package c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public enum j$l implements j$g {
    SENSITIVE,
    INSENSITIVE,
    /* JADX INFO: Fake field, exist only in values array */
    STRICT,
    LENIENT;

    @Override // c.j$g
    public final boolean a(j$r j_r, StringBuilder sb) {
        return true;
    }

    @Override // java.lang.Enum
    public final String toString() {
        int ordinal = ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        return "ParseStrict(false)";
                    }
                    throw new IllegalStateException("Unreachable");
                }
                return "ParseStrict(true)";
            }
            return "ParseCaseSensitive(false)";
        }
        return "ParseCaseSensitive(true)";
    }
}
