package io.jsonwebtoken.io;

import java.util.Arrays;
/* loaded from: classes.dex */
final class Base64 {
    private static final char[] BASE64URL_ALPHABET;
    private static final int[] BASE64URL_IALPHABET;
    private static final char[] BASE64_ALPHABET;
    private static final int[] BASE64_IALPHABET;
    static final Base64 DEFAULT;
    private static final int IALPHABET_MAX_INDEX;
    static final Base64 URL_SAFE;
    private final char[] ALPHABET;
    private final int[] IALPHABET;
    private final boolean urlsafe;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        BASE64_ALPHABET = charArray;
        BASE64URL_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();
        int[] iArr = new int[256];
        BASE64_IALPHABET = iArr;
        int[] iArr2 = new int[256];
        BASE64URL_IALPHABET = iArr2;
        IALPHABET_MAX_INDEX = iArr.length - 1;
        Arrays.fill(iArr, -1);
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        int length = charArray.length;
        for (int i6 = 0; i6 < length; i6++) {
            BASE64_IALPHABET[BASE64_ALPHABET[i6]] = i6;
            BASE64URL_IALPHABET[BASE64URL_ALPHABET[i6]] = i6;
        }
        BASE64_IALPHABET[61] = 0;
        BASE64URL_IALPHABET[61] = 0;
        DEFAULT = new Base64(false);
        URL_SAFE = new Base64(true);
    }

    private Base64(boolean z5) {
        this.urlsafe = z5;
        this.ALPHABET = z5 ? BASE64URL_ALPHABET : BASE64_ALPHABET;
        this.IALPHABET = z5 ? BASE64URL_IALPHABET : BASE64_IALPHABET;
    }

    private int ctoi(char c6) {
        int i6 = c6 > IALPHABET_MAX_INDEX ? -1 : this.IALPHABET[c6];
        if (i6 >= 0) {
            return i6;
        }
        throw new DecodingException("Illegal " + getName() + " character: '" + c6 + "'");
    }

    private char[] encodeToChar(byte[] bArr, boolean z5) {
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return new char[0];
        }
        int i6 = (length / 3) * 3;
        int i7 = length - i6;
        int i8 = length - 1;
        int i9 = ((i8 / 3) + 1) << 2;
        int i10 = i9 + (z5 ? ((i9 - 1) / 76) << 1 : 0);
        char[] cArr = new char[this.urlsafe ? i10 - (i7 == 2 ? 1 : i7 == 1 ? 2 : 0) : i10];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < i6) {
            int i14 = i11 + 1;
            int i15 = i14 + 1;
            int i16 = ((bArr[i11] & 255) << 16) | ((bArr[i14] & 255) << 8);
            int i17 = i15 + 1;
            int i18 = i16 | (bArr[i15] & 255);
            int i19 = i12 + 1;
            char[] cArr2 = this.ALPHABET;
            cArr[i12] = cArr2[(i18 >>> 18) & 63];
            int i20 = i19 + 1;
            cArr[i19] = cArr2[(i18 >>> 12) & 63];
            int i21 = i20 + 1;
            cArr[i20] = cArr2[(i18 >>> 6) & 63];
            i12 = i21 + 1;
            cArr[i21] = cArr2[i18 & 63];
            if (z5 && (i13 = i13 + 1) == 19 && i12 < i10 - 2) {
                int i22 = i12 + 1;
                cArr[i12] = '\r';
                cArr[i22] = '\n';
                i12 = i22 + 1;
                i13 = 0;
            }
            i11 = i17;
        }
        if (i7 > 0) {
            int i23 = ((bArr[i6] & 255) << 10) | (i7 == 2 ? (bArr[i8] & 255) << 2 : 0);
            char[] cArr3 = this.ALPHABET;
            cArr[i10 - 4] = cArr3[i23 >> 12];
            cArr[i10 - 3] = cArr3[(i23 >>> 6) & 63];
            if (i7 == 2) {
                cArr[i10 - 2] = cArr3[i23 & 63];
            } else if (!this.urlsafe) {
                cArr[i10 - 2] = '=';
            }
            if (!this.urlsafe) {
                cArr[i10 - 1] = '=';
            }
        }
        return cArr;
    }

    private String getName() {
        return this.urlsafe ? "base64url" : "base64";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] decodeFast(char[] cArr) {
        int i6;
        int i7 = 0;
        int length = cArr != null ? cArr.length : 0;
        if (length == 0) {
            return new byte[0];
        }
        int i8 = length - 1;
        int i9 = 0;
        while (i9 < i8 && this.IALPHABET[cArr[i9]] < 0) {
            i9++;
        }
        while (i8 > 0 && this.IALPHABET[cArr[i8]] < 0) {
            i8--;
        }
        int i10 = cArr[i8] == '=' ? cArr[i8 + (-1)] == '=' ? 2 : 1 : 0;
        int i11 = (i8 - i9) + 1;
        if (length > 76) {
            i6 = (cArr[76] == '\r' ? i11 / 78 : 0) << 1;
        } else {
            i6 = 0;
        }
        int i12 = (((i11 - i6) * 6) >> 3) - i10;
        byte[] bArr = new byte[i12];
        int i13 = (i12 / 3) * 3;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i13) {
            int i16 = i9 + 1;
            int i17 = i16 + 1;
            int ctoi = (ctoi(cArr[i9]) << 18) | (ctoi(cArr[i16]) << 12);
            int i18 = i17 + 1;
            int ctoi2 = ctoi | (ctoi(cArr[i17]) << 6);
            int i19 = i18 + 1;
            int ctoi3 = ctoi2 | ctoi(cArr[i18]);
            int i20 = i14 + 1;
            bArr[i14] = (byte) (ctoi3 >> 16);
            int i21 = i20 + 1;
            bArr[i20] = (byte) (ctoi3 >> 8);
            int i22 = i21 + 1;
            bArr[i21] = (byte) ctoi3;
            if (i6 <= 0 || (i15 = i15 + 1) != 19) {
                i9 = i19;
            } else {
                i9 = i19 + 2;
                i15 = 0;
            }
            i14 = i22;
        }
        if (i14 < i12) {
            int i23 = 0;
            while (i9 <= i8 - i10) {
                i7 |= ctoi(cArr[i9]) << (18 - (i23 * 6));
                i23++;
                i9++;
            }
            int i24 = 16;
            while (i14 < i12) {
                bArr[i14] = (byte) (i7 >> i24);
                i24 -= 8;
                i14++;
            }
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String encodeToString(byte[] bArr, boolean z5) {
        return new String(encodeToChar(bArr, z5));
    }
}
