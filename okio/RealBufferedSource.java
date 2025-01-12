package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField;
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source source) {
        kotlin.jvm.internal.l.d(source, "source");
        this.source = source;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (!this.closed) {
            return this.bufferField.exhausted() && this.source.read(this.bufferField, 8192L) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b6) {
        return indexOf(b6, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "targetBytes");
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.RealBufferedSource$inputStream$1
            @Override // java.io.InputStream
            public int available() {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                return (int) Math.min(realBufferedSource.bufferField.size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                RealBufferedSource.this.close();
            }

            @Override // java.io.InputStream
            public int read() {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                if (realBufferedSource.bufferField.size() == 0) {
                    RealBufferedSource realBufferedSource2 = RealBufferedSource.this;
                    if (realBufferedSource2.source.read(realBufferedSource2.bufferField, 8192L) == -1) {
                        return -1;
                    }
                }
                return RealBufferedSource.this.bufferField.readByte() & 255;
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i6, int i7) {
                kotlin.jvm.internal.l.d(bArr, "data");
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                _UtilKt.checkOffsetAndCount(bArr.length, i6, i7);
                if (RealBufferedSource.this.bufferField.size() == 0) {
                    RealBufferedSource realBufferedSource = RealBufferedSource.this;
                    if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                        return -1;
                    }
                }
                return RealBufferedSource.this.bufferField.read(bArr, i6, i7);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j6, ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "bytes");
        return rangeEquals(j6, byteString, 0, byteString.size());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        kotlin.jvm.internal.l.d(byteBuffer, "sink");
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
            return -1;
        }
        return this.bufferField.read(byteBuffer);
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) {
        Buffer buffer;
        kotlin.jvm.internal.l.d(sink, "sink");
        long j6 = 0;
        while (true) {
            int i6 = (this.source.read(this.bufferField, 8192L) > (-1L) ? 1 : (this.source.read(this.bufferField, 8192L) == (-1L) ? 0 : -1));
            buffer = this.bufferField;
            if (i6 == 0) {
                break;
            }
            long completeSegmentByteCount = buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j6 += completeSegmentByteCount;
                sink.write(this.bufferField, completeSegmentByteCount);
            }
        }
        if (buffer.size() > 0) {
            long size = j6 + this.bufferField.size();
            Buffer buffer2 = this.bufferField;
            sink.write(buffer2, buffer2.size());
            return size;
        }
        return j6;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (r9 == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append("Expected a digit or '-' but was 0x");
        r2 = kotlin.text.b.a(16);
        r2 = kotlin.text.b.a(r2);
        r2 = java.lang.Integer.toString(r8, r2);
        kotlin.jvm.internal.l.c(r2, "toString(this, checkRadix(radix))");
        r1.append(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        throw new java.lang.NumberFormatException(r1.toString());
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readDecimalLong() {
        require(1L);
        long j6 = 0;
        while (true) {
            long j7 = j6 + 1;
            if (!request(j7)) {
                break;
            }
            byte b6 = this.bufferField.getByte(j6);
            if ((b6 < ((byte) 48) || b6 > ((byte) 57)) && !(j6 == 0 && b6 == ((byte) 45))) {
                break;
            }
            j6 = j7;
        }
        return this.bufferField.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "sink");
        try {
            require(j6);
            this.bufferField.readFully(buffer, j6);
        } catch (EOFException e6) {
            buffer.writeAll(this.bufferField);
            throw e6;
        }
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        byte b6;
        int a6;
        int a7;
        require(1L);
        int i6 = 0;
        while (true) {
            int i7 = i6 + 1;
            if (!request(i7)) {
                break;
            }
            b6 = this.bufferField.getByte(i6);
            if ((b6 < ((byte) 48) || b6 > ((byte) 57)) && ((b6 < ((byte) 97) || b6 > ((byte) androidx.constraintlayout.widget.g.U0)) && (b6 < ((byte) 65) || b6 > ((byte) 70)))) {
                break;
            }
            i6 = i7;
        }
        if (i6 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            a6 = kotlin.text.b.a(16);
            a7 = kotlin.text.b.a(a6);
            String num = Integer.toString(b6, a7);
            kotlin.jvm.internal.l.c(num, "toString(this, checkRadix(radix))");
            sb.append(num);
            throw new NumberFormatException(sb.toString());
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public int readInt() {
        require(4L);
        return this.bufferField.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        require(4L);
        return this.bufferField.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() {
        require(8L);
        return this.bufferField.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        require(8L);
        return this.bufferField.readLongLe();
    }

    @Override // okio.BufferedSource
    public short readShort() {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        require(2L);
        return this.bufferField.readShortLe();
    }

    @Override // okio.BufferedSource
    public String readString(long j6, Charset charset) {
        kotlin.jvm.internal.l.d(charset, "charset");
        require(j6);
        return this.bufferField.readString(j6, charset);
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() {
        long j6;
        require(1L);
        byte b6 = this.bufferField.getByte(0L);
        if ((b6 & 224) == 192) {
            j6 = 2;
        } else if ((b6 & 240) != 224) {
            if ((b6 & 248) == 240) {
                j6 = 4;
            }
            return this.bufferField.readUtf8CodePoint();
        } else {
            j6 = 3;
        }
        require(j6);
        return this.bufferField.readUtf8CodePoint();
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf == -1) {
            if (this.bufferField.size() != 0) {
                return readUtf8(this.bufferField.size());
            }
            return null;
        }
        return _BufferKt.readUtf8Line(this.bufferField, indexOf);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long j6) {
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        } else if (!this.closed) {
            while (this.bufferField.size() < j6) {
                if (this.source.read(this.bufferField, 8192L) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    @Override // okio.BufferedSource
    public void require(long j6) {
        if (!request(j6)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) {
        kotlin.jvm.internal.l.d(options, "options");
        if (!this.closed) {
            while (true) {
                int selectPrefix = _BufferKt.selectPrefix(this.bufferField, options, true);
                if (selectPrefix == -2) {
                    if (this.source.read(this.bufferField, 8192L) == -1) {
                        break;
                    }
                } else if (selectPrefix != -1) {
                    this.bufferField.skip(options.getByteStrings$okio()[selectPrefix].size());
                    return selectPrefix;
                }
            }
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public void skip(long j6) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j6 > 0) {
            if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j6, this.bufferField.size());
            this.bufferField.skip(min);
            j6 -= min;
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b6, long j6) {
        return indexOf(b6, j6, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j6) {
        kotlin.jvm.internal.l.d(byteString, "targetBytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOfElement = this.bufferField.indexOfElement(byteString, j6);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            j6 = Math.max(j6, size);
        }
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j6, ByteString byteString, int i6, int i7) {
        int i8;
        kotlin.jvm.internal.l.d(byteString, "bytes");
        if (!this.closed) {
            if (j6 >= 0 && i6 >= 0 && i7 >= 0 && byteString.size() - i6 >= i7) {
                while (i8 < i7) {
                    long j7 = i8 + j6;
                    i8 = (request(1 + j7) && this.bufferField.getByte(j7) == byteString.getByte(i6 + i8)) ? i8 + 1 : 0;
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        kotlin.jvm.internal.l.d(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j6) {
        require(j6);
        return this.bufferField.readByteArray(j6);
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j6) {
        require(j6);
        return this.bufferField.readByteString(j6);
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) {
        kotlin.jvm.internal.l.d(bArr, "sink");
        try {
            require(bArr.length);
            this.bufferField.readFully(bArr);
        } catch (EOFException e6) {
            int i6 = 0;
            while (this.bufferField.size() > 0) {
                Buffer buffer = this.bufferField;
                int read = buffer.read(bArr, i6, (int) buffer.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                i6 += read;
            }
            throw e6;
        }
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        kotlin.jvm.internal.l.d(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j6) {
        require(j6);
        return this.bufferField.readUtf8(j6);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j6) {
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j6).toString());
        }
        long j7 = j6 == Long.MAX_VALUE ? Long.MAX_VALUE : j6 + 1;
        byte b6 = (byte) 10;
        long indexOf = indexOf(b6, 0L, j7);
        if (indexOf != -1) {
            return _BufferKt.readUtf8Line(this.bufferField, indexOf);
        }
        if (j7 < Long.MAX_VALUE && request(j7) && this.bufferField.getByte(j7 - 1) == ((byte) 13) && request(1 + j7) && this.bufferField.getByte(j7) == b6) {
            return _BufferKt.readUtf8Line(this.bufferField, j7);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), j6) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b6, long j6, long j7) {
        boolean z5 = true;
        if (!this.closed) {
            if (!((0 > j6 || j6 > j7) ? false : false)) {
                throw new IllegalArgumentException(("fromIndex=" + j6 + " toIndex=" + j7).toString());
            }
            while (j6 < j7) {
                long indexOf = this.bufferField.indexOf(b6, j6, j7);
                if (indexOf != -1) {
                    return indexOf;
                }
                long size = this.bufferField.size();
                if (size >= j7 || this.source.read(this.bufferField, 8192L) == -1) {
                    return -1L;
                }
                j6 = Math.max(j6, size);
            }
            return -1L;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.l.d(bArr, "sink");
        long j6 = i7;
        _UtilKt.checkOffsetAndCount(bArr.length, i6, j6);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
            return -1;
        }
        return this.bufferField.read(bArr, i6, (int) Math.min(j6, this.bufferField.size()));
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "bytes");
        return indexOf(byteString, 0L);
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "sink");
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        } else if (true ^ this.closed) {
            if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            return this.bufferField.read(buffer, Math.min(j6, this.bufferField.size()));
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j6) {
        kotlin.jvm.internal.l.d(byteString, "bytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOf = this.bufferField.indexOf(byteString, j6);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            j6 = Math.max(j6, (size - byteString.size()) + 1);
        }
    }
}
