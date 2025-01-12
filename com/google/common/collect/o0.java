package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
final class o0 extends c1 implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<Object> elementOrder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(Comparator<Object> comparator) {
        this.elementOrder = comparator;
    }

    @Override // com.google.common.collect.c1, java.util.Comparator
    public int compare(Iterable<Object> iterable, Iterable<Object> iterable2) {
        Iterator<Object> it = iterable2.iterator();
        for (Object obj : iterable) {
            if (!it.hasNext()) {
                return 1;
            }
            int compare = this.elementOrder.compare(obj, it.next());
            if (compare != 0) {
                return compare;
            }
        }
        return it.hasNext() ? -1 : 0;
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o0) {
            return this.elementOrder.equals(((o0) obj).elementOrder);
        }
        return false;
    }

    public int hashCode() {
        return this.elementOrder.hashCode() ^ 2075626741;
    }

    public String toString() {
        return this.elementOrder + ".lexicographical()";
    }
}
