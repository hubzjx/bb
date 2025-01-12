package okio;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.internal._SegmentedByteStringKt;
/* loaded from: classes.dex */
public final class SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.EMPTY.getData$okio());
        kotlin.jvm.internal.l.d(bArr, "segments");
        kotlin.jvm.internal.l.d(iArr, "directory");
        this.segments = bArr;
        this.directory = iArr;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        return toByteString();
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        kotlin.jvm.internal.l.c(asReadOnlyBuffer, "wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public void copyInto(int i6, byte[] bArr, int i7, int i8) {
        kotlin.jvm.internal.l.d(bArr, "target");
        long j6 = i8;
        _UtilKt.checkOffsetAndCount(size(), i6, j6);
        _UtilKt.checkOffsetAndCount(bArr.length, i7, j6);
        int i9 = i8 + i6;
        int segment = _SegmentedByteStringKt.segment(this, i6);
        while (i6 < i9) {
            int i10 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i11 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i9, (getDirectory$okio()[segment] - i10) + i10) - i6;
            int i12 = i11 + (i6 - i10);
            kotlin.collections.i.d(getSegments$okio()[segment], bArr, i7, i12, i12 + min);
            i7 += min;
            i6 += min;
            segment++;
        }
    }

    @Override // okio.ByteString
    public ByteString digest$okio(String str) {
        kotlin.jvm.internal.l.d(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = getSegments$okio().length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = getDirectory$okio()[length + i6];
            int i9 = getDirectory$okio()[i6];
            messageDigest.update(getSegments$okio()[i6], i8, i9 - i7);
            i6++;
            i7 = i9;
        }
        byte[] digest = messageDigest.digest();
        kotlin.jvm.internal.l.c(digest, "digestBytes");
        return new ByteString(digest);
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i6 = 0;
        int i7 = 1;
        int i8 = 0;
        while (i6 < length) {
            int i9 = getDirectory$okio()[length + i6];
            int i10 = getDirectory$okio()[i6];
            byte[] bArr = getSegments$okio()[i6];
            int i11 = (i10 - i8) + i9;
            while (i9 < i11) {
                i7 = (i7 * 31) + bArr[i9];
                i9++;
            }
            i6++;
            i8 = i10;
        }
        setHashCode$okio(i7);
        return i7;
    }

    @Override // okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public ByteString hmac$okio(String str, ByteString byteString) {
        kotlin.jvm.internal.l.d(str, "algorithm");
        kotlin.jvm.internal.l.d(byteString, "key");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            int length = getSegments$okio().length;
            int i6 = 0;
            int i7 = 0;
            while (i6 < length) {
                int i8 = getDirectory$okio()[length + i6];
                int i9 = getDirectory$okio()[i6];
                mac.update(getSegments$okio()[i6], i8, i9 - i7);
                i6++;
                i7 = i9;
            }
            byte[] doFinal = mac.doFinal();
            kotlin.jvm.internal.l.c(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    @Override // okio.ByteString
    public int indexOf(byte[] bArr, int i6) {
        kotlin.jvm.internal.l.d(bArr, "other");
        return toByteString().indexOf(bArr, i6);
    }

    @Override // okio.ByteString
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int i6) {
        _UtilKt.checkOffsetAndCount(getDirectory$okio()[getSegments$okio().length - 1], i6, 1L);
        int segment = _SegmentedByteStringKt.segment(this, i6);
        return getSegments$okio()[segment][(i6 - (segment == 0 ? 0 : getDirectory$okio()[segment - 1])) + getDirectory$okio()[getSegments$okio().length + segment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] bArr, int i6) {
        kotlin.jvm.internal.l.d(bArr, "other");
        return toByteString().lastIndexOf(bArr, i6);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i6, ByteString byteString, int i7, int i8) {
        kotlin.jvm.internal.l.d(byteString, "other");
        if (i6 < 0 || i6 > size() - i8) {
            return false;
        }
        int i9 = i8 + i6;
        int segment = _SegmentedByteStringKt.segment(this, i6);
        while (i6 < i9) {
            int i10 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i11 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i9, (getDirectory$okio()[segment] - i10) + i10) - i6;
            if (!byteString.rangeEquals(i7, getSegments$okio()[segment], i11 + (i6 - i10), min)) {
                return false;
            }
            i7 += min;
            i6 += min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        kotlin.jvm.internal.l.d(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    public ByteString substring(int i6, int i7) {
        Object[] i8;
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(this, i7);
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i6 + " < 0").toString());
        }
        if (!(resolveDefaultParameter <= size())) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + size() + ')').toString());
        }
        int i9 = resolveDefaultParameter - i6;
        if (!(i9 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i6).toString());
        } else if (i6 == 0 && resolveDefaultParameter == size()) {
            return this;
        } else {
            if (i6 == resolveDefaultParameter) {
                return ByteString.EMPTY;
            }
            int segment = _SegmentedByteStringKt.segment(this, i6);
            int segment2 = _SegmentedByteStringKt.segment(this, resolveDefaultParameter - 1);
            i8 = kotlin.collections.i.i(getSegments$okio(), segment, segment2 + 1);
            byte[][] bArr = (byte[][]) i8;
            int[] iArr = new int[bArr.length * 2];
            if (segment <= segment2) {
                int i10 = segment;
                int i11 = 0;
                while (true) {
                    iArr[i11] = Math.min(getDirectory$okio()[i10] - i6, i9);
                    int i12 = i11 + 1;
                    iArr[i11 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i10];
                    if (i10 == segment2) {
                        break;
                    }
                    i10++;
                    i11 = i12;
                }
            }
            int i13 = segment != 0 ? getDirectory$okio()[segment - 1] : 0;
            int length = bArr.length;
            iArr[length] = iArr[length] + (i6 - i13);
            return new SegmentedByteString(bArr, iArr);
        }
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < length) {
            int i9 = getDirectory$okio()[length + i6];
            int i10 = getDirectory$okio()[i6];
            int i11 = i10 - i7;
            kotlin.collections.i.d(getSegments$okio()[i6], bArr, i8, i9, i9 + i11);
            i8 += i11;
            i6++;
            i7 = i10;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(OutputStream outputStream) {
        kotlin.jvm.internal.l.d(outputStream, "out");
        int length = getSegments$okio().length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = getDirectory$okio()[length + i6];
            int i9 = getDirectory$okio()[i6];
            outputStream.write(getSegments$okio()[i6], i8, i9 - i7);
            i6++;
            i7 = i9;
        }
    }

    @Override // okio.ByteString
    public void write$okio(Buffer buffer, int i6, int i7) {
        kotlin.jvm.internal.l.d(buffer, "buffer");
        int i8 = i6 + i7;
        int segment = _SegmentedByteStringKt.segment(this, i6);
        while (i6 < i8) {
            int i9 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i10 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i8, (getDirectory$okio()[segment] - i9) + i9) - i6;
            int i11 = i10 + (i6 - i9);
            Segment segment2 = new Segment(getSegments$okio()[segment], i11, i11 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                kotlin.jvm.internal.l.b(segment3);
                Segment segment4 = segment3.prev;
                kotlin.jvm.internal.l.b(segment4);
                segment4.push(segment2);
            }
            i6 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + i7);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i6, byte[] bArr, int i7, int i8) {
        kotlin.jvm.internal.l.d(bArr, "other");
        if (i6 < 0 || i6 > size() - i8 || i7 < 0 || i7 > bArr.length - i8) {
            return false;
        }
        int i9 = i8 + i6;
        int segment = _SegmentedByteStringKt.segment(this, i6);
        while (i6 < i9) {
            int i10 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i11 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i9, (getDirectory$okio()[segment] - i10) + i10) - i6;
            if (!_UtilKt.arrayRangeEquals(getSegments$okio()[segment], i11 + (i6 - i10), bArr, i7, min)) {
                return false;
            }
            i7 += min;
            i6 += min;
            segment++;
        }
        return true;
    }
}
