package x4;
/* loaded from: classes.dex */
public abstract class b {
    public static byte[] a(byte[] bArr, char[] cArr, f5.a aVar) {
        y4.b bVar = new y4.b(new y4.c("HmacSHA1", "ISO-8859-1", bArr, 1000));
        int keyLength = aVar.getKeyLength();
        int macLength = aVar.getMacLength();
        int i6 = keyLength + macLength + 2;
        byte[] f6 = bVar.f(cArr, i6);
        if (f6 == null || f6.length != i6) {
            throw new a5.a(String.format("Derived Key invalid for Key Length [%d] MAC Length [%d]", Integer.valueOf(keyLength), Integer.valueOf(macLength)));
        }
        return f6;
    }

    public static byte[] b(byte[] bArr, f5.a aVar) {
        byte[] bArr2 = new byte[2];
        System.arraycopy(bArr, aVar.getKeyLength() + aVar.getMacLength(), bArr2, 0, 2);
        return bArr2;
    }

    public static z4.a c(byte[] bArr, f5.a aVar) {
        int keyLength = aVar.getKeyLength();
        byte[] bArr2 = new byte[keyLength];
        System.arraycopy(bArr, 0, bArr2, 0, keyLength);
        return new z4.a(bArr2);
    }

    public static y4.a d(byte[] bArr, f5.a aVar) {
        int macLength = aVar.getMacLength();
        byte[] bArr2 = new byte[macLength];
        System.arraycopy(bArr, aVar.getKeyLength(), bArr2, 0, macLength);
        y4.a aVar2 = new y4.a("HmacSHA1");
        aVar2.c(bArr2);
        return aVar2;
    }

    public static void e(byte[] bArr, int i6) {
        bArr[0] = (byte) i6;
        bArr[1] = (byte) (i6 >> 8);
        bArr[2] = (byte) (i6 >> 16);
        bArr[3] = (byte) (i6 >> 24);
        for (int i7 = 4; i7 <= 15; i7++) {
            bArr[i7] = 0;
        }
    }
}
