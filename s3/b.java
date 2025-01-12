package s3;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class b implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private final int f13267a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13268b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13269c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f13270d;

    public b(int i6) {
        this(i6, i6);
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f13268b * (this.f13267a + 1));
        for (int i6 = 0; i6 < this.f13268b; i6++) {
            for (int i7 = 0; i7 < this.f13267a; i7++) {
                sb.append(e(i7, i6) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public void b() {
        int length = this.f13270d.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f13270d[i6] = 0;
        }
    }

    /* renamed from: c */
    public b clone() {
        return new b(this.f13267a, this.f13268b, this.f13269c, (int[]) this.f13270d.clone());
    }

    public void d(int i6, int i7) {
        int i8 = (i7 * this.f13269c) + (i6 / 32);
        int[] iArr = this.f13270d;
        iArr[i8] = (1 << (i6 & 31)) ^ iArr[i8];
    }

    public boolean e(int i6, int i7) {
        return ((this.f13270d[(i7 * this.f13269c) + (i6 / 32)] >>> (i6 & 31)) & 1) != 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f13267a == bVar.f13267a && this.f13268b == bVar.f13268b && this.f13269c == bVar.f13269c && Arrays.equals(this.f13270d, bVar.f13270d);
        }
        return false;
    }

    public int[] f() {
        int length = this.f13270d.length - 1;
        while (length >= 0 && this.f13270d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i6 = this.f13269c;
        int i7 = length / i6;
        int i8 = (length % i6) << 5;
        int i9 = 31;
        while ((this.f13270d[length] >>> i9) == 0) {
            i9--;
        }
        return new int[]{i8 + i9, i7};
    }

    public int g() {
        return this.f13268b;
    }

    public int[] h() {
        int[] iArr;
        int i6 = 0;
        while (true) {
            iArr = this.f13270d;
            if (i6 >= iArr.length || iArr[i6] != 0) {
                break;
            }
            i6++;
        }
        if (i6 == iArr.length) {
            return null;
        }
        int i7 = this.f13269c;
        int i8 = i6 / i7;
        int i9 = (i6 % i7) << 5;
        int i10 = iArr[i6];
        int i11 = 0;
        while ((i10 << (31 - i11)) == 0) {
            i11++;
        }
        return new int[]{i9 + i11, i8};
    }

    public int hashCode() {
        int i6 = this.f13267a;
        return (((((((i6 * 31) + i6) * 31) + this.f13268b) * 31) + this.f13269c) * 31) + Arrays.hashCode(this.f13270d);
    }

    public int i() {
        return this.f13267a;
    }

    public void j(int i6, int i7) {
        int i8 = (i7 * this.f13269c) + (i6 / 32);
        int[] iArr = this.f13270d;
        iArr[i8] = (1 << (i6 & 31)) | iArr[i8];
    }

    public void k(int i6, int i7, int i8, int i9) {
        if (i7 < 0 || i6 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i9 <= 0 || i8 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i10 = i8 + i6;
        int i11 = i9 + i7;
        if (i11 > this.f13268b || i10 > this.f13267a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i7 < i11) {
            int i12 = this.f13269c * i7;
            for (int i13 = i6; i13 < i10; i13++) {
                int[] iArr = this.f13270d;
                int i14 = (i13 / 32) + i12;
                iArr[i14] = iArr[i14] | (1 << (i13 & 31));
            }
            i7++;
        }
    }

    public String l(String str, String str2) {
        return a(str, str2, "\n");
    }

    public String toString() {
        return l("X ", "  ");
    }

    public b(int i6, int i7) {
        if (i6 <= 0 || i7 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f13267a = i6;
        this.f13268b = i7;
        int i8 = (i6 + 31) / 32;
        this.f13269c = i8;
        this.f13270d = new int[i8 * i7];
    }

    private b(int i6, int i7, int i8, int[] iArr) {
        this.f13267a = i6;
        this.f13268b = i7;
        this.f13269c = i8;
        this.f13270d = iArr;
    }
}
