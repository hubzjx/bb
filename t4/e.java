package t4;

import h4.k;
import h4.q;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
final class e extends f implements Iterator, j4.a, q4.a {

    /* renamed from: a  reason: collision with root package name */
    private int f13393a;

    /* renamed from: b  reason: collision with root package name */
    private Object f13394b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator f13395c;

    /* renamed from: d  reason: collision with root package name */
    private j4.a f13396d;

    private final Throwable b() {
        int i6 = this.f13393a;
        if (i6 != 4) {
            if (i6 != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.f13393a);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    private final Object c() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // t4.f
    public Object a(Object obj, j4.a aVar) {
        Object b6;
        Object b7;
        Object b8;
        this.f13394b = obj;
        this.f13393a = 3;
        this.f13396d = aVar;
        b6 = kotlin.coroutines.intrinsics.d.b();
        b7 = kotlin.coroutines.intrinsics.d.b();
        if (b6 == b7) {
            kotlin.coroutines.jvm.internal.g.c(aVar);
        }
        b8 = kotlin.coroutines.intrinsics.d.b();
        return b6 == b8 ? b6 : q.f10774a;
    }

    public final void d(j4.a aVar) {
        this.f13396d = aVar;
    }

    @Override // j4.a
    public j4.c getContext() {
        return j4.d.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i6 = this.f13393a;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2 || i6 == 3) {
                        return true;
                    }
                    if (i6 == 4) {
                        return false;
                    }
                    throw b();
                }
                Iterator it = this.f13395c;
                kotlin.jvm.internal.l.b(it);
                if (it.hasNext()) {
                    this.f13393a = 2;
                    return true;
                }
                this.f13395c = null;
            }
            this.f13393a = 5;
            j4.a aVar = this.f13396d;
            kotlin.jvm.internal.l.b(aVar);
            this.f13396d = null;
            k.a aVar2 = h4.k.Companion;
            aVar.resumeWith(h4.k.m15constructorimpl(q.f10774a));
        }
    }

    @Override // java.util.Iterator
    public Object next() {
        int i6 = this.f13393a;
        if (i6 == 0 || i6 == 1) {
            return c();
        }
        if (i6 == 2) {
            this.f13393a = 1;
            Iterator it = this.f13395c;
            kotlin.jvm.internal.l.b(it);
            return it.next();
        } else if (i6 == 3) {
            this.f13393a = 0;
            Object obj = this.f13394b;
            this.f13394b = null;
            return obj;
        } else {
            throw b();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j4.a
    public void resumeWith(Object obj) {
        h4.l.b(obj);
        this.f13393a = 4;
    }
}
