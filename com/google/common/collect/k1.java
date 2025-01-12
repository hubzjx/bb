package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
final class k1 extends c1 implements Serializable {
    private static final long serialVersionUID = 0;
    final c1 forwardOrder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k1(c1 c1Var) {
        this.forwardOrder = (c1) com.google.common.base.j.j(c1Var);
    }

    @Override // com.google.common.collect.c1, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.forwardOrder.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k1) {
            return this.forwardOrder.equals(((k1) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // com.google.common.collect.c1
    public <E> E max(Iterable<E> iterable) {
        return (E) this.forwardOrder.min(iterable);
    }

    @Override // com.google.common.collect.c1
    public <E> E min(Iterable<E> iterable) {
        return (E) this.forwardOrder.max(iterable);
    }

    @Override // com.google.common.collect.c1
    public <S> c1 reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }

    @Override // com.google.common.collect.c1
    public <E> E max(E e6, E e7) {
        return (E) this.forwardOrder.min(e6, e7);
    }

    @Override // com.google.common.collect.c1
    public <E> E min(E e6, E e7) {
        return (E) this.forwardOrder.max(e6, e7);
    }

    @Override // com.google.common.collect.c1
    public <E> E max(E e6, E e7, E e8, E... eArr) {
        return (E) this.forwardOrder.min(e6, e7, e8, eArr);
    }

    @Override // com.google.common.collect.c1
    public <E> E min(E e6, E e7, E e8, E... eArr) {
        return (E) this.forwardOrder.max(e6, e7, e8, eArr);
    }

    @Override // com.google.common.collect.c1
    public <E> E max(Iterator<E> it) {
        return (E) this.forwardOrder.min(it);
    }

    @Override // com.google.common.collect.c1
    public <E> E min(Iterator<E> it) {
        return (E) this.forwardOrder.max(it);
    }
}
