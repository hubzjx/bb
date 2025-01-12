package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.s0;
import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3331a = {2002, 2000, 1920, 1601, 1600, WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f3332a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3333b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3334c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3335d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3336e;

        private b(int i6, int i7, int i8, int i9, int i10) {
            this.f3332a = i6;
            this.f3334c = i7;
            this.f3333b = i8;
            this.f3335d = i9;
            this.f3336e = i10;
        }
    }

    public static void a(int i6, com.google.android.exoplayer2.util.y yVar) {
        yVar.I(7);
        byte[] c6 = yVar.c();
        c6[0] = -84;
        c6[1] = 64;
        c6[2] = -1;
        c6[3] = -1;
        c6[4] = (byte) ((i6 >> 16) & 255);
        c6[5] = (byte) ((i6 >> 8) & 255);
        c6[6] = (byte) (i6 & 255);
    }

    public static com.google.android.exoplayer2.s0 b(com.google.android.exoplayer2.util.y yVar, String str, String str2, com.google.android.exoplayer2.drm.k kVar) {
        yVar.N(1);
        return new s0.b().S(str).e0("audio/ac4").H(2).f0(((yVar.A() & 32) >> 5) == 1 ? 48000 : 44100).L(kVar).V(str2).E();
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return d(new com.google.android.exoplayer2.util.x(bArr)).f3336e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
        if (r11 != 11) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0089, code lost:
        if (r11 != 11) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
        if (r11 != 8) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b d(com.google.android.exoplayer2.util.x xVar) {
        int i6;
        int i7;
        int h6 = xVar.h(16);
        int h7 = xVar.h(16);
        if (h7 == 65535) {
            h7 = xVar.h(24);
            i6 = 7;
        } else {
            i6 = 4;
        }
        int i8 = h7 + i6;
        if (h6 == 44097) {
            i8 += 2;
        }
        int i9 = i8;
        int h8 = xVar.h(2);
        if (h8 == 3) {
            h8 += f(xVar, 2);
        }
        int i10 = h8;
        int h9 = xVar.h(10);
        if (xVar.g() && xVar.h(3) > 0) {
            xVar.r(2);
        }
        int i11 = xVar.g() ? 48000 : 44100;
        int h10 = xVar.h(4);
        if (i11 == 44100 && h10 == 13) {
            i7 = f3331a[h10];
        } else {
            if (i11 == 48000) {
                int[] iArr = f3331a;
                if (h10 < iArr.length) {
                    int i12 = iArr[h10];
                    int i13 = h9 % 5;
                    if (i13 != 1) {
                        if (i13 == 2) {
                            if (h10 != 8) {
                            }
                            i12++;
                            i7 = i12;
                        } else if (i13 != 3) {
                            if (i13 == 4) {
                                if (h10 != 3) {
                                    if (h10 != 8) {
                                    }
                                }
                                i12++;
                            }
                            i7 = i12;
                        }
                    }
                    if (h10 != 3) {
                    }
                    i12++;
                    i7 = i12;
                }
            }
            i7 = 0;
        }
        return new b(i10, 2, i11, i9, i7);
    }

    public static int e(byte[] bArr, int i6) {
        int i7 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i8 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i8 == 65535) {
            i8 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i7 = 4;
        }
        if (i6 == 44097) {
            i7 += 2;
        }
        return i8 + i7;
    }

    private static int f(com.google.android.exoplayer2.util.x xVar, int i6) {
        int i7 = 0;
        while (true) {
            int h6 = i7 + xVar.h(i6);
            if (!xVar.g()) {
                return h6;
            }
            i7 = (h6 + 1) << i6;
        }
    }
}
