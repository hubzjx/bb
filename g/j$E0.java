package g;

import e.AbstractC0227j$a;
import e.InterfaceC0228j$b;
import f.InterfaceC0257j$e;
import f.InterfaceC0274j$v;
import java.util.Collection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$E0 implements j$B0 {

    /* renamed from: a  reason: collision with root package name */
    private final Collection f9979a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$E0(Collection collection) {
        this.f9979a = collection;
    }

    @Override // g.j$B0
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.y(this.f9979a, interfaceC0257j$e);
    }

    @Override // g.j$B0
    public final j$B0 c(int i6) {
        throw new IndexOutOfBoundsException();
    }

    @Override // g.j$B0
    public final long count() {
        return this.f9979a.size();
    }

    @Override // g.j$B0
    public final Object[] n(InterfaceC0274j$v interfaceC0274j$v) {
        Collection collection = this.f9979a;
        return collection.toArray((Object[]) interfaceC0274j$v.r(collection.size()));
    }

    @Override // g.j$B0
    public final void p(Object[] objArr, int i6) {
        for (Object obj : this.f9979a) {
            objArr[i6] = obj;
            i6++;
        }
    }

    @Override // g.j$B0
    public final /* synthetic */ j$B0 r(long j6, long j7, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.E(this, j6, j7, interfaceC0274j$v);
    }

    @Override // g.j$B0
    public final e.j$J spliterator() {
        Collection collection = this.f9979a;
        return ((AbstractC0285j$c) (collection instanceof InterfaceC0228j$b ? ((InterfaceC0228j$b) collection).stream() : AbstractC0227j$a.m(collection))).spliterator();
    }

    @Override // g.j$B0
    public final /* synthetic */ int t() {
        return 0;
    }

    public final String toString() {
        Collection collection = this.f9979a;
        return String.format("CollectionNode[%d][%s]", Integer.valueOf(collection.size()), collection);
    }
}
