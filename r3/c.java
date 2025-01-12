package r3;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f13037a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int[] a(s3.a aVar, int i6, int i7) {
        int[] iArr = new int[i7];
        int g6 = aVar.g() / i6;
        for (int i8 = 0; i8 < g6; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 |= aVar.f((i8 * i6) + i10) ? 1 << ((i6 - i10) - 1) : 0;
            }
            iArr[i8] = i9;
        }
        return iArr;
    }

    private static void b(s3.b bVar, int i6, int i7) {
        for (int i8 = 0; i8 < i7; i8 += 2) {
            int i9 = i6 - i8;
            int i10 = i9;
            while (true) {
                int i11 = i6 + i8;
                if (i10 <= i11) {
                    bVar.j(i10, i9);
                    bVar.j(i10, i11);
                    bVar.j(i9, i10);
                    bVar.j(i11, i10);
                    i10++;
                }
            }
        }
        int i12 = i6 - i7;
        bVar.j(i12, i12);
        int i13 = i12 + 1;
        bVar.j(i13, i12);
        bVar.j(i12, i13);
        int i14 = i6 + i7;
        bVar.j(i14, i12);
        bVar.j(i14, i13);
        bVar.j(i14, i14 - 1);
    }

    private static void c(s3.b bVar, boolean z5, int i6, s3.a aVar) {
        int i7 = i6 / 2;
        int i8 = 0;
        if (z5) {
            while (i8 < 7) {
                int i9 = (i7 - 3) + i8;
                if (aVar.f(i8)) {
                    bVar.j(i9, i7 - 5);
                }
                if (aVar.f(i8 + 7)) {
                    bVar.j(i7 + 5, i9);
                }
                if (aVar.f(20 - i8)) {
                    bVar.j(i9, i7 + 5);
                }
                if (aVar.f(27 - i8)) {
                    bVar.j(i7 - 5, i9);
                }
                i8++;
            }
            return;
        }
        while (i8 < 10) {
            int i10 = (i7 - 5) + i8 + (i8 / 5);
            if (aVar.f(i8)) {
                bVar.j(i10, i7 - 7);
            }
            if (aVar.f(i8 + 10)) {
                bVar.j(i7 + 7, i10);
            }
            if (aVar.f(29 - i8)) {
                bVar.j(i10, i7 + 7);
            }
            if (aVar.f(39 - i8)) {
                bVar.j(i7 - 7, i10);
            }
            i8++;
        }
    }

    public static a d(byte[] bArr, int i6, int i7) {
        s3.a aVar;
        boolean z5;
        int i8;
        int i9;
        int i10;
        int i11;
        s3.a a6 = new d(bArr).a();
        int g6 = ((a6.g() * i6) / 100) + 11;
        int g7 = a6.g() + g6;
        int i12 = 0;
        int i13 = 1;
        if (i7 == 0) {
            s3.a aVar2 = null;
            int i14 = 0;
            int i15 = 0;
            while (i14 <= 32) {
                boolean z6 = i14 <= 3;
                int i16 = z6 ? i14 + 1 : i14;
                int i17 = i(i16, z6);
                if (g7 <= i17) {
                    int i18 = f13037a[i16];
                    if (i15 != i18) {
                        aVar2 = h(a6, i18);
                    } else {
                        i18 = i15;
                    }
                    int i19 = i17 - (i17 % i18);
                    if ((!z6 || aVar2.g() <= (i18 << 6)) && aVar2.g() + g6 <= i19) {
                        aVar = aVar2;
                        z5 = z6;
                        i8 = i16;
                        i9 = i17;
                        i10 = i18;
                    } else {
                        i15 = i18;
                    }
                }
                i14++;
                i12 = 0;
                i13 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z5 = i7 < 0;
        i8 = Math.abs(i7);
        if (i8 > (z5 ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i7)));
        }
        i9 = i(i8, z5);
        i10 = f13037a[i8];
        int i20 = i9 - (i9 % i10);
        aVar = h(a6, i10);
        if (aVar.g() + g6 > i20) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z5 && aVar.g() > (i10 << 6)) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        s3.a e6 = e(aVar, i9, i10);
        int g8 = aVar.g() / i10;
        s3.a f6 = f(z5, i8, g8);
        int i21 = (z5 ? 11 : 14) + (i8 << 2);
        int[] iArr = new int[i21];
        int i22 = 2;
        if (z5) {
            for (int i23 = 0; i23 < i21; i23++) {
                iArr[i23] = i23;
            }
            i11 = i21;
        } else {
            int i24 = i21 / 2;
            i11 = i21 + 1 + (((i24 - 1) / 15) * 2);
            int i25 = i11 / 2;
            for (int i26 = 0; i26 < i24; i26++) {
                int i27 = (i26 / 15) + i26;
                iArr[(i24 - i26) - i13] = (i25 - i27) - 1;
                iArr[i24 + i26] = i27 + i25 + i13;
            }
        }
        s3.b bVar = new s3.b(i11);
        int i28 = 0;
        int i29 = 0;
        while (i28 < i8) {
            int i30 = ((i8 - i28) << i22) + (z5 ? 9 : 12);
            int i31 = 0;
            while (i31 < i30) {
                int i32 = i31 << 1;
                while (i12 < i22) {
                    if (e6.f(i29 + i32 + i12)) {
                        int i33 = i28 << 1;
                        bVar.j(iArr[i33 + i12], iArr[i33 + i31]);
                    }
                    if (e6.f((i30 << 1) + i29 + i32 + i12)) {
                        int i34 = i28 << 1;
                        bVar.j(iArr[i34 + i31], iArr[((i21 - 1) - i34) - i12]);
                    }
                    if (e6.f((i30 << 2) + i29 + i32 + i12)) {
                        int i35 = (i21 - 1) - (i28 << 1);
                        bVar.j(iArr[i35 - i12], iArr[i35 - i31]);
                    }
                    if (e6.f((i30 * 6) + i29 + i32 + i12)) {
                        int i36 = i28 << 1;
                        bVar.j(iArr[((i21 - 1) - i36) - i31], iArr[i36 + i12]);
                    }
                    i12++;
                    i22 = 2;
                }
                i31++;
                i12 = 0;
                i22 = 2;
            }
            i29 += i30 << 3;
            i28++;
            i12 = 0;
            i22 = 2;
        }
        c(bVar, z5, i11, f6);
        int i37 = i11 / 2;
        if (z5) {
            b(bVar, i37, 5);
        } else {
            b(bVar, i37, 7);
            int i38 = 0;
            int i39 = 0;
            while (i39 < (i21 / 2) - 1) {
                for (int i40 = i37 & 1; i40 < i11; i40 += 2) {
                    int i41 = i37 - i38;
                    bVar.j(i41, i40);
                    int i42 = i37 + i38;
                    bVar.j(i42, i40);
                    bVar.j(i40, i41);
                    bVar.j(i40, i42);
                }
                i39 += 15;
                i38 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.c(z5);
        aVar3.f(i11);
        aVar3.d(i8);
        aVar3.b(g8);
        aVar3.e(bVar);
        return aVar3;
    }

    private static s3.a e(s3.a aVar, int i6, int i7) {
        u3.d dVar = new u3.d(g(i7));
        int i8 = i6 / i7;
        int[] a6 = a(aVar, i7, i8);
        dVar.b(a6, i8 - (aVar.g() / i7));
        s3.a aVar2 = new s3.a();
        aVar2.c(0, i6 % i7);
        for (int i9 : a6) {
            aVar2.c(i9, i7);
        }
        return aVar2;
    }

    static s3.a f(boolean z5, int i6, int i7) {
        int i8;
        s3.a aVar = new s3.a();
        int i9 = i6 - 1;
        if (z5) {
            aVar.c(i9, 2);
            aVar.c(i7 - 1, 6);
            i8 = 28;
        } else {
            aVar.c(i9, 5);
            aVar.c(i7 - 1, 11);
            i8 = 40;
        }
        return e(aVar, i8, 4);
    }

    private static u3.a g(int i6) {
        if (i6 != 4) {
            if (i6 != 6) {
                if (i6 != 8) {
                    if (i6 != 10) {
                        if (i6 == 12) {
                            return u3.a.f13605h;
                        }
                        throw new IllegalArgumentException("Unsupported word size " + i6);
                    }
                    return u3.a.f13606i;
                }
                return u3.a.f13611n;
            }
            return u3.a.f13607j;
        }
        return u3.a.f13608k;
    }

    static s3.a h(s3.a aVar, int i6) {
        s3.a aVar2 = new s3.a();
        int g6 = aVar.g();
        int i7 = (1 << i6) - 2;
        int i8 = 0;
        while (i8 < g6) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = i8 + i10;
                if (i11 >= g6 || aVar.f(i11)) {
                    i9 |= 1 << ((i6 - 1) - i10);
                }
            }
            int i12 = i9 & i7;
            if (i12 != i7) {
                if (i12 == 0) {
                    i12 = i9 | 1;
                } else {
                    aVar2.c(i9, i6);
                    i8 += i6;
                }
            }
            aVar2.c(i12, i6);
            i8--;
            i8 += i6;
        }
        return aVar2;
    }

    private static int i(int i6, boolean z5) {
        return ((z5 ? 88 : 112) + (i6 << 4)) * i6;
    }
}
