package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    final b f5180a;

    /* renamed from: b  reason: collision with root package name */
    final b f5181b;

    /* renamed from: c  reason: collision with root package name */
    final b f5182c;

    /* renamed from: d  reason: collision with root package name */
    final b f5183d;

    /* renamed from: e  reason: collision with root package name */
    final b f5184e;

    /* renamed from: f  reason: collision with root package name */
    final b f5185f;

    /* renamed from: g  reason: collision with root package name */
    final b f5186g;

    /* renamed from: h  reason: collision with root package name */
    final Paint f5187h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(e3.b.c(context, u2.a.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), u2.j.f13536o2);
        this.f5180a = b.a(context, obtainStyledAttributes.getResourceId(u2.j.f13554r2, 0));
        this.f5186g = b.a(context, obtainStyledAttributes.getResourceId(u2.j.f13542p2, 0));
        this.f5181b = b.a(context, obtainStyledAttributes.getResourceId(u2.j.f13548q2, 0));
        this.f5182c = b.a(context, obtainStyledAttributes.getResourceId(u2.j.f13560s2, 0));
        ColorStateList a6 = e3.c.a(context, obtainStyledAttributes, u2.j.f13566t2);
        this.f5183d = b.a(context, obtainStyledAttributes.getResourceId(u2.j.f13578v2, 0));
        this.f5184e = b.a(context, obtainStyledAttributes.getResourceId(u2.j.f13572u2, 0));
        this.f5185f = b.a(context, obtainStyledAttributes.getResourceId(u2.j.f13584w2, 0));
        Paint paint = new Paint();
        this.f5187h = paint;
        paint.setColor(a6.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
