package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.text.x;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
/* loaded from: classes.dex */
public final /* synthetic */ class Okio__JvmOkioKt {
    private static final Logger logger = Logger.getLogger("okio.Okio");

    public static final Sink appendingSink(File file) {
        kotlin.jvm.internal.l.d(file, "<this>");
        return Okio.sink(new FileOutputStream(file, true));
    }

    public static final FileSystem asResourceFileSystem(ClassLoader classLoader) {
        kotlin.jvm.internal.l.d(classLoader, "<this>");
        return new ResourceFileSystem(classLoader, true);
    }

    public static final CipherSink cipherSink(Sink sink, Cipher cipher) {
        kotlin.jvm.internal.l.d(sink, "<this>");
        kotlin.jvm.internal.l.d(cipher, "cipher");
        return new CipherSink(Okio.buffer(sink), cipher);
    }

    public static final CipherSource cipherSource(Source source, Cipher cipher) {
        kotlin.jvm.internal.l.d(source, "<this>");
        kotlin.jvm.internal.l.d(cipher, "cipher");
        return new CipherSource(Okio.buffer(source), cipher);
    }

    public static final HashingSink hashingSink(Sink sink, MessageDigest messageDigest) {
        kotlin.jvm.internal.l.d(sink, "<this>");
        kotlin.jvm.internal.l.d(messageDigest, "digest");
        return new HashingSink(sink, messageDigest);
    }

    public static final HashingSource hashingSource(Source source, MessageDigest messageDigest) {
        kotlin.jvm.internal.l.d(source, "<this>");
        kotlin.jvm.internal.l.d(messageDigest, "digest");
        return new HashingSource(source, messageDigest);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        kotlin.jvm.internal.l.d(assertionError, "<this>");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            return message != null ? x.D(message, "getsockname failed", false, 2, null) : false;
        }
        return false;
    }

    public static final FileSystem openZip(FileSystem fileSystem, Path path) {
        kotlin.jvm.internal.l.d(fileSystem, "<this>");
        kotlin.jvm.internal.l.d(path, "zipPath");
        return ZipKt.openZip$default(path, fileSystem, null, 4, null);
    }

    public static final Sink sink(File file) {
        Sink sink$default;
        kotlin.jvm.internal.l.d(file, "<this>");
        sink$default = sink$default(file, false, 1, null);
        return sink$default;
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        return Okio.sink(file, z5);
    }

    public static final Source source(File file) {
        kotlin.jvm.internal.l.d(file, "<this>");
        return new InputStreamSource(new FileInputStream(file), Timeout.NONE);
    }

    public static final HashingSink hashingSink(Sink sink, Mac mac) {
        kotlin.jvm.internal.l.d(sink, "<this>");
        kotlin.jvm.internal.l.d(mac, "mac");
        return new HashingSink(sink, mac);
    }

    public static final HashingSource hashingSource(Source source, Mac mac) {
        kotlin.jvm.internal.l.d(source, "<this>");
        kotlin.jvm.internal.l.d(mac, "mac");
        return new HashingSource(source, mac);
    }

    public static final Sink sink(File file, boolean z5) {
        kotlin.jvm.internal.l.d(file, "<this>");
        return Okio.sink(new FileOutputStream(file, z5));
    }

    public static final Source source(InputStream inputStream) {
        kotlin.jvm.internal.l.d(inputStream, "<this>");
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final Sink sink(OutputStream outputStream) {
        kotlin.jvm.internal.l.d(outputStream, "<this>");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static final Source source(Socket socket) {
        kotlin.jvm.internal.l.d(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        kotlin.jvm.internal.l.c(inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    public static final Sink sink(Socket socket) {
        kotlin.jvm.internal.l.d(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        kotlin.jvm.internal.l.c(outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    @IgnoreJRERequirement
    public static final Source source(java.nio.file.Path path, OpenOption... openOptionArr) {
        InputStream newInputStream;
        kotlin.jvm.internal.l.d(path, "<this>");
        kotlin.jvm.internal.l.d(openOptionArr, "options");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        kotlin.jvm.internal.l.c(newInputStream, "newInputStream(this, *options)");
        return Okio.source(newInputStream);
    }

    @IgnoreJRERequirement
    public static final Sink sink(java.nio.file.Path path, OpenOption... openOptionArr) {
        OutputStream newOutputStream;
        kotlin.jvm.internal.l.d(path, "<this>");
        kotlin.jvm.internal.l.d(openOptionArr, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        kotlin.jvm.internal.l.c(newOutputStream, "newOutputStream(this, *options)");
        return Okio.sink(newOutputStream);
    }
}
