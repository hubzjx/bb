package x3;

import io.jsonwebtoken.JwtParser;
/* loaded from: classes.dex */
public final class b extends n {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f14198a;

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f14199b = {'T', 'N', '*', 'E'};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f14200c = {'/', ':', '+', JwtParser.SEPARATOR_CHAR};

    /* renamed from: d  reason: collision with root package name */
    private static final char f14201d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f14198a = cArr;
        f14201d = cArr[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e7  */
    @Override // x3.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean[] c(String str) {
        StringBuilder sb;
        int i6;
        int i7;
        int i8;
        if (str.length() >= 2) {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f14198a;
            boolean a6 = a.a(cArr, upperCase);
            boolean a7 = a.a(cArr, upperCase2);
            char[] cArr2 = f14199b;
            boolean a8 = a.a(cArr2, upperCase);
            boolean a9 = a.a(cArr2, upperCase2);
            if (a6) {
                if (!a7) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (a8) {
                if (!a9) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (a7 || a9) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            } else {
                sb = new StringBuilder();
            }
            int i9 = 20;
            for (i6 = 1; i6 < str.length() - 1; i6++) {
                if (Character.isDigit(str.charAt(i6)) || str.charAt(i6) == '-' || str.charAt(i6) == '$') {
                    i9 += 9;
                } else if (!a.a(f14200c, str.charAt(i6))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i6) + '\'');
                } else {
                    i9 += 10;
                }
            }
            boolean[] zArr = new boolean[i9 + (str.length() - 1)];
            int i10 = 0;
            for (i7 = 0; i7 < str.length(); i7++) {
                char upperCase3 = Character.toUpperCase(str.charAt(i7));
                if (i7 == 0 || i7 == str.length() - 1) {
                    if (upperCase3 == '*') {
                        upperCase3 = 'C';
                    } else if (upperCase3 == 'E') {
                        upperCase3 = 'D';
                    } else if (upperCase3 == 'N') {
                        upperCase3 = 'B';
                    } else if (upperCase3 == 'T') {
                        upperCase3 = 'A';
                    }
                }
                int i11 = 0;
                while (true) {
                    char[] cArr3 = a.f14195a;
                    if (i11 >= cArr3.length) {
                        i8 = 0;
                        break;
                    } else if (upperCase3 == cArr3[i11]) {
                        i8 = a.f14196b[i11];
                        break;
                    } else {
                        i11++;
                    }
                }
                int i12 = 0;
                boolean z5 = true;
                while (true) {
                    int i13 = 0;
                    while (i12 < 7) {
                        zArr[i10] = z5;
                        i10++;
                        if (((i8 >> (6 - i12)) & 1) == 0 || i13 == 1) {
                            z5 = !z5;
                            i12++;
                        } else {
                            i13++;
                        }
                    }
                    break;
                }
                if (i7 < str.length() - 1) {
                    zArr[i10] = false;
                    i10++;
                }
            }
            return zArr;
        }
        sb = new StringBuilder();
        char c6 = f14201d;
        sb.append(c6);
        sb.append(str);
        sb.append(c6);
        str = sb.toString();
        int i92 = 20;
        while (i6 < str.length() - 1) {
        }
        boolean[] zArr2 = new boolean[i92 + (str.length() - 1)];
        int i102 = 0;
        while (i7 < str.length()) {
        }
        return zArr2;
    }
}
