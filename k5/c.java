package k5;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.helpers.e;
import org.slf4j.helpers.g;
import org.slf4j.helpers.h;
import org.slf4j.helpers.i;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    static volatile int f11283a;

    /* renamed from: b  reason: collision with root package name */
    static h f11284b = new h();

    /* renamed from: c  reason: collision with root package name */
    static e f11285c = new e();

    /* renamed from: d  reason: collision with root package name */
    static boolean f11286d = i.c("slf4j.detectLoggerNameMismatch");

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f11287e = {"1.6", "1.7"};

    /* renamed from: f  reason: collision with root package name */
    private static String f11288f = "org/slf4j/impl/StaticLoggerBinder.class";

    private static final void a() {
        Set set;
        try {
            if (i()) {
                set = null;
            } else {
                set = d();
                o(set);
            }
            org.slf4j.impl.c.c();
            f11283a = 3;
            n(set);
            e();
            l();
            f11284b.b();
        } catch (Exception e6) {
            c(e6);
            throw new IllegalStateException("Unexpected initialization failure", e6);
        } catch (NoClassDefFoundError e7) {
            if (!j(e7.getMessage())) {
                c(e7);
                throw e7;
            }
            f11283a = 4;
            i.a("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
            i.a("Defaulting to no-operation (NOP) logger implementation");
            i.a("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
        } catch (NoSuchMethodError e8) {
            String message = e8.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f11283a = 2;
                i.a("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                i.a("Your binding is version 1.5.5 or earlier.");
                i.a("Upgrade your binding to version 1.6.x.");
            }
            throw e8;
        }
    }

    private static void b(l5.a aVar, int i6) {
        throw null;
    }

    static void c(Throwable th) {
        f11283a = 2;
        i.b("Failed to instantiate SLF4J LoggerFactory", th);
    }

    static Set d() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = c.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(f11288f) : classLoader.getResources(f11288f);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e6) {
            i.b("Error getting resources from path", e6);
        }
        return linkedHashSet;
    }

    private static void e() {
        synchronized (f11284b) {
            f11284b.e();
            for (g gVar : f11284b.d()) {
                gVar.b(g(gVar.a()));
            }
        }
    }

    public static a f() {
        if (f11283a == 0) {
            synchronized (c.class) {
                if (f11283a == 0) {
                    f11283a = 1;
                    k();
                }
            }
        }
        int i6 = f11283a;
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 == 4) {
                        return f11285c;
                    }
                    throw new IllegalStateException("Unreachable code");
                }
                return org.slf4j.impl.c.c().a();
            }
            throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        return f11284b;
    }

    public static b g(String str) {
        return f().a(str);
    }

    private static boolean h(Set set) {
        return set.size() > 1;
    }

    private static boolean i() {
        String d6 = i.d("java.vendor.url");
        if (d6 == null) {
            return false;
        }
        return d6.toLowerCase().contains("android");
    }

    private static boolean j(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    private static final void k() {
        a();
        if (f11283a == 3) {
            p();
        }
    }

    private static void l() {
        LinkedBlockingQueue c6 = f11284b.c();
        int size = c6.size();
        ArrayList<Object> arrayList = new ArrayList(128);
        int i6 = 0;
        while (c6.drainTo(arrayList, 128) != 0) {
            for (Object obj : arrayList) {
                android.support.v4.media.a.a(obj);
                m(null);
                int i7 = i6 + 1;
                if (i6 == 0) {
                    b(null, size);
                }
                i6 = i7;
            }
            arrayList.clear();
        }
    }

    private static void m(l5.a aVar) {
    }

    private static void n(Set set) {
        if (set == null || !h(set)) {
            return;
        }
        i.a("Actual binding is of type [" + org.slf4j.impl.c.c().b() + "]");
    }

    private static void o(Set set) {
        if (h(set)) {
            i.a("Class path contains multiple SLF4J bindings.");
            Iterator it = set.iterator();
            while (it.hasNext()) {
                i.a("Found binding in [" + ((URL) it.next()) + "]");
            }
            i.a("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static final void p() {
        try {
            String str = org.slf4j.impl.c.f12506c;
            boolean z5 = false;
            for (String str2 : f11287e) {
                if (str.startsWith(str2)) {
                    z5 = true;
                }
            }
            if (z5) {
                return;
            }
            i.a("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f11287e).toString());
            i.a("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            i.b("Unexpected problem occured during version sanity check", th);
        }
    }
}
