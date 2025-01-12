package n2;

import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
final class c implements e2.f {

    /* renamed from: a  reason: collision with root package name */
    private final List f12201a;

    public c(List list) {
        this.f12201a = Collections.unmodifiableList(list);
    }

    @Override // e2.f
    public int a(long j6) {
        return j6 < 0 ? 0 : -1;
    }

    @Override // e2.f
    public long b(int i6) {
        com.google.android.exoplayer2.util.a.a(i6 == 0);
        return 0L;
    }

    @Override // e2.f
    public List c(long j6) {
        return j6 >= 0 ? this.f12201a : Collections.emptyList();
    }

    @Override // e2.f
    public int d() {
        return 1;
    }
}
