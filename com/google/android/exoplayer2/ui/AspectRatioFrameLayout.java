package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private final c f4489b;

    /* renamed from: c  reason: collision with root package name */
    private float f4490c;

    /* renamed from: d  reason: collision with root package name */
    private int f4491d;

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    private final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private float f4492a;

        /* renamed from: b  reason: collision with root package name */
        private float f4493b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4494c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4495d;

        private c() {
        }

        public void a(float f6, float f7, boolean z5) {
            this.f4492a = f6;
            this.f4493b = f7;
            this.f4494c = z5;
            if (this.f4495d) {
                return;
            }
            this.f4495d = true;
            AspectRatioFrameLayout.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4495d = false;
            AspectRatioFrameLayout.this.getClass();
        }
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4491d = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, p2.d.f12620a, 0, 0);
            try {
                this.f4491d = obtainStyledAttributes.getInt(p2.d.f12621b, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f4489b = new c();
    }

    public int getResizeMode() {
        return this.f4491d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r4 > 0.0f) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
        if (r4 > 0.0f) goto L21;
     */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (this.f4490c <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f6 = measuredWidth;
        float f7 = measuredHeight;
        float f8 = f6 / f7;
        float f9 = (this.f4490c / f8) - 1.0f;
        if (Math.abs(f9) <= 0.01f) {
            this.f4489b.a(this.f4490c, f8, false);
            return;
        }
        int i8 = this.f4491d;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 4) {
                    }
                }
                measuredWidth = (int) (f7 * this.f4490c);
            }
            measuredHeight = (int) (f6 / this.f4490c);
        }
        this.f4489b.a(this.f4490c, f8, true);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f6) {
        if (this.f4490c != f6) {
            this.f4490c = f6;
            requestLayout();
        }
    }

    public void setAspectRatioListener(b bVar) {
    }

    public void setResizeMode(int i6) {
        if (this.f4491d != i6) {
            this.f4491d = i6;
            requestLayout();
        }
    }
}
