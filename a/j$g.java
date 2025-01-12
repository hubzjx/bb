package a;

import b.j;
import d.j$k;
import d.j$l;
import d.j$n;
import d.j$p;
import d.j$q;
/* loaded from: classes2.dex */
public enum j$g implements j$k {
    /* JADX INFO: Fake field, exist only in values array */
    JANUARY,
    FEBRUARY,
    /* JADX INFO: Fake field, exist only in values array */
    MARCH,
    /* JADX INFO: Fake field, exist only in values array */
    APRIL,
    /* JADX INFO: Fake field, exist only in values array */
    MAY,
    /* JADX INFO: Fake field, exist only in values array */
    JUNE,
    /* JADX INFO: Fake field, exist only in values array */
    JULY,
    /* JADX INFO: Fake field, exist only in values array */
    AUGUST,
    /* JADX INFO: Fake field, exist only in values array */
    SEPTEMBER,
    /* JADX INFO: Fake field, exist only in values array */
    OCTOBER,
    /* JADX INFO: Fake field, exist only in values array */
    NOVEMBER,
    /* JADX INFO: Fake field, exist only in values array */
    DECEMBER;
    

    /* renamed from: b  reason: collision with root package name */
    private static final j$g[] f29b = values();

    public static j$g g(int i6) {
        if (i6 < 1 || i6 > 12) {
            throw new j$b("Invalid value for MonthOfYear: " + i6);
        }
        return f29b[i6 - 1];
    }

    @Override // d.j$k
    public final long a(j$l j_l) {
        if (j_l == d.j$a.MONTH_OF_YEAR) {
            return ordinal() + 1;
        }
        if (j_l instanceof d.j$a) {
            throw new j$p("Unsupported field: " + j_l);
        }
        return j_l.a(this);
    }

    @Override // d.j$k
    public final j$q b(j$l j_l) {
        return j_l == d.j$a.MONTH_OF_YEAR ? j_l.b() : d.j$j.c(this, j_l);
    }

    @Override // d.j$k
    public final Object c(j$n j_n) {
        return j_n == d.j$j.d() ? j.e.f2842a : j_n == d.j$j.h() ? d.j$b.MONTHS : d.j$j.b(this, j_n);
    }

    @Override // d.j$k
    public final boolean d(j$l j_l) {
        return j_l instanceof d.j$a ? j_l == d.j$a.MONTH_OF_YEAR : j_l != null && j_l.c(this);
    }

    @Override // d.j$k
    public final int e(d.j$a j_a) {
        return j_a == d.j$a.MONTH_OF_YEAR ? ordinal() + 1 : d.j$j.a(this, j_a);
    }

    public final int f(boolean z5) {
        switch (ordinal()) {
            case 0:
                return 1;
            case 1:
                return 32;
            case 2:
                return (z5 ? 1 : 0) + 60;
            case 3:
                return (z5 ? 1 : 0) + 91;
            case 4:
                return (z5 ? 1 : 0) + j.K0;
            case 5:
                return (z5 ? 1 : 0) + 152;
            case 6:
                return (z5 ? 1 : 0) + 182;
            case 7:
                return (z5 ? 1 : 0) + 213;
            case 8:
                return (z5 ? 1 : 0) + 244;
            case 9:
                return (z5 ? 1 : 0) + 274;
            case 10:
                return (z5 ? 1 : 0) + 305;
            default:
                return (z5 ? 1 : 0) + 335;
        }
    }

    public final j$g h() {
        int i6 = ((int) 1) + 12;
        return f29b[(i6 + ordinal()) % 12];
    }
}
