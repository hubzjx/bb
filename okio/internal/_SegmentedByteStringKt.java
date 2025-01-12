package okio.internal;

import kotlin.collections.i;
import kotlin.jvm.internal.l;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio._UtilKt;
import p4.q;
/* loaded from: classes.dex */
public final class _SegmentedByteStringKt {
    public static final int binarySearch(int[] iArr, int i6, int i7, int i8) {
        l.d(iArr, "<this>");
        int i9 = i8 - 1;
        while (i7 <= i9) {
            int i10 = (i7 + i9) >>> 1;
            int i11 = iArr[i10];
            if (i11 < i6) {
                i7 = i10 + 1;
            } else if (i11 <= i6) {
                return i10;
            } else {
                i9 = i10 - 1;
            }
        }
        return (-i7) - 1;
    }

    public static final void commonCopyInto(SegmentedByteString segmentedByteString, int i6, byte[] bArr, int i7, int i8) {
        l.d(segmentedByteString, "<this>");
        l.d(bArr, "target");
        long j6 = i8;
        _UtilKt.checkOffsetAndCount(segmentedByteString.size(), i6, j6);
        _UtilKt.checkOffsetAndCount(bArr.length, i7, j6);
        int i9 = i8 + i6;
        int segment = segment(segmentedByteString, i6);
        while (i6 < i9) {
            int i10 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int i11 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i9, (segmentedByteString.getDirectory$okio()[segment] - i10) + i10) - i6;
            int i12 = i11 + (i6 - i10);
            i.d(segmentedByteString.getSegments$okio()[segment], bArr, i7, i12, i12 + min);
            i7 += min;
            i6 += min;
            segment++;
        }
    }

    public static final boolean commonEquals(SegmentedByteString segmentedByteString, Object obj) {
        l.d(segmentedByteString, "<this>");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(SegmentedByteString segmentedByteString) {
        l.d(segmentedByteString, "<this>");
        return segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(SegmentedByteString segmentedByteString) {
        l.d(segmentedByteString, "<this>");
        int hashCode$okio = segmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = segmentedByteString.getSegments$okio().length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        while (i6 < length) {
            int i9 = segmentedByteString.getDirectory$okio()[length + i6];
            int i10 = segmentedByteString.getDirectory$okio()[i6];
            byte[] bArr = segmentedByteString.getSegments$okio()[i6];
            int i11 = (i10 - i7) + i9;
            while (i9 < i11) {
                i8 = (i8 * 31) + bArr[i9];
                i9++;
            }
            i6++;
            i7 = i10;
        }
        segmentedByteString.setHashCode$okio(i8);
        return i8;
    }

    public static final byte commonInternalGet(SegmentedByteString segmentedByteString, int i6) {
        l.d(segmentedByteString, "<this>");
        _UtilKt.checkOffsetAndCount(segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1], i6, 1L);
        int segment = segment(segmentedByteString, i6);
        return segmentedByteString.getSegments$okio()[segment][(i6 - (segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1])) + segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment]];
    }

    public static final boolean commonRangeEquals(SegmentedByteString segmentedByteString, int i6, ByteString byteString, int i7, int i8) {
        l.d(segmentedByteString, "<this>");
        l.d(byteString, "other");
        if (i6 < 0 || i6 > segmentedByteString.size() - i8) {
            return false;
        }
        int i9 = i8 + i6;
        int segment = segment(segmentedByteString, i6);
        while (i6 < i9) {
            int i10 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int i11 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i9, (segmentedByteString.getDirectory$okio()[segment] - i10) + i10) - i6;
            if (!byteString.rangeEquals(i7, segmentedByteString.getSegments$okio()[segment], i11 + (i6 - i10), min)) {
                return false;
            }
            i7 += min;
            i6 += min;
            segment++;
        }
        return true;
    }

    public static final ByteString commonSubstring(SegmentedByteString segmentedByteString, int i6, int i7) {
        Object[] i8;
        l.d(segmentedByteString, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(segmentedByteString, i7);
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i6 + " < 0").toString());
        }
        if (!(resolveDefaultParameter <= segmentedByteString.size())) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + segmentedByteString.size() + ')').toString());
        }
        int i9 = resolveDefaultParameter - i6;
        if (!(i9 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i6).toString());
        } else if (i6 == 0 && resolveDefaultParameter == segmentedByteString.size()) {
            return segmentedByteString;
        } else {
            if (i6 == resolveDefaultParameter) {
                return ByteString.EMPTY;
            }
            int segment = segment(segmentedByteString, i6);
            int segment2 = segment(segmentedByteString, resolveDefaultParameter - 1);
            i8 = i.i(segmentedByteString.getSegments$okio(), segment, segment2 + 1);
            byte[][] bArr = (byte[][]) i8;
            int[] iArr = new int[bArr.length * 2];
            if (segment <= segment2) {
                int i10 = segment;
                int i11 = 0;
                while (true) {
                    iArr[i11] = Math.min(segmentedByteString.getDirectory$okio()[i10] - i6, i9);
                    int i12 = i11 + 1;
                    iArr[i11 + bArr.length] = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i10];
                    if (i10 == segment2) {
                        break;
                    }
                    i10++;
                    i11 = i12;
                }
            }
            int i13 = segment != 0 ? segmentedByteString.getDirectory$okio()[segment - 1] : 0;
            int length = bArr.length;
            iArr[length] = iArr[length] + (i6 - i13);
            return new SegmentedByteString(bArr, iArr);
        }
    }

    public static final byte[] commonToByteArray(SegmentedByteString segmentedByteString) {
        l.d(segmentedByteString, "<this>");
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments$okio().length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < length) {
            int i9 = segmentedByteString.getDirectory$okio()[length + i6];
            int i10 = segmentedByteString.getDirectory$okio()[i6];
            int i11 = i10 - i7;
            i.d(segmentedByteString.getSegments$okio()[i6], bArr, i8, i9, i9 + i11);
            i8 += i11;
            i6++;
            i7 = i10;
        }
        return bArr;
    }

    public static final void commonWrite(SegmentedByteString segmentedByteString, Buffer buffer, int i6, int i7) {
        l.d(segmentedByteString, "<this>");
        l.d(buffer, "buffer");
        int i8 = i6 + i7;
        int segment = segment(segmentedByteString, i6);
        while (i6 < i8) {
            int i9 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int i10 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i8, (segmentedByteString.getDirectory$okio()[segment] - i9) + i9) - i6;
            int i11 = i10 + (i6 - i9);
            Segment segment2 = new Segment(segmentedByteString.getSegments$okio()[segment], i11, i11 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                l.b(segment3);
                Segment segment4 = segment3.prev;
                l.b(segment4);
                segment4.push(segment2);
            }
            i6 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + i7);
    }

    private static final void forEachSegment(SegmentedByteString segmentedByteString, int i6, int i7, q qVar) {
        int segment = segment(segmentedByteString, i6);
        while (i6 < i7) {
            int i8 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int i9 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i7, (segmentedByteString.getDirectory$okio()[segment] - i8) + i8) - i6;
            qVar.b(segmentedByteString.getSegments$okio()[segment], Integer.valueOf(i9 + (i6 - i8)), Integer.valueOf(min));
            i6 += min;
            segment++;
        }
    }

    public static final int segment(SegmentedByteString segmentedByteString, int i6) {
        l.d(segmentedByteString, "<this>");
        int binarySearch = binarySearch(segmentedByteString.getDirectory$okio(), i6 + 1, 0, segmentedByteString.getSegments$okio().length);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    public static final boolean commonRangeEquals(SegmentedByteString segmentedByteString, int i6, byte[] bArr, int i7, int i8) {
        l.d(segmentedByteString, "<this>");
        l.d(bArr, "other");
        if (i6 < 0 || i6 > segmentedByteString.size() - i8 || i7 < 0 || i7 > bArr.length - i8) {
            return false;
        }
        int i9 = i8 + i6;
        int segment = segment(segmentedByteString, i6);
        while (i6 < i9) {
            int i10 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int i11 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i9, (segmentedByteString.getDirectory$okio()[segment] - i10) + i10) - i6;
            if (!_UtilKt.arrayRangeEquals(segmentedByteString.getSegments$okio()[segment], i11 + (i6 - i10), bArr, i7, min)) {
                return false;
            }
            i7 += min;
            i6 += min;
            segment++;
        }
        return true;
    }

    public static final void forEachSegment(SegmentedByteString segmentedByteString, q qVar) {
        l.d(segmentedByteString, "<this>");
        l.d(qVar, "action");
        int length = segmentedByteString.getSegments$okio().length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = segmentedByteString.getDirectory$okio()[length + i6];
            int i9 = segmentedByteString.getDirectory$okio()[i6];
            qVar.b(segmentedByteString.getSegments$okio()[i6], Integer.valueOf(i8), Integer.valueOf(i9 - i7));
            i6++;
            i7 = i9;
        }
    }
}
