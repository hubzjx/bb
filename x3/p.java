package x3;
/* loaded from: classes.dex */
public abstract class p extends m {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f14212a = {1, 1, 1};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f14213b = {1, 1, 1, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f14214c = {1, 1, 1, 1, 1, 1};

    /* renamed from: d  reason: collision with root package name */
    static final int[][] f14215d;

    /* renamed from: e  reason: collision with root package name */
    static final int[][] f14216e;

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f14215d = iArr;
        int[][] iArr2 = new int[20];
        f14216e = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i6 = 10; i6 < 20; i6++) {
            int[] iArr3 = f14215d[i6 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i7 = 0; i7 < iArr3.length; i7++) {
                iArr4[i7] = iArr3[(iArr3.length - i7) - 1];
            }
            f14216e[i6] = iArr4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i6 = length - 1;
        return b(charSequence.subSequence(0, i6)) == Character.digit(charSequence.charAt(i6), 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(CharSequence charSequence) {
        int length = charSequence.length();
        int i6 = 0;
        for (int i7 = length - 1; i7 >= 0; i7 -= 2) {
            int charAt = charSequence.charAt(i7) - '0';
            if (charAt < 0 || charAt > 9) {
                throw com.google.zxing.h.getFormatInstance();
            }
            i6 += charAt;
        }
        int i8 = i6 * 3;
        for (int i9 = length - 2; i9 >= 0; i9 -= 2) {
            int charAt2 = charSequence.charAt(i9) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw com.google.zxing.h.getFormatInstance();
            }
            i8 += charAt2;
        }
        return (1000 - i8) % 10;
    }
}
