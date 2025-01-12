package v;

import java.lang.reflect.Array;
/* loaded from: classes.dex */
abstract class e {
    public static int[] a(int[] iArr, int i6, int i7) {
        if (i6 + 1 > iArr.length) {
            int[] iArr2 = new int[c(i6)];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            iArr = iArr2;
        }
        iArr[i6] = i7;
        return iArr;
    }

    public static Object[] b(Object[] objArr, int i6, Object obj) {
        if (i6 + 1 > objArr.length) {
            Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), c(i6));
            System.arraycopy(objArr, 0, objArr2, 0, i6);
            objArr = objArr2;
        }
        objArr[i6] = obj;
        return objArr;
    }

    public static int c(int i6) {
        if (i6 <= 4) {
            return 8;
        }
        return i6 * 2;
    }
}
