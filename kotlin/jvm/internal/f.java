package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Object[] f11320a = new Object[0];

    public static final Object[] a(Collection collection) {
        l.d(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr = new Object[size];
                int i6 = 0;
                while (true) {
                    int i7 = i6 + 1;
                    objArr[i6] = it.next();
                    if (i7 >= objArr.length) {
                        if (!it.hasNext()) {
                            return objArr;
                        }
                        int i8 = ((i7 * 3) + 1) >>> 1;
                        if (i8 <= i7) {
                            i8 = 2147483645;
                            if (i7 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr = Arrays.copyOf(objArr, i8);
                        l.c(objArr, "copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i7);
                        l.c(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i6 = i7;
                }
            }
        }
        return f11320a;
    }

    public static final Object[] b(Collection collection, Object[] objArr) {
        Object[] objArr2;
        l.d(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i6 = 0;
        if (size == 0) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int i7 = i6 + 1;
            objArr2[i6] = it.next();
            if (i7 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i8 = ((i7 * 3) + 1) >>> 1;
                if (i8 <= i7) {
                    i8 = 2147483645;
                    if (i7 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr2 = Arrays.copyOf(objArr2, i8);
                l.c(objArr2, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i7] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i7);
                l.c(copyOf, "copyOf(result, size)");
                return copyOf;
            }
            i6 = i7;
        }
    }
}
