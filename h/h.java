package h;

import android.view.View;
import android.view.animation.Interpolator;
import e0.r0;
import e0.s0;
import e0.t0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class h {

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f10585c;

    /* renamed from: d  reason: collision with root package name */
    s0 f10586d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10587e;

    /* renamed from: b  reason: collision with root package name */
    private long f10584b = -1;

    /* renamed from: f  reason: collision with root package name */
    private final t0 f10588f = new a();

    /* renamed from: a  reason: collision with root package name */
    final ArrayList f10583a = new ArrayList();

    /* loaded from: classes.dex */
    class a extends t0 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f10589a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f10590b = 0;

        a() {
        }

        @Override // e0.s0
        public void b(View view) {
            int i6 = this.f10590b + 1;
            this.f10590b = i6;
            if (i6 == h.this.f10583a.size()) {
                s0 s0Var = h.this.f10586d;
                if (s0Var != null) {
                    s0Var.b(null);
                }
                d();
            }
        }

        @Override // e0.t0, e0.s0
        public void c(View view) {
            if (this.f10589a) {
                return;
            }
            this.f10589a = true;
            s0 s0Var = h.this.f10586d;
            if (s0Var != null) {
                s0Var.c(null);
            }
        }

        void d() {
            this.f10590b = 0;
            this.f10589a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f10587e) {
            Iterator it = this.f10583a.iterator();
            while (it.hasNext()) {
                ((r0) it.next()).b();
            }
            this.f10587e = false;
        }
    }

    void b() {
        this.f10587e = false;
    }

    public h c(r0 r0Var) {
        if (!this.f10587e) {
            this.f10583a.add(r0Var);
        }
        return this;
    }

    public h d(r0 r0Var, r0 r0Var2) {
        this.f10583a.add(r0Var);
        r0Var2.h(r0Var.c());
        this.f10583a.add(r0Var2);
        return this;
    }

    public h e(long j6) {
        if (!this.f10587e) {
            this.f10584b = j6;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f10587e) {
            this.f10585c = interpolator;
        }
        return this;
    }

    public h g(s0 s0Var) {
        if (!this.f10587e) {
            this.f10586d = s0Var;
        }
        return this;
    }

    public void h() {
        if (this.f10587e) {
            return;
        }
        Iterator it = this.f10583a.iterator();
        while (it.hasNext()) {
            r0 r0Var = (r0) it.next();
            long j6 = this.f10584b;
            if (j6 >= 0) {
                r0Var.d(j6);
            }
            Interpolator interpolator = this.f10585c;
            if (interpolator != null) {
                r0Var.e(interpolator);
            }
            if (this.f10586d != null) {
                r0Var.f(this.f10588f);
            }
            r0Var.j();
        }
        this.f10587e = true;
    }
}
