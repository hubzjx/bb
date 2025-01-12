package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
/* loaded from: classes.dex */
public abstract class y1 {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal f1136a = new ThreadLocal();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f1137b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f1138c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f1139d = {16843518};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f1140e = {16842919};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f1141f = {16842912};

    /* renamed from: g  reason: collision with root package name */
    static final int[] f1142g = {16842913};

    /* renamed from: h  reason: collision with root package name */
    static final int[] f1143h = {-16842919, -16842908};

    /* renamed from: i  reason: collision with root package name */
    static final int[] f1144i = new int[0];

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f1145j = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(b.j.f2838z0);
        try {
            if (!obtainStyledAttributes.hasValue(b.j.E0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i6) {
        ColorStateList e6 = e(context, i6);
        if (e6 == null || !e6.isStateful()) {
            TypedValue f6 = f();
            context.getTheme().resolveAttribute(16842803, f6, true);
            return d(context, i6, f6.getFloat());
        }
        return e6.getColorForState(f1137b, e6.getDefaultColor());
    }

    public static int c(Context context, int i6) {
        int[] iArr = f1145j;
        iArr[0] = i6;
        c2 u5 = c2.u(context, null, iArr);
        try {
            return u5.b(0, 0);
        } finally {
            u5.w();
        }
    }

    static int d(Context context, int i6, float f6) {
        int c6 = c(context, i6);
        return w.a.h(c6, Math.round(Color.alpha(c6) * f6));
    }

    public static ColorStateList e(Context context, int i6) {
        int[] iArr = f1145j;
        iArr[0] = i6;
        c2 u5 = c2.u(context, null, iArr);
        try {
            return u5.c(0);
        } finally {
            u5.w();
        }
    }

    private static TypedValue f() {
        ThreadLocal threadLocal = f1136a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }
}
