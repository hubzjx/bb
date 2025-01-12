package g2;

import com.google.android.exoplayer2.util.y;
import e2.d;
import e2.f;
import java.util.List;
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: o  reason: collision with root package name */
    private final b f10412o;

    public a(List list) {
        super("DvbDecoder");
        y yVar = new y((byte[]) list.get(0));
        this.f10412o = new b(yVar.G(), yVar.G());
    }

    @Override // e2.d
    protected f A(byte[] bArr, int i6, boolean z5) {
        if (z5) {
            this.f10412o.r();
        }
        return new c(this.f10412o.b(bArr, i6));
    }
}
