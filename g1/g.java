package g1;

import c1.j;
/* loaded from: classes.dex */
final class g {

    /* renamed from: d  reason: collision with root package name */
    private static final long[] f10408d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f10409a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private int f10410b;

    /* renamed from: c  reason: collision with root package name */
    private int f10411c;

    public static long a(byte[] bArr, int i6, boolean z5) {
        long j6 = bArr[0] & 255;
        if (z5) {
            j6 &= ~f10408d[i6 - 1];
        }
        for (int i7 = 1; i7 < i6; i7++) {
            j6 = (j6 << 8) | (bArr[i7] & 255);
        }
        return j6;
    }

    public static int c(int i6) {
        int i7;
        int i8 = 0;
        do {
            long[] jArr = f10408d;
            if (i8 >= jArr.length) {
                return -1;
            }
            i7 = ((jArr[i8] & i6) > 0L ? 1 : ((jArr[i8] & i6) == 0L ? 0 : -1));
            i8++;
        } while (i7 == 0);
        return i8;
    }

    public int b() {
        return this.f10411c;
    }

    public long d(j jVar, boolean z5, boolean z6, int i6) {
        if (this.f10410b == 0) {
            if (!jVar.d(this.f10409a, 0, 1, z5)) {
                return -1L;
            }
            int c6 = c(this.f10409a[0] & 255);
            this.f10411c = c6;
            if (c6 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f10410b = 1;
        }
        int i7 = this.f10411c;
        if (i7 > i6) {
            this.f10410b = 0;
            return -2L;
        }
        if (i7 != 1) {
            jVar.readFully(this.f10409a, 1, i7 - 1);
        }
        this.f10410b = 0;
        return a(this.f10409a, this.f10411c, z6);
    }

    public void e() {
        this.f10410b = 0;
        this.f10411c = 0;
    }
}
