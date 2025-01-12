package w1;
/* loaded from: classes.dex */
public class h implements s0 {

    /* renamed from: a  reason: collision with root package name */
    protected final s0[] f13842a;

    public h(s0[] s0VarArr) {
        this.f13842a = s0VarArr;
    }

    @Override // w1.s0
    public boolean a() {
        for (s0 s0Var : this.f13842a) {
            if (s0Var.a()) {
                return true;
            }
        }
        return false;
    }

    @Override // w1.s0
    public final long d() {
        long j6 = Long.MAX_VALUE;
        for (s0 s0Var : this.f13842a) {
            long d6 = s0Var.d();
            if (d6 != Long.MIN_VALUE) {
                j6 = Math.min(j6, d6);
            }
        }
        if (j6 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j6;
    }

    @Override // w1.s0
    public final long f() {
        long j6 = Long.MAX_VALUE;
        for (s0 s0Var : this.f13842a) {
            long f6 = s0Var.f();
            if (f6 != Long.MIN_VALUE) {
                j6 = Math.min(j6, f6);
            }
        }
        if (j6 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j6;
    }

    @Override // w1.s0
    public boolean h(long j6) {
        s0[] s0VarArr;
        boolean z5;
        boolean z6 = false;
        do {
            long d6 = d();
            if (d6 == Long.MIN_VALUE) {
                break;
            }
            z5 = false;
            for (s0 s0Var : this.f13842a) {
                long d7 = s0Var.d();
                boolean z7 = d7 != Long.MIN_VALUE && d7 <= j6;
                if (d7 == d6 || z7) {
                    z5 |= s0Var.h(j6);
                }
            }
            z6 |= z5;
        } while (z5);
        return z6;
    }

    @Override // w1.s0
    public final void i(long j6) {
        for (s0 s0Var : this.f13842a) {
            s0Var.i(j6);
        }
    }
}
