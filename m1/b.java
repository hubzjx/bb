package m1;

import android.net.Uri;
import android.util.Pair;
import androidx.constraintlayout.widget.g;
import b.j;
import c1.a0;
import c1.i;
import c1.k;
import c1.n;
import c1.o;
import c1.w;
import com.google.android.exoplayer2.audio.j1;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.y;
import java.util.Map;
import okhttp3.internal.http.StatusLine;
/* loaded from: classes.dex */
public final class b implements i {

    /* renamed from: f  reason: collision with root package name */
    public static final o f11957f = new o() { // from class: m1.a
        @Override // c1.o
        public final i[] a() {
            i[] f6;
            f6 = b.f();
            return f6;
        }

        @Override // c1.o
        public /* synthetic */ i[] b(Uri uri, Map map) {
            return n.a(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private k f11958a;

    /* renamed from: b  reason: collision with root package name */
    private a0 f11959b;

    /* renamed from: c  reason: collision with root package name */
    private InterfaceC0195b f11960c;

    /* renamed from: d  reason: collision with root package name */
    private int f11961d = -1;

    /* renamed from: e  reason: collision with root package name */
    private long f11962e = -1;

    /* loaded from: classes.dex */
    private static final class a implements InterfaceC0195b {

        /* renamed from: m  reason: collision with root package name */
        private static final int[] f11963m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* renamed from: n  reason: collision with root package name */
        private static final int[] f11964n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, g.Y0, j.H0, 130, 143, 157, 173, 190, 209, 230, 253, 279, StatusLine.HTTP_TEMP_REDIRECT, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* renamed from: a  reason: collision with root package name */
        private final k f11965a;

        /* renamed from: b  reason: collision with root package name */
        private final a0 f11966b;

        /* renamed from: c  reason: collision with root package name */
        private final m1.c f11967c;

        /* renamed from: d  reason: collision with root package name */
        private final int f11968d;

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f11969e;

        /* renamed from: f  reason: collision with root package name */
        private final y f11970f;

        /* renamed from: g  reason: collision with root package name */
        private final int f11971g;

        /* renamed from: h  reason: collision with root package name */
        private final s0 f11972h;

        /* renamed from: i  reason: collision with root package name */
        private int f11973i;

        /* renamed from: j  reason: collision with root package name */
        private long f11974j;

        /* renamed from: k  reason: collision with root package name */
        private int f11975k;

        /* renamed from: l  reason: collision with root package name */
        private long f11976l;

        public a(k kVar, a0 a0Var, m1.c cVar) {
            this.f11965a = kVar;
            this.f11966b = a0Var;
            this.f11967c = cVar;
            int max = Math.max(1, cVar.f11987c / 10);
            this.f11971g = max;
            y yVar = new y(cVar.f11991g);
            yVar.s();
            int s5 = yVar.s();
            this.f11968d = s5;
            int i6 = cVar.f11986b;
            int i7 = (((cVar.f11989e - (i6 * 4)) * 8) / (cVar.f11990f * i6)) + 1;
            if (s5 == i7) {
                int l6 = com.google.android.exoplayer2.util.s0.l(max, s5);
                this.f11969e = new byte[cVar.f11989e * l6];
                this.f11970f = new y(l6 * h(s5, i6));
                int i8 = ((cVar.f11987c * cVar.f11989e) * 8) / s5;
                this.f11972h = new s0.b().e0("audio/raw").G(i8).Z(i8).W(h(max, i6)).H(cVar.f11986b).f0(cVar.f11987c).Y(2).E();
                return;
            }
            StringBuilder sb = new StringBuilder(56);
            sb.append("Expected frames per block: ");
            sb.append(i7);
            sb.append("; got: ");
            sb.append(s5);
            throw new f1(sb.toString());
        }

        private void d(byte[] bArr, int i6, y yVar) {
            for (int i7 = 0; i7 < i6; i7++) {
                for (int i8 = 0; i8 < this.f11967c.f11986b; i8++) {
                    e(bArr, i7, i8, yVar.c());
                }
            }
            yVar.I(g(this.f11968d * i6));
        }

        private void e(byte[] bArr, int i6, int i7, byte[] bArr2) {
            m1.c cVar = this.f11967c;
            int i8 = cVar.f11989e;
            int i9 = cVar.f11986b;
            int i10 = (i6 * i8) + (i7 * 4);
            int i11 = (i9 * 4) + i10;
            int i12 = (i8 / i9) - 4;
            int i13 = (short) (((bArr[i10 + 1] & 255) << 8) | (bArr[i10] & 255));
            int min = Math.min(bArr[i10 + 2] & 255, 88);
            int i14 = f11964n[min];
            int i15 = ((i6 * this.f11968d * i9) + i7) * 2;
            bArr2[i15] = (byte) (i13 & 255);
            bArr2[i15 + 1] = (byte) (i13 >> 8);
            for (int i16 = 0; i16 < i12 * 2; i16++) {
                int i17 = bArr[((i16 / 8) * i9 * 4) + i11 + ((i16 / 2) % 4)] & 255;
                int i18 = i16 % 2 == 0 ? i17 & 15 : i17 >> 4;
                int i19 = ((((i18 & 7) * 2) + 1) * i14) >> 3;
                if ((i18 & 8) != 0) {
                    i19 = -i19;
                }
                i13 = com.google.android.exoplayer2.util.s0.r(i13 + i19, -32768, 32767);
                i15 += i9 * 2;
                bArr2[i15] = (byte) (i13 & 255);
                bArr2[i15 + 1] = (byte) (i13 >> 8);
                int i20 = min + f11963m[i18];
                int[] iArr = f11964n;
                min = com.google.android.exoplayer2.util.s0.r(i20, 0, iArr.length - 1);
                i14 = iArr[min];
            }
        }

        private int f(int i6) {
            return i6 / (this.f11967c.f11986b * 2);
        }

        private int g(int i6) {
            return h(i6, this.f11967c.f11986b);
        }

        private static int h(int i6, int i7) {
            return i6 * 2 * i7;
        }

        private void i(int i6) {
            long F0 = this.f11974j + com.google.android.exoplayer2.util.s0.F0(this.f11976l, 1000000L, this.f11967c.f11987c);
            int g6 = g(i6);
            this.f11966b.d(F0, 1, g6, this.f11975k - g6, null);
            this.f11976l += i6;
            this.f11975k -= g6;
        }

        @Override // m1.b.InterfaceC0195b
        public void a(int i6, long j6) {
            this.f11965a.r(new e(this.f11967c, this.f11968d, i6, j6));
            this.f11966b.e(this.f11972h);
        }

        @Override // m1.b.InterfaceC0195b
        public void b(long j6) {
            this.f11973i = 0;
            this.f11974j = j6;
            this.f11975k = 0;
            this.f11976l = 0L;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0036 -> B:4:0x001c). Please submit an issue!!! */
        @Override // m1.b.InterfaceC0195b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean c(c1.j jVar, long j6) {
            boolean z5;
            int i6;
            int f6;
            int i7;
            int l6 = com.google.android.exoplayer2.util.s0.l(this.f11971g - f(this.f11975k), this.f11968d) * this.f11967c.f11989e;
            if (j6 != 0) {
                z5 = false;
                while (!z5) {
                    if (this.f11973i >= l6) {
                        break;
                    }
                    int read = jVar.read(this.f11969e, this.f11973i, (int) Math.min(l6 - i7, j6));
                    if (read != -1) {
                        this.f11973i += read;
                    }
                }
                i6 = this.f11973i / this.f11967c.f11989e;
                if (i6 > 0) {
                    d(this.f11969e, i6, this.f11970f);
                    this.f11973i -= i6 * this.f11967c.f11989e;
                    int e6 = this.f11970f.e();
                    this.f11966b.a(this.f11970f, e6);
                    int i8 = this.f11975k + e6;
                    this.f11975k = i8;
                    int f7 = f(i8);
                    int i9 = this.f11971g;
                    if (f7 >= i9) {
                        i(i9);
                    }
                }
                if (z5 && (f6 = f(this.f11975k)) > 0) {
                    i(f6);
                }
                return z5;
            }
            z5 = true;
            while (!z5) {
            }
            i6 = this.f11973i / this.f11967c.f11989e;
            if (i6 > 0) {
            }
            if (z5) {
                i(f6);
            }
            return z5;
        }
    }

    /* renamed from: m1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private interface InterfaceC0195b {
        void a(int i6, long j6);

        void b(long j6);

        boolean c(c1.j jVar, long j6);
    }

    /* loaded from: classes.dex */
    private static final class c implements InterfaceC0195b {

        /* renamed from: a  reason: collision with root package name */
        private final k f11977a;

        /* renamed from: b  reason: collision with root package name */
        private final a0 f11978b;

        /* renamed from: c  reason: collision with root package name */
        private final m1.c f11979c;

        /* renamed from: d  reason: collision with root package name */
        private final s0 f11980d;

        /* renamed from: e  reason: collision with root package name */
        private final int f11981e;

        /* renamed from: f  reason: collision with root package name */
        private long f11982f;

        /* renamed from: g  reason: collision with root package name */
        private int f11983g;

        /* renamed from: h  reason: collision with root package name */
        private long f11984h;

        public c(k kVar, a0 a0Var, m1.c cVar, String str, int i6) {
            this.f11977a = kVar;
            this.f11978b = a0Var;
            this.f11979c = cVar;
            int i7 = (cVar.f11986b * cVar.f11990f) / 8;
            if (cVar.f11989e == i7) {
                int i8 = cVar.f11987c;
                int i9 = i8 * i7 * 8;
                int max = Math.max(i7, (i8 * i7) / 10);
                this.f11981e = max;
                this.f11980d = new s0.b().e0(str).G(i9).Z(i9).W(max).H(cVar.f11986b).f0(cVar.f11987c).Y(i6).E();
                return;
            }
            int i10 = cVar.f11989e;
            StringBuilder sb = new StringBuilder(50);
            sb.append("Expected block size: ");
            sb.append(i7);
            sb.append("; got: ");
            sb.append(i10);
            throw new f1(sb.toString());
        }

        @Override // m1.b.InterfaceC0195b
        public void a(int i6, long j6) {
            this.f11977a.r(new e(this.f11979c, 1, i6, j6));
            this.f11978b.e(this.f11980d);
        }

        @Override // m1.b.InterfaceC0195b
        public void b(long j6) {
            this.f11982f = j6;
            this.f11983g = 0;
            this.f11984h = 0L;
        }

        @Override // m1.b.InterfaceC0195b
        public boolean c(c1.j jVar, long j6) {
            int i6;
            m1.c cVar;
            int i7;
            int i8;
            long j7 = j6;
            while (true) {
                i6 = (j7 > 0L ? 1 : (j7 == 0L ? 0 : -1));
                if (i6 <= 0 || (i7 = this.f11983g) >= (i8 = this.f11981e)) {
                    break;
                }
                int b6 = this.f11978b.b(jVar, (int) Math.min(i8 - i7, j7), true);
                if (b6 == -1) {
                    j7 = 0;
                } else {
                    this.f11983g += b6;
                    j7 -= b6;
                }
            }
            int i9 = this.f11979c.f11989e;
            int i10 = this.f11983g / i9;
            if (i10 > 0) {
                int i11 = i10 * i9;
                int i12 = this.f11983g - i11;
                this.f11978b.d(this.f11982f + com.google.android.exoplayer2.util.s0.F0(this.f11984h, 1000000L, cVar.f11987c), 1, i11, i12, null);
                this.f11984h += i10;
                this.f11983g = i12;
            }
            return i6 <= 0;
        }
    }

    private void e() {
        com.google.android.exoplayer2.util.a.i(this.f11959b);
        com.google.android.exoplayer2.util.s0.j(this.f11958a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i[] f() {
        return new i[]{new b()};
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(k kVar) {
        this.f11958a = kVar;
        this.f11959b = kVar.e(0, 1);
        kVar.g();
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        InterfaceC0195b interfaceC0195b = this.f11960c;
        if (interfaceC0195b != null) {
            interfaceC0195b.b(j7);
        }
    }

    @Override // c1.i
    public int g(c1.j jVar, w wVar) {
        InterfaceC0195b cVar;
        e();
        if (this.f11960c == null) {
            m1.c a6 = d.a(jVar);
            if (a6 == null) {
                throw new f1("Unsupported or unrecognized wav header.");
            }
            int i6 = a6.f11985a;
            if (i6 == 17) {
                cVar = new a(this.f11958a, this.f11959b, a6);
            } else if (i6 == 6) {
                cVar = new c(this.f11958a, this.f11959b, a6, "audio/g711-alaw", -1);
            } else if (i6 == 7) {
                cVar = new c(this.f11958a, this.f11959b, a6, "audio/g711-mlaw", -1);
            } else {
                int a7 = j1.a(i6, a6.f11990f);
                if (a7 == 0) {
                    int i7 = a6.f11985a;
                    StringBuilder sb = new StringBuilder(40);
                    sb.append("Unsupported WAV format type: ");
                    sb.append(i7);
                    throw new f1(sb.toString());
                }
                cVar = new c(this.f11958a, this.f11959b, a6, "audio/raw", a7);
            }
            this.f11960c = cVar;
        }
        if (this.f11961d == -1) {
            Pair b6 = d.b(jVar);
            this.f11961d = ((Long) b6.first).intValue();
            long longValue = ((Long) b6.second).longValue();
            this.f11962e = longValue;
            this.f11960c.a(this.f11961d, longValue);
        } else if (jVar.p() == 0) {
            jVar.h(this.f11961d);
        }
        com.google.android.exoplayer2.util.a.g(this.f11962e != -1);
        return this.f11960c.c(jVar, this.f11962e - jVar.p()) ? -1 : 0;
    }

    @Override // c1.i
    public boolean h(c1.j jVar) {
        return d.a(jVar) != null;
    }
}
