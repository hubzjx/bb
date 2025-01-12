package com.google.android.exoplayer2.util;
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    private long f4636a;

    /* renamed from: b  reason: collision with root package name */
    private long f4637b;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f4638c = -9223372036854775807L;

    public k0(long j6) {
        h(j6);
    }

    public static long f(long j6) {
        return (j6 * 1000000) / 90000;
    }

    public static long i(long j6) {
        return (j6 * 90000) / 1000000;
    }

    public static long j(long j6) {
        return i(j6) % 8589934592L;
    }

    public long a(long j6) {
        if (j6 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f4638c != -9223372036854775807L) {
            this.f4638c = j6;
        } else {
            long j7 = this.f4636a;
            if (j7 != Long.MAX_VALUE) {
                this.f4637b = j7 - j6;
            }
            synchronized (this) {
                this.f4638c = j6;
                notifyAll();
            }
        }
        return j6 + this.f4637b;
    }

    public long b(long j6) {
        if (j6 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f4638c != -9223372036854775807L) {
            long i6 = i(this.f4638c);
            long j7 = (4294967296L + i6) / 8589934592L;
            long j8 = ((j7 - 1) * 8589934592L) + j6;
            j6 += j7 * 8589934592L;
            if (Math.abs(j8 - i6) < Math.abs(j6 - i6)) {
                j6 = j8;
            }
        }
        return a(f(j6));
    }

    public long c() {
        return this.f4636a;
    }

    public long d() {
        if (this.f4638c != -9223372036854775807L) {
            return this.f4637b + this.f4638c;
        }
        long j6 = this.f4636a;
        if (j6 != Long.MAX_VALUE) {
            return j6;
        }
        return -9223372036854775807L;
    }

    public long e() {
        if (this.f4636a == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.f4638c == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f4637b;
    }

    public void g() {
        this.f4638c = -9223372036854775807L;
    }

    public synchronized void h(long j6) {
        a.g(this.f4638c == -9223372036854775807L);
        this.f4636a = j6;
    }

    public synchronized void k() {
        while (this.f4638c == -9223372036854775807L) {
            wait();
        }
    }
}
