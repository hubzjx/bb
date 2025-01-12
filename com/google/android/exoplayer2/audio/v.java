package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes.dex */
public abstract class v implements h {

    /* renamed from: b  reason: collision with root package name */
    protected h.a f3540b;

    /* renamed from: c  reason: collision with root package name */
    protected h.a f3541c;

    /* renamed from: d  reason: collision with root package name */
    private h.a f3542d;

    /* renamed from: e  reason: collision with root package name */
    private h.a f3543e;

    /* renamed from: f  reason: collision with root package name */
    private ByteBuffer f3544f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f3545g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3546h;

    public v() {
        ByteBuffer byteBuffer = h.f3399a;
        this.f3544f = byteBuffer;
        this.f3545g = byteBuffer;
        h.a aVar = h.a.f3400e;
        this.f3542d = aVar;
        this.f3543e = aVar;
        this.f3540b = aVar;
        this.f3541c = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.h
    public ByteBuffer a() {
        ByteBuffer byteBuffer = this.f3545g;
        this.f3545g = h.f3399a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.h
    public final void b() {
        this.f3546h = true;
        k();
    }

    @Override // com.google.android.exoplayer2.audio.h
    public final void c() {
        flush();
        this.f3544f = h.f3399a;
        h.a aVar = h.a.f3400e;
        this.f3542d = aVar;
        this.f3543e = aVar;
        this.f3540b = aVar;
        this.f3541c = aVar;
        l();
    }

    @Override // com.google.android.exoplayer2.audio.h
    public boolean d() {
        return this.f3546h && this.f3545g == h.f3399a;
    }

    @Override // com.google.android.exoplayer2.audio.h
    public boolean e() {
        return this.f3543e != h.a.f3400e;
    }

    @Override // com.google.android.exoplayer2.audio.h
    public final void flush() {
        this.f3545g = h.f3399a;
        this.f3546h = false;
        this.f3540b = this.f3542d;
        this.f3541c = this.f3543e;
        j();
    }

    @Override // com.google.android.exoplayer2.audio.h
    public final h.a g(h.a aVar) {
        this.f3542d = aVar;
        this.f3543e = i(aVar);
        return e() ? this.f3543e : h.a.f3400e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean h() {
        return this.f3545g.hasRemaining();
    }

    protected abstract h.a i(h.a aVar);

    protected void j() {
    }

    protected void k() {
    }

    protected void l() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ByteBuffer m(int i6) {
        if (this.f3544f.capacity() < i6) {
            this.f3544f = ByteBuffer.allocateDirect(i6).order(ByteOrder.nativeOrder());
        } else {
            this.f3544f.clear();
        }
        ByteBuffer byteBuffer = this.f3544f;
        this.f3545g = byteBuffer;
        return byteBuffer;
    }
}
