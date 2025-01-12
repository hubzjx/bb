package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n1 extends h0 {
    @LazyInit
    private transient int cachedHashCode;
    final transient Object element;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n1(Object obj) {
        this.element = com.google.common.base.j.j(obj);
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public int copyIntoArray(Object[] objArr, int i6) {
        objArr[i6] = this.element;
        return i6 + 1;
    }

    @Override // com.google.common.collect.h0
    y createAsList() {
        return y.of(this.element);
    }

    @Override // com.google.common.collect.h0, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i6 = this.cachedHashCode;
        if (i6 == 0) {
            int hashCode = this.element.hashCode();
            this.cachedHashCode = hashCode;
            return hashCode;
        }
        return i6;
    }

    @Override // com.google.common.collect.h0
    boolean isHashCodeFast() {
        return this.cachedHashCode != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public s1 iterator() {
        return n0.j(this.element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.element.toString() + ']';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n1(Object obj, int i6) {
        this.element = obj;
        this.cachedHashCode = i6;
    }
}
