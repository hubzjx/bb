package t4;

import io.jsonwebtoken.JwtParser;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a implements d, b {

    /* renamed from: a  reason: collision with root package name */
    private final d f13384a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13385b;

    /* renamed from: t4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0218a implements Iterator, q4.a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator f13386a;

        /* renamed from: b  reason: collision with root package name */
        private int f13387b;

        C0218a(a aVar) {
            this.f13386a = aVar.f13384a.iterator();
            this.f13387b = aVar.f13385b;
        }

        private final void a() {
            while (this.f13387b > 0 && this.f13386a.hasNext()) {
                this.f13386a.next();
                this.f13387b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f13386a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            return this.f13386a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public a(d dVar, int i6) {
        kotlin.jvm.internal.l.d(dVar, "sequence");
        this.f13384a = dVar;
        this.f13385b = i6;
        if (i6 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i6 + JwtParser.SEPARATOR_CHAR).toString());
    }

    @Override // t4.b
    public d a(int i6) {
        int i7 = this.f13385b + i6;
        return i7 < 0 ? new a(this, i6) : new a(this.f13384a, i7);
    }

    @Override // t4.d
    public Iterator iterator() {
        return new C0218a(this);
    }
}
