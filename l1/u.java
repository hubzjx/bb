package l1;

import java.util.Arrays;
/* loaded from: classes.dex */
final class u {

    /* renamed from: a  reason: collision with root package name */
    private final int f11750a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11751b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11752c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f11753d;

    /* renamed from: e  reason: collision with root package name */
    public int f11754e;

    public u(int i6, int i7) {
        this.f11750a = i6;
        byte[] bArr = new byte[i7 + 3];
        this.f11753d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i6, int i7) {
        if (this.f11751b) {
            int i8 = i7 - i6;
            byte[] bArr2 = this.f11753d;
            int length = bArr2.length;
            int i9 = this.f11754e;
            if (length < i9 + i8) {
                this.f11753d = Arrays.copyOf(bArr2, (i9 + i8) * 2);
            }
            System.arraycopy(bArr, i6, this.f11753d, this.f11754e, i8);
            this.f11754e += i8;
        }
    }

    public boolean b(int i6) {
        if (this.f11751b) {
            this.f11754e -= i6;
            this.f11751b = false;
            this.f11752c = true;
            return true;
        }
        return false;
    }

    public boolean c() {
        return this.f11752c;
    }

    public void d() {
        this.f11751b = false;
        this.f11752c = false;
    }

    public void e(int i6) {
        com.google.android.exoplayer2.util.a.g(!this.f11751b);
        boolean z5 = i6 == this.f11750a;
        this.f11751b = z5;
        if (z5) {
            this.f11754e = 3;
            this.f11752c = false;
        }
    }
}
