package h2;

import android.graphics.Bitmap;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import e2.b;
import e2.d;
import e2.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: o  reason: collision with root package name */
    private final y f10634o;

    /* renamed from: p  reason: collision with root package name */
    private final y f10635p;

    /* renamed from: q  reason: collision with root package name */
    private final C0173a f10636q;

    /* renamed from: r  reason: collision with root package name */
    private Inflater f10637r;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0173a {

        /* renamed from: a  reason: collision with root package name */
        private final y f10638a = new y();

        /* renamed from: b  reason: collision with root package name */
        private final int[] f10639b = new int[256];

        /* renamed from: c  reason: collision with root package name */
        private boolean f10640c;

        /* renamed from: d  reason: collision with root package name */
        private int f10641d;

        /* renamed from: e  reason: collision with root package name */
        private int f10642e;

        /* renamed from: f  reason: collision with root package name */
        private int f10643f;

        /* renamed from: g  reason: collision with root package name */
        private int f10644g;

        /* renamed from: h  reason: collision with root package name */
        private int f10645h;

        /* renamed from: i  reason: collision with root package name */
        private int f10646i;

        /* JADX INFO: Access modifiers changed from: private */
        public void e(y yVar, int i6) {
            int D;
            if (i6 < 4) {
                return;
            }
            yVar.N(3);
            int i7 = i6 - 4;
            if ((yVar.A() & 128) != 0) {
                if (i7 < 7 || (D = yVar.D()) < 4) {
                    return;
                }
                this.f10645h = yVar.G();
                this.f10646i = yVar.G();
                this.f10638a.I(D - 4);
                i7 -= 7;
            }
            int d6 = this.f10638a.d();
            int e6 = this.f10638a.e();
            if (d6 >= e6 || i7 <= 0) {
                return;
            }
            int min = Math.min(i7, e6 - d6);
            yVar.i(this.f10638a.c(), d6, min);
            this.f10638a.M(d6 + min);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(y yVar, int i6) {
            if (i6 < 19) {
                return;
            }
            this.f10641d = yVar.G();
            this.f10642e = yVar.G();
            yVar.N(11);
            this.f10643f = yVar.G();
            this.f10644g = yVar.G();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(y yVar, int i6) {
            if (i6 % 5 != 2) {
                return;
            }
            yVar.N(2);
            Arrays.fill(this.f10639b, 0);
            int i7 = i6 / 5;
            for (int i8 = 0; i8 < i7; i8++) {
                int A = yVar.A();
                int A2 = yVar.A();
                int A3 = yVar.A();
                int A4 = yVar.A();
                double d6 = A2;
                double d7 = A3 - 128;
                double d8 = A4 - 128;
                this.f10639b[A] = (s0.r((int) ((d6 - (0.34414d * d8)) - (d7 * 0.71414d)), 0, 255) << 8) | (yVar.A() << 24) | (s0.r((int) ((1.402d * d7) + d6), 0, 255) << 16) | s0.r((int) (d6 + (d8 * 1.772d)), 0, 255);
            }
            this.f10640c = true;
        }

        public e2.b d() {
            int i6;
            if (this.f10641d == 0 || this.f10642e == 0 || this.f10645h == 0 || this.f10646i == 0 || this.f10638a.e() == 0 || this.f10638a.d() != this.f10638a.e() || !this.f10640c) {
                return null;
            }
            this.f10638a.M(0);
            int i7 = this.f10645h * this.f10646i;
            int[] iArr = new int[i7];
            int i8 = 0;
            while (i8 < i7) {
                int A = this.f10638a.A();
                if (A != 0) {
                    i6 = i8 + 1;
                    iArr[i8] = this.f10639b[A];
                } else {
                    int A2 = this.f10638a.A();
                    if (A2 != 0) {
                        i6 = ((A2 & 64) == 0 ? A2 & 63 : ((A2 & 63) << 8) | this.f10638a.A()) + i8;
                        Arrays.fill(iArr, i8, i6, (A2 & 128) == 0 ? 0 : this.f10639b[this.f10638a.A()]);
                    }
                }
                i8 = i6;
            }
            return new b.C0159b().f(Bitmap.createBitmap(iArr, this.f10645h, this.f10646i, Bitmap.Config.ARGB_8888)).j(this.f10643f / this.f10641d).k(0).h(this.f10644g / this.f10642e, 0).i(0).l(this.f10645h / this.f10641d).g(this.f10646i / this.f10642e).a();
        }

        public void h() {
            this.f10641d = 0;
            this.f10642e = 0;
            this.f10643f = 0;
            this.f10644g = 0;
            this.f10645h = 0;
            this.f10646i = 0;
            this.f10638a.I(0);
            this.f10640c = false;
        }
    }

    public a() {
        super("PgsDecoder");
        this.f10634o = new y();
        this.f10635p = new y();
        this.f10636q = new C0173a();
    }

    private void C(y yVar) {
        if (yVar.a() <= 0 || yVar.g() != 120) {
            return;
        }
        if (this.f10637r == null) {
            this.f10637r = new Inflater();
        }
        if (s0.l0(yVar, this.f10635p, this.f10637r)) {
            yVar.K(this.f10635p.c(), this.f10635p.e());
        }
    }

    private static e2.b D(y yVar, C0173a c0173a) {
        int e6 = yVar.e();
        int A = yVar.A();
        int G = yVar.G();
        int d6 = yVar.d() + G;
        e2.b bVar = null;
        if (d6 > e6) {
            yVar.M(e6);
            return null;
        }
        if (A != 128) {
            switch (A) {
                case 20:
                    c0173a.g(yVar, G);
                    break;
                case 21:
                    c0173a.e(yVar, G);
                    break;
                case 22:
                    c0173a.f(yVar, G);
                    break;
            }
        } else {
            bVar = c0173a.d();
            c0173a.h();
        }
        yVar.M(d6);
        return bVar;
    }

    @Override // e2.d
    protected f A(byte[] bArr, int i6, boolean z5) {
        this.f10634o.K(bArr, i6);
        C(this.f10634o);
        this.f10636q.h();
        ArrayList arrayList = new ArrayList();
        while (this.f10634o.a() >= 3) {
            e2.b D = D(this.f10634o, this.f10636q);
            if (D != null) {
                arrayList.add(D);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }
}
