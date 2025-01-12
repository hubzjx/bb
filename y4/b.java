package y4;

import i5.i0;
import okhttp3.dnsoverhttps.DnsOverHttps;
import okhttp3.internal.http2.Http2Connection;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private c f14340a;

    /* renamed from: b  reason: collision with root package name */
    private d f14341b;

    public b(c cVar) {
        this(cVar, null);
    }

    private byte[] b(d dVar, byte[] bArr, int i6, int i7) {
        byte[] bArr2 = bArr == null ? new byte[0] : bArr;
        int b6 = dVar.b();
        int e6 = e(i7, b6);
        int i8 = i7 - ((e6 - 1) * b6);
        byte[] bArr3 = new byte[e6 * b6];
        int i9 = 0;
        for (int i10 = 1; i10 <= e6; i10++) {
            c(bArr3, i9, dVar, bArr2, i6, i10);
            i9 += b6;
        }
        if (i8 < b6) {
            byte[] bArr4 = new byte[i7];
            System.arraycopy(bArr3, 0, bArr4, 0, i7);
            return bArr4;
        }
        return bArr3;
    }

    private void c(byte[] bArr, int i6, d dVar, byte[] bArr2, int i7, int i8) {
        int b6 = dVar.b();
        byte[] bArr3 = new byte[b6];
        byte[] bArr4 = new byte[bArr2.length + 4];
        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        a(bArr4, bArr2.length, i8);
        for (int i9 = 0; i9 < i7; i9++) {
            bArr4 = dVar.a(bArr4);
            g(bArr3, bArr4);
        }
        System.arraycopy(bArr3, 0, bArr, i6, b6);
    }

    private void d(byte[] bArr) {
        if (this.f14341b == null) {
            this.f14341b = new a(this.f14340a.a());
        }
        this.f14341b.c(bArr);
    }

    private int e(int i6, int i7) {
        return (i6 / i7) + (i6 % i7 > 0 ? 1 : 0);
    }

    private void g(byte[] bArr, byte[] bArr2) {
        for (int i6 = 0; i6 < bArr.length; i6++) {
            bArr[i6] = (byte) (bArr[i6] ^ bArr2[i6]);
        }
    }

    protected void a(byte[] bArr, int i6, int i7) {
        bArr[i6] = (byte) (i7 / Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
        bArr[i6 + 1] = (byte) (i7 / DnsOverHttps.MAX_RESPONSE_SIZE);
        bArr[i6 + 2] = (byte) (i7 / 256);
        bArr[i6 + 3] = (byte) i7;
    }

    public byte[] f(char[] cArr, int i6) {
        cArr.getClass();
        d(i0.a(cArr));
        if (i6 == 0) {
            i6 = this.f14341b.b();
        }
        return b(this.f14341b, this.f14340a.c(), this.f14340a.b(), i6);
    }

    public b(c cVar, d dVar) {
        this.f14340a = cVar;
        this.f14341b = dVar;
    }
}
