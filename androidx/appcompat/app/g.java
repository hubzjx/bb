package androidx.appcompat.app;
/* loaded from: classes.dex */
class g {

    /* renamed from: d  reason: collision with root package name */
    private static g f411d;

    /* renamed from: a  reason: collision with root package name */
    public long f412a;

    /* renamed from: b  reason: collision with root package name */
    public long f413b;

    /* renamed from: c  reason: collision with root package name */
    public int f414c;

    g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g b() {
        if (f411d == null) {
            f411d = new g();
        }
        return f411d;
    }

    public void a(long j6, double d6, double d7) {
        float f6;
        float f7;
        double d8;
        double d9 = (0.01720197f * (((float) (j6 - 946728000000L)) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(d9) * 0.03341960161924362d) + d9 + (Math.sin(2.0f * f7) * 3.4906598739326E-4d) + (Math.sin(f7 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double round = ((float) Math.round((f6 - 9.0E-4f) - d8)) + 9.0E-4f + ((-d7) / 360.0d) + (Math.sin(d9) * 0.0053d) + (Math.sin(2.0d * sin) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d10 = 0.01745329238474369d * d6;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d10) * Math.sin(asin))) / (Math.cos(d10) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f414c = 1;
        } else if (sin2 > -1.0d) {
            double acos = (float) (Math.acos(sin2) / 6.283185307179586d);
            this.f412a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            long round2 = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            this.f413b = round2;
            if (round2 >= j6 || this.f412a <= j6) {
                this.f414c = 1;
                return;
            } else {
                this.f414c = 0;
                return;
            }
        } else {
            this.f414c = 0;
        }
        this.f412a = -1L;
        this.f413b = -1L;
    }
}
