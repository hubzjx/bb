package kotlin.text;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class z extends y {
    public static String w0(String str, int i6) {
        int c6;
        kotlin.jvm.internal.l.d(str, "<this>");
        if (i6 >= 0) {
            c6 = r4.f.c(i6, str.length());
            String substring = str.substring(0, c6);
            kotlin.jvm.internal.l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i6 + " is less than zero.").toString());
    }
}
