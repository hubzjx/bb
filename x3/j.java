package x3;

import java.util.Map;
/* loaded from: classes.dex */
public final class j extends q {
    @Override // x3.n, com.google.zxing.r
    public s3.b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        if (aVar == com.google.zxing.a.EAN_13) {
            return super.a(str, aVar, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + aVar);
    }

    @Override // x3.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + p.b(str);
            } catch (com.google.zxing.h e6) {
                throw new IllegalArgumentException(e6);
            }
        } else if (length != 13) {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
        } else {
            try {
                if (!p.a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (com.google.zxing.h unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        int i6 = i.f14207f[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int b6 = n.b(zArr, 0, p.f14212a, true) + 0;
        for (int i7 = 1; i7 <= 6; i7++) {
            int digit = Character.digit(str.charAt(i7), 10);
            if (((i6 >> (6 - i7)) & 1) == 1) {
                digit += 10;
            }
            b6 += n.b(zArr, b6, p.f14216e[digit], false);
        }
        int b7 = b6 + n.b(zArr, b6, p.f14213b, false);
        for (int i8 = 7; i8 <= 12; i8++) {
            b7 += n.b(zArr, b7, p.f14215d[Character.digit(str.charAt(i8), 10)], true);
        }
        n.b(zArr, b7, p.f14212a, true);
        return zArr;
    }
}
