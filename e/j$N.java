package e;

import f.InterfaceC0257j$e;
import f.InterfaceC0261j$i;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$N implements InterfaceC0245j$s, InterfaceC0261j$i, InterfaceC0236j$j {

    /* renamed from: a  reason: collision with root package name */
    boolean f9252a = false;

    /* renamed from: b  reason: collision with root package name */
    double f9253b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j$B f9254c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$N(j$B j_b) {
        this.f9254c = j_b;
    }

    @Override // e.InterfaceC0236j$j
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.a(this, interfaceC0257j$e);
    }

    public final void c(InterfaceC0261j$i interfaceC0261j$i) {
        interfaceC0261j$i.getClass();
        while (hasNext()) {
            interfaceC0261j$i.d(nextDouble());
        }
    }

    @Override // f.InterfaceC0261j$i
    public final void d(double d6) {
        this.f9252a = true;
        this.f9253b = d6;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f9252a) {
            this.f9254c.n(this);
        }
        return this.f9252a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (j$Z.f9280a) {
            j$Z.a(j$N.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
            throw null;
        }
        return Double.valueOf(nextDouble());
    }

    public final double nextDouble() {
        if (this.f9252a || hasNext()) {
            this.f9252a = false;
            return this.f9253b;
        }
        throw new NoSuchElementException();
    }
}
