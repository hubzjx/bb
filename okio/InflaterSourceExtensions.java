package okio;

import java.util.zip.Inflater;
/* renamed from: okio.-InflaterSourceExtensions  reason: invalid class name */
/* loaded from: classes.dex */
public final class InflaterSourceExtensions {
    public static final InflaterSource inflate(Source source, Inflater inflater) {
        kotlin.jvm.internal.l.d(source, "<this>");
        kotlin.jvm.internal.l.d(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source source, Inflater inflater, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            inflater = new Inflater();
        }
        kotlin.jvm.internal.l.d(source, "<this>");
        kotlin.jvm.internal.l.d(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }
}
