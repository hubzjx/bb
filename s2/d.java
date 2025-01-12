package s2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
/* loaded from: classes.dex */
public final class d extends Surface {

    /* renamed from: d  reason: collision with root package name */
    private static int f13180d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f13181e;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f13182a;

    /* renamed from: b  reason: collision with root package name */
    private final b f13183b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13184c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends HandlerThread implements Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        private com.google.android.exoplayer2.util.i f13185a;

        /* renamed from: b  reason: collision with root package name */
        private Handler f13186b;

        /* renamed from: c  reason: collision with root package name */
        private Error f13187c;

        /* renamed from: d  reason: collision with root package name */
        private RuntimeException f13188d;

        /* renamed from: e  reason: collision with root package name */
        private d f13189e;

        public b() {
            super("ExoPlayer:DummySurface");
        }

        private void b(int i6) {
            com.google.android.exoplayer2.util.a.e(this.f13185a);
            this.f13185a.h(i6);
            this.f13189e = new d(this, this.f13185a.g(), i6 != 0);
        }

        private void d() {
            com.google.android.exoplayer2.util.a.e(this.f13185a);
            this.f13185a.i();
        }

        public d a(int i6) {
            boolean z5;
            start();
            this.f13186b = new Handler(getLooper(), this);
            this.f13185a = new com.google.android.exoplayer2.util.i(this.f13186b);
            synchronized (this) {
                z5 = false;
                this.f13186b.obtainMessage(1, i6, 0).sendToTarget();
                while (this.f13189e == null && this.f13188d == null && this.f13187c == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z5 = true;
                    }
                }
            }
            if (z5) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f13188d;
            if (runtimeException == null) {
                Error error = this.f13187c;
                if (error == null) {
                    return (d) com.google.android.exoplayer2.util.a.e(this.f13189e);
                }
                throw error;
            }
            throw runtimeException;
        }

        public void c() {
            com.google.android.exoplayer2.util.a.e(this.f13186b);
            this.f13186b.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i6 = message.what;
            try {
                if (i6 != 1) {
                    if (i6 != 2) {
                        return true;
                    }
                    try {
                        d();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e6) {
                    com.google.android.exoplayer2.util.n.d("DummySurface", "Failed to initialize dummy surface", e6);
                    this.f13187c = e6;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e7) {
                    com.google.android.exoplayer2.util.n.d("DummySurface", "Failed to initialize dummy surface", e7);
                    this.f13188d = e7;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }
    }

    private d(b bVar, SurfaceTexture surfaceTexture, boolean z5) {
        super(surfaceTexture);
        this.f13183b = bVar;
        this.f13182a = z5;
    }

    private static int e(Context context) {
        if (com.google.android.exoplayer2.util.k.b(context)) {
            return com.google.android.exoplayer2.util.k.c() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean f(Context context) {
        boolean z5;
        synchronized (d.class) {
            if (!f13181e) {
                f13180d = e(context);
                f13181e = true;
            }
            z5 = f13180d != 0;
        }
        return z5;
    }

    public static d g(Context context, boolean z5) {
        com.google.android.exoplayer2.util.a.g(!z5 || f(context));
        return new b().a(z5 ? f13180d : 0);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f13183b) {
            if (!this.f13184c) {
                this.f13183b.c();
                this.f13184c = true;
            }
        }
    }
}
