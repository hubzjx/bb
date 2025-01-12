package e;

import f.C0256j$d;
import f.C0260j$h;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$A implements Spliterator.OfDouble {

    /* renamed from: a */
    public final /* synthetic */ j$B f9238a;

    private /* synthetic */ j$A(j$B j_b) {
        this.f9238a = j_b;
    }

    public static /* synthetic */ j$A a(j$B j_b) {
        if (j_b == null) {
            return null;
        }
        return new j$A(j_b);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f9238a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        j$B j_b = this.f9238a;
        if (obj instanceof j$A) {
            obj = ((j$A) obj).f9238a;
        }
        return j_b.equals(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f9238a.estimateSize();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f9238a.forEachRemaining(doubleConsumer);
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f9238a.b(C0256j$d.b(consumer));
    }

    @Override // java.util.Spliterator.OfDouble
    /* renamed from: forEachRemaining */
    public final /* synthetic */ void forEachRemaining2(DoubleConsumer doubleConsumer) {
        this.f9238a.k(C0260j$h.b(doubleConsumer));
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f9238a.getComparator();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f9238a.getExactSizeIfKnown();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i6) {
        return this.f9238a.hasCharacteristics(i6);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9238a.hashCode();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return this.f9238a.tryAdvance(doubleConsumer);
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f9238a.r(C0256j$d.b(consumer));
    }

    @Override // java.util.Spliterator.OfDouble
    /* renamed from: tryAdvance */
    public final /* synthetic */ boolean tryAdvance2(DoubleConsumer doubleConsumer) {
        return this.f9238a.n(C0260j$h.b(doubleConsumer));
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ Spliterator.OfDouble trySplit() {
        return a(this.f9238a.trySplit());
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return j$G.a(this.f9238a.trySplit());
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return j$I.a(this.f9238a.trySplit());
    }
}
