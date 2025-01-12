package s2;

import com.google.android.exoplayer2.util.y;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f13177a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13178b;

    /* renamed from: c  reason: collision with root package name */
    public final String f13179c;

    private c(int i6, int i7, String str) {
        this.f13177a = i6;
        this.f13178b = i7;
        this.f13179c = str;
    }

    public static c a(y yVar) {
        String str;
        yVar.N(2);
        int A = yVar.A();
        int i6 = A >> 1;
        int A2 = ((yVar.A() >> 3) & 31) | ((A & 1) << 5);
        if (i6 == 4 || i6 == 5 || i6 == 7) {
            str = "dvhe";
        } else if (i6 == 8) {
            str = "hev1";
        } else if (i6 != 9) {
            return null;
        } else {
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder(str.length() + 26);
        sb.append(str);
        sb.append(".0");
        sb.append(i6);
        sb.append(".0");
        sb.append(A2);
        return new c(i6, A2, sb.toString());
    }
}
