package w1;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.w0;
import java.util.List;
import q2.l;
import w1.o0;
import w1.w0;
/* loaded from: classes.dex */
public final class k implements g0 {

    /* renamed from: a  reason: collision with root package name */
    private final w f13865a;

    /* renamed from: b  reason: collision with root package name */
    private final l.a f13866b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray f13867c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f13868d;

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.exoplayer2.drm.v f13869e;

    /* renamed from: f  reason: collision with root package name */
    private List f13870f;

    /* renamed from: g  reason: collision with root package name */
    private q2.c0 f13871g;

    public k(Context context, c1.o oVar) {
        this(new q2.t(context), oVar);
    }

    private static SparseArray e(l.a aVar, c1.o oVar) {
        SparseArray sparseArray = new SparseArray();
        try {
            sparseArray.put(0, (g0) DashMediaSource.Factory.class.asSubclass(g0.class).getConstructor(l.a.class).newInstance(aVar));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (g0) SsMediaSource.Factory.class.asSubclass(g0.class).getConstructor(l.a.class).newInstance(aVar));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (g0) HlsMediaSource.Factory.class.asSubclass(g0.class).getConstructor(l.a.class).newInstance(aVar));
        } catch (Exception unused3) {
        }
        sparseArray.put(3, new o0.b(aVar, oVar));
        return sparseArray;
    }

    private static v f(com.google.android.exoplayer2.w0 w0Var, v vVar) {
        w0.c cVar = w0Var.f4704d;
        long j6 = cVar.f4727a;
        if (j6 == 0 && cVar.f4728b == Long.MIN_VALUE && !cVar.f4730d) {
            return vVar;
        }
        long a6 = com.google.android.exoplayer2.p.a(j6);
        long a7 = com.google.android.exoplayer2.p.a(w0Var.f4704d.f4728b);
        w0.c cVar2 = w0Var.f4704d;
        return new e(vVar, a6, a7, !cVar2.f4731e, cVar2.f4729c, cVar2.f4730d);
    }

    private v g(com.google.android.exoplayer2.w0 w0Var, v vVar) {
        com.google.android.exoplayer2.util.a.e(w0Var.f4702b);
        if (w0Var.f4702b.f4746g == null) {
            return vVar;
        }
        com.google.android.exoplayer2.util.n.h("DefaultMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
        return vVar;
    }

    @Override // w1.g0
    public v c(com.google.android.exoplayer2.w0 w0Var) {
        com.google.android.exoplayer2.util.a.e(w0Var.f4702b);
        w0.e eVar = w0Var.f4702b;
        int k02 = com.google.android.exoplayer2.util.s0.k0(eVar.f4740a, eVar.f4741b);
        g0 g0Var = (g0) this.f13867c.get(k02);
        StringBuilder sb = new StringBuilder(68);
        sb.append("No suitable media source factory found for content type: ");
        sb.append(k02);
        com.google.android.exoplayer2.util.a.f(g0Var, sb.toString());
        com.google.android.exoplayer2.drm.v vVar = this.f13869e;
        if (vVar == null) {
            vVar = this.f13865a.a(w0Var);
        }
        g0Var.b(vVar);
        g0Var.a(!w0Var.f4702b.f4743d.isEmpty() ? w0Var.f4702b.f4743d : this.f13870f);
        g0Var.d(this.f13871g);
        v c6 = g0Var.c(w0Var);
        List list = w0Var.f4702b.f4745f;
        if (!list.isEmpty()) {
            v[] vVarArr = new v[list.size() + 1];
            int i6 = 0;
            vVarArr[0] = c6;
            w0.b bVar = new w0.b(this.f13866b);
            while (i6 < list.size()) {
                int i7 = i6 + 1;
                android.support.v4.media.a.a(list.get(i6));
                vVarArr[i7] = bVar.a(null, -9223372036854775807L);
                i6 = i7;
            }
            c6 = new i0(vVarArr);
        }
        return g(w0Var, f(w0Var, c6));
    }

    @Override // w1.g0
    /* renamed from: h */
    public k b(com.google.android.exoplayer2.drm.v vVar) {
        this.f13869e = vVar;
        return this;
    }

    @Override // w1.g0
    /* renamed from: i */
    public k d(q2.c0 c0Var) {
        this.f13871g = c0Var;
        return this;
    }

    @Override // w1.g0
    /* renamed from: j */
    public k a(List list) {
        this.f13870f = (list == null || list.isEmpty()) ? null : null;
        return this;
    }

    public k(l.a aVar, c1.o oVar) {
        this.f13866b = aVar;
        this.f13865a = new w();
        SparseArray e6 = e(aVar, oVar);
        this.f13867c = e6;
        this.f13868d = new int[e6.size()];
        for (int i6 = 0; i6 < this.f13867c.size(); i6++) {
            this.f13868d[i6] = this.f13867c.keyAt(i6);
        }
    }
}
