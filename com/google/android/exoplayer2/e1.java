package com.google.android.exoplayer2;

import android.os.Handler;
import com.google.android.exoplayer2.drm.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import w1.e0;
import w1.t0;
import w1.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: d  reason: collision with root package name */
    private final d f3738d;

    /* renamed from: e  reason: collision with root package name */
    private final e0.a f3739e;

    /* renamed from: f  reason: collision with root package name */
    private final t.a f3740f;

    /* renamed from: g  reason: collision with root package name */
    private final HashMap f3741g;

    /* renamed from: h  reason: collision with root package name */
    private final Set f3742h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3744j;

    /* renamed from: k  reason: collision with root package name */
    private q2.i0 f3745k;

    /* renamed from: i  reason: collision with root package name */
    private w1.t0 f3743i = new t0.a(0);

    /* renamed from: b  reason: collision with root package name */
    private final IdentityHashMap f3736b = new IdentityHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map f3737c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private final List f3735a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements w1.e0, com.google.android.exoplayer2.drm.t {

        /* renamed from: b  reason: collision with root package name */
        private final c f3746b;

        /* renamed from: c  reason: collision with root package name */
        private e0.a f3747c;

        /* renamed from: d  reason: collision with root package name */
        private t.a f3748d;

        public a(c cVar) {
            this.f3747c = e1.this.f3739e;
            this.f3748d = e1.this.f3740f;
            this.f3746b = cVar;
        }

        private boolean a(int i6, v.a aVar) {
            v.a aVar2;
            if (aVar != null) {
                aVar2 = e1.n(this.f3746b, aVar);
                if (aVar2 == null) {
                    return false;
                }
            } else {
                aVar2 = null;
            }
            int r5 = e1.r(this.f3746b, i6);
            e0.a aVar3 = this.f3747c;
            if (aVar3.f13824a != r5 || !com.google.android.exoplayer2.util.s0.c(aVar3.f13825b, aVar2)) {
                this.f3747c = e1.this.f3739e.F(r5, aVar2, 0L);
            }
            t.a aVar4 = this.f3748d;
            if (aVar4.f3723a == r5 && com.google.android.exoplayer2.util.s0.c(aVar4.f3724b, aVar2)) {
                return true;
            }
            this.f3748d = e1.this.f3740f.t(r5, aVar2);
            return true;
        }

        @Override // w1.e0
        public void I(int i6, v.a aVar, w1.p pVar, w1.s sVar, IOException iOException, boolean z5) {
            if (a(i6, aVar)) {
                this.f3747c.y(pVar, sVar, iOException, z5);
            }
        }

        @Override // com.google.android.exoplayer2.drm.t
        public void L(int i6, v.a aVar) {
            if (a(i6, aVar)) {
                this.f3748d.k();
            }
        }

        @Override // com.google.android.exoplayer2.drm.t
        public void N(int i6, v.a aVar) {
            if (a(i6, aVar)) {
                this.f3748d.h();
            }
        }

        @Override // w1.e0
        public void Q(int i6, v.a aVar, w1.p pVar, w1.s sVar) {
            if (a(i6, aVar)) {
                this.f3747c.B(pVar, sVar);
            }
        }

        @Override // com.google.android.exoplayer2.drm.t
        public void R(int i6, v.a aVar) {
            if (a(i6, aVar)) {
                this.f3748d.i();
            }
        }

        @Override // w1.e0
        public void j(int i6, v.a aVar, w1.s sVar) {
            if (a(i6, aVar)) {
                this.f3747c.E(sVar);
            }
        }

        @Override // w1.e0
        public void l(int i6, v.a aVar, w1.s sVar) {
            if (a(i6, aVar)) {
                this.f3747c.j(sVar);
            }
        }

        @Override // w1.e0
        public void n(int i6, v.a aVar, w1.p pVar, w1.s sVar) {
            if (a(i6, aVar)) {
                this.f3747c.v(pVar, sVar);
            }
        }

        @Override // com.google.android.exoplayer2.drm.t
        public void q(int i6, v.a aVar) {
            if (a(i6, aVar)) {
                this.f3748d.j();
            }
        }

        @Override // w1.e0
        public void v(int i6, v.a aVar, w1.p pVar, w1.s sVar) {
            if (a(i6, aVar)) {
                this.f3747c.s(pVar, sVar);
            }
        }

        @Override // com.google.android.exoplayer2.drm.t
        public void x(int i6, v.a aVar, Exception exc) {
            if (a(i6, aVar)) {
                this.f3748d.l(exc);
            }
        }

        @Override // com.google.android.exoplayer2.drm.t
        public void z(int i6, v.a aVar) {
            if (a(i6, aVar)) {
                this.f3748d.m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final w1.v f3750a;

        /* renamed from: b  reason: collision with root package name */
        public final v.b f3751b;

        /* renamed from: c  reason: collision with root package name */
        public final w1.e0 f3752c;

        public b(w1.v vVar, v.b bVar, w1.e0 e0Var) {
            this.f3750a = vVar;
            this.f3751b = bVar;
            this.f3752c = e0Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c implements c1 {

        /* renamed from: a  reason: collision with root package name */
        public final w1.r f3753a;

        /* renamed from: d  reason: collision with root package name */
        public int f3756d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3757e;

        /* renamed from: c  reason: collision with root package name */
        public final List f3755c = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final Object f3754b = new Object();

        public c(w1.v vVar, boolean z5) {
            this.f3753a = new w1.r(vVar, z5);
        }

        @Override // com.google.android.exoplayer2.c1
        public Object a() {
            return this.f3754b;
        }

        @Override // com.google.android.exoplayer2.c1
        public y1 b() {
            return this.f3753a.O();
        }

        public void c(int i6) {
            this.f3756d = i6;
            this.f3757e = false;
            this.f3755c.clear();
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void c();
    }

    public e1(d dVar, y0.a aVar, Handler handler) {
        this.f3738d = dVar;
        e0.a aVar2 = new e0.a();
        this.f3739e = aVar2;
        t.a aVar3 = new t.a();
        this.f3740f = aVar3;
        this.f3741g = new HashMap();
        this.f3742h = new HashSet();
        if (aVar != null) {
            aVar2.g(handler, aVar);
            aVar3.g(handler, aVar);
        }
    }

    private void A(int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            c cVar = (c) this.f3735a.remove(i8);
            this.f3737c.remove(cVar.f3754b);
            g(i8, -cVar.f3753a.O().o());
            cVar.f3757e = true;
            if (this.f3744j) {
                u(cVar);
            }
        }
    }

    private void g(int i6, int i7) {
        while (i6 < this.f3735a.size()) {
            ((c) this.f3735a.get(i6)).f3756d += i7;
            i6++;
        }
    }

    private void j(c cVar) {
        b bVar = (b) this.f3741g.get(cVar);
        if (bVar != null) {
            bVar.f3750a.j(bVar.f3751b);
        }
    }

    private void k() {
        Iterator it = this.f3742h.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.f3755c.isEmpty()) {
                j(cVar);
                it.remove();
            }
        }
    }

    private void l(c cVar) {
        this.f3742h.add(cVar);
        b bVar = (b) this.f3741g.get(cVar);
        if (bVar != null) {
            bVar.f3750a.b(bVar.f3751b);
        }
    }

    private static Object m(Object obj) {
        return com.google.android.exoplayer2.a.u(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static v.a n(c cVar, v.a aVar) {
        for (int i6 = 0; i6 < cVar.f3755c.size(); i6++) {
            if (((v.a) cVar.f3755c.get(i6)).f14054d == aVar.f14054d) {
                return aVar.a(p(cVar, aVar.f14051a));
            }
        }
        return null;
    }

    private static Object o(Object obj) {
        return com.google.android.exoplayer2.a.v(obj);
    }

    private static Object p(c cVar, Object obj) {
        return com.google.android.exoplayer2.a.x(cVar.f3754b, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r(c cVar, int i6) {
        return i6 + cVar.f3756d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(w1.v vVar, y1 y1Var) {
        this.f3738d.c();
    }

    private void u(c cVar) {
        if (cVar.f3757e && cVar.f3755c.isEmpty()) {
            b bVar = (b) com.google.android.exoplayer2.util.a.e((b) this.f3741g.remove(cVar));
            bVar.f3750a.c(bVar.f3751b);
            bVar.f3750a.r(bVar.f3752c);
            this.f3742h.remove(cVar);
        }
    }

    private void w(c cVar) {
        w1.r rVar = cVar.f3753a;
        v.b bVar = new v.b() { // from class: com.google.android.exoplayer2.d1
            @Override // w1.v.b
            public final void a(w1.v vVar, y1 y1Var) {
                e1.this.t(vVar, y1Var);
            }
        };
        a aVar = new a(cVar);
        this.f3741g.put(cVar, new b(rVar, bVar, aVar));
        rVar.n(com.google.android.exoplayer2.util.s0.z(), aVar);
        rVar.d(com.google.android.exoplayer2.util.s0.z(), aVar);
        rVar.l(bVar, this.f3745k);
    }

    public y1 B(List list, w1.t0 t0Var) {
        A(0, this.f3735a.size());
        return f(this.f3735a.size(), list, t0Var);
    }

    public y1 C(w1.t0 t0Var) {
        int q5 = q();
        if (t0Var.a() != q5) {
            t0Var = t0Var.h().d(0, q5);
        }
        this.f3743i = t0Var;
        return i();
    }

    public y1 f(int i6, List list, w1.t0 t0Var) {
        int i7;
        if (!list.isEmpty()) {
            this.f3743i = t0Var;
            for (int i8 = i6; i8 < list.size() + i6; i8++) {
                c cVar = (c) list.get(i8 - i6);
                if (i8 > 0) {
                    c cVar2 = (c) this.f3735a.get(i8 - 1);
                    i7 = cVar2.f3756d + cVar2.f3753a.O().o();
                } else {
                    i7 = 0;
                }
                cVar.c(i7);
                g(i8, cVar.f3753a.O().o());
                this.f3735a.add(i8, cVar);
                this.f3737c.put(cVar.f3754b, cVar);
                if (this.f3744j) {
                    w(cVar);
                    if (this.f3736b.isEmpty()) {
                        this.f3742h.add(cVar);
                    } else {
                        j(cVar);
                    }
                }
            }
        }
        return i();
    }

    public w1.t h(v.a aVar, q2.b bVar, long j6) {
        Object o5 = o(aVar.f14051a);
        v.a a6 = aVar.a(m(aVar.f14051a));
        c cVar = (c) com.google.android.exoplayer2.util.a.e((c) this.f3737c.get(o5));
        l(cVar);
        cVar.f3755c.add(a6);
        w1.q o6 = cVar.f3753a.o(a6, bVar, j6);
        this.f3736b.put(o6, cVar);
        k();
        return o6;
    }

    public y1 i() {
        if (this.f3735a.isEmpty()) {
            return y1.f4826a;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.f3735a.size(); i7++) {
            c cVar = (c) this.f3735a.get(i7);
            cVar.f3756d = i6;
            i6 += cVar.f3753a.O().o();
        }
        return new l1(this.f3735a, this.f3743i);
    }

    public int q() {
        return this.f3735a.size();
    }

    public boolean s() {
        return this.f3744j;
    }

    public void v(q2.i0 i0Var) {
        com.google.android.exoplayer2.util.a.g(!this.f3744j);
        this.f3745k = i0Var;
        for (int i6 = 0; i6 < this.f3735a.size(); i6++) {
            c cVar = (c) this.f3735a.get(i6);
            w(cVar);
            this.f3742h.add(cVar);
        }
        this.f3744j = true;
    }

    public void x() {
        for (b bVar : this.f3741g.values()) {
            try {
                bVar.f3750a.c(bVar.f3751b);
            } catch (RuntimeException e6) {
                com.google.android.exoplayer2.util.n.d("MediaSourceList", "Failed to release child source.", e6);
            }
            bVar.f3750a.r(bVar.f3752c);
        }
        this.f3741g.clear();
        this.f3742h.clear();
        this.f3744j = false;
    }

    public void y(w1.t tVar) {
        c cVar = (c) com.google.android.exoplayer2.util.a.e((c) this.f3736b.remove(tVar));
        cVar.f3753a.i(tVar);
        cVar.f3755c.remove(((w1.q) tVar).f13977b);
        if (!this.f3736b.isEmpty()) {
            k();
        }
        u(cVar);
    }

    public y1 z(int i6, int i7, w1.t0 t0Var) {
        com.google.android.exoplayer2.util.a.a(i6 >= 0 && i6 <= i7 && i7 <= q());
        this.f3743i = t0Var;
        A(i6, i7);
        return i();
    }
}
