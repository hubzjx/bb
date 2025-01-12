package t4;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private final p4.a f13388a;

    /* renamed from: b  reason: collision with root package name */
    private final p4.l f13389b;

    /* loaded from: classes.dex */
    public static final class a implements Iterator, q4.a {

        /* renamed from: a  reason: collision with root package name */
        private Object f13390a;

        /* renamed from: b  reason: collision with root package name */
        private int f13391b = -2;

        a() {
        }

        private final void a() {
            Object invoke;
            if (this.f13391b == -2) {
                invoke = c.this.f13388a.invoke();
            } else {
                p4.l lVar = c.this.f13389b;
                Object obj = this.f13390a;
                kotlin.jvm.internal.l.b(obj);
                invoke = lVar.invoke(obj);
            }
            this.f13390a = invoke;
            this.f13391b = invoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f13391b < 0) {
                a();
            }
            return this.f13391b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f13391b < 0) {
                a();
            }
            if (this.f13391b != 0) {
                Object obj = this.f13390a;
                if (obj != null) {
                    this.f13391b = -1;
                    return obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public c(p4.a aVar, p4.l lVar) {
        kotlin.jvm.internal.l.d(aVar, "getInitialValue");
        kotlin.jvm.internal.l.d(lVar, "getNextValue");
        this.f13388a = aVar;
        this.f13389b = lVar;
    }

    @Override // t4.d
    public Iterator iterator() {
        return new a();
    }
}
