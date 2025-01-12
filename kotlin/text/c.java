package kotlin.text;
/* loaded from: classes.dex */
abstract class c extends b {
    public static final boolean d(char c6, char c7, boolean z5) {
        if (c6 == c7) {
            return true;
        }
        if (z5) {
            char upperCase = Character.toUpperCase(c6);
            char upperCase2 = Character.toUpperCase(c7);
            return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
        }
        return false;
    }
}
