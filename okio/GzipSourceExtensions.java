package okio;
/* renamed from: okio.-GzipSourceExtensions  reason: invalid class name */
/* loaded from: classes.dex */
public final class GzipSourceExtensions {
    private static final int FCOMMENT = 4;
    private static final int FEXTRA = 2;
    private static final int FHCRC = 1;
    private static final int FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;

    private static final boolean getBit(int i6, int i7) {
        return ((i6 >> i7) & 1) == 1;
    }

    public static final GzipSource gzip(Source source) {
        kotlin.jvm.internal.l.d(source, "<this>");
        return new GzipSource(source);
    }
}
