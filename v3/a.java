package v3;

import com.google.zxing.g;
import com.google.zxing.r;
import java.util.Map;
import s3.b;
import w3.e;
import w3.i;
import w3.j;
import w3.k;
import w3.l;
/* loaded from: classes.dex */
public final class a implements r {
    private static b b(b4.b bVar, int i6, int i7) {
        b bVar2;
        int e6 = bVar.e();
        int d6 = bVar.d();
        int max = Math.max(i6, e6);
        int max2 = Math.max(i7, d6);
        int min = Math.min(max / e6, max2 / d6);
        int i8 = (max - (e6 * min)) / 2;
        int i9 = (max2 - (d6 * min)) / 2;
        if (i7 < d6 || i6 < e6) {
            bVar2 = new b(e6, d6);
            i8 = 0;
            i9 = 0;
        } else {
            bVar2 = new b(i6, i7);
        }
        bVar2.b();
        int i10 = 0;
        while (i10 < d6) {
            int i11 = i8;
            int i12 = 0;
            while (i12 < e6) {
                if (bVar.b(i12, i10) == 1) {
                    bVar2.k(i11, i9, min, min);
                }
                i12++;
                i11 += min;
            }
            i10++;
            i9 += min;
        }
        return bVar2;
    }

    private static b c(e eVar, k kVar, int i6, int i7) {
        int h6 = kVar.h();
        int g6 = kVar.g();
        b4.b bVar = new b4.b(kVar.j(), kVar.i());
        int i8 = 0;
        for (int i9 = 0; i9 < g6; i9++) {
            if (i9 % kVar.f14128e == 0) {
                int i10 = 0;
                for (int i11 = 0; i11 < kVar.j(); i11++) {
                    bVar.g(i10, i8, i11 % 2 == 0);
                    i10++;
                }
                i8++;
            }
            int i12 = 0;
            for (int i13 = 0; i13 < h6; i13++) {
                if (i13 % kVar.f14127d == 0) {
                    bVar.g(i12, i8, true);
                    i12++;
                }
                bVar.g(i12, i8, eVar.e(i13, i9));
                i12++;
                int i14 = kVar.f14127d;
                if (i13 % i14 == i14 - 1) {
                    bVar.g(i12, i8, i9 % 2 == 0);
                    i12++;
                }
            }
            i8++;
            int i15 = kVar.f14128e;
            if (i9 % i15 == i15 - 1) {
                int i16 = 0;
                for (int i17 = 0; i17 < kVar.j(); i17++) {
                    bVar.g(i16, i8, true);
                    i16++;
                }
                i8++;
            }
        }
        return b(bVar, i6, i7);
    }

    @Override // com.google.zxing.r
    public b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (aVar != com.google.zxing.a.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + aVar);
        } else if (i6 < 0 || i7 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i6 + 'x' + i7);
        } else {
            l lVar = l.FORCE_NONE;
            if (map != null) {
                l lVar2 = (l) map.get(g.DATA_MATRIX_SHAPE);
                if (lVar2 != null) {
                    lVar = lVar2;
                }
                android.support.v4.media.a.a(map.get(g.MIN_SIZE));
                android.support.v4.media.a.a(map.get(g.MAX_SIZE));
            }
            String b6 = j.b(str, lVar, null, null);
            k l6 = k.l(b6.length(), lVar, null, null, true);
            e eVar = new e(i.c(b6, l6), l6.h(), l6.g());
            eVar.h();
            return c(eVar, l6, i6, i7);
        }
    }
}
