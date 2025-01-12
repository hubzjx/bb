package g3;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
/* loaded from: classes.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f10470i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    private static final float[] f10471j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f10472k = new int[4];

    /* renamed from: l  reason: collision with root package name */
    private static final float[] f10473l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private final Paint f10474a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f10475b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f10476c;

    /* renamed from: d  reason: collision with root package name */
    private int f10477d;

    /* renamed from: e  reason: collision with root package name */
    private int f10478e;

    /* renamed from: f  reason: collision with root package name */
    private int f10479f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f10480g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f10481h;

    public a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i6, float f6, float f7) {
        boolean z5 = f7 < 0.0f;
        Path path = this.f10480g;
        if (z5) {
            int[] iArr = f10472k;
            iArr[0] = 0;
            iArr[1] = this.f10479f;
            iArr[2] = this.f10478e;
            iArr[3] = this.f10477d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f6, f7);
            path.close();
            float f8 = -i6;
            rectF.inset(f8, f8);
            int[] iArr2 = f10472k;
            iArr2[0] = 0;
            iArr2[1] = this.f10477d;
            iArr2[2] = this.f10478e;
            iArr2[3] = this.f10479f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f9 = 1.0f - (i6 / width);
        float[] fArr = f10473l;
        fArr[1] = f9;
        fArr[2] = ((1.0f - f9) / 2.0f) + f9;
        this.f10475b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f10472k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z5) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f10481h);
        }
        canvas.drawArc(rectF, f6, f7, true, this.f10475b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i6) {
        rectF.bottom += i6;
        rectF.offset(0.0f, -i6);
        int[] iArr = f10470i;
        iArr[0] = this.f10479f;
        iArr[1] = this.f10478e;
        iArr[2] = this.f10477d;
        Paint paint = this.f10476c;
        float f6 = rectF.left;
        paint.setShader(new LinearGradient(f6, rectF.top, f6, rectF.bottom, iArr, f10471j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f10476c);
        canvas.restore();
    }

    public Paint c() {
        return this.f10474a;
    }

    public void d(int i6) {
        this.f10477d = w.a.h(i6, 68);
        this.f10478e = w.a.h(i6, 20);
        this.f10479f = w.a.h(i6, 0);
        this.f10474a.setColor(this.f10477d);
    }

    public a(int i6) {
        this.f10480g = new Path();
        this.f10481h = new Paint();
        this.f10474a = new Paint();
        d(i6);
        this.f10481h.setColor(0);
        Paint paint = new Paint(4);
        this.f10475b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f10476c = new Paint(paint);
    }
}
