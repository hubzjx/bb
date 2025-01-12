package i1;

import c1.a0;
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f10997a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10998b;

    /* renamed from: c  reason: collision with root package name */
    public final a0.a f10999c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11000d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f11001e;

    public p(boolean z5, String str, int i6, byte[] bArr, int i7, int i8, byte[] bArr2) {
        com.google.android.exoplayer2.util.a.a((bArr2 == null) ^ (i6 == 0));
        this.f10997a = z5;
        this.f10998b = str;
        this.f11000d = i6;
        this.f11001e = bArr2;
        this.f10999c = new a0.a(a(str), bArr, i7, i8);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int a(String str) {
        if (str == null) {
            return 1;
        }
        char c6 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    c6 = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    c6 = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    c6 = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    c6 = 3;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
            case 1:
                return 2;
            case 2:
            case 3:
                break;
            default:
                StringBuilder sb = new StringBuilder(str.length() + 68);
                sb.append("Unsupported protection scheme type '");
                sb.append(str);
                sb.append("'. Assuming AES-CTR crypto mode.");
                com.google.android.exoplayer2.util.n.h("TrackEncryptionBox", sb.toString());
                break;
        }
        return 1;
    }
}
