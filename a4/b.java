package a4;

import b4.c;
import b4.f;
import com.google.zxing.g;
import com.google.zxing.r;
import java.util.Map;
/* loaded from: classes.dex */
public final class b implements r {
    private static s3.b b(f fVar, int i6, int i7, int i8) {
        b4.b a6 = fVar.a();
        if (a6 != null) {
            int e6 = a6.e();
            int d6 = a6.d();
            int i9 = i8 << 1;
            int i10 = e6 + i9;
            int i11 = i9 + d6;
            int max = Math.max(i6, i10);
            int max2 = Math.max(i7, i11);
            int min = Math.min(max / i10, max2 / i11);
            int i12 = (max - (e6 * min)) / 2;
            int i13 = (max2 - (d6 * min)) / 2;
            s3.b bVar = new s3.b(max, max2);
            int i14 = 0;
            while (i14 < d6) {
                int i15 = i12;
                int i16 = 0;
                while (i16 < e6) {
                    if (a6.b(i16, i14) == 1) {
                        bVar.k(i15, i13, min, min);
                    }
                    i16++;
                    i15 += min;
                }
                i14++;
                i13 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.zxing.r
    public s3.b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (aVar != com.google.zxing.a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + aVar);
        } else if (i6 < 0 || i7 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i6 + 'x' + i7);
        } else {
            com.google.zxing.qrcode.decoder.f fVar = com.google.zxing.qrcode.decoder.f.L;
            int i8 = 4;
            if (map != null) {
                g gVar = g.ERROR_CORRECTION;
                if (map.containsKey(gVar)) {
                    fVar = com.google.zxing.qrcode.decoder.f.valueOf(map.get(gVar).toString());
                }
                g gVar2 = g.MARGIN;
                if (map.containsKey(gVar2)) {
                    i8 = Integer.parseInt(map.get(gVar2).toString());
                }
            }
            return b(c.n(str, fVar, map), i6, i7, i8);
        }
    }
}
