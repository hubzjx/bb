package v0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import s0.h;
/* loaded from: classes.dex */
public class c extends a {

    /* renamed from: l  reason: collision with root package name */
    private int f13667l;

    /* renamed from: m  reason: collision with root package name */
    private Paint f13668m;

    /* renamed from: n  reason: collision with root package name */
    private Paint f13669n;

    /* renamed from: o  reason: collision with root package name */
    private Paint f13670o;

    /* renamed from: p  reason: collision with root package name */
    private com.flask.colorpicker.a f13671p;

    public c(Context context) {
        super(context);
        this.f13668m = t0.d.c().a();
        this.f13669n = t0.d.c().a();
        this.f13670o = t0.d.c().b(-1).f(PorterDuff.Mode.CLEAR).a();
    }

    @Override // v0.a
    protected void b(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        float[] fArr = new float[3];
        Color.colorToHSV(this.f13667l, fArr);
        int max = Math.max(2, width / 256);
        int i6 = 0;
        while (i6 <= width) {
            float f6 = i6;
            fArr[2] = f6 / (width - 1);
            this.f13668m.setColor(Color.HSVToColor(fArr));
            i6 += max;
            canvas.drawRect(f6, 0.0f, i6, height, this.f13668m);
        }
    }

    @Override // v0.a
    protected void c(Canvas canvas, float f6, float f7) {
        this.f13669n.setColor(h.c(this.f13667l, this.f13655i));
        if (this.f13656j) {
            canvas.drawCircle(f6, f7, this.f13653g, this.f13670o);
        }
        canvas.drawCircle(f6, f7, this.f13653g * 0.75f, this.f13669n);
    }

    @Override // v0.a
    protected void f(float f6) {
        com.flask.colorpicker.a aVar = this.f13671p;
        if (aVar != null) {
            aVar.setLightness(f6);
        }
    }

    public void setColor(int i6) {
        this.f13667l = i6;
        this.f13655i = h.f(i6);
        if (this.f13650d != null) {
            g();
            invalidate();
        }
    }

    public void setColorPicker(com.flask.colorpicker.a aVar) {
        this.f13671p = aVar;
    }
}
