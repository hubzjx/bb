package com.google.android.exoplayer2.util;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    private long[] f4632a;

    /* renamed from: b  reason: collision with root package name */
    private Object[] f4633b;

    /* renamed from: c  reason: collision with root package name */
    private int f4634c;

    /* renamed from: d  reason: collision with root package name */
    private int f4635d;

    public j0() {
        this(10);
    }

    private void b(long j6, Object obj) {
        int i6 = this.f4634c;
        int i7 = this.f4635d;
        Object[] objArr = this.f4633b;
        int length = (i6 + i7) % objArr.length;
        this.f4632a[length] = j6;
        objArr[length] = obj;
        this.f4635d = i7 + 1;
    }

    private void d(long j6) {
        int i6 = this.f4635d;
        if (i6 > 0) {
            if (j6 <= this.f4632a[((this.f4634c + i6) - 1) % this.f4633b.length]) {
                c();
            }
        }
    }

    private void e() {
        int length = this.f4633b.length;
        if (this.f4635d < length) {
            return;
        }
        int i6 = length * 2;
        long[] jArr = new long[i6];
        Object[] f6 = f(i6);
        int i7 = this.f4634c;
        int i8 = length - i7;
        System.arraycopy(this.f4632a, i7, jArr, 0, i8);
        System.arraycopy(this.f4633b, this.f4634c, f6, 0, i8);
        int i9 = this.f4634c;
        if (i9 > 0) {
            System.arraycopy(this.f4632a, 0, jArr, i8, i9);
            System.arraycopy(this.f4633b, 0, f6, i8, this.f4634c);
        }
        this.f4632a = jArr;
        this.f4633b = f6;
        this.f4634c = 0;
    }

    private static Object[] f(int i6) {
        return new Object[i6];
    }

    private Object g(long j6, boolean z5) {
        Object obj = null;
        long j7 = Long.MAX_VALUE;
        while (this.f4635d > 0) {
            long j8 = j6 - this.f4632a[this.f4634c];
            if (j8 < 0 && (z5 || (-j8) >= j7)) {
                break;
            }
            obj = j();
            j7 = j8;
        }
        return obj;
    }

    private Object j() {
        a.g(this.f4635d > 0);
        Object[] objArr = this.f4633b;
        int i6 = this.f4634c;
        Object obj = objArr[i6];
        objArr[i6] = null;
        this.f4634c = (i6 + 1) % objArr.length;
        this.f4635d--;
        return obj;
    }

    public synchronized void a(long j6, Object obj) {
        d(j6);
        e();
        b(j6, obj);
    }

    public synchronized void c() {
        this.f4634c = 0;
        this.f4635d = 0;
        Arrays.fill(this.f4633b, (Object) null);
    }

    public synchronized Object h() {
        return this.f4635d == 0 ? null : j();
    }

    public synchronized Object i(long j6) {
        return g(j6, true);
    }

    public synchronized int k() {
        return this.f4635d;
    }

    public j0(int i6) {
        this.f4632a = new long[i6];
        this.f4633b = f(i6);
    }
}
