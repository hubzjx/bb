package n1;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public abstract class h implements c {
    @Override // n1.c
    public final a a(e eVar) {
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(eVar.f3600b);
        com.google.android.exoplayer2.util.a.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (eVar.isDecodeOnly()) {
            return null;
        }
        return b(eVar, byteBuffer);
    }

    protected abstract a b(e eVar, ByteBuffer byteBuffer);
}
