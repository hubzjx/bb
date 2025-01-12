package kotlin.jvm.internal;

import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    private static final t f11323a;

    /* renamed from: b  reason: collision with root package name */
    private static final s4.c[] f11324b;

    static {
        t tVar = null;
        try {
            tVar = (t) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (tVar == null) {
            tVar = new t();
        }
        f11323a = tVar;
        f11324b = new s4.c[0];
    }

    public static s4.f a(i iVar) {
        return f11323a.a(iVar);
    }

    public static s4.c b(Class cls) {
        return f11323a.b(cls);
    }

    public static s4.e c(Class cls) {
        return f11323a.c(cls, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public static String d(h hVar) {
        return f11323a.d(hVar);
    }

    public static String e(m mVar) {
        return f11323a.e(mVar);
    }
}
