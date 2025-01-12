package com.google.common.collect;

import java.util.Comparator;
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    private static final n f5673a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final n f5674b = new b(-1);

    /* renamed from: c  reason: collision with root package name */
    private static final n f5675c = new b(1);

    /* loaded from: classes.dex */
    static class a extends n {
        a() {
            super(null);
        }

        @Override // com.google.common.collect.n
        public n d(int i6, int i7) {
            return j(com.google.common.primitives.b.c(i6, i7));
        }

        @Override // com.google.common.collect.n
        public n e(Object obj, Object obj2, Comparator comparator) {
            return j(comparator.compare(obj, obj2));
        }

        @Override // com.google.common.collect.n
        public n f(boolean z5, boolean z6) {
            return j(com.google.common.primitives.a.a(z5, z6));
        }

        @Override // com.google.common.collect.n
        public n g(boolean z5, boolean z6) {
            return j(com.google.common.primitives.a.a(z6, z5));
        }

        @Override // com.google.common.collect.n
        public int h() {
            return 0;
        }

        n j(int i6) {
            return i6 < 0 ? n.f5674b : i6 > 0 ? n.f5675c : n.f5673a;
        }
    }

    /* loaded from: classes.dex */
    private static final class b extends n {

        /* renamed from: d  reason: collision with root package name */
        final int f5676d;

        b(int i6) {
            super(null);
            this.f5676d = i6;
        }

        @Override // com.google.common.collect.n
        public n d(int i6, int i7) {
            return this;
        }

        @Override // com.google.common.collect.n
        public n e(Object obj, Object obj2, Comparator comparator) {
            return this;
        }

        @Override // com.google.common.collect.n
        public n f(boolean z5, boolean z6) {
            return this;
        }

        @Override // com.google.common.collect.n
        public n g(boolean z5, boolean z6) {
            return this;
        }

        @Override // com.google.common.collect.n
        public int h() {
            return this.f5676d;
        }
    }

    private n() {
    }

    /* synthetic */ n(a aVar) {
        this();
    }

    public static n i() {
        return f5673a;
    }

    public abstract n d(int i6, int i7);

    public abstract n e(Object obj, Object obj2, Comparator comparator);

    public abstract n f(boolean z5, boolean z6);

    public abstract n g(boolean z5, boolean z6);

    public abstract int h();
}
