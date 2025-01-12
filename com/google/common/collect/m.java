package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends c1 implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<Object> comparator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Comparator<Object> comparator) {
        this.comparator = (Comparator) com.google.common.base.j.j(comparator);
    }

    @Override // com.google.common.collect.c1, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.comparator.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            return this.comparator.equals(((m) obj).comparator);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}
