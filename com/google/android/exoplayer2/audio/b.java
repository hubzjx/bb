package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.s0;
import java.nio.ByteBuffer;
import okio.Utf8;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3318a = {1, 2, 3, 6};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f3319b = {48000, 44100, 32000};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f3320c = {24000, 22050, 16000};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f3321d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f3322e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f3323f = {69, 87, androidx.constraintlayout.widget.g.W0, b.j.K0, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: com.google.android.exoplayer2.audio.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0036b {

        /* renamed from: a  reason: collision with root package name */
        public final String f3324a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3325b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3326c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3327d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3328e;

        /* renamed from: f  reason: collision with root package name */
        public final int f3329f;

        private C0036b(String str, int i6, int i7, int i8, int i9, int i10) {
            this.f3324a = str;
            this.f3325b = i6;
            this.f3327d = i7;
            this.f3326c = i8;
            this.f3328e = i9;
            this.f3329f = i10;
        }
    }

    public static int a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i6 = position; i6 <= limit; i6++) {
            if ((com.google.android.exoplayer2.util.s0.H(byteBuffer, i6 + 4) & (-2)) == -126718022) {
                return i6 - position;
            }
        }
        return -1;
    }

    private static int b(int i6, int i7) {
        int i8 = i7 / 2;
        if (i6 >= 0) {
            int[] iArr = f3319b;
            if (i6 >= iArr.length || i7 < 0) {
                return -1;
            }
            int[] iArr2 = f3323f;
            if (i8 >= iArr2.length) {
                return -1;
            }
            int i9 = iArr[i6];
            if (i9 == 44100) {
                return (iArr2[i8] + (i7 % 2)) * 2;
            }
            int i10 = f3322e[i8];
            return i9 == 32000 ? i10 * 6 : i10 * 4;
        }
        return -1;
    }

    public static com.google.android.exoplayer2.s0 c(com.google.android.exoplayer2.util.y yVar, String str, String str2, com.google.android.exoplayer2.drm.k kVar) {
        int i6 = f3319b[(yVar.A() & 192) >> 6];
        int A = yVar.A();
        int i7 = f3321d[(A & 56) >> 3];
        if ((A & 4) != 0) {
            i7++;
        }
        return new s0.b().S(str).e0("audio/ac3").H(i7).f0(i6).L(kVar).V(str2).E();
    }

    public static int d(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f3318a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static C0036b e(com.google.android.exoplayer2.util.x xVar) {
        String str;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int h6;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int e6 = xVar.e();
        xVar.r(40);
        boolean z5 = xVar.h(5) > 10;
        xVar.p(e6);
        int i16 = -1;
        if (z5) {
            xVar.r(16);
            int h7 = xVar.h(2);
            if (h7 == 0) {
                i16 = 0;
            } else if (h7 == 1) {
                i16 = 1;
            } else if (h7 == 2) {
                i16 = 2;
            }
            xVar.r(3);
            int h8 = (xVar.h(11) + 1) * 2;
            int h9 = xVar.h(2);
            if (h9 == 3) {
                i12 = f3320c[xVar.h(2)];
                h6 = 3;
                i11 = 6;
            } else {
                h6 = xVar.h(2);
                i11 = f3318a[h6];
                i12 = f3319b[h9];
            }
            int i17 = i11 * 256;
            int h10 = xVar.h(3);
            boolean g6 = xVar.g();
            int i18 = f3321d[h10] + (g6 ? 1 : 0);
            xVar.r(10);
            if (xVar.g()) {
                xVar.r(8);
            }
            if (h10 == 0) {
                xVar.r(5);
                if (xVar.g()) {
                    xVar.r(8);
                }
            }
            if (i16 == 1 && xVar.g()) {
                xVar.r(16);
            }
            if (xVar.g()) {
                if (h10 > 2) {
                    xVar.r(2);
                }
                if ((h10 & 1) == 0 || h10 <= 2) {
                    i14 = 6;
                } else {
                    i14 = 6;
                    xVar.r(6);
                }
                if ((h10 & 4) != 0) {
                    xVar.r(i14);
                }
                if (g6 && xVar.g()) {
                    xVar.r(5);
                }
                if (i16 == 0) {
                    if (xVar.g()) {
                        i15 = 6;
                        xVar.r(6);
                    } else {
                        i15 = 6;
                    }
                    if (h10 == 0 && xVar.g()) {
                        xVar.r(i15);
                    }
                    if (xVar.g()) {
                        xVar.r(i15);
                    }
                    int h11 = xVar.h(2);
                    if (h11 == 1) {
                        xVar.r(5);
                    } else if (h11 == 2) {
                        xVar.r(12);
                    } else if (h11 == 3) {
                        int h12 = xVar.h(5);
                        if (xVar.g()) {
                            xVar.r(5);
                            if (xVar.g()) {
                                xVar.r(4);
                            }
                            if (xVar.g()) {
                                xVar.r(4);
                            }
                            if (xVar.g()) {
                                xVar.r(4);
                            }
                            if (xVar.g()) {
                                xVar.r(4);
                            }
                            if (xVar.g()) {
                                xVar.r(4);
                            }
                            if (xVar.g()) {
                                xVar.r(4);
                            }
                            if (xVar.g()) {
                                xVar.r(4);
                            }
                            if (xVar.g()) {
                                if (xVar.g()) {
                                    xVar.r(4);
                                }
                                if (xVar.g()) {
                                    xVar.r(4);
                                }
                            }
                        }
                        if (xVar.g()) {
                            xVar.r(5);
                            if (xVar.g()) {
                                xVar.r(7);
                                if (xVar.g()) {
                                    xVar.r(8);
                                }
                            }
                        }
                        xVar.r((h12 + 2) * 8);
                        xVar.c();
                    }
                    if (h10 < 2) {
                        if (xVar.g()) {
                            xVar.r(14);
                        }
                        if (h10 == 0 && xVar.g()) {
                            xVar.r(14);
                        }
                    }
                    if (xVar.g()) {
                        if (h6 == 0) {
                            xVar.r(5);
                        } else {
                            for (int i19 = 0; i19 < i11; i19++) {
                                if (xVar.g()) {
                                    xVar.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (xVar.g()) {
                xVar.r(5);
                if (h10 == 2) {
                    xVar.r(4);
                }
                if (h10 >= 6) {
                    xVar.r(2);
                }
                if (xVar.g()) {
                    xVar.r(8);
                }
                if (h10 == 0 && xVar.g()) {
                    xVar.r(8);
                }
                if (h9 < 3) {
                    xVar.q();
                }
            }
            if (i16 == 0 && h6 != 3) {
                xVar.q();
            }
            if (i16 == 2 && (h6 == 3 || xVar.g())) {
                i13 = 6;
                xVar.r(6);
            } else {
                i13 = 6;
            }
            str = (xVar.g() && xVar.h(i13) == 1 && xVar.h(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i9 = i16;
            i10 = i17;
            i6 = h8;
            i7 = i12;
            i8 = i18;
        } else {
            xVar.r(32);
            int h13 = xVar.h(2);
            String str2 = h13 == 3 ? null : "audio/ac3";
            int b6 = b(h13, xVar.h(6));
            xVar.r(8);
            int h14 = xVar.h(3);
            if ((h14 & 1) != 0 && h14 != 1) {
                xVar.r(2);
            }
            if ((h14 & 4) != 0) {
                xVar.r(2);
            }
            if (h14 == 2) {
                xVar.r(2);
            }
            int[] iArr = f3319b;
            str = str2;
            i6 = b6;
            i7 = h13 < iArr.length ? iArr[h13] : -1;
            i8 = f3321d[h14] + (xVar.g() ? 1 : 0);
            i9 = -1;
            i10 = 1536;
        }
        return new C0036b(str, i9, i8, i7, i6, i10);
    }

    public static int f(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b6 = bArr[4];
        return b((b6 & 192) >> 6, b6 & Utf8.REPLACEMENT_BYTE);
    }

    public static com.google.android.exoplayer2.s0 g(com.google.android.exoplayer2.util.y yVar, String str, String str2, com.google.android.exoplayer2.drm.k kVar) {
        yVar.N(2);
        int i6 = f3319b[(yVar.A() & 192) >> 6];
        int A = yVar.A();
        int i7 = f3321d[(A & 14) >> 1];
        if ((A & 1) != 0) {
            i7++;
        }
        if (((yVar.A() & 30) >> 1) > 0 && (2 & yVar.A()) != 0) {
            i7 += 2;
        }
        return new s0.b().S(str).e0((yVar.a() <= 0 || (yVar.A() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc").H(i7).f0(i6).L(kVar).V(str2).E();
    }

    public static int h(ByteBuffer byteBuffer, int i6) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i6) + ((byteBuffer.get((byteBuffer.position() + i6) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int i(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b6 = bArr[7];
            if ((b6 & 254) == 186) {
                return 40 << ((bArr[(b6 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }
}
