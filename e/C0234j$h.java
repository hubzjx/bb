package e;

import f.InterfaceC0272j$t;
/* renamed from: e.j$h  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0234j$h implements InterfaceC0272j$t {
    private long count;
    private long sum;
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;

    public final void b(C0234j$h c0234j$h) {
        this.count += c0234j$h.count;
        this.sum += c0234j$h.sum;
        this.min = Math.min(this.min, c0234j$h.min);
        this.max = Math.max(this.max, c0234j$h.max);
    }

    public final long c() {
        return this.count;
    }

    public final int d() {
        return this.max;
    }

    @Override // f.InterfaceC0272j$t
    public final void e(int i6) {
        this.count++;
        this.sum += i6;
        this.min = Math.min(this.min, i6);
        this.max = Math.max(this.max, i6);
    }

    public final int f() {
        return this.min;
    }

    public final long g() {
        return this.sum;
    }

    public final String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = C0234j$h.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Long.valueOf(this.sum);
        objArr[3] = Integer.valueOf(this.min);
        long j6 = this.count;
        objArr[4] = Double.valueOf(j6 > 0 ? this.sum / j6 : 0.0d);
        objArr[5] = Integer.valueOf(this.max);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
