package okio.internal;

import java.util.Arrays;
import kotlin.jvm.internal.l;
import kotlin.text.w;
import okio.Utf8;
/* loaded from: classes.dex */
public final class _Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i6;
        int i7;
        l.d(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i8 = 0;
        while (i8 < length) {
            char charAt = str.charAt(i8);
            if (l.e(charAt, 128) >= 0) {
                int length2 = str.length();
                int i9 = i8;
                while (i8 < length2) {
                    char charAt2 = str.charAt(i8);
                    if (l.e(charAt2, 128) < 0) {
                        int i10 = i9 + 1;
                        bArr[i9] = (byte) charAt2;
                        i8++;
                        while (true) {
                            i9 = i10;
                            if (i8 < length2 && l.e(str.charAt(i8), 128) < 0) {
                                i10 = i9 + 1;
                                bArr[i9] = (byte) str.charAt(i8);
                                i8++;
                            }
                        }
                    } else {
                        if (l.e(charAt2, 2048) < 0) {
                            int i11 = i9 + 1;
                            bArr[i9] = (byte) ((charAt2 >> 6) | 192);
                            i6 = i11 + 1;
                            bArr[i11] = (byte) ((charAt2 & '?') | 128);
                        } else {
                            boolean z5 = true;
                            if (55296 <= charAt2 && charAt2 < 57344) {
                                if (l.e(charAt2, 56319) <= 0 && length2 > (i7 = i8 + 1)) {
                                    char charAt3 = str.charAt(i7);
                                    if ((56320 > charAt3 || charAt3 >= 57344) ? false : false) {
                                        int charAt4 = ((charAt2 << '\n') + str.charAt(i7)) - 56613888;
                                        int i12 = i9 + 1;
                                        bArr[i9] = (byte) ((charAt4 >> 18) | 240);
                                        int i13 = i12 + 1;
                                        bArr[i12] = (byte) (((charAt4 >> 12) & 63) | 128);
                                        int i14 = i13 + 1;
                                        bArr[i13] = (byte) (((charAt4 >> 6) & 63) | 128);
                                        i6 = i14 + 1;
                                        bArr[i14] = (byte) ((charAt4 & 63) | 128);
                                        i8 += 2;
                                        i9 = i6;
                                    }
                                }
                                i6 = i9 + 1;
                                bArr[i9] = Utf8.REPLACEMENT_BYTE;
                            } else {
                                int i15 = i9 + 1;
                                bArr[i9] = (byte) ((charAt2 >> '\f') | 224);
                                int i16 = i15 + 1;
                                bArr[i15] = (byte) (((charAt2 >> 6) & 63) | 128);
                                i6 = i16 + 1;
                                bArr[i16] = (byte) ((charAt2 & '?') | 128);
                            }
                        }
                        i8++;
                        i9 = i6;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i9);
                l.c(copyOf, "copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i8] = (byte) charAt;
            i8++;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        l.c(copyOf2, "copyOf(this, newSize)");
        return copyOf2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0092, code lost:
        if (((r16[r5] & 192) == 128) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x010d, code lost:
        if (((r16[r5] & 192) == 128) == false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String commonToUtf8String(byte[] bArr, int i6, int i7) {
        String i8;
        byte b6;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = i6;
        l.d(bArr, "<this>");
        if (i14 < 0 || i7 > bArr.length || i14 > i7) {
            throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i14 + " endIndex=" + i7);
        }
        char[] cArr = new char[i7 - i14];
        int i15 = 0;
        while (i14 < i7) {
            byte b7 = bArr[i14];
            if (b7 >= 0) {
                int i16 = i15 + 1;
                cArr[i15] = (char) b7;
                i14++;
                while (true) {
                    i15 = i16;
                    if (i14 < i7 && (b6 = bArr[i14]) >= 0) {
                        i14++;
                        i16 = i15 + 1;
                        cArr[i15] = (char) b6;
                    }
                }
            } else {
                if ((b7 >> 5) == -2) {
                    int i17 = i14 + 1;
                    if (i7 <= i17) {
                        i9 = i15 + 1;
                        cArr[i15] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    } else {
                        byte b8 = bArr[i17];
                        if ((b8 & 192) == 128) {
                            int i18 = (b7 << 6) ^ (b8 ^ 3968);
                            if (i18 < 128) {
                                i9 = i15 + 1;
                                cArr[i15] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            } else {
                                i9 = i15 + 1;
                                cArr[i15] = (char) i18;
                            }
                            i15 = i9;
                            i10 = 2;
                        } else {
                            i9 = i15 + 1;
                            cArr[i15] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        }
                    }
                    i15 = i9;
                    i10 = 1;
                } else {
                    if ((b7 >> 4) == -2) {
                        int i19 = i14 + 2;
                        if (i7 <= i19) {
                            i9 = i15 + 1;
                            cArr[i15] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            int i20 = i14 + 1;
                            if (i7 > i20) {
                            }
                            i15 = i9;
                            i10 = 1;
                        } else {
                            byte b9 = bArr[i14 + 1];
                            if ((b9 & 192) == 128) {
                                byte b10 = bArr[i19];
                                if ((b10 & 192) == 128) {
                                    int i21 = (b7 << 12) ^ ((b10 ^ (-123008)) ^ (b9 << 6));
                                    if (i21 < 2048) {
                                        i11 = i15 + 1;
                                        cArr[i15] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                    } else {
                                        if (55296 <= i21 && i21 < 57344) {
                                            i11 = i15 + 1;
                                            cArr[i15] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                        } else {
                                            i11 = i15 + 1;
                                            cArr[i15] = (char) i21;
                                        }
                                    }
                                    i15 = i11;
                                } else {
                                    i9 = i15 + 1;
                                    cArr[i15] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                    i15 = i9;
                                    i10 = 2;
                                }
                            } else {
                                i9 = i15 + 1;
                                cArr[i15] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                i15 = i9;
                                i10 = 1;
                            }
                        }
                    } else if ((b7 >> 3) == -2) {
                        int i22 = i14 + 3;
                        if (i7 <= i22) {
                            i13 = i15 + 1;
                            cArr[i15] = Utf8.REPLACEMENT_CHARACTER;
                            int i23 = i14 + 1;
                            if (i7 > i23) {
                                if ((bArr[i23] & 192) == 128) {
                                    int i24 = i14 + 2;
                                    if (i7 > i24) {
                                    }
                                    i15 = i13;
                                    i10 = 2;
                                }
                            }
                            i15 = i13;
                            i10 = 1;
                        } else {
                            byte b11 = bArr[i14 + 1];
                            if ((b11 & 192) == 128) {
                                byte b12 = bArr[i14 + 2];
                                if ((b12 & 192) == 128) {
                                    byte b13 = bArr[i22];
                                    if ((b13 & 192) == 128) {
                                        int i25 = (b7 << 18) ^ (((b13 ^ 3678080) ^ (b12 << 6)) ^ (b11 << 12));
                                        if (i25 > 1114111) {
                                            i12 = i15 + 1;
                                            cArr[i15] = Utf8.REPLACEMENT_CHARACTER;
                                        } else {
                                            if (55296 <= i25 && i25 < 57344) {
                                                i12 = i15 + 1;
                                                cArr[i15] = Utf8.REPLACEMENT_CHARACTER;
                                            } else if (i25 < 65536) {
                                                i12 = i15 + 1;
                                                cArr[i15] = Utf8.REPLACEMENT_CHARACTER;
                                            } else if (i25 != 65533) {
                                                int i26 = i15 + 1;
                                                cArr[i15] = (char) ((i25 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                                i12 = i26 + 1;
                                                cArr[i26] = (char) ((i25 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                            } else {
                                                i12 = i15 + 1;
                                                cArr[i15] = Utf8.REPLACEMENT_CHARACTER;
                                            }
                                        }
                                        i10 = 4;
                                        i15 = i12;
                                    } else {
                                        i13 = i15 + 1;
                                        cArr[i15] = Utf8.REPLACEMENT_CHARACTER;
                                        i15 = i13;
                                    }
                                } else {
                                    i13 = i15 + 1;
                                    cArr[i15] = Utf8.REPLACEMENT_CHARACTER;
                                    i15 = i13;
                                    i10 = 2;
                                }
                            } else {
                                i13 = i15 + 1;
                                cArr[i15] = Utf8.REPLACEMENT_CHARACTER;
                                i15 = i13;
                                i10 = 1;
                            }
                        }
                    } else {
                        cArr[i15] = Utf8.REPLACEMENT_CHARACTER;
                        i14++;
                        i15++;
                    }
                    i10 = 3;
                }
                i14 += i10;
            }
        }
        i8 = w.i(cArr, 0, i15);
        return i8;
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = bArr.length;
        }
        return commonToUtf8String(bArr, i6, i7);
    }
}
