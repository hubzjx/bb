package s0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
/* loaded from: classes.dex */
public class b extends ColorDrawable {

    /* renamed from: a  reason: collision with root package name */
    private float f13094a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f13095b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f13096c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f13097d;

    public b(int i6) {
        super(i6);
        this.f13095b = t0.d.c().e(Paint.Style.STROKE).d(this.f13094a).b(-6381922).a();
        this.f13096c = t0.d.c().e(Paint.Style.FILL).b(0).a();
        this.f13097d = t0.d.c().c(t0.d.b(26)).a();
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawColor(0);
        float width = canvas.getWidth() / 2.0f;
        float f6 = width / 8.0f;
        this.f13094a = f6;
        this.f13095b.setStrokeWidth(f6);
        this.f13096c.setColor(getColor());
        canvas.drawCircle(width, width, width - this.f13094a, this.f13097d);
        canvas.drawCircle(width, width, width - this.f13094a, this.f13096c);
        canvas.drawCircle(width, width, width - this.f13094a, this.f13095b);
    }

    @Override // android.graphics.drawable.ColorDrawable
    public void setColor(int i6) {
        super.setColor(i6);
        invalidateSelf();
    }
}
