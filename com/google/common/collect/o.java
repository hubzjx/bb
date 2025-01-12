package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes.dex */
final class o extends c1 implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<Object>[] comparators;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Iterable<? extends Comparator<Object>> iterable) {
        this.comparators = (Comparator[]) m0.f(iterable, new Comparator[0]);
    }

    @Override // com.google.common.collect.c1, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int i6 = 0;
        while (true) {
            Comparator<Object>[] comparatorArr = this.comparators;
            if (i6 >= comparatorArr.length) {
                return 0;
            }
            int compare = comparatorArr[i6].compare(obj, obj2);
            if (compare != 0) {
                return compare;
            }
            i6++;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            return Arrays.equals(this.comparators, ((o) obj).comparators);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.comparators) + ")";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Comparator<Object> comparator, Comparator<Object> comparator2) {
        this.comparators = new Comparator[]{comparator, comparator2};
    }
}
