package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.jvm.internal.l;
import kotlin.text.w;
import kotlin.text.x;
import okio.Buffer;
/* loaded from: classes.dex */
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int N;
        int length = str.length();
        int i6 = 0;
        while (i6 < length) {
            int i7 = i6 + 1;
            char charAt = str.charAt(i6);
            if (l.e(charAt, 31) <= 0 || l.e(charAt, 127) >= 0) {
                return true;
            }
            N = x.N(" #%/:?@[\\]", charAt, 0, false, 6, null);
            if (N != -1) {
                return true;
            }
            i6 = i7;
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i6, int i7, byte[] bArr, int i8) {
        int i9 = i8;
        while (i6 < i7) {
            if (i9 == bArr.length) {
                return false;
            }
            if (i9 != i8) {
                if (str.charAt(i6) != '.') {
                    return false;
                }
                i6++;
            }
            int i10 = i6;
            int i11 = 0;
            while (i10 < i7) {
                char charAt = str.charAt(i10);
                if (l.e(charAt, 48) < 0 || l.e(charAt, 57) > 0) {
                    break;
                } else if ((i11 == 0 && i6 != i10) || (i11 = ((i11 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i10++;
                }
            }
            if (i10 - i6 == 0) {
                return false;
            }
            bArr[i9] = (byte) i11;
            i9++;
            i6 = i10;
        }
        return i9 == i8 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:
        if (r13 == 16) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0099, code lost:
        if (r14 != (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009c, code lost:
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ad, code lost:
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final InetAddress decodeIpv6(String str, int i6, int i7) {
        boolean x5;
        boolean x6;
        int i8;
        boolean x7;
        byte[] bArr = new byte[16];
        int i9 = i6;
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        while (true) {
            if (i9 < i7) {
                if (i10 != 16) {
                    int i13 = i9 + 2;
                    if (i13 <= i7) {
                        x7 = w.x(str, "::", i9, false, 4, null);
                        if (x7) {
                            if (i11 != -1) {
                                return null;
                            }
                            i10 += 2;
                            if (i13 == i7) {
                                i11 = i10;
                                break;
                            }
                            i12 = i13;
                            i11 = i10;
                            i9 = i12;
                            int i14 = 0;
                            while (i9 < i7) {
                                int parseHexDigit = Util.parseHexDigit(str.charAt(i9));
                                if (parseHexDigit == -1) {
                                    break;
                                }
                                i14 = (i14 << 4) + parseHexDigit;
                                i9++;
                            }
                            i8 = i9 - i12;
                            if (i8 == 0 || i8 > 4) {
                                break;
                            }
                            int i15 = i10 + 1;
                            bArr[i10] = (byte) ((i14 >>> 8) & 255);
                            i10 = i15 + 1;
                            bArr[i15] = (byte) (i14 & 255);
                        }
                    }
                    if (i10 != 0) {
                        x5 = w.x(str, ":", i9, false, 4, null);
                        if (x5) {
                            i9++;
                        } else {
                            x6 = w.x(str, ".", i9, false, 4, null);
                            if (!x6 || !decodeIpv4Suffix(str, i12, i7, bArr, i10 - 2)) {
                                return null;
                            }
                            i10 += 2;
                        }
                    }
                    i12 = i9;
                    i9 = i12;
                    int i142 = 0;
                    while (i9 < i7) {
                    }
                    i8 = i9 - i12;
                    if (i8 == 0) {
                        break;
                    }
                    break;
                }
                return null;
            }
            break;
        }
        return null;
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i6 = -1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < bArr.length) {
            int i10 = i8;
            while (i10 < 16 && bArr[i10] == 0 && bArr[i10 + 1] == 0) {
                i10 += 2;
            }
            int i11 = i10 - i8;
            if (i11 > i9 && i11 >= 4) {
                i6 = i8;
                i9 = i11;
            }
            i8 = i10 + 2;
        }
        Buffer buffer = new Buffer();
        while (i7 < bArr.length) {
            if (i7 == i6) {
                buffer.writeByte(58);
                i7 += i9;
                if (i7 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i7 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((Util.and(bArr[i7], 255) << 8) | Util.and(bArr[i7 + 1], 255));
                i7 += 2;
            }
        }
        return buffer.readUtf8();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String toCanonicalHost(String str) {
        boolean D;
        boolean y5;
        InetAddress decodeIpv6;
        boolean k6;
        l.d(str, "<this>");
        D = x.D(str, ":", false, 2, null);
        if (!D) {
            try {
                String ascii = IDN.toASCII(str);
                l.c(ascii, "toASCII(host)");
                Locale locale = Locale.US;
                l.c(locale, "US");
                String lowerCase = ascii.toLowerCase(locale);
                l.c(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    return null;
                }
                if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        y5 = w.y(str, "[", false, 2, null);
        if (y5) {
            k6 = w.k(str, "]", false, 2, null);
            if (k6) {
                decodeIpv6 = decodeIpv6(str, 1, str.length() - 1);
                if (decodeIpv6 != null) {
                    return null;
                }
                byte[] address = decodeIpv6.getAddress();
                if (address.length == 16) {
                    l.c(address, "address");
                    return inet6AddressToAscii(address);
                } else if (address.length == 4) {
                    return decodeIpv6.getHostAddress();
                } else {
                    throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
                }
            }
        }
        decodeIpv6 = decodeIpv6(str, 0, str.length());
        if (decodeIpv6 != null) {
        }
    }
}
