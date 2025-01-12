package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z0 extends c1 implements Serializable {
    private static final long serialVersionUID = 0;
    final c1 ordering;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(c1 c1Var) {
        this.ordering = c1Var;
    }

    @Override // com.google.common.collect.c1, java.util.Comparator
    public int compare(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (obj2 == null) {
            return -1;
        }
        return this.ordering.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z0) {
            return this.ordering.equals(((z0) obj).ordering);
        }
        return false;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ (-921210296);
    }

    @Override // com.google.common.collect.c1
    public <S> c1 nullsFirst() {
        return this.ordering.nullsFirst();
    }

    @Override // com.google.common.collect.c1
    public <S> c1 nullsLast() {
        return this;
    }

    @Override // com.google.common.collect.c1
    public <S> c1 reverse() {
        return this.ordering.reverse().nullsFirst();
    }

    public String toString() {
        return this.ordering + ".nullsLast()";
    }
}
