package j0;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
abstract class d implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f11148a;

    /* renamed from: b  reason: collision with root package name */
    private final float f11149b;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(float[] fArr) {
        this.f11148a = fArr;
        this.f11149b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f6) {
        if (f6 >= 1.0f) {
            return 1.0f;
        }
        if (f6 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f11148a;
        int min = Math.min((int) ((fArr.length - 1) * f6), fArr.length - 2);
        float f7 = this.f11149b;
        float f8 = (f6 - (min * f7)) / f7;
        float[] fArr2 = this.f11148a;
        float f9 = fArr2[min];
        return f9 + (f8 * (fArr2[min + 1] - f9));
    }
}
