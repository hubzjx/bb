package i1;

import com.google.android.exoplayer2.util.y;
/* loaded from: classes.dex */
abstract class n {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f10985a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    private static boolean a(int i6) {
        if ((i6 >>> 8) == 3368816) {
            return true;
        }
        for (int i7 : f10985a) {
            if (i7 == i6) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(c1.j jVar) {
        return c(jVar, true);
    }

    private static boolean c(c1.j jVar, boolean z5) {
        boolean z6;
        boolean z7;
        int i6;
        long a6 = jVar.a();
        long j6 = 4096;
        long j7 = -1;
        int i7 = (a6 > (-1L) ? 1 : (a6 == (-1L) ? 0 : -1));
        if (i7 != 0 && a6 <= 4096) {
            j6 = a6;
        }
        int i8 = (int) j6;
        y yVar = new y(64);
        boolean z8 = false;
        int i9 = 0;
        boolean z9 = false;
        while (i9 < i8) {
            yVar.I(8);
            if (!jVar.l(yVar.c(), z8 ? 1 : 0, 8, true)) {
                break;
            }
            long C = yVar.C();
            int k6 = yVar.k();
            if (C == 1) {
                jVar.n(yVar.c(), 8, 8);
                yVar.L(16);
                C = yVar.t();
                i6 = 16;
            } else {
                if (C == 0) {
                    long a7 = jVar.a();
                    if (a7 != j7) {
                        C = (a7 - jVar.m()) + 8;
                    }
                }
                i6 = 8;
            }
            long j8 = i6;
            if (C < j8) {
                return z8;
            }
            i9 += i6;
            if (k6 == 1836019574) {
                i8 += (int) C;
                if (i7 != 0 && i8 > a6) {
                    i8 = (int) a6;
                }
                j7 = -1;
            } else if (k6 == 1836019558 || k6 == 1836475768) {
                z6 = true;
                z7 = true;
                break;
            } else {
                int i10 = i7;
                if ((i9 + C) - j8 >= i8) {
                    break;
                }
                int i11 = (int) (C - j8);
                i9 += i11;
                if (k6 == 1718909296) {
                    if (i11 < 8) {
                        return false;
                    }
                    yVar.I(i11);
                    jVar.n(yVar.c(), 0, i11);
                    int i12 = i11 / 4;
                    int i13 = 0;
                    while (true) {
                        if (i13 >= i12) {
                            break;
                        }
                        if (i13 == 1) {
                            yVar.N(4);
                        } else if (a(yVar.k())) {
                            z9 = true;
                            break;
                        }
                        i13++;
                    }
                    if (!z9) {
                        return false;
                    }
                } else if (i11 != 0) {
                    jVar.o(i11);
                }
                i7 = i10;
                j7 = -1;
                z8 = false;
            }
        }
        z6 = true;
        z7 = false;
        if (z9 && z5 == z7) {
            return z6;
        }
        return false;
    }

    public static boolean d(c1.j jVar) {
        return c(jVar, false);
    }
}
