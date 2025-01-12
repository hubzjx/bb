package g;

import java.util.concurrent.CountedCompleter;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$m1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0327j$m1 extends CountedCompleter implements InterfaceC0284j$b2 {

    /* renamed from: a  reason: collision with root package name */
    protected final e.j$J f10208a;

    /* renamed from: b  reason: collision with root package name */
    protected final AbstractC0350j$s0 f10209b;

    /* renamed from: c  reason: collision with root package name */
    protected final long f10210c;

    /* renamed from: d  reason: collision with root package name */
    protected long f10211d;

    /* renamed from: e  reason: collision with root package name */
    protected long f10212e;

    /* renamed from: f  reason: collision with root package name */
    protected int f10213f;

    /* renamed from: g  reason: collision with root package name */
    protected int f10214g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0327j$m1(int i6, e.j$J j_j, AbstractC0350j$s0 abstractC0350j$s0) {
        this.f10208a = j_j;
        this.f10209b = abstractC0350j$s0;
        this.f10210c = AbstractC0297j$f.f(j_j.estimateSize());
        this.f10211d = 0L;
        this.f10212e = i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0327j$m1(AbstractC0327j$m1 abstractC0327j$m1, e.j$J j_j, long j6, long j7, int i6) {
        super(abstractC0327j$m1);
        this.f10208a = j_j;
        this.f10209b = abstractC0327j$m1.f10209b;
        this.f10210c = abstractC0327j$m1.f10210c;
        this.f10211d = j6;
        this.f10212e = j7;
        if (j6 < 0 || j7 < 0 || (j6 + j7) - 1 >= i6) {
            throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", Long.valueOf(j6), Long.valueOf(j6), Long.valueOf(j7), Integer.valueOf(i6)));
        }
    }

    abstract AbstractC0327j$m1 b(e.j$J j_j, long j6, long j7);

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        e.j$J trySplit;
        e.j$J j_j = this.f10208a;
        AbstractC0327j$m1 abstractC0327j$m1 = this;
        while (j_j.estimateSize() > abstractC0327j$m1.f10210c && (trySplit = j_j.trySplit()) != null) {
            abstractC0327j$m1.setPendingCount(1);
            long estimateSize = trySplit.estimateSize();
            abstractC0327j$m1.b(trySplit, abstractC0327j$m1.f10211d, estimateSize).fork();
            abstractC0327j$m1 = abstractC0327j$m1.b(j_j, abstractC0327j$m1.f10211d + estimateSize, abstractC0327j$m1.f10212e - estimateSize);
        }
        abstractC0327j$m1.f10209b.s0(j_j, abstractC0327j$m1);
        abstractC0327j$m1.propagateCompletion();
    }

    public /* synthetic */ void d(double d6) {
        AbstractC0350j$s0.j();
        throw null;
    }

    public /* synthetic */ void e(int i6) {
        AbstractC0350j$s0.s();
        throw null;
    }

    public /* synthetic */ void f(long j6) {
        AbstractC0350j$s0.t();
        throw null;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void h() {
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        long j7 = this.f10212e;
        if (j6 > j7) {
            throw new IllegalStateException("size passed to Sink.begin exceeds array length");
        }
        int i6 = (int) this.f10211d;
        this.f10213f = i6;
        this.f10214g = i6 + ((int) j7);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }
}
