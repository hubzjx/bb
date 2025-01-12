package com.google.zxing.qrcode.decoder;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import s3.l;
/* loaded from: classes.dex */
abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f5856a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5857a;

        static {
            int[] iArr = new int[h.values().length];
            f5857a = iArr;
            try {
                iArr[h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5857a[h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5857a[h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5857a[h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5857a[h.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5857a[h.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5857a[h.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5857a[h.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5857a[h.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5857a[h.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static s3.e a(byte[] bArr, j jVar, f fVar, Map map) {
        h hVar;
        s3.c cVar = new s3.c(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i6 = 1;
        ArrayList arrayList = new ArrayList(1);
        s3.d dVar = null;
        int i7 = -1;
        int i8 = -1;
        boolean z5 = false;
        while (true) {
            try {
                h forBits = cVar.a() < 4 ? h.TERMINATOR : h.forBits(cVar.b(4));
                int[] iArr = a.f5857a;
                switch (iArr[forBits.ordinal()]) {
                    case 5:
                        hVar = forBits;
                        break;
                    case 6:
                    case 7:
                        hVar = forBits;
                        z5 = true;
                        break;
                    case 8:
                        if (cVar.a() >= 16) {
                            int b6 = cVar.b(8);
                            i8 = cVar.b(8);
                            i7 = b6;
                            hVar = forBits;
                            break;
                        } else {
                            throw com.google.zxing.h.getFormatInstance();
                        }
                    case 9:
                        dVar = s3.d.getCharacterSetECIByValue(g(cVar));
                        if (dVar == null) {
                            throw com.google.zxing.h.getFormatInstance();
                        }
                        hVar = forBits;
                        break;
                    case 10:
                        int b7 = cVar.b(4);
                        int b8 = cVar.b(forBits.getCharacterCountBits(jVar));
                        if (b7 == i6) {
                            d(cVar, sb, b8);
                        }
                        hVar = forBits;
                        break;
                    default:
                        int b9 = cVar.b(forBits.getCharacterCountBits(jVar));
                        int i9 = iArr[forBits.ordinal()];
                        if (i9 == i6) {
                            hVar = forBits;
                            f(cVar, sb, b9);
                            break;
                        } else if (i9 == 2) {
                            hVar = forBits;
                            b(cVar, sb, b9, z5);
                            break;
                        } else if (i9 == 3) {
                            hVar = forBits;
                            c(cVar, sb, b9, dVar, arrayList, map);
                            break;
                        } else if (i9 == 4) {
                            e(cVar, sb, b9);
                            hVar = forBits;
                            break;
                        } else {
                            throw com.google.zxing.h.getFormatInstance();
                        }
                }
                if (hVar == h.TERMINATOR) {
                    return new s3.e(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, fVar == null ? null : fVar.toString(), i7, i8);
                }
                i6 = 1;
            } catch (IllegalArgumentException unused) {
                throw com.google.zxing.h.getFormatInstance();
            }
        }
    }

    private static void b(s3.c cVar, StringBuilder sb, int i6, boolean z5) {
        while (i6 > 1) {
            if (cVar.a() < 11) {
                throw com.google.zxing.h.getFormatInstance();
            }
            int b6 = cVar.b(11);
            sb.append(h(b6 / 45));
            sb.append(h(b6 % 45));
            i6 -= 2;
        }
        if (i6 == 1) {
            if (cVar.a() < 6) {
                throw com.google.zxing.h.getFormatInstance();
            }
            sb.append(h(cVar.b(6)));
        }
        if (z5) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i7 = length + 1;
                        if (sb.charAt(i7) == '%') {
                            sb.deleteCharAt(i7);
                        }
                    }
                    sb.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static void c(s3.c cVar, StringBuilder sb, int i6, s3.d dVar, Collection collection, Map map) {
        if ((i6 << 3) > cVar.a()) {
            throw com.google.zxing.h.getFormatInstance();
        }
        byte[] bArr = new byte[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            bArr[i7] = (byte) cVar.b(8);
        }
        try {
            sb.append(new String(bArr, dVar == null ? l.a(bArr, map) : dVar.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw com.google.zxing.h.getFormatInstance();
        }
    }

    private static void d(s3.c cVar, StringBuilder sb, int i6) {
        if (i6 * 13 > cVar.a()) {
            throw com.google.zxing.h.getFormatInstance();
        }
        byte[] bArr = new byte[i6 * 2];
        int i7 = 0;
        while (i6 > 0) {
            int b6 = cVar.b(13);
            int i8 = (b6 % 96) | ((b6 / 96) << 8);
            int i9 = i8 + (i8 < 959 ? 41377 : 42657);
            bArr[i7] = (byte) (i9 >> 8);
            bArr[i7 + 1] = (byte) i9;
            i7 += 2;
            i6--;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException unused) {
            throw com.google.zxing.h.getFormatInstance();
        }
    }

    private static void e(s3.c cVar, StringBuilder sb, int i6) {
        if (i6 * 13 > cVar.a()) {
            throw com.google.zxing.h.getFormatInstance();
        }
        byte[] bArr = new byte[i6 * 2];
        int i7 = 0;
        while (i6 > 0) {
            int b6 = cVar.b(13);
            int i8 = (b6 % 192) | ((b6 / 192) << 8);
            int i9 = i8 + (i8 < 7936 ? 33088 : 49472);
            bArr[i7] = (byte) (i9 >> 8);
            bArr[i7 + 1] = (byte) i9;
            i7 += 2;
            i6--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw com.google.zxing.h.getFormatInstance();
        }
    }

    private static void f(s3.c cVar, StringBuilder sb, int i6) {
        while (i6 >= 3) {
            if (cVar.a() < 10) {
                throw com.google.zxing.h.getFormatInstance();
            }
            int b6 = cVar.b(10);
            if (b6 >= 1000) {
                throw com.google.zxing.h.getFormatInstance();
            }
            sb.append(h(b6 / 100));
            sb.append(h((b6 / 10) % 10));
            sb.append(h(b6 % 10));
            i6 -= 3;
        }
        if (i6 == 2) {
            if (cVar.a() < 7) {
                throw com.google.zxing.h.getFormatInstance();
            }
            int b7 = cVar.b(7);
            if (b7 >= 100) {
                throw com.google.zxing.h.getFormatInstance();
            }
            sb.append(h(b7 / 10));
            sb.append(h(b7 % 10));
        } else if (i6 == 1) {
            if (cVar.a() < 4) {
                throw com.google.zxing.h.getFormatInstance();
            }
            int b8 = cVar.b(4);
            if (b8 >= 10) {
                throw com.google.zxing.h.getFormatInstance();
            }
            sb.append(h(b8));
        }
    }

    private static int g(s3.c cVar) {
        int b6 = cVar.b(8);
        if ((b6 & 128) == 0) {
            return b6 & 127;
        }
        if ((b6 & 192) == 128) {
            return cVar.b(8) | ((b6 & 63) << 8);
        }
        if ((b6 & 224) == 192) {
            return cVar.b(16) | ((b6 & 31) << 16);
        }
        throw com.google.zxing.h.getFormatInstance();
    }

    private static char h(int i6) {
        char[] cArr = f5856a;
        if (i6 < cArr.length) {
            return cArr[i6];
        }
        throw com.google.zxing.h.getFormatInstance();
    }
}
