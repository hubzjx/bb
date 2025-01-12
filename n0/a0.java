package n0;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class a0 {

    /* renamed from: a  reason: collision with root package name */
    private static final m0 f12054a;

    /* renamed from: b  reason: collision with root package name */
    static final Property f12055b;

    /* renamed from: c  reason: collision with root package name */
    static final Property f12056c;

    /* loaded from: classes.dex */
    static class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(a0.c(view));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, Float f6) {
            a0.g(view, f6.floatValue());
        }
    }

    /* loaded from: classes.dex */
    static class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Rect get(View view) {
            return e0.b0.u(view);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, Rect rect) {
            e0.b0.r0(view, rect);
        }
    }

    static {
        int i6 = Build.VERSION.SDK_INT;
        f12054a = i6 >= 29 ? new l0() : i6 >= 23 ? new k0() : i6 >= 22 ? new i0() : new g0();
        f12055b = new a(Float.class, "translationAlpha");
        f12056c = new b(Rect.class, "clipBounds");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        f12054a.a(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z b(View view) {
        return new y(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(View view) {
        return f12054a.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p0 d(View view) {
        return new o0(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(View view) {
        f12054a.d(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(View view, int i6, int i7, int i8, int i9) {
        f12054a.e(view, i6, i7, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(View view, float f6) {
        f12054a.f(view, f6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(View view, int i6) {
        f12054a.g(view, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(View view, Matrix matrix) {
        f12054a.h(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(View view, Matrix matrix) {
        f12054a.i(view, matrix);
    }
}
