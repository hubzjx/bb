package y1;

import android.net.Uri;
import com.google.android.exoplayer2.s0;
import java.util.Map;
import q2.d0;
import q2.g0;
import w1.p;
/* loaded from: classes.dex */
public abstract class e implements d0.e {

    /* renamed from: a  reason: collision with root package name */
    public final long f14280a = p.a();

    /* renamed from: b  reason: collision with root package name */
    public final q2.o f14281b;

    /* renamed from: c  reason: collision with root package name */
    public final int f14282c;

    /* renamed from: d  reason: collision with root package name */
    public final s0 f14283d;

    /* renamed from: e  reason: collision with root package name */
    public final int f14284e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f14285f;

    /* renamed from: g  reason: collision with root package name */
    public final long f14286g;

    /* renamed from: h  reason: collision with root package name */
    public final long f14287h;

    /* renamed from: i  reason: collision with root package name */
    protected final g0 f14288i;

    public e(q2.l lVar, q2.o oVar, int i6, s0 s0Var, int i7, Object obj, long j6, long j7) {
        this.f14288i = new g0(lVar);
        this.f14281b = (q2.o) com.google.android.exoplayer2.util.a.e(oVar);
        this.f14282c = i6;
        this.f14283d = s0Var;
        this.f14284e = i7;
        this.f14285f = obj;
        this.f14286g = j6;
        this.f14287h = j7;
    }

    public final long b() {
        return this.f14288i.q();
    }

    public final long d() {
        return this.f14287h - this.f14286g;
    }

    public final Map e() {
        return this.f14288i.s();
    }

    public final Uri f() {
        return this.f14288i.r();
    }
}
