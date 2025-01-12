package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.t;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes.dex */
public interface m {

    /* loaded from: classes.dex */
    public static class a extends IOException {
        public a(Throwable th) {
            super(th);
        }
    }

    boolean a();

    void b(t.a aVar);

    Map c();

    void d(t.a aVar);

    y e();

    a f();

    int getState();
}
