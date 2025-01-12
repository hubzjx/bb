package l;
/* loaded from: classes.dex */
abstract class c {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f11364a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    static final long[] f11365b = new long[0];

    /* renamed from: c  reason: collision with root package name */
    static final Object[] f11366c = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int[] iArr, int i6, int i7) {
        int i8 = i6 - 1;
        int i9 = 0;
        while (i9 <= i8) {
            int i10 = (i9 + i8) >>> 1;
            int i11 = iArr[i10];
            if (i11 < i7) {
                i9 = i10 + 1;
            } else if (i11 <= i7) {
                return i10;
            } else {
                i8 = i10 - 1;
            }
        }
        return ~i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(long[] jArr, int i6, long j6) {
        int i7 = i6 - 1;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            int i10 = (jArr[i9] > j6 ? 1 : (jArr[i9] == j6 ? 0 : -1));
            if (i10 < 0) {
                i8 = i9 + 1;
            } else if (i10 <= 0) {
                return i9;
            } else {
                i7 = i9 - 1;
            }
        }
        return ~i8;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int d(int i6) {
        for (int i7 = 4; i7 < 32; i7++) {
            int i8 = (1 << i7) - 12;
            if (i6 <= i8) {
                return i8;
            }
        }
        return i6;
    }

    public static int e(int i6) {
        return d(i6 * 4) / 4;
    }

    public static int f(int i6) {
        return d(i6 * 8) / 8;
    }
}
