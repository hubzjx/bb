package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import e0.b0;
import java.util.ArrayList;
import java.util.List;
import u2.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ClockHandView extends View {

    /* renamed from: b  reason: collision with root package name */
    private ValueAnimator f5492b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5493c;

    /* renamed from: d  reason: collision with root package name */
    private float f5494d;

    /* renamed from: e  reason: collision with root package name */
    private float f5495e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5496f;

    /* renamed from: g  reason: collision with root package name */
    private int f5497g;

    /* renamed from: h  reason: collision with root package name */
    private final List f5498h;

    /* renamed from: i  reason: collision with root package name */
    private final int f5499i;

    /* renamed from: j  reason: collision with root package name */
    private final float f5500j;

    /* renamed from: k  reason: collision with root package name */
    private final Paint f5501k;

    /* renamed from: l  reason: collision with root package name */
    private final RectF f5502l;

    /* renamed from: m  reason: collision with root package name */
    private final int f5503m;

    /* renamed from: n  reason: collision with root package name */
    private float f5504n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f5505o;

    /* renamed from: p  reason: collision with root package name */
    private c f5506p;

    /* renamed from: q  reason: collision with root package name */
    private double f5507q;

    /* renamed from: r  reason: collision with root package name */
    private int f5508r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.n(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void c(float f6, boolean z5);
    }

    /* loaded from: classes.dex */
    public interface d {
        void e(float f6, boolean z5);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, u2.a.materialClockStyle);
    }

    private void c(Canvas canvas) {
        int width;
        int height = getHeight() / 2;
        float width2 = getWidth() / 2;
        float f6 = height;
        this.f5501k.setStrokeWidth(0.0f);
        canvas.drawCircle((this.f5508r * ((float) Math.cos(this.f5507q))) + width2, (this.f5508r * ((float) Math.sin(this.f5507q))) + f6, this.f5499i, this.f5501k);
        double sin = Math.sin(this.f5507q);
        double cos = Math.cos(this.f5507q);
        this.f5501k.setStrokeWidth(this.f5503m);
        canvas.drawLine(width2, f6, width + ((int) (cos * r6)), height + ((int) (r6 * sin)), this.f5501k);
        canvas.drawCircle(width2, f6, this.f5500j, this.f5501k);
    }

    private int e(float f6, float f7) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f7 - (getHeight() / 2), f6 - (getWidth() / 2)))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    private Pair h(float f6) {
        float f7 = f();
        if (Math.abs(f7 - f6) > 180.0f) {
            if (f7 > 180.0f && f6 < 180.0f) {
                f6 += 360.0f;
            }
            if (f7 < 180.0f && f6 > 180.0f) {
                f7 += 360.0f;
            }
        }
        return new Pair(Float.valueOf(f7), Float.valueOf(f6));
    }

    private boolean i(float f6, float f7, boolean z5, boolean z6, boolean z7) {
        float e6 = e(f6, f7);
        boolean z8 = false;
        boolean z9 = f() != e6;
        if (z6 && z9) {
            return true;
        }
        if (z9 || z5) {
            if (z7 && this.f5493c) {
                z8 = true;
            }
            m(e6, z8);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(float f6, boolean z5) {
        float f7 = f6 % 360.0f;
        this.f5504n = f7;
        this.f5507q = Math.toRadians(f7 - 90.0f);
        float width = (getWidth() / 2) + (this.f5508r * ((float) Math.cos(this.f5507q)));
        float height = (getHeight() / 2) + (this.f5508r * ((float) Math.sin(this.f5507q)));
        RectF rectF = this.f5502l;
        int i6 = this.f5499i;
        rectF.set(width - i6, height - i6, width + i6, height + i6);
        for (d dVar : this.f5498h) {
            dVar.e(f7, z5);
        }
        invalidate();
    }

    public void b(d dVar) {
        this.f5498h.add(dVar);
    }

    public RectF d() {
        return this.f5502l;
    }

    public float f() {
        return this.f5504n;
    }

    public int g() {
        return this.f5499i;
    }

    public void j(boolean z5) {
        this.f5493c = z5;
    }

    public void k(int i6) {
        this.f5508r = i6;
        invalidate();
    }

    public void l(float f6) {
        m(f6, false);
    }

    public void m(float f6, boolean z5) {
        ValueAnimator valueAnimator = this.f5492b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z5) {
            n(f6, false);
            return;
        }
        Pair h6 = h(f6);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) h6.first).floatValue(), ((Float) h6.second).floatValue());
        this.f5492b = ofFloat;
        ofFloat.setDuration(200L);
        this.f5492b.addUpdateListener(new a());
        this.f5492b.addListener(new b());
        this.f5492b.start();
    }

    public void o(c cVar) {
        this.f5506p = cVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        l(f());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        boolean z6;
        boolean z7;
        c cVar;
        int actionMasked = motionEvent.getActionMasked();
        float x5 = motionEvent.getX();
        float y5 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i6 = (int) (x5 - this.f5494d);
                int i7 = (int) (y5 - this.f5495e);
                this.f5496f = (i6 * i6) + (i7 * i7) > this.f5497g;
                boolean z8 = this.f5505o;
                z5 = actionMasked == 1;
                z6 = z8;
            } else {
                z5 = false;
                z6 = false;
            }
            z7 = false;
        } else {
            this.f5494d = x5;
            this.f5495e = y5;
            this.f5496f = true;
            this.f5505o = false;
            z5 = false;
            z6 = false;
            z7 = true;
        }
        boolean i8 = i(x5, y5, z6, z7, z5) | this.f5505o;
        this.f5505o = i8;
        if (i8 && z5 && (cVar = this.f5506p) != null) {
            cVar.c(e(x5, y5), this.f5496f);
        }
        return true;
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f5498h = new ArrayList();
        Paint paint = new Paint();
        this.f5501k = paint;
        this.f5502l = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.S0, i6, u2.i.Widget_MaterialComponents_TimePicker_Clock);
        this.f5508r = obtainStyledAttributes.getDimensionPixelSize(j.U0, 0);
        this.f5499i = obtainStyledAttributes.getDimensionPixelSize(j.V0, 0);
        Resources resources = getResources();
        this.f5503m = resources.getDimensionPixelSize(u2.c.material_clock_hand_stroke_width);
        this.f5500j = resources.getDimensionPixelSize(u2.c.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(j.T0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        l(0.0f);
        this.f5497g = ViewConfiguration.get(context).getScaledTouchSlop();
        b0.u0(this, 2);
        obtainStyledAttributes.recycle();
    }
}
