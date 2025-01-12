package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
final class f extends c implements Serializable {
    private static final long serialVersionUID = 0;
    private final e function;
    private final c resultEquivalence;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, c cVar) {
        this.function = (e) j.j(eVar);
        this.resultEquivalence = (c) j.j(cVar);
    }

    @Override // com.google.common.base.c
    protected boolean doEquivalent(Object obj, Object obj2) {
        return this.resultEquivalence.equivalent(this.function.apply(obj), this.function.apply(obj2));
    }

    @Override // com.google.common.base.c
    protected int doHash(Object obj) {
        return this.resultEquivalence.hash(this.function.apply(obj));
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.function.equals(fVar.function) && this.resultEquivalence.equals(fVar.resultEquivalence);
        }
        return false;
    }

    public int hashCode() {
        return h.b(this.function, this.resultEquivalence);
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
