package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.internal.l;
import e0.v0;
import f0.b0;
import f0.y;
import h3.k;
import i0.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import u2.j;
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.b {
    private static final int Y = u2.i.Widget_Design_BottomSheet_Modal;
    float A;
    int B;
    float C;
    boolean D;
    private boolean E;
    private boolean F;
    int G;
    i0.c H;
    private boolean I;
    private int J;
    private boolean K;
    private int L;
    int M;
    int N;
    WeakReference O;
    WeakReference P;
    private final ArrayList Q;
    private VelocityTracker R;
    int S;
    private int T;
    boolean U;
    private Map V;
    private int W;
    private final c.AbstractC0177c X;

    /* renamed from: a  reason: collision with root package name */
    private int f4923a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4924b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4925c;

    /* renamed from: d  reason: collision with root package name */
    private float f4926d;

    /* renamed from: e  reason: collision with root package name */
    private int f4927e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4928f;

    /* renamed from: g  reason: collision with root package name */
    private int f4929g;

    /* renamed from: h  reason: collision with root package name */
    private int f4930h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4931i;

    /* renamed from: j  reason: collision with root package name */
    private h3.g f4932j;

    /* renamed from: k  reason: collision with root package name */
    private int f4933k;

    /* renamed from: l  reason: collision with root package name */
    private int f4934l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f4935m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f4936n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f4937o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f4938p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f4939q;

    /* renamed from: r  reason: collision with root package name */
    private int f4940r;

    /* renamed from: s  reason: collision with root package name */
    private int f4941s;

    /* renamed from: t  reason: collision with root package name */
    private k f4942t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f4943u;

    /* renamed from: v  reason: collision with root package name */
    private i f4944v;

    /* renamed from: w  reason: collision with root package name */
    private ValueAnimator f4945w;

    /* renamed from: x  reason: collision with root package name */
    int f4946x;

    /* renamed from: y  reason: collision with root package name */
    int f4947y;

    /* renamed from: z  reason: collision with root package name */
    int f4948z;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f4949a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f4950b;

        a(View view, ViewGroup.LayoutParams layoutParams) {
            this.f4949a = view;
            this.f4950b = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4949a.setLayoutParams(this.f4950b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f4952a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f4953b;

        b(View view, int i6) {
            this.f4952a = view;
            this.f4953b = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.A0(this.f4952a, this.f4953b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f4932j != null) {
                BottomSheetBehavior.this.f4932j.V(floatValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements l.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f4956a;

        d(boolean z5) {
            this.f4956a = z5;
        }

        @Override // com.google.android.material.internal.l.c
        public v0 a(View view, v0 v0Var, l.d dVar) {
            BottomSheetBehavior.this.f4941s = v0Var.i();
            boolean d6 = l.d(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.f4936n) {
                BottomSheetBehavior.this.f4940r = v0Var.f();
                paddingBottom = dVar.f5316d + BottomSheetBehavior.this.f4940r;
            }
            if (BottomSheetBehavior.this.f4937o) {
                paddingLeft = (d6 ? dVar.f5315c : dVar.f5313a) + v0Var.g();
            }
            if (BottomSheetBehavior.this.f4938p) {
                paddingRight = (d6 ? dVar.f5313a : dVar.f5315c) + v0Var.h();
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.f4956a) {
                BottomSheetBehavior.this.f4934l = v0Var.e().f13693d;
            }
            if (BottomSheetBehavior.this.f4936n || this.f4956a) {
                BottomSheetBehavior.this.H0(false);
            }
            return v0Var;
        }
    }

    /* loaded from: classes.dex */
    class e extends c.AbstractC0177c {
        e() {
        }

        private boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.N + bottomSheetBehavior.d0()) / 2;
        }

        @Override // i0.c.AbstractC0177c
        public int a(View view, int i6, int i7) {
            return view.getLeft();
        }

        @Override // i0.c.AbstractC0177c
        public int b(View view, int i6, int i7) {
            int d02 = BottomSheetBehavior.this.d0();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return z.a.b(i6, d02, bottomSheetBehavior.D ? bottomSheetBehavior.N : bottomSheetBehavior.B);
        }

        @Override // i0.c.AbstractC0177c
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.D ? bottomSheetBehavior.N : bottomSheetBehavior.B;
        }

        @Override // i0.c.AbstractC0177c
        public void j(int i6) {
            if (i6 == 1 && BottomSheetBehavior.this.F) {
                BottomSheetBehavior.this.y0(1);
            }
        }

        @Override // i0.c.AbstractC0177c
        public void k(View view, int i6, int i7, int i8, int i9) {
            BottomSheetBehavior.this.a0(i7);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
            if (java.lang.Math.abs(r6.getTop() - r5.f4958a.d0()) < java.lang.Math.abs(r6.getTop() - r5.f4958a.f4948z)) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
            r7 = r5.f4958a.d0();
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00b8, code lost:
            if (java.lang.Math.abs(r7 - r5.f4958a.f4948z) < java.lang.Math.abs(r7 - r5.f4958a.B)) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00de, code lost:
            if (java.lang.Math.abs(r7 - r5.f4958a.f4947y) < java.lang.Math.abs(r7 - r5.f4958a.B)) goto L5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00f0, code lost:
            if (r7 < java.lang.Math.abs(r7 - r8.B)) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0102, code lost:
            if (java.lang.Math.abs(r7 - r2) < java.lang.Math.abs(r7 - r5.f4958a.B)) goto L30;
         */
        @Override // i0.c.AbstractC0177c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void l(View view, float f6, float f7) {
            int i6;
            int i7 = 6;
            if (f7 < 0.0f) {
                if (!BottomSheetBehavior.this.f4924b) {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    int i8 = bottomSheetBehavior.f4948z;
                    if (top > i8) {
                        i6 = i8;
                    } else {
                        i6 = bottomSheetBehavior.d0();
                        i7 = 3;
                    }
                }
                i6 = BottomSheetBehavior.this.f4947y;
                i7 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                if (bottomSheetBehavior2.D && bottomSheetBehavior2.C0(view, f7)) {
                    if ((Math.abs(f6) >= Math.abs(f7) || f7 <= 500.0f) && !n(view)) {
                        if (!BottomSheetBehavior.this.f4924b) {
                        }
                        i6 = BottomSheetBehavior.this.f4947y;
                        i7 = 3;
                    } else {
                        i6 = BottomSheetBehavior.this.N;
                        i7 = 5;
                    }
                } else if (f7 == 0.0f || Math.abs(f6) > Math.abs(f7)) {
                    int top2 = view.getTop();
                    if (!BottomSheetBehavior.this.f4924b) {
                        BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                        int i9 = bottomSheetBehavior3.f4948z;
                        if (top2 < i9) {
                        }
                        i6 = BottomSheetBehavior.this.f4948z;
                    }
                    i6 = BottomSheetBehavior.this.B;
                    i7 = 4;
                } else {
                    if (!BottomSheetBehavior.this.f4924b) {
                        int top3 = view.getTop();
                    }
                    i6 = BottomSheetBehavior.this.B;
                    i7 = 4;
                }
            }
            BottomSheetBehavior.this.D0(view, i7, i6, true);
        }

        @Override // i0.c.AbstractC0177c
        public boolean m(View view, int i6) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i7 = bottomSheetBehavior.G;
            if (i7 == 1 || bottomSheetBehavior.U) {
                return false;
            }
            if (i7 == 3 && bottomSheetBehavior.S == i6) {
                WeakReference weakReference = bottomSheetBehavior.P;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference weakReference2 = BottomSheetBehavior.this.O;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements b0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4959a;

        f(int i6) {
            this.f4959a = i6;
        }

        @Override // f0.b0
        public boolean a(View view, b0.a aVar) {
            BottomSheetBehavior.this.x0(this.f4959a);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g {
        public abstract void a(View view, float f6);

        public abstract void b(View view, int i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class h extends h0.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        final int f4961c;

        /* renamed from: d  reason: collision with root package name */
        int f4962d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4963e;

        /* renamed from: f  reason: collision with root package name */
        boolean f4964f;

        /* renamed from: g  reason: collision with root package name */
        boolean f4965g;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public h[] newArray(int i6) {
                return new h[i6];
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4961c = parcel.readInt();
            this.f4962d = parcel.readInt();
            this.f4963e = parcel.readInt() == 1;
            this.f4964f = parcel.readInt() == 1;
            this.f4965g = parcel.readInt() == 1;
        }

        @Override // h0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f4961c);
            parcel.writeInt(this.f4962d);
            parcel.writeInt(this.f4963e ? 1 : 0);
            parcel.writeInt(this.f4964f ? 1 : 0);
            parcel.writeInt(this.f4965g ? 1 : 0);
        }

        public h(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.f4961c = bottomSheetBehavior.G;
            this.f4962d = bottomSheetBehavior.f4927e;
            this.f4963e = bottomSheetBehavior.f4924b;
            this.f4964f = bottomSheetBehavior.D;
            this.f4965g = bottomSheetBehavior.E;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f4966a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4967b;

        /* renamed from: c  reason: collision with root package name */
        int f4968c;

        i(View view, int i6) {
            this.f4966a = view;
            this.f4968c = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            i0.c cVar = BottomSheetBehavior.this.H;
            if (cVar == null || !cVar.k(true)) {
                BottomSheetBehavior.this.y0(this.f4968c);
            } else {
                e0.b0.d0(this.f4966a, this);
            }
            this.f4967b = false;
        }
    }

    public BottomSheetBehavior() {
        this.f4923a = 0;
        this.f4924b = true;
        this.f4925c = false;
        this.f4933k = -1;
        this.f4944v = null;
        this.A = 0.5f;
        this.C = -1.0f;
        this.F = true;
        this.G = 4;
        this.Q = new ArrayList();
        this.W = -1;
        this.X = new e();
    }

    private void B0(int i6) {
        View view = (View) this.O.get();
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && e0.b0.Q(view)) {
            view.post(new b(view, i6));
        } else {
            A0(view, i6);
        }
    }

    private void E0() {
        View view;
        int i6;
        y.a aVar;
        WeakReference weakReference = this.O;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        e0.b0.f0(view, 524288);
        e0.b0.f0(view, 262144);
        e0.b0.f0(view, 1048576);
        int i7 = this.W;
        if (i7 != -1) {
            e0.b0.f0(view, i7);
        }
        if (!this.f4924b && this.G != 6) {
            this.W = R(view, u2.h.bottomsheet_action_expand_halfway, 6);
        }
        if (this.D && this.G != 5) {
            j0(view, y.a.f9756y, 5);
        }
        int i8 = this.G;
        if (i8 == 3) {
            i6 = this.f4924b ? 4 : 6;
            aVar = y.a.f9755x;
        } else if (i8 != 4) {
            if (i8 != 6) {
                return;
            }
            j0(view, y.a.f9755x, 4);
            j0(view, y.a.f9754w, 3);
            return;
        } else {
            i6 = this.f4924b ? 3 : 6;
            aVar = y.a.f9754w;
        }
        j0(view, aVar, i6);
    }

    private void F0(int i6) {
        ValueAnimator valueAnimator;
        if (i6 == 2) {
            return;
        }
        boolean z5 = i6 == 3;
        if (this.f4943u != z5) {
            this.f4943u = z5;
            if (this.f4932j == null || (valueAnimator = this.f4945w) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.f4945w.reverse();
                return;
            }
            float f6 = z5 ? 0.0f : 1.0f;
            this.f4945w.setFloatValues(1.0f - f6, f6);
            this.f4945w.start();
        }
    }

    private void G0(boolean z5) {
        Map map;
        int intValue;
        WeakReference weakReference = this.O;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z5) {
                if (this.V != null) {
                    return;
                }
                this.V = new HashMap(childCount);
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = coordinatorLayout.getChildAt(i6);
                if (childAt != this.O.get()) {
                    if (z5) {
                        this.V.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.f4925c) {
                            intValue = 4;
                            e0.b0.u0(childAt, intValue);
                        }
                    } else if (this.f4925c && (map = this.V) != null && map.containsKey(childAt)) {
                        intValue = ((Integer) this.V.get(childAt)).intValue();
                        e0.b0.u0(childAt, intValue);
                    }
                }
            }
            if (!z5) {
                this.V = null;
            } else if (this.f4925c) {
                ((View) this.O.get()).sendAccessibilityEvent(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(boolean z5) {
        View view;
        if (this.O != null) {
            T();
            if (this.G != 4 || (view = (View) this.O.get()) == null) {
                return;
            }
            if (z5) {
                B0(this.G);
            } else {
                view.requestLayout();
            }
        }
    }

    private int R(View view, int i6, int i7) {
        return e0.b0.b(view, view.getResources().getString(i6), W(i7));
    }

    private void T() {
        int V = V();
        if (this.f4924b) {
            this.B = Math.max(this.N - V, this.f4947y);
        } else {
            this.B = this.N - V;
        }
    }

    private void U() {
        this.f4948z = (int) (this.N * (1.0f - this.A));
    }

    private int V() {
        int i6;
        return this.f4928f ? Math.min(Math.max(this.f4929g, this.N - ((this.M * 9) / 16)), this.L) + this.f4940r : (this.f4935m || this.f4936n || (i6 = this.f4934l) <= 0) ? this.f4927e + this.f4940r : Math.max(this.f4927e, i6 + this.f4930h);
    }

    private b0 W(int i6) {
        return new f(i6);
    }

    private void X(Context context, AttributeSet attributeSet, boolean z5) {
        Y(context, attributeSet, z5, null);
    }

    private void Y(Context context, AttributeSet attributeSet, boolean z5, ColorStateList colorStateList) {
        if (this.f4931i) {
            this.f4942t = k.e(context, attributeSet, u2.a.bottomSheetStyle, Y).m();
            h3.g gVar = new h3.g(this.f4942t);
            this.f4932j = gVar;
            gVar.K(context);
            if (z5 && colorStateList != null) {
                this.f4932j.U(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.f4932j.setTint(typedValue.data);
        }
    }

    private void Z() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f4945w = ofFloat;
        ofFloat.setDuration(500L);
        this.f4945w.addUpdateListener(new c());
    }

    public static BottomSheetBehavior c0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.e) {
            CoordinatorLayout.b e6 = ((CoordinatorLayout.e) layoutParams).e();
            if (e6 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) e6;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private float g0() {
        VelocityTracker velocityTracker = this.R;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f4926d);
        return this.R.getYVelocity(this.S);
    }

    private void j0(View view, y.a aVar, int i6) {
        e0.b0.h0(view, aVar, null, W(i6));
    }

    private void k0() {
        this.S = -1;
        VelocityTracker velocityTracker = this.R;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.R = null;
        }
    }

    private void l0(h hVar) {
        int i6 = this.f4923a;
        if (i6 == 0) {
            return;
        }
        if (i6 == -1 || (i6 & 1) == 1) {
            this.f4927e = hVar.f4962d;
        }
        if (i6 == -1 || (i6 & 2) == 2) {
            this.f4924b = hVar.f4963e;
        }
        if (i6 == -1 || (i6 & 4) == 4) {
            this.D = hVar.f4964f;
        }
        if (i6 == -1 || (i6 & 8) == 8) {
            this.E = hVar.f4965g;
        }
    }

    private void z0(View view) {
        boolean z5 = (Build.VERSION.SDK_INT < 29 || h0() || this.f4928f) ? false : true;
        if (this.f4936n || this.f4937o || this.f4938p || z5) {
            l.a(view, new d(z5));
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6, int i7) {
        this.J = 0;
        this.K = false;
        return (i6 & 2) != 0;
    }

    void A0(View view, int i6) {
        int i7;
        int i8;
        if (i6 == 4) {
            i7 = this.B;
        } else if (i6 == 6) {
            i7 = this.f4948z;
            if (this.f4924b && i7 <= (i8 = this.f4947y)) {
                i7 = i8;
                i6 = 3;
            }
        } else if (i6 == 3) {
            i7 = d0();
        } else if (!this.D || i6 != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + i6);
        } else {
            i7 = this.N;
        }
        D0(view, i6, i7, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x006b, code lost:
        if (java.lang.Math.abs(r3 - r2.f4947y) < java.lang.Math.abs(r3 - r2.B)) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007a, code lost:
        if (r3 < java.lang.Math.abs(r3 - r2.B)) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.B)) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a8, code lost:
        if (java.lang.Math.abs(r3 - r2.f4948z) < java.lang.Math.abs(r3 - r2.B)) goto L40;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C(CoordinatorLayout coordinatorLayout, View view, View view2, int i6) {
        int i7;
        int i8 = 3;
        if (view.getTop() == d0()) {
            y0(3);
            return;
        }
        WeakReference weakReference = this.P;
        if (weakReference != null && view2 == weakReference.get() && this.K) {
            if (this.J > 0) {
                if (!this.f4924b) {
                    int top = view.getTop();
                    int i9 = this.f4948z;
                    if (top > i9) {
                        i7 = i9;
                        i8 = 6;
                    }
                    i7 = d0();
                }
                i7 = this.f4947y;
            } else if (this.D && C0(view, g0())) {
                i7 = this.N;
                i8 = 5;
            } else if (this.J == 0) {
                int top2 = view.getTop();
                if (!this.f4924b) {
                    int i10 = this.f4948z;
                    if (top2 < i10) {
                    }
                    i7 = this.f4948z;
                    i8 = 6;
                }
                i7 = this.B;
                i8 = 4;
            } else {
                if (!this.f4924b) {
                    int top3 = view.getTop();
                }
                i7 = this.B;
                i8 = 4;
            }
            D0(view, i8, i7, false);
            this.K = false;
        }
    }

    boolean C0(View view, float f6) {
        if (this.E) {
            return true;
        }
        if (view.getTop() < this.B) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f6 * 0.1f)) - ((float) this.B)) / ((float) V()) > 0.5f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (view.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.G == 1 && actionMasked == 0) {
                return true;
            }
            i0.c cVar = this.H;
            if (cVar != null) {
                cVar.z(motionEvent);
            }
            if (actionMasked == 0) {
                k0();
            }
            if (this.R == null) {
                this.R = VelocityTracker.obtain();
            }
            this.R.addMovement(motionEvent);
            if (this.H != null && actionMasked == 2 && !this.I && Math.abs(this.T - motionEvent.getY()) > this.H.u()) {
                this.H.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return !this.I;
        }
        return false;
    }

    void D0(View view, int i6, int i7, boolean z5) {
        i0.c cVar = this.H;
        if (!(cVar != null && (!z5 ? !cVar.H(view, view.getLeft(), i7) : !cVar.F(view.getLeft(), i7)))) {
            y0(i6);
            return;
        }
        y0(2);
        F0(i6);
        if (this.f4944v == null) {
            this.f4944v = new i(view, i6);
        }
        if (this.f4944v.f4967b) {
            this.f4944v.f4968c = i6;
            return;
        }
        i iVar = this.f4944v;
        iVar.f4968c = i6;
        e0.b0.d0(view, iVar);
        this.f4944v.f4967b = true;
    }

    public void S(g gVar) {
        if (this.Q.contains(gVar)) {
            return;
        }
        this.Q.add(gVar);
    }

    void a0(int i6) {
        float f6;
        float f7;
        View view = (View) this.O.get();
        if (view == null || this.Q.isEmpty()) {
            return;
        }
        int i7 = this.B;
        if (i6 > i7 || i7 == d0()) {
            int i8 = this.B;
            f6 = i8 - i6;
            f7 = this.N - i8;
        } else {
            int i9 = this.B;
            f6 = i9 - i6;
            f7 = i9 - d0();
        }
        float f8 = f6 / f7;
        for (int i10 = 0; i10 < this.Q.size(); i10++) {
            ((g) this.Q.get(i10)).a(view, f8);
        }
    }

    View b0(View view) {
        if (e0.b0.S(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View b02 = b0(viewGroup.getChildAt(i6));
                if (b02 != null) {
                    return b02;
                }
            }
            return null;
        }
        return null;
    }

    public int d0() {
        if (this.f4924b) {
            return this.f4947y;
        }
        return Math.max(this.f4946x, this.f4939q ? 0 : this.f4941s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h3.g e0() {
        return this.f4932j;
    }

    public int f0() {
        return this.G;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void g(CoordinatorLayout.e eVar) {
        super.g(eVar);
        this.O = null;
        this.H = null;
    }

    public boolean h0() {
        return this.f4935m;
    }

    public void i0(g gVar) {
        this.Q.remove(gVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void j() {
        super.j();
        this.O = null;
        this.H = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        i0.c cVar;
        if (!view.isShown() || !this.F) {
            this.I = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            k0();
        }
        if (this.R == null) {
            this.R = VelocityTracker.obtain();
        }
        this.R.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x5 = (int) motionEvent.getX();
            this.T = (int) motionEvent.getY();
            if (this.G != 2) {
                WeakReference weakReference = this.P;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.z(view2, x5, this.T)) {
                    this.S = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.U = true;
                }
            }
            this.I = this.S == -1 && !coordinatorLayout.z(view, x5, this.T);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.U = false;
            this.S = -1;
            if (this.I) {
                this.I = false;
                return false;
            }
        }
        if (this.I || (cVar = this.H) == null || !cVar.G(motionEvent)) {
            WeakReference weakReference2 = this.P;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            return (actionMasked != 2 || view3 == null || this.I || this.G == 1 || coordinatorLayout.z(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.H == null || Math.abs(((float) this.T) - motionEvent.getY()) <= ((float) this.H.u())) ? false : true;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i6) {
        int i7;
        h3.g gVar;
        if (e0.b0.y(coordinatorLayout) && !e0.b0.y(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.O == null) {
            this.f4929g = coordinatorLayout.getResources().getDimensionPixelSize(u2.c.design_bottom_sheet_peek_height_min);
            z0(view);
            this.O = new WeakReference(view);
            if (this.f4931i && (gVar = this.f4932j) != null) {
                e0.b0.o0(view, gVar);
            }
            h3.g gVar2 = this.f4932j;
            if (gVar2 != null) {
                float f6 = this.C;
                if (f6 == -1.0f) {
                    f6 = e0.b0.w(view);
                }
                gVar2.T(f6);
                boolean z5 = this.G == 3;
                this.f4943u = z5;
                this.f4932j.V(z5 ? 0.0f : 1.0f);
            }
            E0();
            if (e0.b0.z(view) == 0) {
                e0.b0.u0(view, 1);
            }
            int measuredWidth = view.getMeasuredWidth();
            int i8 = this.f4933k;
            if (measuredWidth > i8 && i8 != -1) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = this.f4933k;
                view.post(new a(view, layoutParams));
            }
        }
        if (this.H == null) {
            this.H = i0.c.m(coordinatorLayout, this.X);
        }
        int top = view.getTop();
        coordinatorLayout.G(view, i6);
        this.M = coordinatorLayout.getWidth();
        this.N = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.L = height;
        int i9 = this.N;
        int i10 = i9 - height;
        int i11 = this.f4941s;
        if (i10 < i11) {
            if (this.f4939q) {
                this.L = i9;
            } else {
                this.L = i9 - i11;
            }
        }
        this.f4947y = Math.max(0, i9 - this.L);
        U();
        T();
        int i12 = this.G;
        if (i12 == 3) {
            i7 = d0();
        } else if (i12 == 6) {
            i7 = this.f4948z;
        } else if (this.D && i12 == 5) {
            i7 = this.N;
        } else if (i12 != 4) {
            if (i12 == 1 || i12 == 2) {
                e0.b0.X(view, top - view.getTop());
            }
            this.P = new WeakReference(b0(view));
            return true;
        } else {
            i7 = this.B;
        }
        e0.b0.X(view, i7);
        this.P = new WeakReference(b0(view));
        return true;
    }

    public void m0(boolean z5) {
        this.F = z5;
    }

    public void n0(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.f4946x = i6;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, float f6, float f7) {
        WeakReference weakReference = this.P;
        if (weakReference == null || view2 != weakReference.get()) {
            return false;
        }
        return this.G != 3 || super.o(coordinatorLayout, view, view2, f6, f7);
    }

    public void o0(boolean z5) {
        if (this.f4924b == z5) {
            return;
        }
        this.f4924b = z5;
        if (this.O != null) {
            T();
        }
        y0((this.f4924b && this.G == 6) ? 3 : this.G);
        E0();
    }

    public void p0(boolean z5) {
        this.f4935m = z5;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i6, int i7, int[] iArr, int i8) {
        int i9;
        if (i8 == 1) {
            return;
        }
        WeakReference weakReference = this.P;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i10 = top - i7;
        if (i7 > 0) {
            if (i10 < d0()) {
                int d02 = top - d0();
                iArr[1] = d02;
                e0.b0.X(view, -d02);
                i9 = 3;
                y0(i9);
            } else if (!this.F) {
                return;
            } else {
                iArr[1] = i7;
                e0.b0.X(view, -i7);
                y0(1);
            }
        } else if (i7 < 0 && !view2.canScrollVertically(-1)) {
            int i11 = this.B;
            if (i10 > i11 && !this.D) {
                int i12 = top - i11;
                iArr[1] = i12;
                e0.b0.X(view, -i12);
                i9 = 4;
                y0(i9);
            } else if (!this.F) {
                return;
            } else {
                iArr[1] = i7;
                e0.b0.X(view, -i7);
                y0(1);
            }
        }
        a0(view.getTop());
        this.J = i7;
        this.K = true;
    }

    public void q0(float f6) {
        if (f6 <= 0.0f || f6 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.A = f6;
        if (this.O != null) {
            U();
        }
    }

    public void r0(boolean z5) {
        if (this.D != z5) {
            this.D = z5;
            if (!z5 && this.G == 5) {
                x0(4);
            }
            E0();
        }
    }

    public void s0(int i6) {
        this.f4933k = i6;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
    }

    public void t0(int i6) {
        u0(i6, false);
    }

    public final void u0(int i6, boolean z5) {
        boolean z6 = true;
        if (i6 == -1) {
            if (!this.f4928f) {
                this.f4928f = true;
            }
            z6 = false;
        } else {
            if (this.f4928f || this.f4927e != i6) {
                this.f4928f = false;
                this.f4927e = Math.max(0, i6);
            }
            z6 = false;
        }
        if (z6) {
            H0(z5);
        }
    }

    public void v0(int i6) {
        this.f4923a = i6;
    }

    public void w0(boolean z5) {
        this.E = z5;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void x(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        h hVar = (h) parcelable;
        super.x(coordinatorLayout, view, hVar.e());
        l0(hVar);
        int i6 = hVar.f4961c;
        this.G = (i6 == 1 || i6 == 2) ? 4 : 4;
    }

    public void x0(int i6) {
        if (i6 == this.G) {
            return;
        }
        if (this.O != null) {
            B0(i6);
        } else if (i6 == 4 || i6 == 3 || i6 == 6 || (this.D && i6 == 5)) {
            this.G = i6;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Parcelable y(CoordinatorLayout coordinatorLayout, View view) {
        return new h(super.y(coordinatorLayout, view), this);
    }

    void y0(int i6) {
        View view;
        if (this.G == i6) {
            return;
        }
        this.G = i6;
        WeakReference weakReference = this.O;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        if (i6 == 3) {
            G0(true);
        } else if (i6 == 6 || i6 == 5 || i6 == 4) {
            G0(false);
        }
        F0(i6);
        for (int i7 = 0; i7 < this.Q.size(); i7++) {
            ((g) this.Q.get(i7)).b(view, i6);
        }
        E0();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i6;
        this.f4923a = 0;
        this.f4924b = true;
        this.f4925c = false;
        this.f4933k = -1;
        this.f4944v = null;
        this.A = 0.5f;
        this.C = -1.0f;
        this.F = true;
        this.G = 4;
        this.Q = new ArrayList();
        this.W = -1;
        this.X = new e();
        this.f4930h = context.getResources().getDimensionPixelSize(u2.c.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f13581w);
        this.f4931i = obtainStyledAttributes.hasValue(j.N);
        int i7 = j.f13599z;
        boolean hasValue = obtainStyledAttributes.hasValue(i7);
        if (hasValue) {
            Y(context, attributeSet, hasValue, e3.c.a(context, obtainStyledAttributes, i7));
        } else {
            X(context, attributeSet, hasValue);
        }
        Z();
        this.C = obtainStyledAttributes.getDimension(j.f13593y, -1.0f);
        int i8 = j.f13587x;
        if (obtainStyledAttributes.hasValue(i8)) {
            s0(obtainStyledAttributes.getDimensionPixelSize(i8, -1));
        }
        int i9 = j.F;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i9);
        if (peekValue == null || (i6 = peekValue.data) != -1) {
            t0(obtainStyledAttributes.getDimensionPixelSize(i9, -1));
        } else {
            t0(i6);
        }
        r0(obtainStyledAttributes.getBoolean(j.E, false));
        p0(obtainStyledAttributes.getBoolean(j.I, false));
        o0(obtainStyledAttributes.getBoolean(j.C, true));
        w0(obtainStyledAttributes.getBoolean(j.H, false));
        m0(obtainStyledAttributes.getBoolean(j.A, true));
        v0(obtainStyledAttributes.getInt(j.G, 0));
        q0(obtainStyledAttributes.getFloat(j.D, 0.5f));
        int i10 = j.B;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i10);
        n0((peekValue2 == null || peekValue2.type != 16) ? obtainStyledAttributes.getDimensionPixelOffset(i10, 0) : peekValue2.data);
        this.f4936n = obtainStyledAttributes.getBoolean(j.J, false);
        this.f4937o = obtainStyledAttributes.getBoolean(j.K, false);
        this.f4938p = obtainStyledAttributes.getBoolean(j.L, false);
        this.f4939q = obtainStyledAttributes.getBoolean(j.M, true);
        obtainStyledAttributes.recycle();
        this.f4926d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
