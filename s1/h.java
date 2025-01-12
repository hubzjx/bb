package s1;

import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.x;
import com.google.android.exoplayer2.util.y;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class h extends n1.h {

    /* renamed from: b  reason: collision with root package name */
    public static final a f13147b = new a() { // from class: s1.g
        @Override // s1.h.a
        public final boolean a(int i6, int i7, int i8, int i9, int i10) {
            boolean z5;
            z5 = h.z(i6, i7, i8, i9, i10);
            return z5;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final a f13148a;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(int i6, int i7, int i8, int i9, int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f13149a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f13150b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13151c;

        public b(int i6, boolean z5, int i7) {
            this.f13149a = i6;
            this.f13150b = z5;
            this.f13151c = i7;
        }
    }

    public h() {
        this(null);
    }

    private static int A(y yVar, int i6) {
        byte[] c6 = yVar.c();
        int d6 = yVar.d();
        int i7 = d6;
        while (true) {
            int i8 = i7 + 1;
            if (i8 >= d6 + i6) {
                return i6;
            }
            if ((c6[i7] & 255) == 255 && c6[i8] == 0) {
                System.arraycopy(c6, i7 + 2, c6, i8, (i6 - (i7 - d6)) - 2);
                i6--;
            }
            i7 = i8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        if ((r10 & 1) != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0086, code lost:
        if ((r10 & 128) != 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean B(y yVar, int i6, int i7, boolean z5) {
        int D;
        long D2;
        int i8;
        int i9;
        int d6 = yVar.d();
        while (true) {
            try {
                boolean z6 = true;
                if (yVar.a() < i7) {
                    return true;
                }
                if (i6 >= 3) {
                    D = yVar.k();
                    D2 = yVar.C();
                    i8 = yVar.G();
                } else {
                    D = yVar.D();
                    D2 = yVar.D();
                    i8 = 0;
                }
                if (D == 0 && D2 == 0 && i8 == 0) {
                    return true;
                }
                if (i6 == 4 && !z5) {
                    if ((8421504 & D2) != 0) {
                        return false;
                    }
                    D2 = (((D2 >> 24) & 255) << 21) | (D2 & 255) | (((D2 >> 8) & 255) << 7) | (((D2 >> 16) & 255) << 14);
                }
                if (i6 == 4) {
                    i9 = (i8 & 64) != 0 ? 1 : 0;
                } else {
                    if (i6 == 3) {
                        i9 = (i8 & 32) != 0 ? 1 : 0;
                    } else {
                        i9 = 0;
                    }
                    z6 = false;
                    if (z6) {
                        i9 += 4;
                    }
                    if (D2 < i9) {
                        return false;
                    }
                    if (yVar.a() < D2) {
                        return false;
                    }
                    yVar.N((int) D2);
                }
            } finally {
                yVar.M(d6);
            }
        }
    }

    private static byte[] d(byte[] bArr, int i6, int i7) {
        return i7 <= i6 ? s0.f4678f : Arrays.copyOfRange(bArr, i6, i7);
    }

    private static s1.a f(y yVar, int i6, int i7) {
        int y5;
        String str;
        int A = yVar.A();
        String v5 = v(A);
        int i8 = i6 - 1;
        byte[] bArr = new byte[i8];
        yVar.i(bArr, 0, i8);
        if (i7 == 2) {
            String valueOf = String.valueOf(s0.S0(new String(bArr, 0, 3, "ISO-8859-1")));
            str = valueOf.length() != 0 ? "image/".concat(valueOf) : new String("image/");
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            y5 = 2;
        } else {
            y5 = y(bArr, 0);
            String S0 = s0.S0(new String(bArr, 0, y5, "ISO-8859-1"));
            if (S0.indexOf(47) == -1) {
                if (S0.length() != 0) {
                    str = "image/".concat(S0);
                } else {
                    S0 = new String("image/");
                }
            }
            str = S0;
        }
        int i9 = y5 + 2;
        int x5 = x(bArr, i9, A);
        return new s1.a(str, new String(bArr, i9, x5 - i9, v5), bArr[y5 + 1] & 255, d(bArr, x5 + u(A), i8));
    }

    private static s1.b g(y yVar, int i6, String str) {
        byte[] bArr = new byte[i6];
        yVar.i(bArr, 0, i6);
        return new s1.b(str, bArr);
    }

    private static c h(y yVar, int i6, int i7, boolean z5, int i8, a aVar) {
        int d6 = yVar.d();
        int y5 = y(yVar.c(), d6);
        String str = new String(yVar.c(), d6, y5 - d6, "ISO-8859-1");
        yVar.M(y5 + 1);
        int k6 = yVar.k();
        int k7 = yVar.k();
        long C = yVar.C();
        long j6 = C == 4294967295L ? -1L : C;
        long C2 = yVar.C();
        long j7 = C2 == 4294967295L ? -1L : C2;
        ArrayList arrayList = new ArrayList();
        int i9 = d6 + i6;
        while (yVar.d() < i9) {
            i k8 = k(i7, yVar, z5, i8, aVar);
            if (k8 != null) {
                arrayList.add(k8);
            }
        }
        return new c(str, k6, k7, j6, j7, (i[]) arrayList.toArray(new i[0]));
    }

    private static d i(y yVar, int i6, int i7, boolean z5, int i8, a aVar) {
        int d6 = yVar.d();
        int y5 = y(yVar.c(), d6);
        String str = new String(yVar.c(), d6, y5 - d6, "ISO-8859-1");
        yVar.M(y5 + 1);
        int A = yVar.A();
        boolean z6 = (A & 2) != 0;
        boolean z7 = (A & 1) != 0;
        int A2 = yVar.A();
        String[] strArr = new String[A2];
        for (int i9 = 0; i9 < A2; i9++) {
            int d7 = yVar.d();
            int y6 = y(yVar.c(), d7);
            strArr[i9] = new String(yVar.c(), d7, y6 - d7, "ISO-8859-1");
            yVar.M(y6 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i10 = d6 + i6;
        while (yVar.d() < i10) {
            i k6 = k(i7, yVar, z5, i8, aVar);
            if (k6 != null) {
                arrayList.add(k6);
            }
        }
        return new d(str, z6, z7, strArr, (i[]) arrayList.toArray(new i[0]));
    }

    private static e j(y yVar, int i6) {
        if (i6 < 4) {
            return null;
        }
        int A = yVar.A();
        String v5 = v(A);
        byte[] bArr = new byte[3];
        yVar.i(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i7 = i6 - 4;
        byte[] bArr2 = new byte[i7];
        yVar.i(bArr2, 0, i7);
        int x5 = x(bArr2, 0, A);
        String str2 = new String(bArr2, 0, x5, v5);
        int u5 = x5 + u(A);
        return new e(str, str2, p(bArr2, u5, x(bArr2, u5, A), v5));
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x0190, code lost:
        if (r13 == 67) goto L98;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static i k(int i6, y yVar, boolean z5, int i7, a aVar) {
        int E;
        String str;
        int i8;
        int i9;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        i j6;
        int A = yVar.A();
        int A2 = yVar.A();
        int A3 = yVar.A();
        int A4 = i6 >= 3 ? yVar.A() : 0;
        if (i6 == 4) {
            E = yVar.E();
            if (!z5) {
                E = (((E >> 24) & 255) << 21) | (E & 255) | (((E >> 8) & 255) << 7) | (((E >> 16) & 255) << 14);
            }
        } else {
            E = i6 == 3 ? yVar.E() : yVar.D();
        }
        int i10 = E;
        int G = i6 >= 3 ? yVar.G() : 0;
        if (A == 0 && A2 == 0 && A3 == 0 && A4 == 0 && i10 == 0 && G == 0) {
            yVar.M(yVar.e());
            return null;
        }
        int d6 = yVar.d() + i10;
        if (d6 > yVar.e()) {
            com.google.android.exoplayer2.util.n.h("Id3Decoder", "Frame size exceeds remaining tag data");
            yVar.M(yVar.e());
            return null;
        }
        if (aVar != null) {
            str = "Id3Decoder";
            i8 = d6;
            i9 = G;
            if (!aVar.a(i6, A, A2, A3, A4)) {
                yVar.M(i8);
                return null;
            }
        } else {
            str = "Id3Decoder";
            i8 = d6;
            i9 = G;
        }
        if (i6 == 3) {
            int i11 = i9;
            z7 = (i11 & 128) != 0;
            z8 = (i11 & 64) != 0;
            z6 = (i11 & 32) != 0;
            z10 = z7;
            z9 = false;
        } else {
            int i12 = i9;
            if (i6 == 4) {
                boolean z11 = (i12 & 64) != 0;
                boolean z12 = (i12 & 8) != 0;
                boolean z13 = (i12 & 4) != 0;
                z9 = (i12 & 2) != 0;
                boolean z14 = (i12 & 1) != 0;
                z6 = z11;
                z7 = z14;
                z10 = z12;
                z8 = z13;
            } else {
                z6 = false;
                z7 = false;
                z8 = false;
                z9 = false;
                z10 = false;
            }
        }
        if (z10 || z8) {
            com.google.android.exoplayer2.util.n.h(str, "Skipping unsupported compressed or encrypted frame");
            yVar.M(i8);
            return null;
        }
        if (z6) {
            i10--;
            yVar.N(1);
        }
        if (z7) {
            i10 -= 4;
            yVar.N(4);
        }
        if (z9) {
            i10 = A(yVar, i10);
        }
        try {
            try {
                if (A == 84 && A2 == 88 && A3 == 88 && (i6 == 2 || A4 == 88)) {
                    j6 = r(yVar, i10);
                } else if (A == 84) {
                    j6 = q(yVar, i10, w(i6, A, A2, A3, A4));
                } else if (A == 87 && A2 == 88 && A3 == 88 && (i6 == 2 || A4 == 88)) {
                    j6 = t(yVar, i10);
                } else if (A == 87) {
                    j6 = s(yVar, i10, w(i6, A, A2, A3, A4));
                } else if (A == 80 && A2 == 82 && A3 == 73 && A4 == 86) {
                    j6 = o(yVar, i10);
                } else if (A == 71 && A2 == 69 && A3 == 79 && (A4 == 66 || i6 == 2)) {
                    j6 = l(yVar, i10);
                } else if (i6 == 2) {
                    if (A == 80 && A2 == 73 && A3 == 67) {
                        j6 = f(yVar, i10, i6);
                    }
                    j6 = (A != 67 && A2 == 79 && A3 == 77 && (A4 == 77 || i6 == 2)) ? j(yVar, i10) : (A != 67 && A2 == 72 && A3 == 65 && A4 == 80) ? h(yVar, i10, i6, z5, i7, aVar) : (A != 67 && A2 == 84 && A3 == 79 && A4 == 67) ? i(yVar, i10, i6, z5, i7, aVar) : (A != 77 && A2 == 76 && A3 == 76 && A4 == 84) ? n(yVar, i10) : g(yVar, i10, w(i6, A, A2, A3, A4));
                } else {
                    if (A == 65) {
                        if (A2 == 80) {
                            if (A3 == 73) {
                            }
                        }
                    }
                    if (A != 67) {
                    }
                }
                if (j6 == null) {
                    String w5 = w(i6, A, A2, A3, A4);
                    StringBuilder sb = new StringBuilder(String.valueOf(w5).length() + 50);
                    sb.append("Failed to decode frame: id=");
                    sb.append(w5);
                    sb.append(", frameSize=");
                    sb.append(i10);
                    com.google.android.exoplayer2.util.n.h(str, sb.toString());
                }
                yVar.M(i8);
                return j6;
            } catch (UnsupportedEncodingException unused) {
                com.google.android.exoplayer2.util.n.h(str, "Unsupported character encoding");
                yVar.M(i8);
                return null;
            }
        } catch (Throwable th) {
            yVar.M(i8);
            throw th;
        }
    }

    private static f l(y yVar, int i6) {
        int A = yVar.A();
        String v5 = v(A);
        int i7 = i6 - 1;
        byte[] bArr = new byte[i7];
        yVar.i(bArr, 0, i7);
        int y5 = y(bArr, 0);
        String str = new String(bArr, 0, y5, "ISO-8859-1");
        int i8 = y5 + 1;
        int x5 = x(bArr, i8, A);
        String p5 = p(bArr, i8, x5, v5);
        int u5 = x5 + u(A);
        int x6 = x(bArr, u5, A);
        return new f(str, p5, p(bArr, u5, x6, v5), d(bArr, x6 + u(A), i7));
    }

    private static b m(y yVar) {
        String sb;
        if (yVar.a() >= 10) {
            int D = yVar.D();
            boolean z5 = false;
            if (D != 4801587) {
                String valueOf = String.valueOf(String.format("%06X", Integer.valueOf(D)));
                com.google.android.exoplayer2.util.n.h("Id3Decoder", valueOf.length() != 0 ? "Unexpected first three bytes of ID3 tag header: 0x".concat(valueOf) : new String("Unexpected first three bytes of ID3 tag header: 0x"));
                return null;
            }
            int A = yVar.A();
            yVar.N(1);
            int A2 = yVar.A();
            int z6 = yVar.z();
            if (A == 2) {
                if ((A2 & 64) != 0) {
                    sb = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme";
                }
                if (A < 4 && (A2 & 128) != 0) {
                    z5 = true;
                }
                return new b(A, z5, z6);
            }
            if (A == 3) {
                if ((A2 & 64) != 0) {
                    int k6 = yVar.k();
                    yVar.N(k6);
                    z6 -= k6 + 4;
                }
            } else if (A == 4) {
                if ((A2 & 64) != 0) {
                    int z7 = yVar.z();
                    yVar.N(z7 - 4);
                    z6 -= z7;
                }
                if ((A2 & 16) != 0) {
                    z6 -= 10;
                }
            } else {
                StringBuilder sb2 = new StringBuilder(57);
                sb2.append("Skipped ID3 tag with unsupported majorVersion=");
                sb2.append(A);
                sb = sb2.toString();
            }
            if (A < 4) {
                z5 = true;
            }
            return new b(A, z5, z6);
        }
        sb = "Data too short to be an ID3 tag";
        com.google.android.exoplayer2.util.n.h("Id3Decoder", sb);
        return null;
    }

    private static k n(y yVar, int i6) {
        int G = yVar.G();
        int D = yVar.D();
        int D2 = yVar.D();
        int A = yVar.A();
        int A2 = yVar.A();
        x xVar = new x();
        xVar.m(yVar);
        int i7 = ((i6 - 10) * 8) / (A + A2);
        int[] iArr = new int[i7];
        int[] iArr2 = new int[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            int h6 = xVar.h(A);
            int h7 = xVar.h(A2);
            iArr[i8] = h6;
            iArr2[i8] = h7;
        }
        return new k(G, D, D2, iArr, iArr2);
    }

    private static l o(y yVar, int i6) {
        byte[] bArr = new byte[i6];
        yVar.i(bArr, 0, i6);
        int y5 = y(bArr, 0);
        return new l(new String(bArr, 0, y5, "ISO-8859-1"), d(bArr, y5 + 1, i6));
    }

    private static String p(byte[] bArr, int i6, int i7, String str) {
        return (i7 <= i6 || i7 > bArr.length) ? HttpUrl.FRAGMENT_ENCODE_SET : new String(bArr, i6, i7 - i6, str);
    }

    private static m q(y yVar, int i6, String str) {
        if (i6 < 1) {
            return null;
        }
        int A = yVar.A();
        String v5 = v(A);
        int i7 = i6 - 1;
        byte[] bArr = new byte[i7];
        yVar.i(bArr, 0, i7);
        return new m(str, null, new String(bArr, 0, x(bArr, 0, A), v5));
    }

    private static m r(y yVar, int i6) {
        if (i6 < 1) {
            return null;
        }
        int A = yVar.A();
        String v5 = v(A);
        int i7 = i6 - 1;
        byte[] bArr = new byte[i7];
        yVar.i(bArr, 0, i7);
        int x5 = x(bArr, 0, A);
        String str = new String(bArr, 0, x5, v5);
        int u5 = x5 + u(A);
        return new m("TXXX", str, p(bArr, u5, x(bArr, u5, A), v5));
    }

    private static n s(y yVar, int i6, String str) {
        byte[] bArr = new byte[i6];
        yVar.i(bArr, 0, i6);
        return new n(str, null, new String(bArr, 0, y(bArr, 0), "ISO-8859-1"));
    }

    private static n t(y yVar, int i6) {
        if (i6 < 1) {
            return null;
        }
        int A = yVar.A();
        String v5 = v(A);
        int i7 = i6 - 1;
        byte[] bArr = new byte[i7];
        yVar.i(bArr, 0, i7);
        int x5 = x(bArr, 0, A);
        String str = new String(bArr, 0, x5, v5);
        int u5 = x5 + u(A);
        return new n("WXXX", str, p(bArr, u5, y(bArr, u5), "ISO-8859-1"));
    }

    private static int u(int i6) {
        return (i6 == 0 || i6 == 3) ? 1 : 2;
    }

    private static String v(int i6) {
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    private static String w(int i6, int i7, int i8, int i9, int i10) {
        return i6 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10));
    }

    private static int x(byte[] bArr, int i6, int i7) {
        int y5 = y(bArr, i6);
        if (i7 == 0 || i7 == 3) {
            return y5;
        }
        while (y5 < bArr.length - 1) {
            if (y5 % 2 == 0 && bArr[y5 + 1] == 0) {
                return y5;
            }
            y5 = y(bArr, y5 + 1);
        }
        return bArr.length;
    }

    private static int y(byte[] bArr, int i6) {
        while (i6 < bArr.length) {
            if (bArr[i6] == 0) {
                return i6;
            }
            i6++;
        }
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean z(int i6, int i7, int i8, int i9, int i10) {
        return false;
    }

    @Override // n1.h
    protected n1.a b(n1.e eVar, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    public n1.a e(byte[] bArr, int i6) {
        ArrayList arrayList = new ArrayList();
        y yVar = new y(bArr, i6);
        b m5 = m(yVar);
        if (m5 == null) {
            return null;
        }
        int d6 = yVar.d();
        int i7 = m5.f13149a == 2 ? 6 : 10;
        int i8 = m5.f13151c;
        if (m5.f13150b) {
            i8 = A(yVar, m5.f13151c);
        }
        yVar.L(d6 + i8);
        boolean z5 = false;
        if (!B(yVar, m5.f13149a, i7, false)) {
            if (m5.f13149a != 4 || !B(yVar, 4, i7, true)) {
                int i9 = m5.f13149a;
                StringBuilder sb = new StringBuilder(56);
                sb.append("Failed to validate ID3 tag with majorVersion=");
                sb.append(i9);
                com.google.android.exoplayer2.util.n.h("Id3Decoder", sb.toString());
                return null;
            }
            z5 = true;
        }
        while (yVar.a() >= i7) {
            i k6 = k(m5.f13149a, yVar, z5, i7, this.f13148a);
            if (k6 != null) {
                arrayList.add(k6);
            }
        }
        return new n1.a(arrayList);
    }

    public h(a aVar) {
        this.f13148a = aVar;
    }
}
