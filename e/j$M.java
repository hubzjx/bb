package e;

import f.InterfaceC0257j$e;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class j$M implements InterfaceC0251j$y, f.j$E, InterfaceC0236j$j {

    /* renamed from: a  reason: collision with root package name */
    boolean f9249a = false;

    /* renamed from: b  reason: collision with root package name */
    long f9250b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j$F f9251c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$M(j$F j_f) {
        this.f9251c = j_f;
    }

    @Override // e.InterfaceC0236j$j
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof f.j$E) {
            c((f.j$E) interfaceC0257j$e);
            return;
        }
        interfaceC0257j$e.getClass();
        if (j$Z.f9280a) {
            j$Z.a(j$M.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
            throw null;
        } else {
            c(new C0249j$w(interfaceC0257j$e));
        }
    }

    public final void c(f.j$E j_e) {
        j_e.getClass();
        while (hasNext()) {
            j_e.f(nextLong());
        }
    }

    @Override // f.j$E
    public final void f(long j6) {
        this.f9249a = true;
        this.f9250b = j6;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f9249a) {
            this.f9251c.p(this);
        }
        return this.f9249a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (j$Z.f9280a) {
            j$Z.a(j$M.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
            throw null;
        }
        return Long.valueOf(nextLong());
    }

    public final long nextLong() {
        if (this.f9249a || hasNext()) {
            this.f9249a = false;
            return this.f9250b;
        }
        throw new NoSuchElementException();
    }
}
