package j$.util.concurrent;

import e.AbstractC0227j$a;
import e.j$D;
import f.InterfaceC0257j$e;
import f.InterfaceC0272j$t;
import java.util.Comparator;
/* loaded from: classes2.dex */
final class y implements j$D {

    /* renamed from: a  reason: collision with root package name */
    long f11121a;

    /* renamed from: b  reason: collision with root package name */
    final long f11122b;

    /* renamed from: c  reason: collision with root package name */
    final int f11123c;

    /* renamed from: d  reason: collision with root package name */
    final int f11124d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(long j6, long j7, int i6, int i7) {
        this.f11121a = j6;
        this.f11122b = j7;
        this.f11123c = i6;
        this.f11124d = i7;
    }

    @Override // e.j$D, e.j$H, e.j$J
    /* renamed from: a */
    public final y trySplit() {
        long j6 = this.f11121a;
        long j7 = (this.f11122b + j6) >>> 1;
        if (j7 <= j6) {
            return null;
        }
        this.f11121a = j7;
        return new y(j6, j7, this.f11123c, this.f11124d);
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.e(this, interfaceC0257j$e);
    }

    @Override // e.j$J
    public final int characteristics() {
        return 17728;
    }

    @Override // e.j$J
    public final long estimateSize() {
        return this.f11122b - this.f11121a;
    }

    @Override // e.j$H
    /* renamed from: g */
    public final boolean tryAdvance(InterfaceC0272j$t interfaceC0272j$t) {
        interfaceC0272j$t.getClass();
        long j6 = this.f11121a;
        if (j6 < this.f11122b) {
            interfaceC0272j$t.e(A.b().e(this.f11123c, this.f11124d));
            this.f11121a = j6 + 1;
            return true;
        }
        return false;
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
    /* renamed from: l */
    public final void forEachRemaining(InterfaceC0272j$t interfaceC0272j$t) {
        interfaceC0272j$t.getClass();
        long j6 = this.f11121a;
        long j7 = this.f11122b;
        if (j6 < j7) {
            this.f11121a = j7;
            A b6 = A.b();
            do {
                interfaceC0272j$t.e(b6.e(this.f11123c, this.f11124d));
                j6++;
            } while (j6 < j7);
        }
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.q(this, interfaceC0257j$e);
    }
}
