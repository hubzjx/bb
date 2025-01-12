package g;

import e.AbstractC0227j$a;
import java.util.Comparator;
/* loaded from: classes2.dex */
abstract class j$l3 extends j$n3 implements e.j$H {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j$l3(e.j$H j_h, long j6, long j7) {
        super(j_h, j6, j7, 0L, Math.min(j_h.estimateSize(), j7));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$l3(e.j$H j_h, long j6, long j7, long j8, long j9) {
        super(j_h, j6, j7, j8, j9);
    }

    protected abstract Object d();

    @Override // e.j$H
    /* renamed from: forEachRemaining */
    public final void l(Object obj) {
        obj.getClass();
        long j6 = this.f10226e;
        long j7 = this.f10222a;
        if (j7 >= j6) {
            return;
        }
        long j8 = this.f10225d;
        if (j8 >= j6) {
            return;
        }
        if (j8 >= j7 && ((e.j$H) this.f10224c).estimateSize() + j8 <= this.f10223b) {
            ((e.j$H) this.f10224c).forEachRemaining(obj);
            this.f10225d = this.f10226e;
            return;
        }
        while (j7 > this.f10225d) {
            ((e.j$H) this.f10224c).tryAdvance(d());
            this.f10225d++;
        }
        while (this.f10225d < this.f10226e) {
            ((e.j$H) this.f10224c).tryAdvance(obj);
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

    @Override // e.j$H
    /* renamed from: tryAdvance */
    public final boolean p(Object obj) {
        long j6;
        obj.getClass();
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
            ((e.j$H) this.f10224c).tryAdvance(d());
            this.f10225d++;
        }
        if (j6 >= this.f10226e) {
            return false;
        }
        this.f10225d = j6 + 1;
        return ((e.j$H) this.f10224c).tryAdvance(obj);
    }
}
