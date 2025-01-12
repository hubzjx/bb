package q2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.s0;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public final class d0 implements e0 {

    /* renamed from: d  reason: collision with root package name */
    public static final c f12726d = h(false, -9223372036854775807L);

    /* renamed from: e  reason: collision with root package name */
    public static final c f12727e = h(true, -9223372036854775807L);

    /* renamed from: f  reason: collision with root package name */
    public static final c f12728f = new c(2, -9223372036854775807L);

    /* renamed from: g  reason: collision with root package name */
    public static final c f12729g = new c(3, -9223372036854775807L);

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f12730a;

    /* renamed from: b  reason: collision with root package name */
    private d f12731b;

    /* renamed from: c  reason: collision with root package name */
    private IOException f12732c;

    /* loaded from: classes.dex */
    public interface b {
        c k(e eVar, long j6, long j7, IOException iOException, int i6);

        void m(e eVar, long j6, long j7);

        void p(e eVar, long j6, long j7, boolean z5);
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final int f12733a;

        /* renamed from: b  reason: collision with root package name */
        private final long f12734b;

        private c(int i6, long j6) {
            this.f12733a = i6;
            this.f12734b = j6;
        }

        public boolean c() {
            int i6 = this.f12733a;
            return i6 == 0 || i6 == 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class d extends Handler implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final int f12735a;

        /* renamed from: b  reason: collision with root package name */
        private final e f12736b;

        /* renamed from: c  reason: collision with root package name */
        private final long f12737c;

        /* renamed from: d  reason: collision with root package name */
        private b f12738d;

        /* renamed from: e  reason: collision with root package name */
        private IOException f12739e;

        /* renamed from: f  reason: collision with root package name */
        private int f12740f;

        /* renamed from: g  reason: collision with root package name */
        private Thread f12741g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f12742h;

        /* renamed from: k  reason: collision with root package name */
        private volatile boolean f12743k;

        public d(Looper looper, e eVar, b bVar, int i6, long j6) {
            super(looper);
            this.f12736b = eVar;
            this.f12738d = bVar;
            this.f12735a = i6;
            this.f12737c = j6;
        }

        private void b() {
            this.f12739e = null;
            d0.this.f12730a.execute((Runnable) com.google.android.exoplayer2.util.a.e(d0.this.f12731b));
        }

        private void c() {
            d0.this.f12731b = null;
        }

        private long d() {
            return Math.min((this.f12740f - 1) * 1000, 5000);
        }

        public void a(boolean z5) {
            this.f12743k = z5;
            this.f12739e = null;
            if (hasMessages(0)) {
                this.f12742h = true;
                removeMessages(0);
                if (!z5) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.f12742h = true;
                    this.f12736b.c();
                    Thread thread = this.f12741g;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z5) {
                c();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ((b) com.google.android.exoplayer2.util.a.e(this.f12738d)).p(this.f12736b, elapsedRealtime, elapsedRealtime - this.f12737c, true);
                this.f12738d = null;
            }
        }

        public void e(int i6) {
            IOException iOException = this.f12739e;
            if (iOException != null && this.f12740f > i6) {
                throw iOException;
            }
        }

        public void f(long j6) {
            com.google.android.exoplayer2.util.a.g(d0.this.f12731b == null);
            d0.this.f12731b = this;
            if (j6 > 0) {
                sendEmptyMessageDelayed(0, j6);
            } else {
                b();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f12743k) {
                return;
            }
            int i6 = message.what;
            if (i6 == 0) {
                b();
            } else if (i6 == 3) {
                throw ((Error) message.obj);
            } else {
                c();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j6 = elapsedRealtime - this.f12737c;
                b bVar = (b) com.google.android.exoplayer2.util.a.e(this.f12738d);
                if (this.f12742h) {
                    bVar.p(this.f12736b, elapsedRealtime, j6, false);
                    return;
                }
                int i7 = message.what;
                if (i7 == 1) {
                    try {
                        bVar.m(this.f12736b, elapsedRealtime, j6);
                    } catch (RuntimeException e6) {
                        com.google.android.exoplayer2.util.n.d("LoadTask", "Unexpected exception handling load completed", e6);
                        d0.this.f12732c = new h(e6);
                    }
                } else if (i7 != 2) {
                } else {
                    IOException iOException = (IOException) message.obj;
                    this.f12739e = iOException;
                    int i8 = this.f12740f + 1;
                    this.f12740f = i8;
                    c k6 = bVar.k(this.f12736b, elapsedRealtime, j6, iOException, i8);
                    if (k6.f12733a == 3) {
                        d0.this.f12732c = this.f12739e;
                    } else if (k6.f12733a != 2) {
                        if (k6.f12733a == 1) {
                            this.f12740f = 1;
                        }
                        f(k6.f12734b != -9223372036854775807L ? k6.f12734b : d());
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Object hVar;
            Message obtainMessage;
            boolean z5;
            try {
                synchronized (this) {
                    z5 = !this.f12742h;
                    this.f12741g = Thread.currentThread();
                }
                if (z5) {
                    String simpleName = this.f12736b.getClass().getSimpleName();
                    l0.a(simpleName.length() != 0 ? "load:".concat(simpleName) : new String("load:"));
                    try {
                        this.f12736b.a();
                        l0.c();
                    } catch (Throwable th) {
                        l0.c();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.f12741g = null;
                    Thread.interrupted();
                }
                if (this.f12743k) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e6) {
                if (this.f12743k) {
                    return;
                }
                obtainMessage = obtainMessage(2, e6);
                obtainMessage.sendToTarget();
            } catch (Error e7) {
                com.google.android.exoplayer2.util.n.d("LoadTask", "Unexpected error loading stream", e7);
                if (!this.f12743k) {
                    obtainMessage(3, e7).sendToTarget();
                }
                throw e7;
            } catch (Exception e8) {
                com.google.android.exoplayer2.util.n.d("LoadTask", "Unexpected exception loading stream", e8);
                if (this.f12743k) {
                    return;
                }
                hVar = new h(e8);
                obtainMessage = obtainMessage(2, hVar);
                obtainMessage.sendToTarget();
            } catch (OutOfMemoryError e9) {
                com.google.android.exoplayer2.util.n.d("LoadTask", "OutOfMemory error loading stream", e9);
                if (this.f12743k) {
                    return;
                }
                hVar = new h(e9);
                obtainMessage = obtainMessage(2, hVar);
                obtainMessage.sendToTarget();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();

        void c();
    }

    /* loaded from: classes.dex */
    public interface f {
        void j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final f f12745a;

        public g(f fVar) {
            this.f12745a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12745a.j();
        }
    }

    /* loaded from: classes.dex */
    public static final class h extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public h(Throwable th) {
            super(r3.toString(), th);
            String simpleName = th.getClass().getSimpleName();
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(simpleName.length() + 13 + String.valueOf(message).length());
            sb.append("Unexpected ");
            sb.append(simpleName);
            sb.append(": ");
            sb.append(message);
        }
    }

    public d0(String str) {
        this.f12730a = s0.u0(str);
    }

    public static c h(boolean z5, long j6) {
        return new c(z5 ? 1 : 0, j6);
    }

    @Override // q2.e0
    public void b() {
        k(Integer.MIN_VALUE);
    }

    public void f() {
        ((d) com.google.android.exoplayer2.util.a.i(this.f12731b)).a(false);
    }

    public void g() {
        this.f12732c = null;
    }

    public boolean i() {
        return this.f12732c != null;
    }

    public boolean j() {
        return this.f12731b != null;
    }

    public void k(int i6) {
        IOException iOException = this.f12732c;
        if (iOException != null) {
            throw iOException;
        }
        d dVar = this.f12731b;
        if (dVar != null) {
            if (i6 == Integer.MIN_VALUE) {
                i6 = dVar.f12735a;
            }
            dVar.e(i6);
        }
    }

    public void l() {
        m(null);
    }

    public void m(f fVar) {
        d dVar = this.f12731b;
        if (dVar != null) {
            dVar.a(true);
        }
        if (fVar != null) {
            this.f12730a.execute(new g(fVar));
        }
        this.f12730a.shutdown();
    }

    public long n(e eVar, b bVar, int i6) {
        this.f12732c = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new d((Looper) com.google.android.exoplayer2.util.a.i(Looper.myLooper()), eVar, bVar, i6, elapsedRealtime).f(0L);
        return elapsedRealtime;
    }
}
