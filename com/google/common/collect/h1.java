package com.google.common.collect;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
final class h1 extends h0 {
    static final h1 EMPTY = new h1(new Object[0], 0, null, 0, 0);
    final transient Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    private final transient int size;
    final transient Object[] table;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h1(Object[] objArr, int i6, Object[] objArr2, int i7, int i8) {
        this.elements = objArr;
        this.table = objArr2;
        this.mask = i7;
        this.hashCode = i6;
        this.size = i8;
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.table;
        if (obj == null || objArr == null) {
            return false;
        }
        int c6 = v.c(obj);
        while (true) {
            int i6 = c6 & this.mask;
            Object obj2 = objArr[i6];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            c6 = i6 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public int copyIntoArray(Object[] objArr, int i6) {
        System.arraycopy(this.elements, 0, objArr, i6, this.size);
        return i6 + this.size;
    }

    @Override // com.google.common.collect.h0
    y createAsList() {
        return y.asImmutableList(this.elements, this.size);
    }

    @Override // com.google.common.collect.h0, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public Object[] internalArray() {
        return this.elements;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public int internalArrayEnd() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.h0
    boolean isHashCodeFast() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public s1 iterator() {
        return asList().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }
}
