package s3;
/* loaded from: classes.dex */
public abstract class h extends com.google.zxing.b {

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f13284d = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private byte[] f13285b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f13286c;

    public h(com.google.zxing.i iVar) {
        super(iVar);
        this.f13285b = f13284d;
        this.f13286c = new int[32];
    }

    private static int c(int[] iArr) {
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = iArr[i9];
            if (i10 > i6) {
                i8 = i9;
                i6 = i10;
            }
            if (i10 > i7) {
                i7 = i10;
            }
        }
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            int i14 = i13 - i8;
            int i15 = iArr[i13] * i14 * i14;
            if (i15 > i12) {
                i11 = i13;
                i12 = i15;
            }
        }
        if (i8 <= i11) {
            int i16 = i8;
            i8 = i11;
            i11 = i16;
        }
        if (i8 - i11 > length / 16) {
            int i17 = i8 - 1;
            int i18 = i17;
            int i19 = -1;
            while (i17 > i11) {
                int i20 = i17 - i11;
                int i21 = i20 * i20 * (i8 - i17) * (i7 - iArr[i17]);
                if (i21 > i19) {
                    i18 = i17;
                    i19 = i21;
                }
                i17--;
            }
            return i18 << 3;
        }
        throw com.google.zxing.k.getNotFoundInstance();
    }

    private void d(int i6) {
        if (this.f13285b.length < i6) {
            this.f13285b = new byte[i6];
        }
        for (int i7 = 0; i7 < 32; i7++) {
            this.f13286c[i7] = 0;
        }
    }

    @Override // com.google.zxing.b
    public b a() {
        com.google.zxing.i b6 = b();
        int d6 = b6.d();
        int a6 = b6.a();
        b bVar = new b(d6, a6);
        d(d6);
        int[] iArr = this.f13286c;
        for (int i6 = 1; i6 < 5; i6++) {
            byte[] c6 = b6.c((a6 * i6) / 5, this.f13285b);
            int i7 = (d6 << 2) / 5;
            for (int i8 = d6 / 5; i8 < i7; i8++) {
                int i9 = (c6[i8] & 255) >> 3;
                iArr[i9] = iArr[i9] + 1;
            }
        }
        int c7 = c(iArr);
        byte[] b7 = b6.b();
        for (int i10 = 0; i10 < a6; i10++) {
            int i11 = i10 * d6;
            for (int i12 = 0; i12 < d6; i12++) {
                if ((b7[i11 + i12] & 255) < c7) {
                    bVar.j(i12, i10);
                }
            }
        }
        return bVar;
    }
}
