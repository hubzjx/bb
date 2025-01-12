package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import okio.internal._BufferKt;
import r4.a;
import r4.c;
import r4.f;
/* loaded from: classes.dex */
public final class Http2Reader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final BufferedSource source;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int i6, int i7, int i8) {
            if ((i7 & 8) != 0) {
                i6--;
            }
            if (i8 <= i6) {
                return i6 - i8;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i8 + " > remaining length " + i6);
        }
    }

    /* loaded from: classes.dex */
    public static final class ContinuationSource implements Source {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final BufferedSource source;
        private int streamId;

        public ContinuationSource(BufferedSource bufferedSource) {
            l.d(bufferedSource, "source");
            this.source = bufferedSource;
        }

        private final void readContinuationHeader() {
            int i6 = this.streamId;
            int readMedium = Util.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            int and = Util.and(this.source.readByte(), 255);
            this.flags = Util.and(this.source.readByte(), 255);
            Companion companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, and, this.flags));
            }
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = readInt;
            if (and == 9) {
                if (readInt != i6) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
                return;
            }
            throw new IOException(and + " != TYPE_CONTINUATION");
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j6) {
            l.d(buffer, "sink");
            while (true) {
                int i6 = this.left;
                if (i6 != 0) {
                    long read = this.source.read(buffer, Math.min(j6, i6));
                    if (read == -1) {
                        return -1L;
                    }
                    this.left -= (int) read;
                    return read;
                }
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        public final void setFlags(int i6) {
            this.flags = i6;
        }

        public final void setLeft(int i6) {
            this.left = i6;
        }

        public final void setLength(int i6) {
            this.length = i6;
        }

        public final void setPadding(int i6) {
            this.padding = i6;
        }

        public final void setStreamId(int i6) {
            this.streamId = i6;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    /* loaded from: classes.dex */
    public interface Handler {
        void ackSettings();

        void alternateService(int i6, String str, ByteString byteString, String str2, int i7, long j6);

        void data(boolean z5, int i6, BufferedSource bufferedSource, int i7);

        void goAway(int i6, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z5, int i6, int i7, List<Header> list);

        void ping(boolean z5, int i6, int i7);

        void priority(int i6, int i7, int i8, boolean z5);

        void pushPromise(int i6, int i7, List<Header> list);

        void rstStream(int i6, ErrorCode errorCode);

        void settings(boolean z5, Settings settings);

        void windowUpdate(int i6, long j6);
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        l.c(logger2, "getLogger(Http2::class.java.name)");
        logger = logger2;
    }

    public Http2Reader(BufferedSource bufferedSource, boolean z5) {
        l.d(bufferedSource, "source");
        this.source = bufferedSource;
        this.client = z5;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, _BufferKt.SEGMENTING_THRESHOLD, 0, 4, null);
    }

    private final void readData(Handler handler, int i6, int i7, int i8) {
        if (i8 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z5 = (i7 & 1) != 0;
        if ((i7 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int and = (i7 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        handler.data(z5, i8, this.source, Companion.lengthWithoutPadding(i6, i7, and));
        this.source.skip(and);
    }

    private final void readGoAway(Handler handler, int i6, int i7, int i8) {
        if (i6 < 8) {
            throw new IOException(l.i("TYPE_GOAWAY length < 8: ", Integer.valueOf(i6)));
        }
        if (i8 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int readInt = this.source.readInt();
        int readInt2 = this.source.readInt();
        int i9 = i6 - 8;
        ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt2);
        if (fromHttp2 == null) {
            throw new IOException(l.i("TYPE_GOAWAY unexpected error code: ", Integer.valueOf(readInt2)));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i9 > 0) {
            byteString = this.source.readByteString(i9);
        }
        handler.goAway(readInt, fromHttp2, byteString);
    }

    private final List<Header> readHeaderBlock(int i6, int i7, int i8, int i9) {
        this.continuation.setLeft(i6);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i7);
        this.continuation.setFlags(i8);
        this.continuation.setStreamId(i9);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int i6, int i7, int i8) {
        if (i8 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z5 = (i7 & 1) != 0;
        int and = (i7 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        if ((i7 & 32) != 0) {
            readPriority(handler, i8);
            i6 -= 5;
        }
        handler.headers(z5, i8, -1, readHeaderBlock(Companion.lengthWithoutPadding(i6, i7, and), and, i7, i8));
    }

    private final void readPing(Handler handler, int i6, int i7, int i8) {
        if (i6 != 8) {
            throw new IOException(l.i("TYPE_PING length != 8: ", Integer.valueOf(i6)));
        }
        if (i8 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.ping((i7 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private final void readPriority(Handler handler, int i6) {
        int readInt = this.source.readInt();
        handler.priority(i6, readInt & Integer.MAX_VALUE, Util.and(this.source.readByte(), 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private final void readPushPromise(Handler handler, int i6, int i7, int i8) {
        if (i8 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int and = (i7 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        handler.pushPromise(i8, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(i6 - 4, i7, and), and, i7, i8));
    }

    private final void readRstStream(Handler handler, int i6, int i7, int i8) {
        if (i6 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i6 + " != 4");
        } else if (i8 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        } else {
            int readInt = this.source.readInt();
            ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt);
            if (fromHttp2 == null) {
                throw new IOException(l.i("TYPE_RST_STREAM unexpected error code: ", Integer.valueOf(readInt)));
            }
            handler.rstStream(i8, fromHttp2);
        }
    }

    private final void readSettings(Handler handler, int i6, int i7, int i8) {
        c g6;
        a f6;
        int readInt;
        if (i8 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i7 & 1) != 0) {
            if (i6 != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            handler.ackSettings();
        } else if (i6 % 6 != 0) {
            throw new IOException(l.i("TYPE_SETTINGS length % 6 != 0: ", Integer.valueOf(i6)));
        } else {
            Settings settings = new Settings();
            g6 = f.g(0, i6);
            f6 = f.f(g6, 6);
            int a6 = f6.a();
            int b6 = f6.b();
            int c6 = f6.c();
            if ((c6 > 0 && a6 <= b6) || (c6 < 0 && b6 <= a6)) {
                while (true) {
                    int i9 = a6 + c6;
                    int and = Util.and(this.source.readShort(), (int) Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                    readInt = this.source.readInt();
                    if (and != 2) {
                        if (and == 3) {
                            and = 4;
                        } else if (and != 4) {
                            if (and == 5 && (readInt < 16384 || readInt > 16777215)) {
                                break;
                            }
                        } else if (readInt < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        } else {
                            and = 7;
                        }
                    } else if (readInt != 0 && readInt != 1) {
                        throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                    }
                    settings.set(and, readInt);
                    if (a6 == b6) {
                        break;
                    }
                    a6 = i9;
                }
                throw new IOException(l.i("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", Integer.valueOf(readInt)));
            }
            handler.settings(false, settings);
        }
    }

    private final void readWindowUpdate(Handler handler, int i6, int i7, int i8) {
        if (i6 != 4) {
            throw new IOException(l.i("TYPE_WINDOW_UPDATE length !=4: ", Integer.valueOf(i6)));
        }
        long and = Util.and(this.source.readInt(), 2147483647L);
        if (and == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        handler.windowUpdate(i8, and);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.source.close();
    }

    public final boolean nextFrame(boolean z5, Handler handler) {
        l.d(handler, "handler");
        try {
            this.source.require(9L);
            int readMedium = Util.readMedium(this.source);
            if (readMedium <= 16384) {
                int and = Util.and(this.source.readByte(), 255);
                int and2 = Util.and(this.source.readByte(), 255);
                int readInt = this.source.readInt() & Integer.MAX_VALUE;
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Http2.INSTANCE.frameLog(true, readInt, readMedium, and, and2));
                }
                if (!z5 || and == 4) {
                    switch (and) {
                        case 0:
                            readData(handler, readMedium, and2, readInt);
                            return true;
                        case 1:
                            readHeaders(handler, readMedium, and2, readInt);
                            return true;
                        case 2:
                            readPriority(handler, readMedium, and2, readInt);
                            return true;
                        case 3:
                            readRstStream(handler, readMedium, and2, readInt);
                            return true;
                        case 4:
                            readSettings(handler, readMedium, and2, readInt);
                            return true;
                        case 5:
                            readPushPromise(handler, readMedium, and2, readInt);
                            return true;
                        case 6:
                            readPing(handler, readMedium, and2, readInt);
                            return true;
                        case 7:
                            readGoAway(handler, readMedium, and2, readInt);
                            return true;
                        case 8:
                            readWindowUpdate(handler, readMedium, and2, readInt);
                            return true;
                        default:
                            this.source.skip(readMedium);
                            return true;
                    }
                }
                throw new IOException(l.i("Expected a SETTINGS frame but was ", Http2.INSTANCE.formattedType$okhttp(and)));
            }
            throw new IOException(l.i("FRAME_SIZE_ERROR: ", Integer.valueOf(readMedium)));
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(Handler handler) {
        l.d(handler, "handler");
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        BufferedSource bufferedSource = this.source;
        ByteString byteString = Http2.CONNECTION_PREFACE;
        ByteString readByteString = bufferedSource.readByteString(byteString.size());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Util.format(l.i("<< CONNECTION ", readByteString.hex()), new Object[0]));
        }
        if (!l.a(byteString, readByteString)) {
            throw new IOException(l.i("Expected a connection header but was ", readByteString.utf8()));
        }
    }

    private final void readPriority(Handler handler, int i6, int i7, int i8) {
        if (i6 == 5) {
            if (i8 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            readPriority(handler, i8);
            return;
        }
        throw new IOException("TYPE_PRIORITY length: " + i6 + " != 5");
    }
}
