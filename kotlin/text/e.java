package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements t4.d {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f11335a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11336b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11337c;

    /* renamed from: d  reason: collision with root package name */
    private final p4.p f11338d;

    /* loaded from: classes.dex */
    public static final class a implements Iterator, q4.a {

        /* renamed from: a  reason: collision with root package name */
        private int f11339a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f11340b;

        /* renamed from: c  reason: collision with root package name */
        private int f11341c;

        /* renamed from: d  reason: collision with root package name */
        private r4.c f11342d;

        /* renamed from: e  reason: collision with root package name */
        private int f11343e;

        a() {
            int d6;
            d6 = r4.f.d(e.this.f11336b, 0, e.this.f11335a.length());
            this.f11340b = d6;
            this.f11341c = d6;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
            if (r0 < r6.f11344f.f11337c) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void a() {
            r4.c g6;
            r4.c cVar;
            if (this.f11341c < 0) {
                this.f11339a = 0;
                this.f11342d = null;
                return;
            }
            int i6 = -1;
            if (e.this.f11337c > 0) {
                int i7 = this.f11343e + 1;
                this.f11343e = i7;
            }
            if (this.f11341c <= e.this.f11335a.length()) {
                h4.j jVar = (h4.j) e.this.f11338d.invoke(e.this.f11335a, Integer.valueOf(this.f11341c));
                if (jVar == null) {
                    cVar = new r4.c(this.f11340b, x.I(e.this.f11335a));
                    this.f11342d = cVar;
                    this.f11341c = i6;
                    this.f11339a = 1;
                }
                int intValue = ((Number) jVar.component1()).intValue();
                int intValue2 = ((Number) jVar.component2()).intValue();
                g6 = r4.f.g(this.f11340b, intValue);
                this.f11342d = g6;
                int i8 = intValue + intValue2;
                this.f11340b = i8;
                i6 = i8 + (intValue2 == 0 ? 1 : 0);
                this.f11341c = i6;
                this.f11339a = 1;
            }
            cVar = new r4.c(this.f11340b, x.I(e.this.f11335a));
            this.f11342d = cVar;
            this.f11341c = i6;
            this.f11339a = 1;
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public r4.c next() {
            if (this.f11339a == -1) {
                a();
            }
            if (this.f11339a != 0) {
                r4.c cVar = this.f11342d;
                if (cVar != null) {
                    this.f11342d = null;
                    this.f11339a = -1;
                    return cVar;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f11339a == -1) {
                a();
            }
            return this.f11339a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(CharSequence charSequence, int i6, int i7, p4.p pVar) {
        kotlin.jvm.internal.l.d(charSequence, "input");
        kotlin.jvm.internal.l.d(pVar, "getNextMatch");
        this.f11335a = charSequence;
        this.f11336b = i6;
        this.f11337c = i7;
        this.f11338d = pVar;
    }

    @Override // t4.d
    public Iterator iterator() {
        return new a();
    }
}
