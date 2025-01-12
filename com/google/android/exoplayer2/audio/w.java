package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.h;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
final class w extends v {

    /* renamed from: i  reason: collision with root package name */
    private int[] f3547i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f3548j;

    @Override // com.google.android.exoplayer2.audio.h
    public void f(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) com.google.android.exoplayer2.util.a.e(this.f3548j);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer m5 = m(((limit - position) / this.f3540b.f3404d) * this.f3541c.f3404d);
        while (position < limit) {
            for (int i6 : iArr) {
                m5.putShort(byteBuffer.getShort((i6 * 2) + position));
            }
            position += this.f3540b.f3404d;
        }
        byteBuffer.position(limit);
        m5.flip();
    }

    @Override // com.google.android.exoplayer2.audio.v
    public h.a i(h.a aVar) {
        int[] iArr = this.f3547i;
        if (iArr == null) {
            return h.a.f3400e;
        }
        if (aVar.f3403c == 2) {
            boolean z5 = aVar.f3402b != iArr.length;
            int i6 = 0;
            while (i6 < iArr.length) {
                int i7 = iArr[i6];
                if (i7 >= aVar.f3402b) {
                    throw new h.b(aVar);
                }
                z5 |= i7 != i6;
                i6++;
            }
            return z5 ? new h.a(aVar.f3401a, iArr.length, 2) : h.a.f3400e;
        }
        throw new h.b(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void j() {
        this.f3548j = this.f3547i;
    }

    @Override // com.google.android.exoplayer2.audio.v
    protected void l() {
        this.f3548j = null;
        this.f3547i = null;
    }

    public void n(int[] iArr) {
        this.f3547i = iArr;
    }
}
