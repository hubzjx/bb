package g;

import e.AbstractC0227j$a;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
/* renamed from: g.j$e1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0295j$e1 implements e.j$J {

    /* renamed from: a  reason: collision with root package name */
    j$B0 f10145a;

    /* renamed from: b  reason: collision with root package name */
    int f10146b;

    /* renamed from: c  reason: collision with root package name */
    e.j$J f10147c;

    /* renamed from: d  reason: collision with root package name */
    e.j$J f10148d;

    /* renamed from: e  reason: collision with root package name */
    Deque f10149e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0295j$e1(j$B0 j_b0) {
        this.f10145a = j_b0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static j$B0 a(Deque deque) {
        while (true) {
            ArrayDeque arrayDeque = (ArrayDeque) deque;
            j$B0 j_b0 = (j$B0) arrayDeque.pollFirst();
            if (j_b0 == null) {
                return null;
            }
            if (j_b0.t() != 0) {
                int t5 = j_b0.t();
                while (true) {
                    t5--;
                    if (t5 >= 0) {
                        arrayDeque.addFirst(j_b0.c(t5));
                    }
                }
            } else if (j_b0.count() > 0) {
                return j_b0;
            }
        }
    }

    @Override // e.j$J
    public final int characteristics() {
        return 64;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Deque d() {
        ArrayDeque arrayDeque = new ArrayDeque(8);
        int t5 = this.f10145a.t();
        while (true) {
            t5--;
            if (t5 < this.f10146b) {
                return arrayDeque;
            }
            arrayDeque.addFirst(this.f10145a.c(t5));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean e() {
        if (this.f10145a == null) {
            return false;
        }
        if (this.f10148d == null) {
            e.j$J j_j = this.f10147c;
            if (j_j == null) {
                Deque d6 = d();
                this.f10149e = d6;
                j$B0 a6 = a(d6);
                if (a6 == null) {
                    this.f10145a = null;
                    return false;
                }
                j_j = a6.spliterator();
            }
            this.f10148d = j_j;
            return true;
        }
        return true;
    }

    @Override // e.j$J
    public final long estimateSize() {
        long j6 = 0;
        if (this.f10145a == null) {
            return 0L;
        }
        e.j$J j_j = this.f10147c;
        if (j_j != null) {
            return j_j.estimateSize();
        }
        for (int i6 = this.f10146b; i6 < this.f10145a.t(); i6++) {
            j6 += this.f10145a.c(i6).count();
        }
        return j6;
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
    public /* bridge */ /* synthetic */ e.j$B trySplit() {
        return (e.j$B) trySplit();
    }

    @Override // e.j$J
    public /* bridge */ /* synthetic */ e.j$D trySplit() {
        return (e.j$D) trySplit();
    }

    @Override // e.j$J
    public /* bridge */ /* synthetic */ e.j$F trySplit() {
        return (e.j$F) trySplit();
    }

    @Override // e.j$J
    public /* bridge */ /* synthetic */ e.j$H trySplit() {
        return (e.j$H) trySplit();
    }

    @Override // e.j$J
    public final e.j$J trySplit() {
        j$B0 j_b0 = this.f10145a;
        if (j_b0 == null || this.f10148d != null) {
            return null;
        }
        e.j$J j_j = this.f10147c;
        if (j_j != null) {
            return j_j.trySplit();
        }
        if (this.f10146b < j_b0.t() - 1) {
            j$B0 j_b02 = this.f10145a;
            int i6 = this.f10146b;
            this.f10146b = i6 + 1;
            return j_b02.c(i6).spliterator();
        }
        j$B0 c6 = this.f10145a.c(this.f10146b);
        this.f10145a = c6;
        if (c6.t() == 0) {
            e.j$J spliterator = this.f10145a.spliterator();
            this.f10147c = spliterator;
            return spliterator.trySplit();
        }
        j$B0 j_b03 = this.f10145a;
        this.f10146b = 0 + 1;
        return j_b03.c(0).spliterator();
    }
}
