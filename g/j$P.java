package g;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountedCompleter;
/* loaded from: classes2.dex */
final class j$P extends CountedCompleter {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ int f10036h = 0;

    /* renamed from: a  reason: collision with root package name */
    private final AbstractC0350j$s0 f10037a;

    /* renamed from: b  reason: collision with root package name */
    private e.j$J f10038b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10039c;

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentHashMap f10040d;

    /* renamed from: e  reason: collision with root package name */
    private final InterfaceC0284j$b2 f10041e;

    /* renamed from: f  reason: collision with root package name */
    private final j$P f10042f;

    /* renamed from: g  reason: collision with root package name */
    private j$B0 f10043g;

    j$P(j$P j_p, e.j$J j_j, j$P j_p2) {
        super(j_p);
        this.f10037a = j_p.f10037a;
        this.f10038b = j_j;
        this.f10039c = j_p.f10039c;
        this.f10040d = j_p.f10040d;
        this.f10041e = j_p.f10041e;
        this.f10042f = j_p2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j$P(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, InterfaceC0284j$b2 interfaceC0284j$b2) {
        super(null);
        this.f10037a = abstractC0350j$s0;
        this.f10038b = j_j;
        this.f10039c = AbstractC0297j$f.f(j_j.estimateSize());
        this.f10040d = new ConcurrentHashMap(Math.max(16, AbstractC0297j$f.f10153g << 1));
        this.f10041e = interfaceC0284j$b2;
        this.f10042f = null;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        e.j$J trySplit;
        e.j$J j_j = this.f10038b;
        long j6 = this.f10039c;
        boolean z5 = false;
        j$P j_p = this;
        while (j_j.estimateSize() > j6 && (trySplit = j_j.trySplit()) != null) {
            j$P j_p2 = new j$P(j_p, trySplit, j_p.f10042f);
            j$P j_p3 = new j$P(j_p, j_j, j_p2);
            j_p.addToPendingCount(1);
            j_p3.addToPendingCount(1);
            j_p.f10040d.put(j_p2, j_p3);
            if (j_p.f10042f != null) {
                j_p2.addToPendingCount(1);
                if (j_p.f10040d.replace(j_p.f10042f, j_p, j_p2)) {
                    j_p.addToPendingCount(-1);
                } else {
                    j_p2.addToPendingCount(-1);
                }
            }
            if (z5) {
                j_j = trySplit;
                j_p = j_p2;
                j_p2 = j_p3;
            } else {
                j_p = j_p3;
            }
            z5 = !z5;
            j_p2.fork();
        }
        if (j_p.getPendingCount() > 0) {
            C0281j$b c0281j$b = new C0281j$b(14);
            AbstractC0350j$s0 abstractC0350j$s0 = j_p.f10037a;
            InterfaceC0366j$w0 n02 = abstractC0350j$s0.n0(abstractC0350j$s0.W(j_j), c0281j$b);
            j_p.f10037a.s0(j_j, n02);
            j_p.f10043g = n02.a();
            j_p.f10038b = null;
        }
        j_p.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        j$B0 j_b0 = this.f10043g;
        if (j_b0 != null) {
            j_b0.b(this.f10041e);
            this.f10043g = null;
        } else {
            e.j$J j_j = this.f10038b;
            if (j_j != null) {
                this.f10037a.s0(j_j, this.f10041e);
                this.f10038b = null;
            }
        }
        j$P j_p = (j$P) this.f10040d.remove(this);
        if (j_p != null) {
            j_p.tryComplete();
        }
    }
}
