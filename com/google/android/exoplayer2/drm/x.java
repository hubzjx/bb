package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.m;
import com.google.android.exoplayer2.drm.t;
import java.util.Map;
/* loaded from: classes.dex */
public final class x implements m {

    /* renamed from: a  reason: collision with root package name */
    private final m.a f3729a;

    public x(m.a aVar) {
        this.f3729a = (m.a) com.google.android.exoplayer2.util.a.e(aVar);
    }

    @Override // com.google.android.exoplayer2.drm.m
    public boolean a() {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void b(t.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.m
    public Map c() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void d(t.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.m
    public y e() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.m
    public m.a f() {
        return this.f3729a;
    }

    @Override // com.google.android.exoplayer2.drm.m
    public int getState() {
        return 1;
    }
}
