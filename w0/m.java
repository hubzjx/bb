package w0;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
/* loaded from: classes.dex */
public class m implements View.OnTouchListener, View.OnLayoutChangeListener {
    private static float A = 3.0f;
    private static float B = 1.75f;
    private static float C = 1.0f;
    private static int D = 200;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f13739i;

    /* renamed from: j  reason: collision with root package name */
    private GestureDetector f13740j;

    /* renamed from: k  reason: collision with root package name */
    private w0.b f13741k;

    /* renamed from: q  reason: collision with root package name */
    private g f13747q;

    /* renamed from: r  reason: collision with root package name */
    private View.OnClickListener f13748r;

    /* renamed from: s  reason: collision with root package name */
    private View.OnLongClickListener f13749s;

    /* renamed from: t  reason: collision with root package name */
    private f f13750t;

    /* renamed from: w  reason: collision with root package name */
    private float f13753w;

    /* renamed from: b  reason: collision with root package name */
    private Interpolator f13732b = new AccelerateDecelerateInterpolator();

    /* renamed from: c  reason: collision with root package name */
    private int f13733c = D;

    /* renamed from: d  reason: collision with root package name */
    private float f13734d = C;

    /* renamed from: e  reason: collision with root package name */
    private float f13735e = B;

    /* renamed from: f  reason: collision with root package name */
    private float f13736f = A;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13737g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13738h = false;

    /* renamed from: l  reason: collision with root package name */
    private final Matrix f13742l = new Matrix();

    /* renamed from: m  reason: collision with root package name */
    private final Matrix f13743m = new Matrix();

    /* renamed from: n  reason: collision with root package name */
    private final Matrix f13744n = new Matrix();

    /* renamed from: o  reason: collision with root package name */
    private final RectF f13745o = new RectF();

    /* renamed from: p  reason: collision with root package name */
    private final float[] f13746p = new float[9];

    /* renamed from: u  reason: collision with root package name */
    private int f13751u = 2;

    /* renamed from: v  reason: collision with root package name */
    private int f13752v = 2;

    /* renamed from: x  reason: collision with root package name */
    private boolean f13754x = true;

    /* renamed from: y  reason: collision with root package name */
    private ImageView.ScaleType f13755y = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: z  reason: collision with root package name */
    private w0.d f13756z = new a();

    /* loaded from: classes.dex */
    class a implements w0.d {
        a() {
        }

        @Override // w0.d
        public void a(float f6, float f7, float f8) {
            if (m.this.K() < m.this.f13736f || f6 < 1.0f) {
                m.this.getClass();
                m.this.f13744n.postScale(f6, f6, f7, f8);
                m.this.z();
            }
        }

        @Override // w0.d
        public void b(float f6, float f7) {
            if (m.this.f13741k.e()) {
                return;
            }
            m.this.getClass();
            m.this.f13744n.postTranslate(f6, f7);
            m.this.z();
            ViewParent parent = m.this.f13739i.getParent();
            if (!m.this.f13737g || m.this.f13741k.e() || m.this.f13738h) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((m.this.f13751u == 2 || ((m.this.f13751u == 0 && f6 >= 1.0f) || ((m.this.f13751u == 1 && f6 <= -1.0f) || ((m.this.f13752v == 0 && f7 >= 1.0f) || (m.this.f13752v == 1 && f7 <= -1.0f))))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }

        @Override // w0.d
        public void c(float f6, float f7, float f8, float f9) {
            m mVar = m.this;
            mVar.f13750t = new f(mVar.f13739i.getContext());
            f fVar = m.this.f13750t;
            m mVar2 = m.this;
            int G = mVar2.G(mVar2.f13739i);
            m mVar3 = m.this;
            fVar.b(G, mVar3.F(mVar3.f13739i), (int) f8, (int) f9);
            m.this.f13739i.post(m.this.f13750t);
        }
    }

    /* loaded from: classes.dex */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
            m.this.getClass();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (m.this.f13749s != null) {
                m.this.f13749s.onLongClick(m.this.f13739i);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            m mVar;
            float J;
            try {
                float K = m.this.K();
                float x5 = motionEvent.getX();
                float y5 = motionEvent.getY();
                if (K < m.this.I()) {
                    mVar = m.this;
                    J = mVar.I();
                } else if (K < m.this.I() || K >= m.this.H()) {
                    mVar = m.this;
                    J = mVar.J();
                } else {
                    mVar = m.this;
                    J = mVar.H();
                }
                mVar.g0(J, x5, y5, true);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (m.this.f13748r != null) {
                m.this.f13748r.onClick(m.this.f13739i);
            }
            RectF B = m.this.B();
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            m.this.getClass();
            if (B != null) {
                if (!B.contains(x5, y5)) {
                    m.this.getClass();
                    return false;
                }
                float width = (x5 - B.left) / B.width();
                float height = (y5 - B.top) / B.height();
                if (m.this.f13747q != null) {
                    m.this.f13747q.a(m.this.f13739i, width, height);
                    return true;
                }
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13760a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f13760a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13760a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13760a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13760a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final float f13761a;

        /* renamed from: b  reason: collision with root package name */
        private final float f13762b;

        /* renamed from: c  reason: collision with root package name */
        private final long f13763c = System.currentTimeMillis();

        /* renamed from: d  reason: collision with root package name */
        private final float f13764d;

        /* renamed from: e  reason: collision with root package name */
        private final float f13765e;

        public e(float f6, float f7, float f8, float f9) {
            this.f13761a = f8;
            this.f13762b = f9;
            this.f13764d = f6;
            this.f13765e = f7;
        }

        private float a() {
            return m.this.f13732b.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f13763c)) * 1.0f) / m.this.f13733c));
        }

        @Override // java.lang.Runnable
        public void run() {
            float a6 = a();
            float f6 = this.f13764d;
            m.this.f13756z.a((f6 + ((this.f13765e - f6) * a6)) / m.this.K(), this.f13761a, this.f13762b);
            if (a6 < 1.0f) {
                w0.a.a(m.this.f13739i, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final OverScroller f13767a;

        /* renamed from: b  reason: collision with root package name */
        private int f13768b;

        /* renamed from: c  reason: collision with root package name */
        private int f13769c;

        public f(Context context) {
            this.f13767a = new OverScroller(context);
        }

        public void a() {
            this.f13767a.forceFinished(true);
        }

        public void b(int i6, int i7, int i8, int i9) {
            int i10;
            int i11;
            int i12;
            int i13;
            RectF B = m.this.B();
            if (B == null) {
                return;
            }
            int round = Math.round(-B.left);
            float f6 = i6;
            if (f6 < B.width()) {
                i11 = Math.round(B.width() - f6);
                i10 = 0;
            } else {
                i10 = round;
                i11 = i10;
            }
            int round2 = Math.round(-B.top);
            float f7 = i7;
            if (f7 < B.height()) {
                i13 = Math.round(B.height() - f7);
                i12 = 0;
            } else {
                i12 = round2;
                i13 = i12;
            }
            this.f13768b = round;
            this.f13769c = round2;
            if (round == i11 && round2 == i13) {
                return;
            }
            this.f13767a.fling(round, round2, i8, i9, i10, i11, i12, i13, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f13767a.isFinished() && this.f13767a.computeScrollOffset()) {
                int currX = this.f13767a.getCurrX();
                int currY = this.f13767a.getCurrY();
                m.this.f13744n.postTranslate(this.f13768b - currX, this.f13769c - currY);
                m.this.z();
                this.f13768b = currX;
                this.f13769c = currY;
                w0.a.a(m.this.f13739i, this);
            }
        }
    }

    public m(ImageView imageView) {
        this.f13739i = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f13753w = 0.0f;
        this.f13741k = new w0.b(imageView.getContext(), this.f13756z);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.f13740j = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    private boolean A() {
        float f6;
        RectF C2 = C(D());
        if (C2 == null) {
            return false;
        }
        float height = C2.height();
        float width = C2.width();
        float F = F(this.f13739i);
        float f7 = 0.0f;
        if (height <= F) {
            int i6 = d.f13760a[this.f13755y.ordinal()];
            if (i6 != 2) {
                float f8 = F - height;
                if (i6 != 3) {
                    f8 /= 2.0f;
                }
                f6 = f8 - C2.top;
            } else {
                f6 = -C2.top;
            }
            this.f13752v = 2;
        } else {
            float f9 = C2.top;
            if (f9 > 0.0f) {
                this.f13752v = 0;
                f6 = -f9;
            } else {
                float f10 = C2.bottom;
                if (f10 < F) {
                    this.f13752v = 1;
                    f6 = F - f10;
                } else {
                    this.f13752v = -1;
                    f6 = 0.0f;
                }
            }
        }
        float G = G(this.f13739i);
        if (width <= G) {
            int i7 = d.f13760a[this.f13755y.ordinal()];
            if (i7 != 2) {
                float f11 = G - width;
                if (i7 != 3) {
                    f11 /= 2.0f;
                }
                f7 = f11 - C2.left;
            } else {
                f7 = -C2.left;
            }
            this.f13751u = 2;
        } else {
            float f12 = C2.left;
            if (f12 > 0.0f) {
                this.f13751u = 0;
                f7 = -f12;
            } else {
                float f13 = C2.right;
                if (f13 < G) {
                    f7 = G - f13;
                    this.f13751u = 1;
                } else {
                    this.f13751u = -1;
                }
            }
        }
        this.f13744n.postTranslate(f7, f6);
        return true;
    }

    private RectF C(Matrix matrix) {
        Drawable drawable = this.f13739i.getDrawable();
        if (drawable != null) {
            this.f13745o.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(this.f13745o);
            return this.f13745o;
        }
        return null;
    }

    private Matrix D() {
        this.f13743m.set(this.f13742l);
        this.f13743m.postConcat(this.f13744n);
        return this.f13743m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float M(Matrix matrix, int i6) {
        matrix.getValues(this.f13746p);
        return this.f13746p[i6];
    }

    private void N() {
        this.f13744n.reset();
        d0(this.f13753w);
        P(D());
        A();
    }

    private void P(Matrix matrix) {
        this.f13739i.setImageMatrix(matrix);
    }

    private void m0(Drawable drawable) {
        Matrix matrix;
        Matrix.ScaleToFit scaleToFit;
        float min;
        if (drawable == null) {
            return;
        }
        float G = G(this.f13739i);
        float F = F(this.f13739i);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f13742l.reset();
        float f6 = intrinsicWidth;
        float f7 = G / f6;
        float f8 = intrinsicHeight;
        float f9 = F / f8;
        ImageView.ScaleType scaleType = this.f13755y;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f13742l.postTranslate((G - f6) / 2.0f, (F - f8) / 2.0f);
        } else {
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                min = Math.max(f7, f9);
            } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                min = Math.min(1.0f, Math.min(f7, f9));
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f6, f8);
                RectF rectF2 = new RectF(0.0f, 0.0f, G, F);
                if (((int) this.f13753w) % 180 != 0) {
                    rectF = new RectF(0.0f, 0.0f, f8, f6);
                }
                int i6 = d.f13760a[this.f13755y.ordinal()];
                if (i6 == 1) {
                    matrix = this.f13742l;
                    scaleToFit = Matrix.ScaleToFit.CENTER;
                } else if (i6 == 2) {
                    matrix = this.f13742l;
                    scaleToFit = Matrix.ScaleToFit.START;
                } else if (i6 == 3) {
                    matrix = this.f13742l;
                    scaleToFit = Matrix.ScaleToFit.END;
                } else if (i6 == 4) {
                    matrix = this.f13742l;
                    scaleToFit = Matrix.ScaleToFit.FILL;
                }
                matrix.setRectToRect(rectF, rectF2, scaleToFit);
            }
            this.f13742l.postScale(min, min);
            this.f13742l.postTranslate((G - (f6 * min)) / 2.0f, (F - (f8 * min)) / 2.0f);
        }
        N();
    }

    private void y() {
        f fVar = this.f13750t;
        if (fVar != null) {
            fVar.a();
            this.f13750t = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (A()) {
            P(D());
        }
    }

    public RectF B() {
        A();
        return C(D());
    }

    public Matrix E() {
        return this.f13743m;
    }

    public float H() {
        return this.f13736f;
    }

    public float I() {
        return this.f13735e;
    }

    public float J() {
        return this.f13734d;
    }

    public float K() {
        return (float) Math.sqrt(((float) Math.pow(M(this.f13744n, 0), 2.0d)) + ((float) Math.pow(M(this.f13744n, 3), 2.0d)));
    }

    public ImageView.ScaleType L() {
        return this.f13755y;
    }

    public void O(boolean z5) {
        this.f13737g = z5;
    }

    public void Q(float f6) {
        n.a(this.f13734d, this.f13735e, f6);
        this.f13736f = f6;
    }

    public void R(float f6) {
        n.a(this.f13734d, f6, this.f13736f);
        this.f13735e = f6;
    }

    public void S(float f6) {
        n.a(f6, this.f13735e, this.f13736f);
        this.f13734d = f6;
    }

    public void T(View.OnClickListener onClickListener) {
        this.f13748r = onClickListener;
    }

    public void U(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f13740j.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void V(View.OnLongClickListener onLongClickListener) {
        this.f13749s = onLongClickListener;
    }

    public void W(w0.e eVar) {
    }

    public void X(w0.f fVar) {
    }

    public void Y(g gVar) {
        this.f13747q = gVar;
    }

    public void Z(h hVar) {
    }

    public void a0(i iVar) {
    }

    public void b0(j jVar) {
    }

    public void c0(k kVar) {
    }

    public void d0(float f6) {
        this.f13744n.postRotate(f6 % 360.0f);
        z();
    }

    public void e0(float f6) {
        this.f13744n.setRotate(f6 % 360.0f);
        z();
    }

    public void f0(float f6) {
        h0(f6, false);
    }

    public void g0(float f6, float f7, float f8, boolean z5) {
        if (f6 < this.f13734d || f6 > this.f13736f) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z5) {
            this.f13739i.post(new e(K(), f6, f7, f8));
            return;
        }
        this.f13744n.setScale(f6, f6, f7, f8);
        z();
    }

    public void h0(float f6, boolean z5) {
        g0(f6, this.f13739i.getRight() / 2, this.f13739i.getBottom() / 2, z5);
    }

    public void i0(ImageView.ScaleType scaleType) {
        if (!n.d(scaleType) || scaleType == this.f13755y) {
            return;
        }
        this.f13755y = scaleType;
        l0();
    }

    public void j0(int i6) {
        this.f13733c = i6;
    }

    public void k0(boolean z5) {
        this.f13754x = z5;
        l0();
    }

    public void l0() {
        if (this.f13754x) {
            m0(this.f13739i.getDrawable());
        } else {
            N();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        if (i6 == i10 && i7 == i11 && i8 == i12 && i9 == i13) {
            return;
        }
        m0(this.f13739i.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00af  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z5;
        w0.b bVar;
        boolean z6;
        GestureDetector gestureDetector;
        RectF B2;
        e eVar;
        boolean z7 = false;
        if (this.f13754x && n.c((ImageView) view)) {
            int action = motionEvent.getAction();
            if (action == 0) {
                ViewParent parent = view.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                y();
            } else if (action == 1 || action == 3) {
                if (K() < this.f13734d) {
                    RectF B3 = B();
                    if (B3 != null) {
                        eVar = new e(K(), this.f13734d, B3.centerX(), B3.centerY());
                        view.post(eVar);
                        z5 = true;
                    }
                } else if (K() > this.f13736f && (B2 = B()) != null) {
                    eVar = new e(K(), this.f13736f, B2.centerX(), B2.centerY());
                    view.post(eVar);
                    z5 = true;
                }
                bVar = this.f13741k;
                if (bVar == null) {
                    boolean e6 = bVar.e();
                    boolean d6 = this.f13741k.d();
                    boolean f6 = this.f13741k.f(motionEvent);
                    boolean z8 = (e6 || this.f13741k.e()) ? false : true;
                    boolean z9 = (d6 || this.f13741k.d()) ? false : true;
                    if (z8 && z9) {
                        z7 = true;
                    }
                    this.f13738h = z7;
                    z6 = f6;
                } else {
                    z6 = z5;
                }
                gestureDetector = this.f13740j;
                if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                    return true;
                }
            }
            z5 = false;
            bVar = this.f13741k;
            if (bVar == null) {
            }
            gestureDetector = this.f13740j;
            return gestureDetector == null ? z6 : z6;
        }
        return false;
    }
}
