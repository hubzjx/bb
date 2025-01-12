package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
class x extends c implements Serializable {
    private static final long serialVersionUID = 0;
    @NullableDecl
    final Object key;
    @NullableDecl
    final Object value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(@NullableDecl Object obj, @NullableDecl Object obj2) {
        this.key = obj;
        this.value = obj2;
    }

    @Override // com.google.common.collect.c, java.util.Map.Entry
    @NullableDecl
    public final Object getKey() {
        return this.key;
    }

    @Override // com.google.common.collect.c, java.util.Map.Entry
    @NullableDecl
    public final Object getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.c, java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
