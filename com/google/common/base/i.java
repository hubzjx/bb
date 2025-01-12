package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
final class i extends c implements Serializable {
    private static final long serialVersionUID = 1;
    final c elementEquivalence;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.elementEquivalence = (c) j.j(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.base.c
    public boolean doEquivalent(Iterable<Object> iterable, Iterable<Object> iterable2) {
        Iterator<Object> it = iterable.iterator();
        Iterator<Object> it2 = iterable2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.elementEquivalence.equivalent(it.next(), it2.next())) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.base.c
    public int doHash(Iterable<Object> iterable) {
        int i6 = 78721;
        for (Object obj : iterable) {
            i6 = (i6 * 24943) + this.elementEquivalence.hash(obj);
        }
        return i6;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof i) {
            return this.elementEquivalence.equals(((i) obj).elementEquivalence);
        }
        return false;
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        return this.elementEquivalence + ".pairwise()";
    }
}
