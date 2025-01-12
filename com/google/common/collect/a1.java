package com.google.common.collect;
/* loaded from: classes.dex */
public abstract class a1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Object obj, int i6) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] b(Object... objArr) {
        return c(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] c(Object[] objArr, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            a(objArr[i7], i7);
        }
        return objArr;
    }

    public static Object[] d(Object[] objArr, int i6) {
        return d1.b(objArr, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] e(Object[] objArr, int i6, int i7, Object[] objArr2) {
        com.google.common.base.j.n(i6, i6 + i7, objArr.length);
        if (objArr2.length < i7) {
            objArr2 = d(objArr2, i7);
        } else if (objArr2.length > i7) {
            objArr2[i7] = null;
        }
        System.arraycopy(objArr, i6, objArr2, 0, i7);
        return objArr2;
    }
}
