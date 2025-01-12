package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.util.Arrays;
/* renamed from: okio.-DeprecatedOkio  reason: invalid class name */
/* loaded from: classes.dex */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    public final Sink appendingSink(File file) {
        kotlin.jvm.internal.l.d(file, "file");
        return Okio.appendingSink(file);
    }

    public final Sink blackhole() {
        return Okio.blackhole();
    }

    public final BufferedSink buffer(Sink sink) {
        kotlin.jvm.internal.l.d(sink, "sink");
        return Okio.buffer(sink);
    }

    public final Sink sink(File file) {
        Sink sink$default;
        kotlin.jvm.internal.l.d(file, "file");
        sink$default = Okio__JvmOkioKt.sink$default(file, false, 1, null);
        return sink$default;
    }

    public final Source source(File file) {
        kotlin.jvm.internal.l.d(file, "file");
        return Okio.source(file);
    }

    public final BufferedSource buffer(Source source) {
        kotlin.jvm.internal.l.d(source, "source");
        return Okio.buffer(source);
    }

    public final Sink sink(OutputStream outputStream) {
        kotlin.jvm.internal.l.d(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    public final Source source(InputStream inputStream) {
        kotlin.jvm.internal.l.d(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    public final Sink sink(Socket socket) {
        kotlin.jvm.internal.l.d(socket, "socket");
        return Okio.sink(socket);
    }

    public final Source source(Socket socket) {
        kotlin.jvm.internal.l.d(socket, "socket");
        return Okio.source(socket);
    }

    public final Sink sink(java.nio.file.Path path, OpenOption... openOptionArr) {
        kotlin.jvm.internal.l.d(path, "path");
        kotlin.jvm.internal.l.d(openOptionArr, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    public final Source source(java.nio.file.Path path, OpenOption... openOptionArr) {
        kotlin.jvm.internal.l.d(path, "path");
        kotlin.jvm.internal.l.d(openOptionArr, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }
}
