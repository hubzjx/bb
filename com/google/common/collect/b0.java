package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class b0 extends h0 {

    /* loaded from: classes.dex */
    private static class a implements Serializable {
        private static final long serialVersionUID = 0;
        final a0 map;

        a(a0 a0Var) {
            this.map = a0Var;
        }

        Object readResolve() {
            return this.map.entrySet();
        }
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = map().get(entry.getKey());
            return obj2 != null && obj2.equals(entry.getValue());
        }
        return false;
    }

    @Override // com.google.common.collect.h0, java.util.Collection, java.util.Set
    public int hashCode() {
        return map().hashCode();
    }

    @Override // com.google.common.collect.h0
    boolean isHashCodeFast() {
        return map().isHashCodeFast();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public boolean isPartialView() {
        return map().isPartialView();
    }

    abstract a0 map();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return map().size();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.w
    Object writeReplace() {
        return new a(map());
    }
}
