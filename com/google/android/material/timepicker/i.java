package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements TimePickerView.g, g {

    /* renamed from: b  reason: collision with root package name */
    private final LinearLayout f5562b;

    /* renamed from: c  reason: collision with root package name */
    private final e f5563c;

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f5564d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final TextWatcher f5565e = new b();

    /* renamed from: f  reason: collision with root package name */
    private final ChipTextInputComboView f5566f;

    /* renamed from: g  reason: collision with root package name */
    private final ChipTextInputComboView f5567g;

    /* renamed from: h  reason: collision with root package name */
    private final h f5568h;

    /* renamed from: i  reason: collision with root package name */
    private final EditText f5569i;

    /* renamed from: j  reason: collision with root package name */
    private final EditText f5570j;

    /* renamed from: k  reason: collision with root package name */
    private MaterialButtonToggleGroup f5571k;

    /* loaded from: classes.dex */
    class a extends com.google.android.material.internal.i {
        a() {
        }

        @Override // com.google.android.material.internal.i, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    i.this.f5563c.l(0);
                    return;
                }
                i.this.f5563c.l(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends com.google.android.material.internal.i {
        b() {
        }

        @Override // com.google.android.material.internal.i, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    i.this.f5563c.k(0);
                    return;
                }
                i.this.f5563c.k(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.f(((Integer) view.getTag(u2.e.selection_type)).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements MaterialButtonToggleGroup.e {
        d() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i6, boolean z5) {
            i.this.f5563c.m(i6 == u2.e.material_clock_period_pm_button ? 1 : 0);
        }
    }

    public i(LinearLayout linearLayout, e eVar) {
        this.f5562b = linearLayout;
        this.f5563c = eVar;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(u2.e.material_minute_text_input);
        this.f5566f = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(u2.e.material_hour_text_input);
        this.f5567g = chipTextInputComboView2;
        int i6 = u2.e.material_label;
        ((TextView) chipTextInputComboView.findViewById(i6)).setText(resources.getString(u2.h.material_timepicker_minute));
        ((TextView) chipTextInputComboView2.findViewById(i6)).setText(resources.getString(u2.h.material_timepicker_hour));
        int i7 = u2.e.selection_type;
        chipTextInputComboView.setTag(i7, 12);
        chipTextInputComboView2.setTag(i7, 10);
        if (eVar.f5545c == 0) {
            l();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.c(eVar.h());
        chipTextInputComboView.c(eVar.i());
        this.f5569i = chipTextInputComboView2.e().getEditText();
        this.f5570j = chipTextInputComboView.e().getEditText();
        this.f5568h = new h(chipTextInputComboView2, chipTextInputComboView, eVar);
        chipTextInputComboView2.f(new com.google.android.material.timepicker.b(linearLayout.getContext(), u2.h.material_hour_selection));
        chipTextInputComboView.f(new com.google.android.material.timepicker.b(linearLayout.getContext(), u2.h.material_minute_selection));
        h();
    }

    private void d() {
        this.f5569i.addTextChangedListener(this.f5565e);
        this.f5570j.addTextChangedListener(this.f5564d);
    }

    private void i() {
        this.f5569i.removeTextChangedListener(this.f5565e);
        this.f5570j.removeTextChangedListener(this.f5564d);
    }

    private void k(e eVar) {
        i();
        Locale locale = this.f5562b.getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", Integer.valueOf(eVar.f5547e));
        String format2 = String.format(locale, "%02d", Integer.valueOf(eVar.g()));
        this.f5566f.g(format);
        this.f5567g.g(format2);
        d();
        m();
    }

    private void l() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f5562b.findViewById(u2.e.material_clock_period_toggle);
        this.f5571k = materialButtonToggleGroup;
        materialButtonToggleGroup.g(new d());
        this.f5571k.setVisibility(0);
        m();
    }

    private void m() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f5571k;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.j(this.f5563c.f5549g == 0 ? u2.e.material_clock_period_am_button : u2.e.material_clock_period_pm_button);
    }

    @Override // com.google.android.material.timepicker.g
    public void a() {
        this.f5562b.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.g
    public void b() {
        k(this.f5563c);
    }

    public void e() {
        this.f5566f.setChecked(false);
        this.f5567g.setChecked(false);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.g
    public void f(int i6) {
        this.f5563c.f5548f = i6;
        this.f5566f.setChecked(i6 == 12);
        this.f5567g.setChecked(i6 == 10);
        m();
    }

    @Override // com.google.android.material.timepicker.g
    public void g() {
        InputMethodManager inputMethodManager;
        View focusedChild = this.f5562b.getFocusedChild();
        if (focusedChild != null && (inputMethodManager = (InputMethodManager) u.c.f(this.f5562b.getContext(), InputMethodManager.class)) != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.f5562b.setVisibility(8);
    }

    public void h() {
        d();
        k(this.f5563c);
        this.f5568h.a();
    }

    public void j() {
        this.f5566f.setChecked(this.f5563c.f5548f == 12);
        this.f5567g.setChecked(this.f5563c.f5548f == 10);
    }
}
