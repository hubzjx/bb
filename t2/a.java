package t2;

import com.google.android.exoplayer2.decoder.j;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.y;
/* loaded from: classes.dex */
public final class a extends o {

    /* renamed from: o  reason: collision with root package name */
    private final j f13380o;

    /* renamed from: p  reason: collision with root package name */
    private final y f13381p;

    /* renamed from: q  reason: collision with root package name */
    private long f13382q;

    /* renamed from: r  reason: collision with root package name */
    private long f13383r;

    public a() {
        super(5);
        this.f13380o = new j(1);
        this.f13381p = new y();
    }

    private void P() {
    }

    @Override // com.google.android.exoplayer2.o
    protected void G() {
        P();
    }

    @Override // com.google.android.exoplayer2.o
    protected void I(long j6, boolean z5) {
        this.f13383r = Long.MIN_VALUE;
        P();
    }

    @Override // com.google.android.exoplayer2.o
    protected void M(s0[] s0VarArr, long j6, long j7) {
        this.f13382q = j7;
    }

    @Override // com.google.android.exoplayer2.p1
    public int a(s0 s0Var) {
        return o1.a("application/x-camera-motion".equals(s0Var.f4056n) ? 4 : 0);
    }

    @Override // com.google.android.exoplayer2.n1
    public boolean d() {
        return l();
    }

    @Override // com.google.android.exoplayer2.n1, com.google.android.exoplayer2.p1
    public String f() {
        return "CameraMotionRenderer";
    }

    @Override // com.google.android.exoplayer2.n1
    public boolean g() {
        return true;
    }

    @Override // com.google.android.exoplayer2.n1
    public void o(long j6, long j7) {
        while (!l() && this.f13383r < 100000 + j6) {
            this.f13380o.clear();
            if (N(C(), this.f13380o, false) != -4 || this.f13380o.isEndOfStream()) {
                return;
            }
            this.f13383r = this.f13380o.f3602d;
        }
    }

    @Override // com.google.android.exoplayer2.o, com.google.android.exoplayer2.k1.b
    public void p(int i6, Object obj) {
        if (i6 == 7) {
            android.support.v4.media.a.a(obj);
        } else {
            super.p(i6, obj);
        }
    }
}
