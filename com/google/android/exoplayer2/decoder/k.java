package com.google.android.exoplayer2.decoder;
/* loaded from: classes.dex */
public abstract class k extends com.google.android.exoplayer2.decoder.a {
    public int skippedOutputBufferCount;
    public long timeUs;

    /* loaded from: classes.dex */
    public interface a {
        void a(k kVar);
    }

    public abstract void release();
}
