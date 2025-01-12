package com.google.common.collect;

import com.google.common.collect.v0;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes.dex */
abstract class l1 {

    /* loaded from: classes.dex */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Field f5672a;

        private b(Field field) {
            this.f5672a = field;
            field.setAccessible(true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Object obj, int i6) {
            try {
                this.f5672a.set(obj, Integer.valueOf(i6));
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(Object obj, Object obj2) {
            try {
                this.f5672a.set(obj, obj2);
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(Class cls, String str) {
        try {
            return new b(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e6) {
            throw new AssertionError(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(v0 v0Var, ObjectInputStream objectInputStream, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            v0Var.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(ObjectInputStream objectInputStream) {
        return objectInputStream.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(t0 t0Var, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(t0Var.asMap().size());
        for (Map.Entry entry : t0Var.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection) entry.getValue()).size());
            for (Object obj : (Collection) entry.getValue()) {
                objectOutputStream.writeObject(obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(v0 v0Var, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(v0Var.entrySet().size());
        for (v0.a aVar : v0Var.entrySet()) {
            objectOutputStream.writeObject(aVar.getElement());
            objectOutputStream.writeInt(aVar.getCount());
        }
    }
}
