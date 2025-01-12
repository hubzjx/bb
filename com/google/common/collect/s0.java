package com.google.common.collect;

import com.google.common.collect.a0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public abstract class s0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends r1 {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.r1
        /* renamed from: b */
        public Object a(Map.Entry entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends r1 {
        b(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.r1
        /* renamed from: b */
        public Object a(Map.Entry entry) {
            return entry.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static abstract class c implements com.google.common.base.e {
        private static final /* synthetic */ c[] $VALUES;
        public static final c KEY;
        public static final c VALUE;

        /* loaded from: classes.dex */
        enum a extends c {
            a(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.google.common.collect.s0.c, com.google.common.base.e
            @NullableDecl
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        /* loaded from: classes.dex */
        enum b extends c {
            b(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.google.common.collect.s0.c, com.google.common.base.e
            @NullableDecl
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        static {
            a aVar = new a("KEY", 0);
            KEY = aVar;
            b bVar = new b("VALUE", 1);
            VALUE = bVar;
            $VALUES = new c[]{aVar, bVar};
        }

        private c(String str, int i6) {
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) $VALUES.clone();
        }

        @Override // com.google.common.base.e
        @CanIgnoreReturnValue
        @NullableDecl
        public abstract /* synthetic */ Object apply(@NullableDecl Object obj);

        /* synthetic */ c(String str, int i6, a aVar) {
            this(str, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Map map, Object obj) {
        return n0.c(g(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Map map, Object obj) {
        return n0.c(l(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static Map.Entry d(Object obj, Object obj2) {
        return new x(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a0 e(Collection collection) {
        a0.b bVar = new a0.b(collection.size());
        int i6 = 0;
        for (Object obj : collection) {
            bVar.c(obj, Integer.valueOf(i6));
            i6++;
        }
        return bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.common.base.e f() {
        return c.KEY;
    }

    static Iterator g(Iterator it) {
        return new a(it);
    }

    public static IdentityHashMap h() {
        return new IdentityHashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Map map, Map map2) {
        for (Map.Entry entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j(Map map) {
        StringBuilder b6 = j.b(map.size());
        b6.append('{');
        boolean z5 = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z5) {
                b6.append(", ");
            }
            b6.append(entry.getKey());
            b6.append('=');
            b6.append(entry.getValue());
            z5 = false;
        }
        b6.append('}');
        return b6.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.common.base.e k() {
        return c.VALUE;
    }

    static Iterator l(Iterator it) {
        return new b(it);
    }
}
