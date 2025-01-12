package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f11305a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final a f11306b = new a(null, null, null);

    /* renamed from: c  reason: collision with root package name */
    private static a f11307c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Method f11308a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f11309b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f11310c;

        public a(Method method, Method method2, Method method3) {
            this.f11308a = method;
            this.f11309b = method2;
            this.f11310c = method3;
        }
    }

    private h() {
    }

    private final a a(kotlin.coroutines.jvm.internal.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f11307c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f11306b;
            f11307c = aVar3;
            return aVar3;
        }
    }

    public final String b(kotlin.coroutines.jvm.internal.a aVar) {
        l.d(aVar, "continuation");
        a aVar2 = f11307c;
        if (aVar2 == null) {
            aVar2 = a(aVar);
        }
        if (aVar2 == f11306b) {
            return null;
        }
        Method method = aVar2.f11308a;
        Object invoke = method != null ? method.invoke(aVar.getClass(), new Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = aVar2.f11309b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = aVar2.f11310c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
