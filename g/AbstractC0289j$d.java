package g;

import java.util.concurrent.atomic.AtomicReference;
/* renamed from: g.j$d  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0289j$d extends AbstractC0297j$f {

    /* renamed from: h  reason: collision with root package name */
    protected final AtomicReference f10133h;

    /* renamed from: i  reason: collision with root package name */
    protected volatile boolean f10134i;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0289j$d(AbstractC0289j$d abstractC0289j$d, e.j$J j_j) {
        super(abstractC0289j$d, j_j);
        this.f10133h = abstractC0289j$d.f10133h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0289j$d(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j) {
        super(abstractC0350j$s0, j_j);
        this.f10133h = new AtomicReference(null);
    }

    @Override // g.AbstractC0297j$f
    public final Object b() {
        if (c() == null) {
            Object obj = this.f10133h.get();
            return obj == null ? i() : obj;
        }
        return super.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
        r8 = r7.a();
     */
    @Override // g.AbstractC0297j$f, java.util.concurrent.CountedCompleter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void compute() {
        Object obj;
        e.j$J trySplit;
        e.j$J j_j = this.f10155b;
        long estimateSize = j_j.estimateSize();
        long j6 = this.f10156c;
        if (j6 == 0) {
            j6 = AbstractC0297j$f.f(estimateSize);
            this.f10156c = j6;
        }
        AtomicReference atomicReference = this.f10133h;
        boolean z5 = false;
        AbstractC0289j$d abstractC0289j$d = this;
        while (true) {
            obj = atomicReference.get();
            if (obj != null) {
                break;
            }
            boolean z6 = abstractC0289j$d.f10134i;
            if (!z6) {
                AbstractC0297j$f c6 = abstractC0289j$d.c();
                while (true) {
                    AbstractC0289j$d abstractC0289j$d2 = (AbstractC0289j$d) c6;
                    if (z6 || abstractC0289j$d2 == null) {
                        break;
                    }
                    z6 = abstractC0289j$d2.f10134i;
                    c6 = abstractC0289j$d2.c();
                }
            }
            if (z6) {
                obj = abstractC0289j$d.i();
                break;
            } else if (estimateSize <= j6 || (trySplit = j_j.trySplit()) == null) {
                break;
            } else {
                AbstractC0289j$d abstractC0289j$d3 = (AbstractC0289j$d) abstractC0289j$d.d(trySplit);
                abstractC0289j$d.f10157d = abstractC0289j$d3;
                AbstractC0289j$d abstractC0289j$d4 = (AbstractC0289j$d) abstractC0289j$d.d(j_j);
                abstractC0289j$d.f10158e = abstractC0289j$d4;
                abstractC0289j$d.setPendingCount(1);
                if (z5) {
                    j_j = trySplit;
                    abstractC0289j$d = abstractC0289j$d3;
                    abstractC0289j$d3 = abstractC0289j$d4;
                } else {
                    abstractC0289j$d = abstractC0289j$d4;
                }
                z5 = !z5;
                abstractC0289j$d3.fork();
                estimateSize = j_j.estimateSize();
            }
        }
        abstractC0289j$d.e(obj);
        abstractC0289j$d.tryComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.AbstractC0297j$f
    public final void e(Object obj) {
        if (!(c() == null)) {
            super.e(obj);
        } else if (obj != null) {
            AtomicReference atomicReference = this.f10133h;
            while (!atomicReference.compareAndSet(null, obj) && atomicReference.get() == null) {
            }
        }
    }

    protected void g() {
        this.f10134i = true;
    }

    @Override // g.AbstractC0297j$f, java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public final Object getRawResult() {
        return b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        AbstractC0289j$d abstractC0289j$d = this;
        for (AbstractC0289j$d abstractC0289j$d2 = (AbstractC0289j$d) c(); abstractC0289j$d2 != null; abstractC0289j$d2 = (AbstractC0289j$d) abstractC0289j$d2.c()) {
            if (abstractC0289j$d2.f10157d == abstractC0289j$d) {
                AbstractC0289j$d abstractC0289j$d3 = (AbstractC0289j$d) abstractC0289j$d2.f10158e;
                if (!abstractC0289j$d3.f10134i) {
                    abstractC0289j$d3.g();
                }
            }
            abstractC0289j$d = abstractC0289j$d2;
        }
    }

    protected abstract Object i();
}
