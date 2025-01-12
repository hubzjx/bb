package x3;

import java.util.Map;
/* loaded from: classes.dex */
public final class f extends n {
    private static void f(int i6, int[] iArr) {
        for (int i7 = 0; i7 < 9; i7++) {
            int i8 = 1;
            if (((1 << (8 - i7)) & i6) != 0) {
                i8 = 2;
            }
            iArr[i7] = i8;
        }
    }

    private static String g(String str) {
        String str2;
        int i6;
        int i7;
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < length; i8++) {
            char charAt = str.charAt(i8);
            if (charAt != 0) {
                if (charAt != ' ') {
                    if (charAt == '@') {
                        str2 = "%V";
                    } else if (charAt == '`') {
                        str2 = "%W";
                    } else if (charAt != '-' && charAt != '.') {
                        if (charAt > 0 && charAt < 27) {
                            sb.append('$');
                            i7 = charAt - 1;
                        } else if (charAt > 26 && charAt < ' ') {
                            sb.append('%');
                            i7 = charAt - 27;
                        } else if ((charAt > ' ' && charAt < '-') || charAt == '/' || charAt == ':') {
                            sb.append('/');
                            i7 = charAt - '!';
                        } else {
                            if (charAt > '/' && charAt < ':') {
                                i6 = (charAt - '0') + 48;
                            } else if (charAt > ':' && charAt < '@') {
                                sb.append('%');
                                i6 = (charAt - ';') + 70;
                            } else if (charAt > '@' && charAt < '[') {
                                i7 = charAt - 'A';
                            } else if (charAt > 'Z' && charAt < '`') {
                                sb.append('%');
                                i6 = (charAt - '[') + 75;
                            } else if (charAt > '`' && charAt < '{') {
                                sb.append('+');
                                i7 = charAt - 'a';
                            } else if (charAt <= 'z' || charAt >= 128) {
                                throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i8) + "'");
                            } else {
                                sb.append('%');
                                i6 = (charAt - '{') + 80;
                            }
                            charAt = (char) i6;
                        }
                        i6 = i7 + 65;
                        charAt = (char) i6;
                    }
                }
                sb.append(charAt);
            } else {
                str2 = "%U";
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    @Override // x3.n, com.google.zxing.r
    public s3.b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        if (aVar == com.google.zxing.a.CODE_39) {
            return super.a(str, aVar, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + aVar);
    }

    @Override // x3.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                break;
            } else if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i6)) < 0) {
                str = g(str);
                length = str.length();
                if (length > 80) {
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                }
            } else {
                i6++;
            }
        }
        int[] iArr = new int[9];
        int i7 = length + 25;
        for (int i8 = 0; i8 < length; i8++) {
            f(e.f14203a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i8))], iArr);
            for (int i9 = 0; i9 < 9; i9++) {
                i7 += iArr[i9];
            }
        }
        boolean[] zArr = new boolean[i7];
        f(148, iArr);
        int b6 = n.b(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int b7 = b6 + n.b(zArr, b6, iArr2, false);
        for (int i10 = 0; i10 < length; i10++) {
            f(e.f14203a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i10))], iArr);
            int b8 = b7 + n.b(zArr, b7, iArr, true);
            b7 = b8 + n.b(zArr, b8, iArr2, false);
        }
        f(148, iArr);
        n.b(zArr, b7, iArr, true);
        return zArr;
    }
}
