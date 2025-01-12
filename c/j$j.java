package c;

import okhttp3.internal.connection.RealConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$j implements j$g {

    /* renamed from: f  reason: collision with root package name */
    static final long[] f3057f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS};

    /* renamed from: a  reason: collision with root package name */
    final d.j$l f3058a;

    /* renamed from: b  reason: collision with root package name */
    final int f3059b;

    /* renamed from: c  reason: collision with root package name */
    final int f3060c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3061d;

    /* renamed from: e  reason: collision with root package name */
    final int f3062e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$j(d.j$l j_l, int i6, int i7, int i8) {
        this.f3058a = j_l;
        this.f3059b = i6;
        this.f3060c = i7;
        this.f3061d = i8;
        this.f3062e = 0;
    }

    protected j$j(d.j$l j_l, int i6, int i7, int i8, int i9) {
        this.f3058a = j_l;
        this.f3059b = i6;
        this.f3060c = i7;
        this.f3061d = i8;
        this.f3062e = i9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
        if (r8 != 4) goto L19;
     */
    @Override // c.j$g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(j$r j_r, StringBuilder sb) {
        d.j$l j_l = this.f3058a;
        Long e6 = j_r.e(j_l);
        if (e6 == null) {
            return false;
        }
        long longValue = e6.longValue();
        j$t b6 = j_r.b();
        String l6 = longValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(longValue));
        int length = l6.length();
        int i6 = this.f3060c;
        if (length > i6) {
            throw new a.j$b("Field " + j_l + " cannot be printed as the value " + longValue + " exceeds the maximum print width of " + i6);
        }
        b6.getClass();
        int i7 = this.f3059b;
        int i8 = this.f3061d;
        if (longValue >= 0) {
            int a6 = j$u.a(i8);
            if (a6 == 1 || (a6 == 4 && i7 < 19 && longValue >= f3057f[i7])) {
                sb.append('+');
            }
        } else {
            int a7 = j$u.a(i8);
            if (a7 != 0 && a7 != 1) {
                if (a7 == 3) {
                    throw new a.j$b("Field " + j_l + " cannot be printed as the value " + longValue + " cannot be negative according to the SignStyle");
                }
            }
            sb.append('-');
        }
        for (int i9 = 0; i9 < i7 - l6.length(); i9++) {
            sb.append('0');
        }
        sb.append(l6);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j$j c() {
        return this.f3062e == -1 ? this : new j$j(this.f3058a, this.f3059b, this.f3060c, this.f3061d, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j$j d(int i6) {
        return new j$j(this.f3058a, this.f3059b, this.f3060c, this.f3061d, this.f3062e + i6);
    }

    public final String toString() {
        int i6 = this.f3061d;
        d.j$l j_l = this.f3058a;
        int i7 = this.f3060c;
        int i8 = this.f3059b;
        if (i8 == 1 && i7 == 19 && i6 == 1) {
            return "Value(" + j_l + ")";
        } else if (i8 == i7 && i6 == 4) {
            return "Value(" + j_l + "," + i8 + ")";
        } else {
            return "Value(" + j_l + "," + i8 + "," + i7 + "," + j$u.b(i6) + ")";
        }
    }
}
