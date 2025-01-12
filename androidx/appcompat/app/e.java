package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.c1;
import androidx.appcompat.widget.k;
import androidx.appcompat.widget.m;
import androidx.appcompat.widget.n0;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.p;
import androidx.appcompat.widget.s;
import androidx.appcompat.widget.t;
import androidx.appcompat.widget.u;
import androidx.appcompat.widget.w;
import androidx.appcompat.widget.z1;
import b.j;
import e0.b0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    private static final Class[] f394b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f395c = {16843375};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f396d = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e  reason: collision with root package name */
    private static final l.g f397e = new l.g();

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f398a = new Object[2];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f399b;

        /* renamed from: c  reason: collision with root package name */
        private final String f400c;

        /* renamed from: d  reason: collision with root package name */
        private Method f401d;

        /* renamed from: e  reason: collision with root package name */
        private Context f402e;

        public a(View view, String str) {
            this.f399b = view;
            this.f400c = str;
        }

        private void a(Context context) {
            int id;
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f400c, View.class)) != null) {
                        this.f401d = method;
                        this.f402e = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            if (this.f399b.getId() == -1) {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            } else {
                str = " with id '" + this.f399b.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f400c + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f399b.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f401d == null) {
                a(this.f399b.getContext());
            }
            try {
                this.f401d.invoke(this.f402e, view);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e6);
            } catch (InvocationTargetException e7) {
                throw new IllegalStateException("Could not execute method for android:onClick", e7);
            }
        }
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && b0.M(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f395c);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View r(Context context, String str, String str2) {
        String str3;
        l.g gVar = f397e;
        Constructor constructor = (Constructor) gVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f394b);
            gVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f398a);
    }

    private View s(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f398a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return r(context, str, null);
            }
            int i6 = 0;
            while (true) {
                String[] strArr = f396d;
                if (i6 >= strArr.length) {
                    return null;
                }
                View r5 = r(context, str, strArr[i6]);
                if (r5 != null) {
                    return r5;
                }
                i6++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f398a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context t(Context context, AttributeSet attributeSet, boolean z5, boolean z6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.A3, 0, 0);
        int resourceId = z5 ? obtainStyledAttributes.getResourceId(j.B3, 0) : 0;
        if (z6 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(j.C3, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof h.d) && ((h.d) context).c() == resourceId) ? context : new h.d(context, resourceId) : context;
    }

    private void u(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    protected androidx.appcompat.widget.d b(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.d(context, attributeSet);
    }

    protected androidx.appcompat.widget.f c(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.f(context, attributeSet);
    }

    protected androidx.appcompat.widget.g d(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.g(context, attributeSet);
    }

    protected androidx.appcompat.widget.h e(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.h(context, attributeSet);
    }

    protected k f(Context context, AttributeSet attributeSet) {
        return new k(context, attributeSet);
    }

    protected m g(Context context, AttributeSet attributeSet) {
        return new m(context, attributeSet);
    }

    protected o h(Context context, AttributeSet attributeSet) {
        return new o(context, attributeSet);
    }

    protected p i(Context context, AttributeSet attributeSet) {
        return new p(context, attributeSet);
    }

    protected s j(Context context, AttributeSet attributeSet) {
        return new s(context, attributeSet);
    }

    protected t k(Context context, AttributeSet attributeSet) {
        return new t(context, attributeSet);
    }

    protected u l(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    protected w m(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet);
    }

    protected n0 n(Context context, AttributeSet attributeSet) {
        return new n0(context, attributeSet);
    }

    protected c1 o(Context context, AttributeSet attributeSet) {
        return new c1(context, attributeSet);
    }

    protected View p(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View q(View view, String str, Context context, AttributeSet attributeSet, boolean z5, boolean z6, boolean z7, boolean z8) {
        View k6;
        Context context2 = (!z5 || view == null) ? context : view.getContext();
        if (z6 || z7) {
            context2 = t(context2, attributeSet, z6, z7);
        }
        if (z8) {
            context2 = z1.b(context2);
        }
        str.hashCode();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c6 = 0;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c6 = 1;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c6 = 2;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c6 = 3;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c6 = 4;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c6 = 5;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c6 = 6;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c6 = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c6 = '\b';
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c6 = '\t';
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c6 = '\n';
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c6 = 11;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c6 = '\f';
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c6 = '\r';
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                k6 = k(context2, attributeSet);
                u(k6, str);
                break;
            case 1:
                k6 = e(context2, attributeSet);
                u(k6, str);
                break;
            case 2:
                k6 = i(context2, attributeSet);
                u(k6, str);
                break;
            case 3:
                k6 = n(context2, attributeSet);
                u(k6, str);
                break;
            case 4:
                k6 = g(context2, attributeSet);
                u(k6, str);
                break;
            case 5:
                k6 = l(context2, attributeSet);
                u(k6, str);
                break;
            case 6:
                k6 = m(context2, attributeSet);
                u(k6, str);
                break;
            case 7:
                k6 = j(context2, attributeSet);
                u(k6, str);
                break;
            case '\b':
                k6 = o(context2, attributeSet);
                u(k6, str);
                break;
            case '\t':
                k6 = h(context2, attributeSet);
                u(k6, str);
                break;
            case '\n':
                k6 = b(context2, attributeSet);
                u(k6, str);
                break;
            case 11:
                k6 = d(context2, attributeSet);
                u(k6, str);
                break;
            case '\f':
                k6 = f(context2, attributeSet);
                u(k6, str);
                break;
            case '\r':
                k6 = c(context2, attributeSet);
                u(k6, str);
                break;
            default:
                k6 = p(context2, str, attributeSet);
                break;
        }
        if (k6 == null && context != context2) {
            k6 = s(context2, str, attributeSet);
        }
        if (k6 != null) {
            a(k6, attributeSet);
        }
        return k6;
    }
}
