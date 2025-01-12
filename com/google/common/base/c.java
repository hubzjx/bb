package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public abstract class c {

    /* loaded from: classes.dex */
    static final class b extends c implements Serializable {
        static final b INSTANCE = new b();
        private static final long serialVersionUID = 1;

        b() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.c
        protected boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.c
        protected int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    /* renamed from: com.google.common.base.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0053c implements k, Serializable {
        private static final long serialVersionUID = 0;
        private final c equivalence;
        @NullableDecl
        private final Object target;

        C0053c(c cVar, @NullableDecl Object obj) {
            this.equivalence = (c) j.j(cVar);
            this.target = obj;
        }

        @Override // com.google.common.base.k
        public boolean apply(@NullableDecl Object obj) {
            return this.equivalence.equivalent(obj, this.target);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0053c) {
                C0053c c0053c = (C0053c) obj;
                return this.equivalence.equals(c0053c.equivalence) && h.a(this.target, c0053c.target);
            }
            return false;
        }

        public int hashCode() {
            return h.b(this.equivalence, this.target);
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + ")";
        }
    }

    /* loaded from: classes.dex */
    static final class d extends c implements Serializable {
        static final d INSTANCE = new d();
        private static final long serialVersionUID = 1;

        d() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.c
        protected boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.c
        protected int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    /* loaded from: classes.dex */
    public static final class e implements Serializable {
        private static final long serialVersionUID = 0;
        private final c equivalence;
        @NullableDecl
        private final Object reference;

        private e(c cVar, @NullableDecl Object obj) {
            this.equivalence = (c) j.j(cVar);
            this.reference = obj;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (this.equivalence.equals(eVar.equivalence)) {
                    return this.equivalence.equivalent(this.reference, eVar.reference);
                }
                return false;
            }
            return false;
        }

        @NullableDecl
        public Object get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }
    }

    public static c equals() {
        return b.INSTANCE;
    }

    public static c identity() {
        return d.INSTANCE;
    }

    protected abstract boolean doEquivalent(Object obj, Object obj2);

    protected abstract int doHash(Object obj);

    public final boolean equivalent(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return doEquivalent(obj, obj2);
    }

    public final k equivalentTo(@NullableDecl Object obj) {
        return new C0053c(this, obj);
    }

    public final int hash(@NullableDecl Object obj) {
        if (obj == null) {
            return 0;
        }
        return doHash(obj);
    }

    public final <F> c onResultOf(com.google.common.base.e eVar) {
        return new f(eVar, this);
    }

    public final <S> c pairwise() {
        return new i(this);
    }

    public final <S> e wrap(@NullableDecl S s5) {
        return new e(s5);
    }
}
