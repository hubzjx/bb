package k;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class b implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    c f11252a;

    /* renamed from: b  reason: collision with root package name */
    private c f11253b;

    /* renamed from: c  reason: collision with root package name */
    private WeakHashMap f11254c = new WeakHashMap();

    /* renamed from: d  reason: collision with root package name */
    private int f11255d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends e {
        a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // k.b.e
        c b(c cVar) {
            return cVar.f11259d;
        }

        @Override // k.b.e
        c c(c cVar) {
            return cVar.f11258c;
        }
    }

    /* renamed from: k.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0183b extends e {
        C0183b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // k.b.e
        c b(c cVar) {
            return cVar.f11258c;
        }

        @Override // k.b.e
        c c(c cVar) {
            return cVar.f11259d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Map.Entry {

        /* renamed from: a  reason: collision with root package name */
        final Object f11256a;

        /* renamed from: b  reason: collision with root package name */
        final Object f11257b;

        /* renamed from: c  reason: collision with root package name */
        c f11258c;

        /* renamed from: d  reason: collision with root package name */
        c f11259d;

        c(Object obj, Object obj2) {
            this.f11256a = obj;
            this.f11257b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f11256a.equals(cVar.f11256a) && this.f11257b.equals(cVar.f11257b);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f11256a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f11257b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f11256a.hashCode() ^ this.f11257b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f11256a + "=" + this.f11257b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Iterator, f {

        /* renamed from: a  reason: collision with root package name */
        private c f11260a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f11261b = true;

        d() {
        }

        @Override // k.b.f
        public void a(c cVar) {
            c cVar2 = this.f11260a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f11259d;
                this.f11260a = cVar3;
                this.f11261b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry next() {
            c cVar;
            if (this.f11261b) {
                this.f11261b = false;
                cVar = b.this.f11252a;
            } else {
                c cVar2 = this.f11260a;
                cVar = cVar2 != null ? cVar2.f11258c : null;
            }
            this.f11260a = cVar;
            return this.f11260a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f11261b) {
                return b.this.f11252a != null;
            }
            c cVar = this.f11260a;
            return (cVar == null || cVar.f11258c == null) ? false : true;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class e implements Iterator, f {

        /* renamed from: a  reason: collision with root package name */
        c f11263a;

        /* renamed from: b  reason: collision with root package name */
        c f11264b;

        e(c cVar, c cVar2) {
            this.f11263a = cVar2;
            this.f11264b = cVar;
        }

        private c e() {
            c cVar = this.f11264b;
            c cVar2 = this.f11263a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // k.b.f
        public void a(c cVar) {
            if (this.f11263a == cVar && cVar == this.f11264b) {
                this.f11264b = null;
                this.f11263a = null;
            }
            c cVar2 = this.f11263a;
            if (cVar2 == cVar) {
                this.f11263a = b(cVar2);
            }
            if (this.f11264b == cVar) {
                this.f11264b = e();
            }
        }

        abstract c b(c cVar);

        abstract c c(c cVar);

        @Override // java.util.Iterator
        /* renamed from: d */
        public Map.Entry next() {
            c cVar = this.f11264b;
            this.f11264b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11264b != null;
        }
    }

    /* loaded from: classes.dex */
    interface f {
        void a(c cVar);
    }

    public Map.Entry a() {
        return this.f11252a;
    }

    protected c b(Object obj) {
        c cVar = this.f11252a;
        while (cVar != null && !cVar.f11256a.equals(obj)) {
            cVar = cVar.f11258c;
        }
        return cVar;
    }

    public d c() {
        d dVar = new d();
        this.f11254c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry d() {
        return this.f11253b;
    }

    public Iterator descendingIterator() {
        C0183b c0183b = new C0183b(this.f11253b, this.f11252a);
        this.f11254c.put(c0183b, Boolean.FALSE);
        return c0183b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c e(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f11255d++;
        c cVar2 = this.f11253b;
        if (cVar2 == null) {
            this.f11252a = cVar;
        } else {
            cVar2.f11258c = cVar;
            cVar.f11259d = cVar2;
        }
        this.f11253b = cVar;
        return cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (size() != bVar.size()) {
                return false;
            }
            Iterator it = iterator();
            Iterator it2 = bVar.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object next = it2.next();
                if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    public Object f(Object obj) {
        c b6 = b(obj);
        if (b6 == null) {
            return null;
        }
        this.f11255d--;
        if (!this.f11254c.isEmpty()) {
            for (f fVar : this.f11254c.keySet()) {
                fVar.a(b6);
            }
        }
        c cVar = b6.f11259d;
        c cVar2 = b6.f11258c;
        if (cVar != null) {
            cVar.f11258c = cVar2;
        } else {
            this.f11252a = cVar2;
        }
        c cVar3 = b6.f11258c;
        if (cVar3 != null) {
            cVar3.f11259d = cVar;
        } else {
            this.f11253b = cVar;
        }
        b6.f11258c = null;
        b6.f11259d = null;
        return b6.f11257b;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += ((Map.Entry) it.next()).hashCode();
        }
        return i6;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f11252a, this.f11253b);
        this.f11254c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f11255d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
