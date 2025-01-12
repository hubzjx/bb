package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
/* loaded from: classes.dex */
final class z implements g {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f3921a;

    public z(MediaCodec mediaCodec) {
        this.f3921a = mediaCodec;
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public void b(int i6, int i7, com.google.android.exoplayer2.decoder.b bVar, long j6, int i8) {
        this.f3921a.queueSecureInputBuffer(i6, i7, bVar.a(), j6, i8);
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public void c(int i6, int i7, int i8, long j6, int i9) {
        this.f3921a.queueInputBuffer(i6, i7, i8, j6, i9);
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public int d(MediaCodec.BufferInfo bufferInfo) {
        return this.f3921a.dequeueOutputBuffer(bufferInfo, 0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public void e(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i6) {
        this.f3921a.configure(mediaFormat, surface, mediaCrypto, i6);
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public MediaFormat f() {
        return this.f3921a.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public void flush() {
        this.f3921a.flush();
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public int g() {
        return this.f3921a.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public MediaCodec h() {
        return this.f3921a;
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public void start() {
        this.f3921a.start();
    }
}
