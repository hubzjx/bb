package a;

import b.j;
import d.j$k;
import d.j$l;
import d.j$n;
import d.j$p;
import d.j$q;
import java.io.Serializable;
/* loaded from: classes2.dex */
public final class j$d implements j$k, j.b, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final j$d f14d = n(-999999999, 1, 1);

    /* renamed from: e  reason: collision with root package name */
    public static final j$d f15e = n(999999999, 12, 31);

    /* renamed from: a  reason: collision with root package name */
    private final int f16a;

    /* renamed from: b  reason: collision with root package name */
    private final short f17b;

    /* renamed from: c  reason: collision with root package name */
    private final short f18c;

    private j$d(int i6, int i7, int i8) {
        this.f16a = i6;
        this.f17b = (short) i7;
        this.f18c = (short) i8;
    }

    public static j$d h(j$k j_k) {
        if (j_k != null) {
            j$d j_d = (j$d) j_k.c(d.j$j.e());
            if (j_d != null) {
                return j_d;
            }
            throw new j$b("Unable to obtain LocalDate from TemporalAccessor: " + j_k + " of type " + j_k.getClass().getName());
        }
        throw new NullPointerException("temporal");
    }

    private int i(j$l j_l) {
        int i6;
        int i7;
        int i8;
        switch (((d.j$a) j_l).ordinal()) {
            case 15:
                return j().ordinal() + 1;
            case 16:
                i6 = this.f18c;
                i7 = (i6 - 1) % 7;
                return i7 + 1;
            case 17:
                i6 = k();
                i7 = (i6 - 1) % 7;
                return i7 + 1;
            case 18:
                return this.f18c;
            case 19:
                return k();
            case 20:
                throw new j$p("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 21:
                i8 = this.f18c;
                i7 = (i8 - 1) / 7;
                return i7 + 1;
            case 22:
                i8 = k();
                i7 = (i8 - 1) / 7;
                return i7 + 1;
            case 23:
                return this.f17b;
            case 24:
                throw new j$p("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 25:
                int i9 = this.f16a;
                return i9 >= 1 ? i9 : 1 - i9;
            case 26:
                return this.f16a;
            case 27:
                return this.f16a >= 1 ? 1 : 0;
            default:
                throw new j$p("Unsupported field: " + j_l);
        }
    }

    public static j$d n(int i6, int i7, int i8) {
        long j6 = i6;
        d.j$a.YEAR.h(j6);
        d.j$a.MONTH_OF_YEAR.h(i7);
        d.j$a.DAY_OF_MONTH.h(i8);
        int i9 = 28;
        if (i8 > 28) {
            if (i7 != 2) {
                i9 = (i7 == 4 || i7 == 6 || i7 == 9 || i7 == 11) ? 30 : 31;
            } else {
                j.e.f2842a.getClass();
                if (j.e.a(j6)) {
                    i9 = 29;
                }
            }
            if (i8 > i9) {
                if (i8 == 29) {
                    throw new j$b("Invalid date 'February 29' as '" + i6 + "' is not a leap year");
                }
                throw new j$b("Invalid date '" + j$g.g(i7).name() + " " + i8 + "'");
            }
        }
        return new j$d(i6, i7, i8);
    }

    public static j$d o(long j6) {
        long j7;
        long j8 = (j6 + 719528) - 60;
        if (j8 < 0) {
            long j9 = ((j8 + 1) / 146097) - 1;
            j7 = j9 * 400;
            j8 += (-j9) * 146097;
        } else {
            j7 = 0;
        }
        long j10 = ((j8 * 400) + 591) / 146097;
        long j11 = j8 - ((j10 / 400) + (((j10 / 4) + (j10 * 365)) - (j10 / 100)));
        if (j11 < 0) {
            j10--;
            j11 = j8 - ((j10 / 400) + (((j10 / 4) + (365 * j10)) - (j10 / 100)));
        }
        int i6 = (int) j11;
        int i7 = ((i6 * 5) + 2) / 153;
        return new j$d(d.j$a.YEAR.g(j10 + j7 + (i7 / 10)), ((i7 + 2) % 12) + 1, (i6 - (((i7 * 306) + 5) / 10)) + 1);
    }

    @Override // d.j$k
    public final long a(j$l j_l) {
        return j_l instanceof d.j$a ? j_l == d.j$a.EPOCH_DAY ? q() : j_l == d.j$a.PROLEPTIC_MONTH ? ((this.f16a * 12) + this.f17b) - 1 : i(j_l) : j_l.a(this);
    }

    @Override // d.j$k
    public final j$q b(j$l j_l) {
        int i6;
        if (j_l instanceof d.j$a) {
            d.j$a j_a = (d.j$a) j_l;
            if (!j_a.e()) {
                throw new j$p("Unsupported field: " + j_l);
            }
            int ordinal = j_a.ordinal();
            if (ordinal == 18) {
                short s5 = this.f17b;
                i6 = s5 != 2 ? (s5 == 4 || s5 == 6 || s5 == 9 || s5 == 11) ? 30 : 31 : m() ? 29 : 28;
            } else if (ordinal != 19) {
                if (ordinal == 21) {
                    return j$q.i(1L, (j$g.g(this.f17b) != j$g.FEBRUARY || m()) ? 5L : 4L);
                } else if (ordinal != 25) {
                    return j_l.b();
                } else {
                    return j$q.i(1L, this.f16a <= 0 ? 1000000000L : 999999999L);
                }
            } else {
                i6 = m() ? 366 : 365;
            }
            return j$q.i(1L, i6);
        }
        return j_l.f(this);
    }

    @Override // d.j$k
    public final Object c(j$n j_n) {
        if (j_n == d.j$j.e()) {
            return this;
        }
        if (j_n == d.j$j.j() || j_n == d.j$j.i() || j_n == d.j$j.g() || j_n == d.j$j.f()) {
            return null;
        }
        return j_n == d.j$j.d() ? j.e.f2842a : j_n == d.j$j.h() ? d.j$b.DAYS : j_n.a(this);
    }

    @Override // d.j$k
    public final boolean d(j$l j_l) {
        return j_l instanceof d.j$a ? j_l.e() : j_l != null && j_l.c(this);
    }

    @Override // d.j$k
    public final int e(d.j$a j_a) {
        return j_a instanceof d.j$a ? i(j_a) : d.j$j.a(this, j_a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j$d) && g((j$d) obj) == 0;
    }

    @Override // java.lang.Comparable
    /* renamed from: f */
    public final int compareTo(j.b bVar) {
        if (bVar instanceof j$d) {
            return g((j$d) bVar);
        }
        int compare = Long.compare(q(), ((j$d) bVar).q());
        if (compare == 0) {
            j.e.f2842a.getClass();
            return 0;
        }
        return compare;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int g(j$d j_d) {
        int i6 = this.f16a - j_d.f16a;
        if (i6 == 0) {
            int i7 = this.f17b - j_d.f17b;
            return i7 == 0 ? this.f18c - j_d.f18c : i7;
        }
        return i6;
    }

    public final int hashCode() {
        int i6 = this.f16a;
        return (((i6 << 11) + (this.f17b << 6)) + this.f18c) ^ (i6 & (-2048));
    }

    public final j$c j() {
        return j$c.f(((int) j$a.c(q() + 3, 7L)) + 1);
    }

    public final int k() {
        return (j$g.g(this.f17b).f(m()) + this.f18c) - 1;
    }

    public final int l() {
        return this.f16a;
    }

    public final boolean m() {
        j.e.f2842a.getClass();
        return j.e.a(this.f16a);
    }

    public final j$d p(long j6) {
        int i6;
        if (j6 == 0) {
            return this;
        }
        int g6 = d.j$a.YEAR.g(this.f16a + j6);
        short s5 = this.f17b;
        int i7 = this.f18c;
        if (s5 != 2) {
            if (s5 == 4 || s5 == 6 || s5 == 9 || s5 == 11) {
                i6 = 30;
            }
            return new j$d(g6, s5, i7);
        }
        j.e.f2842a.getClass();
        i6 = j.e.a((long) g6) ? 29 : 28;
        i7 = Math.min(i7, i6);
        return new j$d(g6, s5, i7);
    }

    public final long q() {
        long j6;
        long j7 = this.f16a;
        long j8 = this.f17b;
        long j9 = (365 * j7) + 0;
        if (j7 >= 0) {
            j6 = ((j7 + 399) / 400) + (((3 + j7) / 4) - ((99 + j7) / 100)) + j9;
        } else {
            j6 = j9 - ((j7 / (-400)) + ((j7 / (-4)) - (j7 / (-100))));
        }
        long j10 = (((367 * j8) - 362) / 12) + j6 + (this.f18c - 1);
        if (j8 > 2) {
            j10--;
            if (!m()) {
                j10--;
            }
        }
        return j10 - 719528;
    }

    public final j$d r() {
        if (k() == 180) {
            return this;
        }
        int i6 = this.f16a;
        long j6 = i6;
        d.j$a.YEAR.h(j6);
        d.j$a.DAY_OF_YEAR.h(180);
        j.e.f2842a.getClass();
        boolean a6 = j.e.a(j6);
        j$g g6 = j$g.g(6);
        int f6 = g6.f(a6);
        int ordinal = g6.ordinal();
        if (180 > (f6 + (ordinal != 1 ? (ordinal == 3 || ordinal == 5 || ordinal == 8 || ordinal == 10) ? 30 : 31 : a6 ? 29 : 28)) - 1) {
            g6 = g6.h();
        }
        return new j$d(i6, g6.ordinal() + 1, (180 - g6.f(a6)) + 1);
    }

    public final String toString() {
        int i6;
        int i7 = this.f16a;
        short s5 = this.f17b;
        short s6 = this.f18c;
        int abs = Math.abs(i7);
        StringBuilder sb = new StringBuilder(10);
        if (abs < 1000) {
            if (i7 < 0) {
                sb.append(i7 - 10000);
                i6 = 1;
            } else {
                sb.append(i7 + 10000);
                i6 = 0;
            }
            sb.deleteCharAt(i6);
        } else {
            if (i7 > 9999) {
                sb.append('+');
            }
            sb.append(i7);
        }
        sb.append(s5 < 10 ? "-0" : "-");
        sb.append((int) s5);
        sb.append(s6 >= 10 ? "-" : "-0");
        sb.append((int) s6);
        return sb.toString();
    }
}
