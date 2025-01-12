package com.google.android.exoplayer2.decoder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class j extends a {

    /* renamed from: a  reason: collision with root package name */
    public final b f3599a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f3600b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3601c;

    /* renamed from: d  reason: collision with root package name */
    public long f3602d;

    /* renamed from: e  reason: collision with root package name */
    public ByteBuffer f3603e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3604f;

    /* renamed from: g  reason: collision with root package name */
    private final int f3605g;

    public j(int i6) {
        this(i6, 0);
    }

    private ByteBuffer e(int i6) {
        int i7 = this.f3604f;
        if (i7 == 1) {
            return ByteBuffer.allocate(i6);
        }
        if (i7 == 2) {
            return ByteBuffer.allocateDirect(i6);
        }
        ByteBuffer byteBuffer = this.f3600b;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i6);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    public static j j() {
        return new j(0);
    }

    @Override // com.google.android.exoplayer2.decoder.a
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.f3600b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f3603e;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f3601c = false;
    }

    public void f(int i6) {
        int i7 = i6 + this.f3605g;
        ByteBuffer byteBuffer = this.f3600b;
        if (byteBuffer == null) {
            this.f3600b = e(i7);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i8 = i7 + position;
        if (capacity >= i8) {
            this.f3600b = byteBuffer;
            return;
        }
        ByteBuffer e6 = e(i8);
        e6.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            e6.put(byteBuffer);
        }
        this.f3600b = e6;
    }

    public final void g() {
        ByteBuffer byteBuffer = this.f3600b;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f3603e;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean h() {
        return getFlag(1073741824);
    }

    public final boolean i() {
        return this.f3600b == null && this.f3604f == 0;
    }

    public void k(int i6) {
        ByteBuffer byteBuffer = this.f3603e;
        if (byteBuffer == null || byteBuffer.capacity() < i6) {
            this.f3603e = ByteBuffer.allocate(i6);
        } else {
            this.f3603e.clear();
        }
    }

    public j(int i6, int i7) {
        this.f3599a = new b();
        this.f3604f = i6;
        this.f3605g = i7;
    }
}
