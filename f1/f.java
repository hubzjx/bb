package f1;

import c1.a0;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.y;
import f1.e;
/* loaded from: classes.dex */
final class f extends e {

    /* renamed from: b  reason: collision with root package name */
    private final y f9791b;

    /* renamed from: c  reason: collision with root package name */
    private final y f9792c;

    /* renamed from: d  reason: collision with root package name */
    private int f9793d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9794e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9795f;

    /* renamed from: g  reason: collision with root package name */
    private int f9796g;

    public f(a0 a0Var) {
        super(a0Var);
        this.f9791b = new y(r.f4652a);
        this.f9792c = new y(4);
    }

    @Override // f1.e
    protected boolean b(y yVar) {
        int A = yVar.A();
        int i6 = (A >> 4) & 15;
        int i7 = A & 15;
        if (i7 == 7) {
            this.f9796g = i6;
            return i6 != 5;
        }
        StringBuilder sb = new StringBuilder(39);
        sb.append("Video format not supported: ");
        sb.append(i7);
        throw new e.a(sb.toString());
    }

    @Override // f1.e
    protected boolean c(y yVar, long j6) {
        int A = yVar.A();
        long l6 = j6 + (yVar.l() * 1000);
        if (A == 0 && !this.f9794e) {
            y yVar2 = new y(new byte[yVar.a()]);
            yVar.i(yVar2.c(), 0, yVar.a());
            s2.a b6 = s2.a.b(yVar2);
            this.f9793d = b6.f13168b;
            this.f9790a.e(new s0.b().e0("video/avc").j0(b6.f13169c).Q(b6.f13170d).a0(b6.f13171e).T(b6.f13167a).E());
            this.f9794e = true;
            return false;
        } else if (A == 1 && this.f9794e) {
            int i6 = this.f9796g == 1 ? 1 : 0;
            if (this.f9795f || i6 != 0) {
                byte[] c6 = this.f9792c.c();
                c6[0] = 0;
                c6[1] = 0;
                c6[2] = 0;
                int i7 = 4 - this.f9793d;
                int i8 = 0;
                while (yVar.a() > 0) {
                    yVar.i(this.f9792c.c(), i7, this.f9793d);
                    this.f9792c.M(0);
                    int E = this.f9792c.E();
                    this.f9791b.M(0);
                    this.f9790a.a(this.f9791b, 4);
                    this.f9790a.a(yVar, E);
                    i8 = i8 + 4 + E;
                }
                this.f9790a.d(l6, i6, i8, 0, null);
                this.f9795f = true;
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}
