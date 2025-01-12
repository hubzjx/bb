package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
class c extends h3.g {
    private final RectF A;
    private int B;

    /* renamed from: z  reason: collision with root package name */
    private final Paint f5412z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(h3.k kVar) {
        super(kVar == null ? new h3.k() : kVar);
        this.f5412z = new Paint(1);
        m0();
        this.A = new RectF();
    }

    private void g0(Canvas canvas) {
        if (n0(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.B);
    }

    private void h0(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (!n0(callback)) {
            j0(canvas);
            return;
        }
        View view = (View) callback;
        if (view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    private void j0(Canvas canvas) {
        this.B = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
    }

    private void m0() {
        this.f5412z.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f5412z.setColor(-1);
        this.f5412z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean n0(Drawable.Callback callback) {
        return callback instanceof View;
    }

    @Override // h3.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        h0(canvas);
        super.draw(canvas);
        canvas.drawRect(this.A, this.f5412z);
        g0(canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f0() {
        return !this.A.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i0() {
        k0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void k0(float f6, float f7, float f8, float f9) {
        RectF rectF = this.A;
        if (f6 == rectF.left && f7 == rectF.top && f8 == rectF.right && f9 == rectF.bottom) {
            return;
        }
        rectF.set(f6, f7, f8, f9);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l0(RectF rectF) {
        k0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
