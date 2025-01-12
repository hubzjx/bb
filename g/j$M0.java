package g;

import f.InterfaceC0257j$e;
import f.InterfaceC0274j$v;
import java.util.Deque;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$M0 extends j$C0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j$M0(j$B0 j_b0, j$B0 j_b02) {
        super(j_b0, j_b02);
    }

    @Override // g.j$B0
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        this.f9964a.b(interfaceC0257j$e);
        this.f9965b.b(interfaceC0257j$e);
    }

    @Override // g.j$B0
    public final Object[] n(InterfaceC0274j$v interfaceC0274j$v) {
        long count = count();
        if (count < 2147483639) {
            Object[] objArr = (Object[]) interfaceC0274j$v.r((int) count);
            p(objArr, 0);
            return objArr;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // g.j$B0
    public final void p(Object[] objArr, int i6) {
        objArr.getClass();
        j$B0 j_b0 = this.f9964a;
        j_b0.p(objArr, i6);
        this.f9965b.p(objArr, i6 + ((int) j_b0.count()));
    }

    @Override // g.j$B0
    public final j$B0 r(long j6, long j7, InterfaceC0274j$v interfaceC0274j$v) {
        if (j6 == 0 && j7 == count()) {
            return this;
        }
        long count = this.f9964a.count();
        if (j6 >= count) {
            return this.f9965b.r(j6 - count, j7 - count, interfaceC0274j$v);
        }
        int i6 = (j7 > count ? 1 : (j7 == count ? 0 : -1));
        j$B0 j_b0 = this.f9964a;
        return i6 <= 0 ? j_b0.r(j6, j7, interfaceC0274j$v) : AbstractC0350j$s0.Q(1, j_b0.r(j6, count, interfaceC0274j$v), this.f9965b.r(0L, j7 - count, interfaceC0274j$v));
    }

    @Override // g.j$B0
    public final e.j$J spliterator() {
        return new AbstractC0295j$e1(this) { // from class: g.j$d1
            @Override // e.j$J
            public final void b(InterfaceC0257j$e interfaceC0257j$e) {
                if (this.f10145a == null) {
                    return;
                }
                if (this.f10148d != null) {
                    do {
                    } while (r(interfaceC0257j$e));
                    return;
                }
                e.j$J j_j = this.f10147c;
                if (j_j != null) {
                    j_j.b(interfaceC0257j$e);
                    return;
                }
                Deque d6 = d();
                while (true) {
                    j$B0 a6 = AbstractC0295j$e1.a(d6);
                    if (a6 == null) {
                        this.f10145a = null;
                        return;
                    }
                    a6.b(interfaceC0257j$e);
                }
            }

            @Override // e.j$J
            public final boolean r(InterfaceC0257j$e interfaceC0257j$e) {
                j$B0 a6;
                if (e()) {
                    boolean r5 = this.f10148d.r(interfaceC0257j$e);
                    if (!r5) {
                        if (this.f10147c == null && (a6 = AbstractC0295j$e1.a(this.f10149e)) != null) {
                            e.j$J spliterator = a6.spliterator();
                            this.f10148d = spliterator;
                            return spliterator.r(interfaceC0257j$e);
                        }
                        this.f10145a = null;
                    }
                    return r5;
                }
                return false;
            }
        };
    }

    public final String toString() {
        return count() < 32 ? String.format("ConcNode[%s.%s]", this.f9964a, this.f9965b) : String.format("ConcNode[size=%d]", Long.valueOf(count()));
    }
}
