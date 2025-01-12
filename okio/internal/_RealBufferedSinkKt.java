package okio.internal;

import java.io.EOFException;
import kotlin.jvm.internal.l;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Source;
import okio.Timeout;
/* loaded from: classes.dex */
public final class _RealBufferedSinkKt {
    public static final void commonClose(RealBufferedSink realBufferedSink) {
        l.d(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            return;
        }
        try {
            if (realBufferedSink.bufferField.size() > 0) {
                Sink sink = realBufferedSink.sink;
                Buffer buffer = realBufferedSink.bufferField;
                sink.write(buffer, buffer.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            realBufferedSink.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        realBufferedSink.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public static final BufferedSink commonEmit(RealBufferedSink realBufferedSink) {
        l.d(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            long size = realBufferedSink.bufferField.size();
            if (size > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, size);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonEmitCompleteSegments(RealBufferedSink realBufferedSink) {
        l.d(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            long completeSegmentByteCount = realBufferedSink.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, completeSegmentByteCount);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonFlush(RealBufferedSink realBufferedSink) {
        l.d(realBufferedSink, "<this>");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (realBufferedSink.bufferField.size() > 0) {
            Sink sink = realBufferedSink.sink;
            Buffer buffer = realBufferedSink.bufferField;
            sink.write(buffer, buffer.size());
        }
        realBufferedSink.sink.flush();
    }

    public static final Timeout commonTimeout(RealBufferedSink realBufferedSink) {
        l.d(realBufferedSink, "<this>");
        return realBufferedSink.sink.timeout();
    }

    public static final String commonToString(RealBufferedSink realBufferedSink) {
        l.d(realBufferedSink, "<this>");
        return "buffer(" + realBufferedSink.sink + ')';
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, ByteString byteString) {
        l.d(realBufferedSink, "<this>");
        l.d(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonWriteAll(RealBufferedSink realBufferedSink, Source source) {
        l.d(realBufferedSink, "<this>");
        l.d(source, "source");
        long j6 = 0;
        while (true) {
            long read = source.read(realBufferedSink.bufferField, 8192L);
            if (read == -1) {
                return j6;
            }
            j6 += read;
            realBufferedSink.emitCompleteSegments();
        }
    }

    public static final BufferedSink commonWriteByte(RealBufferedSink realBufferedSink, int i6) {
        l.d(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeByte(i6);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteDecimalLong(RealBufferedSink realBufferedSink, long j6) {
        l.d(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeDecimalLong(j6);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(RealBufferedSink realBufferedSink, long j6) {
        l.d(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeHexadecimalUnsignedLong(j6);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteInt(RealBufferedSink realBufferedSink, int i6) {
        l.d(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeInt(i6);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteIntLe(RealBufferedSink realBufferedSink, int i6) {
        l.d(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeIntLe(i6);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteLong(RealBufferedSink realBufferedSink, long j6) {
        l.d(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeLong(j6);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteLongLe(RealBufferedSink realBufferedSink, long j6) {
        l.d(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeLongLe(j6);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteShort(RealBufferedSink realBufferedSink, int i6) {
        l.d(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeShort(i6);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteShortLe(RealBufferedSink realBufferedSink, int i6) {
        l.d(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeShortLe(i6);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink realBufferedSink, String str) {
        l.d(realBufferedSink, "<this>");
        l.d(str, "string");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(str);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8CodePoint(RealBufferedSink realBufferedSink, int i6) {
        l.d(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8CodePoint(i6);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, ByteString byteString, int i6, int i7) {
        l.d(realBufferedSink, "<this>");
        l.d(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString, i6, i7);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink realBufferedSink, String str, int i6, int i7) {
        l.d(realBufferedSink, "<this>");
        l.d(str, "string");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(str, i6, i7);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, Source source, long j6) {
        l.d(realBufferedSink, "<this>");
        l.d(source, "source");
        while (j6 > 0) {
            long read = source.read(realBufferedSink.bufferField, j6);
            if (read == -1) {
                throw new EOFException();
            }
            j6 -= read;
            realBufferedSink.emitCompleteSegments();
        }
        return realBufferedSink;
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, byte[] bArr) {
        l.d(realBufferedSink, "<this>");
        l.d(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, byte[] bArr, int i6, int i7) {
        l.d(realBufferedSink, "<this>");
        l.d(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr, i6, i7);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonWrite(RealBufferedSink realBufferedSink, Buffer buffer, long j6) {
        l.d(realBufferedSink, "<this>");
        l.d(buffer, "source");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.write(buffer, j6);
        realBufferedSink.emitCompleteSegments();
    }
}
