package j1;

import android.net.Uri;
import c1.a0;
import c1.k;
import c1.n;
import c1.o;
import c1.w;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.util.y;
import java.util.Map;
/* loaded from: classes.dex */
public class d implements c1.i {

    /* renamed from: d  reason: collision with root package name */
    public static final o f11169d = new o() { // from class: j1.c
        @Override // c1.o
        public final c1.i[] a() {
            c1.i[] e6;
            e6 = d.e();
            return e6;
        }

        @Override // c1.o
        public /* synthetic */ c1.i[] b(Uri uri, Map map) {
            return n.a(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private k f11170a;

    /* renamed from: b  reason: collision with root package name */
    private i f11171b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11172c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c1.i[] e() {
        return new c1.i[]{new d()};
    }

    private static y f(y yVar) {
        yVar.M(0);
        return yVar;
    }

    private boolean i(c1.j jVar) {
        i hVar;
        f fVar = new f();
        if (fVar.b(jVar, true) && (fVar.f11179b & 2) == 2) {
            int min = Math.min(fVar.f11186i, 8);
            y yVar = new y(min);
            jVar.n(yVar.c(), 0, min);
            if (b.n(f(yVar))) {
                hVar = new b();
            } else if (j.p(f(yVar))) {
                hVar = new j();
            } else if (h.m(f(yVar))) {
                hVar = new h();
            }
            this.f11171b = hVar;
            return true;
        }
        return false;
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(k kVar) {
        this.f11170a = kVar;
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        i iVar = this.f11171b;
        if (iVar != null) {
            iVar.k(j6, j7);
        }
    }

    @Override // c1.i
    public int g(c1.j jVar, w wVar) {
        com.google.android.exoplayer2.util.a.i(this.f11170a);
        if (this.f11171b == null) {
            if (!i(jVar)) {
                throw new f1("Failed to determine bitstream type");
            }
            jVar.g();
        }
        if (!this.f11172c) {
            a0 e6 = this.f11170a.e(0, 1);
            this.f11170a.g();
            this.f11171b.c(this.f11170a, e6);
            this.f11172c = true;
        }
        return this.f11171b.f(jVar, wVar);
    }

    @Override // c1.i
    public boolean h(c1.j jVar) {
        try {
            return i(jVar);
        } catch (f1 unused) {
            return false;
        }
    }
}
