package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import b2.f;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.m0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.internal.http2.Http2;
import q2.i0;
import q2.o;
import w1.x0;
/* loaded from: classes.dex */
class f {

    /* renamed from: a  reason: collision with root package name */
    private final h f4265a;

    /* renamed from: b  reason: collision with root package name */
    private final q2.l f4266b;

    /* renamed from: c  reason: collision with root package name */
    private final q2.l f4267c;

    /* renamed from: d  reason: collision with root package name */
    private final t f4268d;

    /* renamed from: e  reason: collision with root package name */
    private final Uri[] f4269e;

    /* renamed from: f  reason: collision with root package name */
    private final s0[] f4270f;

    /* renamed from: g  reason: collision with root package name */
    private final b2.j f4271g;

    /* renamed from: h  reason: collision with root package name */
    private final x0 f4272h;

    /* renamed from: i  reason: collision with root package name */
    private final List f4273i;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4275k;

    /* renamed from: m  reason: collision with root package name */
    private IOException f4277m;

    /* renamed from: n  reason: collision with root package name */
    private Uri f4278n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f4279o;

    /* renamed from: p  reason: collision with root package name */
    private o2.j f4280p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f4282r;

    /* renamed from: j  reason: collision with root package name */
    private final e f4274j = new e(4);

    /* renamed from: l  reason: collision with root package name */
    private byte[] f4276l = com.google.android.exoplayer2.util.s0.f4678f;

    /* renamed from: q  reason: collision with root package name */
    private long f4281q = -9223372036854775807L;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends y1.k {

        /* renamed from: l  reason: collision with root package name */
        private byte[] f4283l;

        public a(q2.l lVar, q2.o oVar, s0 s0Var, int i6, Object obj, byte[] bArr) {
            super(lVar, oVar, 3, s0Var, i6, obj, bArr);
        }

        @Override // y1.k
        protected void g(byte[] bArr, int i6) {
            this.f4283l = Arrays.copyOf(bArr, i6);
        }

        public byte[] j() {
            return this.f4283l;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public y1.e f4284a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4285b;

        /* renamed from: c  reason: collision with root package name */
        public Uri f4286c;

        public b() {
            a();
        }

        public void a() {
            this.f4284a = null;
            this.f4285b = false;
            this.f4286c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends y1.b {

        /* renamed from: e  reason: collision with root package name */
        private final b2.f f4287e;

        /* renamed from: f  reason: collision with root package name */
        private final long f4288f;

        public c(b2.f fVar, long j6, int i6) {
            super(i6, fVar.f2971o.size() - 1);
            this.f4287e = fVar;
            this.f4288f = j6;
        }
    }

    /* loaded from: classes.dex */
    private static final class d extends o2.c {

        /* renamed from: g  reason: collision with root package name */
        private int f4289g;

        public d(x0 x0Var, int[] iArr) {
            super(x0Var, iArr);
            this.f4289g = h(x0Var.e(iArr[0]));
        }

        @Override // o2.j
        public void b(long j6, long j7, long j8, List list, y1.n[] nVarArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (t(this.f4289g, elapsedRealtime)) {
                for (int i6 = this.f12364b - 1; i6 >= 0; i6--) {
                    if (!t(i6, elapsedRealtime)) {
                        this.f4289g = i6;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // o2.j
        public int m() {
            return 0;
        }

        @Override // o2.j
        public int n() {
            return this.f4289g;
        }

        @Override // o2.j
        public Object p() {
            return null;
        }
    }

    public f(h hVar, b2.j jVar, Uri[] uriArr, s0[] s0VarArr, g gVar, i0 i0Var, t tVar, List list) {
        this.f4265a = hVar;
        this.f4271g = jVar;
        this.f4269e = uriArr;
        this.f4270f = s0VarArr;
        this.f4268d = tVar;
        this.f4273i = list;
        q2.l a6 = gVar.a(1);
        this.f4266b = a6;
        if (i0Var != null) {
            a6.i(i0Var);
        }
        this.f4267c = gVar.a(3);
        this.f4272h = new x0(s0VarArr);
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < uriArr.length; i6++) {
            if ((s0VarArr[i6].f4049e & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
                arrayList.add(Integer.valueOf(i6));
            }
        }
        this.f4280p = new d(this.f4272h, com.google.common.primitives.b.h(arrayList));
    }

    private long b(j jVar, boolean z5, b2.f fVar, long j6, long j7) {
        long g6;
        long j8;
        if (jVar != null && !z5) {
            return jVar.h() ? jVar.g() : jVar.f14331j;
        }
        long j9 = fVar.f2972p + j6;
        if (jVar != null && !this.f4279o) {
            j7 = jVar.f14286g;
        }
        if (fVar.f2968l || j7 < j9) {
            g6 = com.google.android.exoplayer2.util.s0.g(fVar.f2971o, Long.valueOf(j7 - j6), true, !this.f4271g.a() || jVar == null);
            j8 = fVar.f2965i;
        } else {
            g6 = fVar.f2965i;
            j8 = fVar.f2971o.size();
        }
        return g6 + j8;
    }

    private static Uri c(b2.f fVar, f.a aVar) {
        String str;
        if (aVar == null || (str = aVar.f2980h) == null) {
            return null;
        }
        return m0.d(fVar.f2985a, str);
    }

    private y1.e h(Uri uri, int i6) {
        if (uri == null) {
            return null;
        }
        byte[] c6 = this.f4274j.c(uri);
        if (c6 != null) {
            this.f4274j.b(uri, c6);
            return null;
        }
        return new a(this.f4267c, new o.b().i(uri).b(1).a(), this.f4270f[i6], this.f4280p.m(), this.f4280p.p(), this.f4276l);
    }

    private long n(long j6) {
        long j7 = this.f4281q;
        if (j7 != -9223372036854775807L) {
            return j7 - j6;
        }
        return -9223372036854775807L;
    }

    private void r(b2.f fVar) {
        this.f4281q = fVar.f2968l ? -9223372036854775807L : fVar.e() - this.f4271g.j();
    }

    public y1.n[] a(j jVar, long j6) {
        int f6 = jVar == null ? -1 : this.f4272h.f(jVar.f14283d);
        int length = this.f4280p.length();
        y1.n[] nVarArr = new y1.n[length];
        for (int i6 = 0; i6 < length; i6++) {
            int f7 = this.f4280p.f(i6);
            Uri uri = this.f4269e[f7];
            if (this.f4271g.d(uri)) {
                b2.f i7 = this.f4271g.i(uri, false);
                com.google.android.exoplayer2.util.a.e(i7);
                long j7 = i7.f2962f - this.f4271g.j();
                long b6 = b(jVar, f7 != f6, i7, j7, j6);
                long j8 = i7.f2965i;
                if (b6 < j8) {
                    nVarArr[i6] = y1.n.f14332a;
                } else {
                    nVarArr[i6] = new c(i7, j7, (int) (b6 - j8));
                }
            } else {
                nVarArr[i6] = y1.n.f14332a;
            }
        }
        return nVarArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(long j6, long j7, List list, boolean z5, b bVar) {
        long j8;
        long j9;
        Uri uri;
        int i6;
        Uri uri2;
        b2.f fVar;
        int i7;
        j jVar = list.isEmpty() ? null : (j) list.get(list.size() - 1);
        int f6 = jVar == null ? -1 : this.f4272h.f(jVar.f14283d);
        long j10 = j7 - j6;
        long n5 = n(j6);
        if (jVar != null && !this.f4279o) {
            long d6 = jVar.d();
            j10 = Math.max(0L, j10 - d6);
            if (n5 != -9223372036854775807L) {
                j8 = j10;
                j9 = Math.max(0L, n5 - d6);
                this.f4280p.b(j6, j8, j9, list, a(jVar, j7));
                int j11 = this.f4280p.j();
                boolean z6 = f6 == j11;
                uri = this.f4269e[j11];
                if (this.f4271g.d(uri)) {
                    bVar.f4286c = uri;
                    this.f4282r &= uri.equals(this.f4278n);
                    this.f4278n = uri;
                    return;
                }
                b2.f i8 = this.f4271g.i(uri, true);
                com.google.android.exoplayer2.util.a.e(i8);
                this.f4279o = i8.f2987c;
                r(i8);
                long j12 = i8.f2962f - this.f4271g.j();
                j jVar2 = jVar;
                int i9 = f6;
                long b6 = b(jVar, z6, i8, j12, j7);
                if (b6 >= i8.f2965i || jVar2 == null || !z6) {
                    i6 = j11;
                    uri2 = uri;
                    fVar = i8;
                } else {
                    Uri uri3 = this.f4269e[i9];
                    b2.f i10 = this.f4271g.i(uri3, true);
                    com.google.android.exoplayer2.util.a.e(i10);
                    j12 = i10.f2962f - this.f4271g.j();
                    uri2 = uri3;
                    fVar = i10;
                    b6 = jVar2.g();
                    i6 = i9;
                }
                long j13 = fVar.f2965i;
                if (b6 < j13) {
                    this.f4277m = new w1.b();
                    return;
                }
                int i11 = (int) (b6 - j13);
                int size = fVar.f2971o.size();
                if (i11 < size) {
                    i7 = i11;
                } else if (!fVar.f2968l) {
                    bVar.f4286c = uri2;
                    this.f4282r &= uri2.equals(this.f4278n);
                    this.f4278n = uri2;
                    return;
                } else if (z5 || size == 0) {
                    bVar.f4285b = true;
                    return;
                } else {
                    i7 = size - 1;
                }
                this.f4282r = false;
                this.f4278n = null;
                f.a aVar = (f.a) fVar.f2971o.get(i7);
                Uri c6 = c(fVar, aVar.f2974b);
                y1.e h6 = h(c6, i6);
                bVar.f4284a = h6;
                if (h6 != null) {
                    return;
                }
                Uri c7 = c(fVar, aVar);
                y1.e h7 = h(c7, i6);
                bVar.f4284a = h7;
                if (h7 != null) {
                    return;
                }
                bVar.f4284a = j.j(this.f4265a, this.f4266b, this.f4270f[i6], j12, fVar, i7, uri2, this.f4273i, this.f4280p.m(), this.f4280p.p(), this.f4275k, this.f4268d, jVar2, this.f4274j.a(c7), this.f4274j.a(c6));
                return;
            }
        }
        j8 = j10;
        j9 = n5;
        this.f4280p.b(j6, j8, j9, list, a(jVar, j7));
        int j112 = this.f4280p.j();
        if (f6 == j112) {
        }
        uri = this.f4269e[j112];
        if (this.f4271g.d(uri)) {
        }
    }

    public int e(long j6, List list) {
        return (this.f4277m != null || this.f4280p.length() < 2) ? list.size() : this.f4280p.g(j6, list);
    }

    public x0 f() {
        return this.f4272h;
    }

    public o2.j g() {
        return this.f4280p;
    }

    public boolean i(y1.e eVar, long j6) {
        o2.j jVar = this.f4280p;
        return jVar.a(jVar.r(this.f4272h.f(eVar.f14283d)), j6);
    }

    public void j() {
        IOException iOException = this.f4277m;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.f4278n;
        if (uri == null || !this.f4282r) {
            return;
        }
        this.f4271g.f(uri);
    }

    public void k(y1.e eVar) {
        if (eVar instanceof a) {
            a aVar = (a) eVar;
            this.f4276l = aVar.h();
            this.f4274j.b(aVar.f14281b.f12794a, (byte[]) com.google.android.exoplayer2.util.a.e(aVar.j()));
        }
    }

    public boolean l(Uri uri, long j6) {
        int r5;
        int i6 = 0;
        while (true) {
            Uri[] uriArr = this.f4269e;
            if (i6 >= uriArr.length) {
                i6 = -1;
                break;
            } else if (uriArr[i6].equals(uri)) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 == -1 || (r5 = this.f4280p.r(i6)) == -1) {
            return true;
        }
        this.f4282r = uri.equals(this.f4278n) | this.f4282r;
        return j6 == -9223372036854775807L || this.f4280p.a(r5, j6);
    }

    public void m() {
        this.f4277m = null;
    }

    public void o(boolean z5) {
        this.f4275k = z5;
    }

    public void p(o2.j jVar) {
        this.f4280p = jVar;
    }

    public boolean q(long j6, y1.e eVar, List list) {
        if (this.f4277m != null) {
            return false;
        }
        return this.f4280p.i(j6, eVar, list);
    }
}
