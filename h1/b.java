package h1;

import c1.x;
import c1.y;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
final class b implements g {

    /* renamed from: a  reason: collision with root package name */
    private final long f10595a;

    /* renamed from: b  reason: collision with root package name */
    private final o f10596b;

    /* renamed from: c  reason: collision with root package name */
    private final o f10597c;

    /* renamed from: d  reason: collision with root package name */
    private long f10598d;

    public b(long j6, long j7, long j8) {
        this.f10598d = j6;
        this.f10595a = j8;
        o oVar = new o();
        this.f10596b = oVar;
        o oVar2 = new o();
        this.f10597c = oVar2;
        oVar.a(0L);
        oVar2.a(j7);
    }

    public boolean a(long j6) {
        o oVar = this.f10596b;
        return j6 - oVar.b(oVar.c() - 1) < 100000;
    }

    @Override // h1.g
    public long b(long j6) {
        return this.f10596b.b(s0.f(this.f10597c, j6, true, true));
    }

    public void c(long j6, long j7) {
        if (a(j6)) {
            return;
        }
        this.f10596b.a(j6);
        this.f10597c.a(j7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(long j6) {
        this.f10598d = j6;
    }

    @Override // h1.g
    public long e() {
        return this.f10595a;
    }

    @Override // c1.x
    public boolean f() {
        return true;
    }

    @Override // c1.x
    public x.a i(long j6) {
        int f6 = s0.f(this.f10596b, j6, true, true);
        y yVar = new y(this.f10596b.b(f6), this.f10597c.b(f6));
        if (yVar.f3253a == j6 || f6 == this.f10596b.c() - 1) {
            return new x.a(yVar);
        }
        int i6 = f6 + 1;
        return new x.a(yVar, new y(this.f10596b.b(i6), this.f10597c.b(i6)));
    }

    @Override // c1.x
    public long j() {
        return this.f10598d;
    }
}
