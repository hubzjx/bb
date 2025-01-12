package a;

import b.j;
import d.j$k;
import d.j$l;
import d.j$n;
import d.j$q;
import java.io.Serializable;
/* loaded from: classes2.dex */
public final class j$e implements j$k, j.c, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final j$d f19a;

    /* renamed from: b  reason: collision with root package name */
    private final j$f f20b;

    static {
        j$d j_d = j$d.f14d;
        j$f j_f = j$f.f21e;
        if (j_d == null) {
            throw new NullPointerException("date");
        }
        if (j_f == null) {
            throw new NullPointerException("time");
        }
        j$d j_d2 = j$d.f15e;
        j$f j_f2 = j$f.f22f;
        if (j_d2 == null) {
            throw new NullPointerException("date");
        }
        if (j_f2 == null) {
            throw new NullPointerException("time");
        }
    }

    private j$e(j$d j_d, j$f j_f) {
        this.f19a = j_d;
        this.f20b = j_f;
    }

    public static j$e i(long j6, int i6, j$i j_i) {
        long g6;
        if (j_i != null) {
            long j7 = i6;
            d.j$a.NANO_OF_SECOND.h(j7);
            return new j$e(j$d.o(j$a.e(j6 + j_i.g(), 86400L)), j$f.i((((int) j$a.c(g6, 86400L)) * 1000000000) + j7));
        }
        throw new NullPointerException("offset");
    }

    @Override // d.j$k
    public final long a(j$l j_l) {
        return j_l instanceof d.j$a ? ((d.j$a) j_l).d() ? this.f20b.a(j_l) : this.f19a.a(j_l) : j_l.a(this);
    }

    @Override // d.j$k
    public final j$q b(j$l j_l) {
        if (j_l instanceof d.j$a) {
            if (((d.j$a) j_l).d()) {
                j$f j_f = this.f20b;
                j_f.getClass();
                return d.j$j.c(j_f, j_l);
            }
            return this.f19a.b(j_l);
        }
        return j_l.f(this);
    }

    @Override // d.j$k
    public final Object c(j$n j_n) {
        if (j_n == d.j$j.e()) {
            return this.f19a;
        }
        if (j_n == d.j$j.j() || j_n == d.j$j.i() || j_n == d.j$j.g()) {
            return null;
        }
        if (j_n == d.j$j.f()) {
            return this.f20b;
        }
        if (j_n != d.j$j.d()) {
            return j_n == d.j$j.h() ? d.j$b.NANOS : j_n.a(this);
        }
        ((j$d) j()).getClass();
        return j.e.f2842a;
    }

    @Override // d.j$k
    public final boolean d(j$l j_l) {
        if (!(j_l instanceof d.j$a)) {
            return j_l != null && j_l.c(this);
        }
        d.j$a j_a = (d.j$a) j_l;
        return j_a.e() || j_a.d();
    }

    @Override // d.j$k
    public final int e(d.j$a j_a) {
        return j_a instanceof d.j$a ? j_a.d() ? this.f20b.e(j_a) : this.f19a.e(j_a) : d.j$j.a(this, j_a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j$e) {
            j$e j_e = (j$e) obj;
            return this.f19a.equals(j_e.f19a) && this.f20b.equals(j_e.f20b);
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: f */
    public final int compareTo(j.c cVar) {
        if (cVar instanceof j$e) {
            j$e j_e = (j$e) cVar;
            int g6 = this.f19a.g(j_e.f19a);
            return g6 == 0 ? this.f20b.compareTo(j_e.f20b) : g6;
        }
        j$e j_e2 = (j$e) cVar;
        int compareTo = this.f19a.compareTo(j_e2.f19a);
        if (compareTo == 0) {
            int compareTo2 = this.f20b.compareTo(j_e2.f20b);
            if (compareTo2 == 0) {
                ((j$d) j()).getClass();
                j.e eVar = j.e.f2842a;
                ((j$d) j_e2.j()).getClass();
                eVar.getClass();
                eVar.getClass();
                return 0;
            }
            return compareTo2;
        }
        return compareTo;
    }

    public final int g() {
        return this.f20b.h();
    }

    public final int h() {
        return this.f19a.l();
    }

    public final int hashCode() {
        return this.f19a.hashCode() ^ this.f20b.hashCode();
    }

    public final j.b j() {
        return this.f19a;
    }

    public final String toString() {
        return this.f19a.toString() + 'T' + this.f20b.toString();
    }
}
