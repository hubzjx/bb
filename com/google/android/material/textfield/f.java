package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.n0;
import androidx.core.widget.v;
import e0.b0;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5445a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f5446b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f5447c;

    /* renamed from: d  reason: collision with root package name */
    private int f5448d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f5449e;

    /* renamed from: f  reason: collision with root package name */
    private Animator f5450f;

    /* renamed from: g  reason: collision with root package name */
    private final float f5451g;

    /* renamed from: h  reason: collision with root package name */
    private int f5452h;

    /* renamed from: i  reason: collision with root package name */
    private int f5453i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f5454j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5455k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f5456l;

    /* renamed from: m  reason: collision with root package name */
    private CharSequence f5457m;

    /* renamed from: n  reason: collision with root package name */
    private int f5458n;

    /* renamed from: o  reason: collision with root package name */
    private ColorStateList f5459o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f5460p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f5461q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f5462r;

    /* renamed from: s  reason: collision with root package name */
    private int f5463s;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f5464t;

    /* renamed from: u  reason: collision with root package name */
    private Typeface f5465u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f5466a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f5467b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f5468c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TextView f5469d;

        a(int i6, TextView textView, int i7, TextView textView2) {
            this.f5466a = i6;
            this.f5467b = textView;
            this.f5468c = i7;
            this.f5469d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f5452h = this.f5466a;
            f.this.f5450f = null;
            TextView textView = this.f5467b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f5468c == 1 && f.this.f5456l != null) {
                    f.this.f5456l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f5469d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f5469d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f5469d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public f(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f5445a = context;
        this.f5446b = textInputLayout;
        this.f5451g = context.getResources().getDimensionPixelSize(u2.c.design_textinput_caption_translate_y);
    }

    private void A(int i6, int i7) {
        TextView l6;
        TextView l7;
        if (i6 == i7) {
            return;
        }
        if (i7 != 0 && (l7 = l(i7)) != null) {
            l7.setVisibility(0);
            l7.setAlpha(1.0f);
        }
        if (i6 != 0 && (l6 = l(i6)) != null) {
            l6.setVisibility(4);
            if (i6 == 1) {
                l6.setText((CharSequence) null);
            }
        }
        this.f5452h = i7;
    }

    private void I(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void K(ViewGroup viewGroup, int i6) {
        if (i6 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean L(TextView textView, CharSequence charSequence) {
        return b0.R(this.f5446b) && this.f5446b.isEnabled() && !(this.f5453i == this.f5452h && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void O(int i6, int i7, boolean z5) {
        if (i6 == i7) {
            return;
        }
        if (z5) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f5450f = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.f5461q, this.f5462r, 2, i6, i7);
            h(arrayList, this.f5455k, this.f5456l, 1, i6, i7);
            v2.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i7, l(i6), i6, l(i7)));
            animatorSet.start();
        } else {
            A(i6, i7);
        }
        this.f5446b.s0();
        this.f5446b.v0(z5);
        this.f5446b.F0();
    }

    private boolean f() {
        return (this.f5447c == null || this.f5446b.getEditText() == null) ? false : true;
    }

    private void h(List list, boolean z5, TextView textView, int i6, int i7, int i8) {
        if (textView == null || !z5) {
            return;
        }
        if (i6 == i8 || i6 == i7) {
            list.add(i(textView, i8 == i6));
            if (i8 == i6) {
                list.add(j(textView));
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z5) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z5 ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(v2.a.f13673a);
        return ofFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f5451g, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(v2.a.f13676d);
        return ofFloat;
    }

    private TextView l(int i6) {
        if (i6 != 1) {
            if (i6 != 2) {
                return null;
            }
            return this.f5462r;
        }
        return this.f5456l;
    }

    private int s(boolean z5, int i6, int i7) {
        return z5 ? this.f5445a.getResources().getDimensionPixelSize(i6) : i7;
    }

    private boolean v(int i6) {
        return (i6 != 1 || this.f5456l == null || TextUtils.isEmpty(this.f5454j)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(CharSequence charSequence) {
        this.f5457m = charSequence;
        TextView textView = this.f5456l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(boolean z5) {
        if (this.f5455k == z5) {
            return;
        }
        g();
        if (z5) {
            n0 n0Var = new n0(this.f5445a);
            this.f5456l = n0Var;
            n0Var.setId(u2.e.textinput_error);
            this.f5456l.setTextAlignment(5);
            Typeface typeface = this.f5465u;
            if (typeface != null) {
                this.f5456l.setTypeface(typeface);
            }
            D(this.f5458n);
            E(this.f5459o);
            B(this.f5457m);
            this.f5456l.setVisibility(4);
            b0.n0(this.f5456l, 1);
            d(this.f5456l, 0);
        } else {
            t();
            z(this.f5456l, 0);
            this.f5456l = null;
            this.f5446b.s0();
            this.f5446b.F0();
        }
        this.f5455k = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(int i6) {
        this.f5458n = i6;
        TextView textView = this.f5456l;
        if (textView != null) {
            this.f5446b.e0(textView, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(ColorStateList colorStateList) {
        this.f5459o = colorStateList;
        TextView textView = this.f5456l;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(int i6) {
        this.f5463s = i6;
        TextView textView = this.f5462r;
        if (textView != null) {
            v.n(textView, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(boolean z5) {
        if (this.f5461q == z5) {
            return;
        }
        g();
        if (z5) {
            n0 n0Var = new n0(this.f5445a);
            this.f5462r = n0Var;
            n0Var.setId(u2.e.textinput_helper_text);
            this.f5462r.setTextAlignment(5);
            Typeface typeface = this.f5465u;
            if (typeface != null) {
                this.f5462r.setTypeface(typeface);
            }
            this.f5462r.setVisibility(4);
            b0.n0(this.f5462r, 1);
            F(this.f5463s);
            H(this.f5464t);
            d(this.f5462r, 1);
        } else {
            u();
            z(this.f5462r, 1);
            this.f5462r = null;
            this.f5446b.s0();
            this.f5446b.F0();
        }
        this.f5461q = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(ColorStateList colorStateList) {
        this.f5464t = colorStateList;
        TextView textView = this.f5462r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(Typeface typeface) {
        if (typeface != this.f5465u) {
            this.f5465u = typeface;
            I(this.f5456l, typeface);
            I(this.f5462r, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(CharSequence charSequence) {
        g();
        this.f5454j = charSequence;
        this.f5456l.setText(charSequence);
        int i6 = this.f5452h;
        if (i6 != 1) {
            this.f5453i = 1;
        }
        O(i6, this.f5453i, L(this.f5456l, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(CharSequence charSequence) {
        g();
        this.f5460p = charSequence;
        this.f5462r.setText(charSequence);
        int i6 = this.f5452h;
        if (i6 != 2) {
            this.f5453i = 2;
        }
        O(i6, this.f5453i, L(this.f5462r, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView, int i6) {
        if (this.f5447c == null && this.f5449e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f5445a);
            this.f5447c = linearLayout;
            linearLayout.setOrientation(0);
            this.f5446b.addView(this.f5447c, -1, -2);
            this.f5449e = new FrameLayout(this.f5445a);
            this.f5447c.addView(this.f5449e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f5446b.getEditText() != null) {
                e();
            }
        }
        if (w(i6)) {
            this.f5449e.setVisibility(0);
            this.f5449e.addView(textView);
        } else {
            this.f5447c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f5447c.setVisibility(0);
        this.f5448d++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            EditText editText = this.f5446b.getEditText();
            boolean g6 = e3.c.g(this.f5445a);
            LinearLayout linearLayout = this.f5447c;
            int i6 = u2.c.material_helper_text_font_1_3_padding_horizontal;
            b0.x0(linearLayout, s(g6, i6, b0.G(editText)), s(g6, u2.c.material_helper_text_font_1_3_padding_top, this.f5445a.getResources().getDimensionPixelSize(u2.c.material_helper_text_default_padding_top)), s(g6, i6, b0.F(editText)), 0);
        }
    }

    void g() {
        Animator animator = this.f5450f;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return v(this.f5453i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence m() {
        return this.f5457m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence n() {
        return this.f5454j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        TextView textView = this.f5456l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList p() {
        TextView textView = this.f5456l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence q() {
        return this.f5460p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        TextView textView = this.f5462r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        this.f5454j = null;
        g();
        if (this.f5452h == 1) {
            this.f5453i = (!this.f5461q || TextUtils.isEmpty(this.f5460p)) ? 0 : 2;
        }
        O(this.f5452h, this.f5453i, L(this.f5456l, null));
    }

    void u() {
        g();
        int i6 = this.f5452h;
        if (i6 == 2) {
            this.f5453i = 0;
        }
        O(i6, this.f5453i, L(this.f5462r, null));
    }

    boolean w(int i6) {
        return i6 == 0 || i6 == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        return this.f5455k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        return this.f5461q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(TextView textView, int i6) {
        ViewGroup viewGroup;
        if (this.f5447c == null) {
            return;
        }
        if (!w(i6) || (viewGroup = this.f5449e) == null) {
            viewGroup = this.f5447c;
        }
        viewGroup.removeView(textView);
        int i7 = this.f5448d - 1;
        this.f5448d = i7;
        K(this.f5447c, i7);
    }
}
