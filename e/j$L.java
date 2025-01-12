package e;

import f.InterfaceC0257j$e;
import f.InterfaceC0272j$t;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class j$L implements InterfaceC0248j$v, InterfaceC0272j$t, InterfaceC0236j$j {

    /* renamed from: a  reason: collision with root package name */
    boolean f9246a = false;

    /* renamed from: b  reason: collision with root package name */
    int f9247b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j$D f9248c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$L(j$D j_d) {
        this.f9248c = j_d;
    }

    @Override // e.InterfaceC0236j$j
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof InterfaceC0272j$t) {
            c((InterfaceC0272j$t) interfaceC0257j$e);
            return;
        }
        interfaceC0257j$e.getClass();
        if (j$Z.f9280a) {
            j$Z.a(j$L.class, "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
            throw null;
        } else {
            c(new C0246j$t(interfaceC0257j$e));
        }
    }

    public final void c(InterfaceC0272j$t interfaceC0272j$t) {
        interfaceC0272j$t.getClass();
        while (hasNext()) {
            interfaceC0272j$t.e(nextInt());
        }
    }

    @Override // f.InterfaceC0272j$t
    public final void e(int i6) {
        this.f9246a = true;
        this.f9247b = i6;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f9246a) {
            this.f9248c.g(this);
        }
        return this.f9246a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (j$Z.f9280a) {
            j$Z.a(j$L.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
            throw null;
        }
        return Integer.valueOf(nextInt());
    }

    public final int nextInt() {
        if (this.f9246a || hasNext()) {
            this.f9246a = false;
            return this.f9247b;
        }
        throw new NoSuchElementException();
    }
}
