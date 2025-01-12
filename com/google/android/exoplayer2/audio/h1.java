package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import okhttp3.internal.ws.RealWebSocket;
/* loaded from: classes.dex */
public final class h1 implements h {

    /* renamed from: b  reason: collision with root package name */
    private int f3405b;

    /* renamed from: c  reason: collision with root package name */
    private float f3406c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f3407d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private h.a f3408e;

    /* renamed from: f  reason: collision with root package name */
    private h.a f3409f;

    /* renamed from: g  reason: collision with root package name */
    private h.a f3410g;

    /* renamed from: h  reason: collision with root package name */
    private h.a f3411h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3412i;

    /* renamed from: j  reason: collision with root package name */
    private g1 f3413j;

    /* renamed from: k  reason: collision with root package name */
    private ByteBuffer f3414k;

    /* renamed from: l  reason: collision with root package name */
    private ShortBuffer f3415l;

    /* renamed from: m  reason: collision with root package name */
    private ByteBuffer f3416m;

    /* renamed from: n  reason: collision with root package name */
    private long f3417n;

    /* renamed from: o  reason: collision with root package name */
    private long f3418o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f3419p;

    public h1() {
        h.a aVar = h.a.f3400e;
        this.f3408e = aVar;
        this.f3409f = aVar;
        this.f3410g = aVar;
        this.f3411h = aVar;
        ByteBuffer byteBuffer = h.f3399a;
        this.f3414k = byteBuffer;
        this.f3415l = byteBuffer.asShortBuffer();
        this.f3416m = byteBuffer;
        this.f3405b = -1;
    }

    @Override // com.google.android.exoplayer2.audio.h
    public ByteBuffer a() {
        ByteBuffer byteBuffer = this.f3416m;
        this.f3416m = h.f3399a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.h
    public void b() {
        g1 g1Var = this.f3413j;
        if (g1Var != null) {
            g1Var.r();
        }
        this.f3419p = true;
    }

    @Override // com.google.android.exoplayer2.audio.h
    public void c() {
        this.f3406c = 1.0f;
        this.f3407d = 1.0f;
        h.a aVar = h.a.f3400e;
        this.f3408e = aVar;
        this.f3409f = aVar;
        this.f3410g = aVar;
        this.f3411h = aVar;
        ByteBuffer byteBuffer = h.f3399a;
        this.f3414k = byteBuffer;
        this.f3415l = byteBuffer.asShortBuffer();
        this.f3416m = byteBuffer;
        this.f3405b = -1;
        this.f3412i = false;
        this.f3413j = null;
        this.f3417n = 0L;
        this.f3418o = 0L;
        this.f3419p = false;
    }

    @Override // com.google.android.exoplayer2.audio.h
    public boolean d() {
        g1 g1Var;
        return this.f3419p && ((g1Var = this.f3413j) == null || g1Var.k() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.h
    public boolean e() {
        return this.f3409f.f3401a != -1 && (Math.abs(this.f3406c - 1.0f) >= 0.01f || Math.abs(this.f3407d - 1.0f) >= 0.01f || this.f3409f.f3401a != this.f3408e.f3401a);
    }

    @Override // com.google.android.exoplayer2.audio.h
    public void f(ByteBuffer byteBuffer) {
        g1 g1Var = (g1) com.google.android.exoplayer2.util.a.e(this.f3413j);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f3417n += remaining;
            g1Var.s(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int k6 = g1Var.k();
        if (k6 > 0) {
            if (this.f3414k.capacity() < k6) {
                ByteBuffer order = ByteBuffer.allocateDirect(k6).order(ByteOrder.nativeOrder());
                this.f3414k = order;
                this.f3415l = order.asShortBuffer();
            } else {
                this.f3414k.clear();
                this.f3415l.clear();
            }
            g1Var.j(this.f3415l);
            this.f3418o += k6;
            this.f3414k.limit(k6);
            this.f3416m = this.f3414k;
        }
    }

    @Override // com.google.android.exoplayer2.audio.h
    public void flush() {
        if (e()) {
            h.a aVar = this.f3408e;
            this.f3410g = aVar;
            h.a aVar2 = this.f3409f;
            this.f3411h = aVar2;
            if (this.f3412i) {
                this.f3413j = new g1(aVar.f3401a, aVar.f3402b, this.f3406c, this.f3407d, aVar2.f3401a);
            } else {
                g1 g1Var = this.f3413j;
                if (g1Var != null) {
                    g1Var.i();
                }
            }
        }
        this.f3416m = h.f3399a;
        this.f3417n = 0L;
        this.f3418o = 0L;
        this.f3419p = false;
    }

    @Override // com.google.android.exoplayer2.audio.h
    public h.a g(h.a aVar) {
        if (aVar.f3403c == 2) {
            int i6 = this.f3405b;
            if (i6 == -1) {
                i6 = aVar.f3401a;
            }
            this.f3408e = aVar;
            h.a aVar2 = new h.a(i6, aVar.f3402b, 2);
            this.f3409f = aVar2;
            this.f3412i = true;
            return aVar2;
        }
        throw new h.b(aVar);
    }

    public long h(long j6) {
        long j7 = this.f3418o;
        if (j7 >= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            int i6 = this.f3411h.f3401a;
            int i7 = this.f3410g.f3401a;
            long j8 = this.f3417n;
            return i6 == i7 ? com.google.android.exoplayer2.util.s0.F0(j6, j8, j7) : com.google.android.exoplayer2.util.s0.F0(j6, j8 * i6, j7 * i7);
        }
        return (long) (this.f3406c * j6);
    }

    public float i(float f6) {
        if (this.f3407d != f6) {
            this.f3407d = f6;
            this.f3412i = true;
        }
        return f6;
    }

    public float j(float f6) {
        if (this.f3406c != f6) {
            this.f3406c = f6;
            this.f3412i = true;
        }
        return f6;
    }
}
