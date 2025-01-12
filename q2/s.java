package q2;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.util.s0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class s implements l {

    /* renamed from: a  reason: collision with root package name */
    private final Context f12855a;

    /* renamed from: b  reason: collision with root package name */
    private final List f12856b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final l f12857c;

    /* renamed from: d  reason: collision with root package name */
    private l f12858d;

    /* renamed from: e  reason: collision with root package name */
    private l f12859e;

    /* renamed from: f  reason: collision with root package name */
    private l f12860f;

    /* renamed from: g  reason: collision with root package name */
    private l f12861g;

    /* renamed from: h  reason: collision with root package name */
    private l f12862h;

    /* renamed from: i  reason: collision with root package name */
    private l f12863i;

    /* renamed from: j  reason: collision with root package name */
    private l f12864j;

    /* renamed from: k  reason: collision with root package name */
    private l f12865k;

    public s(Context context, l lVar) {
        this.f12855a = context.getApplicationContext();
        this.f12857c = (l) com.google.android.exoplayer2.util.a.e(lVar);
    }

    private void q(l lVar) {
        for (int i6 = 0; i6 < this.f12856b.size(); i6++) {
            lVar.i((i0) this.f12856b.get(i6));
        }
    }

    private l r() {
        if (this.f12859e == null) {
            c cVar = new c(this.f12855a);
            this.f12859e = cVar;
            q(cVar);
        }
        return this.f12859e;
    }

    private l s() {
        if (this.f12860f == null) {
            g gVar = new g(this.f12855a);
            this.f12860f = gVar;
            q(gVar);
        }
        return this.f12860f;
    }

    private l t() {
        if (this.f12863i == null) {
            i iVar = new i();
            this.f12863i = iVar;
            q(iVar);
        }
        return this.f12863i;
    }

    private l u() {
        if (this.f12858d == null) {
            z zVar = new z();
            this.f12858d = zVar;
            q(zVar);
        }
        return this.f12858d;
    }

    private l v() {
        if (this.f12864j == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f12855a);
            this.f12864j = rawResourceDataSource;
            q(rawResourceDataSource);
        }
        return this.f12864j;
    }

    private l w() {
        if (this.f12861g == null) {
            try {
                l lVar = (l) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f12861g = lVar;
                q(lVar);
            } catch (ClassNotFoundException unused) {
                com.google.android.exoplayer2.util.n.h("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e6) {
                throw new RuntimeException("Error instantiating RTMP extension", e6);
            }
            if (this.f12861g == null) {
                this.f12861g = this.f12857c;
            }
        }
        return this.f12861g;
    }

    private l x() {
        if (this.f12862h == null) {
            j0 j0Var = new j0();
            this.f12862h = j0Var;
            q(j0Var);
        }
        return this.f12862h;
    }

    private void y(l lVar, i0 i0Var) {
        if (lVar != null) {
            lVar.i(i0Var);
        }
    }

    @Override // q2.l
    public long b(o oVar) {
        l s5;
        com.google.android.exoplayer2.util.a.g(this.f12865k == null);
        String scheme = oVar.f12794a.getScheme();
        if (s0.p0(oVar.f12794a)) {
            String path = oVar.f12794a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                s5 = u();
            }
            s5 = r();
        } else {
            if (!"asset".equals(scheme)) {
                s5 = "content".equals(scheme) ? s() : "rtmp".equals(scheme) ? w() : "udp".equals(scheme) ? x() : "data".equals(scheme) ? t() : ("rawresource".equals(scheme) || "android.resource".equals(scheme)) ? v() : this.f12857c;
            }
            s5 = r();
        }
        this.f12865k = s5;
        return this.f12865k.b(oVar);
    }

    @Override // q2.l
    public void close() {
        l lVar = this.f12865k;
        if (lVar != null) {
            try {
                lVar.close();
            } finally {
                this.f12865k = null;
            }
        }
    }

    @Override // q2.l
    public Map f() {
        l lVar = this.f12865k;
        return lVar == null ? Collections.emptyMap() : lVar.f();
    }

    @Override // q2.l
    public void i(i0 i0Var) {
        com.google.android.exoplayer2.util.a.e(i0Var);
        this.f12857c.i(i0Var);
        this.f12856b.add(i0Var);
        y(this.f12858d, i0Var);
        y(this.f12859e, i0Var);
        y(this.f12860f, i0Var);
        y(this.f12861g, i0Var);
        y(this.f12862h, i0Var);
        y(this.f12863i, i0Var);
        y(this.f12864j, i0Var);
    }

    @Override // q2.l
    public Uri k() {
        l lVar = this.f12865k;
        if (lVar == null) {
            return null;
        }
        return lVar.k();
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        return ((l) com.google.android.exoplayer2.util.a.e(this.f12865k)).read(bArr, i6, i7);
    }
}
