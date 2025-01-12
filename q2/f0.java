package q2;

import android.net.Uri;
import com.google.android.exoplayer2.util.s0;
import java.io.InputStream;
import java.util.Map;
import q2.d0;
import q2.o;
/* loaded from: classes.dex */
public final class f0 implements d0.e {

    /* renamed from: a  reason: collision with root package name */
    public final long f12754a;

    /* renamed from: b  reason: collision with root package name */
    public final o f12755b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12756c;

    /* renamed from: d  reason: collision with root package name */
    private final g0 f12757d;

    /* renamed from: e  reason: collision with root package name */
    private final a f12758e;

    /* renamed from: f  reason: collision with root package name */
    private volatile Object f12759f;

    /* loaded from: classes.dex */
    public interface a {
        Object a(Uri uri, InputStream inputStream);
    }

    public f0(l lVar, Uri uri, int i6, a aVar) {
        this(lVar, new o.b().i(uri).b(1).a(), i6, aVar);
    }

    @Override // q2.d0.e
    public final void a() {
        this.f12757d.t();
        n nVar = new n(this.f12757d, this.f12755b);
        try {
            nVar.b();
            this.f12759f = this.f12758e.a((Uri) com.google.android.exoplayer2.util.a.e(this.f12757d.k()), nVar);
        } finally {
            s0.n(nVar);
        }
    }

    public long b() {
        return this.f12757d.q();
    }

    @Override // q2.d0.e
    public final void c() {
    }

    public Map d() {
        return this.f12757d.s();
    }

    public final Object e() {
        return this.f12759f;
    }

    public Uri f() {
        return this.f12757d.r();
    }

    public f0(l lVar, o oVar, int i6, a aVar) {
        this.f12757d = new g0(lVar);
        this.f12755b = oVar;
        this.f12756c = i6;
        this.f12758e = aVar;
        this.f12754a = w1.p.a();
    }
}
