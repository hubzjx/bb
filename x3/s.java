package x3;

import java.util.Map;
/* loaded from: classes.dex */
public final class s extends q {
    @Override // x3.n, com.google.zxing.r
    public s3.b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        if (aVar == com.google.zxing.a.UPC_E) {
            return super.a(str, aVar, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got " + aVar);
    }

    @Override // x3.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + p.b(r.c(str));
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
        int digit = Character.digit(str.charAt(0), 10);
        if (digit == 0 || digit == 1) {
            int i6 = r.f14218g[digit][Character.digit(str.charAt(7), 10)];
            boolean[] zArr = new boolean[51];
            int b6 = n.b(zArr, 0, p.f14212a, true) + 0;
            for (int i7 = 1; i7 <= 6; i7++) {
                int digit2 = Character.digit(str.charAt(i7), 10);
                if (((i6 >> (6 - i7)) & 1) == 1) {
                    digit2 += 10;
                }
                b6 += n.b(zArr, b6, p.f14216e[digit2], false);
            }
            n.b(zArr, b6, p.f14214c, false);
            return zArr;
        }
        throw new IllegalArgumentException("Number system must be 0 or 1");
    }
}
