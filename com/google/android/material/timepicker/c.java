package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class c implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private int f5539a;

    public c(int i6) {
        this.f5539a = i6;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i6, int i7, Spanned spanned, int i8, int i9) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i8, i9, charSequence.subSequence(i6, i7).toString());
            if (Integer.parseInt(sb.toString()) <= this.f5539a) {
                return null;
            }
            return HttpUrl.FRAGMENT_ENCODE_SET;
        } catch (NumberFormatException unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }
}
