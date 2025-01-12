package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import b2.f;
import b2.j;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.r0;
import com.google.android.exoplayer2.w0;
import java.util.Collections;
import java.util.List;
import q2.c0;
import q2.i0;
import q2.l;
import w1.e0;
import w1.g0;
import w1.u0;
import w1.v;
import w1.w;
/* loaded from: classes.dex */
public final class HlsMediaSource extends w1.a implements j.e {

    /* renamed from: g  reason: collision with root package name */
    private final h f4227g;

    /* renamed from: h  reason: collision with root package name */
    private final w0 f4228h;

    /* renamed from: k  reason: collision with root package name */
    private final w0.e f4229k;

    /* renamed from: l  reason: collision with root package name */
    private final g f4230l;

    /* renamed from: m  reason: collision with root package name */
    private final w1.i f4231m;

    /* renamed from: n  reason: collision with root package name */
    private final v f4232n;

    /* renamed from: o  reason: collision with root package name */
    private final c0 f4233o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f4234p;

    /* renamed from: q  reason: collision with root package name */
    private final int f4235q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f4236r;

    /* renamed from: s  reason: collision with root package name */
    private final b2.j f4237s;

    /* renamed from: t  reason: collision with root package name */
    private i0 f4238t;

    /* loaded from: classes.dex */
    public static final class Factory implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private final g f4239a;

        /* renamed from: b  reason: collision with root package name */
        private final w f4240b;

        /* renamed from: c  reason: collision with root package name */
        private h f4241c;

        /* renamed from: d  reason: collision with root package name */
        private b2.i f4242d;

        /* renamed from: e  reason: collision with root package name */
        private j.a f4243e;

        /* renamed from: f  reason: collision with root package name */
        private w1.i f4244f;

        /* renamed from: g  reason: collision with root package name */
        private v f4245g;

        /* renamed from: h  reason: collision with root package name */
        private c0 f4246h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f4247i;

        /* renamed from: j  reason: collision with root package name */
        private int f4248j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f4249k;

        /* renamed from: l  reason: collision with root package name */
        private List f4250l;

        /* renamed from: m  reason: collision with root package name */
        private Object f4251m;

        public Factory(g gVar) {
            this.f4239a = (g) com.google.android.exoplayer2.util.a.e(gVar);
            this.f4240b = new w();
            this.f4242d = new b2.a();
            this.f4243e = b2.c.f2909s;
            this.f4241c = h.f4290a;
            this.f4246h = new q2.w();
            this.f4244f = new w1.j();
            this.f4248j = 1;
            this.f4250l = Collections.emptyList();
        }

        public HlsMediaSource e(Uri uri) {
            return c(new w0.b().g(uri).d("application/x-mpegURL").a());
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
        @Override // w1.g0
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public HlsMediaSource c(w0 w0Var) {
            w0.b a6;
            w0.b f6;
            v vVar;
            com.google.android.exoplayer2.util.a.e(w0Var.f4702b);
            b2.i iVar = this.f4242d;
            List list = w0Var.f4702b.f4743d.isEmpty() ? this.f4250l : w0Var.f4702b.f4743d;
            if (!list.isEmpty()) {
                iVar = new b2.d(iVar, list);
            }
            w0.e eVar = w0Var.f4702b;
            boolean z5 = true;
            boolean z6 = eVar.f4747h == null && this.f4251m != null;
            z5 = (!eVar.f4743d.isEmpty() || list.isEmpty()) ? false : false;
            if (!z6 || !z5) {
                if (!z6) {
                    if (z5) {
                        a6 = w0Var.a();
                    }
                    w0 w0Var2 = w0Var;
                    g gVar = this.f4239a;
                    h hVar = this.f4241c;
                    w1.i iVar2 = this.f4244f;
                    vVar = this.f4245g;
                    if (vVar == null) {
                    }
                    c0 c0Var = this.f4246h;
                    return new HlsMediaSource(w0Var2, gVar, hVar, iVar2, vVar, c0Var, this.f4243e.a(this.f4239a, c0Var, iVar), this.f4247i, this.f4248j, this.f4249k);
                }
                f6 = w0Var.a().f(this.f4251m);
                w0Var = f6.a();
                w0 w0Var22 = w0Var;
                g gVar2 = this.f4239a;
                h hVar2 = this.f4241c;
                w1.i iVar22 = this.f4244f;
                vVar = this.f4245g;
                if (vVar == null) {
                    vVar = this.f4240b.a(w0Var22);
                }
                c0 c0Var2 = this.f4246h;
                return new HlsMediaSource(w0Var22, gVar2, hVar2, iVar22, vVar, c0Var2, this.f4243e.a(this.f4239a, c0Var2, iVar), this.f4247i, this.f4248j, this.f4249k);
            }
            a6 = w0Var.a().f(this.f4251m);
            f6 = a6.e(list);
            w0Var = f6.a();
            w0 w0Var222 = w0Var;
            g gVar22 = this.f4239a;
            h hVar22 = this.f4241c;
            w1.i iVar222 = this.f4244f;
            vVar = this.f4245g;
            if (vVar == null) {
            }
            c0 c0Var22 = this.f4246h;
            return new HlsMediaSource(w0Var222, gVar22, hVar22, iVar222, vVar, c0Var22, this.f4243e.a(this.f4239a, c0Var22, iVar), this.f4247i, this.f4248j, this.f4249k);
        }

        @Override // w1.g0
        /* renamed from: g */
        public Factory b(v vVar) {
            this.f4245g = vVar;
            return this;
        }

        @Override // w1.g0
        /* renamed from: h */
        public Factory d(c0 c0Var) {
            if (c0Var == null) {
                c0Var = new q2.w();
            }
            this.f4246h = c0Var;
            return this;
        }

        @Override // w1.g0
        /* renamed from: i */
        public Factory a(List list) {
            if (list == null) {
                list = Collections.emptyList();
            }
            this.f4250l = list;
            return this;
        }

        public Factory(l.a aVar) {
            this(new c(aVar));
        }
    }

    static {
        r0.a("goog.exo.hls");
    }

    private HlsMediaSource(w0 w0Var, g gVar, h hVar, w1.i iVar, v vVar, c0 c0Var, b2.j jVar, boolean z5, int i6, boolean z6) {
        this.f4229k = (w0.e) com.google.android.exoplayer2.util.a.e(w0Var.f4702b);
        this.f4228h = w0Var;
        this.f4230l = gVar;
        this.f4227g = hVar;
        this.f4231m = iVar;
        this.f4232n = vVar;
        this.f4233o = c0Var;
        this.f4237s = jVar;
        this.f4234p = z5;
        this.f4235q = i6;
        this.f4236r = z6;
    }

    @Override // w1.a
    protected void A(i0 i0Var) {
        this.f4238t = i0Var;
        this.f4232n.b();
        this.f4237s.l(this.f4229k.f4740a, v(null), this);
    }

    @Override // w1.a
    protected void C() {
        this.f4237s.stop();
        this.f4232n.a();
    }

    @Override // w1.v
    public w0 a() {
        return this.f4228h;
    }

    @Override // w1.v
    public void e() {
        this.f4237s.e();
    }

    @Override // b2.j.e
    public void h(b2.f fVar) {
        u0 u0Var;
        long j6;
        long b6 = fVar.f2969m ? com.google.android.exoplayer2.p.b(fVar.f2962f) : -9223372036854775807L;
        int i6 = fVar.f2960d;
        long j7 = (i6 == 2 || i6 == 1) ? b6 : -9223372036854775807L;
        long j8 = fVar.f2961e;
        i iVar = new i((b2.e) com.google.android.exoplayer2.util.a.e(this.f4237s.c()), fVar);
        if (this.f4237s.a()) {
            long j9 = fVar.f2962f - this.f4237s.j();
            long j10 = fVar.f2968l ? j9 + fVar.f2972p : -9223372036854775807L;
            List list = fVar.f2971o;
            if (j8 != -9223372036854775807L) {
                j6 = j8;
            } else if (list.isEmpty()) {
                j6 = 0;
            } else {
                int max = Math.max(0, list.size() - 3);
                long j11 = fVar.f2972p - (fVar.f2967k * 2);
                while (max > 0 && ((f.a) list.get(max)).f2978f > j11) {
                    max--;
                }
                j6 = ((f.a) list.get(max)).f2978f;
            }
            u0Var = new u0(j7, b6, -9223372036854775807L, j10, fVar.f2972p, j9, j6, true, !fVar.f2968l, true, iVar, this.f4228h);
        } else {
            long j12 = j8 == -9223372036854775807L ? 0L : j8;
            long j13 = fVar.f2972p;
            u0Var = new u0(j7, b6, -9223372036854775807L, j13, j13, 0L, j12, true, false, false, iVar, this.f4228h);
        }
        B(u0Var);
    }

    @Override // w1.v
    public void i(w1.t tVar) {
        ((l) tVar).B();
    }

    @Override // w1.v
    public w1.t o(v.a aVar, q2.b bVar, long j6) {
        e0.a v5 = v(aVar);
        return new l(this.f4227g, this.f4237s, this.f4230l, this.f4238t, this.f4232n, t(aVar), this.f4233o, v5, bVar, this.f4231m, this.f4234p, this.f4235q, this.f4236r);
    }
}
