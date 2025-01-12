package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
abstract class c extends CoordinatorLayout.b {

    /* renamed from: a  reason: collision with root package name */
    private d f4887a;

    /* renamed from: b  reason: collision with root package name */
    private int f4888b;

    /* renamed from: c  reason: collision with root package name */
    private int f4889c;

    public c() {
        this.f4888b = 0;
        this.f4889c = 0;
    }

    public int E() {
        d dVar = this.f4887a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(CoordinatorLayout coordinatorLayout, View view, int i6) {
        coordinatorLayout.G(view, i6);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i6) {
        F(coordinatorLayout, view, i6);
        if (this.f4887a == null) {
            this.f4887a = new d(view);
        }
        this.f4887a.c();
        this.f4887a.a();
        int i7 = this.f4888b;
        if (i7 != 0) {
            this.f4887a.e(i7);
            this.f4888b = 0;
        }
        int i8 = this.f4889c;
        if (i8 != 0) {
            this.f4887a.d(i8);
            this.f4889c = 0;
            return true;
        }
        return true;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4888b = 0;
        this.f4889c = 0;
    }
}
