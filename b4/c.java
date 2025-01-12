package b4;

import com.google.zxing.g;
import com.google.zxing.qrcode.decoder.h;
import com.google.zxing.qrcode.decoder.j;
import com.google.zxing.s;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3026a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3027a;

        static {
            int[] iArr = new int[h.values().length];
            f3027a = iArr;
            try {
                iArr[h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3027a[h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3027a[h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3027a[h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static void a(String str, s3.a aVar, String str2) {
        try {
            for (byte b6 : str.getBytes(str2)) {
                aVar.c(b6, 8);
            }
        } catch (UnsupportedEncodingException e6) {
            throw new s(e6);
        }
    }

    static void b(CharSequence charSequence, s3.a aVar) {
        int length = charSequence.length();
        int i6 = 0;
        while (i6 < length) {
            int p5 = p(charSequence.charAt(i6));
            if (p5 == -1) {
                throw new s();
            }
            int i7 = i6 + 1;
            if (i7 < length) {
                int p6 = p(charSequence.charAt(i7));
                if (p6 == -1) {
                    throw new s();
                }
                aVar.c((p5 * 45) + p6, 11);
                i6 += 2;
            } else {
                aVar.c(p5, 6);
                i6 = i7;
            }
        }
    }

    static void c(String str, h hVar, s3.a aVar, String str2) {
        int i6 = a.f3027a[hVar.ordinal()];
        if (i6 == 1) {
            h(str, aVar);
        } else if (i6 == 2) {
            b(str, aVar);
        } else if (i6 == 3) {
            a(str, aVar, str2);
        } else if (i6 == 4) {
            e(str, aVar);
        } else {
            throw new s("Invalid mode: " + hVar);
        }
    }

    private static void d(s3.d dVar, s3.a aVar) {
        aVar.c(h.ECI.getBits(), 4);
        aVar.c(dVar.getValue(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[LOOP:0: B:4:0x0008->B:17:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void e(String str, s3.a aVar) {
        int i6;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i7 = 0; i7 < length; i7 += 2) {
                int i8 = ((bytes[i7] & 255) << 8) | (bytes[i7 + 1] & 255);
                int i9 = 33088;
                if (i8 < 33088 || i8 > 40956) {
                    if (i8 < 57408 || i8 > 60351) {
                        i6 = -1;
                        if (i6 != -1) {
                            throw new s("Invalid byte sequence");
                        }
                        aVar.c(((i6 >> 8) * 192) + (i6 & 255), 13);
                    } else {
                        i9 = 49472;
                    }
                }
                i6 = i8 - i9;
                if (i6 != -1) {
                }
            }
        } catch (UnsupportedEncodingException e6) {
            throw new s(e6);
        }
    }

    static void f(int i6, j jVar, h hVar, s3.a aVar) {
        int characterCountBits = hVar.getCharacterCountBits(jVar);
        int i7 = 1 << characterCountBits;
        if (i6 < i7) {
            aVar.c(i6, characterCountBits);
            return;
        }
        throw new s(i6 + " is bigger than " + (i7 - 1));
    }

    static void g(h hVar, s3.a aVar) {
        aVar.c(hVar.getBits(), 4);
    }

    static void h(CharSequence charSequence, s3.a aVar) {
        int length = charSequence.length();
        int i6 = 0;
        while (i6 < length) {
            int charAt = charSequence.charAt(i6) - '0';
            int i7 = i6 + 2;
            if (i7 < length) {
                aVar.c((charAt * 100) + ((charSequence.charAt(i6 + 1) - '0') * 10) + (charSequence.charAt(i7) - '0'), 10);
                i6 += 3;
            } else {
                i6++;
                if (i6 < length) {
                    aVar.c((charAt * 10) + (charSequence.charAt(i6) - '0'), 7);
                    i6 = i7;
                } else {
                    aVar.c(charAt, 4);
                }
            }
        }
    }

    private static int i(h hVar, s3.a aVar, s3.a aVar2, j jVar) {
        return aVar.g() + hVar.getCharacterCountBits(jVar) + aVar2.g();
    }

    private static int j(b bVar) {
        return d.a(bVar) + d.c(bVar) + d.d(bVar) + d.e(bVar);
    }

    private static int k(s3.a aVar, com.google.zxing.qrcode.decoder.f fVar, j jVar, b bVar) {
        int i6 = Integer.MAX_VALUE;
        int i7 = -1;
        for (int i8 = 0; i8 < 8; i8++) {
            e.a(aVar, fVar, jVar, i8, bVar);
            int j6 = j(bVar);
            if (j6 < i6) {
                i7 = i8;
                i6 = j6;
            }
        }
        return i7;
    }

    private static h l(String str, String str2) {
        if ("Shift_JIS".equals(str2) && s(str)) {
            return h.KANJI;
        }
        boolean z5 = false;
        boolean z6 = false;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt >= '0' && charAt <= '9') {
                z6 = true;
            } else if (p(charAt) == -1) {
                return h.BYTE;
            } else {
                z5 = true;
            }
        }
        return z5 ? h.ALPHANUMERIC : z6 ? h.NUMERIC : h.BYTE;
    }

    private static j m(int i6, com.google.zxing.qrcode.decoder.f fVar) {
        for (int i7 = 1; i7 <= 40; i7++) {
            j i8 = j.i(i7);
            if (v(i6, i8, fVar)) {
                return i8;
            }
        }
        throw new s("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f n(String str, com.google.zxing.qrcode.decoder.f fVar, Map map) {
        j t5;
        s3.d characterSetECIByName;
        boolean z5 = true;
        boolean z6 = map != null && map.containsKey(g.CHARACTER_SET);
        String obj = z6 ? map.get(g.CHARACTER_SET).toString() : "ISO-8859-1";
        h l6 = l(str, obj);
        s3.a aVar = new s3.a();
        h hVar = h.BYTE;
        if (l6 == hVar && ((z6 || !"ISO-8859-1".equals(obj)) && (characterSetECIByName = s3.d.getCharacterSetECIByName(obj)) != null)) {
            d(characterSetECIByName, aVar);
        }
        if (((map == null || !map.containsKey(g.GS1_FORMAT)) ? false : false) && Boolean.valueOf(map.get(g.GS1_FORMAT).toString()).booleanValue()) {
            g(h.FNC1_FIRST_POSITION, aVar);
        }
        g(l6, aVar);
        s3.a aVar2 = new s3.a();
        c(str, l6, aVar2, obj);
        if (map != null) {
            g gVar = g.QR_VERSION;
            if (map.containsKey(gVar)) {
                t5 = j.i(Integer.parseInt(map.get(gVar).toString()));
                if (!v(i(l6, aVar, aVar2, t5), t5, fVar)) {
                    throw new s("Data too big for requested version");
                }
                s3.a aVar3 = new s3.a();
                aVar3.b(aVar);
                f(l6 != hVar ? aVar2.h() : str.length(), t5, l6, aVar3);
                aVar3.b(aVar2);
                j.b f6 = t5.f(fVar);
                int h6 = t5.h() - f6.d();
                u(h6, aVar3);
                s3.a r5 = r(aVar3, t5.h(), h6, f6.c());
                f fVar2 = new f();
                fVar2.c(fVar);
                fVar2.f(l6);
                fVar2.g(t5);
                int e6 = t5.e();
                b bVar = new b(e6, e6);
                int k6 = k(r5, fVar, t5, bVar);
                fVar2.d(k6);
                e.a(r5, fVar, t5, k6, bVar);
                fVar2.e(bVar);
                return fVar2;
            }
        }
        t5 = t(fVar, l6, aVar, aVar2);
        s3.a aVar32 = new s3.a();
        aVar32.b(aVar);
        f(l6 != hVar ? aVar2.h() : str.length(), t5, l6, aVar32);
        aVar32.b(aVar2);
        j.b f62 = t5.f(fVar);
        int h62 = t5.h() - f62.d();
        u(h62, aVar32);
        s3.a r52 = r(aVar32, t5.h(), h62, f62.c());
        f fVar22 = new f();
        fVar22.c(fVar);
        fVar22.f(l6);
        fVar22.g(t5);
        int e62 = t5.e();
        b bVar2 = new b(e62, e62);
        int k62 = k(r52, fVar, t5, bVar2);
        fVar22.d(k62);
        e.a(r52, fVar, t5, k62, bVar2);
        fVar22.e(bVar2);
        return fVar22;
    }

    static byte[] o(byte[] bArr, int i6) {
        int length = bArr.length;
        int[] iArr = new int[length + i6];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = bArr[i7] & 255;
        }
        new u3.d(u3.a.f13609l).b(iArr, i6);
        byte[] bArr2 = new byte[i6];
        for (int i8 = 0; i8 < i6; i8++) {
            bArr2[i8] = (byte) iArr[length + i8];
        }
        return bArr2;
    }

    static int p(int i6) {
        int[] iArr = f3026a;
        if (i6 < iArr.length) {
            return iArr[i6];
        }
        return -1;
    }

    static void q(int i6, int i7, int i8, int i9, int[] iArr, int[] iArr2) {
        if (i9 >= i8) {
            throw new s("Block ID too large");
        }
        int i10 = i6 % i8;
        int i11 = i8 - i10;
        int i12 = i6 / i8;
        int i13 = i12 + 1;
        int i14 = i7 / i8;
        int i15 = i14 + 1;
        int i16 = i12 - i14;
        int i17 = i13 - i15;
        if (i16 != i17) {
            throw new s("EC bytes mismatch");
        }
        if (i8 != i11 + i10) {
            throw new s("RS blocks mismatch");
        }
        if (i6 != ((i14 + i16) * i11) + ((i15 + i17) * i10)) {
            throw new s("Total bytes mismatch");
        }
        if (i9 < i11) {
            iArr[0] = i14;
            iArr2[0] = i16;
            return;
        }
        iArr[0] = i15;
        iArr2[0] = i17;
    }

    static s3.a r(s3.a aVar, int i6, int i7, int i8) {
        if (aVar.h() == i7) {
            ArrayList<b4.a> arrayList = new ArrayList(i8);
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                q(i6, i7, i8, i12, iArr, iArr2);
                int i13 = iArr[0];
                byte[] bArr = new byte[i13];
                aVar.j(i9 << 3, bArr, 0, i13);
                byte[] o5 = o(bArr, iArr2[0]);
                arrayList.add(new b4.a(bArr, o5));
                i10 = Math.max(i10, i13);
                i11 = Math.max(i11, o5.length);
                i9 += iArr[0];
            }
            if (i7 == i9) {
                s3.a aVar2 = new s3.a();
                for (int i14 = 0; i14 < i10; i14++) {
                    for (b4.a aVar3 : arrayList) {
                        byte[] a6 = aVar3.a();
                        if (i14 < a6.length) {
                            aVar2.c(a6[i14], 8);
                        }
                    }
                }
                for (int i15 = 0; i15 < i11; i15++) {
                    for (b4.a aVar4 : arrayList) {
                        byte[] b6 = aVar4.b();
                        if (i15 < b6.length) {
                            aVar2.c(b6[i15], 8);
                        }
                    }
                }
                if (i6 == aVar2.h()) {
                    return aVar2;
                }
                throw new s("Interleaving error: " + i6 + " and " + aVar2.h() + " differ.");
            }
            throw new s("Data bytes does not match offset");
        }
        throw new s("Number of bits and data bytes does not match");
    }

    private static boolean s(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i6 = 0; i6 < length; i6 += 2) {
                int i7 = bytes[i6] & 255;
                if ((i7 < 129 || i7 > 159) && (i7 < 224 || i7 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static j t(com.google.zxing.qrcode.decoder.f fVar, h hVar, s3.a aVar, s3.a aVar2) {
        return m(i(hVar, aVar, aVar2, m(i(hVar, aVar, aVar2, j.i(1)), fVar)), fVar);
    }

    static void u(int i6, s3.a aVar) {
        int i7 = i6 << 3;
        if (aVar.g() > i7) {
            throw new s("data bits cannot fit in the QR Code" + aVar.g() + " > " + i7);
        }
        for (int i8 = 0; i8 < 4 && aVar.g() < i7; i8++) {
            aVar.a(false);
        }
        int g6 = aVar.g() & 7;
        if (g6 > 0) {
            while (g6 < 8) {
                aVar.a(false);
                g6++;
            }
        }
        int h6 = i6 - aVar.h();
        for (int i9 = 0; i9 < h6; i9++) {
            aVar.c((i9 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.g() != i7) {
            throw new s("Bits size does not equal capacity");
        }
    }

    private static boolean v(int i6, j jVar, com.google.zxing.qrcode.decoder.f fVar) {
        return jVar.h() - jVar.f(fVar).d() >= (i6 + 7) / 8;
    }
}
