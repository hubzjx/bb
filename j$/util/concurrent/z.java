package j$.util.concurrent;

import e.AbstractC0227j$a;
import e.j$F;
import f.InterfaceC0257j$e;
import f.j$E;
import java.util.Comparator;
/* loaded from: classes2.dex */
final class z implements j$F {

    /* renamed from: a  reason: collision with root package name */
    long f11125a;

    /* renamed from: b  reason: collision with root package name */
    final long f11126b;

    /* renamed from: c  reason: collision with root package name */
    final long f11127c;

    /* renamed from: d  reason: collision with root package name */
    final long f11128d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(long j6, long j7, long j8, long j9) {
        this.f11125a = j6;
        this.f11126b = j7;
        this.f11127c = j8;
        this.f11128d = j9;
    }

    @Override // e.j$F, e.j$H, e.j$J
    /* renamed from: a */
    public final z trySplit() {
        long j6 = this.f11125a;
        long j7 = (this.f11126b + j6) >>> 1;
        if (j7 <= j6) {
            return null;
        }
        this.f11125a = j7;
        return new z(j6, j7, this.f11127c, this.f11128d);
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.f(this, interfaceC0257j$e);
    }

    @Override // e.j$H
    /* renamed from: c */
    public final void forEachRemaining(j$E j_e) {
        j_e.getClass();
        long j6 = this.f11125a;
        long j7 = this.f11126b;
        if (j6 < j7) {
            this.f11125a = j7;
            A b6 = A.b();
            do {
                j_e.f(b6.f(this.f11127c, this.f11128d));
                j6++;
            } while (j6 < j7);
        }
    }

    @Override // e.j$J
    public final int characteristics() {
        return 17728;
    }

    @Override // e.j$J
    public final long estimateSize() {
        return this.f11126b - this.f11125a;
    }

    @Override // e.j$J
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // e.j$J
    public final /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0227j$a.h(this);
    }

    @Override // e.j$J
    public final /* synthetic */ boolean hasCharacteristics(int i6) {
        return AbstractC0227j$a.i(this, i6);
    }

    @Override // e.j$H
    /* renamed from: p */
    public final boolean tryAdvance(j$E j_e) {
        j_e.getClass();
        long j6 = this.f11125a;
        if (j6 < this.f11126b) {
            j_e.f(A.b().f(this.f11127c, this.f11128d));
            this.f11125a = j6 + 1;
            return true;
        }
        return false;
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.s(this, interfaceC0257j$e);
    }
}
