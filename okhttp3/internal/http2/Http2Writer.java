package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;
/* loaded from: classes.dex */
public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public Http2Writer(BufferedSink bufferedSink, boolean z5) {
        l.d(bufferedSink, "sink");
        this.sink = bufferedSink;
        this.client = z5;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.maxFrameSize = Http2.INITIAL_MAX_FRAME_SIZE;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, null);
    }

    private final void writeContinuationFrames(int i6, long j6) {
        while (j6 > 0) {
            long min = Math.min(this.maxFrameSize, j6);
            j6 -= min;
            frameHeader(i6, (int) min, 9, j6 == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final synchronized void applyAndAckSettings(Settings settings) {
        l.d(settings, "peerSettings");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
        if (settings.getHeaderTableSize() != -1) {
            this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
        }
        frameHeader(0, 0, 4, 1);
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (this.client) {
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Util.format(l.i(">> CONNECTION ", Http2.CONNECTION_PREFACE.hex()), new Object[0]));
            }
            this.sink.write(Http2.CONNECTION_PREFACE);
            this.sink.flush();
        }
    }

    public final synchronized void data(boolean z5, int i6, Buffer buffer, int i7) {
        if (this.closed) {
            throw new IOException("closed");
        }
        dataFrame(i6, z5 ? 1 : 0, buffer, i7);
    }

    public final void dataFrame(int i6, int i7, Buffer buffer, int i8) {
        frameHeader(i6, i8, 0, i7);
        if (i8 > 0) {
            BufferedSink bufferedSink = this.sink;
            l.b(buffer);
            bufferedSink.write(buffer, i8);
        }
    }

    public final synchronized void flush() {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final void frameHeader(int i6, int i7, int i8, int i9) {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.INSTANCE.frameLog(false, i6, i7, i8, i9));
        }
        if (!(i7 <= this.maxFrameSize)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i7).toString());
        }
        if (!((Integer.MIN_VALUE & i6) == 0)) {
            throw new IllegalArgumentException(l.i("reserved bit set: ", Integer.valueOf(i6)).toString());
        }
        Util.writeMedium(this.sink, i7);
        this.sink.writeByte(i8 & 255);
        this.sink.writeByte(i9 & 255);
        this.sink.writeInt(i6 & Integer.MAX_VALUE);
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i6, ErrorCode errorCode, byte[] bArr) {
        l.d(errorCode, "errorCode");
        l.d(bArr, "debugData");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(errorCode.getHttpCode() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        frameHeader(0, bArr.length + 8, 7, 0);
        this.sink.writeInt(i6);
        this.sink.writeInt(errorCode.getHttpCode());
        if (!(bArr.length == 0)) {
            this.sink.write(bArr);
        }
        this.sink.flush();
    }

    public final synchronized void headers(boolean z5, int i6, List<Header> list) {
        l.d(list, "headerBlock");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long size = this.hpackBuffer.size();
        long min = Math.min(this.maxFrameSize, size);
        int i7 = (size > min ? 1 : (size == min ? 0 : -1));
        int i8 = i7 == 0 ? 4 : 0;
        if (z5) {
            i8 |= 1;
        }
        frameHeader(i6, (int) min, 1, i8);
        this.sink.write(this.hpackBuffer, min);
        if (i7 > 0) {
            writeContinuationFrames(i6, size - min);
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z5, int i6, int i7) {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, 6, z5 ? 1 : 0);
        this.sink.writeInt(i6);
        this.sink.writeInt(i7);
        this.sink.flush();
    }

    public final synchronized void pushPromise(int i6, int i7, List<Header> list) {
        l.d(list, "requestHeaders");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long size = this.hpackBuffer.size();
        int min = (int) Math.min(this.maxFrameSize - 4, size);
        int i8 = min + 4;
        long j6 = min;
        int i9 = (size > j6 ? 1 : (size == j6 ? 0 : -1));
        frameHeader(i6, i8, 5, i9 == 0 ? 4 : 0);
        this.sink.writeInt(i7 & Integer.MAX_VALUE);
        this.sink.write(this.hpackBuffer, j6);
        if (i9 > 0) {
            writeContinuationFrames(i6, size - j6);
        }
    }

    public final synchronized void rstStream(int i6, ErrorCode errorCode) {
        l.d(errorCode, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(errorCode.getHttpCode() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        frameHeader(i6, 4, 3, 0);
        this.sink.writeInt(errorCode.getHttpCode());
        this.sink.flush();
    }

    public final synchronized void settings(Settings settings) {
        l.d(settings, "settings");
        if (this.closed) {
            throw new IOException("closed");
        }
        int i6 = 0;
        frameHeader(0, settings.size() * 6, 4, 0);
        while (i6 < 10) {
            int i7 = i6 + 1;
            if (settings.isSet(i6)) {
                this.sink.writeShort(i6 != 4 ? i6 != 7 ? i6 : 4 : 3);
                this.sink.writeInt(settings.get(i6));
            }
            i6 = i7;
        }
        this.sink.flush();
    }

    public final synchronized void windowUpdate(int i6, long j6) {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(j6 != 0 && j6 <= 2147483647L)) {
            throw new IllegalArgumentException(l.i("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ", Long.valueOf(j6)).toString());
        }
        frameHeader(i6, 4, 8, 0);
        this.sink.writeInt((int) j6);
        this.sink.flush();
    }
}
