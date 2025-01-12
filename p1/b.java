package p1;

import com.google.android.exoplayer2.util.y;
import java.nio.ByteBuffer;
import java.util.Arrays;
import n1.e;
import n1.h;
/* loaded from: classes.dex */
public final class b extends h {
    @Override // n1.h
    protected n1.a b(e eVar, ByteBuffer byteBuffer) {
        return new n1.a(c(new y(byteBuffer.array(), byteBuffer.limit())));
    }

    public a c(y yVar) {
        return new a((String) com.google.android.exoplayer2.util.a.e(yVar.u()), (String) com.google.android.exoplayer2.util.a.e(yVar.u()), yVar.C(), yVar.C(), Arrays.copyOfRange(yVar.c(), yVar.d(), yVar.e()));
    }
}
