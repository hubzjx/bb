package w1;

import java.util.Arrays;
import java.util.Random;
/* loaded from: classes.dex */
public interface t0 {

    /* loaded from: classes.dex */
    public static class a implements t0 {

        /* renamed from: a  reason: collision with root package name */
        private final Random f14034a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f14035b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f14036c;

        public a(int i6) {
            this(i6, new Random());
        }

        private static int[] i(int i6, Random random) {
            int[] iArr = new int[i6];
            int i7 = 0;
            while (i7 < i6) {
                int i8 = i7 + 1;
                int nextInt = random.nextInt(i8);
                iArr[i7] = iArr[nextInt];
                iArr[nextInt] = i7;
                i7 = i8;
            }
            return iArr;
        }

        @Override // w1.t0
        public int a() {
            return this.f14035b.length;
        }

        @Override // w1.t0
        public t0 b(int i6, int i7) {
            int i8 = i7 - i6;
            int[] iArr = new int[this.f14035b.length - i8];
            int i9 = 0;
            int i10 = 0;
            while (true) {
                int[] iArr2 = this.f14035b;
                if (i9 >= iArr2.length) {
                    return new a(iArr, new Random(this.f14034a.nextLong()));
                }
                int i11 = iArr2[i9];
                if (i11 < i6 || i11 >= i7) {
                    int i12 = i9 - i10;
                    if (i11 >= i6) {
                        i11 -= i8;
                    }
                    iArr[i12] = i11;
                } else {
                    i10++;
                }
                i9++;
            }
        }

        @Override // w1.t0
        public int c(int i6) {
            int i7 = this.f14036c[i6] + 1;
            int[] iArr = this.f14035b;
            if (i7 < iArr.length) {
                return iArr[i7];
            }
            return -1;
        }

        @Override // w1.t0
        public t0 d(int i6, int i7) {
            int[] iArr = new int[i7];
            int[] iArr2 = new int[i7];
            int i8 = 0;
            int i9 = 0;
            while (i9 < i7) {
                iArr[i9] = this.f14034a.nextInt(this.f14035b.length + 1);
                int i10 = i9 + 1;
                int nextInt = this.f14034a.nextInt(i10);
                iArr2[i9] = iArr2[nextInt];
                iArr2[nextInt] = i9 + i6;
                i9 = i10;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f14035b.length + i7];
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int[] iArr4 = this.f14035b;
                if (i8 >= iArr4.length + i7) {
                    return new a(iArr3, new Random(this.f14034a.nextLong()));
                }
                if (i11 >= i7 || i12 != iArr[i11]) {
                    int i13 = i12 + 1;
                    int i14 = iArr4[i12];
                    iArr3[i8] = i14;
                    if (i14 >= i6) {
                        iArr3[i8] = i14 + i7;
                    }
                    i12 = i13;
                } else {
                    iArr3[i8] = iArr2[i11];
                    i11++;
                }
                i8++;
            }
        }

        @Override // w1.t0
        public int e() {
            int[] iArr = this.f14035b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // w1.t0
        public int f(int i6) {
            int i7 = this.f14036c[i6] - 1;
            if (i7 >= 0) {
                return this.f14035b[i7];
            }
            return -1;
        }

        @Override // w1.t0
        public int g() {
            int[] iArr = this.f14035b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // w1.t0
        public t0 h() {
            return new a(0, new Random(this.f14034a.nextLong()));
        }

        private a(int i6, Random random) {
            this(i(i6, random), random);
        }

        private a(int[] iArr, Random random) {
            this.f14035b = iArr;
            this.f14034a = random;
            this.f14036c = new int[iArr.length];
            for (int i6 = 0; i6 < iArr.length; i6++) {
                this.f14036c[iArr[i6]] = i6;
            }
        }
    }

    int a();

    t0 b(int i6, int i7);

    int c(int i6);

    t0 d(int i6, int i7);

    int e();

    int f(int i6);

    int g();

    t0 h();
}
