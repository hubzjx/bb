package okio;
/* renamed from: okio.-GzipSinkExtensions  reason: invalid class name */
/* loaded from: classes.dex */
public final class GzipSinkExtensions {
    public static final GzipSink gzip(Sink sink) {
        kotlin.jvm.internal.l.d(sink, "<this>");
        return new GzipSink(sink);
    }
}
