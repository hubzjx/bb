package j3;
/* loaded from: classes.dex */
abstract class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String str, int i6) {
        if (i6 > 0) {
            return i6;
        }
        throw new IllegalArgumentException(str + " (" + i6 + ") must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z5) {
        if (!z5) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
