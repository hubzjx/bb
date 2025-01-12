package e2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.t0;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.q;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class m extends o implements Handler.Callback {
    private k A;
    private int B;

    /* renamed from: o  reason: collision with root package name */
    private final Handler f9473o;

    /* renamed from: p  reason: collision with root package name */
    private final l f9474p;

    /* renamed from: q  reason: collision with root package name */
    private final i f9475q;

    /* renamed from: r  reason: collision with root package name */
    private final t0 f9476r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f9477s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f9478t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f9479u;

    /* renamed from: v  reason: collision with root package name */
    private int f9480v;

    /* renamed from: w  reason: collision with root package name */
    private s0 f9481w;

    /* renamed from: x  reason: collision with root package name */
    private g f9482x;

    /* renamed from: y  reason: collision with root package name */
    private j f9483y;

    /* renamed from: z  reason: collision with root package name */
    private k f9484z;

    public m(l lVar, Looper looper) {
        this(lVar, looper, i.f9469a);
    }

    private void P() {
        X(Collections.emptyList());
    }

    private long Q() {
        if (this.B == -1) {
            return Long.MAX_VALUE;
        }
        com.google.android.exoplayer2.util.a.e(this.f9484z);
        if (this.B >= this.f9484z.d()) {
            return Long.MAX_VALUE;
        }
        return this.f9484z.b(this.B);
    }

    private void R(h hVar) {
        String valueOf = String.valueOf(this.f9481w);
        StringBuilder sb = new StringBuilder(valueOf.length() + 39);
        sb.append("Subtitle decoding failed. streamFormat=");
        sb.append(valueOf);
        n.d("TextRenderer", sb.toString(), hVar);
        P();
        W();
    }

    private void S() {
        this.f9479u = true;
        this.f9482x = this.f9475q.b((s0) com.google.android.exoplayer2.util.a.e(this.f9481w));
    }

    private void T(List list) {
        this.f9474p.n(list);
    }

    private void U() {
        this.f9483y = null;
        this.B = -1;
        k kVar = this.f9484z;
        if (kVar != null) {
            kVar.release();
            this.f9484z = null;
        }
        k kVar2 = this.A;
        if (kVar2 != null) {
            kVar2.release();
            this.A = null;
        }
    }

    private void V() {
        U();
        ((g) com.google.android.exoplayer2.util.a.e(this.f9482x)).a();
        this.f9482x = null;
        this.f9480v = 0;
    }

    private void W() {
        V();
        S();
    }

    private void X(List list) {
        Handler handler = this.f9473o;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            T(list);
        }
    }

    @Override // com.google.android.exoplayer2.o
    protected void G() {
        this.f9481w = null;
        P();
        V();
    }

    @Override // com.google.android.exoplayer2.o
    protected void I(long j6, boolean z5) {
        P();
        this.f9477s = false;
        this.f9478t = false;
        if (this.f9480v != 0) {
            W();
            return;
        }
        U();
        ((g) com.google.android.exoplayer2.util.a.e(this.f9482x)).flush();
    }

    @Override // com.google.android.exoplayer2.o
    protected void M(s0[] s0VarArr, long j6, long j7) {
        this.f9481w = s0VarArr[0];
        if (this.f9482x != null) {
            this.f9480v = 1;
        } else {
            S();
        }
    }

    @Override // com.google.android.exoplayer2.p1
    public int a(s0 s0Var) {
        if (this.f9475q.a(s0Var)) {
            return o1.a(s0Var.G == null ? 4 : 2);
        }
        return o1.a(q.p(s0Var.f4056n) ? 1 : 0);
    }

    @Override // com.google.android.exoplayer2.n1
    public boolean d() {
        return this.f9478t;
    }

    @Override // com.google.android.exoplayer2.n1, com.google.android.exoplayer2.p1
    public String f() {
        return "TextRenderer";
    }

    @Override // com.google.android.exoplayer2.n1
    public boolean g() {
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            T((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.n1
    public void o(long j6, long j7) {
        boolean z5;
        if (this.f9478t) {
            return;
        }
        if (this.A == null) {
            ((g) com.google.android.exoplayer2.util.a.e(this.f9482x)).b(j6);
            try {
                this.A = (k) ((g) com.google.android.exoplayer2.util.a.e(this.f9482x)).d();
            } catch (h e6) {
                R(e6);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.f9484z != null) {
            long Q = Q();
            z5 = false;
            while (Q <= j6) {
                this.B++;
                Q = Q();
                z5 = true;
            }
        } else {
            z5 = false;
        }
        k kVar = this.A;
        if (kVar != null) {
            if (kVar.isEndOfStream()) {
                if (!z5 && Q() == Long.MAX_VALUE) {
                    if (this.f9480v == 2) {
                        W();
                    } else {
                        U();
                        this.f9478t = true;
                    }
                }
            } else if (kVar.timeUs <= j6) {
                k kVar2 = this.f9484z;
                if (kVar2 != null) {
                    kVar2.release();
                }
                this.B = kVar.a(j6);
                this.f9484z = kVar;
                this.A = null;
                z5 = true;
            }
        }
        if (z5) {
            com.google.android.exoplayer2.util.a.e(this.f9484z);
            X(this.f9484z.c(j6));
        }
        if (this.f9480v == 2) {
            return;
        }
        while (!this.f9477s) {
            try {
                j jVar = this.f9483y;
                if (jVar == null) {
                    jVar = (j) ((g) com.google.android.exoplayer2.util.a.e(this.f9482x)).e();
                    if (jVar == null) {
                        return;
                    }
                    this.f9483y = jVar;
                }
                if (this.f9480v == 1) {
                    jVar.setFlags(4);
                    ((g) com.google.android.exoplayer2.util.a.e(this.f9482x)).c(jVar);
                    this.f9483y = null;
                    this.f9480v = 2;
                    return;
                }
                int N = N(this.f9476r, jVar, false);
                if (N == -4) {
                    if (jVar.isEndOfStream()) {
                        this.f9477s = true;
                        this.f9479u = false;
                    } else {
                        s0 s0Var = this.f9476r.f4441b;
                        if (s0Var == null) {
                            return;
                        }
                        jVar.f9470h = s0Var.f4060r;
                        jVar.g();
                        this.f9479u &= !jVar.isKeyFrame();
                    }
                    if (!this.f9479u) {
                        ((g) com.google.android.exoplayer2.util.a.e(this.f9482x)).c(jVar);
                        this.f9483y = null;
                    }
                } else if (N == -3) {
                    return;
                }
            } catch (h e7) {
                R(e7);
                return;
            }
        }
    }

    public m(l lVar, Looper looper, i iVar) {
        super(3);
        this.f9474p = (l) com.google.android.exoplayer2.util.a.e(lVar);
        this.f9473o = looper == null ? null : com.google.android.exoplayer2.util.s0.w(looper, this);
        this.f9475q = iVar;
        this.f9476r = new t0();
    }
}
