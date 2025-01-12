package e;

import f.C0256j$d;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$E implements Spliterator.OfLong {

    /* renamed from: a */
    public final /* synthetic */ j$F f9240a;

    private /* synthetic */ j$E(j$F j_f) {
        this.f9240a = j_f;
    }

    public static /* synthetic */ j$E a(j$F j_f) {
        if (j_f == null) {
            return null;
        }
        return new j$E(j_f);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f9240a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        j$F j_f = this.f9240a;
        if (obj instanceof j$E) {
            obj = ((j$E) obj).f9240a;
        }
        return j_f.equals(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f9240a.estimateSize();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f9240a.forEachRemaining(longConsumer);
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f9240a.b(C0256j$d.b(consumer));
    }

    @Override // java.util.Spliterator.OfLong
    /* renamed from: forEachRemaining */
    public final /* synthetic */ void forEachRemaining2(LongConsumer longConsumer) {
        this.f9240a.c(f.j$D.b(longConsumer));
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f9240a.getComparator();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f9240a.getExactSizeIfKnown();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i6) {
        return this.f9240a.hasCharacteristics(i6);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9240a.hashCode();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return this.f9240a.tryAdvance(longConsumer);
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f9240a.r(C0256j$d.b(consumer));
    }

    @Override // java.util.Spliterator.OfLong
    /* renamed from: tryAdvance */
    public final /* synthetic */ boolean tryAdvance2(LongConsumer longConsumer) {
        return this.f9240a.p(f.j$D.b(longConsumer));
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ Spliterator.OfLong trySplit() {
        return a(this.f9240a.trySplit());
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return j$G.a(this.f9240a.trySplit());
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return j$I.a(this.f9240a.trySplit());
    }
}
