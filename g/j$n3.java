package g;
/* loaded from: classes2.dex */
abstract class j$n3 {

    /* renamed from: a  reason: collision with root package name */
    final long f10222a;

    /* renamed from: b  reason: collision with root package name */
    final long f10223b;

    /* renamed from: c  reason: collision with root package name */
    e.j$J f10224c;

    /* renamed from: d  reason: collision with root package name */
    long f10225d;

    /* renamed from: e  reason: collision with root package name */
    long f10226e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$n3(e.j$J j_j, long j6, long j7, long j8, long j9) {
        this.f10224c = j_j;
        this.f10222a = j6;
        this.f10223b = j7;
        this.f10225d = j8;
        this.f10226e = j9;
    }

    protected abstract e.j$J a(e.j$J j_j, long j6, long j7, long j8, long j9);

    public final int characteristics() {
        return this.f10224c.characteristics();
    }

    public final long estimateSize() {
        long j6 = this.f10226e;
        long j7 = this.f10222a;
        if (j7 < j6) {
            return j6 - Math.max(j7, this.f10225d);
        }
        return 0L;
    }

    public /* bridge */ /* synthetic */ e.j$B trySplit() {
        return (e.j$B) m9trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ e.j$D m6trySplit() {
        return (e.j$D) m9trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ e.j$F m7trySplit() {
        return (e.j$F) m9trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ e.j$H m8trySplit() {
        return (e.j$H) m9trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final e.j$J m9trySplit() {
        long j6 = this.f10226e;
        if (this.f10222a >= j6 || this.f10225d >= j6) {
            return null;
        }
        while (true) {
            e.j$J trySplit = this.f10224c.trySplit();
            if (trySplit == null) {
                return null;
            }
            long estimateSize = trySplit.estimateSize() + this.f10225d;
            long min = Math.min(estimateSize, this.f10223b);
            long j7 = this.f10222a;
            if (j7 >= min) {
                this.f10225d = min;
            } else {
                long j8 = this.f10223b;
                if (min < j8) {
                    long j9 = this.f10225d;
                    if (j9 < j7 || estimateSize > j8) {
                        this.f10225d = min;
                        return a(trySplit, j7, j8, j9, min);
                    }
                    this.f10225d = min;
                    return trySplit;
                }
                this.f10224c = trySplit;
                this.f10226e = min;
            }
        }
    }
}
