package e0;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
/* loaded from: classes.dex */
public class v0 {

    /* renamed from: b  reason: collision with root package name */
    public static final v0 f9372b;

    /* renamed from: a  reason: collision with root package name */
    private final l f9373a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Field f9374a;

        /* renamed from: b  reason: collision with root package name */
        private static Field f9375b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f9376c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f9377d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f9374a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f9375b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f9376c = declaredField3;
                declaredField3.setAccessible(true);
                f9377d = true;
            } catch (ReflectiveOperationException e6) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e6.getMessage(), e6);
            }
        }

        public static v0 a(View view) {
            if (f9377d && view.isAttachedToWindow()) {
                try {
                    Object obj = f9374a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f9375b.get(obj);
                        Rect rect2 = (Rect) f9376c.get(obj);
                        if (rect != null && rect2 != null) {
                            v0 a6 = new b().b(w.g.c(rect)).c(w.g.c(rect2)).a();
                            a6.p(a6);
                            a6.d(view.getRootView());
                            return a6;
                        }
                    }
                } catch (IllegalAccessException e6) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e6.getMessage(), e6);
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final f f9378a;

        public b() {
            int i6 = Build.VERSION.SDK_INT;
            this.f9378a = i6 >= 30 ? new e() : i6 >= 29 ? new d() : new c();
        }

        public v0 a() {
            return this.f9378a.b();
        }

        public b b(w.g gVar) {
            this.f9378a.d(gVar);
            return this;
        }

        public b c(w.g gVar) {
            this.f9378a.f(gVar);
            return this;
        }

        public b(v0 v0Var) {
            int i6 = Build.VERSION.SDK_INT;
            this.f9378a = i6 >= 30 ? new e(v0Var) : i6 >= 29 ? new d(v0Var) : new c(v0Var);
        }
    }

    /* loaded from: classes.dex */
    private static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private static Field f9379e;

        /* renamed from: f  reason: collision with root package name */
        private static boolean f9380f;

        /* renamed from: g  reason: collision with root package name */
        private static Constructor f9381g;

        /* renamed from: h  reason: collision with root package name */
        private static boolean f9382h;

        /* renamed from: c  reason: collision with root package name */
        private WindowInsets f9383c;

        /* renamed from: d  reason: collision with root package name */
        private w.g f9384d;

        c() {
            this.f9383c = h();
        }

        private static WindowInsets h() {
            if (!f9380f) {
                try {
                    f9379e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e6) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e6);
                }
                f9380f = true;
            }
            Field field = f9379e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e7) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e7);
                }
            }
            if (!f9382h) {
                try {
                    f9381g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e8) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e8);
                }
                f9382h = true;
            }
            Constructor constructor = f9381g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e9) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e9);
                }
            }
            return null;
        }

        @Override // e0.v0.f
        v0 b() {
            a();
            v0 s5 = v0.s(this.f9383c);
            s5.n(this.f9387b);
            s5.q(this.f9384d);
            return s5;
        }

        @Override // e0.v0.f
        void d(w.g gVar) {
            this.f9384d = gVar;
        }

        @Override // e0.v0.f
        void f(w.g gVar) {
            WindowInsets windowInsets = this.f9383c;
            if (windowInsets != null) {
                this.f9383c = windowInsets.replaceSystemWindowInsets(gVar.f13690a, gVar.f13691b, gVar.f13692c, gVar.f13693d);
            }
        }

        c(v0 v0Var) {
            this.f9383c = v0Var.r();
        }
    }

    /* loaded from: classes.dex */
    private static class d extends f {

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets.Builder f9385c;

        d() {
            e1.a();
            this.f9385c = c1.a();
        }

        @Override // e0.v0.f
        v0 b() {
            WindowInsets build;
            a();
            build = this.f9385c.build();
            v0 s5 = v0.s(build);
            s5.n(this.f9387b);
            return s5;
        }

        @Override // e0.v0.f
        void c(w.g gVar) {
            this.f9385c.setMandatorySystemGestureInsets(gVar.e());
        }

        @Override // e0.v0.f
        void d(w.g gVar) {
            this.f9385c.setStableInsets(gVar.e());
        }

        @Override // e0.v0.f
        void e(w.g gVar) {
            this.f9385c.setSystemGestureInsets(gVar.e());
        }

        @Override // e0.v0.f
        void f(w.g gVar) {
            this.f9385c.setSystemWindowInsets(gVar.e());
        }

        @Override // e0.v0.f
        void g(w.g gVar) {
            this.f9385c.setTappableElementInsets(gVar.e());
        }

        d(v0 v0Var) {
            WindowInsets.Builder a6;
            WindowInsets r5 = v0Var.r();
            if (r5 != null) {
                e1.a();
                a6 = d1.a(r5);
            } else {
                e1.a();
                a6 = c1.a();
            }
            this.f9385c = a6;
        }
    }

    /* loaded from: classes.dex */
    private static class e extends d {
        e() {
        }

        e(v0 v0Var) {
            super(v0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private final v0 f9386a;

        /* renamed from: b  reason: collision with root package name */
        w.g[] f9387b;

        f() {
            this(new v0((v0) null));
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected final void a() {
            w.g gVar;
            w.g gVar2;
            w.g gVar3;
            w.g[] gVarArr = this.f9387b;
            if (gVarArr == null) {
                return;
            }
            w.g gVar4 = gVarArr[m.a(1)];
            w.g gVar5 = this.f9387b[m.a(2)];
            if (gVar4 != null && gVar5 != null) {
                gVar4 = w.g.a(gVar4, gVar5);
            } else if (gVar4 == null) {
                if (gVar5 != null) {
                    f(gVar5);
                }
                gVar = this.f9387b[m.a(16)];
                if (gVar != null) {
                    e(gVar);
                }
                gVar2 = this.f9387b[m.a(32)];
                if (gVar2 != null) {
                    c(gVar2);
                }
                gVar3 = this.f9387b[m.a(64)];
                if (gVar3 == null) {
                    g(gVar3);
                    return;
                }
                return;
            }
            f(gVar4);
            gVar = this.f9387b[m.a(16)];
            if (gVar != null) {
            }
            gVar2 = this.f9387b[m.a(32)];
            if (gVar2 != null) {
            }
            gVar3 = this.f9387b[m.a(64)];
            if (gVar3 == null) {
            }
        }

        abstract v0 b();

        void c(w.g gVar) {
        }

        abstract void d(w.g gVar);

        void e(w.g gVar) {
        }

        abstract void f(w.g gVar);

        void g(w.g gVar) {
        }

        f(v0 v0Var) {
            this.f9386a = v0Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g extends l {

        /* renamed from: h  reason: collision with root package name */
        private static boolean f9388h;

        /* renamed from: i  reason: collision with root package name */
        private static Method f9389i;

        /* renamed from: j  reason: collision with root package name */
        private static Class f9390j;

        /* renamed from: k  reason: collision with root package name */
        private static Class f9391k;

        /* renamed from: l  reason: collision with root package name */
        private static Field f9392l;

        /* renamed from: m  reason: collision with root package name */
        private static Field f9393m;

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets f9394c;

        /* renamed from: d  reason: collision with root package name */
        private w.g[] f9395d;

        /* renamed from: e  reason: collision with root package name */
        private w.g f9396e;

        /* renamed from: f  reason: collision with root package name */
        private v0 f9397f;

        /* renamed from: g  reason: collision with root package name */
        w.g f9398g;

        g(v0 v0Var, WindowInsets windowInsets) {
            super(v0Var);
            this.f9396e = null;
            this.f9394c = windowInsets;
        }

        private w.g q(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f9388h) {
                    r();
                }
                Method method = f9389i;
                if (method != null && f9391k != null && f9392l != null) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f9392l.get(f9393m.get(invoke));
                        if (rect != null) {
                            return w.g.c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e6) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e6.getMessage(), e6);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void r() {
            try {
                f9389i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                f9390j = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f9391k = cls;
                f9392l = cls.getDeclaredField("mVisibleInsets");
                f9393m = f9390j.getDeclaredField("mAttachInfo");
                f9392l.setAccessible(true);
                f9393m.setAccessible(true);
            } catch (ReflectiveOperationException e6) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e6.getMessage(), e6);
            }
            f9388h = true;
        }

        @Override // e0.v0.l
        void d(View view) {
            w.g q5 = q(view);
            if (q5 == null) {
                q5 = w.g.f13689e;
            }
            n(q5);
        }

        @Override // e0.v0.l
        void e(v0 v0Var) {
            v0Var.p(this.f9397f);
            v0Var.o(this.f9398g);
        }

        @Override // e0.v0.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f9398g, ((g) obj).f9398g);
            }
            return false;
        }

        @Override // e0.v0.l
        final w.g i() {
            if (this.f9396e == null) {
                this.f9396e = w.g.b(this.f9394c.getSystemWindowInsetLeft(), this.f9394c.getSystemWindowInsetTop(), this.f9394c.getSystemWindowInsetRight(), this.f9394c.getSystemWindowInsetBottom());
            }
            return this.f9396e;
        }

        @Override // e0.v0.l
        v0 j(int i6, int i7, int i8, int i9) {
            b bVar = new b(v0.s(this.f9394c));
            bVar.c(v0.k(i(), i6, i7, i8, i9));
            bVar.b(v0.k(h(), i6, i7, i8, i9));
            return bVar.a();
        }

        @Override // e0.v0.l
        boolean l() {
            return this.f9394c.isRound();
        }

        @Override // e0.v0.l
        public void m(w.g[] gVarArr) {
            this.f9395d = gVarArr;
        }

        @Override // e0.v0.l
        void n(w.g gVar) {
            this.f9398g = gVar;
        }

        @Override // e0.v0.l
        void o(v0 v0Var) {
            this.f9397f = v0Var;
        }

        g(v0 v0Var, g gVar) {
            this(v0Var, new WindowInsets(gVar.f9394c));
        }
    }

    /* loaded from: classes.dex */
    private static class h extends g {

        /* renamed from: n  reason: collision with root package name */
        private w.g f9399n;

        h(v0 v0Var, WindowInsets windowInsets) {
            super(v0Var, windowInsets);
            this.f9399n = null;
        }

        @Override // e0.v0.l
        v0 b() {
            return v0.s(this.f9394c.consumeStableInsets());
        }

        @Override // e0.v0.l
        v0 c() {
            return v0.s(this.f9394c.consumeSystemWindowInsets());
        }

        @Override // e0.v0.l
        final w.g h() {
            if (this.f9399n == null) {
                this.f9399n = w.g.b(this.f9394c.getStableInsetLeft(), this.f9394c.getStableInsetTop(), this.f9394c.getStableInsetRight(), this.f9394c.getStableInsetBottom());
            }
            return this.f9399n;
        }

        @Override // e0.v0.l
        boolean k() {
            return this.f9394c.isConsumed();
        }

        @Override // e0.v0.l
        public void p(w.g gVar) {
            this.f9399n = gVar;
        }

        h(v0 v0Var, h hVar) {
            super(v0Var, hVar);
            this.f9399n = null;
            this.f9399n = hVar.f9399n;
        }
    }

    /* loaded from: classes.dex */
    private static class i extends h {
        i(v0 v0Var, WindowInsets windowInsets) {
            super(v0Var, windowInsets);
        }

        @Override // e0.v0.l
        v0 a() {
            WindowInsets consumeDisplayCutout;
            consumeDisplayCutout = this.f9394c.consumeDisplayCutout();
            return v0.s(consumeDisplayCutout);
        }

        @Override // e0.v0.g, e0.v0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof i) {
                i iVar = (i) obj;
                return Objects.equals(this.f9394c, iVar.f9394c) && Objects.equals(this.f9398g, iVar.f9398g);
            }
            return false;
        }

        @Override // e0.v0.l
        e0.c f() {
            DisplayCutout displayCutout;
            displayCutout = this.f9394c.getDisplayCutout();
            return e0.c.a(displayCutout);
        }

        @Override // e0.v0.l
        public int hashCode() {
            return this.f9394c.hashCode();
        }

        i(v0 v0Var, i iVar) {
            super(v0Var, iVar);
        }
    }

    /* loaded from: classes.dex */
    private static class j extends i {

        /* renamed from: o  reason: collision with root package name */
        private w.g f9400o;

        /* renamed from: p  reason: collision with root package name */
        private w.g f9401p;

        /* renamed from: q  reason: collision with root package name */
        private w.g f9402q;

        j(v0 v0Var, WindowInsets windowInsets) {
            super(v0Var, windowInsets);
            this.f9400o = null;
            this.f9401p = null;
            this.f9402q = null;
        }

        @Override // e0.v0.l
        w.g g() {
            Insets mandatorySystemGestureInsets;
            if (this.f9401p == null) {
                mandatorySystemGestureInsets = this.f9394c.getMandatorySystemGestureInsets();
                this.f9401p = w.g.d(mandatorySystemGestureInsets);
            }
            return this.f9401p;
        }

        @Override // e0.v0.g, e0.v0.l
        v0 j(int i6, int i7, int i8, int i9) {
            WindowInsets inset;
            inset = this.f9394c.inset(i6, i7, i8, i9);
            return v0.s(inset);
        }

        @Override // e0.v0.h, e0.v0.l
        public void p(w.g gVar) {
        }

        j(v0 v0Var, j jVar) {
            super(v0Var, jVar);
            this.f9400o = null;
            this.f9401p = null;
            this.f9402q = null;
        }
    }

    /* loaded from: classes.dex */
    private static class k extends j {

        /* renamed from: r  reason: collision with root package name */
        static final v0 f9403r = v0.s(WindowInsets.CONSUMED);

        k(v0 v0Var, WindowInsets windowInsets) {
            super(v0Var, windowInsets);
        }

        @Override // e0.v0.g, e0.v0.l
        final void d(View view) {
        }

        k(v0 v0Var, k kVar) {
            super(v0Var, kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: b  reason: collision with root package name */
        static final v0 f9404b = new b().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        final v0 f9405a;

        l(v0 v0Var) {
            this.f9405a = v0Var;
        }

        v0 a() {
            return this.f9405a;
        }

        v0 b() {
            return this.f9405a;
        }

        v0 c() {
            return this.f9405a;
        }

        void d(View view) {
        }

        void e(v0 v0Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof l) {
                l lVar = (l) obj;
                return l() == lVar.l() && k() == lVar.k() && d0.d.a(i(), lVar.i()) && d0.d.a(h(), lVar.h()) && d0.d.a(f(), lVar.f());
            }
            return false;
        }

        e0.c f() {
            return null;
        }

        w.g g() {
            return i();
        }

        w.g h() {
            return w.g.f13689e;
        }

        public int hashCode() {
            return d0.d.b(Boolean.valueOf(l()), Boolean.valueOf(k()), i(), h(), f());
        }

        w.g i() {
            return w.g.f13689e;
        }

        v0 j(int i6, int i7, int i8, int i9) {
            return f9404b;
        }

        boolean k() {
            return false;
        }

        boolean l() {
            return false;
        }

        public void m(w.g[] gVarArr) {
        }

        void n(w.g gVar) {
        }

        void o(v0 v0Var) {
        }

        public void p(w.g gVar) {
        }
    }

    /* loaded from: classes.dex */
    public static final class m {
        static int a(int i6) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 4) {
                        if (i6 != 8) {
                            if (i6 != 16) {
                                if (i6 != 32) {
                                    if (i6 != 64) {
                                        if (i6 != 128) {
                                            if (i6 == 256) {
                                                return 8;
                                            }
                                            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i6);
                                        }
                                        return 7;
                                    }
                                    return 6;
                                }
                                return 5;
                            }
                            return 4;
                        }
                        return 3;
                    }
                    return 2;
                }
                return 1;
            }
            return 0;
        }
    }

    static {
        f9372b = Build.VERSION.SDK_INT >= 30 ? k.f9403r : l.f9404b;
    }

    private v0(WindowInsets windowInsets) {
        int i6 = Build.VERSION.SDK_INT;
        this.f9373a = i6 >= 30 ? new k(this, windowInsets) : i6 >= 29 ? new j(this, windowInsets) : i6 >= 28 ? new i(this, windowInsets) : new h(this, windowInsets);
    }

    static w.g k(w.g gVar, int i6, int i7, int i8, int i9) {
        int max = Math.max(0, gVar.f13690a - i6);
        int max2 = Math.max(0, gVar.f13691b - i7);
        int max3 = Math.max(0, gVar.f13692c - i8);
        int max4 = Math.max(0, gVar.f13693d - i9);
        return (max == i6 && max2 == i7 && max3 == i8 && max4 == i9) ? gVar : w.g.b(max, max2, max3, max4);
    }

    public static v0 s(WindowInsets windowInsets) {
        return t(windowInsets, null);
    }

    public static v0 t(WindowInsets windowInsets, View view) {
        v0 v0Var = new v0((WindowInsets) d0.i.c(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            v0Var.p(b0.H(view));
            v0Var.d(view.getRootView());
        }
        return v0Var;
    }

    public v0 a() {
        return this.f9373a.a();
    }

    public v0 b() {
        return this.f9373a.b();
    }

    public v0 c() {
        return this.f9373a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        this.f9373a.d(view);
    }

    public w.g e() {
        return this.f9373a.g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v0) {
            return d0.d.a(this.f9373a, ((v0) obj).f9373a);
        }
        return false;
    }

    public int f() {
        return this.f9373a.i().f13693d;
    }

    public int g() {
        return this.f9373a.i().f13690a;
    }

    public int h() {
        return this.f9373a.i().f13692c;
    }

    public int hashCode() {
        l lVar = this.f9373a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public int i() {
        return this.f9373a.i().f13691b;
    }

    public v0 j(int i6, int i7, int i8, int i9) {
        return this.f9373a.j(i6, i7, i8, i9);
    }

    public boolean l() {
        return this.f9373a.k();
    }

    public v0 m(int i6, int i7, int i8, int i9) {
        return new b(this).c(w.g.b(i6, i7, i8, i9)).a();
    }

    void n(w.g[] gVarArr) {
        this.f9373a.m(gVarArr);
    }

    void o(w.g gVar) {
        this.f9373a.n(gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(v0 v0Var) {
        this.f9373a.o(v0Var);
    }

    void q(w.g gVar) {
        this.f9373a.p(gVar);
    }

    public WindowInsets r() {
        l lVar = this.f9373a;
        if (lVar instanceof g) {
            return ((g) lVar).f9394c;
        }
        return null;
    }

    public v0(v0 v0Var) {
        if (v0Var == null) {
            this.f9373a = new l(this);
            return;
        }
        l lVar = v0Var.f9373a;
        int i6 = Build.VERSION.SDK_INT;
        this.f9373a = (i6 < 30 || !(lVar instanceof k)) ? (i6 < 29 || !(lVar instanceof j)) ? (i6 < 28 || !(lVar instanceof i)) ? lVar instanceof h ? new h(this, (h) lVar) : lVar instanceof g ? new g(this, (g) lVar) : new l(this) : new i(this, (i) lVar) : new j(this, (j) lVar) : new k(this, (k) lVar);
        lVar.e(this);
    }
}
