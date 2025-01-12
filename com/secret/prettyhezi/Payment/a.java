package com.secret.prettyhezi.Payment;

import android.graphics.Bitmap;
import com.google.zxing.h;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.n;
import s3.j;
/* loaded from: classes.dex */
public abstract class a {
    public static boolean a(String str) {
        return str.startsWith("https://qr.alipay.com/");
    }

    public static boolean b(String str) {
        return str.startsWith("wxp://");
    }

    public static String c(Bitmap bitmap) {
        n nVar;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        try {
            nVar = new a4.a().a(new com.google.zxing.c(new j(new l(width, height, iArr))));
        } catch (com.google.zxing.d | h | k e6) {
            e6.printStackTrace();
            nVar = null;
        }
        if (nVar == null) {
            return null;
        }
        return nVar.a();
    }
}
