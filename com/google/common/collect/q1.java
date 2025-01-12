package com.google.common.collect;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
final class q1 {

    /* renamed from: a  reason: collision with root package name */
    private final int f5688a;

    /* renamed from: b  reason: collision with root package name */
    private final Comparator f5689b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f5690c;

    /* renamed from: d  reason: collision with root package name */
    private int f5691d;

    /* renamed from: e  reason: collision with root package name */
    private Object f5692e;

    private q1(Comparator comparator, int i6) {
        this.f5689b = (Comparator) com.google.common.base.j.k(comparator, "comparator");
        this.f5688a = i6;
        com.google.common.base.j.f(i6 >= 0, "k must be nonnegative, was %s", i6);
        this.f5690c = new Object[i6 * 2];
        this.f5691d = 0;
        this.f5692e = null;
    }

    public static q1 a(int i6, Comparator comparator) {
        return new q1(comparator, i6);
    }

    private int d(int i6, int i7, int i8) {
        Object[] objArr = this.f5690c;
        Object obj = objArr[i8];
        objArr[i8] = objArr[i7];
        int i9 = i6;
        while (i6 < i7) {
            if (this.f5689b.compare(this.f5690c[i6], obj) < 0) {
                e(i9, i6);
                i9++;
            }
            i6++;
        }
        Object[] objArr2 = this.f5690c;
        objArr2[i7] = objArr2[i9];
        objArr2[i9] = obj;
        return i9;
    }

    private void e(int i6, int i7) {
        Object[] objArr = this.f5690c;
        Object obj = objArr[i6];
        objArr[i6] = objArr[i7];
        objArr[i7] = obj;
    }

    private void g() {
        int i6 = (this.f5688a * 2) - 1;
        int c6 = j3.a.c(i6 + 0, RoundingMode.CEILING) * 3;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i7 < i6) {
                int d6 = d(i7, i6, ((i7 + i6) + 1) >>> 1);
                int i10 = this.f5688a;
                if (d6 <= i10) {
                    if (d6 >= i10) {
                        break;
                    }
                    i7 = Math.max(d6, i7 + 1);
                    i9 = d6;
                } else {
                    i6 = d6 - 1;
                }
                i8++;
                if (i8 >= c6) {
                    Arrays.sort(this.f5690c, i7, i6, this.f5689b);
                    break;
                }
            } else {
                break;
            }
        }
        this.f5691d = this.f5688a;
        this.f5692e = this.f5690c[i9];
        while (true) {
            i9++;
            if (i9 >= this.f5688a) {
                return;
            }
            if (this.f5689b.compare(this.f5690c[i9], this.f5692e) > 0) {
                this.f5692e = this.f5690c[i9];
            }
        }
    }

    public void b(Object obj) {
        int i6 = this.f5688a;
        if (i6 == 0) {
            return;
        }
        int i7 = this.f5691d;
        if (i7 == 0) {
            this.f5690c[0] = obj;
            this.f5692e = obj;
            this.f5691d = 1;
        } else if (i7 < i6) {
            Object[] objArr = this.f5690c;
            this.f5691d = i7 + 1;
            objArr[i7] = obj;
            if (this.f5689b.compare(obj, this.f5692e) > 0) {
                this.f5692e = obj;
            }
        } else if (this.f5689b.compare(obj, this.f5692e) < 0) {
            Object[] objArr2 = this.f5690c;
            int i8 = this.f5691d;
            int i9 = i8 + 1;
            this.f5691d = i9;
            objArr2[i8] = obj;
            if (i9 == this.f5688a * 2) {
                g();
            }
        }
    }

    public void c(Iterator it) {
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public List f() {
        Arrays.sort(this.f5690c, 0, this.f5691d, this.f5689b);
        int i6 = this.f5691d;
        int i7 = this.f5688a;
        if (i6 > i7) {
            Object[] objArr = this.f5690c;
            Arrays.fill(objArr, i7, objArr.length, (Object) null);
            int i8 = this.f5688a;
            this.f5691d = i8;
            this.f5692e = this.f5690c[i8 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.f5690c, this.f5691d)));
    }
}
