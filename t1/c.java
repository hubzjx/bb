package t1;

import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.x;
import com.google.android.exoplayer2.util.y;
import java.nio.ByteBuffer;
import n1.a;
import n1.h;
/* loaded from: classes.dex */
public final class c extends h {

    /* renamed from: a  reason: collision with root package name */
    private final y f13345a = new y();

    /* renamed from: b  reason: collision with root package name */
    private final x f13346b = new x();

    /* renamed from: c  reason: collision with root package name */
    private k0 f13347c;

    @Override // n1.h
    protected n1.a b(n1.e eVar, ByteBuffer byteBuffer) {
        k0 k0Var = this.f13347c;
        if (k0Var == null || eVar.f12185h != k0Var.e()) {
            k0 k0Var2 = new k0(eVar.f3602d);
            this.f13347c = k0Var2;
            k0Var2.a(eVar.f3602d - eVar.f12185h);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f13345a.K(array, limit);
        this.f13346b.o(array, limit);
        this.f13346b.r(39);
        long h6 = (this.f13346b.h(1) << 32) | this.f13346b.h(32);
        this.f13346b.r(20);
        int h7 = this.f13346b.h(12);
        int h8 = this.f13346b.h(8);
        this.f13345a.N(14);
        a.b e6 = h8 != 0 ? h8 != 255 ? h8 != 4 ? h8 != 5 ? h8 != 6 ? null : g.e(this.f13345a, h6, this.f13347c) : d.e(this.f13345a, h6, this.f13347c) : f.e(this.f13345a) : a.e(this.f13345a, h7, h6) : new e();
        return e6 == null ? new n1.a(new a.b[0]) : new n1.a(e6);
    }
}
