package s3;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final float f13289a;

    /* renamed from: b  reason: collision with root package name */
    private final float f13290b;

    /* renamed from: c  reason: collision with root package name */
    private final float f13291c;

    /* renamed from: d  reason: collision with root package name */
    private final float f13292d;

    /* renamed from: e  reason: collision with root package name */
    private final float f13293e;

    /* renamed from: f  reason: collision with root package name */
    private final float f13294f;

    /* renamed from: g  reason: collision with root package name */
    private final float f13295g;

    /* renamed from: h  reason: collision with root package name */
    private final float f13296h;

    /* renamed from: i  reason: collision with root package name */
    private final float f13297i;

    private k(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        this.f13289a = f6;
        this.f13290b = f9;
        this.f13291c = f12;
        this.f13292d = f7;
        this.f13293e = f10;
        this.f13294f = f13;
        this.f13295g = f8;
        this.f13296h = f11;
        this.f13297i = f14;
    }

    public static k b(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21) {
        return d(f14, f15, f16, f17, f18, f19, f20, f21).e(c(f6, f7, f8, f9, f10, f11, f12, f13));
    }

    public static k c(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        return d(f6, f7, f8, f9, f10, f11, f12, f13).a();
    }

    public static k d(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        float f14 = ((f6 - f8) + f10) - f12;
        float f15 = ((f7 - f9) + f11) - f13;
        if (f14 == 0.0f && f15 == 0.0f) {
            return new k(f8 - f6, f10 - f8, f6, f9 - f7, f11 - f9, f7, 0.0f, 0.0f, 1.0f);
        }
        float f16 = f8 - f10;
        float f17 = f12 - f10;
        float f18 = f9 - f11;
        float f19 = f13 - f11;
        float f20 = (f16 * f19) - (f17 * f18);
        float f21 = ((f19 * f14) - (f17 * f15)) / f20;
        float f22 = ((f16 * f15) - (f14 * f18)) / f20;
        return new k((f21 * f8) + (f8 - f6), (f22 * f12) + (f12 - f6), f6, (f9 - f7) + (f21 * f9), (f13 - f7) + (f22 * f13), f7, f21, f22, 1.0f);
    }

    k a() {
        float f6 = this.f13293e;
        float f7 = this.f13297i;
        float f8 = this.f13294f;
        float f9 = this.f13296h;
        float f10 = (f6 * f7) - (f8 * f9);
        float f11 = this.f13295g;
        float f12 = this.f13292d;
        float f13 = (f8 * f11) - (f12 * f7);
        float f14 = (f12 * f9) - (f6 * f11);
        float f15 = this.f13291c;
        float f16 = this.f13290b;
        float f17 = (f15 * f9) - (f16 * f7);
        float f18 = this.f13289a;
        return new k(f10, f13, f14, f17, (f7 * f18) - (f15 * f11), (f11 * f16) - (f9 * f18), (f16 * f8) - (f15 * f6), (f15 * f12) - (f8 * f18), (f18 * f6) - (f16 * f12));
    }

    k e(k kVar) {
        float f6 = this.f13289a;
        float f7 = kVar.f13289a;
        float f8 = this.f13292d;
        float f9 = kVar.f13290b;
        float f10 = this.f13295g;
        float f11 = kVar.f13291c;
        float f12 = (f6 * f7) + (f8 * f9) + (f10 * f11);
        float f13 = kVar.f13292d;
        float f14 = kVar.f13293e;
        float f15 = kVar.f13294f;
        float f16 = (f6 * f13) + (f8 * f14) + (f10 * f15);
        float f17 = kVar.f13295g;
        float f18 = kVar.f13296h;
        float f19 = kVar.f13297i;
        float f20 = (f6 * f17) + (f8 * f18) + (f10 * f19);
        float f21 = this.f13290b;
        float f22 = this.f13293e;
        float f23 = this.f13296h;
        float f24 = (f23 * f19) + (f21 * f17) + (f22 * f18);
        float f25 = this.f13291c;
        float f26 = this.f13294f;
        float f27 = (f7 * f25) + (f9 * f26);
        float f28 = this.f13297i;
        return new k(f12, f16, f20, (f21 * f7) + (f22 * f9) + (f23 * f11), (f21 * f13) + (f22 * f14) + (f23 * f15), f24, (f11 * f28) + f27, (f13 * f25) + (f14 * f26) + (f15 * f28), (f25 * f17) + (f26 * f18) + (f28 * f19));
    }

    public void f(float[] fArr) {
        int length = fArr.length;
        float f6 = this.f13289a;
        float f7 = this.f13290b;
        float f8 = this.f13291c;
        float f9 = this.f13292d;
        float f10 = this.f13293e;
        float f11 = this.f13294f;
        float f12 = this.f13295g;
        float f13 = this.f13296h;
        float f14 = this.f13297i;
        for (int i6 = 0; i6 < length; i6 += 2) {
            float f15 = fArr[i6];
            int i7 = i6 + 1;
            float f16 = fArr[i7];
            float f17 = (f8 * f15) + (f11 * f16) + f14;
            fArr[i6] = (((f6 * f15) + (f9 * f16)) + f12) / f17;
            fArr[i7] = (((f15 * f7) + (f16 * f10)) + f13) / f17;
        }
    }
}
