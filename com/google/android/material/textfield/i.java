package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends e {

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f5475d;

    /* renamed from: e  reason: collision with root package name */
    private final TextInputLayout.f f5476e;

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.g f5477f;

    /* loaded from: classes.dex */
    class a extends com.google.android.material.internal.i {
        a() {
        }

        @Override // com.google.android.material.internal.i, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
            i iVar = i.this;
            iVar.f5444c.setChecked(!iVar.g());
        }
    }

    /* loaded from: classes.dex */
    class b implements TextInputLayout.f {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            i iVar = i.this;
            iVar.f5444c.setChecked(!iVar.g());
            editText.removeTextChangedListener(i.this.f5475d);
            editText.addTextChangedListener(i.this.f5475d);
        }
    }

    /* loaded from: classes.dex */
    class c implements TextInputLayout.g {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ EditText f5481a;

            a(EditText editText) {
                this.f5481a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f5481a.removeTextChangedListener(i.this.f5475d);
            }
        }

        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i6) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i6 != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = i.this.f5442a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            editText.setTransformationMethod(i.this.g() ? null : PasswordTransformationMethod.getInstance());
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            i.this.f5442a.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f5475d = new a();
        this.f5476e = new b();
        this.f5477f = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        EditText editText = this.f5442a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        this.f5442a.setEndIconDrawable(e.b.d(this.f5443b, u2.d.design_password_eye));
        TextInputLayout textInputLayout = this.f5442a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(u2.h.password_toggle_content_description));
        this.f5442a.setEndIconOnClickListener(new d());
        this.f5442a.e(this.f5476e);
        this.f5442a.f(this.f5477f);
        EditText editText = this.f5442a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
