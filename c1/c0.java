package c1;

import com.google.android.exoplayer2.f1;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class c0 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f3164a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3165b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f3166c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3167d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f3168e;

        public a(int i6, int i7, long[] jArr, int i8, boolean z5) {
            this.f3164a = i6;
            this.f3165b = i7;
            this.f3166c = jArr;
            this.f3167d = i8;
            this.f3168e = z5;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f3169a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f3170b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3171c;

        public b(String str, String[] strArr, int i6) {
            this.f3169a = str;
            this.f3170b = strArr;
            this.f3171c = i6;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f3172a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3173b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3174c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3175d;

        public c(boolean z5, int i6, int i7, int i8) {
            this.f3172a = z5;
            this.f3173b = i6;
            this.f3174c = i7;
            this.f3175d = i8;
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f3176a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3177b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3178c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3179d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3180e;

        /* renamed from: f  reason: collision with root package name */
        public final int f3181f;

        /* renamed from: g  reason: collision with root package name */
        public final int f3182g;

        /* renamed from: h  reason: collision with root package name */
        public final int f3183h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f3184i;

        /* renamed from: j  reason: collision with root package name */
        public final byte[] f3185j;

        public d(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, boolean z5, byte[] bArr) {
            this.f3176a = i6;
            this.f3177b = i7;
            this.f3178c = i8;
            this.f3179d = i9;
            this.f3180e = i10;
            this.f3181f = i11;
            this.f3182g = i12;
            this.f3183h = i13;
            this.f3184i = z5;
            this.f3185j = bArr;
        }
    }

    public static int a(int i6) {
        int i7 = 0;
        while (i6 > 0) {
            i7++;
            i6 >>>= 1;
        }
        return i7;
    }

    private static long b(long j6, long j7) {
        return (long) Math.floor(Math.pow(j6, 1.0d / j7));
    }

    private static a c(b0 b0Var) {
        if (b0Var.d(24) != 5653314) {
            int b6 = b0Var.b();
            StringBuilder sb = new StringBuilder(66);
            sb.append("expected code book to start with [0x56, 0x43, 0x42] at ");
            sb.append(b6);
            throw new f1(sb.toString());
        }
        int d6 = b0Var.d(16);
        int d7 = b0Var.d(24);
        long[] jArr = new long[d7];
        boolean c6 = b0Var.c();
        long j6 = 0;
        if (c6) {
            int d8 = b0Var.d(5) + 1;
            int i6 = 0;
            while (i6 < d7) {
                int d9 = b0Var.d(a(d7 - i6));
                for (int i7 = 0; i7 < d9 && i6 < d7; i7++) {
                    jArr[i6] = d8;
                    i6++;
                }
                d8++;
            }
        } else {
            boolean c7 = b0Var.c();
            for (int i8 = 0; i8 < d7; i8++) {
                if (!c7) {
                    jArr[i8] = b0Var.d(5) + 1;
                } else if (b0Var.c()) {
                    jArr[i8] = b0Var.d(5) + 1;
                } else {
                    jArr[i8] = 0;
                }
            }
        }
        int d10 = b0Var.d(4);
        if (d10 > 2) {
            StringBuilder sb2 = new StringBuilder(53);
            sb2.append("lookup type greater than 2 not decodable: ");
            sb2.append(d10);
            throw new f1(sb2.toString());
        }
        if (d10 == 1 || d10 == 2) {
            b0Var.e(32);
            b0Var.e(32);
            int d11 = b0Var.d(4) + 1;
            b0Var.e(1);
            if (d10 != 1) {
                j6 = d7 * d6;
            } else if (d6 != 0) {
                j6 = b(d7, d6);
            }
            b0Var.e((int) (j6 * d11));
        }
        return new a(d6, d7, jArr, d10, c6);
    }

    private static void d(b0 b0Var) {
        int d6 = b0Var.d(6) + 1;
        for (int i6 = 0; i6 < d6; i6++) {
            int d7 = b0Var.d(16);
            if (d7 == 0) {
                b0Var.e(8);
                b0Var.e(16);
                b0Var.e(16);
                b0Var.e(6);
                b0Var.e(8);
                int d8 = b0Var.d(4) + 1;
                for (int i7 = 0; i7 < d8; i7++) {
                    b0Var.e(8);
                }
            } else if (d7 != 1) {
                StringBuilder sb = new StringBuilder(52);
                sb.append("floor type greater than 1 not decodable: ");
                sb.append(d7);
                throw new f1(sb.toString());
            } else {
                int d9 = b0Var.d(5);
                int[] iArr = new int[d9];
                int i8 = -1;
                for (int i9 = 0; i9 < d9; i9++) {
                    int d10 = b0Var.d(4);
                    iArr[i9] = d10;
                    if (d10 > i8) {
                        i8 = d10;
                    }
                }
                int i10 = i8 + 1;
                int[] iArr2 = new int[i10];
                for (int i11 = 0; i11 < i10; i11++) {
                    iArr2[i11] = b0Var.d(3) + 1;
                    int d11 = b0Var.d(2);
                    if (d11 > 0) {
                        b0Var.e(8);
                    }
                    for (int i12 = 0; i12 < (1 << d11); i12++) {
                        b0Var.e(8);
                    }
                }
                b0Var.e(2);
                int d12 = b0Var.d(4);
                int i13 = 0;
                int i14 = 0;
                for (int i15 = 0; i15 < d9; i15++) {
                    i13 += iArr2[iArr[i15]];
                    while (i14 < i13) {
                        b0Var.e(d12);
                        i14++;
                    }
                }
            }
        }
    }

    private static void e(int i6, b0 b0Var) {
        int d6 = b0Var.d(6) + 1;
        for (int i7 = 0; i7 < d6; i7++) {
            int d7 = b0Var.d(16);
            if (d7 != 0) {
                StringBuilder sb = new StringBuilder(52);
                sb.append("mapping type other than 0 not supported: ");
                sb.append(d7);
                com.google.android.exoplayer2.util.n.c("VorbisUtil", sb.toString());
            } else {
                int d8 = b0Var.c() ? b0Var.d(4) + 1 : 1;
                if (b0Var.c()) {
                    int d9 = b0Var.d(8) + 1;
                    for (int i8 = 0; i8 < d9; i8++) {
                        int i9 = i6 - 1;
                        b0Var.e(a(i9));
                        b0Var.e(a(i9));
                    }
                }
                if (b0Var.d(2) != 0) {
                    throw new f1("to reserved bits must be zero after mapping coupling steps");
                }
                if (d8 > 1) {
                    for (int i10 = 0; i10 < i6; i10++) {
                        b0Var.e(4);
                    }
                }
                for (int i11 = 0; i11 < d8; i11++) {
                    b0Var.e(8);
                    b0Var.e(8);
                    b0Var.e(8);
                }
            }
        }
    }

    private static c[] f(b0 b0Var) {
        int d6 = b0Var.d(6) + 1;
        c[] cVarArr = new c[d6];
        for (int i6 = 0; i6 < d6; i6++) {
            cVarArr[i6] = new c(b0Var.c(), b0Var.d(16), b0Var.d(16), b0Var.d(8));
        }
        return cVarArr;
    }

    private static void g(b0 b0Var) {
        int d6 = b0Var.d(6) + 1;
        for (int i6 = 0; i6 < d6; i6++) {
            if (b0Var.d(16) > 2) {
                throw new f1("residueType greater than 2 is not decodable");
            }
            b0Var.e(24);
            b0Var.e(24);
            b0Var.e(24);
            int d7 = b0Var.d(6) + 1;
            b0Var.e(8);
            int[] iArr = new int[d7];
            for (int i7 = 0; i7 < d7; i7++) {
                iArr[i7] = ((b0Var.c() ? b0Var.d(5) : 0) * 8) + b0Var.d(3);
            }
            for (int i8 = 0; i8 < d7; i8++) {
                for (int i9 = 0; i9 < 8; i9++) {
                    if ((iArr[i8] & (1 << i9)) != 0) {
                        b0Var.e(8);
                    }
                }
            }
        }
    }

    public static b h(com.google.android.exoplayer2.util.y yVar) {
        return i(yVar, true, true);
    }

    public static b i(com.google.android.exoplayer2.util.y yVar, boolean z5, boolean z6) {
        if (z5) {
            l(3, yVar, false);
        }
        String x5 = yVar.x((int) yVar.q());
        int length = 11 + x5.length();
        long q5 = yVar.q();
        String[] strArr = new String[(int) q5];
        int i6 = length + 4;
        for (int i7 = 0; i7 < q5; i7++) {
            String x6 = yVar.x((int) yVar.q());
            strArr[i7] = x6;
            i6 = i6 + 4 + x6.length();
        }
        if (z6 && (yVar.A() & 1) == 0) {
            throw new f1("framing bit expected to be set");
        }
        return new b(x5, strArr, i6 + 1);
    }

    public static d j(com.google.android.exoplayer2.util.y yVar) {
        l(1, yVar, false);
        int r5 = yVar.r();
        int A = yVar.A();
        int r6 = yVar.r();
        int n5 = yVar.n();
        if (n5 <= 0) {
            n5 = -1;
        }
        int n6 = yVar.n();
        if (n6 <= 0) {
            n6 = -1;
        }
        int n7 = yVar.n();
        if (n7 <= 0) {
            n7 = -1;
        }
        int A2 = yVar.A();
        return new d(r5, A, r6, n5, n6, n7, (int) Math.pow(2.0d, A2 & 15), (int) Math.pow(2.0d, (A2 & 240) >> 4), (yVar.A() & 1) > 0, Arrays.copyOf(yVar.c(), yVar.e()));
    }

    public static c[] k(com.google.android.exoplayer2.util.y yVar, int i6) {
        l(5, yVar, false);
        int A = yVar.A() + 1;
        b0 b0Var = new b0(yVar.c());
        b0Var.e(yVar.d() * 8);
        for (int i7 = 0; i7 < A; i7++) {
            c(b0Var);
        }
        int d6 = b0Var.d(6) + 1;
        for (int i8 = 0; i8 < d6; i8++) {
            if (b0Var.d(16) != 0) {
                throw new f1("placeholder of time domain transforms not zeroed out");
            }
        }
        d(b0Var);
        g(b0Var);
        e(i6, b0Var);
        c[] f6 = f(b0Var);
        if (b0Var.c()) {
            return f6;
        }
        throw new f1("framing bit after modes not set as expected");
    }

    public static boolean l(int i6, com.google.android.exoplayer2.util.y yVar, boolean z5) {
        if (yVar.a() < 7) {
            if (z5) {
                return false;
            }
            int a6 = yVar.a();
            StringBuilder sb = new StringBuilder(29);
            sb.append("too short header: ");
            sb.append(a6);
            throw new f1(sb.toString());
        } else if (yVar.A() != i6) {
            if (z5) {
                return false;
            }
            String valueOf = String.valueOf(Integer.toHexString(i6));
            throw new f1(valueOf.length() != 0 ? "expected header type ".concat(valueOf) : new String("expected header type "));
        } else if (yVar.A() == 118 && yVar.A() == 111 && yVar.A() == 114 && yVar.A() == 98 && yVar.A() == 105 && yVar.A() == 115) {
            return true;
        } else {
            if (z5) {
                return false;
            }
            throw new f1("expected characters 'vorbis'");
        }
    }
}
