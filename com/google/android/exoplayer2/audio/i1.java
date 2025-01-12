package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.h;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
final class i1 extends v {

    /* renamed from: i  reason: collision with root package name */
    private int f3422i;

    /* renamed from: j  reason: collision with root package name */
    private int f3423j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3424k;

    /* renamed from: l  reason: collision with root package name */
    private int f3425l;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f3426m = com.google.android.exoplayer2.util.s0.f4678f;

    /* renamed from: n  reason: collision with root package name */
    private int f3427n;

    /* renamed from: o  reason: collision with root package name */
    private long f3428o;

    @Override // com.google.android.exoplayer2.audio.v, com.google.android.exoplayer2.audio.h
    public ByteBuffer a() {
        int i6;
        if (super.d() && (i6 = this.f3427n) > 0) {
            m(i6).put(this.f3426m, 0, this.f3427n).flip();
            this.f3427n = 0;
        }
        return super.a();
    }

    @Override // com.google.android.exoplayer2.audio.v, com.google.android.exoplayer2.audio.h
    public boolean d() {
        return super.d() && this.f3427n == 0;
    }

    @Override // com.google.android.exoplayer2.audio.h
    public void f(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i6 = limit - position;
        if (i6 == 0) {
            return;
        }
        int min = Math.min(i6, this.f3425l);
        this.f3428o += min / this.f3540b.f3404d;
        this.f3425l -= min;
        byteBuffer.position(position + min);
        if (this.f3425l > 0) {
            return;
        }
        int i7 = i6 - min;
        int length = (this.f3427n + i7) - this.f3426m.length;
        ByteBuffer m5 = m(length);
        int r5 = com.google.android.exoplayer2.util.s0.r(length, 0, this.f3427n);
        m5.put(this.f3426m, 0, r5);
        int r6 = com.google.android.exoplayer2.util.s0.r(length - r5, 0, i7);
        byteBuffer.limit(byteBuffer.position() + r6);
        m5.put(byteBuffer);
        byteBuffer.limit(limit);
        int i8 = i7 - r6;
        int i9 = this.f3427n - r5;
        this.f3427n = i9;
        byte[] bArr = this.f3426m;
        System.arraycopy(bArr, r5, bArr, 0, i9);
        byteBuffer.get(this.f3426m, this.f3427n, i8);
        this.f3427n += i8;
        m5.flip();
    }

    @Override // com.google.android.exoplayer2.audio.v
    public h.a i(h.a aVar) {
        if (aVar.f3403c == 2) {
            this.f3424k = true;
            return (this.f3422i == 0 && this.f3423j == 0) ? h.a.f3400e : aVar;
        }
        throw new h.b(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void j() {
        if (this.f3424k) {
            this.f3424k = false;
            int i6 = this.f3423j;
            int i7 = this.f3540b.f3404d;
            this.f3426m = new byte[i6 * i7];
            this.f3425l = this.f3422i * i7;
        }
        this.f3427n = 0;
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void k() {
        int i6;
        if (this.f3424k) {
            if (this.f3427n > 0) {
                this.f3428o += i6 / this.f3540b.f3404d;
            }
            this.f3427n = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void l() {
        this.f3426m = com.google.android.exoplayer2.util.s0.f4678f;
    }

    public long n() {
        return this.f3428o;
    }

    public void o() {
        this.f3428o = 0L;
    }

    public void p(int i6, int i7) {
        this.f3422i = i6;
        this.f3423j = i7;
    }
}
