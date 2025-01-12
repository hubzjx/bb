package com.google.common.collect;
/* loaded from: classes.dex */
abstract class l0 extends h0 {

    /* loaded from: classes.dex */
    class a extends y {
        a() {
        }

        @Override // java.util.List
        public Object get(int i6) {
            return l0.this.get(i6);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public boolean isPartialView() {
            return l0.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return l0.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public int copyIntoArray(Object[] objArr, int i6) {
        return asList().copyIntoArray(objArr, i6);
    }

    @Override // com.google.common.collect.h0
    y createAsList() {
        return new a();
    }

    abstract Object get(int i6);

    @Override // com.google.common.collect.h0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public s1 iterator() {
        return asList().iterator();
    }
}
