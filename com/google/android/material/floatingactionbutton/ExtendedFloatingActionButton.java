package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v4.media.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import u2.j;
/* loaded from: classes.dex */
public abstract class ExtendedFloatingActionButton extends MaterialButton {

    /* loaded from: classes.dex */
    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.b {

        /* renamed from: a  reason: collision with root package name */
        private boolean f5220a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f5221b;

        public ExtendedFloatingActionButtonBehavior() {
            this.f5220a = false;
            this.f5221b = true;
        }

        private static boolean F(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e) layoutParams).e() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean I(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            throw null;
        }

        private boolean J(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (I(view, extendedFloatingActionButton)) {
                throw null;
            }
            return false;
        }

        public boolean E(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        public boolean G(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (F(view)) {
                J(view, extendedFloatingActionButton);
                return false;
            }
            return false;
        }

        public boolean H(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i6) {
            List q5 = coordinatorLayout.q(extendedFloatingActionButton);
            int size = q5.size();
            for (int i7 = 0; i7 < size; i7++) {
                View view = (View) q5.get(i7);
                if (F(view) && J(view, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.G(extendedFloatingActionButton, i6);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            a.a(view);
            return E(coordinatorLayout, null, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void g(CoordinatorLayout.e eVar) {
            if (eVar.f1537h == 0) {
                eVar.f1537h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a.a(view);
            return G(coordinatorLayout, null, view2);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i6) {
            a.a(view);
            return H(coordinatorLayout, null, i6);
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f13502j1);
            this.f5220a = obtainStyledAttributes.getBoolean(j.f13509k1, false);
            this.f5221b = obtainStyledAttributes.getBoolean(j.f13516l1, true);
            obtainStyledAttributes.recycle();
        }
    }
}
