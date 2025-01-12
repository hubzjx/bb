package com.google.android.exoplayer2.util;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private int f4639a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f4640b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f4641c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int[] f4642d;

    /* renamed from: e  reason: collision with root package name */
    private int f4643e;

    public m() {
        int[] iArr = new int[16];
        this.f4642d = iArr;
        this.f4643e = iArr.length - 1;
    }

    private void c() {
        int[] iArr = this.f4642d;
        int length = iArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        int i6 = this.f4639a;
        int i7 = length2 - i6;
        System.arraycopy(iArr, i6, iArr2, 0, i7);
        System.arraycopy(this.f4642d, 0, iArr2, i7, i6);
        this.f4639a = 0;
        this.f4640b = this.f4641c - 1;
        this.f4642d = iArr2;
        this.f4643e = iArr2.length - 1;
    }

    public void a(int i6) {
        if (this.f4641c == this.f4642d.length) {
            c();
        }
        int i7 = (this.f4640b + 1) & this.f4643e;
        this.f4640b = i7;
        this.f4642d[i7] = i6;
        this.f4641c++;
    }

    public void b() {
        this.f4639a = 0;
        this.f4640b = -1;
        this.f4641c = 0;
    }

    public boolean d() {
        return this.f4641c == 0;
    }

    public int e() {
        int i6 = this.f4641c;
        if (i6 != 0) {
            int[] iArr = this.f4642d;
            int i7 = this.f4639a;
            int i8 = iArr[i7];
            this.f4639a = (i7 + 1) & this.f4643e;
            this.f4641c = i6 - 1;
            return i8;
        }
        throw new NoSuchElementException();
    }
}
