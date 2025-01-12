package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class i extends h {
    public static List c(Object[] objArr) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        List a6 = k.a(objArr);
        kotlin.jvm.internal.l.c(a6, "asList(this)");
        return a6;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, int i6, int i7, int i8) {
        kotlin.jvm.internal.l.d(bArr, "<this>");
        kotlin.jvm.internal.l.d(bArr2, "destination");
        System.arraycopy(bArr, i7, bArr2, i6, i8 - i7);
        return bArr2;
    }

    public static final Object[] e(Object[] objArr, Object[] objArr2, int i6, int i7, int i8) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        kotlin.jvm.internal.l.d(objArr2, "destination");
        System.arraycopy(objArr, i7, objArr2, i6, i8 - i7);
        return objArr2;
    }

    public static /* synthetic */ byte[] f(byte[] bArr, byte[] bArr2, int i6, int i7, int i8, int i9, Object obj) {
        byte[] d6;
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = bArr.length;
        }
        d6 = d(bArr, bArr2, i6, i7, i8);
        return d6;
    }

    public static /* synthetic */ Object[] g(Object[] objArr, Object[] objArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = objArr.length;
        }
        return e(objArr, objArr2, i6, i7, i8);
    }

    public static byte[] h(byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.l.d(bArr, "<this>");
        g.b(i7, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i6, i7);
        kotlin.jvm.internal.l.c(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static Object[] i(Object[] objArr, int i6, int i7) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        g.b(i7, objArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, i6, i7);
        kotlin.jvm.internal.l.c(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final void j(int[] iArr, int i6, int i7, int i8) {
        kotlin.jvm.internal.l.d(iArr, "<this>");
        Arrays.fill(iArr, i7, i8, i6);
    }

    public static void k(Object[] objArr, Object obj, int i6, int i7) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        Arrays.fill(objArr, i6, i7, obj);
    }

    public static /* synthetic */ void l(int[] iArr, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = iArr.length;
        }
        j(iArr, i6, i7, i8);
    }

    public static /* synthetic */ void m(Object[] objArr, Object obj, int i6, int i7, int i8, Object obj2) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = objArr.length;
        }
        k(objArr, obj, i6, i7);
    }

    public static final void n(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        kotlin.jvm.internal.l.d(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }
}
