package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.audio.h;
import com.google.android.exoplayer2.audio.r;
import com.google.android.exoplayer2.audio.t;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Executor;
import okio.Segment;
/* loaded from: classes.dex */
public final class m0 implements r {
    public static boolean Y;
    public static boolean Z;
    private long A;
    private long B;
    private int C;
    private boolean D;
    private boolean E;
    private long F;
    private float G;
    private com.google.android.exoplayer2.audio.h[] H;
    private ByteBuffer[] I;
    private ByteBuffer J;
    private int K;
    private ByteBuffer L;
    private byte[] M;
    private int N;
    private int O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private int S;
    private u T;
    private boolean U;
    private long V;
    private boolean W;
    private boolean X;

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.audio.f f3439a;

    /* renamed from: b  reason: collision with root package name */
    private final c f3440b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3441c;

    /* renamed from: d  reason: collision with root package name */
    private final w f3442d;

    /* renamed from: e  reason: collision with root package name */
    private final i1 f3443e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.exoplayer2.audio.h[] f3444f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.exoplayer2.audio.h[] f3445g;

    /* renamed from: h  reason: collision with root package name */
    private final ConditionVariable f3446h;

    /* renamed from: i  reason: collision with root package name */
    private final t f3447i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayDeque f3448j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f3449k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f3450l;

    /* renamed from: m  reason: collision with root package name */
    private i f3451m;

    /* renamed from: n  reason: collision with root package name */
    private r.c f3452n;

    /* renamed from: o  reason: collision with root package name */
    private AudioTrack f3453o;

    /* renamed from: p  reason: collision with root package name */
    private d f3454p;

    /* renamed from: q  reason: collision with root package name */
    private d f3455q;

    /* renamed from: r  reason: collision with root package name */
    private AudioTrack f3456r;

    /* renamed from: s  reason: collision with root package name */
    private com.google.android.exoplayer2.audio.e f3457s;

    /* renamed from: t  reason: collision with root package name */
    private g f3458t;

    /* renamed from: u  reason: collision with root package name */
    private g f3459u;

    /* renamed from: v  reason: collision with root package name */
    private com.google.android.exoplayer2.h1 f3460v;

    /* renamed from: w  reason: collision with root package name */
    private ByteBuffer f3461w;

    /* renamed from: x  reason: collision with root package name */
    private int f3462x;

    /* renamed from: y  reason: collision with root package name */
    private long f3463y;

    /* renamed from: z  reason: collision with root package name */
    private long f3464z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AudioTrack f3465a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, AudioTrack audioTrack) {
            super(str);
            this.f3465a = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f3465a.flush();
                this.f3465a.release();
            } finally {
                m0.this.f3446h.open();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AudioTrack f3467a;

        b(m0 m0Var, AudioTrack audioTrack) {
            this.f3467a = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f3467a.release();
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        com.google.android.exoplayer2.h1 a(com.google.android.exoplayer2.h1 h1Var);

        long b();

        boolean c(boolean z5);

        long d(long j6);

        com.google.android.exoplayer2.audio.h[] e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final com.google.android.exoplayer2.s0 f3468a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3469b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3470c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3471d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3472e;

        /* renamed from: f  reason: collision with root package name */
        public final int f3473f;

        /* renamed from: g  reason: collision with root package name */
        public final int f3474g;

        /* renamed from: h  reason: collision with root package name */
        public final int f3475h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f3476i;

        /* renamed from: j  reason: collision with root package name */
        public final com.google.android.exoplayer2.audio.h[] f3477j;

        public d(com.google.android.exoplayer2.s0 s0Var, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z5, boolean z6, com.google.android.exoplayer2.audio.h[] hVarArr) {
            this.f3468a = s0Var;
            this.f3469b = i6;
            this.f3470c = i7;
            this.f3471d = i8;
            this.f3472e = i9;
            this.f3473f = i10;
            this.f3474g = i11;
            this.f3476i = z6;
            this.f3477j = hVarArr;
            this.f3475h = c(i12, z5);
        }

        private int c(int i6, boolean z5) {
            long j6;
            if (i6 != 0) {
                return i6;
            }
            int i7 = this.f3470c;
            if (i7 == 0) {
                return m(z5 ? 8.0f : 1.0f);
            }
            if (i7 == 1) {
                j6 = 50000000;
            } else if (i7 != 2) {
                throw new IllegalStateException();
            } else {
                j6 = 250000;
            }
            return l(j6);
        }

        private AudioTrack d(boolean z5, com.google.android.exoplayer2.audio.e eVar, int i6) {
            int i7 = com.google.android.exoplayer2.util.s0.f4673a;
            return i7 >= 29 ? f(z5, eVar, i6) : i7 >= 21 ? e(z5, eVar, i6) : g(eVar, i6);
        }

        private AudioTrack e(boolean z5, com.google.android.exoplayer2.audio.e eVar, int i6) {
            return new AudioTrack(j(eVar, z5), m0.M(this.f3472e, this.f3473f, this.f3474g), this.f3475h, 1, i6);
        }

        private AudioTrack f(boolean z5, com.google.android.exoplayer2.audio.e eVar, int i6) {
            AudioTrack.Builder audioAttributes;
            AudioTrack.Builder audioFormat;
            AudioTrack.Builder transferMode;
            AudioTrack.Builder bufferSizeInBytes;
            AudioTrack.Builder sessionId;
            AudioTrack.Builder offloadedPlayback;
            AudioTrack build;
            AudioFormat M = m0.M(this.f3472e, this.f3473f, this.f3474g);
            AudioAttributes j6 = j(eVar, z5);
            v0.a();
            audioAttributes = u0.a().setAudioAttributes(j6);
            audioFormat = audioAttributes.setAudioFormat(M);
            transferMode = audioFormat.setTransferMode(1);
            bufferSizeInBytes = transferMode.setBufferSizeInBytes(this.f3475h);
            sessionId = bufferSizeInBytes.setSessionId(i6);
            offloadedPlayback = sessionId.setOffloadedPlayback(this.f3470c == 1);
            build = offloadedPlayback.build();
            return build;
        }

        private AudioTrack g(com.google.android.exoplayer2.audio.e eVar, int i6) {
            int c02 = com.google.android.exoplayer2.util.s0.c0(eVar.f3354c);
            int i7 = this.f3472e;
            int i8 = this.f3473f;
            int i9 = this.f3474g;
            int i10 = this.f3475h;
            return i6 == 0 ? new AudioTrack(c02, i7, i8, i9, i10, 1) : new AudioTrack(c02, i7, i8, i9, i10, 1, i6);
        }

        private static AudioAttributes j(com.google.android.exoplayer2.audio.e eVar, boolean z5) {
            return z5 ? k() : eVar.a();
        }

        private static AudioAttributes k() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        private int l(long j6) {
            int R = m0.R(this.f3474g);
            if (this.f3474g == 5) {
                R *= 2;
            }
            return (int) ((j6 * R) / 1000000);
        }

        private int m(float f6) {
            int minBufferSize = AudioTrack.getMinBufferSize(this.f3472e, this.f3473f, this.f3474g);
            com.google.android.exoplayer2.util.a.g(minBufferSize != -2);
            int r5 = com.google.android.exoplayer2.util.s0.r(minBufferSize * 4, ((int) h(250000L)) * this.f3471d, Math.max(minBufferSize, ((int) h(750000L)) * this.f3471d));
            return f6 != 1.0f ? Math.round(r5 * f6) : r5;
        }

        public AudioTrack a(boolean z5, com.google.android.exoplayer2.audio.e eVar, int i6) {
            try {
                AudioTrack d6 = d(z5, eVar, i6);
                int state = d6.getState();
                if (state == 1) {
                    return d6;
                }
                try {
                    d6.release();
                } catch (Exception unused) {
                }
                throw new r.b(state, this.f3472e, this.f3473f, this.f3475h);
            } catch (UnsupportedOperationException unused2) {
                throw new r.b(0, this.f3472e, this.f3473f, this.f3475h);
            }
        }

        public boolean b(d dVar) {
            return dVar.f3470c == this.f3470c && dVar.f3474g == this.f3474g && dVar.f3472e == this.f3472e && dVar.f3473f == this.f3473f && dVar.f3471d == this.f3471d;
        }

        public long h(long j6) {
            return (j6 * this.f3472e) / 1000000;
        }

        public long i(long j6) {
            return (j6 * 1000000) / this.f3472e;
        }

        public long n(long j6) {
            return (j6 * 1000000) / this.f3468a.B;
        }

        public boolean o() {
            return this.f3470c == 1;
        }
    }

    /* loaded from: classes.dex */
    public static class e implements c {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.android.exoplayer2.audio.h[] f3478a;

        /* renamed from: b  reason: collision with root package name */
        private final f1 f3479b;

        /* renamed from: c  reason: collision with root package name */
        private final h1 f3480c;

        public e(com.google.android.exoplayer2.audio.h... hVarArr) {
            this(hVarArr, new f1(), new h1());
        }

        @Override // com.google.android.exoplayer2.audio.m0.c
        public com.google.android.exoplayer2.h1 a(com.google.android.exoplayer2.h1 h1Var) {
            return new com.google.android.exoplayer2.h1(this.f3480c.j(h1Var.f3778a), this.f3480c.i(h1Var.f3779b));
        }

        @Override // com.google.android.exoplayer2.audio.m0.c
        public long b() {
            return this.f3479b.q();
        }

        @Override // com.google.android.exoplayer2.audio.m0.c
        public boolean c(boolean z5) {
            this.f3479b.w(z5);
            return z5;
        }

        @Override // com.google.android.exoplayer2.audio.m0.c
        public long d(long j6) {
            return this.f3480c.h(j6);
        }

        @Override // com.google.android.exoplayer2.audio.m0.c
        public com.google.android.exoplayer2.audio.h[] e() {
            return this.f3478a;
        }

        public e(com.google.android.exoplayer2.audio.h[] hVarArr, f1 f1Var, h1 h1Var) {
            com.google.android.exoplayer2.audio.h[] hVarArr2 = new com.google.android.exoplayer2.audio.h[hVarArr.length + 2];
            this.f3478a = hVarArr2;
            System.arraycopy(hVarArr, 0, hVarArr2, 0, hVarArr.length);
            this.f3479b = f1Var;
            this.f3480c = h1Var;
            hVarArr2[hVarArr.length] = f1Var;
            hVarArr2[hVarArr.length + 1] = h1Var;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends RuntimeException {
        private f(String str) {
            super(str);
        }

        /* synthetic */ f(String str, a aVar) {
            this(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final com.google.android.exoplayer2.h1 f3481a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3482b;

        /* renamed from: c  reason: collision with root package name */
        public final long f3483c;

        /* renamed from: d  reason: collision with root package name */
        public final long f3484d;

        private g(com.google.android.exoplayer2.h1 h1Var, boolean z5, long j6, long j7) {
            this.f3481a = h1Var;
            this.f3482b = z5;
            this.f3483c = j6;
            this.f3484d = j7;
        }

        /* synthetic */ g(com.google.android.exoplayer2.h1 h1Var, boolean z5, long j6, long j7, a aVar) {
            this(h1Var, z5, j6, j7);
        }
    }

    /* loaded from: classes.dex */
    private final class h implements t.a {
        private h() {
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void a(int i6, long j6) {
            if (m0.this.f3452n != null) {
                m0.this.f3452n.g(i6, j6, SystemClock.elapsedRealtime() - m0.this.V);
            }
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void b(long j6, long j7, long j8, long j9) {
            long U = m0.this.U();
            long V = m0.this.V();
            StringBuilder sb = new StringBuilder(182);
            sb.append("Spurious audio timestamp (frame position mismatch): ");
            sb.append(j6);
            sb.append(", ");
            sb.append(j7);
            sb.append(", ");
            sb.append(j8);
            sb.append(", ");
            sb.append(j9);
            sb.append(", ");
            sb.append(U);
            sb.append(", ");
            sb.append(V);
            String sb2 = sb.toString();
            if (m0.Z) {
                throw new f(sb2, null);
            }
            com.google.android.exoplayer2.util.n.h("AudioTrack", sb2);
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void c(long j6) {
            if (m0.this.f3452n != null) {
                m0.this.f3452n.c(j6);
            }
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void d(long j6, long j7, long j8, long j9) {
            long U = m0.this.U();
            long V = m0.this.V();
            StringBuilder sb = new StringBuilder(180);
            sb.append("Spurious audio timestamp (system clock mismatch): ");
            sb.append(j6);
            sb.append(", ");
            sb.append(j7);
            sb.append(", ");
            sb.append(j8);
            sb.append(", ");
            sb.append(j9);
            sb.append(", ");
            sb.append(U);
            sb.append(", ");
            sb.append(V);
            String sb2 = sb.toString();
            if (m0.Z) {
                throw new f(sb2, null);
            }
            com.google.android.exoplayer2.util.n.h("AudioTrack", sb2);
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void e(long j6) {
            StringBuilder sb = new StringBuilder(61);
            sb.append("Ignoring impossibly large audio latency: ");
            sb.append(j6);
            com.google.android.exoplayer2.util.n.h("AudioTrack", sb.toString());
        }

        /* synthetic */ h(m0 m0Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class i {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f3486a = new Handler();

        /* renamed from: b  reason: collision with root package name */
        private final AudioTrack.StreamEventCallback f3487b;

        /* loaded from: classes.dex */
        class a extends AudioTrack.StreamEventCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ m0 f3489a;

            a(m0 m0Var) {
                this.f3489a = m0Var;
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i6) {
                com.google.android.exoplayer2.util.a.g(audioTrack == m0.this.f3456r);
                if (m0.this.f3452n != null) {
                    m0.this.f3452n.f();
                }
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(AudioTrack audioTrack) {
                if (m0.this.f3452n == null || !m0.this.R) {
                    return;
                }
                m0.this.f3452n.f();
            }
        }

        public i() {
            this.f3487b = new a(m0.this);
        }

        public void a(AudioTrack audioTrack) {
            final Handler handler = this.f3486a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new Executor() { // from class: com.google.android.exoplayer2.audio.y0
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    handler.post(runnable);
                }
            }, this.f3487b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f3487b);
            this.f3486a.removeCallbacksAndMessages(null);
        }
    }

    public m0(com.google.android.exoplayer2.audio.f fVar, c cVar, boolean z5, boolean z6, boolean z7) {
        this.f3439a = fVar;
        this.f3440b = (c) com.google.android.exoplayer2.util.a.e(cVar);
        int i6 = com.google.android.exoplayer2.util.s0.f4673a;
        this.f3441c = i6 >= 21 && z5;
        this.f3449k = i6 >= 23 && z6;
        this.f3450l = i6 >= 29 && z7;
        this.f3446h = new ConditionVariable(true);
        this.f3447i = new t(new h(this, null));
        w wVar = new w();
        this.f3442d = wVar;
        i1 i1Var = new i1();
        this.f3443e = i1Var;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new e1(), wVar, i1Var);
        Collections.addAll(arrayList, cVar.e());
        this.f3444f = (com.google.android.exoplayer2.audio.h[]) arrayList.toArray(new com.google.android.exoplayer2.audio.h[0]);
        this.f3445g = new com.google.android.exoplayer2.audio.h[]{new a1()};
        this.G = 1.0f;
        this.f3457s = com.google.android.exoplayer2.audio.e.f3351f;
        this.S = 0;
        this.T = new u(0, 0.0f);
        com.google.android.exoplayer2.h1 h1Var = com.google.android.exoplayer2.h1.f3777d;
        this.f3459u = new g(h1Var, false, 0L, 0L, null);
        this.f3460v = h1Var;
        this.O = -1;
        this.H = new com.google.android.exoplayer2.audio.h[0];
        this.I = new ByteBuffer[0];
        this.f3448j = new ArrayDeque();
    }

    private void G(long j6) {
        com.google.android.exoplayer2.h1 a6 = this.f3455q.f3476i ? this.f3440b.a(N()) : com.google.android.exoplayer2.h1.f3777d;
        boolean c6 = this.f3455q.f3476i ? this.f3440b.c(T()) : false;
        this.f3448j.add(new g(a6, c6, Math.max(0L, j6), this.f3455q.i(V()), null));
        p0();
        r.c cVar = this.f3452n;
        if (cVar != null) {
            cVar.a(c6);
        }
    }

    private long H(long j6) {
        while (!this.f3448j.isEmpty() && j6 >= ((g) this.f3448j.getFirst()).f3484d) {
            this.f3459u = (g) this.f3448j.remove();
        }
        g gVar = this.f3459u;
        long j7 = j6 - gVar.f3484d;
        if (!gVar.f3481a.equals(com.google.android.exoplayer2.h1.f3777d)) {
            j7 = this.f3448j.isEmpty() ? this.f3440b.d(j7) : com.google.android.exoplayer2.util.s0.U(j7, this.f3459u.f3481a.f3778a);
        }
        return this.f3459u.f3483c + j7;
    }

    private long I(long j6) {
        return j6 + this.f3455q.i(this.f3440b.b());
    }

    private AudioTrack J() {
        try {
            return ((d) com.google.android.exoplayer2.util.a.e(this.f3455q)).a(this.U, this.f3457s, this.S);
        } catch (r.b e6) {
            e0();
            throw e6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean K() {
        boolean z5;
        int i6;
        com.google.android.exoplayer2.audio.h[] hVarArr;
        if (this.O == -1) {
            this.O = 0;
            z5 = true;
            i6 = this.O;
            hVarArr = this.H;
            if (i6 < hVarArr.length) {
                com.google.android.exoplayer2.audio.h hVar = hVarArr[i6];
                if (z5) {
                    hVar.b();
                }
                g0(-9223372036854775807L);
                if (!hVar.d()) {
                    return false;
                }
                this.O++;
                z5 = true;
                i6 = this.O;
                hVarArr = this.H;
                if (i6 < hVarArr.length) {
                    ByteBuffer byteBuffer = this.L;
                    if (byteBuffer != null) {
                        q0(byteBuffer, -9223372036854775807L);
                        if (this.L != null) {
                            return false;
                        }
                    }
                    this.O = -1;
                    return true;
                }
            }
        } else {
            z5 = false;
            i6 = this.O;
            hVarArr = this.H;
            if (i6 < hVarArr.length) {
            }
        }
    }

    private void L() {
        int i6 = 0;
        while (true) {
            com.google.android.exoplayer2.audio.h[] hVarArr = this.H;
            if (i6 >= hVarArr.length) {
                return;
            }
            com.google.android.exoplayer2.audio.h hVar = hVarArr[i6];
            hVar.flush();
            this.I[i6] = hVar.a();
            i6++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AudioFormat M(int i6, int i7, int i8) {
        return new AudioFormat.Builder().setSampleRate(i6).setChannelMask(i7).setEncoding(i8).build();
    }

    private com.google.android.exoplayer2.h1 N() {
        return S().f3481a;
    }

    private static int O(int i6) {
        int i7 = com.google.android.exoplayer2.util.s0.f4673a;
        if (i7 <= 28) {
            if (i6 == 7) {
                i6 = 8;
            } else if (i6 == 3 || i6 == 4 || i6 == 5) {
                i6 = 6;
            }
        }
        if (i7 <= 26 && "fugu".equals(com.google.android.exoplayer2.util.s0.f4674b) && i6 == 1) {
            i6 = 2;
        }
        return com.google.android.exoplayer2.util.s0.G(i6);
    }

    private static Pair P(com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.audio.f fVar) {
        int O;
        int i6;
        if (fVar == null) {
            return null;
        }
        int d6 = com.google.android.exoplayer2.util.q.d((String) com.google.android.exoplayer2.util.a.e(s0Var.f4056n), s0Var.f4053k);
        if (d6 == 5 || d6 == 6 || d6 == 18 || d6 == 17 || d6 == 7 || d6 == 8 || d6 == 14) {
            int i7 = d6 == 18 ? 6 : s0Var.A;
            if (i7 <= fVar.d() && (O = O(i7)) != 0) {
                if (fVar.e(d6)) {
                    i6 = Integer.valueOf(d6);
                } else if (d6 != 18 || !fVar.e(6)) {
                    return null;
                } else {
                    i6 = 6;
                }
                return Pair.create(i6, Integer.valueOf(O));
            }
            return null;
        }
        return null;
    }

    private static int Q(int i6, ByteBuffer byteBuffer) {
        switch (i6) {
            case 5:
            case 6:
            case 18:
                return com.google.android.exoplayer2.audio.b.d(byteBuffer);
            case 7:
            case 8:
                return z0.e(byteBuffer);
            case 9:
                int m5 = c1.m(com.google.android.exoplayer2.util.s0.H(byteBuffer, byteBuffer.position()));
                if (m5 != -1) {
                    return m5;
                }
                throw new IllegalArgumentException();
            case 10:
                return Segment.SHARE_MINIMUM;
            case 11:
            case 12:
                return 2048;
            case 13:
            default:
                StringBuilder sb = new StringBuilder(38);
                sb.append("Unexpected audio encoding: ");
                sb.append(i6);
                throw new IllegalStateException(sb.toString());
            case 14:
                int a6 = com.google.android.exoplayer2.audio.b.a(byteBuffer);
                if (a6 == -1) {
                    return 0;
                }
                return com.google.android.exoplayer2.audio.b.h(byteBuffer, a6) * 16;
            case 15:
                return 512;
            case 16:
                return Segment.SHARE_MINIMUM;
            case 17:
                return com.google.android.exoplayer2.audio.c.c(byteBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int R(int i6) {
        switch (i6) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
        }
    }

    private g S() {
        g gVar = this.f3458t;
        return gVar != null ? gVar : !this.f3448j.isEmpty() ? (g) this.f3448j.getLast() : this.f3459u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long U() {
        d dVar = this.f3455q;
        return dVar.f3470c == 0 ? this.f3463y / dVar.f3469b : this.f3464z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long V() {
        d dVar = this.f3455q;
        return dVar.f3470c == 0 ? this.A / dVar.f3471d : this.B;
    }

    private void W() {
        this.f3446h.block();
        AudioTrack J = J();
        this.f3456r = J;
        if (b0(J)) {
            h0(this.f3456r);
            AudioTrack audioTrack = this.f3456r;
            com.google.android.exoplayer2.s0 s0Var = this.f3455q.f3468a;
            audioTrack.setOffloadDelayPadding(s0Var.D, s0Var.E);
        }
        int audioSessionId = this.f3456r.getAudioSessionId();
        if (Y && com.google.android.exoplayer2.util.s0.f4673a < 21) {
            AudioTrack audioTrack2 = this.f3453o;
            if (audioTrack2 != null && audioSessionId != audioTrack2.getAudioSessionId()) {
                i0();
            }
            if (this.f3453o == null) {
                this.f3453o = X(audioSessionId);
            }
        }
        if (this.S != audioSessionId) {
            this.S = audioSessionId;
            r.c cVar = this.f3452n;
            if (cVar != null) {
                cVar.b(audioSessionId);
            }
        }
        t tVar = this.f3447i;
        AudioTrack audioTrack3 = this.f3456r;
        d dVar = this.f3455q;
        tVar.t(audioTrack3, dVar.f3470c == 2, dVar.f3474g, dVar.f3471d, dVar.f3475h);
        m0();
        int i6 = this.T.f3538a;
        if (i6 != 0) {
            this.f3456r.attachAuxEffect(i6);
            this.f3456r.setAuxEffectSendLevel(this.T.f3539b);
        }
        this.E = true;
    }

    private static AudioTrack X(int i6) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i6);
    }

    private static boolean Y(int i6) {
        return com.google.android.exoplayer2.util.s0.f4673a >= 24 && i6 == -6;
    }

    private boolean Z() {
        return this.f3456r != null;
    }

    private static boolean a0() {
        return com.google.android.exoplayer2.util.s0.f4673a >= 30 && com.google.android.exoplayer2.util.s0.f4676d.startsWith("Pixel");
    }

    private static boolean b0(AudioTrack audioTrack) {
        boolean isOffloadedPlayback;
        if (com.google.android.exoplayer2.util.s0.f4673a >= 29) {
            isOffloadedPlayback = audioTrack.isOffloadedPlayback();
            if (isOffloadedPlayback) {
                return true;
            }
        }
        return false;
    }

    private static boolean c0(com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.audio.e eVar) {
        int d6;
        int G;
        boolean isOffloadedPlaybackSupported;
        if (com.google.android.exoplayer2.util.s0.f4673a < 29 || (d6 = com.google.android.exoplayer2.util.q.d((String) com.google.android.exoplayer2.util.a.e(s0Var.f4056n), s0Var.f4053k)) == 0 || (G = com.google.android.exoplayer2.util.s0.G(s0Var.A)) == 0) {
            return false;
        }
        isOffloadedPlaybackSupported = AudioManager.isOffloadedPlaybackSupported(M(s0Var.B, G, d6), eVar.a());
        if (isOffloadedPlaybackSupported) {
            return (s0Var.D == 0 && s0Var.E == 0) || a0();
        }
        return false;
    }

    private static boolean d0(com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.audio.f fVar) {
        return P(s0Var, fVar) != null;
    }

    private void e0() {
        if (this.f3455q.o()) {
            this.W = true;
        }
    }

    private void f0() {
        if (this.Q) {
            return;
        }
        this.Q = true;
        this.f3447i.h(V());
        this.f3456r.stop();
        this.f3462x = 0;
    }

    private void g0(long j6) {
        ByteBuffer byteBuffer;
        int length = this.H.length;
        int i6 = length;
        while (i6 >= 0) {
            if (i6 > 0) {
                byteBuffer = this.I[i6 - 1];
            } else {
                byteBuffer = this.J;
                if (byteBuffer == null) {
                    byteBuffer = com.google.android.exoplayer2.audio.h.f3399a;
                }
            }
            if (i6 == length) {
                q0(byteBuffer, j6);
            } else {
                com.google.android.exoplayer2.audio.h hVar = this.H[i6];
                hVar.f(byteBuffer);
                ByteBuffer a6 = hVar.a();
                this.I[i6] = a6;
                if (a6.hasRemaining()) {
                    i6++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            }
            i6--;
        }
    }

    private void h0(AudioTrack audioTrack) {
        if (this.f3451m == null) {
            this.f3451m = new i();
        }
        this.f3451m.a(audioTrack);
    }

    private void i0() {
        AudioTrack audioTrack = this.f3453o;
        if (audioTrack == null) {
            return;
        }
        this.f3453o = null;
        new b(this, audioTrack).start();
    }

    private void j0() {
        this.f3463y = 0L;
        this.f3464z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.X = false;
        this.C = 0;
        this.f3459u = new g(N(), T(), 0L, 0L, null);
        this.F = 0L;
        this.f3458t = null;
        this.f3448j.clear();
        this.J = null;
        this.K = 0;
        this.L = null;
        this.Q = false;
        this.P = false;
        this.O = -1;
        this.f3461w = null;
        this.f3462x = 0;
        this.f3443e.o();
        L();
    }

    private void k0(com.google.android.exoplayer2.h1 h1Var, boolean z5) {
        g S = S();
        if (h1Var.equals(S.f3481a) && z5 == S.f3482b) {
            return;
        }
        g gVar = new g(h1Var, z5, -9223372036854775807L, -9223372036854775807L, null);
        if (Z()) {
            this.f3458t = gVar;
        } else {
            this.f3459u = gVar;
        }
    }

    private void l0(com.google.android.exoplayer2.h1 h1Var) {
        PlaybackParams allowDefaults;
        PlaybackParams speed;
        PlaybackParams pitch;
        PlaybackParams audioFallbackMode;
        PlaybackParams playbackParams;
        float speed2;
        PlaybackParams playbackParams2;
        float pitch2;
        if (Z()) {
            c0.a();
            allowDefaults = b0.a().allowDefaults();
            speed = allowDefaults.setSpeed(h1Var.f3778a);
            pitch = speed.setPitch(h1Var.f3779b);
            audioFallbackMode = pitch.setAudioFallbackMode(2);
            try {
                this.f3456r.setPlaybackParams(audioFallbackMode);
            } catch (IllegalArgumentException e6) {
                com.google.android.exoplayer2.util.n.i("AudioTrack", "Failed to set playback params", e6);
            }
            playbackParams = this.f3456r.getPlaybackParams();
            speed2 = playbackParams.getSpeed();
            playbackParams2 = this.f3456r.getPlaybackParams();
            pitch2 = playbackParams2.getPitch();
            h1Var = new com.google.android.exoplayer2.h1(speed2, pitch2);
            this.f3447i.u(h1Var.f3778a);
        }
        this.f3460v = h1Var;
    }

    private void m0() {
        if (Z()) {
            if (com.google.android.exoplayer2.util.s0.f4673a >= 21) {
                n0(this.f3456r, this.G);
            } else {
                o0(this.f3456r, this.G);
            }
        }
    }

    private static void n0(AudioTrack audioTrack, float f6) {
        audioTrack.setVolume(f6);
    }

    private static void o0(AudioTrack audioTrack, float f6) {
        audioTrack.setStereoVolume(f6, f6);
    }

    private void p0() {
        com.google.android.exoplayer2.audio.h[] hVarArr = this.f3455q.f3477j;
        ArrayList arrayList = new ArrayList();
        for (com.google.android.exoplayer2.audio.h hVar : hVarArr) {
            if (hVar.e()) {
                arrayList.add(hVar);
            } else {
                hVar.flush();
            }
        }
        int size = arrayList.size();
        this.H = (com.google.android.exoplayer2.audio.h[]) arrayList.toArray(new com.google.android.exoplayer2.audio.h[size]);
        this.I = new ByteBuffer[size];
        L();
    }

    private void q0(ByteBuffer byteBuffer, long j6) {
        int r02;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.L;
            if (byteBuffer2 != null) {
                com.google.android.exoplayer2.util.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.L = byteBuffer;
                if (com.google.android.exoplayer2.util.s0.f4673a < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.M;
                    if (bArr == null || bArr.length < remaining) {
                        this.M = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.M, 0, remaining);
                    byteBuffer.position(position);
                    this.N = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (com.google.android.exoplayer2.util.s0.f4673a < 21) {
                int c6 = this.f3447i.c(this.A);
                if (c6 > 0) {
                    r02 = this.f3456r.write(this.M, this.N, Math.min(remaining2, c6));
                    if (r02 > 0) {
                        this.N += r02;
                        byteBuffer.position(byteBuffer.position() + r02);
                    }
                } else {
                    r02 = 0;
                }
            } else if (this.U) {
                com.google.android.exoplayer2.util.a.g(j6 != -9223372036854775807L);
                r02 = s0(this.f3456r, byteBuffer, remaining2, j6);
            } else {
                r02 = r0(this.f3456r, byteBuffer, remaining2);
            }
            this.V = SystemClock.elapsedRealtime();
            if (r02 < 0) {
                if (Y(r02)) {
                    e0();
                }
                throw new r.d(r02);
            }
            if (b0(this.f3456r)) {
                long j7 = this.B;
                if (j7 > 0) {
                    this.X = false;
                }
                if (this.R && this.f3452n != null && r02 < remaining2 && !this.X) {
                    this.f3452n.d(this.f3447i.e(j7));
                }
            }
            int i6 = this.f3455q.f3470c;
            if (i6 == 0) {
                this.A += r02;
            }
            if (r02 == remaining2) {
                if (i6 != 0) {
                    com.google.android.exoplayer2.util.a.g(byteBuffer == this.J);
                    this.B += this.C * this.K;
                }
                this.L = null;
            }
        }
    }

    private static int r0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i6) {
        return audioTrack.write(byteBuffer, i6, 1);
    }

    private int s0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i6, long j6) {
        int write;
        if (com.google.android.exoplayer2.util.s0.f4673a >= 26) {
            write = audioTrack.write(byteBuffer, i6, 1, j6 * 1000);
            return write;
        }
        if (this.f3461w == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.f3461w = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.f3461w.putInt(1431633921);
        }
        if (this.f3462x == 0) {
            this.f3461w.putInt(4, i6);
            this.f3461w.putLong(8, j6 * 1000);
            this.f3461w.position(0);
            this.f3462x = i6;
        }
        int remaining = this.f3461w.remaining();
        if (remaining > 0) {
            int write2 = audioTrack.write(this.f3461w, remaining, 1);
            if (write2 < 0) {
                this.f3462x = 0;
                return write2;
            } else if (write2 < remaining) {
                return 0;
            }
        }
        int r02 = r0(audioTrack, byteBuffer, i6);
        if (r02 < 0) {
            this.f3462x = 0;
            return r02;
        }
        this.f3462x -= r02;
        return r02;
    }

    public boolean T() {
        return S().f3482b;
    }

    @Override // com.google.android.exoplayer2.audio.r
    public boolean a(com.google.android.exoplayer2.s0 s0Var) {
        return s(s0Var) != 0;
    }

    @Override // com.google.android.exoplayer2.audio.r
    public com.google.android.exoplayer2.h1 b() {
        return this.f3449k ? this.f3460v : N();
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void c() {
        flush();
        i0();
        for (com.google.android.exoplayer2.audio.h hVar : this.f3444f) {
            hVar.c();
        }
        for (com.google.android.exoplayer2.audio.h hVar2 : this.f3445g) {
            hVar2.c();
        }
        this.S = 0;
        this.R = false;
        this.W = false;
    }

    @Override // com.google.android.exoplayer2.audio.r
    public boolean d() {
        return !Z() || (this.P && !j());
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void flush() {
        if (Z()) {
            j0();
            if (this.f3447i.j()) {
                this.f3456r.pause();
            }
            if (b0(this.f3456r)) {
                ((i) com.google.android.exoplayer2.util.a.e(this.f3451m)).b(this.f3456r);
            }
            AudioTrack audioTrack = this.f3456r;
            this.f3456r = null;
            d dVar = this.f3454p;
            if (dVar != null) {
                this.f3455q = dVar;
                this.f3454p = null;
            }
            this.f3447i.r();
            this.f3446h.close();
            new a("ExoPlayer:AudioTrackReleaseThread", audioTrack).start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void h(com.google.android.exoplayer2.h1 h1Var) {
        com.google.android.exoplayer2.h1 h1Var2 = new com.google.android.exoplayer2.h1(com.google.android.exoplayer2.util.s0.q(h1Var.f3778a, 0.1f, 8.0f), com.google.android.exoplayer2.util.s0.q(h1Var.f3779b, 0.1f, 8.0f));
        if (!this.f3449k || com.google.android.exoplayer2.util.s0.f4673a < 23) {
            k0(h1Var2, T());
        } else {
            l0(h1Var2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void i() {
        if (!this.P && Z() && K()) {
            f0();
            this.P = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.r
    public boolean j() {
        return Z() && this.f3447i.i(V());
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void k(int i6) {
        if (this.S != i6) {
            this.S = i6;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void l() {
        this.R = true;
        if (Z()) {
            this.f3447i.v();
            this.f3456r.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.r
    public boolean m(ByteBuffer byteBuffer, long j6, int i6) {
        ByteBuffer byteBuffer2 = this.J;
        com.google.android.exoplayer2.util.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f3454p != null) {
            if (!K()) {
                return false;
            }
            if (this.f3454p.b(this.f3455q)) {
                this.f3455q = this.f3454p;
                this.f3454p = null;
                if (b0(this.f3456r)) {
                    this.f3456r.setOffloadEndOfStream();
                    AudioTrack audioTrack = this.f3456r;
                    com.google.android.exoplayer2.s0 s0Var = this.f3455q.f3468a;
                    audioTrack.setOffloadDelayPadding(s0Var.D, s0Var.E);
                    this.X = true;
                }
            } else {
                f0();
                if (j()) {
                    return false;
                }
                flush();
            }
            G(j6);
        }
        if (!Z()) {
            W();
        }
        if (this.E) {
            this.F = Math.max(0L, j6);
            this.D = false;
            this.E = false;
            if (this.f3449k && com.google.android.exoplayer2.util.s0.f4673a >= 23) {
                l0(this.f3460v);
            }
            G(j6);
            if (this.R) {
                l();
            }
        }
        if (this.f3447i.l(V())) {
            if (this.J == null) {
                com.google.android.exoplayer2.util.a.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
                if (!byteBuffer.hasRemaining()) {
                    return true;
                }
                d dVar = this.f3455q;
                if (dVar.f3470c != 0 && this.C == 0) {
                    int Q = Q(dVar.f3474g, byteBuffer);
                    this.C = Q;
                    if (Q == 0) {
                        return true;
                    }
                }
                if (this.f3458t != null) {
                    if (!K()) {
                        return false;
                    }
                    G(j6);
                    this.f3458t = null;
                }
                long n5 = this.F + this.f3455q.n(U() - this.f3443e.n());
                if (!this.D && Math.abs(n5 - j6) > 200000) {
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Discontinuity detected [expected ");
                    sb.append(n5);
                    sb.append(", got ");
                    sb.append(j6);
                    sb.append("]");
                    com.google.android.exoplayer2.util.n.c("AudioTrack", sb.toString());
                    this.D = true;
                }
                if (this.D) {
                    if (!K()) {
                        return false;
                    }
                    long j7 = j6 - n5;
                    this.F += j7;
                    this.D = false;
                    G(j6);
                    r.c cVar = this.f3452n;
                    if (cVar != null && j7 != 0) {
                        cVar.e();
                    }
                }
                if (this.f3455q.f3470c == 0) {
                    this.f3463y += byteBuffer.remaining();
                } else {
                    this.f3464z += this.C * i6;
                }
                this.J = byteBuffer;
                this.K = i6;
            }
            g0(j6);
            if (!this.J.hasRemaining()) {
                this.J = null;
                this.K = 0;
                return true;
            } else if (this.f3447i.k(V())) {
                com.google.android.exoplayer2.util.n.h("AudioTrack", "Resetting stalled audio track");
                flush();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void n() {
        this.R = false;
        if (Z() && this.f3447i.q()) {
            this.f3456r.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.r
    public long o(boolean z5) {
        if (!Z() || this.E) {
            return Long.MIN_VALUE;
        }
        return I(H(Math.min(this.f3447i.d(z5), this.f3455q.i(V()))));
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void p() {
        if (this.U) {
            this.U = false;
            this.S = 0;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void q(r.c cVar) {
        this.f3452n = cVar;
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void r(com.google.android.exoplayer2.audio.e eVar) {
        if (this.f3457s.equals(eVar)) {
            return;
        }
        this.f3457s = eVar;
        if (this.U) {
            return;
        }
        flush();
        this.S = 0;
    }

    @Override // com.google.android.exoplayer2.audio.r
    public int s(com.google.android.exoplayer2.s0 s0Var) {
        if (!"audio/raw".equals(s0Var.f4056n)) {
            return ((this.f3450l && !this.W && c0(s0Var, this.f3457s)) || d0(s0Var, this.f3439a)) ? 2 : 0;
        }
        boolean n02 = com.google.android.exoplayer2.util.s0.n0(s0Var.C);
        int i6 = s0Var.C;
        if (n02) {
            return (i6 == 2 || (this.f3441c && i6 == 4)) ? 2 : 1;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Invalid PCM encoding: ");
        sb.append(i6);
        com.google.android.exoplayer2.util.n.h("AudioTrack", sb.toString());
        return 0;
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void t(com.google.android.exoplayer2.s0 s0Var, int i6, int[] iArr) {
        int i7;
        com.google.android.exoplayer2.audio.h[] hVarArr;
        int intValue;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z5;
        int[] iArr2;
        if ("audio/raw".equals(s0Var.f4056n)) {
            com.google.android.exoplayer2.util.a.a(com.google.android.exoplayer2.util.s0.n0(s0Var.C));
            int a02 = com.google.android.exoplayer2.util.s0.a0(s0Var.C, s0Var.A);
            boolean z6 = this.f3441c && com.google.android.exoplayer2.util.s0.m0(s0Var.C);
            com.google.android.exoplayer2.audio.h[] hVarArr2 = z6 ? this.f3445g : this.f3444f;
            boolean z7 = true ^ z6;
            this.f3443e.p(s0Var.D, s0Var.E);
            if (com.google.android.exoplayer2.util.s0.f4673a < 21 && s0Var.A == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i12 = 0; i12 < 6; i12++) {
                    iArr2[i12] = i12;
                }
            } else {
                iArr2 = iArr;
            }
            this.f3442d.n(iArr2);
            h.a aVar = new h.a(s0Var.B, s0Var.A, s0Var.C);
            for (com.google.android.exoplayer2.audio.h hVar : hVarArr2) {
                try {
                    h.a g6 = hVar.g(aVar);
                    if (hVar.e()) {
                        aVar = g6;
                    }
                } catch (h.b e6) {
                    throw new r.a(e6);
                }
            }
            int i13 = aVar.f3403c;
            i8 = aVar.f3401a;
            intValue = com.google.android.exoplayer2.util.s0.G(aVar.f3402b);
            int a03 = com.google.android.exoplayer2.util.s0.a0(i13, aVar.f3402b);
            z5 = z7;
            hVarArr = hVarArr2;
            i9 = i13;
            i7 = a02;
            i11 = a03;
            i10 = 0;
        } else {
            com.google.android.exoplayer2.audio.h[] hVarArr3 = new com.google.android.exoplayer2.audio.h[0];
            int i14 = s0Var.B;
            i7 = -1;
            if (this.f3450l && c0(s0Var, this.f3457s)) {
                hVarArr = hVarArr3;
                i9 = com.google.android.exoplayer2.util.q.d((String) com.google.android.exoplayer2.util.a.e(s0Var.f4056n), s0Var.f4053k);
                intValue = com.google.android.exoplayer2.util.s0.G(s0Var.A);
                i11 = -1;
                z5 = false;
                i8 = i14;
                i10 = 1;
            } else {
                Pair P = P(s0Var, this.f3439a);
                if (P == null) {
                    String valueOf = String.valueOf(s0Var);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 37);
                    sb.append("Unable to configure passthrough for: ");
                    sb.append(valueOf);
                    throw new r.a(sb.toString());
                }
                int intValue2 = ((Integer) P.first).intValue();
                hVarArr = hVarArr3;
                intValue = ((Integer) P.second).intValue();
                i8 = i14;
                i9 = intValue2;
                i10 = 2;
                i11 = -1;
                z5 = false;
            }
        }
        if (i9 == 0) {
            String valueOf2 = String.valueOf(s0Var);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 48);
            sb2.append("Invalid output encoding (mode=");
            sb2.append(i10);
            sb2.append(") for: ");
            sb2.append(valueOf2);
            throw new r.a(sb2.toString());
        } else if (intValue == 0) {
            String valueOf3 = String.valueOf(s0Var);
            StringBuilder sb3 = new StringBuilder(valueOf3.length() + 54);
            sb3.append("Invalid output channel config (mode=");
            sb3.append(i10);
            sb3.append(") for: ");
            sb3.append(valueOf3);
            throw new r.a(sb3.toString());
        } else {
            this.W = false;
            d dVar = new d(s0Var, i7, i10, i11, i8, intValue, i9, i6, this.f3449k, z5, hVarArr);
            if (Z()) {
                this.f3454p = dVar;
            } else {
                this.f3455q = dVar;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void u() {
        if (com.google.android.exoplayer2.util.s0.f4673a < 25) {
            flush();
        } else if (Z()) {
            j0();
            if (this.f3447i.j()) {
                this.f3456r.pause();
            }
            this.f3456r.flush();
            this.f3447i.r();
            t tVar = this.f3447i;
            AudioTrack audioTrack = this.f3456r;
            d dVar = this.f3455q;
            tVar.t(audioTrack, dVar.f3470c == 2, dVar.f3474g, dVar.f3471d, dVar.f3475h);
            this.E = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void v(boolean z5) {
        k0(N(), z5);
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void w(u uVar) {
        if (this.T.equals(uVar)) {
            return;
        }
        int i6 = uVar.f3538a;
        float f6 = uVar.f3539b;
        AudioTrack audioTrack = this.f3456r;
        if (audioTrack != null) {
            if (this.T.f3538a != i6) {
                audioTrack.attachAuxEffect(i6);
            }
            if (i6 != 0) {
                this.f3456r.setAuxEffectSendLevel(f6);
            }
        }
        this.T = uVar;
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void x() {
        this.D = true;
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void y(float f6) {
        if (this.G != f6) {
            this.G = f6;
            m0();
        }
    }

    @Override // com.google.android.exoplayer2.audio.r
    public void z(int i6) {
        com.google.android.exoplayer2.util.a.g(com.google.android.exoplayer2.util.s0.f4673a >= 21);
        if (this.U && this.S == i6) {
            return;
        }
        this.U = true;
        this.S = i6;
        flush();
    }
}
