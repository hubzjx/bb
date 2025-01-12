package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.exoplayer2.util.s0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends MediaCodec.Callback implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3821a;

    /* renamed from: b  reason: collision with root package name */
    private final h f3822b;

    /* renamed from: c  reason: collision with root package name */
    private final MediaCodec f3823c;

    /* renamed from: d  reason: collision with root package name */
    private final HandlerThread f3824d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f3825e;

    /* renamed from: f  reason: collision with root package name */
    private long f3826f;

    /* renamed from: g  reason: collision with root package name */
    private int f3827g;

    /* renamed from: h  reason: collision with root package name */
    private final k f3828h;

    /* renamed from: i  reason: collision with root package name */
    private IllegalStateException f3829i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MediaCodec mediaCodec, int i6) {
        this(mediaCodec, false, i6, new HandlerThread(j(i6)));
    }

    private static String j(int i6) {
        String str;
        StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecAsyncAdapter:");
        if (i6 == 1) {
            str = "Audio";
        } else if (i6 == 2) {
            str = "Video";
        } else {
            sb.append("Unknown(");
            sb.append(i6);
            str = ")";
        }
        sb.append(str);
        return sb.toString();
    }

    private boolean k() {
        return this.f3826f > 0;
    }

    private void l() {
        m();
        this.f3822b.f();
    }

    private void m() {
        IllegalStateException illegalStateException = this.f3829i;
        if (illegalStateException == null) {
            return;
        }
        this.f3829i = null;
        throw illegalStateException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        synchronized (this.f3821a) {
            o();
        }
    }

    private void o() {
        if (this.f3827g == 3) {
            return;
        }
        long j6 = this.f3826f - 1;
        this.f3826f = j6;
        if (j6 > 0) {
            return;
        }
        if (j6 < 0) {
            this.f3829i = new IllegalStateException();
            return;
        }
        this.f3822b.d();
        try {
            this.f3823c.start();
        } catch (IllegalStateException e6) {
            this.f3829i = e6;
        } catch (Exception e7) {
            this.f3829i = new IllegalStateException(e7);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public void a() {
        synchronized (this.f3821a) {
            if (this.f3827g == 2) {
                this.f3828h.a();
            }
            int i6 = this.f3827g;
            if (i6 == 1 || i6 == 2) {
                this.f3824d.quit();
                this.f3822b.d();
                this.f3826f++;
            }
            this.f3827g = 3;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public void b(int i6, int i7, com.google.android.exoplayer2.decoder.b bVar, long j6, int i8) {
        this.f3828h.b(i6, i7, bVar, j6, i8);
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public void c(int i6, int i7, int i8, long j6, int i9) {
        this.f3828h.c(i6, i7, i8, j6, i9);
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public int d(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f3821a) {
            if (k()) {
                return -1;
            }
            l();
            return this.f3822b.c(bufferInfo);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public void e(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i6) {
        this.f3824d.start();
        Handler handler = new Handler(this.f3824d.getLooper());
        this.f3825e = handler;
        this.f3823c.setCallback(this, handler);
        this.f3823c.configure(mediaFormat, surface, mediaCrypto, i6);
        this.f3827g = 1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public MediaFormat f() {
        MediaFormat e6;
        synchronized (this.f3821a) {
            e6 = this.f3822b.e();
        }
        return e6;
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public void flush() {
        synchronized (this.f3821a) {
            this.f3828h.flush();
            this.f3823c.flush();
            this.f3826f++;
            ((Handler) s0.j(this.f3825e)).post(new Runnable() { // from class: com.google.android.exoplayer2.mediacodec.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.n();
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public int g() {
        synchronized (this.f3821a) {
            if (k()) {
                return -1;
            }
            l();
            return this.f3822b.b();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public MediaCodec h() {
        return this.f3823c;
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f3821a) {
            this.f3822b.onError(mediaCodec, codecException);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i6) {
        synchronized (this.f3821a) {
            this.f3822b.onInputBufferAvailable(mediaCodec, i6);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i6, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f3821a) {
            this.f3822b.onOutputBufferAvailable(mediaCodec, i6, bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f3821a) {
            this.f3822b.onOutputFormatChanged(mediaCodec, mediaFormat);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.g
    public void start() {
        this.f3828h.start();
        this.f3823c.start();
        this.f3827g = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MediaCodec mediaCodec, boolean z5, int i6) {
        this(mediaCodec, z5, i6, new HandlerThread(j(i6)));
    }

    c(MediaCodec mediaCodec, boolean z5, int i6, HandlerThread handlerThread) {
        this.f3821a = new Object();
        this.f3822b = new h();
        this.f3823c = mediaCodec;
        this.f3824d = handlerThread;
        this.f3828h = z5 ? new d(mediaCodec, i6) : new a0(mediaCodec);
        this.f3827g = 0;
    }
}
