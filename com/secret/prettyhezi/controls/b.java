package com.secret.prettyhezi.controls;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public abstract class b {
    public static Bitmap a(Bitmap bitmap, float f6) {
        return b(bitmap, f6, false);
    }

    public static Bitmap b(Bitmap bitmap, float f6, boolean z5) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i6 = (int) (height * f6);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (width - i6) / 2, 0, Math.min(i6, width), height);
        if (z5 && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap c(Bitmap bitmap, float f6) {
        return f6 > ((float) bitmap.getWidth()) / ((float) bitmap.getHeight()) ? d(bitmap, f6) : a(bitmap, f6);
    }

    public static Bitmap d(Bitmap bitmap, float f6) {
        return e(bitmap, f6, false);
    }

    public static Bitmap e(Bitmap bitmap, float f6, boolean z5) {
        int width = bitmap.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, Math.min((int) (width / f6), bitmap.getHeight()));
        if (z5 && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
