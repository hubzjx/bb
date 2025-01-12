package h3;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final m[] f10728a = new m[4];

    /* renamed from: b  reason: collision with root package name */
    private final Matrix[] f10729b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix[] f10730c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    private final PointF f10731d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    private final Path f10732e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final Path f10733f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final m f10734g = new m();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f10735h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    private final float[] f10736i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    private final Path f10737j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private final Path f10738k = new Path();

    /* renamed from: l  reason: collision with root package name */
    private boolean f10739l = true;

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final l f10740a = new l();
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(m mVar, Matrix matrix, int i6);

        void b(m mVar, Matrix matrix, int i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final k f10741a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f10742b;

        /* renamed from: c  reason: collision with root package name */
        public final RectF f10743c;

        /* renamed from: d  reason: collision with root package name */
        public final b f10744d;

        /* renamed from: e  reason: collision with root package name */
        public final float f10745e;

        c(k kVar, float f6, RectF rectF, b bVar, Path path) {
            this.f10744d = bVar;
            this.f10741a = kVar;
            this.f10745e = f6;
            this.f10743c = rectF;
            this.f10742b = path;
        }
    }

    public l() {
        for (int i6 = 0; i6 < 4; i6++) {
            this.f10728a[i6] = new m();
            this.f10729b[i6] = new Matrix();
            this.f10730c[i6] = new Matrix();
        }
    }

    private float a(int i6) {
        return (i6 + 1) * 90;
    }

    private void b(c cVar, int i6) {
        this.f10735h[0] = this.f10728a[i6].k();
        this.f10735h[1] = this.f10728a[i6].l();
        this.f10729b[i6].mapPoints(this.f10735h);
        Path path = cVar.f10742b;
        float[] fArr = this.f10735h;
        if (i6 == 0) {
            path.moveTo(fArr[0], fArr[1]);
        } else {
            path.lineTo(fArr[0], fArr[1]);
        }
        this.f10728a[i6].d(this.f10729b[i6], cVar.f10742b);
        b bVar = cVar.f10744d;
        if (bVar != null) {
            bVar.b(this.f10728a[i6], this.f10729b[i6], i6);
        }
    }

    private void c(c cVar, int i6) {
        m mVar;
        Matrix matrix;
        Path path;
        int i7 = (i6 + 1) % 4;
        this.f10735h[0] = this.f10728a[i6].i();
        this.f10735h[1] = this.f10728a[i6].j();
        this.f10729b[i6].mapPoints(this.f10735h);
        this.f10736i[0] = this.f10728a[i7].k();
        this.f10736i[1] = this.f10728a[i7].l();
        this.f10729b[i7].mapPoints(this.f10736i);
        float[] fArr = this.f10735h;
        float f6 = fArr[0];
        float[] fArr2 = this.f10736i;
        float max = Math.max(((float) Math.hypot(f6 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float i8 = i(cVar.f10743c, i6);
        this.f10734g.n(0.0f, 0.0f);
        f j6 = j(i6, cVar.f10741a);
        j6.b(max, i8, cVar.f10745e, this.f10734g);
        this.f10737j.reset();
        this.f10734g.d(this.f10730c[i6], this.f10737j);
        if (this.f10739l && (j6.a() || l(this.f10737j, i6) || l(this.f10737j, i7))) {
            Path path2 = this.f10737j;
            path2.op(path2, this.f10733f, Path.Op.DIFFERENCE);
            this.f10735h[0] = this.f10734g.k();
            this.f10735h[1] = this.f10734g.l();
            this.f10730c[i6].mapPoints(this.f10735h);
            Path path3 = this.f10732e;
            float[] fArr3 = this.f10735h;
            path3.moveTo(fArr3[0], fArr3[1]);
            mVar = this.f10734g;
            matrix = this.f10730c[i6];
            path = this.f10732e;
        } else {
            mVar = this.f10734g;
            matrix = this.f10730c[i6];
            path = cVar.f10742b;
        }
        mVar.d(matrix, path);
        b bVar = cVar.f10744d;
        if (bVar != null) {
            bVar.a(this.f10734g, this.f10730c[i6], i6);
        }
    }

    private void f(int i6, RectF rectF, PointF pointF) {
        float f6;
        float f7;
        if (i6 == 1) {
            f6 = rectF.right;
        } else if (i6 != 2) {
            f6 = i6 != 3 ? rectF.right : rectF.left;
            f7 = rectF.top;
            pointF.set(f6, f7);
        } else {
            f6 = rectF.left;
        }
        f7 = rectF.bottom;
        pointF.set(f6, f7);
    }

    private h3.c g(int i6, k kVar) {
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? kVar.t() : kVar.r() : kVar.j() : kVar.l();
    }

    private d h(int i6, k kVar) {
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? kVar.s() : kVar.q() : kVar.i() : kVar.k();
    }

    private float i(RectF rectF, int i6) {
        float centerX;
        float f6;
        float[] fArr = this.f10735h;
        m mVar = this.f10728a[i6];
        fArr[0] = mVar.f10748c;
        fArr[1] = mVar.f10749d;
        this.f10729b[i6].mapPoints(fArr);
        if (i6 == 1 || i6 == 3) {
            centerX = rectF.centerX();
            f6 = this.f10735h[0];
        } else {
            centerX = rectF.centerY();
            f6 = this.f10735h[1];
        }
        return Math.abs(centerX - f6);
    }

    private f j(int i6, k kVar) {
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? kVar.o() : kVar.p() : kVar.n() : kVar.h();
    }

    public static l k() {
        return a.f10740a;
    }

    private boolean l(Path path, int i6) {
        this.f10738k.reset();
        this.f10728a[i6].d(this.f10729b[i6], this.f10738k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f10738k.computeBounds(rectF, true);
        path.op(this.f10738k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void m(c cVar, int i6) {
        h(i6, cVar.f10741a).b(this.f10728a[i6], 90.0f, cVar.f10745e, cVar.f10743c, g(i6, cVar.f10741a));
        float a6 = a(i6);
        this.f10729b[i6].reset();
        f(i6, cVar.f10743c, this.f10731d);
        Matrix matrix = this.f10729b[i6];
        PointF pointF = this.f10731d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f10729b[i6].preRotate(a6);
    }

    private void n(int i6) {
        this.f10735h[0] = this.f10728a[i6].i();
        this.f10735h[1] = this.f10728a[i6].j();
        this.f10729b[i6].mapPoints(this.f10735h);
        float a6 = a(i6);
        this.f10730c[i6].reset();
        Matrix matrix = this.f10730c[i6];
        float[] fArr = this.f10735h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f10730c[i6].preRotate(a6);
    }

    public void d(k kVar, float f6, RectF rectF, Path path) {
        e(kVar, f6, rectF, null, path);
    }

    public void e(k kVar, float f6, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f10732e.rewind();
        this.f10733f.rewind();
        this.f10733f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(kVar, f6, rectF, bVar, path);
        for (int i6 = 0; i6 < 4; i6++) {
            m(cVar, i6);
            n(i6);
        }
        for (int i7 = 0; i7 < 4; i7++) {
            b(cVar, i7);
            c(cVar, i7);
        }
        path.close();
        this.f10732e.close();
        if (this.f10732e.isEmpty()) {
            return;
        }
        path.op(this.f10732e, Path.Op.UNION);
    }
}
