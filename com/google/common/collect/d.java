package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
/* loaded from: classes.dex */
abstract class d implements t0 {
    @MonotonicNonNullDecl
    private transient Map<Object, Collection<Object>> asMap;
    @MonotonicNonNullDecl
    private transient Collection<Map.Entry<Object, Object>> entries;
    @MonotonicNonNullDecl
    private transient Set<Object> keySet;
    @MonotonicNonNullDecl
    private transient v0 keys;
    @MonotonicNonNullDecl
    private transient Collection<Object> values;

    @Override // com.google.common.collect.t0
    public abstract Map asMap();

    public boolean containsEntry(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean containsValue(Object obj) {
        for (Collection collection : asMap().values()) {
            if (collection.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    abstract Collection createEntries();

    abstract v0 createKeys();

    abstract Collection createValues();

    public Collection entries() {
        Collection<Map.Entry<Object, Object>> collection = this.entries;
        if (collection == null) {
            Collection<Map.Entry<Object, Object>> createEntries = createEntries();
            this.entries = createEntries;
            return createEntries;
        }
        return collection;
    }

    public boolean equals(Object obj) {
        return u0.a(this, obj);
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.t0
    public boolean isEmpty() {
        return size() == 0;
    }

    public v0 keys() {
        v0 v0Var = this.keys;
        if (v0Var == null) {
            v0 createKeys = createKeys();
            this.keys = createKeys;
            return createKeys;
        }
        return v0Var;
    }

    public String toString() {
        return asMap().toString();
    }

    public Collection values() {
        Collection<Object> collection = this.values;
        if (collection == null) {
            Collection<Object> createValues = createValues();
            this.values = createValues;
            return createValues;
        }
        return collection;
    }
}
