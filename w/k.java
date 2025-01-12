package w;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import b0.f;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import v.c;
/* loaded from: classes.dex */
class k extends n0 {

    /* renamed from: b  reason: collision with root package name */
    private static final Class f13706b;

    /* renamed from: c  reason: collision with root package name */
    private static final Constructor f13707c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f13708d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f13709e;

    static {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e6) {
            Log.e("TypefaceCompatApi24Impl", e6.getClass().getName(), e6);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f13707c = constructor;
        f13706b = cls;
        f13708d = method2;
        f13709e = method;
    }

    private static boolean g(Object obj, ByteBuffer byteBuffer, int i6, int i7, boolean z5) {
        try {
            return ((Boolean) f13708d.invoke(obj, byteBuffer, Integer.valueOf(i6), null, Integer.valueOf(i7), Boolean.valueOf(z5))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface h(Object obj) {
        try {
            Object newInstance = Array.newInstance(f13706b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f13709e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean i() {
        Method method = f13708d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object j() {
        try {
            return f13707c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // w.n0
    public Typeface a(Context context, c.b bVar, Resources resources, int i6) {
        c.C0219c[] a6;
        Object j6 = j();
        if (j6 == null) {
            return null;
        }
        for (c.C0219c c0219c : bVar.a()) {
            ByteBuffer b6 = o0.b(context, resources, c0219c.b());
            if (b6 == null || !g(j6, b6, c0219c.c(), c0219c.e(), c0219c.f())) {
                return null;
            }
        }
        return h(j6);
    }

    @Override // w.n0
    public Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i6) {
        Object j6 = j();
        if (j6 == null) {
            return null;
        }
        l.g gVar = new l.g();
        for (f.b bVar : bVarArr) {
            Uri d6 = bVar.d();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(d6);
            if (byteBuffer == null) {
                byteBuffer = o0.f(context, cancellationSignal, d6);
                gVar.put(d6, byteBuffer);
            }
            if (byteBuffer == null || !g(j6, byteBuffer, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface h6 = h(j6);
        if (h6 == null) {
            return null;
        }
        return Typeface.create(h6, i6);
    }
}
