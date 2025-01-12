package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class t1 {

    /* renamed from: i  reason: collision with root package name */
    private static t1 f1068i;

    /* renamed from: a  reason: collision with root package name */
    private WeakHashMap f1070a;

    /* renamed from: b  reason: collision with root package name */
    private l.g f1071b;

    /* renamed from: c  reason: collision with root package name */
    private l.h f1072c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakHashMap f1073d = new WeakHashMap(0);

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f1074e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1075f;

    /* renamed from: g  reason: collision with root package name */
    private e f1076g;

    /* renamed from: h  reason: collision with root package name */
    private static final PorterDuff.Mode f1067h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j  reason: collision with root package name */
    private static final c f1069j = new c(6);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements d {
        a() {
        }

        @Override // androidx.appcompat.widget.t1.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return f.a.l(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e6) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e6);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements d {
        b() {
        }

        @Override // androidx.appcompat.widget.t1.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e6) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e6);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends l.e {
        public c(int i6) {
            super(i6);
        }

        private static int h(int i6, PorterDuff.Mode mode) {
            return ((i6 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter i(int i6, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) c(Integer.valueOf(h(i6, mode)));
        }

        PorterDuffColorFilter j(int i6, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) d(Integer.valueOf(h(i6, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        boolean a(Context context, int i6, Drawable drawable);

        PorterDuff.Mode b(int i6);

        Drawable c(t1 t1Var, Context context, int i6);

        ColorStateList d(Context context, int i6);

        boolean e(Context context, int i6, Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f implements d {
        f() {
        }

        @Override // androidx.appcompat.widget.t1.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.g.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e6) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e6);
                return null;
            }
        }
    }

    private void a(String str, d dVar) {
        if (this.f1071b == null) {
            this.f1071b = new l.g();
        }
        this.f1071b.put(str, dVar);
    }

    private synchronized boolean b(Context context, long j6, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            l.d dVar = (l.d) this.f1073d.get(context);
            if (dVar == null) {
                dVar = new l.d();
                this.f1073d.put(context, dVar);
            }
            dVar.i(j6, new WeakReference(constantState));
            return true;
        }
        return false;
    }

    private void c(Context context, int i6, ColorStateList colorStateList) {
        if (this.f1070a == null) {
            this.f1070a = new WeakHashMap();
        }
        l.h hVar = (l.h) this.f1070a.get(context);
        if (hVar == null) {
            hVar = new l.h();
            this.f1070a.put(context, hVar);
        }
        hVar.a(i6, colorStateList);
    }

    private void d(Context context) {
        if (this.f1075f) {
            return;
        }
        this.f1075f = true;
        Drawable j6 = j(context, g.a.abc_vector_test);
        if (j6 == null || !q(j6)) {
            this.f1075f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long e(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable f(Context context, int i6) {
        if (this.f1074e == null) {
            this.f1074e = new TypedValue();
        }
        TypedValue typedValue = this.f1074e;
        context.getResources().getValue(i6, typedValue, true);
        long e6 = e(typedValue);
        Drawable i7 = i(context, e6);
        if (i7 != null) {
            return i7;
        }
        e eVar = this.f1076g;
        Drawable c6 = eVar == null ? null : eVar.c(this, context, i6);
        if (c6 != null) {
            c6.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e6, c6);
        }
        return c6;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized t1 h() {
        t1 t1Var;
        synchronized (t1.class) {
            if (f1068i == null) {
                t1 t1Var2 = new t1();
                f1068i = t1Var2;
                p(t1Var2);
            }
            t1Var = f1068i;
        }
        return t1Var;
    }

    private synchronized Drawable i(Context context, long j6) {
        l.d dVar = (l.d) this.f1073d.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) dVar.e(j6);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.j(j6);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i6, PorterDuff.Mode mode) {
        PorterDuffColorFilter i7;
        synchronized (t1.class) {
            c cVar = f1069j;
            i7 = cVar.i(i6, mode);
            if (i7 == null) {
                i7 = new PorterDuffColorFilter(i6, mode);
                cVar.j(i6, mode, i7);
            }
        }
        return i7;
    }

    private ColorStateList n(Context context, int i6) {
        l.h hVar;
        WeakHashMap weakHashMap = this.f1070a;
        if (weakHashMap == null || (hVar = (l.h) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) hVar.e(i6);
    }

    private static void p(t1 t1Var) {
        if (Build.VERSION.SDK_INT < 24) {
            t1Var.a("vector", new f());
            t1Var.a("animated-vector", new b());
            t1Var.a("animated-selector", new a());
        }
    }

    private static boolean q(Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.graphics.drawable.g) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable r(Context context, int i6) {
        int next;
        l.g gVar = this.f1071b;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        l.h hVar = this.f1072c;
        if (hVar != null) {
            String str = (String) hVar.e(i6);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f1071b.get(str) == null)) {
                return null;
            }
        } else {
            this.f1072c = new l.h();
        }
        if (this.f1074e == null) {
            this.f1074e = new TypedValue();
        }
        TypedValue typedValue = this.f1074e;
        Resources resources = context.getResources();
        resources.getValue(i6, typedValue, true);
        long e6 = e(typedValue);
        Drawable i7 = i(context, e6);
        if (i7 != null) {
            return i7;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i6);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f1072c.a(i6, name);
                d dVar = (d) this.f1071b.get(name);
                if (dVar != null) {
                    i7 = dVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (i7 != null) {
                    i7.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, e6, i7);
                }
            } catch (Exception e7) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e7);
            }
        }
        if (i7 == null) {
            this.f1072c.a(i6, "appcompat_skip_skip");
        }
        return i7;
    }

    private Drawable v(Context context, int i6, boolean z5, Drawable drawable) {
        ColorStateList m5 = m(context, i6);
        if (m5 == null) {
            e eVar = this.f1076g;
            if ((eVar == null || !eVar.e(context, i6, drawable)) && !x(context, i6, drawable) && z5) {
                return null;
            }
            return drawable;
        }
        if (f1.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable r5 = x.b.r(drawable);
        x.b.o(r5, m5);
        PorterDuff.Mode o5 = o(i6);
        if (o5 != null) {
            x.b.p(r5, o5);
            return r5;
        }
        return r5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(Drawable drawable, a2 a2Var, int[] iArr) {
        if (f1.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z5 = a2Var.f830d;
        if (z5 || a2Var.f829c) {
            drawable.setColorFilter(g(z5 ? a2Var.f827a : null, a2Var.f829c ? a2Var.f828b : f1067h, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public synchronized Drawable j(Context context, int i6) {
        return k(context, i6, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable k(Context context, int i6, boolean z5) {
        Drawable r5;
        d(context);
        r5 = r(context, i6);
        if (r5 == null) {
            r5 = f(context, i6);
        }
        if (r5 == null) {
            r5 = u.c.c(context, i6);
        }
        if (r5 != null) {
            r5 = v(context, i6, z5, r5);
        }
        if (r5 != null) {
            f1.b(r5);
        }
        return r5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList m(Context context, int i6) {
        ColorStateList n5;
        n5 = n(context, i6);
        if (n5 == null) {
            e eVar = this.f1076g;
            n5 = eVar == null ? null : eVar.d(context, i6);
            if (n5 != null) {
                c(context, i6, n5);
            }
        }
        return n5;
    }

    PorterDuff.Mode o(int i6) {
        e eVar = this.f1076g;
        if (eVar == null) {
            return null;
        }
        return eVar.b(i6);
    }

    public synchronized void s(Context context) {
        l.d dVar = (l.d) this.f1073d.get(context);
        if (dVar != null) {
            dVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable t(Context context, i2 i2Var, int i6) {
        Drawable r5 = r(context, i6);
        if (r5 == null) {
            r5 = i2Var.c(i6);
        }
        if (r5 != null) {
            return v(context, i6, false, r5);
        }
        return null;
    }

    public synchronized void u(e eVar) {
        this.f1076g = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(Context context, int i6, Drawable drawable) {
        e eVar = this.f1076g;
        return eVar != null && eVar.a(context, i6, drawable);
    }
}
