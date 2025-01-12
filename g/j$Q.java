package g;

import java.util.concurrent.CountedCompleter;
/* loaded from: classes2.dex */
final class j$Q extends CountedCompleter {

    /* renamed from: a  reason: collision with root package name */
    private e.j$J f10072a;

    /* renamed from: b  reason: collision with root package name */
    private final InterfaceC0284j$b2 f10073b;

    /* renamed from: c  reason: collision with root package name */
    private final AbstractC0350j$s0 f10074c;

    /* renamed from: d  reason: collision with root package name */
    private long f10075d;

    j$Q(j$Q j_q, e.j$J j_j) {
        super(j_q);
        this.f10072a = j_j;
        this.f10073b = j_q.f10073b;
        this.f10075d = j_q.f10075d;
        this.f10074c = j_q.f10074c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$Q(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, InterfaceC0284j$b2 interfaceC0284j$b2) {
        super(null);
        this.f10073b = interfaceC0284j$b2;
        this.f10074c = abstractC0350j$s0;
        this.f10072a = j_j;
        this.f10075d = 0L;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        e.j$J trySplit;
        e.j$J j_j = this.f10072a;
        long estimateSize = j_j.estimateSize();
        long j6 = this.f10075d;
        if (j6 == 0) {
            j6 = AbstractC0297j$f.f(estimateSize);
            this.f10075d = j6;
        }
        boolean d6 = j$P2.f10050j.d(this.f10074c.c0());
        InterfaceC0284j$b2 interfaceC0284j$b2 = this.f10073b;
        boolean z5 = false;
        j$Q j_q = this;
        while (true) {
            if (d6 && interfaceC0284j$b2.o()) {
                break;
            } else if (estimateSize <= j6 || (trySplit = j_j.trySplit()) == null) {
                break;
            } else {
                j$Q j_q2 = new j$Q(j_q, trySplit);
                j_q.addToPendingCount(1);
                if (z5) {
                    j_j = trySplit;
                } else {
                    j$Q j_q3 = j_q;
                    j_q = j_q2;
                    j_q2 = j_q3;
                }
                z5 = !z5;
                j_q.fork();
                j_q = j_q2;
                estimateSize = j_j.estimateSize();
            }
        }
        j_q.f10074c.R(j_j, interfaceC0284j$b2);
        j_q.f10072a = null;
        j_q.propagateCompletion();
    }
}
