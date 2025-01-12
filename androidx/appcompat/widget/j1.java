package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
/* loaded from: classes.dex */
public abstract class j1 extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private boolean f969b;

    /* renamed from: c  reason: collision with root package name */
    private int f970c;

    /* renamed from: d  reason: collision with root package name */
    private int f971d;

    /* renamed from: e  reason: collision with root package name */
    private int f972e;

    /* renamed from: f  reason: collision with root package name */
    private int f973f;

    /* renamed from: g  reason: collision with root package name */
    private int f974g;

    /* renamed from: h  reason: collision with root package name */
    private float f975h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f976i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f977j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f978k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f979l;

    /* renamed from: m  reason: collision with root package name */
    private int f980m;

    /* renamed from: n  reason: collision with root package name */
    private int f981n;

    /* renamed from: o  reason: collision with root package name */
    private int f982o;

    /* renamed from: p  reason: collision with root package name */
    private int f983p;

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public float f984a;

        /* renamed from: b  reason: collision with root package name */
        public int f985b;

        public a(int i6, int i7) {
            super(i6, i7);
            this.f985b = -1;
            this.f984a = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f985b = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.j.f2769l1);
            this.f984a = obtainStyledAttributes.getFloat(b.j.f2779n1, 0.0f);
            this.f985b = obtainStyledAttributes.getInt(b.j.f2774m1, -1);
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f985b = -1;
        }
    }

    public j1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A(View view, int i6, int i7, int i8, int i9) {
        view.layout(i6, i7, i8 + i6, i9 + i7);
    }

    private void k(int i6, int i7) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i8 = 0; i8 < i6; i8++) {
            View s5 = s(i8);
            if (s5.getVisibility() != 8) {
                a aVar = (a) s5.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                    int i9 = ((ViewGroup.MarginLayoutParams) aVar).width;
                    ((ViewGroup.MarginLayoutParams) aVar).width = s5.getMeasuredWidth();
                    measureChildWithMargins(s5, i7, 0, makeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).width = i9;
                }
            }
        }
    }

    private void l(int i6, int i7) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i8 = 0; i8 < i6; i8++) {
            View s5 = s(i8);
            if (s5.getVisibility() != 8) {
                a aVar = (a) s5.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                    int i9 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    ((ViewGroup.MarginLayoutParams) aVar).height = s5.getMeasuredHeight();
                    measureChildWithMargins(s5, makeMeasureSpec, 0, i7, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).height = i9;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void g(Canvas canvas) {
        int right;
        int left;
        int i6;
        int virtualChildCount = getVirtualChildCount();
        boolean b6 = j2.b(this);
        for (int i7 = 0; i7 < virtualChildCount; i7++) {
            View s5 = s(i7);
            if (s5 != null && s5.getVisibility() != 8 && t(i7)) {
                a aVar = (a) s5.getLayoutParams();
                j(canvas, b6 ? s5.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin : (s5.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.f980m);
            }
        }
        if (t(virtualChildCount)) {
            View s6 = s(virtualChildCount - 1);
            if (s6 != null) {
                a aVar2 = (a) s6.getLayoutParams();
                if (b6) {
                    left = s6.getLeft();
                    i6 = ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                    right = (left - i6) - this.f980m;
                } else {
                    right = s6.getRight() + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                }
            } else if (b6) {
                right = getPaddingLeft();
            } else {
                left = getWidth();
                i6 = getPaddingRight();
                right = (left - i6) - this.f980m;
            }
            j(canvas, right);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i6;
        if (this.f970c < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i7 = this.f970c;
        if (childCount > i7) {
            View childAt = getChildAt(i7);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.f970c == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i8 = this.f971d;
            if (this.f972e == 1 && (i6 = this.f973f & 112) != 48) {
                if (i6 == 16) {
                    i8 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f974g) / 2;
                } else if (i6 == 80) {
                    i8 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f974g;
                }
            }
            return i8 + ((ViewGroup.MarginLayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f970c;
    }

    public Drawable getDividerDrawable() {
        return this.f979l;
    }

    public int getDividerPadding() {
        return this.f983p;
    }

    public int getDividerWidth() {
        return this.f980m;
    }

    public int getGravity() {
        return this.f973f;
    }

    public int getOrientation() {
        return this.f972e;
    }

    public int getShowDividers() {
        return this.f982o;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f975h;
    }

    void h(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i6 = 0; i6 < virtualChildCount; i6++) {
            View s5 = s(i6);
            if (s5 != null && s5.getVisibility() != 8 && t(i6)) {
                i(canvas, (s5.getTop() - ((ViewGroup.MarginLayoutParams) ((a) s5.getLayoutParams())).topMargin) - this.f981n);
            }
        }
        if (t(virtualChildCount)) {
            View s6 = s(virtualChildCount - 1);
            i(canvas, s6 == null ? (getHeight() - getPaddingBottom()) - this.f981n : s6.getBottom() + ((ViewGroup.MarginLayoutParams) ((a) s6.getLayoutParams())).bottomMargin);
        }
    }

    void i(Canvas canvas, int i6) {
        this.f979l.setBounds(getPaddingLeft() + this.f983p, i6, (getWidth() - getPaddingRight()) - this.f983p, this.f981n + i6);
        this.f979l.draw(canvas);
    }

    void j(Canvas canvas, int i6) {
        this.f979l.setBounds(i6, getPaddingTop() + this.f983p, this.f980m + i6, (getHeight() - getPaddingBottom()) - this.f983p);
        this.f979l.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m */
    public a generateDefaultLayoutParams() {
        int i6 = this.f972e;
        if (i6 == 0) {
            return new a(-2, -2);
        }
        if (i6 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: n */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: o */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f979l == null) {
            return;
        }
        if (this.f972e == 1) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        if (this.f972e == 1) {
            v(i6, i7, i8, i9);
        } else {
            u(i6, i7, i8, i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i6, int i7) {
        if (this.f972e == 1) {
            z(i6, i7);
        } else {
            x(i6, i7);
        }
    }

    int p(View view, int i6) {
        return 0;
    }

    int q(View view) {
        return 0;
    }

    int r(View view) {
        return 0;
    }

    View s(int i6) {
        return getChildAt(i6);
    }

    public void setBaselineAligned(boolean z5) {
        this.f969b = z5;
    }

    public void setBaselineAlignedChildIndex(int i6) {
        if (i6 >= 0 && i6 < getChildCount()) {
            this.f970c = i6;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f979l) {
            return;
        }
        this.f979l = drawable;
        if (drawable != null) {
            this.f980m = drawable.getIntrinsicWidth();
            this.f981n = drawable.getIntrinsicHeight();
        } else {
            this.f980m = 0;
            this.f981n = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i6) {
        this.f983p = i6;
    }

    public void setGravity(int i6) {
        if (this.f973f != i6) {
            if ((8388615 & i6) == 0) {
                i6 |= 8388611;
            }
            if ((i6 & 112) == 0) {
                i6 |= 48;
            }
            this.f973f = i6;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i6) {
        int i7 = i6 & 8388615;
        int i8 = this.f973f;
        if ((8388615 & i8) != i7) {
            this.f973f = i7 | ((-8388616) & i8);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z5) {
        this.f976i = z5;
    }

    public void setOrientation(int i6) {
        if (this.f972e != i6) {
            this.f972e = i6;
            requestLayout();
        }
    }

    public void setShowDividers(int i6) {
        if (i6 != this.f982o) {
            requestLayout();
        }
        this.f982o = i6;
    }

    public void setVerticalGravity(int i6) {
        int i7 = i6 & 112;
        int i8 = this.f973f;
        if ((i8 & 112) != i7) {
            this.f973f = i7 | (i8 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f6) {
        this.f975h = Math.max(0.0f, f6);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(int i6) {
        if (i6 == 0) {
            return (this.f982o & 1) != 0;
        } else if (i6 == getChildCount()) {
            return (this.f982o & 4) != 0;
        } else if ((this.f982o & 2) != 0) {
            for (int i7 = i6 - 1; i7 >= 0; i7--) {
                if (getChildAt(i7).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void u(int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean b6 = j2.b(this);
        int paddingTop = getPaddingTop();
        int i19 = i9 - i7;
        int paddingBottom = i19 - getPaddingBottom();
        int paddingBottom2 = (i19 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i20 = this.f973f;
        int i21 = i20 & 112;
        boolean z5 = this.f969b;
        int[] iArr = this.f977j;
        int[] iArr2 = this.f978k;
        int b7 = e0.d.b(8388615 & i20, e0.b0.B(this));
        int paddingLeft = b7 != 1 ? b7 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i8) - i6) - this.f974g : getPaddingLeft() + (((i8 - i6) - this.f974g) / 2);
        if (b6) {
            i10 = virtualChildCount - 1;
            i11 = -1;
        } else {
            i10 = 0;
            i11 = 1;
        }
        int i22 = 0;
        while (i22 < virtualChildCount) {
            int i23 = i10 + (i11 * i22);
            View s5 = s(i23);
            if (s5 == null) {
                paddingLeft += y(i23);
            } else if (s5.getVisibility() != 8) {
                int measuredWidth = s5.getMeasuredWidth();
                int measuredHeight = s5.getMeasuredHeight();
                a aVar = (a) s5.getLayoutParams();
                int i24 = i22;
                if (z5) {
                    i12 = virtualChildCount;
                    if (((ViewGroup.MarginLayoutParams) aVar).height != -1) {
                        i13 = s5.getBaseline();
                        i14 = aVar.f985b;
                        if (i14 < 0) {
                            i14 = i21;
                        }
                        i15 = i14 & 112;
                        i16 = i21;
                        if (i15 != 16) {
                            i17 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + ((ViewGroup.MarginLayoutParams) aVar).topMargin) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        } else if (i15 == 48) {
                            i17 = ((ViewGroup.MarginLayoutParams) aVar).topMargin + paddingTop;
                            if (i13 != -1) {
                                i17 += iArr[1] - i13;
                            }
                        } else if (i15 != 80) {
                            i17 = paddingTop;
                        } else {
                            i17 = (paddingBottom - measuredHeight) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                            if (i13 != -1) {
                                i17 -= iArr2[2] - (s5.getMeasuredHeight() - i13);
                            }
                        }
                        if (t(i23)) {
                            paddingLeft += this.f980m;
                        }
                        int i25 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                        i18 = paddingTop;
                        A(s5, i25 + q(s5), i17, measuredWidth, measuredHeight);
                        i22 = i24 + p(s5, i23);
                        paddingLeft = i25 + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(s5);
                        i22++;
                        virtualChildCount = i12;
                        i21 = i16;
                        paddingTop = i18;
                    }
                } else {
                    i12 = virtualChildCount;
                }
                i13 = -1;
                i14 = aVar.f985b;
                if (i14 < 0) {
                }
                i15 = i14 & 112;
                i16 = i21;
                if (i15 != 16) {
                }
                if (t(i23)) {
                }
                int i252 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                i18 = paddingTop;
                A(s5, i252 + q(s5), i17, measuredWidth, measuredHeight);
                i22 = i24 + p(s5, i23);
                paddingLeft = i252 + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(s5);
                i22++;
                virtualChildCount = i12;
                i21 = i16;
                paddingTop = i18;
            }
            i18 = paddingTop;
            i12 = virtualChildCount;
            i16 = i21;
            i22++;
            virtualChildCount = i12;
            i21 = i16;
            paddingTop = i18;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void v(int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int paddingLeft = getPaddingLeft();
        int i12 = i8 - i6;
        int paddingRight = i12 - getPaddingRight();
        int paddingRight2 = (i12 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i13 = this.f973f;
        int i14 = i13 & 112;
        int i15 = i13 & 8388615;
        int paddingTop = i14 != 16 ? i14 != 80 ? getPaddingTop() : ((getPaddingTop() + i9) - i7) - this.f974g : getPaddingTop() + (((i9 - i7) - this.f974g) / 2);
        int i16 = 0;
        while (i16 < virtualChildCount) {
            View s5 = s(i16);
            if (s5 == null) {
                paddingTop += y(i16);
            } else if (s5.getVisibility() != 8) {
                int measuredWidth = s5.getMeasuredWidth();
                int measuredHeight = s5.getMeasuredHeight();
                a aVar = (a) s5.getLayoutParams();
                int i17 = aVar.f985b;
                if (i17 < 0) {
                    i17 = i15;
                }
                int b6 = e0.d.b(i17, e0.b0.B(this)) & 7;
                if (b6 == 1) {
                    i10 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                } else if (b6 != 5) {
                    i11 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                    int i18 = i11;
                    if (t(i16)) {
                        paddingTop += this.f981n;
                    }
                    int i19 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                    A(s5, i18, i19 + q(s5), measuredWidth, measuredHeight);
                    i16 += p(s5, i16);
                    paddingTop = i19 + measuredHeight + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + r(s5);
                } else {
                    i10 = paddingRight - measuredWidth;
                }
                i11 = i10 - ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                int i182 = i11;
                if (t(i16)) {
                }
                int i192 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                A(s5, i182, i192 + q(s5), measuredWidth, measuredHeight);
                i16 += p(s5, i16);
                paddingTop = i192 + measuredHeight + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + r(s5);
            }
            i16++;
        }
    }

    void w(View view, int i6, int i7, int i8, int i9, int i10) {
        measureChildWithMargins(view, i7, i8, i9, i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x03a0, code lost:
        if (r8 > 0) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03ab, code lost:
        if (r8 < 0) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03ad, code lost:
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03ae, code lost:
        r14.measure(android.view.View.MeasureSpec.makeMeasureSpec(r8, r3), r0);
        r9 = android.view.View.combineMeasuredStates(r9, r14.getMeasuredState() & (-16777216));
        r0 = r0;
        r3 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void x(int i6, int i7) {
        int[] iArr;
        int i8;
        int max;
        int i9;
        int i10;
        int max2;
        int i11;
        int i12;
        int i13;
        float f6;
        int i14;
        boolean z5;
        int baseline;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z6;
        boolean z7;
        View view;
        int max3;
        int i20;
        boolean z8;
        int measuredHeight;
        int p5;
        int baseline2;
        int i21;
        this.f974g = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        if (this.f977j == null || this.f978k == null) {
            this.f977j = new int[4];
            this.f978k = new int[4];
        }
        int[] iArr2 = this.f977j;
        int[] iArr3 = this.f978k;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z9 = this.f969b;
        boolean z10 = this.f976i;
        int i22 = 1073741824;
        boolean z11 = mode == 1073741824;
        float f7 = 0.0f;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        boolean z12 = false;
        int i28 = 0;
        boolean z13 = true;
        boolean z14 = false;
        while (true) {
            iArr = iArr3;
            if (i23 >= virtualChildCount) {
                break;
            }
            View s5 = s(i23);
            if (s5 == null) {
                this.f974g += y(i23);
            } else if (s5.getVisibility() == 8) {
                i23 += p(s5, i23);
            } else {
                if (t(i23)) {
                    this.f974g += this.f980m;
                }
                a aVar = (a) s5.getLayoutParams();
                float f8 = aVar.f984a;
                float f9 = f7 + f8;
                if (mode == i22 && ((ViewGroup.MarginLayoutParams) aVar).width == 0 && f8 > 0.0f) {
                    int i29 = this.f974g;
                    this.f974g = z11 ? i29 + ((ViewGroup.MarginLayoutParams) aVar).leftMargin + ((ViewGroup.MarginLayoutParams) aVar).rightMargin : Math.max(i29, ((ViewGroup.MarginLayoutParams) aVar).leftMargin + i29 + ((ViewGroup.MarginLayoutParams) aVar).rightMargin);
                    if (z9) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        s5.measure(makeMeasureSpec, makeMeasureSpec);
                        i19 = i23;
                        z6 = z10;
                        z7 = z9;
                        view = s5;
                    } else {
                        i19 = i23;
                        z6 = z10;
                        z7 = z9;
                        view = s5;
                        i20 = 1073741824;
                        z12 = true;
                        if (mode2 == i20 && ((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                            z8 = true;
                            z14 = true;
                        } else {
                            z8 = false;
                        }
                        int i30 = ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i30;
                        i28 = View.combineMeasuredStates(i28, view.getMeasuredState());
                        if (z7 && (baseline2 = view.getBaseline()) != -1) {
                            i21 = aVar.f985b;
                            if (i21 < 0) {
                                i21 = this.f973f;
                            }
                            int i31 = (((i21 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i31] = Math.max(iArr2[i31], baseline2);
                            iArr[i31] = Math.max(iArr[i31], measuredHeight - baseline2);
                        }
                        i25 = Math.max(i25, measuredHeight);
                        z13 = !z13 && ((ViewGroup.MarginLayoutParams) aVar).height == -1;
                        if (aVar.f984a <= 0.0f) {
                            if (!z8) {
                                i30 = measuredHeight;
                            }
                            i27 = Math.max(i27, i30);
                        } else {
                            int i32 = i27;
                            if (!z8) {
                                i30 = measuredHeight;
                            }
                            i26 = Math.max(i26, i30);
                            i27 = i32;
                        }
                        int i33 = i19;
                        p5 = p(view, i33) + i33;
                        f7 = f9;
                        i23 = p5 + 1;
                        iArr3 = iArr;
                        z10 = z6;
                        z9 = z7;
                        i22 = 1073741824;
                    }
                } else {
                    if (((ViewGroup.MarginLayoutParams) aVar).width != 0 || f8 <= 0.0f) {
                        i18 = Integer.MIN_VALUE;
                    } else {
                        ((ViewGroup.MarginLayoutParams) aVar).width = -2;
                        i18 = 0;
                    }
                    i19 = i23;
                    int i34 = i18;
                    z6 = z10;
                    z7 = z9;
                    w(s5, i19, i6, f9 == 0.0f ? this.f974g : 0, i7, 0);
                    if (i34 != Integer.MIN_VALUE) {
                        ((ViewGroup.MarginLayoutParams) aVar).width = i34;
                    }
                    int measuredWidth = s5.getMeasuredWidth();
                    if (z11) {
                        view = s5;
                        max3 = this.f974g + ((ViewGroup.MarginLayoutParams) aVar).leftMargin + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(view);
                    } else {
                        view = s5;
                        int i35 = this.f974g;
                        max3 = Math.max(i35, i35 + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).leftMargin + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(view));
                    }
                    this.f974g = max3;
                    if (z6) {
                        i24 = Math.max(measuredWidth, i24);
                    }
                }
                i20 = 1073741824;
                if (mode2 == i20) {
                }
                z8 = false;
                int i302 = ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i302;
                i28 = View.combineMeasuredStates(i28, view.getMeasuredState());
                if (z7) {
                    i21 = aVar.f985b;
                    if (i21 < 0) {
                    }
                    int i312 = (((i21 & 112) >> 4) & (-2)) >> 1;
                    iArr2[i312] = Math.max(iArr2[i312], baseline2);
                    iArr[i312] = Math.max(iArr[i312], measuredHeight - baseline2);
                }
                i25 = Math.max(i25, measuredHeight);
                if (z13) {
                }
                if (aVar.f984a <= 0.0f) {
                }
                int i332 = i19;
                p5 = p(view, i332) + i332;
                f7 = f9;
                i23 = p5 + 1;
                iArr3 = iArr;
                z10 = z6;
                z9 = z7;
                i22 = 1073741824;
            }
            p5 = i23;
            z6 = z10;
            z7 = z9;
            i23 = p5 + 1;
            iArr3 = iArr;
            z10 = z6;
            z9 = z7;
            i22 = 1073741824;
        }
        boolean z15 = z10;
        boolean z16 = z9;
        int i36 = i25;
        int i37 = i26;
        int i38 = i27;
        int i39 = i28;
        if (this.f974g > 0 && t(virtualChildCount)) {
            this.f974g += this.f980m;
        }
        int i40 = iArr2[1];
        if (i40 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            max = i36;
            i8 = i39;
        } else {
            i8 = i39;
            max = Math.max(i36, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i40, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z15 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f974g = 0;
            int i41 = 0;
            while (i41 < virtualChildCount) {
                View s6 = s(i41);
                if (s6 == null) {
                    this.f974g += y(i41);
                } else if (s6.getVisibility() == 8) {
                    i41 += p(s6, i41);
                } else {
                    a aVar2 = (a) s6.getLayoutParams();
                    int i42 = this.f974g;
                    if (z11) {
                        this.f974g = i42 + ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + i24 + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin + r(s6);
                    } else {
                        i17 = max;
                        this.f974g = Math.max(i42, i42 + i24 + ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin + r(s6));
                        i41++;
                        max = i17;
                    }
                }
                i17 = max;
                i41++;
                max = i17;
            }
        }
        int i43 = max;
        int paddingLeft = this.f974g + getPaddingLeft() + getPaddingRight();
        this.f974g = paddingLeft;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i6, 0);
        int i44 = (16777215 & resolveSizeAndState) - this.f974g;
        if (z12 || (i44 != 0 && f7 > 0.0f)) {
            float f10 = this.f975h;
            if (f10 > 0.0f) {
                f7 = f10;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f974g = 0;
            int i45 = i37;
            int i46 = i8;
            int i47 = -1;
            int i48 = 0;
            while (i48 < virtualChildCount) {
                View s7 = s(i48);
                if (s7 == null || s7.getVisibility() == 8) {
                    i12 = i44;
                    i13 = virtualChildCount;
                } else {
                    a aVar3 = (a) s7.getLayoutParams();
                    float f11 = aVar3.f984a;
                    if (f11 > 0.0f) {
                        int i49 = (int) ((i44 * f11) / f7);
                        float f12 = f7 - f11;
                        int i50 = i44 - i49;
                        i13 = virtualChildCount;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i7, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) aVar3).topMargin + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin, ((ViewGroup.MarginLayoutParams) aVar3).height);
                        if (((ViewGroup.MarginLayoutParams) aVar3).width == 0) {
                            i16 = 1073741824;
                            if (mode == 1073741824) {
                            }
                        } else {
                            i16 = 1073741824;
                        }
                        i49 = s7.getMeasuredWidth() + i49;
                    } else {
                        i12 = i44;
                        i13 = virtualChildCount;
                    }
                    int i51 = this.f974g;
                    if (z11) {
                        this.f974g = i51 + s7.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) aVar3).leftMargin + ((ViewGroup.MarginLayoutParams) aVar3).rightMargin + r(s7);
                        f6 = f7;
                    } else {
                        f6 = f7;
                        this.f974g = Math.max(i51, s7.getMeasuredWidth() + i51 + ((ViewGroup.MarginLayoutParams) aVar3).leftMargin + ((ViewGroup.MarginLayoutParams) aVar3).rightMargin + r(s7));
                    }
                    boolean z17 = mode2 != 1073741824 && ((ViewGroup.MarginLayoutParams) aVar3).height == -1;
                    int i52 = ((ViewGroup.MarginLayoutParams) aVar3).topMargin + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin;
                    int measuredHeight2 = s7.getMeasuredHeight() + i52;
                    i47 = Math.max(i47, measuredHeight2);
                    if (!z17) {
                        i52 = measuredHeight2;
                    }
                    int max4 = Math.max(i45, i52);
                    if (z13) {
                        i14 = -1;
                        if (((ViewGroup.MarginLayoutParams) aVar3).height == -1) {
                            z5 = true;
                            if (z16 && (baseline = s7.getBaseline()) != i14) {
                                i15 = aVar3.f985b;
                                if (i15 < 0) {
                                    i15 = this.f973f;
                                }
                                int i53 = (((i15 & 112) >> 4) & (-2)) >> 1;
                                iArr2[i53] = Math.max(iArr2[i53], baseline);
                                iArr[i53] = Math.max(iArr[i53], measuredHeight2 - baseline);
                            }
                            z13 = z5;
                            i45 = max4;
                            f7 = f6;
                        }
                    } else {
                        i14 = -1;
                    }
                    z5 = false;
                    if (z16) {
                        i15 = aVar3.f985b;
                        if (i15 < 0) {
                        }
                        int i532 = (((i15 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i532] = Math.max(iArr2[i532], baseline);
                        iArr[i532] = Math.max(iArr[i532], measuredHeight2 - baseline);
                    }
                    z13 = z5;
                    i45 = max4;
                    f7 = f6;
                }
                i48++;
                i44 = i12;
                virtualChildCount = i13;
            }
            i9 = i7;
            i10 = virtualChildCount;
            this.f974g += getPaddingLeft() + getPaddingRight();
            int i54 = iArr2[1];
            max2 = (i54 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i47 : Math.max(i47, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i54, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            i11 = i45;
            i8 = i46;
        } else {
            i11 = Math.max(i37, i38);
            if (z15 && mode != 1073741824) {
                for (int i55 = 0; i55 < virtualChildCount; i55++) {
                    View s8 = s(i55);
                    if (s8 != null && s8.getVisibility() != 8 && ((a) s8.getLayoutParams()).f984a > 0.0f) {
                        s8.measure(View.MeasureSpec.makeMeasureSpec(i24, 1073741824), View.MeasureSpec.makeMeasureSpec(s8.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i9 = i7;
            i10 = virtualChildCount;
            max2 = i43;
        }
        if (z13 || mode2 == 1073741824) {
            i11 = max2;
        }
        setMeasuredDimension(resolveSizeAndState | (i8 & (-16777216)), View.resolveSizeAndState(Math.max(i11 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i9, i8 << 16));
        if (z14) {
            k(i10, i6);
        }
    }

    int y(int i6) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x02ce, code lost:
        if (r15 > 0) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02d9, code lost:
        if (r15 < 0) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02db, code lost:
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02dc, code lost:
        r13.measure(r0, android.view.View.MeasureSpec.makeMeasureSpec(r15, r10));
        r1 = android.view.View.combineMeasuredStates(r1, r13.getMeasuredState() & (-256));
        r0 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0319  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void z(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z5;
        int i15;
        int max;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        View view;
        int max2;
        boolean z6;
        int max3;
        this.f974g = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        int i24 = this.f970c;
        boolean z7 = this.f976i;
        float f6 = 0.0f;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        boolean z8 = false;
        boolean z9 = true;
        boolean z10 = false;
        while (true) {
            int i31 = 8;
            int i32 = i28;
            if (i30 >= virtualChildCount) {
                int i33 = i25;
                int i34 = i27;
                int i35 = i29;
                int i36 = virtualChildCount;
                int i37 = mode2;
                int i38 = i26;
                if (this.f974g > 0) {
                    i8 = i36;
                    if (t(i8)) {
                        this.f974g += this.f981n;
                    }
                } else {
                    i8 = i36;
                }
                if (z7 && (i37 == Integer.MIN_VALUE || i37 == 0)) {
                    this.f974g = 0;
                    int i39 = 0;
                    while (i39 < i8) {
                        View s5 = s(i39);
                        if (s5 == null) {
                            max = this.f974g + y(i39);
                        } else if (s5.getVisibility() == i31) {
                            i39 += p(s5, i39);
                            i39++;
                            i31 = 8;
                        } else {
                            a aVar = (a) s5.getLayoutParams();
                            int i40 = this.f974g;
                            max = Math.max(i40, i40 + i34 + ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + r(s5));
                        }
                        this.f974g = max;
                        i39++;
                        i31 = 8;
                    }
                }
                int paddingTop = this.f974g + getPaddingTop() + getPaddingBottom();
                this.f974g = paddingTop;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i7, 0);
                int i41 = (16777215 & resolveSizeAndState) - this.f974g;
                if (z8 || (i41 != 0 && f6 > 0.0f)) {
                    float f7 = this.f975h;
                    if (f7 > 0.0f) {
                        f6 = f7;
                    }
                    this.f974g = 0;
                    int i42 = i41;
                    int i43 = i35;
                    i9 = i33;
                    int i44 = 0;
                    while (i44 < i8) {
                        View s6 = s(i44);
                        if (s6.getVisibility() == 8) {
                            i12 = i42;
                        } else {
                            a aVar2 = (a) s6.getLayoutParams();
                            float f8 = aVar2.f984a;
                            if (f8 > 0.0f) {
                                int i45 = (int) ((i42 * f8) / f6);
                                float f9 = f6 - f8;
                                i12 = i42 - i45;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin, ((ViewGroup.MarginLayoutParams) aVar2).width);
                                if (((ViewGroup.MarginLayoutParams) aVar2).height == 0) {
                                    i15 = 1073741824;
                                    if (i37 == 1073741824) {
                                    }
                                } else {
                                    i15 = 1073741824;
                                }
                                i45 = s6.getMeasuredHeight() + i45;
                            } else {
                                i12 = i42;
                            }
                            int i46 = ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                            int measuredWidth = s6.getMeasuredWidth() + i46;
                            i38 = Math.max(i38, measuredWidth);
                            float f10 = f6;
                            if (mode != 1073741824) {
                                i13 = i9;
                                i14 = -1;
                                if (((ViewGroup.MarginLayoutParams) aVar2).width == -1) {
                                    z5 = true;
                                    if (!z5) {
                                        i46 = measuredWidth;
                                    }
                                    int max4 = Math.max(i43, i46);
                                    boolean z11 = !z9 && ((ViewGroup.MarginLayoutParams) aVar2).width == i14;
                                    int i47 = this.f974g;
                                    this.f974g = Math.max(i47, s6.getMeasuredHeight() + i47 + ((ViewGroup.MarginLayoutParams) aVar2).topMargin + ((ViewGroup.MarginLayoutParams) aVar2).bottomMargin + r(s6));
                                    z9 = z11;
                                    i9 = i13;
                                    i43 = max4;
                                    f6 = f10;
                                }
                            } else {
                                i13 = i9;
                                i14 = -1;
                            }
                            z5 = false;
                            if (!z5) {
                            }
                            int max42 = Math.max(i43, i46);
                            if (z9) {
                            }
                            int i472 = this.f974g;
                            this.f974g = Math.max(i472, s6.getMeasuredHeight() + i472 + ((ViewGroup.MarginLayoutParams) aVar2).topMargin + ((ViewGroup.MarginLayoutParams) aVar2).bottomMargin + r(s6));
                            z9 = z11;
                            i9 = i13;
                            i43 = max42;
                            f6 = f10;
                        }
                        i44++;
                        i42 = i12;
                    }
                    i10 = i6;
                    this.f974g += getPaddingTop() + getPaddingBottom();
                    i11 = i43;
                } else {
                    i11 = Math.max(i35, i32);
                    if (z7 && i37 != 1073741824) {
                        for (int i48 = 0; i48 < i8; i48++) {
                            View s7 = s(i48);
                            if (s7 != null && s7.getVisibility() != 8 && ((a) s7.getLayoutParams()).f984a > 0.0f) {
                                s7.measure(View.MeasureSpec.makeMeasureSpec(s7.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i34, 1073741824));
                            }
                        }
                    }
                    i10 = i6;
                    i9 = i33;
                }
                if (z9 || mode == 1073741824) {
                    i11 = i38;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i11 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, i9), resolveSizeAndState);
                if (z10) {
                    l(i8, i7);
                    return;
                }
                return;
            }
            View s8 = s(i30);
            if (s8 == null) {
                this.f974g += y(i30);
                i19 = virtualChildCount;
                i20 = mode2;
                i28 = i32;
            } else {
                int i49 = i25;
                if (s8.getVisibility() == 8) {
                    i30 += p(s8, i30);
                    i19 = virtualChildCount;
                    i28 = i32;
                    i25 = i49;
                    i20 = mode2;
                } else {
                    if (t(i30)) {
                        this.f974g += this.f981n;
                    }
                    a aVar3 = (a) s8.getLayoutParams();
                    float f11 = aVar3.f984a;
                    float f12 = f6 + f11;
                    if (mode2 == 1073741824 && ((ViewGroup.MarginLayoutParams) aVar3).height == 0 && f11 > 0.0f) {
                        int i50 = this.f974g;
                        this.f974g = Math.max(i50, ((ViewGroup.MarginLayoutParams) aVar3).topMargin + i50 + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin);
                        max2 = i27;
                        view = s8;
                        i22 = i29;
                        i17 = i49;
                        i18 = i26;
                        z8 = true;
                        i19 = virtualChildCount;
                        i20 = mode2;
                        i21 = i32;
                        i23 = i30;
                    } else {
                        int i51 = i26;
                        if (((ViewGroup.MarginLayoutParams) aVar3).height != 0 || f11 <= 0.0f) {
                            i16 = Integer.MIN_VALUE;
                        } else {
                            ((ViewGroup.MarginLayoutParams) aVar3).height = -2;
                            i16 = 0;
                        }
                        i17 = i49;
                        int i52 = i16;
                        i18 = i51;
                        int i53 = i27;
                        i19 = virtualChildCount;
                        i20 = mode2;
                        i21 = i32;
                        i22 = i29;
                        i23 = i30;
                        w(s8, i30, i6, 0, i7, f12 == 0.0f ? this.f974g : 0);
                        if (i52 != Integer.MIN_VALUE) {
                            ((ViewGroup.MarginLayoutParams) aVar3).height = i52;
                        }
                        int measuredHeight = s8.getMeasuredHeight();
                        int i54 = this.f974g;
                        view = s8;
                        this.f974g = Math.max(i54, i54 + measuredHeight + ((ViewGroup.MarginLayoutParams) aVar3).topMargin + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin + r(view));
                        max2 = z7 ? Math.max(measuredHeight, i53) : i53;
                    }
                    if (i24 >= 0 && i24 == i23 + 1) {
                        this.f971d = this.f974g;
                    }
                    if (i23 < i24 && aVar3.f984a > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((ViewGroup.MarginLayoutParams) aVar3).width != -1) {
                        z6 = false;
                    } else {
                        z6 = true;
                        z10 = true;
                    }
                    int i55 = ((ViewGroup.MarginLayoutParams) aVar3).leftMargin + ((ViewGroup.MarginLayoutParams) aVar3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i55;
                    int max5 = Math.max(i18, measuredWidth2);
                    int combineMeasuredStates = View.combineMeasuredStates(i17, view.getMeasuredState());
                    z9 = z9 && ((ViewGroup.MarginLayoutParams) aVar3).width == -1;
                    if (aVar3.f984a > 0.0f) {
                        if (!z6) {
                            i55 = measuredWidth2;
                        }
                        i28 = Math.max(i21, i55);
                        max3 = i22;
                    } else {
                        if (!z6) {
                            i55 = measuredWidth2;
                        }
                        max3 = Math.max(i22, i55);
                        i28 = i21;
                    }
                    i27 = max2;
                    f6 = f12;
                    i29 = max3;
                    i25 = combineMeasuredStates;
                    i30 = p(view, i23) + i23;
                    i26 = max5;
                }
            }
            i30++;
            mode2 = i20;
            virtualChildCount = i19;
        }
    }

    public j1(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f969b = true;
        this.f970c = -1;
        this.f971d = 0;
        this.f973f = 8388659;
        int[] iArr = b.j.f2719b1;
        c2 v5 = c2.v(context, attributeSet, iArr, i6, 0);
        e0.b0.j0(this, context, iArr, attributeSet, v5.r(), i6, 0);
        int k6 = v5.k(b.j.f2729d1, -1);
        if (k6 >= 0) {
            setOrientation(k6);
        }
        int k7 = v5.k(b.j.f2724c1, -1);
        if (k7 >= 0) {
            setGravity(k7);
        }
        boolean a6 = v5.a(b.j.f2734e1, true);
        if (!a6) {
            setBaselineAligned(a6);
        }
        this.f975h = v5.i(b.j.f2744g1, -1.0f);
        this.f970c = v5.k(b.j.f2739f1, -1);
        this.f976i = v5.a(b.j.f2759j1, false);
        setDividerDrawable(v5.g(b.j.f2749h1));
        this.f982o = v5.k(b.j.f2764k1, 0);
        this.f983p = v5.f(b.j.f2754i1, 0);
        v5.w();
    }
}
