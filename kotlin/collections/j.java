package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j extends i {
    public static final boolean o(Object[] objArr, Object obj) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        return s(objArr, obj) >= 0;
    }

    public static final List p(Object[] objArr) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        return (List) q(objArr, new ArrayList());
    }

    public static final Collection q(Object[] objArr, Collection collection) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        kotlin.jvm.internal.l.d(collection, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static int r(Object[] objArr) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        return objArr.length - 1;
    }

    public static final int s(Object[] objArr, Object obj) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        int i6 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i6 < length) {
                if (objArr[i6] == null) {
                    return i6;
                }
                i6++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i6 < length2) {
            if (kotlin.jvm.internal.l.a(obj, objArr[i6])) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public static char t(char[] cArr) {
        kotlin.jvm.internal.l.d(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Object u(Object[] objArr) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static List v(Object[] objArr) {
        List f6;
        List b6;
        List w5;
        kotlin.jvm.internal.l.d(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            f6 = n.f();
            return f6;
        } else if (length != 1) {
            w5 = w(objArr);
            return w5;
        } else {
            b6 = m.b(objArr[0]);
            return b6;
        }
    }

    public static List w(Object[] objArr) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        return new ArrayList(n.c(objArr));
    }
}
