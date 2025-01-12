package com.google.android.exoplayer2.source.dash;

import a2.m;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.r0;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.c;
import com.google.android.exoplayer2.source.dash.e;
import com.google.android.exoplayer2.util.f0;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.y1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import q2.c0;
import q2.d0;
import q2.e0;
import q2.f0;
import q2.i0;
import q2.l;
import w1.e0;
import w1.g0;
import w1.j;
import w1.s;
import w1.t;
import w1.v;
import w1.w;
/* loaded from: classes.dex */
public final class DashMediaSource extends w1.a {
    private final w0.e A;
    private l B;
    private d0 C;
    private i0 D;
    private IOException E;
    private Handler F;
    private Uri G;
    private Uri H;
    private a2.b I;
    private boolean J;
    private long K;
    private long L;
    private long M;
    private int N;
    private long O;
    private int P;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f4102g;

    /* renamed from: h  reason: collision with root package name */
    private final l.a f4103h;

    /* renamed from: k  reason: collision with root package name */
    private final a.InterfaceC0040a f4104k;

    /* renamed from: l  reason: collision with root package name */
    private final w1.i f4105l;

    /* renamed from: m  reason: collision with root package name */
    private final v f4106m;

    /* renamed from: n  reason: collision with root package name */
    private final c0 f4107n;

    /* renamed from: o  reason: collision with root package name */
    private final long f4108o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f4109p;

    /* renamed from: q  reason: collision with root package name */
    private final e0.a f4110q;

    /* renamed from: r  reason: collision with root package name */
    private final f0.a f4111r;

    /* renamed from: s  reason: collision with root package name */
    private final e f4112s;

    /* renamed from: t  reason: collision with root package name */
    private final Object f4113t;

    /* renamed from: u  reason: collision with root package name */
    private final SparseArray f4114u;

    /* renamed from: v  reason: collision with root package name */
    private final Runnable f4115v;

    /* renamed from: w  reason: collision with root package name */
    private final Runnable f4116w;

    /* renamed from: x  reason: collision with root package name */
    private final e.b f4117x;

    /* renamed from: y  reason: collision with root package name */
    private final q2.e0 f4118y;

    /* renamed from: z  reason: collision with root package name */
    private final w0 f4119z;

    /* loaded from: classes.dex */
    public static final class Factory implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private final a.InterfaceC0040a f4120a;

        /* renamed from: b  reason: collision with root package name */
        private final w f4121b;

        /* renamed from: c  reason: collision with root package name */
        private final l.a f4122c;

        /* renamed from: d  reason: collision with root package name */
        private v f4123d;

        /* renamed from: e  reason: collision with root package name */
        private w1.i f4124e;

        /* renamed from: f  reason: collision with root package name */
        private c0 f4125f;

        /* renamed from: g  reason: collision with root package name */
        private long f4126g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f4127h;

        /* renamed from: i  reason: collision with root package name */
        private f0.a f4128i;

        /* renamed from: j  reason: collision with root package name */
        private List f4129j;

        /* renamed from: k  reason: collision with root package name */
        private Object f4130k;

        public Factory(a.InterfaceC0040a interfaceC0040a, l.a aVar) {
            this.f4120a = (a.InterfaceC0040a) com.google.android.exoplayer2.util.a.e(interfaceC0040a);
            this.f4122c = aVar;
            this.f4121b = new w();
            this.f4125f = new q2.w();
            this.f4126g = 30000L;
            this.f4124e = new j();
            this.f4129j = Collections.emptyList();
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
        @Override // w1.g0
        /* renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DashMediaSource c(w0 w0Var) {
            w0.b a6;
            w0.b f6;
            v vVar;
            w0 w0Var2 = w0Var;
            com.google.android.exoplayer2.util.a.e(w0Var2.f4702b);
            f0.a aVar = this.f4128i;
            if (aVar == null) {
                aVar = new a2.c();
            }
            List list = w0Var2.f4702b.f4743d.isEmpty() ? this.f4129j : w0Var2.f4702b.f4743d;
            u1.d dVar = !list.isEmpty() ? new u1.d(aVar, list) : aVar;
            w0.e eVar = w0Var2.f4702b;
            boolean z5 = true;
            boolean z6 = eVar.f4747h == null && this.f4130k != null;
            z5 = (!eVar.f4743d.isEmpty() || list.isEmpty()) ? false : false;
            if (!z6 || !z5) {
                if (!z6) {
                    if (z5) {
                        a6 = w0Var.a();
                    }
                    w0 w0Var3 = w0Var2;
                    l.a aVar2 = this.f4122c;
                    a.InterfaceC0040a interfaceC0040a = this.f4120a;
                    w1.i iVar = this.f4124e;
                    vVar = this.f4123d;
                    if (vVar == null) {
                    }
                    return new DashMediaSource(w0Var3, null, aVar2, dVar, interfaceC0040a, iVar, vVar, this.f4125f, this.f4126g, this.f4127h, null);
                }
                f6 = w0Var.a().f(this.f4130k);
                w0Var2 = f6.a();
                w0 w0Var32 = w0Var2;
                l.a aVar22 = this.f4122c;
                a.InterfaceC0040a interfaceC0040a2 = this.f4120a;
                w1.i iVar2 = this.f4124e;
                vVar = this.f4123d;
                if (vVar == null) {
                    vVar = this.f4121b.a(w0Var32);
                }
                return new DashMediaSource(w0Var32, null, aVar22, dVar, interfaceC0040a2, iVar2, vVar, this.f4125f, this.f4126g, this.f4127h, null);
            }
            a6 = w0Var.a().f(this.f4130k);
            f6 = a6.e(list);
            w0Var2 = f6.a();
            w0 w0Var322 = w0Var2;
            l.a aVar222 = this.f4122c;
            a.InterfaceC0040a interfaceC0040a22 = this.f4120a;
            w1.i iVar22 = this.f4124e;
            vVar = this.f4123d;
            if (vVar == null) {
            }
            return new DashMediaSource(w0Var322, null, aVar222, dVar, interfaceC0040a22, iVar22, vVar, this.f4125f, this.f4126g, this.f4127h, null);
        }

        @Override // w1.g0
        /* renamed from: f */
        public Factory b(v vVar) {
            this.f4123d = vVar;
            return this;
        }

        @Override // w1.g0
        /* renamed from: g */
        public Factory d(c0 c0Var) {
            if (c0Var == null) {
                c0Var = new q2.w();
            }
            this.f4125f = c0Var;
            return this;
        }

        @Override // w1.g0
        /* renamed from: h */
        public Factory a(List list) {
            if (list == null) {
                list = Collections.emptyList();
            }
            this.f4129j = list;
            return this;
        }

        public Factory(l.a aVar) {
            this(new c.a(aVar), aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements f0.b {
        a() {
        }

        @Override // com.google.android.exoplayer2.util.f0.b
        public void a() {
            DashMediaSource.this.U(com.google.android.exoplayer2.util.f0.h());
        }

        @Override // com.google.android.exoplayer2.util.f0.b
        public void b(IOException iOException) {
            DashMediaSource.this.T(iOException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends y1 {

        /* renamed from: b  reason: collision with root package name */
        private final long f4132b;

        /* renamed from: c  reason: collision with root package name */
        private final long f4133c;

        /* renamed from: d  reason: collision with root package name */
        private final long f4134d;

        /* renamed from: e  reason: collision with root package name */
        private final int f4135e;

        /* renamed from: f  reason: collision with root package name */
        private final long f4136f;

        /* renamed from: g  reason: collision with root package name */
        private final long f4137g;

        /* renamed from: h  reason: collision with root package name */
        private final long f4138h;

        /* renamed from: i  reason: collision with root package name */
        private final a2.b f4139i;

        /* renamed from: j  reason: collision with root package name */
        private final w0 f4140j;

        public b(long j6, long j7, long j8, int i6, long j9, long j10, long j11, a2.b bVar, w0 w0Var) {
            this.f4132b = j6;
            this.f4133c = j7;
            this.f4134d = j8;
            this.f4135e = i6;
            this.f4136f = j9;
            this.f4137g = j10;
            this.f4138h = j11;
            this.f4139i = bVar;
            this.f4140j = w0Var;
        }

        private long r(long j6) {
            z1.d i6;
            long j7 = this.f4138h;
            if (s(this.f4139i)) {
                if (j6 > 0) {
                    j7 += j6;
                    if (j7 > this.f4137g) {
                        return -9223372036854775807L;
                    }
                }
                long j8 = this.f4136f + j7;
                long g6 = this.f4139i.g(0);
                int i7 = 0;
                while (i7 < this.f4139i.e() - 1 && j8 >= g6) {
                    j8 -= g6;
                    i7++;
                    g6 = this.f4139i.g(i7);
                }
                a2.f d6 = this.f4139i.d(i7);
                int a6 = d6.a(2);
                return (a6 == -1 || (i6 = ((a2.i) ((a2.a) d6.f85c.get(a6)).f47c.get(0)).i()) == null || i6.g(g6) == 0) ? j7 : (j7 + i6.b(i6.a(j8, g6))) - j8;
            }
            return j7;
        }

        private static boolean s(a2.b bVar) {
            return bVar.f54d && bVar.f55e != -9223372036854775807L && bVar.f52b == -9223372036854775807L;
        }

        @Override // com.google.android.exoplayer2.y1
        public int b(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.f4135e) >= 0 && intValue < i()) {
                return intValue;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.y1
        public y1.b g(int i6, y1.b bVar, boolean z5) {
            com.google.android.exoplayer2.util.a.c(i6, 0, i());
            return bVar.m(z5 ? this.f4139i.d(i6).f83a : null, z5 ? Integer.valueOf(this.f4135e + i6) : null, 0, this.f4139i.g(i6), p.a(this.f4139i.d(i6).f84b - this.f4139i.d(0).f84b) - this.f4136f);
        }

        @Override // com.google.android.exoplayer2.y1
        public int i() {
            return this.f4139i.e();
        }

        @Override // com.google.android.exoplayer2.y1
        public Object l(int i6) {
            com.google.android.exoplayer2.util.a.c(i6, 0, i());
            return Integer.valueOf(this.f4135e + i6);
        }

        @Override // com.google.android.exoplayer2.y1
        public y1.c n(int i6, y1.c cVar, long j6) {
            com.google.android.exoplayer2.util.a.c(i6, 0, 1);
            long r5 = r(j6);
            Object obj = y1.c.f4833q;
            w0 w0Var = this.f4140j;
            a2.b bVar = this.f4139i;
            return cVar.e(obj, w0Var, bVar, this.f4132b, this.f4133c, this.f4134d, true, s(bVar), this.f4139i.f54d, r5, this.f4137g, 0, i() - 1, this.f4136f);
        }

        @Override // com.google.android.exoplayer2.y1
        public int o() {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    private final class c implements e.b {
        private c() {
        }

        @Override // com.google.android.exoplayer2.source.dash.e.b
        public void a() {
            DashMediaSource.this.N();
        }

        @Override // com.google.android.exoplayer2.source.dash.e.b
        public void b(long j6) {
            DashMediaSource.this.M(j6);
        }

        /* synthetic */ c(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d implements f0.a {

        /* renamed from: a  reason: collision with root package name */
        private static final Pattern f4142a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        d() {
        }

        @Override // q2.f0.a
        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) {
            String readLine = new BufferedReader(new InputStreamReader(inputStream, com.google.common.base.b.f5585c)).readLine();
            try {
                Matcher matcher = f4142a.matcher(readLine);
                if (!matcher.matches()) {
                    String valueOf = String.valueOf(readLine);
                    throw new f1(valueOf.length() != 0 ? "Couldn't parse timestamp: ".concat(valueOf) : new String("Couldn't parse timestamp: "));
                }
                String group = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(group).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j6 = k5.d.ANY_NON_NULL_MARKER.equals(matcher.group(4)) ? 1L : -1L;
                    long parseLong = Long.parseLong(matcher.group(5));
                    String group2 = matcher.group(7);
                    time -= j6 * ((((parseLong * 60) + (TextUtils.isEmpty(group2) ? 0L : Long.parseLong(group2))) * 60) * 1000);
                }
                return Long.valueOf(time);
            } catch (ParseException e6) {
                throw new f1(e6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class e implements d0.b {
        private e() {
        }

        @Override // q2.d0.b
        /* renamed from: a */
        public void p(q2.f0 f0Var, long j6, long j7, boolean z5) {
            DashMediaSource.this.O(f0Var, j6, j7);
        }

        @Override // q2.d0.b
        /* renamed from: b */
        public void m(q2.f0 f0Var, long j6, long j7) {
            DashMediaSource.this.P(f0Var, j6, j7);
        }

        @Override // q2.d0.b
        /* renamed from: c */
        public d0.c k(q2.f0 f0Var, long j6, long j7, IOException iOException, int i6) {
            return DashMediaSource.this.Q(f0Var, j6, j7, iOException, i6);
        }

        /* synthetic */ e(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    final class f implements q2.e0 {
        f() {
        }

        private void a() {
            if (DashMediaSource.this.E != null) {
                throw DashMediaSource.this.E;
            }
        }

        @Override // q2.e0
        public void b() {
            DashMediaSource.this.C.b();
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f4145a;

        /* renamed from: b  reason: collision with root package name */
        public final long f4146b;

        /* renamed from: c  reason: collision with root package name */
        public final long f4147c;

        private g(boolean z5, long j6, long j7) {
            this.f4145a = z5;
            this.f4146b = j6;
            this.f4147c = j7;
        }

        public static g a(a2.f fVar, long j6) {
            boolean z5;
            boolean z6;
            long j7;
            int size = fVar.f85c.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                int i8 = ((a2.a) fVar.f85c.get(i7)).f46b;
                if (i8 == 1 || i8 == 2) {
                    z5 = true;
                    break;
                }
            }
            z5 = false;
            long j8 = Long.MAX_VALUE;
            int i9 = 0;
            boolean z7 = false;
            long j9 = 0;
            boolean z8 = false;
            while (i9 < size) {
                a2.a aVar = (a2.a) fVar.f85c.get(i9);
                if (!z5 || aVar.f46b != 3) {
                    z1.d i10 = ((a2.i) aVar.f47c.get(i6)).i();
                    if (i10 == null) {
                        return new g(true, 0L, j6);
                    }
                    z7 |= i10.e();
                    int g6 = i10.g(j6);
                    if (g6 == 0) {
                        z6 = z5;
                        j7 = 0;
                        j9 = 0;
                        z8 = true;
                    } else if (!z8) {
                        z6 = z5;
                        long f6 = i10.f();
                        long j10 = j8;
                        j9 = Math.max(j9, i10.b(f6));
                        if (g6 != -1) {
                            long j11 = (f6 + g6) - 1;
                            j7 = Math.min(j10, i10.b(j11) + i10.c(j11, j6));
                        } else {
                            j7 = j10;
                        }
                    }
                    i9++;
                    j8 = j7;
                    z5 = z6;
                    i6 = 0;
                }
                z6 = z5;
                j7 = j8;
                i9++;
                j8 = j7;
                z5 = z6;
                i6 = 0;
            }
            return new g(z7, j9, j8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class h implements d0.b {
        private h() {
        }

        @Override // q2.d0.b
        /* renamed from: a */
        public void p(q2.f0 f0Var, long j6, long j7, boolean z5) {
            DashMediaSource.this.O(f0Var, j6, j7);
        }

        @Override // q2.d0.b
        /* renamed from: b */
        public void m(q2.f0 f0Var, long j6, long j7) {
            DashMediaSource.this.R(f0Var, j6, j7);
        }

        @Override // q2.d0.b
        /* renamed from: c */
        public d0.c k(q2.f0 f0Var, long j6, long j7, IOException iOException, int i6) {
            return DashMediaSource.this.S(f0Var, j6, j7, iOException);
        }

        /* synthetic */ h(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class i implements f0.a {
        private i() {
        }

        /* synthetic */ i(a aVar) {
            this();
        }

        @Override // q2.f0.a
        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) {
            return Long.valueOf(s0.A0(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        r0.a("goog.exo.dash");
    }

    private DashMediaSource(w0 w0Var, a2.b bVar, l.a aVar, f0.a aVar2, a.InterfaceC0040a interfaceC0040a, w1.i iVar, v vVar, c0 c0Var, long j6, boolean z5) {
        this.f4119z = w0Var;
        w0.e eVar = (w0.e) com.google.android.exoplayer2.util.a.e(w0Var.f4702b);
        this.A = eVar;
        Uri uri = eVar.f4740a;
        this.G = uri;
        this.H = uri;
        this.I = bVar;
        this.f4103h = aVar;
        this.f4111r = aVar2;
        this.f4104k = interfaceC0040a;
        this.f4106m = vVar;
        this.f4107n = c0Var;
        this.f4108o = j6;
        this.f4109p = z5;
        this.f4105l = iVar;
        boolean z6 = bVar != null;
        this.f4102g = z6;
        this.f4110q = v(null);
        this.f4113t = new Object();
        this.f4114u = new SparseArray();
        this.f4117x = new c(this, null);
        this.O = -9223372036854775807L;
        this.M = -9223372036854775807L;
        if (!z6) {
            this.f4112s = new e(this, null);
            this.f4118y = new f();
            this.f4115v = new Runnable() { // from class: z1.b
                @Override // java.lang.Runnable
                public final void run() {
                    DashMediaSource.this.b0();
                }
            };
            this.f4116w = new Runnable() { // from class: z1.c
                @Override // java.lang.Runnable
                public final void run() {
                    DashMediaSource.this.K();
                }
            };
            return;
        }
        com.google.android.exoplayer2.util.a.g(true ^ bVar.f54d);
        this.f4112s = null;
        this.f4115v = null;
        this.f4116w = null;
        this.f4118y = new e0.a();
    }

    private long J() {
        return Math.min((this.N - 1) * 1000, 5000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        V(false);
    }

    private void L() {
        com.google.android.exoplayer2.util.f0.j(this.C, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(IOException iOException) {
        n.d("DashMediaSource", "Failed to resolve time offset.", iOException);
        V(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(long j6) {
        this.M = j6;
        V(true);
    }

    private void V(boolean z5) {
        long j6;
        boolean z6;
        long j7;
        for (int i6 = 0; i6 < this.f4114u.size(); i6++) {
            int keyAt = this.f4114u.keyAt(i6);
            if (keyAt >= this.P) {
                ((com.google.android.exoplayer2.source.dash.b) this.f4114u.valueAt(i6)).M(this.I, keyAt - this.P);
            }
        }
        int e6 = this.I.e() - 1;
        g a6 = g.a(this.I.d(0), this.I.g(0));
        g a7 = g.a(this.I.d(e6), this.I.g(e6));
        long j8 = a6.f4146b;
        long j9 = a7.f4147c;
        if (!this.I.f54d || a7.f4145a) {
            j6 = j8;
            z6 = false;
        } else {
            j9 = Math.min((p.a(s0.X(this.M)) - p.a(this.I.f51a)) - p.a(this.I.d(e6).f84b), j9);
            long j10 = this.I.f56f;
            if (j10 != -9223372036854775807L) {
                long a8 = j9 - p.a(j10);
                while (a8 < 0 && e6 > 0) {
                    e6--;
                    a8 += this.I.g(e6);
                }
                j8 = e6 == 0 ? Math.max(j8, a8) : this.I.g(0);
            }
            j6 = j8;
            z6 = true;
        }
        long j11 = j9 - j6;
        for (int i7 = 0; i7 < this.I.e() - 1; i7++) {
            j11 += this.I.g(i7);
        }
        a2.b bVar = this.I;
        if (bVar.f54d) {
            long j12 = this.f4108o;
            if (!this.f4109p) {
                long j13 = bVar.f57g;
                if (j13 != -9223372036854775807L) {
                    j12 = j13;
                }
            }
            long a9 = j11 - p.a(j12);
            if (a9 < 5000000) {
                a9 = Math.min(5000000L, j11 / 2);
            }
            j7 = a9;
        } else {
            j7 = 0;
        }
        a2.b bVar2 = this.I;
        long j14 = bVar2.f51a;
        long b6 = j14 != -9223372036854775807L ? j14 + bVar2.d(0).f84b + p.b(j6) : -9223372036854775807L;
        a2.b bVar3 = this.I;
        B(new b(bVar3.f51a, b6, this.M, this.P, j6, j11, j7, bVar3, this.f4119z));
        if (this.f4102g) {
            return;
        }
        this.F.removeCallbacks(this.f4116w);
        if (z6) {
            this.F.postDelayed(this.f4116w, 5000L);
        }
        if (this.J) {
            b0();
        } else if (z5) {
            a2.b bVar4 = this.I;
            if (bVar4.f54d) {
                long j15 = bVar4.f55e;
                if (j15 != -9223372036854775807L) {
                    Z(Math.max(0L, (this.K + (j15 != 0 ? j15 : 5000L)) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    private void W(m mVar) {
        f0.a dVar;
        String str = mVar.f128a;
        if (s0.c(str, "urn:mpeg:dash:utc:direct:2014") || s0.c(str, "urn:mpeg:dash:utc:direct:2012")) {
            X(mVar);
            return;
        }
        if (s0.c(str, "urn:mpeg:dash:utc:http-iso:2014") || s0.c(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            dVar = new d();
        } else if (!s0.c(str, "urn:mpeg:dash:utc:http-xsdate:2014") && !s0.c(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            if (s0.c(str, "urn:mpeg:dash:utc:ntp:2014") || s0.c(str, "urn:mpeg:dash:utc:ntp:2012")) {
                L();
                return;
            } else {
                T(new IOException("Unsupported UTC timing scheme"));
                return;
            }
        } else {
            dVar = new i(null);
        }
        Y(mVar, dVar);
    }

    private void X(m mVar) {
        try {
            U(s0.A0(mVar.f129b) - this.L);
        } catch (f1 e6) {
            T(e6);
        }
    }

    private void Y(m mVar, f0.a aVar) {
        a0(new q2.f0(this.B, Uri.parse(mVar.f129b), 5, aVar), new h(this, null), 1);
    }

    private void Z(long j6) {
        this.F.postDelayed(this.f4115v, j6);
    }

    private void a0(q2.f0 f0Var, d0.b bVar, int i6) {
        this.f4110q.z(new w1.p(f0Var.f12754a, f0Var.f12755b, this.C.n(f0Var, bVar, i6)), f0Var.f12756c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        Uri uri;
        this.F.removeCallbacks(this.f4115v);
        if (this.C.i()) {
            return;
        }
        if (this.C.j()) {
            this.J = true;
            return;
        }
        synchronized (this.f4113t) {
            uri = this.G;
        }
        this.J = false;
        a0(new q2.f0(this.B, uri, 4, this.f4111r), this.f4112s, this.f4107n.d(4));
    }

    @Override // w1.a
    protected void A(i0 i0Var) {
        this.D = i0Var;
        this.f4106m.b();
        if (this.f4102g) {
            V(false);
            return;
        }
        this.B = this.f4103h.a();
        this.C = new d0("Loader:DashMediaSource");
        this.F = s0.x();
        b0();
    }

    @Override // w1.a
    protected void C() {
        this.J = false;
        this.B = null;
        d0 d0Var = this.C;
        if (d0Var != null) {
            d0Var.l();
            this.C = null;
        }
        this.K = 0L;
        this.L = 0L;
        this.I = this.f4102g ? this.I : null;
        this.G = this.H;
        this.E = null;
        Handler handler = this.F;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.F = null;
        }
        this.M = -9223372036854775807L;
        this.N = 0;
        this.O = -9223372036854775807L;
        this.P = 0;
        this.f4114u.clear();
        this.f4106m.a();
    }

    void M(long j6) {
        long j7 = this.O;
        if (j7 == -9223372036854775807L || j7 < j6) {
            this.O = j6;
        }
    }

    void N() {
        this.F.removeCallbacks(this.f4116w);
        b0();
    }

    void O(q2.f0 f0Var, long j6, long j7) {
        w1.p pVar = new w1.p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b());
        this.f4107n.a(f0Var.f12754a);
        this.f4110q.q(pVar, f0Var.f12756c);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void P(q2.f0 f0Var, long j6, long j7) {
        boolean z5;
        String str;
        String sb;
        w1.p pVar = new w1.p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b());
        this.f4107n.a(f0Var.f12754a);
        this.f4110q.t(pVar, f0Var.f12756c);
        a2.b bVar = (a2.b) f0Var.e();
        a2.b bVar2 = this.I;
        int e6 = bVar2 == null ? 0 : bVar2.e();
        long j8 = bVar.d(0).f84b;
        int i6 = 0;
        while (i6 < e6 && this.I.d(i6).f84b < j8) {
            i6++;
        }
        if (bVar.f54d) {
            if (e6 - i6 > bVar.e()) {
                str = "DashMediaSource";
                sb = "Loaded out of sync manifest";
            } else {
                long j9 = this.O;
                if (j9 != -9223372036854775807L) {
                    long j10 = bVar.f58h;
                    if (1000 * j10 <= j9) {
                        str = "DashMediaSource";
                        StringBuilder sb2 = new StringBuilder(73);
                        sb2.append("Loaded stale dynamic manifest: ");
                        sb2.append(j10);
                        sb2.append(", ");
                        sb2.append(j9);
                        sb = sb2.toString();
                    }
                }
                z5 = false;
                if (!z5) {
                    int i7 = this.N;
                    this.N = i7 + 1;
                    if (i7 < this.f4107n.d(f0Var.f12756c)) {
                        Z(J());
                        return;
                    } else {
                        this.E = new z1.a();
                        return;
                    }
                }
                this.N = 0;
            }
            n.h(str, sb);
            z5 = true;
            if (!z5) {
            }
        }
        this.I = bVar;
        this.J = bVar.f54d & this.J;
        this.K = j6 - j7;
        this.L = j6;
        synchronized (this.f4113t) {
            if (f0Var.f12755b.f12794a == this.G) {
                Uri uri = this.I.f60j;
                if (uri == null) {
                    uri = f0Var.f();
                }
                this.G = uri;
            }
        }
        if (e6 == 0) {
            a2.b bVar3 = this.I;
            if (bVar3.f54d) {
                m mVar = bVar3.f59i;
                if (mVar != null) {
                    W(mVar);
                    return;
                } else {
                    L();
                    return;
                }
            }
        } else {
            this.P += i6;
        }
        V(true);
    }

    d0.c Q(q2.f0 f0Var, long j6, long j7, IOException iOException, int i6) {
        w1.p pVar = new w1.p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b());
        long b6 = this.f4107n.b(new c0.a(pVar, new s(f0Var.f12756c), iOException, i6));
        d0.c h6 = b6 == -9223372036854775807L ? d0.f12729g : d0.h(false, b6);
        boolean z5 = !h6.c();
        this.f4110q.x(pVar, f0Var.f12756c, iOException, z5);
        if (z5) {
            this.f4107n.a(f0Var.f12754a);
        }
        return h6;
    }

    void R(q2.f0 f0Var, long j6, long j7) {
        w1.p pVar = new w1.p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b());
        this.f4107n.a(f0Var.f12754a);
        this.f4110q.t(pVar, f0Var.f12756c);
        U(((Long) f0Var.e()).longValue() - j6);
    }

    d0.c S(q2.f0 f0Var, long j6, long j7, IOException iOException) {
        this.f4110q.x(new w1.p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b()), f0Var.f12756c, iOException, true);
        this.f4107n.a(f0Var.f12754a);
        T(iOException);
        return d0.f12728f;
    }

    @Override // w1.v
    public w0 a() {
        return this.f4119z;
    }

    @Override // w1.v
    public void e() {
        this.f4118y.b();
    }

    @Override // w1.v
    public void i(t tVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) tVar;
        bVar.I();
        this.f4114u.remove(bVar.f4151a);
    }

    @Override // w1.v
    public t o(v.a aVar, q2.b bVar, long j6) {
        int intValue = ((Integer) aVar.f14051a).intValue() - this.P;
        e0.a w5 = w(aVar, this.I.d(intValue).f84b);
        com.google.android.exoplayer2.source.dash.b bVar2 = new com.google.android.exoplayer2.source.dash.b(this.P + intValue, this.I, intValue, this.f4104k, this.D, this.f4106m, t(aVar), this.f4107n, w5, this.M, this.f4118y, bVar, this.f4105l, this.f4117x);
        this.f4114u.put(bVar2.f4151a, bVar2);
        return bVar2;
    }

    /* synthetic */ DashMediaSource(w0 w0Var, a2.b bVar, l.a aVar, f0.a aVar2, a.InterfaceC0040a interfaceC0040a, w1.i iVar, com.google.android.exoplayer2.drm.v vVar, c0 c0Var, long j6, boolean z5, a aVar3) {
        this(w0Var, bVar, aVar, aVar2, interfaceC0040a, iVar, vVar, c0Var, j6, z5);
    }
}
