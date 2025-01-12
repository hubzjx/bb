package com.google.common.collect;

import java.io.Serializable;
/* loaded from: classes.dex */
final class u1 extends c1 implements Serializable {
    static final u1 INSTANCE = new u1();
    private static final long serialVersionUID = 0;

    private u1() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.c1, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return obj.toString().compareTo(obj2.toString());
    }

    public String toString() {
        return "Ordering.usingToString()";
    }
}
