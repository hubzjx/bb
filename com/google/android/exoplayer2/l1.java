package com.google.android.exoplayer2;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
final class l1 extends a {

    /* renamed from: e  reason: collision with root package name */
    private final int f3800e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3801f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f3802g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f3803h;

    /* renamed from: i  reason: collision with root package name */
    private final y1[] f3804i;

    /* renamed from: j  reason: collision with root package name */
    private final Object[] f3805j;

    /* renamed from: k  reason: collision with root package name */
    private final HashMap f3806k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(Collection collection, w1.t0 t0Var) {
        super(false, t0Var);
        int i6 = 0;
        int size = collection.size();
        this.f3802g = new int[size];
        this.f3803h = new int[size];
        this.f3804i = new y1[size];
        this.f3805j = new Object[size];
        this.f3806k = new HashMap();
        Iterator it = collection.iterator();
        int i7 = 0;
        int i8 = 0;
        while (it.hasNext()) {
            c1 c1Var = (c1) it.next();
            this.f3804i[i8] = c1Var.b();
            this.f3803h[i8] = i6;
            this.f3802g[i8] = i7;
            i6 += this.f3804i[i8].o();
            i7 += this.f3804i[i8].i();
            this.f3805j[i8] = c1Var.a();
            this.f3806k.put(this.f3805j[i8], Integer.valueOf(i8));
            i8++;
        }
        this.f3800e = i6;
        this.f3801f = i7;
    }

    @Override // com.google.android.exoplayer2.a
    protected y1 C(int i6) {
        return this.f3804i[i6];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List D() {
        return Arrays.asList(this.f3804i);
    }

    @Override // com.google.android.exoplayer2.y1
    public int i() {
        return this.f3801f;
    }

    @Override // com.google.android.exoplayer2.y1
    public int o() {
        return this.f3800e;
    }

    @Override // com.google.android.exoplayer2.a
    protected int r(Object obj) {
        Integer num = (Integer) this.f3806k.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.exoplayer2.a
    protected int s(int i6) {
        return com.google.android.exoplayer2.util.s0.h(this.f3802g, i6 + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.a
    protected int t(int i6) {
        return com.google.android.exoplayer2.util.s0.h(this.f3803h, i6 + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.a
    protected Object w(int i6) {
        return this.f3805j[i6];
    }

    @Override // com.google.android.exoplayer2.a
    protected int y(int i6) {
        return this.f3802g[i6];
    }

    @Override // com.google.android.exoplayer2.a
    protected int z(int i6) {
        return this.f3803h[i6];
    }
}
