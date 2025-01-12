package j$.util.concurrent;

import e.AbstractC0227j$a;
import e.j$B;
import f.InterfaceC0257j$e;
import f.InterfaceC0261j$i;
import java.util.Comparator;
/* loaded from: classes2.dex */
final class x implements j$B {

    /* renamed from: a  reason: collision with root package name */
    long f11117a;

    /* renamed from: b  reason: collision with root package name */
    final long f11118b;

    /* renamed from: c  reason: collision with root package name */
    final double f11119c;

    /* renamed from: d  reason: collision with root package name */
    final double f11120d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(long j6, long j7, double d6, double d7) {
        this.f11117a = j6;
        this.f11118b = j7;
        this.f11119c = d6;
        this.f11120d = d7;
    }

    @Override // e.j$B, e.j$H, e.j$J
    /* renamed from: a */
    public final x trySplit() {
        long j6 = this.f11117a;
        long j7 = (this.f11118b + j6) >>> 1;
        if (j7 <= j6) {
            return null;
        }
        this.f11117a = j7;
        return new x(j6, j7, this.f11119c, this.f11120d);
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.d(this, interfaceC0257j$e);
    }

    @Override // e.j$J
    public final int characteristics() {
        return 17728;
    }

    @Override // e.j$J
    public final long estimateSize() {
        return this.f11118b - this.f11117a;
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
    /* renamed from: k */
    public final void forEachRemaining(InterfaceC0261j$i interfaceC0261j$i) {
        interfaceC0261j$i.getClass();
        long j6 = this.f11117a;
        long j7 = this.f11118b;
        if (j6 < j7) {
            this.f11117a = j7;
            A b6 = A.b();
            do {
                interfaceC0261j$i.d(b6.d(this.f11119c, this.f11120d));
                j6++;
            } while (j6 < j7);
        }
    }

    @Override // e.j$H
    /* renamed from: n */
    public final boolean tryAdvance(InterfaceC0261j$i interfaceC0261j$i) {
        interfaceC0261j$i.getClass();
        long j6 = this.f11117a;
        if (j6 < this.f11118b) {
            interfaceC0261j$i.d(A.b().d(this.f11119c, this.f11120d));
            this.f11117a = j6 + 1;
            return true;
        }
        return false;
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.o(this, interfaceC0257j$e);
    }
}
