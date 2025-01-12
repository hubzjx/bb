package okio;

import java.util.zip.Deflater;
/* renamed from: okio.-DeflaterSinkExtensions  reason: invalid class name */
/* loaded from: classes.dex */
public final class DeflaterSinkExtensions {
    public static final DeflaterSink deflate(Sink sink, Deflater deflater) {
        kotlin.jvm.internal.l.d(sink, "<this>");
        kotlin.jvm.internal.l.d(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink sink, Deflater deflater, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            deflater = new Deflater();
        }
        kotlin.jvm.internal.l.d(sink, "<this>");
        kotlin.jvm.internal.l.d(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }
}
