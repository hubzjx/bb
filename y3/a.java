package y3;

import com.google.zxing.g;
import com.google.zxing.r;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;
import s3.b;
import z3.c;
import z3.d;
/* loaded from: classes.dex */
public final class a implements r {
    private static b b(byte[][] bArr, int i6) {
        int i7 = i6 * 2;
        b bVar = new b(bArr[0].length + i7, bArr.length + i7);
        bVar.b();
        int g6 = (bVar.g() - i6) - 1;
        int i8 = 0;
        while (i8 < bArr.length) {
            byte[] bArr2 = bArr[i8];
            for (int i9 = 0; i9 < bArr[0].length; i9++) {
                if (bArr2[i9] == 1) {
                    bVar.j(i9 + i6, g6);
                }
            }
            i8++;
            g6--;
        }
        return bVar;
    }

    private static b c(d dVar, String str, int i6, int i7, int i8, int i9) {
        boolean z5;
        dVar.e(str, i6);
        byte[][] b6 = dVar.f().b(1, 4);
        if ((i8 > i7) != (b6[0].length < b6.length)) {
            b6 = d(b6);
            z5 = true;
        } else {
            z5 = false;
        }
        int length = i7 / b6[0].length;
        int length2 = i8 / b6.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            byte[][] b7 = dVar.f().b(length, length << 2);
            if (z5) {
                b7 = d(b7);
            }
            return b(b7, i9);
        }
        return b(b6, i9);
    }

    private static byte[][] d(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(Byte.TYPE, bArr[0].length, bArr.length);
        for (int i6 = 0; i6 < bArr.length; i6++) {
            int length = (bArr.length - i6) - 1;
            for (int i7 = 0; i7 < bArr[0].length; i7++) {
                bArr2[i7][length] = bArr[i6][i7];
            }
        }
        return bArr2;
    }

    @Override // com.google.zxing.r
    public b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        int i8;
        int i9;
        if (aVar != com.google.zxing.a.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + aVar);
        }
        d dVar = new d();
        if (map != null) {
            g gVar = g.PDF417_COMPACT;
            if (map.containsKey(gVar)) {
                dVar.h(Boolean.valueOf(map.get(gVar).toString()).booleanValue());
            }
            g gVar2 = g.PDF417_COMPACTION;
            if (map.containsKey(gVar2)) {
                dVar.i(c.valueOf(map.get(gVar2).toString()));
            }
            g gVar3 = g.PDF417_DIMENSIONS;
            if (map.containsKey(gVar3)) {
                android.support.v4.media.a.a(map.get(gVar3));
                throw null;
            }
            g gVar4 = g.MARGIN;
            int parseInt = map.containsKey(gVar4) ? Integer.parseInt(map.get(gVar4).toString()) : 30;
            g gVar5 = g.ERROR_CORRECTION;
            int parseInt2 = map.containsKey(gVar5) ? Integer.parseInt(map.get(gVar5).toString()) : 2;
            g gVar6 = g.CHARACTER_SET;
            if (map.containsKey(gVar6)) {
                dVar.j(Charset.forName(map.get(gVar6).toString()));
            }
            i9 = parseInt;
            i8 = parseInt2;
        } else {
            i8 = 2;
            i9 = 30;
        }
        return c(dVar, str, i8, i6, i7, i9);
    }
}
