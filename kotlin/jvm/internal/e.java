package kotlin.jvm.internal;

import io.jsonwebtoken.JwtParser;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.collections.e0;
import kotlin.text.x;
import p4.w;
/* loaded from: classes.dex */
public final class e implements s4.c, d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f11313b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private static final Map f11314c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap f11315d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap f11316e;

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap f11317f;

    /* renamed from: g  reason: collision with root package name */
    private static final Map f11318g;

    /* renamed from: a  reason: collision with root package name */
    private final Class f11319a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a(Class cls) {
            String str;
            l.d(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str3 = (String) e.f11317f.get(cls.getName());
                return str3 == null ? cls.getCanonicalName() : str3;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) e.f11317f.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 == null ? "kotlin.Array" : str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003d, code lost:
            if (r2 == null) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String b(Class cls) {
            String str;
            String str2;
            Method enclosingMethod;
            String r02;
            String s02;
            l.d(cls, "jClass");
            String str3 = null;
            if (cls.isAnonymousClass()) {
                return null;
            }
            if (cls.isLocalClass()) {
                String simpleName = cls.getSimpleName();
                if (cls.getEnclosingMethod() != null) {
                    l.c(simpleName, "name");
                    str = x.s0(simpleName, enclosingMethod.getName() + '$', null, 2, null);
                }
                Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                l.c(simpleName, "name");
                if (enclosingConstructor == null) {
                    r02 = x.r0(simpleName, '$', null, 2, null);
                    return r02;
                }
                s02 = x.s0(simpleName, enclosingConstructor.getName() + '$', null, 2, null);
                return s02;
            } else if (!cls.isArray()) {
                String str4 = (String) e.f11318g.get(cls.getName());
                return str4 == null ? cls.getSimpleName() : str4;
            } else {
                Class<?> componentType = cls.getComponentType();
                str = "Array";
                if (componentType.isPrimitive() && (str2 = (String) e.f11318g.get(componentType.getName())) != null) {
                    str3 = str2 + "Array";
                }
                if (str3 != null) {
                    return str3;
                }
            }
            return str;
        }

        public final boolean c(Object obj, Class cls) {
            l.d(cls, "jClass");
            Integer num = (Integer) e.f11314c.get(cls);
            if (num != null) {
                return v.e(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = o4.a.a(o4.a.b(cls));
            }
            return cls.isInstance(obj);
        }
    }

    static {
        List i6;
        int p5;
        Map i7;
        int a6;
        String u02;
        String u03;
        int i8 = 0;
        i6 = kotlin.collections.n.i(p4.a.class, p4.l.class, p4.p.class, p4.q.class, p4.r.class, p4.s.class, p4.t.class, p4.u.class, p4.v.class, w.class, p4.b.class, p4.c.class, p4.d.class, p4.e.class, p4.f.class, p4.g.class, p4.h.class, p4.i.class, p4.j.class, p4.k.class, p4.m.class, p4.n.class, p4.o.class);
        p5 = kotlin.collections.o.p(i6, 10);
        ArrayList arrayList = new ArrayList(p5);
        for (Object obj : i6) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                kotlin.collections.n.o();
            }
            arrayList.add(h4.n.a((Class) obj, Integer.valueOf(i8)));
            i8 = i9;
        }
        i7 = e0.i(arrayList);
        f11314c = i7;
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f11315d = hashMap;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f11316e = hashMap2;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        l.c(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            l.c(str, "kotlinName");
            u03 = x.u0(str, JwtParser.SEPARATOR_CHAR, null, 2, null);
            sb.append(u03);
            sb.append("CompanionObject");
            h4.j a7 = h4.n.a(sb.toString(), str + ".Companion");
            hashMap3.put(a7.getFirst(), a7.getSecond());
        }
        for (Map.Entry entry : f11314c.entrySet()) {
            int intValue = ((Number) entry.getValue()).intValue();
            hashMap3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + intValue);
        }
        f11317f = hashMap3;
        a6 = d0.a(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(a6);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            u02 = x.u0((String) entry2.getValue(), JwtParser.SEPARATOR_CHAR, null, 2, null);
            linkedHashMap.put(key, u02);
        }
        f11318g = linkedHashMap;
    }

    public e(Class cls) {
        l.d(cls, "jClass");
        this.f11319a = cls;
    }

    @Override // s4.c
    public String a() {
        return f11313b.a(b());
    }

    @Override // kotlin.jvm.internal.d
    public Class b() {
        return this.f11319a;
    }

    @Override // s4.c
    public boolean c(Object obj) {
        return f11313b.c(obj, b());
    }

    @Override // s4.c
    public String d() {
        return f11313b.b(b());
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && l.a(o4.a.a(this), o4.a.a((s4.c) obj));
    }

    public int hashCode() {
        return o4.a.a(this).hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
