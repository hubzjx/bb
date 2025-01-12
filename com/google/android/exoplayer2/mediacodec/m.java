package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.exoplayer2.mediacodec.x;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.t0;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.l0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class m extends com.google.android.exoplayer2.o {
    private static final byte[] G0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private s0 A;
    private int A0;
    private s0 B;
    private com.google.android.exoplayer2.t B0;
    private com.google.android.exoplayer2.drm.m C;
    protected com.google.android.exoplayer2.decoder.h C0;
    private com.google.android.exoplayer2.drm.m D;
    private long D0;
    private MediaCrypto E;
    private long E0;
    private boolean F;
    private int F0;
    private long G;
    private float H;
    private MediaCodec I;
    private g J;
    private s0 K;
    private MediaFormat L;
    private boolean M;
    private float N;
    private ArrayDeque O;
    private a P;
    private j Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f3872a0;

    /* renamed from: b0  reason: collision with root package name */
    private boolean f3873b0;

    /* renamed from: c0  reason: collision with root package name */
    private f f3874c0;

    /* renamed from: d0  reason: collision with root package name */
    private ByteBuffer[] f3875d0;

    /* renamed from: e0  reason: collision with root package name */
    private ByteBuffer[] f3876e0;

    /* renamed from: f0  reason: collision with root package name */
    private long f3877f0;

    /* renamed from: g0  reason: collision with root package name */
    private int f3878g0;

    /* renamed from: h0  reason: collision with root package name */
    private int f3879h0;

    /* renamed from: i0  reason: collision with root package name */
    private ByteBuffer f3880i0;

    /* renamed from: j0  reason: collision with root package name */
    private boolean f3881j0;

    /* renamed from: k0  reason: collision with root package name */
    private boolean f3882k0;

    /* renamed from: l0  reason: collision with root package name */
    private boolean f3883l0;

    /* renamed from: m0  reason: collision with root package name */
    private boolean f3884m0;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f3885n0;

    /* renamed from: o  reason: collision with root package name */
    private final o f3886o;

    /* renamed from: o0  reason: collision with root package name */
    private int f3887o0;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f3888p;

    /* renamed from: p0  reason: collision with root package name */
    private int f3889p0;

    /* renamed from: q  reason: collision with root package name */
    private final float f3890q;

    /* renamed from: q0  reason: collision with root package name */
    private int f3891q0;

    /* renamed from: r  reason: collision with root package name */
    private final com.google.android.exoplayer2.decoder.j f3892r;

    /* renamed from: r0  reason: collision with root package name */
    private boolean f3893r0;

    /* renamed from: s  reason: collision with root package name */
    private final com.google.android.exoplayer2.decoder.j f3894s;

    /* renamed from: s0  reason: collision with root package name */
    private boolean f3895s0;

    /* renamed from: t  reason: collision with root package name */
    private final e f3896t;

    /* renamed from: t0  reason: collision with root package name */
    private boolean f3897t0;

    /* renamed from: u  reason: collision with root package name */
    private final j0 f3898u;

    /* renamed from: u0  reason: collision with root package name */
    private long f3899u0;

    /* renamed from: v  reason: collision with root package name */
    private final ArrayList f3900v;

    /* renamed from: v0  reason: collision with root package name */
    private long f3901v0;

    /* renamed from: w  reason: collision with root package name */
    private final MediaCodec.BufferInfo f3902w;

    /* renamed from: w0  reason: collision with root package name */
    private boolean f3903w0;

    /* renamed from: x  reason: collision with root package name */
    private final long[] f3904x;

    /* renamed from: x0  reason: collision with root package name */
    private boolean f3905x0;

    /* renamed from: y  reason: collision with root package name */
    private final long[] f3906y;

    /* renamed from: y0  reason: collision with root package name */
    private boolean f3907y0;

    /* renamed from: z  reason: collision with root package name */
    private final long[] f3908z;

    /* renamed from: z0  reason: collision with root package name */
    private boolean f3909z0;

    /* loaded from: classes.dex */
    public static class a extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public final j codecInfo;
        public final String diagnosticInfo;
        public final a fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a(s0 s0Var, Throwable th, boolean z5, int i6) {
            this(r2.toString(), th, s0Var.f4056n, z5, null, buildCustomDiagnosticInfo(i6), null);
            String valueOf = String.valueOf(s0Var);
            StringBuilder sb = new StringBuilder(valueOf.length() + 36);
            sb.append("Decoder init failed: [");
            sb.append(i6);
            sb.append("], ");
            sb.append(valueOf);
        }

        private static String buildCustomDiagnosticInfo(int i6) {
            String str = i6 < 0 ? "neg_" : HttpUrl.FRAGMENT_ENCODE_SET;
            int abs = Math.abs(i6);
            StringBuilder sb = new StringBuilder(str.length() + 71);
            sb.append("com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_");
            sb.append(str);
            sb.append(abs);
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a copyWithFallbackException(a aVar) {
            return new a(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, aVar);
        }

        private static String getDiagnosticInfoV21(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a(s0 s0Var, Throwable th, boolean z5, j jVar) {
            this(r3.toString(), th, s0Var.f4056n, z5, jVar, com.google.android.exoplayer2.util.s0.f4673a >= 21 ? getDiagnosticInfoV21(th) : null, null);
            String str = jVar.f3861a;
            String valueOf = String.valueOf(s0Var);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23 + valueOf.length());
            sb.append("Decoder init failed: ");
            sb.append(str);
            sb.append(", ");
            sb.append(valueOf);
        }

        private a(String str, Throwable th, String str2, boolean z5, j jVar, String str3, a aVar) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z5;
            this.codecInfo = jVar;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = aVar;
        }
    }

    public m(int i6, o oVar, boolean z5, float f6) {
        super(i6);
        this.f3886o = (o) com.google.android.exoplayer2.util.a.e(oVar);
        this.f3888p = z5;
        this.f3890q = f6;
        this.f3892r = new com.google.android.exoplayer2.decoder.j(0);
        this.f3894s = com.google.android.exoplayer2.decoder.j.j();
        this.f3898u = new j0();
        this.f3900v = new ArrayList();
        this.f3902w = new MediaCodec.BufferInfo();
        this.H = 1.0f;
        this.A0 = 0;
        this.G = -9223372036854775807L;
        this.f3904x = new long[10];
        this.f3906y = new long[10];
        this.f3908z = new long[10];
        this.D0 = -9223372036854775807L;
        this.E0 = -9223372036854775807L;
        this.f3896t = new e();
        c1();
    }

    private boolean B0() {
        return this.f3879h0 >= 0;
    }

    private void C0(s0 s0Var) {
        c0();
        String str = s0Var.f4056n;
        if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
            this.f3896t.x(32);
        } else {
            this.f3896t.x(1);
        }
        this.f3883l0 = true;
    }

    private void D0(j jVar, MediaCrypto mediaCrypto) {
        MediaCodec mediaCodec;
        g zVar;
        String str = jVar.f3861a;
        int i6 = com.google.android.exoplayer2.util.s0.f4673a;
        float q02 = i6 < 23 ? -1.0f : q0(this.H, this.A, E());
        float f6 = q02 <= this.f3890q ? -1.0f : q02;
        g gVar = null;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String valueOf = String.valueOf(str);
            l0.a(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
            mediaCodec = MediaCodec.createByCodecName(str);
            try {
                int i7 = this.A0;
                zVar = (i7 != 2 || i6 < 23) ? (i7 != 4 || i6 < 23) ? new z(mediaCodec) : new c(mediaCodec, true, i()) : new c(mediaCodec, i());
            } catch (Exception e6) {
                e = e6;
            }
            try {
                l0.c();
                l0.a("configureCodec");
                a0(jVar, zVar, this.A, mediaCrypto, f6);
                l0.c();
                l0.a("startCodec");
                zVar.start();
                l0.c();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                n0(mediaCodec);
                this.I = mediaCodec;
                this.J = zVar;
                this.Q = jVar;
                this.N = f6;
                this.K = this.A;
                this.R = R(str);
                this.S = Y(str);
                this.T = S(str, this.K);
                this.U = W(str);
                this.V = Z(str);
                this.W = T(str);
                this.X = U(str);
                this.Y = X(str, this.K);
                this.f3873b0 = V(jVar) || p0();
                if ("c2.android.mp3.decoder".equals(jVar.f3861a)) {
                    this.f3874c0 = new f();
                }
                if (getState() == 2) {
                    this.f3877f0 = SystemClock.elapsedRealtime() + 1000;
                }
                this.C0.f3588a++;
                L0(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
            } catch (Exception e7) {
                e = e7;
                gVar = zVar;
                if (gVar != null) {
                    gVar.a();
                }
                if (mediaCodec != null) {
                    a1();
                    mediaCodec.release();
                }
                throw e;
            }
        } catch (Exception e8) {
            e = e8;
            mediaCodec = null;
        }
    }

    private boolean E0(long j6) {
        int size = this.f3900v.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (((Long) this.f3900v.get(i6)).longValue() == j6) {
                this.f3900v.remove(i6);
                return true;
            }
        }
        return false;
    }

    private static boolean F0(IllegalStateException illegalStateException) {
        if (com.google.android.exoplayer2.util.s0.f4673a < 21 || !G0(illegalStateException)) {
            StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
            return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
        }
        return true;
    }

    private static boolean G0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private void J0(MediaCrypto mediaCrypto, boolean z5) {
        if (this.O == null) {
            try {
                List l02 = l0(z5);
                ArrayDeque arrayDeque = new ArrayDeque();
                this.O = arrayDeque;
                if (this.f3888p) {
                    arrayDeque.addAll(l02);
                } else if (!l02.isEmpty()) {
                    this.O.add((j) l02.get(0));
                }
                this.P = null;
            } catch (x.c e6) {
                throw new a(this.A, e6, z5, -49998);
            }
        }
        if (this.O.isEmpty()) {
            throw new a(this.A, (Throwable) null, z5, -49999);
        }
        while (this.I == null) {
            j jVar = (j) this.O.peekFirst();
            if (!k1(jVar)) {
                return;
            }
            try {
                D0(jVar, mediaCrypto);
            } catch (Exception e7) {
                String valueOf = String.valueOf(jVar);
                StringBuilder sb = new StringBuilder(valueOf.length() + 30);
                sb.append("Failed to initialize decoder: ");
                sb.append(valueOf);
                com.google.android.exoplayer2.util.n.i("MediaCodecRenderer", sb.toString(), e7);
                this.O.removeFirst();
                a aVar = new a(this.A, e7, z5, jVar);
                if (this.P == null) {
                    this.P = aVar;
                } else {
                    this.P = this.P.copyWithFallbackException(aVar);
                }
                if (this.O.isEmpty()) {
                    throw this.P;
                }
            }
        }
        this.O = null;
    }

    private boolean K0(com.google.android.exoplayer2.drm.m mVar, s0 s0Var) {
        com.google.android.exoplayer2.drm.a0 s02 = s0(mVar);
        if (s02 == null) {
            return true;
        }
        if (s02.f3623c) {
            return false;
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(s02.f3621a, s02.f3622b);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(s0Var.f4056n);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    private boolean P(long j6, long j7) {
        e eVar;
        e eVar2 = this.f3896t;
        com.google.android.exoplayer2.util.a.g(!this.f3905x0);
        if (eVar2.u()) {
            eVar = eVar2;
        } else {
            eVar = eVar2;
            if (!S0(j6, j7, null, eVar2.f3600b, this.f3879h0, 0, eVar2.q(), eVar2.r(), eVar2.isDecodeOnly(), eVar2.isEndOfStream(), this.B)) {
                return false;
            }
            O0(eVar.s());
        }
        if (eVar.isEndOfStream()) {
            this.f3905x0 = true;
            return false;
        }
        eVar.l();
        if (this.f3884m0) {
            if (!eVar.u()) {
                return true;
            }
            c0();
            this.f3884m0 = false;
            I0();
            if (!this.f3883l0) {
                return false;
            }
        }
        com.google.android.exoplayer2.util.a.g(!this.f3903w0);
        t0 C = C();
        e eVar3 = eVar;
        boolean V0 = V0(C, eVar3);
        if (!eVar3.u() && this.f3907y0) {
            s0 s0Var = (s0) com.google.android.exoplayer2.util.a.e(this.A);
            this.B = s0Var;
            N0(s0Var, null);
            this.f3907y0 = false;
        }
        if (V0) {
            M0(C);
        }
        if (eVar3.isEndOfStream()) {
            this.f3903w0 = true;
        }
        if (eVar3.u()) {
            return false;
        }
        eVar3.g();
        eVar3.f3600b.order(ByteOrder.nativeOrder());
        return true;
    }

    private int R(String str) {
        int i6 = com.google.android.exoplayer2.util.s0.f4673a;
        if (i6 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = com.google.android.exoplayer2.util.s0.f4676d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i6 < 24) {
            if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
                String str3 = com.google.android.exoplayer2.util.s0.f4674b;
                return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
            }
            return 0;
        }
        return 0;
    }

    private void R0() {
        int i6 = this.f3891q0;
        if (i6 == 1) {
            j0();
        } else if (i6 == 2) {
            p1();
        } else if (i6 == 3) {
            X0();
        } else {
            this.f3905x0 = true;
            Z0();
        }
    }

    private static boolean S(String str, s0 s0Var) {
        return com.google.android.exoplayer2.util.s0.f4673a < 21 && s0Var.f4058p.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean T(String str) {
        int i6 = com.google.android.exoplayer2.util.s0.f4673a;
        if (i6 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i6 <= 19) {
                String str2 = com.google.android.exoplayer2.util.s0.f4674b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    private void T0() {
        if (com.google.android.exoplayer2.util.s0.f4673a < 21) {
            this.f3876e0 = this.I.getOutputBuffers();
        }
    }

    private static boolean U(String str) {
        return com.google.android.exoplayer2.util.s0.f4673a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private void U0() {
        this.f3897t0 = true;
        MediaFormat f6 = this.J.f();
        if (this.R != 0 && f6.getInteger("width") == 32 && f6.getInteger("height") == 32) {
            this.f3872a0 = true;
            return;
        }
        if (this.Y) {
            f6.setInteger("channel-count", 1);
        }
        this.L = f6;
        this.M = true;
    }

    private static boolean V(j jVar) {
        String str = jVar.f3861a;
        int i6 = com.google.android.exoplayer2.util.s0.f4673a;
        return (i6 <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i6 <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i6 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) || ("Amazon".equals(com.google.android.exoplayer2.util.s0.f4675c) && "AFTS".equals(com.google.android.exoplayer2.util.s0.f4676d) && jVar.f3867g));
    }

    private boolean V0(t0 t0Var, e eVar) {
        while (!eVar.v() && !eVar.isEndOfStream()) {
            int N = N(t0Var, eVar.t(), false);
            if (N == -5) {
                return true;
            }
            if (N != -4) {
                if (N == -3) {
                    return false;
                }
                throw new IllegalStateException();
            }
            eVar.o();
        }
        return false;
    }

    private static boolean W(String str) {
        int i6 = com.google.android.exoplayer2.util.s0.f4673a;
        return i6 < 18 || (i6 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i6 == 19 && com.google.android.exoplayer2.util.s0.f4676d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private boolean W0(boolean z5) {
        t0 C = C();
        this.f3894s.clear();
        int N = N(C, this.f3894s, z5);
        if (N == -5) {
            M0(C);
            return true;
        } else if (N == -4 && this.f3894s.isEndOfStream()) {
            this.f3903w0 = true;
            R0();
            return false;
        } else {
            return false;
        }
    }

    private static boolean X(String str, s0 s0Var) {
        return com.google.android.exoplayer2.util.s0.f4673a <= 18 && s0Var.A == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private void X0() {
        Y0();
        I0();
    }

    private static boolean Y(String str) {
        return com.google.android.exoplayer2.util.s0.f4676d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean Z(String str) {
        return com.google.android.exoplayer2.util.s0.f4673a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private void a1() {
        if (com.google.android.exoplayer2.util.s0.f4673a < 21) {
            this.f3875d0 = null;
            this.f3876e0 = null;
        }
    }

    private void c0() {
        this.f3884m0 = false;
        this.f3896t.clear();
        this.f3883l0 = false;
    }

    private void d0() {
        if (this.f3893r0) {
            this.f3889p0 = 1;
            this.f3891q0 = 1;
        }
    }

    private void d1() {
        this.f3878g0 = -1;
        this.f3892r.f3600b = null;
    }

    private void e0() {
        if (!this.f3893r0) {
            X0();
            return;
        }
        this.f3889p0 = 1;
        this.f3891q0 = 3;
    }

    private void e1() {
        this.f3879h0 = -1;
        this.f3880i0 = null;
    }

    private void f0() {
        if (com.google.android.exoplayer2.util.s0.f4673a < 23) {
            e0();
        } else if (!this.f3893r0) {
            p1();
        } else {
            this.f3889p0 = 1;
            this.f3891q0 = 2;
        }
    }

    private void f1(com.google.android.exoplayer2.drm.m mVar) {
        com.google.android.exoplayer2.drm.l.a(this.C, mVar);
        this.C = mVar;
    }

    private boolean g0(long j6, long j7) {
        boolean z5;
        boolean S0;
        MediaCodec mediaCodec;
        ByteBuffer byteBuffer;
        int i6;
        MediaCodec.BufferInfo bufferInfo;
        int d6;
        if (!B0()) {
            if (this.X && this.f3895s0) {
                try {
                    d6 = this.J.d(this.f3902w);
                } catch (IllegalStateException unused) {
                    R0();
                    if (this.f3905x0) {
                        Y0();
                    }
                    return false;
                }
            } else {
                d6 = this.J.d(this.f3902w);
            }
            if (d6 < 0) {
                if (d6 == -2) {
                    U0();
                    return true;
                } else if (d6 == -3) {
                    T0();
                    return true;
                } else {
                    if (this.f3873b0 && (this.f3903w0 || this.f3889p0 == 2)) {
                        R0();
                    }
                    return false;
                }
            } else if (this.f3872a0) {
                this.f3872a0 = false;
                this.I.releaseOutputBuffer(d6, false);
                return true;
            } else {
                MediaCodec.BufferInfo bufferInfo2 = this.f3902w;
                if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                    R0();
                    return false;
                }
                this.f3879h0 = d6;
                ByteBuffer x02 = x0(d6);
                this.f3880i0 = x02;
                if (x02 != null) {
                    x02.position(this.f3902w.offset);
                    ByteBuffer byteBuffer2 = this.f3880i0;
                    MediaCodec.BufferInfo bufferInfo3 = this.f3902w;
                    byteBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
                }
                this.f3881j0 = E0(this.f3902w.presentationTimeUs);
                long j8 = this.f3901v0;
                long j9 = this.f3902w.presentationTimeUs;
                this.f3882k0 = j8 == j9;
                q1(j9);
            }
        }
        if (this.X && this.f3895s0) {
            try {
                mediaCodec = this.I;
                byteBuffer = this.f3880i0;
                i6 = this.f3879h0;
                bufferInfo = this.f3902w;
                z5 = false;
            } catch (IllegalStateException unused2) {
                z5 = false;
            }
            try {
                S0 = S0(j6, j7, mediaCodec, byteBuffer, i6, bufferInfo.flags, 1, bufferInfo.presentationTimeUs, this.f3881j0, this.f3882k0, this.B);
            } catch (IllegalStateException unused3) {
                R0();
                if (this.f3905x0) {
                    Y0();
                }
                return z5;
            }
        } else {
            z5 = false;
            MediaCodec mediaCodec2 = this.I;
            ByteBuffer byteBuffer3 = this.f3880i0;
            int i7 = this.f3879h0;
            MediaCodec.BufferInfo bufferInfo4 = this.f3902w;
            S0 = S0(j6, j7, mediaCodec2, byteBuffer3, i7, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.f3881j0, this.f3882k0, this.B);
        }
        if (S0) {
            O0(this.f3902w.presentationTimeUs);
            boolean z6 = (this.f3902w.flags & 4) != 0;
            e1();
            if (!z6) {
                return true;
            }
            R0();
        }
        return z5;
    }

    private boolean i0() {
        if (this.I == null || this.f3889p0 == 2 || this.f3903w0) {
            return false;
        }
        if (this.f3878g0 < 0) {
            int g6 = this.J.g();
            this.f3878g0 = g6;
            if (g6 < 0) {
                return false;
            }
            this.f3892r.f3600b = t0(g6);
            this.f3892r.clear();
        }
        if (this.f3889p0 == 1) {
            if (!this.f3873b0) {
                this.f3895s0 = true;
                this.J.c(this.f3878g0, 0, 0, 0L, 4);
                d1();
            }
            this.f3889p0 = 2;
            return false;
        } else if (this.Z) {
            this.Z = false;
            ByteBuffer byteBuffer = this.f3892r.f3600b;
            byte[] bArr = G0;
            byteBuffer.put(bArr);
            this.J.c(this.f3878g0, 0, bArr.length, 0L, 0);
            d1();
            this.f3893r0 = true;
            return true;
        } else {
            if (this.f3887o0 == 1) {
                for (int i6 = 0; i6 < this.K.f4058p.size(); i6++) {
                    this.f3892r.f3600b.put((byte[]) this.K.f4058p.get(i6));
                }
                this.f3887o0 = 2;
            }
            int position = this.f3892r.f3600b.position();
            t0 C = C();
            int N = N(C, this.f3892r, false);
            if (l()) {
                this.f3901v0 = this.f3899u0;
            }
            if (N == -3) {
                return false;
            }
            if (N == -5) {
                if (this.f3887o0 == 2) {
                    this.f3892r.clear();
                    this.f3887o0 = 1;
                }
                M0(C);
                return true;
            } else if (this.f3892r.isEndOfStream()) {
                if (this.f3887o0 == 2) {
                    this.f3892r.clear();
                    this.f3887o0 = 1;
                }
                this.f3903w0 = true;
                if (!this.f3893r0) {
                    R0();
                    return false;
                }
                try {
                    if (!this.f3873b0) {
                        this.f3895s0 = true;
                        this.J.c(this.f3878g0, 0, 0, 0L, 4);
                        d1();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e6) {
                    throw A(e6, this.A);
                }
            } else if (!this.f3893r0 && !this.f3892r.isKeyFrame()) {
                this.f3892r.clear();
                if (this.f3887o0 == 2) {
                    this.f3887o0 = 1;
                }
                return true;
            } else {
                boolean h6 = this.f3892r.h();
                if (h6) {
                    this.f3892r.f3599a.b(position);
                }
                if (this.T && !h6) {
                    com.google.android.exoplayer2.util.r.b(this.f3892r.f3600b);
                    if (this.f3892r.f3600b.position() == 0) {
                        return true;
                    }
                    this.T = false;
                }
                com.google.android.exoplayer2.decoder.j jVar = this.f3892r;
                long j6 = jVar.f3602d;
                f fVar = this.f3874c0;
                if (fVar != null) {
                    j6 = fVar.c(this.A, jVar);
                }
                long j7 = j6;
                if (this.f3892r.isDecodeOnly()) {
                    this.f3900v.add(Long.valueOf(j7));
                }
                if (this.f3907y0) {
                    this.f3898u.a(j7, this.A);
                    this.f3907y0 = false;
                }
                f fVar2 = this.f3874c0;
                long j8 = this.f3899u0;
                this.f3899u0 = fVar2 != null ? Math.max(j8, this.f3892r.f3602d) : Math.max(j8, j7);
                this.f3892r.g();
                if (this.f3892r.hasSupplementalData()) {
                    A0(this.f3892r);
                }
                Q0(this.f3892r);
                try {
                    if (h6) {
                        this.J.b(this.f3878g0, 0, this.f3892r.f3599a, j7, 0);
                    } else {
                        this.J.c(this.f3878g0, 0, this.f3892r.f3600b.limit(), j7, 0);
                    }
                    d1();
                    this.f3893r0 = true;
                    this.f3887o0 = 0;
                    this.C0.f3590c++;
                    return true;
                } catch (MediaCodec.CryptoException e7) {
                    throw A(e7, this.A);
                }
            }
        }
    }

    private void i1(com.google.android.exoplayer2.drm.m mVar) {
        com.google.android.exoplayer2.drm.l.a(this.D, mVar);
        this.D = mVar;
    }

    private boolean j1(long j6) {
        return this.G == -9223372036854775807L || SystemClock.elapsedRealtime() - j6 < this.G;
    }

    private List l0(boolean z5) {
        List r02 = r0(this.f3886o, this.A, z5);
        if (r02.isEmpty() && z5) {
            r02 = r0(this.f3886o, this.A, false);
            if (!r02.isEmpty()) {
                String str = this.A.f4056n;
                String valueOf = String.valueOf(r02);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 99 + valueOf.length());
                sb.append("Drm session requires secure decoder for ");
                sb.append(str);
                sb.append(", but no secure decoder available. Trying to proceed with ");
                sb.append(valueOf);
                sb.append(".");
                com.google.android.exoplayer2.util.n.h("MediaCodecRenderer", sb.toString());
            }
        }
        return r02;
    }

    private void n0(MediaCodec mediaCodec) {
        if (com.google.android.exoplayer2.util.s0.f4673a < 21) {
            this.f3875d0 = mediaCodec.getInputBuffers();
            this.f3876e0 = mediaCodec.getOutputBuffers();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean n1(s0 s0Var) {
        Class cls = s0Var.G;
        return cls == null || com.google.android.exoplayer2.drm.a0.class.equals(cls);
    }

    private void o1() {
        if (com.google.android.exoplayer2.util.s0.f4673a < 23) {
            return;
        }
        float q02 = q0(this.H, this.K, E());
        float f6 = this.N;
        if (f6 == q02) {
            return;
        }
        if (q02 == -1.0f) {
            e0();
        } else if (f6 != -1.0f || q02 > this.f3890q) {
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", q02);
            this.I.setParameters(bundle);
            this.N = q02;
        }
    }

    private void p1() {
        com.google.android.exoplayer2.drm.a0 s02 = s0(this.D);
        if (s02 == null) {
            X0();
        } else if (com.google.android.exoplayer2.p.f3952e.equals(s02.f3621a)) {
            X0();
        } else if (j0()) {
        } else {
            try {
                this.E.setMediaDrmSession(s02.f3622b);
                f1(this.D);
                this.f3889p0 = 0;
                this.f3891q0 = 0;
            } catch (MediaCryptoException e6) {
                throw A(e6, this.A);
            }
        }
    }

    private com.google.android.exoplayer2.drm.a0 s0(com.google.android.exoplayer2.drm.m mVar) {
        com.google.android.exoplayer2.drm.y e6 = mVar.e();
        if (e6 == null || (e6 instanceof com.google.android.exoplayer2.drm.a0)) {
            return (com.google.android.exoplayer2.drm.a0) e6;
        }
        String valueOf = String.valueOf(e6);
        StringBuilder sb = new StringBuilder(valueOf.length() + 42);
        sb.append("Expecting FrameworkMediaCrypto but found: ");
        sb.append(valueOf);
        throw A(new IllegalArgumentException(sb.toString()), this.A);
    }

    private ByteBuffer t0(int i6) {
        return com.google.android.exoplayer2.util.s0.f4673a >= 21 ? this.I.getInputBuffer(i6) : this.f3875d0[i6];
    }

    private ByteBuffer x0(int i6) {
        return com.google.android.exoplayer2.util.s0.f4673a >= 21 ? this.I.getOutputBuffer(i6) : this.f3876e0[i6];
    }

    protected void A0(com.google.android.exoplayer2.decoder.j jVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.o
    public void G() {
        this.A = null;
        this.D0 = -9223372036854775807L;
        this.E0 = -9223372036854775807L;
        this.F0 = 0;
        if (this.D == null && this.C == null) {
            k0();
        } else {
            J();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.o
    public void H(boolean z5, boolean z6) {
        this.C0 = new com.google.android.exoplayer2.decoder.h();
    }

    protected boolean H0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.o
    public void I(long j6, boolean z5) {
        this.f3903w0 = false;
        this.f3905x0 = false;
        this.f3909z0 = false;
        if (this.f3883l0) {
            this.f3896t.p();
        } else {
            j0();
        }
        if (this.f3898u.k() > 0) {
            this.f3907y0 = true;
        }
        this.f3898u.c();
        int i6 = this.F0;
        if (i6 != 0) {
            this.E0 = this.f3906y[i6 - 1];
            this.D0 = this.f3904x[i6 - 1];
            this.F0 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I0() {
        s0 s0Var;
        if (this.I != null || this.f3883l0 || (s0Var = this.A) == null) {
            return;
        }
        if (this.D == null && l1(s0Var)) {
            C0(this.A);
            return;
        }
        f1(this.D);
        String str = this.A.f4056n;
        com.google.android.exoplayer2.drm.m mVar = this.C;
        if (mVar != null) {
            if (this.E == null) {
                com.google.android.exoplayer2.drm.a0 s02 = s0(mVar);
                if (s02 != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(s02.f3621a, s02.f3622b);
                        this.E = mediaCrypto;
                        this.F = !s02.f3623c && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e6) {
                        throw A(e6, this.A);
                    }
                } else if (this.C.f() == null) {
                    return;
                }
            }
            if (com.google.android.exoplayer2.drm.a0.f3620d) {
                int state = this.C.getState();
                if (state == 1) {
                    throw A(this.C.f(), this.A);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            J0(this.E, this.F);
        } catch (a e7) {
            throw A(e7, this.A);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.o
    public void J() {
        try {
            c0();
            Y0();
        } finally {
            i1(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.o
    public void K() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.o
    public void L() {
    }

    protected abstract void L0(String str, long j6, long j7);

    @Override // com.google.android.exoplayer2.o
    protected void M(s0[] s0VarArr, long j6, long j7) {
        if (this.E0 == -9223372036854775807L) {
            com.google.android.exoplayer2.util.a.g(this.D0 == -9223372036854775807L);
            this.D0 = j6;
            this.E0 = j7;
            return;
        }
        int i6 = this.F0;
        long[] jArr = this.f3906y;
        if (i6 == jArr.length) {
            long j8 = jArr[i6 - 1];
            StringBuilder sb = new StringBuilder(65);
            sb.append("Too many stream changes, so dropping offset: ");
            sb.append(j8);
            com.google.android.exoplayer2.util.n.h("MediaCodecRenderer", sb.toString());
        } else {
            this.F0 = i6 + 1;
        }
        long[] jArr2 = this.f3904x;
        int i7 = this.F0;
        jArr2[i7 - 1] = j6;
        this.f3906y[i7 - 1] = j7;
        this.f3908z[i7 - 1] = this.f3899u0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0099, code lost:
        if (r1.f4062t == r2.f4062t) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void M0(t0 t0Var) {
        boolean z5 = true;
        this.f3907y0 = true;
        s0 s0Var = (s0) com.google.android.exoplayer2.util.a.e(t0Var.f4441b);
        i1(t0Var.f4440a);
        this.A = s0Var;
        if (this.f3883l0) {
            this.f3884m0 = true;
        } else if (this.I == null) {
            if (!H0()) {
                this.O = null;
            }
            I0();
        } else {
            com.google.android.exoplayer2.drm.m mVar = this.D;
            if ((mVar == null && this.C != null) || ((mVar != null && this.C == null) || ((mVar != this.C && !this.Q.f3867g && K0(mVar, s0Var)) || (com.google.android.exoplayer2.util.s0.f4673a < 23 && this.D != this.C)))) {
                e0();
                return;
            }
            int Q = Q(this.I, this.Q, this.K, s0Var);
            if (Q != 0) {
                if (Q == 1) {
                    this.K = s0Var;
                    o1();
                    if (this.D == this.C) {
                        d0();
                        return;
                    }
                } else if (Q != 2) {
                    if (Q != 3) {
                        throw new IllegalStateException();
                    }
                    this.K = s0Var;
                    o1();
                    if (this.D == this.C) {
                        return;
                    }
                } else if (!this.S) {
                    this.f3885n0 = true;
                    this.f3887o0 = 1;
                    int i6 = this.R;
                    if (i6 != 2) {
                        if (i6 == 1) {
                            int i7 = s0Var.f4061s;
                            s0 s0Var2 = this.K;
                            if (i7 == s0Var2.f4061s) {
                            }
                        }
                        z5 = false;
                    }
                    this.Z = z5;
                    this.K = s0Var;
                    o1();
                    if (this.D == this.C) {
                        return;
                    }
                }
                f0();
                return;
            }
            e0();
        }
    }

    protected abstract void N0(s0 s0Var, MediaFormat mediaFormat);

    /* JADX INFO: Access modifiers changed from: protected */
    public void O0(long j6) {
        while (true) {
            int i6 = this.F0;
            if (i6 == 0 || j6 < this.f3908z[0]) {
                return;
            }
            long[] jArr = this.f3904x;
            this.D0 = jArr[0];
            this.E0 = this.f3906y[0];
            int i7 = i6 - 1;
            this.F0 = i7;
            System.arraycopy(jArr, 1, jArr, 0, i7);
            long[] jArr2 = this.f3906y;
            System.arraycopy(jArr2, 1, jArr2, 0, this.F0);
            long[] jArr3 = this.f3908z;
            System.arraycopy(jArr3, 1, jArr3, 0, this.F0);
            P0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P0() {
    }

    protected abstract int Q(MediaCodec mediaCodec, j jVar, s0 s0Var, s0 s0Var2);

    protected abstract void Q0(com.google.android.exoplayer2.decoder.j jVar);

    protected abstract boolean S0(long j6, long j7, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i6, int i7, int i8, long j8, boolean z5, boolean z6, s0 s0Var);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.drm.m, android.media.MediaCrypto] */
    public void Y0() {
        try {
            g gVar = this.J;
            if (gVar != null) {
                gVar.a();
            }
            MediaCodec mediaCodec = this.I;
            if (mediaCodec != null) {
                this.C0.f3589b++;
                mediaCodec.release();
            }
            this.I = null;
            this.J = null;
            try {
                MediaCrypto mediaCrypto = this.E;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.I = null;
            this.J = null;
            try {
                MediaCrypto mediaCrypto2 = this.E;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    protected void Z0() {
    }

    @Override // com.google.android.exoplayer2.p1
    public final int a(s0 s0Var) {
        try {
            return m1(this.f3886o, s0Var);
        } catch (x.c e6) {
            throw A(e6, s0Var);
        }
    }

    protected abstract void a0(j jVar, g gVar, s0 s0Var, MediaCrypto mediaCrypto, float f6);

    protected i b0(Throwable th, j jVar) {
        return new i(th, jVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b1() {
        d1();
        e1();
        this.f3877f0 = -9223372036854775807L;
        this.f3895s0 = false;
        this.f3893r0 = false;
        this.Z = false;
        this.f3872a0 = false;
        this.f3881j0 = false;
        this.f3882k0 = false;
        this.f3900v.clear();
        this.f3899u0 = -9223372036854775807L;
        this.f3901v0 = -9223372036854775807L;
        f fVar = this.f3874c0;
        if (fVar != null) {
            fVar.b();
        }
        this.f3889p0 = 0;
        this.f3891q0 = 0;
        this.f3887o0 = this.f3885n0 ? 1 : 0;
    }

    protected void c1() {
        b1();
        this.B0 = null;
        this.f3874c0 = null;
        this.O = null;
        this.Q = null;
        this.K = null;
        this.L = null;
        this.M = false;
        this.f3897t0 = false;
        this.N = -1.0f;
        this.R = 0;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.f3873b0 = false;
        this.f3885n0 = false;
        this.f3887o0 = 0;
        a1();
        this.F = false;
    }

    @Override // com.google.android.exoplayer2.n1
    public boolean d() {
        return this.f3905x0;
    }

    @Override // com.google.android.exoplayer2.n1
    public boolean g() {
        return this.A != null && (F() || B0() || (this.f3877f0 != -9223372036854775807L && SystemClock.elapsedRealtime() < this.f3877f0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g1() {
        this.f3909z0 = true;
    }

    public void h0(int i6) {
        this.A0 = i6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h1(com.google.android.exoplayer2.t tVar) {
        this.B0 = tVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean j0() {
        boolean k02 = k0();
        if (k02) {
            I0();
        }
        return k02;
    }

    protected boolean k0() {
        if (this.I == null) {
            return false;
        }
        if (this.f3891q0 == 3 || this.U || ((this.V && !this.f3897t0) || (this.W && this.f3895s0))) {
            Y0();
            return true;
        }
        try {
            this.J.flush();
            return false;
        } finally {
            b1();
        }
    }

    protected boolean k1(j jVar) {
        return true;
    }

    protected boolean l1(s0 s0Var) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaCodec m0() {
        return this.I;
    }

    protected abstract int m1(o oVar, s0 s0Var);

    @Override // com.google.android.exoplayer2.o, com.google.android.exoplayer2.p1
    public final int n() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.n1
    public void o(long j6, long j7) {
        if (this.f3909z0) {
            this.f3909z0 = false;
            R0();
        }
        com.google.android.exoplayer2.t tVar = this.B0;
        if (tVar != null) {
            this.B0 = null;
            throw tVar;
        }
        try {
            if (this.f3905x0) {
                Z0();
            } else if (this.A != null || W0(true)) {
                I0();
                if (this.f3883l0) {
                    l0.a("bypassRender");
                    while (P(j6, j7)) {
                    }
                } else if (this.I == null) {
                    this.C0.f3591d += O(j6);
                    W0(false);
                    this.C0.c();
                } else {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    l0.a("drainAndFeed");
                    while (g0(j6, j7) && j1(elapsedRealtime)) {
                    }
                    while (i0() && j1(elapsedRealtime)) {
                    }
                }
                l0.c();
                this.C0.c();
            }
        } catch (IllegalStateException e6) {
            if (!F0(e6)) {
                throw e6;
            }
            throw A(b0(e6, o0()), this.A);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final j o0() {
        return this.Q;
    }

    protected boolean p0() {
        return false;
    }

    protected abstract float q0(float f6, s0 s0Var, s0[] s0VarArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q1(long j6) {
        boolean z5;
        s0 s0Var = (s0) this.f3898u.i(j6);
        if (s0Var == null && this.M) {
            s0Var = (s0) this.f3898u.h();
        }
        if (s0Var != null) {
            this.B = s0Var;
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 || (this.M && this.B != null)) {
            N0(this.B, this.L);
            this.M = false;
        }
    }

    @Override // com.google.android.exoplayer2.o, com.google.android.exoplayer2.n1
    public void r(float f6) {
        this.H = f6;
        if (this.I == null || this.f3891q0 == 3 || getState() == 0) {
            return;
        }
        o1();
    }

    protected abstract List r0(o oVar, s0 s0Var, boolean z5);

    /* JADX INFO: Access modifiers changed from: protected */
    public s0 u0() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long v0() {
        return this.f3899u0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float w0() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s0 y0() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long z0() {
        return this.E0;
    }
}
