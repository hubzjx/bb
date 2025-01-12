package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
final class d0 extends w {
    private final a0 map;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s1 {

        /* renamed from: a  reason: collision with root package name */
        final s1 f5628a;

        a() {
            this.f5628a = d0.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5628a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return ((Map.Entry) this.f5628a.next()).getValue();
        }
    }

    /* loaded from: classes.dex */
    class b extends y {
        final /* synthetic */ y val$entryList;

        b(y yVar) {
            this.val$entryList = yVar;
        }

        @Override // java.util.List
        public Object get(int i6) {
            return ((Map.Entry) this.val$entryList.get(i6)).getValue();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.val$entryList.size();
        }
    }

    /* loaded from: classes.dex */
    private static class c implements Serializable {
        private static final long serialVersionUID = 0;
        final a0 map;

        c(a0 a0Var) {
            this.map = a0Var;
        }

        Object readResolve() {
            return this.map.values();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(a0 a0Var) {
        this.map = a0Var;
    }

    @Override // com.google.common.collect.w
    public y asList() {
        return new b(this.map.entrySet().asList());
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return obj != null && n0.c(iterator(), obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public boolean isPartialView() {
        return true;
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public s1 iterator() {
        return new a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.w
    Object writeReplace() {
        return new c(this.map);
    }
}
