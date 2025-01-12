package c;

import k5.d;
import okhttp3.HttpUrl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$k implements j$g {

    /* renamed from: c  reason: collision with root package name */
    static final String[] f3063c = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};

    /* renamed from: d  reason: collision with root package name */
    static final j$k f3064d = new j$k("+HH:MM:ss", "Z");

    /* renamed from: a  reason: collision with root package name */
    private final String f3065a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3066b;

    static {
        new j$k("+HH:MM:ss", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$k(String str, String str2) {
        int i6 = 0;
        while (true) {
            String[] strArr = f3063c;
            if (i6 >= 9) {
                throw new IllegalArgumentException("Invalid zone offset pattern: ".concat(str));
            }
            if (strArr[i6].equals(str)) {
                this.f3066b = i6;
                this.f3065a = str2;
                return;
            }
            i6++;
        }
    }

    @Override // c.j$g
    public final boolean a(j$r j_r, StringBuilder sb) {
        Long e6 = j_r.e(d.j$a.OFFSET_SECONDS);
        if (e6 == null) {
            return false;
        }
        long longValue = e6.longValue();
        int i6 = (int) longValue;
        if (longValue == i6) {
            if (i6 != 0) {
                int abs = Math.abs((i6 / 3600) % 100);
                int abs2 = Math.abs((i6 / 60) % 60);
                int abs3 = Math.abs(i6 % 60);
                int length = sb.length();
                sb.append(i6 < 0 ? "-" : d.ANY_NON_NULL_MARKER);
                sb.append((char) ((abs / 10) + 48));
                sb.append((char) ((abs % 10) + 48));
                int i7 = this.f3066b;
                if (i7 >= 3 || (i7 >= 1 && abs2 > 0)) {
                    int i8 = i7 % 2;
                    sb.append(i8 == 0 ? ":" : HttpUrl.FRAGMENT_ENCODE_SET);
                    sb.append((char) ((abs2 / 10) + 48));
                    sb.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    if (i7 >= 7 || (i7 >= 5 && abs3 > 0)) {
                        sb.append(i8 != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : ":");
                        sb.append((char) ((abs3 / 10) + 48));
                        sb.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    sb.setLength(length);
                }
                return true;
            }
            sb.append(this.f3065a);
            return true;
        }
        throw new ArithmeticException();
    }

    public final String toString() {
        String replace = this.f3065a.replace("'", "''");
        return "Offset(" + f3063c[this.f3066b] + ",'" + replace + "')";
    }
}
