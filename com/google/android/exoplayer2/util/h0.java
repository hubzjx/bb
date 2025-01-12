package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
/* loaded from: classes.dex */
public class h0 implements c {
    @Override // com.google.android.exoplayer2.util.c
    public long a() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.google.android.exoplayer2.util.c
    public l b(Looper looper, Handler.Callback callback) {
        return new i0(new Handler(looper, callback));
    }

    @Override // com.google.android.exoplayer2.util.c
    public long c() {
        return SystemClock.elapsedRealtime();
    }
}
