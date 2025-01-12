package s3;

import java.nio.charset.Charset;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13298a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f13299b;

    static {
        String name = Charset.defaultCharset().name();
        f13298a = name;
        f13299b = "SJIS".equalsIgnoreCase(name) || "EUC_JP".equalsIgnoreCase(name);
    }

    public static String a(byte[] bArr, Map map) {
        byte[] bArr2 = bArr;
        if (map != null) {
            com.google.zxing.e eVar = com.google.zxing.e.CHARACTER_SET;
            if (map.containsKey(eVar)) {
                return map.get(eVar).toString();
            }
        }
        int length = bArr2.length;
        boolean z5 = true;
        int i6 = 0;
        boolean z6 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i7 = 0;
        boolean z7 = true;
        boolean z8 = true;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i8 < length && (z5 || z7 || z8)) {
            int i18 = bArr2[i8] & 255;
            if (z8) {
                int i19 = i18 & 128;
                if (i9 > 0) {
                    if (i19 != 0) {
                        i9--;
                    }
                    z8 = false;
                } else if (i19 != 0) {
                    if ((i18 & 64) != 0) {
                        i9++;
                        if ((i18 & 32) == 0) {
                            i11++;
                        } else {
                            i9++;
                            if ((i18 & 16) == 0) {
                                i12++;
                            } else {
                                i9++;
                                if ((i18 & 8) == 0) {
                                    i13++;
                                }
                            }
                        }
                    }
                    z8 = false;
                }
            }
            if (z5) {
                if (i18 > 127 && i18 < 160) {
                    z5 = false;
                } else if (i18 > 159 && (i18 < 192 || i18 == 215 || i18 == 247)) {
                    i15++;
                }
            }
            if (z7) {
                if (i10 > 0) {
                    if (i18 >= 64 && i18 != 127 && i18 <= 252) {
                        i10--;
                    }
                    z7 = false;
                } else {
                    if (i18 != 128 && i18 != 160 && i18 <= 239) {
                        if (i18 <= 160 || i18 >= 224) {
                            if (i18 > 127) {
                                i10++;
                                int i20 = i16 + 1;
                                if (i20 > i6) {
                                    i6 = i20;
                                    i16 = i6;
                                } else {
                                    i16 = i20;
                                }
                            } else {
                                i16 = 0;
                            }
                            i17 = 0;
                        } else {
                            i7++;
                            int i21 = i17 + 1;
                            if (i21 > i14) {
                                i14 = i21;
                                i17 = i14;
                            } else {
                                i17 = i21;
                            }
                            i16 = 0;
                        }
                    }
                    z7 = false;
                }
            }
            i8++;
            bArr2 = bArr;
        }
        if (z8 && i9 > 0) {
            z8 = false;
        }
        if (z7 && i10 > 0) {
            z7 = false;
        }
        return (!z8 || (!z6 && (i11 + i12) + i13 <= 0)) ? (!z7 || (!f13299b && i14 < 3 && i6 < 3)) ? (z5 && z7) ? (!(i14 == 2 && i7 == 2) && i15 * 10 < length) ? "ISO8859_1" : "SJIS" : z5 ? "ISO8859_1" : z7 ? "SJIS" : z8 ? "UTF8" : f13298a : "SJIS" : "UTF8";
    }
}
