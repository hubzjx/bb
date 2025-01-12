package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import e0.b0;
/* loaded from: classes.dex */
class k extends RecyclerView.g {

    /* renamed from: c  reason: collision with root package name */
    private final Context f5205c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.material.datepicker.a f5206d;

    /* renamed from: e  reason: collision with root package name */
    private final MaterialCalendar.l f5207e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5208f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f5209b;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f5209b = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
            if (this.f5209b.getAdapter2().l(i6)) {
                k.this.f5207e.a(this.f5209b.getAdapter2().getItem(i6).longValue());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.c0 {

        /* renamed from: t  reason: collision with root package name */
        final TextView f5211t;

        /* renamed from: u  reason: collision with root package name */
        final MaterialCalendarGridView f5212u;

        b(LinearLayout linearLayout, boolean z5) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(u2.e.month_title);
            this.f5211t = textView;
            b0.m0(textView, true);
            this.f5212u = (MaterialCalendarGridView) linearLayout.findViewById(u2.e.month_grid);
            if (z5) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, d dVar, com.google.android.material.datepicker.a aVar, MaterialCalendar.l lVar) {
        i m5 = aVar.m();
        i j6 = aVar.j();
        i l6 = aVar.l();
        if (m5.compareTo(l6) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (l6.compareTo(j6) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int z12 = j.f5200f * MaterialCalendar.z1(context);
        int z13 = MaterialDatePicker.B1(context) ? MaterialCalendar.z1(context) : 0;
        this.f5205c = context;
        this.f5208f = z12 + z13;
        this.f5206d = aVar;
        this.f5207e = lVar;
        r(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f5206d.k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long d(int i6) {
        return this.f5206d.m().n(i6).m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i u(int i6) {
        return this.f5206d.m().n(i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence v(int i6) {
        return u(i6).l(this.f5205c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w(i iVar) {
        return this.f5206d.m().o(iVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: x */
    public void i(b bVar, int i6) {
        i n5 = this.f5206d.m().n(i6);
        bVar.f5211t.setText(n5.l(bVar.f2221a.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f5212u.findViewById(u2.e.month_grid);
        if (materialCalendarGridView.getAdapter2() == null || !n5.equals(materialCalendarGridView.getAdapter2().f5201b)) {
            j jVar = new j(n5, null, this.f5206d);
            materialCalendarGridView.setNumColumns(n5.f5196d);
            materialCalendarGridView.setAdapter((ListAdapter) jVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter2().k(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: y */
    public b k(ViewGroup viewGroup, int i6) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(u2.g.mtrl_calendar_month_labeled, viewGroup, false);
        if (MaterialDatePicker.B1(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f5208f));
            return new b(linearLayout, true);
        }
        return new b(linearLayout, false);
    }
}
