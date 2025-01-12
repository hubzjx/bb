package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes.dex */
public abstract class n extends m {
    public static final Collection c(Object[] objArr) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        return new d(objArr, false);
    }

    public static final int d(List list, Comparable comparable, int i6, int i7) {
        int a6;
        kotlin.jvm.internal.l.d(list, "<this>");
        m(list.size(), i6, i7);
        int i8 = i7 - 1;
        while (i6 <= i8) {
            int i9 = (i6 + i8) >>> 1;
            a6 = i4.b.a((Comparable) list.get(i9), comparable);
            if (a6 < 0) {
                i6 = i9 + 1;
            } else if (a6 <= 0) {
                return i9;
            } else {
                i8 = i9 - 1;
            }
        }
        return -(i6 + 1);
    }

    public static /* synthetic */ int e(List list, Comparable comparable, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = list.size();
        }
        return d(list, comparable, i6, i7);
    }

    public static List f() {
        return x.INSTANCE;
    }

    public static r4.c g(Collection collection) {
        kotlin.jvm.internal.l.d(collection, "<this>");
        return new r4.c(0, collection.size() - 1);
    }

    public static int h(List list) {
        kotlin.jvm.internal.l.d(list, "<this>");
        return list.size() - 1;
    }

    public static List i(Object... objArr) {
        List f6;
        List c6;
        kotlin.jvm.internal.l.d(objArr, "elements");
        if (objArr.length > 0) {
            c6 = i.c(objArr);
            return c6;
        }
        f6 = f();
        return f6;
    }

    public static List j(Object... objArr) {
        kotlin.jvm.internal.l.d(objArr, "elements");
        return j.p(objArr);
    }

    public static List k(Object... objArr) {
        kotlin.jvm.internal.l.d(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new d(objArr, true));
    }

    public static List l(List list) {
        List f6;
        List b6;
        kotlin.jvm.internal.l.d(list, "<this>");
        int size = list.size();
        if (size == 0) {
            f6 = f();
            return f6;
        } else if (size != 1) {
            return list;
        } else {
            b6 = m.b(list.get(0));
            return b6;
        }
    }

    private static final void m(int i6, int i7, int i8) {
        if (i7 > i8) {
            throw new IllegalArgumentException("fromIndex (" + i7 + ") is greater than toIndex (" + i8 + ").");
        } else if (i7 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i7 + ") is less than zero.");
        } else if (i8 <= i6) {
        } else {
            throw new IndexOutOfBoundsException("toIndex (" + i8 + ") is greater than size (" + i6 + ").");
        }
    }

    public static void n() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void o() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
