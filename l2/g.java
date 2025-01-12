package l2;

import com.google.android.exoplayer2.util.s0;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
final class g implements e2.f {

    /* renamed from: a  reason: collision with root package name */
    private final c f11835a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f11836b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f11837c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f11838d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f11839e;

    public g(c cVar, Map map, Map map2, Map map3) {
        this.f11835a = cVar;
        this.f11838d = map2;
        this.f11839e = map3;
        this.f11837c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f11836b = cVar.j();
    }

    @Override // e2.f
    public int a(long j6) {
        int e6 = s0.e(this.f11836b, j6, false, false);
        if (e6 < this.f11836b.length) {
            return e6;
        }
        return -1;
    }

    @Override // e2.f
    public long b(int i6) {
        return this.f11836b[i6];
    }

    @Override // e2.f
    public List c(long j6) {
        return this.f11835a.h(j6, this.f11837c, this.f11838d, this.f11839e);
    }

    @Override // e2.f
    public int d() {
        return this.f11836b.length;
    }
}
