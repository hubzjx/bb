package okhttp3.internal.connection;

import h4.q;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.collections.n;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;
/* loaded from: classes.dex */
public final class RealConnectionPool {
    public static final Companion Companion = new Companion(null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            l.d(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(TaskRunner taskRunner, int i6, long j6, TimeUnit timeUnit) {
        l.d(taskRunner, "taskRunner");
        l.d(timeUnit, "timeUnit");
        this.maxIdleConnections = i6;
        this.keepAliveDurationNs = timeUnit.toNanos(j6);
        this.cleanupQueue = taskRunner.newQueue();
        final String i7 = l.i(Util.okHttpName, " ConnectionPool");
        this.cleanupTask = new Task(i7) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return RealConnectionPool.this.cleanup(System.nanoTime());
            }
        };
        this.connections = new ConcurrentLinkedQueue<>();
        if (!(j6 > 0)) {
            throw new IllegalArgumentException(l.i("keepAliveDuration <= 0: ", Long.valueOf(j6)).toString());
        }
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j6) {
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + realConnection);
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        int i6 = 0;
        while (i6 < calls.size()) {
            Reference<RealCall> reference = calls.get(i6);
            if (reference.get() != null) {
                i6++;
            } else {
                Platform.Companion.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                calls.remove(i6);
                realConnection.setNoNewExchanges(true);
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs$okhttp(j6 - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return calls.size();
    }

    public final boolean callAcquirePooledConnection(Address address, RealCall realCall, List<Route> list, boolean z5) {
        l.d(address, "address");
        l.d(realCall, "call");
        Iterator<RealConnection> it = this.connections.iterator();
        while (it.hasNext()) {
            RealConnection next = it.next();
            l.c(next, "connection");
            synchronized (next) {
                if (z5) {
                    if (!next.isMultiplexed$okhttp()) {
                        q qVar = q.f10774a;
                    }
                }
                if (next.isEligible$okhttp(address, list)) {
                    realCall.acquireConnectionNoEvents(next);
                    return true;
                }
                q qVar2 = q.f10774a;
            }
        }
        return false;
    }

    public final long cleanup(long j6) {
        Iterator<RealConnection> it = this.connections.iterator();
        int i6 = 0;
        long j7 = Long.MIN_VALUE;
        RealConnection realConnection = null;
        int i7 = 0;
        while (it.hasNext()) {
            RealConnection next = it.next();
            l.c(next, "connection");
            synchronized (next) {
                if (pruneAndGetAllocationCount(next, j6) > 0) {
                    i7++;
                } else {
                    i6++;
                    long idleAtNs$okhttp = j6 - next.getIdleAtNs$okhttp();
                    if (idleAtNs$okhttp > j7) {
                        realConnection = next;
                        j7 = idleAtNs$okhttp;
                    }
                    q qVar = q.f10774a;
                }
            }
        }
        long j8 = this.keepAliveDurationNs;
        if (j7 < j8 && i6 <= this.maxIdleConnections) {
            if (i6 > 0) {
                return j8 - j7;
            }
            if (i7 > 0) {
                return j8;
            }
            return -1L;
        }
        l.b(realConnection);
        synchronized (realConnection) {
            if (!realConnection.getCalls().isEmpty()) {
                return 0L;
            }
            if (realConnection.getIdleAtNs$okhttp() + j7 != j6) {
                return 0L;
            }
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return 0L;
        }
    }

    public final boolean connectionBecameIdle(RealConnection realConnection) {
        l.d(realConnection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + realConnection);
        } else if (!realConnection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return false;
        } else {
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return true;
        }
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator<RealConnection> it = this.connections.iterator();
        l.c(it, "connections.iterator()");
        while (it.hasNext()) {
            RealConnection next = it.next();
            l.c(next, "connection");
            synchronized (next) {
                if (next.getCalls().isEmpty()) {
                    it.remove();
                    next.setNoNewExchanges(true);
                    socket = next.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                Util.closeQuietly(socket);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final int idleConnectionCount() {
        boolean isEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.connections;
        int i6 = 0;
        if (!(concurrentLinkedQueue instanceof Collection) || !concurrentLinkedQueue.isEmpty()) {
            for (RealConnection realConnection : concurrentLinkedQueue) {
                l.c(realConnection, "it");
                synchronized (realConnection) {
                    isEmpty = realConnection.getCalls().isEmpty();
                }
                if (isEmpty && (i6 = i6 + 1) < 0) {
                    n.n();
                }
            }
        }
        return i6;
    }

    public final void put(RealConnection realConnection) {
        l.d(realConnection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            this.connections.add(realConnection);
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + realConnection);
    }
}
