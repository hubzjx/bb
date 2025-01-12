package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
final class c0 extends l0 {
    private final a0 map;

    /* loaded from: classes.dex */
    private static class a implements Serializable {
        private static final long serialVersionUID = 0;
        final a0 map;

        a(a0 a0Var) {
            this.map = a0Var;
        }

        Object readResolve() {
            return this.map.keySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(a0 a0Var) {
        this.map = a0Var;
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.l0
    Object get(int i6) {
        return ((Map.Entry) this.map.entrySet().asList().get(i6)).getKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public boolean isPartialView() {
        return true;
    }

    @Override // com.google.common.collect.l0, com.google.common.collect.h0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public s1 iterator() {
        return this.map.keyIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.w
    Object writeReplace() {
        return new a(this.map);
    }
}
