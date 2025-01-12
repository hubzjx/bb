package okio.internal;

import b.j;
import java.util.Arrays;
import kotlin.collections.i;
import kotlin.jvm.internal.l;
import kotlin.text.w;
import okio.Buffer;
import okio.ByteString;
import okio._Base64Kt;
import okio._JvmPlatformKt;
import okio._UtilKt;
/* loaded from: classes.dex */
public final class _ByteStringKt {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Removed duplicated region for block: B:553:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:556:0x007a A[EDGE_INSN: B:556:0x007a->B:350:0x007a ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:563:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:577:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:581:0x01f8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int codePointIndexToCharIndex(byte[] bArr, int i6) {
        byte b6;
        boolean z5;
        boolean z6;
        int i7;
        boolean z7;
        boolean z8;
        boolean z9;
        int length = bArr.length;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        loop0: while (i8 < length) {
            byte b7 = bArr[i8];
            if (b7 >= 0) {
                int i11 = i10 + 1;
                if (i10 == i6) {
                    return i9;
                }
                if (b7 != 10 && b7 != 13) {
                    if (!(b7 >= 0 && b7 < 32)) {
                        if (!(Byte.MAX_VALUE <= b7 && b7 < 160)) {
                            z6 = false;
                            if (z6) {
                                return -1;
                            }
                        }
                    }
                    z6 = true;
                    if (z6) {
                    }
                }
                if (b7 == 65533) {
                    return -1;
                }
                i9 += b7 < 65536 ? 1 : 2;
                i8++;
                while (true) {
                    i10 = i11;
                    if (i8 < length && (b6 = bArr[i8]) >= 0) {
                        i8++;
                        i11 = i10 + 1;
                        if (i10 == i6) {
                            return i9;
                        }
                        if (b6 != 10 && b6 != 13) {
                            if (!(b6 >= 0 && b6 < 32)) {
                                if (!(Byte.MAX_VALUE <= b6 && b6 < 160)) {
                                    z5 = false;
                                    if (z5) {
                                        break loop0;
                                    }
                                }
                            }
                            z5 = true;
                            if (z5) {
                            }
                        }
                        if (b6 == 65533) {
                            break loop0;
                        }
                        i9 += b6 < 65536 ? 1 : 2;
                    }
                }
                return -1;
            }
            if ((b7 >> 5) == -2) {
                int i12 = i8 + 1;
                if (length <= i12) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                }
                byte b8 = bArr[i12];
                if (!((b8 & 192) == 128)) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                }
                int i13 = (b8 ^ 3968) ^ (b7 << 6);
                if (i13 < 128) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                }
                i7 = i10 + 1;
                if (i10 == i6) {
                    return i9;
                }
                if (i13 != 10 && i13 != 13) {
                    if (!(i13 >= 0 && i13 < 32)) {
                        if (!(127 <= i13 && i13 < 160)) {
                            z9 = false;
                            if (z9) {
                                return -1;
                            }
                        }
                    }
                    z9 = true;
                    if (z9) {
                    }
                }
                if (i13 == 65533) {
                    return -1;
                }
                i9 += i13 < 65536 ? 1 : 2;
                i8 += 2;
            } else if ((b7 >> 4) == -2) {
                int i14 = i8 + 2;
                if (length <= i14) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                }
                byte b9 = bArr[i8 + 1];
                if (!((b9 & 192) == 128)) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                }
                byte b10 = bArr[i14];
                if (!((b10 & 192) == 128)) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                }
                int i15 = ((b10 ^ (-123008)) ^ (b9 << 6)) ^ (b7 << 12);
                if (i15 < 2048) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                }
                if (55296 <= i15 && i15 < 57344) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                }
                i7 = i10 + 1;
                if (i10 == i6) {
                    return i9;
                }
                if (i15 != 10 && i15 != 13) {
                    if (!(i15 >= 0 && i15 < 32)) {
                        if (!(127 <= i15 && i15 < 160)) {
                            z8 = false;
                            if (z8) {
                                return -1;
                            }
                        }
                    }
                    z8 = true;
                    if (z8) {
                    }
                }
                if (i15 == 65533) {
                    return -1;
                }
                i9 += i15 < 65536 ? 1 : 2;
                i8 += 3;
            } else if ((b7 >> 3) != -2) {
                if (i10 == i6) {
                    return i9;
                }
                return -1;
            } else {
                int i16 = i8 + 3;
                if (length <= i16) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                }
                byte b11 = bArr[i8 + 1];
                if (!((b11 & 192) == 128)) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                }
                byte b12 = bArr[i8 + 2];
                if (!((b12 & 192) == 128)) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                }
                byte b13 = bArr[i16];
                if (!((b13 & 192) == 128)) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                }
                int i17 = (((b13 ^ 3678080) ^ (b12 << 6)) ^ (b11 << 12)) ^ (b7 << 18);
                if (i17 > 1114111) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                }
                if (55296 <= i17 && i17 < 57344) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                } else if (i17 < 65536) {
                    if (i10 == i6) {
                        return i9;
                    }
                    return -1;
                } else {
                    i7 = i10 + 1;
                    if (i10 == i6) {
                        return i9;
                    }
                    if (i17 != 10 && i17 != 13) {
                        if (!(i17 >= 0 && i17 < 32)) {
                            if (!(127 <= i17 && i17 < 160)) {
                                z7 = false;
                                if (z7) {
                                    return -1;
                                }
                            }
                        }
                        z7 = true;
                        if (z7) {
                        }
                    }
                    if (i17 == 65533) {
                        return -1;
                    }
                    i9 += i17 < 65536 ? 1 : 2;
                    i8 += 4;
                }
            }
            i10 = i7;
        }
        return i9;
    }

    public static final String commonBase64(ByteString byteString) {
        l.d(byteString, "<this>");
        return _Base64Kt.encodeBase64$default(byteString.getData$okio(), null, 1, null);
    }

    public static final String commonBase64Url(ByteString byteString) {
        l.d(byteString, "<this>");
        return _Base64Kt.encodeBase64(byteString.getData$okio(), _Base64Kt.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(ByteString byteString, ByteString byteString2) {
        l.d(byteString, "<this>");
        l.d(byteString2, "other");
        int size = byteString.size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        for (int i6 = 0; i6 < min; i6++) {
            int i7 = byteString.getByte(i6) & 255;
            int i8 = byteString2.getByte(i6) & 255;
            if (i7 != i8) {
                return i7 < i8 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public static final void commonCopyInto(ByteString byteString, int i6, byte[] bArr, int i7, int i8) {
        l.d(byteString, "<this>");
        l.d(bArr, "target");
        i.d(byteString.getData$okio(), bArr, i7, i6, i8 + i6);
    }

    public static final ByteString commonDecodeBase64(String str) {
        l.d(str, "<this>");
        byte[] decodeBase64ToArray = _Base64Kt.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    public static final ByteString commonDecodeHex(String str) {
        l.d(str, "<this>");
        if (!(str.length() % 2 == 0)) {
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 * 2;
            bArr[i6] = (byte) ((decodeHexDigit(str.charAt(i7)) << 4) + decodeHexDigit(str.charAt(i7 + 1)));
        }
        return new ByteString(bArr);
    }

    public static final ByteString commonEncodeUtf8(String str) {
        l.d(str, "<this>");
        ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(ByteString byteString, ByteString byteString2) {
        l.d(byteString, "<this>");
        l.d(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEquals(ByteString byteString, Object obj) {
        l.d(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(ByteString byteString, int i6) {
        l.d(byteString, "<this>");
        return byteString.getData$okio()[i6];
    }

    public static final int commonGetSize(ByteString byteString) {
        l.d(byteString, "<this>");
        return byteString.getData$okio().length;
    }

    public static final int commonHashCode(ByteString byteString) {
        l.d(byteString, "<this>");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    public static final String commonHex(ByteString byteString) {
        byte[] data$okio;
        String h6;
        l.d(byteString, "<this>");
        char[] cArr = new char[byteString.getData$okio().length * 2];
        int i6 = 0;
        for (byte b6 : byteString.getData$okio()) {
            int i7 = i6 + 1;
            cArr[i6] = getHEX_DIGIT_CHARS()[(b6 >> 4) & 15];
            i6 = i7 + 1;
            cArr[i7] = getHEX_DIGIT_CHARS()[b6 & 15];
        }
        h6 = w.h(cArr);
        return h6;
    }

    public static final int commonIndexOf(ByteString byteString, byte[] bArr, int i6) {
        l.d(byteString, "<this>");
        l.d(bArr, "other");
        int length = byteString.getData$okio().length - bArr.length;
        int max = Math.max(i6, 0);
        if (max <= length) {
            while (!_UtilKt.arrayRangeEquals(byteString.getData$okio(), max, bArr, 0, bArr.length)) {
                if (max == length) {
                    return -1;
                }
                max++;
            }
            return max;
        }
        return -1;
    }

    public static final byte[] commonInternalArray(ByteString byteString) {
        l.d(byteString, "<this>");
        return byteString.getData$okio();
    }

    public static final int commonLastIndexOf(ByteString byteString, ByteString byteString2, int i6) {
        l.d(byteString, "<this>");
        l.d(byteString2, "other");
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i6);
    }

    public static final ByteString commonOf(byte[] bArr) {
        l.d(bArr, "data");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        l.c(copyOf, "copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(ByteString byteString, int i6, ByteString byteString2, int i7, int i8) {
        l.d(byteString, "<this>");
        l.d(byteString2, "other");
        return byteString2.rangeEquals(i7, byteString.getData$okio(), i6, i8);
    }

    public static final boolean commonStartsWith(ByteString byteString, ByteString byteString2) {
        l.d(byteString, "<this>");
        l.d(byteString2, "prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    public static final ByteString commonSubstring(ByteString byteString, int i6, int i7) {
        byte[] h6;
        l.d(byteString, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString, i7);
        if (i6 >= 0) {
            if (!(resolveDefaultParameter <= byteString.getData$okio().length)) {
                throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
            }
            if (resolveDefaultParameter - i6 >= 0) {
                if (i6 == 0 && resolveDefaultParameter == byteString.getData$okio().length) {
                    return byteString;
                }
                h6 = i.h(byteString.getData$okio(), i6, resolveDefaultParameter);
                return new ByteString(h6);
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    public static final ByteString commonToAsciiLowercase(ByteString byteString) {
        byte b6;
        l.d(byteString, "<this>");
        for (int i6 = 0; i6 < byteString.getData$okio().length; i6++) {
            byte b7 = byteString.getData$okio()[i6];
            byte b8 = (byte) 65;
            if (b7 >= b8 && b7 <= (b6 = (byte) 90)) {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                l.c(copyOf, "copyOf(this, size)");
                copyOf[i6] = (byte) (b7 + 32);
                for (int i7 = i6 + 1; i7 < copyOf.length; i7++) {
                    byte b9 = copyOf[i7];
                    if (b9 >= b8 && b9 <= b6) {
                        copyOf[i7] = (byte) (b9 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final ByteString commonToAsciiUppercase(ByteString byteString) {
        byte b6;
        l.d(byteString, "<this>");
        for (int i6 = 0; i6 < byteString.getData$okio().length; i6++) {
            byte b7 = byteString.getData$okio()[i6];
            byte b8 = (byte) 97;
            if (b7 >= b8 && b7 <= (b6 = (byte) j.L0)) {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                l.c(copyOf, "copyOf(this, size)");
                copyOf[i6] = (byte) (b7 - 32);
                for (int i7 = i6 + 1; i7 < copyOf.length; i7++) {
                    byte b9 = copyOf[i7];
                    if (b9 >= b8 && b9 <= b6) {
                        copyOf[i7] = (byte) (b9 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final byte[] commonToByteArray(ByteString byteString) {
        l.d(byteString, "<this>");
        byte[] data$okio = byteString.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        l.c(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public static final ByteString commonToByteString(byte[] bArr, int i6, int i7) {
        byte[] h6;
        l.d(bArr, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(bArr, i7);
        _UtilKt.checkOffsetAndCount(bArr.length, i6, resolveDefaultParameter);
        h6 = i.h(bArr, i6, resolveDefaultParameter + i6);
        return new ByteString(h6);
    }

    public static final String commonToString(ByteString byteString) {
        String u5;
        String u6;
        String u7;
        StringBuilder sb;
        byte[] h6;
        ByteString byteString2 = byteString;
        l.d(byteString2, "<this>");
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (codePointIndexToCharIndex != -1) {
            String utf8 = byteString.utf8();
            String substring = utf8.substring(0, codePointIndexToCharIndex);
            l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            u5 = w.u(substring, "\\", "\\\\", false, 4, null);
            u6 = w.u(u5, "\n", "\\n", false, 4, null);
            u7 = w.u(u6, "\r", "\\r", false, 4, null);
            if (codePointIndexToCharIndex >= utf8.length()) {
                return "[text=" + u7 + ']';
            }
            return "[size=" + byteString.getData$okio().length + " text=" + u7 + "…]";
        }
        if (byteString.getData$okio().length <= 64) {
            sb = new StringBuilder();
            sb.append("[hex=");
            sb.append(byteString.hex());
            sb.append(']');
        } else {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(byteString.getData$okio().length);
            sb.append(" hex=");
            int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString2, 64);
            if (!(resolveDefaultParameter <= byteString.getData$okio().length)) {
                throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
            }
            if (!(resolveDefaultParameter + 0 >= 0)) {
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            if (resolveDefaultParameter != byteString.getData$okio().length) {
                h6 = i.h(byteString.getData$okio(), 0, resolveDefaultParameter);
                byteString2 = new ByteString(h6);
            }
            sb.append(byteString2.hex());
            sb.append("…]");
        }
        return sb.toString();
    }

    public static final String commonUtf8(ByteString byteString) {
        l.d(byteString, "<this>");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio == null) {
            String utf8String = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
            byteString.setUtf8$okio(utf8String);
            return utf8String;
        }
        return utf8$okio;
    }

    public static final void commonWrite(ByteString byteString, Buffer buffer, int i6, int i7) {
        l.d(byteString, "<this>");
        l.d(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i6, i7);
    }

    public static final int decodeHexDigit(char c6) {
        boolean z5 = true;
        if ('0' <= c6 && c6 < ':') {
            return c6 - '0';
        }
        char c7 = 'a';
        if (!('a' <= c6 && c6 < 'g')) {
            c7 = 'A';
            if (!(('A' > c6 || c6 >= 'G') ? false : false)) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c6);
            }
        }
        return (c6 - c7) + 10;
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }

    public static final boolean commonEndsWith(ByteString byteString, byte[] bArr) {
        l.d(byteString, "<this>");
        l.d(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonLastIndexOf(ByteString byteString, byte[] bArr, int i6) {
        l.d(byteString, "<this>");
        l.d(bArr, "other");
        for (int min = Math.min(_UtilKt.resolveDefaultParameter(byteString, i6), byteString.getData$okio().length - bArr.length); -1 < min; min--) {
            if (_UtilKt.arrayRangeEquals(byteString.getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(ByteString byteString, int i6, byte[] bArr, int i7, int i8) {
        l.d(byteString, "<this>");
        l.d(bArr, "other");
        return i6 >= 0 && i6 <= byteString.getData$okio().length - i8 && i7 >= 0 && i7 <= bArr.length - i8 && _UtilKt.arrayRangeEquals(byteString.getData$okio(), i6, bArr, i7, i8);
    }

    public static final boolean commonStartsWith(ByteString byteString, byte[] bArr) {
        l.d(byteString, "<this>");
        l.d(bArr, "prefix");
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }
}
