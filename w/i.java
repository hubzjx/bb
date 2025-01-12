package w;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import b0.f;
import v.c;
import v.f;
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static final n0 f13698a;

    /* renamed from: b  reason: collision with root package name */
    private static final l.e f13699b;

    /* loaded from: classes.dex */
    public static class a extends f.c {

        /* renamed from: a  reason: collision with root package name */
        private f.a f13700a;

        public a(f.a aVar) {
            this.f13700a = aVar;
        }

        @Override // b0.f.c
        public void a(int i6) {
            f.a aVar = this.f13700a;
            if (aVar != null) {
                aVar.d(i6);
            }
        }

        @Override // b0.f.c
        public void b(Typeface typeface) {
            f.a aVar = this.f13700a;
            if (aVar != null) {
                aVar.e(typeface);
            }
        }
    }

    static {
        int i6 = Build.VERSION.SDK_INT;
        f13698a = i6 >= 29 ? new m0() : i6 >= 28 ? new s() : i6 >= 26 ? new r() : (i6 < 24 || !k.i()) ? new j() : new k();
        f13699b = new l.e(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i6) {
        if (context != null) {
            return Typeface.create(typeface, i6);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i6) {
        return f13698a.b(context, cancellationSignal, bVarArr, i6);
    }

    public static Typeface c(Context context, c.a aVar, Resources resources, int i6, int i7, f.a aVar2, Handler handler, boolean z5) {
        Typeface a6;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            Typeface g6 = g(dVar.c());
            if (g6 != null) {
                if (aVar2 != null) {
                    aVar2.b(g6, handler);
                }
                return g6;
            }
            a6 = b0.f.a(context, dVar.b(), i7, !z5 ? aVar2 != null : dVar.a() != 0, z5 ? dVar.d() : -1, f.a.c(handler), new a(aVar2));
        } else {
            a6 = f13698a.a(context, (c.b) aVar, resources, i7);
            if (aVar2 != null) {
                if (a6 != null) {
                    aVar2.b(a6, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (a6 != null) {
            f13699b.d(e(resources, i6, i7), a6);
        }
        return a6;
    }

    public static Typeface d(Context context, Resources resources, int i6, String str, int i7) {
        Typeface d6 = f13698a.d(context, resources, i6, str, i7);
        if (d6 != null) {
            f13699b.d(e(resources, i6, i7), d6);
        }
        return d6;
    }

    private static String e(Resources resources, int i6, int i7) {
        return resources.getResourcePackageName(i6) + "-" + i6 + "-" + i7;
    }

    public static Typeface f(Resources resources, int i6, int i7) {
        return (Typeface) f13699b.c(e(resources, i6, i7));
    }

    private static Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
