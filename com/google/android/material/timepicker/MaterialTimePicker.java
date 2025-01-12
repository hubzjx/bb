package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.timepicker.TimePickerView;
import java.util.LinkedHashSet;
import java.util.Set;
import u2.j;
/* loaded from: classes.dex */
public final class MaterialTimePicker extends DialogFragment {

    /* renamed from: o0  reason: collision with root package name */
    private TimePickerView f5515o0;

    /* renamed from: p0  reason: collision with root package name */
    private ViewStub f5516p0;

    /* renamed from: q0  reason: collision with root package name */
    private f f5517q0;

    /* renamed from: r0  reason: collision with root package name */
    private i f5518r0;

    /* renamed from: s0  reason: collision with root package name */
    private g f5519s0;

    /* renamed from: t0  reason: collision with root package name */
    private int f5520t0;

    /* renamed from: u0  reason: collision with root package name */
    private int f5521u0;

    /* renamed from: w0  reason: collision with root package name */
    private String f5523w0;

    /* renamed from: x0  reason: collision with root package name */
    private MaterialButton f5524x0;

    /* renamed from: z0  reason: collision with root package name */
    private e f5526z0;

    /* renamed from: k0  reason: collision with root package name */
    private final Set f5511k0 = new LinkedHashSet();

    /* renamed from: l0  reason: collision with root package name */
    private final Set f5512l0 = new LinkedHashSet();

    /* renamed from: m0  reason: collision with root package name */
    private final Set f5513m0 = new LinkedHashSet();

    /* renamed from: n0  reason: collision with root package name */
    private final Set f5514n0 = new LinkedHashSet();

    /* renamed from: v0  reason: collision with root package name */
    private int f5522v0 = 0;

    /* renamed from: y0  reason: collision with root package name */
    private int f5525y0 = 0;
    private int A0 = 0;

    /* loaded from: classes.dex */
    class a implements TimePickerView.e {
        a() {
        }

        @Override // com.google.android.material.timepicker.TimePickerView.e
        public void a() {
            MaterialTimePicker.this.f5525y0 = 1;
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.E1(materialTimePicker.f5524x0);
            MaterialTimePicker.this.f5518r0.j();
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (View.OnClickListener onClickListener : MaterialTimePicker.this.f5511k0) {
                onClickListener.onClick(view);
            }
            MaterialTimePicker.this.m1();
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (View.OnClickListener onClickListener : MaterialTimePicker.this.f5512l0) {
                onClickListener.onClick(view);
            }
            MaterialTimePicker.this.m1();
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.f5525y0 = materialTimePicker.f5525y0 == 0 ? 1 : 0;
            MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
            materialTimePicker2.E1(materialTimePicker2.f5524x0);
        }
    }

    private Pair A1(int i6) {
        if (i6 != 0) {
            if (i6 == 1) {
                return new Pair(Integer.valueOf(this.f5521u0), Integer.valueOf(u2.h.material_timepicker_clock_mode_description));
            }
            throw new IllegalArgumentException("no icon for mode: " + i6);
        }
        return new Pair(Integer.valueOf(this.f5520t0), Integer.valueOf(u2.h.material_timepicker_text_input_mode_description));
    }

    private int B1() {
        int i6 = this.A0;
        if (i6 != 0) {
            return i6;
        }
        TypedValue a6 = e3.b.a(Y0(), u2.a.materialTimePickerTheme);
        if (a6 == null) {
            return 0;
        }
        return a6.data;
    }

    private g C1(int i6) {
        if (i6 != 0) {
            if (this.f5518r0 == null) {
                this.f5518r0 = new i((LinearLayout) this.f5516p0.inflate(), this.f5526z0);
            }
            this.f5518r0.e();
            return this.f5518r0;
        }
        f fVar = this.f5517q0;
        if (fVar == null) {
            fVar = new f(this.f5515o0, this.f5526z0);
        }
        this.f5517q0 = fVar;
        return fVar;
    }

    private void D1(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        e eVar = (e) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
        this.f5526z0 = eVar;
        if (eVar == null) {
            this.f5526z0 = new e();
        }
        this.f5525y0 = bundle.getInt("TIME_PICKER_INPUT_MODE", 0);
        this.f5522v0 = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
        this.f5523w0 = bundle.getString("TIME_PICKER_TITLE_TEXT");
        this.A0 = bundle.getInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1(MaterialButton materialButton) {
        g gVar = this.f5519s0;
        if (gVar != null) {
            gVar.g();
        }
        g C1 = C1(this.f5525y0);
        this.f5519s0 = C1;
        C1.a();
        this.f5519s0.b();
        Pair A1 = A1(this.f5525y0);
        materialButton.setIconResource(((Integer) A1.first).intValue());
        materialButton.setContentDescription(C().getString(((Integer) A1.second).intValue()));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void Z(Bundle bundle) {
        super.Z(bundle);
        if (bundle == null) {
            bundle = n();
        }
        D1(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final View d0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(u2.g.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(u2.e.material_timepicker_view);
        this.f5515o0 = timePickerView;
        timePickerView.D(new a());
        this.f5516p0 = (ViewStub) viewGroup2.findViewById(u2.e.material_textinput_timepicker);
        this.f5524x0 = (MaterialButton) viewGroup2.findViewById(u2.e.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(u2.e.header_title);
        if (!TextUtils.isEmpty(this.f5523w0)) {
            textView.setText(this.f5523w0);
        }
        int i6 = this.f5522v0;
        if (i6 != 0) {
            textView.setText(i6);
        }
        E1(this.f5524x0);
        ((Button) viewGroup2.findViewById(u2.e.material_timepicker_ok_button)).setOnClickListener(new b());
        ((Button) viewGroup2.findViewById(u2.e.material_timepicker_cancel_button)).setOnClickListener(new c());
        this.f5524x0.setOnClickListener(new d());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        for (DialogInterface.OnCancelListener onCancelListener : this.f5513m0) {
            onCancelListener.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismissListener : this.f5514n0) {
            onDismissListener.onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog q1(Bundle bundle) {
        Dialog dialog = new Dialog(Y0(), B1());
        Context context = dialog.getContext();
        int c6 = e3.b.c(context, u2.a.colorSurface, MaterialTimePicker.class.getCanonicalName());
        int i6 = u2.a.materialTimePickerStyle;
        int i7 = u2.i.Widget_MaterialComponents_TimePicker;
        h3.g gVar = new h3.g(context, null, i6, i7);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j.f13441a3, i6, i7);
        this.f5521u0 = obtainStyledAttributes.getResourceId(j.f13448b3, 0);
        this.f5520t0 = obtainStyledAttributes.getResourceId(j.f13455c3, 0);
        obtainStyledAttributes.recycle();
        gVar.K(context);
        gVar.U(ColorStateList.valueOf(c6));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(gVar);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        return dialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        super.v0(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.f5526z0);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.f5525y0);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.f5522v0);
        bundle.putString("TIME_PICKER_TITLE_TEXT", this.f5523w0);
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", this.A0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void x0() {
        super.x0();
        this.f5519s0 = null;
        this.f5517q0 = null;
        this.f5518r0 = null;
        this.f5515o0 = null;
    }
}
