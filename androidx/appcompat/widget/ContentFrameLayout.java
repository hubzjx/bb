package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private TypedValue f718b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f719c;

    /* renamed from: d  reason: collision with root package name */
    private TypedValue f720d;

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f721e;

    /* renamed from: f  reason: collision with root package name */
    private TypedValue f722f;

    /* renamed from: g  reason: collision with root package name */
    private TypedValue f723g;

    /* renamed from: h  reason: collision with root package name */
    private final Rect f724h;

    /* renamed from: i  reason: collision with root package name */
    private a f725i;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(int i6, int i7, int i8, int i9) {
        this.f724h.set(i6, i7, i8, i9);
        if (e0.b0.R(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f722f == null) {
            this.f722f = new TypedValue();
        }
        return this.f722f;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f723g == null) {
            this.f723g = new TypedValue();
        }
        return this.f723g;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f720d == null) {
            this.f720d = new TypedValue();
        }
        return this.f720d;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f721e == null) {
            this.f721e = new TypedValue();
        }
        return this.f721e;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f718b == null) {
            this.f718b = new TypedValue();
        }
        return this.f718b;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f719c == null) {
            this.f719c = new TypedValue();
        }
        return this.f719c;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f725i;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f725i;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i6, int i7) {
        boolean z5;
        int measuredWidth;
        TypedValue typedValue;
        int i8;
        int i9;
        float fraction;
        int i10;
        int i11;
        float fraction2;
        int i12;
        int i13;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z6 = true;
        boolean z7 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z7 ? this.f721e : this.f720d;
            if (typedValue2 != null && (i12 = typedValue2.type) != 0) {
                if (i12 == 5) {
                    fraction3 = typedValue2.getDimension(displayMetrics);
                } else if (i12 == 6) {
                    int i14 = displayMetrics.widthPixels;
                    fraction3 = typedValue2.getFraction(i14, i14);
                } else {
                    i13 = 0;
                    if (i13 > 0) {
                        Rect rect = this.f724h;
                        i6 = View.MeasureSpec.makeMeasureSpec(Math.min(i13 - (rect.left + rect.right), View.MeasureSpec.getSize(i6)), 1073741824);
                        z5 = true;
                        if (mode2 == Integer.MIN_VALUE) {
                            TypedValue typedValue3 = z7 ? this.f722f : this.f723g;
                            if (typedValue3 != null && (i10 = typedValue3.type) != 0) {
                                if (i10 == 5) {
                                    fraction2 = typedValue3.getDimension(displayMetrics);
                                } else if (i10 == 6) {
                                    int i15 = displayMetrics.heightPixels;
                                    fraction2 = typedValue3.getFraction(i15, i15);
                                } else {
                                    i11 = 0;
                                    if (i11 > 0) {
                                        Rect rect2 = this.f724h;
                                        i7 = View.MeasureSpec.makeMeasureSpec(Math.min(i11 - (rect2.top + rect2.bottom), View.MeasureSpec.getSize(i7)), 1073741824);
                                    }
                                }
                                i11 = (int) fraction2;
                                if (i11 > 0) {
                                }
                            }
                        }
                        super.onMeasure(i6, i7);
                        measuredWidth = getMeasuredWidth();
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                        if (!z5 && mode == Integer.MIN_VALUE) {
                            typedValue = !z7 ? this.f719c : this.f718b;
                            if (typedValue != null && (i8 = typedValue.type) != 0) {
                                if (i8 != 5) {
                                    fraction = typedValue.getDimension(displayMetrics);
                                } else if (i8 == 6) {
                                    int i16 = displayMetrics.widthPixels;
                                    fraction = typedValue.getFraction(i16, i16);
                                } else {
                                    i9 = 0;
                                    if (i9 > 0) {
                                        Rect rect3 = this.f724h;
                                        i9 -= rect3.left + rect3.right;
                                    }
                                    if (measuredWidth < i9) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
                                        if (z6) {
                                            super.onMeasure(makeMeasureSpec, i7);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i9 = (int) fraction;
                                if (i9 > 0) {
                                }
                                if (measuredWidth < i9) {
                                }
                            }
                        }
                        z6 = false;
                        if (z6) {
                        }
                    }
                }
                i13 = (int) fraction3;
                if (i13 > 0) {
                }
            }
        }
        z5 = false;
        if (mode2 == Integer.MIN_VALUE) {
        }
        super.onMeasure(i6, i7);
        measuredWidth = getMeasuredWidth();
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (!z5) {
            if (!z7) {
            }
            if (typedValue != null) {
                if (i8 != 5) {
                }
                i9 = (int) fraction;
                if (i9 > 0) {
                }
                if (measuredWidth < i9) {
                }
            }
        }
        z6 = false;
        if (z6) {
        }
    }

    public void setAttachListener(a aVar) {
        this.f725i = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f724h = new Rect();
    }
}
