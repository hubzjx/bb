package e;

import f.C0256j$d;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$G implements Spliterator.OfPrimitive {

    /* renamed from: a */
    public final /* synthetic */ j$H f9241a;

    private /* synthetic */ j$G(j$H j_h) {
        this.f9241a = j_h;
    }

    public static /* synthetic */ Spliterator.OfPrimitive a(j$H j_h) {
        if (j_h == null) {
            return null;
        }
        return j_h instanceof j$B ? j$A.a((j$B) j_h) : j_h instanceof j$D ? j$C.a((j$D) j_h) : j_h instanceof j$F ? j$E.a((j$F) j_h) : new j$G(j_h);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f9241a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        j$H j_h = this.f9241a;
        if (obj instanceof j$G) {
            obj = ((j$G) obj).f9241a;
        }
        return j_h.equals(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f9241a.estimateSize();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f9241a.forEachRemaining(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f9241a.b(C0256j$d.b(consumer));
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f9241a.getComparator();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f9241a.getExactSizeIfKnown();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i6) {
        return this.f9241a.hasCharacteristics(i6);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9241a.hashCode();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f9241a.tryAdvance(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f9241a.r(C0256j$d.b(consumer));
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return a(this.f9241a.trySplit());
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return j$I.a(this.f9241a.trySplit());
    }
}
