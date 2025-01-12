package x3;

import java.util.Map;
/* loaded from: classes.dex */
public final class k extends q {
    @Override // x3.n, com.google.zxing.r
    public s3.b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        if (aVar == com.google.zxing.a.EAN_8) {
            return super.a(str, aVar, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + aVar);
    }

    @Override // x3.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + p.b(str);
            } catch (com.google.zxing.h e6) {
                throw new IllegalArgumentException(e6);
            }
        } else if (length != 8) {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + length);
        } else {
            try {
                if (!p.a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (com.google.zxing.h unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        boolean[] zArr = new boolean[67];
        int b6 = n.b(zArr, 0, p.f14212a, true) + 0;
        for (int i6 = 0; i6 <= 3; i6++) {
            b6 += n.b(zArr, b6, p.f14215d[Character.digit(str.charAt(i6), 10)], false);
        }
        int b7 = b6 + n.b(zArr, b6, p.f14213b, false);
        for (int i7 = 4; i7 <= 7; i7++) {
            b7 += n.b(zArr, b7, p.f14215d[Character.digit(str.charAt(i7), 10)], true);
        }
        n.b(zArr, b7, p.f14212a, true);
        return zArr;
    }
}
