package h3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
/* loaded from: classes.dex */
public class k {

    /* renamed from: m  reason: collision with root package name */
    public static final h3.c f10703m = new i(0.5f);

    /* renamed from: a  reason: collision with root package name */
    d f10704a;

    /* renamed from: b  reason: collision with root package name */
    d f10705b;

    /* renamed from: c  reason: collision with root package name */
    d f10706c;

    /* renamed from: d  reason: collision with root package name */
    d f10707d;

    /* renamed from: e  reason: collision with root package name */
    h3.c f10708e;

    /* renamed from: f  reason: collision with root package name */
    h3.c f10709f;

    /* renamed from: g  reason: collision with root package name */
    h3.c f10710g;

    /* renamed from: h  reason: collision with root package name */
    h3.c f10711h;

    /* renamed from: i  reason: collision with root package name */
    f f10712i;

    /* renamed from: j  reason: collision with root package name */
    f f10713j;

    /* renamed from: k  reason: collision with root package name */
    f f10714k;

    /* renamed from: l  reason: collision with root package name */
    f f10715l;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private d f10716a;

        /* renamed from: b  reason: collision with root package name */
        private d f10717b;

        /* renamed from: c  reason: collision with root package name */
        private d f10718c;

        /* renamed from: d  reason: collision with root package name */
        private d f10719d;

        /* renamed from: e  reason: collision with root package name */
        private h3.c f10720e;

        /* renamed from: f  reason: collision with root package name */
        private h3.c f10721f;

        /* renamed from: g  reason: collision with root package name */
        private h3.c f10722g;

        /* renamed from: h  reason: collision with root package name */
        private h3.c f10723h;

        /* renamed from: i  reason: collision with root package name */
        private f f10724i;

        /* renamed from: j  reason: collision with root package name */
        private f f10725j;

        /* renamed from: k  reason: collision with root package name */
        private f f10726k;

        /* renamed from: l  reason: collision with root package name */
        private f f10727l;

        public b() {
            this.f10716a = h.b();
            this.f10717b = h.b();
            this.f10718c = h.b();
            this.f10719d = h.b();
            this.f10720e = new h3.a(0.0f);
            this.f10721f = new h3.a(0.0f);
            this.f10722g = new h3.a(0.0f);
            this.f10723h = new h3.a(0.0f);
            this.f10724i = h.c();
            this.f10725j = h.c();
            this.f10726k = h.c();
            this.f10727l = h.c();
        }

        private static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).f10702a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f10651a;
            }
            return -1.0f;
        }

        public b A(float f6) {
            this.f10720e = new h3.a(f6);
            return this;
        }

        public b B(h3.c cVar) {
            this.f10720e = cVar;
            return this;
        }

        public b C(int i6, h3.c cVar) {
            return D(h.a(i6)).F(cVar);
        }

        public b D(d dVar) {
            this.f10717b = dVar;
            float n5 = n(dVar);
            if (n5 != -1.0f) {
                E(n5);
            }
            return this;
        }

        public b E(float f6) {
            this.f10721f = new h3.a(f6);
            return this;
        }

        public b F(h3.c cVar) {
            this.f10721f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f6) {
            return A(f6).E(f6).w(f6).s(f6);
        }

        public b p(h3.c cVar) {
            return B(cVar).F(cVar).x(cVar).t(cVar);
        }

        public b q(int i6, h3.c cVar) {
            return r(h.a(i6)).t(cVar);
        }

        public b r(d dVar) {
            this.f10719d = dVar;
            float n5 = n(dVar);
            if (n5 != -1.0f) {
                s(n5);
            }
            return this;
        }

        public b s(float f6) {
            this.f10723h = new h3.a(f6);
            return this;
        }

        public b t(h3.c cVar) {
            this.f10723h = cVar;
            return this;
        }

        public b u(int i6, h3.c cVar) {
            return v(h.a(i6)).x(cVar);
        }

        public b v(d dVar) {
            this.f10718c = dVar;
            float n5 = n(dVar);
            if (n5 != -1.0f) {
                w(n5);
            }
            return this;
        }

        public b w(float f6) {
            this.f10722g = new h3.a(f6);
            return this;
        }

        public b x(h3.c cVar) {
            this.f10722g = cVar;
            return this;
        }

        public b y(int i6, h3.c cVar) {
            return z(h.a(i6)).B(cVar);
        }

        public b z(d dVar) {
            this.f10716a = dVar;
            float n5 = n(dVar);
            if (n5 != -1.0f) {
                A(n5);
            }
            return this;
        }

        public b(k kVar) {
            this.f10716a = h.b();
            this.f10717b = h.b();
            this.f10718c = h.b();
            this.f10719d = h.b();
            this.f10720e = new h3.a(0.0f);
            this.f10721f = new h3.a(0.0f);
            this.f10722g = new h3.a(0.0f);
            this.f10723h = new h3.a(0.0f);
            this.f10724i = h.c();
            this.f10725j = h.c();
            this.f10726k = h.c();
            this.f10727l = h.c();
            this.f10716a = kVar.f10704a;
            this.f10717b = kVar.f10705b;
            this.f10718c = kVar.f10706c;
            this.f10719d = kVar.f10707d;
            this.f10720e = kVar.f10708e;
            this.f10721f = kVar.f10709f;
            this.f10722g = kVar.f10710g;
            this.f10723h = kVar.f10711h;
            this.f10724i = kVar.f10712i;
            this.f10725j = kVar.f10713j;
            this.f10726k = kVar.f10714k;
            this.f10727l = kVar.f10715l;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        h3.c a(h3.c cVar);
    }

    public k() {
        this.f10704a = h.b();
        this.f10705b = h.b();
        this.f10706c = h.b();
        this.f10707d = h.b();
        this.f10708e = new h3.a(0.0f);
        this.f10709f = new h3.a(0.0f);
        this.f10710g = new h3.a(0.0f);
        this.f10711h = new h3.a(0.0f);
        this.f10712i = h.c();
        this.f10713j = h.c();
        this.f10714k = h.c();
        this.f10715l = h.c();
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i6, int i7) {
        return c(context, i6, i7, 0);
    }

    private static b c(Context context, int i6, int i7, int i8) {
        return d(context, i6, i7, new h3.a(i8));
    }

    private static b d(Context context, int i6, int i7, h3.c cVar) {
        if (i7 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i6);
            i6 = i7;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i6, u2.j.H3);
        try {
            int i8 = obtainStyledAttributes.getInt(u2.j.I3, 0);
            int i9 = obtainStyledAttributes.getInt(u2.j.L3, i8);
            int i10 = obtainStyledAttributes.getInt(u2.j.M3, i8);
            int i11 = obtainStyledAttributes.getInt(u2.j.K3, i8);
            int i12 = obtainStyledAttributes.getInt(u2.j.J3, i8);
            h3.c m5 = m(obtainStyledAttributes, u2.j.N3, cVar);
            h3.c m6 = m(obtainStyledAttributes, u2.j.Q3, m5);
            h3.c m7 = m(obtainStyledAttributes, u2.j.R3, m5);
            h3.c m8 = m(obtainStyledAttributes, u2.j.P3, m5);
            return new b().y(i9, m6).C(i10, m7).u(i11, m8).q(i12, m(obtainStyledAttributes, u2.j.O3, m5));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i6, int i7) {
        return f(context, attributeSet, i6, i7, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i6, int i7, int i8) {
        return g(context, attributeSet, i6, i7, new h3.a(i8));
    }

    public static b g(Context context, AttributeSet attributeSet, int i6, int i7, h3.c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u2.j.P2, i6, i7);
        int resourceId = obtainStyledAttributes.getResourceId(u2.j.Q2, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(u2.j.R2, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    private static h3.c m(TypedArray typedArray, int i6, h3.c cVar) {
        TypedValue peekValue = typedArray.peekValue(i6);
        if (peekValue == null) {
            return cVar;
        }
        int i7 = peekValue.type;
        return i7 == 5 ? new h3.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i7 == 6 ? new i(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.f10714k;
    }

    public d i() {
        return this.f10707d;
    }

    public h3.c j() {
        return this.f10711h;
    }

    public d k() {
        return this.f10706c;
    }

    public h3.c l() {
        return this.f10710g;
    }

    public f n() {
        return this.f10715l;
    }

    public f o() {
        return this.f10713j;
    }

    public f p() {
        return this.f10712i;
    }

    public d q() {
        return this.f10704a;
    }

    public h3.c r() {
        return this.f10708e;
    }

    public d s() {
        return this.f10705b;
    }

    public h3.c t() {
        return this.f10709f;
    }

    public boolean u(RectF rectF) {
        boolean z5 = this.f10715l.getClass().equals(f.class) && this.f10713j.getClass().equals(f.class) && this.f10712i.getClass().equals(f.class) && this.f10714k.getClass().equals(f.class);
        float a6 = this.f10708e.a(rectF);
        return z5 && ((this.f10709f.a(rectF) > a6 ? 1 : (this.f10709f.a(rectF) == a6 ? 0 : -1)) == 0 && (this.f10711h.a(rectF) > a6 ? 1 : (this.f10711h.a(rectF) == a6 ? 0 : -1)) == 0 && (this.f10710g.a(rectF) > a6 ? 1 : (this.f10710g.a(rectF) == a6 ? 0 : -1)) == 0) && ((this.f10705b instanceof j) && (this.f10704a instanceof j) && (this.f10706c instanceof j) && (this.f10707d instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f6) {
        return v().o(f6).m();
    }

    public k x(h3.c cVar) {
        return v().p(cVar).m();
    }

    public k y(c cVar) {
        return v().B(cVar.a(r())).F(cVar.a(t())).t(cVar.a(j())).x(cVar.a(l())).m();
    }

    private k(b bVar) {
        this.f10704a = bVar.f10716a;
        this.f10705b = bVar.f10717b;
        this.f10706c = bVar.f10718c;
        this.f10707d = bVar.f10719d;
        this.f10708e = bVar.f10720e;
        this.f10709f = bVar.f10721f;
        this.f10710g = bVar.f10722g;
        this.f10711h = bVar.f10723h;
        this.f10712i = bVar.f10724i;
        this.f10713j = bVar.f10725j;
        this.f10714k = bVar.f10726k;
        this.f10715l = bVar.f10727l;
    }
}
