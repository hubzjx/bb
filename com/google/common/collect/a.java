package com.google.common.collect;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
abstract class a extends t1 {

    /* renamed from: a  reason: collision with root package name */
    private final int f5596a;

    /* renamed from: b  reason: collision with root package name */
    private int f5597b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(int i6, int i7) {
        com.google.common.base.j.l(i7, i6);
        this.f5596a = i6;
        this.f5597b = i7;
    }

    protected abstract Object a(int i6);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f5597b < this.f5596a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f5597b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (hasNext()) {
            int i6 = this.f5597b;
            this.f5597b = i6 + 1;
            return a(i6);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f5597b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i6 = this.f5597b - 1;
            this.f5597b = i6;
            return a(i6);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f5597b - 1;
    }
}
