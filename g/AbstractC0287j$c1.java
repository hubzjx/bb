package g;

import java.util.Deque;
/* renamed from: g.j$c1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0287j$c1 extends AbstractC0295j$e1 implements e.j$H {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0287j$c1(j$A0 j_a0) {
        super(j_a0);
    }

    @Override // e.j$H
    /* renamed from: forEachRemaining */
    public final void l(Object obj) {
        if (this.f10145a == null) {
            return;
        }
        if (this.f10148d != null) {
            do {
            } while (p(obj));
            return;
        }
        e.j$J j_j = this.f10147c;
        if (j_j != null) {
            ((e.j$H) j_j).forEachRemaining(obj);
            return;
        }
        Deque d6 = d();
        while (true) {
            j$A0 j_a0 = (j$A0) AbstractC0295j$e1.a(d6);
            if (j_a0 == null) {
                this.f10145a = null;
                return;
            }
            j_a0.l(obj);
        }
    }

    @Override // e.j$H
    /* renamed from: tryAdvance */
    public final boolean p(Object obj) {
        j$A0 j_a0;
        if (e()) {
            boolean tryAdvance = ((e.j$H) this.f10148d).tryAdvance(obj);
            if (!tryAdvance) {
                if (this.f10147c == null && (j_a0 = (j$A0) AbstractC0295j$e1.a(this.f10149e)) != null) {
                    e.j$H spliterator = j_a0.spliterator();
                    this.f10148d = spliterator;
                    return spliterator.tryAdvance(obj);
                }
                this.f10145a = null;
            }
            return tryAdvance;
        }
        return false;
    }
}
