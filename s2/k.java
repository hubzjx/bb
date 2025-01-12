package s2;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final WindowManager f13220a;

    /* renamed from: b  reason: collision with root package name */
    private final b f13221b;

    /* renamed from: c  reason: collision with root package name */
    private final a f13222c;

    /* renamed from: d  reason: collision with root package name */
    private long f13223d;

    /* renamed from: e  reason: collision with root package name */
    private long f13224e;

    /* renamed from: f  reason: collision with root package name */
    private long f13225f;

    /* renamed from: g  reason: collision with root package name */
    private long f13226g;

    /* renamed from: h  reason: collision with root package name */
    private long f13227h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13228i;

    /* renamed from: j  reason: collision with root package name */
    private long f13229j;

    /* renamed from: k  reason: collision with root package name */
    private long f13230k;

    /* renamed from: l  reason: collision with root package name */
    private long f13231l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements DisplayManager.DisplayListener {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayManager f13232a;

        public a(DisplayManager displayManager) {
            this.f13232a = displayManager;
        }

        public void a() {
            this.f13232a.registerDisplayListener(this, null);
        }

        public void b() {
            this.f13232a.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i6) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i6) {
            if (i6 == 0) {
                k.this.h();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i6) {
        }
    }

    /* loaded from: classes.dex */
    private static final class b implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: f  reason: collision with root package name */
        private static final b f13234f = new b();

        /* renamed from: a  reason: collision with root package name */
        public volatile long f13235a = -9223372036854775807L;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f13236b;

        /* renamed from: c  reason: collision with root package name */
        private final HandlerThread f13237c;

        /* renamed from: d  reason: collision with root package name */
        private Choreographer f13238d;

        /* renamed from: e  reason: collision with root package name */
        private int f13239e;

        private b() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f13237c = handlerThread;
            handlerThread.start();
            Handler w5 = s0.w(handlerThread.getLooper(), this);
            this.f13236b = w5;
            w5.sendEmptyMessage(0);
        }

        private void b() {
            int i6 = this.f13239e + 1;
            this.f13239e = i6;
            if (i6 == 1) {
                this.f13238d.postFrameCallback(this);
            }
        }

        private void c() {
            this.f13238d = Choreographer.getInstance();
        }

        public static b d() {
            return f13234f;
        }

        private void f() {
            int i6 = this.f13239e - 1;
            this.f13239e = i6;
            if (i6 == 0) {
                this.f13238d.removeFrameCallback(this);
                this.f13235a = -9223372036854775807L;
            }
        }

        public void a() {
            this.f13236b.sendEmptyMessage(1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j6) {
            this.f13235a = j6;
            this.f13238d.postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f13236b.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i6 = message.what;
            if (i6 == 0) {
                c();
                return true;
            } else if (i6 == 1) {
                b();
                return true;
            } else if (i6 != 2) {
                return false;
            } else {
                f();
                return true;
            }
        }
    }

    public k(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
            this.f13220a = (WindowManager) context.getSystemService("window");
        } else {
            this.f13220a = null;
        }
        if (this.f13220a != null) {
            this.f13222c = s0.f4673a >= 17 ? g(context) : null;
            this.f13221b = b.d();
        } else {
            this.f13222c = null;
            this.f13221b = null;
        }
        this.f13223d = -9223372036854775807L;
        this.f13224e = -9223372036854775807L;
    }

    private static long c(long j6, long j7, long j8) {
        long j9;
        long j10 = j7 + (((j6 - j7) / j8) * j8);
        if (j6 <= j10) {
            j9 = j10 - j8;
        } else {
            j10 = j8 + j10;
            j9 = j10;
        }
        return j10 - j6 < j6 - j9 ? j10 : j9;
    }

    private boolean f(long j6, long j7) {
        return Math.abs((j7 - this.f13229j) - (j6 - this.f13230k)) > 20000000;
    }

    private a g(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new a(displayManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Display defaultDisplay = this.f13220a.getDefaultDisplay();
        if (defaultDisplay != null) {
            long refreshRate = (long) (1.0E9d / defaultDisplay.getRefreshRate());
            this.f13223d = refreshRate;
            this.f13224e = (refreshRate * 80) / 100;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (f(r0, r13) != false) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long b(long j6, long j7) {
        long j8;
        long j9;
        b bVar;
        long j10 = 1000 * j6;
        if (this.f13228i) {
            if (j6 != this.f13225f) {
                this.f13231l++;
                this.f13226g = this.f13227h;
            }
            long j11 = this.f13231l;
            if (j11 >= 6) {
                j9 = this.f13226g + ((j10 - this.f13230k) / j11);
                if (!f(j9, j7)) {
                    j8 = (this.f13229j + j9) - this.f13230k;
                    if (!this.f13228i) {
                        this.f13230k = j10;
                        this.f13229j = j7;
                        this.f13231l = 0L;
                        this.f13228i = true;
                    }
                    this.f13225f = j6;
                    this.f13227h = j9;
                    bVar = this.f13221b;
                    if (bVar != null || this.f13223d == -9223372036854775807L) {
                        return j8;
                    }
                    long j12 = bVar.f13235a;
                    return j12 == -9223372036854775807L ? j8 : c(j8, j12, this.f13223d) - this.f13224e;
                }
            }
            this.f13228i = false;
        }
        j8 = j7;
        j9 = j10;
        if (!this.f13228i) {
        }
        this.f13225f = j6;
        this.f13227h = j9;
        bVar = this.f13221b;
        if (bVar != null) {
        }
        return j8;
    }

    public void d() {
        if (this.f13220a != null) {
            a aVar = this.f13222c;
            if (aVar != null) {
                aVar.b();
            }
            this.f13221b.e();
        }
    }

    public void e() {
        this.f13228i = false;
        if (this.f13220a != null) {
            this.f13221b.a();
            a aVar = this.f13222c;
            if (aVar != null) {
                aVar.a();
            }
            h();
        }
    }
}
