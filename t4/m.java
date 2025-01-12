package t4;

import java.util.Iterator;
/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: a  reason: collision with root package name */
    private final d f13399a;

    /* renamed from: b  reason: collision with root package name */
    private final p4.l f13400b;

    /* loaded from: classes.dex */
    public static final class a implements Iterator, q4.a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator f13401a;

        a() {
            this.f13401a = m.this.f13399a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13401a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return m.this.f13400b.invoke(this.f13401a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public m(d dVar, p4.l lVar) {
        kotlin.jvm.internal.l.d(dVar, "sequence");
        kotlin.jvm.internal.l.d(lVar, "transformer");
        this.f13399a = dVar;
        this.f13400b = lVar;
    }

    @Override // t4.d
    public Iterator iterator() {
        return new a();
    }
}
