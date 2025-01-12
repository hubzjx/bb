package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.util.s0;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
class d implements k {

    /* renamed from: h  reason: collision with root package name */
    private static final ArrayDeque f3830h = new ArrayDeque();

    /* renamed from: i  reason: collision with root package name */
    private static final Object f3831i = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f3832a;

    /* renamed from: b  reason: collision with root package name */
    private final HandlerThread f3833b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f3834c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference f3835d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.f f3836e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f3837f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3838g;

    /* loaded from: classes.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d.this.i(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3840a;

        /* renamed from: b  reason: collision with root package name */
        public int f3841b;

        /* renamed from: c  reason: collision with root package name */
        public int f3842c;

        /* renamed from: d  reason: collision with root package name */
        public final MediaCodec.CryptoInfo f3843d = new MediaCodec.CryptoInfo();

        /* renamed from: e  reason: collision with root package name */
        public long f3844e;

        /* renamed from: f  reason: collision with root package name */
        public int f3845f;

        b() {
        }

        public void a(int i6, int i7, int i8, long j6, int i9) {
            this.f3840a = i6;
            this.f3841b = i7;
            this.f3842c = i8;
            this.f3844e = j6;
            this.f3845f = i9;
        }
    }

    public d(MediaCodec mediaCodec, int i6) {
        this(mediaCodec, new HandlerThread(h(i6)), new com.google.android.exoplayer2.util.f());
    }

    private static void e(com.google.android.exoplayer2.decoder.b bVar, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = bVar.f3581f;
        cryptoInfo.numBytesOfClearData = g(bVar.f3579d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = g(bVar.f3580e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) com.google.android.exoplayer2.util.a.e(f(bVar.f3577b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) com.google.android.exoplayer2.util.a.e(f(bVar.f3576a, cryptoInfo.iv));
        cryptoInfo.mode = bVar.f3578c;
        if (s0.f4673a >= 24) {
            com.google.android.exoplayer2.decoder.f.a();
            cryptoInfo.setPattern(com.google.android.exoplayer2.decoder.e.a(bVar.f3582g, bVar.f3583h));
        }
    }

    private static byte[] f(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int[] g(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    private static String h(int i6) {
        String str;
        StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecBufferEnqueuer:");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Message message) {
        b bVar;
        int i6 = message.what;
        if (i6 == 0) {
            bVar = (b) message.obj;
            j(bVar.f3840a, bVar.f3841b, bVar.f3842c, bVar.f3844e, bVar.f3845f);
        } else if (i6 != 1) {
            if (i6 != 2) {
                q(new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.f3836e.d();
            }
            bVar = null;
        } else {
            bVar = (b) message.obj;
            k(bVar.f3840a, bVar.f3841b, bVar.f3843d, bVar.f3844e, bVar.f3845f);
        }
        if (bVar != null) {
            p(bVar);
        }
    }

    private void j(int i6, int i7, int i8, long j6, int i9) {
        try {
            this.f3832a.queueInputBuffer(i6, i7, i8, j6, i9);
        } catch (RuntimeException e6) {
            q(e6);
        }
    }

    private void k(int i6, int i7, MediaCodec.CryptoInfo cryptoInfo, long j6, int i8) {
        try {
            if (this.f3837f) {
                synchronized (f3831i) {
                    this.f3832a.queueSecureInputBuffer(i6, i7, cryptoInfo, j6, i8);
                }
            } else {
                this.f3832a.queueSecureInputBuffer(i6, i7, cryptoInfo, j6, i8);
            }
        } catch (RuntimeException e6) {
            q(e6);
        }
    }

    private void l() {
        Handler handler = (Handler) s0.j(this.f3834c);
        handler.removeCallbacksAndMessages(null);
        this.f3836e.b();
        handler.obtainMessage(2).sendToTarget();
        this.f3836e.a();
        n();
    }

    private static b m() {
        ArrayDeque arrayDeque = f3830h;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new b();
            }
            return (b) arrayDeque.removeFirst();
        }
    }

    private void n() {
        RuntimeException runtimeException = (RuntimeException) this.f3835d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    private static boolean o() {
        String S0 = s0.S0(s0.f4675c);
        return S0.contains("samsung") || S0.contains("motorola");
    }

    private static void p(b bVar) {
        ArrayDeque arrayDeque = f3830h;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.k
    public void a() {
        if (this.f3838g) {
            flush();
            this.f3833b.quit();
        }
        this.f3838g = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.k
    public void b(int i6, int i7, com.google.android.exoplayer2.decoder.b bVar, long j6, int i8) {
        n();
        b m5 = m();
        m5.a(i6, i7, 0, j6, i8);
        e(bVar, m5.f3843d);
        ((Handler) s0.j(this.f3834c)).obtainMessage(1, m5).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.mediacodec.k
    public void c(int i6, int i7, int i8, long j6, int i9) {
        n();
        b m5 = m();
        m5.a(i6, i7, i8, j6, i9);
        ((Handler) s0.j(this.f3834c)).obtainMessage(0, m5).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.mediacodec.k
    public void flush() {
        if (this.f3838g) {
            try {
                l();
            } catch (InterruptedException e6) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e6);
            }
        }
    }

    void q(RuntimeException runtimeException) {
        this.f3835d.set(runtimeException);
    }

    @Override // com.google.android.exoplayer2.mediacodec.k
    public void start() {
        if (this.f3838g) {
            return;
        }
        this.f3833b.start();
        this.f3834c = new a(this.f3833b.getLooper());
        this.f3838g = true;
    }

    d(MediaCodec mediaCodec, HandlerThread handlerThread, com.google.android.exoplayer2.util.f fVar) {
        this.f3832a = mediaCodec;
        this.f3833b = handlerThread;
        this.f3836e = fVar;
        this.f3835d = new AtomicReference();
        this.f3837f = o();
    }
}
