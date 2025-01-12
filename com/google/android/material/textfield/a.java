package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.google.android.material.textfield.e {

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f5395d;

    /* renamed from: e  reason: collision with root package name */
    private final View.OnFocusChangeListener f5396e;

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.f f5397f;

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.g f5398g;

    /* renamed from: h  reason: collision with root package name */
    private AnimatorSet f5399h;

    /* renamed from: i  reason: collision with root package name */
    private ValueAnimator f5400i;

    /* renamed from: com.google.android.material.textfield.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0049a implements TextWatcher {
        C0049a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f5442a.getSuffixText() != null) {
                return;
            }
            a aVar = a.this;
            aVar.i(aVar.f5442a.hasFocus() && a.l(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z5) {
            boolean z6 = true;
            a.this.i(((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z5) ? false : false);
        }
    }

    /* loaded from: classes.dex */
    class c implements TextInputLayout.f {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.hasFocus() && a.l(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f5396e);
            editText.removeTextChangedListener(a.this.f5395d);
            editText.addTextChangedListener(a.this.f5395d);
        }
    }

    /* loaded from: classes.dex */
    class d implements TextInputLayout.g {

        /* renamed from: com.google.android.material.textfield.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0050a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ EditText f5405a;

            RunnableC0050a(EditText editText) {
                this.f5405a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f5405a.removeTextChangedListener(a.this.f5395d);
            }
        }

        d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i6) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i6 != 2) {
                return;
            }
            editText.post(new RunnableC0050a(editText));
            if (editText.getOnFocusChangeListener() == a.this.f5396e) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.f5442a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.f5442a.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f5442a.setEndIconVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f5442a.setEndIconVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f5444c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f5444c.setScaleX(floatValue);
            a.this.f5444c.setScaleY(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f5395d = new C0049a();
        this.f5396e = new b();
        this.f5397f = new c();
        this.f5398g = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z5) {
        boolean z6 = this.f5442a.K() == z5;
        if (z5 && !this.f5399h.isRunning()) {
            this.f5400i.cancel();
            this.f5399h.start();
            if (z6) {
                this.f5399h.end();
            }
        } else if (z5) {
        } else {
            this.f5399h.cancel();
            this.f5400i.start();
            if (z6) {
                this.f5400i.end();
            }
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(v2.a.f13673a);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new h());
        return ofFloat;
    }

    private ValueAnimator k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(v2.a.f13676d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new i());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(Editable editable) {
        return editable.length() > 0;
    }

    private void m() {
        ValueAnimator k6 = k();
        ValueAnimator j6 = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f5399h = animatorSet;
        animatorSet.playTogether(k6, j6);
        this.f5399h.addListener(new f());
        ValueAnimator j7 = j(1.0f, 0.0f);
        this.f5400i = j7;
        j7.addListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        this.f5442a.setEndIconDrawable(e.b.d(this.f5443b, u2.d.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.f5442a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(u2.h.clear_text_end_icon_content_description));
        this.f5442a.setEndIconOnClickListener(new e());
        this.f5442a.e(this.f5397f);
        this.f5442a.f(this.f5398g);
        m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void c(boolean z5) {
        if (this.f5442a.getSuffixText() == null) {
            return;
        }
        i(z5);
    }
}
