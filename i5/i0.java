package i5;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Calendar;
/* loaded from: classes.dex */
public abstract class i0 {
    public static byte[] a(char[] cArr) {
        try {
            ByteBuffer encode = g0.f11039b.encode(CharBuffer.wrap(cArr));
            byte[] bArr = new byte[encode.limit()];
            encode.get(bArr);
            return bArr;
        } catch (Exception unused) {
            byte[] bArr2 = new byte[cArr.length];
            for (int i6 = 0; i6 < cArr.length; i6++) {
                bArr2[i6] = (byte) cArr[i6];
            }
            return bArr2;
        }
    }

    private static long b(long j6) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j6);
        int i6 = calendar.get(1);
        if (i6 < 1980) {
            return 2162688L;
        }
        return (calendar.get(13) >> 1) | ((i6 - 1980) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5);
    }

    public static long c(long j6) {
        if (j6 < 0) {
            return 2162688L;
        }
        long b6 = b(j6);
        if (b6 != 2162688) {
            return b6 + ((j6 % 2000) << 32);
        }
        return 2162688L;
    }

    public static boolean d(String str) {
        return str != null && str.trim().length() > 0;
    }
}
