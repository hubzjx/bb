package a;

import d.j$k;
import d.j$l;
import d.j$n;
import d.j$p;
import d.j$q;
import io.jsonwebtoken.JwtParser;
import java.io.Serializable;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2Connection;
/* loaded from: classes2.dex */
public final class j$f implements j$k, Comparable, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final j$f f21e;

    /* renamed from: f  reason: collision with root package name */
    public static final j$f f22f;

    /* renamed from: g  reason: collision with root package name */
    private static final j$f[] f23g = new j$f[24];

    /* renamed from: a  reason: collision with root package name */
    private final byte f24a;

    /* renamed from: b  reason: collision with root package name */
    private final byte f25b;

    /* renamed from: c  reason: collision with root package name */
    private final byte f26c;

    /* renamed from: d  reason: collision with root package name */
    private final int f27d;

    static {
        int i6 = 0;
        while (true) {
            j$f[] j_fArr = f23g;
            if (i6 >= j_fArr.length) {
                j$f j_f = j_fArr[0];
                j$f j_f2 = j_fArr[12];
                f21e = j_f;
                f22f = new j$f(23, 59, 59, 999999999);
                return;
            }
            j_fArr[i6] = new j$f(i6, 0, 0, 0);
            i6++;
        }
    }

    private j$f(int i6, int i7, int i8, int i9) {
        this.f24a = (byte) i6;
        this.f25b = (byte) i7;
        this.f26c = (byte) i8;
        this.f27d = i9;
    }

    private int g(j$l j_l) {
        switch (((d.j$a) j_l).ordinal()) {
            case 0:
                return this.f27d;
            case 1:
                throw new j$p("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 2:
                return this.f27d / 1000;
            case 3:
                throw new j$p("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 4:
                return this.f27d / 1000000;
            case 5:
                return (int) (j() / 1000000);
            case 6:
                return this.f26c;
            case 7:
                return k();
            case 8:
                return this.f25b;
            case 9:
                return (this.f24a * 60) + this.f25b;
            case 10:
                return this.f24a % 12;
            case 11:
                int i6 = this.f24a % 12;
                if (i6 % 12 == 0) {
                    return 12;
                }
                return i6;
            case 12:
                return this.f24a;
            case 13:
                byte b6 = this.f24a;
                if (b6 == 0) {
                    return 24;
                }
                return b6;
            case 14:
                return this.f24a / 12;
            default:
                throw new j$p("Unsupported field: " + j_l);
        }
    }

    public static j$f i(long j6) {
        d.j$a.NANO_OF_DAY.h(j6);
        int i6 = (int) (j6 / 3600000000000L);
        long j7 = j6 - (i6 * 3600000000000L);
        int i7 = (int) (j7 / 60000000000L);
        long j8 = j7 - (i7 * 60000000000L);
        int i8 = (int) (j8 / 1000000000);
        int i9 = (int) (j8 - (i8 * 1000000000));
        return ((i7 | i8) | i9) == 0 ? f23g[i6] : new j$f(i6, i7, i8, i9);
    }

    @Override // d.j$k
    public final long a(j$l j_l) {
        return j_l instanceof d.j$a ? j_l == d.j$a.NANO_OF_DAY ? j() : j_l == d.j$a.MICRO_OF_DAY ? j() / 1000 : g(j_l) : j_l.a(this);
    }

    @Override // d.j$k
    public final j$q b(j$l j_l) {
        return d.j$j.c(this, j_l);
    }

    @Override // d.j$k
    public final Object c(j$n j_n) {
        if (j_n == d.j$j.d() || j_n == d.j$j.j() || j_n == d.j$j.i() || j_n == d.j$j.g()) {
            return null;
        }
        if (j_n == d.j$j.f()) {
            return this;
        }
        if (j_n == d.j$j.e()) {
            return null;
        }
        return j_n == d.j$j.h() ? d.j$b.NANOS : j_n.a(this);
    }

    @Override // d.j$k
    public final boolean d(j$l j_l) {
        return j_l instanceof d.j$a ? j_l.d() : j_l != null && j_l.c(this);
    }

    @Override // d.j$k
    public final int e(d.j$a j_a) {
        return j_a instanceof d.j$a ? g(j_a) : d.j$j.a(this, j_a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j$f) {
            j$f j_f = (j$f) obj;
            return this.f24a == j_f.f24a && this.f25b == j_f.f25b && this.f26c == j_f.f26c && this.f27d == j_f.f27d;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: f */
    public final int compareTo(j$f j_f) {
        int compare = Integer.compare(this.f24a, j_f.f24a);
        if (compare == 0) {
            int compare2 = Integer.compare(this.f25b, j_f.f25b);
            if (compare2 == 0) {
                int compare3 = Integer.compare(this.f26c, j_f.f26c);
                return compare3 == 0 ? Integer.compare(this.f27d, j_f.f27d) : compare3;
            }
            return compare2;
        }
        return compare;
    }

    public final int h() {
        return this.f26c;
    }

    public final int hashCode() {
        long j6 = j();
        return (int) (j6 ^ (j6 >>> 32));
    }

    public final long j() {
        return (this.f26c * 1000000000) + (this.f25b * 60000000000L) + (this.f24a * 3600000000000L) + this.f27d;
    }

    public final int k() {
        return (this.f25b * 60) + (this.f24a * 3600) + this.f26c;
    }

    public final String toString() {
        int i6;
        StringBuilder sb = new StringBuilder(18);
        byte b6 = this.f24a;
        byte b7 = this.f25b;
        byte b8 = this.f26c;
        int i7 = this.f27d;
        sb.append(b6 < 10 ? "0" : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append((int) b6);
        sb.append(b7 < 10 ? ":0" : ":");
        sb.append((int) b7);
        if (b8 > 0 || i7 > 0) {
            sb.append(b8 >= 10 ? ":" : ":0");
            sb.append((int) b8);
            if (i7 > 0) {
                sb.append(JwtParser.SEPARATOR_CHAR);
                int i8 = 1000000;
                if (i7 % 1000000 == 0) {
                    i6 = (i7 / 1000000) + 1000;
                } else {
                    if (i7 % 1000 == 0) {
                        i7 /= 1000;
                    } else {
                        i8 = Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
                    }
                    i6 = i7 + i8;
                }
                sb.append(Integer.toString(i6).substring(1));
            }
        }
        return sb.toString();
    }
}
