package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class e extends f implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    private final List f5767a = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof e) && ((e) obj).f5767a.equals(this.f5767a));
    }

    public void h(f fVar) {
        if (fVar == null) {
            fVar = h.f5768a;
        }
        this.f5767a.add(fVar);
    }

    public int hashCode() {
        return this.f5767a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f5767a.iterator();
    }
}
