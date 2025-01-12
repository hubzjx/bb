package com.google.common.collect;

import com.google.common.collect.c1;
import java.io.Serializable;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends c1 implements Serializable {
    private static final long serialVersionUID = 0;
    final a0 rankMap;

    r(a0 a0Var) {
        this.rankMap = a0Var;
    }

    private int rank(Object obj) {
        Integer num = (Integer) this.rankMap.get(obj);
        if (num != null) {
            return num.intValue();
        }
        throw new c1.c(obj);
    }

    @Override // com.google.common.collect.c1, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return rank(obj) - rank(obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof r) {
            return this.rankMap.equals(((r) obj).rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(List<Object> list) {
        this(s0.e(list));
    }
}
