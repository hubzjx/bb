package okio.internal;

import androidx.constraintlayout.widget.g;
import java.io.EOFException;
import kotlin.jvm.internal.l;
import kotlin.text.b;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Timeout;
import okio._UtilKt;
/* loaded from: classes.dex */
public final class _RealBufferedSourceKt {
    public static final void commonClose(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        if (realBufferedSource.closed) {
            return;
        }
        realBufferedSource.closed = true;
        realBufferedSource.source.close();
        realBufferedSource.bufferField.clear();
    }

    public static final boolean commonExhausted(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        if (!realBufferedSource.closed) {
            return realBufferedSource.bufferField.exhausted() && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(RealBufferedSource realBufferedSource, byte b6, long j6, long j7) {
        l.d(realBufferedSource, "<this>");
        boolean z5 = true;
        if (!realBufferedSource.closed) {
            if (!((0 > j6 || j6 > j7) ? false : false)) {
                throw new IllegalArgumentException(("fromIndex=" + j6 + " toIndex=" + j7).toString());
            }
            while (j6 < j7) {
                long indexOf = realBufferedSource.bufferField.indexOf(b6, j6, j7);
                if (indexOf == -1) {
                    long size = realBufferedSource.bufferField.size();
                    if (size >= j7 || realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                        break;
                    }
                    j6 = Math.max(j6, size);
                } else {
                    return indexOf;
                }
            }
            return -1L;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOfElement(RealBufferedSource realBufferedSource, ByteString byteString, long j6) {
        l.d(realBufferedSource, "<this>");
        l.d(byteString, "targetBytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOfElement = realBufferedSource.bufferField.indexOfElement(byteString, j6);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
            j6 = Math.max(j6, size);
        }
    }

    public static final BufferedSource commonPeek(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        return Okio.buffer(new PeekSource(realBufferedSource));
    }

    public static final boolean commonRangeEquals(RealBufferedSource realBufferedSource, long j6, ByteString byteString, int i6, int i7) {
        l.d(realBufferedSource, "<this>");
        l.d(byteString, "bytes");
        if (!realBufferedSource.closed) {
            if (j6 < 0 || i6 < 0 || i7 < 0 || byteString.size() - i6 < i7) {
                return false;
            }
            for (int i8 = 0; i8 < i7; i8++) {
                long j7 = i8 + j6;
                if (!realBufferedSource.request(1 + j7) || realBufferedSource.bufferField.getByte(j7) != byteString.getByte(i6 + i8)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final int commonRead(RealBufferedSource realBufferedSource, byte[] bArr, int i6, int i7) {
        l.d(realBufferedSource, "<this>");
        l.d(bArr, "sink");
        long j6 = i7;
        _UtilKt.checkOffsetAndCount(bArr.length, i6, j6);
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
            return -1;
        }
        return realBufferedSource.bufferField.read(bArr, i6, (int) Math.min(j6, realBufferedSource.bufferField.size()));
    }

    public static final long commonReadAll(RealBufferedSource realBufferedSource, Sink sink) {
        Buffer buffer;
        l.d(realBufferedSource, "<this>");
        l.d(sink, "sink");
        long j6 = 0;
        while (true) {
            int i6 = (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) > (-1L) ? 1 : (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == (-1L) ? 0 : -1));
            buffer = realBufferedSource.bufferField;
            if (i6 == 0) {
                break;
            }
            long completeSegmentByteCount = buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j6 += completeSegmentByteCount;
                sink.write(realBufferedSource.bufferField, completeSegmentByteCount);
            }
        }
        if (buffer.size() > 0) {
            long size = j6 + realBufferedSource.bufferField.size();
            Buffer buffer2 = realBufferedSource.bufferField;
            sink.write(buffer2, buffer2.size());
            return size;
        }
        return j6;
    }

    public static final byte commonReadByte(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        return realBufferedSource.bufferField.readByte();
    }

    public static final byte[] commonReadByteArray(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    public static final ByteString commonReadByteString(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r9 == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append("Expected a digit or '-' but was 0x");
        r1 = kotlin.text.b.a(16);
        r1 = kotlin.text.b.a(r1);
        r1 = java.lang.Integer.toString(r8, r1);
        kotlin.jvm.internal.l.c(r1, "toString(this, checkRadix(radix))");
        r0.append(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005d, code lost:
        throw new java.lang.NumberFormatException(r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long commonReadDecimalLong(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        long j6 = 0;
        while (true) {
            long j7 = j6 + 1;
            if (!realBufferedSource.request(j7)) {
                break;
            }
            byte b6 = realBufferedSource.bufferField.getByte(j6);
            if ((b6 < ((byte) 48) || b6 > ((byte) 57)) && !(j6 == 0 && b6 == ((byte) 45))) {
                break;
            }
            j6 = j7;
        }
        return realBufferedSource.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(RealBufferedSource realBufferedSource, Buffer buffer, long j6) {
        l.d(realBufferedSource, "<this>");
        l.d(buffer, "sink");
        try {
            realBufferedSource.require(j6);
            realBufferedSource.bufferField.readFully(buffer, j6);
        } catch (EOFException e6) {
            buffer.writeAll(realBufferedSource.bufferField);
            throw e6;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(RealBufferedSource realBufferedSource) {
        byte b6;
        int a6;
        int a7;
        l.d(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        int i6 = 0;
        while (true) {
            int i7 = i6 + 1;
            if (!realBufferedSource.request(i7)) {
                break;
            }
            b6 = realBufferedSource.bufferField.getByte(i6);
            if ((b6 < ((byte) 48) || b6 > ((byte) 57)) && ((b6 < ((byte) 97) || b6 > ((byte) g.U0)) && (b6 < ((byte) 65) || b6 > ((byte) 70)))) {
                break;
            }
            i6 = i7;
        }
        if (i6 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            a6 = b.a(16);
            a7 = b.a(a6);
            String num = Integer.toString(b6, a7);
            l.c(num, "toString(this, checkRadix(radix))");
            sb.append(num);
            throw new NumberFormatException(sb.toString());
        }
        return realBufferedSource.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final short commonReadShort(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShortLe();
    }

    public static final String commonReadUtf8(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    public static final int commonReadUtf8CodePoint(RealBufferedSource realBufferedSource) {
        long j6;
        l.d(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        byte b6 = realBufferedSource.bufferField.getByte(0L);
        if ((b6 & 224) == 192) {
            j6 = 2;
        } else if ((b6 & 240) != 224) {
            if ((b6 & 248) == 240) {
                j6 = 4;
            }
            return realBufferedSource.bufferField.readUtf8CodePoint();
        } else {
            j6 = 3;
        }
        realBufferedSource.require(j6);
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    public static final String commonReadUtf8Line(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        long indexOf = realBufferedSource.indexOf((byte) 10);
        if (indexOf == -1) {
            if (realBufferedSource.bufferField.size() != 0) {
                return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
            }
            return null;
        }
        return _BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
    }

    public static final String commonReadUtf8LineStrict(RealBufferedSource realBufferedSource, long j6) {
        l.d(realBufferedSource, "<this>");
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j6).toString());
        }
        long j7 = j6 == Long.MAX_VALUE ? Long.MAX_VALUE : j6 + 1;
        byte b6 = (byte) 10;
        long indexOf = realBufferedSource.indexOf(b6, 0L, j7);
        if (indexOf != -1) {
            return _BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
        }
        if (j7 < Long.MAX_VALUE && realBufferedSource.request(j7) && realBufferedSource.bufferField.getByte(j7 - 1) == ((byte) 13) && realBufferedSource.request(1 + j7) && realBufferedSource.bufferField.getByte(j7) == b6) {
            return _BufferKt.readUtf8Line(realBufferedSource.bufferField, j7);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = realBufferedSource.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(realBufferedSource.bufferField.size(), j6) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    public static final boolean commonRequest(RealBufferedSource realBufferedSource, long j6) {
        l.d(realBufferedSource, "<this>");
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        } else if (!realBufferedSource.closed) {
            while (realBufferedSource.bufferField.size() < j6) {
                if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final void commonRequire(RealBufferedSource realBufferedSource, long j6) {
        l.d(realBufferedSource, "<this>");
        if (!realBufferedSource.request(j6)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(RealBufferedSource realBufferedSource, Options options) {
        l.d(realBufferedSource, "<this>");
        l.d(options, "options");
        if (!realBufferedSource.closed) {
            do {
                int selectPrefix = _BufferKt.selectPrefix(realBufferedSource.bufferField, options, true);
                if (selectPrefix != -2) {
                    if (selectPrefix != -1) {
                        realBufferedSource.bufferField.skip(options.getByteStrings$okio()[selectPrefix].size());
                        return selectPrefix;
                    }
                    return -1;
                }
            } while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) != -1);
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonSkip(RealBufferedSource realBufferedSource, long j6) {
        l.d(realBufferedSource, "<this>");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j6 > 0) {
            if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j6, realBufferedSource.bufferField.size());
            realBufferedSource.bufferField.skip(min);
            j6 -= min;
        }
    }

    public static final Timeout commonTimeout(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        return realBufferedSource.source.timeout();
    }

    public static final String commonToString(RealBufferedSource realBufferedSource) {
        l.d(realBufferedSource, "<this>");
        return "buffer(" + realBufferedSource.source + ')';
    }

    public static final long commonIndexOf(RealBufferedSource realBufferedSource, ByteString byteString, long j6) {
        l.d(realBufferedSource, "<this>");
        l.d(byteString, "bytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOf = realBufferedSource.bufferField.indexOf(byteString, j6);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
            j6 = Math.max(j6, (size - byteString.size()) + 1);
        }
    }

    public static final long commonRead(RealBufferedSource realBufferedSource, Buffer buffer, long j6) {
        l.d(realBufferedSource, "<this>");
        l.d(buffer, "sink");
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        } else if (true ^ realBufferedSource.closed) {
            if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
            return realBufferedSource.bufferField.read(buffer, Math.min(j6, realBufferedSource.bufferField.size()));
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final byte[] commonReadByteArray(RealBufferedSource realBufferedSource, long j6) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.require(j6);
        return realBufferedSource.bufferField.readByteArray(j6);
    }

    public static final ByteString commonReadByteString(RealBufferedSource realBufferedSource, long j6) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.require(j6);
        return realBufferedSource.bufferField.readByteString(j6);
    }

    public static final void commonReadFully(RealBufferedSource realBufferedSource, byte[] bArr) {
        l.d(realBufferedSource, "<this>");
        l.d(bArr, "sink");
        try {
            realBufferedSource.require(bArr.length);
            realBufferedSource.bufferField.readFully(bArr);
        } catch (EOFException e6) {
            int i6 = 0;
            while (realBufferedSource.bufferField.size() > 0) {
                Buffer buffer = realBufferedSource.bufferField;
                int read = buffer.read(bArr, i6, (int) buffer.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                i6 += read;
            }
            throw e6;
        }
    }

    public static final String commonReadUtf8(RealBufferedSource realBufferedSource, long j6) {
        l.d(realBufferedSource, "<this>");
        realBufferedSource.require(j6);
        return realBufferedSource.bufferField.readUtf8(j6);
    }
}
