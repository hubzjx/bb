package w1;

import android.net.Uri;
import java.io.EOFException;
import java.util.Map;
/* loaded from: classes.dex */
final class c implements j0 {

    /* renamed from: a  reason: collision with root package name */
    private final c1.o f13788a;

    /* renamed from: b  reason: collision with root package name */
    private c1.i f13789b;

    /* renamed from: c  reason: collision with root package name */
    private c1.j f13790c;

    public c(c1.o oVar) {
        this.f13788a = oVar;
    }

    @Override // w1.j0
    public void a() {
        c1.i iVar = this.f13789b;
        if (iVar != null) {
            iVar.a();
            this.f13789b = null;
        }
        this.f13790c = null;
    }

    @Override // w1.j0
    public int b(c1.w wVar) {
        return ((c1.i) com.google.android.exoplayer2.util.a.e(this.f13789b)).g((c1.j) com.google.android.exoplayer2.util.a.e(this.f13790c), wVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r6.p() != r11) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0062, code lost:
        if (r6.p() != r11) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
        r1 = false;
     */
    @Override // w1.j0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(q2.h hVar, Uri uri, Map map, long j6, long j7, c1.k kVar) {
        c1.f fVar = new c1.f(hVar, j6, j7);
        this.f13790c = fVar;
        if (this.f13789b != null) {
            return;
        }
        c1.i[] b6 = this.f13788a.b(uri, map);
        boolean z5 = false;
        if (b6.length == 1) {
            this.f13789b = b6[0];
        } else {
            int length = b6.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    break;
                }
                c1.i iVar = b6[i6];
                try {
                } catch (EOFException unused) {
                    if (this.f13789b == null) {
                    }
                } catch (Throwable th) {
                    com.google.android.exoplayer2.util.a.g((this.f13789b != null || fVar.p() == j6) ? true : true);
                    fVar.g();
                    throw th;
                }
                if (iVar.h(fVar)) {
                    this.f13789b = iVar;
                    com.google.android.exoplayer2.util.a.g(true);
                    fVar.g();
                    break;
                }
                if (this.f13789b == null) {
                }
                boolean z6 = true;
                com.google.android.exoplayer2.util.a.g(z6);
                fVar.g();
                i6++;
            }
            if (this.f13789b == null) {
                String K = com.google.android.exoplayer2.util.s0.K(b6);
                StringBuilder sb = new StringBuilder(String.valueOf(K).length() + 58);
                sb.append("None of the available extractors (");
                sb.append(K);
                sb.append(") could read the stream.");
                throw new z0(sb.toString(), (Uri) com.google.android.exoplayer2.util.a.e(uri));
            }
        }
        this.f13789b.c(kVar);
    }

    @Override // w1.j0
    public void d(long j6, long j7) {
        ((c1.i) com.google.android.exoplayer2.util.a.e(this.f13789b)).d(j6, j7);
    }

    @Override // w1.j0
    public long e() {
        c1.j jVar = this.f13790c;
        if (jVar != null) {
            return jVar.p();
        }
        return -1L;
    }

    @Override // w1.j0
    public void f() {
        c1.i iVar = this.f13789b;
        if (iVar instanceof h1.f) {
            ((h1.f) iVar).k();
        }
    }
}
