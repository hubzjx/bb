package com.google.zxing.qrcode.decoder;
/* loaded from: classes.dex */
final class g {

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f5859c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: a  reason: collision with root package name */
    private final f f5860a;

    /* renamed from: b  reason: collision with root package name */
    private final byte f5861b;

    private g(int i6) {
        this.f5860a = f.forBits((i6 >> 3) & 3);
        this.f5861b = (byte) (i6 & 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g a(int i6, int i7) {
        g b6 = b(i6, i7);
        return b6 != null ? b6 : b(i6 ^ 21522, i7 ^ 21522);
    }

    private static g b(int i6, int i7) {
        int[][] iArr;
        int e6;
        int i8 = Integer.MAX_VALUE;
        int i9 = 0;
        for (int[] iArr2 : f5859c) {
            int i10 = iArr2[0];
            if (i10 == i6 || i10 == i7) {
                return new g(iArr2[1]);
            }
            int e7 = e(i6, i10);
            if (e7 < i8) {
                i9 = iArr2[1];
                i8 = e7;
            }
            if (i6 != i7 && (e6 = e(i7, i10)) < i8) {
                i9 = iArr2[1];
                i8 = e6;
            }
        }
        if (i8 <= 3) {
            return new g(i9);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i6, int i7) {
        return Integer.bitCount(i6 ^ i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte c() {
        return this.f5861b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f d() {
        return this.f5860a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f5860a == gVar.f5860a && this.f5861b == gVar.f5861b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f5860a.ordinal() << 3) | this.f5861b;
    }
}
