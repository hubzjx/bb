package com.google.gson;

import java.util.Set;
/* loaded from: classes.dex */
public final class i extends f {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.internal.h f5769a = new com.google.gson.internal.h();

    public Set entrySet() {
        return this.f5769a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).f5769a.equals(this.f5769a));
    }

    public void h(String str, f fVar) {
        com.google.gson.internal.h hVar = this.f5769a;
        if (fVar == null) {
            fVar = h.f5768a;
        }
        hVar.put(str, fVar);
    }

    public int hashCode() {
        return this.f5769a.hashCode();
    }
}
