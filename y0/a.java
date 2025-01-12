package y0;

import android.view.Surface;
import com.google.android.exoplayer2.audio.g;
import com.google.android.exoplayer2.audio.q;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.c;
import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.y1;
import com.google.common.base.h;
import com.google.common.collect.a0;
import com.google.common.collect.m0;
import com.google.common.collect.y;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import n1.f;
import o2.k;
import q2.e;
import s2.l;
import s2.u;
import w1.e0;
import w1.s;
import w1.v;
import w1.y0;
/* loaded from: classes.dex */
public class a implements j1.a, f, q, u, e0, e.a, t, l, g {

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArraySet f14231b = new CopyOnWriteArraySet();

    /* renamed from: c  reason: collision with root package name */
    private final c f14232c;

    /* renamed from: d  reason: collision with root package name */
    private final y1.b f14233d;

    /* renamed from: e  reason: collision with root package name */
    private final y1.c f14234e;

    /* renamed from: f  reason: collision with root package name */
    private final C0226a f14235f;

    /* renamed from: g  reason: collision with root package name */
    private j1 f14236g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14237h;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0226a {

        /* renamed from: a  reason: collision with root package name */
        private final y1.b f14238a;

        /* renamed from: b  reason: collision with root package name */
        private y f14239b = y.of();

        /* renamed from: c  reason: collision with root package name */
        private a0 f14240c = a0.of();

        /* renamed from: d  reason: collision with root package name */
        private v.a f14241d;

        /* renamed from: e  reason: collision with root package name */
        private v.a f14242e;

        /* renamed from: f  reason: collision with root package name */
        private v.a f14243f;

        public C0226a(y1.b bVar) {
            this.f14238a = bVar;
        }

        private void b(a0.b bVar, v.a aVar, y1 y1Var) {
            if (aVar == null) {
                return;
            }
            if (y1Var.b(aVar.f14051a) == -1 && (y1Var = (y1) this.f14240c.get(aVar)) == null) {
                return;
            }
            bVar.c(aVar, y1Var);
        }

        private static v.a c(j1 j1Var, y yVar, v.a aVar, y1.b bVar) {
            y1 i6 = j1Var.i();
            int e6 = j1Var.e();
            Object l6 = i6.p() ? null : i6.l(e6);
            int c6 = (j1Var.a() || i6.p()) ? -1 : i6.f(e6, bVar).c(p.a(j1Var.k()) - bVar.k());
            for (int i7 = 0; i7 < yVar.size(); i7++) {
                v.a aVar2 = (v.a) yVar.get(i7);
                if (i(aVar2, l6, j1Var.a(), j1Var.f(), j1Var.h(), c6)) {
                    return aVar2;
                }
            }
            if (yVar.isEmpty() && aVar != null) {
                if (i(aVar, l6, j1Var.a(), j1Var.f(), j1Var.h(), c6)) {
                    return aVar;
                }
            }
            return null;
        }

        private static boolean i(v.a aVar, Object obj, boolean z5, int i6, int i7, int i8) {
            if (aVar.f14051a.equals(obj)) {
                return (z5 && aVar.f14052b == i6 && aVar.f14053c == i7) || (!z5 && aVar.f14052b == -1 && aVar.f14055e == i8);
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
            if (com.google.common.base.h.a(r3.f14241d, r3.f14243f) == false) goto L10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
            if (r3.f14239b.contains(r3.f14241d) == false) goto L10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
            b(r0, r3.f14241d, r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void m(y1 y1Var) {
            a0.b builder = a0.builder();
            if (this.f14239b.isEmpty()) {
                b(builder, this.f14242e, y1Var);
                if (!h.a(this.f14243f, this.f14242e)) {
                    b(builder, this.f14243f, y1Var);
                }
                if (!h.a(this.f14241d, this.f14242e)) {
                }
            } else {
                for (int i6 = 0; i6 < this.f14239b.size(); i6++) {
                    b(builder, (v.a) this.f14239b.get(i6), y1Var);
                }
            }
            this.f14240c = builder.a();
        }

        public v.a d() {
            return this.f14241d;
        }

        public v.a e() {
            if (this.f14239b.isEmpty()) {
                return null;
            }
            return (v.a) m0.c(this.f14239b);
        }

        public y1 f(v.a aVar) {
            return (y1) this.f14240c.get(aVar);
        }

        public v.a g() {
            return this.f14242e;
        }

        public v.a h() {
            return this.f14243f;
        }

        public void j(j1 j1Var) {
            this.f14241d = c(j1Var, this.f14239b, this.f14242e, this.f14238a);
        }

        public void k(List list, v.a aVar, j1 j1Var) {
            this.f14239b = y.copyOf((Collection) list);
            if (!list.isEmpty()) {
                this.f14242e = (v.a) list.get(0);
                this.f14243f = (v.a) com.google.android.exoplayer2.util.a.e(aVar);
            }
            if (this.f14241d == null) {
                this.f14241d = c(j1Var, this.f14239b, this.f14242e, this.f14238a);
            }
            m(j1Var.i());
        }

        public void l(j1 j1Var) {
            this.f14241d = c(j1Var, this.f14239b, this.f14242e, this.f14238a);
            m(j1Var.i());
        }
    }

    public a(c cVar) {
        this.f14232c = (c) com.google.android.exoplayer2.util.a.e(cVar);
        y1.b bVar = new y1.b();
        this.f14233d = bVar;
        this.f14234e = new y1.c();
        this.f14235f = new C0226a(bVar);
    }

    private b W() {
        return Y(this.f14235f.d());
    }

    private b Y(v.a aVar) {
        com.google.android.exoplayer2.util.a.e(this.f14236g);
        y1 f6 = aVar == null ? null : this.f14235f.f(aVar);
        if (aVar == null || f6 == null) {
            int j6 = this.f14236g.j();
            y1 i6 = this.f14236g.i();
            if (!(j6 < i6.o())) {
                i6 = y1.f4826a;
            }
            return X(i6, j6, null);
        }
        return X(f6, f6.h(aVar.f14051a, this.f14233d).f4829c, aVar);
    }

    private b Z() {
        return Y(this.f14235f.e());
    }

    private b a0(int i6, v.a aVar) {
        com.google.android.exoplayer2.util.a.e(this.f14236g);
        if (aVar != null) {
            return this.f14235f.f(aVar) != null ? Y(aVar) : X(y1.f4826a, i6, aVar);
        }
        y1 i7 = this.f14236g.i();
        if (!(i6 < i7.o())) {
            i7 = y1.f4826a;
        }
        return X(i7, i6, null);
    }

    private b b0() {
        return Y(this.f14235f.g());
    }

    private b c0() {
        return Y(this.f14235f.h());
    }

    @Override // s2.u
    public final void A(com.google.android.exoplayer2.decoder.h hVar) {
        c0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.audio.q
    public final void B(long j6) {
        c0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.j1.a
    public final void C(y1 y1Var, int i6) {
        this.f14235f.l((j1) com.google.android.exoplayer2.util.a.e(this.f14236g));
        W();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.audio.q
    public final void D(s0 s0Var) {
        c0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.j1.a
    public final void E(int i6) {
        W();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.j1.a
    public final void F(boolean z5, int i6) {
        W();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // s2.u
    public final void G(Surface surface) {
        c0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // q2.e.a
    public final void H(int i6, long j6, long j7) {
        Z();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // w1.e0
    public final void I(int i6, v.a aVar, w1.p pVar, s sVar, IOException iOException, boolean z5) {
        a0(i6, aVar);
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // s2.u
    public final void J(com.google.android.exoplayer2.decoder.h hVar) {
        b0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.audio.q
    public final void K(String str, long j6, long j7) {
        c0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.drm.t
    public final void L(int i6, v.a aVar) {
        a0(i6, aVar);
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // s2.l
    public void M(int i6, int i7) {
        c0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.drm.t
    public final void N(int i6, v.a aVar) {
        a0(i6, aVar);
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // n1.f
    public final void O(n1.a aVar) {
        W();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.j1.a
    public /* synthetic */ void P(boolean z5) {
        i1.a(this, z5);
    }

    @Override // w1.e0
    public final void Q(int i6, v.a aVar, w1.p pVar, s sVar) {
        a0(i6, aVar);
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.drm.t
    public final void R(int i6, v.a aVar) {
        a0(i6, aVar);
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.audio.q
    public final void S(int i6, long j6, long j7) {
        c0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // s2.u
    public final void T(int i6, long j6) {
        b0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // s2.u
    public final void U(long j6, int i6) {
        b0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.j1.a
    public void V(boolean z5) {
        W();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    protected b X(y1 y1Var, int i6, v.a aVar) {
        long b6;
        v.a aVar2 = y1Var.p() ? null : aVar;
        long c6 = this.f14232c.c();
        boolean z5 = true;
        boolean z6 = y1Var.equals(this.f14236g.i()) && i6 == this.f14236g.j();
        long j6 = 0;
        if (aVar2 != null && aVar2.b()) {
            if ((z6 && this.f14236g.f() == aVar2.f14052b && this.f14236g.h() == aVar2.f14053c) ? false : false) {
                j6 = this.f14236g.k();
            }
        } else if (z6) {
            b6 = this.f14236g.b();
            return new b(c6, y1Var, i6, aVar2, b6, this.f14236g.i(), this.f14236g.j(), this.f14235f.d(), this.f14236g.k(), this.f14236g.c());
        } else if (!y1Var.p()) {
            j6 = y1Var.m(i6, this.f14234e).a();
        }
        b6 = j6;
        return new b(c6, y1Var, i6, aVar2, b6, this.f14236g.i(), this.f14236g.j(), this.f14235f.d(), this.f14236g.k(), this.f14236g.c());
    }

    @Override // com.google.android.exoplayer2.audio.q
    public void a(boolean z5) {
        c0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.audio.q
    public final void b(int i6) {
        c0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // s2.u
    public final void c(int i6, int i7, int i8, float f6) {
        c0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.j1.a
    public final void d(h1 h1Var) {
        W();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    public final void d0() {
        if (this.f14237h) {
            return;
        }
        W();
        this.f14237h = true;
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.j1.a
    public void e(int i6) {
        W();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    public final void e0() {
    }

    @Override // com.google.android.exoplayer2.j1.a
    public final void f(boolean z5, int i6) {
        W();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    public void f0(j1 j1Var) {
        com.google.android.exoplayer2.util.a.g(this.f14236g == null || this.f14235f.f14239b.isEmpty());
        this.f14236g = (j1) com.google.android.exoplayer2.util.a.e(j1Var);
    }

    @Override // com.google.android.exoplayer2.j1.a
    public final void g(y0 y0Var, k kVar) {
        W();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    public void g0(List list, v.a aVar) {
        this.f14235f.k(list, aVar, (j1) com.google.android.exoplayer2.util.a.e(this.f14236g));
    }

    @Override // com.google.android.exoplayer2.j1.a
    public /* synthetic */ void h(boolean z5) {
        i1.d(this, z5);
    }

    @Override // com.google.android.exoplayer2.j1.a
    public final void i(int i6) {
        if (i6 == 1) {
            this.f14237h = false;
        }
        this.f14235f.j((j1) com.google.android.exoplayer2.util.a.e(this.f14236g));
        W();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // w1.e0
    public final void j(int i6, v.a aVar, s sVar) {
        a0(i6, aVar);
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.audio.q
    public final void k(com.google.android.exoplayer2.decoder.h hVar) {
        b0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // w1.e0
    public final void l(int i6, v.a aVar, s sVar) {
        a0(i6, aVar);
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.audio.q
    public final void m(com.google.android.exoplayer2.decoder.h hVar) {
        c0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // w1.e0
    public final void n(int i6, v.a aVar, w1.p pVar, s sVar) {
        a0(i6, aVar);
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // s2.u
    public final void o(String str, long j6, long j7) {
        c0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.j1.a
    public /* synthetic */ void p(y1 y1Var, Object obj, int i6) {
        i1.o(this, y1Var, obj, i6);
    }

    @Override // com.google.android.exoplayer2.drm.t
    public final void q(int i6, v.a aVar) {
        a0(i6, aVar);
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.j1.a
    public final void r(com.google.android.exoplayer2.t tVar) {
        v.a aVar = tVar.mediaPeriodId;
        if (aVar != null) {
            Y(aVar);
        } else {
            W();
        }
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.j1.a
    public final void s(boolean z5) {
        W();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // s2.l
    public final void t() {
    }

    @Override // com.google.android.exoplayer2.j1.a
    public final void u() {
        W();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // w1.e0
    public final void v(int i6, v.a aVar, w1.p pVar, s sVar) {
        a0(i6, aVar);
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.j1.a
    public final void w(w0 w0Var, int i6) {
        W();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.drm.t
    public final void x(int i6, v.a aVar, Exception exc) {
        a0(i6, aVar);
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // s2.u
    public final void y(s0 s0Var) {
        c0();
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.drm.t
    public final void z(int i6, v.a aVar) {
        a0(i6, aVar);
        Iterator it = this.f14231b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }
}
