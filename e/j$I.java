package e;

import f.C0256j$d;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$I implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j$J f9242a;

    private /* synthetic */ j$I(j$J j_j) {
        this.f9242a = j_j;
    }

    public static /* synthetic */ Spliterator a(j$J j_j) {
        if (j_j == null) {
            return null;
        }
        return j_j instanceof j$H ? j$G.a((j$H) j_j) : new j$I(j_j);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f9242a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        j$J j_j = this.f9242a;
        if (obj instanceof j$I) {
            obj = ((j$I) obj).f9242a;
        }
        return j_j.equals(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f9242a.estimateSize();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f9242a.b(C0256j$d.b(consumer));
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f9242a.getComparator();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f9242a.getExactSizeIfKnown();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i6) {
        return this.f9242a.hasCharacteristics(i6);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9242a.hashCode();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f9242a.r(C0256j$d.b(consumer));
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return a(this.f9242a.trySplit());
    }
}
