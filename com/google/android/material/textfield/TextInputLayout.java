package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.c2;
import androidx.appcompat.widget.f1;
import androidx.appcompat.widget.n0;
import androidx.core.widget.v;
import com.google.android.material.internal.CheckableImageButton;
import e0.b0;
import f0.y;
import h3.k;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    private static final int N0 = u2.i.Widget_Design_TextInputLayout;
    private final TextView A;
    private ColorStateList A0;
    private boolean B;
    private int B0;
    private CharSequence C;
    private int C0;
    private boolean D;
    private int D0;
    private h3.g E;
    private int E0;
    private h3.g F;
    private int F0;
    private h3.k G;
    private boolean G0;
    private final int H;
    final com.google.android.material.internal.a H0;
    private int I;
    private boolean I0;
    private int J;
    private boolean J0;
    private int K;
    private ValueAnimator K0;
    private int L;
    private boolean L0;
    private int M;
    private boolean M0;
    private int N;
    private int O;
    private int P;
    private final Rect Q;
    private final Rect R;
    private final RectF S;
    private Typeface T;
    private final CheckableImageButton U;
    private ColorStateList V;
    private boolean W;

    /* renamed from: a0  reason: collision with root package name */
    private PorterDuff.Mode f5334a0;

    /* renamed from: b  reason: collision with root package name */
    private final FrameLayout f5335b;

    /* renamed from: b0  reason: collision with root package name */
    private boolean f5336b0;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f5337c;

    /* renamed from: c0  reason: collision with root package name */
    private Drawable f5338c0;

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayout f5339d;

    /* renamed from: d0  reason: collision with root package name */
    private int f5340d0;

    /* renamed from: e  reason: collision with root package name */
    private final FrameLayout f5341e;

    /* renamed from: e0  reason: collision with root package name */
    private View.OnLongClickListener f5342e0;

    /* renamed from: f  reason: collision with root package name */
    EditText f5343f;

    /* renamed from: f0  reason: collision with root package name */
    private final LinkedHashSet f5344f0;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f5345g;

    /* renamed from: g0  reason: collision with root package name */
    private int f5346g0;

    /* renamed from: h  reason: collision with root package name */
    private int f5347h;

    /* renamed from: h0  reason: collision with root package name */
    private final SparseArray f5348h0;

    /* renamed from: i  reason: collision with root package name */
    private int f5349i;

    /* renamed from: i0  reason: collision with root package name */
    private final CheckableImageButton f5350i0;

    /* renamed from: j  reason: collision with root package name */
    private final com.google.android.material.textfield.f f5351j;

    /* renamed from: j0  reason: collision with root package name */
    private final LinkedHashSet f5352j0;

    /* renamed from: k  reason: collision with root package name */
    boolean f5353k;

    /* renamed from: k0  reason: collision with root package name */
    private ColorStateList f5354k0;

    /* renamed from: l  reason: collision with root package name */
    private int f5355l;

    /* renamed from: l0  reason: collision with root package name */
    private boolean f5356l0;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5357m;

    /* renamed from: m0  reason: collision with root package name */
    private PorterDuff.Mode f5358m0;

    /* renamed from: n  reason: collision with root package name */
    private TextView f5359n;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f5360n0;

    /* renamed from: o  reason: collision with root package name */
    private int f5361o;

    /* renamed from: o0  reason: collision with root package name */
    private Drawable f5362o0;

    /* renamed from: p  reason: collision with root package name */
    private int f5363p;

    /* renamed from: p0  reason: collision with root package name */
    private int f5364p0;

    /* renamed from: q  reason: collision with root package name */
    private CharSequence f5365q;

    /* renamed from: q0  reason: collision with root package name */
    private Drawable f5366q0;

    /* renamed from: r  reason: collision with root package name */
    private boolean f5367r;

    /* renamed from: r0  reason: collision with root package name */
    private View.OnLongClickListener f5368r0;

    /* renamed from: s  reason: collision with root package name */
    private TextView f5369s;

    /* renamed from: s0  reason: collision with root package name */
    private View.OnLongClickListener f5370s0;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f5371t;

    /* renamed from: t0  reason: collision with root package name */
    private final CheckableImageButton f5372t0;

    /* renamed from: u  reason: collision with root package name */
    private int f5373u;

    /* renamed from: u0  reason: collision with root package name */
    private ColorStateList f5374u0;

    /* renamed from: v  reason: collision with root package name */
    private ColorStateList f5375v;

    /* renamed from: v0  reason: collision with root package name */
    private ColorStateList f5376v0;

    /* renamed from: w  reason: collision with root package name */
    private ColorStateList f5377w;

    /* renamed from: w0  reason: collision with root package name */
    private ColorStateList f5378w0;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f5379x;

    /* renamed from: x0  reason: collision with root package name */
    private int f5380x0;

    /* renamed from: y  reason: collision with root package name */
    private final TextView f5381y;

    /* renamed from: y0  reason: collision with root package name */
    private int f5382y0;

    /* renamed from: z  reason: collision with root package name */
    private CharSequence f5383z;

    /* renamed from: z0  reason: collision with root package name */
    private int f5384z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.v0(!textInputLayout.M0);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f5353k) {
                textInputLayout2.n0(editable.length());
            }
            if (TextInputLayout.this.f5367r) {
                TextInputLayout.this.z0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f5350i0.performClick();
            TextInputLayout.this.f5350i0.jumpDrawablesToCurrentState();
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f5343f.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.H0.a0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e extends e0.a {

        /* renamed from: d  reason: collision with root package name */
        private final TextInputLayout f5389d;

        public e(TextInputLayout textInputLayout) {
            this.f5389d = textInputLayout;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0083, code lost:
            if (r3 != null) goto L43;
         */
        @Override // e0.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void g(View view, y yVar) {
            super.g(view, yVar);
            EditText editText = this.f5389d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f5389d.getHint();
            CharSequence error = this.f5389d.getError();
            CharSequence placeholderText = this.f5389d.getPlaceholderText();
            int counterMaxLength = this.f5389d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f5389d.getCounterOverflowDescription();
            boolean z5 = !TextUtils.isEmpty(text);
            boolean z6 = !TextUtils.isEmpty(hint);
            boolean z7 = !this.f5389d.N();
            boolean z8 = !TextUtils.isEmpty(error);
            boolean z9 = z8 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z6 ? hint.toString() : HttpUrl.FRAGMENT_ENCODE_SET;
            if (z5) {
                yVar.s0(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                yVar.s0(charSequence);
                if (z7 && placeholderText != null) {
                    placeholderText = charSequence + ", " + ((Object) placeholderText);
                    yVar.s0(placeholderText);
                }
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    yVar.h0(charSequence);
                } else {
                    if (z5) {
                        charSequence = ((Object) text) + ", " + charSequence;
                    }
                    yVar.s0(charSequence);
                }
                yVar.p0(!z5);
            }
            yVar.i0((text == null || text.length() != counterMaxLength) ? -1 : -1);
            if (z9) {
                if (!z8) {
                    error = counterOverflowDescription;
                }
                yVar.d0(error);
            }
            if (editText != null) {
                editText.setLabelFor(u2.e.textinput_helper_text);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(TextInputLayout textInputLayout, int i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h extends h0.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        CharSequence f5390c;

        /* renamed from: d  reason: collision with root package name */
        boolean f5391d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f5392e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f5393f;

        /* renamed from: g  reason: collision with root package name */
        CharSequence f5394g;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
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

        h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5390c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f5391d = parcel.readInt() == 1;
            this.f5392e = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f5393f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f5394g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f5390c) + " hint=" + ((Object) this.f5392e) + " helperText=" + ((Object) this.f5393f) + " placeholderText=" + ((Object) this.f5394g) + "}";
        }

        @Override // h0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            TextUtils.writeToParcel(this.f5390c, parcel, i6);
            parcel.writeInt(this.f5391d ? 1 : 0);
            TextUtils.writeToParcel(this.f5392e, parcel, i6);
            TextUtils.writeToParcel(this.f5393f, parcel, i6);
            TextUtils.writeToParcel(this.f5394g, parcel, i6);
        }

        h(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, u2.a.textInputStyle);
    }

    private boolean A() {
        return this.B && !TextUtils.isEmpty(this.C) && (this.E instanceof com.google.android.material.textfield.c);
    }

    private void A0() {
        if (this.f5343f == null) {
            return;
        }
        b0.x0(this.f5381y, Q() ? 0 : b0.G(this.f5343f), this.f5343f.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(u2.c.material_input_text_to_prefix_suffix_padding), this.f5343f.getCompoundPaddingBottom());
    }

    private void B() {
        Iterator it = this.f5344f0.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(this);
        }
    }

    private void B0() {
        this.f5381y.setVisibility((this.f5379x == null || N()) ? 8 : 0);
        r0();
    }

    private void C(int i6) {
        Iterator it = this.f5352j0.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(this, i6);
        }
    }

    private void C0(boolean z5, boolean z6) {
        int defaultColor = this.A0.getDefaultColor();
        int colorForState = this.A0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.A0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z5) {
            this.O = colorForState2;
        } else if (z6) {
            this.O = colorForState;
        } else {
            this.O = defaultColor;
        }
    }

    private void D(Canvas canvas) {
        h3.g gVar = this.F;
        if (gVar != null) {
            Rect bounds = gVar.getBounds();
            bounds.top = bounds.bottom - this.L;
            this.F.draw(canvas);
        }
    }

    private void D0() {
        if (this.f5343f == null) {
            return;
        }
        b0.x0(this.A, getContext().getResources().getDimensionPixelSize(u2.c.material_input_text_to_prefix_suffix_padding), this.f5343f.getPaddingTop(), (K() || L()) ? 0 : b0.F(this.f5343f), this.f5343f.getPaddingBottom());
    }

    private void E(Canvas canvas) {
        if (this.B) {
            this.H0.m(canvas);
        }
    }

    private void E0() {
        int visibility = this.A.getVisibility();
        boolean z5 = (this.f5383z == null || N()) ? false : true;
        this.A.setVisibility(z5 ? 0 : 8);
        if (visibility != this.A.getVisibility()) {
            getEndIconDelegate().c(z5);
        }
        r0();
    }

    private void F(boolean z5) {
        ValueAnimator valueAnimator = this.K0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.K0.cancel();
        }
        if (z5 && this.J0) {
            i(0.0f);
        } else {
            this.H0.a0(0.0f);
        }
        if (A() && ((com.google.android.material.textfield.c) this.E).f0()) {
            y();
        }
        this.G0 = true;
        J();
        B0();
        E0();
    }

    private int G(int i6, boolean z5) {
        int compoundPaddingLeft = i6 + this.f5343f.getCompoundPaddingLeft();
        return (this.f5379x == null || z5) ? compoundPaddingLeft : (compoundPaddingLeft - this.f5381y.getMeasuredWidth()) + this.f5381y.getPaddingLeft();
    }

    private int H(int i6, boolean z5) {
        int compoundPaddingRight = i6 - this.f5343f.getCompoundPaddingRight();
        return (this.f5379x == null || !z5) ? compoundPaddingRight : compoundPaddingRight + (this.f5381y.getMeasuredWidth() - this.f5381y.getPaddingRight());
    }

    private boolean I() {
        return this.f5346g0 != 0;
    }

    private void J() {
        TextView textView = this.f5369s;
        if (textView == null || !this.f5367r) {
            return;
        }
        textView.setText((CharSequence) null);
        this.f5369s.setVisibility(4);
    }

    private boolean L() {
        return this.f5372t0.getVisibility() == 0;
    }

    private boolean P() {
        return this.J == 1 && this.f5343f.getMinLines() <= 1;
    }

    private int[] R(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    private void S() {
        p();
        a0();
        F0();
        k0();
        h();
        if (this.J != 0) {
            u0();
        }
    }

    private void T() {
        if (A()) {
            RectF rectF = this.S;
            this.H0.p(rectF, this.f5343f.getWidth(), this.f5343f.getGravity());
            l(rectF);
            int i6 = this.L;
            this.I = i6;
            rectF.top = 0.0f;
            rectF.bottom = i6;
            rectF.offset(-getPaddingLeft(), 0.0f);
            ((com.google.android.material.textfield.c) this.E).l0(rectF);
        }
    }

    private static void U(ViewGroup viewGroup, boolean z5) {
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = viewGroup.getChildAt(i6);
            childAt.setEnabled(z5);
            if (childAt instanceof ViewGroup) {
                U((ViewGroup) childAt, z5);
            }
        }
    }

    private void X(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(R(checkableImageButton), colorStateList.getDefaultColor());
        Drawable mutate = x.b.r(drawable).mutate();
        x.b.o(mutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    private void Z() {
        TextView textView = this.f5369s;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void a0() {
        if (h0()) {
            b0.o0(this.f5343f, this.E);
        }
    }

    private static void b0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean M = b0.M(checkableImageButton);
        boolean z5 = false;
        boolean z6 = onLongClickListener != null;
        z5 = (M || z6) ? true : true;
        checkableImageButton.setFocusable(z5);
        checkableImageButton.setClickable(M);
        checkableImageButton.setPressable(M);
        checkableImageButton.setLongClickable(z6);
        b0.u0(checkableImageButton, z5 ? 1 : 2);
    }

    private static void c0(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        b0(checkableImageButton, onLongClickListener);
    }

    private static void d0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        b0(checkableImageButton, onLongClickListener);
    }

    private boolean f0() {
        return (this.f5372t0.getVisibility() == 0 || ((I() && K()) || this.f5383z != null)) && this.f5339d.getMeasuredWidth() > 0;
    }

    private void g() {
        TextView textView = this.f5369s;
        if (textView != null) {
            this.f5335b.addView(textView);
            this.f5369s.setVisibility(0);
        }
    }

    private boolean g0() {
        return !(getStartIconDrawable() == null && this.f5379x == null) && this.f5337c.getMeasuredWidth() > 0;
    }

    private com.google.android.material.textfield.e getEndIconDelegate() {
        com.google.android.material.textfield.e eVar = (com.google.android.material.textfield.e) this.f5348h0.get(this.f5346g0);
        return eVar != null ? eVar : (com.google.android.material.textfield.e) this.f5348h0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.f5372t0.getVisibility() == 0) {
            return this.f5372t0;
        }
        if (I() && K()) {
            return this.f5350i0;
        }
        return null;
    }

    private void h() {
        EditText editText;
        int G;
        int dimensionPixelSize;
        int F;
        Resources resources;
        int i6;
        if (this.f5343f == null || this.J != 1) {
            return;
        }
        if (e3.c.h(getContext())) {
            editText = this.f5343f;
            G = b0.G(editText);
            dimensionPixelSize = getResources().getDimensionPixelSize(u2.c.material_filled_edittext_font_2_0_padding_top);
            F = b0.F(this.f5343f);
            resources = getResources();
            i6 = u2.c.material_filled_edittext_font_2_0_padding_bottom;
        } else if (!e3.c.g(getContext())) {
            return;
        } else {
            editText = this.f5343f;
            G = b0.G(editText);
            dimensionPixelSize = getResources().getDimensionPixelSize(u2.c.material_filled_edittext_font_1_3_padding_top);
            F = b0.F(this.f5343f);
            resources = getResources();
            i6 = u2.c.material_filled_edittext_font_1_3_padding_bottom;
        }
        b0.x0(editText, G, dimensionPixelSize, F, resources.getDimensionPixelSize(i6));
    }

    private boolean h0() {
        EditText editText = this.f5343f;
        return (editText == null || this.E == null || editText.getBackground() != null || this.J == 0) ? false : true;
    }

    private void i0() {
        TextView textView = this.f5369s;
        if (textView == null || !this.f5367r) {
            return;
        }
        textView.setText(this.f5365q);
        this.f5369s.setVisibility(0);
        this.f5369s.bringToFront();
    }

    private void j() {
        h3.g gVar = this.E;
        if (gVar == null) {
            return;
        }
        gVar.setShapeAppearanceModel(this.G);
        if (w()) {
            this.E.Y(this.L, this.O);
        }
        int q5 = q();
        this.P = q5;
        this.E.U(ColorStateList.valueOf(q5));
        if (this.f5346g0 == 3) {
            this.f5343f.getBackground().invalidateSelf();
        }
        k();
        invalidate();
    }

    private void j0(boolean z5) {
        if (!z5 || getEndIconDrawable() == null) {
            m();
            return;
        }
        Drawable mutate = x.b.r(getEndIconDrawable()).mutate();
        x.b.n(mutate, this.f5351j.o());
        this.f5350i0.setImageDrawable(mutate);
    }

    private void k() {
        if (this.F == null) {
            return;
        }
        if (x()) {
            this.F.U(ColorStateList.valueOf(this.O));
        }
        invalidate();
    }

    private void k0() {
        Resources resources;
        int i6;
        if (this.J == 1) {
            if (e3.c.h(getContext())) {
                resources = getResources();
                i6 = u2.c.material_font_2_0_box_collapsed_padding_top;
            } else if (!e3.c.g(getContext())) {
                return;
            } else {
                resources = getResources();
                i6 = u2.c.material_font_1_3_box_collapsed_padding_top;
            }
            this.K = resources.getDimensionPixelSize(i6);
        }
    }

    private void l(RectF rectF) {
        float f6 = rectF.left;
        int i6 = this.H;
        rectF.left = f6 - i6;
        rectF.right += i6;
    }

    private void l0(Rect rect) {
        h3.g gVar = this.F;
        if (gVar != null) {
            int i6 = rect.bottom;
            gVar.setBounds(rect.left, i6 - this.N, rect.right, i6);
        }
    }

    private void m() {
        n(this.f5350i0, this.f5356l0, this.f5354k0, this.f5360n0, this.f5358m0);
    }

    private void m0() {
        if (this.f5359n != null) {
            EditText editText = this.f5343f;
            n0(editText == null ? 0 : editText.getText().length());
        }
    }

    private void n(CheckableImageButton checkableImageButton, boolean z5, ColorStateList colorStateList, boolean z6, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z5 || z6)) {
            drawable = x.b.r(drawable).mutate();
            if (z5) {
                x.b.o(drawable, colorStateList);
            }
            if (z6) {
                x.b.p(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void o() {
        n(this.U, this.W, this.V, this.f5336b0, this.f5334a0);
    }

    private static void o0(Context context, TextView textView, int i6, int i7, boolean z5) {
        textView.setContentDescription(context.getString(z5 ? u2.h.character_counter_overflowed_content_description : u2.h.character_counter_content_description, Integer.valueOf(i6), Integer.valueOf(i7)));
    }

    private void p() {
        int i6 = this.J;
        if (i6 == 0) {
            this.E = null;
        } else if (i6 == 1) {
            this.E = new h3.g(this.G);
            this.F = new h3.g();
            return;
        } else if (i6 != 2) {
            throw new IllegalArgumentException(this.J + " is illegal; only @BoxBackgroundMode constants are supported.");
        } else {
            this.E = (!this.B || (this.E instanceof com.google.android.material.textfield.c)) ? new h3.g(this.G) : new com.google.android.material.textfield.c(this.G);
        }
        this.F = null;
    }

    private void p0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f5359n;
        if (textView != null) {
            e0(textView, this.f5357m ? this.f5361o : this.f5363p);
            if (!this.f5357m && (colorStateList2 = this.f5375v) != null) {
                this.f5359n.setTextColor(colorStateList2);
            }
            if (!this.f5357m || (colorStateList = this.f5377w) == null) {
                return;
            }
            this.f5359n.setTextColor(colorStateList);
        }
    }

    private int q() {
        return this.J == 1 ? y2.a.f(y2.a.d(this, u2.a.colorSurface, 0), this.P) : this.P;
    }

    private void q0() {
        if (!A() || this.G0 || this.I == this.L) {
            return;
        }
        y();
        T();
    }

    private Rect r(Rect rect) {
        int i6;
        int i7;
        if (this.f5343f != null) {
            Rect rect2 = this.R;
            boolean z5 = b0.B(this) == 1;
            rect2.bottom = rect.bottom;
            int i8 = this.J;
            if (i8 == 1) {
                rect2.left = G(rect.left, z5);
                i6 = rect.top + this.K;
            } else if (i8 == 2) {
                rect2.left = rect.left + this.f5343f.getPaddingLeft();
                rect2.top = rect.top - v();
                i7 = rect.right - this.f5343f.getPaddingRight();
                rect2.right = i7;
                return rect2;
            } else {
                rect2.left = G(rect.left, z5);
                i6 = getPaddingTop();
            }
            rect2.top = i6;
            i7 = H(rect.right, z5);
            rect2.right = i7;
            return rect2;
        }
        throw new IllegalStateException();
    }

    private boolean r0() {
        boolean z5;
        Drawable drawable;
        EditText editText;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        if (this.f5343f == null) {
            return false;
        }
        boolean z6 = true;
        if (g0()) {
            int measuredWidth = this.f5337c.getMeasuredWidth() - this.f5343f.getPaddingLeft();
            if (this.f5338c0 == null || this.f5340d0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f5338c0 = colorDrawable;
                this.f5340d0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] a6 = v.a(this.f5343f);
            Drawable drawable5 = a6[0];
            Drawable drawable6 = this.f5338c0;
            if (drawable5 != drawable6) {
                v.i(this.f5343f, drawable6, a6[1], a6[2], a6[3]);
                z5 = true;
            }
            z5 = false;
        } else {
            if (this.f5338c0 != null) {
                Drawable[] a7 = v.a(this.f5343f);
                v.i(this.f5343f, null, a7[1], a7[2], a7[3]);
                this.f5338c0 = null;
                z5 = true;
            }
            z5 = false;
        }
        if (f0()) {
            int measuredWidth2 = this.A.getMeasuredWidth() - this.f5343f.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + e0.g.b((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] a8 = v.a(this.f5343f);
            Drawable drawable7 = this.f5362o0;
            if (drawable7 == null || this.f5364p0 == measuredWidth2) {
                if (drawable7 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f5362o0 = colorDrawable2;
                    this.f5364p0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable8 = a8[2];
                drawable = this.f5362o0;
                if (drawable8 != drawable) {
                    this.f5366q0 = drawable8;
                    editText = this.f5343f;
                    drawable2 = a8[0];
                    drawable3 = a8[1];
                    drawable4 = a8[3];
                } else {
                    z6 = z5;
                }
            } else {
                this.f5364p0 = measuredWidth2;
                drawable7.setBounds(0, 0, measuredWidth2, 1);
                editText = this.f5343f;
                drawable2 = a8[0];
                drawable3 = a8[1];
                drawable = this.f5362o0;
                drawable4 = a8[3];
            }
            v.i(editText, drawable2, drawable3, drawable, drawable4);
        } else if (this.f5362o0 == null) {
            return z5;
        } else {
            Drawable[] a9 = v.a(this.f5343f);
            if (a9[2] == this.f5362o0) {
                v.i(this.f5343f, a9[0], a9[1], this.f5366q0, a9[3]);
            } else {
                z6 = z5;
            }
            this.f5362o0 = null;
        }
        return z6;
    }

    private int s(Rect rect, Rect rect2, float f6) {
        return P() ? (int) (rect2.top + f6) : rect.bottom - this.f5343f.getCompoundPaddingBottom();
    }

    private void setEditText(EditText editText) {
        if (this.f5343f != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.f5346g0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f5343f = editText;
        setMinWidth(this.f5347h);
        setMaxWidth(this.f5349i);
        S();
        setTextInputAccessibilityDelegate(new e(this));
        this.H0.g0(this.f5343f.getTypeface());
        this.H0.Y(this.f5343f.getTextSize());
        int gravity = this.f5343f.getGravity();
        this.H0.Q((gravity & (-113)) | 48);
        this.H0.X(gravity);
        this.f5343f.addTextChangedListener(new a());
        if (this.f5376v0 == null) {
            this.f5376v0 = this.f5343f.getHintTextColors();
        }
        if (this.B) {
            if (TextUtils.isEmpty(this.C)) {
                CharSequence hint = this.f5343f.getHint();
                this.f5345g = hint;
                setHint(hint);
                this.f5343f.setHint((CharSequence) null);
            }
            this.D = true;
        }
        if (this.f5359n != null) {
            n0(this.f5343f.getText().length());
        }
        s0();
        this.f5351j.e();
        this.f5337c.bringToFront();
        this.f5339d.bringToFront();
        this.f5341e.bringToFront();
        this.f5372t0.bringToFront();
        B();
        A0();
        D0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        w0(false, true);
    }

    private void setErrorIconVisible(boolean z5) {
        this.f5372t0.setVisibility(z5 ? 0 : 8);
        this.f5341e.setVisibility(z5 ? 8 : 0);
        D0();
        if (I()) {
            return;
        }
        r0();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.C)) {
            return;
        }
        this.C = charSequence;
        this.H0.e0(charSequence);
        if (this.G0) {
            return;
        }
        T();
    }

    private void setPlaceholderTextEnabled(boolean z5) {
        if (this.f5367r == z5) {
            return;
        }
        if (z5) {
            n0 n0Var = new n0(getContext());
            this.f5369s = n0Var;
            n0Var.setId(u2.e.textinput_placeholder);
            b0.n0(this.f5369s, 1);
            setPlaceholderTextAppearance(this.f5373u);
            setPlaceholderTextColor(this.f5371t);
            g();
        } else {
            Z();
            this.f5369s = null;
        }
        this.f5367r = z5;
    }

    private int t(Rect rect, float f6) {
        return P() ? (int) (rect.centerY() - (f6 / 2.0f)) : rect.top + this.f5343f.getCompoundPaddingTop();
    }

    private boolean t0() {
        int max;
        if (this.f5343f != null && this.f5343f.getMeasuredHeight() < (max = Math.max(this.f5339d.getMeasuredHeight(), this.f5337c.getMeasuredHeight()))) {
            this.f5343f.setMinimumHeight(max);
            return true;
        }
        return false;
    }

    private Rect u(Rect rect) {
        if (this.f5343f != null) {
            Rect rect2 = this.R;
            float x5 = this.H0.x();
            rect2.left = rect.left + this.f5343f.getCompoundPaddingLeft();
            rect2.top = t(rect, x5);
            rect2.right = rect.right - this.f5343f.getCompoundPaddingRight();
            rect2.bottom = s(rect, rect2, x5);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private void u0() {
        if (this.J != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f5335b.getLayoutParams();
            int v5 = v();
            if (v5 != layoutParams.topMargin) {
                layoutParams.topMargin = v5;
                this.f5335b.requestLayout();
            }
        }
    }

    private int v() {
        float r5;
        if (this.B) {
            int i6 = this.J;
            if (i6 == 0 || i6 == 1) {
                r5 = this.H0.r();
            } else if (i6 != 2) {
                return 0;
            } else {
                r5 = this.H0.r() / 2.0f;
            }
            return (int) r5;
        }
        return 0;
    }

    private boolean w() {
        return this.J == 2 && x();
    }

    private void w0(boolean z5, boolean z6) {
        ColorStateList colorStateList;
        com.google.android.material.internal.a aVar;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f5343f;
        boolean z7 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f5343f;
        boolean z8 = editText2 != null && editText2.hasFocus();
        boolean k6 = this.f5351j.k();
        ColorStateList colorStateList2 = this.f5376v0;
        if (colorStateList2 != null) {
            this.H0.P(colorStateList2);
            this.H0.W(this.f5376v0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f5376v0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.F0) : this.F0;
            this.H0.P(ColorStateList.valueOf(colorForState));
            this.H0.W(ColorStateList.valueOf(colorForState));
        } else if (k6) {
            this.H0.P(this.f5351j.p());
        } else {
            if (this.f5357m && (textView = this.f5359n) != null) {
                aVar = this.H0;
                colorStateList = textView.getTextColors();
            } else if (z8 && (colorStateList = this.f5378w0) != null) {
                aVar = this.H0;
            }
            aVar.P(colorStateList);
        }
        if (z7 || !this.I0 || (isEnabled() && z8)) {
            if (z6 || this.G0) {
                z(z5);
            }
        } else if (z6 || !this.G0) {
            F(z5);
        }
    }

    private boolean x() {
        return this.L > -1 && this.O != 0;
    }

    private void x0() {
        EditText editText;
        if (this.f5369s == null || (editText = this.f5343f) == null) {
            return;
        }
        this.f5369s.setGravity(editText.getGravity());
        this.f5369s.setPadding(this.f5343f.getCompoundPaddingLeft(), this.f5343f.getCompoundPaddingTop(), this.f5343f.getCompoundPaddingRight(), this.f5343f.getCompoundPaddingBottom());
    }

    private void y() {
        if (A()) {
            ((com.google.android.material.textfield.c) this.E).i0();
        }
    }

    private void y0() {
        EditText editText = this.f5343f;
        z0(editText == null ? 0 : editText.getText().length());
    }

    private void z(boolean z5) {
        ValueAnimator valueAnimator = this.K0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.K0.cancel();
        }
        if (z5 && this.J0) {
            i(1.0f);
        } else {
            this.H0.a0(1.0f);
        }
        this.G0 = false;
        if (A()) {
            T();
        }
        y0();
        B0();
        E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(int i6) {
        if (i6 != 0 || this.G0) {
            J();
        } else {
            i0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void F0() {
        int i6;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.E == null || this.J == 0) {
            return;
        }
        boolean z5 = false;
        boolean z6 = isFocused() || ((editText2 = this.f5343f) != null && editText2.hasFocus());
        boolean z7 = isHovered() || ((editText = this.f5343f) != null && editText.isHovered());
        if (isEnabled()) {
            if (this.f5351j.k()) {
                if (this.A0 == null) {
                    i6 = this.f5351j.o();
                }
                C0(z6, z7);
            } else if (!this.f5357m || (textView = this.f5359n) == null) {
                i6 = z6 ? this.f5384z0 : z7 ? this.f5382y0 : this.f5380x0;
            } else {
                if (this.A0 == null) {
                    i6 = textView.getCurrentTextColor();
                }
                C0(z6, z7);
            }
            if (getErrorIconDrawable() != null && this.f5351j.x() && this.f5351j.k()) {
                z5 = true;
            }
            setErrorIconVisible(z5);
            W();
            Y();
            V();
            if (getEndIconDelegate().d()) {
                j0(this.f5351j.k());
            }
            this.L = (z6 || !isEnabled()) ? this.M : this.N;
            if (this.J == 2) {
                q0();
            }
            if (this.J == 1) {
                this.P = !isEnabled() ? this.C0 : (!z7 || z6) ? z6 ? this.D0 : this.B0 : this.E0;
            }
            j();
        }
        i6 = this.F0;
        this.O = i6;
        if (getErrorIconDrawable() != null) {
            z5 = true;
        }
        setErrorIconVisible(z5);
        W();
        Y();
        V();
        if (getEndIconDelegate().d()) {
        }
        this.L = (z6 || !isEnabled()) ? this.M : this.N;
        if (this.J == 2) {
        }
        if (this.J == 1) {
        }
        j();
    }

    public boolean K() {
        return this.f5341e.getVisibility() == 0 && this.f5350i0.getVisibility() == 0;
    }

    public boolean M() {
        return this.f5351j.y();
    }

    final boolean N() {
        return this.G0;
    }

    public boolean O() {
        return this.D;
    }

    public boolean Q() {
        return this.U.getVisibility() == 0;
    }

    public void V() {
        X(this.f5350i0, this.f5354k0);
    }

    public void W() {
        X(this.f5372t0, this.f5374u0);
    }

    public void Y() {
        X(this.U, this.V);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i6, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f5335b.addView(view, layoutParams2);
        this.f5335b.setLayoutParams(layoutParams);
        u0();
        setEditText((EditText) view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i6) {
        ViewStructure newChild;
        EditText editText = this.f5343f;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i6);
            return;
        }
        if (this.f5345g != null) {
            boolean z5 = this.D;
            this.D = false;
            CharSequence hint = editText.getHint();
            this.f5343f.setHint(this.f5345g);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i6);
                return;
            } finally {
                this.f5343f.setHint(hint);
                this.D = z5;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i6);
        onProvideAutofillVirtualStructure(viewStructure, i6);
        viewStructure.setChildCount(this.f5335b.getChildCount());
        for (int i7 = 0; i7 < this.f5335b.getChildCount(); i7++) {
            View childAt = this.f5335b.getChildAt(i7);
            newChild = viewStructure.newChild(i7);
            childAt.dispatchProvideAutofillStructure(newChild, i6);
            if (childAt == this.f5343f) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.M0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.M0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.L0) {
            return;
        }
        boolean z5 = true;
        this.L0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.H0;
        boolean d02 = aVar != null ? aVar.d0(drawableState) | false : false;
        if (this.f5343f != null) {
            v0((b0.R(this) && isEnabled()) ? false : false);
        }
        s0();
        F0();
        if (d02) {
            invalidate();
        }
        this.L0 = false;
    }

    public void e(f fVar) {
        this.f5344f0.add(fVar);
        if (this.f5343f != null) {
            fVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e0(TextView textView, int i6) {
        boolean z5 = true;
        try {
            v.n(textView, i6);
            if (Build.VERSION.SDK_INT >= 23) {
            }
            z5 = false;
        } catch (Exception unused) {
        }
        if (z5) {
            v.n(textView, u2.i.TextAppearance_AppCompat_Caption);
            textView.setTextColor(u.c.a(getContext(), u2.b.design_error));
        }
    }

    public void f(g gVar) {
        this.f5352j0.add(gVar);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f5343f;
        return editText != null ? editText.getBaseline() + getPaddingTop() + v() : super.getBaseline();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h3.g getBoxBackground() {
        int i6 = this.J;
        if (i6 == 1 || i6 == 2) {
            return this.E;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.P;
    }

    public int getBoxBackgroundMode() {
        return this.J;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.E.s();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.E.t();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.E.E();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.E.D();
    }

    public int getBoxStrokeColor() {
        return this.f5384z0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.A0;
    }

    public int getBoxStrokeWidth() {
        return this.M;
    }

    public int getBoxStrokeWidthFocused() {
        return this.N;
    }

    public int getCounterMaxLength() {
        return this.f5355l;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f5353k && this.f5357m && (textView = this.f5359n) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f5375v;
    }

    public ColorStateList getCounterTextColor() {
        return this.f5375v;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f5376v0;
    }

    public EditText getEditText() {
        return this.f5343f;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f5350i0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f5350i0.getDrawable();
    }

    public int getEndIconMode() {
        return this.f5346g0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckableImageButton getEndIconView() {
        return this.f5350i0;
    }

    public CharSequence getError() {
        if (this.f5351j.x()) {
            return this.f5351j.n();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f5351j.m();
    }

    public int getErrorCurrentTextColors() {
        return this.f5351j.o();
    }

    public Drawable getErrorIconDrawable() {
        return this.f5372t0.getDrawable();
    }

    final int getErrorTextCurrentColor() {
        return this.f5351j.o();
    }

    public CharSequence getHelperText() {
        if (this.f5351j.y()) {
            return this.f5351j.q();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f5351j.r();
    }

    public CharSequence getHint() {
        if (this.B) {
            return this.C;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.H0.r();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.H0.u();
    }

    public ColorStateList getHintTextColor() {
        return this.f5378w0;
    }

    public int getMaxWidth() {
        return this.f5349i;
    }

    public int getMinWidth() {
        return this.f5347h;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f5350i0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f5350i0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f5367r) {
            return this.f5365q;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f5373u;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f5371t;
    }

    public CharSequence getPrefixText() {
        return this.f5379x;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f5381y.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f5381y;
    }

    public CharSequence getStartIconContentDescription() {
        return this.U.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.U.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.f5383z;
    }

    public ColorStateList getSuffixTextColor() {
        return this.A.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.A;
    }

    public Typeface getTypeface() {
        return this.T;
    }

    void i(float f6) {
        if (this.H0.y() == f6) {
            return;
        }
        if (this.K0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.K0 = valueAnimator;
            valueAnimator.setInterpolator(v2.a.f13674b);
            this.K0.setDuration(167L);
            this.K0.addUpdateListener(new d());
        }
        this.K0.setFloatValues(this.H0.y(), f6);
        this.K0.start();
    }

    void n0(int i6) {
        boolean z5 = this.f5357m;
        int i7 = this.f5355l;
        if (i7 == -1) {
            this.f5359n.setText(String.valueOf(i6));
            this.f5359n.setContentDescription(null);
            this.f5357m = false;
        } else {
            this.f5357m = i6 > i7;
            o0(getContext(), this.f5359n, i6, this.f5355l, this.f5357m);
            if (z5 != this.f5357m) {
                p0();
            }
            this.f5359n.setText(c0.a.c().j(getContext().getString(u2.h.character_counter_pattern, Integer.valueOf(i6), Integer.valueOf(this.f5355l))));
        }
        if (this.f5343f == null || z5 == this.f5357m) {
            return;
        }
        v0(false);
        F0();
        s0();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        EditText editText = this.f5343f;
        if (editText != null) {
            Rect rect = this.Q;
            com.google.android.material.internal.b.a(this, editText, rect);
            l0(rect);
            if (this.B) {
                this.H0.Y(this.f5343f.getTextSize());
                int gravity = this.f5343f.getGravity();
                this.H0.Q((gravity & (-113)) | 48);
                this.H0.X(gravity);
                this.H0.M(r(rect));
                this.H0.U(u(rect));
                this.H0.I();
                if (!A() || this.G0) {
                    return;
                }
                T();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        boolean t02 = t0();
        boolean r02 = r0();
        if (t02 || r02) {
            this.f5343f.post(new c());
        }
        x0();
        A0();
        D0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.e());
        setError(hVar.f5390c);
        if (hVar.f5391d) {
            this.f5350i0.post(new b());
        }
        setHint(hVar.f5392e);
        setHelperText(hVar.f5393f);
        setPlaceholderText(hVar.f5394g);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.f5351j.k()) {
            hVar.f5390c = getError();
        }
        hVar.f5391d = I() && this.f5350i0.isChecked();
        hVar.f5392e = getHint();
        hVar.f5393f = getHelperText();
        hVar.f5394g = getPlaceholderText();
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s0() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.f5343f;
        if (editText == null || this.J != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (f1.a(background)) {
            background = background.mutate();
        }
        if (this.f5351j.k()) {
            currentTextColor = this.f5351j.o();
        } else if (!this.f5357m || (textView = this.f5359n) == null) {
            x.b.c(background);
            this.f5343f.refreshDrawableState();
            return;
        } else {
            currentTextColor = textView.getCurrentTextColor();
        }
        background.setColorFilter(androidx.appcompat.widget.j.e(currentTextColor, PorterDuff.Mode.SRC_IN));
    }

    public void setBoxBackgroundColor(int i6) {
        if (this.P != i6) {
            this.P = i6;
            this.B0 = i6;
            this.D0 = i6;
            this.E0 = i6;
            j();
        }
    }

    public void setBoxBackgroundColorResource(int i6) {
        setBoxBackgroundColor(u.c.a(getContext(), i6));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.B0 = defaultColor;
        this.P = defaultColor;
        this.C0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.D0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.E0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        j();
    }

    public void setBoxBackgroundMode(int i6) {
        if (i6 == this.J) {
            return;
        }
        this.J = i6;
        if (this.f5343f != null) {
            S();
        }
    }

    public void setBoxStrokeColor(int i6) {
        if (this.f5384z0 != i6) {
            this.f5384z0 = i6;
            F0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        int defaultColor;
        if (!colorStateList.isStateful()) {
            if (this.f5384z0 != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            F0();
        }
        this.f5380x0 = colorStateList.getDefaultColor();
        this.F0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f5382y0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        defaultColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.f5384z0 = defaultColor;
        F0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.A0 != colorStateList) {
            this.A0 = colorStateList;
            F0();
        }
    }

    public void setBoxStrokeWidth(int i6) {
        this.M = i6;
        F0();
    }

    public void setBoxStrokeWidthFocused(int i6) {
        this.N = i6;
        F0();
    }

    public void setBoxStrokeWidthFocusedResource(int i6) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i6));
    }

    public void setBoxStrokeWidthResource(int i6) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i6));
    }

    public void setCounterEnabled(boolean z5) {
        if (this.f5353k != z5) {
            if (z5) {
                n0 n0Var = new n0(getContext());
                this.f5359n = n0Var;
                n0Var.setId(u2.e.textinput_counter);
                Typeface typeface = this.T;
                if (typeface != null) {
                    this.f5359n.setTypeface(typeface);
                }
                this.f5359n.setMaxLines(1);
                this.f5351j.d(this.f5359n, 2);
                e0.g.d((ViewGroup.MarginLayoutParams) this.f5359n.getLayoutParams(), getResources().getDimensionPixelOffset(u2.c.mtrl_textinput_counter_margin_start));
                p0();
                m0();
            } else {
                this.f5351j.z(this.f5359n, 2);
                this.f5359n = null;
            }
            this.f5353k = z5;
        }
    }

    public void setCounterMaxLength(int i6) {
        if (this.f5355l != i6) {
            if (i6 <= 0) {
                i6 = -1;
            }
            this.f5355l = i6;
            if (this.f5353k) {
                m0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i6) {
        if (this.f5361o != i6) {
            this.f5361o = i6;
            p0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f5377w != colorStateList) {
            this.f5377w = colorStateList;
            p0();
        }
    }

    public void setCounterTextAppearance(int i6) {
        if (this.f5363p != i6) {
            this.f5363p = i6;
            p0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f5375v != colorStateList) {
            this.f5375v = colorStateList;
            p0();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f5376v0 = colorStateList;
        this.f5378w0 = colorStateList;
        if (this.f5343f != null) {
            v0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        U(this, z5);
        super.setEnabled(z5);
    }

    public void setEndIconActivated(boolean z5) {
        this.f5350i0.setActivated(z5);
    }

    public void setEndIconCheckable(boolean z5) {
        this.f5350i0.setCheckable(z5);
    }

    public void setEndIconContentDescription(int i6) {
        setEndIconContentDescription(i6 != 0 ? getResources().getText(i6) : null);
    }

    public void setEndIconDrawable(int i6) {
        setEndIconDrawable(i6 != 0 ? e.b.d(getContext(), i6) : null);
    }

    public void setEndIconMode(int i6) {
        int i7 = this.f5346g0;
        this.f5346g0 = i6;
        C(i7);
        setEndIconVisible(i6 != 0);
        if (getEndIconDelegate().b(this.J)) {
            getEndIconDelegate().a();
            m();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.J + " is not supported by the end icon mode " + i6);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        c0(this.f5350i0, onClickListener, this.f5368r0);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f5368r0 = onLongClickListener;
        d0(this.f5350i0, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.f5354k0 != colorStateList) {
            this.f5354k0 = colorStateList;
            this.f5356l0 = true;
            m();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.f5358m0 != mode) {
            this.f5358m0 = mode;
            this.f5360n0 = true;
            m();
        }
    }

    public void setEndIconVisible(boolean z5) {
        if (K() != z5) {
            this.f5350i0.setVisibility(z5 ? 0 : 8);
            D0();
            r0();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f5351j.x()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f5351j.t();
        } else {
            this.f5351j.M(charSequence);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f5351j.B(charSequence);
    }

    public void setErrorEnabled(boolean z5) {
        this.f5351j.C(z5);
    }

    public void setErrorIconDrawable(int i6) {
        setErrorIconDrawable(i6 != 0 ? e.b.d(getContext(), i6) : null);
        W();
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        c0(this.f5372t0, onClickListener, this.f5370s0);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f5370s0 = onLongClickListener;
        d0(this.f5372t0, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f5374u0 = colorStateList;
        Drawable drawable = this.f5372t0.getDrawable();
        if (drawable != null) {
            drawable = x.b.r(drawable).mutate();
            x.b.o(drawable, colorStateList);
        }
        if (this.f5372t0.getDrawable() != drawable) {
            this.f5372t0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f5372t0.getDrawable();
        if (drawable != null) {
            drawable = x.b.r(drawable).mutate();
            x.b.p(drawable, mode);
        }
        if (this.f5372t0.getDrawable() != drawable) {
            this.f5372t0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i6) {
        this.f5351j.D(i6);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f5351j.E(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z5) {
        if (this.I0 != z5) {
            this.I0 = z5;
            v0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (M()) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!M()) {
            setHelperTextEnabled(true);
        }
        this.f5351j.N(charSequence);
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f5351j.H(colorStateList);
    }

    public void setHelperTextEnabled(boolean z5) {
        this.f5351j.G(z5);
    }

    public void setHelperTextTextAppearance(int i6) {
        this.f5351j.F(i6);
    }

    public void setHint(int i6) {
        setHint(i6 != 0 ? getResources().getText(i6) : null);
    }

    public void setHintAnimationEnabled(boolean z5) {
        this.J0 = z5;
    }

    public void setHintEnabled(boolean z5) {
        if (z5 != this.B) {
            this.B = z5;
            if (z5) {
                CharSequence hint = this.f5343f.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.C)) {
                        setHint(hint);
                    }
                    this.f5343f.setHint((CharSequence) null);
                }
                this.D = true;
            } else {
                this.D = false;
                if (!TextUtils.isEmpty(this.C) && TextUtils.isEmpty(this.f5343f.getHint())) {
                    this.f5343f.setHint(this.C);
                }
                setHintInternal(null);
            }
            if (this.f5343f != null) {
                u0();
            }
        }
    }

    public void setHintTextAppearance(int i6) {
        this.H0.N(i6);
        this.f5378w0 = this.H0.q();
        if (this.f5343f != null) {
            v0(false);
            u0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f5378w0 != colorStateList) {
            if (this.f5376v0 == null) {
                this.H0.P(colorStateList);
            }
            this.f5378w0 = colorStateList;
            if (this.f5343f != null) {
                v0(false);
            }
        }
    }

    public void setMaxWidth(int i6) {
        this.f5349i = i6;
        EditText editText = this.f5343f;
        if (editText == null || i6 == -1) {
            return;
        }
        editText.setMaxWidth(i6);
    }

    public void setMaxWidthResource(int i6) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i6));
    }

    public void setMinWidth(int i6) {
        this.f5347h = i6;
        EditText editText = this.f5343f;
        if (editText == null || i6 == -1) {
            return;
        }
        editText.setMinWidth(i6);
    }

    public void setMinWidthResource(int i6) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i6));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i6) {
        setPasswordVisibilityToggleContentDescription(i6 != 0 ? getResources().getText(i6) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i6) {
        setPasswordVisibilityToggleDrawable(i6 != 0 ? e.b.d(getContext(), i6) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z5) {
        if (z5 && this.f5346g0 != 1) {
            setEndIconMode(1);
        } else if (z5) {
        } else {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f5354k0 = colorStateList;
        this.f5356l0 = true;
        m();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f5358m0 = mode;
        this.f5360n0 = true;
        m();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f5367r && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f5367r) {
                setPlaceholderTextEnabled(true);
            }
            this.f5365q = charSequence;
        }
        y0();
    }

    public void setPlaceholderTextAppearance(int i6) {
        this.f5373u = i6;
        TextView textView = this.f5369s;
        if (textView != null) {
            v.n(textView, i6);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f5371t != colorStateList) {
            this.f5371t = colorStateList;
            TextView textView = this.f5369s;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f5379x = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f5381y.setText(charSequence);
        B0();
    }

    public void setPrefixTextAppearance(int i6) {
        v.n(this.f5381y, i6);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f5381y.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z5) {
        this.U.setCheckable(z5);
    }

    public void setStartIconContentDescription(int i6) {
        setStartIconContentDescription(i6 != 0 ? getResources().getText(i6) : null);
    }

    public void setStartIconDrawable(int i6) {
        setStartIconDrawable(i6 != 0 ? e.b.d(getContext(), i6) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        c0(this.U, onClickListener, this.f5342e0);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f5342e0 = onLongClickListener;
        d0(this.U, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            this.W = true;
            o();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.f5334a0 != mode) {
            this.f5334a0 = mode;
            this.f5336b0 = true;
            o();
        }
    }

    public void setStartIconVisible(boolean z5) {
        if (Q() != z5) {
            this.U.setVisibility(z5 ? 0 : 8);
            A0();
            r0();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f5383z = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.A.setText(charSequence);
        E0();
    }

    public void setSuffixTextAppearance(int i6) {
        v.n(this.A, i6);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.A.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f5343f;
        if (editText != null) {
            b0.l0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.T) {
            this.T = typeface;
            this.H0.g0(typeface);
            this.f5351j.J(typeface);
            TextView textView = this.f5359n;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v0(boolean z5) {
        w0(z5, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v150 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47, types: [int, boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i6) {
        super(i3.a.c(context, attributeSet, i6, r9), attributeSet, i6);
        int i7;
        ?? r22;
        int colorForState;
        int i8 = N0;
        this.f5347h = -1;
        this.f5349i = -1;
        this.f5351j = new com.google.android.material.textfield.f(this);
        this.Q = new Rect();
        this.R = new Rect();
        this.S = new RectF();
        this.f5344f0 = new LinkedHashSet();
        this.f5346g0 = 0;
        SparseArray sparseArray = new SparseArray();
        this.f5348h0 = sparseArray;
        this.f5352j0 = new LinkedHashSet();
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a(this);
        this.H0 = aVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f5335b = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(frameLayout);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.f5337c = linearLayout;
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        frameLayout.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.f5339d = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout.addView(linearLayout2);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f5341e = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = v2.a.f13673a;
        aVar.f0(timeInterpolator);
        aVar.c0(timeInterpolator);
        aVar.Q(8388659);
        int[] iArr = u2.j.D4;
        int i9 = u2.j.Y4;
        int i10 = u2.j.W4;
        int i11 = u2.j.f13520l5;
        int i12 = u2.j.q5;
        int i13 = u2.j.u5;
        c2 i14 = com.google.android.material.internal.j.i(context2, attributeSet, iArr, i6, i8, i9, i10, i11, i12, i13);
        this.B = i14.a(u2.j.t5, true);
        setHint(i14.p(u2.j.I4));
        this.J0 = i14.a(u2.j.s5, true);
        this.I0 = i14.a(u2.j.n5, true);
        int i15 = u2.j.H4;
        if (i14.s(i15)) {
            i7 = -1;
            setMinWidth(i14.f(i15, -1));
        } else {
            i7 = -1;
        }
        int i16 = u2.j.G4;
        if (i14.s(i16)) {
            setMaxWidth(i14.f(i16, i7));
        }
        this.G = h3.k.e(context2, attributeSet, i6, i8).m();
        this.H = context2.getResources().getDimensionPixelOffset(u2.c.mtrl_textinput_box_label_cutout_padding);
        this.K = i14.e(u2.j.L4, 0);
        this.M = i14.f(u2.j.S4, context2.getResources().getDimensionPixelSize(u2.c.mtrl_textinput_box_stroke_width_default));
        this.N = i14.f(u2.j.T4, context2.getResources().getDimensionPixelSize(u2.c.mtrl_textinput_box_stroke_width_focused));
        this.L = this.M;
        float d6 = i14.d(u2.j.P4, -1.0f);
        float d7 = i14.d(u2.j.O4, -1.0f);
        float d8 = i14.d(u2.j.M4, -1.0f);
        float d9 = i14.d(u2.j.N4, -1.0f);
        k.b v5 = this.G.v();
        if (d6 >= 0.0f) {
            v5.A(d6);
        }
        if (d7 >= 0.0f) {
            v5.E(d7);
        }
        if (d8 >= 0.0f) {
            v5.w(d8);
        }
        if (d9 >= 0.0f) {
            v5.s(d9);
        }
        this.G = v5.m();
        ColorStateList b6 = e3.c.b(context2, i14, u2.j.J4);
        if (b6 != null) {
            int defaultColor = b6.getDefaultColor();
            this.B0 = defaultColor;
            this.P = defaultColor;
            if (b6.isStateful()) {
                this.C0 = b6.getColorForState(new int[]{-16842910}, -1);
                this.D0 = b6.getColorForState(new int[]{16842908, 16842910}, -1);
                colorForState = b6.getColorForState(new int[]{16843623, 16842910}, -1);
            } else {
                this.D0 = this.B0;
                ColorStateList c6 = e.b.c(context2, u2.b.mtrl_filled_background_color);
                this.C0 = c6.getColorForState(new int[]{-16842910}, -1);
                colorForState = c6.getColorForState(new int[]{16843623}, -1);
            }
            this.E0 = colorForState;
        } else {
            this.P = 0;
            this.B0 = 0;
            this.C0 = 0;
            this.D0 = 0;
            this.E0 = 0;
        }
        int i17 = u2.j.F4;
        if (i14.s(i17)) {
            ColorStateList c7 = i14.c(i17);
            this.f5378w0 = c7;
            this.f5376v0 = c7;
        }
        int i18 = u2.j.Q4;
        ColorStateList b7 = e3.c.b(context2, i14, i18);
        this.f5384z0 = i14.b(i18, 0);
        this.f5380x0 = u.c.a(context2, u2.b.mtrl_textinput_default_box_stroke_color);
        this.F0 = u.c.a(context2, u2.b.mtrl_textinput_disabled_color);
        this.f5382y0 = u.c.a(context2, u2.b.mtrl_textinput_hovered_box_stroke_color);
        if (b7 != null) {
            setBoxStrokeColorStateList(b7);
        }
        int i19 = u2.j.R4;
        if (i14.s(i19)) {
            setBoxStrokeErrorColor(e3.c.b(context2, i14, i19));
        }
        if (i14.n(i13, -1) != -1) {
            r22 = 0;
            setHintTextAppearance(i14.n(i13, 0));
        } else {
            r22 = 0;
        }
        int n5 = i14.n(i11, r22);
        CharSequence p5 = i14.p(u2.j.f13485g5);
        boolean a6 = i14.a(u2.j.f13492h5, r22);
        LayoutInflater from = LayoutInflater.from(getContext());
        int i20 = u2.g.design_text_input_end_icon;
        CheckableImageButton checkableImageButton = (CheckableImageButton) from.inflate(i20, linearLayout2, (boolean) r22);
        this.f5372t0 = checkableImageButton;
        checkableImageButton.setId(u2.e.text_input_error_icon);
        checkableImageButton.setVisibility(8);
        if (e3.c.g(context2)) {
            e0.g.d((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), r22);
        }
        int i21 = u2.j.f13499i5;
        if (i14.s(i21)) {
            setErrorIconDrawable(i14.g(i21));
        }
        int i22 = u2.j.f13506j5;
        if (i14.s(i22)) {
            setErrorIconTintList(e3.c.b(context2, i14, i22));
        }
        int i23 = u2.j.f13513k5;
        if (i14.s(i23)) {
            setErrorIconTintMode(com.google.android.material.internal.l.e(i14.k(i23, -1), null));
        }
        checkableImageButton.setContentDescription(getResources().getText(u2.h.error_icon_content_description));
        b0.u0(checkableImageButton, 2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int n6 = i14.n(i12, 0);
        boolean a7 = i14.a(u2.j.p5, false);
        CharSequence p6 = i14.p(u2.j.o5);
        int n7 = i14.n(u2.j.C5, 0);
        CharSequence p7 = i14.p(u2.j.B5);
        int n8 = i14.n(u2.j.F5, 0);
        CharSequence p8 = i14.p(u2.j.E5);
        int n9 = i14.n(u2.j.N5, 0);
        CharSequence p9 = i14.p(u2.j.M5);
        boolean a8 = i14.a(u2.j.U4, false);
        setCounterMaxLength(i14.k(u2.j.V4, -1));
        this.f5363p = i14.n(i9, 0);
        this.f5361o = i14.n(i10, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(u2.g.design_text_input_start_icon, (ViewGroup) linearLayout, false);
        this.U = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        if (e3.c.g(context2)) {
            e0.g.c((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams(), 0);
        }
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        int i24 = u2.j.J5;
        if (i14.s(i24)) {
            setStartIconDrawable(i14.g(i24));
            int i25 = u2.j.I5;
            if (i14.s(i25)) {
                setStartIconContentDescription(i14.p(i25));
            }
            setStartIconCheckable(i14.a(u2.j.H5, true));
        }
        int i26 = u2.j.K5;
        if (i14.s(i26)) {
            setStartIconTintList(e3.c.b(context2, i14, i26));
        }
        int i27 = u2.j.L5;
        if (i14.s(i27)) {
            setStartIconTintMode(com.google.android.material.internal.l.e(i14.k(i27, -1), null));
        }
        setBoxBackgroundMode(i14.k(u2.j.K4, 0));
        CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(i20, (ViewGroup) frameLayout2, false);
        this.f5350i0 = checkableImageButton3;
        frameLayout2.addView(checkableImageButton3);
        checkableImageButton3.setVisibility(8);
        if (e3.c.g(context2)) {
            e0.g.d((ViewGroup.MarginLayoutParams) checkableImageButton3.getLayoutParams(), 0);
        }
        sparseArray.append(-1, new com.google.android.material.textfield.b(this));
        sparseArray.append(0, new com.google.android.material.textfield.h(this));
        sparseArray.append(1, new i(this));
        sparseArray.append(2, new com.google.android.material.textfield.a(this));
        sparseArray.append(3, new com.google.android.material.textfield.d(this));
        int i28 = u2.j.f13464d5;
        if (i14.s(i28)) {
            setEndIconMode(i14.k(i28, 0));
            int i29 = u2.j.f13457c5;
            if (i14.s(i29)) {
                setEndIconDrawable(i14.g(i29));
            }
            int i30 = u2.j.f13450b5;
            if (i14.s(i30)) {
                setEndIconContentDescription(i14.p(i30));
            }
            setEndIconCheckable(i14.a(u2.j.f13443a5, true));
        } else {
            int i31 = u2.j.y5;
            if (i14.s(i31)) {
                setEndIconMode(i14.a(i31, false) ? 1 : 0);
                setEndIconDrawable(i14.g(u2.j.x5));
                setEndIconContentDescription(i14.p(u2.j.w5));
                int i32 = u2.j.z5;
                if (i14.s(i32)) {
                    setEndIconTintList(e3.c.b(context2, i14, i32));
                }
                int i33 = u2.j.A5;
                if (i14.s(i33)) {
                    setEndIconTintMode(com.google.android.material.internal.l.e(i14.k(i33, -1), null));
                }
            }
        }
        if (!i14.s(u2.j.y5)) {
            int i34 = u2.j.f13471e5;
            if (i14.s(i34)) {
                setEndIconTintList(e3.c.b(context2, i14, i34));
            }
            int i35 = u2.j.f13478f5;
            if (i14.s(i35)) {
                setEndIconTintMode(com.google.android.material.internal.l.e(i14.k(i35, -1), null));
            }
        }
        n0 n0Var = new n0(context2);
        this.f5381y = n0Var;
        n0Var.setId(u2.e.textinput_prefix_text);
        n0Var.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        b0.n0(n0Var, 1);
        linearLayout.addView(checkableImageButton2);
        linearLayout.addView(n0Var);
        n0 n0Var2 = new n0(context2);
        this.A = n0Var2;
        n0Var2.setId(u2.e.textinput_suffix_text);
        n0Var2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        b0.n0(n0Var2, 1);
        linearLayout2.addView(n0Var2);
        linearLayout2.addView(checkableImageButton);
        linearLayout2.addView(frameLayout2);
        setHelperTextEnabled(a7);
        setHelperText(p6);
        setHelperTextTextAppearance(n6);
        setErrorEnabled(a6);
        setErrorTextAppearance(n5);
        setErrorContentDescription(p5);
        setCounterTextAppearance(this.f5363p);
        setCounterOverflowTextAppearance(this.f5361o);
        setPlaceholderText(p7);
        setPlaceholderTextAppearance(n7);
        setPrefixText(p8);
        setPrefixTextAppearance(n8);
        setSuffixText(p9);
        setSuffixTextAppearance(n9);
        int i36 = u2.j.m5;
        if (i14.s(i36)) {
            setErrorTextColor(i14.c(i36));
        }
        int i37 = u2.j.r5;
        if (i14.s(i37)) {
            setHelperTextColor(i14.c(i37));
        }
        int i38 = u2.j.v5;
        if (i14.s(i38)) {
            setHintTextColor(i14.c(i38));
        }
        int i39 = u2.j.Z4;
        if (i14.s(i39)) {
            setCounterTextColor(i14.c(i39));
        }
        int i40 = u2.j.X4;
        if (i14.s(i40)) {
            setCounterOverflowTextColor(i14.c(i40));
        }
        int i41 = u2.j.D5;
        if (i14.s(i41)) {
            setPlaceholderTextColor(i14.c(i41));
        }
        int i42 = u2.j.G5;
        if (i14.s(i42)) {
            setPrefixTextColor(i14.c(i42));
        }
        int i43 = u2.j.O5;
        if (i14.s(i43)) {
            setSuffixTextColor(i14.c(i43));
        }
        setCounterEnabled(a8);
        setEnabled(i14.a(u2.j.E4, true));
        i14.w();
        b0.u0(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            b0.v0(this, 1);
        }
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f5350i0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f5350i0.setImageDrawable(drawable);
        V();
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f5372t0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f5351j.x());
    }

    public void setHint(CharSequence charSequence) {
        if (this.B) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f5350i0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f5350i0.setImageDrawable(drawable);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.U.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.U.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            Y();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }
}
