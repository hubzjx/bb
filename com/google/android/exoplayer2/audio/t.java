package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
final class t {
    private long A;
    private long B;
    private long C;
    private boolean D;
    private long E;
    private long F;

    /* renamed from: a  reason: collision with root package name */
    private final a f3512a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f3513b;

    /* renamed from: c  reason: collision with root package name */
    private AudioTrack f3514c;

    /* renamed from: d  reason: collision with root package name */
    private int f3515d;

    /* renamed from: e  reason: collision with root package name */
    private int f3516e;

    /* renamed from: f  reason: collision with root package name */
    private s f3517f;

    /* renamed from: g  reason: collision with root package name */
    private int f3518g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3519h;

    /* renamed from: i  reason: collision with root package name */
    private long f3520i;

    /* renamed from: j  reason: collision with root package name */
    private float f3521j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3522k;

    /* renamed from: l  reason: collision with root package name */
    private long f3523l;

    /* renamed from: m  reason: collision with root package name */
    private long f3524m;

    /* renamed from: n  reason: collision with root package name */
    private Method f3525n;

    /* renamed from: o  reason: collision with root package name */
    private long f3526o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f3527p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f3528q;

    /* renamed from: r  reason: collision with root package name */
    private long f3529r;

    /* renamed from: s  reason: collision with root package name */
    private long f3530s;

    /* renamed from: t  reason: collision with root package name */
    private long f3531t;

    /* renamed from: u  reason: collision with root package name */
    private long f3532u;

    /* renamed from: v  reason: collision with root package name */
    private int f3533v;

    /* renamed from: w  reason: collision with root package name */
    private int f3534w;

    /* renamed from: x  reason: collision with root package name */
    private long f3535x;

    /* renamed from: y  reason: collision with root package name */
    private long f3536y;

    /* renamed from: z  reason: collision with root package name */
    private long f3537z;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i6, long j6);

        void b(long j6, long j7, long j8, long j9);

        void c(long j6);

        void d(long j6, long j7, long j8, long j9);

        void e(long j6);
    }

    public t(a aVar) {
        this.f3512a = (a) com.google.android.exoplayer2.util.a.e(aVar);
        if (com.google.android.exoplayer2.util.s0.f4673a >= 18) {
            try {
                this.f3525n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f3513b = new long[10];
    }

    private boolean a() {
        return this.f3519h && ((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f3514c)).getPlayState() == 2 && f() == 0;
    }

    private long b(long j6) {
        return (j6 * 1000000) / this.f3518g;
    }

    private long f() {
        AudioTrack audioTrack = (AudioTrack) com.google.android.exoplayer2.util.a.e(this.f3514c);
        if (this.f3535x != -9223372036854775807L) {
            return Math.min(this.A, this.f3537z + ((((SystemClock.elapsedRealtime() * 1000) - this.f3535x) * this.f3518g) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = audioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (this.f3519h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f3532u = this.f3530s;
            }
            playbackHeadPosition += this.f3532u;
        }
        if (com.google.android.exoplayer2.util.s0.f4673a <= 29) {
            if (playbackHeadPosition == 0 && this.f3530s > 0 && playState == 3) {
                if (this.f3536y == -9223372036854775807L) {
                    this.f3536y = SystemClock.elapsedRealtime();
                }
                return this.f3530s;
            }
            this.f3536y = -9223372036854775807L;
        }
        if (this.f3530s > playbackHeadPosition) {
            this.f3531t++;
        }
        this.f3530s = playbackHeadPosition;
        return playbackHeadPosition + (this.f3531t << 32);
    }

    private long g() {
        return b(f());
    }

    private void m(long j6, long j7) {
        s sVar = (s) com.google.android.exoplayer2.util.a.e(this.f3517f);
        if (sVar.e(j6)) {
            long c6 = sVar.c();
            long b6 = sVar.b();
            if (Math.abs(c6 - j6) > 5000000) {
                this.f3512a.d(b6, c6, j6, j7);
            } else if (Math.abs(b(b6) - j7) <= 5000000) {
                sVar.a();
                return;
            } else {
                this.f3512a.b(b6, c6, j6, j7);
            }
            sVar.f();
        }
    }

    private void n() {
        long g6 = g();
        if (g6 == 0) {
            return;
        }
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.f3524m >= 30000) {
            long[] jArr = this.f3513b;
            int i6 = this.f3533v;
            jArr[i6] = g6 - nanoTime;
            this.f3533v = (i6 + 1) % 10;
            int i7 = this.f3534w;
            if (i7 < 10) {
                this.f3534w = i7 + 1;
            }
            this.f3524m = nanoTime;
            this.f3523l = 0L;
            int i8 = 0;
            while (true) {
                int i9 = this.f3534w;
                if (i8 >= i9) {
                    break;
                }
                this.f3523l += this.f3513b[i8] / i9;
                i8++;
            }
        }
        if (this.f3519h) {
            return;
        }
        m(nanoTime, g6);
        o(nanoTime);
    }

    private void o(long j6) {
        Method method;
        if (!this.f3528q || (method = this.f3525n) == null || j6 - this.f3529r < 500000) {
            return;
        }
        try {
            long intValue = (((Integer) com.google.android.exoplayer2.util.s0.j((Integer) method.invoke(com.google.android.exoplayer2.util.a.e(this.f3514c), new Object[0]))).intValue() * 1000) - this.f3520i;
            this.f3526o = intValue;
            long max = Math.max(intValue, 0L);
            this.f3526o = max;
            if (max > 5000000) {
                this.f3512a.e(max);
                this.f3526o = 0L;
            }
        } catch (Exception unused) {
            this.f3525n = null;
        }
        this.f3529r = j6;
    }

    private static boolean p(int i6) {
        return com.google.android.exoplayer2.util.s0.f4673a < 23 && (i6 == 5 || i6 == 6);
    }

    private void s() {
        this.f3523l = 0L;
        this.f3534w = 0;
        this.f3533v = 0;
        this.f3524m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.f3522k = false;
    }

    public int c(long j6) {
        return this.f3516e - ((int) (j6 - (f() * this.f3515d)));
    }

    public long d(boolean z5) {
        long g6;
        if (((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f3514c)).getPlayState() == 3) {
            n();
        }
        long nanoTime = System.nanoTime() / 1000;
        s sVar = (s) com.google.android.exoplayer2.util.a.e(this.f3517f);
        boolean d6 = sVar.d();
        if (d6) {
            g6 = b(sVar.b()) + com.google.android.exoplayer2.util.s0.U(nanoTime - sVar.c(), this.f3521j);
        } else {
            g6 = this.f3534w == 0 ? g() : this.f3523l + nanoTime;
            if (!z5) {
                g6 = Math.max(0L, g6 - this.f3526o);
            }
        }
        if (this.D != d6) {
            this.F = this.C;
            this.E = this.B;
        }
        long j6 = nanoTime - this.F;
        if (j6 < 1000000) {
            long j7 = (j6 * 1000) / 1000000;
            g6 = ((g6 * j7) + ((1000 - j7) * (this.E + com.google.android.exoplayer2.util.s0.U(j6, this.f3521j)))) / 1000;
        }
        if (!this.f3522k) {
            long j8 = this.B;
            if (g6 > j8) {
                this.f3522k = true;
                this.f3512a.c(System.currentTimeMillis() - com.google.android.exoplayer2.p.b(com.google.android.exoplayer2.util.s0.b0(com.google.android.exoplayer2.p.b(g6 - j8), this.f3521j)));
            }
        }
        this.C = nanoTime;
        this.B = g6;
        this.D = d6;
        return g6;
    }

    public long e(long j6) {
        return com.google.android.exoplayer2.p.b(b(j6 - f()));
    }

    public void h(long j6) {
        this.f3537z = f();
        this.f3535x = SystemClock.elapsedRealtime() * 1000;
        this.A = j6;
    }

    public boolean i(long j6) {
        return j6 > f() || a();
    }

    public boolean j() {
        return ((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f3514c)).getPlayState() == 3;
    }

    public boolean k(long j6) {
        return this.f3536y != -9223372036854775807L && j6 > 0 && SystemClock.elapsedRealtime() - this.f3536y >= 200;
    }

    public boolean l(long j6) {
        int playState = ((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f3514c)).getPlayState();
        if (this.f3519h) {
            if (playState == 2) {
                this.f3527p = false;
                return false;
            } else if (playState == 1 && f() == 0) {
                return false;
            }
        }
        boolean z5 = this.f3527p;
        boolean i6 = i(j6);
        this.f3527p = i6;
        if (z5 && !i6 && playState != 1) {
            this.f3512a.a(this.f3516e, com.google.android.exoplayer2.p.b(this.f3520i));
        }
        return true;
    }

    public boolean q() {
        s();
        if (this.f3535x == -9223372036854775807L) {
            ((s) com.google.android.exoplayer2.util.a.e(this.f3517f)).g();
            return true;
        }
        return false;
    }

    public void r() {
        s();
        this.f3514c = null;
        this.f3517f = null;
    }

    public void t(AudioTrack audioTrack, boolean z5, int i6, int i7, int i8) {
        this.f3514c = audioTrack;
        this.f3515d = i7;
        this.f3516e = i8;
        this.f3517f = new s(audioTrack);
        this.f3518g = audioTrack.getSampleRate();
        this.f3519h = z5 && p(i6);
        boolean n02 = com.google.android.exoplayer2.util.s0.n0(i6);
        this.f3528q = n02;
        this.f3520i = n02 ? b(i8 / i7) : -9223372036854775807L;
        this.f3530s = 0L;
        this.f3531t = 0L;
        this.f3532u = 0L;
        this.f3527p = false;
        this.f3535x = -9223372036854775807L;
        this.f3536y = -9223372036854775807L;
        this.f3529r = 0L;
        this.f3526o = 0L;
        this.f3521j = 1.0f;
    }

    public void u(float f6) {
        this.f3521j = f6;
        s sVar = this.f3517f;
        if (sVar != null) {
            sVar.g();
        }
    }

    public void v() {
        ((s) com.google.android.exoplayer2.util.a.e(this.f3517f)).g();
    }
}
