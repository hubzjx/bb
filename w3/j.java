package w3;

import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class j {
    public static int a(CharSequence charSequence, int i6) {
        int length = charSequence.length();
        int i7 = 0;
        if (i6 < length) {
            loop0: while (true) {
                char charAt = charSequence.charAt(i6);
                while (f(charAt) && i6 < length) {
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8 A[LOOP:1: B:27:0x00b2->B:29:0x00b8, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str, l lVar, com.google.zxing.f fVar, com.google.zxing.f fVar2) {
        int a6;
        int a7;
        StringBuilder b6;
        char c6;
        int i6 = 0;
        g[] gVarArr = {new a(), new c(), new m(), new n(), new f(), new b()};
        h hVar = new h(str);
        hVar.n(lVar);
        hVar.l(fVar, fVar2);
        if (!str.startsWith("[)>\u001e05\u001d") || !str.endsWith("\u001e\u0004")) {
            c6 = (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) ? (char) 237 : (char) 237;
            while (hVar.i()) {
                gVarArr[i6].a(hVar);
                if (hVar.e() >= 0) {
                    i6 = hVar.e();
                    hVar.j();
                }
            }
            a6 = hVar.a();
            hVar.p();
            a7 = hVar.g().a();
            if (a6 < a7 && i6 != 0 && i6 != 5 && i6 != 4) {
                hVar.r((char) 254);
            }
            b6 = hVar.b();
            if (b6.length() < a7) {
                b6.append((char) 129);
            }
            while (b6.length() < a7) {
                b6.append(o((char) 129, b6.length() + 1));
            }
            return hVar.b().toString();
        }
        c6 = 236;
        hVar.r(c6);
        hVar.m(2);
        hVar.f14114d += 7;
        while (hVar.i()) {
        }
        a6 = hVar.a();
        hVar.p();
        a7 = hVar.g().a();
        if (a6 < a7) {
            hVar.r((char) 254);
        }
        b6 = hVar.b();
        if (b6.length() < a7) {
        }
        while (b6.length() < a7) {
        }
        return hVar.b().toString();
    }

    private static int c(float[] fArr, int[] iArr, int i6, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i7 = 0; i7 < 6; i7++) {
            int ceil = (int) Math.ceil(fArr[i7]);
            iArr[i7] = ceil;
            if (i6 > ceil) {
                Arrays.fill(bArr, (byte) 0);
                i6 = ceil;
            }
            if (i6 == ceil) {
                bArr[i7] = (byte) (bArr[i7] + 1);
            }
        }
        return i6;
    }

    private static int d(byte[] bArr) {
        int i6 = 0;
        for (int i7 = 0; i7 < 6; i7++) {
            i6 += bArr[i7];
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(char c6) {
        String hexString;
        throw new IllegalArgumentException("Illegal character: " + c6 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + Integer.toHexString(c6)) + ')');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(char c6) {
        return c6 >= '0' && c6 <= '9';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(char c6) {
        return c6 >= 128 && c6 <= 255;
    }

    private static boolean h(char c6) {
        if (c6 != ' ') {
            if (c6 < '0' || c6 > '9') {
                return c6 >= 'A' && c6 <= 'Z';
            }
            return true;
        }
        return true;
    }

    private static boolean i(char c6) {
        return c6 >= ' ' && c6 <= '^';
    }

    private static boolean j(char c6) {
        if (c6 != ' ') {
            if (c6 < '0' || c6 > '9') {
                return c6 >= 'a' && c6 <= 'z';
            }
            return true;
        }
        return true;
    }

    private static boolean k(char c6) {
        if (m(c6) || c6 == ' ') {
            return true;
        }
        if (c6 < '0' || c6 > '9') {
            return c6 >= 'A' && c6 <= 'Z';
        }
        return true;
    }

    private static boolean l(char c6) {
        return false;
    }

    private static boolean m(char c6) {
        return c6 == '\r' || c6 == '*' || c6 == '>';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(CharSequence charSequence, int i6, int i7) {
        char c6;
        if (i6 >= charSequence.length()) {
            return i7;
        }
        int i8 = 6;
        float[] fArr = {1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
        if (i7 == 0) {
            // fill-array-data instruction
            fArr[0] = 0.0f;
            fArr[1] = 1.0f;
            fArr[2] = 1.0f;
            fArr[3] = 1.0f;
            fArr[4] = 1.0f;
            fArr[5] = 1.25f;
        } else {
            fArr[i7] = 0.0f;
        }
        int i9 = 0;
        while (true) {
            int i10 = i6 + i9;
            if (i10 == charSequence.length()) {
                byte[] bArr = new byte[i8];
                int[] iArr = new int[i8];
                int c7 = c(fArr, iArr, Integer.MAX_VALUE, bArr);
                int d6 = d(bArr);
                if (iArr[0] == c7) {
                    return 0;
                }
                if (d6 != 1 || bArr[5] <= 0) {
                    if (d6 != 1 || bArr[4] <= 0) {
                        if (d6 != 1 || bArr[2] <= 0) {
                            return (d6 != 1 || bArr[3] <= 0) ? 1 : 3;
                        }
                        return 2;
                    }
                    return 4;
                }
                return 5;
            }
            char charAt = charSequence.charAt(i10);
            i9++;
            if (f(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (g(charAt)) {
                float ceil = (float) Math.ceil(fArr[0]);
                fArr[0] = ceil;
                fArr[0] = ceil + 2.0f;
            } else {
                float ceil2 = (float) Math.ceil(fArr[0]);
                fArr[0] = ceil2;
                fArr[0] = ceil2 + 1.0f;
            }
            if (h(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (j(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (k(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (i(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (g(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (l(charAt)) {
                c6 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c6 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i9 >= 4) {
                int[] iArr2 = new int[i8];
                byte[] bArr2 = new byte[i8];
                c(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int d7 = d(bArr2);
                int i11 = iArr2[0];
                int i12 = iArr2[c6];
                if (i11 < i12 && i11 < iArr2[1] && i11 < iArr2[2] && i11 < iArr2[3] && i11 < iArr2[4]) {
                    return 0;
                }
                if (i12 < i11) {
                    return 5;
                }
                byte b6 = bArr2[1];
                byte b7 = bArr2[2];
                byte b8 = bArr2[3];
                byte b9 = bArr2[4];
                if (b6 + b7 + b8 + b9 == 0) {
                    return 5;
                }
                if (d7 == 1 && b9 > 0) {
                    return 4;
                }
                if (d7 == 1 && b7 > 0) {
                    return 2;
                }
                if (d7 == 1 && b8 > 0) {
                    return 3;
                }
                int i13 = iArr2[1];
                if (i13 + 1 < i11 && i13 + 1 < i12 && i13 + 1 < iArr2[4] && i13 + 1 < iArr2[2]) {
                    int i14 = iArr2[3];
                    if (i13 < i14) {
                        return 1;
                    }
                    if (i13 == i14) {
                        for (int i15 = i6 + i9 + 1; i15 < charSequence.length(); i15++) {
                            char charAt2 = charSequence.charAt(i15);
                            if (m(charAt2)) {
                                return 3;
                            }
                            if (!k(charAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
            i8 = 6;
        }
    }

    private static char o(char c6, int i6) {
        int i7 = c6 + ((i6 * 149) % 253) + 1;
        if (i7 > 254) {
            i7 -= 254;
        }
        return (char) i7;
    }
}
