package w1;

import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.y1;
import java.util.List;
import q2.l;
import w1.n0;
import w1.v;
/* loaded from: classes.dex */
public final class o0 extends w1.a implements n0.b {

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.exoplayer2.w0 f13936g;

    /* renamed from: h  reason: collision with root package name */
    private final w0.e f13937h;

    /* renamed from: k  reason: collision with root package name */
    private final l.a f13938k;

    /* renamed from: l  reason: collision with root package name */
    private final c1.o f13939l;

    /* renamed from: m  reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.v f13940m;

    /* renamed from: n  reason: collision with root package name */
    private final q2.c0 f13941n;

    /* renamed from: o  reason: collision with root package name */
    private final int f13942o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f13943p = true;

    /* renamed from: q  reason: collision with root package name */
    private long f13944q = -9223372036854775807L;

    /* renamed from: r  reason: collision with root package name */
    private boolean f13945r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f13946s;

    /* renamed from: t  reason: collision with root package name */
    private q2.i0 f13947t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends n {
        a(o0 o0Var, y1 y1Var) {
            super(y1Var);
        }

        @Override // w1.n, com.google.android.exoplayer2.y1
        public y1.c n(int i6, y1.c cVar, long j6) {
            super.n(i6, cVar, j6);
            cVar.f4845k = true;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private final l.a f13948a;

        /* renamed from: c  reason: collision with root package name */
        private c1.o f13950c;

        /* renamed from: d  reason: collision with root package name */
        private com.google.android.exoplayer2.drm.v f13951d;

        /* renamed from: g  reason: collision with root package name */
        private String f13954g;

        /* renamed from: h  reason: collision with root package name */
        private Object f13955h;

        /* renamed from: b  reason: collision with root package name */
        private final w f13949b = new w();

        /* renamed from: e  reason: collision with root package name */
        private q2.c0 f13952e = new q2.w();

        /* renamed from: f  reason: collision with root package name */
        private int f13953f = 1048576;

        public b(l.a aVar, c1.o oVar) {
            this.f13948a = aVar;
            this.f13950c = oVar;
        }

        @Override // w1.g0
        public /* synthetic */ g0 a(List list) {
            return f0.a(this, list);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
        @Override // w1.g0
        /* renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public o0 c(com.google.android.exoplayer2.w0 w0Var) {
            w0.b a6;
            w0.b f6;
            com.google.android.exoplayer2.drm.v vVar;
            com.google.android.exoplayer2.util.a.e(w0Var.f4702b);
            w0.e eVar = w0Var.f4702b;
            boolean z5 = true;
            boolean z6 = eVar.f4747h == null && this.f13955h != null;
            z5 = (eVar.f4744e != null || this.f13954g == null) ? false : false;
            if (!z6 || !z5) {
                if (!z6) {
                    if (z5) {
                        a6 = w0Var.a();
                    }
                    com.google.android.exoplayer2.w0 w0Var2 = w0Var;
                    l.a aVar = this.f13948a;
                    c1.o oVar = this.f13950c;
                    vVar = this.f13951d;
                    if (vVar == null) {
                    }
                    return new o0(w0Var2, aVar, oVar, vVar, this.f13952e, this.f13953f);
                }
                f6 = w0Var.a().f(this.f13955h);
                w0Var = f6.a();
                com.google.android.exoplayer2.w0 w0Var22 = w0Var;
                l.a aVar2 = this.f13948a;
                c1.o oVar2 = this.f13950c;
                vVar = this.f13951d;
                if (vVar == null) {
                    vVar = this.f13949b.a(w0Var22);
                }
                return new o0(w0Var22, aVar2, oVar2, vVar, this.f13952e, this.f13953f);
            }
            a6 = w0Var.a().f(this.f13955h);
            f6 = a6.b(this.f13954g);
            w0Var = f6.a();
            com.google.android.exoplayer2.w0 w0Var222 = w0Var;
            l.a aVar22 = this.f13948a;
            c1.o oVar22 = this.f13950c;
            vVar = this.f13951d;
            if (vVar == null) {
            }
            return new o0(w0Var222, aVar22, oVar22, vVar, this.f13952e, this.f13953f);
        }

        @Override // w1.g0
        /* renamed from: f */
        public b b(com.google.android.exoplayer2.drm.v vVar) {
            this.f13951d = vVar;
            return this;
        }

        @Override // w1.g0
        /* renamed from: g */
        public b d(q2.c0 c0Var) {
            if (c0Var == null) {
                c0Var = new q2.w();
            }
            this.f13952e = c0Var;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(com.google.android.exoplayer2.w0 w0Var, l.a aVar, c1.o oVar, com.google.android.exoplayer2.drm.v vVar, q2.c0 c0Var, int i6) {
        this.f13937h = (w0.e) com.google.android.exoplayer2.util.a.e(w0Var.f4702b);
        this.f13936g = w0Var;
        this.f13938k = aVar;
        this.f13939l = oVar;
        this.f13940m = vVar;
        this.f13941n = c0Var;
        this.f13942o = i6;
    }

    private void D() {
        y1 u0Var = new u0(this.f13944q, this.f13945r, false, this.f13946s, null, this.f13936g);
        if (this.f13943p) {
            u0Var = new a(this, u0Var);
        }
        B(u0Var);
    }

    @Override // w1.a
    protected void A(q2.i0 i0Var) {
        this.f13947t = i0Var;
        this.f13940m.b();
        D();
    }

    @Override // w1.a
    protected void C() {
        this.f13940m.a();
    }

    @Override // w1.v
    public com.google.android.exoplayer2.w0 a() {
        return this.f13936g;
    }

    @Override // w1.v
    public void e() {
    }

    @Override // w1.v
    public void i(t tVar) {
        ((n0) tVar).c0();
    }

    @Override // w1.v
    public t o(v.a aVar, q2.b bVar, long j6) {
        q2.l a6 = this.f13938k.a();
        q2.i0 i0Var = this.f13947t;
        if (i0Var != null) {
            a6.i(i0Var);
        }
        return new n0(this.f13937h.f4740a, a6, this.f13939l, this.f13940m, t(aVar), this.f13941n, v(aVar), this, bVar, this.f13937h.f4744e, this.f13942o);
    }

    @Override // w1.n0.b
    public void q(long j6, boolean z5, boolean z6) {
        if (j6 == -9223372036854775807L) {
            j6 = this.f13944q;
        }
        if (!this.f13943p && this.f13944q == j6 && this.f13945r == z5 && this.f13946s == z6) {
            return;
        }
        this.f13944q = j6;
        this.f13945r = z5;
        this.f13946s = z6;
        this.f13943p = false;
        D();
    }
}
