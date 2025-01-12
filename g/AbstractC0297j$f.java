package g;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$f  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0297j$f extends CountedCompleter {

    /* renamed from: g  reason: collision with root package name */
    static final int f10153g = ForkJoinPool.getCommonPoolParallelism() << 2;

    /* renamed from: a  reason: collision with root package name */
    protected final AbstractC0350j$s0 f10154a;

    /* renamed from: b  reason: collision with root package name */
    protected e.j$J f10155b;

    /* renamed from: c  reason: collision with root package name */
    protected long f10156c;

    /* renamed from: d  reason: collision with root package name */
    protected AbstractC0297j$f f10157d;

    /* renamed from: e  reason: collision with root package name */
    protected AbstractC0297j$f f10158e;

    /* renamed from: f  reason: collision with root package name */
    private Object f10159f;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0297j$f(AbstractC0297j$f abstractC0297j$f, e.j$J j_j) {
        super(abstractC0297j$f);
        this.f10155b = j_j;
        this.f10154a = abstractC0297j$f.f10154a;
        this.f10156c = abstractC0297j$f.f10156c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0297j$f(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j) {
        super(null);
        this.f10154a = abstractC0350j$s0;
        this.f10155b = j_j;
        this.f10156c = 0L;
    }

    public static long f(long j6) {
        long j7 = j6 / f10153g;
        if (j7 > 0) {
            return j7;
        }
        return 1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object a();

    /* JADX INFO: Access modifiers changed from: protected */
    public Object b() {
        return this.f10159f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AbstractC0297j$f c() {
        return (AbstractC0297j$f) getCompleter();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        e.j$J trySplit;
        e.j$J j_j = this.f10155b;
        long estimateSize = j_j.estimateSize();
        long j6 = this.f10156c;
        if (j6 == 0) {
            j6 = f(estimateSize);
            this.f10156c = j6;
        }
        boolean z5 = false;
        AbstractC0297j$f abstractC0297j$f = this;
        while (estimateSize > j6 && (trySplit = j_j.trySplit()) != null) {
            AbstractC0297j$f d6 = abstractC0297j$f.d(trySplit);
            abstractC0297j$f.f10157d = d6;
            AbstractC0297j$f d7 = abstractC0297j$f.d(j_j);
            abstractC0297j$f.f10158e = d7;
            abstractC0297j$f.setPendingCount(1);
            if (z5) {
                j_j = trySplit;
                abstractC0297j$f = d6;
                d6 = d7;
            } else {
                abstractC0297j$f = d7;
            }
            z5 = !z5;
            d6.fork();
            estimateSize = j_j.estimateSize();
        }
        abstractC0297j$f.e(abstractC0297j$f.a());
        abstractC0297j$f.tryComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract AbstractC0297j$f d(e.j$J j_j);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Object obj) {
        this.f10159f = obj;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public Object getRawResult() {
        return this.f10159f;
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        this.f10155b = null;
        this.f10158e = null;
        this.f10157d = null;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    protected final void setRawResult(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }
}
