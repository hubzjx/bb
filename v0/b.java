package v0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import s0.h;
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: l  reason: collision with root package name */
    public int f13658l;

    /* renamed from: m  reason: collision with root package name */
    private Paint f13659m;

    /* renamed from: n  reason: collision with root package name */
    private Paint f13660n;

    /* renamed from: o  reason: collision with root package name */
    private Paint f13661o;

    /* renamed from: p  reason: collision with root package name */
    private Paint f13662p;

    /* renamed from: q  reason: collision with root package name */
    private Paint f13663q;

    /* renamed from: r  reason: collision with root package name */
    private Bitmap f13664r;

    /* renamed from: s  reason: collision with root package name */
    private Canvas f13665s;

    /* renamed from: t  reason: collision with root package name */
    private com.flask.colorpicker.a f13666t;

    public b(Context context) {
        super(context);
        this.f13659m = t0.d.c().a();
        this.f13660n = t0.d.c().a();
        this.f13661o = t0.d.c().a();
        this.f13662p = t0.d.c().b(-1).f(PorterDuff.Mode.CLEAR).a();
        this.f13663q = t0.d.c().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v0.a
    public void a() {
        super.a();
        this.f13659m.setShader(t0.d.b(this.f13654h * 2));
        this.f13664r = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.f13665s = new Canvas(this.f13664r);
    }

    @Override // v0.a
    protected void b(Canvas canvas) {
        int width = canvas.getWidth();
        float height = canvas.getHeight();
        canvas.drawRect(0.0f, 0.0f, width, height, this.f13659m);
        int max = Math.max(2, width / 256);
        int i6 = 0;
        while (i6 <= width) {
            float f6 = i6;
            this.f13660n.setColor(this.f13658l);
            this.f13660n.setAlpha(Math.round((f6 / (width - 1)) * 255.0f));
            i6 += max;
            canvas.drawRect(f6, 0.0f, i6, height, this.f13660n);
        }
    }

    @Override // v0.a
    protected void c(Canvas canvas, float f6, float f7) {
        this.f13661o.setColor(this.f13658l);
        this.f13661o.setAlpha(Math.round(this.f13655i * 255.0f));
        if (this.f13656j) {
            canvas.drawCircle(f6, f7, this.f13653g, this.f13662p);
        }
        if (this.f13655i >= 1.0f) {
            canvas.drawCircle(f6, f7, this.f13653g * 0.75f, this.f13661o);
            return;
        }
        this.f13665s.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f13665s.drawCircle(f6, f7, (this.f13653g * 0.75f) + 4.0f, this.f13659m);
        this.f13665s.drawCircle(f6, f7, (this.f13653g * 0.75f) + 4.0f, this.f13661o);
        Paint a6 = t0.d.c().b(-1).e(Paint.Style.STROKE).d(6.0f).f(PorterDuff.Mode.CLEAR).a();
        this.f13663q = a6;
        this.f13665s.drawCircle(f6, f7, (this.f13653g * 0.75f) + (a6.getStrokeWidth() / 2.0f), this.f13663q);
        canvas.drawBitmap(this.f13664r, 0.0f, 0.0f, (Paint) null);
    }

    @Override // v0.a
    protected void f(float f6) {
        com.flask.colorpicker.a aVar = this.f13666t;
        if (aVar != null) {
            aVar.setAlphaValue(f6);
        }
    }

    public void setColor(int i6) {
        this.f13658l = i6;
        this.f13655i = h.d(i6);
        if (this.f13650d != null) {
            g();
            invalidate();
        }
    }

    public void setColorPicker(com.flask.colorpicker.a aVar) {
        this.f13666t = aVar;
    }
}
