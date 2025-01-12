package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.j1;
/* loaded from: classes.dex */
public class AlertDialogLayout extends j1 {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void A(View view, int i6, int i7, int i8, int i9) {
        view.layout(i6, i7, i8 + i6, i9 + i7);
    }

    private static int B(View view) {
        int C = e0.b0.C(view);
        if (C > 0) {
            return C;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return B(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private boolean C(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == b.f.topPanel) {
                    view = childAt;
                } else if (id == b.f.buttonPanel) {
                    view2 = childAt;
                } else if ((id != b.f.contentPanel && id != b.f.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i6);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i6, 0);
            paddingTop += view.getMeasuredHeight();
            i8 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i8 = 0;
        }
        if (view2 != null) {
            view2.measure(i6, 0);
            i9 = B(view2);
            i10 = view2.getMeasuredHeight() - i9;
            paddingTop += i9;
            i8 = View.combineMeasuredStates(i8, view2.getMeasuredState());
        } else {
            i9 = 0;
            i10 = 0;
        }
        if (view3 != null) {
            view3.measure(i6, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            i11 = view3.getMeasuredHeight();
            paddingTop += i11;
            i8 = View.combineMeasuredStates(i8, view3.getMeasuredState());
        } else {
            i11 = 0;
        }
        int i13 = size - paddingTop;
        if (view2 != null) {
            int i14 = paddingTop - i9;
            int min = Math.min(i13, i10);
            if (min > 0) {
                i13 -= min;
                i9 += min;
            }
            view2.measure(i6, View.MeasureSpec.makeMeasureSpec(i9, 1073741824));
            paddingTop = i14 + view2.getMeasuredHeight();
            i8 = View.combineMeasuredStates(i8, view2.getMeasuredState());
        }
        if (view3 != null && i13 > 0) {
            view3.measure(i6, View.MeasureSpec.makeMeasureSpec(i11 + i13, mode));
            paddingTop = (paddingTop - i11) + view3.getMeasuredHeight();
            i8 = View.combineMeasuredStates(i8, view3.getMeasuredState());
        }
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2.getVisibility() != 8) {
                i15 = Math.max(i15, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i15 + getPaddingLeft() + getPaddingRight(), i6, i8), View.resolveSizeAndState(paddingTop, i7, 0));
        if (mode2 != 1073741824) {
            l(childCount, i7);
            return true;
        }
        return true;
    }

    private void l(int i6, int i7) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i8 = 0; i8 < i6; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                j1.a aVar = (j1.a) childAt.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                    int i9 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    ((ViewGroup.MarginLayoutParams) aVar).height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i7, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).height = i9;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
    @Override // androidx.appcompat.widget.j1, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int paddingLeft = getPaddingLeft();
        int i12 = i8 - i6;
        int paddingRight = i12 - getPaddingRight();
        int paddingRight2 = (i12 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i13 = gravity & 112;
        int i14 = gravity & 8388615;
        int paddingTop = i13 != 16 ? i13 != 80 ? getPaddingTop() : ((getPaddingTop() + i9) - i7) - measuredHeight : getPaddingTop() + (((i9 - i7) - measuredHeight) / 2);
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                j1.a aVar = (j1.a) childAt.getLayoutParams();
                int i16 = aVar.f985b;
                if (i16 < 0) {
                    i16 = i14;
                }
                int b6 = e0.d.b(i16, e0.b0.B(this)) & 7;
                if (b6 == 1) {
                    i10 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                } else if (b6 != 5) {
                    i11 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                    if (t(i15)) {
                        paddingTop += intrinsicHeight;
                    }
                    int i17 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                    A(childAt, i11, i17, measuredWidth, measuredHeight2);
                    paddingTop = i17 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                } else {
                    i10 = paddingRight - measuredWidth;
                }
                i11 = i10 - ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                if (t(i15)) {
                }
                int i172 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                A(childAt, i11, i172, measuredWidth, measuredHeight2);
                paddingTop = i172 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.j1, android.view.View
    public void onMeasure(int i6, int i7) {
        if (C(i6, i7)) {
            return;
        }
        super.onMeasure(i6, i7);
    }
}
