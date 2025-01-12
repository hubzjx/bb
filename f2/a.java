package f2;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.constraintlayout.widget.g;
import b.j;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import e2.b;
import e2.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: h  reason: collision with root package name */
    private final int f9800h;

    /* renamed from: i  reason: collision with root package name */
    private final int f9801i;

    /* renamed from: j  reason: collision with root package name */
    private final int f9802j;

    /* renamed from: k  reason: collision with root package name */
    private final long f9803k;

    /* renamed from: n  reason: collision with root package name */
    private List f9806n;

    /* renamed from: o  reason: collision with root package name */
    private List f9807o;

    /* renamed from: p  reason: collision with root package name */
    private int f9808p;

    /* renamed from: q  reason: collision with root package name */
    private int f9809q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f9810r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f9811s;

    /* renamed from: t  reason: collision with root package name */
    private byte f9812t;

    /* renamed from: u  reason: collision with root package name */
    private byte f9813u;

    /* renamed from: w  reason: collision with root package name */
    private boolean f9815w;

    /* renamed from: x  reason: collision with root package name */
    private long f9816x;

    /* renamed from: y  reason: collision with root package name */
    private static final int[] f9797y = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: z  reason: collision with root package name */
    private static final int[] f9798z = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] A = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, g.T0, g.U0, g.V0, g.W0, 105, g.X0, g.Y0, g.Z0, 109, 110, 111, 112, 113, j.D0, j.E0, j.F0, j.G0, j.H0, j.I0, j.J0, j.K0, j.L0, 231, 247, 209, 241, 9632};
    private static final int[] C = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] D = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] E = {195, 227, 205, 204, 236, 210, 242, 213, 245, j.M0, 125, 92, 94, 95, j.N0, WebSocketProtocol.PAYLOAD_SHORT, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: g  reason: collision with root package name */
    private final y f9799g = new y();

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList f9804l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private C0163a f9805m = new C0163a(0, 4);

    /* renamed from: v  reason: collision with root package name */
    private int f9814v = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0163a {

        /* renamed from: a  reason: collision with root package name */
        private final List f9817a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List f9818b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final StringBuilder f9819c = new StringBuilder();

        /* renamed from: d  reason: collision with root package name */
        private int f9820d;

        /* renamed from: e  reason: collision with root package name */
        private int f9821e;

        /* renamed from: f  reason: collision with root package name */
        private int f9822f;

        /* renamed from: g  reason: collision with root package name */
        private int f9823g;

        /* renamed from: h  reason: collision with root package name */
        private int f9824h;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0164a {

            /* renamed from: a  reason: collision with root package name */
            public final int f9825a;

            /* renamed from: b  reason: collision with root package name */
            public final boolean f9826b;

            /* renamed from: c  reason: collision with root package name */
            public int f9827c;

            public C0164a(int i6, boolean z5, int i7) {
                this.f9825a = i6;
                this.f9826b = z5;
                this.f9827c = i7;
            }
        }

        public C0163a(int i6, int i7) {
            j(i6);
            this.f9824h = i7;
        }

        private SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f9819c);
            int length = spannableStringBuilder.length();
            int i6 = 0;
            int i7 = -1;
            int i8 = -1;
            int i9 = 0;
            int i10 = -1;
            int i11 = -1;
            boolean z5 = false;
            while (i6 < this.f9817a.size()) {
                C0164a c0164a = (C0164a) this.f9817a.get(i6);
                boolean z6 = c0164a.f9826b;
                int i12 = c0164a.f9825a;
                if (i12 != 8) {
                    boolean z7 = i12 == 7;
                    if (i12 != 7) {
                        i11 = a.A[i12];
                    }
                    z5 = z7;
                }
                int i13 = c0164a.f9827c;
                i6++;
                if (i13 != (i6 < this.f9817a.size() ? ((C0164a) this.f9817a.get(i6)).f9827c : length)) {
                    if (i7 != -1 && !z6) {
                        q(spannableStringBuilder, i7, i13);
                        i7 = -1;
                    } else if (i7 == -1 && z6) {
                        i7 = i13;
                    }
                    if (i8 != -1 && !z5) {
                        o(spannableStringBuilder, i8, i13);
                        i8 = -1;
                    } else if (i8 == -1 && z5) {
                        i8 = i13;
                    }
                    if (i11 != i10) {
                        n(spannableStringBuilder, i9, i13, i10);
                        i10 = i11;
                        i9 = i13;
                    }
                }
            }
            if (i7 != -1 && i7 != length) {
                q(spannableStringBuilder, i7, length);
            }
            if (i8 != -1 && i8 != length) {
                o(spannableStringBuilder, i8, length);
            }
            if (i9 != length) {
                n(spannableStringBuilder, i9, length, i10);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void n(SpannableStringBuilder spannableStringBuilder, int i6, int i7, int i8) {
            if (i8 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i8), i6, i7, 33);
        }

        private static void o(SpannableStringBuilder spannableStringBuilder, int i6, int i7) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i6, i7, 33);
        }

        private static void q(SpannableStringBuilder spannableStringBuilder, int i6, int i7) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i6, i7, 33);
        }

        public void e(char c6) {
            if (this.f9819c.length() < 32) {
                this.f9819c.append(c6);
            }
        }

        public void f() {
            int length = this.f9819c.length();
            if (length > 0) {
                this.f9819c.delete(length - 1, length);
                for (int size = this.f9817a.size() - 1; size >= 0; size--) {
                    C0164a c0164a = (C0164a) this.f9817a.get(size);
                    int i6 = c0164a.f9827c;
                    if (i6 != length) {
                        return;
                    }
                    c0164a.f9827c = i6 - 1;
                }
            }
        }

        public e2.b g(int i6) {
            float f6;
            int i7 = this.f9821e + this.f9822f;
            int i8 = 32 - i7;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i9 = 0; i9 < this.f9818b.size(); i9++) {
                spannableStringBuilder.append(s0.V0((CharSequence) this.f9818b.get(i9), i8));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(s0.V0(h(), i8));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i8 - spannableStringBuilder.length();
            int i10 = i7 - length;
            if (i6 == Integer.MIN_VALUE) {
                i6 = (this.f9823g != 2 || (Math.abs(i10) >= 3 && length >= 0)) ? (this.f9823g != 2 || i10 <= 0) ? 0 : 2 : 1;
            }
            if (i6 != 1) {
                if (i6 == 2) {
                    i7 = 32 - length;
                }
                f6 = ((i7 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f6 = 0.5f;
            }
            int i11 = this.f9820d;
            if (i11 > 7) {
                i11 = (i11 - 15) - 2;
            } else if (this.f9823g == 1) {
                i11 -= this.f9824h - 1;
            }
            return new b.C0159b().m(spannableStringBuilder).n(Layout.Alignment.ALIGN_NORMAL).h(i11, 1).j(f6).k(i6).a();
        }

        public boolean i() {
            return this.f9817a.isEmpty() && this.f9818b.isEmpty() && this.f9819c.length() == 0;
        }

        public void j(int i6) {
            this.f9823g = i6;
            this.f9817a.clear();
            this.f9818b.clear();
            this.f9819c.setLength(0);
            this.f9820d = 15;
            this.f9821e = 0;
            this.f9822f = 0;
        }

        public void k() {
            this.f9818b.add(h());
            this.f9819c.setLength(0);
            this.f9817a.clear();
            int min = Math.min(this.f9824h, this.f9820d);
            while (this.f9818b.size() >= min) {
                this.f9818b.remove(0);
            }
        }

        public void l(int i6) {
            this.f9823g = i6;
        }

        public void m(int i6) {
            this.f9824h = i6;
        }

        public void p(int i6, boolean z5) {
            this.f9817a.add(new C0164a(i6, z5, this.f9819c.length()));
        }
    }

    public a(String str, int i6, long j6) {
        this.f9803k = j6 > 0 ? j6 * 1000 : -9223372036854775807L;
        this.f9800h = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i6 != 1) {
            if (i6 == 2) {
                this.f9802j = 1;
                this.f9801i = 0;
                N(0);
                M();
                this.f9815w = true;
                this.f9816x = -9223372036854775807L;
            }
            if (i6 == 3) {
                this.f9802j = 0;
            } else if (i6 != 4) {
                n.h("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            } else {
                this.f9802j = 1;
            }
            this.f9801i = 1;
            N(0);
            M();
            this.f9815w = true;
            this.f9816x = -9223372036854775807L;
        }
        this.f9802j = 0;
        this.f9801i = 0;
        N(0);
        M();
        this.f9815w = true;
        this.f9816x = -9223372036854775807L;
    }

    private static boolean A(byte b6) {
        return (b6 & 224) == 0;
    }

    private static boolean B(byte b6, byte b7) {
        return (b6 & 246) == 18 && (b7 & 224) == 32;
    }

    private static boolean C(byte b6, byte b7) {
        return (b6 & 247) == 17 && (b7 & 240) == 32;
    }

    private static boolean D(byte b6, byte b7) {
        return (b6 & 246) == 20 && (b7 & 240) == 32;
    }

    private static boolean E(byte b6, byte b7) {
        return (b6 & 240) == 16 && (b7 & 192) == 64;
    }

    private static boolean F(byte b6) {
        return (b6 & 240) == 16;
    }

    private boolean G(boolean z5, byte b6, byte b7) {
        if (!z5 || !F(b6)) {
            this.f9811s = false;
        } else if (this.f9811s && this.f9812t == b6 && this.f9813u == b7) {
            this.f9811s = false;
            return true;
        } else {
            this.f9811s = true;
            this.f9812t = b6;
            this.f9813u = b7;
        }
        return false;
    }

    private static boolean H(byte b6) {
        return (b6 & 247) == 20;
    }

    private static boolean I(byte b6, byte b7) {
        return (b6 & 247) == 17 && (b7 & 240) == 48;
    }

    private static boolean J(byte b6, byte b7) {
        return (b6 & 247) == 23 && b7 >= 33 && b7 <= 35;
    }

    private static boolean K(byte b6) {
        return 1 <= b6 && b6 <= 15;
    }

    private void L(byte b6, byte b7) {
        if (!K(b6)) {
            if (H(b6)) {
                if (b7 != 32 && b7 != 47) {
                    switch (b7) {
                        case 37:
                        case 38:
                        case 39:
                            break;
                        default:
                            switch (b7) {
                                case 41:
                                    break;
                                case 42:
                                case 43:
                                    break;
                                default:
                                    return;
                            }
                    }
                }
                this.f9815w = true;
                return;
            }
            return;
        }
        this.f9815w = false;
    }

    private void M() {
        this.f9805m.j(this.f9808p);
        this.f9804l.clear();
        this.f9804l.add(this.f9805m);
    }

    private void N(int i6) {
        int i7 = this.f9808p;
        if (i7 == i6) {
            return;
        }
        this.f9808p = i6;
        if (i6 == 3) {
            for (int i8 = 0; i8 < this.f9804l.size(); i8++) {
                ((C0163a) this.f9804l.get(i8)).l(i6);
            }
            return;
        }
        M();
        if (i7 == 3 || i6 == 1 || i6 == 0) {
            this.f9806n = Collections.emptyList();
        }
    }

    private void O(int i6) {
        this.f9809q = i6;
        this.f9805m.m(i6);
    }

    private boolean P() {
        return (this.f9803k == -9223372036854775807L || this.f9816x == -9223372036854775807L || k() - this.f9816x < this.f9803k) ? false : true;
    }

    private boolean Q(byte b6) {
        if (A(b6)) {
            this.f9814v = r(b6);
        }
        return this.f9814v == this.f9802j;
    }

    private static char q(byte b6) {
        return (char) B[(b6 & Byte.MAX_VALUE) - 32];
    }

    private static int r(byte b6) {
        return (b6 >> 3) & 1;
    }

    private List s() {
        int size = this.f9804l.size();
        ArrayList arrayList = new ArrayList(size);
        int i6 = 2;
        for (int i7 = 0; i7 < size; i7++) {
            e2.b g6 = ((C0163a) this.f9804l.get(i7)).g(Integer.MIN_VALUE);
            arrayList.add(g6);
            if (g6 != null) {
                i6 = Math.min(i6, g6.f9443h);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i8 = 0; i8 < size; i8++) {
            e2.b bVar = (e2.b) arrayList.get(i8);
            if (bVar != null) {
                if (bVar.f9443h != i6) {
                    bVar = (e2.b) com.google.android.exoplayer2.util.a.e(((C0163a) this.f9804l.get(i8)).g(i6));
                }
                arrayList2.add(bVar);
            }
        }
        return arrayList2;
    }

    private static char t(byte b6) {
        return (char) D[b6 & 31];
    }

    private static char u(byte b6) {
        return (char) E[b6 & 31];
    }

    private static char v(byte b6, byte b7) {
        return (b6 & 1) == 0 ? t(b7) : u(b7);
    }

    private static char w(byte b6) {
        return (char) C[b6 & 15];
    }

    private void x(byte b6) {
        this.f9805m.e(' ');
        this.f9805m.p((b6 >> 1) & 7, (b6 & 1) == 1);
    }

    private void y(byte b6) {
        if (b6 == 32) {
            N(2);
        } else if (b6 == 41) {
            N(3);
        } else {
            switch (b6) {
                case 37:
                    N(1);
                    O(2);
                    return;
                case 38:
                    N(1);
                    O(3);
                    return;
                case 39:
                    N(1);
                    O(4);
                    return;
                default:
                    int i6 = this.f9808p;
                    if (i6 == 0) {
                        return;
                    }
                    if (b6 == 33) {
                        this.f9805m.f();
                        return;
                    }
                    switch (b6) {
                        case 44:
                            this.f9806n = Collections.emptyList();
                            int i7 = this.f9808p;
                            if (i7 != 1 && i7 != 3) {
                                return;
                            }
                            break;
                        case 45:
                            if (i6 != 1 || this.f9805m.i()) {
                                return;
                            }
                            this.f9805m.k();
                            return;
                        case 46:
                            break;
                        case 47:
                            this.f9806n = s();
                            break;
                        default:
                            return;
                    }
                    M();
                    return;
            }
        }
    }

    private void z(byte b6, byte b7) {
        int i6 = f9797y[b6 & 7];
        if ((b7 & 32) != 0) {
            i6++;
        }
        if (i6 != this.f9805m.f9820d) {
            if (this.f9808p != 1 && !this.f9805m.i()) {
                C0163a c0163a = new C0163a(this.f9808p, this.f9809q);
                this.f9805m = c0163a;
                this.f9804l.add(c0163a);
            }
            this.f9805m.f9820d = i6;
        }
        boolean z5 = (b7 & 16) == 16;
        boolean z6 = (b7 & 1) == 1;
        int i7 = (b7 >> 1) & 7;
        this.f9805m.p(z5 ? 8 : i7, z6);
        if (z5) {
            this.f9805m.f9821e = f9798z[i7];
        }
    }

    @Override // f2.e, com.google.android.exoplayer2.decoder.g
    public void a() {
    }

    @Override // f2.e, e2.g
    public /* bridge */ /* synthetic */ void b(long j6) {
        super.b(j6);
    }

    @Override // f2.e
    protected e2.f f() {
        List list = this.f9806n;
        this.f9807o = list;
        return new f((List) com.google.android.exoplayer2.util.a.e(list));
    }

    @Override // f2.e, com.google.android.exoplayer2.decoder.g
    public void flush() {
        super.flush();
        this.f9806n = null;
        this.f9807o = null;
        N(0);
        O(4);
        M();
        this.f9810r = false;
        this.f9811s = false;
        this.f9812t = (byte) 0;
        this.f9813u = (byte) 0;
        this.f9814v = 0;
        this.f9815w = true;
        this.f9816x = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0017 A[SYNTHETIC] */
    @Override // f2.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void g(e2.j jVar) {
        boolean z5;
        C0163a c0163a;
        char q5;
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(jVar.f3600b);
        this.f9799g.K(byteBuffer.array(), byteBuffer.limit());
        boolean z6 = false;
        while (true) {
            int a6 = this.f9799g.a();
            int i6 = this.f9800h;
            if (a6 < i6) {
                break;
            }
            byte A2 = i6 == 2 ? (byte) -4 : (byte) this.f9799g.A();
            int A3 = this.f9799g.A();
            int A4 = this.f9799g.A();
            if ((A2 & 2) == 0 && (A2 & 1) == this.f9801i) {
                byte b6 = (byte) (A3 & 127);
                byte b7 = (byte) (A4 & 127);
                if (b6 != 0 || b7 != 0) {
                    boolean z7 = this.f9810r;
                    if ((A2 & 4) == 4) {
                        boolean[] zArr = F;
                        if (zArr[A3] && zArr[A4]) {
                            z5 = true;
                            this.f9810r = z5;
                            if (!G(z5, b6, b7)) {
                                if (this.f9810r) {
                                    L(b6, b7);
                                    if (this.f9815w && Q(b6)) {
                                        if (A(b6)) {
                                            if (I(b6, b7)) {
                                                c0163a = this.f9805m;
                                                q5 = w(b7);
                                            } else if (B(b6, b7)) {
                                                this.f9805m.f();
                                                c0163a = this.f9805m;
                                                q5 = v(b6, b7);
                                            } else {
                                                if (C(b6, b7)) {
                                                    x(b7);
                                                } else if (E(b6, b7)) {
                                                    z(b6, b7);
                                                } else if (J(b6, b7)) {
                                                    this.f9805m.f9822f = b7 - 32;
                                                } else if (D(b6, b7)) {
                                                    y(b7);
                                                }
                                                z6 = true;
                                            }
                                            c0163a.e(q5);
                                            z6 = true;
                                        } else {
                                            this.f9805m.e(q(b6));
                                            if ((b7 & 224) != 0) {
                                                c0163a = this.f9805m;
                                                q5 = q(b7);
                                                c0163a.e(q5);
                                            }
                                            z6 = true;
                                        }
                                    }
                                } else if (z7) {
                                    M();
                                    z6 = true;
                                }
                            }
                        }
                    }
                    z5 = false;
                    this.f9810r = z5;
                    if (!G(z5, b6, b7)) {
                    }
                }
            }
        }
        if (z6) {
            int i7 = this.f9808p;
            if (i7 == 1 || i7 == 3) {
                this.f9806n = s();
                this.f9816x = k();
            }
        }
    }

    @Override // f2.e
    public /* bridge */ /* synthetic */ e2.j h() {
        return super.e();
    }

    @Override // f2.e, com.google.android.exoplayer2.decoder.g
    /* renamed from: i */
    public k d() {
        k j6;
        k d6 = super.d();
        if (d6 != null) {
            return d6;
        }
        if (!P() || (j6 = j()) == null) {
            return null;
        }
        this.f9806n = Collections.emptyList();
        this.f9816x = -9223372036854775807L;
        j6.e(k(), f(), Long.MAX_VALUE);
        return j6;
    }

    @Override // f2.e
    protected boolean l() {
        return this.f9806n != this.f9807o;
    }

    @Override // f2.e
    public /* bridge */ /* synthetic */ void m(e2.j jVar) {
        super.c(jVar);
    }
}
