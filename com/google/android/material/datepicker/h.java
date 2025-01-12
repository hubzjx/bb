package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes.dex */
class h extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    private static final int f5189e;

    /* renamed from: b  reason: collision with root package name */
    private final Calendar f5190b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5191c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5192d;

    static {
        f5189e = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public h() {
        Calendar k6 = s.k();
        this.f5190b = k6;
        this.f5191c = k6.getMaximum(7);
        this.f5192d = k6.getFirstDayOfWeek();
    }

    private int b(int i6) {
        int i7 = i6 + this.f5192d;
        int i8 = this.f5191c;
        return i7 > i8 ? i7 - i8 : i7;
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public Integer getItem(int i6) {
        if (i6 >= this.f5191c) {
            return null;
        }
        return Integer.valueOf(b(i6));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5191c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i6) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i6, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(u2.g.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f5190b.set(7, b(i6));
        textView.setText(this.f5190b.getDisplayName(7, f5189e, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(u2.h.mtrl_picker_day_of_week_column_header), this.f5190b.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
