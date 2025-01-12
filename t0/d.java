package t0;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
/* loaded from: classes.dex */
public abstract class d {

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private Paint f13341a;

        private b() {
            this.f13341a = new Paint(1);
        }

        public Paint a() {
            return this.f13341a;
        }

        public b b(int i6) {
            this.f13341a.setColor(i6);
            return this;
        }

        public b c(Shader shader) {
            this.f13341a.setShader(shader);
            return this;
        }

        public b d(float f6) {
            this.f13341a.setStrokeWidth(f6);
            return this;
        }

        public b e(Paint.Style style) {
            this.f13341a.setStyle(style);
            return this;
        }

        public b f(PorterDuff.Mode mode) {
            this.f13341a.setXfermode(new PorterDuffXfermode(mode));
            return this;
        }
    }

    private static Bitmap a(int i6) {
        Paint a6 = c().a();
        Bitmap createBitmap = Bitmap.createBitmap(i6, i6, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int round = Math.round(i6 / 2.0f);
        for (int i7 = 0; i7 < 2; i7++) {
            int i8 = 0;
            while (i8 < 2) {
                a6.setColor((i7 + i8) % 2 == 0 ? -1 : -3092272);
                int i9 = i8 + 1;
                canvas.drawRect(i7 * round, i8 * round, (i7 + 1) * round, i9 * round, a6);
                i8 = i9;
            }
        }
        return createBitmap;
    }

    public static Shader b(int i6) {
        Bitmap a6 = a(Math.max(8, (i6 / 2) * 2));
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        return new BitmapShader(a6, tileMode, tileMode);
    }

    public static b c() {
        return new b();
    }
}
