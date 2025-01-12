package g1;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import c1.a0;
import c1.i;
import c1.j;
import c1.k;
import c1.n;
import c1.o;
import c1.w;
import c1.x;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.drm.k;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import okio.Segment;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public class e implements i {

    /* renamed from: b0  reason: collision with root package name */
    public static final o f10339b0 = new o() { // from class: g1.d
        @Override // c1.o
        public final i[] a() {
            i[] x5;
            x5 = e.x();
            return x5;
        }

        @Override // c1.o
        public /* synthetic */ i[] b(Uri uri, Map map) {
            return n.a(this, uri, map);
        }
    };

    /* renamed from: c0  reason: collision with root package name */
    private static final byte[] f10340c0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: d0  reason: collision with root package name */
    private static final byte[] f10341d0 = s0.h0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: e0  reason: collision with root package name */
    private static final byte[] f10342e0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: f0  reason: collision with root package name */
    private static final UUID f10343f0 = new UUID(72057594037932032L, -9223371306706625679L);

    /* renamed from: g0  reason: collision with root package name */
    private static final Map f10344g0;
    private long A;
    private long B;
    private com.google.android.exoplayer2.util.o C;
    private com.google.android.exoplayer2.util.o D;
    private boolean E;
    private boolean F;
    private int G;
    private long H;
    private long I;
    private int J;
    private int K;
    private int[] L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private byte Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    private final g1.c f10345a;

    /* renamed from: a0  reason: collision with root package name */
    private k f10346a0;

    /* renamed from: b  reason: collision with root package name */
    private final g f10347b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray f10348c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10349d;

    /* renamed from: e  reason: collision with root package name */
    private final y f10350e;

    /* renamed from: f  reason: collision with root package name */
    private final y f10351f;

    /* renamed from: g  reason: collision with root package name */
    private final y f10352g;

    /* renamed from: h  reason: collision with root package name */
    private final y f10353h;

    /* renamed from: i  reason: collision with root package name */
    private final y f10354i;

    /* renamed from: j  reason: collision with root package name */
    private final y f10355j;

    /* renamed from: k  reason: collision with root package name */
    private final y f10356k;

    /* renamed from: l  reason: collision with root package name */
    private final y f10357l;

    /* renamed from: m  reason: collision with root package name */
    private final y f10358m;

    /* renamed from: n  reason: collision with root package name */
    private final y f10359n;

    /* renamed from: o  reason: collision with root package name */
    private ByteBuffer f10360o;

    /* renamed from: p  reason: collision with root package name */
    private long f10361p;

    /* renamed from: q  reason: collision with root package name */
    private long f10362q;

    /* renamed from: r  reason: collision with root package name */
    private long f10363r;

    /* renamed from: s  reason: collision with root package name */
    private long f10364s;

    /* renamed from: t  reason: collision with root package name */
    private long f10365t;

    /* renamed from: u  reason: collision with root package name */
    private c f10366u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f10367v;

    /* renamed from: w  reason: collision with root package name */
    private int f10368w;

    /* renamed from: x  reason: collision with root package name */
    private long f10369x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f10370y;

    /* renamed from: z  reason: collision with root package name */
    private long f10371z;

    /* loaded from: classes.dex */
    private final class b implements g1.b {
        private b() {
        }

        @Override // g1.b
        public void a(int i6) {
            e.this.m(i6);
        }

        @Override // g1.b
        public int b(int i6) {
            return e.this.r(i6);
        }

        @Override // g1.b
        public void c(int i6, double d6) {
            e.this.p(i6, d6);
        }

        @Override // g1.b
        public boolean d(int i6) {
            return e.this.w(i6);
        }

        @Override // g1.b
        public void e(int i6, int i7, j jVar) {
            e.this.j(i6, i7, jVar);
        }

        @Override // g1.b
        public void f(int i6, String str) {
            e.this.E(i6, str);
        }

        @Override // g1.b
        public void g(int i6, long j6, long j7) {
            e.this.D(i6, j6, j7);
        }

        @Override // g1.b
        public void h(int i6, long j6) {
            e.this.u(i6, j6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {
        public int A;
        public int B;
        public int C;
        public float D;
        public float E;
        public float F;
        public float G;
        public float H;
        public float I;
        public float J;
        public float K;
        public float L;
        public float M;
        public byte[] N;
        public int O;
        public int P;
        public int Q;
        public long R;
        public long S;
        public d T;
        public boolean U;
        public boolean V;
        private String W;
        public a0 X;
        public int Y;

        /* renamed from: a  reason: collision with root package name */
        public String f10373a;

        /* renamed from: b  reason: collision with root package name */
        public String f10374b;

        /* renamed from: c  reason: collision with root package name */
        public int f10375c;

        /* renamed from: d  reason: collision with root package name */
        public int f10376d;

        /* renamed from: e  reason: collision with root package name */
        public int f10377e;

        /* renamed from: f  reason: collision with root package name */
        public int f10378f;

        /* renamed from: g  reason: collision with root package name */
        private int f10379g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f10380h;

        /* renamed from: i  reason: collision with root package name */
        public byte[] f10381i;

        /* renamed from: j  reason: collision with root package name */
        public a0.a f10382j;

        /* renamed from: k  reason: collision with root package name */
        public byte[] f10383k;

        /* renamed from: l  reason: collision with root package name */
        public com.google.android.exoplayer2.drm.k f10384l;

        /* renamed from: m  reason: collision with root package name */
        public int f10385m;

        /* renamed from: n  reason: collision with root package name */
        public int f10386n;

        /* renamed from: o  reason: collision with root package name */
        public int f10387o;

        /* renamed from: p  reason: collision with root package name */
        public int f10388p;

        /* renamed from: q  reason: collision with root package name */
        public int f10389q;

        /* renamed from: r  reason: collision with root package name */
        public int f10390r;

        /* renamed from: s  reason: collision with root package name */
        public float f10391s;

        /* renamed from: t  reason: collision with root package name */
        public float f10392t;

        /* renamed from: u  reason: collision with root package name */
        public float f10393u;

        /* renamed from: v  reason: collision with root package name */
        public byte[] f10394v;

        /* renamed from: w  reason: collision with root package name */
        public int f10395w;

        /* renamed from: x  reason: collision with root package name */
        public boolean f10396x;

        /* renamed from: y  reason: collision with root package name */
        public int f10397y;

        /* renamed from: z  reason: collision with root package name */
        public int f10398z;

        private c() {
            this.f10385m = -1;
            this.f10386n = -1;
            this.f10387o = -1;
            this.f10388p = -1;
            this.f10389q = 0;
            this.f10390r = -1;
            this.f10391s = 0.0f;
            this.f10392t = 0.0f;
            this.f10393u = 0.0f;
            this.f10394v = null;
            this.f10395w = -1;
            this.f10396x = false;
            this.f10397y = -1;
            this.f10398z = -1;
            this.A = -1;
            this.B = 1000;
            this.C = 200;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = -1.0f;
            this.K = -1.0f;
            this.L = -1.0f;
            this.M = -1.0f;
            this.O = 1;
            this.P = -1;
            this.Q = 8000;
            this.R = 0L;
            this.S = 0L;
            this.V = true;
            this.W = "eng";
        }

        private byte[] d() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((this.D * 50000.0f) + 0.5f));
            order.putShort((short) ((this.E * 50000.0f) + 0.5f));
            order.putShort((short) ((this.F * 50000.0f) + 0.5f));
            order.putShort((short) ((this.G * 50000.0f) + 0.5f));
            order.putShort((short) ((this.H * 50000.0f) + 0.5f));
            order.putShort((short) ((this.I * 50000.0f) + 0.5f));
            order.putShort((short) ((this.J * 50000.0f) + 0.5f));
            order.putShort((short) ((this.K * 50000.0f) + 0.5f));
            order.putShort((short) (this.L + 0.5f));
            order.putShort((short) (this.M + 0.5f));
            order.putShort((short) this.B);
            order.putShort((short) this.C);
            return bArr;
        }

        private static Pair g(y yVar) {
            try {
                yVar.N(16);
                long q5 = yVar.q();
                if (q5 == 1482049860) {
                    return new Pair("video/divx", null);
                }
                if (q5 == 859189832) {
                    return new Pair("video/3gpp", null);
                }
                if (q5 != 826496599) {
                    com.google.android.exoplayer2.util.n.h("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair("video/x-unknown", null);
                }
                byte[] c6 = yVar.c();
                for (int d6 = yVar.d() + 20; d6 < c6.length - 4; d6++) {
                    if (c6[d6] == 0 && c6[d6 + 1] == 0 && c6[d6 + 2] == 1 && c6[d6 + 3] == 15) {
                        return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(c6, d6, c6.length)));
                    }
                }
                throw new f1("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new f1("Error parsing FourCC private data");
            }
        }

        private static boolean h(y yVar) {
            try {
                int s5 = yVar.s();
                if (s5 == 1) {
                    return true;
                }
                if (s5 == 65534) {
                    yVar.M(24);
                    if (yVar.t() == e.f10343f0.getMostSignificantBits()) {
                        if (yVar.t() == e.f10343f0.getLeastSignificantBits()) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new f1("Error parsing MS/ACM codec private");
            }
        }

        private static List i(byte[] bArr) {
            int i6;
            int i7;
            try {
                if (bArr[0] == 2) {
                    int i8 = 1;
                    int i9 = 0;
                    while (true) {
                        i6 = bArr[i8];
                        if (i6 != -1) {
                            break;
                        }
                        i9 += 255;
                        i8++;
                    }
                    int i10 = i8 + 1;
                    int i11 = i9 + i6;
                    int i12 = 0;
                    while (true) {
                        i7 = bArr[i10];
                        if (i7 != -1) {
                            break;
                        }
                        i12 += 255;
                        i10++;
                    }
                    int i13 = i10 + 1;
                    int i14 = i12 + i7;
                    if (bArr[i13] == 1) {
                        byte[] bArr2 = new byte[i11];
                        System.arraycopy(bArr, i13, bArr2, 0, i11);
                        int i15 = i13 + i11;
                        if (bArr[i15] == 3) {
                            int i16 = i15 + i14;
                            if (bArr[i16] == 5) {
                                byte[] bArr3 = new byte[bArr.length - i16];
                                System.arraycopy(bArr, i16, bArr3, 0, bArr.length - i16);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw new f1("Error parsing vorbis codec private");
                        }
                        throw new f1("Error parsing vorbis codec private");
                    }
                    throw new f1("Error parsing vorbis codec private");
                }
                throw new f1("Error parsing vorbis codec private");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new f1("Error parsing vorbis codec private");
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public void e(k kVar, int i6) {
            char c6;
            List singletonList;
            String concat;
            int Y;
            int i7;
            StringBuilder sb;
            ArrayList i8;
            String str;
            int i9;
            int i10;
            int i11;
            int i12;
            s2.c a6;
            String str2 = this.f10374b;
            str2.hashCode();
            int i13 = 1;
            int i14 = 0;
            switch (str2.hashCode()) {
                case -2095576542:
                    if (str2.equals("V_MPEG4/ISO/AP")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -2095575984:
                    if (str2.equals("V_MPEG4/ISO/SP")) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -1985379776:
                    if (str2.equals("A_MS/ACM")) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -1784763192:
                    if (str2.equals("A_TRUEHD")) {
                        c6 = 3;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -1730367663:
                    if (str2.equals("A_VORBIS")) {
                        c6 = 4;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -1482641358:
                    if (str2.equals("A_MPEG/L2")) {
                        c6 = 5;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -1482641357:
                    if (str2.equals("A_MPEG/L3")) {
                        c6 = 6;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -1373388978:
                    if (str2.equals("V_MS/VFW/FOURCC")) {
                        c6 = 7;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -933872740:
                    if (str2.equals("S_DVBSUB")) {
                        c6 = '\b';
                        break;
                    }
                    c6 = 65535;
                    break;
                case -538363189:
                    if (str2.equals("V_MPEG4/ISO/ASP")) {
                        c6 = '\t';
                        break;
                    }
                    c6 = 65535;
                    break;
                case -538363109:
                    if (str2.equals("V_MPEG4/ISO/AVC")) {
                        c6 = '\n';
                        break;
                    }
                    c6 = 65535;
                    break;
                case -425012669:
                    if (str2.equals("S_VOBSUB")) {
                        c6 = 11;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -356037306:
                    if (str2.equals("A_DTS/LOSSLESS")) {
                        c6 = '\f';
                        break;
                    }
                    c6 = 65535;
                    break;
                case 62923557:
                    if (str2.equals("A_AAC")) {
                        c6 = '\r';
                        break;
                    }
                    c6 = 65535;
                    break;
                case 62923603:
                    if (str2.equals("A_AC3")) {
                        c6 = 14;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 62927045:
                    if (str2.equals("A_DTS")) {
                        c6 = 15;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 82318131:
                    if (str2.equals("V_AV1")) {
                        c6 = 16;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 82338133:
                    if (str2.equals("V_VP8")) {
                        c6 = 17;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 82338134:
                    if (str2.equals("V_VP9")) {
                        c6 = 18;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 99146302:
                    if (str2.equals("S_HDMV/PGS")) {
                        c6 = 19;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 444813526:
                    if (str2.equals("V_THEORA")) {
                        c6 = 20;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 542569478:
                    if (str2.equals("A_DTS/EXPRESS")) {
                        c6 = 21;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 725957860:
                    if (str2.equals("A_PCM/INT/LIT")) {
                        c6 = 22;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 738597099:
                    if (str2.equals("S_TEXT/ASS")) {
                        c6 = 23;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 855502857:
                    if (str2.equals("V_MPEGH/ISO/HEVC")) {
                        c6 = 24;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1422270023:
                    if (str2.equals("S_TEXT/UTF8")) {
                        c6 = 25;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1809237540:
                    if (str2.equals("V_MPEG2")) {
                        c6 = 26;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1950749482:
                    if (str2.equals("A_EAC3")) {
                        c6 = 27;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1950789798:
                    if (str2.equals("A_FLAC")) {
                        c6 = 28;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1951062397:
                    if (str2.equals("A_OPUS")) {
                        c6 = 29;
                        break;
                    }
                    c6 = 65535;
                    break;
                default:
                    c6 = 65535;
                    break;
            }
            String str3 = "audio/raw";
            switch (c6) {
                case 0:
                case 1:
                case '\t':
                    byte[] bArr = this.f10383k;
                    singletonList = bArr == null ? null : Collections.singletonList(bArr);
                    str3 = "video/mp4v-es";
                    i8 = singletonList;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 2:
                    if (h(new y(this.f10383k))) {
                        Y = s0.Y(this.P);
                        if (Y == 0) {
                            i7 = this.P;
                            sb = new StringBuilder("audio/x-unknown".length() + 60);
                            sb.append("Unsupported PCM bit depth: ");
                            sb.append(i7);
                            sb.append(". Setting mimeType to ");
                            sb.append("audio/x-unknown");
                            concat = sb.toString();
                            com.google.android.exoplayer2.util.n.h("MatroskaExtractor", concat);
                            str3 = "audio/x-unknown";
                            i8 = null;
                            str = null;
                            Y = -1;
                            i9 = -1;
                            break;
                        }
                        i8 = null;
                        str = null;
                        i9 = -1;
                    } else {
                        concat = "audio/x-unknown".length() != 0 ? "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown") : new String("Non-PCM MS/ACM is unsupported. Setting mimeType to ");
                        com.google.android.exoplayer2.util.n.h("MatroskaExtractor", concat);
                        str3 = "audio/x-unknown";
                        i8 = null;
                        str = null;
                        Y = -1;
                        i9 = -1;
                    }
                case 3:
                    this.T = new d();
                    str3 = "audio/true-hd";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 4:
                    str3 = "audio/vorbis";
                    i8 = i(this.f10383k);
                    str = null;
                    Y = -1;
                    i9 = Segment.SIZE;
                    break;
                case 5:
                    str3 = "audio/mpeg-L2";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = _BufferKt.SEGMENTING_THRESHOLD;
                    break;
                case 6:
                    str3 = "audio/mpeg";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = _BufferKt.SEGMENTING_THRESHOLD;
                    break;
                case 7:
                    Pair g6 = g(new y(this.f10383k));
                    str3 = (String) g6.first;
                    singletonList = (List) g6.second;
                    i8 = singletonList;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case '\b':
                    byte[] bArr2 = this.f10383k;
                    i8 = Collections.singletonList(new byte[]{bArr2[0], bArr2[1], bArr2[2], bArr2[3]});
                    str3 = "application/dvbsubs";
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case '\n':
                    s2.a b6 = s2.a.b(new y(this.f10383k));
                    i8 = b6.f13167a;
                    this.Y = b6.f13168b;
                    str3 = "video/avc";
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 11:
                    i8 = Collections.singletonList(this.f10383k);
                    str3 = "application/vobsub";
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case '\f':
                    str3 = "audio/vnd.dts.hd";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case '\r':
                    List singletonList2 = Collections.singletonList(this.f10383k);
                    a.b g7 = com.google.android.exoplayer2.audio.a.g(this.f10383k);
                    this.Q = g7.f3314a;
                    this.O = g7.f3315b;
                    str3 = "audio/mp4a-latm";
                    str = g7.f3316c;
                    i9 = -1;
                    i8 = singletonList2;
                    Y = -1;
                    break;
                case 14:
                    str3 = "audio/ac3";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 15:
                case 21:
                    str3 = "audio/vnd.dts";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 16:
                    str3 = "video/av01";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 17:
                    str3 = "video/x-vnd.on2.vp8";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 18:
                    str3 = "video/x-vnd.on2.vp9";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 19:
                    str3 = "application/pgs";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 20:
                    str3 = "video/x-unknown";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 22:
                    Y = s0.Y(this.P);
                    if (Y == 0) {
                        i7 = this.P;
                        sb = new StringBuilder("audio/x-unknown".length() + 60);
                        sb.append("Unsupported PCM bit depth: ");
                        sb.append(i7);
                        sb.append(". Setting mimeType to ");
                        sb.append("audio/x-unknown");
                        concat = sb.toString();
                        com.google.android.exoplayer2.util.n.h("MatroskaExtractor", concat);
                        str3 = "audio/x-unknown";
                        i8 = null;
                        str = null;
                        Y = -1;
                        i9 = -1;
                        break;
                    }
                    i8 = null;
                    str = null;
                    i9 = -1;
                case 23:
                    str3 = "text/x-ssa";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 24:
                    s2.e a7 = s2.e.a(new y(this.f10383k));
                    i8 = a7.f13190a;
                    this.Y = a7.f13191b;
                    str3 = "video/hevc";
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 25:
                    str3 = "application/x-subrip";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 26:
                    str3 = "video/mpeg2";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 27:
                    str3 = "audio/eac3";
                    i8 = null;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 28:
                    singletonList = Collections.singletonList(this.f10383k);
                    str3 = "audio/flac";
                    i8 = singletonList;
                    str = null;
                    Y = -1;
                    i9 = -1;
                    break;
                case 29:
                    ArrayList arrayList = new ArrayList(3);
                    arrayList.add(this.f10383k);
                    ByteBuffer allocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    arrayList.add(allocate.order(byteOrder).putLong(this.R).array());
                    arrayList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.S).array());
                    str3 = "audio/opus";
                    i8 = arrayList;
                    str = null;
                    Y = -1;
                    i9 = 5760;
                    break;
                default:
                    throw new f1("Unrecognized codec identifier.");
            }
            byte[] bArr3 = this.N;
            if (bArr3 != null && (a6 = s2.c.a(new y(bArr3))) != null) {
                str = a6.f13179c;
                str3 = "video/dolby-vision";
            }
            String str4 = str3;
            int i15 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
            s0.b bVar = new s0.b();
            if (q.n(str4)) {
                bVar.H(this.O).f0(this.Q).Y(Y);
            } else if (q.q(str4)) {
                if (this.f10389q == 0) {
                    int i16 = this.f10387o;
                    i10 = -1;
                    if (i16 == -1) {
                        i16 = this.f10385m;
                    }
                    this.f10387o = i16;
                    int i17 = this.f10388p;
                    if (i17 == -1) {
                        i17 = this.f10386n;
                    }
                    this.f10388p = i17;
                } else {
                    i10 = -1;
                }
                float f6 = (this.f10387o == i10 || (i12 = this.f10388p) == i10) ? -1.0f : (this.f10386n * i11) / (this.f10385m * i12);
                s2.b bVar2 = this.f10396x ? new s2.b(this.f10397y, this.A, this.f10398z, d()) : null;
                if (e.f10344g0.containsKey(this.f10373a)) {
                    i10 = ((Integer) e.f10344g0.get(this.f10373a)).intValue();
                }
                if (this.f10390r == 0 && Float.compare(this.f10391s, 0.0f) == 0 && Float.compare(this.f10392t, 0.0f) == 0) {
                    if (Float.compare(this.f10393u, 0.0f) != 0) {
                        if (Float.compare(this.f10392t, 90.0f) == 0) {
                            i14 = 90;
                        } else if (Float.compare(this.f10392t, -180.0f) == 0 || Float.compare(this.f10392t, 180.0f) == 0) {
                            i14 = 180;
                        } else if (Float.compare(this.f10392t, -90.0f) == 0) {
                            i14 = 270;
                        }
                    }
                    bVar.j0(this.f10385m).Q(this.f10386n).a0(f6).d0(i14).b0(this.f10394v).h0(this.f10395w).J(bVar2);
                    i13 = 2;
                }
                i14 = i10;
                bVar.j0(this.f10385m).Q(this.f10386n).a0(f6).d0(i14).b0(this.f10394v).h0(this.f10395w).J(bVar2);
                i13 = 2;
            } else {
                if (!"application/x-subrip".equals(str4)) {
                    if ("text/x-ssa".equals(str4)) {
                        i8 = new ArrayList(2);
                        i8.add(e.f10341d0);
                        i8.add(this.f10383k);
                    } else if (!"application/vobsub".equals(str4) && !"application/pgs".equals(str4) && !"application/dvbsubs".equals(str4)) {
                        throw new f1("Unexpected MIME type.");
                    }
                }
                i13 = 3;
            }
            if (!e.f10344g0.containsKey(this.f10373a)) {
                bVar.U(this.f10373a);
            }
            com.google.android.exoplayer2.s0 E = bVar.R(i6).e0(str4).W(i9).V(this.W).g0(i15).T(i8).I(str).L(this.f10384l).E();
            a0 e6 = kVar.e(this.f10375c, i13);
            this.X = e6;
            e6.e(E);
        }

        public void f() {
            d dVar = this.T;
            if (dVar != null) {
                dVar.a(this);
            }
        }

        public void j() {
            d dVar = this.T;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f10399a = new byte[10];

        /* renamed from: b  reason: collision with root package name */
        private boolean f10400b;

        /* renamed from: c  reason: collision with root package name */
        private int f10401c;

        /* renamed from: d  reason: collision with root package name */
        private long f10402d;

        /* renamed from: e  reason: collision with root package name */
        private int f10403e;

        /* renamed from: f  reason: collision with root package name */
        private int f10404f;

        /* renamed from: g  reason: collision with root package name */
        private int f10405g;

        public void a(c cVar) {
            if (this.f10401c > 0) {
                cVar.X.d(this.f10402d, this.f10403e, this.f10404f, this.f10405g, cVar.f10382j);
                this.f10401c = 0;
            }
        }

        public void b() {
            this.f10400b = false;
            this.f10401c = 0;
        }

        public void c(c cVar, long j6, int i6, int i7, int i8) {
            if (this.f10400b) {
                int i9 = this.f10401c;
                int i10 = i9 + 1;
                this.f10401c = i10;
                if (i9 == 0) {
                    this.f10402d = j6;
                    this.f10403e = i6;
                    this.f10404f = 0;
                }
                this.f10404f += i7;
                this.f10405g = i8;
                if (i10 >= 16) {
                    a(cVar);
                }
            }
        }

        public void d(j jVar) {
            if (this.f10400b) {
                return;
            }
            jVar.n(this.f10399a, 0, 10);
            jVar.g();
            if (com.google.android.exoplayer2.audio.b.i(this.f10399a) == 0) {
                return;
            }
            this.f10400b = true;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        f10344g0 = Collections.unmodifiableMap(hashMap);
    }

    public e() {
        this(0);
    }

    private void A() {
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = 0;
        this.Y = (byte) 0;
        this.Z = false;
        this.f10355j.I(0);
    }

    private long B(long j6) {
        long j7 = this.f10363r;
        if (j7 != -9223372036854775807L) {
            return com.google.android.exoplayer2.util.s0.F0(j6, j7, 1000L);
        }
        throw new f1("Can't scale timecode prior to timecodeScale being set.");
    }

    private static void C(String str, long j6, byte[] bArr) {
        byte[] q5;
        int i6;
        str.hashCode();
        if (str.equals("S_TEXT/ASS")) {
            q5 = q(j6, "%01d:%02d:%02d:%02d", 10000L);
            i6 = 21;
        } else if (!str.equals("S_TEXT/UTF8")) {
            throw new IllegalArgumentException();
        } else {
            q5 = q(j6, "%02d:%02d:%02d,%03d", 1000L);
            i6 = 19;
        }
        System.arraycopy(q5, 0, bArr, i6, q5.length);
    }

    private int F(j jVar, c cVar, int i6) {
        int i7;
        if ("S_TEXT/UTF8".equals(cVar.f10374b)) {
            G(jVar, f10340c0, i6);
        } else if (!"S_TEXT/ASS".equals(cVar.f10374b)) {
            a0 a0Var = cVar.X;
            if (!this.U) {
                if (cVar.f10380h) {
                    this.O &= -1073741825;
                    if (!this.V) {
                        jVar.readFully(this.f10352g.c(), 0, 1);
                        this.R++;
                        if ((this.f10352g.c()[0] & 128) == 128) {
                            throw new f1("Extension bit is set in signal byte");
                        }
                        this.Y = this.f10352g.c()[0];
                        this.V = true;
                    }
                    byte b6 = this.Y;
                    if ((b6 & 1) == 1) {
                        boolean z5 = (b6 & 2) == 2;
                        this.O |= 1073741824;
                        if (!this.Z) {
                            jVar.readFully(this.f10357l.c(), 0, 8);
                            this.R += 8;
                            this.Z = true;
                            this.f10352g.c()[0] = (byte) ((z5 ? 128 : 0) | 8);
                            this.f10352g.M(0);
                            a0Var.f(this.f10352g, 1, 1);
                            this.S++;
                            this.f10357l.M(0);
                            a0Var.f(this.f10357l, 8, 1);
                            this.S += 8;
                        }
                        if (z5) {
                            if (!this.W) {
                                jVar.readFully(this.f10352g.c(), 0, 1);
                                this.R++;
                                this.f10352g.M(0);
                                this.X = this.f10352g.A();
                                this.W = true;
                            }
                            int i8 = this.X * 4;
                            this.f10352g.I(i8);
                            jVar.readFully(this.f10352g.c(), 0, i8);
                            this.R += i8;
                            short s5 = (short) ((this.X / 2) + 1);
                            int i9 = (s5 * 6) + 2;
                            ByteBuffer byteBuffer = this.f10360o;
                            if (byteBuffer == null || byteBuffer.capacity() < i9) {
                                this.f10360o = ByteBuffer.allocate(i9);
                            }
                            this.f10360o.position(0);
                            this.f10360o.putShort(s5);
                            int i10 = 0;
                            int i11 = 0;
                            while (true) {
                                i7 = this.X;
                                if (i10 >= i7) {
                                    break;
                                }
                                int E = this.f10352g.E();
                                if (i10 % 2 == 0) {
                                    this.f10360o.putShort((short) (E - i11));
                                } else {
                                    this.f10360o.putInt(E - i11);
                                }
                                i10++;
                                i11 = E;
                            }
                            int i12 = (i6 - this.R) - i11;
                            int i13 = i7 % 2;
                            ByteBuffer byteBuffer2 = this.f10360o;
                            if (i13 == 1) {
                                byteBuffer2.putInt(i12);
                            } else {
                                byteBuffer2.putShort((short) i12);
                                this.f10360o.putInt(0);
                            }
                            this.f10358m.K(this.f10360o.array(), i9);
                            a0Var.f(this.f10358m, i9, 1);
                            this.S += i9;
                        }
                    }
                } else {
                    byte[] bArr = cVar.f10381i;
                    if (bArr != null) {
                        this.f10355j.K(bArr, bArr.length);
                    }
                }
                if (cVar.f10378f > 0) {
                    this.O |= 268435456;
                    this.f10359n.I(0);
                    this.f10352g.I(4);
                    this.f10352g.c()[0] = (byte) ((i6 >> 24) & 255);
                    this.f10352g.c()[1] = (byte) ((i6 >> 16) & 255);
                    this.f10352g.c()[2] = (byte) ((i6 >> 8) & 255);
                    this.f10352g.c()[3] = (byte) (i6 & 255);
                    a0Var.f(this.f10352g, 4, 2);
                    this.S += 4;
                }
                this.U = true;
            }
            int e6 = i6 + this.f10355j.e();
            if (!"V_MPEG4/ISO/AVC".equals(cVar.f10374b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f10374b)) {
                if (cVar.T != null) {
                    com.google.android.exoplayer2.util.a.g(this.f10355j.e() == 0);
                    cVar.T.d(jVar);
                }
                while (true) {
                    int i14 = this.R;
                    if (i14 >= e6) {
                        break;
                    }
                    int H = H(jVar, a0Var, e6 - i14);
                    this.R += H;
                    this.S += H;
                }
            } else {
                byte[] c6 = this.f10351f.c();
                c6[0] = 0;
                c6[1] = 0;
                c6[2] = 0;
                int i15 = cVar.Y;
                int i16 = 4 - i15;
                while (this.R < e6) {
                    int i17 = this.T;
                    if (i17 == 0) {
                        I(jVar, c6, i16, i15);
                        this.R += i15;
                        this.f10351f.M(0);
                        this.T = this.f10351f.E();
                        this.f10350e.M(0);
                        a0Var.a(this.f10350e, 4);
                        this.S += 4;
                    } else {
                        int H2 = H(jVar, a0Var, i17);
                        this.R += H2;
                        this.S += H2;
                        this.T -= H2;
                    }
                }
            }
            if ("A_VORBIS".equals(cVar.f10374b)) {
                this.f10353h.M(0);
                a0Var.a(this.f10353h, 4);
                this.S += 4;
            }
            return o();
        } else {
            G(jVar, f10342e0, i6);
        }
        return o();
    }

    private void G(j jVar, byte[] bArr, int i6) {
        int length = bArr.length + i6;
        if (this.f10356k.b() < length) {
            this.f10356k.J(Arrays.copyOf(bArr, length + i6));
        } else {
            System.arraycopy(bArr, 0, this.f10356k.c(), 0, bArr.length);
        }
        jVar.readFully(this.f10356k.c(), bArr.length, i6);
        this.f10356k.I(length);
    }

    private int H(j jVar, a0 a0Var, int i6) {
        int a6 = this.f10355j.a();
        if (a6 > 0) {
            int min = Math.min(i6, a6);
            a0Var.a(this.f10355j, min);
            return min;
        }
        return a0Var.b(jVar, i6, false);
    }

    private void I(j jVar, byte[] bArr, int i6, int i7) {
        int min = Math.min(i7, this.f10355j.a());
        jVar.readFully(bArr, i6 + min, i7 - min);
        if (min > 0) {
            this.f10355j.i(bArr, i6, min);
        }
    }

    private x k() {
        com.google.android.exoplayer2.util.o oVar;
        com.google.android.exoplayer2.util.o oVar2;
        int i6;
        if (this.f10362q == -1 || this.f10365t == -9223372036854775807L || (oVar = this.C) == null || oVar.c() == 0 || (oVar2 = this.D) == null || oVar2.c() != this.C.c()) {
            this.C = null;
            this.D = null;
            return new x.b(this.f10365t);
        }
        int c6 = this.C.c();
        int[] iArr = new int[c6];
        long[] jArr = new long[c6];
        long[] jArr2 = new long[c6];
        long[] jArr3 = new long[c6];
        int i7 = 0;
        for (int i8 = 0; i8 < c6; i8++) {
            jArr3[i8] = this.C.b(i8);
            jArr[i8] = this.f10362q + this.D.b(i8);
        }
        while (true) {
            i6 = c6 - 1;
            if (i7 >= i6) {
                break;
            }
            int i9 = i7 + 1;
            iArr[i7] = (int) (jArr[i9] - jArr[i7]);
            jArr2[i7] = jArr3[i9] - jArr3[i7];
            i7 = i9;
        }
        iArr[i6] = (int) ((this.f10362q + this.f10361p) - jArr[i6]);
        long j6 = this.f10365t - jArr3[i6];
        jArr2[i6] = j6;
        if (j6 <= 0) {
            StringBuilder sb = new StringBuilder(72);
            sb.append("Discarding last cue point with unexpected duration: ");
            sb.append(j6);
            com.google.android.exoplayer2.util.n.h("MatroskaExtractor", sb.toString());
            iArr = Arrays.copyOf(iArr, i6);
            jArr = Arrays.copyOf(jArr, i6);
            jArr2 = Arrays.copyOf(jArr2, i6);
            jArr3 = Arrays.copyOf(jArr3, i6);
        }
        this.C = null;
        this.D = null;
        return new c1.d(iArr, jArr, jArr2, jArr3);
    }

    private void l(c cVar, long j6, int i6, int i7, int i8) {
        String str;
        d dVar = cVar.T;
        if (dVar != null) {
            dVar.c(cVar, j6, i6, i7, i8);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f10374b) || "S_TEXT/ASS".equals(cVar.f10374b)) {
                if (this.K > 1) {
                    str = "Skipping subtitle sample in laced block.";
                } else {
                    long j7 = this.I;
                    if (j7 == -9223372036854775807L) {
                        str = "Skipping subtitle sample with no duration.";
                    } else {
                        C(cVar.f10374b, j7, this.f10356k.c());
                        a0 a0Var = cVar.X;
                        y yVar = this.f10356k;
                        a0Var.a(yVar, yVar.e());
                        i7 += this.f10356k.e();
                    }
                }
                com.google.android.exoplayer2.util.n.h("MatroskaExtractor", str);
            }
            if ((268435456 & i6) != 0) {
                if (this.K > 1) {
                    i6 &= -268435457;
                } else {
                    int e6 = this.f10359n.e();
                    cVar.X.f(this.f10359n, e6, 2);
                    i7 += e6;
                }
            }
            cVar.X.d(j6, i6, i7, i8, cVar.f10382j);
        }
        this.F = true;
    }

    private static int[] n(int[] iArr, int i6) {
        return iArr == null ? new int[i6] : iArr.length >= i6 ? iArr : new int[Math.max(iArr.length * 2, i6)];
    }

    private int o() {
        int i6 = this.S;
        A();
        return i6;
    }

    private static byte[] q(long j6, String str, long j7) {
        com.google.android.exoplayer2.util.a.a(j6 != -9223372036854775807L);
        int i6 = (int) (j6 / 3600000000L);
        long j8 = j6 - ((i6 * 3600) * 1000000);
        int i7 = (int) (j8 / 60000000);
        long j9 = j8 - ((i7 * 60) * 1000000);
        int i8 = (int) (j9 / 1000000);
        return com.google.android.exoplayer2.util.s0.h0(String.format(Locale.US, str, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf((int) ((j9 - (i8 * 1000000)) / j7))));
    }

    private static boolean v(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_AV1".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i[] x() {
        return new i[]{new e()};
    }

    private boolean y(w wVar, long j6) {
        if (this.f10370y) {
            this.A = j6;
            wVar.f3247a = this.f10371z;
            this.f10370y = false;
            return true;
        }
        if (this.f10367v) {
            long j7 = this.A;
            if (j7 != -1) {
                wVar.f3247a = j7;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }

    private void z(j jVar, int i6) {
        if (this.f10352g.e() >= i6) {
            return;
        }
        if (this.f10352g.b() < i6) {
            y yVar = this.f10352g;
            yVar.K(Arrays.copyOf(yVar.c(), Math.max(this.f10352g.c().length * 2, i6)), this.f10352g.e());
        }
        jVar.readFully(this.f10352g.c(), this.f10352g.e(), i6 - this.f10352g.e());
        this.f10352g.L(i6);
    }

    protected void D(int i6, long j6, long j7) {
        if (i6 == 160) {
            this.Q = false;
        } else if (i6 == 174) {
            this.f10366u = new c();
        } else if (i6 == 187) {
            this.E = false;
        } else if (i6 == 19899) {
            this.f10368w = -1;
            this.f10369x = -1L;
        } else if (i6 == 20533) {
            this.f10366u.f10380h = true;
        } else if (i6 == 21968) {
            this.f10366u.f10396x = true;
        } else if (i6 == 408125543) {
            long j8 = this.f10362q;
            if (j8 != -1 && j8 != j6) {
                throw new f1("Multiple Segment elements not supported");
            }
            this.f10362q = j6;
            this.f10361p = j7;
        } else if (i6 == 475249515) {
            this.C = new com.google.android.exoplayer2.util.o();
            this.D = new com.google.android.exoplayer2.util.o();
        } else if (i6 == 524531317 && !this.f10367v) {
            if (this.f10349d && this.f10371z != -1) {
                this.f10370y = true;
                return;
            }
            this.f10346a0.r(new x.b(this.f10365t));
            this.f10367v = true;
        }
    }

    protected void E(int i6, String str) {
        if (i6 == 134) {
            this.f10366u.f10374b = str;
        } else if (i6 != 17026) {
            if (i6 == 21358) {
                this.f10366u.f10373a = str;
            } else if (i6 != 2274716) {
            } else {
                this.f10366u.W = str;
            }
        } else if ("webm".equals(str) || "matroska".equals(str)) {
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new f1(sb.toString());
        }
    }

    @Override // c1.i
    public final void a() {
    }

    @Override // c1.i
    public final void c(k kVar) {
        this.f10346a0 = kVar;
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        this.B = -9223372036854775807L;
        this.G = 0;
        this.f10345a.c();
        this.f10347b.e();
        A();
        for (int i6 = 0; i6 < this.f10348c.size(); i6++) {
            ((c) this.f10348c.valueAt(i6)).j();
        }
    }

    @Override // c1.i
    public final int g(j jVar, w wVar) {
        this.F = false;
        boolean z5 = true;
        while (z5 && !this.F) {
            z5 = this.f10345a.b(jVar);
            if (z5 && y(wVar, jVar.p())) {
                return 1;
            }
        }
        if (z5) {
            return 0;
        }
        for (int i6 = 0; i6 < this.f10348c.size(); i6++) {
            ((c) this.f10348c.valueAt(i6)).f();
        }
        return -1;
    }

    @Override // c1.i
    public final boolean h(j jVar) {
        return new f().b(jVar);
    }

    protected void j(int i6, int i7, j jVar) {
        long j6;
        int i8;
        int i9;
        int i10;
        if (i6 != 161 && i6 != 163) {
            if (i6 == 165) {
                if (this.G != 2) {
                    return;
                }
                t((c) this.f10348c.get(this.M), this.P, jVar, i7);
                return;
            } else if (i6 == 16877) {
                s(this.f10366u, jVar, i7);
                return;
            } else if (i6 == 16981) {
                byte[] bArr = new byte[i7];
                this.f10366u.f10381i = bArr;
                jVar.readFully(bArr, 0, i7);
                return;
            } else if (i6 == 18402) {
                byte[] bArr2 = new byte[i7];
                jVar.readFully(bArr2, 0, i7);
                this.f10366u.f10382j = new a0.a(1, bArr2, 0, 0);
                return;
            } else if (i6 == 21419) {
                Arrays.fill(this.f10354i.c(), (byte) 0);
                jVar.readFully(this.f10354i.c(), 4 - i7, i7);
                this.f10354i.M(0);
                this.f10368w = (int) this.f10354i.C();
                return;
            } else if (i6 == 25506) {
                byte[] bArr3 = new byte[i7];
                this.f10366u.f10383k = bArr3;
                jVar.readFully(bArr3, 0, i7);
                return;
            } else if (i6 == 30322) {
                byte[] bArr4 = new byte[i7];
                this.f10366u.f10394v = bArr4;
                jVar.readFully(bArr4, 0, i7);
                return;
            } else {
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unexpected id: ");
                sb.append(i6);
                throw new f1(sb.toString());
            }
        }
        int i11 = 8;
        if (this.G == 0) {
            this.M = (int) this.f10347b.d(jVar, false, true, 8);
            this.N = this.f10347b.b();
            this.I = -9223372036854775807L;
            this.G = 1;
            this.f10352g.I(0);
        }
        c cVar = (c) this.f10348c.get(this.M);
        if (cVar == null) {
            jVar.h(i7 - this.N);
            this.G = 0;
            return;
        }
        if (this.G == 1) {
            z(jVar, 3);
            int i12 = (this.f10352g.c()[2] & 6) >> 1;
            byte b6 = 255;
            if (i12 == 0) {
                this.K = 1;
                int[] n5 = n(this.L, 1);
                this.L = n5;
                n5[0] = (i7 - this.N) - 3;
            } else {
                int i13 = 4;
                z(jVar, 4);
                int i14 = (this.f10352g.c()[3] & 255) + 1;
                this.K = i14;
                int[] n6 = n(this.L, i14);
                this.L = n6;
                if (i12 == 2) {
                    int i15 = this.K;
                    Arrays.fill(n6, 0, i15, ((i7 - this.N) - 4) / i15);
                } else if (i12 != 1) {
                    if (i12 != 3) {
                        StringBuilder sb2 = new StringBuilder(36);
                        sb2.append("Unexpected lacing value: ");
                        sb2.append(i12);
                        throw new f1(sb2.toString());
                    }
                    int i16 = 0;
                    int i17 = 0;
                    while (true) {
                        int i18 = this.K;
                        if (i16 >= i18 - 1) {
                            this.L[i18 - 1] = ((i7 - this.N) - i13) - i17;
                            break;
                        }
                        this.L[i16] = 0;
                        i13++;
                        z(jVar, i13);
                        int i19 = i13 - 1;
                        if (this.f10352g.c()[i19] == 0) {
                            throw new f1("No valid varint length mask found");
                        }
                        int i20 = 0;
                        while (true) {
                            if (i20 >= i11) {
                                j6 = 0;
                                break;
                            }
                            int i21 = 1 << (7 - i20);
                            if ((this.f10352g.c()[i19] & i21) != 0) {
                                int i22 = i13 + i20;
                                z(jVar, i22);
                                j6 = (~i21) & this.f10352g.c()[i19] & b6;
                                int i23 = i19 + 1;
                                while (i23 < i22) {
                                    j6 = (j6 << i11) | (this.f10352g.c()[i23] & b6);
                                    i23++;
                                    i22 = i22;
                                    i11 = 8;
                                    b6 = 255;
                                }
                                int i24 = i22;
                                if (i16 > 0) {
                                    j6 -= (1 << ((i20 * 7) + 6)) - 1;
                                }
                                i13 = i24;
                            } else {
                                i20++;
                                i11 = 8;
                                b6 = 255;
                            }
                        }
                        if (j6 < -2147483648L || j6 > 2147483647L) {
                            break;
                        }
                        int i25 = (int) j6;
                        int[] iArr = this.L;
                        if (i16 != 0) {
                            i25 += iArr[i16 - 1];
                        }
                        iArr[i16] = i25;
                        i17 += i25;
                        i16++;
                        i11 = 8;
                        b6 = 255;
                    }
                    throw new f1("EBML lacing sample size out of range.");
                } else {
                    int i26 = 0;
                    int i27 = 0;
                    while (true) {
                        i8 = this.K;
                        if (i26 >= i8 - 1) {
                            break;
                        }
                        this.L[i26] = 0;
                        do {
                            i13++;
                            z(jVar, i13);
                            i9 = this.f10352g.c()[i13 - 1] & 255;
                            int[] iArr2 = this.L;
                            i10 = iArr2[i26] + i9;
                            iArr2[i26] = i10;
                        } while (i9 == 255);
                        i27 += i10;
                        i26++;
                    }
                    this.L[i8 - 1] = ((i7 - this.N) - i13) - i27;
                }
            }
            this.H = this.B + B((this.f10352g.c()[0] << 8) | (this.f10352g.c()[1] & 255));
            this.O = (cVar.f10376d == 2 || (i6 == 163 && (this.f10352g.c()[2] & 128) == 128)) ? 1 : 0;
            this.G = 2;
            this.J = 0;
        }
        if (i6 == 163) {
            while (true) {
                int i28 = this.J;
                if (i28 >= this.K) {
                    this.G = 0;
                    return;
                } else {
                    l(cVar, ((this.J * cVar.f10377e) / 1000) + this.H, this.O, F(jVar, cVar, this.L[i28]), 0);
                    this.J++;
                }
            }
        } else {
            while (true) {
                int i29 = this.J;
                if (i29 >= this.K) {
                    return;
                }
                int[] iArr3 = this.L;
                iArr3[i29] = F(jVar, cVar, iArr3[i29]);
                this.J++;
            }
        }
    }

    protected void m(int i6) {
        if (i6 == 160) {
            if (this.G != 2) {
                return;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.K; i8++) {
                i7 += this.L[i8];
            }
            c cVar = (c) this.f10348c.get(this.M);
            for (int i9 = 0; i9 < this.K; i9++) {
                long j6 = ((cVar.f10377e * i9) / 1000) + this.H;
                int i10 = this.O;
                if (i9 == 0 && !this.Q) {
                    i10 |= 1;
                }
                int i11 = this.L[i9];
                i7 -= i11;
                l(cVar, j6, i10, i11, i7);
            }
            this.G = 0;
        } else if (i6 == 174) {
            if (v(this.f10366u.f10374b)) {
                c cVar2 = this.f10366u;
                cVar2.e(this.f10346a0, cVar2.f10375c);
                SparseArray sparseArray = this.f10348c;
                c cVar3 = this.f10366u;
                sparseArray.put(cVar3.f10375c, cVar3);
            }
            this.f10366u = null;
        } else if (i6 == 19899) {
            int i12 = this.f10368w;
            if (i12 != -1) {
                long j7 = this.f10369x;
                if (j7 != -1) {
                    if (i12 == 475249515) {
                        this.f10371z = j7;
                        return;
                    }
                    return;
                }
            }
            throw new f1("Mandatory element SeekID or SeekPosition not found");
        } else if (i6 == 25152) {
            c cVar4 = this.f10366u;
            if (cVar4.f10380h) {
                if (cVar4.f10382j == null) {
                    throw new f1("Encrypted Track found but ContentEncKeyID was not found");
                }
                cVar4.f10384l = new com.google.android.exoplayer2.drm.k(new k.b(p.f3948a, "video/webm", this.f10366u.f10382j.f3157b));
            }
        } else if (i6 == 28032) {
            c cVar5 = this.f10366u;
            if (cVar5.f10380h && cVar5.f10381i != null) {
                throw new f1("Combining encryption and compression is not supported");
            }
        } else if (i6 == 357149030) {
            if (this.f10363r == -9223372036854775807L) {
                this.f10363r = 1000000L;
            }
            long j8 = this.f10364s;
            if (j8 != -9223372036854775807L) {
                this.f10365t = B(j8);
            }
        } else if (i6 == 374648427) {
            if (this.f10348c.size() == 0) {
                throw new f1("No valid tracks were found");
            }
            this.f10346a0.g();
        } else if (i6 == 475249515 && !this.f10367v) {
            this.f10346a0.r(k());
            this.f10367v = true;
        }
    }

    protected void p(int i6, double d6) {
        if (i6 == 181) {
            this.f10366u.Q = (int) d6;
        } else if (i6 == 17545) {
            this.f10364s = (long) d6;
        } else {
            switch (i6) {
                case 21969:
                    this.f10366u.D = (float) d6;
                    return;
                case 21970:
                    this.f10366u.E = (float) d6;
                    return;
                case 21971:
                    this.f10366u.F = (float) d6;
                    return;
                case 21972:
                    this.f10366u.G = (float) d6;
                    return;
                case 21973:
                    this.f10366u.H = (float) d6;
                    return;
                case 21974:
                    this.f10366u.I = (float) d6;
                    return;
                case 21975:
                    this.f10366u.J = (float) d6;
                    return;
                case 21976:
                    this.f10366u.K = (float) d6;
                    return;
                case 21977:
                    this.f10366u.L = (float) d6;
                    return;
                case 21978:
                    this.f10366u.M = (float) d6;
                    return;
                default:
                    switch (i6) {
                        case 30323:
                            this.f10366u.f10391s = (float) d6;
                            return;
                        case 30324:
                            this.f10366u.f10392t = (float) d6;
                            return;
                        case 30325:
                            this.f10366u.f10393u = (float) d6;
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    protected int r(int i6) {
        switch (i6) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    protected void s(c cVar, j jVar, int i6) {
        if (cVar.f10379g != 1685485123 && cVar.f10379g != 1685480259) {
            jVar.h(i6);
            return;
        }
        byte[] bArr = new byte[i6];
        cVar.N = bArr;
        jVar.readFully(bArr, 0, i6);
    }

    protected void t(c cVar, int i6, j jVar, int i7) {
        if (i6 != 4 || !"V_VP9".equals(cVar.f10374b)) {
            jVar.h(i7);
            return;
        }
        this.f10359n.I(i7);
        jVar.readFully(this.f10359n.c(), 0, i7);
    }

    protected void u(int i6, long j6) {
        if (i6 == 20529) {
            if (j6 == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(55);
            sb.append("ContentEncodingOrder ");
            sb.append(j6);
            sb.append(" not supported");
            throw new f1(sb.toString());
        } else if (i6 == 20530) {
            if (j6 == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("ContentEncodingScope ");
            sb2.append(j6);
            sb2.append(" not supported");
            throw new f1(sb2.toString());
        } else {
            switch (i6) {
                case 131:
                    this.f10366u.f10376d = (int) j6;
                    return;
                case 136:
                    this.f10366u.V = j6 == 1;
                    return;
                case 155:
                    this.I = B(j6);
                    return;
                case 159:
                    this.f10366u.O = (int) j6;
                    return;
                case 176:
                    this.f10366u.f10385m = (int) j6;
                    return;
                case 179:
                    this.C.a(B(j6));
                    return;
                case 186:
                    this.f10366u.f10386n = (int) j6;
                    return;
                case 215:
                    this.f10366u.f10375c = (int) j6;
                    return;
                case 231:
                    this.B = B(j6);
                    return;
                case 238:
                    this.P = (int) j6;
                    return;
                case 241:
                    if (this.E) {
                        return;
                    }
                    this.D.a(j6);
                    this.E = true;
                    return;
                case 251:
                    this.Q = true;
                    return;
                case 16871:
                    this.f10366u.f10379g = (int) j6;
                    return;
                case 16980:
                    if (j6 == 3) {
                        return;
                    }
                    StringBuilder sb3 = new StringBuilder(50);
                    sb3.append("ContentCompAlgo ");
                    sb3.append(j6);
                    sb3.append(" not supported");
                    throw new f1(sb3.toString());
                case 17029:
                    if (j6 < 1 || j6 > 2) {
                        StringBuilder sb4 = new StringBuilder(53);
                        sb4.append("DocTypeReadVersion ");
                        sb4.append(j6);
                        sb4.append(" not supported");
                        throw new f1(sb4.toString());
                    }
                    return;
                case 17143:
                    if (j6 == 1) {
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder(50);
                    sb5.append("EBMLReadVersion ");
                    sb5.append(j6);
                    sb5.append(" not supported");
                    throw new f1(sb5.toString());
                case 18401:
                    if (j6 == 5) {
                        return;
                    }
                    StringBuilder sb6 = new StringBuilder(49);
                    sb6.append("ContentEncAlgo ");
                    sb6.append(j6);
                    sb6.append(" not supported");
                    throw new f1(sb6.toString());
                case 18408:
                    if (j6 == 1) {
                        return;
                    }
                    StringBuilder sb7 = new StringBuilder(56);
                    sb7.append("AESSettingsCipherMode ");
                    sb7.append(j6);
                    sb7.append(" not supported");
                    throw new f1(sb7.toString());
                case 21420:
                    this.f10369x = j6 + this.f10362q;
                    return;
                case 21432:
                    int i7 = (int) j6;
                    if (i7 == 0) {
                        this.f10366u.f10395w = 0;
                        return;
                    } else if (i7 == 1) {
                        this.f10366u.f10395w = 2;
                        return;
                    } else if (i7 == 3) {
                        this.f10366u.f10395w = 1;
                        return;
                    } else if (i7 != 15) {
                        return;
                    } else {
                        this.f10366u.f10395w = 3;
                        return;
                    }
                case 21680:
                    this.f10366u.f10387o = (int) j6;
                    return;
                case 21682:
                    this.f10366u.f10389q = (int) j6;
                    return;
                case 21690:
                    this.f10366u.f10388p = (int) j6;
                    return;
                case 21930:
                    this.f10366u.U = j6 == 1;
                    return;
                case 21998:
                    this.f10366u.f10378f = (int) j6;
                    return;
                case 22186:
                    this.f10366u.R = j6;
                    return;
                case 22203:
                    this.f10366u.S = j6;
                    return;
                case 25188:
                    this.f10366u.P = (int) j6;
                    return;
                case 30321:
                    int i8 = (int) j6;
                    if (i8 == 0) {
                        this.f10366u.f10390r = 0;
                        return;
                    } else if (i8 == 1) {
                        this.f10366u.f10390r = 1;
                        return;
                    } else if (i8 == 2) {
                        this.f10366u.f10390r = 2;
                        return;
                    } else if (i8 != 3) {
                        return;
                    } else {
                        this.f10366u.f10390r = 3;
                        return;
                    }
                case 2352003:
                    this.f10366u.f10377e = (int) j6;
                    return;
                case 2807729:
                    this.f10363r = j6;
                    return;
                default:
                    switch (i6) {
                        case 21945:
                            int i9 = (int) j6;
                            if (i9 == 1) {
                                this.f10366u.A = 2;
                                return;
                            } else if (i9 != 2) {
                                return;
                            } else {
                                this.f10366u.A = 1;
                                return;
                            }
                        case 21946:
                            int i10 = (int) j6;
                            if (i10 != 1) {
                                if (i10 == 16) {
                                    this.f10366u.f10398z = 6;
                                    return;
                                } else if (i10 == 18) {
                                    this.f10366u.f10398z = 7;
                                    return;
                                } else if (i10 != 6 && i10 != 7) {
                                    return;
                                }
                            }
                            this.f10366u.f10398z = 3;
                            return;
                        case 21947:
                            c cVar = this.f10366u;
                            cVar.f10396x = true;
                            int i11 = (int) j6;
                            if (i11 == 1) {
                                cVar.f10397y = 1;
                                return;
                            } else if (i11 == 9) {
                                cVar.f10397y = 6;
                                return;
                            } else if (i11 == 4 || i11 == 5 || i11 == 6 || i11 == 7) {
                                cVar.f10397y = 2;
                                return;
                            } else {
                                return;
                            }
                        case 21948:
                            this.f10366u.B = (int) j6;
                            return;
                        case 21949:
                            this.f10366u.C = (int) j6;
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    protected boolean w(int i6) {
        return i6 == 357149030 || i6 == 524531317 || i6 == 475249515 || i6 == 374648427;
    }

    public e(int i6) {
        this(new g1.a(), i6);
    }

    e(g1.c cVar, int i6) {
        this.f10362q = -1L;
        this.f10363r = -9223372036854775807L;
        this.f10364s = -9223372036854775807L;
        this.f10365t = -9223372036854775807L;
        this.f10371z = -1L;
        this.A = -1L;
        this.B = -9223372036854775807L;
        this.f10345a = cVar;
        cVar.a(new b());
        this.f10349d = (i6 & 1) == 0;
        this.f10347b = new g();
        this.f10348c = new SparseArray();
        this.f10352g = new y(4);
        this.f10353h = new y(ByteBuffer.allocate(4).putInt(-1).array());
        this.f10354i = new y(4);
        this.f10350e = new y(r.f4652a);
        this.f10351f = new y(4);
        this.f10355j = new y();
        this.f10356k = new y();
        this.f10357l = new y(8);
        this.f10358m = new y();
        this.f10359n = new y();
        this.L = new int[1];
    }
}
