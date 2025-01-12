package x3;

import java.util.Map;
/* loaded from: classes.dex */
public final class l extends n {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14208a = {1, 1, 1, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f14209b = {3, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f14210c = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // x3.n, com.google.zxing.r
    public s3.b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        if (aVar == com.google.zxing.a.ITF) {
            return super.a(str, aVar, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + aVar);
    }

    @Override // x3.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            if (length > 80) {
                throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
            }
            boolean[] zArr = new boolean[(length * 9) + 9];
            int b6 = n.b(zArr, 0, f14208a, true);
            for (int i6 = 0; i6 < length; i6 += 2) {
                int digit = Character.digit(str.charAt(i6), 10);
                int digit2 = Character.digit(str.charAt(i6 + 1), 10);
                int[] iArr = new int[10];
                for (int i7 = 0; i7 < 5; i7++) {
                    int i8 = i7 * 2;
                    int[][] iArr2 = f14210c;
                    iArr[i8] = iArr2[digit][i7];
                    iArr[i8 + 1] = iArr2[digit2][i7];
                }
                b6 += n.b(zArr, b6, iArr, true);
            }
            n.b(zArr, b6, f14209b, true);
            return zArr;
        }
        throw new IllegalArgumentException("The length of the input should be even");
    }
}
