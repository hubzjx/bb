package kotlin.text;
/* loaded from: classes.dex */
public enum m implements f {
    IGNORE_CASE(2, 0, 2, null),
    MULTILINE(8, 0, 2, null),
    LITERAL(16, 0, 2, null),
    UNIX_LINES(1, 0, 2, null),
    COMMENTS(4, 0, 2, null),
    DOT_MATCHES_ALL(32, 0, 2, null),
    CANON_EQ(128, 0, 2, null);
    
    private final int mask;
    private final int value;

    m(int i6, int i7) {
        this.value = i6;
        this.mask = i7;
    }

    @Override // kotlin.text.f
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.f
    public int getValue() {
        return this.value;
    }

    /* synthetic */ m(int i6, int i7, int i8, kotlin.jvm.internal.g gVar) {
        this(i6, (i8 & 2) != 0 ? i6 : i7);
    }
}
