package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;
/* loaded from: classes.dex */
public final class ConnectionPool {
    private final RealConnectionPool delegate;

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }

    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i6, long j6, TimeUnit timeUnit) {
        this(new RealConnectionPool(TaskRunner.INSTANCE, i6, j6, timeUnit));
        l.d(timeUnit, "timeUnit");
    }

    public ConnectionPool(RealConnectionPool realConnectionPool) {
        l.d(realConnectionPool, "delegate");
        this.delegate = realConnectionPool;
    }
}
