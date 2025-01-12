package com.google.common.collect;

import com.google.common.base.g;
import com.google.common.collect.r0;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: a  reason: collision with root package name */
    boolean f5682a;

    /* renamed from: b  reason: collision with root package name */
    int f5683b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f5684c = -1;

    /* renamed from: d  reason: collision with root package name */
    r0.p f5685d;

    /* renamed from: e  reason: collision with root package name */
    r0.p f5686e;

    /* renamed from: f  reason: collision with root package name */
    com.google.common.base.c f5687f;

    /* loaded from: classes.dex */
    enum a {
        VALUE
    }

    public q0 a(int i6) {
        int i7 = this.f5684c;
        com.google.common.base.j.p(i7 == -1, "concurrency level was already set to %s", i7);
        com.google.common.base.j.d(i6 > 0);
        this.f5684c = i6;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i6 = this.f5684c;
        if (i6 == -1) {
            return 4;
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        int i6 = this.f5683b;
        if (i6 == -1) {
            return 16;
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.common.base.c d() {
        return (com.google.common.base.c) com.google.common.base.g.a(this.f5687f, e().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0.p e() {
        return (r0.p) com.google.common.base.g.a(this.f5685d, r0.p.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0.p f() {
        return (r0.p) com.google.common.base.g.a(this.f5686e, r0.p.STRONG);
    }

    public q0 g(int i6) {
        int i7 = this.f5683b;
        com.google.common.base.j.p(i7 == -1, "initial capacity was already set to %s", i7);
        com.google.common.base.j.d(i6 >= 0);
        this.f5683b = i6;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q0 h(com.google.common.base.c cVar) {
        com.google.common.base.c cVar2 = this.f5687f;
        com.google.common.base.j.q(cVar2 == null, "key equivalence was already set to %s", cVar2);
        this.f5687f = (com.google.common.base.c) com.google.common.base.j.j(cVar);
        this.f5682a = true;
        return this;
    }

    public ConcurrentMap i() {
        return !this.f5682a ? new ConcurrentHashMap(c(), 0.75f, b()) : r0.create(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q0 j(r0.p pVar) {
        r0.p pVar2 = this.f5685d;
        com.google.common.base.j.q(pVar2 == null, "Key strength was already set to %s", pVar2);
        this.f5685d = (r0.p) com.google.common.base.j.j(pVar);
        if (pVar != r0.p.STRONG) {
            this.f5682a = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q0 k(r0.p pVar) {
        r0.p pVar2 = this.f5686e;
        com.google.common.base.j.q(pVar2 == null, "Value strength was already set to %s", pVar2);
        this.f5686e = (r0.p) com.google.common.base.j.j(pVar);
        if (pVar != r0.p.STRONG) {
            this.f5682a = true;
        }
        return this;
    }

    public q0 l() {
        return j(r0.p.WEAK);
    }

    public String toString() {
        g.b b6 = com.google.common.base.g.b(this);
        int i6 = this.f5683b;
        if (i6 != -1) {
            b6.a("initialCapacity", i6);
        }
        int i7 = this.f5684c;
        if (i7 != -1) {
            b6.a("concurrencyLevel", i7);
        }
        r0.p pVar = this.f5685d;
        if (pVar != null) {
            b6.b("keyStrength", com.google.common.base.a.b(pVar.toString()));
        }
        r0.p pVar2 = this.f5686e;
        if (pVar2 != null) {
            b6.b("valueStrength", com.google.common.base.a.b(pVar2.toString()));
        }
        if (this.f5687f != null) {
            b6.f("keyEquivalence");
        }
        return b6.toString();
    }
}
