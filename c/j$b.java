package c;

import b.j;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class j$b {

    /* renamed from: d  reason: collision with root package name */
    public static final j$b f3043d;

    /* renamed from: a  reason: collision with root package name */
    private final j$f f3044a;

    /* renamed from: b  reason: collision with root package name */
    private final Locale f3045b;

    /* renamed from: c  reason: collision with root package name */
    private final j.d f3046c;

    static {
        j$p j_p = new j$p();
        d.j$a j_a = d.j$a.YEAR;
        j_p.l(j_a, 4, 10, 5);
        j_p.e('-');
        d.j$a j_a2 = d.j$a.MONTH_OF_YEAR;
        j_p.k(j_a2, 2);
        j_p.e('-');
        d.j$a j_a3 = d.j$a.DAY_OF_MONTH;
        j_p.k(j_a3, 2);
        j.e eVar = j.e.f2842a;
        j$b s5 = j_p.s(1, eVar);
        j$p j_p2 = new j$p();
        j_p2.p();
        j_p2.a(s5);
        j_p2.h();
        j_p2.s(1, eVar);
        j$p j_p3 = new j$p();
        j_p3.p();
        j_p3.a(s5);
        j_p3.o();
        j_p3.h();
        j_p3.s(1, eVar);
        j$p j_p4 = new j$p();
        d.j$a j_a4 = d.j$a.HOUR_OF_DAY;
        j_p4.k(j_a4, 2);
        j_p4.e(':');
        d.j$a j_a5 = d.j$a.MINUTE_OF_HOUR;
        j_p4.k(j_a5, 2);
        j_p4.o();
        j_p4.e(':');
        d.j$a j_a6 = d.j$a.SECOND_OF_MINUTE;
        j_p4.k(j_a6, 2);
        j_p4.o();
        j_p4.b(d.j$a.NANO_OF_SECOND);
        j$b s6 = j_p4.s(1, null);
        j$p j_p5 = new j$p();
        j_p5.p();
        j_p5.a(s6);
        j_p5.h();
        j_p5.s(1, null);
        j$p j_p6 = new j$p();
        j_p6.p();
        j_p6.a(s6);
        j_p6.o();
        j_p6.h();
        j_p6.s(1, null);
        j$p j_p7 = new j$p();
        j_p7.p();
        j_p7.a(s5);
        j_p7.e('T');
        j_p7.a(s6);
        j$b s7 = j_p7.s(1, eVar);
        j$p j_p8 = new j$p();
        j_p8.p();
        j_p8.a(s7);
        j_p8.h();
        j$b s8 = j_p8.s(1, eVar);
        j$p j_p9 = new j$p();
        j_p9.a(s8);
        j_p9.o();
        j_p9.e('[');
        j_p9.q();
        j_p9.m();
        j_p9.e(']');
        j_p9.s(1, eVar);
        j$p j_p10 = new j$p();
        j_p10.a(s7);
        j_p10.o();
        j_p10.h();
        j_p10.o();
        j_p10.e('[');
        j_p10.q();
        j_p10.m();
        j_p10.e(']');
        j_p10.s(1, eVar);
        j$p j_p11 = new j$p();
        j_p11.p();
        j_p11.l(j_a, 4, 10, 5);
        j_p11.e('-');
        j_p11.k(d.j$a.DAY_OF_YEAR, 3);
        j_p11.o();
        j_p11.h();
        j_p11.s(1, eVar);
        j$p j_p12 = new j$p();
        j_p12.p();
        j_p12.l(d.j$i.f9096c, 4, 10, 5);
        j_p12.f("-W");
        j_p12.k(d.j$i.f9095b, 2);
        j_p12.e('-');
        d.j$a j_a7 = d.j$a.DAY_OF_WEEK;
        j_p12.k(j_a7, 1);
        j_p12.o();
        j_p12.h();
        j_p12.s(1, eVar);
        j$p j_p13 = new j$p();
        j_p13.p();
        j_p13.c();
        f3043d = j_p13.s(1, null);
        j$p j_p14 = new j$p();
        j_p14.p();
        j_p14.k(j_a, 4);
        j_p14.k(j_a2, 2);
        j_p14.k(j_a3, 2);
        j_p14.o();
        j_p14.g("+HHMMss", "Z");
        j_p14.s(1, eVar);
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        j$p j_p15 = new j$p();
        j_p15.p();
        j_p15.r();
        j_p15.o();
        j_p15.i(j_a7, hashMap);
        j_p15.f(", ");
        j_p15.n();
        j_p15.l(j_a3, 1, 2, 4);
        j_p15.e(' ');
        j_p15.i(j_a2, hashMap2);
        j_p15.e(' ');
        j_p15.k(j_a, 4);
        j_p15.e(' ');
        j_p15.k(j_a4, 2);
        j_p15.e(':');
        j_p15.k(j_a5, 2);
        j_p15.o();
        j_p15.e(':');
        j_p15.k(j_a6, 2);
        j_p15.n();
        j_p15.e(' ');
        j_p15.g("+HHMM", "GMT");
        j_p15.s(2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$b(j$f j_f, Locale locale, int i6, j.e eVar) {
        j$t j_t = j$t.f3091a;
        this.f3044a = j_f;
        this.f3045b = locale;
        if (i6 == 0) {
            throw new NullPointerException("resolverStyle");
        }
        this.f3046c = eVar;
    }

    public final String a(d.j$k j_k) {
        StringBuilder sb = new StringBuilder(32);
        if (j_k != null) {
            try {
                this.f3044a.a(new j$r(j_k, this), sb);
                return sb.toString();
            } catch (IOException e6) {
                throw new a.j$b(e6.getMessage(), e6);
            }
        }
        throw new NullPointerException("temporal");
    }

    public final j.d b() {
        return this.f3046c;
    }

    public final j$t c() {
        return j$t.f3091a;
    }

    public final Locale d() {
        return this.f3045b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j$f e() {
        return this.f3044a.b();
    }

    public final String toString() {
        String j_f = this.f3044a.toString();
        return j_f.startsWith("[") ? j_f : j_f.substring(1, j_f.length() - 1);
    }
}
