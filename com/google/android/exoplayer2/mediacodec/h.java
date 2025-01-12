package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.util.ArrayDeque;
/* loaded from: classes.dex */
final class h extends MediaCodec.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.m f3854a = new com.google.android.exoplayer2.util.m();

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.m f3855b = new com.google.android.exoplayer2.util.m();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque f3856c = new ArrayDeque();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayDeque f3857d = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    private MediaFormat f3858e;

    /* renamed from: f  reason: collision with root package name */
    private MediaFormat f3859f;

    /* renamed from: g  reason: collision with root package name */
    private IllegalStateException f3860g;

    private void a(MediaFormat mediaFormat) {
        this.f3855b.a(-2);
        this.f3857d.add(mediaFormat);
    }

    public int b() {
        if (this.f3854a.d()) {
            return -1;
        }
        return this.f3854a.e();
    }

    public int c(MediaCodec.BufferInfo bufferInfo) {
        if (this.f3855b.d()) {
            return -1;
        }
        int e6 = this.f3855b.e();
        if (e6 >= 0) {
            MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.f3856c.remove();
            bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
        } else if (e6 == -2) {
            this.f3858e = (MediaFormat) this.f3857d.remove();
        }
        return e6;
    }

    public void d() {
        this.f3859f = this.f3857d.isEmpty() ? null : (MediaFormat) this.f3857d.getLast();
        this.f3854a.b();
        this.f3855b.b();
        this.f3856c.clear();
        this.f3857d.clear();
        this.f3860g = null;
    }

    public MediaFormat e() {
        MediaFormat mediaFormat = this.f3858e;
        if (mediaFormat != null) {
            return mediaFormat;
        }
        throw new IllegalStateException();
    }

    public void f() {
        IllegalStateException illegalStateException = this.f3860g;
        this.f3860g = null;
        if (illegalStateException != null) {
            throw illegalStateException;
        }
    }

    void g(IllegalStateException illegalStateException) {
        this.f3860g = illegalStateException;
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        g(codecException);
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i6) {
        this.f3854a.a(i6);
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i6, MediaCodec.BufferInfo bufferInfo) {
        MediaFormat mediaFormat = this.f3859f;
        if (mediaFormat != null) {
            a(mediaFormat);
            this.f3859f = null;
        }
        this.f3855b.a(i6);
        this.f3856c.add(bufferInfo);
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        a(mediaFormat);
        this.f3859f = null;
    }
}
