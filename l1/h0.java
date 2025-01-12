package l1;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import c1.x;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.util.s0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import l1.i0;
import okio.Segment;
/* loaded from: classes.dex */
public final class h0 implements c1.i {

    /* renamed from: t  reason: collision with root package name */
    public static final c1.o f11505t = new c1.o() { // from class: l1.g0
        @Override // c1.o
        public final c1.i[] a() {
            c1.i[] x5;
            x5 = h0.x();
            return x5;
        }

        @Override // c1.o
        public /* synthetic */ c1.i[] b(Uri uri, Map map) {
            return c1.n.a(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f11506a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11507b;

    /* renamed from: c  reason: collision with root package name */
    private final List f11508c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11509d;

    /* renamed from: e  reason: collision with root package name */
    private final SparseIntArray f11510e;

    /* renamed from: f  reason: collision with root package name */
    private final i0.c f11511f;

    /* renamed from: g  reason: collision with root package name */
    private final SparseArray f11512g;

    /* renamed from: h  reason: collision with root package name */
    private final SparseBooleanArray f11513h;

    /* renamed from: i  reason: collision with root package name */
    private final SparseBooleanArray f11514i;

    /* renamed from: j  reason: collision with root package name */
    private final f0 f11515j;

    /* renamed from: k  reason: collision with root package name */
    private e0 f11516k;

    /* renamed from: l  reason: collision with root package name */
    private c1.k f11517l;

    /* renamed from: m  reason: collision with root package name */
    private int f11518m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f11519n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f11520o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f11521p;

    /* renamed from: q  reason: collision with root package name */
    private i0 f11522q;

    /* renamed from: r  reason: collision with root package name */
    private int f11523r;

    /* renamed from: s  reason: collision with root package name */
    private int f11524s;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements b0 {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.x f11525a = new com.google.android.exoplayer2.util.x(new byte[4]);

        public a() {
        }

        @Override // l1.b0
        public void b(com.google.android.exoplayer2.util.k0 k0Var, c1.k kVar, i0.d dVar) {
        }

        @Override // l1.b0
        public void c(com.google.android.exoplayer2.util.y yVar) {
            if (yVar.A() == 0 && (yVar.A() & 128) != 0) {
                yVar.N(6);
                int a6 = yVar.a() / 4;
                for (int i6 = 0; i6 < a6; i6++) {
                    yVar.h(this.f11525a, 4);
                    int h6 = this.f11525a.h(16);
                    this.f11525a.r(3);
                    if (h6 == 0) {
                        this.f11525a.r(13);
                    } else {
                        int h7 = this.f11525a.h(13);
                        if (h0.this.f11512g.get(h7) == null) {
                            h0.this.f11512g.put(h7, new c0(new b(h7)));
                            h0.l(h0.this);
                        }
                    }
                }
                if (h0.this.f11506a != 2) {
                    h0.this.f11512g.remove(0);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private class b implements b0 {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.x f11527a = new com.google.android.exoplayer2.util.x(new byte[5]);

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray f11528b = new SparseArray();

        /* renamed from: c  reason: collision with root package name */
        private final SparseIntArray f11529c = new SparseIntArray();

        /* renamed from: d  reason: collision with root package name */
        private final int f11530d;

        public b(int i6) {
            this.f11530d = i6;
        }

        private i0.b a(com.google.android.exoplayer2.util.y yVar, int i6) {
            int d6 = yVar.d();
            int i7 = i6 + d6;
            int i8 = -1;
            String str = null;
            ArrayList arrayList = null;
            while (yVar.d() < i7) {
                int A = yVar.A();
                int d7 = yVar.d() + yVar.A();
                if (d7 > i7) {
                    break;
                }
                if (A == 5) {
                    long C = yVar.C();
                    if (C != 1094921523) {
                        if (C != 1161904947) {
                            if (C != 1094921524) {
                                if (C == 1212503619) {
                                    i8 = 36;
                                }
                            }
                            i8 = 172;
                        }
                        i8 = 135;
                    }
                    i8 = 129;
                } else {
                    if (A != 106) {
                        if (A != 122) {
                            if (A == 127) {
                                if (yVar.A() != 21) {
                                }
                                i8 = 172;
                            } else if (A == 123) {
                                i8 = 138;
                            } else if (A == 10) {
                                str = yVar.x(3).trim();
                            } else if (A == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (yVar.d() < d7) {
                                    String trim = yVar.x(3).trim();
                                    int A2 = yVar.A();
                                    byte[] bArr = new byte[4];
                                    yVar.i(bArr, 0, 4);
                                    arrayList2.add(new i0.a(trim, A2, bArr));
                                }
                                arrayList = arrayList2;
                                i8 = 89;
                            } else if (A == 111) {
                                i8 = 257;
                            }
                        }
                        i8 = 135;
                    }
                    i8 = 129;
                }
                yVar.N(d7 - yVar.d());
            }
            yVar.M(i7);
            return new i0.b(i8, str, arrayList, Arrays.copyOfRange(yVar.c(), d6, i7));
        }

        @Override // l1.b0
        public void b(com.google.android.exoplayer2.util.k0 k0Var, c1.k kVar, i0.d dVar) {
        }

        @Override // l1.b0
        public void c(com.google.android.exoplayer2.util.y yVar) {
            com.google.android.exoplayer2.util.k0 k0Var;
            if (yVar.A() != 2) {
                return;
            }
            if (h0.this.f11506a == 1 || h0.this.f11506a == 2 || h0.this.f11518m == 1) {
                k0Var = (com.google.android.exoplayer2.util.k0) h0.this.f11508c.get(0);
            } else {
                k0Var = new com.google.android.exoplayer2.util.k0(((com.google.android.exoplayer2.util.k0) h0.this.f11508c.get(0)).c());
                h0.this.f11508c.add(k0Var);
            }
            if ((yVar.A() & 128) == 0) {
                return;
            }
            yVar.N(1);
            int G = yVar.G();
            int i6 = 3;
            yVar.N(3);
            yVar.h(this.f11527a, 2);
            this.f11527a.r(3);
            int i7 = 13;
            h0.this.f11524s = this.f11527a.h(13);
            yVar.h(this.f11527a, 2);
            int i8 = 4;
            this.f11527a.r(4);
            yVar.N(this.f11527a.h(12));
            if (h0.this.f11506a == 2 && h0.this.f11522q == null) {
                i0.b bVar = new i0.b(21, null, null, s0.f4678f);
                h0 h0Var = h0.this;
                h0Var.f11522q = h0Var.f11511f.b(21, bVar);
                h0.this.f11522q.b(k0Var, h0.this.f11517l, new i0.d(G, 21, Segment.SIZE));
            }
            this.f11528b.clear();
            this.f11529c.clear();
            int a6 = yVar.a();
            while (a6 > 0) {
                yVar.h(this.f11527a, 5);
                int h6 = this.f11527a.h(8);
                this.f11527a.r(i6);
                int h7 = this.f11527a.h(i7);
                this.f11527a.r(i8);
                int h8 = this.f11527a.h(12);
                i0.b a7 = a(yVar, h8);
                if (h6 == 6 || h6 == 5) {
                    h6 = a7.f11557a;
                }
                a6 -= h8 + 5;
                int i9 = h0.this.f11506a == 2 ? h6 : h7;
                if (!h0.this.f11513h.get(i9)) {
                    i0 b6 = (h0.this.f11506a == 2 && h6 == 21) ? h0.this.f11522q : h0.this.f11511f.b(h6, a7);
                    if (h0.this.f11506a != 2 || h7 < this.f11529c.get(i9, Segment.SIZE)) {
                        this.f11529c.put(i9, h7);
                        this.f11528b.put(i9, b6);
                    }
                }
                i6 = 3;
                i8 = 4;
                i7 = 13;
            }
            int size = this.f11529c.size();
            for (int i10 = 0; i10 < size; i10++) {
                int keyAt = this.f11529c.keyAt(i10);
                int valueAt = this.f11529c.valueAt(i10);
                h0.this.f11513h.put(keyAt, true);
                h0.this.f11514i.put(valueAt, true);
                i0 i0Var = (i0) this.f11528b.valueAt(i10);
                if (i0Var != null) {
                    if (i0Var != h0.this.f11522q) {
                        i0Var.b(k0Var, h0.this.f11517l, new i0.d(G, keyAt, Segment.SIZE));
                    }
                    h0.this.f11512g.put(valueAt, i0Var);
                }
            }
            if (h0.this.f11506a != 2) {
                h0.this.f11512g.remove(this.f11530d);
                h0 h0Var2 = h0.this;
                h0Var2.f11518m = h0Var2.f11506a == 1 ? 0 : h0.this.f11518m - 1;
                if (h0.this.f11518m != 0) {
                    return;
                }
                h0.this.f11517l.g();
            } else if (h0.this.f11519n) {
                return;
            } else {
                h0.this.f11517l.g();
                h0.this.f11518m = 0;
            }
            h0.this.f11519n = true;
        }
    }

    public h0() {
        this(0);
    }

    private boolean A(int i6) {
        return this.f11506a == 2 || this.f11519n || !this.f11514i.get(i6, false);
    }

    static /* synthetic */ int l(h0 h0Var) {
        int i6 = h0Var.f11518m;
        h0Var.f11518m = i6 + 1;
        return i6;
    }

    private boolean v(c1.j jVar) {
        byte[] c6 = this.f11509d.c();
        if (9400 - this.f11509d.d() < 188) {
            int a6 = this.f11509d.a();
            if (a6 > 0) {
                System.arraycopy(c6, this.f11509d.d(), c6, 0, a6);
            }
            this.f11509d.K(c6, a6);
        }
        while (this.f11509d.a() < 188) {
            int e6 = this.f11509d.e();
            int read = jVar.read(c6, e6, 9400 - e6);
            if (read == -1) {
                return false;
            }
            this.f11509d.L(e6 + read);
        }
        return true;
    }

    private int w() {
        int d6 = this.f11509d.d();
        int e6 = this.f11509d.e();
        int a6 = j0.a(this.f11509d.c(), d6, e6);
        this.f11509d.M(a6);
        int i6 = a6 + 188;
        if (i6 > e6) {
            int i7 = this.f11523r + (a6 - d6);
            this.f11523r = i7;
            if (this.f11506a == 2 && i7 > 376) {
                throw new f1("Cannot find sync byte. Most likely not a Transport Stream.");
            }
        } else {
            this.f11523r = 0;
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c1.i[] x() {
        return new c1.i[]{new h0()};
    }

    private void y(long j6) {
        c1.k kVar;
        c1.x bVar;
        if (this.f11520o) {
            return;
        }
        this.f11520o = true;
        if (this.f11515j.b() != -9223372036854775807L) {
            e0 e0Var = new e0(this.f11515j.c(), this.f11515j.b(), j6, this.f11524s, this.f11507b);
            this.f11516k = e0Var;
            kVar = this.f11517l;
            bVar = e0Var.b();
        } else {
            kVar = this.f11517l;
            bVar = new x.b(this.f11515j.b());
        }
        kVar.r(bVar);
    }

    private void z() {
        this.f11513h.clear();
        this.f11512g.clear();
        SparseArray a6 = this.f11511f.a();
        int size = a6.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f11512g.put(a6.keyAt(i6), (i0) a6.valueAt(i6));
        }
        this.f11512g.put(0, new c0(new a()));
        this.f11522q = null;
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(c1.k kVar) {
        this.f11517l = kVar;
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        e0 e0Var;
        com.google.android.exoplayer2.util.a.g(this.f11506a != 2);
        int size = this.f11508c.size();
        for (int i6 = 0; i6 < size; i6++) {
            com.google.android.exoplayer2.util.k0 k0Var = (com.google.android.exoplayer2.util.k0) this.f11508c.get(i6);
            if ((k0Var.e() == -9223372036854775807L) || (k0Var.e() != 0 && k0Var.c() != j7)) {
                k0Var.g();
                k0Var.h(j7);
            }
        }
        if (j7 != 0 && (e0Var = this.f11516k) != null) {
            e0Var.h(j7);
        }
        this.f11509d.I(0);
        this.f11510e.clear();
        for (int i7 = 0; i7 < this.f11512g.size(); i7++) {
            ((i0) this.f11512g.valueAt(i7)).a();
        }
        this.f11523r = 0;
    }

    @Override // c1.i
    public int g(c1.j jVar, c1.w wVar) {
        long a6 = jVar.a();
        if (this.f11519n) {
            if (((a6 == -1 || this.f11506a == 2) ? false : true) && !this.f11515j.d()) {
                return this.f11515j.e(jVar, wVar, this.f11524s);
            }
            y(a6);
            if (this.f11521p) {
                this.f11521p = false;
                d(0L, 0L);
                if (jVar.p() != 0) {
                    wVar.f3247a = 0L;
                    return 1;
                }
            }
            e0 e0Var = this.f11516k;
            if (e0Var != null && e0Var.d()) {
                return this.f11516k.c(jVar, wVar);
            }
        }
        if (v(jVar)) {
            int w5 = w();
            int e6 = this.f11509d.e();
            if (w5 > e6) {
                return 0;
            }
            int k6 = this.f11509d.k();
            if ((8388608 & k6) == 0) {
                int i6 = ((4194304 & k6) != 0 ? 1 : 0) | 0;
                int i7 = (2096896 & k6) >> 8;
                boolean z5 = (k6 & 32) != 0;
                i0 i0Var = (k6 & 16) != 0 ? (i0) this.f11512g.get(i7) : null;
                if (i0Var != null) {
                    if (this.f11506a != 2) {
                        int i8 = k6 & 15;
                        int i9 = this.f11510e.get(i7, i8 - 1);
                        this.f11510e.put(i7, i8);
                        if (i9 != i8) {
                            if (i8 != ((i9 + 1) & 15)) {
                                i0Var.a();
                            }
                        }
                    }
                    if (z5) {
                        int A = this.f11509d.A();
                        i6 |= (this.f11509d.A() & 64) != 0 ? 2 : 0;
                        this.f11509d.N(A - 1);
                    }
                    boolean z6 = this.f11519n;
                    if (A(i7)) {
                        this.f11509d.L(w5);
                        i0Var.c(this.f11509d, i6);
                        this.f11509d.L(e6);
                    }
                    if (this.f11506a != 2 && !z6 && this.f11519n && a6 != -1) {
                        this.f11521p = true;
                    }
                }
            }
            this.f11509d.M(w5);
            return 0;
        }
        return -1;
    }

    @Override // c1.i
    public boolean h(c1.j jVar) {
        boolean z5;
        byte[] c6 = this.f11509d.c();
        jVar.n(c6, 0, 940);
        for (int i6 = 0; i6 < 188; i6++) {
            int i7 = 0;
            while (true) {
                if (i7 >= 5) {
                    z5 = true;
                    break;
                } else if (c6[(i7 * 188) + i6] != 71) {
                    z5 = false;
                    break;
                } else {
                    i7++;
                }
            }
            if (z5) {
                jVar.h(i6);
                return true;
            }
        }
        return false;
    }

    public h0(int i6) {
        this(1, i6, 112800);
    }

    public h0(int i6, int i7, int i8) {
        this(i6, new com.google.android.exoplayer2.util.k0(0L), new j(i7), i8);
    }

    public h0(int i6, com.google.android.exoplayer2.util.k0 k0Var, i0.c cVar) {
        this(i6, k0Var, cVar, 112800);
    }

    public h0(int i6, com.google.android.exoplayer2.util.k0 k0Var, i0.c cVar, int i7) {
        this.f11511f = (i0.c) com.google.android.exoplayer2.util.a.e(cVar);
        this.f11507b = i7;
        this.f11506a = i6;
        if (i6 == 1 || i6 == 2) {
            this.f11508c = Collections.singletonList(k0Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f11508c = arrayList;
            arrayList.add(k0Var);
        }
        this.f11509d = new com.google.android.exoplayer2.util.y(new byte[9400], 0);
        this.f11513h = new SparseBooleanArray();
        this.f11514i = new SparseBooleanArray();
        this.f11512g = new SparseArray();
        this.f11510e = new SparseIntArray();
        this.f11515j = new f0(i7);
        this.f11524s = -1;
        z();
    }
}
