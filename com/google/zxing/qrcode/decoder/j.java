package com.google.zxing.qrcode.decoder;

import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f5863e = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};

    /* renamed from: f  reason: collision with root package name */
    private static final j[] f5864f = b();

    /* renamed from: a  reason: collision with root package name */
    private final int f5865a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f5866b;

    /* renamed from: c  reason: collision with root package name */
    private final b[] f5867c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5868d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f5869a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5870b;

        a(int i6, int i7) {
            this.f5869a = i6;
            this.f5870b = i7;
        }

        public int a() {
            return this.f5869a;
        }

        public int b() {
            return this.f5870b;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f5871a;

        /* renamed from: b  reason: collision with root package name */
        private final a[] f5872b;

        b(int i6, a... aVarArr) {
            this.f5871a = i6;
            this.f5872b = aVarArr;
        }

        public a[] a() {
            return this.f5872b;
        }

        public int b() {
            return this.f5871a;
        }

        public int c() {
            int i6 = 0;
            for (a aVar : this.f5872b) {
                i6 += aVar.a();
            }
            return i6;
        }

        public int d() {
            return this.f5871a * c();
        }
    }

    private j(int i6, int[] iArr, b... bVarArr) {
        a[] a6;
        this.f5865a = i6;
        this.f5866b = iArr;
        this.f5867c = bVarArr;
        int b6 = bVarArr[0].b();
        int i7 = 0;
        for (a aVar : bVarArr[0].a()) {
            i7 += aVar.a() * (aVar.b() + b6);
        }
        this.f5868d = i7;
    }

    private static j[] b() {
        return new j[]{new j(1, new int[0], new b(7, new a(1, 19)), new b(10, new a(1, 16)), new b(13, new a(1, 13)), new b(17, new a(1, 9))), new j(2, new int[]{6, 18}, new b(10, new a(1, 34)), new b(16, new a(1, 28)), new b(22, new a(1, 22)), new b(28, new a(1, 16))), new j(3, new int[]{6, 22}, new b(15, new a(1, 55)), new b(26, new a(1, 44)), new b(18, new a(2, 17)), new b(22, new a(2, 13))), new j(4, new int[]{6, 26}, new b(20, new a(1, 80)), new b(18, new a(2, 32)), new b(26, new a(2, 24)), new b(16, new a(4, 9))), new j(5, new int[]{6, 30}, new b(26, new a(1, androidx.constraintlayout.widget.g.Z0)), new b(24, new a(2, 43)), new b(18, new a(2, 15), new a(2, 16)), new b(22, new a(2, 11), new a(2, 12))), new j(6, new int[]{6, 34}, new b(18, new a(2, 68)), new b(16, new a(4, 27)), new b(24, new a(4, 19)), new b(28, new a(4, 15))), new j(7, new int[]{6, 22, 38}, new b(20, new a(2, 78)), new b(18, new a(4, 31)), new b(18, new a(2, 14), new a(4, 15)), new b(26, new a(4, 13), new a(1, 14))), new j(8, new int[]{6, 24, 42}, new b(24, new a(2, 97)), new b(22, new a(2, 38), new a(2, 39)), new b(22, new a(4, 18), new a(2, 19)), new b(26, new a(4, 14), new a(2, 15))), new j(9, new int[]{6, 26, 46}, new b(30, new a(2, b.j.F0)), new b(22, new a(3, 36), new a(2, 37)), new b(20, new a(4, 16), new a(4, 17)), new b(24, new a(4, 12), new a(4, 13))), new j(10, new int[]{6, 28, 50}, new b(18, new a(2, 68), new a(2, 69)), new b(26, new a(4, 43), new a(1, 44)), new b(24, new a(6, 19), new a(2, 20)), new b(28, new a(6, 15), new a(2, 16))), new j(11, new int[]{6, 30, 54}, new b(20, new a(4, 81)), new b(30, new a(1, 50), new a(4, 51)), new b(28, new a(4, 22), new a(4, 23)), new b(24, new a(3, 12), new a(8, 13))), new j(12, new int[]{6, 32, 58}, new b(24, new a(2, 92), new a(2, 93)), new b(22, new a(6, 36), new a(2, 37)), new b(26, new a(4, 20), new a(6, 21)), new b(28, new a(7, 14), new a(4, 15))), new j(13, new int[]{6, 34, 62}, new b(26, new a(4, androidx.constraintlayout.widget.g.Y0)), new b(22, new a(8, 37), new a(1, 38)), new b(24, new a(8, 20), new a(4, 21)), new b(22, new a(12, 11), new a(4, 12))), new j(14, new int[]{6, 26, 46, 66}, new b(30, new a(3, b.j.E0), new a(1, b.j.F0)), new b(24, new a(4, 40), new a(5, 41)), new b(20, new a(11, 16), new a(5, 17)), new b(24, new a(11, 12), new a(5, 13))), new j(15, new int[]{6, 26, 48, 70}, new b(22, new a(5, 87), new a(1, 88)), new b(24, new a(5, 41), new a(5, 42)), new b(30, new a(5, 24), new a(7, 25)), new b(24, new a(11, 12), new a(7, 13))), new j(16, new int[]{6, 26, 50, 74}, new b(24, new a(5, 98), new a(1, 99)), new b(28, new a(7, 45), new a(3, 46)), new b(24, new a(15, 19), new a(2, 20)), new b(30, new a(3, 15), new a(13, 16))), new j(17, new int[]{6, 30, 54, 78}, new b(28, new a(1, androidx.constraintlayout.widget.g.Y0), new a(5, androidx.constraintlayout.widget.g.Z0)), new b(28, new a(10, 46), new a(1, 47)), new b(28, new a(1, 22), new a(15, 23)), new b(28, new a(2, 14), new a(17, 15))), new j(18, new int[]{6, 30, 56, 82}, new b(30, new a(5, b.j.J0), new a(1, b.j.K0)), new b(26, new a(9, 43), new a(4, 44)), new b(28, new a(17, 22), new a(1, 23)), new b(28, new a(2, 14), new a(19, 15))), new j(19, new int[]{6, 30, 58, 86}, new b(28, new a(3, 113), new a(4, b.j.D0)), new b(26, new a(3, 44), new a(11, 45)), new b(26, new a(17, 21), new a(4, 22)), new b(26, new a(9, 13), new a(16, 14))), new j(20, new int[]{6, 34, 62, 90}, new b(28, new a(3, androidx.constraintlayout.widget.g.Y0), new a(5, androidx.constraintlayout.widget.g.Z0)), new b(26, new a(3, 41), new a(13, 42)), new b(30, new a(15, 24), new a(5, 25)), new b(28, new a(15, 15), new a(10, 16))), new j(21, new int[]{6, 28, 50, 72, 94}, new b(28, new a(4, b.j.F0), new a(4, b.j.G0)), new b(26, new a(17, 42)), new b(28, new a(17, 22), new a(6, 23)), new b(30, new a(19, 16), new a(6, 17))), new j(22, new int[]{6, 26, 50, 74, 98}, new b(28, new a(2, 111), new a(7, 112)), new b(28, new a(17, 46)), new b(30, new a(7, 24), new a(16, 25)), new b(24, new a(34, 13))), new j(23, new int[]{6, 30, 54, 78, androidx.constraintlayout.widget.g.U0}, new b(30, new a(4, b.j.K0), new a(5, b.j.L0)), new b(28, new a(4, 47), new a(14, 48)), new b(30, new a(11, 24), new a(14, 25)), new b(30, new a(16, 15), new a(14, 16))), new j(24, new int[]{6, 28, 54, 80, androidx.constraintlayout.widget.g.X0}, new b(30, new a(6, b.j.G0), new a(4, b.j.H0)), new b(28, new a(6, 45), new a(14, 46)), new b(30, new a(11, 24), new a(16, 25)), new b(30, new a(30, 16), new a(2, 17))), new j(25, new int[]{6, 32, 58, 84, 110}, new b(26, new a(8, androidx.constraintlayout.widget.g.X0), new a(4, androidx.constraintlayout.widget.g.Y0)), new b(28, new a(8, 47), new a(13, 48)), new b(30, new a(7, 24), new a(22, 25)), new b(30, new a(22, 15), new a(13, 16))), new j(26, new int[]{6, 30, 58, 86, b.j.D0}, new b(28, new a(10, b.j.D0), new a(2, b.j.E0)), new b(28, new a(19, 46), new a(4, 47)), new b(28, new a(28, 22), new a(6, 23)), new b(30, new a(33, 16), new a(4, 17))), new j(27, new int[]{6, 34, 62, 90, b.j.H0}, new b(30, new a(8, b.j.L0), new a(4, b.j.M0)), new b(28, new a(22, 45), new a(3, 46)), new b(30, new a(8, 23), new a(26, 24)), new b(30, new a(12, 15), new a(28, 16))), new j(28, new int[]{6, 26, 50, 74, 98, b.j.L0}, new b(30, new a(3, b.j.G0), new a(10, b.j.H0)), new b(28, new a(3, 45), new a(23, 46)), new b(30, new a(4, 24), new a(31, 25)), new b(30, new a(11, 15), new a(31, 16))), new j(29, new int[]{6, 30, 54, 78, androidx.constraintlayout.widget.g.U0, WebSocketProtocol.PAYLOAD_SHORT}, new b(30, new a(7, b.j.F0), new a(7, b.j.G0)), new b(28, new a(21, 45), new a(7, 46)), new b(30, new a(1, 23), new a(37, 24)), new b(30, new a(19, 15), new a(26, 16))), new j(30, new int[]{6, 26, 52, 78, androidx.constraintlayout.widget.g.W0, 130}, new b(30, new a(5, b.j.E0), new a(10, b.j.F0)), new b(28, new a(19, 47), new a(10, 48)), new b(30, new a(15, 24), new a(25, 25)), new b(30, new a(23, 15), new a(25, 16))), new j(31, new int[]{6, 30, 56, 82, androidx.constraintlayout.widget.g.Z0, 134}, new b(30, new a(13, b.j.E0), new a(3, b.j.F0)), new b(28, new a(2, 46), new a(29, 47)), new b(30, new a(42, 24), new a(1, 25)), new b(30, new a(23, 15), new a(28, 16))), new j(32, new int[]{6, 34, 60, 86, 112, 138}, new b(30, new a(17, b.j.E0)), new b(28, new a(10, 46), new a(23, 47)), new b(30, new a(10, 24), new a(35, 25)), new b(30, new a(19, 15), new a(35, 16))), new j(33, new int[]{6, 30, 58, 86, b.j.D0, 142}, new b(30, new a(17, b.j.E0), new a(1, b.j.F0)), new b(28, new a(14, 46), new a(21, 47)), new b(30, new a(29, 24), new a(19, 25)), new b(30, new a(11, 15), new a(46, 16))), new j(34, new int[]{6, 34, 62, 90, b.j.H0, 146}, new b(30, new a(13, b.j.E0), new a(6, b.j.F0)), new b(28, new a(14, 46), new a(23, 47)), new b(30, new a(44, 24), new a(7, 25)), new b(30, new a(59, 16), new a(1, 17))), new j(35, new int[]{6, 30, 54, 78, androidx.constraintlayout.widget.g.U0, WebSocketProtocol.PAYLOAD_SHORT, 150}, new b(30, new a(12, b.j.K0), new a(7, b.j.L0)), new b(28, new a(12, 47), new a(26, 48)), new b(30, new a(39, 24), new a(14, 25)), new b(30, new a(22, 15), new a(41, 16))), new j(36, new int[]{6, 24, 50, 76, androidx.constraintlayout.widget.g.U0, 128, 154}, new b(30, new a(6, b.j.K0), new a(14, b.j.L0)), new b(28, new a(6, 47), new a(34, 48)), new b(30, new a(46, 24), new a(10, 25)), new b(30, new a(2, 15), new a(64, 16))), new j(37, new int[]{6, 28, 54, 80, androidx.constraintlayout.widget.g.X0, 132, 158}, new b(30, new a(17, b.j.L0), new a(4, b.j.M0)), new b(28, new a(29, 46), new a(14, 47)), new b(30, new a(49, 24), new a(10, 25)), new b(30, new a(24, 15), new a(46, 16))), new j(38, new int[]{6, 32, 58, 84, 110, 136, 162}, new b(30, new a(4, b.j.L0), new a(18, b.j.M0)), new b(28, new a(13, 46), new a(32, 47)), new b(30, new a(48, 24), new a(14, 25)), new b(30, new a(42, 15), new a(32, 16))), new j(39, new int[]{6, 26, 54, 82, 110, 138, 166}, new b(30, new a(20, b.j.G0), new a(4, b.j.H0)), new b(28, new a(40, 47), new a(7, 48)), new b(30, new a(43, 24), new a(22, 25)), new b(30, new a(10, 15), new a(67, 16))), new j(40, new int[]{6, 30, 58, 86, b.j.D0, 142, 170}, new b(30, new a(19, b.j.H0), new a(6, b.j.I0)), new b(28, new a(18, 47), new a(31, 48)), new b(30, new a(34, 24), new a(34, 25)), new b(30, new a(20, 15), new a(61, 16)))};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j c(int i6) {
        int i7 = Integer.MAX_VALUE;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int[] iArr = f5863e;
            if (i8 >= iArr.length) {
                if (i7 <= 3) {
                    return i(i9);
                }
                return null;
            }
            int i10 = iArr[i8];
            if (i10 == i6) {
                return i(i8 + 7);
            }
            int e6 = g.e(i6, i10);
            if (e6 < i7) {
                i9 = i8 + 7;
                i7 = e6;
            }
            i8++;
        }
    }

    public static j g(int i6) {
        if (i6 % 4 == 1) {
            try {
                return i((i6 - 17) / 4);
            } catch (IllegalArgumentException unused) {
                throw com.google.zxing.h.getFormatInstance();
            }
        }
        throw com.google.zxing.h.getFormatInstance();
    }

    public static j i(int i6) {
        if (i6 <= 0 || i6 > 40) {
            throw new IllegalArgumentException();
        }
        return f5864f[i6 - 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s3.b a() {
        int e6 = e();
        s3.b bVar = new s3.b(e6);
        bVar.k(0, 0, 9, 9);
        int i6 = e6 - 8;
        bVar.k(i6, 0, 8, 9);
        bVar.k(0, i6, 9, 8);
        int length = this.f5866b.length;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = this.f5866b[i7] - 2;
            for (int i9 = 0; i9 < length; i9++) {
                if ((i7 != 0 || (i9 != 0 && i9 != length - 1)) && (i7 != length - 1 || i9 != 0)) {
                    bVar.k(this.f5866b[i9] - 2, i8, 5, 5);
                }
            }
        }
        int i10 = e6 - 17;
        bVar.k(6, 9, 1, i10);
        bVar.k(9, 6, i10, 1);
        if (this.f5865a > 6) {
            int i11 = e6 - 11;
            bVar.k(i11, 0, 3, 6);
            bVar.k(0, i11, 6, 3);
        }
        return bVar;
    }

    public int[] d() {
        return this.f5866b;
    }

    public int e() {
        return (this.f5865a * 4) + 17;
    }

    public b f(f fVar) {
        return this.f5867c[fVar.ordinal()];
    }

    public int h() {
        return this.f5868d;
    }

    public int j() {
        return this.f5865a;
    }

    public String toString() {
        return String.valueOf(this.f5865a);
    }
}
