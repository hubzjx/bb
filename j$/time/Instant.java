package j$.time;

import a.j$a;
import a.j$b;
import d.j$j;
import d.j$k;
import d.j$l;
import d.j$n;
import d.j$p;
import d.j$q;
import java.io.Serializable;
/* loaded from: classes2.dex */
public final class Instant implements j$k, Comparable, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final Instant f11047c = new Instant(0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final long f11048a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11049b;

    static {
        i(-31557014167219200L, 0L);
        i(31556889864403199L, 999999999L);
    }

    private Instant(long j6, int i6) {
        this.f11048a = j6;
        this.f11049b = i6;
    }

    private static Instant g(long j6, int i6) {
        if ((i6 | j6) == 0) {
            return f11047c;
        }
        if (j6 < -31557014167219200L || j6 > 31556889864403199L) {
            throw new j$b("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j6, i6);
    }

    public static Instant h(long j6) {
        return g(j$a.e(j6, 1000L), ((int) j$a.c(j6, 1000L)) * 1000000);
    }

    public static Instant i(long j6, long j7) {
        return g(j$a.a(j6, j$a.e(j7, 1000000000L)), (int) j$a.c(j7, 1000000000L));
    }

    @Override // d.j$k
    public final long a(j$l j_l) {
        int i6;
        if (j_l instanceof d.j$a) {
            int ordinal = ((d.j$a) j_l).ordinal();
            if (ordinal == 0) {
                i6 = this.f11049b;
            } else if (ordinal == 2) {
                i6 = this.f11049b / 1000;
            } else if (ordinal != 4) {
                if (ordinal == 28) {
                    return this.f11048a;
                }
                throw new j$p("Unsupported field: " + j_l);
            } else {
                i6 = this.f11049b / 1000000;
            }
            return i6;
        }
        return j_l.a(this);
    }

    @Override // d.j$k
    public final j$q b(j$l j_l) {
        return j$j.c(this, j_l);
    }

    @Override // d.j$k
    public final Object c(j$n j_n) {
        if (j_n == j$j.h()) {
            return d.j$b.NANOS;
        }
        if (j_n == j$j.d() || j_n == j$j.j() || j_n == j$j.i() || j_n == j$j.g() || j_n == j$j.e() || j_n == j$j.f()) {
            return null;
        }
        return j_n.a(this);
    }

    @Override // d.j$k
    public final boolean d(j$l j_l) {
        return j_l instanceof d.j$a ? j_l == d.j$a.INSTANT_SECONDS || j_l == d.j$a.NANO_OF_SECOND || j_l == d.j$a.MICRO_OF_SECOND || j_l == d.j$a.MILLI_OF_SECOND : j_l != null && j_l.c(this);
    }

    @Override // d.j$k
    public final int e(d.j$a j_a) {
        if (j_a instanceof d.j$a) {
            int ordinal = j_a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 2) {
                    if (ordinal != 4) {
                        if (ordinal == 28) {
                            d.j$a.INSTANT_SECONDS.g(this.f11048a);
                        }
                        throw new j$p("Unsupported field: " + j_a);
                    }
                    return this.f11049b / 1000000;
                }
                return this.f11049b / 1000;
            }
            return this.f11049b;
        }
        return j$j.c(this, j_a).a(a(j_a), j_a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            return this.f11048a == instant.f11048a && this.f11049b == instant.f11049b;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: f */
    public final int compareTo(Instant instant) {
        int compare = Long.compare(this.f11048a, instant.f11048a);
        return compare != 0 ? compare : this.f11049b - instant.f11049b;
    }

    public final int hashCode() {
        long j6 = this.f11048a;
        return (this.f11049b * 51) + ((int) (j6 ^ (j6 >>> 32)));
    }

    public long toEpochMilli() {
        long d6;
        int i6;
        long j6 = this.f11048a;
        if (j6 >= 0 || this.f11049b <= 0) {
            d6 = j$a.d(j6);
            i6 = this.f11049b / 1000000;
        } else {
            d6 = j$a.d(j6 + 1);
            i6 = (this.f11049b / 1000000) - 1000;
        }
        return j$a.a(d6, i6);
    }

    public final String toString() {
        return c.j$b.f3043d.a(this);
    }
}
