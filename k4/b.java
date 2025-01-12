package k4;

import io.jsonwebtoken.JwtParser;
import kotlin.jvm.internal.l;
import kotlin.text.x;
import okhttp3.dnsoverhttps.DnsOverHttps;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f11282a;

    static {
        a aVar;
        Object newInstance;
        Object newInstance2;
        int a6 = a();
        if (a6 >= 65544 || a6 < 65536) {
            try {
                newInstance = m4.a.class.newInstance();
                l.c(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                    } catch (ClassCastException e6) {
                        ClassLoader classLoader = newInstance.getClass().getClassLoader();
                        ClassLoader classLoader2 = a.class.getClassLoader();
                        if (l.a(classLoader, classLoader2)) {
                            throw e6;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e6);
                    }
                } catch (ClassNotFoundException unused) {
                }
            } catch (ClassNotFoundException unused2) {
                Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                l.c(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (newInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) newInstance3;
                } catch (ClassCastException e7) {
                    ClassLoader classLoader3 = newInstance3.getClass().getClassLoader();
                    ClassLoader classLoader4 = a.class.getClassLoader();
                    if (l.a(classLoader3, classLoader4)) {
                        throw e7;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e7);
                }
            }
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            aVar = (a) newInstance;
            f11282a = aVar;
        }
        if (a6 >= 65543 || a6 < 65536) {
            try {
                try {
                    newInstance2 = l4.a.class.newInstance();
                    l.c(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                    } catch (ClassCastException e8) {
                        ClassLoader classLoader5 = newInstance2.getClass().getClassLoader();
                        ClassLoader classLoader6 = a.class.getClassLoader();
                        if (l.a(classLoader5, classLoader6)) {
                            throw e8;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e8);
                    }
                } catch (ClassNotFoundException unused3) {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    l.c(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        if (newInstance4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        aVar = (a) newInstance4;
                    } catch (ClassCastException e9) {
                        ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                        ClassLoader classLoader8 = a.class.getClassLoader();
                        if (l.a(classLoader7, classLoader8)) {
                            throw e9;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e9);
                    }
                }
            } catch (ClassNotFoundException unused4) {
            }
            if (newInstance2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            aVar = (a) newInstance2;
            f11282a = aVar;
        }
        aVar = new a();
        f11282a = aVar;
    }

    private static final int a() {
        int N;
        int N2;
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        N = x.N(property, JwtParser.SEPARATOR_CHAR, 0, false, 6, null);
        if (N < 0) {
            try {
                return Integer.parseInt(property) * DnsOverHttps.MAX_RESPONSE_SIZE;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i6 = N + 1;
        N2 = x.N(property, JwtParser.SEPARATOR_CHAR, i6, false, 4, null);
        if (N2 < 0) {
            N2 = property.length();
        }
        String substring = property.substring(0, N);
        l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = property.substring(i6, N2);
        l.c(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(substring) * DnsOverHttps.MAX_RESPONSE_SIZE) + Integer.parseInt(substring2);
        } catch (NumberFormatException unused2) {
            return 65542;
        }
    }
}
