package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.s1;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import d2.a;
import i1.g;
import i1.o;
import i1.p;
import java.io.IOException;
import java.util.List;
import o2.j;
import q2.e0;
import q2.i0;
import q2.l;
import y1.d;
import y1.e;
import y1.f;
import y1.m;
import y1.n;
/* loaded from: classes.dex */
public class a implements com.google.android.exoplayer2.source.smoothstreaming.b {

    /* renamed from: a  reason: collision with root package name */
    private final e0 f4415a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4416b;

    /* renamed from: c  reason: collision with root package name */
    private final f[] f4417c;

    /* renamed from: d  reason: collision with root package name */
    private final l f4418d;

    /* renamed from: e  reason: collision with root package name */
    private j f4419e;

    /* renamed from: f  reason: collision with root package name */
    private d2.a f4420f;

    /* renamed from: g  reason: collision with root package name */
    private int f4421g;

    /* renamed from: h  reason: collision with root package name */
    private IOException f4422h;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0042a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final l.a f4423a;

        public C0042a(l.a aVar) {
            this.f4423a = aVar;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.b.a
        public com.google.android.exoplayer2.source.smoothstreaming.b a(e0 e0Var, d2.a aVar, int i6, j jVar, i0 i0Var) {
            l a6 = this.f4423a.a();
            if (i0Var != null) {
                a6.i(i0Var);
            }
            return new a(e0Var, aVar, i6, jVar, a6);
        }
    }

    /* loaded from: classes.dex */
    private static final class b extends y1.b {

        /* renamed from: e  reason: collision with root package name */
        private final a.b f4424e;

        /* renamed from: f  reason: collision with root package name */
        private final int f4425f;

        public b(a.b bVar, int i6, int i7) {
            super(i7, bVar.f9158k - 1);
            this.f4424e = bVar;
            this.f4425f = i6;
        }
    }

    public a(e0 e0Var, d2.a aVar, int i6, j jVar, l lVar) {
        this.f4415a = e0Var;
        this.f4420f = aVar;
        this.f4416b = i6;
        this.f4419e = jVar;
        this.f4418d = lVar;
        a.b bVar = aVar.f9142f[i6];
        this.f4417c = new f[jVar.length()];
        int i7 = 0;
        while (i7 < this.f4417c.length) {
            int f6 = jVar.f(i7);
            s0 s0Var = bVar.f9157j[f6];
            p[] pVarArr = s0Var.f4059q != null ? ((a.C0154a) com.google.android.exoplayer2.util.a.e(aVar.f9141e)).f9147c : null;
            int i8 = bVar.f9148a;
            int i9 = i7;
            this.f4417c[i9] = new d(new g(3, null, new o(f6, i8, bVar.f9150c, -9223372036854775807L, aVar.f9143g, s0Var, 0, pVarArr, i8 == 2 ? 4 : 0, null, null)), bVar.f9148a, s0Var);
            i7 = i9 + 1;
        }
    }

    private static m l(s0 s0Var, l lVar, Uri uri, int i6, long j6, long j7, long j8, int i7, Object obj, f fVar) {
        return new y1.j(lVar, new q2.o(uri), s0Var, i7, obj, j6, j7, j8, -9223372036854775807L, i6, 1, j6, fVar);
    }

    private long m(long j6) {
        d2.a aVar = this.f4420f;
        if (aVar.f9140d) {
            a.b bVar = aVar.f9142f[this.f4416b];
            int i6 = bVar.f9158k - 1;
            return (bVar.e(i6) + bVar.c(i6)) - j6;
        }
        return -9223372036854775807L;
    }

    @Override // y1.i
    public void a() {
        for (f fVar : this.f4417c) {
            fVar.a();
        }
    }

    @Override // y1.i
    public void b() {
        IOException iOException = this.f4422h;
        if (iOException != null) {
            throw iOException;
        }
        this.f4415a.b();
    }

    @Override // y1.i
    public long c(long j6, s1 s1Var) {
        a.b bVar = this.f4420f.f9142f[this.f4416b];
        int d6 = bVar.d(j6);
        long e6 = bVar.e(d6);
        return s1Var.a(j6, e6, (e6 >= j6 || d6 >= bVar.f9158k + (-1)) ? e6 : bVar.e(d6 + 1));
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void d(j jVar) {
        this.f4419e = jVar;
    }

    @Override // y1.i
    public int e(long j6, List list) {
        return (this.f4422h != null || this.f4419e.length() < 2) ? list.size() : this.f4419e.g(j6, list);
    }

    @Override // y1.i
    public final void f(long j6, long j7, List list, y1.g gVar) {
        int g6;
        long j8 = j7;
        if (this.f4422h != null) {
            return;
        }
        d2.a aVar = this.f4420f;
        a.b bVar = aVar.f9142f[this.f4416b];
        if (bVar.f9158k == 0) {
            gVar.f14290b = !aVar.f9140d;
            return;
        }
        if (list.isEmpty()) {
            g6 = bVar.d(j8);
        } else {
            g6 = (int) (((m) list.get(list.size() - 1)).g() - this.f4421g);
            if (g6 < 0) {
                this.f4422h = new w1.b();
                return;
            }
        }
        if (g6 >= bVar.f9158k) {
            gVar.f14290b = !this.f4420f.f9140d;
            return;
        }
        long j9 = j8 - j6;
        long m5 = m(j6);
        int length = this.f4419e.length();
        n[] nVarArr = new n[length];
        for (int i6 = 0; i6 < length; i6++) {
            nVarArr[i6] = new b(bVar, this.f4419e.f(i6), g6);
        }
        this.f4419e.b(j6, j9, m5, list, nVarArr);
        long e6 = bVar.e(g6);
        long c6 = e6 + bVar.c(g6);
        if (!list.isEmpty()) {
            j8 = -9223372036854775807L;
        }
        long j10 = j8;
        int i7 = g6 + this.f4421g;
        int n5 = this.f4419e.n();
        f fVar = this.f4417c[n5];
        gVar.f14289a = l(this.f4419e.l(), this.f4418d, bVar.a(this.f4419e.f(n5), g6), i7, e6, c6, j10, this.f4419e.m(), this.f4419e.p(), fVar);
    }

    @Override // y1.i
    public boolean h(e eVar, boolean z5, Exception exc, long j6) {
        if (z5 && j6 != -9223372036854775807L) {
            j jVar = this.f4419e;
            if (jVar.a(jVar.h(eVar.f14283d), j6)) {
                return true;
            }
        }
        return false;
    }

    @Override // y1.i
    public void i(e eVar) {
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void j(d2.a aVar) {
        a.b[] bVarArr = this.f4420f.f9142f;
        int i6 = this.f4416b;
        a.b bVar = bVarArr[i6];
        int i7 = bVar.f9158k;
        a.b bVar2 = aVar.f9142f[i6];
        if (i7 != 0 && bVar2.f9158k != 0) {
            int i8 = i7 - 1;
            long e6 = bVar.e(i8) + bVar.c(i8);
            long e7 = bVar2.e(0);
            if (e6 > e7) {
                this.f4421g += bVar.d(e7);
                this.f4420f = aVar;
            }
        }
        this.f4421g += i7;
        this.f4420f = aVar;
    }

    @Override // y1.i
    public boolean k(long j6, e eVar, List list) {
        if (this.f4422h != null) {
            return false;
        }
        return this.f4419e.i(j6, eVar, list);
    }
}
