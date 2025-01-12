package b4;
/* loaded from: classes.dex */
abstract class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(b bVar) {
        return b(bVar, true) + b(bVar, false);
    }

    private static int b(b bVar, boolean z5) {
        int d6 = z5 ? bVar.d() : bVar.e();
        int e6 = z5 ? bVar.e() : bVar.d();
        byte[][] c6 = bVar.c();
        int i6 = 0;
        for (int i7 = 0; i7 < d6; i7++) {
            byte b6 = -1;
            int i8 = 0;
            for (int i9 = 0; i9 < e6; i9++) {
                byte b7 = z5 ? c6[i7][i9] : c6[i9][i7];
                if (b7 == b6) {
                    i8++;
                } else {
                    if (i8 >= 5) {
                        i6 += (i8 - 5) + 3;
                    }
                    b6 = b7;
                    i8 = 1;
                }
            }
            if (i8 >= 5) {
                i6 += (i8 - 5) + 3;
            }
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(b bVar) {
        byte[][] c6 = bVar.c();
        int e6 = bVar.e();
        int d6 = bVar.d();
        int i6 = 0;
        for (int i7 = 0; i7 < d6 - 1; i7++) {
            byte[] bArr = c6[i7];
            int i8 = 0;
            while (i8 < e6 - 1) {
                byte b6 = bArr[i8];
                int i9 = i8 + 1;
                if (b6 == bArr[i9]) {
                    byte[] bArr2 = c6[i7 + 1];
                    if (b6 == bArr2[i8] && b6 == bArr2[i9]) {
                        i6++;
                    }
                }
                i8 = i9;
            }
        }
        return i6 * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(b bVar) {
        byte[][] c6 = bVar.c();
        int e6 = bVar.e();
        int d6 = bVar.d();
        int i6 = 0;
        for (int i7 = 0; i7 < d6; i7++) {
            for (int i8 = 0; i8 < e6; i8++) {
                byte[] bArr = c6[i7];
                int i9 = i8 + 6;
                if (i9 < e6 && bArr[i8] == 1 && bArr[i8 + 1] == 0 && bArr[i8 + 2] == 1 && bArr[i8 + 3] == 1 && bArr[i8 + 4] == 1 && bArr[i8 + 5] == 0 && bArr[i9] == 1 && (g(bArr, i8 - 4, i8) || g(bArr, i8 + 7, i8 + 11))) {
                    i6++;
                }
                int i10 = i7 + 6;
                if (i10 < d6 && c6[i7][i8] == 1 && c6[i7 + 1][i8] == 0 && c6[i7 + 2][i8] == 1 && c6[i7 + 3][i8] == 1 && c6[i7 + 4][i8] == 1 && c6[i7 + 5][i8] == 0 && c6[i10][i8] == 1 && (h(c6, i8, i7 - 4, i7) || h(c6, i8, i7 + 7, i7 + 11))) {
                    i6++;
                }
            }
        }
        return i6 * 40;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(b bVar) {
        byte[][] c6 = bVar.c();
        int e6 = bVar.e();
        int d6 = bVar.d();
        int i6 = 0;
        for (int i7 = 0; i7 < d6; i7++) {
            byte[] bArr = c6[i7];
            for (int i8 = 0; i8 < e6; i8++) {
                if (bArr[i8] == 1) {
                    i6++;
                }
            }
        }
        int d7 = bVar.d() * bVar.e();
        return ((Math.abs((i6 << 1) - d7) * 10) / d7) * 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean f(int i6, int i7, int i8) {
        int i9;
        int i10;
        switch (i6) {
            case 0:
                i8 += i7;
                i9 = i8 & 1;
                break;
            case 1:
                i9 = i8 & 1;
                break;
            case 2:
                i9 = i7 % 3;
                break;
            case 3:
                i9 = (i8 + i7) % 3;
                break;
            case 4:
                i8 /= 2;
                i7 /= 3;
                i8 += i7;
                i9 = i8 & 1;
                break;
            case 5:
                int i11 = i8 * i7;
                i9 = (i11 & 1) + (i11 % 3);
                break;
            case 6:
                int i12 = i8 * i7;
                i10 = (i12 & 1) + (i12 % 3);
                i9 = i10 & 1;
                break;
            case 7:
                i10 = ((i8 * i7) % 3) + ((i8 + i7) & 1);
                i9 = i10 & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: " + i6);
        }
        return i9 == 0;
    }

    private static boolean g(byte[] bArr, int i6, int i7) {
        int min = Math.min(i7, bArr.length);
        for (int max = Math.max(i6, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean h(byte[][] bArr, int i6, int i7, int i8) {
        int min = Math.min(i8, bArr.length);
        for (int max = Math.max(i7, 0); max < min; max++) {
            if (bArr[max][i6] == 1) {
                return false;
            }
        }
        return true;
    }
}
