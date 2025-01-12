package com.google.android.exoplayer2;
/* loaded from: classes.dex */
public final class u0 extends IllegalStateException {
    public final long positionMs;
    public final y1 timeline;
    public final int windowIndex;

    public u0(y1 y1Var, int i6, long j6) {
        this.timeline = y1Var;
        this.windowIndex = i6;
        this.positionMs = j6;
    }
}
