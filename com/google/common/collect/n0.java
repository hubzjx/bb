package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public abstract class n0 {

    /* loaded from: classes.dex */
    static class a extends s1 {

        /* renamed from: a  reason: collision with root package name */
        boolean f5677a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f5678b;

        a(Object obj) {
            this.f5678b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f5677a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f5677a) {
                throw new NoSuchElementException();
            }
            this.f5677a = true;
            return this.f5678b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends com.google.common.collect.a {

        /* renamed from: e  reason: collision with root package name */
        static final t1 f5679e = new b(new Object[0], 0, 0, 0);

        /* renamed from: c  reason: collision with root package name */
        private final Object[] f5680c;

        /* renamed from: d  reason: collision with root package name */
        private final int f5681d;

        b(Object[] objArr, int i6, int i7, int i8) {
            super(i7, i8);
            this.f5680c = objArr;
            this.f5681d = i6;
        }

        @Override // com.google.common.collect.a
        protected Object a(int i6) {
            return this.f5680c[this.f5681d + i6];
        }
    }

    public static boolean a(Collection collection, Iterator it) {
        com.google.common.base.j.j(collection);
        com.google.common.base.j.j(it);
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= collection.add(it.next());
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Iterator it) {
        com.google.common.base.j.j(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static boolean c(Iterator it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.google.common.base.h.a(it.next(), it2.next())) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return !it2.hasNext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s1 e() {
        return f();
    }

    static t1 f() {
        return b.f5679e;
    }

    public static Object g(Iterator it) {
        Object next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static Object h(Iterator it, Object obj) {
        return it.hasNext() ? it.next() : obj;
    }

    public static boolean i(Iterator it, Collection collection) {
        com.google.common.base.j.j(collection);
        boolean z5 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z5 = true;
            }
        }
        return z5;
    }

    public static s1 j(Object obj) {
        return new a(obj);
    }

    public static String k(Iterator it) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z5 = true;
        while (it.hasNext()) {
            if (!z5) {
                sb.append(", ");
            }
            sb.append(it.next());
            z5 = false;
        }
        sb.append(']');
        return sb.toString();
    }
}
