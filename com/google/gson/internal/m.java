package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public abstract class m {

    /* loaded from: classes.dex */
    class a extends m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f5823a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f5824b;

        a(Method method, Object obj) {
            this.f5823a = method;
            this.f5824b = obj;
        }

        @Override // com.google.gson.internal.m
        public Object c(Class cls) {
            m.a(cls);
            return this.f5823a.invoke(this.f5824b, cls);
        }
    }

    /* loaded from: classes.dex */
    class b extends m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f5825a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f5826b;

        b(Method method, int i6) {
            this.f5825a = method;
            this.f5826b = i6;
        }

        @Override // com.google.gson.internal.m
        public Object c(Class cls) {
            m.a(cls);
            return this.f5825a.invoke(null, cls, Integer.valueOf(this.f5826b));
        }
    }

    /* loaded from: classes.dex */
    class c extends m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f5827a;

        c(Method method) {
            this.f5827a = method;
        }

        @Override // com.google.gson.internal.m
        public Object c(Class cls) {
            m.a(cls);
            return this.f5827a.invoke(null, cls, Object.class);
        }
    }

    /* loaded from: classes.dex */
    class d extends m {
        d() {
        }

        @Override // com.google.gson.internal.m
        public Object c(Class cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    static void a(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        } else if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public static m b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }

    public abstract Object c(Class cls);
}
