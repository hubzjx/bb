package com.google.common.collect;

import com.google.common.collect.f0;
import com.google.common.collect.v0;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g1 extends f0 {
    static final g1 EMPTY = new g1(b1.b());
    final transient b1 contents;
    @LazyInit
    private transient h0 elementSet;
    private final transient int size;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b extends l0 {
        private b() {
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return g1.this.contains(obj);
        }

        @Override // com.google.common.collect.l0
        Object get(int i6) {
            return g1.this.contents.i(i6);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g1.this.contents.C();
        }
    }

    /* loaded from: classes.dex */
    private static class c implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        c(v0 v0Var) {
            int size = v0Var.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i6 = 0;
            for (v0.a aVar : v0Var.entrySet()) {
                this.elements[i6] = aVar.getElement();
                this.counts[i6] = aVar.getCount();
                i6++;
            }
        }

        Object readResolve() {
            f0.b bVar = new f0.b(this.elements.length);
            int i6 = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i6 >= objArr.length) {
                    return bVar.k();
                }
                bVar.j(objArr[i6], this.counts[i6]);
                i6++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(b1 b1Var) {
        this.contents = b1Var;
        long j6 = 0;
        for (int i6 = 0; i6 < b1Var.C(); i6++) {
            j6 += b1Var.k(i6);
        }
        this.size = com.google.common.primitives.b.g(j6);
    }

    @Override // com.google.common.collect.f0, com.google.common.collect.v0
    public int count(@NullableDecl Object obj) {
        return this.contents.f(obj);
    }

    @Override // com.google.common.collect.f0, com.google.common.collect.v0
    public h0 elementSet() {
        h0 h0Var = this.elementSet;
        if (h0Var == null) {
            b bVar = new b();
            this.elementSet = bVar;
            return bVar;
        }
        return h0Var;
    }

    @Override // com.google.common.collect.f0
    v0.a getEntry(int i6) {
        return this.contents.g(i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.v0
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.f0, com.google.common.collect.w
    Object writeReplace() {
        return new c(this);
    }
}
