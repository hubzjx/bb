package w1;

import android.net.Uri;
import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.y1;
import q2.l;
import w1.v;
/* loaded from: classes.dex */
public final class w0 extends w1.a {

    /* renamed from: g  reason: collision with root package name */
    private final q2.o f14079g;

    /* renamed from: h  reason: collision with root package name */
    private final l.a f14080h;

    /* renamed from: k  reason: collision with root package name */
    private final com.google.android.exoplayer2.s0 f14081k;

    /* renamed from: l  reason: collision with root package name */
    private final long f14082l;

    /* renamed from: m  reason: collision with root package name */
    private final q2.c0 f14083m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f14084n;

    /* renamed from: o  reason: collision with root package name */
    private final y1 f14085o;

    /* renamed from: p  reason: collision with root package name */
    private final com.google.android.exoplayer2.w0 f14086p;

    /* renamed from: q  reason: collision with root package name */
    private q2.i0 f14087q;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final l.a f14088a;

        /* renamed from: b  reason: collision with root package name */
        private q2.c0 f14089b = new q2.w();

        /* renamed from: c  reason: collision with root package name */
        private boolean f14090c;

        /* renamed from: d  reason: collision with root package name */
        private Object f14091d;

        /* renamed from: e  reason: collision with root package name */
        private String f14092e;

        public b(l.a aVar) {
            this.f14088a = (l.a) com.google.android.exoplayer2.util.a.e(aVar);
        }

        public w0 a(w0.f fVar, long j6) {
            return new w0(this.f14092e, fVar, this.f14088a, j6, this.f14089b, this.f14090c, this.f14091d);
        }
    }

    private w0(String str, w0.f fVar, l.a aVar, long j6, q2.c0 c0Var, boolean z5, Object obj) {
        this.f14080h = aVar;
        this.f14082l = j6;
        this.f14083m = c0Var;
        this.f14084n = z5;
        new w0.b().g(Uri.EMPTY);
        throw null;
    }

    @Override // w1.a
    protected void A(q2.i0 i0Var) {
        this.f14087q = i0Var;
        B(this.f14085o);
    }

    @Override // w1.a
    protected void C() {
    }

    @Override // w1.v
    public com.google.android.exoplayer2.w0 a() {
        return this.f14086p;
    }

    @Override // w1.v
    public void e() {
    }

    @Override // w1.v
    public void i(t tVar) {
        ((v0) tVar).r();
    }

    @Override // w1.v
    public t o(v.a aVar, q2.b bVar, long j6) {
        return new v0(this.f14079g, this.f14080h, this.f14087q, this.f14081k, this.f14082l, this.f14083m, v(aVar), this.f14084n);
    }
}
