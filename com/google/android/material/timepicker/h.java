package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes.dex */
class h implements TextView.OnEditorActionListener, View.OnKeyListener {

    /* renamed from: b  reason: collision with root package name */
    private final ChipTextInputComboView f5558b;

    /* renamed from: c  reason: collision with root package name */
    private final ChipTextInputComboView f5559c;

    /* renamed from: d  reason: collision with root package name */
    private final e f5560d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5561e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, e eVar) {
        this.f5558b = chipTextInputComboView;
        this.f5559c = chipTextInputComboView2;
        this.f5560d = eVar;
    }

    private void b(int i6) {
        this.f5559c.setChecked(i6 == 12);
        this.f5558b.setChecked(i6 == 10);
        this.f5560d.f5548f = i6;
    }

    private boolean c(int i6, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (i6 >= 7 && i6 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
            b(12);
            return true;
        }
        return false;
    }

    private boolean d(int i6, KeyEvent keyEvent, EditText editText) {
        if (i6 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
            b(10);
            return true;
        }
        return false;
    }

    public void a() {
        TextInputLayout e6 = this.f5558b.e();
        TextInputLayout e7 = this.f5559c.e();
        EditText editText = e6.getEditText();
        EditText editText2 = e7.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i6, KeyEvent keyEvent) {
        boolean z5 = i6 == 5;
        if (z5) {
            b(12);
        }
        return z5;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i6, KeyEvent keyEvent) {
        if (this.f5561e) {
            return false;
        }
        this.f5561e = true;
        EditText editText = (EditText) view;
        boolean d6 = this.f5560d.f5548f == 12 ? d(i6, keyEvent, editText) : c(i6, keyEvent, editText);
        this.f5561e = false;
        return d6;
    }
}
