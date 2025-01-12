package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class MaterialTextInputPicker<S> extends m {

    /* renamed from: a0  reason: collision with root package name */
    private int f5159a0;

    /* renamed from: b0  reason: collision with root package name */
    private com.google.android.material.datepicker.a f5160b0;

    /* loaded from: classes.dex */
    class a extends l {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MaterialTextInputPicker o1(d dVar, int i6, com.google.android.material.datepicker.a aVar) {
        MaterialTextInputPicker materialTextInputPicker = new MaterialTextInputPicker();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i6);
        bundle.putParcelable("DATE_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        materialTextInputPicker.f1(bundle);
        return materialTextInputPicker;
    }

    @Override // androidx.fragment.app.Fragment
    public void Z(Bundle bundle) {
        super.Z(bundle);
        if (bundle == null) {
            bundle = n();
        }
        this.f5159a0 = bundle.getInt("THEME_RES_ID_KEY");
        android.support.v4.media.a.a(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.f5160b0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View d0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(p(), this.f5159a0));
        new a();
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        super.v0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f5159a0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f5160b0);
    }
}
