package androidx.lifecycle;

import androidx.lifecycle.c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
class a {

    /* renamed from: c  reason: collision with root package name */
    static a f1978c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map f1979a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map f1980b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.lifecycle.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0017a {

        /* renamed from: a  reason: collision with root package name */
        final Map f1981a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map f1982b;

        C0017a(Map map) {
            this.f1982b = map;
            for (Map.Entry entry : map.entrySet()) {
                c.a aVar = (c.a) entry.getValue();
                List list = (List) this.f1981a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f1981a.put(aVar, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void b(List list, f fVar, c.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((b) list.get(size)).a(fVar, aVar, obj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(f fVar, c.a aVar, Object obj) {
            b((List) this.f1981a.get(aVar), fVar, aVar, obj);
            b((List) this.f1981a.get(c.a.ON_ANY), fVar, aVar, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f1983a;

        /* renamed from: b  reason: collision with root package name */
        final Method f1984b;

        b(int i6, Method method) {
            this.f1983a = i6;
            this.f1984b = method;
            method.setAccessible(true);
        }

        void a(f fVar, c.a aVar, Object obj) {
            try {
                int i6 = this.f1983a;
                if (i6 == 0) {
                    this.f1984b.invoke(obj, new Object[0]);
                } else if (i6 == 1) {
                    this.f1984b.invoke(obj, fVar);
                } else if (i6 != 2) {
                } else {
                    this.f1984b.invoke(obj, fVar, aVar);
                }
            } catch (IllegalAccessException e6) {
                throw new RuntimeException(e6);
            } catch (InvocationTargetException e7) {
                throw new RuntimeException("Failed to call observer method", e7.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1983a == bVar.f1983a && this.f1984b.getName().equals(bVar.f1984b.getName());
        }

        public int hashCode() {
            return (this.f1983a * 31) + this.f1984b.getName().hashCode();
        }
    }

    a() {
    }

    private C0017a a(Class cls, Method[] methodArr) {
        int i6;
        C0017a c6;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c6 = c(superclass)) != null) {
            hashMap.putAll(c6.f1982b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f1982b.entrySet()) {
                e(hashMap, (b) entry.getKey(), (c.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z5 = false;
        for (Method method : methodArr) {
            l lVar = (l) method.getAnnotation(l.class);
            if (lVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i6 = 0;
                } else if (!parameterTypes[0].isAssignableFrom(f.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i6 = 1;
                }
                c.a value = lVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(c.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != c.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i6 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(hashMap, new b(i6, method), value, cls);
                z5 = true;
            }
        }
        C0017a c0017a = new C0017a(hashMap);
        this.f1979a.put(cls, c0017a);
        this.f1980b.put(cls, Boolean.valueOf(z5));
        return c0017a;
    }

    private Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e6) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e6);
        }
    }

    private void e(Map map, b bVar, c.a aVar, Class cls) {
        c.a aVar2 = (c.a) map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        Method method = bVar.f1984b;
        throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0017a c(Class cls) {
        C0017a c0017a = (C0017a) this.f1979a.get(cls);
        return c0017a != null ? c0017a : a(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Class cls) {
        Boolean bool = (Boolean) this.f1980b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b6 = b(cls);
        for (Method method : b6) {
            if (((l) method.getAnnotation(l.class)) != null) {
                a(cls, b6);
                return true;
            }
        }
        this.f1980b.put(cls, Boolean.FALSE);
        return false;
    }
}
