package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.datepicker.a;
import com.google.android.material.internal.CheckableImageButton;
import e0.b0;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    static final Object A0 = "CONFIRM_BUTTON_TAG";
    static final Object B0 = "CANCEL_BUTTON_TAG";
    static final Object C0 = "TOGGLE_BUTTON_TAG";

    /* renamed from: k0  reason: collision with root package name */
    private final LinkedHashSet f5141k0 = new LinkedHashSet();

    /* renamed from: l0  reason: collision with root package name */
    private final LinkedHashSet f5142l0 = new LinkedHashSet();

    /* renamed from: m0  reason: collision with root package name */
    private final LinkedHashSet f5143m0 = new LinkedHashSet();

    /* renamed from: n0  reason: collision with root package name */
    private final LinkedHashSet f5144n0 = new LinkedHashSet();

    /* renamed from: o0  reason: collision with root package name */
    private int f5145o0;

    /* renamed from: p0  reason: collision with root package name */
    private m f5146p0;

    /* renamed from: q0  reason: collision with root package name */
    private com.google.android.material.datepicker.a f5147q0;

    /* renamed from: r0  reason: collision with root package name */
    private MaterialCalendar f5148r0;

    /* renamed from: s0  reason: collision with root package name */
    private int f5149s0;

    /* renamed from: t0  reason: collision with root package name */
    private CharSequence f5150t0;

    /* renamed from: u0  reason: collision with root package name */
    private boolean f5151u0;

    /* renamed from: v0  reason: collision with root package name */
    private int f5152v0;

    /* renamed from: w0  reason: collision with root package name */
    private TextView f5153w0;

    /* renamed from: x0  reason: collision with root package name */
    private CheckableImageButton f5154x0;

    /* renamed from: y0  reason: collision with root package name */
    private h3.g f5155y0;

    /* renamed from: z0  reason: collision with root package name */
    private Button f5156z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends l {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Button unused = MaterialDatePicker.this.f5156z0;
            MaterialDatePicker.this.getClass();
            throw null;
        }
    }

    private void A1(Context context) {
        this.f5154x0.setTag(C0);
        this.f5154x0.setImageDrawable(v1(context));
        this.f5154x0.setChecked(this.f5152v0 != 0);
        b0.l0(this.f5154x0, null);
        G1(this.f5154x0);
        this.f5154x0.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean B1(Context context) {
        return D1(context, 16843277);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean C1(Context context) {
        return D1(context, u2.a.nestedScrollable);
    }

    static boolean D1(Context context, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(e3.b.c(context, u2.a.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i6});
        boolean z5 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z5;
    }

    private void E1() {
        int z12 = z1(Y0());
        this.f5148r0 = MaterialCalendar.B1(null, z12, this.f5147q0);
        this.f5146p0 = this.f5154x0.isChecked() ? MaterialTextInputPicker.o1(null, z12, this.f5147q0) : this.f5148r0;
        F1();
        androidx.fragment.app.l a6 = o().a();
        a6.i(u2.e.mtrl_calendar_frame, this.f5146p0);
        a6.e();
        this.f5146p0.m1(new a());
    }

    private void F1() {
        String x12 = x1();
        this.f5153w0.setContentDescription(String.format(I(u2.h.mtrl_picker_announce_current_selection), x12));
        this.f5153w0.setText(x12);
    }

    private void G1(CheckableImageButton checkableImageButton) {
        this.f5154x0.setContentDescription(checkableImageButton.getContext().getString(this.f5154x0.isChecked() ? u2.h.mtrl_picker_toggle_to_calendar_input_mode : u2.h.mtrl_picker_toggle_to_text_input_mode));
    }

    private static Drawable v1(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, e.b.d(context, u2.d.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], e.b.d(context, u2.d.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private static int w1(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(u2.c.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(u2.c.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(u2.c.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(u2.c.mtrl_calendar_days_of_week_height);
        int i6 = j.f5200f;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(u2.c.mtrl_calendar_day_height) * i6) + ((i6 - 1) * resources.getDimensionPixelOffset(u2.c.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(u2.c.mtrl_calendar_bottom_padding);
    }

    private static int y1(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(u2.c.mtrl_calendar_content_padding);
        int i6 = i.h().f5196d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(u2.c.mtrl_calendar_day_width) * i6) + ((i6 - 1) * resources.getDimensionPixelOffset(u2.c.mtrl_calendar_month_horizontal_padding));
    }

    private int z1(Context context) {
        int i6 = this.f5145o0;
        if (i6 != 0) {
            return i6;
        }
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void Z(Bundle bundle) {
        super.Z(bundle);
        if (bundle == null) {
            bundle = n();
        }
        this.f5145o0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        android.support.v4.media.a.a(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.f5147q0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f5149s0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f5150t0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f5152v0 = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View d0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.f5151u0 ? u2.g.mtrl_picker_fullscreen : u2.g.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.f5151u0) {
            inflate.findViewById(u2.e.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(y1(context), -2));
        } else {
            View findViewById = inflate.findViewById(u2.e.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(u2.e.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(y1(context), -1));
            findViewById2.setMinimumHeight(w1(Y0()));
        }
        TextView textView = (TextView) inflate.findViewById(u2.e.mtrl_picker_header_selection_text);
        this.f5153w0 = textView;
        b0.n0(textView, 1);
        this.f5154x0 = (CheckableImageButton) inflate.findViewById(u2.e.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(u2.e.mtrl_picker_title_text);
        CharSequence charSequence = this.f5150t0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f5149s0);
        }
        A1(context);
        this.f5156z0 = (Button) inflate.findViewById(u2.e.confirm_button);
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f5143m0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f5144n0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) K();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog q1(Bundle bundle) {
        Dialog dialog = new Dialog(Y0(), z1(Y0()));
        Context context = dialog.getContext();
        this.f5151u0 = B1(context);
        int c6 = e3.b.c(context, u2.a.colorSurface, MaterialDatePicker.class.getCanonicalName());
        h3.g gVar = new h3.g(context, null, u2.a.materialCalendarStyle, u2.i.Widget_MaterialComponents_MaterialCalendar);
        this.f5155y0 = gVar;
        gVar.K(context);
        this.f5155y0.U(ColorStateList.valueOf(c6));
        this.f5155y0.T(b0.w(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void v0(Bundle bundle) {
        super.v0(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f5145o0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        a.b bVar = new a.b(this.f5147q0);
        if (this.f5148r0.x1() != null) {
            bVar.b(this.f5148r0.x1().f5198f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f5149s0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f5150t0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void w0() {
        super.w0();
        Window window = r1().getWindow();
        if (this.f5151u0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f5155y0);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = C().getDimensionPixelOffset(u2.c.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f5155y0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new z2.a(r1(), rect));
        }
        E1();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void x0() {
        this.f5146p0.n1();
        super.x0();
    }

    public String x1() {
        p();
        throw null;
    }
}
