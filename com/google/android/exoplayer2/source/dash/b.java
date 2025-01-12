package com.google.android.exoplayer2.source.dash;

import a2.f;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.s1;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o2.j;
import q2.c0;
import q2.e0;
import q2.i0;
import w1.e0;
import w1.i;
import w1.l;
import w1.r0;
import w1.s0;
import w1.t;
import w1.x0;
import w1.y0;
import y1.h;
/* loaded from: classes.dex */
final class b implements t, s0.a, h.b {

    /* renamed from: y  reason: collision with root package name */
    private static final Pattern f4149y = Pattern.compile("CC([1-4])=(.+)");

    /* renamed from: z  reason: collision with root package name */
    private static final Pattern f4150z = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");

    /* renamed from: a  reason: collision with root package name */
    final int f4151a;

    /* renamed from: b  reason: collision with root package name */
    private final a.InterfaceC0040a f4152b;

    /* renamed from: c  reason: collision with root package name */
    private final i0 f4153c;

    /* renamed from: d  reason: collision with root package name */
    private final v f4154d;

    /* renamed from: e  reason: collision with root package name */
    private final c0 f4155e;

    /* renamed from: f  reason: collision with root package name */
    private final long f4156f;

    /* renamed from: g  reason: collision with root package name */
    private final e0 f4157g;

    /* renamed from: h  reason: collision with root package name */
    private final q2.b f4158h;

    /* renamed from: k  reason: collision with root package name */
    private final y0 f4159k;

    /* renamed from: l  reason: collision with root package name */
    private final a[] f4160l;

    /* renamed from: m  reason: collision with root package name */
    private final i f4161m;

    /* renamed from: n  reason: collision with root package name */
    private final e f4162n;

    /* renamed from: p  reason: collision with root package name */
    private final e0.a f4164p;

    /* renamed from: q  reason: collision with root package name */
    private final t.a f4165q;

    /* renamed from: r  reason: collision with root package name */
    private t.a f4166r;

    /* renamed from: u  reason: collision with root package name */
    private s0 f4169u;

    /* renamed from: v  reason: collision with root package name */
    private a2.b f4170v;

    /* renamed from: w  reason: collision with root package name */
    private int f4171w;

    /* renamed from: x  reason: collision with root package name */
    private List f4172x;

    /* renamed from: s  reason: collision with root package name */
    private h[] f4167s = F(0);

    /* renamed from: t  reason: collision with root package name */
    private d[] f4168t = new d[0];

    /* renamed from: o  reason: collision with root package name */
    private final IdentityHashMap f4163o = new IdentityHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f4173a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4174b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4175c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4176d;

        /* renamed from: e  reason: collision with root package name */
        public final int f4177e;

        /* renamed from: f  reason: collision with root package name */
        public final int f4178f;

        /* renamed from: g  reason: collision with root package name */
        public final int f4179g;

        private a(int i6, int i7, int[] iArr, int i8, int i9, int i10, int i11) {
            this.f4174b = i6;
            this.f4173a = iArr;
            this.f4175c = i7;
            this.f4177e = i8;
            this.f4178f = i9;
            this.f4179g = i10;
            this.f4176d = i11;
        }

        public static a a(int[] iArr, int i6) {
            return new a(3, 1, iArr, i6, -1, -1, -1);
        }

        public static a b(int[] iArr, int i6) {
            return new a(4, 1, iArr, i6, -1, -1, -1);
        }

        public static a c(int i6) {
            return new a(4, 2, new int[0], -1, -1, -1, i6);
        }

        public static a d(int i6, int[] iArr, int i7, int i8, int i9) {
            return new a(i6, 0, iArr, i7, i8, i9, -1);
        }
    }

    public b(int i6, a2.b bVar, int i7, a.InterfaceC0040a interfaceC0040a, i0 i0Var, v vVar, t.a aVar, c0 c0Var, e0.a aVar2, long j6, q2.e0 e0Var, q2.b bVar2, i iVar, e.b bVar3) {
        this.f4151a = i6;
        this.f4170v = bVar;
        this.f4171w = i7;
        this.f4152b = interfaceC0040a;
        this.f4153c = i0Var;
        this.f4154d = vVar;
        this.f4165q = aVar;
        this.f4155e = c0Var;
        this.f4164p = aVar2;
        this.f4156f = j6;
        this.f4157g = e0Var;
        this.f4158h = bVar2;
        this.f4161m = iVar;
        this.f4162n = new e(bVar, bVar3, bVar2);
        this.f4169u = iVar.a(this.f4167s);
        f d6 = bVar.d(i7);
        List list = d6.f86d;
        this.f4172x = list;
        Pair v5 = v(vVar, d6.f85c, list);
        this.f4159k = (y0) v5.first;
        this.f4160l = (a[]) v5.second;
    }

    private static int[][] A(List list) {
        int i6;
        a2.d w5;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i7 = 0; i7 < size; i7++) {
            sparseIntArray.put(((a2.a) list.get(i7)).f45a, i7);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i7));
            arrayList.add(arrayList2);
            sparseArray.put(i7, arrayList2);
        }
        for (int i8 = 0; i8 < size; i8++) {
            a2.a aVar = (a2.a) list.get(i8);
            a2.d y5 = y(aVar.f49e);
            if (y5 == null) {
                y5 = y(aVar.f50f);
            }
            if (y5 == null || (i6 = sparseIntArray.get(Integer.parseInt(y5.f76b), -1)) == -1) {
                i6 = i8;
            }
            if (i6 == i8 && (w5 = w(aVar.f50f)) != null) {
                for (String str : com.google.android.exoplayer2.util.s0.K0(w5.f76b, ",")) {
                    int i9 = sparseIntArray.get(Integer.parseInt(str), -1);
                    if (i9 != -1) {
                        i6 = Math.min(i6, i9);
                    }
                }
            }
            if (i6 != i8) {
                List list2 = (List) sparseArray.get(i8);
                List list3 = (List) sparseArray.get(i6);
                list3.addAll(list2);
                sparseArray.put(i8, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2];
        for (int i10 = 0; i10 < size2; i10++) {
            int[] h6 = com.google.common.primitives.b.h((Collection) arrayList.get(i10));
            iArr[i10] = h6;
            Arrays.sort(h6);
        }
        return iArr;
    }

    private int B(int i6, int[] iArr) {
        int i7 = iArr[i6];
        if (i7 == -1) {
            return -1;
        }
        int i8 = this.f4160l[i7].f4177e;
        for (int i9 = 0; i9 < iArr.length; i9++) {
            int i10 = iArr[i9];
            if (i10 == i8 && this.f4160l[i10].f4175c == 0) {
                return i9;
            }
        }
        return -1;
    }

    private int[] C(j[] jVarArr) {
        int[] iArr = new int[jVarArr.length];
        for (int i6 = 0; i6 < jVarArr.length; i6++) {
            j jVar = jVarArr[i6];
            if (jVar != null) {
                iArr[i6] = this.f4159k.f(jVar.k());
            } else {
                iArr[i6] = -1;
            }
        }
        return iArr;
    }

    private static boolean D(List list, int[] iArr) {
        for (int i6 : iArr) {
            List list2 = ((a2.a) list.get(i6)).f47c;
            for (int i7 = 0; i7 < list2.size(); i7++) {
                if (!((a2.i) list2.get(i7)).f101e.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int E(int i6, List list, int[][] iArr, boolean[] zArr, com.google.android.exoplayer2.s0[][] s0VarArr) {
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            if (D(list, iArr[i8])) {
                zArr[i8] = true;
                i7++;
            }
            com.google.android.exoplayer2.s0[] z5 = z(list, iArr[i8]);
            s0VarArr[i8] = z5;
            if (z5.length != 0) {
                i7++;
            }
        }
        return i7;
    }

    private static h[] F(int i6) {
        return new h[i6];
    }

    private static com.google.android.exoplayer2.s0[] H(a2.d dVar, Pattern pattern, com.google.android.exoplayer2.s0 s0Var) {
        String str = dVar.f76b;
        if (str == null) {
            return new com.google.android.exoplayer2.s0[]{s0Var};
        }
        String[] K0 = com.google.android.exoplayer2.util.s0.K0(str, ";");
        com.google.android.exoplayer2.s0[] s0VarArr = new com.google.android.exoplayer2.s0[K0.length];
        for (int i6 = 0; i6 < K0.length; i6++) {
            Matcher matcher = pattern.matcher(K0[i6]);
            if (!matcher.matches()) {
                return new com.google.android.exoplayer2.s0[]{s0Var};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            s0.b e6 = s0Var.e();
            String str2 = s0Var.f4045a;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 12);
            sb.append(str2);
            sb.append(":");
            sb.append(parseInt);
            s0VarArr[i6] = e6.S(sb.toString()).F(parseInt).V(matcher.group(2)).E();
        }
        return s0VarArr;
    }

    private void J(j[] jVarArr, boolean[] zArr, r0[] r0VarArr) {
        for (int i6 = 0; i6 < jVarArr.length; i6++) {
            if (jVarArr[i6] == null || !zArr[i6]) {
                r0 r0Var = r0VarArr[i6];
                if (r0Var instanceof h) {
                    ((h) r0Var).Q(this);
                } else if (r0Var instanceof h.a) {
                    ((h.a) r0Var).c();
                }
                r0VarArr[i6] = null;
            }
        }
    }

    private void K(j[] jVarArr, r0[] r0VarArr, int[] iArr) {
        boolean z5;
        for (int i6 = 0; i6 < jVarArr.length; i6++) {
            r0 r0Var = r0VarArr[i6];
            if ((r0Var instanceof l) || (r0Var instanceof h.a)) {
                int B = B(i6, iArr);
                if (B == -1) {
                    z5 = r0VarArr[i6] instanceof l;
                } else {
                    r0 r0Var2 = r0VarArr[i6];
                    z5 = (r0Var2 instanceof h.a) && ((h.a) r0Var2).f14314a == r0VarArr[B];
                }
                if (!z5) {
                    r0 r0Var3 = r0VarArr[i6];
                    if (r0Var3 instanceof h.a) {
                        ((h.a) r0Var3).c();
                    }
                    r0VarArr[i6] = null;
                }
            }
        }
    }

    private void L(j[] jVarArr, r0[] r0VarArr, boolean[] zArr, long j6, int[] iArr) {
        for (int i6 = 0; i6 < jVarArr.length; i6++) {
            j jVar = jVarArr[i6];
            if (jVar != null) {
                r0 r0Var = r0VarArr[i6];
                if (r0Var == null) {
                    zArr[i6] = true;
                    a aVar = this.f4160l[iArr[i6]];
                    int i7 = aVar.f4175c;
                    if (i7 == 0) {
                        r0VarArr[i6] = r(aVar, jVar, j6);
                    } else if (i7 == 2) {
                        r0VarArr[i6] = new d((a2.e) this.f4172x.get(aVar.f4176d), jVar.k().e(0), this.f4170v.f54d);
                    }
                } else if (r0Var instanceof h) {
                    ((com.google.android.exoplayer2.source.dash.a) ((h) r0Var).E()).d(jVar);
                }
            }
        }
        for (int i8 = 0; i8 < jVarArr.length; i8++) {
            if (r0VarArr[i8] == null && jVarArr[i8] != null) {
                a aVar2 = this.f4160l[iArr[i8]];
                if (aVar2.f4175c == 1) {
                    int B = B(i8, iArr);
                    if (B == -1) {
                        r0VarArr[i8] = new l();
                    } else {
                        r0VarArr[i8] = ((h) r0VarArr[B]).T(j6, aVar2.f4174b);
                    }
                }
            }
        }
    }

    private static void k(List list, x0[] x0VarArr, a[] aVarArr, int i6) {
        int i7 = 0;
        while (i7 < list.size()) {
            x0VarArr[i6] = new x0(new s0.b().S(((a2.e) list.get(i7)).a()).e0("application/x-emsg").E());
            aVarArr[i6] = a.c(i7);
            i7++;
            i6++;
        }
    }

    private static int p(v vVar, List list, int[][] iArr, int i6, boolean[] zArr, com.google.android.exoplayer2.s0[][] s0VarArr, x0[] x0VarArr, a[] aVarArr) {
        int i7;
        int i8;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i6) {
            int[] iArr2 = iArr[i9];
            ArrayList arrayList = new ArrayList();
            for (int i11 : iArr2) {
                arrayList.addAll(((a2.a) list.get(i11)).f47c);
            }
            int size = arrayList.size();
            com.google.android.exoplayer2.s0[] s0VarArr2 = new com.google.android.exoplayer2.s0[size];
            for (int i12 = 0; i12 < size; i12++) {
                com.google.android.exoplayer2.s0 s0Var = ((a2.i) arrayList.get(i12)).f98b;
                s0VarArr2[i12] = s0Var.f(vVar.d(s0Var));
            }
            a2.a aVar = (a2.a) list.get(iArr2[0]);
            int i13 = i10 + 1;
            if (zArr[i9]) {
                i7 = i13 + 1;
            } else {
                i7 = i13;
                i13 = -1;
            }
            if (s0VarArr[i9].length != 0) {
                i8 = i7 + 1;
            } else {
                i8 = i7;
                i7 = -1;
            }
            x0VarArr[i10] = new x0(s0VarArr2);
            aVarArr[i10] = a.d(aVar.f46b, iArr2, i10, i13, i7);
            if (i13 != -1) {
                s0.b bVar = new s0.b();
                int i14 = aVar.f45a;
                StringBuilder sb = new StringBuilder(16);
                sb.append(i14);
                sb.append(":emsg");
                x0VarArr[i13] = new x0(bVar.S(sb.toString()).e0("application/x-emsg").E());
                aVarArr[i13] = a.b(iArr2, i10);
            }
            if (i7 != -1) {
                x0VarArr[i7] = new x0(s0VarArr[i9]);
                aVarArr[i7] = a.a(iArr2, i10);
            }
            i9++;
            i10 = i8;
        }
        return i10;
    }

    private h r(a aVar, j jVar, long j6) {
        x0 x0Var;
        int i6;
        x0 x0Var2;
        int i7;
        int i8 = aVar.f4178f;
        boolean z5 = i8 != -1;
        e.c cVar = null;
        if (z5) {
            x0Var = this.f4159k.e(i8);
            i6 = 1;
        } else {
            x0Var = null;
            i6 = 0;
        }
        int i9 = aVar.f4179g;
        boolean z6 = i9 != -1;
        if (z6) {
            x0Var2 = this.f4159k.e(i9);
            i6 += x0Var2.f14093a;
        } else {
            x0Var2 = null;
        }
        com.google.android.exoplayer2.s0[] s0VarArr = new com.google.android.exoplayer2.s0[i6];
        int[] iArr = new int[i6];
        if (z5) {
            s0VarArr[0] = x0Var.e(0);
            iArr[0] = 4;
            i7 = 1;
        } else {
            i7 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z6) {
            for (int i10 = 0; i10 < x0Var2.f14093a; i10++) {
                com.google.android.exoplayer2.s0 e6 = x0Var2.e(i10);
                s0VarArr[i7] = e6;
                iArr[i7] = 3;
                arrayList.add(e6);
                i7++;
            }
        }
        if (this.f4170v.f54d && z5) {
            cVar = this.f4162n.k();
        }
        e.c cVar2 = cVar;
        h hVar = new h(aVar.f4174b, iArr, s0VarArr, this.f4152b.a(this.f4157g, this.f4170v, this.f4171w, aVar.f4173a, jVar, aVar.f4174b, this.f4156f, z5, arrayList, cVar2, this.f4153c), this, this.f4158h, j6, this.f4154d, this.f4165q, this.f4155e, this.f4164p);
        synchronized (this) {
            this.f4163o.put(hVar, cVar2);
        }
        return hVar;
    }

    private static Pair v(v vVar, List list, List list2) {
        int[][] A = A(list);
        int length = A.length;
        boolean[] zArr = new boolean[length];
        com.google.android.exoplayer2.s0[][] s0VarArr = new com.google.android.exoplayer2.s0[length];
        int E = E(length, list, A, zArr, s0VarArr) + length + list2.size();
        x0[] x0VarArr = new x0[E];
        a[] aVarArr = new a[E];
        k(list2, x0VarArr, aVarArr, p(vVar, list, A, length, zArr, s0VarArr, x0VarArr, aVarArr));
        return Pair.create(new y0(x0VarArr), aVarArr);
    }

    private static a2.d w(List list) {
        return x(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    private static a2.d x(List list, String str) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            a2.d dVar = (a2.d) list.get(i6);
            if (str.equals(dVar.f75a)) {
                return dVar;
            }
        }
        return null;
    }

    private static a2.d y(List list) {
        return x(list, "http://dashif.org/guidelines/trickmode");
    }

    private static com.google.android.exoplayer2.s0[] z(List list, int[] iArr) {
        com.google.android.exoplayer2.s0 E;
        Pattern pattern;
        for (int i6 : iArr) {
            a2.a aVar = (a2.a) list.get(i6);
            List list2 = ((a2.a) list.get(i6)).f48d;
            for (int i7 = 0; i7 < list2.size(); i7++) {
                a2.d dVar = (a2.d) list2.get(i7);
                if ("urn:scte:dash:cc:cea-608:2015".equals(dVar.f75a)) {
                    s0.b e02 = new s0.b().e0("application/cea-608");
                    int i8 = aVar.f45a;
                    StringBuilder sb = new StringBuilder(18);
                    sb.append(i8);
                    sb.append(":cea608");
                    E = e02.S(sb.toString()).E();
                    pattern = f4149y;
                } else if ("urn:scte:dash:cc:cea-708:2015".equals(dVar.f75a)) {
                    s0.b e03 = new s0.b().e0("application/cea-708");
                    int i9 = aVar.f45a;
                    StringBuilder sb2 = new StringBuilder(18);
                    sb2.append(i9);
                    sb2.append(":cea708");
                    E = e03.S(sb2.toString()).E();
                    pattern = f4150z;
                }
                return H(dVar, pattern, E);
            }
        }
        return new com.google.android.exoplayer2.s0[0];
    }

    @Override // w1.s0.a
    /* renamed from: G */
    public void j(h hVar) {
        this.f4166r.j(this);
    }

    public void I() {
        this.f4162n.n();
        for (h hVar : this.f4167s) {
            hVar.Q(this);
        }
        this.f4166r = null;
    }

    public void M(a2.b bVar, int i6) {
        d[] dVarArr;
        this.f4170v = bVar;
        this.f4171w = i6;
        this.f4162n.p(bVar);
        h[] hVarArr = this.f4167s;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                ((com.google.android.exoplayer2.source.dash.a) hVar.E()).g(bVar, i6);
            }
            this.f4166r.j(this);
        }
        this.f4172x = bVar.d(i6).f86d;
        for (d dVar : this.f4168t) {
            Iterator it = this.f4172x.iterator();
            while (true) {
                if (it.hasNext()) {
                    a2.e eVar = (a2.e) it.next();
                    if (eVar.a().equals(dVar.a())) {
                        boolean z5 = true;
                        dVar.d(eVar, (bVar.f54d && i6 == bVar.e() - 1) ? false : false);
                    }
                }
            }
        }
    }

    @Override // w1.t, w1.s0
    public boolean a() {
        return this.f4169u.a();
    }

    @Override // w1.t
    public long c(long j6, s1 s1Var) {
        h[] hVarArr;
        for (h hVar : this.f4167s) {
            if (hVar.f14291a == 2) {
                return hVar.c(j6, s1Var);
            }
        }
        return j6;
    }

    @Override // w1.t, w1.s0
    public long d() {
        return this.f4169u.d();
    }

    @Override // y1.h.b
    public synchronized void e(h hVar) {
        e.c cVar = (e.c) this.f4163o.remove(hVar);
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // w1.t, w1.s0
    public long f() {
        return this.f4169u.f();
    }

    @Override // w1.t, w1.s0
    public boolean h(long j6) {
        return this.f4169u.h(j6);
    }

    @Override // w1.t, w1.s0
    public void i(long j6) {
        this.f4169u.i(j6);
    }

    @Override // w1.t
    public long l() {
        return -9223372036854775807L;
    }

    @Override // w1.t
    public y0 n() {
        return this.f4159k;
    }

    @Override // w1.t
    public void o(t.a aVar, long j6) {
        this.f4166r = aVar;
        aVar.g(this);
    }

    @Override // w1.t
    public long q(j[] jVarArr, boolean[] zArr, r0[] r0VarArr, boolean[] zArr2, long j6) {
        int[] C = C(jVarArr);
        J(jVarArr, zArr, r0VarArr);
        K(jVarArr, r0VarArr, C);
        L(jVarArr, r0VarArr, zArr2, j6, C);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (r0 r0Var : r0VarArr) {
            if (r0Var instanceof h) {
                arrayList.add((h) r0Var);
            } else if (r0Var instanceof d) {
                arrayList2.add((d) r0Var);
            }
        }
        h[] F = F(arrayList.size());
        this.f4167s = F;
        arrayList.toArray(F);
        d[] dVarArr = new d[arrayList2.size()];
        this.f4168t = dVarArr;
        arrayList2.toArray(dVarArr);
        this.f4169u = this.f4161m.a(this.f4167s);
        return j6;
    }

    @Override // w1.t
    public void s() {
        this.f4157g.b();
    }

    @Override // w1.t
    public void t(long j6, boolean z5) {
        for (h hVar : this.f4167s) {
            hVar.t(j6, z5);
        }
    }

    @Override // w1.t
    public long u(long j6) {
        for (h hVar : this.f4167s) {
            hVar.S(j6);
        }
        for (d dVar : this.f4168t) {
            dVar.c(j6);
        }
        return j6;
    }
}
