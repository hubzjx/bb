package e;

import f.InterfaceC0272j$t;
/* renamed from: e.j$k  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0237j$k implements f.j$E, InterfaceC0272j$t {
    private long count;
    private long sum;
    private long min = Long.MAX_VALUE;
    private long max = Long.MIN_VALUE;

    public final void b(C0237j$k c0237j$k) {
        this.count += c0237j$k.count;
        this.sum += c0237j$k.sum;
        this.min = Math.min(this.min, c0237j$k.min);
        this.max = Math.max(this.max, c0237j$k.max);
    }

    public final long c() {
        return this.count;
    }

    public final long d() {
        return this.max;
    }

    @Override // f.InterfaceC0272j$t
    public final void e(int i6) {
        f(i6);
    }

    @Override // f.j$E
    public final void f(long j6) {
        this.count++;
        this.sum += j6;
        this.min = Math.min(this.min, j6);
        this.max = Math.max(this.max, j6);
    }

    public final long g() {
        return this.min;
    }

    public final long h() {
        return this.sum;
    }

    public final String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = C0237j$k.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Long.valueOf(this.sum);
        objArr[3] = Long.valueOf(this.min);
        long j6 = this.count;
        objArr[4] = Double.valueOf(j6 > 0 ? this.sum / j6 : 0.0d);
        objArr[5] = Long.valueOf(this.max);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
