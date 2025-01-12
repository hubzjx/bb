package okio;
/* loaded from: classes.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i6) {
        if (i6 >= 0 && i6 < 32) {
            return true;
        }
        return 127 <= i6 && i6 < 160;
    }

    public static final boolean isUtf8Continuation(byte b6) {
        return (b6 & 192) == 128;
    }

    public static final int process2Utf8Bytes(byte[] bArr, int i6, int i7, p4.l lVar) {
        kotlin.jvm.internal.l.d(bArr, "<this>");
        kotlin.jvm.internal.l.d(lVar, "yield");
        int i8 = i6 + 1;
        Integer valueOf = Integer.valueOf((int) REPLACEMENT_CODE_POINT);
        if (i7 <= i8) {
            lVar.invoke(valueOf);
            return 1;
        }
        byte b6 = bArr[i6];
        byte b7 = bArr[i8];
        if (!((b7 & 192) == 128)) {
            lVar.invoke(valueOf);
            return 1;
        }
        int i9 = (b7 ^ 3968) ^ (b6 << 6);
        if (i9 < 128) {
            lVar.invoke(valueOf);
            return 2;
        }
        lVar.invoke(Integer.valueOf(i9));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] bArr, int i6, int i7, p4.l lVar) {
        kotlin.jvm.internal.l.d(bArr, "<this>");
        kotlin.jvm.internal.l.d(lVar, "yield");
        int i8 = i6 + 2;
        Integer valueOf = Integer.valueOf((int) REPLACEMENT_CODE_POINT);
        if (i7 <= i8) {
            lVar.invoke(valueOf);
            int i9 = i6 + 1;
            if (i7 > i9) {
                if ((bArr[i9] & 192) == 128) {
                    return 2;
                }
            }
            return 1;
        }
        byte b6 = bArr[i6];
        byte b7 = bArr[i6 + 1];
        if (!((b7 & 192) == 128)) {
            lVar.invoke(valueOf);
            return 1;
        }
        byte b8 = bArr[i8];
        if (!((b8 & 192) == 128)) {
            lVar.invoke(valueOf);
            return 2;
        }
        int i10 = ((b8 ^ (-123008)) ^ (b7 << 6)) ^ (b6 << 12);
        if (i10 >= 2048) {
            if (55296 <= i10 && i10 < 57344) {
                r2 = true;
            }
            if (!r2) {
                lVar.invoke(Integer.valueOf(i10));
                return 3;
            }
        }
        lVar.invoke(valueOf);
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] bArr, int i6, int i7, p4.l lVar) {
        kotlin.jvm.internal.l.d(bArr, "<this>");
        kotlin.jvm.internal.l.d(lVar, "yield");
        int i8 = i6 + 3;
        Integer valueOf = Integer.valueOf((int) REPLACEMENT_CODE_POINT);
        if (i7 <= i8) {
            lVar.invoke(valueOf);
            int i9 = i6 + 1;
            if (i7 > i9) {
                if ((bArr[i9] & 192) == 128) {
                    int i10 = i6 + 2;
                    if (i7 > i10) {
                        if ((bArr[i10] & 192) == 128) {
                            return 3;
                        }
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b6 = bArr[i6];
        byte b7 = bArr[i6 + 1];
        if (!((b7 & 192) == 128)) {
            lVar.invoke(valueOf);
            return 1;
        }
        byte b8 = bArr[i6 + 2];
        if (!((b8 & 192) == 128)) {
            lVar.invoke(valueOf);
            return 2;
        }
        byte b9 = bArr[i8];
        if (!((b9 & 192) == 128)) {
            lVar.invoke(valueOf);
            return 3;
        }
        int i11 = (((b9 ^ 3678080) ^ (b8 << 6)) ^ (b7 << 12)) ^ (b6 << 18);
        if (i11 <= 1114111) {
            if (55296 <= i11 && i11 < 57344) {
                r3 = true;
            }
            if (!r3 && i11 >= 65536) {
                lVar.invoke(Integer.valueOf(i11));
                return 4;
            }
        }
        lVar.invoke(valueOf);
        return 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008d, code lost:
        if (((r16[r4] & 192) == 128) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0108, code lost:
        if (((r16[r4] & 192) == 128) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void processUtf16Chars(byte[] bArr, int i6, int i7, p4.l lVar) {
        int i8;
        char c6;
        Character valueOf;
        kotlin.jvm.internal.l.d(bArr, "<this>");
        kotlin.jvm.internal.l.d(lVar, "yield");
        int i9 = i6;
        while (i9 < i7) {
            byte b6 = bArr[i9];
            if (b6 >= 0) {
                lVar.invoke(Character.valueOf((char) b6));
                i9++;
                while (i9 < i7) {
                    byte b7 = bArr[i9];
                    if (b7 >= 0) {
                        i9++;
                        lVar.invoke(Character.valueOf((char) b7));
                    }
                }
            } else {
                if ((b6 >> 5) == -2) {
                    int i10 = i9 + 1;
                    if (i7 > i10) {
                        byte b8 = bArr[i10];
                        if ((b8 & 192) == 128) {
                            int i11 = (b6 << 6) ^ (b8 ^ 3968);
                            lVar.invoke(Character.valueOf(i11 < 128 ? (char) REPLACEMENT_CODE_POINT : (char) i11));
                            i8 = 2;
                        }
                    }
                    lVar.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                    i8 = 1;
                } else if ((b6 >> 4) == -2) {
                    int i12 = i9 + 2;
                    if (i7 <= i12) {
                        lVar.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                        int i13 = i9 + 1;
                        if (i7 > i13) {
                        }
                        i8 = 1;
                    } else {
                        byte b9 = bArr[i9 + 1];
                        if ((b9 & 192) == 128) {
                            byte b10 = bArr[i12];
                            if ((b10 & 192) == 128) {
                                int i14 = (b6 << 12) ^ ((b10 ^ (-123008)) ^ (b9 << 6));
                                if (i14 >= 2048) {
                                    if (55296 <= i14 && i14 < 57344) {
                                        r9 = true;
                                    }
                                    if (!r9) {
                                        c6 = (char) i14;
                                        lVar.invoke(Character.valueOf(c6));
                                        i8 = 3;
                                    }
                                }
                                c6 = (char) REPLACEMENT_CODE_POINT;
                                lVar.invoke(Character.valueOf(c6));
                                i8 = 3;
                            } else {
                                lVar.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                                i8 = 2;
                            }
                        } else {
                            lVar.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            i8 = 1;
                        }
                    }
                } else if ((b6 >> 3) == -2) {
                    int i15 = i9 + 3;
                    if (i7 <= i15) {
                        lVar.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                        int i16 = i9 + 1;
                        if (i7 > i16) {
                            if ((bArr[i16] & 192) == 128) {
                                int i17 = i9 + 2;
                                if (i7 > i17) {
                                }
                                i8 = 2;
                            }
                        }
                        i8 = 1;
                    } else {
                        byte b11 = bArr[i9 + 1];
                        if ((b11 & 192) == 128) {
                            byte b12 = bArr[i9 + 2];
                            if ((b12 & 192) == 128) {
                                byte b13 = bArr[i15];
                                if ((b13 & 192) == 128) {
                                    int i18 = (b6 << 18) ^ (((b13 ^ 3678080) ^ (b12 << 6)) ^ (b11 << 12));
                                    if (i18 <= 1114111) {
                                        if (55296 <= i18 && i18 < 57344) {
                                            r9 = true;
                                        }
                                        if (!r9 && i18 >= 65536 && i18 != 65533) {
                                            lVar.invoke(Character.valueOf((char) ((i18 >>> 10) + HIGH_SURROGATE_HEADER)));
                                            valueOf = Character.valueOf((char) ((i18 & 1023) + LOG_SURROGATE_HEADER));
                                            lVar.invoke(valueOf);
                                            i8 = 4;
                                        }
                                    }
                                    valueOf = Character.valueOf(REPLACEMENT_CHARACTER);
                                    lVar.invoke(valueOf);
                                    i8 = 4;
                                } else {
                                    lVar.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    i8 = 3;
                                }
                            } else {
                                lVar.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                i8 = 2;
                            }
                        } else {
                            lVar.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            i8 = 1;
                        }
                    }
                } else {
                    lVar.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                    i9++;
                }
                i9 += i8;
            }
        }
    }

    public static final void processUtf8Bytes(String str, int i6, int i7, p4.l lVar) {
        int i8;
        Byte valueOf;
        int i9;
        kotlin.jvm.internal.l.d(str, "<this>");
        kotlin.jvm.internal.l.d(lVar, "yield");
        while (i6 < i7) {
            char charAt = str.charAt(i6);
            if (kotlin.jvm.internal.l.e(charAt, 128) < 0) {
                lVar.invoke(Byte.valueOf((byte) charAt));
                i6++;
                while (i6 < i7 && kotlin.jvm.internal.l.e(str.charAt(i6), 128) < 0) {
                    lVar.invoke(Byte.valueOf((byte) str.charAt(i6)));
                    i6++;
                }
            } else {
                if (kotlin.jvm.internal.l.e(charAt, 2048) < 0) {
                    i8 = (charAt >> 6) | 192;
                } else {
                    boolean z5 = false;
                    if (55296 <= charAt && charAt < 57344) {
                        if (kotlin.jvm.internal.l.e(charAt, 56319) <= 0 && i7 > (i9 = i6 + 1)) {
                            char charAt2 = str.charAt(i9);
                            if (56320 <= charAt2 && charAt2 < 57344) {
                                z5 = true;
                            }
                            if (z5) {
                                int charAt3 = ((charAt << '\n') + str.charAt(i9)) - 56613888;
                                lVar.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                                lVar.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                                lVar.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                                lVar.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                                i6 += 2;
                            }
                        }
                        valueOf = Byte.valueOf((byte) REPLACEMENT_BYTE);
                        lVar.invoke(valueOf);
                        i6++;
                    } else {
                        lVar.invoke(Byte.valueOf((byte) ((charAt >> '\f') | 224)));
                        i8 = ((charAt >> 6) & 63) | 128;
                    }
                }
                lVar.invoke(Byte.valueOf((byte) i8));
                valueOf = Byte.valueOf((byte) ((charAt & '?') | 128));
                lVar.invoke(valueOf);
                i6++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008b, code lost:
        if (((r16[r4] & 192) == 128) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0106, code lost:
        if (((r16[r4] & 192) == 128) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void processUtf8CodePoints(byte[] bArr, int i6, int i7, p4.l lVar) {
        int i8;
        Integer valueOf;
        Integer valueOf2;
        kotlin.jvm.internal.l.d(bArr, "<this>");
        kotlin.jvm.internal.l.d(lVar, "yield");
        int i9 = i6;
        while (i9 < i7) {
            byte b6 = bArr[i9];
            if (b6 >= 0) {
                lVar.invoke(Integer.valueOf(b6));
                i9++;
                while (i9 < i7) {
                    byte b7 = bArr[i9];
                    if (b7 >= 0) {
                        i9++;
                        lVar.invoke(Integer.valueOf(b7));
                    }
                }
            } else {
                if ((b6 >> 5) == -2) {
                    int i10 = i9 + 1;
                    if (i7 > i10) {
                        byte b8 = bArr[i10];
                        if ((b8 & 192) == 128) {
                            int i11 = (b6 << 6) ^ (b8 ^ 3968);
                            lVar.invoke(i11 < 128 ? Integer.valueOf((int) REPLACEMENT_CODE_POINT) : Integer.valueOf(i11));
                            i8 = 2;
                        }
                    }
                    lVar.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                    i8 = 1;
                } else if ((b6 >> 4) == -2) {
                    int i12 = i9 + 2;
                    if (i7 <= i12) {
                        lVar.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                        int i13 = i9 + 1;
                        if (i7 > i13) {
                        }
                        i8 = 1;
                    } else {
                        byte b9 = bArr[i9 + 1];
                        if ((b9 & 192) == 128) {
                            byte b10 = bArr[i12];
                            if ((b10 & 192) == 128) {
                                int i14 = (b6 << 12) ^ ((b10 ^ (-123008)) ^ (b9 << 6));
                                if (i14 >= 2048) {
                                    if (55296 <= i14 && i14 < 57344) {
                                        r9 = true;
                                    }
                                    if (!r9) {
                                        valueOf = Integer.valueOf(i14);
                                        lVar.invoke(valueOf);
                                        i8 = 3;
                                    }
                                }
                                valueOf = Integer.valueOf((int) REPLACEMENT_CODE_POINT);
                                lVar.invoke(valueOf);
                                i8 = 3;
                            } else {
                                lVar.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                                i8 = 2;
                            }
                        } else {
                            lVar.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                            i8 = 1;
                        }
                    }
                } else if ((b6 >> 3) == -2) {
                    int i15 = i9 + 3;
                    if (i7 <= i15) {
                        lVar.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                        int i16 = i9 + 1;
                        if (i7 > i16) {
                            if ((bArr[i16] & 192) == 128) {
                                int i17 = i9 + 2;
                                if (i7 > i17) {
                                }
                                i8 = 2;
                            }
                        }
                        i8 = 1;
                    } else {
                        byte b11 = bArr[i9 + 1];
                        if ((b11 & 192) == 128) {
                            byte b12 = bArr[i9 + 2];
                            if ((b12 & 192) == 128) {
                                byte b13 = bArr[i15];
                                if ((b13 & 192) == 128) {
                                    int i18 = (b6 << 18) ^ (((b13 ^ 3678080) ^ (b12 << 6)) ^ (b11 << 12));
                                    if (i18 <= 1114111) {
                                        if (55296 <= i18 && i18 < 57344) {
                                            r9 = true;
                                        }
                                        if (!r9 && i18 >= 65536) {
                                            valueOf2 = Integer.valueOf(i18);
                                            lVar.invoke(valueOf2);
                                            i8 = 4;
                                        }
                                    }
                                    valueOf2 = Integer.valueOf((int) REPLACEMENT_CODE_POINT);
                                    lVar.invoke(valueOf2);
                                    i8 = 4;
                                } else {
                                    lVar.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                                    i8 = 3;
                                }
                            } else {
                                lVar.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                                i8 = 2;
                            }
                        } else {
                            lVar.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                            i8 = 1;
                        }
                    }
                } else {
                    lVar.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                    i9++;
                }
                i9 += i8;
            }
        }
    }

    public static final long size(String str) {
        kotlin.jvm.internal.l.d(str, "<this>");
        return size$default(str, 0, 0, 3, null);
    }

    public static /* synthetic */ long size$default(String str, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        return size(str, i6, i7);
    }

    public static final long size(String str, int i6) {
        kotlin.jvm.internal.l.d(str, "<this>");
        return size$default(str, i6, 0, 2, null);
    }

    public static final long size(String str, int i6, int i7) {
        int i8;
        kotlin.jvm.internal.l.d(str, "<this>");
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i6).toString());
        }
        if (!(i7 >= i6)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i7 + " < " + i6).toString());
        }
        if (!(i7 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i7 + " > " + str.length()).toString());
        }
        long j6 = 0;
        while (i6 < i7) {
            char charAt = str.charAt(i6);
            if (charAt < 128) {
                j6++;
            } else {
                if (charAt < 2048) {
                    i8 = 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    i8 = 3;
                } else {
                    int i9 = i6 + 1;
                    char charAt2 = i9 < i7 ? str.charAt(i9) : (char) 0;
                    if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                        j6++;
                        i6 = i9;
                    } else {
                        j6 += 4;
                        i6 += 2;
                    }
                }
                j6 += i8;
            }
            i6++;
        }
        return j6;
    }
}
