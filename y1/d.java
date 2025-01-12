package y1;

import android.util.SparseArray;
import c1.a0;
import c1.w;
import c1.x;
import c1.z;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.y;
import y1.f;
/* loaded from: classes.dex */
public final class d implements c1.k, f {

    /* renamed from: l  reason: collision with root package name */
    private static final w f14263l = new w();

    /* renamed from: a  reason: collision with root package name */
    private final c1.i f14264a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14265b;

    /* renamed from: c  reason: collision with root package name */
    private final s0 f14266c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray f14267d = new SparseArray();

    /* renamed from: e  reason: collision with root package name */
    private boolean f14268e;

    /* renamed from: f  reason: collision with root package name */
    private f.a f14269f;

    /* renamed from: g  reason: collision with root package name */
    private long f14270g;

    /* renamed from: h  reason: collision with root package name */
    private x f14271h;

    /* renamed from: k  reason: collision with root package name */
    private s0[] f14272k;

    /* loaded from: classes.dex */
    private static final class a implements a0 {

        /* renamed from: a  reason: collision with root package name */
        private final int f14273a;

        /* renamed from: b  reason: collision with root package name */
        private final int f14274b;

        /* renamed from: c  reason: collision with root package name */
        private final s0 f14275c;

        /* renamed from: d  reason: collision with root package name */
        private final c1.h f14276d = new c1.h();

        /* renamed from: e  reason: collision with root package name */
        public s0 f14277e;

        /* renamed from: f  reason: collision with root package name */
        private a0 f14278f;

        /* renamed from: g  reason: collision with root package name */
        private long f14279g;

        public a(int i6, int i7, s0 s0Var) {
            this.f14273a = i6;
            this.f14274b = i7;
            this.f14275c = s0Var;
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
            return ((a0) com.google.android.exoplayer2.util.s0.j(this.f14278f)).b(hVar, i6, z5);
        }

        @Override // c1.a0
        public void d(long j6, int i6, int i7, int i8, a0.a aVar) {
            long j7 = this.f14279g;
            if (j7 != -9223372036854775807L && j6 >= j7) {
                this.f14278f = this.f14276d;
            }
            ((a0) com.google.android.exoplayer2.util.s0.j(this.f14278f)).d(j6, i6, i7, i8, aVar);
        }

        @Override // c1.a0
        public void e(s0 s0Var) {
            s0 s0Var2 = this.f14275c;
            if (s0Var2 != null) {
                s0Var = s0Var.i(s0Var2);
            }
            this.f14277e = s0Var;
            ((a0) com.google.android.exoplayer2.util.s0.j(this.f14278f)).e(this.f14277e);
        }

        @Override // c1.a0
        public void f(y yVar, int i6, int i7) {
            ((a0) com.google.android.exoplayer2.util.s0.j(this.f14278f)).a(yVar, i6);
        }

        public void g(f.a aVar, long j6) {
            if (aVar == null) {
                this.f14278f = this.f14276d;
                return;
            }
            this.f14279g = j6;
            a0 e6 = aVar.e(this.f14273a, this.f14274b);
            this.f14278f = e6;
            s0 s0Var = this.f14277e;
            if (s0Var != null) {
                e6.e(s0Var);
            }
        }
    }

    public d(c1.i iVar, int i6, s0 s0Var) {
        this.f14264a = iVar;
        this.f14265b = i6;
        this.f14266c = s0Var;
    }

    @Override // y1.f
    public void a() {
        this.f14264a.a();
    }

    @Override // y1.f
    public boolean b(c1.j jVar) {
        int g6 = this.f14264a.g(jVar, f14263l);
        com.google.android.exoplayer2.util.a.g(g6 != 1);
        return g6 == 0;
    }

    @Override // y1.f
    public void c(f.a aVar, long j6, long j7) {
        this.f14269f = aVar;
        this.f14270g = j7;
        if (!this.f14268e) {
            this.f14264a.c(this);
            if (j6 != -9223372036854775807L) {
                this.f14264a.d(0L, j6);
            }
            this.f14268e = true;
            return;
        }
        c1.i iVar = this.f14264a;
        if (j6 == -9223372036854775807L) {
            j6 = 0;
        }
        iVar.d(0L, j6);
        for (int i6 = 0; i6 < this.f14267d.size(); i6++) {
            ((a) this.f14267d.valueAt(i6)).g(aVar, j7);
        }
    }

    @Override // y1.f
    public c1.d d() {
        x xVar = this.f14271h;
        if (xVar instanceof c1.d) {
            return (c1.d) xVar;
        }
        return null;
    }

    @Override // c1.k
    public a0 e(int i6, int i7) {
        a aVar = (a) this.f14267d.get(i6);
        if (aVar == null) {
            com.google.android.exoplayer2.util.a.g(this.f14272k == null);
            aVar = new a(i6, i7, i7 == this.f14265b ? this.f14266c : null);
            aVar.g(this.f14269f, this.f14270g);
            this.f14267d.put(i6, aVar);
        }
        return aVar;
    }

    @Override // y1.f
    public s0[] f() {
        return this.f14272k;
    }

    @Override // c1.k
    public void g() {
        s0[] s0VarArr = new s0[this.f14267d.size()];
        for (int i6 = 0; i6 < this.f14267d.size(); i6++) {
            s0VarArr[i6] = (s0) com.google.android.exoplayer2.util.a.i(((a) this.f14267d.valueAt(i6)).f14277e);
        }
        this.f14272k = s0VarArr;
    }

    @Override // c1.k
    public void r(x xVar) {
        this.f14271h = xVar;
    }
}
