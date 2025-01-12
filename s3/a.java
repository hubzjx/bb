package s3;

import io.jsonwebtoken.JwtParser;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int[] f13265a;

    /* renamed from: b  reason: collision with root package name */
    private int f13266b;

    public a() {
        this.f13266b = 0;
        this.f13265a = new int[1];
    }

    private void e(int i6) {
        if (i6 > (this.f13265a.length << 5)) {
            int[] i7 = i(i6);
            int[] iArr = this.f13265a;
            System.arraycopy(iArr, 0, i7, 0, iArr.length);
            this.f13265a = i7;
        }
    }

    private static int[] i(int i6) {
        return new int[(i6 + 31) / 32];
    }

    public void a(boolean z5) {
        e(this.f13266b + 1);
        if (z5) {
            int[] iArr = this.f13265a;
            int i6 = this.f13266b;
            int i7 = i6 / 32;
            iArr[i7] = (1 << (i6 & 31)) | iArr[i7];
        }
        this.f13266b++;
    }

    public void b(a aVar) {
        int i6 = aVar.f13266b;
        e(this.f13266b + i6);
        for (int i7 = 0; i7 < i6; i7++) {
            a(aVar.f(i7));
        }
    }

    public void c(int i6, int i7) {
        if (i7 < 0 || i7 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        e(this.f13266b + i7);
        while (i7 > 0) {
            boolean z5 = true;
            if (((i6 >> (i7 - 1)) & 1) != 1) {
                z5 = false;
            }
            a(z5);
            i7--;
        }
    }

    /* renamed from: d */
    public a clone() {
        return new a((int[]) this.f13265a.clone(), this.f13266b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f13266b == aVar.f13266b && Arrays.equals(this.f13265a, aVar.f13265a);
        }
        return false;
    }

    public boolean f(int i6) {
        return ((1 << (i6 & 31)) & this.f13265a[i6 / 32]) != 0;
    }

    public int g() {
        return this.f13266b;
    }

    public int h() {
        return (this.f13266b + 7) / 8;
    }

    public int hashCode() {
        return (this.f13266b * 31) + Arrays.hashCode(this.f13265a);
    }

    public void j(int i6, byte[] bArr, int i7, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = 0;
            for (int i11 = 0; i11 < 8; i11++) {
                if (f(i6)) {
                    i10 |= 1 << (7 - i11);
                }
                i6++;
            }
            bArr[i7 + i9] = (byte) i10;
        }
    }

    public void k(a aVar) {
        if (this.f13266b != aVar.f13266b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i6 = 0;
        while (true) {
            int[] iArr = this.f13265a;
            if (i6 >= iArr.length) {
                return;
            }
            iArr[i6] = iArr[i6] ^ aVar.f13265a[i6];
            i6++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f13266b);
        for (int i6 = 0; i6 < this.f13266b; i6++) {
            if ((i6 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(f(i6) ? 'X' : JwtParser.SEPARATOR_CHAR);
        }
        return sb.toString();
    }

    a(int[] iArr, int i6) {
        this.f13265a = iArr;
        this.f13266b = i6;
    }
}
