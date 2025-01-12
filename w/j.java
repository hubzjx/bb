package w;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import b0.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import v.c;
/* loaded from: classes.dex */
class j extends n0 {

    /* renamed from: b  reason: collision with root package name */
    private static Class f13701b;

    /* renamed from: c  reason: collision with root package name */
    private static Constructor f13702c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f13703d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f13704e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f13705f;

    private static boolean g(Object obj, String str, int i6, boolean z5) {
        j();
        try {
            return ((Boolean) f13703d.invoke(obj, str, Integer.valueOf(i6), Boolean.valueOf(z5))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }

    private static Typeface h(Object obj) {
        j();
        try {
            Object newInstance = Array.newInstance(f13701b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f13704e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }

    private File i(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void j() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        if (f13705f) {
            return;
        }
        f13705f = true;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e6) {
            Log.e("TypefaceCompatApi21Impl", e6.getClass().getName(), e6);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f13702c = constructor;
        f13701b = cls;
        f13703d = method2;
        f13704e = method;
    }

    private static Object k() {
        j();
        try {
            return f13702c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }

    @Override // w.n0
    public Typeface a(Context context, c.b bVar, Resources resources, int i6) {
        c.C0219c[] a6;
        Object k6 = k();
        for (c.C0219c c0219c : bVar.a()) {
            File e6 = o0.e(context);
            if (e6 == null) {
                return null;
            }
            try {
                if (!o0.c(e6, resources, c0219c.b())) {
                    return null;
                }
                if (!g(k6, e6.getPath(), c0219c.e(), c0219c.f())) {
                    return null;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                e6.delete();
            }
        }
        return h(k6);
    }

    @Override // w.n0
    public Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i6) {
        if (bVarArr.length < 1) {
            return null;
        }
        f.b f6 = f(bVarArr, i6);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(f6.d(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            File i7 = i(openFileDescriptor);
            if (i7 != null && i7.canRead()) {
                Typeface createFromFile = Typeface.createFromFile(i7);
                openFileDescriptor.close();
                return createFromFile;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface c6 = super.c(context, fileInputStream);
            fileInputStream.close();
            openFileDescriptor.close();
            return c6;
        } catch (IOException unused) {
            return null;
        }
    }
}
