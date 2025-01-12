package q3;

import com.google.zxing.g;
import com.google.zxing.r;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import r3.c;
import s3.b;
/* loaded from: classes.dex */
public final class a implements r {
    private static b b(String str, com.google.zxing.a aVar, int i6, int i7, Charset charset, int i8, int i9) {
        if (aVar == com.google.zxing.a.AZTEC) {
            return c(c.d(str.getBytes(charset), i8, i9), i6, i7);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + aVar);
    }

    private static b c(r3.a aVar, int i6, int i7) {
        b a6 = aVar.a();
        if (a6 != null) {
            int i8 = a6.i();
            int g6 = a6.g();
            int max = Math.max(i6, i8);
            int max2 = Math.max(i7, g6);
            int min = Math.min(max / i8, max2 / g6);
            int i9 = (max - (i8 * min)) / 2;
            int i10 = (max2 - (g6 * min)) / 2;
            b bVar = new b(max, max2);
            int i11 = 0;
            while (i11 < g6) {
                int i12 = i9;
                int i13 = 0;
                while (i13 < i8) {
                    if (a6.e(i13, i11)) {
                        bVar.k(i12, i10, min, min);
                    }
                    i13++;
                    i12 += min;
                }
                i11++;
                i10 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.zxing.r
    public b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        Charset charset;
        int i8;
        int i9;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        if (map != null) {
            g gVar = g.CHARACTER_SET;
            if (map.containsKey(gVar)) {
                charset2 = Charset.forName(map.get(gVar).toString());
            }
            g gVar2 = g.ERROR_CORRECTION;
            int parseInt = map.containsKey(gVar2) ? Integer.parseInt(map.get(gVar2).toString()) : 33;
            g gVar3 = g.AZTEC_LAYERS;
            if (map.containsKey(gVar3)) {
                charset = charset2;
                i8 = parseInt;
                i9 = Integer.parseInt(map.get(gVar3).toString());
                return b(str, aVar, i6, i7, charset, i8, i9);
            }
            charset = charset2;
            i8 = parseInt;
        } else {
            charset = charset2;
            i8 = 33;
        }
        i9 = 0;
        return b(str, aVar, i6, i7, charset, i8, i9);
    }
}
