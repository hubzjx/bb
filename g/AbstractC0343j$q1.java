package g;

import java.util.concurrent.CountedCompleter;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$q1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0343j$q1 extends CountedCompleter {

    /* renamed from: a  reason: collision with root package name */
    protected final j$B0 f10248a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f10249b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0343j$q1(j$B0 j_b0) {
        this.f10248a = j_b0;
        this.f10249b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0343j$q1(AbstractC0343j$q1 abstractC0343j$q1, j$B0 j_b0, int i6) {
        super(abstractC0343j$q1);
        this.f10248a = j_b0;
        this.f10249b = i6;
    }

    abstract void a();

    abstract C0339j$p1 b(int i6, int i7);

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        AbstractC0343j$q1 abstractC0343j$q1 = this;
        while (abstractC0343j$q1.f10248a.t() != 0) {
            abstractC0343j$q1.setPendingCount(abstractC0343j$q1.f10248a.t() - 1);
            int i6 = 0;
            int i7 = 0;
            while (i6 < abstractC0343j$q1.f10248a.t() - 1) {
                C0339j$p1 b6 = abstractC0343j$q1.b(i6, abstractC0343j$q1.f10249b + i7);
                i7 = (int) (i7 + b6.f10248a.count());
                b6.fork();
                i6++;
            }
            abstractC0343j$q1 = abstractC0343j$q1.b(i6, abstractC0343j$q1.f10249b + i7);
        }
        abstractC0343j$q1.a();
        abstractC0343j$q1.propagateCompletion();
    }
}
