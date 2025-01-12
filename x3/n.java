package x3;

import java.util.Map;
/* loaded from: classes.dex */
public abstract class n implements com.google.zxing.r {
    /* JADX INFO: Access modifiers changed from: protected */
    public static int b(boolean[] zArr, int i6, int[] iArr, boolean z5) {
        int i7 = 0;
        for (int i8 : iArr) {
            int i9 = 0;
            while (i9 < i8) {
                zArr[i6] = z5;
                i9++;
                i6++;
            }
            i7 += i8;
            z5 = !z5;
        }
        return i7;
    }

    private static s3.b e(boolean[] zArr, int i6, int i7, int i8) {
        int length = zArr.length;
        int i9 = i8 + length;
        int max = Math.max(i6, i9);
        int max2 = Math.max(1, i7);
        int i10 = max / i9;
        int i11 = (max - (length * i10)) / 2;
        s3.b bVar = new s3.b(max, max2);
        int i12 = 0;
        while (i12 < length) {
            if (zArr[i12]) {
                bVar.k(i11, 0, i10, max2);
            }
            i12++;
            i11 += i10;
        }
        return bVar;
    }

    @Override // com.google.zxing.r
    public s3.b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i6 < 0 || i7 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i6 + 'x' + i7);
        }
        int d6 = d();
        if (map != null) {
            com.google.zxing.g gVar = com.google.zxing.g.MARGIN;
            if (map.containsKey(gVar)) {
                d6 = Integer.parseInt(map.get(gVar).toString());
            }
        }
        return e(c(str), i6, i7, d6);
    }

    public abstract boolean[] c(String str);

    public int d() {
        return 10;
    }
}
