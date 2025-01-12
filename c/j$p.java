package c;

import b.j;
import io.jsonwebtoken.JwtParser;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes2.dex */
public final class j$p {

    /* renamed from: f  reason: collision with root package name */
    private static final j$a f3076f = new d.j$n() { // from class: c.j$a
        @Override // d.j$n
        public final Object a(d.j$k j_k) {
            int i6 = j$p.f3077g;
            a.j$h j_h = (a.j$h) j_k.c(d.j$j.j());
            if (j_h == null || (j_h instanceof a.j$i)) {
                return null;
            }
            return j_h;
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ int f3077g = 0;

    /* renamed from: a  reason: collision with root package name */
    private j$p f3078a;

    /* renamed from: b  reason: collision with root package name */
    private final j$p f3079b;

    /* renamed from: c  reason: collision with root package name */
    private final List f3080c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3081d;

    /* renamed from: e  reason: collision with root package name */
    private int f3082e;

    /* JADX WARN: Type inference failed for: r0v0, types: [c.j$a] */
    static {
        HashMap hashMap = new HashMap();
        hashMap.put('G', d.j$a.ERA);
        hashMap.put('y', d.j$a.YEAR_OF_ERA);
        hashMap.put('u', d.j$a.YEAR);
        d.j$l j_l = d.j$i.f9094a;
        hashMap.put('Q', j_l);
        hashMap.put('q', j_l);
        d.j$a j_a = d.j$a.MONTH_OF_YEAR;
        hashMap.put('M', j_a);
        hashMap.put('L', j_a);
        hashMap.put('D', d.j$a.DAY_OF_YEAR);
        hashMap.put('d', d.j$a.DAY_OF_MONTH);
        hashMap.put('F', d.j$a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        d.j$a j_a2 = d.j$a.DAY_OF_WEEK;
        hashMap.put('E', j_a2);
        hashMap.put('c', j_a2);
        hashMap.put('e', j_a2);
        hashMap.put('a', d.j$a.AMPM_OF_DAY);
        hashMap.put('H', d.j$a.HOUR_OF_DAY);
        hashMap.put('k', d.j$a.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', d.j$a.HOUR_OF_AMPM);
        hashMap.put('h', d.j$a.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', d.j$a.MINUTE_OF_HOUR);
        hashMap.put('s', d.j$a.SECOND_OF_MINUTE);
        d.j$a j_a3 = d.j$a.NANO_OF_SECOND;
        hashMap.put('S', j_a3);
        hashMap.put('A', d.j$a.MILLI_OF_DAY);
        hashMap.put('n', j_a3);
        hashMap.put('N', d.j$a.NANO_OF_DAY);
    }

    public j$p() {
        this.f3078a = this;
        this.f3080c = new ArrayList();
        this.f3082e = -1;
        this.f3079b = null;
        this.f3081d = false;
    }

    private j$p(j$p j_p) {
        this.f3078a = this;
        this.f3080c = new ArrayList();
        this.f3082e = -1;
        this.f3079b = j_p;
        this.f3081d = true;
    }

    private int d(j$g j_g) {
        if (j_g != null) {
            j$p j_p = this.f3078a;
            j_p.getClass();
            ((ArrayList) j_p.f3080c).add(j_g);
            j$p j_p2 = this.f3078a;
            j_p2.f3082e = -1;
            return ((ArrayList) j_p2.f3080c).size() - 1;
        }
        throw new NullPointerException("pp");
    }

    private void j(j$j j_j) {
        j$j c6;
        int i6;
        j$p j_p = this.f3078a;
        int i7 = j_p.f3082e;
        if (i7 < 0) {
            j_p.f3082e = d(j_j);
            return;
        }
        j$j j_j2 = (j$j) ((ArrayList) j_p.f3080c).get(i7);
        int i8 = j_j.f3059b;
        int i9 = j_j.f3060c;
        if (i8 == i9) {
            i6 = j_j.f3061d;
            if (i6 == 4) {
                c6 = j_j2.d(i9);
                d(j_j.c());
                this.f3078a.f3082e = i7;
                ((ArrayList) this.f3078a.f3080c).set(i7, c6);
            }
        }
        c6 = j_j2.c();
        this.f3078a.f3082e = d(j_j);
        ((ArrayList) this.f3078a.f3080c).set(i7, c6);
    }

    public final void a(j$b j_b) {
        d(j_b.e());
    }

    public final void b(final d.j$a j_a) {
        d(new j$g(j_a) { // from class: c.j$h

            /* renamed from: a  reason: collision with root package name */
            private final d.j$l f3053a;

            /* renamed from: b  reason: collision with root package name */
            private final int f3054b;

            /* renamed from: c  reason: collision with root package name */
            private final int f3055c;

            /* renamed from: d  reason: collision with root package name */
            private final boolean f3056d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                if (j_a == null) {
                    throw new NullPointerException("field");
                }
                if (!j_a.b().f()) {
                    throw new IllegalArgumentException("Field must have a fixed set of values: " + j_a);
                }
                this.f3053a = j_a;
                this.f3054b = 0;
                this.f3055c = 9;
                this.f3056d = true;
            }

            @Override // c.j$g
            public final boolean a(j$r j_r, StringBuilder sb) {
                d.j$l j_l = this.f3053a;
                Long e6 = j_r.e(j_l);
                if (e6 == null) {
                    return false;
                }
                j$t b6 = j_r.b();
                long longValue = e6.longValue();
                d.j$q b7 = j_l.b();
                b7.b(longValue, j_l);
                BigDecimal valueOf = BigDecimal.valueOf(b7.e());
                BigDecimal divide = BigDecimal.valueOf(longValue).subtract(valueOf).divide(BigDecimal.valueOf(b7.d()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
                BigDecimal stripTrailingZeros = divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
                int scale = stripTrailingZeros.scale();
                boolean z5 = this.f3056d;
                int i6 = this.f3054b;
                if (scale != 0) {
                    String substring = stripTrailingZeros.setScale(Math.min(Math.max(stripTrailingZeros.scale(), i6), this.f3055c), RoundingMode.FLOOR).toPlainString().substring(2);
                    b6.getClass();
                    if (z5) {
                        sb.append(JwtParser.SEPARATOR_CHAR);
                    }
                    sb.append(substring);
                    return true;
                } else if (i6 > 0) {
                    if (z5) {
                        b6.getClass();
                        sb.append(JwtParser.SEPARATOR_CHAR);
                    }
                    for (int i7 = 0; i7 < i6; i7++) {
                        b6.getClass();
                        sb.append('0');
                    }
                    return true;
                } else {
                    return true;
                }
            }

            public final String toString() {
                String str = this.f3056d ? ",DecimalPoint" : HttpUrl.FRAGMENT_ENCODE_SET;
                return "Fraction(" + this.f3053a + "," + this.f3054b + "," + this.f3055c + str + ")";
            }
        });
    }

    public final void c() {
        d(new j$g() { // from class: c.j$i
            @Override // c.j$g
            public final boolean a(j$r j_r, StringBuilder sb) {
                Long e6 = j_r.e(d.j$a.INSTANT_SECONDS);
                d.j$k d6 = j_r.d();
                d.j$a j_a = d.j$a.NANO_OF_SECOND;
                Long valueOf = d6.d(j_a) ? Long.valueOf(j_r.d().a(j_a)) : null;
                int i6 = 0;
                if (e6 == null) {
                    return false;
                }
                long longValue = e6.longValue();
                int g6 = j_a.g(valueOf != null ? valueOf.longValue() : 0L);
                if (longValue >= -62167219200L) {
                    long j6 = (longValue - 315569520000L) + 62167219200L;
                    long e7 = a.j$a.e(j6, 315569520000L) + 1;
                    a.j$e i7 = a.j$e.i(a.j$a.c(j6, 315569520000L) - 62167219200L, 0, a.j$i.f33e);
                    if (e7 > 0) {
                        sb.append('+');
                        sb.append(e7);
                    }
                    sb.append(i7);
                    if (i7.g() == 0) {
                        sb.append(":00");
                    }
                } else {
                    long j7 = longValue + 62167219200L;
                    long j8 = j7 / 315569520000L;
                    long j9 = j7 % 315569520000L;
                    a.j$e i8 = a.j$e.i(j9 - 62167219200L, 0, a.j$i.f33e);
                    int length = sb.length();
                    sb.append(i8);
                    if (i8.g() == 0) {
                        sb.append(":00");
                    }
                    if (j8 < 0) {
                        if (i8.h() == -10000) {
                            sb.replace(length, length + 2, Long.toString(j8 - 1));
                        } else if (j9 == 0) {
                            sb.insert(length, j8);
                        } else {
                            sb.insert(length + 1, Math.abs(j8));
                        }
                    }
                }
                if (g6 > 0) {
                    sb.append(JwtParser.SEPARATOR_CHAR);
                    int i9 = 100000000;
                    while (true) {
                        if (g6 <= 0 && i6 % 3 == 0 && i6 >= -2) {
                            break;
                        }
                        int i10 = g6 / i9;
                        sb.append((char) (i10 + 48));
                        g6 -= i10 * i9;
                        i9 /= 10;
                        i6++;
                    }
                }
                sb.append('Z');
                return true;
            }

            public final String toString() {
                return "Instant()";
            }
        });
    }

    public final void e(char c6) {
        d(new j$e(c6));
    }

    public final void f(final String str) {
        if (str.length() > 0) {
            d(str.length() == 1 ? new j$e(str.charAt(0)) : new j$g(str) { // from class: c.j$m

                /* renamed from: a  reason: collision with root package name */
                private final String f3071a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3071a = str;
                }

                @Override // c.j$g
                public final boolean a(j$r j_r, StringBuilder sb) {
                    sb.append(this.f3071a);
                    return true;
                }

                public final String toString() {
                    String replace = this.f3071a.replace("'", "''");
                    return "'" + replace + "'";
                }
            });
        }
    }

    public final void g(String str, String str2) {
        d(new j$k(str, str2));
    }

    public final void h() {
        d(j$k.f3064d);
    }

    public final void i(final d.j$a j_a, Map map) {
        if (j_a == null) {
            throw new NullPointerException("field");
        }
        final j$c j_c = new j$c(new j$s(Collections.singletonMap(j$v.FULL, new LinkedHashMap(map))));
        d(new j$g(j_a, j_c) { // from class: c.j$n

            /* renamed from: a  reason: collision with root package name */
            private final d.j$l f3072a;

            /* renamed from: b  reason: collision with root package name */
            private final j$c f3073b;

            /* renamed from: c  reason: collision with root package name */
            private volatile j$j f3074c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3072a = j_a;
                this.f3073b = j_c;
            }

            @Override // c.j$g
            public final boolean a(j$r j_r, StringBuilder sb) {
                String a6;
                j.e eVar;
                Long e6 = j_r.e(this.f3072a);
                if (e6 == null) {
                    return false;
                }
                j.d dVar = (j.d) j_r.d().c(d.j$j.d());
                if (dVar == null || dVar == (eVar = j.e.f2842a)) {
                    j$c j_c2 = this.f3073b;
                    long longValue = e6.longValue();
                    j_r.c();
                    a6 = j_c2.f3049a.a(longValue);
                } else {
                    j$c j_c3 = this.f3073b;
                    d.j$l j_l = this.f3072a;
                    long longValue2 = e6.longValue();
                    j_r.c();
                    j_c3.getClass();
                    a6 = (dVar == eVar || !(j_l instanceof d.j$a)) ? j_c3.f3049a.a(longValue2) : null;
                }
                if (a6 != null) {
                    sb.append(a6);
                    return true;
                }
                if (this.f3074c == null) {
                    this.f3074c = new j$j(this.f3072a, 1, 19, 1);
                }
                return this.f3074c.a(j_r, sb);
            }

            public final String toString() {
                return "Text(" + this.f3072a + ")";
            }
        });
    }

    public final void k(d.j$l j_l, int i6) {
        if (j_l == null) {
            throw new NullPointerException("field");
        }
        if (i6 >= 1 && i6 <= 19) {
            j(new j$j(j_l, i6, i6, 4));
            return;
        }
        throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i6);
    }

    public final j$p l(d.j$l j_l, int i6, int i7, int i8) {
        if (i6 == i7 && i8 == 4) {
            k(j_l, i7);
            return this;
        } else if (j_l != null) {
            if (i8 != 0) {
                if (i6 < 1 || i6 > 19) {
                    throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i6);
                } else if (i7 < 1 || i7 > 19) {
                    throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i7);
                } else if (i7 >= i6) {
                    j(new j$j(j_l, i6, i7, i8));
                    return this;
                } else {
                    throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i7 + " < " + i6);
                }
            }
            throw new NullPointerException("signStyle");
        } else {
            throw new NullPointerException("field");
        }
    }

    public final void m() {
        final j$a j_a = f3076f;
        d(new j$g(j_a) { // from class: c.j$o

            /* renamed from: a  reason: collision with root package name */
            private final d.j$n f3075a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3075a = j_a;
            }

            @Override // c.j$g
            public final boolean a(j$r j_r, StringBuilder sb) {
                a.j$h j_h = (a.j$h) j_r.f(this.f3075a);
                if (j_h == null) {
                    return false;
                }
                sb.append(j_h.f());
                return true;
            }

            public final String toString() {
                return "ZoneRegionId()";
            }
        });
    }

    public final void n() {
        j$p j_p = this.f3078a;
        if (j_p.f3079b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (((ArrayList) j_p.f3080c).size() <= 0) {
            this.f3078a = this.f3078a.f3079b;
            return;
        }
        j$p j_p2 = this.f3078a;
        j$f j_f = new j$f(j_p2.f3080c, j_p2.f3081d);
        this.f3078a = this.f3078a.f3079b;
        d(j_f);
    }

    public final void o() {
        j$p j_p = this.f3078a;
        j_p.f3082e = -1;
        this.f3078a = new j$p(j_p);
    }

    public final void p() {
        d(j$l.INSENSITIVE);
    }

    public final void q() {
        d(j$l.SENSITIVE);
    }

    public final void r() {
        d(j$l.LENIENT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j$b s(int i6, j.e eVar) {
        Locale locale = Locale.getDefault();
        if (locale != null) {
            while (this.f3078a.f3079b != null) {
                n();
            }
            j$f j_f = new j$f(this.f3080c, false);
            j$t j_t = j$t.f3091a;
            return new j$b(j_f, locale, i6, eVar);
        }
        throw new NullPointerException("locale");
    }
}
