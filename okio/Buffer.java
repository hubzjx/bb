package okio;

import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.HttpUrl;
import okhttp3.dnsoverhttps.DnsOverHttps;
import okhttp3.internal.connection.RealConnection;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    private long size;

    /* loaded from: classes.dex */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.buffer != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.buffer = null;
            setSegment$okio(null);
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i6) {
            if (!(i6 > 0)) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + i6).toString());
            }
            if (!(i6 <= 8192)) {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i6).toString());
            }
            Buffer buffer = this.buffer;
            if (buffer != null) {
                if (this.readWrite) {
                    long size = buffer.size();
                    Segment writableSegment$okio = buffer.writableSegment$okio(i6);
                    int i7 = 8192 - writableSegment$okio.limit;
                    writableSegment$okio.limit = Segment.SIZE;
                    long j6 = i7;
                    buffer.setSize$okio(size + j6);
                    setSegment$okio(writableSegment$okio);
                    this.offset = size;
                    this.data = writableSegment$okio.data;
                    this.start = 8192 - i7;
                    this.end = Segment.SIZE;
                    return j6;
                }
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final int next() {
            long j6 = this.offset;
            Buffer buffer = this.buffer;
            kotlin.jvm.internal.l.b(buffer);
            if (j6 != buffer.size()) {
                long j7 = this.offset;
                return seek(j7 == -1 ? 0L : j7 + (this.end - this.start));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final long resizeBuffer(long j6) {
            Buffer buffer = this.buffer;
            if (buffer != null) {
                if (this.readWrite) {
                    long size = buffer.size();
                    int i6 = 1;
                    int i7 = (j6 > size ? 1 : (j6 == size ? 0 : -1));
                    if (i7 <= 0) {
                        if (!(j6 >= 0)) {
                            throw new IllegalArgumentException(("newSize < 0: " + j6).toString());
                        }
                        long j7 = size - j6;
                        while (true) {
                            if (j7 <= 0) {
                                break;
                            }
                            Segment segment = buffer.head;
                            kotlin.jvm.internal.l.b(segment);
                            Segment segment2 = segment.prev;
                            kotlin.jvm.internal.l.b(segment2);
                            int i8 = segment2.limit;
                            long j8 = i8 - segment2.pos;
                            if (j8 > j7) {
                                segment2.limit = i8 - ((int) j7);
                                break;
                            }
                            buffer.head = segment2.pop();
                            SegmentPool.recycle(segment2);
                            j7 -= j8;
                        }
                        setSegment$okio(null);
                        this.offset = j6;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else if (i7 > 0) {
                        long j9 = j6 - size;
                        boolean z5 = true;
                        while (j9 > 0) {
                            Segment writableSegment$okio = buffer.writableSegment$okio(i6);
                            int min = (int) Math.min(j9, 8192 - writableSegment$okio.limit);
                            writableSegment$okio.limit += min;
                            j9 -= min;
                            if (z5) {
                                setSegment$okio(writableSegment$okio);
                                this.offset = size;
                                this.data = writableSegment$okio.data;
                                int i9 = writableSegment$okio.limit;
                                this.start = i9 - min;
                                this.end = i9;
                                i6 = 1;
                                z5 = false;
                            } else {
                                i6 = 1;
                            }
                        }
                    }
                    buffer.setSize$okio(j6);
                    return size;
                }
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final int seek(long j6) {
            Segment segment;
            Buffer buffer = this.buffer;
            if (buffer != null) {
                int i6 = (j6 > (-1L) ? 1 : (j6 == (-1L) ? 0 : -1));
                if (i6 < 0 || j6 > buffer.size()) {
                    throw new ArrayIndexOutOfBoundsException("offset=" + j6 + " > size=" + buffer.size());
                } else if (i6 == 0 || j6 == buffer.size()) {
                    setSegment$okio(null);
                    this.offset = j6;
                    this.data = null;
                    this.start = -1;
                    this.end = -1;
                    return -1;
                } else {
                    long size = buffer.size();
                    Segment segment2 = buffer.head;
                    long j7 = 0;
                    if (getSegment$okio() != null) {
                        long j8 = this.offset;
                        int i7 = this.start;
                        Segment segment$okio = getSegment$okio();
                        kotlin.jvm.internal.l.b(segment$okio);
                        long j9 = j8 - (i7 - segment$okio.pos);
                        if (j9 > j6) {
                            segment = segment2;
                            segment2 = getSegment$okio();
                            size = j9;
                        } else {
                            segment = getSegment$okio();
                            j7 = j9;
                        }
                    } else {
                        segment = segment2;
                    }
                    if (size - j6 > j6 - j7) {
                        while (true) {
                            kotlin.jvm.internal.l.b(segment);
                            int i8 = segment.limit;
                            int i9 = segment.pos;
                            if (j6 < (i8 - i9) + j7) {
                                break;
                            }
                            j7 += i8 - i9;
                            segment = segment.next;
                        }
                    } else {
                        while (size > j6) {
                            kotlin.jvm.internal.l.b(segment2);
                            segment2 = segment2.prev;
                            kotlin.jvm.internal.l.b(segment2);
                            size -= segment2.limit - segment2.pos;
                        }
                        j7 = size;
                        segment = segment2;
                    }
                    if (this.readWrite) {
                        kotlin.jvm.internal.l.b(segment);
                        if (segment.shared) {
                            Segment unsharedCopy = segment.unsharedCopy();
                            if (buffer.head == segment) {
                                buffer.head = unsharedCopy;
                            }
                            segment = segment.push(unsharedCopy);
                            Segment segment3 = segment.prev;
                            kotlin.jvm.internal.l.b(segment3);
                            segment3.pop();
                        }
                    }
                    setSegment$okio(segment);
                    this.offset = j6;
                    kotlin.jvm.internal.l.b(segment);
                    this.data = segment.data;
                    int i10 = segment.pos + ((int) (j6 - j7));
                    this.start = i10;
                    int i11 = segment.limit;
                    this.end = i11;
                    return i11 - i10;
                }
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final void setSegment$okio(Segment segment) {
            this.segment = segment;
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j6, long j7, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = 0;
        }
        long j8 = j6;
        if ((i6 & 4) != 0) {
            j7 = buffer.size - j8;
        }
        return buffer.copyTo(outputStream, j8, j7);
    }

    private final ByteString digest(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i6 = segment.pos;
            messageDigest.update(bArr, i6, segment.limit - i6);
            Segment segment2 = segment.next;
            while (true) {
                kotlin.jvm.internal.l.b(segment2);
                if (segment2 == segment) {
                    break;
                }
                byte[] bArr2 = segment2.data;
                int i7 = segment2.pos;
                messageDigest.update(bArr2, i7, segment2.limit - i7);
                segment2 = segment2.next;
            }
        }
        byte[] digest = messageDigest.digest();
        kotlin.jvm.internal.l.c(digest, "messageDigest.digest()");
        return new ByteString(digest);
    }

    private final ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i6 = segment.pos;
                mac.update(bArr, i6, segment.limit - i6);
                Segment segment2 = segment.next;
                while (true) {
                    kotlin.jvm.internal.l.b(segment2);
                    if (segment2 == segment) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i7 = segment2.pos;
                    mac.update(bArr2, i7, segment2.limit - i7);
                    segment2 = segment2.next;
                }
            }
            byte[] doFinal = mac.doFinal();
            kotlin.jvm.internal.l.c(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            unsafeCursor = _UtilKt.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            unsafeCursor = _UtilKt.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j6, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = buffer.size;
        }
        return buffer.writeTo(outputStream, j6);
    }

    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m161deprecated_getByte(long j6) {
        return getByte(j6);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final long m162deprecated_size() {
        return this.size;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        skip(size());
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.head;
        kotlin.jvm.internal.l.b(segment);
        Segment segment2 = segment.prev;
        kotlin.jvm.internal.l.b(segment2);
        int i6 = segment2.limit;
        if (i6 < 8192 && segment2.owner) {
            size -= i6 - segment2.pos;
        }
        return size;
    }

    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.head;
            kotlin.jvm.internal.l.b(segment);
            Segment sharedCopy = segment.sharedCopy();
            buffer.head = sharedCopy;
            sharedCopy.prev = sharedCopy;
            sharedCopy.next = sharedCopy;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = sharedCopy.prev;
                kotlin.jvm.internal.l.b(segment3);
                kotlin.jvm.internal.l.b(segment2);
                segment3.push(segment2.sharedCopy());
            }
            buffer.setSize$okio(size());
        }
        return buffer;
    }

    public final Buffer copyTo(OutputStream outputStream) {
        kotlin.jvm.internal.l.d(outputStream, "out");
        return copyTo$default(this, outputStream, 0L, 0L, 6, (Object) null);
    }

    @Override // okio.BufferedSink
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            if (size() == buffer.size()) {
                if (size() == 0) {
                    return true;
                }
                Segment segment = this.head;
                kotlin.jvm.internal.l.b(segment);
                Segment segment2 = buffer.head;
                kotlin.jvm.internal.l.b(segment2);
                int i6 = segment.pos;
                int i7 = segment2.pos;
                long j6 = 0;
                while (j6 < size()) {
                    long min = Math.min(segment.limit - i6, segment2.limit - i7);
                    long j7 = 0;
                    while (j7 < min) {
                        int i8 = i6 + 1;
                        int i9 = i7 + 1;
                        if (segment.data[i6] == segment2.data[i7]) {
                            j7++;
                            i6 = i8;
                            i7 = i9;
                        }
                    }
                    if (i6 == segment.limit) {
                        segment = segment.next;
                        kotlin.jvm.internal.l.b(segment);
                        i6 = segment.pos;
                    }
                    if (i7 == segment2.limit) {
                        segment2 = segment2.next;
                        kotlin.jvm.internal.l.b(segment2);
                        i7 = segment2.pos;
                    }
                    j6 += min;
                }
                return true;
            }
        }
        return false;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j6) {
        _UtilKt.checkOffsetAndCount(size(), j6, 1L);
        Segment segment = this.head;
        if (segment == null) {
            kotlin.jvm.internal.l.b(null);
            throw null;
        } else if (size() - j6 < j6) {
            long size = size();
            while (size > j6) {
                segment = segment.prev;
                kotlin.jvm.internal.l.b(segment);
                size -= segment.limit - segment.pos;
            }
            kotlin.jvm.internal.l.b(segment);
            return segment.data[(int) ((segment.pos + j6) - size)];
        } else {
            long j7 = 0;
            while (true) {
                long j8 = (segment.limit - segment.pos) + j7;
                if (j8 > j6) {
                    kotlin.jvm.internal.l.b(segment);
                    return segment.data[(int) ((segment.pos + j6) - j7)];
                }
                segment = segment.next;
                kotlin.jvm.internal.l.b(segment);
                j7 = j8;
            }
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i6 = 1;
        do {
            int i7 = segment.limit;
            for (int i8 = segment.pos; i8 < i7; i8++) {
                i6 = (i6 * 31) + segment.data[i8];
            }
            segment = segment.next;
            kotlin.jvm.internal.l.b(segment);
        } while (segment != this.head);
        return i6;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "key");
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "key");
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "key");
        return hmac("HmacSHA512", byteString);
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
        return new InputStream() { // from class: okio.Buffer$inputStream$1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size() > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i6, int i7) {
                kotlin.jvm.internal.l.d(bArr, "sink");
                return Buffer.this.read(bArr, i6, i7);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer$outputStream$1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i6) {
                Buffer.this.writeByte(i6);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i6, int i7) {
                kotlin.jvm.internal.l.d(bArr, "data");
                Buffer.this.write(bArr, i6, i7);
            }
        };
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
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        int i6 = segment.pos + min;
        segment.pos = i6;
        this.size -= min;
        if (i6 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) {
        kotlin.jvm.internal.l.d(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        if (size() != 0) {
            Segment segment = this.head;
            kotlin.jvm.internal.l.b(segment);
            int i6 = segment.pos;
            int i7 = segment.limit;
            int i8 = i6 + 1;
            byte b6 = segment.data[i6];
            setSize$okio(size() - 1);
            if (i8 == i7) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i8;
            }
            return b6;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return readByteString(size());
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x009e, code lost:
        setSize$okio(size() - r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a7, code lost:
        if (r2 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a9, code lost:
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ab, code lost:
        r14 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ac, code lost:
        if (r1 >= r14) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b6, code lost:
        if (size() == 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b8, code lost:
        if (r2 == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ba, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bd, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e2, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio._UtilKt.toHexString(getByte(0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e8, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e9, code lost:
        if (r2 == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ed, code lost:
        return -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
        return r8;
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readDecimalLong() {
        byte b6;
        if (size() != 0) {
            int i6 = 0;
            long j6 = 0;
            long j7 = -7;
            boolean z5 = false;
            boolean z6 = false;
            loop0: while (true) {
                Segment segment = this.head;
                kotlin.jvm.internal.l.b(segment);
                byte[] bArr = segment.data;
                int i7 = segment.pos;
                int i8 = segment.limit;
                while (i7 < i8) {
                    b6 = bArr[i7];
                    byte b7 = (byte) 48;
                    if (b6 >= b7 && b6 <= ((byte) 57)) {
                        int i9 = b7 - b6;
                        int i10 = (j6 > _BufferKt.OVERFLOW_ZONE ? 1 : (j6 == _BufferKt.OVERFLOW_ZONE ? 0 : -1));
                        if (i10 < 0 || (i10 == 0 && i9 < j7)) {
                            break loop0;
                        }
                        j6 = (j6 * 10) + i9;
                    } else if (b6 != ((byte) 45) || i6 != 0) {
                        z6 = true;
                        break;
                    } else {
                        j7--;
                        z5 = true;
                    }
                    i7++;
                    i6++;
                }
                if (i7 == i8) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i7;
                }
                if (z6 || this.head == null) {
                    break;
                }
            }
            Buffer writeByte = new Buffer().writeDecimalLong(j6).writeByte((int) b6);
            if (!z5) {
                writeByte.readByte();
            }
            throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
        }
        throw new EOFException();
    }

    public final Buffer readFrom(InputStream inputStream) {
        kotlin.jvm.internal.l.d(inputStream, "input");
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "sink");
        if (size() >= j6) {
            buffer.write(this, j6);
        } else {
            buffer.write(this, size());
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae A[EDGE_INSN: B:42:0x00ae->B:37:0x00ae ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readHexadecimalUnsignedLong() {
        int i6;
        if (size() != 0) {
            int i7 = 0;
            long j6 = 0;
            boolean z5 = false;
            do {
                Segment segment = this.head;
                kotlin.jvm.internal.l.b(segment);
                byte[] bArr = segment.data;
                int i8 = segment.pos;
                int i9 = segment.limit;
                while (i8 < i9) {
                    byte b6 = bArr[i8];
                    byte b7 = (byte) 48;
                    if (b6 < b7 || b6 > ((byte) 57)) {
                        byte b8 = (byte) 97;
                        if ((b6 >= b8 && b6 <= ((byte) androidx.constraintlayout.widget.g.U0)) || (b6 >= (b8 = (byte) 65) && b6 <= ((byte) 70))) {
                            i6 = (b6 - b8) + 10;
                        } else if (i7 == 0) {
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + _UtilKt.toHexString(b6));
                        } else {
                            z5 = true;
                            if (i8 != i9) {
                                this.head = segment.pop();
                                SegmentPool.recycle(segment);
                            } else {
                                segment.pos = i8;
                            }
                            if (!z5) {
                                break;
                            }
                        }
                    } else {
                        i6 = b6 - b7;
                    }
                    if (((-1152921504606846976L) & j6) != 0) {
                        Buffer writeByte = new Buffer().writeHexadecimalUnsignedLong(j6).writeByte((int) b6);
                        throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
                    }
                    j6 = (j6 << 4) | i6;
                    i8++;
                    i7++;
                }
                if (i8 != i9) {
                }
                if (!z5) {
                }
            } while (this.head != null);
            setSize$okio(size() - i7);
            return j6;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readInt() {
        if (size() >= 4) {
            Segment segment = this.head;
            kotlin.jvm.internal.l.b(segment);
            int i6 = segment.pos;
            int i7 = segment.limit;
            if (i7 - i6 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.data;
            int i8 = i6 + 1;
            int i9 = i8 + 1;
            int i10 = ((bArr[i6] & 255) << 24) | ((bArr[i8] & 255) << 16);
            int i11 = i9 + 1;
            int i12 = i10 | ((bArr[i9] & 255) << 8);
            int i13 = i11 + 1;
            int i14 = i12 | (bArr[i11] & 255);
            setSize$okio(size() - 4);
            if (i13 == i7) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return i14;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return _UtilKt.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() {
        if (size() >= 8) {
            Segment segment = this.head;
            kotlin.jvm.internal.l.b(segment);
            int i6 = segment.pos;
            int i7 = segment.limit;
            if (i7 - i6 < 8) {
                return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
            }
            byte[] bArr = segment.data;
            int i8 = i6 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j6 = ((bArr[i6] & 255) << 56) | ((bArr[i8] & 255) << 48) | ((bArr[i9] & 255) << 40);
            int i11 = i10 + 1;
            long j7 = ((bArr[i10] & 255) << 32) | j6;
            int i12 = i11 + 1;
            int i13 = i12 + 1;
            long j8 = j7 | ((bArr[i11] & 255) << 24) | ((bArr[i12] & 255) << 16);
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            long j9 = j8 | ((bArr[i13] & 255) << 8) | (bArr[i14] & 255);
            setSize$okio(size() - 8);
            if (i15 == i7) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i15;
            }
            return j9;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return _UtilKt.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() {
        if (size() >= 2) {
            Segment segment = this.head;
            kotlin.jvm.internal.l.b(segment);
            int i6 = segment.pos;
            int i7 = segment.limit;
            if (i7 - i6 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.data;
            int i8 = i6 + 1;
            int i9 = i8 + 1;
            int i10 = ((bArr[i6] & 255) << 8) | (bArr[i8] & 255);
            setSize$okio(size() - 2);
            if (i9 == i7) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i9;
            }
            return (short) i10;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return _UtilKt.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    public String readString(long j6, Charset charset) {
        kotlin.jvm.internal.l.d(charset, "charset");
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        if (!(i6 >= 0 && j6 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        } else if (this.size >= j6) {
            if (i6 == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            Segment segment = this.head;
            kotlin.jvm.internal.l.b(segment);
            int i7 = segment.pos;
            if (i7 + j6 > segment.limit) {
                return new String(readByteArray(j6), charset);
            }
            int i8 = (int) j6;
            String str = new String(segment.data, i7, i8, charset);
            int i9 = segment.pos + i8;
            segment.pos = i9;
            this.size -= j6;
            if (i9 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return str;
        } else {
            throw new EOFException();
        }
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        return readString(this.size, kotlin.text.d.f11327b);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() {
        int i6;
        int i7;
        int i8;
        if (size() != 0) {
            byte b6 = getByte(0L);
            boolean z5 = false;
            if ((b6 & 128) == 0) {
                i6 = b6 & Byte.MAX_VALUE;
                i7 = 1;
                i8 = 0;
            } else if ((b6 & 224) == 192) {
                i6 = b6 & 31;
                i7 = 2;
                i8 = 128;
            } else if ((b6 & 240) == 224) {
                i6 = b6 & 15;
                i7 = 3;
                i8 = 2048;
            } else if ((b6 & 248) != 240) {
                skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            } else {
                i6 = b6 & 7;
                i7 = 4;
                i8 = DnsOverHttps.MAX_RESPONSE_SIZE;
            }
            long j6 = i7;
            if (size() < j6) {
                throw new EOFException("size < " + i7 + ": " + size() + " (to read code point prefixed 0x" + _UtilKt.toHexString(b6) + ')');
            }
            for (int i9 = 1; i9 < i7; i9++) {
                long j7 = i9;
                byte b7 = getByte(j7);
                if ((b7 & 192) != 128) {
                    skip(j7);
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                i6 = (i6 << 6) | (b7 & Utf8.REPLACEMENT_BYTE);
            }
            skip(j6);
            if (i6 > 1114111) {
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            if (55296 <= i6 && i6 < 57344) {
                z5 = true;
            }
            return (!z5 && i6 >= i8) ? i6 : Utf8.REPLACEMENT_CODE_POINT;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return _BufferKt.readUtf8Line(this, indexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long j6) {
        return this.size >= j6;
    }

    @Override // okio.BufferedSource
    public void require(long j6) {
        if (this.size < j6) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) {
        kotlin.jvm.internal.l.d(options, "options");
        int selectPrefix$default = _BufferKt.selectPrefix$default(this, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public final void setSize$okio(long j6) {
        this.size = j6;
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long j6) {
        while (j6 > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j6, segment.limit - segment.pos);
            long j7 = min;
            setSize$okio(size() - j7);
            j6 -= j7;
            int i6 = segment.pos + min;
            segment.pos = i6;
            if (i6 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public final ByteString snapshot() {
        if (size() <= 2147483647L) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public final Segment writableSegment$okio(int i6) {
        boolean z5 = true;
        if ((i6 < 1 || i6 > 8192) ? false : false) {
            Segment segment = this.head;
            if (segment != null) {
                kotlin.jvm.internal.l.b(segment);
                Segment segment2 = segment.prev;
                kotlin.jvm.internal.l.b(segment2);
                return (segment2.limit + i6 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
            }
            Segment take = SegmentPool.take();
            this.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        kotlin.jvm.internal.l.d(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i6 = remaining;
        while (i6 > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i6, 8192 - writableSegment$okio.limit);
            byteBuffer.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            i6 -= min;
            writableSegment$okio.limit += min;
        }
        this.size += remaining;
        return remaining;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) {
        kotlin.jvm.internal.l.d(source, "source");
        long j6 = 0;
        while (true) {
            long read = source.read(this, 8192L);
            if (read == -1) {
                return j6;
            }
            j6 += read;
        }
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int i6) {
        Segment writableSegment$okio = writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        writableSegment$okio.limit = i7 + 1;
        bArr[i7] = (byte) i6;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j6) {
        boolean z5;
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        if (i6 == 0) {
            return writeByte(48);
        }
        int i7 = 1;
        if (i6 < 0) {
            j6 = -j6;
            if (j6 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z5 = true;
        } else {
            z5 = false;
        }
        if (j6 >= 100000000) {
            i7 = j6 < 1000000000000L ? j6 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j6 < 1000000000 ? 9 : 10 : j6 < 100000000000L ? 11 : 12 : j6 < 1000000000000000L ? j6 < 10000000000000L ? 13 : j6 < 100000000000000L ? 14 : 15 : j6 < 100000000000000000L ? j6 < 10000000000000000L ? 16 : 17 : j6 < 1000000000000000000L ? 18 : 19;
        } else if (j6 >= 10000) {
            i7 = j6 < 1000000 ? j6 < 100000 ? 5 : 6 : j6 < 10000000 ? 7 : 8;
        } else if (j6 >= 100) {
            i7 = j6 < 1000 ? 3 : 4;
        } else if (j6 >= 10) {
            i7 = 2;
        }
        if (z5) {
            i7++;
        }
        Segment writableSegment$okio = writableSegment$okio(i7);
        byte[] bArr = writableSegment$okio.data;
        int i8 = writableSegment$okio.limit + i7;
        while (j6 != 0) {
            long j7 = 10;
            i8--;
            bArr[i8] = _BufferKt.getHEX_DIGIT_BYTES()[(int) (j6 % j7)];
            j6 /= j7;
        }
        if (z5) {
            bArr[i8 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i7;
        setSize$okio(size() + i7);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j6) {
        if (j6 == 0) {
            return writeByte(48);
        }
        long j7 = (j6 >>> 1) | j6;
        long j8 = j7 | (j7 >>> 2);
        long j9 = j8 | (j8 >>> 4);
        long j10 = j9 | (j9 >>> 8);
        long j11 = j10 | (j10 >>> 16);
        long j12 = j11 | (j11 >>> 32);
        long j13 = j12 - ((j12 >>> 1) & 6148914691236517205L);
        long j14 = ((j13 >>> 2) & 3689348814741910323L) + (j13 & 3689348814741910323L);
        long j15 = ((j14 >>> 4) + j14) & 1085102592571150095L;
        long j16 = j15 + (j15 >>> 8);
        long j17 = j16 + (j16 >>> 16);
        int i6 = (int) ((((j17 & 63) + ((j17 >>> 32) & 63)) + 3) / 4);
        Segment writableSegment$okio = writableSegment$okio(i6);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        for (int i8 = (i7 + i6) - 1; i8 >= i7; i8--) {
            bArr[i8] = _BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & j6)];
            j6 >>>= 4;
        }
        writableSegment$okio.limit += i6;
        setSize$okio(size() + i6);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i6) {
        Segment writableSegment$okio = writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i6 >>> 24) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((i6 >>> 16) & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((i6 >>> 8) & 255);
        bArr[i10] = (byte) (i6 & 255);
        writableSegment$okio.limit = i10 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i6) {
        return writeInt(_UtilKt.reverseBytes(i6));
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long j6) {
        Segment writableSegment$okio = writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i6 = writableSegment$okio.limit;
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j6 >>> 56) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j6 >>> 48) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j6 >>> 40) & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((j6 >>> 32) & 255);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((j6 >>> 24) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((j6 >>> 16) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((j6 >>> 8) & 255);
        bArr[i13] = (byte) (j6 & 255);
        writableSegment$okio.limit = i13 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j6) {
        return writeLong(_UtilKt.reverseBytes(j6));
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i6) {
        Segment writableSegment$okio = writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i6 >>> 8) & 255);
        bArr[i8] = (byte) (i6 & 255);
        writableSegment$okio.limit = i8 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i6) {
        return writeShort((int) _UtilKt.reverseBytes((short) i6));
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, int i6, int i7, Charset charset) {
        kotlin.jvm.internal.l.d(str, "string");
        kotlin.jvm.internal.l.d(charset, "charset");
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i6).toString());
        }
        if (!(i7 >= i6)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i7 + " < " + i6).toString());
        }
        if (!(i7 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i7 + " > " + str.length()).toString());
        } else if (kotlin.jvm.internal.l.a(charset, kotlin.text.d.f11327b)) {
            return writeUtf8(str, i6, i7);
        } else {
            String substring = str.substring(i6, i7);
            kotlin.jvm.internal.l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            byte[] bytes = substring.getBytes(charset);
            kotlin.jvm.internal.l.c(bytes, "this as java.lang.String).getBytes(charset)");
            return write(bytes, 0, bytes.length);
        }
    }

    public final Buffer writeTo(OutputStream outputStream) {
        kotlin.jvm.internal.l.d(outputStream, "out");
        return writeTo$default(this, outputStream, 0L, 2, null);
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str) {
        kotlin.jvm.internal.l.d(str, "string");
        return writeUtf8(str, 0, str.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i6) {
        long size;
        long j6;
        if (i6 < 128) {
            writeByte(i6);
        } else {
            if (i6 < 2048) {
                Segment writableSegment$okio = writableSegment$okio(2);
                byte[] bArr = writableSegment$okio.data;
                int i7 = writableSegment$okio.limit;
                bArr[i7] = (byte) ((i6 >> 6) | 192);
                bArr[i7 + 1] = (byte) ((i6 & 63) | 128);
                writableSegment$okio.limit = i7 + 2;
                size = size();
                j6 = 2;
            } else {
                boolean z5 = false;
                if (55296 <= i6 && i6 < 57344) {
                    z5 = true;
                }
                if (z5) {
                    writeByte(63);
                } else if (i6 < 65536) {
                    Segment writableSegment$okio2 = writableSegment$okio(3);
                    byte[] bArr2 = writableSegment$okio2.data;
                    int i8 = writableSegment$okio2.limit;
                    bArr2[i8] = (byte) ((i6 >> 12) | 224);
                    bArr2[i8 + 1] = (byte) (((i6 >> 6) & 63) | 128);
                    bArr2[i8 + 2] = (byte) ((i6 & 63) | 128);
                    writableSegment$okio2.limit = i8 + 3;
                    size = size();
                    j6 = 3;
                } else if (i6 > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: 0x" + _UtilKt.toHexString(i6));
                } else {
                    Segment writableSegment$okio3 = writableSegment$okio(4);
                    byte[] bArr3 = writableSegment$okio3.data;
                    int i9 = writableSegment$okio3.limit;
                    bArr3[i9] = (byte) ((i6 >> 18) | 240);
                    bArr3[i9 + 1] = (byte) (((i6 >> 12) & 63) | 128);
                    bArr3[i9 + 2] = (byte) (((i6 >> 6) & 63) | 128);
                    bArr3[i9 + 3] = (byte) ((i6 & 63) | 128);
                    writableSegment$okio3.limit = i9 + 4;
                    size = size();
                    j6 = 4;
                }
            }
            setSize$okio(size + j6);
        }
        return this;
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j6, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = 0;
        }
        return buffer.copyTo(buffer2, j6);
    }

    public Buffer clone() {
        return copy();
    }

    public final Buffer copyTo(OutputStream outputStream, long j6) {
        kotlin.jvm.internal.l.d(outputStream, "out");
        return copyTo$default(this, outputStream, j6, 0L, 4, (Object) null);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b6, long j6) {
        return indexOf(b6, j6, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j6) {
        int i6;
        kotlin.jvm.internal.l.d(byteString, "targetBytes");
        long j7 = 0;
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j6).toString());
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        if (size() - j6 < j6) {
            j7 = size();
            while (j7 > j6) {
                segment = segment.prev;
                kotlin.jvm.internal.l.b(segment);
                j7 -= segment.limit - segment.pos;
            }
            if (byteString.size() == 2) {
                byte b6 = byteString.getByte(0);
                byte b7 = byteString.getByte(1);
                while (j7 < size()) {
                    byte[] bArr = segment.data;
                    i6 = (int) ((segment.pos + j6) - j7);
                    int i7 = segment.limit;
                    while (i6 < i7) {
                        byte b8 = bArr[i6];
                        if (b8 != b6 && b8 != b7) {
                            i6++;
                        }
                    }
                    j7 += segment.limit - segment.pos;
                    segment = segment.next;
                    kotlin.jvm.internal.l.b(segment);
                    j6 = j7;
                }
                return -1L;
            }
            byte[] internalArray$okio = byteString.internalArray$okio();
            while (j7 < size()) {
                byte[] bArr2 = segment.data;
                i6 = (int) ((segment.pos + j6) - j7);
                int i8 = segment.limit;
                while (i6 < i8) {
                    byte b9 = bArr2[i6];
                    for (byte b10 : internalArray$okio) {
                        if (b9 != b10) {
                        }
                    }
                    i6++;
                }
                j7 += segment.limit - segment.pos;
                segment = segment.next;
                kotlin.jvm.internal.l.b(segment);
                j6 = j7;
            }
            return -1L;
        }
        while (true) {
            long j8 = (segment.limit - segment.pos) + j7;
            if (j8 > j6) {
                break;
            }
            segment = segment.next;
            kotlin.jvm.internal.l.b(segment);
            j7 = j8;
        }
        if (byteString.size() == 2) {
            byte b11 = byteString.getByte(0);
            byte b12 = byteString.getByte(1);
            while (j7 < size()) {
                byte[] bArr3 = segment.data;
                i6 = (int) ((segment.pos + j6) - j7);
                int i9 = segment.limit;
                while (i6 < i9) {
                    byte b13 = bArr3[i6];
                    if (b13 != b11 && b13 != b12) {
                        i6++;
                    }
                }
                j7 += segment.limit - segment.pos;
                segment = segment.next;
                kotlin.jvm.internal.l.b(segment);
                j6 = j7;
            }
            return -1L;
        }
        byte[] internalArray$okio2 = byteString.internalArray$okio();
        while (j7 < size()) {
            byte[] bArr4 = segment.data;
            i6 = (int) ((segment.pos + j6) - j7);
            int i10 = segment.limit;
            while (i6 < i10) {
                byte b14 = bArr4[i6];
                for (byte b15 : internalArray$okio2) {
                    if (b14 != b15) {
                    }
                }
                i6++;
            }
            j7 += segment.limit - segment.pos;
            segment = segment.next;
            kotlin.jvm.internal.l.b(segment);
            j6 = j7;
        }
        return -1L;
        return (i6 - segment.pos) + j7;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j6, ByteString byteString, int i6, int i7) {
        kotlin.jvm.internal.l.d(byteString, "bytes");
        if (j6 < 0 || i6 < 0 || i7 < 0 || size() - j6 < i7 || byteString.size() - i6 < i7) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (getByte(i8 + j6) != byteString.getByte(i6 + i8)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        kotlin.jvm.internal.l.d(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        kotlin.jvm.internal.l.d(unsafeCursor, "unsafeCursor");
        return _BufferKt.commonReadAndWriteUnsafe(this, unsafeCursor);
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j6) {
        if (!(j6 >= 0 && j6 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        } else if (size() >= j6) {
            byte[] bArr = new byte[(int) j6];
            readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j6) {
        if (!(j6 >= 0 && j6 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        } else if (size() >= j6) {
            if (j6 >= 4096) {
                ByteString snapshot = snapshot((int) j6);
                skip(j6);
                return snapshot;
            }
            return new ByteString(readByteArray(j6));
        } else {
            throw new EOFException();
        }
    }

    public final Buffer readFrom(InputStream inputStream, long j6) {
        kotlin.jvm.internal.l.d(inputStream, "input");
        if (j6 >= 0) {
            readFrom(inputStream, j6, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) {
        kotlin.jvm.internal.l.d(bArr, "sink");
        int i6 = 0;
        while (i6 < bArr.length) {
            int read = read(bArr, i6, bArr.length - i6);
            if (read == -1) {
                throw new EOFException();
            }
            i6 += read;
        }
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        kotlin.jvm.internal.l.d(charset, "charset");
        return readString(this.size, charset);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        kotlin.jvm.internal.l.d(unsafeCursor, "unsafeCursor");
        return _BufferKt.commonReadUnsafe(this, unsafeCursor);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j6) {
        return readString(j6, kotlin.text.d.f11327b);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j6) {
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j6).toString());
        }
        long j7 = j6 != Long.MAX_VALUE ? j6 + 1 : Long.MAX_VALUE;
        byte b6 = (byte) 10;
        long indexOf = indexOf(b6, 0L, j7);
        if (indexOf != -1) {
            return _BufferKt.readUtf8Line(this, indexOf);
        }
        if (j7 < size() && getByte(j7 - 1) == ((byte) 13) && getByte(j7) == b6) {
            return _BufferKt.readUtf8Line(this, j7);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j6) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    public final ByteString snapshot(int i6) {
        if (i6 == 0) {
            return ByteString.EMPTY;
        }
        _UtilKt.checkOffsetAndCount(size(), 0L, i6);
        Segment segment = this.head;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            kotlin.jvm.internal.l.b(segment);
            int i10 = segment.limit;
            int i11 = segment.pos;
            if (i10 == i11) {
                throw new AssertionError("s.limit == s.pos");
            }
            i8 += i10 - i11;
            i9++;
            segment = segment.next;
        }
        byte[][] bArr = new byte[i9];
        int[] iArr = new int[i9 * 2];
        Segment segment2 = this.head;
        int i12 = 0;
        while (i7 < i6) {
            kotlin.jvm.internal.l.b(segment2);
            bArr[i12] = segment2.data;
            i7 += segment2.limit - segment2.pos;
            iArr[i12] = Math.min(i7, i6);
            iArr[i12 + i9] = segment2.pos;
            segment2.shared = true;
            i12++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        kotlin.jvm.internal.l.d(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        kotlin.jvm.internal.l.d(str, "string");
        kotlin.jvm.internal.l.d(charset, "charset");
        return writeString(str, 0, str.length(), charset);
    }

    public final Buffer writeTo(OutputStream outputStream, long j6) {
        kotlin.jvm.internal.l.d(outputStream, "out");
        _UtilKt.checkOffsetAndCount(this.size, 0L, j6);
        Segment segment = this.head;
        while (j6 > 0) {
            kotlin.jvm.internal.l.b(segment);
            int min = (int) Math.min(j6, segment.limit - segment.pos);
            outputStream.write(segment.data, segment.pos, min);
            int i6 = segment.pos + min;
            segment.pos = i6;
            long j7 = min;
            this.size -= j7;
            j6 -= j7;
            if (i6 == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str, int i6, int i7) {
        char charAt;
        long size;
        long j6;
        kotlin.jvm.internal.l.d(str, "string");
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i6).toString());
        }
        if (!(i7 >= i6)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i7 + " < " + i6).toString());
        }
        if (!(i7 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i7 + " > " + str.length()).toString());
        }
        while (i6 < i7) {
            char charAt2 = str.charAt(i6);
            if (charAt2 < 128) {
                Segment writableSegment$okio = writableSegment$okio(1);
                byte[] bArr = writableSegment$okio.data;
                int i8 = writableSegment$okio.limit - i6;
                int min = Math.min(i7, 8192 - i8);
                int i9 = i6 + 1;
                bArr[i6 + i8] = (byte) charAt2;
                while (true) {
                    i6 = i9;
                    if (i6 >= min || (charAt = str.charAt(i6)) >= 128) {
                        break;
                    }
                    i9 = i6 + 1;
                    bArr[i6 + i8] = (byte) charAt;
                }
                int i10 = writableSegment$okio.limit;
                int i11 = (i8 + i6) - i10;
                writableSegment$okio.limit = i10 + i11;
                setSize$okio(size() + i11);
            } else {
                if (charAt2 < 2048) {
                    Segment writableSegment$okio2 = writableSegment$okio(2);
                    byte[] bArr2 = writableSegment$okio2.data;
                    int i12 = writableSegment$okio2.limit;
                    bArr2[i12] = (byte) ((charAt2 >> 6) | 192);
                    bArr2[i12 + 1] = (byte) ((charAt2 & '?') | 128);
                    writableSegment$okio2.limit = i12 + 2;
                    size = size();
                    j6 = 2;
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    Segment writableSegment$okio3 = writableSegment$okio(3);
                    byte[] bArr3 = writableSegment$okio3.data;
                    int i13 = writableSegment$okio3.limit;
                    bArr3[i13] = (byte) ((charAt2 >> '\f') | 224);
                    bArr3[i13 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                    bArr3[i13 + 2] = (byte) ((charAt2 & '?') | 128);
                    writableSegment$okio3.limit = i13 + 3;
                    size = size();
                    j6 = 3;
                } else {
                    int i14 = i6 + 1;
                    char charAt3 = i14 < i7 ? str.charAt(i14) : (char) 0;
                    if (charAt2 <= 56319) {
                        if (56320 <= charAt3 && charAt3 < 57344) {
                            int i15 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + DnsOverHttps.MAX_RESPONSE_SIZE;
                            Segment writableSegment$okio4 = writableSegment$okio(4);
                            byte[] bArr4 = writableSegment$okio4.data;
                            int i16 = writableSegment$okio4.limit;
                            bArr4[i16] = (byte) ((i15 >> 18) | 240);
                            bArr4[i16 + 1] = (byte) (((i15 >> 12) & 63) | 128);
                            bArr4[i16 + 2] = (byte) (((i15 >> 6) & 63) | 128);
                            bArr4[i16 + 3] = (byte) ((i15 & 63) | 128);
                            writableSegment$okio4.limit = i16 + 4;
                            setSize$okio(size() + 4);
                            i6 += 2;
                        }
                    }
                    writeByte(63);
                    i6 = i14;
                }
                setSize$okio(size + j6);
                i6++;
            }
        }
        return this;
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j6, long j7, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = 0;
        }
        return buffer.copyTo(buffer2, j6, j7);
    }

    private final void readFrom(InputStream inputStream, long j6, boolean z5) {
        while (true) {
            if (j6 <= 0 && !z5) {
                return;
            }
            Segment writableSegment$okio = writableSegment$okio(1);
            int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j6, 8192 - writableSegment$okio.limit));
            if (read == -1) {
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    this.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                if (!z5) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment$okio.limit += read;
            long j7 = read;
            this.size += j7;
            j6 -= j7;
        }
    }

    public final Buffer copyTo(OutputStream outputStream, long j6, long j7) {
        int i6;
        kotlin.jvm.internal.l.d(outputStream, "out");
        _UtilKt.checkOffsetAndCount(this.size, j6, j7);
        if (j7 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            kotlin.jvm.internal.l.b(segment);
            int i7 = segment.limit;
            int i8 = segment.pos;
            if (j6 < i7 - i8) {
                break;
            }
            j6 -= i7 - i8;
            segment = segment.next;
        }
        while (j7 > 0) {
            kotlin.jvm.internal.l.b(segment);
            int min = (int) Math.min(segment.limit - i6, j7);
            outputStream.write(segment.data, (int) (segment.pos + j6), min);
            j7 -= min;
            segment = segment.next;
            j6 = 0;
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b6, long j6, long j7) {
        Segment segment;
        int i6;
        boolean z5 = false;
        long j8 = 0;
        if (0 <= j6 && j6 <= j7) {
            z5 = true;
        }
        if (!z5) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j6 + " toIndex=" + j7).toString());
        }
        if (j7 > size()) {
            j7 = size();
        }
        if (j6 == j7 || (segment = this.head) == null) {
            return -1L;
        }
        if (size() - j6 < j6) {
            j8 = size();
            while (j8 > j6) {
                segment = segment.prev;
                kotlin.jvm.internal.l.b(segment);
                j8 -= segment.limit - segment.pos;
            }
            while (j8 < j7) {
                byte[] bArr = segment.data;
                int min = (int) Math.min(segment.limit, (segment.pos + j7) - j8);
                i6 = (int) ((segment.pos + j6) - j8);
                while (i6 < min) {
                    if (bArr[i6] != b6) {
                        i6++;
                    }
                }
                j8 += segment.limit - segment.pos;
                segment = segment.next;
                kotlin.jvm.internal.l.b(segment);
                j6 = j8;
            }
            return -1L;
        }
        while (true) {
            long j9 = (segment.limit - segment.pos) + j8;
            if (j9 > j6) {
                break;
            }
            segment = segment.next;
            kotlin.jvm.internal.l.b(segment);
            j8 = j9;
        }
        while (j8 < j7) {
            byte[] bArr2 = segment.data;
            int min2 = (int) Math.min(segment.limit, (segment.pos + j7) - j8);
            i6 = (int) ((segment.pos + j6) - j8);
            while (i6 < min2) {
                if (bArr2[i6] != b6) {
                    i6++;
                }
            }
            j8 += segment.limit - segment.pos;
            segment = segment.next;
            kotlin.jvm.internal.l.b(segment);
            j6 = j8;
        }
        return -1L;
        return (i6 - segment.pos) + j8;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.l.d(bArr, "sink");
        _UtilKt.checkOffsetAndCount(bArr.length, i6, i7);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i7, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i8 = segment.pos;
        kotlin.collections.i.d(bArr2, bArr, i6, i8, i8 + min);
        segment.pos += min;
        setSize$okio(size() - min);
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString, int i6, int i7) {
        kotlin.jvm.internal.l.d(byteString, "byteString");
        byteString.write$okio(this, i6, i7);
        return this;
    }

    public final Buffer copyTo(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "out");
        return copyTo(buffer, j6, this.size - j6);
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
        } else if (size() == 0) {
            return -1L;
        } else {
            if (j6 > size()) {
                j6 = size();
            }
            buffer.write(this, j6);
            return j6;
        }
    }

    @Override // okio.BufferedSink
    public Buffer write(Source source, long j6) {
        kotlin.jvm.internal.l.d(source, "source");
        while (j6 > 0) {
            long read = source.read(this, j6);
            if (read == -1) {
                throw new EOFException();
            }
            j6 -= read;
        }
        return this;
    }

    public final Buffer copyTo(Buffer buffer, long j6, long j7) {
        kotlin.jvm.internal.l.d(buffer, "out");
        _UtilKt.checkOffsetAndCount(size(), j6, j7);
        if (j7 != 0) {
            buffer.setSize$okio(buffer.size() + j7);
            Segment segment = this.head;
            while (true) {
                kotlin.jvm.internal.l.b(segment);
                int i6 = segment.limit;
                int i7 = segment.pos;
                if (j6 < i6 - i7) {
                    break;
                }
                j6 -= i6 - i7;
                segment = segment.next;
            }
            while (j7 > 0) {
                kotlin.jvm.internal.l.b(segment);
                Segment sharedCopy = segment.sharedCopy();
                int i8 = sharedCopy.pos + ((int) j6);
                sharedCopy.pos = i8;
                sharedCopy.limit = Math.min(i8 + ((int) j7), sharedCopy.limit);
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    buffer.head = sharedCopy;
                } else {
                    kotlin.jvm.internal.l.b(segment2);
                    Segment segment3 = segment2.prev;
                    kotlin.jvm.internal.l.b(segment3);
                    segment3.push(sharedCopy);
                }
                j7 -= sharedCopy.limit - sharedCopy.pos;
                segment = segment.next;
                j6 = 0;
            }
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j6) {
        long j7 = j6;
        kotlin.jvm.internal.l.d(byteString, "bytes");
        if (byteString.size() > 0) {
            long j8 = 0;
            if (!(j7 >= 0)) {
                throw new IllegalArgumentException(("fromIndex < 0: " + j7).toString());
            }
            Segment segment = this.head;
            if (segment != null) {
                if (size() - j7 < j7) {
                    long size = size();
                    while (size > j7) {
                        segment = segment.prev;
                        kotlin.jvm.internal.l.b(segment);
                        size -= segment.limit - segment.pos;
                    }
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    byte b6 = internalArray$okio[0];
                    int size2 = byteString.size();
                    long size3 = (size() - size2) + 1;
                    while (size < size3) {
                        byte[] bArr = segment.data;
                        long j9 = size;
                        int min = (int) Math.min(segment.limit, (segment.pos + size3) - size);
                        for (int i6 = (int) ((segment.pos + j7) - j9); i6 < min; i6++) {
                            if (bArr[i6] == b6 && _BufferKt.rangeEquals(segment, i6 + 1, internalArray$okio, 1, size2)) {
                                return (i6 - segment.pos) + j9;
                            }
                        }
                        size = j9 + (segment.limit - segment.pos);
                        segment = segment.next;
                        kotlin.jvm.internal.l.b(segment);
                        j7 = size;
                    }
                } else {
                    while (true) {
                        long j10 = (segment.limit - segment.pos) + j8;
                        if (j10 > j7) {
                            break;
                        }
                        segment = segment.next;
                        kotlin.jvm.internal.l.b(segment);
                        j8 = j10;
                    }
                    byte[] internalArray$okio2 = byteString.internalArray$okio();
                    byte b7 = internalArray$okio2[0];
                    int size4 = byteString.size();
                    long size5 = (size() - size4) + 1;
                    while (j8 < size5) {
                        byte[] bArr2 = segment.data;
                        long j11 = size5;
                        int min2 = (int) Math.min(segment.limit, (segment.pos + size5) - j8);
                        for (int i7 = (int) ((segment.pos + j7) - j8); i7 < min2; i7++) {
                            if (bArr2[i7] == b7 && _BufferKt.rangeEquals(segment, i7 + 1, internalArray$okio2, 1, size4)) {
                                return (i7 - segment.pos) + j8;
                            }
                        }
                        j8 += segment.limit - segment.pos;
                        segment = segment.next;
                        kotlin.jvm.internal.l.b(segment);
                        j7 = j8;
                        size5 = j11;
                    }
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr) {
        kotlin.jvm.internal.l.d(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.l.d(bArr, "source");
        long j6 = i7;
        _UtilKt.checkOffsetAndCount(bArr.length, i6, j6);
        int i8 = i7 + i6;
        while (i6 < i8) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i8 - i6, 8192 - writableSegment$okio.limit);
            int i9 = i6 + min;
            kotlin.collections.i.d(bArr, writableSegment$okio.data, writableSegment$okio.limit, i6, i9);
            writableSegment$okio.limit += min;
            i6 = i9;
        }
        setSize$okio(size() + j6);
        return this;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j6) {
        Segment segment;
        Segment segment2;
        kotlin.jvm.internal.l.d(buffer, "source");
        if (!(buffer != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        _UtilKt.checkOffsetAndCount(buffer.size(), 0L, j6);
        while (j6 > 0) {
            Segment segment3 = buffer.head;
            kotlin.jvm.internal.l.b(segment3);
            int i6 = segment3.limit;
            kotlin.jvm.internal.l.b(buffer.head);
            if (j6 < i6 - segment.pos) {
                Segment segment4 = this.head;
                if (segment4 != null) {
                    kotlin.jvm.internal.l.b(segment4);
                    segment2 = segment4.prev;
                } else {
                    segment2 = null;
                }
                if (segment2 != null && segment2.owner) {
                    if ((segment2.limit + j6) - (segment2.shared ? 0 : segment2.pos) <= 8192) {
                        Segment segment5 = buffer.head;
                        kotlin.jvm.internal.l.b(segment5);
                        segment5.writeTo(segment2, (int) j6);
                        buffer.setSize$okio(buffer.size() - j6);
                        setSize$okio(size() + j6);
                        return;
                    }
                }
                Segment segment6 = buffer.head;
                kotlin.jvm.internal.l.b(segment6);
                buffer.head = segment6.split((int) j6);
            }
            Segment segment7 = buffer.head;
            kotlin.jvm.internal.l.b(segment7);
            long j7 = segment7.limit - segment7.pos;
            buffer.head = segment7.pop();
            Segment segment8 = this.head;
            if (segment8 == null) {
                this.head = segment7;
                segment7.prev = segment7;
                segment7.next = segment7;
            } else {
                kotlin.jvm.internal.l.b(segment8);
                Segment segment9 = segment8.prev;
                kotlin.jvm.internal.l.b(segment9);
                segment9.push(segment7).compact();
            }
            buffer.setSize$okio(buffer.size() - j7);
            setSize$okio(size() + j7);
            j6 -= j7;
        }
    }
}
