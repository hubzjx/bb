package com.secret.prettyhezi.share;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.util.Hashtable;
/* loaded from: classes.dex */
public abstract class a {
    public static Bitmap a(String str, Bitmap bitmap) {
        try {
            Matrix matrix = new Matrix();
            matrix.setScale(80.0f / bitmap.getWidth(), 80.0f / bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            com.google.zxing.j jVar = new com.google.zxing.j();
            Hashtable hashtable = new Hashtable();
            hashtable.put(com.google.zxing.g.CHARACTER_SET, "UTF-8");
            hashtable.put(com.google.zxing.g.ERROR_CORRECTION, com.google.zxing.qrcode.decoder.f.H);
            s3.b a6 = jVar.a(str, com.google.zxing.a.QR_CODE, g4.i.r(200.0f), g4.i.r(200.0f), hashtable);
            int i6 = a6.i();
            int g6 = a6.g();
            int i7 = i6 / 2;
            int i8 = g6 / 2;
            int[] iArr = new int[i6 * g6];
            for (int i9 = 0; i9 < g6; i9++) {
                for (int i10 = 0; i10 < i6; i10++) {
                    if (i10 > i7 - 40 && i10 < i7 + 40 && i9 > i8 - 40 && i9 < i8 + 40) {
                        iArr[(i9 * i6) + i10] = createBitmap.getPixel((i10 - i7) + 40, (i9 - i8) + 40);
                    } else if (a6.e(i10, i9)) {
                        iArr[(i9 * i6) + i10] = -16777216;
                    } else {
                        iArr[(i9 * i6) + i10] = -1;
                    }
                }
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(i6, g6, Bitmap.Config.ARGB_8888);
            createBitmap2.setPixels(iArr, 0, i6, 0, 0, i6, g6);
            return createBitmap2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap b(String str) {
        try {
            com.google.zxing.j jVar = new com.google.zxing.j();
            Hashtable hashtable = new Hashtable();
            hashtable.put(com.google.zxing.g.CHARACTER_SET, "UTF-8");
            hashtable.put(com.google.zxing.g.ERROR_CORRECTION, com.google.zxing.qrcode.decoder.f.H);
            s3.b a6 = jVar.a(str, com.google.zxing.a.QR_CODE, g4.i.r(200.0f), g4.i.r(200.0f), hashtable);
            int i6 = a6.i();
            int g6 = a6.g();
            int i7 = i6 / 2;
            int i8 = g6 / 2;
            int[] iArr = new int[i6 * g6];
            for (int i9 = 0; i9 < g6; i9++) {
                for (int i10 = 0; i10 < i6; i10++) {
                    if (a6.e(i10, i9)) {
                        iArr[(i9 * i6) + i10] = -16777216;
                    } else {
                        iArr[(i9 * i6) + i10] = -1;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i6, g6, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i6, 0, 0, i6, g6);
            return createBitmap;
        } catch (Exception unused) {
            return null;
        }
    }
}
