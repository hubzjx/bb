package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x0 extends c1 implements Serializable {
    static final x0 INSTANCE = new x0();
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    private transient c1 nullsFirst;
    @MonotonicNonNullDecl
    private transient c1 nullsLast;

    private x0() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.c1, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        com.google.common.base.j.j(comparable);
        com.google.common.base.j.j(comparable2);
        return comparable.compareTo(comparable2);
    }

    @Override // com.google.common.collect.c1
    public <S extends Comparable> c1 nullsFirst() {
        c1 c1Var = this.nullsFirst;
        if (c1Var == null) {
            c1 nullsFirst = super.nullsFirst();
            this.nullsFirst = nullsFirst;
            return nullsFirst;
        }
        return c1Var;
    }

    @Override // com.google.common.collect.c1
    public <S extends Comparable> c1 nullsLast() {
        c1 c1Var = this.nullsLast;
        if (c1Var == null) {
            c1 nullsLast = super.nullsLast();
            this.nullsLast = nullsLast;
            return nullsLast;
        }
        return c1Var;
    }

    @Override // com.google.common.collect.c1
    public <S extends Comparable> c1 reverse() {
        return j1.INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
