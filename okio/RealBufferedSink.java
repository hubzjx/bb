package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField;
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        kotlin.jvm.internal.l.d(sink, "sink");
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @Override // okio.BufferedSink
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        try {
            if (this.bufferField.size() > 0) {
                Sink sink = this.sink;
                Buffer buffer = this.bufferField;
                sink.write(buffer, buffer.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        if (!this.closed) {
            long size = this.bufferField.size();
            if (size > 0) {
                this.sink.write(this.bufferField, size);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink emitCompleteSegments() {
        if (!this.closed) {
            long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.sink.write(this.bufferField, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.size() > 0) {
            Sink sink = this.sink;
            Buffer buffer = this.bufferField;
            sink.write(buffer, buffer.size());
        }
        this.sink.flush();
    }

    @Override // okio.BufferedSink
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.RealBufferedSink$outputStream$1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                RealBufferedSink.this.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    return;
                }
                realBufferedSink.flush();
            }

            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i6) {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    throw new IOException("closed");
                }
                realBufferedSink.bufferField.writeByte((int) ((byte) i6));
                RealBufferedSink.this.emitCompleteSegments();
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i6, int i7) {
                kotlin.jvm.internal.l.d(bArr, "data");
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    throw new IOException("closed");
                }
                realBufferedSink.bufferField.write(bArr, i6, i7);
                RealBufferedSink.this.emitCompleteSegments();
            }
        };
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        kotlin.jvm.internal.l.d(byteBuffer, "source");
        if (!this.closed) {
            int write = this.bufferField.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) {
        kotlin.jvm.internal.l.d(source, "source");
        long j6 = 0;
        while (true) {
            long read = source.read(this.bufferField, 8192L);
            if (read == -1) {
                return j6;
            }
            j6 += read;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int i6) {
        if (!this.closed) {
            this.bufferField.writeByte(i6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeDecimalLong(long j6) {
        if (!this.closed) {
            this.bufferField.writeDecimalLong(j6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long j6) {
        if (!this.closed) {
            this.bufferField.writeHexadecimalUnsignedLong(j6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int i6) {
        if (!this.closed) {
            this.bufferField.writeInt(i6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeIntLe(int i6) {
        if (!this.closed) {
            this.bufferField.writeIntLe(i6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLong(long j6) {
        if (!this.closed) {
            this.bufferField.writeLong(j6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLongLe(long j6) {
        if (!this.closed) {
            this.bufferField.writeLongLe(j6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int i6) {
        if (!this.closed) {
            this.bufferField.writeShort(i6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShortLe(int i6) {
        if (!this.closed) {
            this.bufferField.writeShortLe(i6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String str, int i6, int i7, Charset charset) {
        kotlin.jvm.internal.l.d(str, "string");
        kotlin.jvm.internal.l.d(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(str, i6, i7, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String str) {
        kotlin.jvm.internal.l.d(str, "string");
        if (!this.closed) {
            this.bufferField.writeUtf8(str);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int i6) {
        if (!this.closed) {
            this.bufferField.writeUtf8CodePoint(i6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String str, Charset charset) {
        kotlin.jvm.internal.l.d(str, "string");
        kotlin.jvm.internal.l.d(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(str, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String str, int i6, int i7) {
        kotlin.jvm.internal.l.d(str, "string");
        if (!this.closed) {
            this.bufferField.writeUtf8(str, i6, i7);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(ByteString byteString, int i6, int i7) {
        kotlin.jvm.internal.l.d(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString, i6, i7);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long j6) {
        kotlin.jvm.internal.l.d(source, "source");
        while (j6 > 0) {
            long read = source.read(this.bufferField, j6);
            if (read == -1) {
                throw new EOFException();
            }
            j6 -= read;
            emitCompleteSegments();
        }
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr) {
        kotlin.jvm.internal.l.d(bArr, "source");
        if (!this.closed) {
            this.bufferField.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.l.d(bArr, "source");
        if (!this.closed) {
            this.bufferField.write(bArr, i6, i7);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(buffer, j6);
        emitCompleteSegments();
    }
}
