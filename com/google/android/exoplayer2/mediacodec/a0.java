package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
/* loaded from: classes.dex */
class a0 implements k {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f3819a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(MediaCodec mediaCodec) {
        this.f3819a = mediaCodec;
    }

    @Override // com.google.android.exoplayer2.mediacodec.k
    public void a() {
    }

    @Override // com.google.android.exoplayer2.mediacodec.k
    public void b(int i6, int i7, com.google.android.exoplayer2.decoder.b bVar, long j6, int i8) {
        this.f3819a.queueSecureInputBuffer(i6, i7, bVar.a(), j6, i8);
    }

    @Override // com.google.android.exoplayer2.mediacodec.k
    public void c(int i6, int i7, int i8, long j6, int i9) {
        this.f3819a.queueInputBuffer(i6, i7, i8, j6, i9);
    }

    @Override // com.google.android.exoplayer2.mediacodec.k
    public void flush() {
    }

    @Override // com.google.android.exoplayer2.mediacodec.k
    public void start() {
    }
}
