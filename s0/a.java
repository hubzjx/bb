package s0;

import android.graphics.Color;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private float f13089a;

    /* renamed from: b  reason: collision with root package name */
    private float f13090b;

    /* renamed from: c  reason: collision with root package name */
    private float[] f13091c = new float[3];

    /* renamed from: d  reason: collision with root package name */
    private float[] f13092d;

    /* renamed from: e  reason: collision with root package name */
    private int f13093e;

    public a(float f6, float f7, float[] fArr) {
        f(f6, f7, fArr);
    }

    public int a() {
        return this.f13093e;
    }

    public float[] b() {
        return this.f13091c;
    }

    public float[] c(float f6) {
        if (this.f13092d == null) {
            this.f13092d = (float[]) this.f13091c.clone();
        }
        float[] fArr = this.f13092d;
        float[] fArr2 = this.f13091c;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = f6;
        return fArr;
    }

    public float d() {
        return this.f13089a;
    }

    public float e() {
        return this.f13090b;
    }

    public void f(float f6, float f7, float[] fArr) {
        this.f13089a = f6;
        this.f13090b = f7;
        float[] fArr2 = this.f13091c;
        fArr2[0] = fArr[0];
        fArr2[1] = fArr[1];
        fArr2[2] = fArr[2];
        this.f13093e = Color.HSVToColor(fArr2);
    }

    public double g(float f6, float f7) {
        double d6 = this.f13089a - f6;
        double d7 = this.f13090b - f7;
        return (d6 * d6) + (d7 * d7);
    }
}
