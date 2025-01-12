package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import c1.a0;
import c1.x;
import c1.z;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.hls.f;
import com.google.android.exoplayer2.source.hls.q;
import com.google.android.exoplayer2.t0;
import com.google.android.exoplayer2.util.y;
import com.google.common.collect.m0;
import com.google.common.collect.y;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import n1.a;
import q2.c0;
import q2.d0;
import w1.e0;
import w1.q0;
import w1.r0;
import w1.s0;
import w1.x0;
import w1.y0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q implements d0.b, d0.f, s0, c1.k, q0.b {
    private static final Set Z = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 4)));
    private a0 A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private int F;
    private com.google.android.exoplayer2.s0 G;
    private com.google.android.exoplayer2.s0 H;
    private boolean I;
    private y0 J;
    private Set K;
    private int[] L;
    private int M;
    private boolean N;
    private boolean[] O;
    private boolean[] P;
    private long Q;
    private long R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private long W;
    private com.google.android.exoplayer2.drm.k X;
    private j Y;

    /* renamed from: a  reason: collision with root package name */
    private final int f4337a;

    /* renamed from: b  reason: collision with root package name */
    private final b f4338b;

    /* renamed from: c  reason: collision with root package name */
    private final f f4339c;

    /* renamed from: d  reason: collision with root package name */
    private final q2.b f4340d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.s0 f4341e;

    /* renamed from: f  reason: collision with root package name */
    private final v f4342f;

    /* renamed from: g  reason: collision with root package name */
    private final t.a f4343g;

    /* renamed from: h  reason: collision with root package name */
    private final c0 f4344h;

    /* renamed from: l  reason: collision with root package name */
    private final e0.a f4346l;

    /* renamed from: m  reason: collision with root package name */
    private final int f4347m;

    /* renamed from: o  reason: collision with root package name */
    private final ArrayList f4349o;

    /* renamed from: p  reason: collision with root package name */
    private final List f4350p;

    /* renamed from: q  reason: collision with root package name */
    private final Runnable f4351q;

    /* renamed from: r  reason: collision with root package name */
    private final Runnable f4352r;

    /* renamed from: s  reason: collision with root package name */
    private final Handler f4353s;

    /* renamed from: t  reason: collision with root package name */
    private final ArrayList f4354t;

    /* renamed from: u  reason: collision with root package name */
    private final Map f4355u;

    /* renamed from: v  reason: collision with root package name */
    private y1.e f4356v;

    /* renamed from: w  reason: collision with root package name */
    private d[] f4357w;

    /* renamed from: y  reason: collision with root package name */
    private Set f4359y;

    /* renamed from: z  reason: collision with root package name */
    private SparseIntArray f4360z;

    /* renamed from: k  reason: collision with root package name */
    private final d0 f4345k = new d0("Loader:HlsSampleStreamWrapper");

    /* renamed from: n  reason: collision with root package name */
    private final f.b f4348n = new f.b();

    /* renamed from: x  reason: collision with root package name */
    private int[] f4358x = new int[0];

    /* loaded from: classes.dex */
    public interface b extends s0.a {
        void b();

        void m(Uri uri);
    }

    /* loaded from: classes.dex */
    private static class c implements a0 {

        /* renamed from: g  reason: collision with root package name */
        private static final com.google.android.exoplayer2.s0 f4361g = new s0.b().e0("application/id3").E();

        /* renamed from: h  reason: collision with root package name */
        private static final com.google.android.exoplayer2.s0 f4362h = new s0.b().e0("application/x-emsg").E();

        /* renamed from: a  reason: collision with root package name */
        private final p1.b f4363a = new p1.b();

        /* renamed from: b  reason: collision with root package name */
        private final a0 f4364b;

        /* renamed from: c  reason: collision with root package name */
        private final com.google.android.exoplayer2.s0 f4365c;

        /* renamed from: d  reason: collision with root package name */
        private com.google.android.exoplayer2.s0 f4366d;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f4367e;

        /* renamed from: f  reason: collision with root package name */
        private int f4368f;

        public c(a0 a0Var, int i6) {
            com.google.android.exoplayer2.s0 s0Var;
            this.f4364b = a0Var;
            if (i6 == 1) {
                s0Var = f4361g;
            } else if (i6 != 3) {
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unknown metadataType: ");
                sb.append(i6);
                throw new IllegalArgumentException(sb.toString());
            } else {
                s0Var = f4362h;
            }
            this.f4365c = s0Var;
            this.f4367e = new byte[0];
            this.f4368f = 0;
        }

        private boolean g(p1.a aVar) {
            com.google.android.exoplayer2.s0 b6 = aVar.b();
            return b6 != null && com.google.android.exoplayer2.util.s0.c(this.f4365c.f4056n, b6.f4056n);
        }

        private void h(int i6) {
            byte[] bArr = this.f4367e;
            if (bArr.length < i6) {
                this.f4367e = Arrays.copyOf(bArr, i6 + (i6 / 2));
            }
        }

        private y i(int i6, int i7) {
            int i8 = this.f4368f - i7;
            y yVar = new y(Arrays.copyOfRange(this.f4367e, i8 - i6, i8));
            byte[] bArr = this.f4367e;
            System.arraycopy(bArr, i8, bArr, 0, i7);
            this.f4368f = i7;
            return yVar;
        }

        @Override // c1.a0
        public /* synthetic */ void a(y yVar, int i6) {
            z.b(this, yVar, i6);
        }

        @Override // c1.a0
        public /* synthetic */ int b(q2.h hVar, int i6, boolean z5) {
            return z.a(this, hVar, i6, z5);
        }

        @Override // c1.a0
        public int c(q2.h hVar, int i6, boolean z5, int i7) {
            h(this.f4368f + i6);
            int read = hVar.read(this.f4367e, this.f4368f, i6);
            if (read != -1) {
                this.f4368f += read;
                return read;
            } else if (z5) {
                return -1;
            } else {
                throw new EOFException();
            }
        }

        @Override // c1.a0
        public void d(long j6, int i6, int i7, int i8, a0.a aVar) {
            com.google.android.exoplayer2.util.a.e(this.f4366d);
            y i9 = i(i7, i8);
            if (!com.google.android.exoplayer2.util.s0.c(this.f4366d.f4056n, this.f4365c.f4056n)) {
                if (!"application/x-emsg".equals(this.f4366d.f4056n)) {
                    String valueOf = String.valueOf(this.f4366d.f4056n);
                    com.google.android.exoplayer2.util.n.h("EmsgUnwrappingTrackOutput", valueOf.length() != 0 ? "Ignoring sample for unsupported format: ".concat(valueOf) : new String("Ignoring sample for unsupported format: "));
                    return;
                }
                p1.a c6 = this.f4363a.c(i9);
                if (!g(c6)) {
                    com.google.android.exoplayer2.util.n.h("EmsgUnwrappingTrackOutput", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.f4365c.f4056n, c6.b()));
                    return;
                }
                i9 = new y((byte[]) com.google.android.exoplayer2.util.a.e(c6.d()));
            }
            int a6 = i9.a();
            this.f4364b.a(i9, a6);
            this.f4364b.d(j6, i6, a6, i8, aVar);
        }

        @Override // c1.a0
        public void e(com.google.android.exoplayer2.s0 s0Var) {
            this.f4366d = s0Var;
            this.f4364b.e(this.f4365c);
        }

        @Override // c1.a0
        public void f(y yVar, int i6, int i7) {
            h(this.f4368f + i6);
            yVar.i(this.f4367e, this.f4368f, i6);
            this.f4368f += i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d extends q0 {
        private final Map J;
        private com.google.android.exoplayer2.drm.k K;

        private d(q2.b bVar, Looper looper, v vVar, t.a aVar, Map map) {
            super(bVar, looper, vVar, aVar);
            this.J = map;
        }

        private n1.a d0(n1.a aVar) {
            if (aVar == null) {
                return null;
            }
            int h6 = aVar.h();
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i7 >= h6) {
                    i7 = -1;
                    break;
                }
                a.b g6 = aVar.g(i7);
                if ((g6 instanceof s1.l) && "com.apple.streaming.transportStreamTimestamp".equals(((s1.l) g6).f13161b)) {
                    break;
                }
                i7++;
            }
            if (i7 == -1) {
                return aVar;
            }
            if (h6 == 1) {
                return null;
            }
            a.b[] bVarArr = new a.b[h6 - 1];
            while (i6 < h6) {
                if (i6 != i7) {
                    bVarArr[i6 < i7 ? i6 : i6 - 1] = aVar.g(i6);
                }
                i6++;
            }
            return new n1.a(bVarArr);
        }

        @Override // w1.q0, c1.a0
        public void d(long j6, int i6, int i7, int i8, a0.a aVar) {
            super.d(j6, i6, i7, i8, aVar);
        }

        public void e0(com.google.android.exoplayer2.drm.k kVar) {
            this.K = kVar;
            F();
        }

        public void f0(j jVar) {
            b0(jVar.f4293k);
        }

        @Override // w1.q0
        public com.google.android.exoplayer2.s0 t(com.google.android.exoplayer2.s0 s0Var) {
            com.google.android.exoplayer2.drm.k kVar;
            com.google.android.exoplayer2.drm.k kVar2 = this.K;
            if (kVar2 == null) {
                kVar2 = s0Var.f4059q;
            }
            if (kVar2 != null && (kVar = (com.google.android.exoplayer2.drm.k) this.J.get(kVar2.f3703c)) != null) {
                kVar2 = kVar;
            }
            n1.a d02 = d0(s0Var.f4054l);
            if (kVar2 != s0Var.f4059q || d02 != s0Var.f4054l) {
                s0Var = s0Var.e().L(kVar2).X(d02).E();
            }
            return super.t(s0Var);
        }
    }

    public q(int i6, b bVar, f fVar, Map map, q2.b bVar2, long j6, com.google.android.exoplayer2.s0 s0Var, v vVar, t.a aVar, c0 c0Var, e0.a aVar2, int i7) {
        this.f4337a = i6;
        this.f4338b = bVar;
        this.f4339c = fVar;
        this.f4355u = map;
        this.f4340d = bVar2;
        this.f4341e = s0Var;
        this.f4342f = vVar;
        this.f4343g = aVar;
        this.f4344h = c0Var;
        this.f4346l = aVar2;
        this.f4347m = i7;
        Set set = Z;
        this.f4359y = new HashSet(set.size());
        this.f4360z = new SparseIntArray(set.size());
        this.f4357w = new d[0];
        this.P = new boolean[0];
        this.O = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.f4349o = arrayList;
        this.f4350p = Collections.unmodifiableList(arrayList);
        this.f4354t = new ArrayList();
        this.f4351q = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.n
            @Override // java.lang.Runnable
            public final void run() {
                q.this.S();
            }
        };
        this.f4352r = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.o
            @Override // java.lang.Runnable
            public final void run() {
                q.this.a0();
            }
        };
        this.f4353s = com.google.android.exoplayer2.util.s0.x();
        this.Q = j6;
        this.R = j6;
    }

    private boolean A(int i6) {
        for (int i7 = i6; i7 < this.f4349o.size(); i7++) {
            if (((j) this.f4349o.get(i7)).f4296n) {
                return false;
            }
        }
        j jVar = (j) this.f4349o.get(i6);
        for (int i8 = 0; i8 < this.f4357w.length; i8++) {
            if (this.f4357w[i8].z() > jVar.m(i8)) {
                return false;
            }
        }
        return true;
    }

    private static c1.h C(int i6, int i7) {
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unmapped track with id ");
        sb.append(i6);
        sb.append(" of type ");
        sb.append(i7);
        com.google.android.exoplayer2.util.n.h("HlsSampleStreamWrapper", sb.toString());
        return new c1.h();
    }

    private q0 D(int i6, int i7) {
        int length = this.f4357w.length;
        boolean z5 = true;
        if (i7 != 1 && i7 != 2) {
            z5 = false;
        }
        d dVar = new d(this.f4340d, this.f4353s.getLooper(), this.f4342f, this.f4343g, this.f4355u);
        if (z5) {
            dVar.e0(this.X);
        }
        dVar.W(this.W);
        j jVar = this.Y;
        if (jVar != null) {
            dVar.f0(jVar);
        }
        dVar.Z(this);
        int i8 = length + 1;
        int[] copyOf = Arrays.copyOf(this.f4358x, i8);
        this.f4358x = copyOf;
        copyOf[length] = i6;
        this.f4357w = (d[]) com.google.android.exoplayer2.util.s0.w0(this.f4357w, dVar);
        boolean[] copyOf2 = Arrays.copyOf(this.P, i8);
        this.P = copyOf2;
        copyOf2[length] = z5;
        this.N |= z5;
        this.f4359y.add(Integer.valueOf(i7));
        this.f4360z.append(i7, length);
        if (M(i7) > M(this.B)) {
            this.C = length;
            this.B = i7;
        }
        this.O = Arrays.copyOf(this.O, i8);
        return dVar;
    }

    private y0 E(x0[] x0VarArr) {
        for (int i6 = 0; i6 < x0VarArr.length; i6++) {
            x0 x0Var = x0VarArr[i6];
            com.google.android.exoplayer2.s0[] s0VarArr = new com.google.android.exoplayer2.s0[x0Var.f14093a];
            for (int i7 = 0; i7 < x0Var.f14093a; i7++) {
                com.google.android.exoplayer2.s0 e6 = x0Var.e(i7);
                s0VarArr[i7] = e6.f(this.f4342f.d(e6));
            }
            x0VarArr[i6] = new x0(s0VarArr);
        }
        return new y0(x0VarArr);
    }

    private static com.google.android.exoplayer2.s0 F(com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.s0 s0Var2, boolean z5) {
        if (s0Var == null) {
            return s0Var2;
        }
        String J = com.google.android.exoplayer2.util.s0.J(s0Var.f4053k, com.google.android.exoplayer2.util.q.j(s0Var2.f4056n));
        String e6 = com.google.android.exoplayer2.util.q.e(J);
        s0.b Q = s0Var2.e().S(s0Var.f4045a).U(s0Var.f4046b).V(s0Var.f4047c).g0(s0Var.f4048d).c0(s0Var.f4049e).G(z5 ? s0Var.f4050f : -1).Z(z5 ? s0Var.f4051g : -1).I(J).j0(s0Var.f4061s).Q(s0Var.f4062t);
        if (e6 != null) {
            Q.e0(e6);
        }
        int i6 = s0Var.A;
        if (i6 != -1) {
            Q.H(i6);
        }
        n1.a aVar = s0Var.f4054l;
        if (aVar != null) {
            n1.a aVar2 = s0Var2.f4054l;
            if (aVar2 != null) {
                aVar = aVar2.f(aVar);
            }
            Q.X(aVar);
        }
        return Q.E();
    }

    private void G(int i6) {
        com.google.android.exoplayer2.util.a.g(!this.f4345k.j());
        while (true) {
            if (i6 >= this.f4349o.size()) {
                i6 = -1;
                break;
            } else if (A(i6)) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 == -1) {
            return;
        }
        long j6 = K().f14287h;
        j H = H(i6);
        if (this.f4349o.isEmpty()) {
            this.R = this.Q;
        } else {
            ((j) m0.c(this.f4349o)).o();
        }
        this.U = false;
        this.f4346l.D(this.B, H.f14286g, j6);
    }

    private j H(int i6) {
        j jVar = (j) this.f4349o.get(i6);
        ArrayList arrayList = this.f4349o;
        com.google.android.exoplayer2.util.s0.E0(arrayList, i6, arrayList.size());
        for (int i7 = 0; i7 < this.f4357w.length; i7++) {
            this.f4357w[i7].r(jVar.m(i7));
        }
        return jVar;
    }

    private boolean I(j jVar) {
        int i6 = jVar.f4293k;
        int length = this.f4357w.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (this.O[i7] && this.f4357w[i7].L() == i6) {
                return false;
            }
        }
        return true;
    }

    private static boolean J(com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.s0 s0Var2) {
        String str = s0Var.f4056n;
        String str2 = s0Var2.f4056n;
        int j6 = com.google.android.exoplayer2.util.q.j(str);
        if (j6 != 3) {
            return j6 == com.google.android.exoplayer2.util.q.j(str2);
        } else if (com.google.android.exoplayer2.util.s0.c(str, str2)) {
            return !("application/cea-608".equals(str) || "application/cea-708".equals(str)) || s0Var.F == s0Var2.F;
        } else {
            return false;
        }
    }

    private j K() {
        ArrayList arrayList = this.f4349o;
        return (j) arrayList.get(arrayList.size() - 1);
    }

    private a0 L(int i6, int i7) {
        com.google.android.exoplayer2.util.a.a(Z.contains(Integer.valueOf(i7)));
        int i8 = this.f4360z.get(i7, -1);
        if (i8 == -1) {
            return null;
        }
        if (this.f4359y.add(Integer.valueOf(i7))) {
            this.f4358x[i8] = i6;
        }
        return this.f4358x[i8] == i6 ? this.f4357w[i8] : C(i6, i7);
    }

    private static int M(int i6) {
        if (i6 != 1) {
            if (i6 != 2) {
                return i6 != 3 ? 0 : 1;
            }
            return 3;
        }
        return 2;
    }

    private void N(j jVar) {
        d[] dVarArr;
        this.Y = jVar;
        this.G = jVar.f14283d;
        this.R = -9223372036854775807L;
        this.f4349o.add(jVar);
        y.a builder = com.google.common.collect.y.builder();
        for (d dVar : this.f4357w) {
            builder.a(Integer.valueOf(dVar.D()));
        }
        jVar.n(this, builder.j());
        for (d dVar2 : this.f4357w) {
            dVar2.f0(jVar);
            if (jVar.f4296n) {
                dVar2.c0();
            }
        }
    }

    private static boolean O(y1.e eVar) {
        return eVar instanceof j;
    }

    private boolean P() {
        return this.R != -9223372036854775807L;
    }

    private void R() {
        int i6 = this.J.f14101a;
        int[] iArr = new int[i6];
        this.L = iArr;
        Arrays.fill(iArr, -1);
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = 0;
            while (true) {
                d[] dVarArr = this.f4357w;
                if (i8 >= dVarArr.length) {
                    break;
                } else if (J((com.google.android.exoplayer2.s0) com.google.android.exoplayer2.util.a.i(dVarArr[i8].C()), this.J.e(i7).e(0))) {
                    this.L[i7] = i8;
                    break;
                } else {
                    i8++;
                }
            }
        }
        Iterator it = this.f4354t.iterator();
        while (it.hasNext()) {
            ((m) it.next()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        if (!this.I && this.L == null && this.D) {
            for (d dVar : this.f4357w) {
                if (dVar.C() == null) {
                    return;
                }
            }
            if (this.J != null) {
                R();
                return;
            }
            z();
            j0();
            this.f4338b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        this.D = true;
        S();
    }

    private void e0() {
        for (d dVar : this.f4357w) {
            dVar.S(this.S);
        }
        this.S = false;
    }

    private boolean f0(long j6) {
        int length = this.f4357w.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (!this.f4357w[i6].V(j6, false) && (this.P[i6] || !this.N)) {
                return false;
            }
        }
        return true;
    }

    private void j0() {
        this.E = true;
    }

    private void o0(r0[] r0VarArr) {
        this.f4354t.clear();
        for (r0 r0Var : r0VarArr) {
            if (r0Var != null) {
                this.f4354t.add((m) r0Var);
            }
        }
    }

    private void x() {
        com.google.android.exoplayer2.util.a.g(this.E);
        com.google.android.exoplayer2.util.a.e(this.J);
        com.google.android.exoplayer2.util.a.e(this.K);
    }

    private void z() {
        int length = this.f4357w.length;
        int i6 = 0;
        int i7 = 6;
        int i8 = -1;
        while (true) {
            if (i6 >= length) {
                break;
            }
            String str = ((com.google.android.exoplayer2.s0) com.google.android.exoplayer2.util.a.i(this.f4357w[i6].C())).f4056n;
            int i9 = com.google.android.exoplayer2.util.q.q(str) ? 2 : com.google.android.exoplayer2.util.q.n(str) ? 1 : com.google.android.exoplayer2.util.q.p(str) ? 3 : 6;
            if (M(i9) > M(i7)) {
                i8 = i6;
                i7 = i9;
            } else if (i9 == i7 && i8 != -1) {
                i8 = -1;
            }
            i6++;
        }
        x0 f6 = this.f4339c.f();
        int i10 = f6.f14093a;
        this.M = -1;
        this.L = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            this.L[i11] = i11;
        }
        x0[] x0VarArr = new x0[length];
        for (int i12 = 0; i12 < length; i12++) {
            com.google.android.exoplayer2.s0 s0Var = (com.google.android.exoplayer2.s0) com.google.android.exoplayer2.util.a.i(this.f4357w[i12].C());
            if (i12 == i8) {
                com.google.android.exoplayer2.s0[] s0VarArr = new com.google.android.exoplayer2.s0[i10];
                if (i10 == 1) {
                    s0VarArr[0] = s0Var.i(f6.e(0));
                } else {
                    for (int i13 = 0; i13 < i10; i13++) {
                        s0VarArr[i13] = F(f6.e(i13), s0Var, true);
                    }
                }
                x0VarArr[i12] = new x0(s0VarArr);
                this.M = i12;
            } else {
                x0VarArr[i12] = new x0(F((i7 == 2 && com.google.android.exoplayer2.util.q.n(s0Var.f4056n)) ? this.f4341e : null, s0Var, false));
            }
        }
        this.J = E(x0VarArr);
        com.google.android.exoplayer2.util.a.g(this.K == null);
        this.K = Collections.emptySet();
    }

    public void B() {
        if (this.E) {
            return;
        }
        h(this.Q);
    }

    public boolean Q(int i6) {
        return !P() && this.f4357w[i6].H(this.U);
    }

    public void T() {
        this.f4345k.b();
        this.f4339c.j();
    }

    public void U(int i6) {
        T();
        this.f4357w[i6].J();
    }

    @Override // q2.d0.b
    /* renamed from: V */
    public void p(y1.e eVar, long j6, long j7, boolean z5) {
        this.f4356v = null;
        w1.p pVar = new w1.p(eVar.f14280a, eVar.f14281b, eVar.f(), eVar.e(), j6, j7, eVar.b());
        this.f4344h.a(eVar.f14280a);
        this.f4346l.r(pVar, eVar.f14282c, this.f4337a, eVar.f14283d, eVar.f14284e, eVar.f14285f, eVar.f14286g, eVar.f14287h);
        if (z5) {
            return;
        }
        if (P() || this.F == 0) {
            e0();
        }
        if (this.F > 0) {
            this.f4338b.j(this);
        }
    }

    @Override // q2.d0.b
    /* renamed from: W */
    public void m(y1.e eVar, long j6, long j7) {
        this.f4356v = null;
        this.f4339c.k(eVar);
        w1.p pVar = new w1.p(eVar.f14280a, eVar.f14281b, eVar.f(), eVar.e(), j6, j7, eVar.b());
        this.f4344h.a(eVar.f14280a);
        this.f4346l.u(pVar, eVar.f14282c, this.f4337a, eVar.f14283d, eVar.f14284e, eVar.f14285f, eVar.f14286g, eVar.f14287h);
        if (this.E) {
            this.f4338b.j(this);
        } else {
            h(this.Q);
        }
    }

    @Override // q2.d0.b
    /* renamed from: X */
    public d0.c k(y1.e eVar, long j6, long j7, IOException iOException, int i6) {
        d0.c h6;
        long b6 = eVar.b();
        boolean O = O(eVar);
        w1.p pVar = new w1.p(eVar.f14280a, eVar.f14281b, eVar.f(), eVar.e(), j6, j7, b6);
        c0.a aVar = new c0.a(pVar, new w1.s(eVar.f14282c, this.f4337a, eVar.f14283d, eVar.f14284e, eVar.f14285f, com.google.android.exoplayer2.p.b(eVar.f14286g), com.google.android.exoplayer2.p.b(eVar.f14287h)), iOException, i6);
        long c6 = this.f4344h.c(aVar);
        boolean i7 = c6 != -9223372036854775807L ? this.f4339c.i(eVar, c6) : false;
        if (i7) {
            if (O && b6 == 0) {
                ArrayList arrayList = this.f4349o;
                com.google.android.exoplayer2.util.a.g(((j) arrayList.remove(arrayList.size() - 1)) == eVar);
                if (this.f4349o.isEmpty()) {
                    this.R = this.Q;
                } else {
                    ((j) m0.c(this.f4349o)).o();
                }
            }
            h6 = d0.f12728f;
        } else {
            long b7 = this.f4344h.b(aVar);
            h6 = b7 != -9223372036854775807L ? d0.h(false, b7) : d0.f12729g;
        }
        boolean z5 = !h6.c();
        boolean z6 = i7;
        this.f4346l.w(pVar, eVar.f14282c, this.f4337a, eVar.f14283d, eVar.f14284e, eVar.f14285f, eVar.f14286g, eVar.f14287h, iOException, z5);
        if (z5) {
            this.f4356v = null;
            this.f4344h.a(eVar.f14280a);
        }
        if (z6) {
            if (this.E) {
                this.f4338b.j(this);
            } else {
                h(this.Q);
            }
        }
        return h6;
    }

    public void Y() {
        this.f4359y.clear();
    }

    public boolean Z(Uri uri, long j6) {
        return this.f4339c.l(uri, j6);
    }

    @Override // w1.s0
    public boolean a() {
        return this.f4345k.j();
    }

    @Override // w1.q0.b
    public void b(com.google.android.exoplayer2.s0 s0Var) {
        this.f4353s.post(this.f4351q);
    }

    public void b0(x0[] x0VarArr, int i6, int... iArr) {
        this.J = E(x0VarArr);
        this.K = new HashSet();
        for (int i7 : iArr) {
            this.K.add(this.J.e(i7));
        }
        this.M = i6;
        Handler handler = this.f4353s;
        final b bVar = this.f4338b;
        Objects.requireNonNull(bVar);
        handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.hls.p
            @Override // java.lang.Runnable
            public final void run() {
                q.b.this.b();
            }
        });
        j0();
    }

    public int c0(int i6, t0 t0Var, com.google.android.exoplayer2.decoder.j jVar, boolean z5) {
        if (P()) {
            return -3;
        }
        int i7 = 0;
        if (!this.f4349o.isEmpty()) {
            int i8 = 0;
            while (i8 < this.f4349o.size() - 1 && I((j) this.f4349o.get(i8))) {
                i8++;
            }
            com.google.android.exoplayer2.util.s0.E0(this.f4349o, 0, i8);
            j jVar2 = (j) this.f4349o.get(0);
            com.google.android.exoplayer2.s0 s0Var = jVar2.f14283d;
            if (!s0Var.equals(this.H)) {
                this.f4346l.i(this.f4337a, s0Var, jVar2.f14284e, jVar2.f14285f, jVar2.f14286g);
            }
            this.H = s0Var;
        }
        int N = this.f4357w[i6].N(t0Var, jVar, z5, this.U);
        if (N == -5) {
            com.google.android.exoplayer2.s0 s0Var2 = (com.google.android.exoplayer2.s0) com.google.android.exoplayer2.util.a.e(t0Var.f4441b);
            if (i6 == this.C) {
                int L = this.f4357w[i6].L();
                while (i7 < this.f4349o.size() && ((j) this.f4349o.get(i7)).f4293k != L) {
                    i7++;
                }
                s0Var2 = s0Var2.i(i7 < this.f4349o.size() ? ((j) this.f4349o.get(i7)).f14283d : (com.google.android.exoplayer2.s0) com.google.android.exoplayer2.util.a.e(this.G));
            }
            t0Var.f4441b = s0Var2;
        }
        return N;
    }

    @Override // w1.s0
    public long d() {
        if (P()) {
            return this.R;
        }
        if (this.U) {
            return Long.MIN_VALUE;
        }
        return K().f14287h;
    }

    public void d0() {
        if (this.E) {
            for (d dVar : this.f4357w) {
                dVar.M();
            }
        }
        this.f4345k.m(this);
        this.f4353s.removeCallbacksAndMessages(null);
        this.I = true;
        this.f4354t.clear();
    }

    @Override // c1.k
    public a0 e(int i6, int i7) {
        a0 a0Var;
        if (!Z.contains(Integer.valueOf(i7))) {
            int i8 = 0;
            while (true) {
                a0[] a0VarArr = this.f4357w;
                if (i8 >= a0VarArr.length) {
                    a0Var = null;
                    break;
                } else if (this.f4358x[i8] == i6) {
                    a0Var = a0VarArr[i8];
                    break;
                } else {
                    i8++;
                }
            }
        } else {
            a0Var = L(i6, i7);
        }
        if (a0Var == null) {
            if (this.V) {
                return C(i6, i7);
            }
            a0Var = D(i6, i7);
        }
        if (i7 == 4) {
            if (this.A == null) {
                this.A = new c(a0Var, this.f4347m);
            }
            return this.A;
        }
        return a0Var;
    }

    @Override // w1.s0
    public long f() {
        ArrayList arrayList;
        if (this.U) {
            return Long.MIN_VALUE;
        }
        if (P()) {
            return this.R;
        }
        long j6 = this.Q;
        j K = K();
        if (!K.h()) {
            K = this.f4349o.size() > 1 ? (j) this.f4349o.get(arrayList.size() - 2) : null;
        }
        if (K != null) {
            j6 = Math.max(j6, K.f14287h);
        }
        if (this.D) {
            for (d dVar : this.f4357w) {
                j6 = Math.max(j6, dVar.w());
            }
        }
        return j6;
    }

    @Override // c1.k
    public void g() {
        this.V = true;
        this.f4353s.post(this.f4352r);
    }

    public boolean g0(long j6, boolean z5) {
        this.Q = j6;
        if (P()) {
            this.R = j6;
            return true;
        } else if (this.D && !z5 && f0(j6)) {
            return false;
        } else {
            this.R = j6;
            this.U = false;
            this.f4349o.clear();
            if (this.f4345k.j()) {
                this.f4345k.f();
            } else {
                this.f4345k.g();
                e0();
            }
            return true;
        }
    }

    @Override // w1.s0
    public boolean h(long j6) {
        List list;
        long max;
        if (this.U || this.f4345k.j() || this.f4345k.i()) {
            return false;
        }
        if (P()) {
            list = Collections.emptyList();
            max = this.R;
            for (d dVar : this.f4357w) {
                dVar.X(this.R);
            }
        } else {
            list = this.f4350p;
            j K = K();
            max = K.h() ? K.f14287h : Math.max(this.Q, K.f14286g);
        }
        List list2 = list;
        this.f4339c.d(j6, max, list2, this.E || !list2.isEmpty(), this.f4348n);
        f.b bVar = this.f4348n;
        boolean z5 = bVar.f4285b;
        y1.e eVar = bVar.f4284a;
        Uri uri = bVar.f4286c;
        bVar.a();
        if (z5) {
            this.R = -9223372036854775807L;
            this.U = true;
            return true;
        } else if (eVar == null) {
            if (uri != null) {
                this.f4338b.m(uri);
            }
            return false;
        } else {
            if (O(eVar)) {
                N((j) eVar);
            }
            this.f4356v = eVar;
            this.f4346l.A(new w1.p(eVar.f14280a, eVar.f14281b, this.f4345k.n(eVar, this, this.f4344h.d(eVar.f14282c))), eVar.f14282c, this.f4337a, eVar.f14283d, eVar.f14284e, eVar.f14285f, eVar.f14286g, eVar.f14287h);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h0(o2.j[] jVarArr, boolean[] zArr, r0[] r0VarArr, boolean[] zArr2, long j6, boolean z5) {
        boolean z6;
        boolean z7;
        x();
        int i6 = this.F;
        int i7 = 0;
        for (int i8 = 0; i8 < jVarArr.length; i8++) {
            m mVar = (m) r0VarArr[i8];
            if (mVar != null && (jVarArr[i8] == null || !zArr[i8])) {
                this.F--;
                mVar.d();
                r0VarArr[i8] = null;
            }
        }
        boolean z8 = z5 || (!this.T ? j6 == this.Q : i6 != 0);
        o2.j g6 = this.f4339c.g();
        boolean z9 = z8;
        o2.j jVar = g6;
        for (int i9 = 0; i9 < jVarArr.length; i9++) {
            o2.j jVar2 = jVarArr[i9];
            if (jVar2 != null) {
                int f6 = this.J.f(jVar2.k());
                if (f6 == this.M) {
                    this.f4339c.p(jVar2);
                    jVar = jVar2;
                }
                if (r0VarArr[i9] == null) {
                    this.F++;
                    m mVar2 = new m(this, f6);
                    r0VarArr[i9] = mVar2;
                    zArr2[i9] = true;
                    if (this.L != null) {
                        mVar2.a();
                        if (!z9) {
                            d dVar = this.f4357w[this.L[f6]];
                            z9 = (dVar.V(j6, true) || dVar.z() == 0) ? false : true;
                        }
                    }
                }
            }
        }
        if (this.F == 0) {
            this.f4339c.m();
            this.H = null;
            this.S = true;
            this.f4349o.clear();
            if (this.f4345k.j()) {
                if (this.D) {
                    d[] dVarArr = this.f4357w;
                    int length = dVarArr.length;
                    while (i7 < length) {
                        dVarArr[i7].o();
                        i7++;
                    }
                }
                this.f4345k.f();
            } else {
                e0();
            }
        } else {
            if (!this.f4349o.isEmpty() && !com.google.android.exoplayer2.util.s0.c(jVar, g6)) {
                if (!this.T) {
                    long j7 = j6 < 0 ? -j6 : 0L;
                    j K = K();
                    jVar.b(j6, j7, -9223372036854775807L, this.f4350p, this.f4339c.a(K, j6));
                    if (jVar.j() == this.f4339c.f().f(K.f14283d)) {
                        z7 = false;
                        if (z7) {
                            this.S = true;
                            z6 = true;
                            z9 = true;
                            if (z9) {
                                g0(j6, z6);
                                while (i7 < r0VarArr.length) {
                                    if (r0VarArr[i7] != null) {
                                        zArr2[i7] = true;
                                    }
                                    i7++;
                                }
                            }
                        }
                    }
                }
                z7 = true;
                if (z7) {
                }
            }
            z6 = z5;
            if (z9) {
            }
        }
        o0(r0VarArr);
        this.T = true;
        return z9;
    }

    @Override // w1.s0
    public void i(long j6) {
        if (this.f4345k.i() || P()) {
            return;
        }
        if (this.f4345k.j()) {
            com.google.android.exoplayer2.util.a.e(this.f4356v);
            if (this.f4339c.q(j6, this.f4356v, this.f4350p)) {
                this.f4345k.f();
                return;
            }
            return;
        }
        int e6 = this.f4339c.e(j6, this.f4350p);
        if (e6 < this.f4349o.size()) {
            G(e6);
        }
    }

    public void i0(com.google.android.exoplayer2.drm.k kVar) {
        if (com.google.android.exoplayer2.util.s0.c(this.X, kVar)) {
            return;
        }
        this.X = kVar;
        int i6 = 0;
        while (true) {
            d[] dVarArr = this.f4357w;
            if (i6 >= dVarArr.length) {
                return;
            }
            if (this.P[i6]) {
                dVarArr[i6].e0(kVar);
            }
            i6++;
        }
    }

    @Override // q2.d0.f
    public void j() {
        for (d dVar : this.f4357w) {
            dVar.P();
        }
    }

    public void k0(boolean z5) {
        this.f4339c.o(z5);
    }

    public void l0(long j6) {
        if (this.W != j6) {
            this.W = j6;
            for (d dVar : this.f4357w) {
                dVar.W(j6);
            }
        }
    }

    public int m0(int i6, long j6) {
        if (P()) {
            return 0;
        }
        d dVar = this.f4357w[i6];
        int B = dVar.B(j6, this.U);
        dVar.a0(B);
        return B;
    }

    public y0 n() {
        x();
        return this.J;
    }

    public void n0(int i6) {
        x();
        com.google.android.exoplayer2.util.a.e(this.L);
        int i7 = this.L[i6];
        com.google.android.exoplayer2.util.a.g(this.O[i7]);
        this.O[i7] = false;
    }

    @Override // c1.k
    public void r(x xVar) {
    }

    public void s() {
        T();
        if (this.U && !this.E) {
            throw new f1("Loading finished before preparation is complete.");
        }
    }

    public void t(long j6, boolean z5) {
        if (!this.D || P()) {
            return;
        }
        int length = this.f4357w.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f4357w[i6].n(j6, z5, this.O[i6]);
        }
    }

    public int y(int i6) {
        x();
        com.google.android.exoplayer2.util.a.e(this.L);
        int i7 = this.L[i6];
        if (i7 == -1) {
            return this.K.contains(this.J.e(i6)) ? -3 : -2;
        }
        boolean[] zArr = this.O;
        if (zArr[i7]) {
            return -2;
        }
        zArr[i7] = true;
        return i7;
    }
}
