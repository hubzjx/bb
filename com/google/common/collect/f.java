package com.google.common.collect;

import java.io.Serializable;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
final class f extends c1 implements Serializable {
    static final f INSTANCE = new f();
    private static final long serialVersionUID = 0;

    f() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.c1, java.util.Comparator
    public int compare(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return 0;
    }

    @Override // com.google.common.collect.c1
    public <E> y immutableSortedCopy(Iterable<E> iterable) {
        return y.copyOf(iterable);
    }

    @Override // com.google.common.collect.c1
    public <S> c1 reverse() {
        return this;
    }

    @Override // com.google.common.collect.c1
    public <E> List<E> sortedCopy(Iterable<E> iterable) {
        return p0.h(iterable);
    }

    public String toString() {
        return "Ordering.allEqual()";
    }
}
