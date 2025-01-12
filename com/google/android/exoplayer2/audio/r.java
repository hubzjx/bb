package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public interface r {

    /* loaded from: classes.dex */
    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends Exception {
        public final int audioTrackState;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(int i6, int i7, int i8, int i9) {
            super(r0.toString());
            StringBuilder sb = new StringBuilder(82);
            sb.append("AudioTrack init failed: ");
            sb.append(i6);
            sb.append(", Config(");
            sb.append(i7);
            sb.append(", ");
            sb.append(i8);
            sb.append(", ");
            sb.append(i9);
            sb.append(")");
            this.audioTrackState = i6;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z5);

        void b(int i6);

        void c(long j6);

        void d(long j6);

        void e();

        void f();

        void g(int i6, long j6, long j7);
    }

    /* loaded from: classes.dex */
    public static final class d extends Exception {
        public final int errorCode;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d(int i6) {
            super(r0.toString());
            StringBuilder sb = new StringBuilder(36);
            sb.append("AudioTrack write failed: ");
            sb.append(i6);
            this.errorCode = i6;
        }
    }

    boolean a(com.google.android.exoplayer2.s0 s0Var);

    com.google.android.exoplayer2.h1 b();

    void c();

    boolean d();

    void flush();

    void h(com.google.android.exoplayer2.h1 h1Var);

    void i();

    boolean j();

    void k(int i6);

    void l();

    boolean m(ByteBuffer byteBuffer, long j6, int i6);

    void n();

    long o(boolean z5);

    void p();

    void q(c cVar);

    void r(e eVar);

    int s(com.google.android.exoplayer2.s0 s0Var);

    void t(com.google.android.exoplayer2.s0 s0Var, int i6, int[] iArr);

    void u();

    void v(boolean z5);

    void w(u uVar);

    void x();

    void y(float f6);

    void z(int i6);
}
