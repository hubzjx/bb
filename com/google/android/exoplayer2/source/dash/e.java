package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import c1.a0;
import c1.z;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.t0;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import q2.h;
import w1.q0;
/* loaded from: classes.dex */
public final class e implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final q2.b f4210a;

    /* renamed from: b  reason: collision with root package name */
    private final b f4211b;

    /* renamed from: f  reason: collision with root package name */
    private a2.b f4215f;

    /* renamed from: g  reason: collision with root package name */
    private long f4216g;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4219l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f4220m;

    /* renamed from: e  reason: collision with root package name */
    private final TreeMap f4214e = new TreeMap();

    /* renamed from: d  reason: collision with root package name */
    private final Handler f4213d = s0.y(this);

    /* renamed from: c  reason: collision with root package name */
    private final p1.b f4212c = new p1.b();

    /* renamed from: h  reason: collision with root package name */
    private long f4217h = -9223372036854775807L;

    /* renamed from: k  reason: collision with root package name */
    private long f4218k = -9223372036854775807L;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f4221a;

        /* renamed from: b  reason: collision with root package name */
        public final long f4222b;

        public a(long j6, long j7) {
            this.f4221a = j6;
            this.f4222b = j7;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b(long j6);
    }

    /* loaded from: classes.dex */
    public final class c implements a0 {

        /* renamed from: a  reason: collision with root package name */
        private final q0 f4223a;

        /* renamed from: b  reason: collision with root package name */
        private final t0 f4224b = new t0();

        /* renamed from: c  reason: collision with root package name */
        private final n1.e f4225c = new n1.e();

        c(q2.b bVar) {
            this.f4223a = new q0(bVar, e.this.f4213d.getLooper(), u.c(), new t.a());
        }

        private n1.e g() {
            this.f4225c.clear();
            if (this.f4223a.N(this.f4224b, this.f4225c, false, false) == -4) {
                this.f4225c.g();
                return this.f4225c;
            }
            return null;
        }

        private void k(long j6, long j7) {
            e.this.f4213d.sendMessage(e.this.f4213d.obtainMessage(1, new a(j6, j7)));
        }

        private void l() {
            while (this.f4223a.H(false)) {
                n1.e g6 = g();
                if (g6 != null) {
                    long j6 = g6.f3602d;
                    n1.a a6 = e.this.f4212c.a(g6);
                    if (a6 != null) {
                        p1.a aVar = (p1.a) a6.g(0);
                        if (e.g(aVar.f12611a, aVar.f12612b)) {
                            m(j6, aVar);
                        }
                    }
                }
            }
            this.f4223a.p();
        }

        private void m(long j6, p1.a aVar) {
            long e6 = e.e(aVar);
            if (e6 == -9223372036854775807L) {
                return;
            }
            k(j6, e6);
        }

        @Override // c1.a0
        public /* synthetic */ void a(y yVar, int i6) {
            z.b(this, yVar, i6);
        }

        @Override // c1.a0
        public /* synthetic */ int b(h hVar, int i6, boolean z5) {
            return z.a(this, hVar, i6, z5);
        }

        @Override // c1.a0
        public int c(h hVar, int i6, boolean z5, int i7) {
            return this.f4223a.b(hVar, i6, z5);
        }

        @Override // c1.a0
        public void d(long j6, int i6, int i7, int i8, a0.a aVar) {
            this.f4223a.d(j6, i6, i7, i8, aVar);
            l();
        }

        @Override // c1.a0
        public void e(com.google.android.exoplayer2.s0 s0Var) {
            this.f4223a.e(s0Var);
        }

        @Override // c1.a0
        public void f(y yVar, int i6, int i7) {
            this.f4223a.a(yVar, i6);
        }

        public boolean h(long j6) {
            return e.this.i(j6);
        }

        public boolean i(y1.e eVar) {
            return e.this.j(eVar);
        }

        public void j(y1.e eVar) {
            e.this.m(eVar);
        }

        public void n() {
            this.f4223a.P();
        }
    }

    public e(a2.b bVar, b bVar2, q2.b bVar3) {
        this.f4215f = bVar;
        this.f4211b = bVar2;
        this.f4210a = bVar3;
    }

    private Map.Entry d(long j6) {
        return this.f4214e.ceilingEntry(Long.valueOf(j6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long e(p1.a aVar) {
        try {
            return s0.A0(s0.E(aVar.f12615e));
        } catch (f1 unused) {
            return -9223372036854775807L;
        }
    }

    private void f(long j6, long j7) {
        Long l6 = (Long) this.f4214e.get(Long.valueOf(j7));
        if (l6 != null && l6.longValue() <= j6) {
            return;
        }
        this.f4214e.put(Long.valueOf(j7), Long.valueOf(j6));
    }

    public static boolean g(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    private void h() {
        long j6 = this.f4218k;
        if (j6 == -9223372036854775807L || j6 != this.f4217h) {
            this.f4219l = true;
            this.f4218k = this.f4217h;
            this.f4211b.a();
        }
    }

    private void l() {
        this.f4211b.b(this.f4216g);
    }

    private void o() {
        Iterator it = this.f4214e.entrySet().iterator();
        while (it.hasNext()) {
            if (((Long) ((Map.Entry) it.next()).getKey()).longValue() < this.f4215f.f58h) {
                it.remove();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f4220m) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        f(aVar.f4221a, aVar.f4222b);
        return true;
    }

    boolean i(long j6) {
        a2.b bVar = this.f4215f;
        boolean z5 = false;
        if (bVar.f54d) {
            if (this.f4219l) {
                return true;
            }
            Map.Entry d6 = d(bVar.f58h);
            if (d6 != null && ((Long) d6.getValue()).longValue() < j6) {
                this.f4216g = ((Long) d6.getKey()).longValue();
                l();
                z5 = true;
            }
            if (z5) {
                h();
            }
            return z5;
        }
        return false;
    }

    boolean j(y1.e eVar) {
        if (this.f4215f.f54d) {
            if (this.f4219l) {
                return true;
            }
            long j6 = this.f4217h;
            if (j6 != -9223372036854775807L && j6 < eVar.f14286g) {
                h();
                return true;
            }
            return false;
        }
        return false;
    }

    public c k() {
        return new c(this.f4210a);
    }

    void m(y1.e eVar) {
        long j6 = this.f4217h;
        if (j6 != -9223372036854775807L || eVar.f14287h > j6) {
            this.f4217h = eVar.f14287h;
        }
    }

    public void n() {
        this.f4220m = true;
        this.f4213d.removeCallbacksAndMessages(null);
    }

    public void p(a2.b bVar) {
        this.f4219l = false;
        this.f4216g = -9223372036854775807L;
        this.f4215f = bVar;
        o();
    }
}
