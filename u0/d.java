package u0;

import android.graphics.Color;
import android.graphics.Paint;
import java.util.List;
/* loaded from: classes.dex */
public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    private Paint f13414c = t0.d.c().a();

    /* renamed from: d  reason: collision with root package name */
    private float[] f13415d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    private float f13416e = 1.2f;

    @Override // u0.c
    public void d() {
        int size = this.f13406b.size();
        float f6 = 2.0f;
        float width = this.f13405a.f13413g.getWidth() / 2.0f;
        b bVar = this.f13405a;
        int i6 = bVar.f13407a;
        float f7 = bVar.f13410d;
        float f8 = bVar.f13408b;
        float f9 = bVar.f13409c;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            float f10 = i7;
            float f11 = i6;
            float f12 = (f10 / (i6 - 1)) * f8;
            float max = Math.max(1.5f + f7, (i7 == 0 ? 0.0f : ((f10 - (f11 / f6)) / f11) * this.f13416e * f9) + f9);
            int min = Math.min(e(f12, max), i6 * 2);
            int i9 = 0;
            while (i9 < min) {
                float f13 = f9;
                int i10 = i7;
                double d6 = min;
                int i11 = min;
                int i12 = i9;
                double d7 = ((i9 * 6.283185307179586d) / d6) + ((3.141592653589793d / d6) * ((i10 + 1) % 2));
                double d8 = f12;
                float cos = ((float) (Math.cos(d7) * d8)) + width;
                float sin = ((float) (d8 * Math.sin(d7))) + width;
                float[] fArr = this.f13415d;
                fArr[0] = (float) ((d7 * 180.0d) / 3.141592653589793d);
                fArr[1] = f12 / f8;
                fArr[2] = this.f13405a.f13412f;
                this.f13414c.setColor(Color.HSVToColor(fArr));
                this.f13414c.setAlpha(f());
                this.f13405a.f13413g.drawCircle(cos, sin, max - f7, this.f13414c);
                List list = this.f13406b;
                if (i8 >= size) {
                    list.add(new s0.a(cos, sin, this.f13415d));
                } else {
                    ((s0.a) list.get(i8)).f(cos, sin, this.f13415d);
                }
                i8++;
                i9 = i12 + 1;
                i7 = i10;
                f9 = f13;
                min = i11;
            }
            i7++;
            f9 = f9;
            f6 = 2.0f;
        }
    }
}
