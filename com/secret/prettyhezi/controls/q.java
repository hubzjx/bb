package com.secret.prettyhezi.controls;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class q extends r {

    /* renamed from: k  reason: collision with root package name */
    int f8436k;

    /* renamed from: l  reason: collision with root package name */
    int f8437l;

    public q(Context context, String str, int i6, int i7) {
        super(context, str);
        this.f8436k = i6;
        this.f8437l = i7;
    }

    @Override // com.secret.prettyhezi.controls.r
    protected void d(Bitmap bitmap) {
        int i6;
        int height;
        if (bitmap != null) {
            if (this.f8436k * bitmap.getHeight() > this.f8437l * bitmap.getWidth()) {
                height = this.f8437l;
                i6 = (bitmap.getWidth() * height) / bitmap.getHeight();
            } else {
                i6 = this.f8436k;
                height = (bitmap.getHeight() * i6) / bitmap.getWidth();
            }
            getLayoutParams().width = i6;
            getLayoutParams().height = height;
            requestLayout();
            setBackground(new BitmapDrawable(bitmap));
        }
    }
}
