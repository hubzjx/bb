package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends c1 implements Serializable {
    private static final long serialVersionUID = 0;
    final com.google.common.base.e function;
    final c1 ordering;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(com.google.common.base.e eVar, c1 c1Var) {
        this.function = (com.google.common.base.e) com.google.common.base.j.j(eVar);
        this.ordering = (c1) com.google.common.base.j.j(c1Var);
    }

    @Override // com.google.common.collect.c1, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.ordering.compare(this.function.apply(obj), this.function.apply(obj2));
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.function.equals(hVar.function) && this.ordering.equals(hVar.ordering);
        }
        return false;
    }

    public int hashCode() {
        return com.google.common.base.h.b(this.function, this.ordering);
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}
