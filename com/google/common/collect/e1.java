package com.google.common.collect;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e1 extends y {
    static final y EMPTY = new e1(new Object[0], 0);
    final transient Object[] array;
    private final transient int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e1(Object[] objArr, int i6) {
        this.array = objArr;
        this.size = i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.y, com.google.common.collect.w
    public int copyIntoArray(Object[] objArr, int i6) {
        System.arraycopy(this.array, 0, objArr, i6, this.size);
        return i6 + this.size;
    }

    @Override // java.util.List
    public Object get(int i6) {
        com.google.common.base.j.h(i6, this.size);
        return this.array[i6];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public Object[] internalArray() {
        return this.array;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
