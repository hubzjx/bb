package a;

import d.j$k;
import d.j$l;
import d.j$n;
import d.j$p;
import d.j$q;
import j$.util.concurrent.ConcurrentHashMap;
import k5.d;
import okhttp3.HttpUrl;
/* loaded from: classes2.dex */
public final class j$i extends j$h implements j$k, Comparable {

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentHashMap f31c = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentHashMap f32d = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final j$i f33e = h(0);

    /* renamed from: a  reason: collision with root package name */
    private final int f34a;

    /* renamed from: b  reason: collision with root package name */
    private final transient String f35b;

    static {
        h(-64800);
        h(64800);
    }

    private j$i(int i6) {
        String sb;
        this.f34a = i6;
        if (i6 == 0) {
            sb = "Z";
        } else {
            int abs = Math.abs(i6);
            StringBuilder sb2 = new StringBuilder();
            int i7 = abs / 3600;
            int i8 = (abs / 60) % 60;
            sb2.append(i6 < 0 ? "-" : d.ANY_NON_NULL_MARKER);
            sb2.append(i7 < 10 ? "0" : HttpUrl.FRAGMENT_ENCODE_SET);
            sb2.append(i7);
            sb2.append(i8 < 10 ? ":0" : ":");
            sb2.append(i8);
            int i9 = abs % 60;
            if (i9 != 0) {
                sb2.append(i9 >= 10 ? ":" : ":0");
                sb2.append(i9);
            }
            sb = sb2.toString();
        }
        this.f35b = sb;
    }

    public static j$i h(int i6) {
        if (i6 < -64800 || i6 > 64800) {
            throw new j$b("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i6 % 900 == 0) {
            Integer valueOf = Integer.valueOf(i6);
            ConcurrentHashMap concurrentHashMap = f31c;
            j$i j_i = (j$i) concurrentHashMap.get(valueOf);
            if (j_i == null) {
                concurrentHashMap.putIfAbsent(valueOf, new j$i(i6));
                j$i j_i2 = (j$i) concurrentHashMap.get(valueOf);
                f32d.putIfAbsent(j_i2.f35b, j_i2);
                return j_i2;
            }
            return j_i;
        }
        return new j$i(i6);
    }

    @Override // d.j$k
    public final long a(j$l j_l) {
        if (j_l == d.j$a.OFFSET_SECONDS) {
            return this.f34a;
        }
        if (j_l instanceof d.j$a) {
            throw new j$p("Unsupported field: " + j_l);
        }
        return j_l.a(this);
    }

    @Override // d.j$k
    public final j$q b(j$l j_l) {
        return d.j$j.c(this, j_l);
    }

    @Override // d.j$k
    public final Object c(j$n j_n) {
        return (j_n == d.j$j.g() || j_n == d.j$j.i()) ? this : d.j$j.b(this, j_n);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return ((j$i) obj).f34a - this.f34a;
    }

    @Override // d.j$k
    public final boolean d(j$l j_l) {
        return j_l instanceof d.j$a ? j_l == d.j$a.OFFSET_SECONDS : j_l != null && j_l.c(this);
    }

    @Override // d.j$k
    public final int e(d.j$a j_a) {
        if (j_a == d.j$a.OFFSET_SECONDS) {
            return this.f34a;
        }
        if (j_a instanceof d.j$a) {
            throw new j$p("Unsupported field: " + j_a);
        }
        return d.j$j.c(this, j_a).a(a(j_a), j_a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j$i) && this.f34a == ((j$i) obj).f34a;
    }

    @Override // a.j$h
    public final String f() {
        return this.f35b;
    }

    public final int g() {
        return this.f34a;
    }

    public final int hashCode() {
        return this.f34a;
    }

    public final String toString() {
        return this.f35b;
    }
}
