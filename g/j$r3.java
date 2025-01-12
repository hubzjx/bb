package g;

import e.AbstractC0227j$a;
import java.util.Comparator;
/* loaded from: classes2.dex */
abstract class j$r3 extends j$t3 implements e.j$H {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j$r3(e.j$H j_h, long j6, long j7) {
        super(j_h, j6, j7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$r3(e.j$H j_h, j$r3 j_r3) {
        super(j_h, j_r3);
    }

    @Override // e.j$H
    /* renamed from: forEachRemaining */
    public final void l(Object obj) {
        obj.getClass();
        j$V2 j_v2 = null;
        while (true) {
            int w5 = w();
            if (w5 == 1) {
                return;
            }
            e.j$J j_j = this.f10277a;
            if (w5 != 2) {
                ((e.j$H) j_j).forEachRemaining(obj);
                return;
            }
            if (j_v2 == null) {
                j_v2 = y();
            } else {
                j_v2.f10097b = 0;
            }
            long j6 = 0;
            while (((e.j$H) j_j).tryAdvance(j_v2)) {
                j6++;
                if (j6 >= 128) {
                    break;
                }
            }
            if (j6 == 0) {
                return;
            }
            j_v2.b(obj, t(j6));
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

    @Override // e.j$H
    /* renamed from: tryAdvance */
    public final boolean p(Object obj) {
        obj.getClass();
        while (w() != 1 && ((e.j$H) this.f10277a).tryAdvance(this)) {
            if (t(1L) == 1) {
                x(obj);
                return true;
            }
        }
        return false;
    }

    protected abstract void x(Object obj);

    protected abstract j$V2 y();
}
