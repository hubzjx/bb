package com.google.android.exoplayer2.drm;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.drm.m;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.drm.z;
import com.google.android.exoplayer2.util.s0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import q2.c0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements m {

    /* renamed from: a  reason: collision with root package name */
    public final List f3635a;

    /* renamed from: b  reason: collision with root package name */
    private final z f3636b;

    /* renamed from: c  reason: collision with root package name */
    private final a f3637c;

    /* renamed from: d  reason: collision with root package name */
    private final b f3638d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3639e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f3640f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f3641g;

    /* renamed from: h  reason: collision with root package name */
    private final HashMap f3642h;

    /* renamed from: i  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.h f3643i;

    /* renamed from: j  reason: collision with root package name */
    private final q2.c0 f3644j;

    /* renamed from: k  reason: collision with root package name */
    final g0 f3645k;

    /* renamed from: l  reason: collision with root package name */
    final UUID f3646l;

    /* renamed from: m  reason: collision with root package name */
    final e f3647m;

    /* renamed from: n  reason: collision with root package name */
    private int f3648n;

    /* renamed from: o  reason: collision with root package name */
    private int f3649o;

    /* renamed from: p  reason: collision with root package name */
    private HandlerThread f3650p;

    /* renamed from: q  reason: collision with root package name */
    private c f3651q;

    /* renamed from: r  reason: collision with root package name */
    private y f3652r;

    /* renamed from: s  reason: collision with root package name */
    private m.a f3653s;

    /* renamed from: t  reason: collision with root package name */
    private byte[] f3654t;

    /* renamed from: u  reason: collision with root package name */
    private byte[] f3655u;

    /* renamed from: v  reason: collision with root package name */
    private z.a f3656v;

    /* renamed from: w  reason: collision with root package name */
    private z.d f3657w;

    /* loaded from: classes.dex */
    public interface a {
        void a(h hVar);

        void b(Exception exc);

        void c();
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(h hVar, int i6);

        void b(h hVar, int i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, h0 h0Var) {
            d dVar = (d) message.obj;
            if (dVar.f3660b) {
                int i6 = dVar.f3663e + 1;
                dVar.f3663e = i6;
                if (i6 > h.this.f3644j.d(3)) {
                    return false;
                }
                long b6 = h.this.f3644j.b(new c0.a(new w1.p(dVar.f3659a, h0Var.dataSpec, h0Var.uriAfterRedirects, h0Var.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.f3661c, h0Var.bytesLoaded), new w1.s(3), h0Var.getCause() instanceof IOException ? (IOException) h0Var.getCause() : new f(h0Var.getCause()), dVar.f3663e));
                if (b6 == -9223372036854775807L) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), b6);
                return true;
            }
            return false;
        }

        void b(int i6, Object obj, boolean z5) {
            obtainMessage(i6, new d(w1.p.a(), z5, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Throwable, java.lang.Exception] */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr;
            d dVar = (d) message.obj;
            try {
                int i6 = message.what;
                if (i6 == 0) {
                    h hVar = h.this;
                    bArr = hVar.f3645k.b(hVar.f3646l, (z.d) dVar.f3662d);
                } else if (i6 != 1) {
                    throw new RuntimeException();
                } else {
                    h hVar2 = h.this;
                    bArr = hVar2.f3645k.a(hVar2.f3646l, (z.a) dVar.f3662d);
                }
            } catch (h0 e6) {
                boolean a6 = a(message, e6);
                bArr = e6;
                if (a6) {
                    return;
                }
            } catch (Exception e7) {
                com.google.android.exoplayer2.util.n.i("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e7);
                bArr = e7;
            }
            h.this.f3644j.a(dVar.f3659a);
            h.this.f3647m.obtainMessage(message.what, Pair.create(dVar.f3662d, bArr)).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f3659a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3660b;

        /* renamed from: c  reason: collision with root package name */
        public final long f3661c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f3662d;

        /* renamed from: e  reason: collision with root package name */
        public int f3663e;

        public d(long j6, boolean z5, long j7, Object obj) {
            this.f3659a = j6;
            this.f3660b = z5;
            this.f3661c = j7;
            this.f3662d = obj;
        }
    }

    /* loaded from: classes.dex */
    private class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i6 = message.what;
            if (i6 == 0) {
                h.this.x(obj, obj2);
            } else if (i6 != 1) {
            } else {
                h.this.r(obj, obj2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends IOException {
        public f(Throwable th) {
            super(th);
        }
    }

    public h(UUID uuid, z zVar, a aVar, b bVar, List list, int i6, boolean z5, boolean z6, byte[] bArr, HashMap hashMap, g0 g0Var, Looper looper, q2.c0 c0Var) {
        List unmodifiableList;
        if (i6 == 1 || i6 == 3) {
            com.google.android.exoplayer2.util.a.e(bArr);
        }
        this.f3646l = uuid;
        this.f3637c = aVar;
        this.f3638d = bVar;
        this.f3636b = zVar;
        this.f3639e = i6;
        this.f3640f = z5;
        this.f3641g = z6;
        if (bArr != null) {
            this.f3655u = bArr;
            unmodifiableList = null;
        } else {
            unmodifiableList = Collections.unmodifiableList((List) com.google.android.exoplayer2.util.a.e(list));
        }
        this.f3635a = unmodifiableList;
        this.f3642h = hashMap;
        this.f3645k = g0Var;
        this.f3643i = new com.google.android.exoplayer2.util.h();
        this.f3644j = c0Var;
        this.f3648n = 2;
        this.f3647m = new e(looper);
    }

    private boolean B() {
        try {
            this.f3636b.c(this.f3654t, this.f3655u);
            return true;
        } catch (Exception e6) {
            com.google.android.exoplayer2.util.n.d("DefaultDrmSession", "Error trying to restore keys.", e6);
            q(e6);
            return false;
        }
    }

    private void k(com.google.android.exoplayer2.util.g gVar) {
        for (t.a aVar : this.f3643i.elementSet()) {
            gVar.a(aVar);
        }
    }

    private void l(boolean z5) {
        if (this.f3641g) {
            return;
        }
        byte[] bArr = (byte[]) s0.j(this.f3654t);
        int i6 = this.f3639e;
        if (i6 == 0 || i6 == 1) {
            if (this.f3655u == null) {
                z(bArr, 1, z5);
                return;
            } else if (this.f3648n != 4 && !B()) {
                return;
            } else {
                long m5 = m();
                if (this.f3639e != 0 || m5 > 60) {
                    if (m5 <= 0) {
                        q(new f0());
                        return;
                    }
                    this.f3648n = 4;
                    k(new com.google.android.exoplayer2.util.g() { // from class: com.google.android.exoplayer2.drm.f
                        @Override // com.google.android.exoplayer2.util.g
                        public final void a(Object obj) {
                            ((t.a) obj).j();
                        }
                    });
                    return;
                }
                StringBuilder sb = new StringBuilder(88);
                sb.append("Offline license has expired or will expire soon. Remaining seconds: ");
                sb.append(m5);
                com.google.android.exoplayer2.util.n.b("DefaultDrmSession", sb.toString());
            }
        } else if (i6 != 2) {
            if (i6 != 3) {
                return;
            }
            com.google.android.exoplayer2.util.a.e(this.f3655u);
            com.google.android.exoplayer2.util.a.e(this.f3654t);
            if (B()) {
                z(this.f3655u, 3, z5);
                return;
            }
            return;
        } else if (this.f3655u != null && !B()) {
            return;
        }
        z(bArr, 2, z5);
    }

    private long m() {
        if (com.google.android.exoplayer2.p.f3951d.equals(this.f3646l)) {
            Pair pair = (Pair) com.google.android.exoplayer2.util.a.e(k0.b(this));
            return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
        }
        return Long.MAX_VALUE;
    }

    private boolean o() {
        int i6 = this.f3648n;
        return i6 == 3 || i6 == 4;
    }

    private void q(final Exception exc) {
        this.f3653s = new m.a(exc);
        k(new com.google.android.exoplayer2.util.g() { // from class: com.google.android.exoplayer2.drm.e
            @Override // com.google.android.exoplayer2.util.g
            public final void a(Object obj) {
                ((t.a) obj).l(exc);
            }
        });
        if (this.f3648n != 4) {
            this.f3648n = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Object obj, Object obj2) {
        com.google.android.exoplayer2.util.g gVar;
        if (obj == this.f3656v && o()) {
            this.f3656v = null;
            if (obj2 instanceof Exception) {
                s((Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f3639e == 3) {
                    this.f3636b.g((byte[]) s0.j(this.f3655u), bArr);
                    gVar = new com.google.android.exoplayer2.util.g() { // from class: com.google.android.exoplayer2.drm.c
                        @Override // com.google.android.exoplayer2.util.g
                        public final void a(Object obj3) {
                            ((t.a) obj3).i();
                        }
                    };
                } else {
                    byte[] g6 = this.f3636b.g(this.f3654t, bArr);
                    int i6 = this.f3639e;
                    if ((i6 == 2 || (i6 == 0 && this.f3655u != null)) && g6 != null && g6.length != 0) {
                        this.f3655u = g6;
                    }
                    this.f3648n = 4;
                    gVar = new com.google.android.exoplayer2.util.g() { // from class: com.google.android.exoplayer2.drm.d
                        @Override // com.google.android.exoplayer2.util.g
                        public final void a(Object obj3) {
                            ((t.a) obj3).h();
                        }
                    };
                }
                k(gVar);
            } catch (Exception e6) {
                s(e6);
            }
        }
    }

    private void s(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.f3637c.a(this);
        } else {
            q(exc);
        }
    }

    private void t() {
        if (this.f3639e == 0 && this.f3648n == 4) {
            s0.j(this.f3654t);
            l(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Object obj, Object obj2) {
        if (obj == this.f3657w) {
            if (this.f3648n == 2 || o()) {
                this.f3657w = null;
                if (obj2 instanceof Exception) {
                    this.f3637c.b((Exception) obj2);
                    return;
                }
                try {
                    this.f3636b.j((byte[]) obj2);
                    this.f3637c.c();
                } catch (Exception e6) {
                    this.f3637c.b(e6);
                }
            }
        }
    }

    private boolean y(boolean z5) {
        if (o()) {
            return true;
        }
        try {
            byte[] l6 = this.f3636b.l();
            this.f3654t = l6;
            this.f3652r = this.f3636b.h(l6);
            k(new com.google.android.exoplayer2.util.g() { // from class: com.google.android.exoplayer2.drm.b
                @Override // com.google.android.exoplayer2.util.g
                public final void a(Object obj) {
                    ((t.a) obj).k();
                }
            });
            this.f3648n = 3;
            com.google.android.exoplayer2.util.a.e(this.f3654t);
            return true;
        } catch (NotProvisionedException e6) {
            if (z5) {
                this.f3637c.a(this);
                return false;
            }
            q(e6);
            return false;
        } catch (Exception e7) {
            q(e7);
            return false;
        }
    }

    private void z(byte[] bArr, int i6, boolean z5) {
        try {
            this.f3656v = this.f3636b.k(bArr, this.f3635a, i6, this.f3642h);
            ((c) s0.j(this.f3651q)).b(1, com.google.android.exoplayer2.util.a.e(this.f3656v), z5);
        } catch (Exception e6) {
            s(e6);
        }
    }

    public void A() {
        this.f3657w = this.f3636b.i();
        ((c) s0.j(this.f3651q)).b(0, com.google.android.exoplayer2.util.a.e(this.f3657w), true);
    }

    @Override // com.google.android.exoplayer2.drm.m
    public boolean a() {
        return this.f3640f;
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void b(t.a aVar) {
        com.google.android.exoplayer2.util.a.g(this.f3649o >= 0);
        if (aVar != null) {
            this.f3643i.a(aVar);
        }
        int i6 = this.f3649o + 1;
        this.f3649o = i6;
        if (i6 == 1) {
            com.google.android.exoplayer2.util.a.g(this.f3648n == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f3650p = handlerThread;
            handlerThread.start();
            this.f3651q = new c(this.f3650p.getLooper());
            if (y(true)) {
                l(true);
            }
        } else if (aVar != null && o()) {
            aVar.k();
        }
        this.f3638d.b(this, this.f3649o);
    }

    @Override // com.google.android.exoplayer2.drm.m
    public Map c() {
        byte[] bArr = this.f3654t;
        if (bArr == null) {
            return null;
        }
        return this.f3636b.d(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void d(t.a aVar) {
        com.google.android.exoplayer2.util.a.g(this.f3649o > 0);
        int i6 = this.f3649o - 1;
        this.f3649o = i6;
        if (i6 == 0) {
            this.f3648n = 0;
            ((e) s0.j(this.f3647m)).removeCallbacksAndMessages(null);
            ((c) s0.j(this.f3651q)).removeCallbacksAndMessages(null);
            this.f3651q = null;
            ((HandlerThread) s0.j(this.f3650p)).quit();
            this.f3650p = null;
            this.f3652r = null;
            this.f3653s = null;
            this.f3656v = null;
            this.f3657w = null;
            byte[] bArr = this.f3654t;
            if (bArr != null) {
                this.f3636b.e(bArr);
                this.f3654t = null;
            }
            k(new com.google.android.exoplayer2.util.g() { // from class: com.google.android.exoplayer2.drm.g
                @Override // com.google.android.exoplayer2.util.g
                public final void a(Object obj) {
                    ((t.a) obj).m();
                }
            });
        }
        if (aVar != null) {
            if (o()) {
                aVar.m();
            }
            this.f3643i.b(aVar);
        }
        this.f3638d.a(this, this.f3649o);
    }

    @Override // com.google.android.exoplayer2.drm.m
    public final y e() {
        return this.f3652r;
    }

    @Override // com.google.android.exoplayer2.drm.m
    public final m.a f() {
        if (this.f3648n == 1) {
            return this.f3653s;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.m
    public final int getState() {
        return this.f3648n;
    }

    public boolean n(byte[] bArr) {
        return Arrays.equals(this.f3654t, bArr);
    }

    public void u(int i6) {
        if (i6 != 2) {
            return;
        }
        t();
    }

    public void v() {
        if (y(false)) {
            l(true);
        }
    }

    public void w(Exception exc) {
        q(exc);
    }
}
