package z3;

import com.google.zxing.s;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import okio.Utf8;
/* loaded from: classes.dex */
abstract class f {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f14373c;

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f14371a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f14372b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, Utf8.REPLACEMENT_BYTE, 123, 125, 39, 0};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f14374d = new byte[128];

    /* renamed from: e  reason: collision with root package name */
    private static final Charset f14375e = StandardCharsets.ISO_8859_1;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14376a;

        static {
            int[] iArr = new int[c.values().length];
            f14376a = iArr;
            try {
                iArr[c.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14376a[c.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14376a[c.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        byte[] bArr = new byte[128];
        f14373c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i6 = 0;
        int i7 = 0;
        while (true) {
            byte[] bArr2 = f14371a;
            if (i7 >= bArr2.length) {
                break;
            }
            byte b6 = bArr2[i7];
            if (b6 > 0) {
                f14373c[b6] = (byte) i7;
            }
            i7++;
        }
        Arrays.fill(f14374d, (byte) -1);
        while (true) {
            byte[] bArr3 = f14372b;
            if (i6 >= bArr3.length) {
                return;
            }
            byte b7 = bArr3[i6];
            if (b7 > 0) {
                f14374d[b7] = (byte) i6;
            }
            i6++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
        return r1 - r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(String str, int i6, Charset charset) {
        int i7;
        CharsetEncoder newEncoder = charset.newEncoder();
        int length = str.length();
        int i8 = i6;
        while (i8 < length) {
            char charAt = str.charAt(i8);
            int i9 = 0;
            while (i9 < 13 && k(charAt) && (i7 = i8 + (i9 = i9 + 1)) < length) {
                charAt = str.charAt(i7);
            }
            char charAt2 = str.charAt(i8);
            if (!newEncoder.canEncode(charAt2)) {
                throw new s("Non-encodable character detected: " + charAt2 + " (Unicode: " + ((int) charAt2) + ')');
            }
            i8++;
        }
        return i8 - i6;
    }

    private static int b(CharSequence charSequence, int i6) {
        int length = charSequence.length();
        int i7 = 0;
        if (i6 < length) {
            loop0: while (true) {
                char charAt = charSequence.charAt(i6);
                while (k(charAt) && i6 < length) {
                    i7++;
                    i6++;
                    if (i6 < length) {
                        break;
                    }
                }
            }
        }
        return i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        return (r1 - r7) - r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int c(CharSequence charSequence, int i6) {
        int length = charSequence.length();
        int i7 = i6;
        while (i7 < length) {
            char charAt = charSequence.charAt(i7);
            int i8 = 0;
            while (i8 < 13 && k(charAt) && i7 < length) {
                i8++;
                i7++;
                if (i7 < length) {
                    charAt = charSequence.charAt(i7);
                }
            }
            if (i8 <= 0) {
                if (!n(charSequence.charAt(i7))) {
                    break;
                }
                i7++;
            }
        }
        return i7 - i6;
    }

    private static void d(byte[] bArr, int i6, int i7, int i8, StringBuilder sb) {
        int i9;
        sb.append((i7 == 1 && i8 == 0) ? (char) 913 : i7 % 6 == 0 ? (char) 924 : (char) 901);
        if (i7 >= 6) {
            char[] cArr = new char[5];
            i9 = i6;
            while ((i6 + i7) - i9 >= 6) {
                long j6 = 0;
                for (int i10 = 0; i10 < 6; i10++) {
                    j6 = (j6 << 8) + (bArr[i9 + i10] & 255);
                }
                for (int i11 = 0; i11 < 5; i11++) {
                    cArr[i11] = (char) (j6 % 900);
                    j6 /= 900;
                }
                for (int i12 = 4; i12 >= 0; i12--) {
                    sb.append(cArr[i12]);
                }
                i9 += 6;
            }
        } else {
            i9 = i6;
        }
        while (i9 < i6 + i7) {
            sb.append((char) (bArr[i9] & 255));
            i9++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(String str, c cVar, Charset charset) {
        s3.d characterSetECIByName;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = f14375e;
        } else if (!f14375e.equals(charset) && (characterSetECIByName = s3.d.getCharacterSetECIByName(charset.name())) != null) {
            h(characterSetECIByName.getValue(), sb);
        }
        int length = str.length();
        int i6 = a.f14376a[cVar.ordinal()];
        if (i6 == 1) {
            g(str, 0, length, sb, 0);
        } else if (i6 == 2) {
            byte[] bytes = str.getBytes(charset);
            d(bytes, 0, bytes.length, 1, sb);
        } else if (i6 != 3) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < length) {
                int b6 = b(str, i7);
                if (b6 >= 13) {
                    sb.append((char) 902);
                    f(str, i7, b6, sb);
                    i7 += b6;
                    i8 = 0;
                    i9 = 2;
                } else {
                    int c6 = c(str, i7);
                    if (c6 >= 5 || b6 == length) {
                        if (i9 != 0) {
                            sb.append((char) 900);
                            i8 = 0;
                            i9 = 0;
                        }
                        i8 = g(str, i7, c6, sb, i8);
                        i7 += c6;
                    } else {
                        int a6 = a(str, i7, charset);
                        if (a6 == 0) {
                            a6 = 1;
                        }
                        int i10 = a6 + i7;
                        byte[] bytes2 = str.substring(i7, i10).getBytes(charset);
                        if (bytes2.length == 1 && i9 == 0) {
                            d(bytes2, 0, 1, 0, sb);
                        } else {
                            d(bytes2, 0, bytes2.length, i9, sb);
                            i8 = 0;
                            i9 = 1;
                        }
                        i7 = i10;
                    }
                }
            }
        } else {
            sb.append((char) 902);
            f(str, 0, length, sb);
        }
        return sb.toString();
    }

    private static void f(String str, int i6, int i7, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i7 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i8 = 0;
        while (i8 < i7) {
            sb2.setLength(0);
            int min = Math.min(44, i7 - i8);
            StringBuilder sb3 = new StringBuilder("1");
            int i9 = i6 + i8;
            sb3.append(str.substring(i9, i9 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i8 += min;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a0, code lost:
        if (r8 == ' ') goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int g(CharSequence charSequence, int i6, int i7, StringBuilder sb, int i8) {
        byte b6;
        int i9;
        char c6;
        StringBuilder sb2 = new StringBuilder(i7);
        int i10 = i8;
        int i11 = 0;
        while (true) {
            int i12 = i6 + i11;
            char charAt = charSequence.charAt(i12);
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (m(charAt)) {
                            b6 = f14374d[charAt];
                        } else {
                            sb2.append((char) 29);
                            i10 = 0;
                        }
                    } else if (l(charAt)) {
                        b6 = f14373c[charAt];
                    } else if (j(charAt)) {
                        sb2.append((char) 28);
                        i10 = 0;
                    } else if (i(charAt)) {
                        sb2.append((char) 27);
                        i10 = 1;
                    } else {
                        int i13 = i12 + 1;
                        if (i13 >= i7 || !m(charSequence.charAt(i13))) {
                            sb2.append((char) 29);
                            b6 = f14374d[charAt];
                        } else {
                            sb2.append((char) 25);
                            i10 = 3;
                        }
                    }
                } else if (i(charAt)) {
                    if (charAt != ' ') {
                        i9 = charAt - 'a';
                        c6 = (char) i9;
                        sb2.append(c6);
                    }
                    sb2.append((char) 26);
                } else if (j(charAt)) {
                    sb2.append((char) 27);
                    i9 = charAt - 'A';
                    c6 = (char) i9;
                    sb2.append(c6);
                } else if (l(charAt)) {
                    sb2.append((char) 28);
                    i10 = 2;
                } else {
                    sb2.append((char) 29);
                    b6 = f14374d[charAt];
                }
                c6 = (char) b6;
                sb2.append(c6);
            } else if (!j(charAt)) {
                if (i(charAt)) {
                    sb2.append((char) 27);
                    i10 = 1;
                } else if (l(charAt)) {
                    sb2.append((char) 28);
                    i10 = 2;
                } else {
                    sb2.append((char) 29);
                    b6 = f14374d[charAt];
                    c6 = (char) b6;
                    sb2.append(c6);
                }
            }
            i11++;
            if (i11 >= i7) {
                break;
            }
        }
        int length = sb2.length();
        char c7 = 0;
        for (int i14 = 0; i14 < length; i14++) {
            if (i14 % 2 != 0) {
                c7 = (char) ((c7 * 30) + sb2.charAt(i14));
                sb.append(c7);
            } else {
                c7 = sb2.charAt(i14);
            }
        }
        if (length % 2 != 0) {
            sb.append((char) ((c7 * 30) + 29));
        }
        return i10;
    }

    private static void h(int i6, StringBuilder sb) {
        char c6;
        if (i6 >= 0 && i6 < 900) {
            sb.append((char) 927);
        } else if (i6 >= 810900) {
            if (i6 >= 811800) {
                throw new s("ECI number not in valid range from 0..811799, but was " + i6);
            }
            sb.append((char) 925);
            c6 = (char) (810900 - i6);
            sb.append(c6);
        } else {
            sb.append((char) 926);
            sb.append((char) ((i6 / 900) - 1));
            i6 %= 900;
        }
        c6 = (char) i6;
        sb.append(c6);
    }

    private static boolean i(char c6) {
        if (c6 != ' ') {
            return c6 >= 'a' && c6 <= 'z';
        }
        return true;
    }

    private static boolean j(char c6) {
        if (c6 != ' ') {
            return c6 >= 'A' && c6 <= 'Z';
        }
        return true;
    }

    private static boolean k(char c6) {
        return c6 >= '0' && c6 <= '9';
    }

    private static boolean l(char c6) {
        return f14373c[c6] != -1;
    }

    private static boolean m(char c6) {
        return f14374d[c6] != -1;
    }

    private static boolean n(char c6) {
        if (c6 == '\t' || c6 == '\n' || c6 == '\r') {
            return true;
        }
        return c6 >= ' ' && c6 <= '~';
    }
}
