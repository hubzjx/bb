package z1;

import a2.h;
/* loaded from: classes.dex */
public final class f implements d {

    /* renamed from: a  reason: collision with root package name */
    private final c1.d f14349a;

    /* renamed from: b  reason: collision with root package name */
    private final long f14350b;

    public f(c1.d dVar, long j6) {
        this.f14349a = dVar;
        this.f14350b = j6;
    }

    @Override // z1.d
    public long a(long j6, long j7) {
        return this.f14349a.a(j6 + this.f14350b);
    }

    @Override // z1.d
    public long b(long j6) {
        return this.f14349a.f3190e[(int) j6] - this.f14350b;
    }

    @Override // z1.d
    public long c(long j6, long j7) {
        return this.f14349a.f3189d[(int) j6];
    }

    @Override // z1.d
    public h d(long j6) {
        c1.d dVar = this.f14349a;
        int i6 = (int) j6;
        return new h(null, dVar.f3188c[i6], dVar.f3187b[i6]);
    }

    @Override // z1.d
    public boolean e() {
        return true;
    }

    @Override // z1.d
    public long f() {
        return 0L;
    }

    @Override // z1.d
    public int g(long j6) {
        return this.f14349a.f3186a;
    }
}
