package x4;

import java.security.SecureRandom;
/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final z4.b f14229a = new z4.b();

    /* renamed from: b  reason: collision with root package name */
    private byte[] f14230b;

    public d(char[] cArr, long j6) {
        f(cArr, j6);
    }

    private void f(char[] cArr, long j6) {
        if (cArr == null || cArr.length <= 0) {
            throw new a5.a("input password is null or empty, cannot initialize standard encrypter");
        }
        this.f14229a.c(cArr);
        this.f14230b = d();
        this.f14229a.c(cArr);
        byte[] bArr = this.f14230b;
        bArr[11] = (byte) (j6 >>> 24);
        bArr[10] = (byte) (j6 >>> 16);
        c(bArr);
    }

    @Override // x4.c
    public int a(byte[] bArr, int i6, int i7) {
        if (i7 >= 0) {
            for (int i8 = i6; i8 < i6 + i7; i8++) {
                bArr[i8] = b(bArr[i8]);
            }
            return i7;
        }
        throw new a5.a("invalid length specified to decrpyt data");
    }

    protected byte b(byte b6) {
        byte b7 = (byte) ((this.f14229a.b() & 255) ^ b6);
        this.f14229a.d(b6);
        return b7;
    }

    public int c(byte[] bArr) {
        bArr.getClass();
        return a(bArr, 0, bArr.length);
    }

    protected byte[] d() {
        byte[] bArr = new byte[12];
        SecureRandom secureRandom = new SecureRandom();
        for (int i6 = 0; i6 < 12; i6++) {
            bArr[i6] = b((byte) secureRandom.nextInt(256));
        }
        return bArr;
    }

    public byte[] e() {
        return this.f14230b;
    }
}
