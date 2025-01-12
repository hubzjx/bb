package com.google.common.collect;

import java.util.Iterator;
/* loaded from: classes.dex */
abstract class r1 implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    final Iterator f5726a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r1(Iterator it) {
        this.f5726a = (Iterator) com.google.common.base.j.j(it);
    }

    abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5726a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f5726a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f5726a.remove();
    }
}
