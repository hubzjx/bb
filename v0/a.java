package v0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import s0.g;
/* loaded from: classes.dex */
public abstract class a extends View {

    /* renamed from: b  reason: collision with root package name */
    protected Bitmap f13648b;

    /* renamed from: c  reason: collision with root package name */
    protected Canvas f13649c;

    /* renamed from: d  reason: collision with root package name */
    protected Bitmap f13650d;

    /* renamed from: e  reason: collision with root package name */
    protected Canvas f13651e;

    /* renamed from: f  reason: collision with root package name */
    protected int f13652f;

    /* renamed from: g  reason: collision with root package name */
    protected int f13653g;

    /* renamed from: h  reason: collision with root package name */
    protected int f13654h;

    /* renamed from: i  reason: collision with root package name */
    protected float f13655i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f13656j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13657k;

    public a(Context context) {
        super(context);
        this.f13653g = 20;
        this.f13654h = 5;
        this.f13655i = 1.0f;
        this.f13656j = false;
        this.f13657k = false;
        e(context, null);
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, g.f13098a, 0, 0);
        try {
            this.f13657k = obtainStyledAttributes.getBoolean(g.f13099b, this.f13657k);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        int width;
        int height;
        if (this.f13657k) {
            width = getHeight();
            height = getWidth();
        } else {
            width = getWidth();
            height = getHeight();
        }
        this.f13650d = Bitmap.createBitmap(Math.max(width - (this.f13652f * 2), 1), this.f13654h, Bitmap.Config.ARGB_8888);
        this.f13651e = new Canvas(this.f13650d);
        Bitmap bitmap = this.f13648b;
        if (bitmap != null && bitmap.getWidth() == width && this.f13648b.getHeight() == height) {
            return;
        }
        Bitmap bitmap2 = this.f13648b;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.f13648b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f13649c = new Canvas(this.f13648b);
    }

    protected abstract void b(Canvas canvas);

    protected abstract void c(Canvas canvas, float f6, float f7);

    protected int d(int i6) {
        return getResources().getDimensionPixelSize(i6);
    }

    protected abstract void f(float f6);

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        this.f13653g = d(s0.d.default_slider_handler_radius);
        this.f13654h = d(s0.d.default_slider_bar_height);
        this.f13652f = this.f13653g;
        if (this.f13650d == null) {
            a();
        }
        b(this.f13651e);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        int height;
        Canvas canvas2;
        super.onDraw(canvas);
        if (this.f13657k) {
            width = getHeight();
            height = getWidth();
            canvas.rotate(-90.0f);
            canvas.translate(-width, 0.0f);
        } else {
            width = getWidth();
            height = getHeight();
        }
        if (this.f13650d == null || (canvas2 = this.f13649c) == null) {
            return;
        }
        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
        Canvas canvas3 = this.f13649c;
        Bitmap bitmap = this.f13650d;
        canvas3.drawBitmap(bitmap, this.f13652f, (height - bitmap.getHeight()) / 2, (Paint) null);
        int i6 = this.f13653g;
        c(this.f13649c, i6 + (this.f13655i * (width - (i6 * 2))), height / 2.0f);
        canvas.drawBitmap(this.f13648b, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int mode = View.MeasureSpec.getMode(i6);
        if (mode != 0) {
            i6 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.getSize(i6) : 0;
        }
        int mode2 = View.MeasureSpec.getMode(i7);
        if (mode2 != 0) {
            i7 = (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) ? View.MeasureSpec.getSize(i7) : 0;
        }
        setMeasuredDimension(i6, i7);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000a, code lost:
        if (r0 != 2) goto L6;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float max;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                max = this.f13655i;
                f(max);
                invalidate();
                return true;
            }
        }
        if (this.f13650d != null) {
            this.f13655i = this.f13657k ? 1.0f - ((motionEvent.getY() - this.f13652f) / this.f13650d.getWidth()) : (motionEvent.getX() - this.f13652f) / this.f13650d.getWidth();
            max = Math.max(0.0f, Math.min(this.f13655i, 1.0f));
            this.f13655i = max;
            f(max);
            invalidate();
        }
        return true;
    }

    public void setOnValueChangedListener(d dVar) {
    }

    public void setShowBorder(boolean z5) {
        this.f13656j = z5;
    }
}
