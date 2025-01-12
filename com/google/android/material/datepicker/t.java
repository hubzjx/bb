package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;
/* loaded from: classes.dex */
class t extends RecyclerView.g {

    /* renamed from: c  reason: collision with root package name */
    private final MaterialCalendar f5218c;

    /* loaded from: classes.dex */
    public static class a extends RecyclerView.c0 {

        /* renamed from: t  reason: collision with root package name */
        final TextView f5219t;

        a(TextView textView) {
            super(textView);
            this.f5219t = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MaterialCalendar materialCalendar) {
        this.f5218c = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f5218c.v1().n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t(int i6) {
        return i6 - this.f5218c.v1().m().f5195c;
    }

    int u(int i6) {
        return this.f5218c.v1().m().f5195c + i6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: v */
    public void i(a aVar, int i6) {
        int u5 = u(i6);
        String string = aVar.f5219t.getContext().getString(u2.h.mtrl_picker_navigate_to_year_description);
        aVar.f5219t.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(u5)));
        aVar.f5219t.setContentDescription(String.format(string, Integer.valueOf(u5)));
        c w12 = this.f5218c.w1();
        if (s.i().get(1) == u5) {
            b bVar = w12.f5185f;
        } else {
            b bVar2 = w12.f5183d;
        }
        this.f5218c.y1();
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: w */
    public a k(ViewGroup viewGroup, int i6) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(u2.g.mtrl_calendar_year, viewGroup, false));
    }
}
