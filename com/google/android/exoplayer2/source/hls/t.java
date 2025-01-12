package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.k0;
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray f4378a = new SparseArray();

    public k0 a(int i6) {
        k0 k0Var = (k0) this.f4378a.get(i6);
        if (k0Var == null) {
            k0 k0Var2 = new k0(Long.MAX_VALUE);
            this.f4378a.put(i6, k0Var2);
            return k0Var2;
        }
        return k0Var;
    }

    public void b() {
        this.f4378a.clear();
    }
}
