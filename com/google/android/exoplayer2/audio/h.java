package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes.dex */
public interface h {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteBuffer f3399a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: e  reason: collision with root package name */
        public static final a f3400e = new a(-1, -1, -1);

        /* renamed from: a  reason: collision with root package name */
        public final int f3401a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3402b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3403c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3404d;

        public a(int i6, int i7, int i8) {
            this.f3401a = i6;
            this.f3402b = i7;
            this.f3403c = i8;
            this.f3404d = com.google.android.exoplayer2.util.s0.n0(i8) ? com.google.android.exoplayer2.util.s0.a0(i8, i7) : -1;
        }

        public String toString() {
            int i6 = this.f3401a;
            int i7 = this.f3402b;
            int i8 = this.f3403c;
            StringBuilder sb = new StringBuilder(83);
            sb.append("AudioFormat[sampleRate=");
            sb.append(i6);
            sb.append(", channelCount=");
            sb.append(i7);
            sb.append(", encoding=");
            sb.append(i8);
            sb.append(']');
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(a aVar) {
            super(r1.toString());
            String valueOf = String.valueOf(aVar);
            StringBuilder sb = new StringBuilder(valueOf.length() + 18);
            sb.append("Unhandled format: ");
            sb.append(valueOf);
        }
    }

    ByteBuffer a();

    void b();

    void c();

    boolean d();

    boolean e();

    void f(ByteBuffer byteBuffer);

    void flush();

    a g(a aVar);
}
