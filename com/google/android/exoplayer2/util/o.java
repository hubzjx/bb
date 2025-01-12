package com.google.android.exoplayer2.util;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private int f4646a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f4647b;

    public o() {
        this(32);
    }

    public void a(long j6) {
        int i6 = this.f4646a;
        long[] jArr = this.f4647b;
        if (i6 == jArr.length) {
            this.f4647b = Arrays.copyOf(jArr, i6 * 2);
        }
        long[] jArr2 = this.f4647b;
        int i7 = this.f4646a;
        this.f4646a = i7 + 1;
        jArr2[i7] = j6;
    }

    public long b(int i6) {
        if (i6 < 0 || i6 >= this.f4646a) {
            int i7 = this.f4646a;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Invalid index ");
            sb.append(i6);
            sb.append(", size is ");
            sb.append(i7);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        return this.f4647b[i6];
    }

    public int c() {
        return this.f4646a;
    }

    public long[] d() {
        return Arrays.copyOf(this.f4647b, this.f4646a);
    }

    public o(int i6) {
        this.f4647b = new long[i6];
    }
}
