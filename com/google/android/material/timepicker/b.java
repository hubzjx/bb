package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import f0.y;
/* loaded from: classes.dex */
class b extends e0.a {

    /* renamed from: d  reason: collision with root package name */
    private final y.a f5538d;

    public b(Context context, int i6) {
        this.f5538d = new y.a(16, context.getString(i6));
    }

    @Override // e0.a
    public void g(View view, y yVar) {
        super.g(view, yVar);
        yVar.b(this.f5538d);
    }
}
