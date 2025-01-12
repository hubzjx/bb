package kotlin.text;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class v extends u {
    public static Integer f(String str) {
        kotlin.jvm.internal.l.d(str, "<this>");
        return g(str, 10);
    }

    public static final Integer g(String str, int i6) {
        boolean z5;
        int i7;
        int i8;
        kotlin.jvm.internal.l.d(str, "<this>");
        b.a(i6);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i9 = 0;
        char charAt = str.charAt(0);
        int i10 = -2147483647;
        if (kotlin.jvm.internal.l.e(charAt, 48) < 0) {
            i7 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i10 = Integer.MIN_VALUE;
                z5 = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z5 = false;
            }
        } else {
            z5 = false;
            i7 = 0;
        }
        int i11 = -59652323;
        while (i7 < length) {
            int b6 = b.b(str.charAt(i7), i6);
            if (b6 < 0) {
                return null;
            }
            if ((i9 < i11 && (i11 != -59652323 || i9 < (i11 = i10 / i6))) || (i8 = i9 * i6) < i10 + b6) {
                return null;
            }
            i9 = i8 - b6;
            i7++;
        }
        return z5 ? Integer.valueOf(i9) : Integer.valueOf(-i9);
    }
}
