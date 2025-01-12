package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.h;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
final class a1 extends v {

    /* renamed from: i  reason: collision with root package name */
    private static final int f3317i = Float.floatToIntBits(Float.NaN);

    private static void n(int i6, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i6 * 4.656612875245797E-10d));
        if (floatToIntBits == f3317i) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // com.google.android.exoplayer2.audio.h
    public void f(ByteBuffer byteBuffer) {
        ByteBuffer m5;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i6 = limit - position;
        int i7 = this.f3540b.f3403c;
        if (i7 == 536870912) {
            m5 = m((i6 / 3) * 4);
            while (position < limit) {
                n(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), m5);
                position += 3;
            }
        } else if (i7 != 805306368) {
            throw new IllegalStateException();
        } else {
            m5 = m(i6);
            while (position < limit) {
                n((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), m5);
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        m5.flip();
    }

    @Override // com.google.android.exoplayer2.audio.v
    public h.a i(h.a aVar) {
        int i6 = aVar.f3403c;
        if (com.google.android.exoplayer2.util.s0.m0(i6)) {
            return i6 != 4 ? new h.a(aVar.f3401a, aVar.f3402b, 4) : h.a.f3400e;
        }
        throw new h.b(aVar);
    }
}
