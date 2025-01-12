package okio.internal;

import androidx.constraintlayout.widget.g;
import java.io.EOFException;
import kotlin.collections.i;
import kotlin.jvm.internal.l;
import okhttp3.HttpUrl;
import okhttp3.dnsoverhttps.DnsOverHttps;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio._JvmPlatformKt;
import okio._UtilKt;
import p4.p;
/* loaded from: classes.dex */
public final class _BufferKt {
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(Buffer buffer) {
        l.d(buffer, "<this>");
        buffer.skip(buffer.size());
    }

    public static final void commonClose(Buffer.UnsafeCursor unsafeCursor) {
        l.d(unsafeCursor, "<this>");
        if (!(unsafeCursor.buffer != null)) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        unsafeCursor.buffer = null;
        unsafeCursor.setSegment$okio(null);
        unsafeCursor.offset = -1L;
        unsafeCursor.data = null;
        unsafeCursor.start = -1;
        unsafeCursor.end = -1;
    }

    public static final long commonCompleteSegmentByteCount(Buffer buffer) {
        l.d(buffer, "<this>");
        long size = buffer.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = buffer.head;
        l.b(segment);
        Segment segment2 = segment.prev;
        l.b(segment2);
        int i6 = segment2.limit;
        return (i6 >= 8192 || !segment2.owner) ? size : size - (i6 - segment2.pos);
    }

    public static final Buffer commonCopy(Buffer buffer) {
        l.d(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        l.b(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            l.b(segment3);
            l.b(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    public static final Buffer commonCopyTo(Buffer buffer, Buffer buffer2, long j6, long j7) {
        l.d(buffer, "<this>");
        l.d(buffer2, "out");
        _UtilKt.checkOffsetAndCount(buffer.size(), j6, j7);
        if (j7 == 0) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + j7);
        Segment segment = buffer.head;
        while (true) {
            l.b(segment);
            int i6 = segment.limit;
            int i7 = segment.pos;
            if (j6 < i6 - i7) {
                break;
            }
            j6 -= i6 - i7;
            segment = segment.next;
        }
        while (j7 > 0) {
            l.b(segment);
            Segment sharedCopy = segment.sharedCopy();
            int i8 = sharedCopy.pos + ((int) j6);
            sharedCopy.pos = i8;
            sharedCopy.limit = Math.min(i8 + ((int) j7), sharedCopy.limit);
            Segment segment2 = buffer2.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                buffer2.head = sharedCopy;
            } else {
                l.b(segment2);
                Segment segment3 = segment2.prev;
                l.b(segment3);
                segment3.push(sharedCopy);
            }
            j7 -= sharedCopy.limit - sharedCopy.pos;
            segment = segment.next;
            j6 = 0;
        }
        return buffer;
    }

    public static final boolean commonEquals(Buffer buffer, Object obj) {
        l.d(buffer, "<this>");
        if (buffer == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer2 = (Buffer) obj;
            if (buffer.size() != buffer2.size()) {
                return false;
            }
            if (buffer.size() == 0) {
                return true;
            }
            Segment segment = buffer.head;
            l.b(segment);
            Segment segment2 = buffer2.head;
            l.b(segment2);
            int i6 = segment.pos;
            int i7 = segment2.pos;
            long j6 = 0;
            while (j6 < buffer.size()) {
                long min = Math.min(segment.limit - i6, segment2.limit - i7);
                long j7 = 0;
                while (j7 < min) {
                    int i8 = i6 + 1;
                    int i9 = i7 + 1;
                    if (segment.data[i6] != segment2.data[i7]) {
                        return false;
                    }
                    j7++;
                    i6 = i8;
                    i7 = i9;
                }
                if (i6 == segment.limit) {
                    segment = segment.next;
                    l.b(segment);
                    i6 = segment.pos;
                }
                if (i7 == segment2.limit) {
                    segment2 = segment2.next;
                    l.b(segment2);
                    i7 = segment2.pos;
                }
                j6 += min;
            }
            return true;
        }
        return false;
    }

    public static final long commonExpandBuffer(Buffer.UnsafeCursor unsafeCursor, int i6) {
        l.d(unsafeCursor, "<this>");
        if (!(i6 > 0)) {
            throw new IllegalArgumentException(("minByteCount <= 0: " + i6).toString());
        }
        if (!(i6 <= 8192)) {
            throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i6).toString());
        }
        Buffer buffer = unsafeCursor.buffer;
        if (buffer != null) {
            if (unsafeCursor.readWrite) {
                long size = buffer.size();
                Segment writableSegment$okio = buffer.writableSegment$okio(i6);
                int i7 = 8192 - writableSegment$okio.limit;
                writableSegment$okio.limit = Segment.SIZE;
                long j6 = i7;
                buffer.setSize$okio(size + j6);
                unsafeCursor.setSegment$okio(writableSegment$okio);
                unsafeCursor.offset = size;
                unsafeCursor.data = writableSegment$okio.data;
                unsafeCursor.start = 8192 - i7;
                unsafeCursor.end = Segment.SIZE;
                return j6;
            }
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
        }
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final byte commonGet(Buffer buffer, long j6) {
        l.d(buffer, "<this>");
        _UtilKt.checkOffsetAndCount(buffer.size(), j6, 1L);
        Segment segment = buffer.head;
        if (segment == null) {
            l.b(null);
            throw null;
        } else if (buffer.size() - j6 < j6) {
            long size = buffer.size();
            while (size > j6) {
                segment = segment.prev;
                l.b(segment);
                size -= segment.limit - segment.pos;
            }
            l.b(segment);
            return segment.data[(int) ((segment.pos + j6) - size)];
        } else {
            long j7 = 0;
            while (true) {
                long j8 = (segment.limit - segment.pos) + j7;
                if (j8 > j6) {
                    l.b(segment);
                    return segment.data[(int) ((segment.pos + j6) - j7)];
                }
                segment = segment.next;
                l.b(segment);
                j7 = j8;
            }
        }
    }

    public static final int commonHashCode(Buffer buffer) {
        l.d(buffer, "<this>");
        Segment segment = buffer.head;
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
            l.b(segment);
        } while (segment != buffer.head);
        return i6;
    }

    public static final long commonIndexOf(Buffer buffer, byte b6, long j6, long j7) {
        Segment segment;
        int i6;
        l.d(buffer, "<this>");
        boolean z5 = false;
        long j8 = 0;
        if (0 <= j6 && j6 <= j7) {
            z5 = true;
        }
        if (!z5) {
            throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + j6 + " toIndex=" + j7).toString());
        }
        if (j7 > buffer.size()) {
            j7 = buffer.size();
        }
        if (j6 == j7 || (segment = buffer.head) == null) {
            return -1L;
        }
        if (buffer.size() - j6 < j6) {
            j8 = buffer.size();
            while (j8 > j6) {
                segment = segment.prev;
                l.b(segment);
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
                l.b(segment);
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
            l.b(segment);
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
            l.b(segment);
            j6 = j8;
        }
        return -1L;
        return (i6 - segment.pos) + j8;
    }

    public static final long commonIndexOfElement(Buffer buffer, ByteString byteString, long j6) {
        int i6;
        l.d(buffer, "<this>");
        l.d(byteString, "targetBytes");
        long j7 = 0;
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j6).toString());
        }
        Segment segment = buffer.head;
        if (segment == null) {
            return -1L;
        }
        if (buffer.size() - j6 < j6) {
            j7 = buffer.size();
            while (j7 > j6) {
                segment = segment.prev;
                l.b(segment);
                j7 -= segment.limit - segment.pos;
            }
            if (byteString.size() == 2) {
                byte b6 = byteString.getByte(0);
                byte b7 = byteString.getByte(1);
                while (j7 < buffer.size()) {
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
                    l.b(segment);
                    j6 = j7;
                }
                return -1L;
            }
            byte[] internalArray$okio = byteString.internalArray$okio();
            while (j7 < buffer.size()) {
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
                l.b(segment);
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
            l.b(segment);
            j7 = j8;
        }
        if (byteString.size() == 2) {
            byte b11 = byteString.getByte(0);
            byte b12 = byteString.getByte(1);
            while (j7 < buffer.size()) {
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
                l.b(segment);
                j6 = j7;
            }
            return -1L;
        }
        byte[] internalArray$okio2 = byteString.internalArray$okio();
        while (j7 < buffer.size()) {
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
            l.b(segment);
            j6 = j7;
        }
        return -1L;
        return (i6 - segment.pos) + j7;
    }

    public static final int commonNext(Buffer.UnsafeCursor unsafeCursor) {
        l.d(unsafeCursor, "<this>");
        long j6 = unsafeCursor.offset;
        Buffer buffer = unsafeCursor.buffer;
        l.b(buffer);
        if (j6 != buffer.size()) {
            long j7 = unsafeCursor.offset;
            return unsafeCursor.seek(j7 == -1 ? 0L : j7 + (unsafeCursor.end - unsafeCursor.start));
        }
        throw new IllegalStateException("no more bytes".toString());
    }

    public static final boolean commonRangeEquals(Buffer buffer, long j6, ByteString byteString, int i6, int i7) {
        l.d(buffer, "<this>");
        l.d(byteString, "bytes");
        if (j6 < 0 || i6 < 0 || i7 < 0 || buffer.size() - j6 < i7 || byteString.size() - i6 < i7) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (buffer.getByte(i8 + j6) != byteString.getByte(i6 + i8)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(Buffer buffer, byte[] bArr) {
        l.d(buffer, "<this>");
        l.d(bArr, "sink");
        return buffer.read(bArr, 0, bArr.length);
    }

    public static final long commonReadAll(Buffer buffer, Sink sink) {
        l.d(buffer, "<this>");
        l.d(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        l.d(buffer, "<this>");
        l.d(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = _UtilKt.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = true;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final byte commonReadByte(Buffer buffer) {
        l.d(buffer, "<this>");
        if (buffer.size() != 0) {
            Segment segment = buffer.head;
            l.b(segment);
            int i6 = segment.pos;
            int i7 = segment.limit;
            int i8 = i6 + 1;
            byte b6 = segment.data[i6];
            buffer.setSize$okio(buffer.size() - 1);
            if (i8 == i7) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i8;
            }
            return b6;
        }
        throw new EOFException();
    }

    public static final byte[] commonReadByteArray(Buffer buffer) {
        l.d(buffer, "<this>");
        return buffer.readByteArray(buffer.size());
    }

    public static final ByteString commonReadByteString(Buffer buffer) {
        l.d(buffer, "<this>");
        return buffer.readByteString(buffer.size());
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x00a3, code lost:
        r17.setSize$okio(r17.size() - r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00ac, code lost:
        if (r2 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00ae, code lost:
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00b0, code lost:
        r14 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00b1, code lost:
        if (r1 >= r14) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00bb, code lost:
        if (r17.size() == 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00bd, code lost:
        if (r2 == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00bf, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00c2, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00e7, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio._UtilKt.toHexString(r17.getByte(0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x00ed, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x00ee, code lost:
        if (r2 == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x00f2, code lost:
        return -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:?, code lost:
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long commonReadDecimalLong(Buffer buffer) {
        byte b6;
        l.d(buffer, "<this>");
        if (buffer.size() != 0) {
            int i6 = 0;
            long j6 = 0;
            long j7 = -7;
            boolean z5 = false;
            boolean z6 = false;
            loop0: while (true) {
                Segment segment = buffer.head;
                l.b(segment);
                byte[] bArr = segment.data;
                int i7 = segment.pos;
                int i8 = segment.limit;
                while (i7 < i8) {
                    b6 = bArr[i7];
                    byte b7 = (byte) 48;
                    if (b6 >= b7 && b6 <= ((byte) 57)) {
                        int i9 = b7 - b6;
                        int i10 = (j6 > OVERFLOW_ZONE ? 1 : (j6 == OVERFLOW_ZONE ? 0 : -1));
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
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i7;
                }
                if (z6 || buffer.head == null) {
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

    public static final void commonReadFully(Buffer buffer, Buffer buffer2, long j6) {
        l.d(buffer, "<this>");
        l.d(buffer2, "sink");
        if (buffer.size() >= j6) {
            buffer2.write(buffer, j6);
        } else {
            buffer2.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b3 A[EDGE_INSN: B:91:0x00b3->B:85:0x00b3 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long commonReadHexadecimalUnsignedLong(Buffer buffer) {
        int i6;
        l.d(buffer, "<this>");
        if (buffer.size() != 0) {
            int i7 = 0;
            long j6 = 0;
            boolean z5 = false;
            do {
                Segment segment = buffer.head;
                l.b(segment);
                byte[] bArr = segment.data;
                int i8 = segment.pos;
                int i9 = segment.limit;
                while (i8 < i9) {
                    byte b6 = bArr[i8];
                    byte b7 = (byte) 48;
                    if (b6 < b7 || b6 > ((byte) 57)) {
                        byte b8 = (byte) 97;
                        if ((b6 >= b8 && b6 <= ((byte) g.U0)) || (b6 >= (b8 = (byte) 65) && b6 <= ((byte) 70))) {
                            i6 = (b6 - b8) + 10;
                        } else if (i7 == 0) {
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + _UtilKt.toHexString(b6));
                        } else {
                            z5 = true;
                            if (i8 != i9) {
                                buffer.head = segment.pop();
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
            } while (buffer.head != null);
            buffer.setSize$okio(buffer.size() - i7);
            return j6;
        }
        throw new EOFException();
    }

    public static final int commonReadInt(Buffer buffer) {
        l.d(buffer, "<this>");
        if (buffer.size() >= 4) {
            Segment segment = buffer.head;
            l.b(segment);
            int i6 = segment.pos;
            int i7 = segment.limit;
            if (i7 - i6 < 4) {
                return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << 24) | ((buffer.readByte() & 255) << 16) | ((buffer.readByte() & 255) << 8);
            }
            byte[] bArr = segment.data;
            int i8 = i6 + 1;
            int i9 = i8 + 1;
            int i10 = ((bArr[i6] & 255) << 24) | ((bArr[i8] & 255) << 16);
            int i11 = i9 + 1;
            int i12 = i10 | ((bArr[i9] & 255) << 8);
            int i13 = i11 + 1;
            int i14 = i12 | (bArr[i11] & 255);
            buffer.setSize$okio(buffer.size() - 4);
            if (i13 == i7) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return i14;
        }
        throw new EOFException();
    }

    public static final long commonReadLong(Buffer buffer) {
        l.d(buffer, "<this>");
        if (buffer.size() >= 8) {
            Segment segment = buffer.head;
            l.b(segment);
            int i6 = segment.pos;
            int i7 = segment.limit;
            if (i7 - i6 < 8) {
                return ((buffer.readInt() & 4294967295L) << 32) | (4294967295L & buffer.readInt());
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
            buffer.setSize$okio(buffer.size() - 8);
            if (i15 == i7) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i15;
            }
            return j9;
        }
        throw new EOFException();
    }

    public static final short commonReadShort(Buffer buffer) {
        l.d(buffer, "<this>");
        if (buffer.size() >= 2) {
            Segment segment = buffer.head;
            l.b(segment);
            int i6 = segment.pos;
            int i7 = segment.limit;
            if (i7 - i6 < 2) {
                return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
            }
            byte[] bArr = segment.data;
            int i8 = i6 + 1;
            int i9 = i8 + 1;
            int i10 = ((bArr[i6] & 255) << 8) | (bArr[i8] & 255);
            buffer.setSize$okio(buffer.size() - 2);
            if (i9 == i7) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i9;
            }
            return (short) i10;
        }
        throw new EOFException();
    }

    public static final Buffer.UnsafeCursor commonReadUnsafe(Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        l.d(buffer, "<this>");
        l.d(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = _UtilKt.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = false;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final String commonReadUtf8(Buffer buffer, long j6) {
        l.d(buffer, "<this>");
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        if (!(i6 >= 0 && j6 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        } else if (buffer.size() >= j6) {
            if (i6 == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            Segment segment = buffer.head;
            l.b(segment);
            int i7 = segment.pos;
            if (i7 + j6 > segment.limit) {
                return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j6), 0, 0, 3, null);
            }
            int i8 = (int) j6;
            String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i7, i7 + i8);
            segment.pos += i8;
            buffer.setSize$okio(buffer.size() - j6);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return commonToUtf8String;
        } else {
            throw new EOFException();
        }
    }

    public static final int commonReadUtf8CodePoint(Buffer buffer) {
        int i6;
        int i7;
        int i8;
        l.d(buffer, "<this>");
        if (buffer.size() != 0) {
            byte b6 = buffer.getByte(0L);
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
                buffer.skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            } else {
                i6 = b6 & 7;
                i7 = 4;
                i8 = DnsOverHttps.MAX_RESPONSE_SIZE;
            }
            long j6 = i7;
            if (buffer.size() < j6) {
                throw new EOFException("size < " + i7 + ": " + buffer.size() + " (to read code point prefixed 0x" + _UtilKt.toHexString(b6) + ')');
            }
            for (int i9 = 1; i9 < i7; i9++) {
                long j7 = i9;
                byte b7 = buffer.getByte(j7);
                if ((b7 & 192) != 128) {
                    buffer.skip(j7);
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                i6 = (i6 << 6) | (b7 & Utf8.REPLACEMENT_BYTE);
            }
            buffer.skip(j6);
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

    public static final String commonReadUtf8Line(Buffer buffer) {
        l.d(buffer, "<this>");
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(Buffer buffer, long j6) {
        l.d(buffer, "<this>");
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j6).toString());
        }
        long j7 = j6 != Long.MAX_VALUE ? j6 + 1 : Long.MAX_VALUE;
        byte b6 = (byte) 10;
        long indexOf = buffer.indexOf(b6, 0L, j7);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (j7 < buffer.size() && buffer.getByte(j7 - 1) == ((byte) 13) && buffer.getByte(j7) == b6) {
            return readUtf8Line(buffer, j7);
        }
        Buffer buffer2 = new Buffer();
        buffer.copyTo(buffer2, 0L, Math.min(32, buffer.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j6) + " content=" + buffer2.readByteString().hex() + (char) 8230);
    }

    public static final long commonResizeBuffer(Buffer.UnsafeCursor unsafeCursor, long j6) {
        l.d(unsafeCursor, "<this>");
        Buffer buffer = unsafeCursor.buffer;
        if (buffer != null) {
            if (unsafeCursor.readWrite) {
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
                        l.b(segment);
                        Segment segment2 = segment.prev;
                        l.b(segment2);
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
                    unsafeCursor.setSegment$okio(null);
                    unsafeCursor.offset = j6;
                    unsafeCursor.data = null;
                    unsafeCursor.start = -1;
                    unsafeCursor.end = -1;
                } else if (i7 > 0) {
                    long j9 = j6 - size;
                    boolean z5 = true;
                    while (j9 > 0) {
                        Segment writableSegment$okio = buffer.writableSegment$okio(i6);
                        int min = (int) Math.min(j9, 8192 - writableSegment$okio.limit);
                        writableSegment$okio.limit += min;
                        j9 -= min;
                        if (z5) {
                            unsafeCursor.setSegment$okio(writableSegment$okio);
                            unsafeCursor.offset = size;
                            unsafeCursor.data = writableSegment$okio.data;
                            int i9 = writableSegment$okio.limit;
                            unsafeCursor.start = i9 - min;
                            unsafeCursor.end = i9;
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

    public static final int commonSeek(Buffer.UnsafeCursor unsafeCursor, long j6) {
        Segment segment;
        l.d(unsafeCursor, "<this>");
        Buffer buffer = unsafeCursor.buffer;
        if (buffer != null) {
            int i6 = (j6 > (-1L) ? 1 : (j6 == (-1L) ? 0 : -1));
            if (i6 < 0 || j6 > buffer.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j6 + " > size=" + buffer.size());
            } else if (i6 == 0 || j6 == buffer.size()) {
                unsafeCursor.setSegment$okio(null);
                unsafeCursor.offset = j6;
                unsafeCursor.data = null;
                unsafeCursor.start = -1;
                unsafeCursor.end = -1;
                return -1;
            } else {
                long size = buffer.size();
                Segment segment2 = buffer.head;
                long j7 = 0;
                if (unsafeCursor.getSegment$okio() != null) {
                    long j8 = unsafeCursor.offset;
                    int i7 = unsafeCursor.start;
                    Segment segment$okio = unsafeCursor.getSegment$okio();
                    l.b(segment$okio);
                    long j9 = j8 - (i7 - segment$okio.pos);
                    if (j9 > j6) {
                        segment = segment2;
                        segment2 = unsafeCursor.getSegment$okio();
                        size = j9;
                    } else {
                        segment = unsafeCursor.getSegment$okio();
                        j7 = j9;
                    }
                } else {
                    segment = segment2;
                }
                if (size - j6 > j6 - j7) {
                    while (true) {
                        l.b(segment);
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
                        l.b(segment2);
                        segment2 = segment2.prev;
                        l.b(segment2);
                        size -= segment2.limit - segment2.pos;
                    }
                    j7 = size;
                    segment = segment2;
                }
                if (unsafeCursor.readWrite) {
                    l.b(segment);
                    if (segment.shared) {
                        Segment unsharedCopy = segment.unsharedCopy();
                        if (buffer.head == segment) {
                            buffer.head = unsharedCopy;
                        }
                        segment = segment.push(unsharedCopy);
                        Segment segment3 = segment.prev;
                        l.b(segment3);
                        segment3.pop();
                    }
                }
                unsafeCursor.setSegment$okio(segment);
                unsafeCursor.offset = j6;
                l.b(segment);
                unsafeCursor.data = segment.data;
                int i10 = segment.pos + ((int) (j6 - j7));
                unsafeCursor.start = i10;
                int i11 = segment.limit;
                unsafeCursor.end = i11;
                return i11 - i10;
            }
        }
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final int commonSelect(Buffer buffer, Options options) {
        l.d(buffer, "<this>");
        l.d(options, "options");
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(Buffer buffer, long j6) {
        l.d(buffer, "<this>");
        while (j6 > 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j6, segment.limit - segment.pos);
            long j7 = min;
            buffer.setSize$okio(buffer.size() - j7);
            j6 -= j7;
            int i6 = segment.pos + min;
            segment.pos = i6;
            if (i6 == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public static final ByteString commonSnapshot(Buffer buffer) {
        l.d(buffer, "<this>");
        if (buffer.size() <= 2147483647L) {
            return buffer.snapshot((int) buffer.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + buffer.size()).toString());
    }

    public static final Segment commonWritableSegment(Buffer buffer, int i6) {
        l.d(buffer, "<this>");
        boolean z5 = true;
        if ((i6 < 1 || i6 > 8192) ? false : false) {
            Segment segment = buffer.head;
            if (segment != null) {
                l.b(segment);
                Segment segment2 = segment.prev;
                l.b(segment2);
                return (segment2.limit + i6 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
            }
            Segment take = SegmentPool.take();
            buffer.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public static final Buffer commonWrite(Buffer buffer, ByteString byteString, int i6, int i7) {
        l.d(buffer, "<this>");
        l.d(byteString, "byteString");
        byteString.write$okio(buffer, i6, i7);
        return buffer;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer buffer, ByteString byteString, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = byteString.size();
        }
        l.d(buffer, "<this>");
        l.d(byteString, "byteString");
        byteString.write$okio(buffer, i6, i7);
        return buffer;
    }

    public static final long commonWriteAll(Buffer buffer, Source source) {
        l.d(buffer, "<this>");
        l.d(source, "source");
        long j6 = 0;
        while (true) {
            long read = source.read(buffer, 8192L);
            if (read == -1) {
                return j6;
            }
            j6 += read;
        }
    }

    public static final Buffer commonWriteByte(Buffer buffer, int i6) {
        l.d(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        writableSegment$okio.limit = i7 + 1;
        bArr[i7] = (byte) i6;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    public static final Buffer commonWriteDecimalLong(Buffer buffer, long j6) {
        boolean z5;
        l.d(buffer, "<this>");
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        if (i6 == 0) {
            return buffer.writeByte(48);
        }
        int i7 = 1;
        if (i6 < 0) {
            j6 = -j6;
            if (j6 < 0) {
                return buffer.writeUtf8("-9223372036854775808");
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
        Segment writableSegment$okio = buffer.writableSegment$okio(i7);
        byte[] bArr = writableSegment$okio.data;
        int i8 = writableSegment$okio.limit + i7;
        while (j6 != 0) {
            long j7 = 10;
            i8--;
            bArr[i8] = getHEX_DIGIT_BYTES()[(int) (j6 % j7)];
            j6 /= j7;
        }
        if (z5) {
            bArr[i8 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i7;
        buffer.setSize$okio(buffer.size() + i7);
        return buffer;
    }

    public static final Buffer commonWriteHexadecimalUnsignedLong(Buffer buffer, long j6) {
        l.d(buffer, "<this>");
        if (j6 == 0) {
            return buffer.writeByte(48);
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
        Segment writableSegment$okio = buffer.writableSegment$okio(i6);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        for (int i8 = (i7 + i6) - 1; i8 >= i7; i8--) {
            bArr[i8] = getHEX_DIGIT_BYTES()[(int) (15 & j6)];
            j6 >>>= 4;
        }
        writableSegment$okio.limit += i6;
        buffer.setSize$okio(buffer.size() + i6);
        return buffer;
    }

    public static final Buffer commonWriteInt(Buffer buffer, int i6) {
        l.d(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
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
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    public static final Buffer commonWriteLong(Buffer buffer, long j6) {
        l.d(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
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
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    public static final Buffer commonWriteShort(Buffer buffer, int i6) {
        l.d(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i6 >>> 8) & 255);
        bArr[i8] = (byte) (i6 & 255);
        writableSegment$okio.limit = i8 + 1;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    public static final Buffer commonWriteUtf8(Buffer buffer, String str, int i6, int i7) {
        char charAt;
        long size;
        long j6;
        l.d(buffer, "<this>");
        l.d(str, "string");
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
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
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
                buffer.setSize$okio(buffer.size() + i11);
            } else {
                if (charAt2 < 2048) {
                    Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                    byte[] bArr2 = writableSegment$okio2.data;
                    int i12 = writableSegment$okio2.limit;
                    bArr2[i12] = (byte) ((charAt2 >> 6) | 192);
                    bArr2[i12 + 1] = (byte) ((charAt2 & '?') | 128);
                    writableSegment$okio2.limit = i12 + 2;
                    size = buffer.size();
                    j6 = 2;
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    Segment writableSegment$okio3 = buffer.writableSegment$okio(3);
                    byte[] bArr3 = writableSegment$okio3.data;
                    int i13 = writableSegment$okio3.limit;
                    bArr3[i13] = (byte) ((charAt2 >> '\f') | 224);
                    bArr3[i13 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                    bArr3[i13 + 2] = (byte) ((charAt2 & '?') | 128);
                    writableSegment$okio3.limit = i13 + 3;
                    size = buffer.size();
                    j6 = 3;
                } else {
                    int i14 = i6 + 1;
                    char charAt3 = i14 < i7 ? str.charAt(i14) : (char) 0;
                    if (charAt2 <= 56319) {
                        if (56320 <= charAt3 && charAt3 < 57344) {
                            int i15 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + DnsOverHttps.MAX_RESPONSE_SIZE;
                            Segment writableSegment$okio4 = buffer.writableSegment$okio(4);
                            byte[] bArr4 = writableSegment$okio4.data;
                            int i16 = writableSegment$okio4.limit;
                            bArr4[i16] = (byte) ((i15 >> 18) | 240);
                            bArr4[i16 + 1] = (byte) (((i15 >> 12) & 63) | 128);
                            bArr4[i16 + 2] = (byte) (((i15 >> 6) & 63) | 128);
                            bArr4[i16 + 3] = (byte) ((i15 & 63) | 128);
                            writableSegment$okio4.limit = i16 + 4;
                            buffer.setSize$okio(buffer.size() + 4);
                            i6 += 2;
                        }
                    }
                    buffer.writeByte(63);
                    i6 = i14;
                }
                buffer.setSize$okio(size + j6);
                i6++;
            }
        }
        return buffer;
    }

    public static final Buffer commonWriteUtf8CodePoint(Buffer buffer, int i6) {
        long size;
        long j6;
        l.d(buffer, "<this>");
        if (i6 < 128) {
            buffer.writeByte(i6);
        } else {
            if (i6 < 2048) {
                Segment writableSegment$okio = buffer.writableSegment$okio(2);
                byte[] bArr = writableSegment$okio.data;
                int i7 = writableSegment$okio.limit;
                bArr[i7] = (byte) ((i6 >> 6) | 192);
                bArr[i7 + 1] = (byte) ((i6 & 63) | 128);
                writableSegment$okio.limit = i7 + 2;
                size = buffer.size();
                j6 = 2;
            } else {
                boolean z5 = false;
                if (55296 <= i6 && i6 < 57344) {
                    z5 = true;
                }
                if (z5) {
                    buffer.writeByte(63);
                } else if (i6 < 65536) {
                    Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
                    byte[] bArr2 = writableSegment$okio2.data;
                    int i8 = writableSegment$okio2.limit;
                    bArr2[i8] = (byte) ((i6 >> 12) | 224);
                    bArr2[i8 + 1] = (byte) (((i6 >> 6) & 63) | 128);
                    bArr2[i8 + 2] = (byte) ((i6 & 63) | 128);
                    writableSegment$okio2.limit = i8 + 3;
                    size = buffer.size();
                    j6 = 3;
                } else if (i6 > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: 0x" + _UtilKt.toHexString(i6));
                } else {
                    Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
                    byte[] bArr3 = writableSegment$okio3.data;
                    int i9 = writableSegment$okio3.limit;
                    bArr3[i9] = (byte) ((i6 >> 18) | 240);
                    bArr3[i9 + 1] = (byte) (((i6 >> 12) & 63) | 128);
                    bArr3[i9 + 2] = (byte) (((i6 >> 6) & 63) | 128);
                    bArr3[i9 + 3] = (byte) ((i6 & 63) | 128);
                    writableSegment$okio3.limit = i9 + 4;
                    size = buffer.size();
                    j6 = 4;
                }
            }
            buffer.setSize$okio(size + j6);
        }
        return buffer;
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static /* synthetic */ void getHEX_DIGIT_BYTES$annotations() {
    }

    public static final boolean rangeEquals(Segment segment, int i6, byte[] bArr, int i7, int i8) {
        l.d(segment, "segment");
        l.d(bArr, "bytes");
        int i9 = segment.limit;
        byte[] bArr2 = segment.data;
        while (i7 < i8) {
            if (i6 == i9) {
                segment = segment.next;
                l.b(segment);
                byte[] bArr3 = segment.data;
                bArr2 = bArr3;
                i6 = segment.pos;
                i9 = segment.limit;
            }
            if (bArr2[i6] != bArr[i7]) {
                return false;
            }
            i6++;
            i7++;
        }
        return true;
    }

    public static final String readUtf8Line(Buffer buffer, long j6) {
        l.d(buffer, "<this>");
        if (j6 > 0) {
            long j7 = j6 - 1;
            if (buffer.getByte(j7) == ((byte) 13)) {
                String readUtf8 = buffer.readUtf8(j7);
                buffer.skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j6);
        buffer.skip(1L);
        return readUtf82;
    }

    public static final <T> T seek(Buffer buffer, long j6, p pVar) {
        l.d(buffer, "<this>");
        l.d(pVar, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return (T) pVar.invoke(null, -1L);
        }
        if (buffer.size() - j6 < j6) {
            long size = buffer.size();
            while (size > j6) {
                segment = segment.prev;
                l.b(segment);
                size -= segment.limit - segment.pos;
            }
            return (T) pVar.invoke(segment, Long.valueOf(size));
        }
        long j7 = 0;
        while (true) {
            long j8 = (segment.limit - segment.pos) + j7;
            if (j8 > j6) {
                return (T) pVar.invoke(segment, Long.valueOf(j7));
            }
            segment = segment.next;
            l.b(segment);
            j7 = j8;
        }
    }

    public static final int selectPrefix(Buffer buffer, Options options, boolean z5) {
        int i6;
        int i7;
        int i8;
        int i9;
        Segment segment;
        l.d(buffer, "<this>");
        l.d(options, "options");
        Segment segment2 = buffer.head;
        if (segment2 == null) {
            return z5 ? -2 : -1;
        }
        byte[] bArr = segment2.data;
        int i10 = segment2.pos;
        int i11 = segment2.limit;
        int[] trie$okio = options.getTrie$okio();
        Segment segment3 = segment2;
        int i12 = 0;
        int i13 = -1;
        loop0: while (true) {
            int i14 = i12 + 1;
            int i15 = trie$okio[i12];
            int i16 = i14 + 1;
            int i17 = trie$okio[i14];
            if (i17 != -1) {
                i13 = i17;
            }
            if (segment3 == null) {
                break;
            }
            if (i15 >= 0) {
                i6 = i10 + 1;
                int i18 = bArr[i10] & 255;
                int i19 = i16 + i15;
                while (i16 != i19) {
                    if (i18 == trie$okio[i16]) {
                        i7 = trie$okio[i16 + i15];
                        if (i6 == i11) {
                            segment3 = segment3.next;
                            l.b(segment3);
                            i6 = segment3.pos;
                            bArr = segment3.data;
                            i11 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                    } else {
                        i16++;
                    }
                }
                return i13;
            }
            int i20 = i16 + (i15 * (-1));
            while (true) {
                int i21 = i10 + 1;
                int i22 = i16 + 1;
                if ((bArr[i10] & 255) != trie$okio[i16]) {
                    return i13;
                }
                boolean z6 = i22 == i20;
                if (i21 == i11) {
                    l.b(segment3);
                    Segment segment4 = segment3.next;
                    l.b(segment4);
                    i9 = segment4.pos;
                    byte[] bArr2 = segment4.data;
                    i8 = segment4.limit;
                    if (segment4 != segment2) {
                        segment = segment4;
                        bArr = bArr2;
                    } else if (!z6) {
                        break loop0;
                    } else {
                        bArr = bArr2;
                        segment = null;
                    }
                } else {
                    Segment segment5 = segment3;
                    i8 = i11;
                    i9 = i21;
                    segment = segment5;
                }
                if (z6) {
                    i7 = trie$okio[i22];
                    i6 = i9;
                    i11 = i8;
                    segment3 = segment;
                    break;
                }
                i10 = i9;
                i11 = i8;
                i16 = i22;
                segment3 = segment;
            }
            if (i7 >= 0) {
                return i7;
            }
            i12 = -i7;
            i10 = i6;
        }
        if (z5) {
            return -2;
        }
        return i13;
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return selectPrefix(buffer, options, z5);
    }

    public static final long commonIndexOf(Buffer buffer, ByteString byteString, long j6) {
        long j7;
        long j8;
        long j9 = j6;
        l.d(buffer, "<this>");
        l.d(byteString, "bytes");
        if (byteString.size() > 0) {
            long j10 = 0;
            if (!(j9 >= 0)) {
                throw new IllegalArgumentException(("fromIndex < 0: " + j9).toString());
            }
            Segment segment = buffer.head;
            if (segment == null) {
                return -1L;
            }
            if (buffer.size() - j9 < j9) {
                j7 = buffer.size();
                while (j7 > j9) {
                    segment = segment.prev;
                    l.b(segment);
                    j7 -= segment.limit - segment.pos;
                }
                byte[] internalArray$okio = byteString.internalArray$okio();
                byte b6 = internalArray$okio[0];
                int size = byteString.size();
                long size2 = (buffer.size() - size) + 1;
                while (j7 < size2) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min(segment.limit, (segment.pos + size2) - j7);
                    for (int i6 = (int) ((segment.pos + j9) - j7); i6 < min; i6++) {
                        if (bArr[i6] == b6 && rangeEquals(segment, i6 + 1, internalArray$okio, 1, size)) {
                            j8 = i6 - segment.pos;
                        }
                    }
                    j7 += segment.limit - segment.pos;
                    segment = segment.next;
                    l.b(segment);
                    j9 = j7;
                }
                return -1L;
            }
            while (true) {
                long j11 = (segment.limit - segment.pos) + j10;
                if (j11 > j9) {
                    break;
                }
                segment = segment.next;
                l.b(segment);
                j10 = j11;
            }
            byte[] internalArray$okio2 = byteString.internalArray$okio();
            byte b7 = internalArray$okio2[0];
            int size3 = byteString.size();
            long size4 = (buffer.size() - size3) + 1;
            j7 = j10;
            while (j7 < size4) {
                byte[] bArr2 = segment.data;
                long j12 = j9;
                int min2 = (int) Math.min(segment.limit, (segment.pos + size4) - j7);
                for (int i7 = (int) ((segment.pos + j12) - j7); i7 < min2; i7++) {
                    if (bArr2[i7] == b7 && rangeEquals(segment, i7 + 1, internalArray$okio2, 1, size3)) {
                        j8 = i7 - segment.pos;
                    }
                }
                j7 += segment.limit - segment.pos;
                segment = segment.next;
                l.b(segment);
                j9 = j7;
            }
            return -1L;
            return j8 + j7;
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    public static final int commonRead(Buffer buffer, byte[] bArr, int i6, int i7) {
        l.d(buffer, "<this>");
        l.d(bArr, "sink");
        _UtilKt.checkOffsetAndCount(bArr.length, i6, i7);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i7, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i8 = segment.pos;
        i.d(bArr2, bArr, i6, i8, i8 + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - min);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public static final byte[] commonReadByteArray(Buffer buffer, long j6) {
        l.d(buffer, "<this>");
        if (!(j6 >= 0 && j6 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        } else if (buffer.size() >= j6) {
            byte[] bArr = new byte[(int) j6];
            buffer.readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public static final ByteString commonReadByteString(Buffer buffer, long j6) {
        l.d(buffer, "<this>");
        if (!(j6 >= 0 && j6 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        } else if (buffer.size() >= j6) {
            if (j6 >= 4096) {
                ByteString snapshot = buffer.snapshot((int) j6);
                buffer.skip(j6);
                return snapshot;
            }
            return new ByteString(buffer.readByteArray(j6));
        } else {
            throw new EOFException();
        }
    }

    public static final void commonReadFully(Buffer buffer, byte[] bArr) {
        l.d(buffer, "<this>");
        l.d(bArr, "sink");
        int i6 = 0;
        while (i6 < bArr.length) {
            int read = buffer.read(bArr, i6, bArr.length - i6);
            if (read == -1) {
                throw new EOFException();
            }
            i6 += read;
        }
    }

    public static final ByteString commonSnapshot(Buffer buffer, int i6) {
        l.d(buffer, "<this>");
        if (i6 == 0) {
            return ByteString.EMPTY;
        }
        _UtilKt.checkOffsetAndCount(buffer.size(), 0L, i6);
        Segment segment = buffer.head;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            l.b(segment);
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
        Segment segment2 = buffer.head;
        int i12 = 0;
        while (i7 < i6) {
            l.b(segment2);
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

    public static final Buffer commonWrite(Buffer buffer, Source source, long j6) {
        l.d(buffer, "<this>");
        l.d(source, "source");
        while (j6 > 0) {
            long read = source.read(buffer, j6);
            if (read == -1) {
                throw new EOFException();
            }
            j6 -= read;
        }
        return buffer;
    }

    public static final long commonRead(Buffer buffer, Buffer buffer2, long j6) {
        l.d(buffer, "<this>");
        l.d(buffer2, "sink");
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        } else if (buffer.size() == 0) {
            return -1L;
        } else {
            if (j6 > buffer.size()) {
                j6 = buffer.size();
            }
            buffer2.write(buffer, j6);
            return j6;
        }
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr) {
        l.d(buffer, "<this>");
        l.d(bArr, "source");
        return buffer.write(bArr, 0, bArr.length);
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr, int i6, int i7) {
        l.d(buffer, "<this>");
        l.d(bArr, "source");
        long j6 = i7;
        _UtilKt.checkOffsetAndCount(bArr.length, i6, j6);
        int i8 = i7 + i6;
        while (i6 < i8) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i8 - i6, 8192 - writableSegment$okio.limit);
            int i9 = i6 + min;
            i.d(bArr, writableSegment$okio.data, writableSegment$okio.limit, i6, i9);
            writableSegment$okio.limit += min;
            i6 = i9;
        }
        buffer.setSize$okio(buffer.size() + j6);
        return buffer;
    }

    public static final void commonWrite(Buffer buffer, Buffer buffer2, long j6) {
        Segment segment;
        Segment segment2;
        l.d(buffer, "<this>");
        l.d(buffer2, "source");
        if (!(buffer2 != buffer)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        _UtilKt.checkOffsetAndCount(buffer2.size(), 0L, j6);
        while (j6 > 0) {
            Segment segment3 = buffer2.head;
            l.b(segment3);
            int i6 = segment3.limit;
            l.b(buffer2.head);
            if (j6 < i6 - segment.pos) {
                Segment segment4 = buffer.head;
                if (segment4 != null) {
                    l.b(segment4);
                    segment2 = segment4.prev;
                } else {
                    segment2 = null;
                }
                if (segment2 != null && segment2.owner) {
                    if ((segment2.limit + j6) - (segment2.shared ? 0 : segment2.pos) <= 8192) {
                        Segment segment5 = buffer2.head;
                        l.b(segment5);
                        segment5.writeTo(segment2, (int) j6);
                        buffer2.setSize$okio(buffer2.size() - j6);
                        buffer.setSize$okio(buffer.size() + j6);
                        return;
                    }
                }
                Segment segment6 = buffer2.head;
                l.b(segment6);
                buffer2.head = segment6.split((int) j6);
            }
            Segment segment7 = buffer2.head;
            l.b(segment7);
            long j7 = segment7.limit - segment7.pos;
            buffer2.head = segment7.pop();
            Segment segment8 = buffer.head;
            if (segment8 == null) {
                buffer.head = segment7;
                segment7.prev = segment7;
                segment7.next = segment7;
            } else {
                l.b(segment8);
                Segment segment9 = segment8.prev;
                l.b(segment9);
                segment9.push(segment7).compact();
            }
            buffer2.setSize$okio(buffer2.size() - j7);
            buffer.setSize$okio(buffer.size() + j7);
            j6 -= j7;
        }
    }
}
