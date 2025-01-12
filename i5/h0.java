package i5;

import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
/* loaded from: classes.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f11041a = new byte[2];

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f11042b = new byte[4];

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f11043c = new byte[8];

    private void i(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
    }

    public int a(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.f11042b);
        return b(this.f11042b);
    }

    public int b(byte[] bArr) {
        return c(bArr, 0);
    }

    public int c(byte[] bArr, int i6) {
        return ((((bArr[i6 + 3] & 255) << 8) | (bArr[i6 + 2] & 255)) << 16) | (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8);
    }

    public long d(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.f11043c);
        return f(this.f11043c, 0);
    }

    public long e(RandomAccessFile randomAccessFile, int i6) {
        i(this.f11043c);
        randomAccessFile.readFully(this.f11043c, 0, i6);
        return f(this.f11043c, 0);
    }

    public long f(byte[] bArr, int i6) {
        if (bArr.length - i6 < 8) {
            i(this.f11043c);
        }
        System.arraycopy(bArr, i6, this.f11043c, 0, bArr.length < 8 ? bArr.length - i6 : 8);
        byte[] bArr2 = this.f11043c;
        return (bArr2[0] & 255) | (((((((((((((((bArr2[7] & 255) | 0) << 8) | (bArr2[6] & 255)) << 8) | (bArr2[5] & 255)) << 8) | (bArr2[4] & 255)) << 8) | (bArr2[3] & 255)) << 8) | (bArr2[2] & 255)) << 8) | (bArr2[1] & 255)) << 8);
    }

    public int g(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.f11041a);
        return h(this.f11041a, 0);
    }

    public int h(byte[] bArr, int i6) {
        return ((bArr[i6 + 1] & 255) << 8) | (bArr[i6] & 255);
    }

    public void j(OutputStream outputStream, int i6) {
        k(this.f11042b, 0, i6);
        outputStream.write(this.f11042b);
    }

    public void k(byte[] bArr, int i6, int i7) {
        bArr[i6 + 3] = (byte) (i7 >>> 24);
        bArr[i6 + 2] = (byte) (i7 >>> 16);
        bArr[i6 + 1] = (byte) (i7 >>> 8);
        bArr[i6] = (byte) (i7 & 255);
    }

    public void l(OutputStream outputStream, long j6) {
        m(this.f11043c, 0, j6);
        outputStream.write(this.f11043c);
    }

    public void m(byte[] bArr, int i6, long j6) {
        bArr[i6 + 7] = (byte) (j6 >>> 56);
        bArr[i6 + 6] = (byte) (j6 >>> 48);
        bArr[i6 + 5] = (byte) (j6 >>> 40);
        bArr[i6 + 4] = (byte) (j6 >>> 32);
        bArr[i6 + 3] = (byte) (j6 >>> 24);
        bArr[i6 + 2] = (byte) (j6 >>> 16);
        bArr[i6 + 1] = (byte) (j6 >>> 8);
        bArr[i6] = (byte) (j6 & 255);
    }

    public void n(OutputStream outputStream, int i6) {
        o(this.f11041a, 0, i6);
        outputStream.write(this.f11041a);
    }

    public void o(byte[] bArr, int i6, int i7) {
        bArr[i6 + 1] = (byte) (i7 >>> 8);
        bArr[i6] = (byte) (i7 & 255);
    }
}
