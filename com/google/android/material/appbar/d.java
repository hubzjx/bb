package com.google.android.material.appbar;

import android.view.View;
import e0.b0;
/* loaded from: classes.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private final View f4890a;

    /* renamed from: b  reason: collision with root package name */
    private int f4891b;

    /* renamed from: c  reason: collision with root package name */
    private int f4892c;

    /* renamed from: d  reason: collision with root package name */
    private int f4893d;

    /* renamed from: e  reason: collision with root package name */
    private int f4894e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4895f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4896g = true;

    public d(View view) {
        this.f4890a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f4890a;
        b0.X(view, this.f4893d - (view.getTop() - this.f4891b));
        View view2 = this.f4890a;
        b0.W(view2, this.f4894e - (view2.getLeft() - this.f4892c));
    }

    public int b() {
        return this.f4893d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f4891b = this.f4890a.getTop();
        this.f4892c = this.f4890a.getLeft();
    }

    public boolean d(int i6) {
        if (!this.f4896g || this.f4894e == i6) {
            return false;
        }
        this.f4894e = i6;
        a();
        return true;
    }

    public boolean e(int i6) {
        if (!this.f4895f || this.f4893d == i6) {
            return false;
        }
        this.f4893d = i6;
        a();
        return true;
    }
}
