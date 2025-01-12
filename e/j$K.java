package e;

import f.InterfaceC0257j$e;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class j$K implements Iterator, InterfaceC0257j$e {

    /* renamed from: a  reason: collision with root package name */
    boolean f9243a = false;

    /* renamed from: b  reason: collision with root package name */
    Object f9244b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j$J f9245c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$K(j$J j_j) {
        this.f9245c = j_j;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f9243a) {
            this.f9245c.r(this);
        }
        return this.f9243a;
    }

    @Override // f.InterfaceC0257j$e
    public final void j(Object obj) {
        this.f9243a = true;
        this.f9244b = obj;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f9243a || hasNext()) {
            this.f9243a = false;
            return this.f9244b;
        }
        throw new NoSuchElementException();
    }
}
