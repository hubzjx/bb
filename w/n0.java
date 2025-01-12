package w;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import b0.f;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.InputStream;
import v.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class n0 {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap f13710a = new ConcurrentHashMap();

    /* loaded from: classes.dex */
    class a implements b {
        a() {
        }

        @Override // w.n0.b
        /* renamed from: c */
        public int a(f.b bVar) {
            return bVar.e();
        }

        @Override // w.n0.b
        /* renamed from: d */
        public boolean b(f.b bVar) {
            return bVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        int a(Object obj);

        boolean b(Object obj);
    }

    private static Object e(Object[] objArr, int i6, b bVar) {
        int i7 = (i6 & 1) == 0 ? 400 : 700;
        boolean z5 = (i6 & 2) != 0;
        Object obj = null;
        int i8 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int abs = (Math.abs(bVar.a(obj2) - i7) * 2) + (bVar.b(obj2) == z5 ? 0 : 1);
            if (obj == null || i8 > abs) {
                obj = obj2;
                i8 = abs;
            }
        }
        return obj;
    }

    public abstract Typeface a(Context context, c.b bVar, Resources resources, int i6);

    public abstract Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i6);

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface c(Context context, InputStream inputStream) {
        File e6 = o0.e(context);
        if (e6 == null) {
            return null;
        }
        try {
            if (o0.d(e6, inputStream)) {
                return Typeface.createFromFile(e6.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e6.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i6, String str, int i7) {
        File e6 = o0.e(context);
        if (e6 == null) {
            return null;
        }
        try {
            if (o0.c(e6, resources, i6)) {
                return Typeface.createFromFile(e6.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e6.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f.b f(f.b[] bVarArr, int i6) {
        return (f.b) e(bVarArr, i6, new a());
    }
}
