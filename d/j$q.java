package d;

import java.io.Serializable;
/* loaded from: classes2.dex */
public final class j$q implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final long f9105a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9106b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9107c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9108d;

    private j$q(long j6, long j7, long j8, long j9) {
        this.f9105a = j6;
        this.f9106b = j7;
        this.f9107c = j8;
        this.f9108d = j9;
    }

    private String c(long j6, j$l j_l) {
        if (j_l == null) {
            return "Invalid value (valid values " + this + "): " + j6;
        }
        return "Invalid value for " + j_l + " (valid values " + this + "): " + j6;
    }

    public static j$q i(long j6, long j7) {
        if (j6 <= j7) {
            return new j$q(j6, j6, j7, j7);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static j$q j(long j6, long j7) {
        if (j6 <= j7) {
            if (1 <= j7) {
                return new j$q(1L, 1L, j6, j7);
            }
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
    }

    public final int a(long j6, j$l j_l) {
        if (g() && h(j6)) {
            return (int) j6;
        }
        throw new a.j$b(c(j6, j_l));
    }

    public final void b(long j6, j$l j_l) {
        if (!h(j6)) {
            throw new a.j$b(c(j6, j_l));
        }
    }

    public final long d() {
        return this.f9108d;
    }

    public final long e() {
        return this.f9105a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j$q) {
            j$q j_q = (j$q) obj;
            return this.f9105a == j_q.f9105a && this.f9106b == j_q.f9106b && this.f9107c == j_q.f9107c && this.f9108d == j_q.f9108d;
        }
        return false;
    }

    public final boolean f() {
        return this.f9105a == this.f9106b && this.f9107c == this.f9108d;
    }

    public final boolean g() {
        return this.f9105a >= -2147483648L && this.f9108d <= 2147483647L;
    }

    public final boolean h(long j6) {
        return j6 >= this.f9105a && j6 <= this.f9108d;
    }

    public final int hashCode() {
        long j6 = this.f9105a;
        long j7 = this.f9106b;
        long j8 = j6 + (j7 << 16) + (j7 >> 48);
        long j9 = this.f9107c;
        long j10 = j8 + (j9 << 32) + (j9 >> 32);
        long j11 = this.f9108d;
        long j12 = j10 + (j11 << 48) + (j11 >> 16);
        return (int) (j12 ^ (j12 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9105a);
        if (this.f9105a != this.f9106b) {
            sb.append('/');
            sb.append(this.f9106b);
        }
        sb.append(" - ");
        sb.append(this.f9107c);
        if (this.f9107c != this.f9108d) {
            sb.append('/');
            sb.append(this.f9108d);
        }
        return sb.toString();
    }
}
