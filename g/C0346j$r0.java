package g;

import java.util.concurrent.atomic.AtomicReference;
/* renamed from: g.j$r0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0346j$r0 extends AbstractC0289j$d {

    /* renamed from: j  reason: collision with root package name */
    private final C0342j$q0 f10254j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0346j$r0(C0342j$q0 c0342j$q0, AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j) {
        super(abstractC0350j$s0, j_j);
        this.f10254j = c0342j$q0;
    }

    C0346j$r0(C0346j$r0 c0346j$r0, e.j$J j_j) {
        super(c0346j$r0, j_j);
        this.f10254j = c0346j$r0.f10254j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.AbstractC0297j$f
    public final Object a() {
        boolean z5;
        Boolean valueOf;
        AbstractC0350j$s0 abstractC0350j$s0 = this.f10154a;
        AbstractC0334j$o0 abstractC0334j$o0 = (AbstractC0334j$o0) this.f10254j.f10247b.get();
        abstractC0350j$s0.s0(this.f10155b, abstractC0334j$o0);
        boolean z6 = abstractC0334j$o0.f10228b;
        z5 = this.f10254j.f10246a.f10239b;
        if (z6 == z5 && (valueOf = Boolean.valueOf(z6)) != null) {
            AtomicReference atomicReference = this.f10133h;
            while (!atomicReference.compareAndSet(null, valueOf) && atomicReference.get() == null) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.AbstractC0297j$f
    public final AbstractC0297j$f d(e.j$J j_j) {
        return new C0346j$r0(this, j_j);
    }

    @Override // g.AbstractC0289j$d
    protected final Object i() {
        boolean z5;
        z5 = this.f10254j.f10246a.f10239b;
        return Boolean.valueOf(!z5);
    }
}
