package j2;

import com.google.android.exoplayer2.util.s0;
import e2.f;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
final class d implements f {

    /* renamed from: a  reason: collision with root package name */
    private final List f11238a;

    /* renamed from: b  reason: collision with root package name */
    private final List f11239b;

    public d(List list, List list2) {
        this.f11238a = list;
        this.f11239b = list2;
    }

    @Override // e2.f
    public int a(long j6) {
        int d6 = s0.d(this.f11239b, Long.valueOf(j6), false, false);
        if (d6 < this.f11239b.size()) {
            return d6;
        }
        return -1;
    }

    @Override // e2.f
    public long b(int i6) {
        com.google.android.exoplayer2.util.a.a(i6 >= 0);
        com.google.android.exoplayer2.util.a.a(i6 < this.f11239b.size());
        return ((Long) this.f11239b.get(i6)).longValue();
    }

    @Override // e2.f
    public List c(long j6) {
        int g6 = s0.g(this.f11239b, Long.valueOf(j6), true, false);
        return g6 == -1 ? Collections.emptyList() : (List) this.f11238a.get(g6);
    }

    @Override // e2.f
    public int d() {
        return this.f11239b.size();
    }
}
