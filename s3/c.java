package s3;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f13271a;

    /* renamed from: b  reason: collision with root package name */
    private int f13272b;

    /* renamed from: c  reason: collision with root package name */
    private int f13273c;

    public c(byte[] bArr) {
        this.f13271a = bArr;
    }

    public int a() {
        return ((this.f13271a.length - this.f13272b) * 8) - this.f13273c;
    }

    public int b(int i6) {
        if (i6 <= 0 || i6 > 32 || i6 > a()) {
            throw new IllegalArgumentException(String.valueOf(i6));
        }
        int i7 = this.f13273c;
        int i8 = 0;
        if (i7 > 0) {
            int i9 = 8 - i7;
            int i10 = i6 < i9 ? i6 : i9;
            int i11 = i9 - i10;
            byte[] bArr = this.f13271a;
            int i12 = this.f13272b;
            int i13 = (((255 >> (8 - i10)) << i11) & bArr[i12]) >> i11;
            i6 -= i10;
            int i14 = i7 + i10;
            this.f13273c = i14;
            if (i14 == 8) {
                this.f13273c = 0;
                this.f13272b = i12 + 1;
            }
            i8 = i13;
        }
        if (i6 > 0) {
            while (i6 >= 8) {
                int i15 = i8 << 8;
                byte[] bArr2 = this.f13271a;
                int i16 = this.f13272b;
                i8 = (bArr2[i16] & 255) | i15;
                this.f13272b = i16 + 1;
                i6 -= 8;
            }
            if (i6 > 0) {
                int i17 = 8 - i6;
                int i18 = (i8 << i6) | ((((255 >> i17) << i17) & this.f13271a[this.f13272b]) >> i17);
                this.f13273c += i6;
                return i18;
            }
            return i8;
        }
        return i8;
    }
}
