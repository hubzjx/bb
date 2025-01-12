package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
/* loaded from: classes.dex */
public interface g {
    void a();

    void b(int i6, int i7, com.google.android.exoplayer2.decoder.b bVar, long j6, int i8);

    void c(int i6, int i7, int i8, long j6, int i9);

    int d(MediaCodec.BufferInfo bufferInfo);

    void e(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i6);

    MediaFormat f();

    void flush();

    int g();

    MediaCodec h();

    void start();
}
