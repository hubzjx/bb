package okio;

import java.util.Arrays;
import okio.ByteString;
/* loaded from: classes.dex */
public final class _Base64Kt {
    private static final byte[] BASE64;
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final byte[] decodeBase64ToArray(String str) {
        int i6;
        char charAt;
        kotlin.jvm.internal.l.d(str, "<this>");
        int length = str.length();
        while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i7 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i7];
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean z5 = true;
            if (i8 >= length) {
                int i12 = i9 % 4;
                if (i12 != 1) {
                    if (i12 == 2) {
                        bArr[i11] = (byte) ((i10 << 12) >> 16);
                        i11++;
                    } else if (i12 == 3) {
                        int i13 = i10 << 6;
                        int i14 = i11 + 1;
                        bArr[i11] = (byte) (i13 >> 16);
                        i11 = i14 + 1;
                        bArr[i14] = (byte) (i13 >> 8);
                    }
                    if (i11 == i7) {
                        return bArr;
                    }
                    byte[] copyOf = Arrays.copyOf(bArr, i11);
                    kotlin.jvm.internal.l.c(copyOf, "copyOf(this, newSize)");
                    return copyOf;
                }
                return null;
            }
            char charAt2 = str.charAt(i8);
            if ('A' <= charAt2 && charAt2 < '[') {
                i6 = charAt2 - 'A';
            } else {
                if ('a' <= charAt2 && charAt2 < '{') {
                    i6 = charAt2 - 'G';
                } else {
                    if (('0' > charAt2 || charAt2 >= ':') ? false : false) {
                        i6 = charAt2 + 4;
                    } else if (charAt2 == '+' || charAt2 == '-') {
                        i6 = 62;
                    } else if (charAt2 == '/' || charAt2 == '_') {
                        i6 = 63;
                    } else {
                        if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                            return null;
                        }
                        i8++;
                    }
                }
            }
            i10 = (i10 << 6) | i6;
            i9++;
            if (i9 % 4 == 0) {
                int i15 = i11 + 1;
                bArr[i11] = (byte) (i10 >> 16);
                int i16 = i15 + 1;
                bArr[i15] = (byte) (i10 >> 8);
                bArr[i16] = (byte) i10;
                i11 = i16 + 1;
            }
            i8++;
        }
    }

    public static final String encodeBase64(byte[] bArr, byte[] bArr2) {
        kotlin.jvm.internal.l.d(bArr, "<this>");
        kotlin.jvm.internal.l.d(bArr2, "map");
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i6 + 1;
            byte b6 = bArr[i6];
            int i9 = i8 + 1;
            byte b7 = bArr[i8];
            int i10 = i9 + 1;
            byte b8 = bArr[i9];
            int i11 = i7 + 1;
            bArr3[i7] = bArr2[(b6 & 255) >> 2];
            int i12 = i11 + 1;
            bArr3[i11] = bArr2[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            int i13 = i12 + 1;
            bArr3[i12] = bArr2[((b7 & 15) << 2) | ((b8 & 255) >> 6)];
            i7 = i13 + 1;
            bArr3[i13] = bArr2[b8 & Utf8.REPLACEMENT_BYTE];
            i6 = i10;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b9 = bArr[i6];
            int i14 = i7 + 1;
            bArr3[i7] = bArr2[(b9 & 255) >> 2];
            int i15 = i14 + 1;
            bArr3[i14] = bArr2[(b9 & 3) << 4];
            byte b10 = (byte) 61;
            bArr3[i15] = b10;
            bArr3[i15 + 1] = b10;
        } else if (length2 == 2) {
            int i16 = i6 + 1;
            byte b11 = bArr[i6];
            byte b12 = bArr[i16];
            int i17 = i7 + 1;
            bArr3[i7] = bArr2[(b11 & 255) >> 2];
            int i18 = i17 + 1;
            bArr3[i17] = bArr2[((b11 & 3) << 4) | ((b12 & 255) >> 4)];
            bArr3[i18] = bArr2[(b12 & 15) << 2];
            bArr3[i18 + 1] = (byte) 61;
        }
        return _JvmPlatformKt.toUtf8String(bArr3);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static /* synthetic */ void getBASE64$annotations() {
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }

    public static /* synthetic */ void getBASE64_URL_SAFE$annotations() {
    }
}
