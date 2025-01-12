package com.google.android.exoplayer2.audio;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.audio.q;
import com.google.android.exoplayer2.audio.r;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.s0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class b1 extends com.google.android.exoplayer2.mediacodec.m implements com.google.android.exoplayer2.util.p {
    private final Context H0;
    private final q.a I0;
    private final r J0;
    private int K0;
    private boolean L0;
    private boolean M0;
    private com.google.android.exoplayer2.s0 N0;
    private long O0;
    private boolean P0;
    private boolean Q0;
    private boolean R0;
    private n1.a S0;

    /* loaded from: classes.dex */
    private final class b implements r.c {
        private b() {
        }

        @Override // com.google.android.exoplayer2.audio.r.c
        public void a(boolean z5) {
            b1.this.I0.w(z5);
        }

        @Override // com.google.android.exoplayer2.audio.r.c
        public void b(int i6) {
            b1.this.I0.i(i6);
            b1.this.A1(i6);
        }

        @Override // com.google.android.exoplayer2.audio.r.c
        public void c(long j6) {
            b1.this.I0.v(j6);
        }

        @Override // com.google.android.exoplayer2.audio.r.c
        public void d(long j6) {
            if (b1.this.S0 != null) {
                b1.this.S0.b(j6);
            }
        }

        @Override // com.google.android.exoplayer2.audio.r.c
        public void e() {
            b1.this.B1();
        }

        @Override // com.google.android.exoplayer2.audio.r.c
        public void f() {
            if (b1.this.S0 != null) {
                b1.this.S0.a();
            }
        }

        @Override // com.google.android.exoplayer2.audio.r.c
        public void g(int i6, long j6, long j7) {
            b1.this.I0.x(i6, j6, j7);
        }
    }

    public b1(Context context, com.google.android.exoplayer2.mediacodec.o oVar, boolean z5, Handler handler, q qVar, r rVar) {
        super(1, oVar, z5, 44100.0f);
        this.H0 = context.getApplicationContext();
        this.J0 = rVar;
        this.I0 = new q.a(handler, qVar);
        rVar.q(new b());
    }

    private void C1() {
        long o5 = this.J0.o(d());
        if (o5 != Long.MIN_VALUE) {
            if (!this.Q0) {
                o5 = Math.max(this.O0, o5);
            }
            this.O0 = o5;
            this.Q0 = false;
        }
    }

    private static boolean u1(String str) {
        if (com.google.android.exoplayer2.util.s0.f4673a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(com.google.android.exoplayer2.util.s0.f4675c)) {
            String str2 = com.google.android.exoplayer2.util.s0.f4674b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private static boolean v1(String str) {
        if (com.google.android.exoplayer2.util.s0.f4673a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(com.google.android.exoplayer2.util.s0.f4675c)) {
            String str2 = com.google.android.exoplayer2.util.s0.f4674b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    private static boolean w1() {
        if (com.google.android.exoplayer2.util.s0.f4673a == 23) {
            String str = com.google.android.exoplayer2.util.s0.f4676d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int x1(com.google.android.exoplayer2.mediacodec.j jVar, com.google.android.exoplayer2.s0 s0Var) {
        int i6;
        if (!"OMX.google.raw.decoder".equals(jVar.f3861a) || (i6 = com.google.android.exoplayer2.util.s0.f4673a) >= 24 || (i6 == 23 && com.google.android.exoplayer2.util.s0.q0(this.H0))) {
            return s0Var.f4057o;
        }
        return -1;
    }

    protected void A1(int i6) {
    }

    protected void B1() {
        this.Q0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o
    public void G() {
        try {
            this.J0.flush();
            try {
                super.G();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.G();
                throw th;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o
    public void H(boolean z5, boolean z6) {
        super.H(z5, z6);
        this.I0.l(this.C0);
        int i6 = B().f4025a;
        if (i6 != 0) {
            this.J0.z(i6);
        } else {
            this.J0.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o
    public void I(long j6, boolean z5) {
        super.I(j6, z5);
        if (this.R0) {
            this.J0.u();
        } else {
            this.J0.flush();
        }
        this.O0 = j6;
        this.P0 = true;
        this.Q0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o
    public void J() {
        try {
            super.J();
        } finally {
            this.J0.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o
    public void K() {
        super.K();
        this.J0.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.o
    public void L() {
        C1();
        this.J0.n();
        super.L();
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected void L0(String str, long j6, long j7) {
        this.I0.j(str, j6, j7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m
    public void M0(com.google.android.exoplayer2.t0 t0Var) {
        super.M0(t0Var);
        this.I0.m(t0Var.f4441b);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0091 A[LOOP:0: B:30:0x008d->B:32:0x0091, LOOP_END] */
    @Override // com.google.android.exoplayer2.mediacodec.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void N0(com.google.android.exoplayer2.s0 s0Var, MediaFormat mediaFormat) {
        int i6;
        int i7;
        int i8;
        com.google.android.exoplayer2.s0 s0Var2 = this.N0;
        int[] iArr = null;
        if (s0Var2 == null) {
            if (m0() == null) {
                s0Var2 = s0Var;
            } else {
                if (!"audio/raw".equals(s0Var.f4056n)) {
                    if (com.google.android.exoplayer2.util.s0.f4673a >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                        i6 = mediaFormat.getInteger("pcm-encoding");
                    } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                        i6 = com.google.android.exoplayer2.util.s0.Y(mediaFormat.getInteger("v-bits-per-sample"));
                    } else if (!"audio/raw".equals(s0Var.f4056n)) {
                        i6 = 2;
                    }
                    s0Var2 = new s0.b().e0("audio/raw").Y(i6).M(s0Var.D).N(s0Var.E).H(mediaFormat.getInteger("channel-count")).f0(mediaFormat.getInteger("sample-rate")).E();
                    if (this.L0 && s0Var2.A == 6 && (i7 = s0Var.A) < 6) {
                        iArr = new int[i7];
                        for (i8 = 0; i8 < s0Var.A; i8++) {
                            iArr[i8] = i8;
                        }
                    }
                }
                i6 = s0Var.C;
                s0Var2 = new s0.b().e0("audio/raw").Y(i6).M(s0Var.D).N(s0Var.E).H(mediaFormat.getInteger("channel-count")).f0(mediaFormat.getInteger("sample-rate")).E();
                if (this.L0) {
                    iArr = new int[i7];
                    while (i8 < s0Var.A) {
                    }
                }
            }
        }
        try {
            this.J0.t(s0Var2, 0, iArr);
        } catch (r.a e6) {
            throw A(e6, s0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.m
    public void P0() {
        super.P0();
        this.J0.x();
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected int Q(MediaCodec mediaCodec, com.google.android.exoplayer2.mediacodec.j jVar, com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.s0 s0Var2) {
        if (x1(jVar, s0Var2) > this.K0) {
            return 0;
        }
        if (jVar.o(s0Var, s0Var2, true)) {
            return 3;
        }
        return t1(s0Var, s0Var2) ? 1 : 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected void Q0(com.google.android.exoplayer2.decoder.j jVar) {
        if (!this.P0 || jVar.isDecodeOnly()) {
            return;
        }
        if (Math.abs(jVar.f3602d - this.O0) > 500000) {
            this.O0 = jVar.f3602d;
        }
        this.P0 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected boolean S0(long j6, long j7, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i6, int i7, int i8, long j8, boolean z5, boolean z6, com.google.android.exoplayer2.s0 s0Var) {
        com.google.android.exoplayer2.util.a.e(byteBuffer);
        if (mediaCodec != null && this.M0 && j8 == 0 && (i7 & 4) != 0 && v0() != -9223372036854775807L) {
            j8 = v0();
        }
        if (this.N0 != null && (i7 & 2) != 0) {
            ((MediaCodec) com.google.android.exoplayer2.util.a.e(mediaCodec)).releaseOutputBuffer(i6, false);
            return true;
        } else if (z5) {
            if (mediaCodec != null) {
                mediaCodec.releaseOutputBuffer(i6, false);
            }
            this.C0.f3593f += i8;
            this.J0.x();
            return true;
        } else {
            try {
                if (this.J0.m(byteBuffer, j8, i8)) {
                    if (mediaCodec != null) {
                        mediaCodec.releaseOutputBuffer(i6, false);
                    }
                    this.C0.f3592e += i8;
                    return true;
                }
                return false;
            } catch (r.b | r.d e6) {
                throw A(e6, s0Var);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected void Z0() {
        try {
            this.J0.i();
        } catch (r.d e6) {
            com.google.android.exoplayer2.s0 y02 = y0();
            if (y02 == null) {
                y02 = u0();
            }
            throw A(e6, y02);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected void a0(com.google.android.exoplayer2.mediacodec.j jVar, com.google.android.exoplayer2.mediacodec.g gVar, com.google.android.exoplayer2.s0 s0Var, MediaCrypto mediaCrypto, float f6) {
        this.K0 = y1(jVar, s0Var, E());
        this.L0 = u1(jVar.f3861a);
        this.M0 = v1(jVar.f3861a);
        boolean z5 = false;
        gVar.e(z1(s0Var, jVar.f3863c, this.K0, f6), null, mediaCrypto, 0);
        if ("audio/raw".equals(jVar.f3862b) && !"audio/raw".equals(s0Var.f4056n)) {
            z5 = true;
        }
        if (!z5) {
            s0Var = null;
        }
        this.N0 = s0Var;
    }

    @Override // com.google.android.exoplayer2.util.p
    public com.google.android.exoplayer2.h1 b() {
        return this.J0.b();
    }

    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.n1
    public boolean d() {
        return super.d() && this.J0.d();
    }

    @Override // com.google.android.exoplayer2.n1, com.google.android.exoplayer2.p1
    public String f() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.m, com.google.android.exoplayer2.n1
    public boolean g() {
        return this.J0.j() || super.g();
    }

    @Override // com.google.android.exoplayer2.util.p
    public void h(com.google.android.exoplayer2.h1 h1Var) {
        this.J0.h(h1Var);
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected boolean l1(com.google.android.exoplayer2.s0 s0Var) {
        return this.J0.a(s0Var);
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected int m1(com.google.android.exoplayer2.mediacodec.o oVar, com.google.android.exoplayer2.s0 s0Var) {
        if (com.google.android.exoplayer2.util.q.n(s0Var.f4056n)) {
            int i6 = com.google.android.exoplayer2.util.s0.f4673a >= 21 ? 32 : 0;
            boolean z5 = s0Var.G != null;
            boolean n12 = com.google.android.exoplayer2.mediacodec.m.n1(s0Var);
            int i7 = 8;
            if (n12 && this.J0.a(s0Var) && (!z5 || com.google.android.exoplayer2.mediacodec.x.v() != null)) {
                return o1.b(4, 8, i6);
            }
            if ((!"audio/raw".equals(s0Var.f4056n) || this.J0.a(s0Var)) && this.J0.a(com.google.android.exoplayer2.util.s0.Z(2, s0Var.A, s0Var.B))) {
                List r02 = r0(oVar, s0Var, false);
                if (r02.isEmpty()) {
                    return o1.a(1);
                }
                if (n12) {
                    com.google.android.exoplayer2.mediacodec.j jVar = (com.google.android.exoplayer2.mediacodec.j) r02.get(0);
                    boolean l6 = jVar.l(s0Var);
                    if (l6 && jVar.n(s0Var)) {
                        i7 = 16;
                    }
                    return o1.b(l6 ? 4 : 3, i7, i6);
                }
                return o1.a(2);
            }
            return o1.a(1);
        }
        return o1.a(0);
    }

    @Override // com.google.android.exoplayer2.o, com.google.android.exoplayer2.k1.b
    public void p(int i6, Object obj) {
        if (i6 == 2) {
            this.J0.y(((Float) obj).floatValue());
        } else if (i6 == 3) {
            this.J0.r((e) obj);
        } else if (i6 == 5) {
            this.J0.w((u) obj);
        } else {
            switch (i6) {
                case androidx.constraintlayout.widget.g.T0 /* 101 */:
                    this.J0.v(((Boolean) obj).booleanValue());
                    return;
                case androidx.constraintlayout.widget.g.U0 /* 102 */:
                    this.J0.k(((Integer) obj).intValue());
                    return;
                case androidx.constraintlayout.widget.g.V0 /* 103 */:
                    this.S0 = (n1.a) obj;
                    return;
                default:
                    super.p(i6, obj);
                    return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected float q0(float f6, com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.s0[] s0VarArr) {
        int i6 = -1;
        for (com.google.android.exoplayer2.s0 s0Var2 : s0VarArr) {
            int i7 = s0Var2.B;
            if (i7 != -1) {
                i6 = Math.max(i6, i7);
            }
        }
        if (i6 == -1) {
            return -1.0f;
        }
        return f6 * i6;
    }

    @Override // com.google.android.exoplayer2.mediacodec.m
    protected List r0(com.google.android.exoplayer2.mediacodec.o oVar, com.google.android.exoplayer2.s0 s0Var, boolean z5) {
        com.google.android.exoplayer2.mediacodec.j v5;
        String str = s0Var.f4056n;
        if (str == null) {
            return Collections.emptyList();
        }
        if (!this.J0.a(s0Var) || (v5 = com.google.android.exoplayer2.mediacodec.x.v()) == null) {
            List u5 = com.google.android.exoplayer2.mediacodec.x.u(oVar.a(str, z5, false), s0Var);
            if ("audio/eac3-joc".equals(str)) {
                ArrayList arrayList = new ArrayList(u5);
                arrayList.addAll(oVar.a("audio/eac3", z5, false));
                u5 = arrayList;
            }
            return Collections.unmodifiableList(u5);
        }
        return Collections.singletonList(v5);
    }

    protected boolean t1(com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.s0 s0Var2) {
        return com.google.android.exoplayer2.util.s0.c(s0Var.f4056n, s0Var2.f4056n) && s0Var.A == s0Var2.A && s0Var.B == s0Var2.B && s0Var.C == s0Var2.C && s0Var.h(s0Var2) && !"audio/opus".equals(s0Var.f4056n);
    }

    @Override // com.google.android.exoplayer2.o, com.google.android.exoplayer2.n1
    public com.google.android.exoplayer2.util.p x() {
        return this;
    }

    protected int y1(com.google.android.exoplayer2.mediacodec.j jVar, com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.s0[] s0VarArr) {
        int x12 = x1(jVar, s0Var);
        if (s0VarArr.length == 1) {
            return x12;
        }
        for (com.google.android.exoplayer2.s0 s0Var2 : s0VarArr) {
            if (jVar.o(s0Var, s0Var2, false)) {
                x12 = Math.max(x12, x1(jVar, s0Var2));
            }
        }
        return x12;
    }

    @Override // com.google.android.exoplayer2.util.p
    public long z() {
        if (getState() == 2) {
            C1();
        }
        return this.O0;
    }

    protected MediaFormat z1(com.google.android.exoplayer2.s0 s0Var, String str, int i6, float f6) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", s0Var.A);
        mediaFormat.setInteger("sample-rate", s0Var.B);
        com.google.android.exoplayer2.mediacodec.y.e(mediaFormat, s0Var.f4058p);
        com.google.android.exoplayer2.mediacodec.y.d(mediaFormat, "max-input-size", i6);
        int i7 = com.google.android.exoplayer2.util.s0.f4673a;
        if (i7 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f6 != -1.0f && !w1()) {
                mediaFormat.setFloat("operating-rate", f6);
            }
        }
        if (i7 <= 28 && "audio/ac4".equals(s0Var.f4056n)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i7 >= 24 && this.J0.s(com.google.android.exoplayer2.util.s0.Z(4, s0Var.A, s0Var.B)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        return mediaFormat;
    }
}
