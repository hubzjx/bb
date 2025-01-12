package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
/* loaded from: classes.dex */
public interface v0 extends Collection {

    /* loaded from: classes.dex */
    public interface a {
        int getCount();

        Object getElement();
    }

    int add(Object obj, int i6);

    @Override // java.util.Collection, com.google.common.collect.v0
    boolean contains(Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection collection);

    int count(Object obj);

    Set elementSet();

    Set entrySet();

    int remove(Object obj, int i6);

    @Override // java.util.Collection, com.google.common.collect.v0
    boolean remove(Object obj);

    boolean setCount(Object obj, int i6, int i7);

    @Override // java.util.Collection, com.google.common.collect.v0
    int size();
}
