package x3;

import java.util.Map;
/* loaded from: classes.dex */
public class h extends n {
    private static int f(boolean[] zArr, int i6, int[] iArr) {
        int length = iArr.length;
        int i7 = 0;
        while (i7 < length) {
            int i8 = i6 + 1;
            zArr[i6] = iArr[i7] != 0;
            i7++;
            i6 = i8;
        }
        return 9;
    }

    private static int g(String str, int i6) {
        int i7 = 0;
        int i8 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i7 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i8;
            i8++;
            if (i8 > i6) {
                i8 = 1;
            }
        }
        return i7 % 47;
    }

    private static void h(int i6, int[] iArr) {
        for (int i7 = 0; i7 < 9; i7++) {
            int i8 = 1;
            if (((1 << (8 - i7)) & i6) == 0) {
                i8 = 0;
            }
            iArr[i7] = i8;
        }
    }

    @Override // x3.n, com.google.zxing.r
    public s3.b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        if (aVar == com.google.zxing.a.CODE_93) {
            return super.a(str, aVar, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got " + aVar);
    }

    @Override // x3.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int[] iArr = new int[9];
        h(g.f14205b[47], iArr);
        boolean[] zArr = new boolean[((str.length() + 2 + 2) * 9) + 1];
        int f6 = f(zArr, 0, iArr);
        for (int i6 = 0; i6 < length; i6++) {
            h(g.f14205b["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i6))], iArr);
            f6 += f(zArr, f6, iArr);
        }
        int g6 = g(str, 20);
        int[] iArr2 = g.f14205b;
        h(iArr2[g6], iArr);
        int f7 = f6 + f(zArr, f6, iArr);
        h(iArr2[g(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(g6), 15)], iArr);
        int f8 = f7 + f(zArr, f7, iArr);
        h(iArr2[47], iArr);
        zArr[f8 + f(zArr, f8, iArr)] = true;
        return zArr;
    }
}
