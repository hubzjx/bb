package b4;

import androidx.constraintlayout.widget.g;
import b.j;
import com.google.zxing.s;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes.dex */
abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f3028a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b  reason: collision with root package name */
    private static final int[][] f3029b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f3030c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, g.U0, -1, -1}, new int[]{6, 28, 54, 80, g.X0, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, j.D0, -1, -1}, new int[]{6, 34, 62, 90, j.H0, -1, -1}, new int[]{6, 26, 50, 74, 98, j.L0, -1}, new int[]{6, 30, 54, 78, g.U0, WebSocketProtocol.PAYLOAD_SHORT, -1}, new int[]{6, 26, 52, 78, g.W0, 130, -1}, new int[]{6, 30, 56, 82, g.Z0, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, j.D0, 142, -1}, new int[]{6, 34, 62, 90, j.H0, 146, -1}, new int[]{6, 30, 54, 78, g.U0, WebSocketProtocol.PAYLOAD_SHORT, 150}, new int[]{6, 24, 50, 76, g.U0, 128, 154}, new int[]{6, 28, 54, 80, g.X0, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, j.D0, 142, 170}};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f3031d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(s3.a aVar, com.google.zxing.qrcode.decoder.f fVar, com.google.zxing.qrcode.decoder.j jVar, int i6, b bVar) {
        c(bVar);
        d(jVar, bVar);
        l(fVar, i6, bVar);
        s(jVar, bVar);
        f(aVar, i6, bVar);
    }

    static int b(int i6, int i7) {
        if (i7 != 0) {
            int n5 = n(i7);
            int i8 = i6 << (n5 - 1);
            while (n(i8) >= n5) {
                i8 ^= i7 << (n(i8) - n5);
            }
            return i8;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void c(b bVar) {
        bVar.a((byte) -1);
    }

    static void d(com.google.zxing.qrcode.decoder.j jVar, b bVar) {
        j(bVar);
        e(bVar);
        r(jVar, bVar);
        k(bVar);
    }

    private static void e(b bVar) {
        if (bVar.b(8, bVar.d() - 8) == 0) {
            throw new s();
        }
        bVar.f(8, bVar.d() - 8, 1);
    }

    static void f(s3.a aVar, int i6, b bVar) {
        boolean z5;
        int e6 = bVar.e() - 1;
        int d6 = bVar.d() - 1;
        int i7 = 0;
        int i8 = -1;
        while (e6 > 0) {
            if (e6 == 6) {
                e6--;
            }
            while (d6 >= 0 && d6 < bVar.d()) {
                for (int i9 = 0; i9 < 2; i9++) {
                    int i10 = e6 - i9;
                    if (o(bVar.b(i10, d6))) {
                        if (i7 < aVar.g()) {
                            z5 = aVar.f(i7);
                            i7++;
                        } else {
                            z5 = false;
                        }
                        if (i6 != -1 && d.f(i6, i10, d6)) {
                            z5 = !z5;
                        }
                        bVar.g(i10, d6, z5);
                    }
                }
                d6 += i8;
            }
            i8 = -i8;
            d6 += i8;
            e6 -= 2;
        }
        if (i7 == aVar.g()) {
            return;
        }
        throw new s("Not all bits consumed: " + i7 + '/' + aVar.g());
    }

    private static void g(int i6, int i7, b bVar) {
        for (int i8 = 0; i8 < 8; i8++) {
            int i9 = i6 + i8;
            if (!o(bVar.b(i9, i7))) {
                throw new s();
            }
            bVar.f(i9, i7, 0);
        }
    }

    private static void h(int i6, int i7, b bVar) {
        for (int i8 = 0; i8 < 5; i8++) {
            int[] iArr = f3029b[i8];
            for (int i9 = 0; i9 < 5; i9++) {
                bVar.f(i6 + i9, i7 + i8, iArr[i9]);
            }
        }
    }

    private static void i(int i6, int i7, b bVar) {
        for (int i8 = 0; i8 < 7; i8++) {
            int[] iArr = f3028a[i8];
            for (int i9 = 0; i9 < 7; i9++) {
                bVar.f(i6 + i9, i7 + i8, iArr[i9]);
            }
        }
    }

    private static void j(b bVar) {
        int length = f3028a[0].length;
        i(0, 0, bVar);
        i(bVar.e() - length, 0, bVar);
        i(0, bVar.e() - length, bVar);
        g(0, 7, bVar);
        g(bVar.e() - 8, 7, bVar);
        g(0, bVar.e() - 8, bVar);
        m(7, 0, bVar);
        m((bVar.d() - 7) - 1, 0, bVar);
        m(7, bVar.d() - 7, bVar);
    }

    private static void k(b bVar) {
        int i6 = 8;
        while (i6 < bVar.e() - 8) {
            int i7 = i6 + 1;
            int i8 = i7 % 2;
            if (o(bVar.b(i6, 6))) {
                bVar.f(i6, 6, i8);
            }
            if (o(bVar.b(6, i6))) {
                bVar.f(6, i6, i8);
            }
            i6 = i7;
        }
    }

    static void l(com.google.zxing.qrcode.decoder.f fVar, int i6, b bVar) {
        s3.a aVar = new s3.a();
        p(fVar, i6, aVar);
        for (int i7 = 0; i7 < aVar.g(); i7++) {
            boolean f6 = aVar.f((aVar.g() - 1) - i7);
            int[] iArr = f3031d[i7];
            bVar.g(iArr[0], iArr[1], f6);
            if (i7 < 8) {
                bVar.g((bVar.e() - i7) - 1, 8, f6);
            } else {
                bVar.g(8, (bVar.d() - 7) + (i7 - 8), f6);
            }
        }
    }

    private static void m(int i6, int i7, b bVar) {
        for (int i8 = 0; i8 < 7; i8++) {
            int i9 = i7 + i8;
            if (!o(bVar.b(i6, i9))) {
                throw new s();
            }
            bVar.f(i6, i9, 0);
        }
    }

    static int n(int i6) {
        return 32 - Integer.numberOfLeadingZeros(i6);
    }

    private static boolean o(int i6) {
        return i6 == -1;
    }

    static void p(com.google.zxing.qrcode.decoder.f fVar, int i6, s3.a aVar) {
        if (!f.b(i6)) {
            throw new s("Invalid mask pattern");
        }
        int bits = (fVar.getBits() << 3) | i6;
        aVar.c(bits, 5);
        aVar.c(b(bits, 1335), 10);
        s3.a aVar2 = new s3.a();
        aVar2.c(21522, 15);
        aVar.k(aVar2);
        if (aVar.g() == 15) {
            return;
        }
        throw new s("should not happen but we got: " + aVar.g());
    }

    static void q(com.google.zxing.qrcode.decoder.j jVar, s3.a aVar) {
        aVar.c(jVar.j(), 6);
        aVar.c(b(jVar.j(), 7973), 12);
        if (aVar.g() == 18) {
            return;
        }
        throw new s("should not happen but we got: " + aVar.g());
    }

    private static void r(com.google.zxing.qrcode.decoder.j jVar, b bVar) {
        if (jVar.j() < 2) {
            return;
        }
        int[] iArr = f3030c[jVar.j() - 1];
        for (int i6 : iArr) {
            if (i6 >= 0) {
                for (int i7 : iArr) {
                    if (i7 >= 0 && o(bVar.b(i7, i6))) {
                        h(i7 - 2, i6 - 2, bVar);
                    }
                }
            }
        }
    }

    static void s(com.google.zxing.qrcode.decoder.j jVar, b bVar) {
        if (jVar.j() < 7) {
            return;
        }
        s3.a aVar = new s3.a();
        q(jVar, aVar);
        int i6 = 17;
        for (int i7 = 0; i7 < 6; i7++) {
            for (int i8 = 0; i8 < 3; i8++) {
                boolean f6 = aVar.f(i6);
                i6--;
                bVar.g(i7, (bVar.d() - 11) + i8, f6);
                bVar.g((bVar.d() - 11) + i8, i7, f6);
            }
        }
    }
}
