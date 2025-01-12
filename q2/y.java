package q2;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;
import q2.l;
/* loaded from: classes.dex */
public final class y implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final y f12893a = new y();

    /* renamed from: b  reason: collision with root package name */
    public static final l.a f12894b = new l.a() { // from class: q2.x
        @Override // q2.l.a
        public final l a() {
            return y.q();
        }
    };

    private y() {
    }

    public static /* synthetic */ y q() {
        return new y();
    }

    @Override // q2.l
    public long b(o oVar) {
        throw new IOException("DummyDataSource cannot be opened");
    }

    @Override // q2.l
    public void close() {
    }

    @Override // q2.l
    public /* synthetic */ Map f() {
        return k.a(this);
    }

    @Override // q2.l
    public void i(i0 i0Var) {
    }

    @Override // q2.l
    public Uri k() {
        return null;
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        throw new UnsupportedOperationException();
    }
}
