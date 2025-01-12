package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.google.android.material.timepicker.ClockHandView;
import e0.b0;
import f0.y;
import java.util.Arrays;
import okhttp3.HttpUrl;
import u2.j;
/* loaded from: classes.dex */
class ClockFaceView extends d implements ClockHandView.d {
    private final ClockHandView B;
    private final Rect C;
    private final RectF D;
    private final SparseArray E;
    private final e0.a F;
    private final int[] G;
    private final float[] H;
    private final int I;
    private final int J;
    private final int K;
    private final int L;
    private String[] M;
    private float N;
    private final ColorStateList O;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (ClockFaceView.this.isShown()) {
                ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                ClockFaceView.this.v(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.B.g()) - ClockFaceView.this.I);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b extends e0.a {
        b() {
        }

        @Override // e0.a
        public void g(View view, y yVar) {
            super.g(view, yVar);
            int intValue = ((Integer) view.getTag(u2.e.material_value_index)).intValue();
            if (intValue > 0) {
                yVar.t0((View) ClockFaceView.this.E.get(intValue - 1));
            }
            yVar.Z(y.c.a(0, 1, intValue, 1, false, view.isSelected()));
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, u2.a.materialClockStyle);
    }

    private void C() {
        RectF d6 = this.B.d();
        for (int i6 = 0; i6 < this.E.size(); i6++) {
            TextView textView = (TextView) this.E.get(i6);
            if (textView != null) {
                textView.getDrawingRect(this.C);
                this.C.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.C);
                this.D.set(this.C);
                textView.getPaint().setShader(D(d6, this.D));
                textView.invalidate();
            }
        }
    }

    private RadialGradient D(RectF rectF, RectF rectF2) {
        if (RectF.intersects(rectF, rectF2)) {
            return new RadialGradient(rectF.centerX() - this.D.left, rectF.centerY() - this.D.top, rectF.width() * 0.5f, this.G, this.H, Shader.TileMode.CLAMP);
        }
        return null;
    }

    private static float E(float f6, float f7, float f8) {
        return Math.max(Math.max(f6, f7), f8);
    }

    private void G(int i6) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.E.size();
        for (int i7 = 0; i7 < Math.max(this.M.length, size); i7++) {
            TextView textView = (TextView) this.E.get(i7);
            if (i7 >= this.M.length) {
                removeView(textView);
                this.E.remove(i7);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(u2.g.material_clockface_textview, (ViewGroup) this, false);
                    this.E.put(i7, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.M[i7]);
                textView.setTag(u2.e.material_value_index, Integer.valueOf(i7));
                b0.l0(textView, this.F);
                textView.setTextColor(this.O);
                if (i6 != 0) {
                    textView.setContentDescription(getResources().getString(i6, this.M[i7]));
                }
            }
        }
    }

    public void F(String[] strArr, int i6) {
        this.M = strArr;
        G(i6);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void e(float f6, boolean z5) {
        if (Math.abs(this.N - f6) > 0.001f) {
            this.N = f6;
            C();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        y.w0(accessibilityNodeInfo).Y(y.b.a(1, this.M.length, false, 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i6, int i7) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int E = (int) (this.L / E(this.J / displayMetrics.heightPixels, this.K / displayMetrics.widthPixels, 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(E, 1073741824);
        setMeasuredDimension(E, E);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    @Override // com.google.android.material.timepicker.d
    public void v(int i6) {
        if (i6 != u()) {
            super.v(i6);
            this.B.k(u());
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.C = new Rect();
        this.D = new RectF();
        this.E = new SparseArray();
        this.H = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.P0, i6, u2.i.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList a6 = e3.c.a(context, obtainStyledAttributes, j.R0);
        this.O = a6;
        LayoutInflater.from(context).inflate(u2.g.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(u2.e.material_clock_hand);
        this.B = clockHandView;
        this.I = resources.getDimensionPixelSize(u2.c.material_clock_hand_padding);
        int colorForState = a6.getColorForState(new int[]{16842913}, a6.getDefaultColor());
        this.G = new int[]{colorForState, colorForState, a6.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = e.b.c(context, u2.b.material_timepicker_clockface).getDefaultColor();
        ColorStateList a7 = e3.c.a(context, obtainStyledAttributes, j.Q0);
        setBackgroundColor(a7 != null ? a7.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.F = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, HttpUrl.FRAGMENT_ENCODE_SET);
        F(strArr, 0);
        this.J = resources.getDimensionPixelSize(u2.c.material_time_picker_minimum_screen_height);
        this.K = resources.getDimensionPixelSize(u2.c.material_time_picker_minimum_screen_width);
        this.L = resources.getDimensionPixelSize(u2.c.material_clock_size);
    }
}
