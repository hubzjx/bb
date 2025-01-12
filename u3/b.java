package u3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f13620a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f13621b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f13620a = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f13621b = iArr;
            return;
        }
        int i6 = 1;
        while (i6 < length && iArr[i6] == 0) {
            i6++;
        }
        if (i6 == length) {
            this.f13621b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i6];
        this.f13621b = iArr2;
        System.arraycopy(iArr, i6, iArr2, 0, iArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(b bVar) {
        if (this.f13620a.equals(bVar.f13620a)) {
            if (g()) {
                return bVar;
            }
            if (bVar.g()) {
                return this;
            }
            int[] iArr = this.f13621b;
            int[] iArr2 = bVar.f13621b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i6 = length; i6 < iArr.length; i6++) {
                iArr3[i6] = a.a(iArr2[i6 - length], iArr[i6]);
            }
            return new b(this.f13620a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b[] b(b bVar) {
        if (this.f13620a.equals(bVar.f13620a)) {
            if (bVar.g()) {
                throw new IllegalArgumentException("Divide by 0");
            }
            b g6 = this.f13620a.g();
            int h6 = this.f13620a.h(bVar.d(bVar.f()));
            b bVar2 = this;
            while (bVar2.f() >= bVar.f() && !bVar2.g()) {
                int f6 = bVar2.f() - bVar.f();
                int j6 = this.f13620a.j(bVar2.d(bVar2.f()), h6);
                b j7 = bVar.j(f6, j6);
                g6 = g6.a(this.f13620a.b(f6, j6));
                bVar2 = bVar2.a(j7);
            }
            return new b[]{g6, bVar2};
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i6) {
        if (i6 == 0) {
            return d(0);
        }
        if (i6 == 1) {
            int i7 = 0;
            for (int i8 : this.f13621b) {
                i7 = a.a(i7, i8);
            }
            return i7;
        }
        int[] iArr = this.f13621b;
        int i9 = iArr[0];
        int length = iArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            i9 = a.a(this.f13620a.j(i6, i9), this.f13621b[i10]);
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i6) {
        int[] iArr = this.f13621b;
        return iArr[(iArr.length - 1) - i6];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] e() {
        return this.f13621b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f13621b.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.f13621b[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b h(int i6) {
        if (i6 == 0) {
            return this.f13620a.g();
        }
        if (i6 == 1) {
            return this;
        }
        int length = this.f13621b.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = this.f13620a.j(this.f13621b[i7], i6);
        }
        return new b(this.f13620a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b i(b bVar) {
        if (this.f13620a.equals(bVar.f13620a)) {
            if (g() || bVar.g()) {
                return this.f13620a.g();
            }
            int[] iArr = this.f13621b;
            int length = iArr.length;
            int[] iArr2 = bVar.f13621b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[(length + length2) - 1];
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = iArr[i6];
                for (int i8 = 0; i8 < length2; i8++) {
                    int i9 = i6 + i8;
                    iArr3[i9] = a.a(iArr3[i9], this.f13620a.j(i7, iArr2[i8]));
                }
            }
            return new b(this.f13620a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b j(int i6, int i7) {
        if (i6 >= 0) {
            if (i7 == 0) {
                return this.f13620a.g();
            }
            int length = this.f13621b.length;
            int[] iArr = new int[i6 + length];
            for (int i8 = 0; i8 < length; i8++) {
                iArr[i8] = this.f13620a.j(this.f13621b[i8], i7);
            }
            return new b(this.f13620a, iArr);
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        char c6;
        StringBuilder sb = new StringBuilder(f() * 8);
        for (int f6 = f(); f6 >= 0; f6--) {
            int d6 = d(f6);
            if (d6 != 0) {
                if (d6 < 0) {
                    sb.append(" - ");
                    d6 = -d6;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (f6 == 0 || d6 != 1) {
                    int i6 = this.f13620a.i(d6);
                    if (i6 == 0) {
                        c6 = '1';
                    } else if (i6 == 1) {
                        c6 = 'a';
                    } else {
                        sb.append("a^");
                        sb.append(i6);
                    }
                    sb.append(c6);
                }
                if (f6 != 0) {
                    if (f6 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(f6);
                    }
                }
            }
        }
        return sb.toString();
    }
}
