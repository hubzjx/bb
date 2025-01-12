package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import e0.b0;
/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f5174a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f5175b;

    /* renamed from: c  reason: collision with root package name */
    private final ColorStateList f5176c;

    /* renamed from: d  reason: collision with root package name */
    private final ColorStateList f5177d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5178e;

    /* renamed from: f  reason: collision with root package name */
    private final h3.k f5179f;

    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i6, h3.k kVar, Rect rect) {
        d0.i.b(rect.left);
        d0.i.b(rect.top);
        d0.i.b(rect.right);
        d0.i.b(rect.bottom);
        this.f5174a = rect;
        this.f5175b = colorStateList2;
        this.f5176c = colorStateList;
        this.f5177d = colorStateList3;
        this.f5178e = i6;
        this.f5179f = kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(Context context, int i6) {
        d0.i.a(i6 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i6, u2.j.f13590x2);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(u2.j.f13596y2, 0), obtainStyledAttributes.getDimensionPixelOffset(u2.j.A2, 0), obtainStyledAttributes.getDimensionPixelOffset(u2.j.f13602z2, 0), obtainStyledAttributes.getDimensionPixelOffset(u2.j.B2, 0));
        ColorStateList a6 = e3.c.a(context, obtainStyledAttributes, u2.j.C2);
        ColorStateList a7 = e3.c.a(context, obtainStyledAttributes, u2.j.H2);
        ColorStateList a8 = e3.c.a(context, obtainStyledAttributes, u2.j.F2);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(u2.j.G2, 0);
        h3.k m5 = h3.k.b(context, obtainStyledAttributes.getResourceId(u2.j.D2, 0), obtainStyledAttributes.getResourceId(u2.j.E2, 0)).m();
        obtainStyledAttributes.recycle();
        return new b(a6, a7, a8, dimensionPixelSize, m5, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(TextView textView) {
        h3.g gVar = new h3.g();
        h3.g gVar2 = new h3.g();
        gVar.setShapeAppearanceModel(this.f5179f);
        gVar2.setShapeAppearanceModel(this.f5179f);
        gVar.U(this.f5176c);
        gVar.Z(this.f5178e, this.f5177d);
        textView.setTextColor(this.f5175b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f5175b.withAlpha(30), gVar, gVar2);
        Rect rect = this.f5174a;
        b0.o0(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
