package e;

import f.InterfaceC0261j$i;
/* renamed from: e.j$f  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0232j$f implements InterfaceC0261j$i {

    /* renamed from: a  reason: collision with root package name */
    private double f9290a;

    /* renamed from: b  reason: collision with root package name */
    private double f9291b;
    private long count;
    private double sum;
    private double min = Double.POSITIVE_INFINITY;
    private double max = Double.NEGATIVE_INFINITY;

    public final void b(C0232j$f c0232j$f) {
        this.count += c0232j$f.count;
        this.f9291b += c0232j$f.f9291b;
        double d6 = c0232j$f.sum - this.f9290a;
        double d7 = this.sum;
        double d8 = d7 + d6;
        double d9 = (d8 - d7) - d6;
        this.f9290a = d9;
        double d10 = c0232j$f.f9290a - d9;
        double d11 = d8 + d10;
        this.f9290a = (d11 - d8) - d10;
        this.sum = d11;
        this.min = Math.min(this.min, c0232j$f.min);
        this.max = Math.max(this.max, c0232j$f.max);
    }

    public final long c() {
        return this.count;
    }

    @Override // f.InterfaceC0261j$i
    public final void d(double d6) {
        this.count++;
        this.f9291b += d6;
        double d7 = d6 - this.f9290a;
        double d8 = this.sum;
        double d9 = d8 + d7;
        this.f9290a = (d9 - d8) - d7;
        this.sum = d9;
        this.min = Math.min(this.min, d6);
        this.max = Math.max(this.max, d6);
    }

    public final double e() {
        return this.max;
    }

    public final double f() {
        return this.min;
    }

    public final double g() {
        double d6 = this.sum + this.f9290a;
        return (Double.isNaN(d6) && Double.isInfinite(this.f9291b)) ? this.f9291b : d6;
    }

    public final String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = C0232j$f.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Double.valueOf(g());
        objArr[3] = Double.valueOf(this.min);
        objArr[4] = Double.valueOf(this.count > 0 ? g() / this.count : 0.0d);
        objArr[5] = Double.valueOf(this.max);
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", objArr);
    }
}
