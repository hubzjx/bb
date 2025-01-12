package w3;
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14118a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};

    /* renamed from: b  reason: collision with root package name */
    private static final int[][] f14119b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, 223, 248, b.j.F0, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, b.j.J0}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, b.j.I0, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, androidx.constraintlayout.widget.g.Z0, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, b.j.N0, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, androidx.constraintlayout.widget.g.V0, 174, 37, 151, 170, 53, 75, 34, 249, b.j.K0, 17, 138, 110, 213, 141, 136, b.j.J0, 151, 233, 168, 93, 255}, new int[]{245, 127, 242, 218, 130, 250, 162, 181, androidx.constraintlayout.widget.g.U0, b.j.J0, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, androidx.constraintlayout.widget.g.T0, 137, 95, b.j.I0, b.j.E0, 44, 175, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, 105, b.j.L0, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, b.j.K0, 21, 1, 253, 57, 54, androidx.constraintlayout.widget.g.T0, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, b.j.G0, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, androidx.constraintlayout.widget.g.X0, 16, 147, b.j.H0, 23, 37, 90, 170, 205, 131, 88, b.j.J0, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, b.j.G0, 203, 29, 232, 144, 238, 22, 150, 201, b.j.G0, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, androidx.constraintlayout.widget.g.Y0, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, b.j.H0, 202, 188, 201, 189, 143, androidx.constraintlayout.widget.g.Z0, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, 250, androidx.constraintlayout.widget.g.X0, 185, 221, 175, 64, b.j.D0, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, androidx.constraintlayout.widget.g.Y0, 232, 7, 94, 166, 224, b.j.N0, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, b.j.L0, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, androidx.constraintlayout.widget.g.Z0, 153, 132, 63, 96, androidx.constraintlayout.widget.g.V0, 82, 186}};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f14120c = new int[256];

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f14121d = new int[255];

    static {
        int i6 = 1;
        for (int i7 = 0; i7 < 255; i7++) {
            f14121d[i7] = i6;
            f14120c[i6] = i7;
            i6 <<= 1;
            if (i6 >= 256) {
                i6 ^= 301;
            }
        }
    }

    private static String a(CharSequence charSequence, int i6) {
        return b(charSequence, 0, charSequence.length(), i6);
    }

    private static String b(CharSequence charSequence, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11 = 0;
        while (true) {
            int[] iArr = f14118a;
            if (i11 >= iArr.length) {
                i11 = -1;
                break;
            } else if (iArr[i11] == i8) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i8);
        }
        int[] iArr2 = f14119b[i11];
        char[] cArr = new char[i8];
        for (int i12 = 0; i12 < i8; i12++) {
            cArr[i12] = 0;
        }
        for (int i13 = i6; i13 < i6 + i7; i13++) {
            int i14 = i8 - 1;
            int charAt = cArr[i14] ^ charSequence.charAt(i13);
            while (i14 > 0) {
                if (charAt == 0 || (i10 = iArr2[i14]) == 0) {
                    cArr[i14] = cArr[i14 - 1];
                } else {
                    char c6 = cArr[i14 - 1];
                    int[] iArr3 = f14121d;
                    int[] iArr4 = f14120c;
                    cArr[i14] = (char) (iArr3[(iArr4[charAt] + iArr4[i10]) % 255] ^ c6);
                }
                i14--;
            }
            if (charAt == 0 || (i9 = iArr2[0]) == 0) {
                cArr[0] = 0;
            } else {
                int[] iArr5 = f14121d;
                int[] iArr6 = f14120c;
                cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[i9]) % 255];
            }
        }
        char[] cArr2 = new char[i8];
        for (int i15 = 0; i15 < i8; i15++) {
            cArr2[i15] = cArr[(i8 - i15) - 1];
        }
        return String.valueOf(cArr2);
    }

    public static String c(String str, k kVar) {
        if (str.length() == kVar.a()) {
            StringBuilder sb = new StringBuilder(kVar.a() + kVar.c());
            sb.append(str);
            int f6 = kVar.f();
            if (f6 == 1) {
                sb.append(a(str, kVar.c()));
            } else {
                sb.setLength(sb.capacity());
                int[] iArr = new int[f6];
                int[] iArr2 = new int[f6];
                int[] iArr3 = new int[f6];
                int i6 = 0;
                while (i6 < f6) {
                    int i7 = i6 + 1;
                    iArr[i6] = kVar.b(i7);
                    iArr2[i6] = kVar.d(i7);
                    iArr3[i6] = 0;
                    if (i6 > 0) {
                        iArr3[i6] = iArr3[i6 - 1] + iArr[i6];
                    }
                    i6 = i7;
                }
                for (int i8 = 0; i8 < f6; i8++) {
                    StringBuilder sb2 = new StringBuilder(iArr[i8]);
                    for (int i9 = i8; i9 < kVar.a(); i9 += f6) {
                        sb2.append(str.charAt(i9));
                    }
                    String a6 = a(sb2.toString(), iArr2[i8]);
                    int i10 = i8;
                    int i11 = 0;
                    while (i10 < iArr2[i8] * f6) {
                        sb.setCharAt(kVar.a() + i10, a6.charAt(i11));
                        i10 += f6;
                        i11++;
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }
}
