package w1;

import android.os.Handler;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.y1;
import java.io.IOException;
import java.util.HashMap;
import w1.e0;
import w1.v;
/* loaded from: classes.dex */
public abstract class g extends w1.a {

    /* renamed from: g  reason: collision with root package name */
    private final HashMap f13832g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private Handler f13833h;

    /* renamed from: k  reason: collision with root package name */
    private q2.i0 f13834k;

    /* loaded from: classes.dex */
    private final class a implements e0, com.google.android.exoplayer2.drm.t {

        /* renamed from: b  reason: collision with root package name */
        private final Object f13835b;

        /* renamed from: c  reason: collision with root package name */
        private e0.a f13836c;

        /* renamed from: d  reason: collision with root package name */
        private t.a f13837d;

        public a(Object obj) {
            this.f13836c = g.this.v(null);
            this.f13837d = g.this.t(null);
            this.f13835b = obj;
        }

        private boolean a(int i6, v.a aVar) {
            v.a aVar2;
            if (aVar != null) {
                aVar2 = g.this.E(this.f13835b, aVar);
                if (aVar2 == null) {
                    return false;
                }
            } else {
                aVar2 = null;
            }
            int G = g.this.G(this.f13835b, i6);
            e0.a aVar3 = this.f13836c;
            if (aVar3.f13824a != G || !com.google.android.exoplayer2.util.s0.c(aVar3.f13825b, aVar2)) {
                this.f13836c = g.this.u(G, aVar2, 0L);
            }
            t.a aVar4 = this.f13837d;
            if (aVar4.f3723a == G && com.google.android.exoplayer2.util.s0.c(aVar4.f3724b, aVar2)) {
                return true;
            }
            this.f13837d = g.this.s(G, aVar2);
            return true;
        }

        private s b(s sVar) {
            long F = g.this.F(this.f13835b, sVar.f14032f);
            long F2 = g.this.F(this.f13835b, sVar.f14033g);
            return (F == sVar.f14032f && F2 == sVar.f14033g) ? sVar : new s(sVar.f14027a, sVar.f14028b, sVar.f14029c, sVar.f14030d, sVar.f14031e, F, F2);
        }

        @Override // w1.e0
        public void I(int i6, v.a aVar, p pVar, s sVar, IOException iOException, boolean z5) {
            if (a(i6, aVar)) {
                this.f13836c.y(pVar, b(sVar), iOException, z5);
            }
        }

        @Override // com.google.android.exoplayer2.drm.t
        public void L(int i6, v.a aVar) {
            if (a(i6, aVar)) {
                this.f13837d.k();
            }
        }

        @Override // com.google.android.exoplayer2.drm.t
        public void N(int i6, v.a aVar) {
            if (a(i6, aVar)) {
                this.f13837d.h();
            }
        }

        @Override // w1.e0
        public void Q(int i6, v.a aVar, p pVar, s sVar) {
            if (a(i6, aVar)) {
                this.f13836c.B(pVar, b(sVar));
            }
        }

        @Override // com.google.android.exoplayer2.drm.t
        public void R(int i6, v.a aVar) {
            if (a(i6, aVar)) {
                this.f13837d.i();
            }
        }

        @Override // w1.e0
        public void j(int i6, v.a aVar, s sVar) {
            if (a(i6, aVar)) {
                this.f13836c.E(b(sVar));
            }
        }

        @Override // w1.e0
        public void l(int i6, v.a aVar, s sVar) {
            if (a(i6, aVar)) {
                this.f13836c.j(b(sVar));
            }
        }

        @Override // w1.e0
        public void n(int i6, v.a aVar, p pVar, s sVar) {
            if (a(i6, aVar)) {
                this.f13836c.v(pVar, b(sVar));
            }
        }

        @Override // com.google.android.exoplayer2.drm.t
        public void q(int i6, v.a aVar) {
            if (a(i6, aVar)) {
                this.f13837d.j();
            }
        }

        @Override // w1.e0
        public void v(int i6, v.a aVar, p pVar, s sVar) {
            if (a(i6, aVar)) {
                this.f13836c.s(pVar, b(sVar));
            }
        }

        @Override // com.google.android.exoplayer2.drm.t
        public void x(int i6, v.a aVar, Exception exc) {
            if (a(i6, aVar)) {
                this.f13837d.l(exc);
            }
        }

        @Override // com.google.android.exoplayer2.drm.t
        public void z(int i6, v.a aVar) {
            if (a(i6, aVar)) {
                this.f13837d.m();
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final v f13839a;

        /* renamed from: b  reason: collision with root package name */
        public final v.b f13840b;

        /* renamed from: c  reason: collision with root package name */
        public final e0 f13841c;

        public b(v vVar, v.b bVar, e0 e0Var) {
            this.f13839a = vVar;
            this.f13840b = bVar;
            this.f13841c = e0Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.a
    public void A(q2.i0 i0Var) {
        this.f13834k = i0Var;
        this.f13833h = com.google.android.exoplayer2.util.s0.x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.a
    public void C() {
        for (b bVar : this.f13832g.values()) {
            bVar.f13839a.c(bVar.f13840b);
            bVar.f13839a.r(bVar.f13841c);
        }
        this.f13832g.clear();
    }

    protected v.a E(Object obj, v.a aVar) {
        return aVar;
    }

    protected long F(Object obj, long j6) {
        return j6;
    }

    protected int G(Object obj, int i6) {
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: I */
    public abstract void H(Object obj, v vVar, y1 y1Var);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void J(final Object obj, v vVar) {
        com.google.android.exoplayer2.util.a.a(!this.f13832g.containsKey(obj));
        v.b bVar = new v.b() { // from class: w1.f
            @Override // w1.v.b
            public final void a(v vVar2, y1 y1Var) {
                g.this.H(obj, vVar2, y1Var);
            }
        };
        a aVar = new a(obj);
        this.f13832g.put(obj, new b(vVar, bVar, aVar));
        vVar.n((Handler) com.google.android.exoplayer2.util.a.e(this.f13833h), aVar);
        vVar.d((Handler) com.google.android.exoplayer2.util.a.e(this.f13833h), aVar);
        vVar.l(bVar, this.f13834k);
        if (z()) {
            return;
        }
        vVar.j(bVar);
    }

    @Override // w1.v
    public void e() {
        for (b bVar : this.f13832g.values()) {
            bVar.f13839a.e();
        }
    }

    @Override // w1.a
    protected void x() {
        for (b bVar : this.f13832g.values()) {
            bVar.f13839a.j(bVar.f13840b);
        }
    }

    @Override // w1.a
    protected void y() {
        for (b bVar : this.f13832g.values()) {
            bVar.f13839a.b(bVar.f13840b);
        }
    }
}
