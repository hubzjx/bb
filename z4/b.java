package z4;

import i5.i0;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f14386b = new int[256];

    /* renamed from: a  reason: collision with root package name */
    private final int[] f14387a = new int[3];

    static {
        for (int i6 = 0; i6 < 256; i6++) {
            int i7 = i6;
            for (int i8 = 0; i8 < 8; i8++) {
                int i9 = i7 & 1;
                i7 >>>= 1;
                if (i9 == 1) {
                    i7 ^= -306674912;
                }
            }
            f14386b[i6] = i7;
        }
    }

    private int a(int i6, byte b6) {
        return f14386b[(i6 ^ b6) & 255] ^ (i6 >>> 8);
    }

    public byte b() {
        int i6 = this.f14387a[2] | 2;
        return (byte) ((i6 * (i6 ^ 1)) >>> 8);
    }

    public void c(char[] cArr) {
        int[] iArr = this.f14387a;
        iArr[0] = 305419896;
        iArr[1] = 591751049;
        iArr[2] = 878082192;
        for (byte b6 : i0.a(cArr)) {
            d((byte) (b6 & 255));
        }
    }

    public void d(byte b6) {
        int[] iArr = this.f14387a;
        iArr[0] = a(iArr[0], b6);
        int[] iArr2 = this.f14387a;
        int i6 = iArr2[1] + (iArr2[0] & 255);
        iArr2[1] = i6;
        int i7 = (i6 * 134775813) + 1;
        iArr2[1] = i7;
        iArr2[2] = a(iArr2[2], (byte) (i7 >> 24));
    }
}
