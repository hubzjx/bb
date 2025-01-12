package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.h;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
final class e1 extends v {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b0 A[LOOP:4: B:30:0x00b0->B:31:0x00b2, LOOP_START, PHI: r0 
      PHI: (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:15:0x0037, B:31:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.audio.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(ByteBuffer byteBuffer) {
        int i6;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i7 = limit - position;
        int i8 = this.f3540b.f3403c;
        if (i8 != 3) {
            if (i8 != 4) {
                if (i8 != 268435456) {
                    if (i8 == 536870912) {
                        i7 /= 3;
                    } else if (i8 != 805306368) {
                        throw new IllegalStateException();
                    }
                }
                ByteBuffer m5 = m(i7);
                i6 = this.f3540b.f3403c;
                if (i6 == 3) {
                    while (position < limit) {
                        m5.put((byte) 0);
                        m5.put((byte) ((byteBuffer.get(position) & 255) - 128));
                        position++;
                    }
                } else if (i6 == 4) {
                    while (position < limit) {
                        short q5 = (short) (com.google.android.exoplayer2.util.s0.q(byteBuffer.getFloat(position), -1.0f, 1.0f) * 32767.0f);
                        m5.put((byte) (q5 & 255));
                        m5.put((byte) ((q5 >> 8) & 255));
                        position += 4;
                    }
                } else if (i6 == 268435456) {
                    while (position < limit) {
                        m5.put(byteBuffer.get(position + 1));
                        m5.put(byteBuffer.get(position));
                        position += 2;
                    }
                } else if (i6 == 536870912) {
                    while (position < limit) {
                        m5.put(byteBuffer.get(position + 1));
                        m5.put(byteBuffer.get(position + 2));
                        position += 3;
                    }
                } else if (i6 != 805306368) {
                    throw new IllegalStateException();
                } else {
                    while (position < limit) {
                        m5.put(byteBuffer.get(position + 2));
                        m5.put(byteBuffer.get(position + 3));
                        position += 4;
                    }
                }
                byteBuffer.position(byteBuffer.limit());
                m5.flip();
            }
            i7 /= 2;
            ByteBuffer m52 = m(i7);
            i6 = this.f3540b.f3403c;
            if (i6 == 3) {
            }
            byteBuffer.position(byteBuffer.limit());
            m52.flip();
        }
        i7 *= 2;
        ByteBuffer m522 = m(i7);
        i6 = this.f3540b.f3403c;
        if (i6 == 3) {
        }
        byteBuffer.position(byteBuffer.limit());
        m522.flip();
    }

    @Override // com.google.android.exoplayer2.audio.v
    public h.a i(h.a aVar) {
        int i6 = aVar.f3403c;
        if (i6 == 3 || i6 == 2 || i6 == 268435456 || i6 == 536870912 || i6 == 805306368 || i6 == 4) {
            return i6 != 2 ? new h.a(aVar.f3401a, aVar.f3402b, 2) : h.a.f3400e;
        }
        throw new h.b(aVar);
    }
}
