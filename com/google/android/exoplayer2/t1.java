package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.w1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes.dex */
public class t1 extends n {
    private com.google.android.exoplayer2.decoder.h A;
    private com.google.android.exoplayer2.decoder.h B;
    private int C;
    private com.google.android.exoplayer2.audio.e D;
    private float E;
    private boolean F;
    private List G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private a1.a L;

    /* renamed from: b  reason: collision with root package name */
    protected final n1[] f4442b;

    /* renamed from: c  reason: collision with root package name */
    private final y f4443c;

    /* renamed from: d  reason: collision with root package name */
    private final c f4444d;

    /* renamed from: e  reason: collision with root package name */
    private final CopyOnWriteArraySet f4445e;

    /* renamed from: f  reason: collision with root package name */
    private final CopyOnWriteArraySet f4446f;

    /* renamed from: g  reason: collision with root package name */
    private final CopyOnWriteArraySet f4447g;

    /* renamed from: h  reason: collision with root package name */
    private final CopyOnWriteArraySet f4448h;

    /* renamed from: i  reason: collision with root package name */
    private final CopyOnWriteArraySet f4449i;

    /* renamed from: j  reason: collision with root package name */
    private final CopyOnWriteArraySet f4450j;

    /* renamed from: k  reason: collision with root package name */
    private final CopyOnWriteArraySet f4451k;

    /* renamed from: l  reason: collision with root package name */
    private final y0.a f4452l;

    /* renamed from: m  reason: collision with root package name */
    private final com.google.android.exoplayer2.b f4453m;

    /* renamed from: n  reason: collision with root package name */
    private final m f4454n;

    /* renamed from: o  reason: collision with root package name */
    private final w1 f4455o;

    /* renamed from: p  reason: collision with root package name */
    private final z1 f4456p;

    /* renamed from: q  reason: collision with root package name */
    private final a2 f4457q;

    /* renamed from: r  reason: collision with root package name */
    private s0 f4458r;

    /* renamed from: s  reason: collision with root package name */
    private s0 f4459s;

    /* renamed from: t  reason: collision with root package name */
    private Surface f4460t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f4461u;

    /* renamed from: v  reason: collision with root package name */
    private int f4462v;

    /* renamed from: w  reason: collision with root package name */
    private SurfaceHolder f4463w;

    /* renamed from: x  reason: collision with root package name */
    private TextureView f4464x;

    /* renamed from: y  reason: collision with root package name */
    private int f4465y;

    /* renamed from: z  reason: collision with root package name */
    private int f4466z;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f4467a;

        /* renamed from: b  reason: collision with root package name */
        private final r1 f4468b;

        /* renamed from: c  reason: collision with root package name */
        private com.google.android.exoplayer2.util.c f4469c;

        /* renamed from: d  reason: collision with root package name */
        private o2.m f4470d;

        /* renamed from: e  reason: collision with root package name */
        private w1.g0 f4471e;

        /* renamed from: f  reason: collision with root package name */
        private v0 f4472f;

        /* renamed from: g  reason: collision with root package name */
        private q2.e f4473g;

        /* renamed from: h  reason: collision with root package name */
        private y0.a f4474h;

        /* renamed from: i  reason: collision with root package name */
        private Looper f4475i;

        /* renamed from: j  reason: collision with root package name */
        private com.google.android.exoplayer2.audio.e f4476j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f4477k;

        /* renamed from: l  reason: collision with root package name */
        private int f4478l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f4479m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f4480n;

        /* renamed from: o  reason: collision with root package name */
        private int f4481o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f4482p;

        /* renamed from: q  reason: collision with root package name */
        private s1 f4483q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f4484r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f4485s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f4486t;

        public b(Context context, r1 r1Var) {
            this(context, r1Var, new c1.g());
        }

        public t1 u() {
            com.google.android.exoplayer2.util.a.g(!this.f4486t);
            this.f4486t = true;
            return new t1(this);
        }

        public b v(q2.e eVar) {
            com.google.android.exoplayer2.util.a.g(!this.f4486t);
            this.f4473g = eVar;
            return this;
        }

        public b w(v0 v0Var) {
            com.google.android.exoplayer2.util.a.g(!this.f4486t);
            this.f4472f = v0Var;
            return this;
        }

        public b(Context context, r1 r1Var, c1.o oVar) {
            this(context, r1Var, new o2.f(context), new w1.k(context, oVar), new q(), q2.q.l(context), new y0.a(com.google.android.exoplayer2.util.c.f4589a));
        }

        public b(Context context, r1 r1Var, o2.m mVar, w1.g0 g0Var, v0 v0Var, q2.e eVar, y0.a aVar) {
            this.f4467a = context;
            this.f4468b = r1Var;
            this.f4470d = mVar;
            this.f4471e = g0Var;
            this.f4472f = v0Var;
            this.f4473g = eVar;
            this.f4474h = aVar;
            this.f4475i = com.google.android.exoplayer2.util.s0.O();
            this.f4476j = com.google.android.exoplayer2.audio.e.f3351f;
            this.f4478l = 0;
            this.f4481o = 1;
            this.f4482p = true;
            this.f4483q = s1.f4099g;
            this.f4469c = com.google.android.exoplayer2.util.c.f4589a;
            this.f4485s = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c implements s2.u, com.google.android.exoplayer2.audio.q, e2.l, n1.f, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, m.b, b.InterfaceC0037b, w1.b, j1.a {
        private c() {
        }

        @Override // s2.u
        public void A(com.google.android.exoplayer2.decoder.h hVar) {
            t1.this.A = hVar;
            Iterator it = t1.this.f4450j.iterator();
            while (it.hasNext()) {
                ((s2.u) it.next()).A(hVar);
            }
        }

        @Override // com.google.android.exoplayer2.audio.q
        public void B(long j6) {
            Iterator it = t1.this.f4451k.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.q) it.next()).B(j6);
            }
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void C(y1 y1Var, int i6) {
            i1.n(this, y1Var, i6);
        }

        @Override // com.google.android.exoplayer2.audio.q
        public void D(s0 s0Var) {
            t1.this.f4459s = s0Var;
            Iterator it = t1.this.f4451k.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.q) it.next()).D(s0Var);
            }
        }

        @Override // com.google.android.exoplayer2.j1.a
        public void E(int i6) {
            t1.this.v0();
        }

        @Override // com.google.android.exoplayer2.j1.a
        public void F(boolean z5, int i6) {
            t1.this.v0();
        }

        @Override // s2.u
        public void G(Surface surface) {
            if (t1.this.f4460t == surface) {
                Iterator it = t1.this.f4445e.iterator();
                while (it.hasNext()) {
                    ((s2.l) it.next()).t();
                }
            }
            Iterator it2 = t1.this.f4450j.iterator();
            while (it2.hasNext()) {
                ((s2.u) it2.next()).G(surface);
            }
        }

        @Override // s2.u
        public void J(com.google.android.exoplayer2.decoder.h hVar) {
            Iterator it = t1.this.f4450j.iterator();
            while (it.hasNext()) {
                ((s2.u) it.next()).J(hVar);
            }
            t1.this.f4458r = null;
            t1.this.A = null;
        }

        @Override // com.google.android.exoplayer2.audio.q
        public void K(String str, long j6, long j7) {
            Iterator it = t1.this.f4451k.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.q) it.next()).K(str, j6, j7);
            }
        }

        @Override // n1.f
        public void O(n1.a aVar) {
            Iterator it = t1.this.f4448h.iterator();
            while (it.hasNext()) {
                ((n1.f) it.next()).O(aVar);
            }
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void P(boolean z5) {
            i1.a(this, z5);
        }

        @Override // com.google.android.exoplayer2.audio.q
        public void S(int i6, long j6, long j7) {
            Iterator it = t1.this.f4451k.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.q) it.next()).S(i6, j6, j7);
            }
        }

        @Override // s2.u
        public void T(int i6, long j6) {
            Iterator it = t1.this.f4450j.iterator();
            while (it.hasNext()) {
                ((s2.u) it.next()).T(i6, j6);
            }
        }

        @Override // s2.u
        public void U(long j6, int i6) {
            Iterator it = t1.this.f4450j.iterator();
            while (it.hasNext()) {
                ((s2.u) it.next()).U(j6, i6);
            }
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void V(boolean z5) {
            i1.c(this, z5);
        }

        @Override // com.google.android.exoplayer2.audio.q
        public void a(boolean z5) {
            if (t1.this.F == z5) {
                return;
            }
            t1.this.F = z5;
            t1.this.e0();
        }

        @Override // com.google.android.exoplayer2.audio.q
        public void b(int i6) {
            if (t1.this.C == i6) {
                return;
            }
            t1.this.C = i6;
            t1.this.d0();
        }

        @Override // s2.u
        public void c(int i6, int i7, int i8, float f6) {
            Iterator it = t1.this.f4445e.iterator();
            while (it.hasNext()) {
                s2.l lVar = (s2.l) it.next();
                if (!t1.this.f4450j.contains(lVar)) {
                    lVar.c(i6, i7, i8, f6);
                }
            }
            Iterator it2 = t1.this.f4450j.iterator();
            while (it2.hasNext()) {
                ((s2.u) it2.next()).c(i6, i7, i8, f6);
            }
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void d(h1 h1Var) {
            i1.g(this, h1Var);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void e(int i6) {
            i1.i(this, i6);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void f(boolean z5, int i6) {
            i1.k(this, z5, i6);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void g(w1.y0 y0Var, o2.k kVar) {
            i1.p(this, y0Var, kVar);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void h(boolean z5) {
            i1.d(this, z5);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void i(int i6) {
            i1.l(this, i6);
        }

        @Override // com.google.android.exoplayer2.m.b
        public void j(int i6) {
            boolean Z = t1.this.Z();
            t1.this.u0(Z, i6, t1.a0(Z, i6));
        }

        @Override // com.google.android.exoplayer2.audio.q
        public void k(com.google.android.exoplayer2.decoder.h hVar) {
            Iterator it = t1.this.f4451k.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.q) it.next()).k(hVar);
            }
            t1.this.f4459s = null;
            t1.this.B = null;
            t1.this.C = 0;
        }

        @Override // com.google.android.exoplayer2.w1.b
        public void l(int i6, boolean z5) {
            Iterator it = t1.this.f4449i.iterator();
            if (it.hasNext()) {
                android.support.v4.media.a.a(it.next());
                throw null;
            }
        }

        @Override // com.google.android.exoplayer2.audio.q
        public void m(com.google.android.exoplayer2.decoder.h hVar) {
            t1.this.B = hVar;
            Iterator it = t1.this.f4451k.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.q) it.next()).m(hVar);
            }
        }

        @Override // e2.l
        public void n(List list) {
            t1.this.G = list;
            Iterator it = t1.this.f4447g.iterator();
            while (it.hasNext()) {
                ((e2.l) it.next()).n(list);
            }
        }

        @Override // s2.u
        public void o(String str, long j6, long j7) {
            Iterator it = t1.this.f4450j.iterator();
            while (it.hasNext()) {
                ((s2.u) it.next()).o(str, j6, j7);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
            t1.this.s0(new Surface(surfaceTexture), true);
            t1.this.c0(i6, i7);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            t1.this.s0(null, true);
            t1.this.c0(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
            t1.this.c0(i6, i7);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void p(y1 y1Var, Object obj, int i6) {
            i1.o(this, y1Var, obj, i6);
        }

        @Override // com.google.android.exoplayer2.w1.b
        public void q(int i6) {
            a1.a W = t1.W(t1.this.f4455o);
            if (W.equals(t1.this.L)) {
                return;
            }
            t1.this.L = W;
            Iterator it = t1.this.f4449i.iterator();
            if (it.hasNext()) {
                android.support.v4.media.a.a(it.next());
                throw null;
            }
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void r(t tVar) {
            i1.j(this, tVar);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public void s(boolean z5) {
            t1.this.getClass();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i6, int i7, int i8) {
            t1.this.c0(i7, i8);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            t1.this.s0(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            t1.this.s0(null, false);
            t1.this.c0(0, 0);
        }

        @Override // com.google.android.exoplayer2.b.InterfaceC0037b
        public void t() {
            t1.this.u0(false, -1, 3);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void u() {
            i1.m(this);
        }

        @Override // com.google.android.exoplayer2.m.b
        public void v(float f6) {
            t1.this.m0();
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void w(w0 w0Var, int i6) {
            i1.e(this, w0Var, i6);
        }

        @Override // s2.u
        public void y(s0 s0Var) {
            t1.this.f4458r = s0Var;
            Iterator it = t1.this.f4450j.iterator();
            while (it.hasNext()) {
                ((s2.u) it.next()).y(s0Var);
            }
        }
    }

    protected t1(b bVar) {
        y0.a aVar = bVar.f4474h;
        this.f4452l = aVar;
        bVar.getClass();
        this.D = bVar.f4476j;
        this.f4462v = bVar.f4481o;
        this.F = bVar.f4480n;
        c cVar = new c();
        this.f4444d = cVar;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.f4445e = copyOnWriteArraySet;
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        this.f4446f = copyOnWriteArraySet2;
        this.f4447g = new CopyOnWriteArraySet();
        this.f4448h = new CopyOnWriteArraySet();
        this.f4449i = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet3 = new CopyOnWriteArraySet();
        this.f4450j = copyOnWriteArraySet3;
        CopyOnWriteArraySet copyOnWriteArraySet4 = new CopyOnWriteArraySet();
        this.f4451k = copyOnWriteArraySet4;
        Handler handler = new Handler(bVar.f4475i);
        n1[] a6 = bVar.f4468b.a(handler, cVar, cVar, cVar, cVar);
        this.f4442b = a6;
        this.E = 1.0f;
        this.C = 0;
        this.G = Collections.emptyList();
        y yVar = new y(a6, bVar.f4470d, bVar.f4471e, bVar.f4472f, bVar.f4473g, aVar, bVar.f4482p, bVar.f4483q, bVar.f4484r, bVar.f4469c, bVar.f4475i);
        this.f4443c = yVar;
        yVar.u(cVar);
        copyOnWriteArraySet3.add(aVar);
        copyOnWriteArraySet.add(aVar);
        copyOnWriteArraySet4.add(aVar);
        copyOnWriteArraySet2.add(aVar);
        T(aVar);
        com.google.android.exoplayer2.b bVar2 = new com.google.android.exoplayer2.b(bVar.f4467a, handler, cVar);
        this.f4453m = bVar2;
        bVar2.b(bVar.f4479m);
        m mVar = new m(bVar.f4467a, handler, cVar);
        this.f4454n = mVar;
        mVar.m(bVar.f4477k ? this.D : null);
        w1 w1Var = new w1(bVar.f4467a, handler, cVar);
        this.f4455o = w1Var;
        w1Var.h(com.google.android.exoplayer2.util.s0.c0(this.D.f3354c));
        z1 z1Var = new z1(bVar.f4467a);
        this.f4456p = z1Var;
        z1Var.a(bVar.f4478l != 0);
        a2 a2Var = new a2(bVar.f4467a);
        this.f4457q = a2Var;
        a2Var.a(bVar.f4478l == 2);
        this.L = W(w1Var);
        if (!bVar.f4485s) {
            yVar.A();
        }
        l0(1, 3, this.D);
        l0(2, 4, Integer.valueOf(this.f4462v));
        l0(1, androidx.constraintlayout.widget.g.T0, Boolean.valueOf(this.F));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static a1.a W(w1 w1Var) {
        return new a1.a(0, w1Var.d(), w1Var.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a0(boolean z5, int i6) {
        return (!z5 || i6 == 1) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(int i6, int i7) {
        if (i6 == this.f4465y && i7 == this.f4466z) {
            return;
        }
        this.f4465y = i6;
        this.f4466z = i7;
        Iterator it = this.f4445e.iterator();
        while (it.hasNext()) {
            ((s2.l) it.next()).M(i6, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        Iterator it = this.f4446f.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.audio.g gVar = (com.google.android.exoplayer2.audio.g) it.next();
            if (!this.f4451k.contains(gVar)) {
                gVar.b(this.C);
            }
        }
        Iterator it2 = this.f4451k.iterator();
        while (it2.hasNext()) {
            ((com.google.android.exoplayer2.audio.q) it2.next()).b(this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        Iterator it = this.f4446f.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.audio.g gVar = (com.google.android.exoplayer2.audio.g) it.next();
            if (!this.f4451k.contains(gVar)) {
                gVar.a(this.F);
            }
        }
        Iterator it2 = this.f4451k.iterator();
        while (it2.hasNext()) {
            ((com.google.android.exoplayer2.audio.q) it2.next()).a(this.F);
        }
    }

    private void j0() {
        TextureView textureView = this.f4464x;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f4444d) {
                com.google.android.exoplayer2.util.n.h("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f4464x.setSurfaceTextureListener(null);
            }
            this.f4464x = null;
        }
        SurfaceHolder surfaceHolder = this.f4463w;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f4444d);
            this.f4463w = null;
        }
    }

    private void l0(int i6, int i7, Object obj) {
        n1[] n1VarArr;
        for (n1 n1Var : this.f4442b) {
            if (n1Var.i() == i6) {
                this.f4443c.y(n1Var).n(i7).m(obj).l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        l0(1, 2, Float.valueOf(this.E * this.f4454n.g()));
    }

    private void r0(s2.j jVar) {
        l0(2, 8, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(Surface surface, boolean z5) {
        n1[] n1VarArr;
        ArrayList<k1> arrayList = new ArrayList();
        for (n1 n1Var : this.f4442b) {
            if (n1Var.i() == 2) {
                arrayList.add(this.f4443c.y(n1Var).n(1).m(surface).l());
            }
        }
        Surface surface2 = this.f4460t;
        if (surface2 != null && surface2 != surface) {
            try {
                for (k1 k1Var : arrayList) {
                    k1Var.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.f4461u) {
                this.f4460t.release();
            }
        }
        this.f4460t = surface;
        this.f4461u = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(boolean z5, int i6, int i7) {
        int i8 = 0;
        boolean z6 = z5 && i6 != -1;
        if (z6 && i6 != 1) {
            i8 = 1;
        }
        this.f4443c.Z(z6, i8, i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        boolean z5;
        a2 a2Var;
        int b02 = b0();
        if (b02 != 1) {
            if (b02 == 2 || b02 == 3) {
                this.f4456p.b(Z());
                a2Var = this.f4457q;
                z5 = Z();
                a2Var.b(z5);
            } else if (b02 != 4) {
                throw new IllegalStateException();
            }
        }
        z5 = false;
        this.f4456p.b(false);
        a2Var = this.f4457q;
        a2Var.b(z5);
    }

    private void w0() {
        if (Looper.myLooper() != X()) {
            if (this.H) {
                throw new IllegalStateException("Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread");
            }
            com.google.android.exoplayer2.util.n.i("SimpleExoPlayer", "Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread", this.I ? null : new IllegalStateException());
            this.I = true;
        }
    }

    public void S(j1.a aVar) {
        com.google.android.exoplayer2.util.a.e(aVar);
        this.f4443c.u(aVar);
    }

    public void T(n1.f fVar) {
        com.google.android.exoplayer2.util.a.e(fVar);
        this.f4448h.add(fVar);
    }

    public void U(s2.l lVar) {
        com.google.android.exoplayer2.util.a.e(lVar);
        this.f4445e.add(lVar);
    }

    public void V() {
        w0();
        r0(null);
    }

    public Looper X() {
        return this.f4443c.B();
    }

    public long Y() {
        w0();
        return this.f4443c.D();
    }

    public boolean Z() {
        w0();
        return this.f4443c.F();
    }

    @Override // com.google.android.exoplayer2.j1
    public boolean a() {
        w0();
        return this.f4443c.a();
    }

    @Override // com.google.android.exoplayer2.j1
    public long b() {
        w0();
        return this.f4443c.b();
    }

    public int b0() {
        w0();
        return this.f4443c.G();
    }

    @Override // com.google.android.exoplayer2.j1
    public long c() {
        w0();
        return this.f4443c.c();
    }

    @Override // com.google.android.exoplayer2.j1
    public void d(int i6, long j6) {
        w0();
        this.f4452l.d0();
        this.f4443c.d(i6, j6);
    }

    @Override // com.google.android.exoplayer2.j1
    public int e() {
        w0();
        return this.f4443c.e();
    }

    @Override // com.google.android.exoplayer2.j1
    public int f() {
        w0();
        return this.f4443c.f();
    }

    public void f0() {
        w0();
        boolean Z = Z();
        int p5 = this.f4454n.p(Z, 2);
        u0(Z, p5, a0(Z, p5));
        this.f4443c.R();
    }

    @Override // com.google.android.exoplayer2.j1
    public void g(List list, boolean z5) {
        w0();
        this.f4452l.e0();
        this.f4443c.g(list, z5);
    }

    public void g0(w1.v vVar) {
        h0(vVar, true, true);
    }

    @Override // com.google.android.exoplayer2.j1
    public int h() {
        w0();
        return this.f4443c.h();
    }

    public void h0(w1.v vVar, boolean z5, boolean z6) {
        w0();
        o0(Collections.singletonList(vVar), z5 ? 0 : -1, -9223372036854775807L);
        f0();
    }

    @Override // com.google.android.exoplayer2.j1
    public y1 i() {
        w0();
        return this.f4443c.i();
    }

    public void i0() {
        w0();
        this.f4453m.b(false);
        this.f4455o.g();
        this.f4456p.b(false);
        this.f4457q.b(false);
        this.f4454n.i();
        this.f4443c.S();
        j0();
        Surface surface = this.f4460t;
        if (surface != null) {
            if (this.f4461u) {
                surface.release();
            }
            this.f4460t = null;
        }
        if (this.J) {
            android.support.v4.media.a.a(com.google.android.exoplayer2.util.a.e(null));
            throw null;
        }
        this.G = Collections.emptyList();
        this.K = true;
    }

    @Override // com.google.android.exoplayer2.j1
    public int j() {
        w0();
        return this.f4443c.j();
    }

    @Override // com.google.android.exoplayer2.j1
    public long k() {
        w0();
        return this.f4443c.k();
    }

    public void k0() {
        w0();
        f0();
    }

    @Override // com.google.android.exoplayer2.n
    public void n(w0 w0Var) {
        w0();
        this.f4452l.e0();
        this.f4443c.n(w0Var);
    }

    public void n0(w1.v vVar) {
        w0();
        this.f4452l.e0();
        this.f4443c.U(vVar);
    }

    @Override // com.google.android.exoplayer2.n
    public void o(List list) {
        w0();
        this.f4452l.e0();
        this.f4443c.o(list);
    }

    public void o0(List list, int i6, long j6) {
        w0();
        this.f4452l.e0();
        this.f4443c.W(list, i6, j6);
    }

    public void p0(boolean z5) {
        w0();
        int p5 = this.f4454n.p(z5, b0());
        u0(z5, p5, a0(z5, p5));
    }

    public void q0(h1 h1Var) {
        w0();
        this.f4443c.a0(h1Var);
    }

    public void t0(TextureView textureView) {
        w0();
        j0();
        if (textureView != null) {
            V();
        }
        this.f4464x = textureView;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != null) {
                com.google.android.exoplayer2.util.n.h("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
            }
            textureView.setSurfaceTextureListener(this.f4444d);
            SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            if (surfaceTexture != null) {
                s0(new Surface(surfaceTexture), true);
                c0(textureView.getWidth(), textureView.getHeight());
                return;
            }
        }
        s0(null, true);
        c0(0, 0);
    }
}
