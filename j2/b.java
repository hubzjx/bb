package j2;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f11222a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11223b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11224c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11225d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11226e;

    private b(int i6, int i7, int i8, int i9, int i10) {
        this.f11222a = i6;
        this.f11223b = i7;
        this.f11224c = i8;
        this.f11225d = i9;
        this.f11226e = i10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static b a(String str) {
        char c6;
        com.google.android.exoplayer2.util.a.a(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), ",");
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        for (int i10 = 0; i10 < split.length; i10++) {
            String S0 = s0.S0(split[i10].trim());
            S0.hashCode();
            switch (S0.hashCode()) {
                case 100571:
                    if (S0.equals("end")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3556653:
                    if (S0.equals("text")) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 109757538:
                    if (S0.equals("start")) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 109780401:
                    if (S0.equals("style")) {
                        c6 = 3;
                        break;
                    }
                    c6 = 65535;
                    break;
                default:
                    c6 = 65535;
                    break;
            }
            switch (c6) {
                case 0:
                    i7 = i10;
                    break;
                case 1:
                    i9 = i10;
                    break;
                case 2:
                    i6 = i10;
                    break;
                case 3:
                    i8 = i10;
                    break;
            }
        }
        if (i6 == -1 || i7 == -1) {
            return null;
        }
        return new b(i6, i7, i8, i9, split.length);
    }
}
