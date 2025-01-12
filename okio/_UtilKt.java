package okio;

import kotlin.text.w;
import okio.Buffer;
import okio.internal._ByteStringKt;
/* loaded from: classes.dex */
public final class _UtilKt {
    private static final Buffer.UnsafeCursor DEFAULT__new_UnsafeCursor = new Buffer.UnsafeCursor();
    private static final int DEFAULT__ByteString_size = -1234567890;

    public static final int and(byte b6, int i6) {
        return b6 & i6;
    }

    public static final boolean arrayRangeEquals(byte[] bArr, int i6, byte[] bArr2, int i7, int i8) {
        kotlin.jvm.internal.l.d(bArr, "a");
        kotlin.jvm.internal.l.d(bArr2, "b");
        for (int i9 = 0; i9 < i8; i9++) {
            if (bArr[i9 + i6] != bArr2[i9 + i7]) {
                return false;
            }
        }
        return true;
    }

    public static final void checkOffsetAndCount(long j6, long j7, long j8) {
        if ((j7 | j8) < 0 || j7 > j6 || j6 - j7 < j8) {
            throw new ArrayIndexOutOfBoundsException("size=" + j6 + " offset=" + j7 + " byteCount=" + j8);
        }
    }

    public static final int getDEFAULT__ByteString_size() {
        return DEFAULT__ByteString_size;
    }

    public static final Buffer.UnsafeCursor getDEFAULT__new_UnsafeCursor() {
        return DEFAULT__new_UnsafeCursor;
    }

    public static /* synthetic */ void getDEFAULT__new_UnsafeCursor$annotations() {
    }

    public static final int leftRotate(int i6, int i7) {
        return (i6 >>> (32 - i7)) | (i6 << i7);
    }

    public static final long minOf(int i6, long j6) {
        return Math.min(i6, j6);
    }

    public static final int resolveDefaultParameter(ByteString byteString, int i6) {
        kotlin.jvm.internal.l.d(byteString, "<this>");
        return i6 == DEFAULT__ByteString_size ? byteString.size() : i6;
    }

    public static final int reverseBytes(int i6) {
        return ((i6 & 255) << 24) | (((-16777216) & i6) >>> 24) | ((16711680 & i6) >>> 8) | ((65280 & i6) << 8);
    }

    public static final long rightRotate(long j6, int i6) {
        return (j6 << (64 - i6)) | (j6 >>> i6);
    }

    public static final int shl(byte b6, int i6) {
        return b6 << i6;
    }

    public static final int shr(byte b6, int i6) {
        return b6 >> i6;
    }

    public static final String toHexString(byte b6) {
        String h6;
        h6 = w.h(new char[]{_ByteStringKt.getHEX_DIGIT_CHARS()[(b6 >> 4) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[b6 & 15]});
        return h6;
    }

    public static final byte xor(byte b6, byte b7) {
        return (byte) (b6 ^ b7);
    }

    public static final long and(byte b6, long j6) {
        return b6 & j6;
    }

    public static final long minOf(long j6, int i6) {
        return Math.min(j6, i6);
    }

    public static final int resolveDefaultParameter(byte[] bArr, int i6) {
        kotlin.jvm.internal.l.d(bArr, "<this>");
        return i6 == DEFAULT__ByteString_size ? bArr.length : i6;
    }

    public static final long reverseBytes(long j6) {
        return ((j6 & 255) << 56) | (((-72057594037927936L) & j6) >>> 56) | ((71776119061217280L & j6) >>> 40) | ((280375465082880L & j6) >>> 24) | ((1095216660480L & j6) >>> 8) | ((4278190080L & j6) << 8) | ((16711680 & j6) << 24) | ((65280 & j6) << 40);
    }

    public static final String toHexString(int i6) {
        String i7;
        if (i6 == 0) {
            return "0";
        }
        int i8 = 0;
        char[] cArr = {_ByteStringKt.getHEX_DIGIT_CHARS()[(i6 >> 28) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i6 >> 24) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i6 >> 20) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i6 >> 16) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i6 >> 12) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i6 >> 8) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i6 >> 4) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[i6 & 15]};
        while (i8 < 8 && cArr[i8] == '0') {
            i8++;
        }
        i7 = w.i(cArr, i8, 8);
        return i7;
    }

    public static final long and(int i6, long j6) {
        return i6 & j6;
    }

    public static final Buffer.UnsafeCursor resolveDefaultParameter(Buffer.UnsafeCursor unsafeCursor) {
        kotlin.jvm.internal.l.d(unsafeCursor, "unsafeCursor");
        return unsafeCursor == DEFAULT__new_UnsafeCursor ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    public static final short reverseBytes(short s5) {
        int i6 = s5 & 65535;
        return (short) (((i6 & 255) << 8) | ((65280 & i6) >>> 8));
    }

    public static final String toHexString(long j6) {
        String i6;
        if (j6 == 0) {
            return "0";
        }
        int i7 = 0;
        char[] cArr = {_ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 60) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 56) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 52) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 48) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 44) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 40) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 36) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 32) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 28) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 24) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 20) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 16) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 12) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 8) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j6 >> 4) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) (j6 & 15)]};
        while (i7 < 16 && cArr[i7] == '0') {
            i7++;
        }
        i6 = w.i(cArr, i7, 16);
        return i6;
    }
}
