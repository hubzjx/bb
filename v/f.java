package v;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import d0.i;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;
import v.c;
/* loaded from: classes.dex */
public abstract class f {

    /* loaded from: classes.dex */
    public static abstract class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: v.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0220a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Typeface f13641a;

            RunnableC0220a(Typeface typeface) {
                this.f13641a = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.e(this.f13641a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f13643a;

            b(int i6) {
                this.f13643a = i6;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.d(this.f13643a);
            }
        }

        public static Handler c(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void a(int i6, Handler handler) {
            c(handler).post(new b(i6));
        }

        public final void b(Typeface typeface, Handler handler) {
            c(handler).post(new RunnableC0220a(typeface));
        }

        public abstract void d(int i6);

        public abstract void e(Typeface typeface);
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* loaded from: classes.dex */
        static class a {

            /* renamed from: a  reason: collision with root package name */
            private static final Object f13645a = new Object();

            /* renamed from: b  reason: collision with root package name */
            private static Method f13646b;

            /* renamed from: c  reason: collision with root package name */
            private static boolean f13647c;

            static void a(Resources.Theme theme) {
                synchronized (f13645a) {
                    if (!f13647c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f13646b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e6) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e6);
                        }
                        f13647c = true;
                    }
                    Method method = f13646b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e7) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e7);
                            f13646b = null;
                        }
                    }
                }
            }
        }

        /* renamed from: v.f$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0221b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 29) {
                C0221b.a(theme);
            } else if (i6 >= 23) {
                a.a(theme);
            }
        }
    }

    public static Typeface a(Context context, int i6) {
        if (context.isRestricted()) {
            return null;
        }
        return f(context, i6, new TypedValue(), 0, null, null, false, true);
    }

    public static Drawable b(Resources resources, int i6, Resources.Theme theme) {
        return resources.getDrawable(i6, theme);
    }

    public static Typeface c(Context context, int i6) {
        if (context.isRestricted()) {
            return null;
        }
        return f(context, i6, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface d(Context context, int i6, TypedValue typedValue, int i7, a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        return f(context, i6, typedValue, i7, aVar, null, true, false);
    }

    public static void e(Context context, int i6, a aVar, Handler handler) {
        i.c(aVar);
        if (context.isRestricted()) {
            aVar.a(-4, handler);
        } else {
            f(context, i6, new TypedValue(), 0, aVar, handler, false, false);
        }
    }

    private static Typeface f(Context context, int i6, TypedValue typedValue, int i7, a aVar, Handler handler, boolean z5, boolean z6) {
        Resources resources = context.getResources();
        resources.getValue(i6, typedValue, true);
        Typeface g6 = g(context, resources, typedValue, i6, i7, aVar, handler, z5, z6);
        if (g6 == null && aVar == null && !z6) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i6) + " could not be retrieved.");
        }
        return g6;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Typeface g(Context context, Resources resources, TypedValue typedValue, int i6, int i7, a aVar, Handler handler, boolean z5, boolean z6) {
        StringBuilder sb;
        String str;
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i6) + "\" (" + Integer.toHexString(i6) + ") is not a Font: " + typedValue);
        }
        String charSequence2 = charSequence.toString();
        if (!charSequence2.startsWith("res/")) {
            if (aVar != null) {
                aVar.a(-3, handler);
            }
            return null;
        }
        Typeface f6 = w.i.f(resources, i6, i7);
        if (f6 != null) {
            if (aVar != null) {
                aVar.b(f6, handler);
            }
            return f6;
        } else if (z6) {
            return null;
        } else {
            try {
                if (!charSequence2.toLowerCase().endsWith(".xml")) {
                    Typeface d6 = w.i.d(context, resources, i6, charSequence2, i7);
                    if (aVar != null) {
                        if (d6 != null) {
                            aVar.b(d6, handler);
                        } else {
                            aVar.a(-3, handler);
                        }
                    }
                    return d6;
                }
                c.a b6 = c.b(resources.getXml(i6), resources);
                if (b6 == null) {
                    Log.e("ResourcesCompat", "Failed to find font-family tag");
                    if (aVar != null) {
                        aVar.a(-3, handler);
                    }
                    return null;
                }
                return w.i.c(context, b6, resources, i6, i7, aVar, handler, z5);
            } catch (IOException e6) {
                e = e6;
                sb = new StringBuilder();
                str = "Failed to read xml resource ";
                sb.append(str);
                sb.append(charSequence2);
                Log.e("ResourcesCompat", sb.toString(), e);
                if (aVar != null) {
                    aVar.a(-3, handler);
                }
                return null;
            } catch (XmlPullParserException e7) {
                e = e7;
                sb = new StringBuilder();
                str = "Failed to parse xml resource ";
                sb.append(str);
                sb.append(charSequence2);
                Log.e("ResourcesCompat", sb.toString(), e);
                if (aVar != null) {
                }
                return null;
            }
        }
    }
}
