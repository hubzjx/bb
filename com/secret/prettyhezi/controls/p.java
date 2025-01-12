package com.secret.prettyhezi.controls;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class p extends r {

    /* renamed from: k  reason: collision with root package name */
    String f8433k;

    /* renamed from: l  reason: collision with root package name */
    int f8434l;

    /* renamed from: m  reason: collision with root package name */
    int f8435m;

    public p(Context context, String str) {
        super(context, str);
        this.f8434l = 0;
        this.f8435m = 0;
        this.f8433k = str;
    }

    @Override // com.secret.prettyhezi.controls.r
    protected void d(Bitmap bitmap) {
        int i6;
        int i7;
        int i8;
        int width = getWidth();
        int height = getHeight();
        if (width <= 0) {
            int i9 = this.f8434l;
            if (i9 <= 0 || (i8 = this.f8435m) <= 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null && (i6 = layoutParams.width) > 0 && (i7 = layoutParams.height) > 0) {
                    height = i7;
                    width = i6;
                }
            } else {
                width = i9;
                height = i8;
            }
        }
        if (bitmap == null || width <= 0 || height <= 0) {
            return;
        }
        Bitmap c6 = b.c(bitmap, width / height);
        setBackground(new BitmapDrawable(c6));
        if (c6 != bitmap) {
            bitmap.recycle();
        }
    }

    public p(Context context, String str, int i6, int i7) {
        super(context, str);
        this.f8433k = str;
        this.f8434l = i6;
        this.f8435m = i7;
    }
}
