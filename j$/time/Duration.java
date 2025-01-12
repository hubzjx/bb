package j$.time;

import a.j$a;
import io.jsonwebtoken.JwtParser;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public final class Duration implements Comparable, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final Duration f11044c = new Duration(0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final long f11045a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11046b;

    static {
        BigInteger.valueOf(1000000000L);
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    private Duration(long j6, int i6) {
        this.f11045a = j6;
        this.f11046b = i6;
    }

    private static Duration a(long j6, int i6) {
        return (((long) i6) | j6) == 0 ? f11044c : new Duration(j6, i6);
    }

    public static Duration b(long j6) {
        long j7 = j6 / 1000000000;
        int i6 = (int) (j6 % 1000000000);
        if (i6 < 0) {
            i6 = (int) (i6 + 1000000000);
            j7--;
        }
        return a(j7, i6);
    }

    public static Duration c() {
        return a(j$a.a(Long.MAX_VALUE, j$a.e(999999999L, 1000000000L)), (int) j$a.c(999999999L, 1000000000L));
    }

    public static Duration d(long j6) {
        return a(j6, 0);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        Duration duration = (Duration) obj;
        int compare = Long.compare(this.f11045a, duration.f11045a);
        return compare != 0 ? compare : this.f11046b - duration.f11046b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            return this.f11045a == duration.f11045a && this.f11046b == duration.f11046b;
        }
        return false;
    }

    public final int hashCode() {
        long j6 = this.f11045a;
        return (this.f11046b * 51) + ((int) (j6 ^ (j6 >>> 32)));
    }

    public long toMillis() {
        return j$a.a(j$a.d(this.f11045a), this.f11046b / 1000000);
    }

    public final String toString() {
        if (this == f11044c) {
            return "PT0S";
        }
        long j6 = this.f11045a;
        long j7 = j6 / 3600;
        int i6 = (int) ((j6 % 3600) / 60);
        int i7 = (int) (j6 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j7 != 0) {
            sb.append(j7);
            sb.append('H');
        }
        if (i6 != 0) {
            sb.append(i6);
            sb.append('M');
        }
        if (i7 == 0 && this.f11046b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i7 >= 0 || this.f11046b <= 0) {
            sb.append(i7);
        } else if (i7 == -1) {
            sb.append("-0");
        } else {
            sb.append(i7 + 1);
        }
        if (this.f11046b > 0) {
            int length = sb.length();
            if (i7 < 0) {
                sb.append(2000000000 - this.f11046b);
            } else {
                sb.append(this.f11046b + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, JwtParser.SEPARATOR_CHAR);
        }
        sb.append('S');
        return sb.toString();
    }
}
