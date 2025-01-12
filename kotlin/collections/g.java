package kotlin.collections;

import java.lang.reflect.Array;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class g {
    public static final Object[] a(Object[] objArr, int i6) {
        kotlin.jvm.internal.l.d(objArr, "reference");
        Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), i6);
        if (newInstance != null) {
            return (Object[]) newInstance;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
    }

    public static final void b(int i6, int i7) {
        if (i6 <= i7) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i6 + ") is greater than size (" + i7 + ").");
    }
}
