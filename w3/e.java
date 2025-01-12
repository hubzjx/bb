package w3;

import java.util.Arrays;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f14107a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14108b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14109c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f14110d;

    public e(CharSequence charSequence, int i6, int i7) {
        this.f14107a = charSequence;
        this.f14109c = i6;
        this.f14108b = i7;
        byte[] bArr = new byte[i6 * i7];
        this.f14110d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    private void a(int i6) {
        g(this.f14108b - 1, 0, i6, 1);
        g(this.f14108b - 1, 1, i6, 2);
        g(this.f14108b - 1, 2, i6, 3);
        g(0, this.f14109c - 2, i6, 4);
        g(0, this.f14109c - 1, i6, 5);
        g(1, this.f14109c - 1, i6, 6);
        g(2, this.f14109c - 1, i6, 7);
        g(3, this.f14109c - 1, i6, 8);
    }

    private void b(int i6) {
        g(this.f14108b - 3, 0, i6, 1);
        g(this.f14108b - 2, 0, i6, 2);
        g(this.f14108b - 1, 0, i6, 3);
        g(0, this.f14109c - 4, i6, 4);
        g(0, this.f14109c - 3, i6, 5);
        g(0, this.f14109c - 2, i6, 6);
        g(0, this.f14109c - 1, i6, 7);
        g(1, this.f14109c - 1, i6, 8);
    }

    private void c(int i6) {
        g(this.f14108b - 3, 0, i6, 1);
        g(this.f14108b - 2, 0, i6, 2);
        g(this.f14108b - 1, 0, i6, 3);
        g(0, this.f14109c - 2, i6, 4);
        g(0, this.f14109c - 1, i6, 5);
        g(1, this.f14109c - 1, i6, 6);
        g(2, this.f14109c - 1, i6, 7);
        g(3, this.f14109c - 1, i6, 8);
    }

    private void d(int i6) {
        g(this.f14108b - 1, 0, i6, 1);
        g(this.f14108b - 1, this.f14109c - 1, i6, 2);
        g(0, this.f14109c - 3, i6, 3);
        g(0, this.f14109c - 2, i6, 4);
        g(0, this.f14109c - 1, i6, 5);
        g(1, this.f14109c - 3, i6, 6);
        g(1, this.f14109c - 2, i6, 7);
        g(1, this.f14109c - 1, i6, 8);
    }

    private boolean f(int i6, int i7) {
        return this.f14110d[(i7 * this.f14109c) + i6] >= 0;
    }

    private void g(int i6, int i7, int i8, int i9) {
        if (i6 < 0) {
            int i10 = this.f14108b;
            i6 += i10;
            i7 += 4 - ((i10 + 4) % 8);
        }
        if (i7 < 0) {
            int i11 = this.f14109c;
            i7 += i11;
            i6 += 4 - ((i11 + 4) % 8);
        }
        i(i7, i6, (this.f14107a.charAt(i8) & (1 << (8 - i9))) != 0);
    }

    private void i(int i6, int i7, boolean z5) {
        this.f14110d[(i7 * this.f14109c) + i6] = z5 ? (byte) 1 : (byte) 0;
    }

    private void j(int i6, int i7, int i8) {
        int i9 = i6 - 2;
        int i10 = i7 - 2;
        g(i9, i10, i8, 1);
        int i11 = i7 - 1;
        g(i9, i11, i8, 2);
        int i12 = i6 - 1;
        g(i12, i10, i8, 3);
        g(i12, i11, i8, 4);
        g(i12, i7, i8, 5);
        g(i6, i10, i8, 6);
        g(i6, i11, i8, 7);
        g(i6, i7, i8, 8);
    }

    public final boolean e(int i6, int i7) {
        return this.f14110d[(i7 * this.f14109c) + i6] == 1;
    }

    public final void h() {
        int i6;
        int i7;
        int i8 = 0;
        int i9 = 0;
        int i10 = 4;
        while (true) {
            if (i10 == this.f14108b && i8 == 0) {
                a(i9);
                i9++;
            }
            if (i10 == this.f14108b - 2 && i8 == 0 && this.f14109c % 4 != 0) {
                b(i9);
                i9++;
            }
            if (i10 == this.f14108b - 2 && i8 == 0 && this.f14109c % 8 == 4) {
                c(i9);
                i9++;
            }
            if (i10 == this.f14108b + 4 && i8 == 2 && this.f14109c % 8 == 0) {
                d(i9);
                i9++;
            }
            do {
                if (i10 < this.f14108b && i8 >= 0 && !f(i8, i10)) {
                    j(i10, i8, i9);
                    i9++;
                }
                i10 -= 2;
                i8 += 2;
                if (i10 < 0) {
                    break;
                }
            } while (i8 < this.f14109c);
            int i11 = i10 + 1;
            int i12 = i8 + 3;
            do {
                if (i11 >= 0 && i12 < this.f14109c && !f(i12, i11)) {
                    j(i11, i12, i9);
                    i9++;
                }
                i11 += 2;
                i12 -= 2;
                i6 = this.f14108b;
                if (i11 >= i6) {
                    break;
                }
            } while (i12 >= 0);
            i10 = i11 + 3;
            i8 = i12 + 1;
            if (i10 >= i6 && i8 >= (i7 = this.f14109c)) {
                break;
            }
        }
        if (f(i7 - 1, i6 - 1)) {
            return;
        }
        i(this.f14109c - 1, this.f14108b - 1, true);
        i(this.f14109c - 2, this.f14108b - 2, true);
    }
}
