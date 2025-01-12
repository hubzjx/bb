package u0;

import android.graphics.Color;
import android.graphics.Paint;
import java.util.List;
/* loaded from: classes.dex */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    private Paint f13417c = t0.d.c().a();

    /* renamed from: d  reason: collision with root package name */
    private float[] f13418d = new float[3];

    @Override // u0.c
    public void d() {
        int size = this.f13406b.size();
        float width = this.f13405a.f13413g.getWidth() / 2.0f;
        b bVar = this.f13405a;
        int i6 = bVar.f13407a;
        float f6 = bVar.f13408b;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            float f7 = (i8 / (i6 - 1)) * f6;
            float f8 = this.f13405a.f13409c;
            int e6 = e(f7, f8);
            int i9 = 0;
            while (i9 < e6) {
                double d6 = e6;
                int i10 = i6;
                double d7 = ((i9 * 6.283185307179586d) / d6) + ((3.141592653589793d / d6) * ((i8 + 1) % 2));
                double d8 = f7;
                float cos = ((float) (Math.cos(d7) * d8)) + width;
                float sin = ((float) (d8 * Math.sin(d7))) + width;
                float[] fArr = this.f13418d;
                fArr[0] = (float) ((d7 * 180.0d) / 3.141592653589793d);
                fArr[1] = f7 / f6;
                fArr[2] = this.f13405a.f13412f;
                this.f13417c.setColor(Color.HSVToColor(fArr));
                this.f13417c.setAlpha(f());
                b bVar2 = this.f13405a;
                bVar2.f13413g.drawCircle(cos, sin, f8 - bVar2.f13410d, this.f13417c);
                List list = this.f13406b;
                if (i7 >= size) {
                    list.add(new s0.a(cos, sin, this.f13418d));
                } else {
                    ((s0.a) list.get(i7)).f(cos, sin, this.f13418d);
                }
                i7++;
                i9++;
                i6 = i10;
            }
        }
    }
}
