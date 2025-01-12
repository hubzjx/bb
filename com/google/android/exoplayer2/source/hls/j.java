package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import b2.f;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.m0;
import com.google.common.collect.y;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import n1.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends y1.m {
    private static final AtomicInteger J = new AtomicInteger();
    private final boolean A;
    private k B;
    private q C;
    private int D;
    private boolean E;
    private volatile boolean F;
    private boolean G;
    private y H;
    private boolean I;

    /* renamed from: k  reason: collision with root package name */
    public final int f4293k;

    /* renamed from: l  reason: collision with root package name */
    public final int f4294l;

    /* renamed from: m  reason: collision with root package name */
    public final Uri f4295m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f4296n;

    /* renamed from: o  reason: collision with root package name */
    private final q2.l f4297o;

    /* renamed from: p  reason: collision with root package name */
    private final q2.o f4298p;

    /* renamed from: q  reason: collision with root package name */
    private final k f4299q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f4300r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f4301s;

    /* renamed from: t  reason: collision with root package name */
    private final k0 f4302t;

    /* renamed from: u  reason: collision with root package name */
    private final h f4303u;

    /* renamed from: v  reason: collision with root package name */
    private final List f4304v;

    /* renamed from: w  reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.k f4305w;

    /* renamed from: x  reason: collision with root package name */
    private final s1.h f4306x;

    /* renamed from: y  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f4307y;

    /* renamed from: z  reason: collision with root package name */
    private final boolean f4308z;

    private j(h hVar, q2.l lVar, q2.o oVar, s0 s0Var, boolean z5, q2.l lVar2, q2.o oVar2, boolean z6, Uri uri, List list, int i6, Object obj, long j6, long j7, long j8, int i7, boolean z7, boolean z8, k0 k0Var, com.google.android.exoplayer2.drm.k kVar, k kVar2, s1.h hVar2, com.google.android.exoplayer2.util.y yVar, boolean z9) {
        super(lVar, oVar, s0Var, i6, obj, j6, j7, j8);
        this.f4308z = z5;
        this.f4294l = i7;
        this.f4298p = oVar2;
        this.f4297o = lVar2;
        this.E = oVar2 != null;
        this.A = z6;
        this.f4295m = uri;
        this.f4300r = z8;
        this.f4302t = k0Var;
        this.f4301s = z7;
        this.f4303u = hVar;
        this.f4304v = list;
        this.f4305w = kVar;
        this.f4299q = kVar2;
        this.f4306x = hVar2;
        this.f4307y = yVar;
        this.f4296n = z9;
        this.H = y.of();
        this.f4293k = J.getAndIncrement();
    }

    private static q2.l i(q2.l lVar, byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            com.google.android.exoplayer2.util.a.e(bArr2);
            return new a(lVar, bArr, bArr2);
        }
        return lVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b0, code lost:
        if (r20 >= r50.f14287h) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static j j(h hVar, q2.l lVar, s0 s0Var, long j6, b2.f fVar, int i6, Uri uri, List list, int i7, Object obj, boolean z5, t tVar, j jVar, byte[] bArr, byte[] bArr2) {
        boolean z6;
        q2.l lVar2;
        boolean z7;
        q2.o oVar;
        s1.h hVar2;
        com.google.android.exoplayer2.util.y yVar;
        k kVar;
        boolean z8;
        s1.h hVar3;
        com.google.android.exoplayer2.util.y yVar2;
        boolean z9;
        f.a aVar = (f.a) fVar.f2971o.get(i6);
        q2.o oVar2 = new q2.o(m0.d(fVar.f2985a, aVar.f2973a), aVar.f2982l, aVar.f2983m);
        boolean z10 = bArr != null;
        q2.l i8 = i(lVar, bArr, z10 ? l((String) com.google.android.exoplayer2.util.a.e(aVar.f2981k)) : null);
        f.a aVar2 = aVar.f2974b;
        if (aVar2 != null) {
            boolean z11 = bArr2 != null;
            byte[] l6 = z11 ? l((String) com.google.android.exoplayer2.util.a.e(aVar2.f2981k)) : null;
            z6 = z10;
            q2.o oVar3 = new q2.o(m0.d(fVar.f2985a, aVar2.f2973a), aVar2.f2982l, aVar2.f2983m);
            lVar2 = i(lVar, bArr2, l6);
            z7 = z11;
            oVar = oVar3;
        } else {
            z6 = z10;
            lVar2 = null;
            z7 = false;
            oVar = null;
        }
        long j7 = j6 + aVar.f2978f;
        long j8 = j7 + aVar.f2975c;
        int i9 = fVar.f2964h + aVar.f2977e;
        if (jVar != null) {
            boolean z12 = uri.equals(jVar.f4295m) && jVar.G;
            s1.h hVar4 = jVar.f4306x;
            com.google.android.exoplayer2.util.y yVar3 = jVar.f4307y;
            if (z12) {
                hVar3 = hVar4;
                yVar2 = yVar3;
            } else {
                if (fVar.f2987c) {
                    hVar3 = hVar4;
                    yVar2 = yVar3;
                } else {
                    hVar3 = hVar4;
                    yVar2 = yVar3;
                }
                z9 = false;
                boolean z13 = !z9;
                kVar = (z12 || jVar.I || jVar.f4294l != i9) ? null : jVar.B;
                hVar2 = hVar3;
                z8 = z13;
                yVar = yVar2;
            }
            z9 = true;
            boolean z132 = !z9;
            if (z12) {
            }
            hVar2 = hVar3;
            z8 = z132;
            yVar = yVar2;
        } else {
            hVar2 = new s1.h();
            yVar = new com.google.android.exoplayer2.util.y(10);
            kVar = null;
            z8 = false;
        }
        return new j(hVar, i8, oVar2, s0Var, z6, lVar2, oVar, z7, uri, list, i7, obj, j7, j8, fVar.f2965i + i6, i9, aVar.f2984n, z5, tVar.a(i9), aVar.f2979g, kVar, hVar2, yVar, z8);
    }

    private void k(q2.l lVar, q2.o oVar, boolean z5) {
        q2.o e6;
        if (z5) {
            r0 = this.D != 0;
            e6 = oVar;
        } else {
            e6 = oVar.e(this.D);
        }
        try {
            c1.f s5 = s(lVar, e6);
            if (r0) {
                s5.h(this.D);
            }
            while (!this.F && this.B.b(s5)) {
            }
            this.D = (int) (s5.p() - oVar.f12800g);
        } finally {
            com.google.android.exoplayer2.util.s0.o(lVar);
        }
    }

    private static byte[] l(String str) {
        if (com.google.android.exoplayer2.util.s0.S0(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    private void p() {
        if (!this.f4300r) {
            try {
                this.f4302t.k();
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        } else if (this.f4302t.c() == Long.MAX_VALUE) {
            this.f4302t.h(this.f14286g);
        }
        k(this.f14288i, this.f14281b, this.f4308z);
    }

    private void q() {
        if (this.E) {
            com.google.android.exoplayer2.util.a.e(this.f4297o);
            com.google.android.exoplayer2.util.a.e(this.f4298p);
            k(this.f4297o, this.f4298p, this.A);
            this.D = 0;
            this.E = false;
        }
    }

    private long r(c1.j jVar) {
        jVar.g();
        try {
            jVar.n(this.f4307y.c(), 0, 10);
            this.f4307y.I(10);
        } catch (EOFException unused) {
        }
        if (this.f4307y.D() != 4801587) {
            return -9223372036854775807L;
        }
        this.f4307y.N(3);
        int z5 = this.f4307y.z();
        int i6 = z5 + 10;
        if (i6 > this.f4307y.b()) {
            byte[] c6 = this.f4307y.c();
            this.f4307y.I(i6);
            System.arraycopy(c6, 0, this.f4307y.c(), 0, 10);
        }
        jVar.n(this.f4307y.c(), 10, z5);
        n1.a e6 = this.f4306x.e(this.f4307y.c(), z5);
        if (e6 == null) {
            return -9223372036854775807L;
        }
        int h6 = e6.h();
        for (int i7 = 0; i7 < h6; i7++) {
            a.b g6 = e6.g(i7);
            if (g6 instanceof s1.l) {
                s1.l lVar = (s1.l) g6;
                if ("com.apple.streaming.transportStreamTimestamp".equals(lVar.f13161b)) {
                    System.arraycopy(lVar.f13162c, 0, this.f4307y.c(), 0, 8);
                    this.f4307y.I(8);
                    return this.f4307y.t() & 8589934591L;
                }
            }
        }
        return -9223372036854775807L;
    }

    private c1.f s(q2.l lVar, q2.o oVar) {
        q qVar;
        long j6;
        c1.f fVar = new c1.f(lVar, oVar.f12800g, lVar.b(oVar));
        if (this.B == null) {
            long r5 = r(fVar);
            fVar.g();
            k kVar = this.f4299q;
            k f6 = kVar != null ? kVar.f() : this.f4303u.a(oVar.f12794a, this.f14283d, this.f4304v, this.f4302t, lVar.f(), fVar);
            this.B = f6;
            if (f6.d()) {
                qVar = this.C;
                j6 = r5 != -9223372036854775807L ? this.f4302t.b(r5) : this.f14286g;
            } else {
                qVar = this.C;
                j6 = 0;
            }
            qVar.l0(j6);
            this.C.Y();
            this.B.c(this.C);
        }
        this.C.i0(this.f4305w);
        return fVar;
    }

    @Override // q2.d0.e
    public void a() {
        k kVar;
        com.google.android.exoplayer2.util.a.e(this.C);
        if (this.B == null && (kVar = this.f4299q) != null && kVar.e()) {
            this.B = this.f4299q;
            this.E = false;
        }
        q();
        if (this.F) {
            return;
        }
        if (!this.f4301s) {
            p();
        }
        this.G = !this.F;
    }

    @Override // q2.d0.e
    public void c() {
        this.F = true;
    }

    @Override // y1.m
    public boolean h() {
        return this.G;
    }

    public int m(int i6) {
        com.google.android.exoplayer2.util.a.g(!this.f4296n);
        if (i6 >= this.H.size()) {
            return 0;
        }
        return ((Integer) this.H.get(i6)).intValue();
    }

    public void n(q qVar, y yVar) {
        this.C = qVar;
        this.H = yVar;
    }

    public void o() {
        this.I = true;
    }
}
