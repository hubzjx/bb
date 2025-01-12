package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e0.b0;
import e0.p;
import f0.y;
import java.lang.ref.WeakReference;
import java.util.List;
import u2.j;
/* loaded from: classes.dex */
public abstract class AppBarLayout extends LinearLayout {

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.a {

        /* renamed from: k  reason: collision with root package name */
        private int f4864k;

        /* renamed from: l  reason: collision with root package name */
        private int f4865l;

        /* renamed from: m  reason: collision with root package name */
        private int f4866m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f4867n;

        /* renamed from: o  reason: collision with root package name */
        private float f4868o;

        /* renamed from: p  reason: collision with root package name */
        private WeakReference f4869p;

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes.dex */
        public static class a extends h0.a {
            public static final Parcelable.Creator<a> CREATOR = new C0044a();

            /* renamed from: c  reason: collision with root package name */
            int f4870c;

            /* renamed from: d  reason: collision with root package name */
            float f4871d;

            /* renamed from: e  reason: collision with root package name */
            boolean f4872e;

            /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static class C0044a implements Parcelable.ClassLoaderCreator {
                C0044a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b */
                public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c */
                public a[] newArray(int i6) {
                    return new a[i6];
                }
            }

            public a(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f4870c = parcel.readInt();
                this.f4871d = parcel.readFloat();
                this.f4872e = parcel.readByte() != 0;
            }

            @Override // h0.a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i6) {
                super.writeToParcel(parcel, i6);
                parcel.writeInt(this.f4870c);
                parcel.writeFloat(this.f4871d);
                parcel.writeByte(this.f4872e ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
            this.f4866m = -1;
        }

        private View S(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = coordinatorLayout.getChildAt(i6);
                if ((childAt instanceof p) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private int T(AppBarLayout appBarLayout, int i6) {
            throw null;
        }

        private void g0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            if (T(appBarLayout, L()) >= 0) {
                throw null;
            }
        }

        private void h0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            b0.f0(coordinatorLayout, y.a.f9748q.b());
            b0.f0(coordinatorLayout, y.a.f9749r.b());
            if (S(coordinatorLayout) != null) {
                throw null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6, int i7) {
            android.support.v4.media.a.a(view);
            return d0(coordinatorLayout, null, view2, view3, i6, i7);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ void C(CoordinatorLayout coordinatorLayout, View view, View view2, int i6) {
            android.support.v4.media.a.a(view);
            e0(coordinatorLayout, null, view2, i6);
        }

        @Override // com.google.android.material.appbar.a
        /* bridge */ /* synthetic */ boolean G(View view) {
            android.support.v4.media.a.a(view);
            return R(null);
        }

        @Override // com.google.android.material.appbar.a
        /* bridge */ /* synthetic */ int J(View view) {
            android.support.v4.media.a.a(view);
            return U(null);
        }

        @Override // com.google.android.material.appbar.a
        /* bridge */ /* synthetic */ int K(View view) {
            android.support.v4.media.a.a(view);
            return V(null);
        }

        @Override // com.google.android.material.appbar.a
        int L() {
            return E() + this.f4864k;
        }

        @Override // com.google.android.material.appbar.a
        /* bridge */ /* synthetic */ void M(CoordinatorLayout coordinatorLayout, View view) {
            android.support.v4.media.a.a(view);
            W(coordinatorLayout, null);
        }

        @Override // com.google.android.material.appbar.a
        /* bridge */ /* synthetic */ int P(CoordinatorLayout coordinatorLayout, View view, int i6, int i7, int i8) {
            android.support.v4.media.a.a(view);
            return f0(coordinatorLayout, null, i6, i7, i8);
        }

        boolean R(AppBarLayout appBarLayout) {
            WeakReference weakReference = this.f4869p;
            if (weakReference != null) {
                View view = (View) weakReference.get();
                return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
            }
            return true;
        }

        int U(AppBarLayout appBarLayout) {
            throw null;
        }

        int V(AppBarLayout appBarLayout) {
            throw null;
        }

        void W(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            g0(coordinatorLayout, appBarLayout);
            throw null;
        }

        public boolean X(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i6) {
            super.l(coordinatorLayout, appBarLayout, i6);
            throw null;
        }

        public boolean Y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i6, int i7, int i8, int i9) {
            throw null;
        }

        public void Z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i6, int i7, int[] iArr, int i8) {
            throw null;
        }

        public void a0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
            if (i9 < 0) {
                throw null;
            }
            if (i9 == 0) {
                h0(coordinatorLayout, appBarLayout);
            }
        }

        public void b0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (!(parcelable instanceof a)) {
                super.x(coordinatorLayout, appBarLayout, parcelable);
                this.f4866m = -1;
                return;
            }
            a aVar = (a) parcelable;
            super.x(coordinatorLayout, appBarLayout, aVar.e());
            this.f4866m = aVar.f4870c;
            this.f4868o = aVar.f4871d;
            this.f4867n = aVar.f4872e;
        }

        public Parcelable c0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            super.y(coordinatorLayout, appBarLayout);
            E();
            throw null;
        }

        public boolean d0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i6, int i7) {
            if ((i6 & 2) == 0) {
                this.f4869p = null;
                this.f4865l = i7;
                return false;
            }
            throw null;
        }

        public void e0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i6) {
            if (this.f4865l == 0 || i6 == 1) {
                g0(coordinatorLayout, appBarLayout);
                throw null;
            } else {
                this.f4869p = new WeakReference(view);
            }
        }

        int f0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i6, int i7, int i8) {
            int L = L();
            if (i7 == 0 || L < i7 || L > i8) {
                this.f4864k = 0;
            } else if (L != z.a.b(i6, i7, i8)) {
                throw null;
            }
            h0(coordinatorLayout, appBarLayout);
            return 0;
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i6) {
            android.support.v4.media.a.a(view);
            return X(coordinatorLayout, null, i6);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, View view, int i6, int i7, int i8, int i9) {
            android.support.v4.media.a.a(view);
            return Y(coordinatorLayout, null, i6, i7, i8, i9);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i6, int i7, int[] iArr, int i8) {
            android.support.v4.media.a.a(view);
            Z(coordinatorLayout, null, view2, i6, i7, iArr, i8);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
            android.support.v4.media.a.a(view);
            a0(coordinatorLayout, null, view2, i6, i7, i8, i9, i10, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ void x(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            android.support.v4.media.a.a(view);
            b0(coordinatorLayout, null, parcelable);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ Parcelable y(CoordinatorLayout coordinatorLayout, View view) {
            android.support.v4.media.a.a(view);
            return c0(coordinatorLayout, null);
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4866m = -1;
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ int E() {
            return super.E();
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean X(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i6) {
            return super.X(coordinatorLayout, appBarLayout, i6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean Y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i6, int i7, int i8, int i9) {
            return super.Y(coordinatorLayout, appBarLayout, i6, i7, i8, i9);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void Z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i6, int i7, int[] iArr, int i8) {
            super.Z(coordinatorLayout, appBarLayout, view, i6, i7, iArr, i8);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
            super.a0(coordinatorLayout, appBarLayout, view, i6, i7, i8, i9, i10, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void b0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.b0(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable c0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.c0(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean d0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i6, int i7) {
            return super.d0(coordinatorLayout, appBarLayout, view, view2, i6, i7);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void e0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i6) {
            super.e0(coordinatorLayout, appBarLayout, view, i6);
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends b {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.E3);
            M(obtainStyledAttributes.getDimensionPixelSize(j.F3, 0));
            obtainStyledAttributes.recycle();
        }

        private void P(View view, View view2) {
            CoordinatorLayout.b e6 = ((CoordinatorLayout.e) view2.getLayoutParams()).e();
            if (e6 instanceof BaseBehavior) {
                b0.X(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) e6).f4864k) + K()) - H(view2));
            }
        }

        private void Q(View view, View view2) {
        }

        @Override // com.google.android.material.appbar.b
        /* bridge */ /* synthetic */ View G(List list) {
            O(list);
            return null;
        }

        @Override // com.google.android.material.appbar.b
        float I(View view) {
            return 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        public int J(View view) {
            return super.J(view);
        }

        AppBarLayout O(List list) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = (View) list.get(i6);
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            P(view, view2);
            Q(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i6) {
            return super.l(coordinatorLayout, view, i6);
        }

        @Override // com.google.android.material.appbar.b, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, View view, int i6, int i7, int i8, int i9) {
            return super.m(coordinatorLayout, view, i6, i7, i8, i9);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z5) {
            O(coordinatorLayout.q(view));
            return false;
        }
    }
}
