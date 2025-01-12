package j$.util.concurrent;

import e.AbstractC0227j$a;
import e.j$J;
import f.InterfaceC0257j$e;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f extends p implements j$J {

    /* renamed from: i  reason: collision with root package name */
    final ConcurrentHashMap f11079i;

    /* renamed from: j  reason: collision with root package name */
    long f11080j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(l[] lVarArr, int i6, int i7, int i8, long j6, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i6, i7, i8);
        this.f11079i = concurrentHashMap;
        this.f11080j = j6;
    }

    @Override // e.j$J
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        interfaceC0257j$e.getClass();
        while (true) {
            l a6 = a();
            if (a6 == null) {
                return;
            }
            interfaceC0257j$e.j(new k(a6.f11089b, a6.f11090c, this.f11079i));
        }
    }

    @Override // e.j$J
    public final int characteristics() {
        return 4353;
    }

    @Override // e.j$J
    public final long estimateSize() {
        return this.f11080j;
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

    @Override // e.j$J
    public final boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        interfaceC0257j$e.getClass();
        l a6 = a();
        if (a6 == null) {
            return false;
        }
        interfaceC0257j$e.j(new k(a6.f11089b, a6.f11090c, this.f11079i));
        return true;
    }

    @Override // e.j$J
    public final j$J trySplit() {
        int i6 = this.f11101f;
        int i7 = this.f11102g;
        int i8 = (i6 + i7) >>> 1;
        if (i8 <= i6) {
            return null;
        }
        l[] lVarArr = this.f11096a;
        int i9 = this.f11103h;
        this.f11102g = i8;
        long j6 = this.f11080j >>> 1;
        this.f11080j = j6;
        return new f(lVarArr, i9, i8, i7, j6, this.f11079i);
    }
}
