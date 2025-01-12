package w;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import b0.f;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import v.c;
/* loaded from: classes.dex */
public class r extends j {

    /* renamed from: g  reason: collision with root package name */
    protected final Class f13712g;

    /* renamed from: h  reason: collision with root package name */
    protected final Constructor f13713h;

    /* renamed from: i  reason: collision with root package name */
    protected final Method f13714i;

    /* renamed from: j  reason: collision with root package name */
    protected final Method f13715j;

    /* renamed from: k  reason: collision with root package name */
    protected final Method f13716k;

    /* renamed from: l  reason: collision with root package name */
    protected final Method f13717l;

    /* renamed from: m  reason: collision with root package name */
    protected final Method f13718m;

    public r() {
        Class cls;
        Constructor constructor;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        try {
            cls = u();
            constructor = v(cls);
            method = r(cls);
            method2 = s(cls);
            method3 = w(cls);
            method4 = q(cls);
            method5 = t(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e6) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e6.getClass().getName(), e6);
            cls = null;
            constructor = null;
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f13712g = cls;
        this.f13713h = constructor;
        this.f13714i = method;
        this.f13715j = method2;
        this.f13716k = method3;
        this.f13717l = method4;
        this.f13718m = method5;
    }

    private Object k() {
        try {
            return this.f13713h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void l(Object obj) {
        try {
            this.f13717l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean m(Context context, Object obj, String str, int i6, int i7, int i8, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f13714i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean n(Object obj, ByteBuffer byteBuffer, int i6, int i7, int i8) {
        try {
            return ((Boolean) this.f13715j.invoke(obj, byteBuffer, Integer.valueOf(i6), null, Integer.valueOf(i7), Integer.valueOf(i8))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean o(Object obj) {
        try {
            return ((Boolean) this.f13716k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean p() {
        if (this.f13714i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f13714i != null;
    }

    @Override // w.j, w.n0
    public Typeface a(Context context, c.b bVar, Resources resources, int i6) {
        c.C0219c[] a6;
        FontVariationAxis[] fromFontVariationSettings;
        if (p()) {
            Object k6 = k();
            if (k6 == null) {
                return null;
            }
            for (c.C0219c c0219c : bVar.a()) {
                String a7 = c0219c.a();
                int c6 = c0219c.c();
                int e6 = c0219c.e();
                boolean f6 = c0219c.f();
                fromFontVariationSettings = FontVariationAxis.fromFontVariationSettings(c0219c.d());
                if (!m(context, k6, a7, c6, e6, f6 ? 1 : 0, fromFontVariationSettings)) {
                    l(k6);
                    return null;
                }
            }
            if (o(k6)) {
                return h(k6);
            }
            return null;
        }
        return super.a(context, bVar, resources, i6);
    }

    @Override // w.j, w.n0
    public Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i6) {
        Typeface h6;
        Typeface.Builder weight;
        Typeface.Builder italic;
        Typeface build;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!p()) {
            f.b f6 = f(bVarArr, i6);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(f6.d(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                q.a();
                weight = p.a(openFileDescriptor.getFileDescriptor()).setWeight(f6.e());
                italic = weight.setItalic(f6.f());
                build = italic.build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        Map h7 = o0.h(context, bVarArr, cancellationSignal);
        Object k6 = k();
        if (k6 == null) {
            return null;
        }
        boolean z5 = false;
        for (f.b bVar : bVarArr) {
            ByteBuffer byteBuffer = (ByteBuffer) h7.get(bVar.d());
            if (byteBuffer != null) {
                if (!n(k6, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    l(k6);
                    return null;
                }
                z5 = true;
            }
        }
        if (!z5) {
            l(k6);
            return null;
        } else if (o(k6) && (h6 = h(k6)) != null) {
            return Typeface.create(h6, i6);
        } else {
            return null;
        }
    }

    @Override // w.n0
    public Typeface d(Context context, Resources resources, int i6, String str, int i7) {
        if (p()) {
            Object k6 = k();
            if (k6 == null) {
                return null;
            }
            if (!m(context, k6, str, 0, -1, -1, null)) {
                l(k6);
                return null;
            } else if (o(k6)) {
                return h(k6);
            } else {
                return null;
            }
        }
        return super.d(context, resources, i6, str, i7);
    }

    protected Typeface h(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f13712g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f13718m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method q(Class cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method r(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method s(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method t(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class u() {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor v(Class cls) {
        return cls.getConstructor(new Class[0]);
    }

    protected Method w(Class cls) {
        return cls.getMethod("freeze", new Class[0]);
    }
}
