package com.google.android.material.bottomappbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import e0.b0;
import java.lang.ref.WeakReference;
import u2.i;
/* loaded from: classes.dex */
public abstract class BottomAppBar extends Toolbar {
    private static final int P = i.Widget_MaterialComponents_BottomAppBar;

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: e  reason: collision with root package name */
        private final Rect f4918e;

        /* renamed from: f  reason: collision with root package name */
        private WeakReference f4919f;

        /* renamed from: g  reason: collision with root package name */
        private int f4920g;

        /* renamed from: h  reason: collision with root package name */
        private final View.OnLayoutChangeListener f4921h;

        /* loaded from: classes.dex */
        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                android.support.v4.media.a.a(Behavior.this.f4919f.get());
                view.removeOnLayoutChangeListener(this);
            }
        }

        public Behavior() {
            this.f4921h = new a();
            this.f4918e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6, int i7) {
            android.support.v4.media.a.a(view);
            return K(coordinatorLayout, null, view2, view3, i6, i7);
        }

        public boolean J(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i6) {
            this.f4919f = new WeakReference(bottomAppBar);
            View P = BottomAppBar.P(bottomAppBar);
            if (P != null && !b0.R(P)) {
                CoordinatorLayout.e eVar = (CoordinatorLayout.e) P.getLayoutParams();
                eVar.f1533d = 49;
                this.f4920g = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                BottomAppBar.O(bottomAppBar);
            }
            coordinatorLayout.G(bottomAppBar, i6);
            return super.l(coordinatorLayout, bottomAppBar, i6);
        }

        public boolean K(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i6, int i7) {
            throw null;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i6) {
            android.support.v4.media.a.a(view);
            return J(coordinatorLayout, null, i6);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4921h = new a();
            this.f4918e = new Rect();
        }
    }

    static /* synthetic */ void O(BottomAppBar bottomAppBar) {
        throw null;
    }

    static /* synthetic */ View P(BottomAppBar bottomAppBar) {
        throw null;
    }
}
