package e;

import f.C0256j$d;
import f.C0271j$s;
import f.InterfaceC0272j$t;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
/* renamed from: e.j$u  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0247j$u implements PrimitiveIterator.OfInt {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0248j$v f9318a;

    private /* synthetic */ C0247j$u(InterfaceC0248j$v interfaceC0248j$v) {
        this.f9318a = interfaceC0248j$v;
    }

    public static /* synthetic */ C0247j$u a(InterfaceC0248j$v interfaceC0248j$v) {
        return new C0247j$u(interfaceC0248j$v);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        InterfaceC0248j$v interfaceC0248j$v = this.f9318a;
        if (obj instanceof C0247j$u) {
            obj = ((C0247j$u) obj).f9318a;
        }
        return interfaceC0248j$v.equals(obj);
    }

    @Override // java.util.PrimitiveIterator
    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        j$L j_l = (j$L) this.f9318a;
        j_l.getClass();
        j_l.c((InterfaceC0272j$t) intConsumer);
    }

    @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        ((j$L) this.f9318a).b(C0256j$d.b(consumer));
    }

    @Override // java.util.PrimitiveIterator.OfInt
    /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
    public final /* synthetic */ void forEachRemaining2(IntConsumer intConsumer) {
        ((j$L) this.f9318a).c(C0271j$s.b(intConsumer));
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return ((j$L) this.f9318a).hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f9318a.hashCode();
    }

    @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public final Integer next() {
        j$L j_l = (j$L) this.f9318a;
        j_l.getClass();
        if (j$Z.f9280a) {
            j$Z.a(j$L.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
            throw null;
        }
        return Integer.valueOf(j_l.nextInt());
    }

    @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public final /* synthetic */ Object next() {
        return ((j$L) this.f9318a).next();
    }

    @Override // java.util.PrimitiveIterator.OfInt
    public final /* synthetic */ int nextInt() {
        return ((j$L) this.f9318a).nextInt();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.f9318a.remove();
    }
}
