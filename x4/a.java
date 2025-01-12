package x4;

import java.security.SecureRandom;
/* loaded from: classes.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private z4.a f14219a;

    /* renamed from: b  reason: collision with root package name */
    private y4.a f14220b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14222d;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f14225g;

    /* renamed from: h  reason: collision with root package name */
    private final byte[] f14226h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f14227i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f14228j;

    /* renamed from: c  reason: collision with root package name */
    private final SecureRandom f14221c = new SecureRandom();

    /* renamed from: e  reason: collision with root package name */
    private int f14223e = 1;

    /* renamed from: f  reason: collision with root package name */
    private int f14224f = 0;

    public a(char[] cArr, f5.a aVar) {
        if (cArr == null || cArr.length == 0) {
            throw new a5.a("input password is empty or null");
        }
        if (aVar != f5.a.KEY_STRENGTH_128 && aVar != f5.a.KEY_STRENGTH_256) {
            throw new a5.a("Invalid AES key strength");
        }
        this.f14222d = false;
        this.f14226h = new byte[16];
        this.f14225g = new byte[16];
        f(cArr, aVar);
    }

    private byte[] b(int i6) {
        if (i6 == 8 || i6 == 16) {
            int i7 = i6 == 8 ? 2 : 4;
            byte[] bArr = new byte[i6];
            for (int i8 = 0; i8 < i7; i8++) {
                int nextInt = this.f14221c.nextInt();
                int i9 = i8 * 4;
                bArr[i9] = (byte) (nextInt >> 24);
                bArr[i9 + 1] = (byte) (nextInt >> 16);
                bArr[i9 + 2] = (byte) (nextInt >> 8);
                bArr[i9 + 3] = (byte) nextInt;
            }
            return bArr;
        }
        throw new a5.a("invalid salt size, cannot generate salt");
    }

    private void f(char[] cArr, f5.a aVar) {
        byte[] b6 = b(aVar.getSaltLength());
        this.f14228j = b6;
        byte[] a6 = b.a(b6, cArr, aVar);
        this.f14227i = b.b(a6, aVar);
        this.f14219a = b.c(a6, aVar);
        this.f14220b = b.d(a6, aVar);
    }

    @Override // x4.c
    public int a(byte[] bArr, int i6, int i7) {
        int i8;
        if (this.f14222d) {
            throw new a5.a("AES Encrypter is in finished state (A non 16 byte block has already been passed to encrypter)");
        }
        if (i7 % 16 != 0) {
            this.f14222d = true;
        }
        int i9 = i6;
        while (true) {
            int i10 = i6 + i7;
            if (i9 >= i10) {
                return i7;
            }
            int i11 = i9 + 16;
            this.f14224f = i11 <= i10 ? 16 : i10 - i9;
            b.e(this.f14225g, this.f14223e);
            this.f14219a.e(this.f14225g, this.f14226h);
            int i12 = 0;
            while (true) {
                i8 = this.f14224f;
                if (i12 < i8) {
                    int i13 = i9 + i12;
                    bArr[i13] = (byte) (bArr[i13] ^ this.f14226h[i12]);
                    i12++;
                }
            }
            this.f14220b.e(bArr, i9, i8);
            this.f14223e++;
            i9 = i11;
        }
    }

    public byte[] c() {
        return this.f14227i;
    }

    public byte[] d() {
        byte[] bArr = new byte[10];
        System.arraycopy(this.f14220b.d(), 0, bArr, 0, 10);
        return bArr;
    }

    public byte[] e() {
        return this.f14228j;
    }
}
