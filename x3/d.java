package x3;

import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public final class d extends n {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int f(CharSequence charSequence, int i6, int i7) {
        a g6;
        a g7;
        char charAt;
        a g8 = g(charSequence, i6);
        a aVar = a.ONE_DIGIT;
        if (g8 == aVar) {
            return 100;
        }
        a aVar2 = a.UNCODABLE;
        if (g8 == aVar2) {
            if (i6 >= charSequence.length() || ((charAt = charSequence.charAt(i6)) >= ' ' && (i7 != 101 || charAt >= '`'))) {
                return 100;
            }
            return androidx.constraintlayout.widget.g.T0;
        } else if (i7 == 99) {
            return 99;
        } else {
            if (i7 != 100) {
                if (g8 == a.FNC_1) {
                    g8 = g(charSequence, i6 + 1);
                }
                return g8 == a.TWO_DIGITS ? 99 : 100;
            }
            a aVar3 = a.FNC_1;
            if (g8 == aVar3 || (g6 = g(charSequence, i6 + 2)) == aVar2 || g6 == aVar) {
                return 100;
            }
            if (g6 == aVar3) {
                return g(charSequence, i6 + 3) == a.TWO_DIGITS ? 99 : 100;
            }
            int i8 = i6 + 4;
            while (true) {
                g7 = g(charSequence, i8);
                if (g7 != a.TWO_DIGITS) {
                    break;
                }
                i8 += 2;
            }
            return g7 == a.ONE_DIGIT ? 100 : 99;
        }
    }

    private static a g(CharSequence charSequence, int i6) {
        int length = charSequence.length();
        if (i6 >= length) {
            return a.UNCODABLE;
        }
        char charAt = charSequence.charAt(i6);
        if (charAt == 241) {
            return a.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return a.UNCODABLE;
        }
        int i7 = i6 + 1;
        if (i7 >= length) {
            return a.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i7);
        return (charAt2 < '0' || charAt2 > '9') ? a.ONE_DIGIT : a.TWO_DIGITS;
    }

    @Override // x3.n, com.google.zxing.r
    public s3.b a(String str, com.google.zxing.a aVar, int i6, int i7, Map map) {
        if (aVar == com.google.zxing.a.CODE_128) {
            return super.a(str, aVar, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + aVar);
    }

    @Override // x3.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            char charAt = str.charAt(i7);
            switch (charAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (charAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: " + charAt);
                    }
                    break;
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 1;
        while (true) {
            int i12 = androidx.constraintlayout.widget.g.V0;
            if (i8 >= length) {
                int i13 = i9 % androidx.constraintlayout.widget.g.V0;
                int[][] iArr = c.f14202a;
                arrayList.add(iArr[i13]);
                arrayList.add(iArr[106]);
                int i14 = 0;
                for (int[] iArr2 : arrayList) {
                    for (int i15 : iArr2) {
                        i14 += i15;
                    }
                }
                boolean[] zArr = new boolean[i14];
                for (int[] iArr3 : arrayList) {
                    i6 += n.b(zArr, i6, iArr3, true);
                }
                return zArr;
            }
            int f6 = f(str, i8, i10);
            int i16 = 100;
            if (f6 == i10) {
                switch (str.charAt(i8)) {
                    case 241:
                        i16 = androidx.constraintlayout.widget.g.U0;
                        break;
                    case 242:
                        i16 = 97;
                        break;
                    case 243:
                        i16 = 96;
                        break;
                    case 244:
                        if (i10 == 101) {
                            i16 = androidx.constraintlayout.widget.g.T0;
                            break;
                        }
                        break;
                    default:
                        if (i10 != 100) {
                            if (i10 != 101) {
                                i16 = Integer.parseInt(str.substring(i8, i8 + 2));
                                i8++;
                                break;
                            } else {
                                i16 = str.charAt(i8) - ' ';
                                if (i16 < 0) {
                                    i16 += 96;
                                    break;
                                }
                            }
                        } else {
                            i16 = str.charAt(i8) - ' ';
                            break;
                        }
                        break;
                }
                i8++;
            } else {
                if (i10 != 0) {
                    i12 = f6;
                } else if (f6 == 100) {
                    i12 = androidx.constraintlayout.widget.g.W0;
                } else if (f6 != 101) {
                    i12 = 105;
                }
                i16 = i12;
                i10 = f6;
            }
            arrayList.add(c.f14202a[i16]);
            i9 += i16 * i11;
            if (i8 != 0) {
                i11++;
            }
        }
    }
}
