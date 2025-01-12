package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import e0.b0;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: b  reason: collision with root package name */
    private final Chip f5484b;

    /* renamed from: c  reason: collision with root package name */
    private final TextInputLayout f5485c;

    /* renamed from: d  reason: collision with root package name */
    private final EditText f5486d;

    /* renamed from: e  reason: collision with root package name */
    private TextWatcher f5487e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f5488f;

    /* loaded from: classes.dex */
    private class b extends com.google.android.material.internal.i {
        private b() {
        }

        @Override // com.google.android.material.internal.i, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f5484b.setText(ChipTextInputComboView.this.d("00"));
            } else {
                ChipTextInputComboView.this.f5484b.setText(ChipTextInputComboView.this.d(editable));
            }
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(CharSequence charSequence) {
        return e.e(getResources(), charSequence);
    }

    private void h() {
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = getContext().getResources().getConfiguration().getLocales();
            this.f5486d.setImeHintLocales(locales);
        }
    }

    public void c(InputFilter inputFilter) {
        InputFilter[] filters = this.f5486d.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.f5486d.setFilters(inputFilterArr);
    }

    public TextInputLayout e() {
        return this.f5485c;
    }

    public void f(e0.a aVar) {
        b0.l0(this.f5484b, aVar);
    }

    public void g(CharSequence charSequence) {
        this.f5484b.setText(d(charSequence));
        if (TextUtils.isEmpty(this.f5486d.getText())) {
            return;
        }
        this.f5486d.removeTextChangedListener(this.f5487e);
        this.f5486d.setText((CharSequence) null);
        this.f5486d.addTextChangedListener(this.f5487e);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f5484b.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) {
        this.f5484b.setChecked(z5);
        this.f5486d.setVisibility(z5 ? 0 : 4);
        this.f5484b.setVisibility(z5 ? 8 : 0);
        if (isChecked()) {
            this.f5486d.requestFocus();
            if (TextUtils.isEmpty(this.f5486d.getText())) {
                return;
            }
            EditText editText = this.f5486d;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f5484b.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i6, Object obj) {
        this.f5484b.setTag(i6, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f5484b.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(u2.g.material_time_chip, (ViewGroup) this, false);
        this.f5484b = chip;
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(u2.g.material_time_input, (ViewGroup) this, false);
        this.f5485c = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f5486d = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f5487e = bVar;
        editText.addTextChangedListener(bVar);
        h();
        addView(chip);
        addView(textInputLayout);
        this.f5488f = (TextView) findViewById(u2.e.material_label);
        editText.setSaveEnabled(false);
    }
}
