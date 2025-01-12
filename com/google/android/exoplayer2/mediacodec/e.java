package com.google.android.exoplayer2.mediacodec;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
final class e extends com.google.android.exoplayer2.decoder.j {

    /* renamed from: h  reason: collision with root package name */
    private final com.google.android.exoplayer2.decoder.j f3846h;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3847k;

    /* renamed from: l  reason: collision with root package name */
    private long f3848l;

    /* renamed from: m  reason: collision with root package name */
    private int f3849m;

    /* renamed from: n  reason: collision with root package name */
    private int f3850n;

    public e() {
        super(2);
        this.f3846h = new com.google.android.exoplayer2.decoder.j(2);
        clear();
    }

    private boolean m(com.google.android.exoplayer2.decoder.j jVar) {
        ByteBuffer byteBuffer;
        if (u()) {
            return true;
        }
        if (jVar.isDecodeOnly() != isDecodeOnly()) {
            return false;
        }
        ByteBuffer byteBuffer2 = jVar.f3600b;
        return byteBuffer2 == null || (byteBuffer = this.f3600b) == null || byteBuffer.position() + byteBuffer2.limit() < 3072000;
    }

    private void n() {
        super.clear();
        this.f3849m = 0;
        this.f3848l = -9223372036854775807L;
        this.f3602d = -9223372036854775807L;
    }

    private void w(com.google.android.exoplayer2.decoder.j jVar) {
        ByteBuffer byteBuffer = jVar.f3600b;
        if (byteBuffer != null) {
            jVar.g();
            f(byteBuffer.remaining());
            this.f3600b.put(byteBuffer);
        }
        if (jVar.isEndOfStream()) {
            setFlags(4);
        }
        if (jVar.isDecodeOnly()) {
            setFlags(Integer.MIN_VALUE);
        }
        if (jVar.isKeyFrame()) {
            setFlags(1);
        }
        int i6 = this.f3849m + 1;
        this.f3849m = i6;
        long j6 = jVar.f3602d;
        this.f3602d = j6;
        if (i6 == 1) {
            this.f3848l = j6;
        }
        jVar.clear();
    }

    @Override // com.google.android.exoplayer2.decoder.j, com.google.android.exoplayer2.decoder.a
    public void clear() {
        p();
        this.f3850n = 32;
    }

    public void l() {
        n();
        if (this.f3847k) {
            w(this.f3846h);
            this.f3847k = false;
        }
    }

    public void o() {
        com.google.android.exoplayer2.decoder.j jVar = this.f3846h;
        boolean z5 = false;
        com.google.android.exoplayer2.util.a.g((v() || isEndOfStream()) ? false : true);
        if (!jVar.h() && !jVar.hasSupplementalData()) {
            z5 = true;
        }
        com.google.android.exoplayer2.util.a.a(z5);
        if (m(jVar)) {
            w(jVar);
        } else {
            this.f3847k = true;
        }
    }

    public void p() {
        n();
        this.f3846h.clear();
        this.f3847k = false;
    }

    public int q() {
        return this.f3849m;
    }

    public long r() {
        return this.f3848l;
    }

    public long s() {
        return this.f3602d;
    }

    public com.google.android.exoplayer2.decoder.j t() {
        return this.f3846h;
    }

    public boolean u() {
        return this.f3849m == 0;
    }

    public boolean v() {
        ByteBuffer byteBuffer;
        return this.f3849m >= this.f3850n || ((byteBuffer = this.f3600b) != null && byteBuffer.position() >= 3072000) || this.f3847k;
    }

    public void x(int i6) {
        com.google.android.exoplayer2.util.a.a(i6 > 0);
        this.f3850n = i6;
    }
}
