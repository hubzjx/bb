package com.google.gson.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map f5771a;

    /* renamed from: b  reason: collision with root package name */
    private final n3.b f5772b = n3.b.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements com.google.gson.internal.i {
        a() {
        }

        @Override // com.google.gson.internal.i
        public Object a() {
            return new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements com.google.gson.internal.i {
        b() {
        }

        @Override // com.google.gson.internal.i
        public Object a() {
            return new TreeMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0060c implements com.google.gson.internal.i {
        C0060c() {
        }

        @Override // com.google.gson.internal.i
        public Object a() {
            return new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements com.google.gson.internal.i {
        d() {
        }

        @Override // com.google.gson.internal.i
        public Object a() {
            return new com.google.gson.internal.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements com.google.gson.internal.i {

        /* renamed from: a  reason: collision with root package name */
        private final m f5777a = m.b();

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f5778b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Type f5779c;

        e(Class cls, Type type) {
            this.f5778b = cls;
            this.f5779c = type;
        }

        @Override // com.google.gson.internal.i
        public Object a() {
            try {
                return this.f5777a.c(this.f5778b);
            } catch (Exception e6) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f5779c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements com.google.gson.internal.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Constructor f5781a;

        f(Constructor constructor) {
            this.f5781a = constructor;
        }

        @Override // com.google.gson.internal.i
        public Object a() {
            try {
                return this.f5781a.newInstance(null);
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            } catch (InstantiationException e7) {
                throw new RuntimeException("Failed to invoke " + this.f5781a + " with no args", e7);
            } catch (InvocationTargetException e8) {
                throw new RuntimeException("Failed to invoke " + this.f5781a + " with no args", e8.getTargetException());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements com.google.gson.internal.i {
        g() {
        }

        @Override // com.google.gson.internal.i
        public Object a() {
            return new TreeSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements com.google.gson.internal.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f5784a;

        h(Type type) {
            this.f5784a = type;
        }

        @Override // com.google.gson.internal.i
        public Object a() {
            Type type = this.f5784a;
            if (!(type instanceof ParameterizedType)) {
                throw new com.google.gson.g("Invalid EnumSet type: " + this.f5784a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return EnumSet.noneOf((Class) type2);
            }
            throw new com.google.gson.g("Invalid EnumSet type: " + this.f5784a.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements com.google.gson.internal.i {
        i() {
        }

        @Override // com.google.gson.internal.i
        public Object a() {
            return new LinkedHashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements com.google.gson.internal.i {
        j() {
        }

        @Override // com.google.gson.internal.i
        public Object a() {
            return new ArrayDeque();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements com.google.gson.internal.i {
        k() {
        }

        @Override // com.google.gson.internal.i
        public Object a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l implements com.google.gson.internal.i {
        l() {
        }

        @Override // com.google.gson.internal.i
        public Object a() {
            return new ConcurrentSkipListMap();
        }
    }

    public c(Map map) {
        this.f5771a = map;
    }

    private com.google.gson.internal.i b(Class cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f5772b.b(declaredConstructor);
            }
            return new f(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private com.google.gson.internal.i c(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new g() : EnumSet.class.isAssignableFrom(cls) ? new h(type) : Set.class.isAssignableFrom(cls) ? new i() : Queue.class.isAssignableFrom(cls) ? new j() : new k();
        } else if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new l() : ConcurrentMap.class.isAssignableFrom(cls) ? new a() : SortedMap.class.isAssignableFrom(cls) ? new b() : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(p3.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) ? new d() : new C0060c();
        } else {
            return null;
        }
    }

    private com.google.gson.internal.i d(Type type, Class cls) {
        return new e(cls, type);
    }

    public com.google.gson.internal.i a(p3.a aVar) {
        Type d6 = aVar.d();
        Class c6 = aVar.c();
        android.support.v4.media.a.a(this.f5771a.get(d6));
        android.support.v4.media.a.a(this.f5771a.get(c6));
        com.google.gson.internal.i b6 = b(c6);
        if (b6 != null) {
            return b6;
        }
        com.google.gson.internal.i c7 = c(d6, c6);
        return c7 != null ? c7 : d(d6, c6);
    }

    public String toString() {
        return this.f5771a.toString();
    }
}
