package c1;

import c1.a0;
import com.google.android.exoplayer2.s0;
import java.io.EOFException;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public final class h implements a0 {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f3218a = new byte[_BufferKt.SEGMENTING_THRESHOLD];

    @Override // c1.a0
    public /* synthetic */ void a(com.google.android.exoplayer2.util.y yVar, int i6) {
        z.b(this, yVar, i6);
    }

    @Override // c1.a0
    public /* synthetic */ int b(q2.h hVar, int i6, boolean z5) {
        return z.a(this, hVar, i6, z5);
    }

    @Override // c1.a0
    public int c(q2.h hVar, int i6, boolean z5, int i7) {
        int read = hVar.read(this.f3218a, 0, Math.min(this.f3218a.length, i6));
        if (read == -1) {
            if (z5) {
                return -1;
            }
            throw new EOFException();
        }
        return read;
    }

    @Override // c1.a0
    public void d(long j6, int i6, int i7, int i8, a0.a aVar) {
    }

    @Override // c1.a0
    public void e(s0 s0Var) {
    }

    @Override // c1.a0
    public void f(com.google.android.exoplayer2.util.y yVar, int i6, int i7) {
        yVar.N(i6);
    }
}
