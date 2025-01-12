package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import b2.e;
import b2.j;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.s1;
import com.google.android.exoplayer2.source.hls.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import q2.c0;
import q2.i0;
import w1.e0;
import w1.r0;
import w1.s0;
import w1.t;
import w1.x0;
import w1.y0;
/* loaded from: classes.dex */
public final class l implements w1.t, q.b, j.b {

    /* renamed from: a  reason: collision with root package name */
    private final h f4309a;

    /* renamed from: b  reason: collision with root package name */
    private final b2.j f4310b;

    /* renamed from: c  reason: collision with root package name */
    private final g f4311c;

    /* renamed from: d  reason: collision with root package name */
    private final i0 f4312d;

    /* renamed from: e  reason: collision with root package name */
    private final v f4313e;

    /* renamed from: f  reason: collision with root package name */
    private final t.a f4314f;

    /* renamed from: g  reason: collision with root package name */
    private final c0 f4315g;

    /* renamed from: h  reason: collision with root package name */
    private final e0.a f4316h;

    /* renamed from: k  reason: collision with root package name */
    private final q2.b f4317k;

    /* renamed from: n  reason: collision with root package name */
    private final w1.i f4320n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f4321o;

    /* renamed from: p  reason: collision with root package name */
    private final int f4322p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f4323q;

    /* renamed from: r  reason: collision with root package name */
    private t.a f4324r;

    /* renamed from: s  reason: collision with root package name */
    private int f4325s;

    /* renamed from: t  reason: collision with root package name */
    private y0 f4326t;

    /* renamed from: x  reason: collision with root package name */
    private s0 f4330x;

    /* renamed from: l  reason: collision with root package name */
    private final IdentityHashMap f4318l = new IdentityHashMap();

    /* renamed from: m  reason: collision with root package name */
    private final t f4319m = new t();

    /* renamed from: u  reason: collision with root package name */
    private q[] f4327u = new q[0];

    /* renamed from: v  reason: collision with root package name */
    private q[] f4328v = new q[0];

    /* renamed from: w  reason: collision with root package name */
    private int[][] f4329w = new int[0];

    public l(h hVar, b2.j jVar, g gVar, i0 i0Var, v vVar, t.a aVar, c0 c0Var, e0.a aVar2, q2.b bVar, w1.i iVar, boolean z5, int i6, boolean z6) {
        this.f4309a = hVar;
        this.f4310b = jVar;
        this.f4311c = gVar;
        this.f4312d = i0Var;
        this.f4313e = vVar;
        this.f4314f = aVar;
        this.f4315g = c0Var;
        this.f4316h = aVar2;
        this.f4317k = bVar;
        this.f4320n = iVar;
        this.f4321o = z5;
        this.f4322p = i6;
        this.f4323q = z6;
        this.f4330x = iVar.a(new s0[0]);
    }

    private void p(long j6, List list, List list2, List list3, Map map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i6 = 0; i6 < list.size(); i6++) {
            String str = ((e.a) list.get(i6)).f2953d;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z5 = true;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    if (com.google.android.exoplayer2.util.s0.c(str, ((e.a) list.get(i7)).f2953d)) {
                        e.a aVar = (e.a) list.get(i7);
                        arrayList3.add(Integer.valueOf(i7));
                        arrayList.add(aVar.f2950a);
                        arrayList2.add(aVar.f2951b);
                        z5 &= aVar.f2951b.f4053k != null;
                    }
                }
                q w5 = w(1, (Uri[]) arrayList.toArray((Uri[]) com.google.android.exoplayer2.util.s0.k(new Uri[0])), (com.google.android.exoplayer2.s0[]) arrayList2.toArray(new com.google.android.exoplayer2.s0[0]), null, Collections.emptyList(), map, j6);
                list3.add(com.google.common.primitives.b.h(arrayList3));
                list2.add(w5);
                if (this.f4321o && z5) {
                    w5.b0(new x0[]{new x0((com.google.android.exoplayer2.s0[]) arrayList2.toArray(new com.google.android.exoplayer2.s0[0]))}, 0, new int[0]);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void r(b2.e eVar, long j6, List list, List list2, Map map) {
        boolean z5;
        boolean z6;
        int i6;
        int size = eVar.f2941e.size();
        int[] iArr = new int[size];
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < eVar.f2941e.size(); i9++) {
            com.google.android.exoplayer2.s0 s0Var = ((e.b) eVar.f2941e.get(i9)).f2955b;
            if (s0Var.f4062t > 0 || com.google.android.exoplayer2.util.s0.J(s0Var.f4053k, 2) != null) {
                iArr[i9] = 2;
                i7++;
            } else if (com.google.android.exoplayer2.util.s0.J(s0Var.f4053k, 1) != null) {
                iArr[i9] = 1;
                i8++;
            } else {
                iArr[i9] = -1;
            }
        }
        if (i7 > 0) {
            size = i7;
            z5 = true;
        } else if (i8 < size) {
            size -= i8;
            z5 = false;
            z6 = true;
            Uri[] uriArr = new Uri[size];
            com.google.android.exoplayer2.s0[] s0VarArr = new com.google.android.exoplayer2.s0[size];
            int[] iArr2 = new int[size];
            int i10 = 0;
            for (i6 = 0; i6 < eVar.f2941e.size(); i6++) {
                if ((!z5 || iArr[i6] == 2) && (!z6 || iArr[i6] != 1)) {
                    e.b bVar = (e.b) eVar.f2941e.get(i6);
                    uriArr[i10] = bVar.f2954a;
                    s0VarArr[i10] = bVar.f2955b;
                    iArr2[i10] = i6;
                    i10++;
                }
            }
            String str = s0VarArr[0].f4053k;
            q w5 = w(0, uriArr, s0VarArr, eVar.f2946j, eVar.f2947k, map, j6);
            list.add(w5);
            list2.add(iArr2);
            if (this.f4321o || str == null) {
            }
            boolean z7 = com.google.android.exoplayer2.util.s0.J(str, 2) != null;
            boolean z8 = com.google.android.exoplayer2.util.s0.J(str, 1) != null;
            ArrayList arrayList = new ArrayList();
            if (z7) {
                com.google.android.exoplayer2.s0[] s0VarArr2 = new com.google.android.exoplayer2.s0[size];
                for (int i11 = 0; i11 < size; i11++) {
                    s0VarArr2[i11] = z(s0VarArr[i11]);
                }
                arrayList.add(new x0(s0VarArr2));
                if (z8 && (eVar.f2946j != null || eVar.f2943g.isEmpty())) {
                    arrayList.add(new x0(x(s0VarArr[0], eVar.f2946j, false)));
                }
                List list3 = eVar.f2947k;
                if (list3 != null) {
                    for (int i12 = 0; i12 < list3.size(); i12++) {
                        arrayList.add(new x0((com.google.android.exoplayer2.s0) list3.get(i12)));
                    }
                }
            } else if (!z8) {
                throw new IllegalArgumentException(str.length() != 0 ? "Unexpected codecs attribute: ".concat(str) : new String("Unexpected codecs attribute: "));
            } else {
                com.google.android.exoplayer2.s0[] s0VarArr3 = new com.google.android.exoplayer2.s0[size];
                for (int i13 = 0; i13 < size; i13++) {
                    s0VarArr3[i13] = x(s0VarArr[i13], eVar.f2946j, true);
                }
                arrayList.add(new x0(s0VarArr3));
            }
            x0 x0Var = new x0(new s0.b().S("ID3").e0("application/id3").E());
            arrayList.add(x0Var);
            w5.b0((x0[]) arrayList.toArray(new x0[0]), 0, arrayList.indexOf(x0Var));
            return;
        } else {
            z5 = false;
        }
        z6 = false;
        Uri[] uriArr2 = new Uri[size];
        com.google.android.exoplayer2.s0[] s0VarArr4 = new com.google.android.exoplayer2.s0[size];
        int[] iArr22 = new int[size];
        int i102 = 0;
        while (i6 < eVar.f2941e.size()) {
        }
        String str2 = s0VarArr4[0].f4053k;
        q w52 = w(0, uriArr2, s0VarArr4, eVar.f2946j, eVar.f2947k, map, j6);
        list.add(w52);
        list2.add(iArr22);
        if (this.f4321o) {
        }
    }

    private void v(long j6) {
        b2.e eVar = (b2.e) com.google.android.exoplayer2.util.a.e(this.f4310b.c());
        Map y5 = this.f4323q ? y(eVar.f2949m) : Collections.emptyMap();
        boolean z5 = !eVar.f2941e.isEmpty();
        List list = eVar.f2943g;
        List list2 = eVar.f2944h;
        this.f4325s = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z5) {
            r(eVar, j6, arrayList, arrayList2, y5);
        }
        p(j6, list, arrayList, arrayList2, y5);
        int i6 = 0;
        while (i6 < list2.size()) {
            e.a aVar = (e.a) list2.get(i6);
            int i7 = i6;
            q w5 = w(3, new Uri[]{aVar.f2950a}, new com.google.android.exoplayer2.s0[]{aVar.f2951b}, null, Collections.emptyList(), y5, j6);
            arrayList2.add(new int[]{i7});
            arrayList.add(w5);
            w5.b0(new x0[]{new x0(aVar.f2951b)}, 0, new int[0]);
            i6 = i7 + 1;
        }
        this.f4327u = (q[]) arrayList.toArray(new q[0]);
        this.f4329w = (int[][]) arrayList2.toArray(new int[0]);
        q[] qVarArr = this.f4327u;
        this.f4325s = qVarArr.length;
        qVarArr[0].k0(true);
        for (q qVar : this.f4327u) {
            qVar.B();
        }
        this.f4328v = this.f4327u;
    }

    private q w(int i6, Uri[] uriArr, com.google.android.exoplayer2.s0[] s0VarArr, com.google.android.exoplayer2.s0 s0Var, List list, Map map, long j6) {
        return new q(i6, this, new f(this.f4309a, this.f4310b, uriArr, s0VarArr, this.f4311c, this.f4312d, this.f4319m, list), map, this.f4317k, j6, s0Var, this.f4313e, this.f4314f, this.f4315g, this.f4316h, this.f4322p);
    }

    private static com.google.android.exoplayer2.s0 x(com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.s0 s0Var2, boolean z5) {
        String J;
        n1.a aVar;
        int i6;
        String str;
        String str2;
        int i7;
        int i8;
        if (s0Var2 != null) {
            J = s0Var2.f4053k;
            aVar = s0Var2.f4054l;
            i7 = s0Var2.A;
            i6 = s0Var2.f4048d;
            i8 = s0Var2.f4049e;
            str = s0Var2.f4047c;
            str2 = s0Var2.f4046b;
        } else {
            J = com.google.android.exoplayer2.util.s0.J(s0Var.f4053k, 1);
            aVar = s0Var.f4054l;
            if (z5) {
                i7 = s0Var.A;
                i6 = s0Var.f4048d;
                i8 = s0Var.f4049e;
                str = s0Var.f4047c;
                str2 = s0Var.f4046b;
            } else {
                i6 = 0;
                str = null;
                str2 = null;
                i7 = -1;
                i8 = 0;
            }
        }
        return new s0.b().S(s0Var.f4045a).U(str2).K(s0Var.f4055m).e0(com.google.android.exoplayer2.util.q.e(J)).I(J).X(aVar).G(z5 ? s0Var.f4050f : -1).Z(z5 ? s0Var.f4051g : -1).H(i7).g0(i6).c0(i8).V(str).E();
    }

    private static Map y(List list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i6 = 0;
        while (i6 < arrayList.size()) {
            com.google.android.exoplayer2.drm.k kVar = (com.google.android.exoplayer2.drm.k) list.get(i6);
            String str = kVar.f3703c;
            i6++;
            int i7 = i6;
            while (i7 < arrayList.size()) {
                com.google.android.exoplayer2.drm.k kVar2 = (com.google.android.exoplayer2.drm.k) arrayList.get(i7);
                if (TextUtils.equals(kVar2.f3703c, str)) {
                    kVar = kVar.j(kVar2);
                    arrayList.remove(i7);
                } else {
                    i7++;
                }
            }
            hashMap.put(str, kVar);
        }
        return hashMap;
    }

    private static com.google.android.exoplayer2.s0 z(com.google.android.exoplayer2.s0 s0Var) {
        String J = com.google.android.exoplayer2.util.s0.J(s0Var.f4053k, 2);
        return new s0.b().S(s0Var.f4045a).U(s0Var.f4046b).K(s0Var.f4055m).e0(com.google.android.exoplayer2.util.q.e(J)).I(J).X(s0Var.f4054l).G(s0Var.f4050f).Z(s0Var.f4051g).j0(s0Var.f4061s).Q(s0Var.f4062t).P(s0Var.f4063u).g0(s0Var.f4048d).c0(s0Var.f4049e).E();
    }

    @Override // w1.s0.a
    /* renamed from: A */
    public void j(q qVar) {
        this.f4324r.j(this);
    }

    public void B() {
        this.f4310b.b(this);
        for (q qVar : this.f4327u) {
            qVar.d0();
        }
        this.f4324r = null;
    }

    @Override // w1.t, w1.s0
    public boolean a() {
        return this.f4330x.a();
    }

    @Override // com.google.android.exoplayer2.source.hls.q.b
    public void b() {
        q[] qVarArr;
        int i6 = this.f4325s - 1;
        this.f4325s = i6;
        if (i6 > 0) {
            return;
        }
        int i7 = 0;
        for (q qVar : this.f4327u) {
            i7 += qVar.n().f14101a;
        }
        x0[] x0VarArr = new x0[i7];
        int i8 = 0;
        for (q qVar2 : this.f4327u) {
            int i9 = qVar2.n().f14101a;
            int i10 = 0;
            while (i10 < i9) {
                x0VarArr[i8] = qVar2.n().e(i10);
                i10++;
                i8++;
            }
        }
        this.f4326t = new y0(x0VarArr);
        this.f4324r.g(this);
    }

    @Override // w1.t
    public long c(long j6, s1 s1Var) {
        return j6;
    }

    @Override // w1.t, w1.s0
    public long d() {
        return this.f4330x.d();
    }

    @Override // b2.j.b
    public void e() {
        this.f4324r.j(this);
    }

    @Override // w1.t, w1.s0
    public long f() {
        return this.f4330x.f();
    }

    @Override // w1.t, w1.s0
    public boolean h(long j6) {
        if (this.f4326t == null) {
            for (q qVar : this.f4327u) {
                qVar.B();
            }
            return false;
        }
        return this.f4330x.h(j6);
    }

    @Override // w1.t, w1.s0
    public void i(long j6) {
        this.f4330x.i(j6);
    }

    @Override // b2.j.b
    public boolean k(Uri uri, long j6) {
        boolean z5 = true;
        for (q qVar : this.f4327u) {
            z5 &= qVar.Z(uri, j6);
        }
        this.f4324r.j(this);
        return z5;
    }

    @Override // w1.t
    public long l() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.hls.q.b
    public void m(Uri uri) {
        this.f4310b.g(uri);
    }

    @Override // w1.t
    public y0 n() {
        return (y0) com.google.android.exoplayer2.util.a.e(this.f4326t);
    }

    @Override // w1.t
    public void o(t.a aVar, long j6) {
        this.f4324r = aVar;
        this.f4310b.h(this);
        v(j6);
    }

    @Override // w1.t
    public long q(o2.j[] jVarArr, boolean[] zArr, r0[] r0VarArr, boolean[] zArr2, long j6) {
        r0[] r0VarArr2 = r0VarArr;
        int[] iArr = new int[jVarArr.length];
        int[] iArr2 = new int[jVarArr.length];
        for (int i6 = 0; i6 < jVarArr.length; i6++) {
            r0 r0Var = r0VarArr2[i6];
            iArr[i6] = r0Var == null ? -1 : ((Integer) this.f4318l.get(r0Var)).intValue();
            iArr2[i6] = -1;
            o2.j jVar = jVarArr[i6];
            if (jVar != null) {
                x0 k6 = jVar.k();
                int i7 = 0;
                while (true) {
                    q[] qVarArr = this.f4327u;
                    if (i7 >= qVarArr.length) {
                        break;
                    } else if (qVarArr[i7].n().f(k6) != -1) {
                        iArr2[i6] = i7;
                        break;
                    } else {
                        i7++;
                    }
                }
            }
        }
        this.f4318l.clear();
        int length = jVarArr.length;
        r0[] r0VarArr3 = new r0[length];
        r0[] r0VarArr4 = new r0[jVarArr.length];
        o2.j[] jVarArr2 = new o2.j[jVarArr.length];
        q[] qVarArr2 = new q[this.f4327u.length];
        int i8 = 0;
        int i9 = 0;
        boolean z5 = false;
        while (i9 < this.f4327u.length) {
            for (int i10 = 0; i10 < jVarArr.length; i10++) {
                o2.j jVar2 = null;
                r0VarArr4[i10] = iArr[i10] == i9 ? r0VarArr2[i10] : null;
                if (iArr2[i10] == i9) {
                    jVar2 = jVarArr[i10];
                }
                jVarArr2[i10] = jVar2;
            }
            q qVar = this.f4327u[i9];
            int i11 = i8;
            int i12 = length;
            int i13 = i9;
            o2.j[] jVarArr3 = jVarArr2;
            q[] qVarArr3 = qVarArr2;
            boolean h02 = qVar.h0(jVarArr2, zArr, r0VarArr4, zArr2, j6, z5);
            int i14 = 0;
            boolean z6 = false;
            while (true) {
                if (i14 >= jVarArr.length) {
                    break;
                }
                r0 r0Var2 = r0VarArr4[i14];
                if (iArr2[i14] == i13) {
                    com.google.android.exoplayer2.util.a.e(r0Var2);
                    r0VarArr3[i14] = r0Var2;
                    this.f4318l.put(r0Var2, Integer.valueOf(i13));
                    z6 = true;
                } else if (iArr[i14] == i13) {
                    com.google.android.exoplayer2.util.a.g(r0Var2 == null);
                }
                i14++;
            }
            if (z6) {
                qVarArr3[i11] = qVar;
                i8 = i11 + 1;
                if (i11 == 0) {
                    qVar.k0(true);
                    if (!h02) {
                        q[] qVarArr4 = this.f4328v;
                        if (qVarArr4.length != 0) {
                            if (qVar == qVarArr4[0]) {
                            }
                            this.f4319m.b();
                            z5 = true;
                        }
                    }
                    this.f4319m.b();
                    z5 = true;
                } else {
                    qVar.k0(false);
                }
            } else {
                i8 = i11;
            }
            i9 = i13 + 1;
            r0VarArr2 = r0VarArr;
            qVarArr2 = qVarArr3;
            length = i12;
            jVarArr2 = jVarArr3;
        }
        System.arraycopy(r0VarArr3, 0, r0VarArr2, 0, length);
        q[] qVarArr5 = (q[]) com.google.android.exoplayer2.util.s0.y0(qVarArr2, i8);
        this.f4328v = qVarArr5;
        this.f4330x = this.f4320n.a(qVarArr5);
        return j6;
    }

    @Override // w1.t
    public void s() {
        for (q qVar : this.f4327u) {
            qVar.s();
        }
    }

    @Override // w1.t
    public void t(long j6, boolean z5) {
        for (q qVar : this.f4328v) {
            qVar.t(j6, z5);
        }
    }

    @Override // w1.t
    public long u(long j6) {
        q[] qVarArr = this.f4328v;
        if (qVarArr.length > 0) {
            boolean g02 = qVarArr[0].g0(j6, false);
            int i6 = 1;
            while (true) {
                q[] qVarArr2 = this.f4328v;
                if (i6 >= qVarArr2.length) {
                    break;
                }
                qVarArr2[i6].g0(j6, g02);
                i6++;
            }
            if (g02) {
                this.f4319m.b();
            }
        }
        return j6;
    }
}
