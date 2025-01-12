package a;

import d.j$k;
import d.j$l;
import d.j$n;
import d.j$p;
import d.j$q;
/* loaded from: classes2.dex */
public enum j$c implements j$k {
    /* JADX INFO: Fake field, exist only in values array */
    MONDAY,
    /* JADX INFO: Fake field, exist only in values array */
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    /* JADX INFO: Fake field, exist only in values array */
    FRIDAY,
    /* JADX INFO: Fake field, exist only in values array */
    SATURDAY,
    /* JADX INFO: Fake field, exist only in values array */
    SUNDAY;
    

    /* renamed from: c  reason: collision with root package name */
    private static final j$c[] f12c = values();

    public static j$c f(int i6) {
        if (i6 < 1 || i6 > 7) {
            throw new j$b("Invalid value for DayOfWeek: " + i6);
        }
        return f12c[i6 - 1];
    }

    @Override // d.j$k
    public final long a(j$l j_l) {
        if (j_l == d.j$a.DAY_OF_WEEK) {
            return ordinal() + 1;
        }
        if (j_l instanceof d.j$a) {
            throw new j$p("Unsupported field: " + j_l);
        }
        return j_l.a(this);
    }

    @Override // d.j$k
    public final j$q b(j$l j_l) {
        return j_l == d.j$a.DAY_OF_WEEK ? j_l.b() : d.j$j.c(this, j_l);
    }

    @Override // d.j$k
    public final Object c(j$n j_n) {
        return j_n == d.j$j.h() ? d.j$b.DAYS : d.j$j.b(this, j_n);
    }

    @Override // d.j$k
    public final boolean d(j$l j_l) {
        return j_l instanceof d.j$a ? j_l == d.j$a.DAY_OF_WEEK : j_l != null && j_l.c(this);
    }

    @Override // d.j$k
    public final int e(d.j$a j_a) {
        return j_a == d.j$a.DAY_OF_WEEK ? ordinal() + 1 : d.j$j.a(this, j_a);
    }
}
