package com.google.common.collect;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class m1 {

    /* loaded from: classes.dex */
    static abstract class a extends AbstractSet {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return m1.d(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            return super.retainAll((Collection) com.google.common.base.j.j(collection));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Set set) {
        Iterator it = set.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i6 = ~(~(i6 + (next != null ? next.hashCode() : 0)));
        }
        return i6;
    }

    public static Set c() {
        return Collections.newSetFromMap(s0.h());
    }

    static boolean d(Set set, Collection collection) {
        com.google.common.base.j.j(collection);
        if (collection instanceof v0) {
            collection = ((v0) collection).elementSet();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? e(set, collection.iterator()) : n0.i(set.iterator(), collection);
    }

    static boolean e(Set set, Iterator it) {
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= set.remove(it.next());
        }
        return z5;
    }
}
