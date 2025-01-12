package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    static final int f5200f = s.k().getMaximum(4);

    /* renamed from: b  reason: collision with root package name */
    final i f5201b;

    /* renamed from: c  reason: collision with root package name */
    private Collection f5202c;

    /* renamed from: d  reason: collision with root package name */
    c f5203d;

    /* renamed from: e  reason: collision with root package name */
    final a f5204e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, d dVar, a aVar) {
        this.f5201b = iVar;
        this.f5204e = aVar;
        this.f5202c = dVar.c();
    }

    private void e(Context context) {
        if (this.f5203d == null) {
            this.f5203d = new c(context);
        }
    }

    private boolean f(long j6) {
        throw null;
    }

    private void i(TextView textView, long j6) {
        b bVar;
        if (textView == null) {
            return;
        }
        if (this.f5204e.i().a(j6)) {
            textView.setEnabled(true);
            if (f(j6)) {
                bVar = this.f5203d.f5181b;
            } else {
                int i6 = (s.i().getTimeInMillis() > j6 ? 1 : (s.i().getTimeInMillis() == j6 ? 0 : -1));
                c cVar = this.f5203d;
                bVar = i6 == 0 ? cVar.f5182c : cVar.f5180a;
            }
        } else {
            textView.setEnabled(false);
            bVar = this.f5203d.f5186g;
        }
        bVar.b(textView);
    }

    private void j(MaterialCalendarGridView materialCalendarGridView, long j6) {
        if (i.g(j6).equals(this.f5201b)) {
            i((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter2().a(this.f5201b.k(j6)) - materialCalendarGridView.getFirstVisiblePosition()), j6);
        }
    }

    int a(int i6) {
        return b() + (i6 - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f5201b.i();
    }

    @Override // android.widget.Adapter
    /* renamed from: c */
    public Long getItem(int i6) {
        if (i6 < this.f5201b.i() || i6 > g()) {
            return null;
        }
        return Long.valueOf(this.f5201b.j(h(i6)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    @Override // android.widget.Adapter
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextView getView(int i6, View view, ViewGroup viewGroup) {
        Long item;
        e(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(u2.g.mtrl_calendar_day, viewGroup, false);
        }
        int b6 = i6 - b();
        if (b6 >= 0) {
            i iVar = this.f5201b;
            if (b6 < iVar.f5197e) {
                int i7 = b6 + 1;
                textView.setTag(iVar);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i7)));
                long j6 = this.f5201b.j(i7);
                textView.setContentDescription(this.f5201b.f5195c == i.h().f5195c ? f.a(j6) : f.d(j6));
                textView.setVisibility(0);
                textView.setEnabled(true);
                item = getItem(i6);
                if (item != null) {
                    return textView;
                }
                i(textView, item.longValue());
                return textView;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        item = getItem(i6);
        if (item != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return (this.f5201b.i() + this.f5201b.f5197e) - 1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5201b.f5197e + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i6) {
        return i6 / this.f5201b.f5196d;
    }

    int h(int i6) {
        return (i6 - this.f5201b.i()) + 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public void k(MaterialCalendarGridView materialCalendarGridView) {
        for (Long l6 : this.f5202c) {
            j(materialCalendarGridView, l6.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(int i6) {
        return i6 >= b() && i6 <= g();
    }
}
