package f2;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import b.j;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.x;
import com.google.android.exoplayer2.util.y;
import e2.b;
import e2.k;
import f2.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;
/* loaded from: classes.dex */
public final class c extends e {

    /* renamed from: g  reason: collision with root package name */
    private final y f9828g = new y();

    /* renamed from: h  reason: collision with root package name */
    private final x f9829h = new x();

    /* renamed from: i  reason: collision with root package name */
    private final boolean f9830i;

    /* renamed from: j  reason: collision with root package name */
    private final int f9831j;

    /* renamed from: k  reason: collision with root package name */
    private final b[] f9832k;

    /* renamed from: l  reason: collision with root package name */
    private b f9833l;

    /* renamed from: m  reason: collision with root package name */
    private List f9834m;

    /* renamed from: n  reason: collision with root package name */
    private List f9835n;

    /* renamed from: o  reason: collision with root package name */
    private C0165c f9836o;

    /* renamed from: p  reason: collision with root package name */
    private int f9837p;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final e2.b f9838a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9839b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f6, int i6, int i7, float f7, int i8, float f8, boolean z5, int i9, int i10) {
            b.C0159b l6 = new b.C0159b().m(charSequence).n(alignment).h(f6, i6).i(i7).j(f7).k(i8).l(f8);
            if (z5) {
                l6.q(i9);
            }
            this.f9838a = l6.a();
            this.f9839b = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {
        private static final int[] A;
        private static final int[] B;
        private static final boolean[] C;
        private static final int[] D;
        private static final int[] E;
        private static final int[] F;
        private static final int[] G;

        /* renamed from: w  reason: collision with root package name */
        public static final int f9840w = h(2, 2, 2, 0);

        /* renamed from: x  reason: collision with root package name */
        public static final int f9841x;

        /* renamed from: y  reason: collision with root package name */
        public static final int f9842y;

        /* renamed from: z  reason: collision with root package name */
        private static final int[] f9843z;

        /* renamed from: a  reason: collision with root package name */
        private final List f9844a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final SpannableStringBuilder f9845b = new SpannableStringBuilder();

        /* renamed from: c  reason: collision with root package name */
        private boolean f9846c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9847d;

        /* renamed from: e  reason: collision with root package name */
        private int f9848e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f9849f;

        /* renamed from: g  reason: collision with root package name */
        private int f9850g;

        /* renamed from: h  reason: collision with root package name */
        private int f9851h;

        /* renamed from: i  reason: collision with root package name */
        private int f9852i;

        /* renamed from: j  reason: collision with root package name */
        private int f9853j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f9854k;

        /* renamed from: l  reason: collision with root package name */
        private int f9855l;

        /* renamed from: m  reason: collision with root package name */
        private int f9856m;

        /* renamed from: n  reason: collision with root package name */
        private int f9857n;

        /* renamed from: o  reason: collision with root package name */
        private int f9858o;

        /* renamed from: p  reason: collision with root package name */
        private int f9859p;

        /* renamed from: q  reason: collision with root package name */
        private int f9860q;

        /* renamed from: r  reason: collision with root package name */
        private int f9861r;

        /* renamed from: s  reason: collision with root package name */
        private int f9862s;

        /* renamed from: t  reason: collision with root package name */
        private int f9863t;

        /* renamed from: u  reason: collision with root package name */
        private int f9864u;

        /* renamed from: v  reason: collision with root package name */
        private int f9865v;

        static {
            int h6 = h(0, 0, 0, 0);
            f9841x = h6;
            int h7 = h(0, 0, 0, 3);
            f9842y = h7;
            f9843z = new int[]{0, 0, 0, 0, 0, 2, 0};
            A = new int[]{0, 0, 0, 0, 0, 0, 2};
            B = new int[]{3, 3, 3, 3, 3, 3, 1};
            C = new boolean[]{false, false, false, true, true, true, false};
            D = new int[]{h6, h7, h6, h6, h7, h6, h6};
            E = new int[]{0, 1, 2, 3, 4, 3, 4};
            F = new int[]{0, 0, 0, 0, 0, 3, 3};
            G = new int[]{h6, h6, h6, h6, h6, h7, h7};
        }

        public b() {
            l();
        }

        public static int g(int i6, int i7, int i8) {
            return h(i6, i7, i8, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int h(int i6, int i7, int i8, int i9) {
            int i10;
            com.google.android.exoplayer2.util.a.c(i6, 0, 4);
            com.google.android.exoplayer2.util.a.c(i7, 0, 4);
            com.google.android.exoplayer2.util.a.c(i8, 0, 4);
            com.google.android.exoplayer2.util.a.c(i9, 0, 4);
            if (i9 != 0 && i9 != 1) {
                if (i9 == 2) {
                    i10 = 127;
                } else if (i9 == 3) {
                    i10 = 0;
                }
                return Color.argb(i10, i6 <= 1 ? 255 : 0, i7 <= 1 ? 255 : 0, i8 > 1 ? 255 : 0);
            }
            i10 = 255;
            return Color.argb(i10, i6 <= 1 ? 255 : 0, i7 <= 1 ? 255 : 0, i8 > 1 ? 255 : 0);
        }

        public void a(char c6) {
            if (c6 != '\n') {
                this.f9845b.append(c6);
                return;
            }
            this.f9844a.add(d());
            this.f9845b.clear();
            if (this.f9859p != -1) {
                this.f9859p = 0;
            }
            if (this.f9860q != -1) {
                this.f9860q = 0;
            }
            if (this.f9861r != -1) {
                this.f9861r = 0;
            }
            if (this.f9863t != -1) {
                this.f9863t = 0;
            }
            while (true) {
                if ((!this.f9854k || this.f9844a.size() < this.f9853j) && this.f9844a.size() < 15) {
                    return;
                }
                this.f9844a.remove(0);
            }
        }

        public void b() {
            int length = this.f9845b.length();
            if (length > 0) {
                this.f9845b.delete(length - 1, length);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a c() {
            Layout.Alignment alignment;
            float f6;
            float f7;
            if (j()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i6 = 0; i6 < this.f9844a.size(); i6++) {
                spannableStringBuilder.append((CharSequence) this.f9844a.get(i6));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) d());
            int i7 = this.f9855l;
            if (i7 != 0) {
                if (i7 == 1) {
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                } else if (i7 == 2) {
                    alignment = Layout.Alignment.ALIGN_CENTER;
                } else if (i7 != 3) {
                    int i8 = this.f9855l;
                    StringBuilder sb = new StringBuilder(43);
                    sb.append("Unexpected justification value: ");
                    sb.append(i8);
                    throw new IllegalArgumentException(sb.toString());
                }
                Layout.Alignment alignment2 = alignment;
                if (this.f9849f) {
                    f6 = this.f9851h / 209.0f;
                    f7 = this.f9850g / 74.0f;
                } else {
                    f6 = this.f9851h / 99.0f;
                    f7 = this.f9850g / 99.0f;
                }
                float f8 = (f6 * 0.9f) + 0.05f;
                float f9 = (f7 * 0.9f) + 0.05f;
                int i9 = this.f9852i;
                int i10 = i9 % 3 != 0 ? 0 : i9 % 3 == 1 ? 1 : 2;
                int i11 = i9 / 3 != 0 ? 0 : i9 / 3 == 1 ? 1 : 2;
                int i12 = this.f9858o;
                return new a(spannableStringBuilder, alignment2, f9, 0, i10, f8, i11, -3.4028235E38f, i12 != f9841x, i12, this.f9848e);
            }
            alignment = Layout.Alignment.ALIGN_NORMAL;
            Layout.Alignment alignment22 = alignment;
            if (this.f9849f) {
            }
            float f82 = (f6 * 0.9f) + 0.05f;
            float f92 = (f7 * 0.9f) + 0.05f;
            int i92 = this.f9852i;
            if (i92 % 3 != 0) {
            }
            if (i92 / 3 != 0) {
            }
            int i122 = this.f9858o;
            return new a(spannableStringBuilder, alignment22, f92, 0, i10, f82, i11, -3.4028235E38f, i122 != f9841x, i122, this.f9848e);
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f9845b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f9859p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f9859p, length, 33);
                }
                if (this.f9860q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f9860q, length, 33);
                }
                if (this.f9861r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f9862s), this.f9861r, length, 33);
                }
                if (this.f9863t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f9864u), this.f9863t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f9844a.clear();
            this.f9845b.clear();
            this.f9859p = -1;
            this.f9860q = -1;
            this.f9861r = -1;
            this.f9863t = -1;
            this.f9865v = 0;
        }

        public void f(boolean z5, boolean z6, boolean z7, int i6, boolean z8, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
            this.f9846c = true;
            this.f9847d = z5;
            this.f9854k = z6;
            this.f9848e = i6;
            this.f9849f = z8;
            this.f9850g = i7;
            this.f9851h = i8;
            this.f9852i = i11;
            int i14 = i9 + 1;
            if (this.f9853j != i14) {
                this.f9853j = i14;
                while (true) {
                    if ((!z6 || this.f9844a.size() < this.f9853j) && this.f9844a.size() < 15) {
                        break;
                    }
                    this.f9844a.remove(0);
                }
            }
            if (i12 != 0 && this.f9856m != i12) {
                this.f9856m = i12;
                int i15 = i12 - 1;
                q(D[i15], f9842y, C[i15], 0, A[i15], B[i15], f9843z[i15]);
            }
            if (i13 == 0 || this.f9857n == i13) {
                return;
            }
            this.f9857n = i13;
            int i16 = i13 - 1;
            m(0, 1, 1, false, false, F[i16], E[i16]);
            n(f9840w, G[i16], f9841x);
        }

        public boolean i() {
            return this.f9846c;
        }

        public boolean j() {
            return !i() || (this.f9844a.isEmpty() && this.f9845b.length() == 0);
        }

        public boolean k() {
            return this.f9847d;
        }

        public void l() {
            e();
            this.f9846c = false;
            this.f9847d = false;
            this.f9848e = 4;
            this.f9849f = false;
            this.f9850g = 0;
            this.f9851h = 0;
            this.f9852i = 0;
            this.f9853j = 15;
            this.f9854k = true;
            this.f9855l = 0;
            this.f9856m = 0;
            this.f9857n = 0;
            int i6 = f9841x;
            this.f9858o = i6;
            this.f9862s = f9840w;
            this.f9864u = i6;
        }

        public void m(int i6, int i7, int i8, boolean z5, boolean z6, int i9, int i10) {
            if (this.f9859p != -1) {
                if (!z5) {
                    this.f9845b.setSpan(new StyleSpan(2), this.f9859p, this.f9845b.length(), 33);
                    this.f9859p = -1;
                }
            } else if (z5) {
                this.f9859p = this.f9845b.length();
            }
            if (this.f9860q == -1) {
                if (z6) {
                    this.f9860q = this.f9845b.length();
                }
            } else if (z6) {
            } else {
                this.f9845b.setSpan(new UnderlineSpan(), this.f9860q, this.f9845b.length(), 33);
                this.f9860q = -1;
            }
        }

        public void n(int i6, int i7, int i8) {
            if (this.f9861r != -1 && this.f9862s != i6) {
                this.f9845b.setSpan(new ForegroundColorSpan(this.f9862s), this.f9861r, this.f9845b.length(), 33);
            }
            if (i6 != f9840w) {
                this.f9861r = this.f9845b.length();
                this.f9862s = i6;
            }
            if (this.f9863t != -1 && this.f9864u != i7) {
                this.f9845b.setSpan(new BackgroundColorSpan(this.f9864u), this.f9863t, this.f9845b.length(), 33);
            }
            if (i7 != f9841x) {
                this.f9863t = this.f9845b.length();
                this.f9864u = i7;
            }
        }

        public void o(int i6, int i7) {
            if (this.f9865v != i6) {
                a('\n');
            }
            this.f9865v = i6;
        }

        public void p(boolean z5) {
            this.f9847d = z5;
        }

        public void q(int i6, int i7, boolean z5, int i8, int i9, int i10, int i11) {
            this.f9858o = i6;
            this.f9855l = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f2.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0165c {

        /* renamed from: a  reason: collision with root package name */
        public final int f9866a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9867b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f9868c;

        /* renamed from: d  reason: collision with root package name */
        int f9869d = 0;

        public C0165c(int i6, int i7) {
            this.f9866a = i6;
            this.f9867b = i7;
            this.f9868c = new byte[(i7 * 2) - 1];
        }
    }

    public c(int i6, List list) {
        boolean z5 = true;
        this.f9831j = i6 == -1 ? 1 : i6;
        this.f9830i = (list == null || !com.google.android.exoplayer2.util.d.g(list)) ? false : false;
        this.f9832k = new b[8];
        for (int i7 = 0; i7 < 8; i7++) {
            this.f9832k[i7] = new b();
        }
        this.f9833l = this.f9832k[0];
    }

    private void A(int i6) {
        b bVar;
        char c6;
        if (i6 == 160) {
            bVar = this.f9833l;
            c6 = 13252;
        } else {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Invalid G3 character: ");
            sb.append(i6);
            n.h("Cea708Decoder", sb.toString());
            bVar = this.f9833l;
            c6 = '_';
        }
        bVar.a(c6);
    }

    private void B() {
        this.f9833l.m(this.f9829h.h(4), this.f9829h.h(2), this.f9829h.h(2), this.f9829h.g(), this.f9829h.g(), this.f9829h.h(3), this.f9829h.h(3));
    }

    private void C() {
        int h6 = b.h(this.f9829h.h(2), this.f9829h.h(2), this.f9829h.h(2), this.f9829h.h(2));
        int h7 = b.h(this.f9829h.h(2), this.f9829h.h(2), this.f9829h.h(2), this.f9829h.h(2));
        this.f9829h.r(2);
        this.f9833l.n(h6, h7, b.g(this.f9829h.h(2), this.f9829h.h(2), this.f9829h.h(2)));
    }

    private void D() {
        this.f9829h.r(4);
        int h6 = this.f9829h.h(4);
        this.f9829h.r(2);
        this.f9833l.o(h6, this.f9829h.h(6));
    }

    private void E() {
        int h6 = b.h(this.f9829h.h(2), this.f9829h.h(2), this.f9829h.h(2), this.f9829h.h(2));
        int h7 = this.f9829h.h(2);
        int g6 = b.g(this.f9829h.h(2), this.f9829h.h(2), this.f9829h.h(2));
        if (this.f9829h.g()) {
            h7 |= 4;
        }
        boolean g7 = this.f9829h.g();
        int h8 = this.f9829h.h(2);
        int h9 = this.f9829h.h(2);
        int h10 = this.f9829h.h(2);
        this.f9829h.r(8);
        this.f9833l.q(h6, g6, g7, h7, h8, h9, h10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int F(a aVar, a aVar2) {
        return Integer.compare(aVar.f9839b, aVar2.f9839b);
    }

    private void G() {
        StringBuilder sb;
        String str;
        C0165c c0165c = this.f9836o;
        int i6 = c0165c.f9869d;
        int i7 = c0165c.f9867b;
        if (i6 != (i7 * 2) - 1) {
            int i8 = c0165c.f9866a;
            StringBuilder sb2 = new StringBuilder(131);
            sb2.append("DtvCcPacket ended prematurely; size is ");
            sb2.append((i7 * 2) - 1);
            sb2.append(", but current index is ");
            sb2.append(i6);
            sb2.append(" (sequence number ");
            sb2.append(i8);
            sb2.append("); ignoring packet");
            n.h("Cea708Decoder", sb2.toString());
            return;
        }
        this.f9829h.o(c0165c.f9868c, i6);
        int h6 = this.f9829h.h(3);
        int h7 = this.f9829h.h(5);
        if (h6 == 7) {
            this.f9829h.r(2);
            h6 = this.f9829h.h(6);
            if (h6 < 7) {
                StringBuilder sb3 = new StringBuilder(44);
                sb3.append("Invalid extended service number: ");
                sb3.append(h6);
                n.h("Cea708Decoder", sb3.toString());
            }
        }
        if (h7 == 0) {
            if (h6 != 0) {
                StringBuilder sb4 = new StringBuilder(59);
                sb4.append("serviceNumber is non-zero (");
                sb4.append(h6);
                sb4.append(") when blockSize is 0");
                n.h("Cea708Decoder", sb4.toString());
            }
        } else if (h6 != this.f9831j) {
        } else {
            boolean z5 = false;
            while (this.f9829h.b() > 0) {
                int h8 = this.f9829h.h(8);
                if (h8 == 16) {
                    h8 = this.f9829h.h(8);
                    if (h8 <= 31) {
                        u(h8);
                    } else {
                        if (h8 <= 127) {
                            z(h8);
                        } else if (h8 <= 159) {
                            v(h8);
                        } else if (h8 <= 255) {
                            A(h8);
                        } else {
                            sb = new StringBuilder(37);
                            str = "Invalid extended command: ";
                            sb.append(str);
                            sb.append(h8);
                            n.h("Cea708Decoder", sb.toString());
                        }
                        z5 = true;
                    }
                } else if (h8 <= 31) {
                    s(h8);
                } else {
                    if (h8 <= 127) {
                        x(h8);
                    } else if (h8 <= 159) {
                        t(h8);
                    } else if (h8 <= 255) {
                        y(h8);
                    } else {
                        sb = new StringBuilder(33);
                        str = "Invalid base command: ";
                        sb.append(str);
                        sb.append(h8);
                        n.h("Cea708Decoder", sb.toString());
                    }
                    z5 = true;
                }
            }
            if (z5) {
                this.f9834m = r();
            }
        }
    }

    private void H() {
        for (int i6 = 0; i6 < 8; i6++) {
            this.f9832k[i6].l();
        }
    }

    private void q() {
        if (this.f9836o == null) {
            return;
        }
        G();
        this.f9836o = null;
    }

    private List r() {
        a c6;
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < 8; i6++) {
            if (!this.f9832k[i6].j() && this.f9832k[i6].k() && (c6 = this.f9832k[i6].c()) != null) {
                arrayList.add(c6);
            }
        }
        Collections.sort(arrayList, new Comparator() { // from class: f2.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int F;
                F = c.F((c.a) obj, (c.a) obj2);
                return F;
            }
        });
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            arrayList2.add(((a) arrayList.get(i7)).f9838a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void s(int i6) {
        x xVar;
        if (i6 != 0) {
            if (i6 == 3) {
                this.f9834m = r();
                return;
            }
            int i7 = 8;
            if (i6 == 8) {
                this.f9833l.b();
                return;
            }
            switch (i6) {
                case 12:
                    H();
                    return;
                case 13:
                    this.f9833l.a('\n');
                    return;
                case 14:
                    return;
                default:
                    if (i6 >= 17 && i6 <= 23) {
                        StringBuilder sb = new StringBuilder(55);
                        sb.append("Currently unsupported COMMAND_EXT1 Command: ");
                        sb.append(i6);
                        n.h("Cea708Decoder", sb.toString());
                        xVar = this.f9829h;
                    } else if (i6 < 24 || i6 > 31) {
                        StringBuilder sb2 = new StringBuilder(31);
                        sb2.append("Invalid C0 command: ");
                        sb2.append(i6);
                        n.h("Cea708Decoder", sb2.toString());
                        return;
                    } else {
                        StringBuilder sb3 = new StringBuilder(54);
                        sb3.append("Currently unsupported COMMAND_P16 Command: ");
                        sb3.append(i6);
                        n.h("Cea708Decoder", sb3.toString());
                        xVar = this.f9829h;
                        i7 = 16;
                    }
                    xVar.r(i7);
                    return;
            }
        }
    }

    private void t(int i6) {
        b bVar;
        b bVar2;
        x xVar;
        int i7 = 16;
        int i8 = 1;
        switch (i6) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i9 = i6 - 128;
                if (this.f9837p != i9) {
                    this.f9837p = i9;
                    bVar = this.f9832k[i9];
                    this.f9833l = bVar;
                    return;
                }
                return;
            case 136:
                while (i8 <= 8) {
                    if (this.f9829h.g()) {
                        this.f9832k[8 - i8].e();
                    }
                    i8++;
                }
                return;
            case 137:
                for (int i10 = 1; i10 <= 8; i10++) {
                    if (this.f9829h.g()) {
                        this.f9832k[8 - i10].p(true);
                    }
                }
                return;
            case 138:
                while (i8 <= 8) {
                    if (this.f9829h.g()) {
                        this.f9832k[8 - i8].p(false);
                    }
                    i8++;
                }
                return;
            case 139:
                for (int i11 = 1; i11 <= 8; i11++) {
                    if (this.f9829h.g()) {
                        this.f9832k[8 - i11].p(!bVar2.k());
                    }
                }
                return;
            case 140:
                while (i8 <= 8) {
                    if (this.f9829h.g()) {
                        this.f9832k[8 - i8].l();
                    }
                    i8++;
                }
                return;
            case 141:
                this.f9829h.r(8);
                return;
            case 142:
                return;
            case 143:
                H();
                return;
            case 144:
                if (this.f9833l.i()) {
                    B();
                    return;
                }
                xVar = this.f9829h;
                xVar.r(i7);
                return;
            case 145:
                if (this.f9833l.i()) {
                    C();
                    return;
                }
                xVar = this.f9829h;
                i7 = 24;
                xVar.r(i7);
                return;
            case 146:
                if (this.f9833l.i()) {
                    D();
                    return;
                }
                xVar = this.f9829h;
                xVar.r(i7);
                return;
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                StringBuilder sb = new StringBuilder(31);
                sb.append("Invalid C1 command: ");
                sb.append(i6);
                n.h("Cea708Decoder", sb.toString());
                return;
            case 151:
                if (this.f9833l.i()) {
                    E();
                    return;
                }
                xVar = this.f9829h;
                i7 = 32;
                xVar.r(i7);
                return;
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i12 = i6 - 152;
                w(i12);
                if (this.f9837p != i12) {
                    this.f9837p = i12;
                    bVar = this.f9832k[i12];
                    this.f9833l = bVar;
                    return;
                }
                return;
        }
    }

    private void u(int i6) {
        x xVar;
        int i7;
        if (i6 <= 7) {
            return;
        }
        if (i6 <= 15) {
            xVar = this.f9829h;
            i7 = 8;
        } else if (i6 <= 23) {
            xVar = this.f9829h;
            i7 = 16;
        } else if (i6 > 31) {
            return;
        } else {
            xVar = this.f9829h;
            i7 = 24;
        }
        xVar.r(i7);
    }

    private void v(int i6) {
        x xVar;
        int i7;
        if (i6 <= 135) {
            xVar = this.f9829h;
            i7 = 32;
        } else if (i6 > 143) {
            if (i6 <= 159) {
                this.f9829h.r(2);
                this.f9829h.r(this.f9829h.h(6) * 8);
                return;
            }
            return;
        } else {
            xVar = this.f9829h;
            i7 = 40;
        }
        xVar.r(i7);
    }

    private void w(int i6) {
        b bVar = this.f9832k[i6];
        this.f9829h.r(2);
        boolean g6 = this.f9829h.g();
        boolean g7 = this.f9829h.g();
        boolean g8 = this.f9829h.g();
        int h6 = this.f9829h.h(3);
        boolean g9 = this.f9829h.g();
        int h7 = this.f9829h.h(7);
        int h8 = this.f9829h.h(8);
        int h9 = this.f9829h.h(4);
        int h10 = this.f9829h.h(4);
        this.f9829h.r(2);
        int h11 = this.f9829h.h(6);
        this.f9829h.r(2);
        bVar.f(g6, g7, g8, h6, g9, h7, h8, h10, h11, h9, this.f9829h.h(3), this.f9829h.h(3));
    }

    private void x(int i6) {
        if (i6 == 127) {
            this.f9833l.a((char) 9835);
        } else {
            this.f9833l.a((char) (i6 & 255));
        }
    }

    private void y(int i6) {
        this.f9833l.a((char) (i6 & 255));
    }

    private void z(int i6) {
        b bVar;
        char c6 = ' ';
        if (i6 == 32) {
            bVar = this.f9833l;
        } else if (i6 == 33) {
            bVar = this.f9833l;
            c6 = 160;
        } else if (i6 == 37) {
            bVar = this.f9833l;
            c6 = 8230;
        } else if (i6 == 42) {
            bVar = this.f9833l;
            c6 = 352;
        } else if (i6 == 44) {
            bVar = this.f9833l;
            c6 = 338;
        } else if (i6 == 63) {
            bVar = this.f9833l;
            c6 = 376;
        } else if (i6 == 57) {
            bVar = this.f9833l;
            c6 = 8482;
        } else if (i6 == 58) {
            bVar = this.f9833l;
            c6 = 353;
        } else if (i6 == 60) {
            bVar = this.f9833l;
            c6 = 339;
        } else if (i6 != 61) {
            switch (i6) {
                case 48:
                    bVar = this.f9833l;
                    c6 = 9608;
                    break;
                case 49:
                    bVar = this.f9833l;
                    c6 = 8216;
                    break;
                case 50:
                    bVar = this.f9833l;
                    c6 = 8217;
                    break;
                case 51:
                    bVar = this.f9833l;
                    c6 = 8220;
                    break;
                case 52:
                    bVar = this.f9833l;
                    c6 = 8221;
                    break;
                case 53:
                    bVar = this.f9833l;
                    c6 = 8226;
                    break;
                default:
                    switch (i6) {
                        case j.H0 /* 118 */:
                            bVar = this.f9833l;
                            c6 = 8539;
                            break;
                        case j.I0 /* 119 */:
                            bVar = this.f9833l;
                            c6 = 8540;
                            break;
                        case j.J0 /* 120 */:
                            bVar = this.f9833l;
                            c6 = 8541;
                            break;
                        case j.K0 /* 121 */:
                            bVar = this.f9833l;
                            c6 = 8542;
                            break;
                        case j.L0 /* 122 */:
                            bVar = this.f9833l;
                            c6 = 9474;
                            break;
                        case j.M0 /* 123 */:
                            bVar = this.f9833l;
                            c6 = 9488;
                            break;
                        case j.N0 /* 124 */:
                            bVar = this.f9833l;
                            c6 = 9492;
                            break;
                        case 125:
                            bVar = this.f9833l;
                            c6 = 9472;
                            break;
                        case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                            bVar = this.f9833l;
                            c6 = 9496;
                            break;
                        case 127:
                            bVar = this.f9833l;
                            c6 = 9484;
                            break;
                        default:
                            StringBuilder sb = new StringBuilder(33);
                            sb.append("Invalid G2 character: ");
                            sb.append(i6);
                            n.h("Cea708Decoder", sb.toString());
                            return;
                    }
            }
        } else {
            bVar = this.f9833l;
            c6 = 8480;
        }
        bVar.a(c6);
    }

    @Override // f2.e, com.google.android.exoplayer2.decoder.g
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // f2.e, e2.g
    public /* bridge */ /* synthetic */ void b(long j6) {
        super.b(j6);
    }

    @Override // f2.e
    protected e2.f f() {
        List list = this.f9834m;
        this.f9835n = list;
        return new f((List) com.google.android.exoplayer2.util.a.e(list));
    }

    @Override // f2.e, com.google.android.exoplayer2.decoder.g
    public void flush() {
        super.flush();
        this.f9834m = null;
        this.f9835n = null;
        this.f9837p = 0;
        this.f9833l = this.f9832k[0];
        H();
        this.f9836o = null;
    }

    @Override // f2.e
    protected void g(e2.j jVar) {
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(jVar.f3600b);
        this.f9828g.K(byteBuffer.array(), byteBuffer.limit());
        while (this.f9828g.a() >= 3) {
            int A = this.f9828g.A() & 7;
            int i6 = A & 3;
            boolean z5 = (A & 4) == 4;
            byte A2 = (byte) this.f9828g.A();
            byte A3 = (byte) this.f9828g.A();
            if (i6 == 2 || i6 == 3) {
                if (z5) {
                    if (i6 == 3) {
                        q();
                        int i7 = (A2 & 192) >> 6;
                        int i8 = A2 & Utf8.REPLACEMENT_BYTE;
                        if (i8 == 0) {
                            i8 = 64;
                        }
                        C0165c c0165c = new C0165c(i7, i8);
                        this.f9836o = c0165c;
                        byte[] bArr = c0165c.f9868c;
                        int i9 = c0165c.f9869d;
                        c0165c.f9869d = i9 + 1;
                        bArr[i9] = A3;
                    } else {
                        com.google.android.exoplayer2.util.a.a(i6 == 2);
                        C0165c c0165c2 = this.f9836o;
                        if (c0165c2 == null) {
                            n.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0165c2.f9868c;
                            int i10 = c0165c2.f9869d;
                            int i11 = i10 + 1;
                            bArr2[i10] = A2;
                            c0165c2.f9869d = i11 + 1;
                            bArr2[i11] = A3;
                        }
                    }
                    C0165c c0165c3 = this.f9836o;
                    if (c0165c3.f9869d == (c0165c3.f9867b * 2) - 1) {
                        q();
                    }
                }
            }
        }
    }

    @Override // f2.e
    public /* bridge */ /* synthetic */ e2.j h() {
        return super.e();
    }

    @Override // f2.e
    public /* bridge */ /* synthetic */ k i() {
        return super.d();
    }

    @Override // f2.e
    protected boolean l() {
        return this.f9834m != this.f9835n;
    }

    @Override // f2.e
    public /* bridge */ /* synthetic */ void m(e2.j jVar) {
        super.c(jVar);
    }
}
