package g;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.BaseStream;
/* renamed from: g.j$g */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0301j$g implements BaseStream {

    /* renamed from: a */
    public final /* synthetic */ InterfaceC0305j$h f10165a;

    private /* synthetic */ C0301j$g(InterfaceC0305j$h interfaceC0305j$h) {
        this.f10165a = interfaceC0305j$h;
    }

    public static /* synthetic */ BaseStream g(InterfaceC0305j$h interfaceC0305j$h) {
        if (interfaceC0305j$h == null) {
            return null;
        }
        return interfaceC0305j$h instanceof j$C ? j$B.g((j$C) interfaceC0305j$h) : interfaceC0305j$h instanceof InterfaceC0282j$b0 ? C0277j$a0.g((InterfaceC0282j$b0) interfaceC0305j$h) : interfaceC0305j$h instanceof InterfaceC0314j$j0 ? C0310j$i0.g((InterfaceC0314j$j0) interfaceC0305j$h) : interfaceC0305j$h instanceof j$M2 ? j$L2.g((j$M2) interfaceC0305j$h) : new C0301j$g(interfaceC0305j$h);
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        ((AbstractC0285j$c) this.f10165a).close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        InterfaceC0305j$h interfaceC0305j$h = this.f10165a;
        if (obj instanceof C0301j$g) {
            obj = ((C0301j$g) obj).f10165a;
        }
        return interfaceC0305j$h.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f10165a.hashCode();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return ((AbstractC0285j$c) this.f10165a).isParallel();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ Iterator iterator() {
        return this.f10165a.iterator();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f10165a;
        abstractC0285j$c.D0(runnable);
        return g(abstractC0285j$c);
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream parallel() {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f10165a;
        abstractC0285j$c.I0();
        return g(abstractC0285j$c);
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream sequential() {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f10165a;
        abstractC0285j$c.J0();
        return g(abstractC0285j$c);
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ Spliterator spliterator() {
        return e.j$I.a(this.f10165a.spliterator());
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream unordered() {
        return g(this.f10165a.unordered());
    }
}
