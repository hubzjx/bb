package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.h;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class f1 extends v {

    /* renamed from: i  reason: collision with root package name */
    private final long f3365i;

    /* renamed from: j  reason: collision with root package name */
    private final long f3366j;

    /* renamed from: k  reason: collision with root package name */
    private final short f3367k;

    /* renamed from: l  reason: collision with root package name */
    private int f3368l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f3369m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f3370n;

    /* renamed from: o  reason: collision with root package name */
    private byte[] f3371o;

    /* renamed from: p  reason: collision with root package name */
    private int f3372p;

    /* renamed from: q  reason: collision with root package name */
    private int f3373q;

    /* renamed from: r  reason: collision with root package name */
    private int f3374r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f3375s;

    /* renamed from: t  reason: collision with root package name */
    private long f3376t;

    public f1() {
        this(150000L, 20000L, (short) 1024);
    }

    private int n(long j6) {
        return (int) ((j6 * this.f3540b.f3401a) / 1000000);
    }

    private int o(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        while (true) {
            limit -= 2;
            if (limit < byteBuffer.position()) {
                return byteBuffer.position();
            }
            if (Math.abs((int) byteBuffer.getShort(limit)) > this.f3367k) {
                int i6 = this.f3368l;
                return ((limit / i6) * i6) + i6;
            }
        }
    }

    private int p(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs((int) byteBuffer.getShort(position)) > this.f3367k) {
                int i6 = this.f3368l;
                return i6 * (position / i6);
            }
        }
        return byteBuffer.limit();
    }

    private void r(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        m(remaining).put(byteBuffer).flip();
        if (remaining > 0) {
            this.f3375s = true;
        }
    }

    private void s(byte[] bArr, int i6) {
        m(i6).put(bArr, 0, i6).flip();
        if (i6 > 0) {
            this.f3375s = true;
        }
    }

    private void t(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int p5 = p(byteBuffer);
        int position = p5 - byteBuffer.position();
        byte[] bArr = this.f3370n;
        int length = bArr.length;
        int i6 = this.f3373q;
        int i7 = length - i6;
        if (p5 < limit && position < i7) {
            s(bArr, i6);
            this.f3373q = 0;
            this.f3372p = 0;
            return;
        }
        int min = Math.min(position, i7);
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer.get(this.f3370n, this.f3373q, min);
        int i8 = this.f3373q + min;
        this.f3373q = i8;
        byte[] bArr2 = this.f3370n;
        if (i8 == bArr2.length) {
            if (this.f3375s) {
                s(bArr2, this.f3374r);
                this.f3376t += (this.f3373q - (this.f3374r * 2)) / this.f3368l;
            } else {
                this.f3376t += (i8 - this.f3374r) / this.f3368l;
            }
            x(byteBuffer, this.f3370n, this.f3373q);
            this.f3373q = 0;
            this.f3372p = 2;
        }
        byteBuffer.limit(limit);
    }

    private void u(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f3370n.length));
        int o5 = o(byteBuffer);
        if (o5 == byteBuffer.position()) {
            this.f3372p = 1;
        } else {
            byteBuffer.limit(o5);
            r(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private void v(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int p5 = p(byteBuffer);
        byteBuffer.limit(p5);
        this.f3376t += byteBuffer.remaining() / this.f3368l;
        x(byteBuffer, this.f3371o, this.f3374r);
        if (p5 < limit) {
            s(this.f3371o, this.f3374r);
            this.f3372p = 0;
            byteBuffer.limit(limit);
        }
    }

    private void x(ByteBuffer byteBuffer, byte[] bArr, int i6) {
        int min = Math.min(byteBuffer.remaining(), this.f3374r);
        int i7 = this.f3374r - min;
        System.arraycopy(bArr, i6 - i7, this.f3371o, 0, i7);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.f3371o, i7, min);
    }

    @Override // com.google.android.exoplayer2.audio.v, com.google.android.exoplayer2.audio.h
    public boolean e() {
        return this.f3369m;
    }

    @Override // com.google.android.exoplayer2.audio.h
    public void f(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !h()) {
            int i6 = this.f3372p;
            if (i6 == 0) {
                u(byteBuffer);
            } else if (i6 == 1) {
                t(byteBuffer);
            } else if (i6 != 2) {
                throw new IllegalStateException();
            } else {
                v(byteBuffer);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.v
    public h.a i(h.a aVar) {
        if (aVar.f3403c == 2) {
            return this.f3369m ? aVar : h.a.f3400e;
        }
        throw new h.b(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void j() {
        if (this.f3369m) {
            this.f3368l = this.f3540b.f3404d;
            int n5 = n(this.f3365i) * this.f3368l;
            if (this.f3370n.length != n5) {
                this.f3370n = new byte[n5];
            }
            int n6 = n(this.f3366j) * this.f3368l;
            this.f3374r = n6;
            if (this.f3371o.length != n6) {
                this.f3371o = new byte[n6];
            }
        }
        this.f3372p = 0;
        this.f3376t = 0L;
        this.f3373q = 0;
        this.f3375s = false;
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void k() {
        int i6 = this.f3373q;
        if (i6 > 0) {
            s(this.f3370n, i6);
        }
        if (this.f3375s) {
            return;
        }
        this.f3376t += this.f3374r / this.f3368l;
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void l() {
        this.f3369m = false;
        this.f3374r = 0;
        byte[] bArr = com.google.android.exoplayer2.util.s0.f4678f;
        this.f3370n = bArr;
        this.f3371o = bArr;
    }

    public long q() {
        return this.f3376t;
    }

    public void w(boolean z5) {
        this.f3369m = z5;
    }

    public f1(long j6, long j7, short s5) {
        com.google.android.exoplayer2.util.a.a(j7 <= j6);
        this.f3365i = j6;
        this.f3366j = j7;
        this.f3367k = s5;
        byte[] bArr = com.google.android.exoplayer2.util.s0.f4678f;
        this.f3370n = bArr;
        this.f3371o = bArr;
    }
}
