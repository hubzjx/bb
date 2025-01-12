package r2;

import android.net.Uri;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.s0;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.Map;
import q2.h0;
import q2.i0;
import q2.j;
import q2.l;
import q2.y;
import q2.z;
import r2.a;
import r2.b;
/* loaded from: classes.dex */
public final class c implements q2.l {

    /* renamed from: a  reason: collision with root package name */
    private final r2.a f12941a;

    /* renamed from: b  reason: collision with root package name */
    private final q2.l f12942b;

    /* renamed from: c  reason: collision with root package name */
    private final q2.l f12943c;

    /* renamed from: d  reason: collision with root package name */
    private final q2.l f12944d;

    /* renamed from: e  reason: collision with root package name */
    private final i f12945e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f12946f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f12947g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f12948h;

    /* renamed from: i  reason: collision with root package name */
    private Uri f12949i;

    /* renamed from: j  reason: collision with root package name */
    private q2.o f12950j;

    /* renamed from: k  reason: collision with root package name */
    private q2.l f12951k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12952l;

    /* renamed from: m  reason: collision with root package name */
    private long f12953m;

    /* renamed from: n  reason: collision with root package name */
    private long f12954n;

    /* renamed from: o  reason: collision with root package name */
    private j f12955o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12956p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f12957q;

    /* renamed from: r  reason: collision with root package name */
    private long f12958r;

    /* renamed from: s  reason: collision with root package name */
    private long f12959s;

    /* loaded from: classes.dex */
    public interface b {
    }

    /* renamed from: r2.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0212c implements l.a {

        /* renamed from: a  reason: collision with root package name */
        private r2.a f12960a;

        /* renamed from: c  reason: collision with root package name */
        private j.a f12962c;

        /* renamed from: e  reason: collision with root package name */
        private boolean f12964e;

        /* renamed from: f  reason: collision with root package name */
        private l.a f12965f;

        /* renamed from: g  reason: collision with root package name */
        private int f12966g;

        /* renamed from: h  reason: collision with root package name */
        private int f12967h;

        /* renamed from: b  reason: collision with root package name */
        private l.a f12961b = new z.a();

        /* renamed from: d  reason: collision with root package name */
        private i f12963d = i.f12973a;

        private c c(q2.l lVar, int i6, int i7) {
            q2.j jVar;
            r2.a aVar = (r2.a) com.google.android.exoplayer2.util.a.e(this.f12960a);
            if (this.f12964e || lVar == null) {
                jVar = null;
            } else {
                j.a aVar2 = this.f12962c;
                jVar = aVar2 != null ? aVar2.a() : new b.C0211b().c(aVar).a();
            }
            return new c(aVar, lVar, this.f12961b.a(), jVar, this.f12963d, i6, null, i7, null);
        }

        @Override // q2.l.a
        /* renamed from: b */
        public c a() {
            l.a aVar = this.f12965f;
            return c(aVar != null ? aVar.a() : null, this.f12967h, this.f12966g);
        }

        public C0212c d(r2.a aVar) {
            this.f12960a = aVar;
            return this;
        }

        public C0212c e(i iVar) {
            this.f12963d = iVar;
            return this;
        }

        public C0212c f(j.a aVar) {
            this.f12962c = aVar;
            this.f12964e = aVar == null;
            return this;
        }

        public C0212c g(l.a aVar) {
            this.f12965f = aVar;
            return this;
        }
    }

    private c(r2.a aVar, q2.l lVar, q2.l lVar2, q2.j jVar, i iVar, int i6, a0 a0Var, int i7, b bVar) {
        this.f12941a = aVar;
        this.f12942b = lVar2;
        this.f12945e = iVar == null ? i.f12973a : iVar;
        this.f12946f = (i6 & 1) != 0;
        this.f12947g = (i6 & 2) != 0;
        this.f12948h = (i6 & 4) != 0;
        h0 h0Var = null;
        if (lVar != null) {
            this.f12944d = lVar;
            if (jVar != null) {
                h0Var = new h0(lVar, jVar);
            }
        } else {
            this.f12944d = y.f12893a;
        }
        this.f12943c = h0Var;
    }

    private void A(String str) {
        this.f12954n = 0L;
        if (w()) {
            o oVar = new o();
            o.g(oVar, this.f12953m);
            this.f12941a.g(str, oVar);
        }
    }

    private int B(q2.o oVar) {
        if (this.f12947g && this.f12956p) {
            return 0;
        }
        return (this.f12948h && oVar.f12801h == -1) ? 1 : -1;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [r2.j, q2.l] */
    private void q() {
        q2.l lVar = this.f12951k;
        if (lVar == null) {
            return;
        }
        try {
            lVar.close();
        } finally {
            this.f12951k = null;
            this.f12952l = false;
            j jVar = this.f12955o;
            if (jVar != null) {
                this.f12941a.c(jVar);
                this.f12955o = null;
            }
        }
    }

    private static Uri r(r2.a aVar, String str, Uri uri) {
        Uri b6 = m.b(aVar.d(str));
        return b6 != null ? b6 : uri;
    }

    private void s(Throwable th) {
        if (u() || (th instanceof a.C0210a)) {
            this.f12956p = true;
        }
    }

    private boolean t() {
        return this.f12951k == this.f12944d;
    }

    private boolean u() {
        return this.f12951k == this.f12942b;
    }

    private boolean v() {
        return !u();
    }

    private boolean w() {
        return this.f12951k == this.f12943c;
    }

    private void x() {
    }

    private void y(int i6) {
    }

    private void z(q2.o oVar, boolean z5) {
        j h6;
        long j6;
        q2.o a6;
        q2.l lVar;
        String str = (String) s0.j(oVar.f12802i);
        if (this.f12957q) {
            h6 = null;
        } else if (this.f12946f) {
            try {
                h6 = this.f12941a.h(str, this.f12953m, this.f12954n);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            h6 = this.f12941a.e(str, this.f12953m, this.f12954n);
        }
        if (h6 == null) {
            lVar = this.f12944d;
            a6 = oVar.a().h(this.f12953m).g(this.f12954n).a();
        } else if (h6.f12977d) {
            Uri fromFile = Uri.fromFile((File) s0.j(h6.f12978e));
            long j7 = h6.f12975b;
            long j8 = this.f12953m - j7;
            long j9 = h6.f12976c - j8;
            long j10 = this.f12954n;
            if (j10 != -1) {
                j9 = Math.min(j9, j10);
            }
            a6 = oVar.a().i(fromFile).k(j7).h(j8).g(j9).a();
            lVar = this.f12942b;
        } else {
            if (h6.c()) {
                j6 = this.f12954n;
            } else {
                j6 = h6.f12976c;
                long j11 = this.f12954n;
                if (j11 != -1) {
                    j6 = Math.min(j6, j11);
                }
            }
            a6 = oVar.a().h(this.f12953m).g(j6).a();
            lVar = this.f12943c;
            if (lVar == null) {
                lVar = this.f12944d;
                this.f12941a.c(h6);
                h6 = null;
            }
        }
        this.f12959s = (this.f12957q || lVar != this.f12944d) ? Long.MAX_VALUE : this.f12953m + 102400;
        if (z5) {
            com.google.android.exoplayer2.util.a.g(t());
            if (lVar == this.f12944d) {
                return;
            }
            try {
                q();
            } catch (Throwable th) {
                if (((j) s0.j(h6)).b()) {
                    this.f12941a.c(h6);
                }
                throw th;
            }
        }
        if (h6 != null && h6.b()) {
            this.f12955o = h6;
        }
        this.f12951k = lVar;
        this.f12952l = a6.f12801h == -1;
        long b6 = lVar.b(a6);
        o oVar2 = new o();
        if (this.f12952l && b6 != -1) {
            this.f12954n = b6;
            o.g(oVar2, this.f12953m + b6);
        }
        if (v()) {
            Uri k6 = lVar.k();
            this.f12949i = k6;
            o.h(oVar2, oVar.f12794a.equals(k6) ^ true ? this.f12949i : null);
        }
        if (w()) {
            this.f12941a.g(str, oVar2);
        }
    }

    @Override // q2.l
    public long b(q2.o oVar) {
        try {
            String a6 = this.f12945e.a(oVar);
            q2.o a7 = oVar.a().f(a6).a();
            this.f12950j = a7;
            this.f12949i = r(this.f12941a, a6, a7.f12794a);
            this.f12953m = oVar.f12800g;
            int B = B(oVar);
            boolean z5 = B != -1;
            this.f12957q = z5;
            if (z5) {
                y(B);
            }
            long j6 = oVar.f12801h;
            if (j6 == -1 && !this.f12957q) {
                long a8 = m.a(this.f12941a.d(a6));
                this.f12954n = a8;
                if (a8 != -1) {
                    long j7 = a8 - oVar.f12800g;
                    this.f12954n = j7;
                    if (j7 <= 0) {
                        throw new q2.m(0);
                    }
                }
                z(a7, false);
                return this.f12954n;
            }
            this.f12954n = j6;
            z(a7, false);
            return this.f12954n;
        } catch (Throwable th) {
            s(th);
            throw th;
        }
    }

    @Override // q2.l
    public void close() {
        this.f12950j = null;
        this.f12949i = null;
        this.f12953m = 0L;
        x();
        try {
            q();
        } catch (Throwable th) {
            s(th);
            throw th;
        }
    }

    @Override // q2.l
    public Map f() {
        return v() ? this.f12944d.f() : Collections.emptyMap();
    }

    @Override // q2.l
    public void i(i0 i0Var) {
        com.google.android.exoplayer2.util.a.e(i0Var);
        this.f12942b.i(i0Var);
        this.f12944d.i(i0Var);
    }

    @Override // q2.l
    public Uri k() {
        return this.f12949i;
    }

    @Override // q2.h
    public int read(byte[] bArr, int i6, int i7) {
        q2.o oVar = (q2.o) com.google.android.exoplayer2.util.a.e(this.f12950j);
        if (i7 == 0) {
            return 0;
        }
        if (this.f12954n == 0) {
            return -1;
        }
        try {
            if (this.f12953m >= this.f12959s) {
                z(oVar, true);
            }
            int read = ((q2.l) com.google.android.exoplayer2.util.a.e(this.f12951k)).read(bArr, i6, i7);
            if (read != -1) {
                if (u()) {
                    this.f12958r += read;
                }
                long j6 = read;
                this.f12953m += j6;
                long j7 = this.f12954n;
                if (j7 != -1) {
                    this.f12954n = j7 - j6;
                }
            } else if (!this.f12952l) {
                long j8 = this.f12954n;
                if (j8 <= 0) {
                    if (j8 == -1) {
                    }
                }
                q();
                z(oVar, false);
                return read(bArr, i6, i7);
            } else {
                A((String) s0.j(oVar.f12802i));
            }
            return read;
        } catch (IOException e6) {
            if (this.f12952l && q2.m.isCausedByPositionOutOfRange(e6)) {
                A((String) s0.j(oVar.f12802i));
                return -1;
            }
            s(e6);
            throw e6;
        } catch (Throwable th) {
            s(th);
            throw th;
        }
    }
}
