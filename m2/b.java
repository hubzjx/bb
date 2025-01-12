package m2;

import e2.f;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
final class b implements f {

    /* renamed from: b  reason: collision with root package name */
    public static final b f12006b = new b();

    /* renamed from: a  reason: collision with root package name */
    private final List f12007a;

    private b() {
        this.f12007a = Collections.emptyList();
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
        return j6 >= 0 ? this.f12007a : Collections.emptyList();
    }

    @Override // e2.f
    public int d() {
        return 1;
    }

    public b(e2.b bVar) {
        this.f12007a = Collections.singletonList(bVar);
    }
}
