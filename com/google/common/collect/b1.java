package com.google.common.collect;

import com.google.common.collect.v0;
import com.google.common.collect.w0;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b1 {

    /* renamed from: a  reason: collision with root package name */
    transient Object[] f5614a;

    /* renamed from: b  reason: collision with root package name */
    transient int[] f5615b;

    /* renamed from: c  reason: collision with root package name */
    transient int f5616c;

    /* renamed from: d  reason: collision with root package name */
    transient int f5617d;

    /* renamed from: e  reason: collision with root package name */
    private transient int[] f5618e;

    /* renamed from: f  reason: collision with root package name */
    transient long[] f5619f;

    /* renamed from: g  reason: collision with root package name */
    private transient float f5620g;

    /* renamed from: h  reason: collision with root package name */
    private transient int f5621h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends w0.a {

        /* renamed from: a  reason: collision with root package name */
        final Object f5622a;

        /* renamed from: b  reason: collision with root package name */
        int f5623b;

        a(int i6) {
            this.f5622a = b1.this.f5614a[i6];
            this.f5623b = i6;
        }

        void a() {
            int i6 = this.f5623b;
            if (i6 == -1 || i6 >= b1.this.C() || !com.google.common.base.h.a(this.f5622a, b1.this.f5614a[this.f5623b])) {
                this.f5623b = b1.this.m(this.f5622a);
            }
        }

        @Override // com.google.common.collect.v0.a
        public int getCount() {
            a();
            int i6 = this.f5623b;
            if (i6 == -1) {
                return 0;
            }
            return b1.this.f5615b[i6];
        }

        @Override // com.google.common.collect.v0.a
        public Object getElement() {
            return this.f5622a;
        }
    }

    b1() {
        n(3, 1.0f);
    }

    private void A(int i6) {
        if (this.f5618e.length >= 1073741824) {
            this.f5621h = Integer.MAX_VALUE;
            return;
        }
        int i7 = ((int) (i6 * this.f5620g)) + 1;
        int[] r5 = r(i6);
        long[] jArr = this.f5619f;
        int length = r5.length - 1;
        for (int i8 = 0; i8 < this.f5616c; i8++) {
            int h6 = h(jArr[i8]);
            int i9 = h6 & length;
            int i10 = r5[i9];
            r5[i9] = i8;
            jArr[i8] = (h6 << 32) | (i10 & 4294967295L);
        }
        this.f5621h = i7;
        this.f5618e = r5;
    }

    private static long D(long j6, int i6) {
        return (j6 & (-4294967296L)) | (4294967295L & i6);
    }

    public static b1 b() {
        return new b1();
    }

    public static b1 c(int i6) {
        return new b1(i6);
    }

    private static int h(long j6) {
        return (int) (j6 >>> 32);
    }

    private static int j(long j6) {
        return (int) j6;
    }

    private int l() {
        return this.f5618e.length - 1;
    }

    private static long[] q(int i6) {
        long[] jArr = new long[i6];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] r(int i6) {
        int[] iArr = new int[i6];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private int w(Object obj, int i6) {
        int l6 = l() & i6;
        int i7 = this.f5618e[l6];
        if (i7 == -1) {
            return 0;
        }
        int i8 = -1;
        while (true) {
            if (h(this.f5619f[i7]) == i6 && com.google.common.base.h.a(obj, this.f5614a[i7])) {
                int i9 = this.f5615b[i7];
                if (i8 == -1) {
                    this.f5618e[l6] = j(this.f5619f[i7]);
                } else {
                    long[] jArr = this.f5619f;
                    jArr[i8] = D(jArr[i8], j(jArr[i7]));
                }
                p(i7);
                this.f5616c--;
                this.f5617d++;
                return i9;
            }
            int j6 = j(this.f5619f[i7]);
            if (j6 == -1) {
                return 0;
            }
            i8 = i7;
            i7 = j6;
        }
    }

    private void z(int i6) {
        int length = this.f5619f.length;
        if (i6 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                y(max);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i6, int i7) {
        com.google.common.base.j.h(i6, this.f5616c);
        this.f5615b[i6] = i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C() {
        return this.f5616c;
    }

    public void a() {
        this.f5617d++;
        Arrays.fill(this.f5614a, 0, this.f5616c, (Object) null);
        Arrays.fill(this.f5615b, 0, this.f5616c, 0);
        Arrays.fill(this.f5618e, -1);
        Arrays.fill(this.f5619f, -1L);
        this.f5616c = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i6) {
        if (i6 > this.f5619f.length) {
            y(i6);
        }
        if (i6 >= this.f5621h) {
            A(Math.max(2, Integer.highestOneBit(i6 - 1) << 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f5616c == 0 ? -1 : 0;
    }

    public int f(Object obj) {
        int m5 = m(obj);
        if (m5 == -1) {
            return 0;
        }
        return this.f5615b[m5];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v0.a g(int i6) {
        com.google.common.base.j.h(i6, this.f5616c);
        return new a(i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object i(int i6) {
        com.google.common.base.j.h(i6, this.f5616c);
        return this.f5614a[i6];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k(int i6) {
        com.google.common.base.j.h(i6, this.f5616c);
        return this.f5615b[i6];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(Object obj) {
        int c6 = v.c(obj);
        int i6 = this.f5618e[l() & c6];
        while (i6 != -1) {
            long j6 = this.f5619f[i6];
            if (h(j6) == c6 && com.google.common.base.h.a(obj, this.f5614a[i6])) {
                return i6;
            }
            i6 = j(j6);
        }
        return -1;
    }

    void n(int i6, float f6) {
        com.google.common.base.j.e(i6 >= 0, "Initial capacity must be non-negative");
        com.google.common.base.j.e(f6 > 0.0f, "Illegal load factor");
        int a6 = v.a(i6, f6);
        this.f5618e = r(a6);
        this.f5620g = f6;
        this.f5614a = new Object[i6];
        this.f5615b = new int[i6];
        this.f5619f = q(i6);
        this.f5621h = Math.max(1, (int) (a6 * f6));
    }

    void o(int i6, Object obj, int i7, int i8) {
        this.f5619f[i6] = (i8 << 32) | 4294967295L;
        this.f5614a[i6] = obj;
        this.f5615b[i6] = i7;
    }

    void p(int i6) {
        int C = C() - 1;
        if (i6 >= C) {
            this.f5614a[i6] = null;
            this.f5615b[i6] = 0;
            this.f5619f[i6] = -1;
            return;
        }
        Object[] objArr = this.f5614a;
        objArr[i6] = objArr[C];
        int[] iArr = this.f5615b;
        iArr[i6] = iArr[C];
        objArr[C] = null;
        iArr[C] = 0;
        long[] jArr = this.f5619f;
        long j6 = jArr[C];
        jArr[i6] = j6;
        jArr[C] = -1;
        int h6 = h(j6) & l();
        int[] iArr2 = this.f5618e;
        int i7 = iArr2[h6];
        if (i7 == C) {
            iArr2[h6] = i6;
            return;
        }
        while (true) {
            long j7 = this.f5619f[i7];
            int j8 = j(j7);
            if (j8 == C) {
                this.f5619f[i7] = D(j7, i6);
                return;
            }
            i7 = j8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s(int i6) {
        int i7 = i6 + 1;
        if (i7 < this.f5616c) {
            return i7;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t(int i6, int i7) {
        return i6 - 1;
    }

    public int u(Object obj, int i6) {
        i.c(i6, "count");
        long[] jArr = this.f5619f;
        Object[] objArr = this.f5614a;
        int[] iArr = this.f5615b;
        int c6 = v.c(obj);
        int l6 = l() & c6;
        int i7 = this.f5616c;
        int[] iArr2 = this.f5618e;
        int i8 = iArr2[l6];
        if (i8 == -1) {
            iArr2[l6] = i7;
        } else {
            while (true) {
                long j6 = jArr[i8];
                if (h(j6) == c6 && com.google.common.base.h.a(obj, objArr[i8])) {
                    int i9 = iArr[i8];
                    iArr[i8] = i6;
                    return i9;
                }
                int j7 = j(j6);
                if (j7 == -1) {
                    jArr[i8] = D(j6, i7);
                    break;
                }
                i8 = j7;
            }
        }
        if (i7 != Integer.MAX_VALUE) {
            int i10 = i7 + 1;
            z(i10);
            o(i7, obj, i6, c6);
            this.f5616c = i10;
            if (i7 >= this.f5621h) {
                A(this.f5618e.length * 2);
            }
            this.f5617d++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    public int v(Object obj) {
        return w(obj, v.c(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x(int i6) {
        return w(this.f5614a[i6], h(this.f5619f[i6]));
    }

    void y(int i6) {
        this.f5614a = Arrays.copyOf(this.f5614a, i6);
        this.f5615b = Arrays.copyOf(this.f5615b, i6);
        long[] jArr = this.f5619f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i6);
        if (i6 > length) {
            Arrays.fill(copyOf, length, i6, -1L);
        }
        this.f5619f = copyOf;
    }

    b1(int i6) {
        this(i6, 1.0f);
    }

    b1(int i6, float f6) {
        n(i6, f6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1(b1 b1Var) {
        n(b1Var.C(), 1.0f);
        int e6 = b1Var.e();
        while (e6 != -1) {
            u(b1Var.i(e6), b1Var.k(e6));
            e6 = b1Var.s(e6);
        }
    }
}
