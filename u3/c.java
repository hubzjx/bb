package u3;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f13622a;

    public c(a aVar) {
        this.f13622a = aVar;
    }

    private int[] b(b bVar) {
        int f6 = bVar.f();
        int i6 = 0;
        if (f6 == 1) {
            return new int[]{bVar.d(1)};
        }
        int[] iArr = new int[f6];
        for (int i7 = 1; i7 < this.f13622a.f() && i6 < f6; i7++) {
            if (bVar.c(i7) == 0) {
                iArr[i6] = this.f13622a.h(i7);
                i6++;
            }
        }
        if (i6 == f6) {
            return iArr;
        }
        throw new e("Error locator degree does not match number of roots");
    }

    private int[] c(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            int h6 = this.f13622a.h(iArr[i6]);
            int i7 = 1;
            for (int i8 = 0; i8 < length; i8++) {
                if (i6 != i8) {
                    int j6 = this.f13622a.j(iArr[i8], h6);
                    i7 = this.f13622a.j(i7, (j6 & 1) == 0 ? j6 | 1 : j6 & (-2));
                }
            }
            iArr2[i6] = this.f13622a.j(bVar.c(h6), this.f13622a.h(i7));
            if (this.f13622a.d() != 0) {
                iArr2[i6] = this.f13622a.j(iArr2[i6], h6);
            }
        }
        return iArr2;
    }

    private b[] d(b bVar, b bVar2, int i6) {
        if (bVar.f() < bVar2.f()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b g6 = this.f13622a.g();
        b e6 = this.f13622a.e();
        do {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
            b bVar4 = e6;
            b bVar5 = g6;
            g6 = bVar4;
            if (bVar.f() < i6 / 2) {
                int d6 = g6.d(0);
                if (d6 != 0) {
                    int h6 = this.f13622a.h(d6);
                    return new b[]{g6.h(h6), bVar.h(h6)};
                }
                throw new e("sigmaTilde(0) was zero");
            } else if (bVar.g()) {
                throw new e("r_{i-1} was zero");
            } else {
                b g7 = this.f13622a.g();
                int h7 = this.f13622a.h(bVar.d(bVar.f()));
                while (bVar2.f() >= bVar.f() && !bVar2.g()) {
                    int f6 = bVar2.f() - bVar.f();
                    int j6 = this.f13622a.j(bVar2.d(bVar2.f()), h7);
                    g7 = g7.a(this.f13622a.b(f6, j6));
                    bVar2 = bVar2.a(bVar.j(f6, j6));
                }
                e6 = g7.i(g6).a(bVar5);
            }
        } while (bVar2.f() < bVar.f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    public void a(int[] iArr, int i6) {
        b bVar = new b(this.f13622a, iArr);
        int[] iArr2 = new int[i6];
        boolean z5 = true;
        for (int i7 = 0; i7 < i6; i7++) {
            a aVar = this.f13622a;
            int c6 = bVar.c(aVar.c(aVar.d() + i7));
            iArr2[(i6 - 1) - i7] = c6;
            if (c6 != 0) {
                z5 = false;
            }
        }
        if (z5) {
            return;
        }
        b[] d6 = d(this.f13622a.b(i6, 1), new b(this.f13622a, iArr2), i6);
        b bVar2 = d6[0];
        b bVar3 = d6[1];
        int[] b6 = b(bVar2);
        int[] c7 = c(bVar3, b6);
        for (int i8 = 0; i8 < b6.length; i8++) {
            int length = (iArr.length - 1) - this.f13622a.i(b6[i8]);
            if (length < 0) {
                throw new e("Bad error location");
            }
            iArr[length] = a.a(iArr[length], c7[i8]);
        }
    }
}
