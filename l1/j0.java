package l1;
/* loaded from: classes.dex */
public abstract class j0 {
    public static int a(byte[] bArr, int i6, int i7) {
        while (i6 < i7 && bArr[i6] != 71) {
            i6++;
        }
        return i6;
    }

    public static long b(com.google.android.exoplayer2.util.y yVar, int i6, int i7) {
        yVar.M(i6);
        if (yVar.a() < 5) {
            return -9223372036854775807L;
        }
        int k6 = yVar.k();
        if ((8388608 & k6) == 0 && ((2096896 & k6) >> 8) == i7) {
            if (((k6 & 32) != 0) && yVar.A() >= 7 && yVar.a() >= 7) {
                if ((yVar.A() & 16) == 16) {
                    byte[] bArr = new byte[6];
                    yVar.i(bArr, 0, 6);
                    return c(bArr);
                }
            }
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    private static long c(byte[] bArr) {
        return ((bArr[0] & 255) << 25) | ((bArr[1] & 255) << 17) | ((bArr[2] & 255) << 9) | ((bArr[3] & 255) << 1) | ((255 & bArr[4]) >> 7);
    }
}
