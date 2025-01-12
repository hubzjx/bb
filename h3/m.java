package h3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public float f10746a;

    /* renamed from: b  reason: collision with root package name */
    public float f10747b;

    /* renamed from: c  reason: collision with root package name */
    public float f10748c;

    /* renamed from: d  reason: collision with root package name */
    public float f10749d;

    /* renamed from: e  reason: collision with root package name */
    public float f10750e;

    /* renamed from: f  reason: collision with root package name */
    public float f10751f;

    /* renamed from: g  reason: collision with root package name */
    private final List f10752g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final List f10753h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private boolean f10754i;

    /* loaded from: classes.dex */
    class a extends g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f10755b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Matrix f10756c;

        a(List list, Matrix matrix) {
            this.f10755b = list;
            this.f10756c = matrix;
        }

        @Override // h3.m.g
        public void a(Matrix matrix, g3.a aVar, int i6, Canvas canvas) {
            for (g gVar : this.f10755b) {
                gVar.a(this.f10756c, aVar, i6, canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends g {

        /* renamed from: b  reason: collision with root package name */
        private final d f10758b;

        public b(d dVar) {
            this.f10758b = dVar;
        }

        @Override // h3.m.g
        public void a(Matrix matrix, g3.a aVar, int i6, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f10758b.k(), this.f10758b.o(), this.f10758b.l(), this.f10758b.j()), i6, this.f10758b.m(), this.f10758b.n());
        }
    }

    /* loaded from: classes.dex */
    static class c extends g {

        /* renamed from: b  reason: collision with root package name */
        private final e f10759b;

        /* renamed from: c  reason: collision with root package name */
        private final float f10760c;

        /* renamed from: d  reason: collision with root package name */
        private final float f10761d;

        public c(e eVar, float f6, float f7) {
            this.f10759b = eVar;
            this.f10760c = f6;
            this.f10761d = f7;
        }

        @Override // h3.m.g
        public void a(Matrix matrix, g3.a aVar, int i6, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f10759b.f10770c - this.f10761d, this.f10759b.f10769b - this.f10760c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f10760c, this.f10761d);
            matrix2.preRotate(c());
            aVar.b(canvas, matrix2, rectF, i6);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f10759b.f10770c - this.f10761d) / (this.f10759b.f10769b - this.f10760c)));
        }
    }

    /* loaded from: classes.dex */
    public static class d extends f {

        /* renamed from: h  reason: collision with root package name */
        private static final RectF f10762h = new RectF();

        /* renamed from: b  reason: collision with root package name */
        public float f10763b;

        /* renamed from: c  reason: collision with root package name */
        public float f10764c;

        /* renamed from: d  reason: collision with root package name */
        public float f10765d;

        /* renamed from: e  reason: collision with root package name */
        public float f10766e;

        /* renamed from: f  reason: collision with root package name */
        public float f10767f;

        /* renamed from: g  reason: collision with root package name */
        public float f10768g;

        public d(float f6, float f7, float f8, float f9) {
            q(f6);
            u(f7);
            r(f8);
            p(f9);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f10766e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f10763b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f10765d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f10767f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f10768g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f10764c;
        }

        private void p(float f6) {
            this.f10766e = f6;
        }

        private void q(float f6) {
            this.f10763b = f6;
        }

        private void r(float f6) {
            this.f10765d = f6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f6) {
            this.f10767f = f6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f6) {
            this.f10768g = f6;
        }

        private void u(float f6) {
            this.f10764c = f6;
        }

        @Override // h3.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f10771a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f10762h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends f {

        /* renamed from: b  reason: collision with root package name */
        private float f10769b;

        /* renamed from: c  reason: collision with root package name */
        private float f10770c;

        @Override // h3.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f10771a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f10769b, this.f10770c);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        protected final Matrix f10771a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class g {

        /* renamed from: a  reason: collision with root package name */
        static final Matrix f10772a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, g3.a aVar, int i6, Canvas canvas);

        public final void b(g3.a aVar, int i6, Canvas canvas) {
            a(f10772a, aVar, i6, canvas);
        }
    }

    public m() {
        n(0.0f, 0.0f);
    }

    private void b(float f6) {
        if (g() == f6) {
            return;
        }
        float g6 = ((f6 - g()) + 360.0f) % 360.0f;
        if (g6 > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(g6);
        this.f10753h.add(new b(dVar));
        p(f6);
    }

    private void c(g gVar, float f6, float f7) {
        b(f6);
        this.f10753h.add(gVar);
        p(f7);
    }

    private float g() {
        return this.f10750e;
    }

    private float h() {
        return this.f10751f;
    }

    private void p(float f6) {
        this.f10750e = f6;
    }

    private void q(float f6) {
        this.f10751f = f6;
    }

    private void r(float f6) {
        this.f10748c = f6;
    }

    private void s(float f6) {
        this.f10749d = f6;
    }

    private void t(float f6) {
        this.f10746a = f6;
    }

    private void u(float f6) {
        this.f10747b = f6;
    }

    public void a(float f6, float f7, float f8, float f9, float f10, float f11) {
        d dVar = new d(f6, f7, f8, f9);
        dVar.s(f10);
        dVar.t(f11);
        this.f10752g.add(dVar);
        b bVar = new b(dVar);
        float f12 = f10 + f11;
        boolean z5 = f11 < 0.0f;
        if (z5) {
            f10 = (f10 + 180.0f) % 360.0f;
        }
        c(bVar, f10, z5 ? (180.0f + f12) % 360.0f : f12);
        double d6 = f12;
        r(((f6 + f8) * 0.5f) + (((f8 - f6) / 2.0f) * ((float) Math.cos(Math.toRadians(d6)))));
        s(((f7 + f9) * 0.5f) + (((f9 - f7) / 2.0f) * ((float) Math.sin(Math.toRadians(d6)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f10752g.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((f) this.f10752g.get(i6)).a(matrix, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f10754i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f10753h), new Matrix(matrix));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f10748c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f10749d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        return this.f10746a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.f10747b;
    }

    public void m(float f6, float f7) {
        e eVar = new e();
        eVar.f10769b = f6;
        eVar.f10770c = f7;
        this.f10752g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f6);
        s(f7);
    }

    public void n(float f6, float f7) {
        o(f6, f7, 270.0f, 0.0f);
    }

    public void o(float f6, float f7, float f8, float f9) {
        t(f6);
        u(f7);
        r(f6);
        s(f7);
        p(f8);
        q((f8 + f9) % 360.0f);
        this.f10752g.clear();
        this.f10753h.clear();
        this.f10754i = false;
    }
}
