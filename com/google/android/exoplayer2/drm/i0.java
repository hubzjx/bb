package com.google.android.exoplayer2.drm;
/* loaded from: classes.dex */
public final class i0 extends Exception {
    public static final int REASON_INSTANTIATION_ERROR = 2;
    public static final int REASON_UNSUPPORTED_SCHEME = 1;
    public final int reason;

    public i0(int i6) {
        this.reason = i6;
    }

    public i0(int i6, Exception exc) {
        super(exc);
        this.reason = i6;
    }
}
