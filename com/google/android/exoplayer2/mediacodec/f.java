package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.audio.c1;
import com.google.android.exoplayer2.s0;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
final class f {

    /* renamed from: a  reason: collision with root package name */
    private long f3851a;

    /* renamed from: b  reason: collision with root package name */
    private long f3852b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3853c;

    private long a(s0 s0Var) {
        return (this.f3851a * 1000000) / s0Var.B;
    }

    public void b() {
        this.f3851a = 0L;
        this.f3852b = 0L;
        this.f3853c = false;
    }

    public long c(s0 s0Var, com.google.android.exoplayer2.decoder.j jVar) {
        if (this.f3853c) {
            return jVar.f3602d;
        }
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(jVar.f3600b);
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            i6 = (i6 << 8) | (byteBuffer.get(i7) & 255);
        }
        int m5 = c1.m(i6);
        if (m5 == -1) {
            this.f3853c = true;
            com.google.android.exoplayer2.util.n.h("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return jVar.f3602d;
        } else if (this.f3851a != 0) {
            long a6 = a(s0Var);
            this.f3851a += m5;
            return this.f3852b + a6;
        } else {
            long j6 = jVar.f3602d;
            this.f3852b = j6;
            this.f3851a = m5 - 529;
            return j6;
        }
    }
}
