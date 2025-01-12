package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;
import e0.b0;
import f0.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.google.android.material.textfield.e {

    /* renamed from: q  reason: collision with root package name */
    private static final boolean f5413q = true;

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f5414d;

    /* renamed from: e  reason: collision with root package name */
    private final View.OnFocusChangeListener f5415e;

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.e f5416f;

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.f f5417g;

    /* renamed from: h  reason: collision with root package name */
    private final TextInputLayout.g f5418h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5419i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5420j;

    /* renamed from: k  reason: collision with root package name */
    private long f5421k;

    /* renamed from: l  reason: collision with root package name */
    private StateListDrawable f5422l;

    /* renamed from: m  reason: collision with root package name */
    private h3.g f5423m;

    /* renamed from: n  reason: collision with root package name */
    private AccessibilityManager f5424n;

    /* renamed from: o  reason: collision with root package name */
    private ValueAnimator f5425o;

    /* renamed from: p  reason: collision with root package name */
    private ValueAnimator f5426p;

    /* loaded from: classes.dex */
    class a extends com.google.android.material.internal.i {

        /* renamed from: com.google.android.material.textfield.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0051a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f5428a;

            RunnableC0051a(AutoCompleteTextView autoCompleteTextView) {
                this.f5428a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.f5428a.isPopupShowing();
                d.this.E(isPopupShowing);
                d.this.f5419i = isPopupShowing;
            }
        }

        a() {
        }

        @Override // com.google.android.material.internal.i, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView y5 = d.y(d.this.f5442a.getEditText());
            if (d.this.f5424n.isTouchExplorationEnabled() && d.D(y5) && !d.this.f5444c.hasFocus()) {
                y5.dismissDropDown();
            }
            y5.post(new RunnableC0051a(y5));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f5444c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnFocusChangeListener {
        c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z5) {
            d.this.f5442a.setEndIconActivated(z5);
            if (z5) {
                return;
            }
            d.this.E(false);
            d.this.f5419i = false;
        }
    }

    /* renamed from: com.google.android.material.textfield.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0052d extends TextInputLayout.e {
        C0052d(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, e0.a
        public void g(View view, y yVar) {
            super.g(view, yVar);
            if (!d.D(d.this.f5442a.getEditText())) {
                yVar.W(Spinner.class.getName());
            }
            if (yVar.J()) {
                yVar.h0(null);
            }
        }

        @Override // e0.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            AutoCompleteTextView y5 = d.y(d.this.f5442a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.f5424n.isTouchExplorationEnabled() && !d.D(d.this.f5442a.getEditText())) {
                d.this.H(y5);
            }
        }
    }

    /* loaded from: classes.dex */
    class e implements TextInputLayout.f {
        e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView y5 = d.y(textInputLayout.getEditText());
            d.this.F(y5);
            d.this.v(y5);
            d.this.G(y5);
            y5.setThreshold(0);
            y5.removeTextChangedListener(d.this.f5414d);
            y5.addTextChangedListener(d.this.f5414d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!d.D(y5)) {
                b0.u0(d.this.f5444c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f5416f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* loaded from: classes.dex */
    class f implements TextInputLayout.g {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f5435a;

            a(AutoCompleteTextView autoCompleteTextView) {
                this.f5435a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f5435a.removeTextChangedListener(d.this.f5414d);
            }
        }

        f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i6) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i6 != 3) {
                return;
            }
            autoCompleteTextView.post(new a(autoCompleteTextView));
            if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f5415e) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            if (d.f5413q) {
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    /* loaded from: classes.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.H((AutoCompleteTextView) d.this.f5442a.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f5438b;

        h(AutoCompleteTextView autoCompleteTextView) {
            this.f5438b = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.C()) {
                    d.this.f5419i = false;
                }
                d.this.H(this.f5438b);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements AutoCompleteTextView.OnDismissListener {
        i() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.f5419i = true;
            d.this.f5421k = System.currentTimeMillis();
            d.this.E(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f5444c.setChecked(dVar.f5420j);
            d.this.f5426p.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f5414d = new a();
        this.f5415e = new c();
        this.f5416f = new C0052d(this.f5442a);
        this.f5417g = new e();
        this.f5418h = new f();
        this.f5419i = false;
        this.f5420j = false;
        this.f5421k = Long.MAX_VALUE;
    }

    private h3.g A(float f6, float f7, float f8, int i6) {
        h3.k m5 = h3.k.a().A(f6).E(f6).s(f7).w(f7).m();
        h3.g m6 = h3.g.m(this.f5443b, f8);
        m6.setShapeAppearanceModel(m5);
        m6.W(0, i6, 0, i6);
        return m6;
    }

    private void B() {
        this.f5426p = z(67, 0.0f, 1.0f);
        ValueAnimator z5 = z(50, 1.0f, 0.0f);
        this.f5425o = z5;
        z5.addListener(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        long currentTimeMillis = System.currentTimeMillis() - this.f5421k;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean D(EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z5) {
        if (this.f5420j != z5) {
            this.f5420j = z5;
            this.f5426p.cancel();
            this.f5425o.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(AutoCompleteTextView autoCompleteTextView) {
        Drawable drawable;
        if (f5413q) {
            int boxBackgroundMode = this.f5442a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                drawable = this.f5423m;
            } else if (boxBackgroundMode != 1) {
                return;
            } else {
                drawable = this.f5422l;
            }
            autoCompleteTextView.setDropDownBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new h(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f5415e);
        if (f5413q) {
            autoCompleteTextView.setOnDismissListener(new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (C()) {
            this.f5419i = false;
        }
        if (this.f5419i) {
            this.f5419i = false;
            return;
        }
        if (f5413q) {
            E(!this.f5420j);
        } else {
            this.f5420j = !this.f5420j;
            this.f5444c.toggle();
        }
        if (!this.f5420j) {
            autoCompleteTextView.dismissDropDown();
            return;
        }
        autoCompleteTextView.requestFocus();
        autoCompleteTextView.showDropDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(AutoCompleteTextView autoCompleteTextView) {
        if (D(autoCompleteTextView)) {
            return;
        }
        int boxBackgroundMode = this.f5442a.getBoxBackgroundMode();
        h3.g boxBackground = this.f5442a.getBoxBackground();
        int c6 = y2.a.c(autoCompleteTextView, u2.a.f13434h);
        int[][] iArr = {new int[]{16842919}, new int[0]};
        if (boxBackgroundMode == 2) {
            x(autoCompleteTextView, c6, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            w(autoCompleteTextView, c6, iArr, boxBackground);
        }
    }

    private void w(AutoCompleteTextView autoCompleteTextView, int i6, int[][] iArr, h3.g gVar) {
        int boxBackgroundColor = this.f5442a.getBoxBackgroundColor();
        int[] iArr2 = {y2.a.g(i6, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f5413q) {
            b0.o0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), gVar, gVar));
            return;
        }
        h3.g gVar2 = new h3.g(gVar.B());
        gVar2.U(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar, gVar2});
        int G = b0.G(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int F = b0.F(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        b0.o0(autoCompleteTextView, layerDrawable);
        b0.x0(autoCompleteTextView, G, paddingTop, F, paddingBottom);
    }

    private void x(AutoCompleteTextView autoCompleteTextView, int i6, int[][] iArr, h3.g gVar) {
        LayerDrawable layerDrawable;
        int c6 = y2.a.c(autoCompleteTextView, u2.a.colorSurface);
        h3.g gVar2 = new h3.g(gVar.B());
        int g6 = y2.a.g(i6, c6, 0.1f);
        gVar2.U(new ColorStateList(iArr, new int[]{g6, 0}));
        if (f5413q) {
            gVar2.setTint(c6);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{g6, c6});
            h3.g gVar3 = new h3.g(gVar.B());
            gVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar2, gVar3), gVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar});
        }
        b0.o0(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AutoCompleteTextView y(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator z(int i6, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(v2.a.f13673a);
        ofFloat.setDuration(i6);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        float dimensionPixelOffset = this.f5443b.getResources().getDimensionPixelOffset(u2.c.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f5443b.getResources().getDimensionPixelOffset(u2.c.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f5443b.getResources().getDimensionPixelOffset(u2.c.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        h3.g A = A(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        h3.g A2 = A(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f5423m = A;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f5422l = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, A);
        this.f5422l.addState(new int[0], A2);
        this.f5442a.setEndIconDrawable(e.b.d(this.f5443b, f5413q ? u2.d.mtrl_dropdown_arrow : u2.d.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = this.f5442a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(u2.h.exposed_dropdown_menu_content_description));
        this.f5442a.setEndIconOnClickListener(new g());
        this.f5442a.e(this.f5417g);
        this.f5442a.f(this.f5418h);
        B();
        this.f5424n = (AccessibilityManager) this.f5443b.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean b(int i6) {
        return i6 != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean d() {
        return true;
    }
}
