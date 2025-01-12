package w2;

import android.graphics.Canvas;
import android.os.Build;
/* loaded from: classes.dex */
public abstract class a {
    public static int a(Canvas canvas, float f6, float f7, float f8, float f9, int i6) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f6, f7, f8, f9, i6) : canvas.saveLayerAlpha(f6, f7, f8, f9, i6, 31);
    }
}
