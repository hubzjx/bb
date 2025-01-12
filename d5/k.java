package d5;

import e5.p;
import e5.q;
import i5.f0;
import i5.h0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
/* loaded from: classes.dex */
public class k extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private d f9219a;

    /* renamed from: b  reason: collision with root package name */
    private char[] f9220b;

    /* renamed from: c  reason: collision with root package name */
    private p f9221c;

    /* renamed from: d  reason: collision with root package name */
    private c f9222d;

    /* renamed from: e  reason: collision with root package name */
    private e5.i f9223e;

    /* renamed from: f  reason: collision with root package name */
    private e5.j f9224f;

    /* renamed from: n  reason: collision with root package name */
    private e5.k f9230n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9231o;

    /* renamed from: g  reason: collision with root package name */
    private b5.a f9225g = new b5.a();

    /* renamed from: h  reason: collision with root package name */
    private b5.e f9226h = new b5.e();

    /* renamed from: k  reason: collision with root package name */
    private CRC32 f9227k = new CRC32();

    /* renamed from: l  reason: collision with root package name */
    private h0 f9228l = new h0();

    /* renamed from: m  reason: collision with root package name */
    private long f9229m = 0;

    /* renamed from: p  reason: collision with root package name */
    private boolean f9232p = true;

    public k(OutputStream outputStream, char[] cArr, e5.k kVar, p pVar) {
        if (kVar.a() < 512) {
            throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
        }
        d dVar = new d(outputStream);
        this.f9219a = dVar;
        this.f9220b = cArr;
        this.f9230n = kVar;
        this.f9221c = g(pVar, dVar);
        this.f9231o = false;
        l();
    }

    private void b() {
        if (this.f9231o) {
            throw new IOException("Stream is closed");
        }
    }

    private void c(q qVar) {
        e5.i d6 = this.f9225g.d(qVar, this.f9219a.g(), this.f9219a.a(), this.f9230n.b(), this.f9228l);
        this.f9223e = d6;
        d6.W(this.f9219a.e());
        e5.j f6 = this.f9225g.f(this.f9223e);
        this.f9224f = f6;
        this.f9226h.p(this.f9221c, f6, this.f9219a, this.f9230n.b());
    }

    private b d(j jVar, q qVar) {
        if (qVar.o()) {
            char[] cArr = this.f9220b;
            if (cArr == null || cArr.length == 0) {
                throw new a5.a("password not set");
            }
            if (qVar.f() == f5.e.AES) {
                return new a(jVar, qVar, this.f9220b);
            }
            if (qVar.f() == f5.e.ZIP_STANDARD) {
                return new l(jVar, qVar, this.f9220b);
            }
            f5.e f6 = qVar.f();
            f5.e eVar = f5.e.ZIP_STANDARD_VARIANT_STRONG;
            if (f6 == eVar) {
                throw new a5.a(eVar + " encryption method is not supported");
            }
            throw new a5.a("Invalid encryption method");
        }
        return new f(jVar, qVar, null);
    }

    private c e(b bVar, q qVar) {
        return qVar.d() == f5.d.DEFLATE ? new e(bVar, qVar.c(), this.f9230n.a()) : new i(bVar);
    }

    private c f(q qVar) {
        return e(d(new j(this.f9219a), qVar), qVar);
    }

    private p g(p pVar, d dVar) {
        if (pVar == null) {
            pVar = new p();
        }
        if (dVar.g()) {
            pVar.l(true);
            pVar.m(dVar.f());
        }
        return pVar;
    }

    private void i() {
        this.f9229m = 0L;
        this.f9227k.reset();
        this.f9222d.close();
    }

    private void j(q qVar) {
        if (qVar.d() == f5.d.STORE && qVar.h() < 0 && !f0.t(qVar.k()) && qVar.u()) {
            throw new IllegalArgumentException("uncompressed size should be set for zip entries of compression type store");
        }
    }

    private boolean k(e5.i iVar) {
        if (iVar.r() && iVar.g().equals(f5.e.AES)) {
            return iVar.c().d().equals(f5.b.ONE);
        }
        return true;
    }

    private void l() {
        if (this.f9219a.g()) {
            this.f9228l.j(this.f9219a, (int) b5.c.SPLIT_ZIP.getValue());
        }
    }

    public e5.i a() {
        this.f9222d.a();
        long b6 = this.f9222d.b();
        this.f9223e.u(b6);
        this.f9224f.u(b6);
        this.f9223e.I(this.f9229m);
        this.f9224f.I(this.f9229m);
        if (k(this.f9223e)) {
            this.f9223e.w(this.f9227k.getValue());
            this.f9224f.w(this.f9227k.getValue());
        }
        this.f9221c.c().add(this.f9224f);
        this.f9221c.a().a().add(this.f9223e);
        if (this.f9224f.q()) {
            this.f9226h.n(this.f9224f, this.f9219a);
        }
        i();
        this.f9232p = true;
        return this.f9223e;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f9232p) {
            a();
        }
        this.f9221c.b().n(this.f9219a.d());
        this.f9226h.d(this.f9221c, this.f9219a, this.f9230n.b());
        this.f9219a.close();
        this.f9231o = true;
    }

    public void h(q qVar) {
        j(qVar);
        q qVar2 = new q(qVar);
        if (f0.t(qVar.k())) {
            qVar2.D(false);
            qVar2.w(f5.d.STORE);
            qVar2.x(false);
        }
        c(qVar2);
        this.f9222d = f(qVar2);
        this.f9232p = false;
    }

    @Override // java.io.OutputStream
    public void write(int i6) {
        write(new byte[]{(byte) i6});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) {
        b();
        this.f9227k.update(bArr, i6, i7);
        this.f9222d.write(bArr, i6, i7);
        this.f9229m += i7;
    }
}
