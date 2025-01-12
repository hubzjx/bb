package j$.util.concurrent;

import e.AbstractC0227j$a;
import e.j$J;
import f.InterfaceC0257j$e;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j extends p implements j$J {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f11083i;

    /* renamed from: j  reason: collision with root package name */
    long f11084j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(l[] lVarArr, int i6, int i7, int i8, long j6, int i9) {
        super(lVarArr, i6, i7, i8);
        this.f11083i = i9;
        this.f11084j = j6;
    }

    @Override // e.j$J
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        switch (this.f11083i) {
            case 0:
                interfaceC0257j$e.getClass();
                while (true) {
                    l a6 = a();
                    if (a6 == null) {
                        return;
                    }
                    interfaceC0257j$e.j(a6.f11089b);
                }
            default:
                interfaceC0257j$e.getClass();
                while (true) {
                    l a7 = a();
                    if (a7 == null) {
                        return;
                    }
                    interfaceC0257j$e.j(a7.f11090c);
                }
        }
    }

    @Override // e.j$J
    public final int characteristics() {
        switch (this.f11083i) {
            case 0:
                return 4353;
            default:
                return 4352;
        }
    }

    @Override // e.j$J
    public final long estimateSize() {
        switch (this.f11083i) {
            case 0:
                return this.f11084j;
            default:
                return this.f11084j;
        }
    }

    @Override // e.j$J
    public final Comparator getComparator() {
        switch (this.f11083i) {
            case 0:
                throw new IllegalStateException();
            default:
                throw new IllegalStateException();
        }
    }

    @Override // e.j$J
    public final /* synthetic */ long getExactSizeIfKnown() {
        switch (this.f11083i) {
            case 0:
                return AbstractC0227j$a.h(this);
            default:
                return AbstractC0227j$a.h(this);
        }
    }

    @Override // e.j$J
    public final /* synthetic */ boolean hasCharacteristics(int i6) {
        switch (this.f11083i) {
            case 0:
                return AbstractC0227j$a.i(this, i6);
            default:
                return AbstractC0227j$a.i(this, i6);
        }
    }

    @Override // e.j$J
    public final boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        switch (this.f11083i) {
            case 0:
                interfaceC0257j$e.getClass();
                l a6 = a();
                if (a6 == null) {
                    return false;
                }
                interfaceC0257j$e.j(a6.f11089b);
                return true;
            default:
                interfaceC0257j$e.getClass();
                l a7 = a();
                if (a7 == null) {
                    return false;
                }
                interfaceC0257j$e.j(a7.f11090c);
                return true;
        }
    }

    @Override // e.j$J
    public final j$J trySplit() {
        switch (this.f11083i) {
            case 0:
                int i6 = this.f11101f;
                int i7 = this.f11102g;
                int i8 = (i6 + i7) >>> 1;
                if (i8 <= i6) {
                    return null;
                }
                l[] lVarArr = this.f11096a;
                int i9 = this.f11103h;
                this.f11102g = i8;
                long j6 = this.f11084j >>> 1;
                this.f11084j = j6;
                return new j(lVarArr, i9, i8, i7, j6, 0);
            default:
                int i10 = this.f11101f;
                int i11 = this.f11102g;
                int i12 = (i10 + i11) >>> 1;
                if (i12 <= i10) {
                    return null;
                }
                l[] lVarArr2 = this.f11096a;
                int i13 = this.f11103h;
                this.f11102g = i12;
                long j7 = this.f11084j >>> 1;
                this.f11084j = j7;
                return new j(lVarArr2, i13, i12, i11, j7, 1);
        }
    }
}
