package com.google.android.material.timepicker;

import android.view.accessibility.AccessibilityManager;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;
/* loaded from: classes.dex */
class f implements ClockHandView.d, TimePickerView.g, TimePickerView.f, ClockHandView.c, g {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f5550g = {"12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f5551h = {"00", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22"};

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f5552i = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    /* renamed from: b  reason: collision with root package name */
    private TimePickerView f5553b;

    /* renamed from: c  reason: collision with root package name */
    private e f5554c;

    /* renamed from: d  reason: collision with root package name */
    private float f5555d;

    /* renamed from: e  reason: collision with root package name */
    private float f5556e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5557f = false;

    public f(TimePickerView timePickerView, e eVar) {
        this.f5553b = timePickerView;
        this.f5554c = eVar;
        j();
    }

    private int h() {
        return this.f5554c.f5545c == 1 ? 15 : 30;
    }

    private String[] i() {
        return this.f5554c.f5545c == 1 ? f5551h : f5550g;
    }

    private void k(int i6, int i7) {
        e eVar = this.f5554c;
        if (eVar.f5547e == i7 && eVar.f5546d == i6) {
            return;
        }
        this.f5553b.performHapticFeedback(4);
    }

    private void m() {
        TimePickerView timePickerView = this.f5553b;
        e eVar = this.f5554c;
        timePickerView.K(eVar.f5549g, eVar.g(), this.f5554c.f5547e);
    }

    private void n() {
        o(f5550g, "%d");
        o(f5551h, "%d");
        o(f5552i, "%02d");
    }

    private void o(String[] strArr, String str) {
        for (int i6 = 0; i6 < strArr.length; i6++) {
            strArr[i6] = e.f(this.f5553b.getResources(), strArr[i6], str);
        }
    }

    @Override // com.google.android.material.timepicker.g
    public void a() {
        this.f5553b.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.g
    public void b() {
        this.f5556e = this.f5554c.g() * h();
        e eVar = this.f5554c;
        this.f5555d = eVar.f5547e * 6;
        l(eVar.f5548f, false);
        m();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void c(float f6, boolean z5) {
        this.f5557f = true;
        e eVar = this.f5554c;
        int i6 = eVar.f5547e;
        int i7 = eVar.f5546d;
        if (eVar.f5548f == 10) {
            this.f5553b.z(this.f5556e, false);
            if (!((AccessibilityManager) u.c.f(this.f5553b.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                l(12, true);
            }
        } else {
            int round = Math.round(f6);
            if (!z5) {
                this.f5554c.l(((round + 15) / 30) * 5);
                this.f5555d = this.f5554c.f5547e * 6;
            }
            this.f5553b.z(this.f5555d, z5);
        }
        this.f5557f = false;
        m();
        k(i7, i6);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void d(int i6) {
        this.f5554c.m(i6);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void e(float f6, boolean z5) {
        if (this.f5557f) {
            return;
        }
        e eVar = this.f5554c;
        int i6 = eVar.f5546d;
        int i7 = eVar.f5547e;
        int round = Math.round(f6);
        e eVar2 = this.f5554c;
        if (eVar2.f5548f == 12) {
            eVar2.l((round + 3) / 6);
            this.f5555d = (float) Math.floor(this.f5554c.f5547e * 6);
        } else {
            this.f5554c.k((round + (h() / 2)) / h());
            this.f5556e = this.f5554c.g() * h();
        }
        if (z5) {
            return;
        }
        m();
        k(i6, i7);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.g
    public void f(int i6) {
        l(i6, true);
    }

    @Override // com.google.android.material.timepicker.g
    public void g() {
        this.f5553b.setVisibility(8);
    }

    public void j() {
        if (this.f5554c.f5545c == 0) {
            this.f5553b.J();
        }
        this.f5553b.w(this);
        this.f5553b.F(this);
        this.f5553b.E(this);
        this.f5553b.C(this);
        n();
        b();
    }

    void l(int i6, boolean z5) {
        boolean z6 = i6 == 12;
        this.f5553b.y(z6);
        this.f5554c.f5548f = i6;
        this.f5553b.H(z6 ? f5552i : i(), z6 ? u2.h.material_minute_suffix : u2.h.material_hour_suffix);
        this.f5553b.z(z6 ? this.f5555d : this.f5556e, z5);
        this.f5553b.x(i6);
        this.f5553b.B(new b(this.f5553b.getContext(), u2.h.material_hour_selection));
        this.f5553b.A(new b(this.f5553b.getContext(), u2.h.material_minute_selection));
    }
}
