package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import e0.b0;
import f0.y;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class MaterialCalendar<S> extends m {

    /* renamed from: j0  reason: collision with root package name */
    static final Object f5109j0 = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: k0  reason: collision with root package name */
    static final Object f5110k0 = "NAVIGATION_PREV_TAG";

    /* renamed from: l0  reason: collision with root package name */
    static final Object f5111l0 = "NAVIGATION_NEXT_TAG";

    /* renamed from: m0  reason: collision with root package name */
    static final Object f5112m0 = "SELECTOR_TOGGLE_TAG";

    /* renamed from: a0  reason: collision with root package name */
    private int f5113a0;

    /* renamed from: b0  reason: collision with root package name */
    private com.google.android.material.datepicker.a f5114b0;

    /* renamed from: c0  reason: collision with root package name */
    private com.google.android.material.datepicker.i f5115c0;

    /* renamed from: d0  reason: collision with root package name */
    private k f5116d0;

    /* renamed from: e0  reason: collision with root package name */
    private com.google.android.material.datepicker.c f5117e0;

    /* renamed from: f0  reason: collision with root package name */
    private RecyclerView f5118f0;

    /* renamed from: g0  reason: collision with root package name */
    private RecyclerView f5119g0;

    /* renamed from: h0  reason: collision with root package name */
    private View f5120h0;

    /* renamed from: i0  reason: collision with root package name */
    private View f5121i0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f5122a;

        a(int i6) {
            this.f5122a = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.this.f5119g0.o1(this.f5122a);
        }
    }

    /* loaded from: classes.dex */
    class b extends e0.a {
        b() {
        }

        @Override // e0.a
        public void g(View view, y yVar) {
            super.g(view, yVar);
            yVar.Y(null);
        }
    }

    /* loaded from: classes.dex */
    class c extends n {
        final /* synthetic */ int I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i6, boolean z5, int i7) {
            super(context, i6, z5);
            this.I = i7;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void M1(RecyclerView.z zVar, int[] iArr) {
            if (this.I == 0) {
                iArr[0] = MaterialCalendar.this.f5119g0.getWidth();
                iArr[1] = MaterialCalendar.this.f5119g0.getWidth();
                return;
            }
            iArr[0] = MaterialCalendar.this.f5119g0.getHeight();
            iArr[1] = MaterialCalendar.this.f5119g0.getHeight();
        }
    }

    /* loaded from: classes.dex */
    class d implements l {
        d() {
        }

        @Override // com.google.android.material.datepicker.MaterialCalendar.l
        public void a(long j6) {
            if (MaterialCalendar.this.f5114b0.i().a(j6)) {
                MaterialCalendar.this.getClass();
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        private final Calendar f5126a = s.k();

        /* renamed from: b  reason: collision with root package name */
        private final Calendar f5127b = s.k();

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
            if ((recyclerView.getAdapter() instanceof t) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                t tVar = (t) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                MaterialCalendar.this.getClass();
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends e0.a {
        f() {
        }

        @Override // e0.a
        public void g(View view, y yVar) {
            MaterialCalendar materialCalendar;
            int i6;
            super.g(view, yVar);
            if (MaterialCalendar.this.f5121i0.getVisibility() == 0) {
                materialCalendar = MaterialCalendar.this;
                i6 = u2.h.mtrl_picker_toggle_to_year_selection;
            } else {
                materialCalendar = MaterialCalendar.this;
                i6 = u2.h.mtrl_picker_toggle_to_day_selection;
            }
            yVar.h0(materialCalendar.I(i6));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends RecyclerView.s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.k f5130a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MaterialButton f5131b;

        g(com.google.android.material.datepicker.k kVar, MaterialButton materialButton) {
            this.f5130a = kVar;
            this.f5131b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int i6) {
            if (i6 == 0) {
                recyclerView.announceForAccessibility(this.f5131b.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int i6, int i7) {
            LinearLayoutManager A1 = MaterialCalendar.this.A1();
            int Z1 = i6 < 0 ? A1.Z1() : A1.c2();
            MaterialCalendar.this.f5115c0 = this.f5130a.u(Z1);
            this.f5131b.setText(this.f5130a.v(Z1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.F1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.k f5134b;

        i(com.google.android.material.datepicker.k kVar) {
            this.f5134b = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int Z1 = MaterialCalendar.this.A1().Z1() + 1;
            if (Z1 < MaterialCalendar.this.f5119g0.getAdapter().c()) {
                MaterialCalendar.this.D1(this.f5134b.u(Z1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.k f5136b;

        j(com.google.android.material.datepicker.k kVar) {
            this.f5136b = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int c22 = MaterialCalendar.this.A1().c2() - 1;
            if (c22 >= 0) {
                MaterialCalendar.this.D1(this.f5136b.u(c22));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum k {
        DAY,
        YEAR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface l {
        void a(long j6);
    }

    public static MaterialCalendar B1(com.google.android.material.datepicker.d dVar, int i6, com.google.android.material.datepicker.a aVar) {
        MaterialCalendar materialCalendar = new MaterialCalendar();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i6);
        bundle.putParcelable("GRID_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.l());
        materialCalendar.f1(bundle);
        return materialCalendar;
    }

    private void C1(int i6) {
        this.f5119g0.post(new a(i6));
    }

    private void t1(View view, com.google.android.material.datepicker.k kVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(u2.e.month_navigation_fragment_toggle);
        materialButton.setTag(f5112m0);
        b0.l0(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(u2.e.month_navigation_previous);
        materialButton2.setTag(f5110k0);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(u2.e.month_navigation_next);
        materialButton3.setTag(f5111l0);
        this.f5120h0 = view.findViewById(u2.e.mtrl_calendar_year_selector_frame);
        this.f5121i0 = view.findViewById(u2.e.mtrl_calendar_day_selector_frame);
        E1(k.DAY);
        materialButton.setText(this.f5115c0.l(view.getContext()));
        this.f5119g0.k(new g(kVar, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(kVar));
        materialButton2.setOnClickListener(new j(kVar));
    }

    private RecyclerView.n u1() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z1(Context context) {
        return context.getResources().getDimensionPixelSize(u2.c.mtrl_calendar_day_height);
    }

    LinearLayoutManager A1() {
        return (LinearLayoutManager) this.f5119g0.getLayoutManager();
    }

    void D1(com.google.android.material.datepicker.i iVar) {
        RecyclerView recyclerView;
        int i6;
        com.google.android.material.datepicker.k kVar = (com.google.android.material.datepicker.k) this.f5119g0.getAdapter();
        int w5 = kVar.w(iVar);
        int w6 = w5 - kVar.w(this.f5115c0);
        boolean z5 = Math.abs(w6) > 3;
        boolean z6 = w6 > 0;
        this.f5115c0 = iVar;
        if (!z5 || !z6) {
            if (z5) {
                recyclerView = this.f5119g0;
                i6 = w5 + 3;
            }
            C1(w5);
        }
        recyclerView = this.f5119g0;
        i6 = w5 - 3;
        recyclerView.g1(i6);
        C1(w5);
    }

    void E1(k kVar) {
        this.f5116d0 = kVar;
        if (kVar == k.YEAR) {
            this.f5118f0.getLayoutManager().x1(((t) this.f5118f0.getAdapter()).t(this.f5115c0.f5195c));
            this.f5120h0.setVisibility(0);
            this.f5121i0.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.f5120h0.setVisibility(8);
            this.f5121i0.setVisibility(0);
            D1(this.f5115c0);
        }
    }

    void F1() {
        k kVar = this.f5116d0;
        k kVar2 = k.YEAR;
        if (kVar == kVar2) {
            E1(k.DAY);
        } else if (kVar == k.DAY) {
            E1(kVar2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Z(Bundle bundle) {
        super.Z(bundle);
        if (bundle == null) {
            bundle = n();
        }
        this.f5113a0 = bundle.getInt("THEME_RES_ID_KEY");
        android.support.v4.media.a.a(bundle.getParcelable("GRID_SELECTOR_KEY"));
        this.f5114b0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f5115c0 = (com.google.android.material.datepicker.i) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View d0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i6;
        int i7;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(p(), this.f5113a0);
        this.f5117e0 = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        com.google.android.material.datepicker.i m5 = this.f5114b0.m();
        if (MaterialDatePicker.B1(contextThemeWrapper)) {
            i6 = u2.g.mtrl_calendar_vertical;
            i7 = 1;
        } else {
            i6 = u2.g.mtrl_calendar_horizontal;
            i7 = 0;
        }
        View inflate = cloneInContext.inflate(i6, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(u2.e.mtrl_calendar_days_of_week);
        b0.l0(gridView, new b());
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.h());
        gridView.setNumColumns(m5.f5196d);
        gridView.setEnabled(false);
        this.f5119g0 = (RecyclerView) inflate.findViewById(u2.e.mtrl_calendar_months);
        this.f5119g0.setLayoutManager(new c(p(), i7, false, i7));
        this.f5119g0.setTag(f5109j0);
        com.google.android.material.datepicker.k kVar = new com.google.android.material.datepicker.k(contextThemeWrapper, null, this.f5114b0, new d());
        this.f5119g0.setAdapter(kVar);
        int integer = contextThemeWrapper.getResources().getInteger(u2.f.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(u2.e.mtrl_calendar_year_selector_frame);
        this.f5118f0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f5118f0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f5118f0.setAdapter(new t(this));
            this.f5118f0.h(u1());
        }
        if (inflate.findViewById(u2.e.month_navigation_fragment_toggle) != null) {
            t1(inflate, kVar);
        }
        if (!MaterialDatePicker.B1(contextThemeWrapper)) {
            new androidx.recyclerview.widget.j().b(this.f5119g0);
        }
        this.f5119g0.g1(kVar.w(this.f5115c0));
        return inflate;
    }

    @Override // com.google.android.material.datepicker.m
    public boolean m1(com.google.android.material.datepicker.l lVar) {
        return super.m1(lVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        super.v0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f5113a0);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f5114b0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f5115c0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.a v1() {
        return this.f5114b0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.c w1() {
        return this.f5117e0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.i x1() {
        return this.f5115c0;
    }

    public com.google.android.material.datepicker.d y1() {
        return null;
    }
}
