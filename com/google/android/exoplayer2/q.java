package com.google.android.exoplayer2;

import okhttp3.dnsoverhttps.DnsOverHttps;
/* loaded from: classes.dex */
public class q implements v0 {

    /* renamed from: a  reason: collision with root package name */
    private final q2.p f3955a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3956b;

    /* renamed from: c  reason: collision with root package name */
    private final long f3957c;

    /* renamed from: d  reason: collision with root package name */
    private final long f3958d;

    /* renamed from: e  reason: collision with root package name */
    private final long f3959e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3960f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f3961g;

    /* renamed from: h  reason: collision with root package name */
    private final long f3962h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f3963i;

    /* renamed from: j  reason: collision with root package name */
    private int f3964j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3965k;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private q2.p f3966a;

        /* renamed from: b  reason: collision with root package name */
        private int f3967b = 50000;

        /* renamed from: c  reason: collision with root package name */
        private int f3968c = 50000;

        /* renamed from: d  reason: collision with root package name */
        private int f3969d = 2500;

        /* renamed from: e  reason: collision with root package name */
        private int f3970e = 5000;

        /* renamed from: f  reason: collision with root package name */
        private int f3971f = -1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f3972g = false;

        /* renamed from: h  reason: collision with root package name */
        private int f3973h = 0;

        /* renamed from: i  reason: collision with root package name */
        private boolean f3974i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f3975j;

        public q a() {
            com.google.android.exoplayer2.util.a.g(!this.f3975j);
            this.f3975j = true;
            if (this.f3966a == null) {
                this.f3966a = new q2.p(true, DnsOverHttps.MAX_RESPONSE_SIZE);
            }
            return new q(this.f3966a, this.f3967b, this.f3968c, this.f3969d, this.f3970e, this.f3971f, this.f3972g, this.f3973h, this.f3974i);
        }

        public a b(q2.p pVar) {
            com.google.android.exoplayer2.util.a.g(!this.f3975j);
            this.f3966a = pVar;
            return this;
        }

        public a c(int i6, int i7, int i8, int i9) {
            com.google.android.exoplayer2.util.a.g(!this.f3975j);
            q.k(i8, 0, "bufferForPlaybackMs", "0");
            q.k(i9, 0, "bufferForPlaybackAfterRebufferMs", "0");
            q.k(i6, i8, "minBufferMs", "bufferForPlaybackMs");
            q.k(i6, i9, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            q.k(i7, i6, "maxBufferMs", "minBufferMs");
            this.f3967b = i6;
            this.f3968c = i7;
            this.f3969d = i8;
            this.f3970e = i9;
            return this;
        }

        public a d(boolean z5) {
            com.google.android.exoplayer2.util.a.g(!this.f3975j);
            this.f3972g = z5;
            return this;
        }
    }

    public q() {
        this(new q2.p(true, DnsOverHttps.MAX_RESPONSE_SIZE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(int i6, int i7, String str, String str2) {
        boolean z5 = i6 >= i7;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" cannot be less than ");
        sb.append(str2);
        com.google.android.exoplayer2.util.a.b(z5, sb.toString());
    }

    private static int m(int i6) {
        switch (i6) {
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
                return 131072;
            case 6:
                return 0;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void n(boolean z5) {
        int i6 = this.f3960f;
        if (i6 == -1) {
            i6 = 13107200;
        }
        this.f3964j = i6;
        this.f3965k = false;
        if (z5) {
            this.f3955a.g();
        }
    }

    @Override // com.google.android.exoplayer2.v0
    public void b() {
        n(false);
    }

    @Override // com.google.android.exoplayer2.v0
    public boolean c(long j6, float f6, boolean z5) {
        long b02 = com.google.android.exoplayer2.util.s0.b0(j6, f6);
        long j7 = z5 ? this.f3959e : this.f3958d;
        return j7 <= 0 || b02 >= j7 || (!this.f3961g && this.f3955a.f() >= this.f3964j);
    }

    @Override // com.google.android.exoplayer2.v0
    public boolean d() {
        return this.f3963i;
    }

    @Override // com.google.android.exoplayer2.v0
    public void e() {
        n(true);
    }

    @Override // com.google.android.exoplayer2.v0
    public boolean f(long j6, long j7, float f6) {
        boolean z5 = true;
        boolean z6 = this.f3955a.f() >= this.f3964j;
        long j8 = this.f3956b;
        if (f6 > 1.0f) {
            j8 = Math.min(com.google.android.exoplayer2.util.s0.U(j8, f6), this.f3957c);
        }
        if (j7 < Math.max(j8, 500000L)) {
            if (!this.f3961g && z6) {
                z5 = false;
            }
            this.f3965k = z5;
            if (!z5 && j7 < 500000) {
                com.google.android.exoplayer2.util.n.h("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j7 >= this.f3957c || z6) {
            this.f3965k = false;
        }
        return this.f3965k;
    }

    @Override // com.google.android.exoplayer2.v0
    public q2.b g() {
        return this.f3955a;
    }

    @Override // com.google.android.exoplayer2.v0
    public void h() {
        n(true);
    }

    @Override // com.google.android.exoplayer2.v0
    public void i(n1[] n1VarArr, w1.y0 y0Var, o2.k kVar) {
        int i6 = this.f3960f;
        if (i6 == -1) {
            i6 = l(n1VarArr, kVar);
        }
        this.f3964j = i6;
        this.f3955a.h(i6);
    }

    @Override // com.google.android.exoplayer2.v0
    public long j() {
        return this.f3962h;
    }

    protected int l(n1[] n1VarArr, o2.k kVar) {
        int i6 = 0;
        for (int i7 = 0; i7 < n1VarArr.length; i7++) {
            if (kVar.a(i7) != null) {
                i6 += m(n1VarArr[i7].i());
            }
        }
        return Math.max(13107200, i6);
    }

    public q(q2.p pVar) {
        this(pVar, 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    protected q(q2.p pVar, int i6, int i7, int i8, int i9, int i10, boolean z5, int i11, boolean z6) {
        k(i8, 0, "bufferForPlaybackMs", "0");
        k(i9, 0, "bufferForPlaybackAfterRebufferMs", "0");
        k(i6, i8, "minBufferMs", "bufferForPlaybackMs");
        k(i6, i9, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        k(i7, i6, "maxBufferMs", "minBufferMs");
        k(i11, 0, "backBufferDurationMs", "0");
        this.f3955a = pVar;
        this.f3956b = p.a(i6);
        this.f3957c = p.a(i7);
        this.f3958d = p.a(i8);
        this.f3959e = p.a(i9);
        this.f3960f = i10;
        this.f3964j = i10 == -1 ? 13107200 : i10;
        this.f3961g = z5;
        this.f3962h = p.a(i11);
        this.f3963i = z6;
    }
}
