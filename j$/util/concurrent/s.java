package j$.util.concurrent;

import e.AbstractC0227j$a;
import e.InterfaceC0228j$b;
import e.j$I;
import e.j$J;
import f.C0256j$d;
import f.InterfaceC0257j$e;
import f.j$S;
import g.AbstractC0350j$s0;
import g.j$L2;
import g.j$M2;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
/* loaded from: classes2.dex */
final class s extends b implements InterfaceC0228j$b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ConcurrentHashMap concurrentHashMap) {
        super(concurrentHashMap);
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // e.InterfaceC0228j$b
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        interfaceC0257j$e.getClass();
        l[] lVarArr = this.f11078a.f11070a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l a6 = pVar.a();
            if (a6 == null) {
                return;
            }
            interfaceC0257j$e.j(a6.f11090c);
        }
    }

    @Override // e.InterfaceC0228j$b
    public final /* synthetic */ boolean c(j$S j_s) {
        return AbstractC0227j$a.j(this, j_s);
    }

    @Override // j$.util.concurrent.b, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f11078a.containsValue(obj);
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ void forEach(Consumer consumer) {
        b(C0256j$d.b(consumer));
    }

    @Override // j$.util.concurrent.b, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.f11078a;
        l[] lVarArr = concurrentHashMap.f11070a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new h(lVarArr, length, length, concurrentHashMap, 1);
    }

    @Override // java.util.Collection
    public final Stream parallelStream() {
        return j$L2.g(AbstractC0350j$s0.r0(AbstractC0227j$a.A(this), true));
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        AbstractC0381a abstractC0381a;
        if (obj != null) {
            Iterator it = iterator();
            do {
                abstractC0381a = (AbstractC0381a) it;
                if (!abstractC0381a.hasNext()) {
                    return false;
                }
            } while (!obj.equals(((h) it).next()));
            abstractC0381a.remove();
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public final /* synthetic */ boolean removeIf(Predicate predicate) {
        return AbstractC0227j$a.j(this, j$S.a(predicate));
    }

    @Override // java.util.Collection, java.lang.Iterable, e.InterfaceC0228j$b, java.util.Set
    public final j$J spliterator() {
        ConcurrentHashMap concurrentHashMap = this.f11078a;
        long l6 = concurrentHashMap.l();
        l[] lVarArr = concurrentHashMap.f11070a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new j(lVarArr, length, 0, length, l6 >= 0 ? l6 : 0L, 1);
    }

    @Override // java.util.Collection, java.lang.Iterable, e.InterfaceC0228j$b, java.util.Set
    public final /* synthetic */ Spliterator spliterator() {
        return j$I.a(spliterator());
    }

    @Override // java.util.Collection, e.InterfaceC0228j$b
    public final /* synthetic */ j$M2 stream() {
        return AbstractC0227j$a.m(this);
    }

    @Override // java.util.Collection, e.InterfaceC0228j$b
    public final /* synthetic */ Stream stream() {
        return j$L2.g(AbstractC0227j$a.m(this));
    }
}
