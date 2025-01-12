package e;

import f.C0256j$d;
import f.C0271j$s;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$C implements Spliterator.OfInt {

    /* renamed from: a */
    public final /* synthetic */ j$D f9239a;

    private /* synthetic */ j$C(j$D j_d) {
        this.f9239a = j_d;
    }

    public static /* synthetic */ j$C a(j$D j_d) {
        if (j_d == null) {
            return null;
        }
        return new j$C(j_d);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f9239a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        j$D j_d = this.f9239a;
        if (obj instanceof j$C) {
            obj = ((j$C) obj).f9239a;
        }
        return j_d.equals(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f9239a.estimateSize();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f9239a.forEachRemaining(intConsumer);
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f9239a.b(C0256j$d.b(consumer));
    }

    @Override // java.util.Spliterator.OfInt
    /* renamed from: forEachRemaining */
    public final /* synthetic */ void forEachRemaining2(IntConsumer intConsumer) {
        this.f9239a.l(C0271j$s.b(intConsumer));
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f9239a.getComparator();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f9239a.getExactSizeIfKnown();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i6) {
        return this.f9239a.hasCharacteristics(i6);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9239a.hashCode();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.f9239a.tryAdvance(intConsumer);
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f9239a.r(C0256j$d.b(consumer));
    }

    @Override // java.util.Spliterator.OfInt
    /* renamed from: tryAdvance */
    public final /* synthetic */ boolean tryAdvance2(IntConsumer intConsumer) {
        return this.f9239a.g(C0271j$s.b(intConsumer));
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ Spliterator.OfInt trySplit() {
        return a(this.f9239a.trySplit());
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return j$G.a(this.f9239a.trySplit());
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return j$I.a(this.f9239a.trySplit());
    }
}
