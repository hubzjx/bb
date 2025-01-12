package com.google.android.exoplayer2.drm;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.drm.h;
import com.google.android.exoplayer2.drm.k;
import com.google.android.exoplayer2.drm.m;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.drm.z;
import com.google.android.exoplayer2.util.s0;
import com.google.common.collect.m1;
import com.google.common.collect.s1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
/* loaded from: classes.dex */
public class i implements v {

    /* renamed from: b  reason: collision with root package name */
    private final UUID f3665b;

    /* renamed from: c  reason: collision with root package name */
    private final z.c f3666c;

    /* renamed from: d  reason: collision with root package name */
    private final g0 f3667d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap f3668e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f3669f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f3670g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f3671h;

    /* renamed from: i  reason: collision with root package name */
    private final f f3672i;

    /* renamed from: j  reason: collision with root package name */
    private final q2.c0 f3673j;

    /* renamed from: k  reason: collision with root package name */
    private final g f3674k;

    /* renamed from: l  reason: collision with root package name */
    private final long f3675l;

    /* renamed from: m  reason: collision with root package name */
    private final List f3676m;

    /* renamed from: n  reason: collision with root package name */
    private final List f3677n;

    /* renamed from: o  reason: collision with root package name */
    private final Set f3678o;

    /* renamed from: p  reason: collision with root package name */
    private int f3679p;

    /* renamed from: q  reason: collision with root package name */
    private z f3680q;

    /* renamed from: r  reason: collision with root package name */
    private h f3681r;

    /* renamed from: s  reason: collision with root package name */
    private h f3682s;

    /* renamed from: t  reason: collision with root package name */
    private Looper f3683t;

    /* renamed from: u  reason: collision with root package name */
    private Handler f3684u;

    /* renamed from: v  reason: collision with root package name */
    private int f3685v;

    /* renamed from: w  reason: collision with root package name */
    private byte[] f3686w;

    /* renamed from: x  reason: collision with root package name */
    volatile d f3687x;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: d  reason: collision with root package name */
        private boolean f3691d;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3693f;

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f3688a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private UUID f3689b = com.google.android.exoplayer2.p.f3951d;

        /* renamed from: c  reason: collision with root package name */
        private z.c f3690c = d0.f3626d;

        /* renamed from: g  reason: collision with root package name */
        private q2.c0 f3694g = new q2.w();

        /* renamed from: e  reason: collision with root package name */
        private int[] f3692e = new int[0];

        /* renamed from: h  reason: collision with root package name */
        private long f3695h = 300000;

        public i a(g0 g0Var) {
            return new i(this.f3689b, this.f3690c, g0Var, this.f3688a, this.f3691d, this.f3692e, this.f3693f, this.f3694g, this.f3695h);
        }

        public b b(boolean z5) {
            this.f3691d = z5;
            return this;
        }

        public b c(boolean z5) {
            this.f3693f = z5;
            return this;
        }

        public b d(int... iArr) {
            for (int i6 : iArr) {
                boolean z5 = true;
                if (i6 != 2 && i6 != 1) {
                    z5 = false;
                }
                com.google.android.exoplayer2.util.a.a(z5);
            }
            this.f3692e = (int[]) iArr.clone();
            return this;
        }

        public b e(UUID uuid, z.c cVar) {
            this.f3689b = (UUID) com.google.android.exoplayer2.util.a.e(uuid);
            this.f3690c = (z.c) com.google.android.exoplayer2.util.a.e(cVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    private class c implements z.b {
        private c() {
        }

        @Override // com.google.android.exoplayer2.drm.z.b
        public void a(z zVar, byte[] bArr, int i6, int i7, byte[] bArr2) {
            ((d) com.google.android.exoplayer2.util.a.e(i.this.f3687x)).obtainMessage(i6, bArr).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (h hVar : i.this.f3676m) {
                if (hVar.n(bArr)) {
                    hVar.u(message.what);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private e(UUID uuid) {
            super(r1.toString());
            String valueOf = String.valueOf(uuid);
            StringBuilder sb = new StringBuilder(valueOf.length() + 29);
            sb.append("Media does not support uuid: ");
            sb.append(valueOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements h.a {
        private f() {
        }

        @Override // com.google.android.exoplayer2.drm.h.a
        public void a(h hVar) {
            if (i.this.f3677n.contains(hVar)) {
                return;
            }
            i.this.f3677n.add(hVar);
            if (i.this.f3677n.size() == 1) {
                hVar.A();
            }
        }

        @Override // com.google.android.exoplayer2.drm.h.a
        public void b(Exception exc) {
            for (h hVar : i.this.f3677n) {
                hVar.w(exc);
            }
            i.this.f3677n.clear();
        }

        @Override // com.google.android.exoplayer2.drm.h.a
        public void c() {
            for (h hVar : i.this.f3677n) {
                hVar.v();
            }
            i.this.f3677n.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g implements h.b {
        private g() {
        }

        @Override // com.google.android.exoplayer2.drm.h.b
        public void a(final h hVar, int i6) {
            if (i6 == 1 && i.this.f3675l != -9223372036854775807L) {
                i.this.f3678o.add(hVar);
                ((Handler) com.google.android.exoplayer2.util.a.e(i.this.f3684u)).postAtTime(new Runnable() { // from class: com.google.android.exoplayer2.drm.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.this.d(null);
                    }
                }, hVar, SystemClock.uptimeMillis() + i.this.f3675l);
            } else if (i6 == 0) {
                i.this.f3676m.remove(hVar);
                if (i.this.f3681r == hVar) {
                    i.this.f3681r = null;
                }
                if (i.this.f3682s == hVar) {
                    i.this.f3682s = null;
                }
                if (i.this.f3677n.size() > 1 && i.this.f3677n.get(0) == hVar) {
                    ((h) i.this.f3677n.get(1)).A();
                }
                i.this.f3677n.remove(hVar);
                if (i.this.f3675l != -9223372036854775807L) {
                    ((Handler) com.google.android.exoplayer2.util.a.e(i.this.f3684u)).removeCallbacksAndMessages(hVar);
                    i.this.f3678o.remove(hVar);
                }
            }
        }

        @Override // com.google.android.exoplayer2.drm.h.b
        public void b(h hVar, int i6) {
            if (i.this.f3675l != -9223372036854775807L) {
                i.this.f3678o.remove(hVar);
                ((Handler) com.google.android.exoplayer2.util.a.e(i.this.f3684u)).removeCallbacksAndMessages(hVar);
            }
        }
    }

    private i(UUID uuid, z.c cVar, g0 g0Var, HashMap hashMap, boolean z5, int[] iArr, boolean z6, q2.c0 c0Var, long j6) {
        com.google.android.exoplayer2.util.a.e(uuid);
        com.google.android.exoplayer2.util.a.b(!com.google.android.exoplayer2.p.f3949b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f3665b = uuid;
        this.f3666c = cVar;
        this.f3667d = g0Var;
        this.f3668e = hashMap;
        this.f3669f = z5;
        this.f3670g = iArr;
        this.f3671h = z6;
        this.f3673j = c0Var;
        this.f3672i = new f();
        this.f3674k = new g();
        this.f3685v = 0;
        this.f3676m = new ArrayList();
        this.f3677n = new ArrayList();
        this.f3678o = m1.c();
        this.f3675l = j6;
    }

    private boolean n(k kVar) {
        if (this.f3686w != null) {
            return true;
        }
        if (q(kVar, this.f3665b, true).isEmpty()) {
            if (kVar.f3704d != 1 || !kVar.i(0).h(com.google.android.exoplayer2.p.f3949b)) {
                return false;
            }
            String valueOf = String.valueOf(this.f3665b);
            StringBuilder sb = new StringBuilder(valueOf.length() + 72);
            sb.append("DrmInitData only contains common PSSH SchemeData. Assuming support for: ");
            sb.append(valueOf);
            com.google.android.exoplayer2.util.n.h("DefaultDrmSessionMgr", sb.toString());
        }
        String str = kVar.f3703c;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return "cbcs".equals(str) ? s0.f4673a >= 25 : ("cbc1".equals(str) || "cens".equals(str)) ? false : true;
    }

    private h o(List list, boolean z5, t.a aVar) {
        com.google.android.exoplayer2.util.a.e(this.f3680q);
        h hVar = new h(this.f3665b, this.f3680q, this.f3672i, this.f3674k, list, this.f3685v, this.f3671h | z5, z5, this.f3686w, this.f3668e, this.f3667d, (Looper) com.google.android.exoplayer2.util.a.e(this.f3683t), this.f3673j);
        hVar.b(aVar);
        if (this.f3675l != -9223372036854775807L) {
            hVar.b(null);
        }
        return hVar;
    }

    private h p(List list, boolean z5, t.a aVar) {
        h o5 = o(list, z5, aVar);
        if (o5.getState() == 1) {
            if ((s0.f4673a < 19 || (((m.a) com.google.android.exoplayer2.util.a.e(o5.f())).getCause() instanceof ResourceBusyException)) && !this.f3678o.isEmpty()) {
                s1 it = com.google.common.collect.y.copyOf((Collection) this.f3678o).iterator();
                while (it.hasNext()) {
                    ((m) it.next()).d(null);
                }
                o5.d(aVar);
                if (this.f3675l != -9223372036854775807L) {
                    o5.d(null);
                }
                return o(list, z5, aVar);
            }
            return o5;
        }
        return o5;
    }

    private static List q(k kVar, UUID uuid, boolean z5) {
        ArrayList arrayList = new ArrayList(kVar.f3704d);
        for (int i6 = 0; i6 < kVar.f3704d; i6++) {
            k.b i7 = kVar.i(i6);
            if ((i7.h(uuid) || (com.google.android.exoplayer2.p.f3950c.equals(uuid) && i7.h(com.google.android.exoplayer2.p.f3949b))) && (i7.f3709e != null || z5)) {
                arrayList.add(i7);
            }
        }
        return arrayList;
    }

    private void r(Looper looper) {
        Looper looper2 = this.f3683t;
        if (looper2 != null) {
            com.google.android.exoplayer2.util.a.g(looper2 == looper);
            return;
        }
        this.f3683t = looper;
        this.f3684u = new Handler(looper);
    }

    private m s(int i6) {
        z zVar = (z) com.google.android.exoplayer2.util.a.e(this.f3680q);
        if ((a0.class.equals(zVar.b()) && a0.f3620d) || s0.s0(this.f3670g, i6) == -1 || j0.class.equals(zVar.b())) {
            return null;
        }
        h hVar = this.f3681r;
        if (hVar == null) {
            h p5 = p(com.google.common.collect.y.of(), true, null);
            this.f3676m.add(p5);
            this.f3681r = p5;
        } else {
            hVar.b(null);
        }
        return this.f3681r;
    }

    private void t(Looper looper) {
        if (this.f3687x == null) {
            this.f3687x = new d(looper);
        }
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void a() {
        int i6 = this.f3679p - 1;
        this.f3679p = i6;
        if (i6 != 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f3676m);
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            ((h) arrayList.get(i7)).d(null);
        }
        ((z) com.google.android.exoplayer2.util.a.e(this.f3680q)).a();
        this.f3680q = null;
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void b() {
        int i6 = this.f3679p;
        this.f3679p = i6 + 1;
        if (i6 != 0) {
            return;
        }
        com.google.android.exoplayer2.util.a.g(this.f3680q == null);
        z a6 = this.f3666c.a(this.f3665b);
        this.f3680q = a6;
        a6.f(new c());
    }

    @Override // com.google.android.exoplayer2.drm.v
    public m c(Looper looper, t.a aVar, com.google.android.exoplayer2.s0 s0Var) {
        List list;
        r(looper);
        t(looper);
        k kVar = s0Var.f4059q;
        if (kVar == null) {
            return s(com.google.android.exoplayer2.util.q.j(s0Var.f4056n));
        }
        h hVar = null;
        if (this.f3686w == null) {
            list = q((k) com.google.android.exoplayer2.util.a.e(kVar), this.f3665b, false);
            if (list.isEmpty()) {
                e eVar = new e(this.f3665b);
                if (aVar != null) {
                    aVar.l(eVar);
                }
                return new x(new m.a(eVar));
            }
        } else {
            list = null;
        }
        if (this.f3669f) {
            Iterator it = this.f3676m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h hVar2 = (h) it.next();
                if (s0.c(hVar2.f3635a, list)) {
                    hVar = hVar2;
                    break;
                }
            }
        } else {
            hVar = this.f3682s;
        }
        if (hVar == null) {
            hVar = p(list, false, aVar);
            if (!this.f3669f) {
                this.f3682s = hVar;
            }
            this.f3676m.add(hVar);
        } else {
            hVar.b(aVar);
        }
        return hVar;
    }

    @Override // com.google.android.exoplayer2.drm.v
    public Class d(com.google.android.exoplayer2.s0 s0Var) {
        Class b6 = ((z) com.google.android.exoplayer2.util.a.e(this.f3680q)).b();
        k kVar = s0Var.f4059q;
        if (kVar != null) {
            return n(kVar) ? b6 : j0.class;
        }
        if (s0.s0(this.f3670g, com.google.android.exoplayer2.util.q.j(s0Var.f4056n)) != -1) {
            return b6;
        }
        return null;
    }

    public void u(int i6, byte[] bArr) {
        com.google.android.exoplayer2.util.a.g(this.f3676m.isEmpty());
        if (i6 == 1 || i6 == 3) {
            com.google.android.exoplayer2.util.a.e(bArr);
        }
        this.f3685v = i6;
        this.f3686w = bArr;
    }
}
