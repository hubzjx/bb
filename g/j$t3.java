package g;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
abstract class j$t3 {

    /* renamed from: a  reason: collision with root package name */
    protected final e.j$J f10277a;

    /* renamed from: b  reason: collision with root package name */
    protected final boolean f10278b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10279c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f10280d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$t3(e.j$J j_j, long j6, long j7) {
        this.f10277a = j_j;
        int i6 = (j7 > 0L ? 1 : (j7 == 0L ? 0 : -1));
        this.f10278b = i6 < 0;
        this.f10279c = i6 >= 0 ? j7 : 0L;
        this.f10280d = new AtomicLong(i6 >= 0 ? j6 + j7 : j6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$t3(e.j$J j_j, j$t3 j_t3) {
        this.f10277a = j_j;
        this.f10278b = j_t3.f10278b;
        this.f10280d = j_t3.f10280d;
        this.f10279c = j_t3.f10279c;
    }

    public final int characteristics() {
        return this.f10277a.characteristics() & (-16465);
    }

    public final long estimateSize() {
        return this.f10277a.estimateSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long t(long j6) {
        AtomicLong atomicLong;
        long j7;
        boolean z5;
        long min;
        do {
            atomicLong = this.f10280d;
            j7 = atomicLong.get();
            z5 = this.f10278b;
            if (j7 != 0) {
                min = Math.min(j7, j6);
                if (min <= 0) {
                    break;
                }
            } else if (z5) {
                return j6;
            } else {
                return 0L;
            }
        } while (!atomicLong.compareAndSet(j7, j7 - min));
        if (z5) {
            return Math.max(j6 - min, 0L);
        }
        long j8 = this.f10279c;
        return j7 > j8 ? Math.max(min - (j7 - j8), 0L) : min;
    }

    public /* bridge */ /* synthetic */ e.j$B trySplit() {
        return (e.j$B) m13trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ e.j$D m10trySplit() {
        return (e.j$D) m13trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ e.j$F m11trySplit() {
        return (e.j$F) m13trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ e.j$H m12trySplit() {
        return (e.j$H) m13trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final e.j$J m13trySplit() {
        e.j$J trySplit;
        if (this.f10280d.get() == 0 || (trySplit = this.f10277a.trySplit()) == null) {
            return null;
        }
        return u(trySplit);
    }

    protected abstract e.j$J u(e.j$J j_j);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int w() {
        if (this.f10280d.get() > 0) {
            return 2;
        }
        return this.f10278b ? 3 : 1;
    }
}
