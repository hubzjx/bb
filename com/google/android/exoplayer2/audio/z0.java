package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.s0;
import java.nio.ByteBuffer;
import java.util.Arrays;
import okio.Segment;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public abstract class z0 {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3550a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f3551b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f3552c = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, Segment.SHARE_MINIMUM, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, _BufferKt.SEGMENTING_THRESHOLD, 6144, 7680};

    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(byte[] bArr) {
        int i6;
        byte b6;
        int i7;
        int i8;
        byte b7;
        boolean z5 = false;
        byte b8 = bArr[0];
        if (b8 != -2) {
            if (b8 == -1) {
                i8 = ((bArr[7] & 3) << 12) | ((bArr[6] & 255) << 4);
                b7 = bArr[9];
            } else if (b8 != 31) {
                i6 = ((bArr[5] & 3) << 12) | ((bArr[6] & 255) << 4);
                b6 = bArr[7];
            } else {
                i8 = ((bArr[6] & 3) << 12) | ((bArr[7] & 255) << 4);
                b7 = bArr[8];
            }
            i7 = (((b7 & 60) >> 2) | i8) + 1;
            z5 = true;
            return !z5 ? (i7 * 16) / 14 : i7;
        }
        i6 = ((bArr[4] & 3) << 12) | ((bArr[7] & 255) << 4);
        b6 = bArr[6];
        i7 = (((b6 & 240) >> 4) | i6) + 1;
        if (!z5) {
        }
    }

    private static com.google.android.exoplayer2.util.x b(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new com.google.android.exoplayer2.util.x(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (c(copyOf)) {
            for (int i6 = 0; i6 < copyOf.length - 1; i6 += 2) {
                byte b6 = copyOf[i6];
                int i7 = i6 + 1;
                copyOf[i6] = copyOf[i7];
                copyOf[i7] = b6;
            }
        }
        com.google.android.exoplayer2.util.x xVar = new com.google.android.exoplayer2.util.x(copyOf);
        if (copyOf[0] == 31) {
            com.google.android.exoplayer2.util.x xVar2 = new com.google.android.exoplayer2.util.x(copyOf);
            while (xVar2.b() >= 16) {
                xVar2.r(2);
                xVar.f(xVar2.h(14), 14);
            }
        }
        xVar.n(copyOf);
        return xVar;
    }

    private static boolean c(byte[] bArr) {
        byte b6 = bArr[0];
        return b6 == -2 || b6 == -1;
    }

    public static boolean d(int i6) {
        return i6 == 2147385345 || i6 == -25230976 || i6 == 536864768 || i6 == -14745368;
    }

    public static int e(ByteBuffer byteBuffer) {
        int i6;
        int i7;
        int i8;
        int i9;
        int position = byteBuffer.position();
        byte b6 = byteBuffer.get(position);
        if (b6 != -2) {
            if (b6 == -1) {
                i6 = (byteBuffer.get(position + 4) & 7) << 4;
                i9 = position + 7;
            } else if (b6 != 31) {
                i6 = (byteBuffer.get(position + 4) & 1) << 6;
                i7 = position + 5;
            } else {
                i6 = (byteBuffer.get(position + 5) & 7) << 4;
                i9 = position + 6;
            }
            i8 = byteBuffer.get(i9) & 60;
            return (((i8 >> 2) | i6) + 1) * 32;
        }
        i6 = (byteBuffer.get(position + 5) & 1) << 6;
        i7 = position + 4;
        i8 = byteBuffer.get(i7) & 252;
        return (((i8 >> 2) | i6) + 1) * 32;
    }

    public static int f(byte[] bArr) {
        int i6;
        byte b6;
        int i7;
        byte b7;
        byte b8 = bArr[0];
        if (b8 != -2) {
            if (b8 == -1) {
                i6 = (bArr[4] & 7) << 4;
                b7 = bArr[7];
            } else if (b8 != 31) {
                i6 = (bArr[4] & 1) << 6;
                b6 = bArr[5];
            } else {
                i6 = (bArr[5] & 7) << 4;
                b7 = bArr[6];
            }
            i7 = b7 & 60;
            return (((i7 >> 2) | i6) + 1) * 32;
        }
        i6 = (bArr[5] & 1) << 6;
        b6 = bArr[4];
        i7 = b6 & 252;
        return (((i7 >> 2) | i6) + 1) * 32;
    }

    public static com.google.android.exoplayer2.s0 g(byte[] bArr, String str, String str2, com.google.android.exoplayer2.drm.k kVar) {
        com.google.android.exoplayer2.util.x b6 = b(bArr);
        b6.r(60);
        int i6 = f3550a[b6.h(6)];
        int i7 = f3551b[b6.h(4)];
        int h6 = b6.h(5);
        int[] iArr = f3552c;
        int i8 = h6 >= iArr.length ? -1 : (iArr[h6] * 1000) / 2;
        b6.r(10);
        return new s0.b().S(str).e0("audio/vnd.dts").G(i8).H(i6 + (b6.h(2) > 0 ? 1 : 0)).f0(i7).L(kVar).V(str2).E();
    }
}
