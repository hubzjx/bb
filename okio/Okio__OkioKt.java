package okio;

import java.io.Closeable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class Okio__OkioKt {
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final BufferedSink buffer(Sink sink) {
        kotlin.jvm.internal.l.d(sink, "<this>");
        return new RealBufferedSink(sink);
    }

    public static final <T extends Closeable, R> R use(T t5, p4.l lVar) {
        R r5;
        kotlin.jvm.internal.l.d(lVar, "block");
        Throwable th = null;
        try {
            r5 = (R) lVar.invoke(t5);
        } catch (Throwable th2) {
            th = th2;
            r5 = null;
        }
        if (t5 != null) {
            try {
                t5.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    h4.b.a(th, th3);
                }
            }
        }
        if (th == null) {
            kotlin.jvm.internal.l.b(r5);
            return r5;
        }
        throw th;
    }

    public static final BufferedSource buffer(Source source) {
        kotlin.jvm.internal.l.d(source, "<this>");
        return new RealBufferedSource(source);
    }
}
