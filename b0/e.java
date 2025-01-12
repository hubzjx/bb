package b0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import b0.f;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import w.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    static final l.e f2858a = new l.e(16);

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f2859b = g.a("fonts-androidx", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    static final Object f2860c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final l.g f2861d = new l.g();

    /* loaded from: classes.dex */
    class a implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2862a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f2863b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b0.d f2864c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2865d;

        a(String str, Context context, b0.d dVar, int i6) {
            this.f2862a = str;
            this.f2863b = context;
            this.f2864c = dVar;
            this.f2865d = i6;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public C0029e call() {
            return e.c(this.f2862a, this.f2863b, this.f2864c, this.f2865d);
        }
    }

    /* loaded from: classes.dex */
    class b implements d0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b0.a f2866a;

        b(b0.a aVar) {
            this.f2866a = aVar;
        }

        @Override // d0.a
        /* renamed from: b */
        public void a(C0029e c0029e) {
            this.f2866a.b(c0029e);
        }
    }

    /* loaded from: classes.dex */
    class c implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2867a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f2868b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b0.d f2869c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2870d;

        c(String str, Context context, b0.d dVar, int i6) {
            this.f2867a = str;
            this.f2868b = context;
            this.f2869c = dVar;
            this.f2870d = i6;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public C0029e call() {
            return e.c(this.f2867a, this.f2868b, this.f2869c, this.f2870d);
        }
    }

    /* loaded from: classes.dex */
    class d implements d0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2871a;

        d(String str) {
            this.f2871a = str;
        }

        @Override // d0.a
        /* renamed from: b */
        public void a(C0029e c0029e) {
            synchronized (e.f2860c) {
                l.g gVar = e.f2861d;
                ArrayList arrayList = (ArrayList) gVar.get(this.f2871a);
                if (arrayList == null) {
                    return;
                }
                gVar.remove(this.f2871a);
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    ((d0.a) arrayList.get(i6)).a(c0029e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0029e {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f2872a;

        /* renamed from: b  reason: collision with root package name */
        final int f2873b;

        C0029e(int i6) {
            this.f2872a = null;
            this.f2873b = i6;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            return this.f2873b == 0;
        }

        C0029e(Typeface typeface) {
            this.f2872a = typeface;
            this.f2873b = 0;
        }
    }

    private static String a(b0.d dVar, int i6) {
        return dVar.d() + "-" + i6;
    }

    private static int b(f.a aVar) {
        int i6 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        f.b[] b6 = aVar.b();
        if (b6 != null && b6.length != 0) {
            i6 = 0;
            for (f.b bVar : b6) {
                int b7 = bVar.b();
                if (b7 != 0) {
                    if (b7 < 0) {
                        return -3;
                    }
                    return b7;
                }
            }
        }
        return i6;
    }

    static C0029e c(String str, Context context, b0.d dVar, int i6) {
        l.e eVar = f2858a;
        Typeface typeface = (Typeface) eVar.c(str);
        if (typeface != null) {
            return new C0029e(typeface);
        }
        try {
            f.a d6 = b0.c.d(context, dVar, null);
            int b6 = b(d6);
            if (b6 != 0) {
                return new C0029e(b6);
            }
            Typeface b7 = i.b(context, null, d6.b(), i6);
            if (b7 != null) {
                eVar.d(str, b7);
                return new C0029e(b7);
            }
            return new C0029e(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0029e(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface d(Context context, b0.d dVar, int i6, Executor executor, b0.a aVar) {
        String a6 = a(dVar, i6);
        Typeface typeface = (Typeface) f2858a.c(a6);
        if (typeface != null) {
            aVar.b(new C0029e(typeface));
            return typeface;
        }
        b bVar = new b(aVar);
        synchronized (f2860c) {
            l.g gVar = f2861d;
            ArrayList arrayList = (ArrayList) gVar.get(a6);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(bVar);
            gVar.put(a6, arrayList2);
            c cVar = new c(a6, context, dVar, i6);
            if (executor == null) {
                executor = f2859b;
            }
            g.b(executor, cVar, new d(a6));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface e(Context context, b0.d dVar, b0.a aVar, int i6, int i7) {
        String a6 = a(dVar, i6);
        Typeface typeface = (Typeface) f2858a.c(a6);
        if (typeface != null) {
            aVar.b(new C0029e(typeface));
            return typeface;
        } else if (i7 == -1) {
            C0029e c6 = c(a6, context, dVar, i6);
            aVar.b(c6);
            return c6.f2872a;
        } else {
            try {
                C0029e c0029e = (C0029e) g.c(f2859b, new a(a6, context, dVar, i6), i7);
                aVar.b(c0029e);
                return c0029e.f2872a;
            } catch (InterruptedException unused) {
                aVar.b(new C0029e(-3));
                return null;
            }
        }
    }
}
