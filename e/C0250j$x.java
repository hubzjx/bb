package e;

import f.C0256j$d;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
/* renamed from: e.j$x  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0250j$x implements PrimitiveIterator.OfLong {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0251j$y f9320a;

    private /* synthetic */ C0250j$x(InterfaceC0251j$y interfaceC0251j$y) {
        this.f9320a = interfaceC0251j$y;
    }

    public static /* synthetic */ C0250j$x a(InterfaceC0251j$y interfaceC0251j$y) {
        return new C0250j$x(interfaceC0251j$y);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        InterfaceC0251j$y interfaceC0251j$y = this.f9320a;
        if (obj instanceof C0250j$x) {
            obj = ((C0250j$x) obj).f9320a;
        }
        return interfaceC0251j$y.equals(obj);
    }

    @Override // java.util.PrimitiveIterator
    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        j$M j_m = (j$M) this.f9320a;
        j_m.getClass();
        j_m.c((f.j$E) longConsumer);
    }

    @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        ((j$M) this.f9320a).b(C0256j$d.b(consumer));
    }

    @Override // java.util.PrimitiveIterator.OfLong
    /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
    public final /* synthetic */ void forEachRemaining2(LongConsumer longConsumer) {
        ((j$M) this.f9320a).c(f.j$D.b(longConsumer));
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return ((j$M) this.f9320a).hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f9320a.hashCode();
    }

    @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final Long next() {
        j$M j_m = (j$M) this.f9320a;
        j_m.getClass();
        if (j$Z.f9280a) {
            j$Z.a(j$M.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
            throw null;
        }
        return Long.valueOf(j_m.nextLong());
    }

    @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ Object next() {
        return ((j$M) this.f9320a).next();
    }

    @Override // java.util.PrimitiveIterator.OfLong
    public final /* synthetic */ long nextLong() {
        return ((j$M) this.f9320a).nextLong();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.f9320a.remove();
    }
}
