package w1;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.y1;
import java.io.IOException;
import java.util.List;
import q2.l;
import w1.v;
/* loaded from: classes.dex */
public final class m extends g {

    /* renamed from: l  reason: collision with root package name */
    private final o0 f13874l;

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    private static final class c implements e0 {
        public c(b bVar) {
            android.support.v4.media.a.a(com.google.android.exoplayer2.util.a.e(bVar));
        }

        @Override // w1.e0
        public void I(int i6, v.a aVar, p pVar, s sVar, IOException iOException, boolean z5) {
            throw null;
        }

        @Override // w1.e0
        public /* synthetic */ void Q(int i6, v.a aVar, p pVar, s sVar) {
            x.d(this, i6, aVar, pVar, sVar);
        }

        @Override // w1.e0
        public /* synthetic */ void j(int i6, v.a aVar, s sVar) {
            x.e(this, i6, aVar, sVar);
        }

        @Override // w1.e0
        public /* synthetic */ void l(int i6, v.a aVar, s sVar) {
            x.a(this, i6, aVar, sVar);
        }

        @Override // w1.e0
        public /* synthetic */ void n(int i6, v.a aVar, p pVar, s sVar) {
            x.c(this, i6, aVar, pVar, sVar);
        }

        @Override // w1.e0
        public /* synthetic */ void v(int i6, v.a aVar, p pVar, s sVar) {
            x.b(this, i6, aVar, pVar, sVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private final l.a f13875a;

        /* renamed from: b  reason: collision with root package name */
        private c1.o f13876b = new c1.g();

        /* renamed from: c  reason: collision with root package name */
        private q2.c0 f13877c = new q2.w();

        /* renamed from: d  reason: collision with root package name */
        private int f13878d = 1048576;

        /* renamed from: e  reason: collision with root package name */
        private String f13879e;

        /* renamed from: f  reason: collision with root package name */
        private Object f13880f;

        public d(l.a aVar) {
            this.f13875a = aVar;
        }

        @Override // w1.g0
        public /* synthetic */ g0 a(List list) {
            return f0.a(this, list);
        }

        public m e(Uri uri) {
            return c(new w0.b().g(uri).a());
        }

        @Override // w1.g0
        /* renamed from: f */
        public m c(com.google.android.exoplayer2.w0 w0Var) {
            com.google.android.exoplayer2.util.a.e(w0Var.f4702b);
            w0.e eVar = w0Var.f4702b;
            Uri uri = eVar.f4740a;
            l.a aVar = this.f13875a;
            c1.o oVar = this.f13876b;
            q2.c0 c0Var = this.f13877c;
            String str = this.f13879e;
            int i6 = this.f13878d;
            Object obj = eVar.f4747h;
            if (obj == null) {
                obj = this.f13880f;
            }
            return new m(uri, aVar, oVar, c0Var, str, i6, obj);
        }

        @Override // w1.g0
        /* renamed from: g */
        public d b(com.google.android.exoplayer2.drm.v vVar) {
            throw new UnsupportedOperationException();
        }

        @Override // w1.g0
        /* renamed from: h */
        public d d(q2.c0 c0Var) {
            if (c0Var == null) {
                c0Var = new q2.w();
            }
            this.f13877c = c0Var;
            return this;
        }
    }

    public m(Uri uri, l.a aVar, c1.o oVar, Handler handler, b bVar) {
        this(uri, aVar, oVar, handler, bVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.g, w1.a
    public void A(q2.i0 i0Var) {
        super.A(i0Var);
        J(null, this.f13874l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.g
    /* renamed from: K */
    public void I(Void r12, v vVar, y1 y1Var) {
        B(y1Var);
    }

    @Override // w1.v
    public com.google.android.exoplayer2.w0 a() {
        return this.f13874l.a();
    }

    @Override // w1.v
    public void i(t tVar) {
        this.f13874l.i(tVar);
    }

    @Override // w1.v
    public t o(v.a aVar, q2.b bVar, long j6) {
        return this.f13874l.o(aVar, bVar, j6);
    }

    public m(Uri uri, l.a aVar, c1.o oVar, Handler handler, b bVar, String str) {
        this(uri, aVar, oVar, handler, bVar, str, 1048576);
    }

    public m(Uri uri, l.a aVar, c1.o oVar, Handler handler, b bVar, String str, int i6) {
        this(uri, aVar, oVar, new q2.w(), str, i6, (Object) null);
        if (bVar == null || handler == null) {
            return;
        }
        n(handler, new c(bVar));
    }

    private m(Uri uri, l.a aVar, c1.o oVar, q2.c0 c0Var, String str, int i6, Object obj) {
        this.f13874l = new o0(new w0.b().g(uri).b(str).f(obj).a(), aVar, oVar, com.google.android.exoplayer2.drm.u.c(), c0Var, i6);
    }
}
