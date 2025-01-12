package e;

import f.C0256j$d;
import f.C0260j$h;
import f.InterfaceC0261j$i;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
/* renamed from: e.j$r */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0244j$r implements PrimitiveIterator.OfDouble {

    /* renamed from: a */
    public final /* synthetic */ InterfaceC0245j$s f9316a;

    private /* synthetic */ C0244j$r(InterfaceC0245j$s interfaceC0245j$s) {
        this.f9316a = interfaceC0245j$s;
    }

    public static /* synthetic */ C0244j$r a(InterfaceC0245j$s interfaceC0245j$s) {
        return new C0244j$r(interfaceC0245j$s);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        InterfaceC0245j$s interfaceC0245j$s = this.f9316a;
        if (obj instanceof C0244j$r) {
            obj = ((C0244j$r) obj).f9316a;
        }
        return interfaceC0245j$s.equals(obj);
    }

    @Override // java.util.PrimitiveIterator
    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        j$N j_n = (j$N) this.f9316a;
        j_n.getClass();
        j_n.c((InterfaceC0261j$i) doubleConsumer);
    }

    @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        InterfaceC0245j$s interfaceC0245j$s = this.f9316a;
        C0256j$d b6 = C0256j$d.b(consumer);
        j$N j_n = (j$N) interfaceC0245j$s;
        j_n.getClass();
        AbstractC0227j$a.a(j_n, b6);
    }

    @Override // java.util.PrimitiveIterator.OfDouble
    /* renamed from: forEachRemaining */
    public final /* synthetic */ void forEachRemaining2(DoubleConsumer doubleConsumer) {
        ((j$N) this.f9316a).c(C0260j$h.b(doubleConsumer));
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return ((j$N) this.f9316a).hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f9316a.hashCode();
    }

    @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    public final Double next() {
        j$N j_n = (j$N) this.f9316a;
        j_n.getClass();
        if (j$Z.f9280a) {
            j$Z.a(j$N.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
            throw null;
        }
        return Double.valueOf(j_n.nextDouble());
    }

    @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    public final /* synthetic */ Object next() {
        return ((j$N) this.f9316a).next();
    }

    @Override // java.util.PrimitiveIterator.OfDouble
    public final /* synthetic */ double nextDouble() {
        return ((j$N) this.f9316a).nextDouble();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.f9316a.remove();
    }
}
