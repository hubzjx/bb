package r4;

import kotlin.collections.a0;
import kotlin.jvm.internal.g;
/* loaded from: classes.dex */
public class a implements Iterable, q4.a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0213a f13053d = new C0213a(null);

    /* renamed from: a  reason: collision with root package name */
    private final int f13054a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13055b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13056c;

    /* renamed from: r4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0213a {
        private C0213a() {
        }

        public /* synthetic */ C0213a(g gVar) {
            this();
        }

        public final a a(int i6, int i7, int i8) {
            return new a(i6, i7, i8);
        }
    }

    public a(int i6, int i7, int i8) {
        if (i8 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i8 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f13054a = i6;
        this.f13055b = k4.c.b(i6, i7, i8);
        this.f13056c = i8;
    }

    public final int a() {
        return this.f13054a;
    }

    public final int b() {
        return this.f13055b;
    }

    public final int c() {
        return this.f13056c;
    }

    @Override // java.lang.Iterable
    /* renamed from: d */
    public a0 iterator() {
        return new b(this.f13054a, this.f13055b, this.f13056c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f13054a != aVar.f13054a || this.f13055b != aVar.f13055b || this.f13056c != aVar.f13056c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f13054a * 31) + this.f13055b) * 31) + this.f13056c;
    }

    public boolean isEmpty() {
        if (this.f13056c > 0) {
            if (this.f13054a > this.f13055b) {
                return true;
            }
        } else if (this.f13054a < this.f13055b) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i6;
        if (this.f13056c > 0) {
            sb = new StringBuilder();
            sb.append(this.f13054a);
            sb.append("..");
            sb.append(this.f13055b);
            sb.append(" step ");
            i6 = this.f13056c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f13054a);
            sb.append(" downTo ");
            sb.append(this.f13055b);
            sb.append(" step ");
            i6 = -this.f13056c;
        }
        sb.append(i6);
        return sb.toString();
    }
}
