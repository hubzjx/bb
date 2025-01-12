package g;

import e.AbstractC0227j$a;
import f.InterfaceC0257j$e;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$m3 extends j$n3 implements e.j$J {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j$m3(e.j$J j_j, long j6, long j7) {
        super(j_j, j6, j7, 0L, Math.min(j_j.estimateSize(), j7));
    }

    private j$m3(e.j$J j_j, long j6, long j7, long j8, long j9) {
        super(j_j, j6, j7, j8, j9);
    }

    @Override // g.j$n3
    protected final e.j$J a(e.j$J j_j, long j6, long j7, long j8, long j9) {
        return new j$m3(j_j, j6, j7, j8, j9);
    }

    @Override // e.j$J
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        interfaceC0257j$e.getClass();
        long j6 = this.f10226e;
        long j7 = this.f10222a;
        if (j7 >= j6) {
            return;
        }
        long j8 = this.f10225d;
        if (j8 >= j6) {
            return;
        }
        if (j8 >= j7 && this.f10224c.estimateSize() + j8 <= this.f10223b) {
            this.f10224c.b(interfaceC0257j$e);
            this.f10225d = this.f10226e;
            return;
        }
        while (j7 > this.f10225d) {
            this.f10224c.r(new j$F0(12));
            this.f10225d++;
        }
        while (this.f10225d < this.f10226e) {
            this.f10224c.r(interfaceC0257j$e);
            this.f10225d++;
        }
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
        long j6;
        interfaceC0257j$e.getClass();
        long j7 = this.f10226e;
        long j8 = this.f10222a;
        if (j8 >= j7) {
            return false;
        }
        while (true) {
            j6 = this.f10225d;
            if (j8 <= j6) {
                break;
            }
            this.f10224c.r(new j$F0(13));
            this.f10225d++;
        }
        if (j6 >= this.f10226e) {
            return false;
        }
        this.f10225d = j6 + 1;
        return this.f10224c.r(interfaceC0257j$e);
    }
}
