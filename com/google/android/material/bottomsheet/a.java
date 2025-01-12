package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d.h;
import e0.b0;
import e0.u;
import e0.v0;
import f0.y;
import h3.g;
import okio.Segment;
import u2.i;
/* loaded from: classes.dex */
public class a extends h {

    /* renamed from: d  reason: collision with root package name */
    private BottomSheetBehavior f4970d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f4971e;

    /* renamed from: f  reason: collision with root package name */
    private CoordinatorLayout f4972f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f4973g;

    /* renamed from: h  reason: collision with root package name */
    boolean f4974h;

    /* renamed from: i  reason: collision with root package name */
    boolean f4975i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4976j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4977k;

    /* renamed from: l  reason: collision with root package name */
    private BottomSheetBehavior.g f4978l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f4979m;

    /* renamed from: n  reason: collision with root package name */
    private BottomSheetBehavior.g f4980n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.bottomsheet.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0046a implements u {
        C0046a() {
        }

        @Override // e0.u
        public v0 a(View view, v0 v0Var) {
            if (a.this.f4978l != null) {
                a.this.f4970d.i0(a.this.f4978l);
            }
            if (v0Var != null) {
                a aVar = a.this;
                aVar.f4978l = new f(aVar.f4973g, v0Var, null);
                a.this.f4970d.S(a.this.f4978l);
            }
            return v0Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.f4975i && aVar.isShowing() && a.this.o()) {
                a.this.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends e0.a {
        c() {
        }

        @Override // e0.a
        public void g(View view, y yVar) {
            boolean z5;
            super.g(view, yVar);
            if (a.this.f4975i) {
                yVar.a(1048576);
                z5 = true;
            } else {
                z5 = false;
            }
            yVar.b0(z5);
        }

        @Override // e0.a
        public boolean j(View view, int i6, Bundle bundle) {
            if (i6 == 1048576) {
                a aVar = a.this;
                if (aVar.f4975i) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.j(view, i6, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes.dex */
    class e extends BottomSheetBehavior.g {
        e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(View view, float f6) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View view, int i6) {
            if (i6 == 5) {
                a.this.cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    private static class f extends BottomSheetBehavior.g {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f4986a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f4987b;

        /* renamed from: c  reason: collision with root package name */
        private final v0 f4988c;

        private f(View view, v0 v0Var) {
            int color;
            this.f4988c = v0Var;
            boolean z5 = Build.VERSION.SDK_INT >= 23 && (view.getSystemUiVisibility() & Segment.SIZE) != 0;
            this.f4987b = z5;
            g e02 = BottomSheetBehavior.c0(view).e0();
            ColorStateList x5 = e02 != null ? e02.x() : b0.s(view);
            if (x5 != null) {
                color = x5.getDefaultColor();
            } else if (!(view.getBackground() instanceof ColorDrawable)) {
                this.f4986a = z5;
                return;
            } else {
                color = ((ColorDrawable) view.getBackground()).getColor();
            }
            this.f4986a = y2.a.e(color);
        }

        private void c(View view) {
            if (view.getTop() < this.f4988c.i()) {
                a.n(view, this.f4986a);
                view.setPadding(view.getPaddingLeft(), this.f4988c.i() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                a.n(view, this.f4987b);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(View view, float f6) {
            c(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View view, int i6) {
            c(view);
        }

        /* synthetic */ f(View view, v0 v0Var, C0046a c0046a) {
            this(view, v0Var);
        }
    }

    public a(Context context, int i6) {
        super(context, b(context, i6));
        this.f4975i = true;
        this.f4976j = true;
        this.f4980n = new e();
        e(1);
        this.f4979m = getContext().getTheme().obtainStyledAttributes(new int[]{u2.a.enableEdgeToEdge}).getBoolean(0, false);
    }

    private static int b(Context context, int i6) {
        if (i6 == 0) {
            TypedValue typedValue = new TypedValue();
            return context.getTheme().resolveAttribute(u2.a.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : i.Theme_Design_Light_BottomSheetDialog;
        }
        return i6;
    }

    private FrameLayout l() {
        if (this.f4971e == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), u2.g.design_bottom_sheet_dialog, null);
            this.f4971e = frameLayout;
            this.f4972f = (CoordinatorLayout) frameLayout.findViewById(u2.e.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f4971e.findViewById(u2.e.design_bottom_sheet);
            this.f4973g = frameLayout2;
            BottomSheetBehavior c02 = BottomSheetBehavior.c0(frameLayout2);
            this.f4970d = c02;
            c02.S(this.f4980n);
            this.f4970d.r0(this.f4975i);
        }
        return this.f4971e;
    }

    public static void n(View view, boolean z5) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = view.getSystemUiVisibility();
            view.setSystemUiVisibility(z5 ? systemUiVisibility | Segment.SIZE : systemUiVisibility & (-8193));
        }
    }

    private View p(int i6, View view, ViewGroup.LayoutParams layoutParams) {
        l();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f4971e.findViewById(u2.e.coordinator);
        if (i6 != 0 && view == null) {
            view = getLayoutInflater().inflate(i6, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f4979m) {
            b0.w0(this.f4973g, new C0046a());
        }
        this.f4973g.removeAllViews();
        FrameLayout frameLayout = this.f4973g;
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(u2.e.touch_outside).setOnClickListener(new b());
        b0.l0(this.f4973g, new c());
        this.f4973g.setOnTouchListener(new d());
        return this.f4971e;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior m5 = m();
        if (!this.f4974h || m5.f0() == 5) {
            super.cancel();
        } else {
            m5.x0(5);
        }
    }

    public BottomSheetBehavior m() {
        if (this.f4970d == null) {
            l();
        }
        return this.f4970d;
    }

    boolean o() {
        if (!this.f4977k) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.f4976j = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f4977k = true;
        }
        return this.f4976j;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z5 = this.f4979m && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f4971e;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z5);
            }
            CoordinatorLayout coordinatorLayout = this.f4972f;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z5);
            }
            if (z5) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // d.h, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            int i6 = Build.VERSION.SDK_INT;
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            if (i6 < 23) {
                window.addFlags(67108864);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.f4970d;
        if (bottomSheetBehavior == null || bottomSheetBehavior.f0() != 5) {
            return;
        }
        this.f4970d.x0(4);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z5) {
        super.setCancelable(z5);
        if (this.f4975i != z5) {
            this.f4975i = z5;
            BottomSheetBehavior bottomSheetBehavior = this.f4970d;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.r0(z5);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z5) {
        super.setCanceledOnTouchOutside(z5);
        if (z5 && !this.f4975i) {
            this.f4975i = true;
        }
        this.f4976j = z5;
        this.f4977k = true;
    }

    @Override // d.h, android.app.Dialog
    public void setContentView(int i6) {
        super.setContentView(p(i6, null, null));
    }

    @Override // d.h, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(p(0, view, null));
    }

    @Override // d.h, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(p(0, view, layoutParams));
    }
}
