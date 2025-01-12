package b5;

import e5.h;
import e5.i;
import e5.j;
import e5.l;
import e5.m;
import e5.p;
import i5.f0;
import i5.h0;
import i5.i0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final h0 f3040a = new h0();

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f3041b = new byte[8];

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f3042c = new byte[4];

    private m a(p pVar, int i6, long j6) {
        m mVar = new m();
        mVar.b(c.ZIP64_END_CENTRAL_DIRECTORY_RECORD);
        mVar.q(44L);
        if (pVar.a() != null && pVar.a().a() != null && pVar.a().a().size() > 0) {
            i iVar = (i) pVar.a().a().get(0);
            mVar.t(iVar.Q());
            mVar.u(iVar.o());
        }
        mVar.m(pVar.b().d());
        mVar.n(pVar.b().e());
        long size = pVar.a().a().size();
        mVar.s(pVar.h() ? c(pVar.a().a(), pVar.b().d()) : size);
        mVar.r(size);
        mVar.p(i6);
        mVar.o(j6);
        return mVar;
    }

    private int b(i iVar, boolean z5) {
        int i6 = z5 ? 32 : 0;
        if (iVar.c() != null) {
            i6 += 11;
        }
        if (iVar.h() != null) {
            for (h hVar : iVar.h()) {
                if (hVar.d() != c.AES_EXTRA_DATA_RECORD.getValue() && hVar.d() != c.ZIP64_EXTRA_FIELD_SIGNATURE.getValue()) {
                    i6 += hVar.e() + 4;
                }
            }
        }
        return i6;
    }

    private long c(List list, int i6) {
        if (list != null) {
            Iterator it = list.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                if (((i) it.next()).M() == i6) {
                    i7++;
                }
            }
            return i7;
        }
        throw new a5.a("file headers are null, cannot calculate number of entries on this disk");
    }

    private int e(OutputStream outputStream) {
        return outputStream instanceof d5.h ? ((d5.h) outputStream).a() : ((d5.d) outputStream).a();
    }

    private long f(p pVar) {
        return (!pVar.i() || pVar.f() == null || pVar.f().e() == -1) ? pVar.b().g() : pVar.f().e();
    }

    private boolean g(OutputStream outputStream) {
        if (outputStream instanceof d5.h) {
            return ((d5.h) outputStream).g();
        }
        if (outputStream instanceof d5.d) {
            return ((d5.d) outputStream).g();
        }
        return false;
    }

    private boolean h(i iVar) {
        return iVar.d() >= 4294967295L || iVar.n() >= 4294967295L || iVar.P() >= 4294967295L || iVar.M() >= 65535;
    }

    private void i(p pVar, OutputStream outputStream) {
        int i6;
        if (outputStream instanceof d5.g) {
            d5.g gVar = (d5.g) outputStream;
            pVar.b().n(gVar.b());
            i6 = gVar.a();
        } else {
            i6 = 0;
        }
        if (pVar.i()) {
            if (pVar.f() == null) {
                pVar.o(new m());
            }
            if (pVar.e() == null) {
                pVar.n(new l());
            }
            pVar.f().o(pVar.b().g());
            pVar.e().f(i6);
            pVar.e().h(i6 + 1);
        }
        pVar.b().k(i6);
        pVar.b().l(i6);
    }

    private void j(d5.h hVar, i iVar) {
        int i6 = (iVar.n() > 4294967295L ? 1 : (iVar.n() == 4294967295L ? 0 : -1));
        h0 h0Var = this.f3040a;
        byte[] bArr = this.f3041b;
        if (i6 < 0) {
            h0Var.m(bArr, 0, iVar.d());
            hVar.write(this.f3041b, 0, 4);
            this.f3040a.m(this.f3041b, 0, iVar.n());
            hVar.write(this.f3041b, 0, 4);
            return;
        }
        h0Var.m(bArr, 0, 4294967295L);
        hVar.write(this.f3041b, 0, 4);
        hVar.write(this.f3041b, 0, 4);
        int k6 = iVar.k() + 4 + 2 + 2;
        if (hVar.i(k6) == k6) {
            this.f3040a.l(hVar, iVar.n());
            this.f3040a.l(hVar, iVar.d());
            return;
        }
        throw new a5.a("Unable to skip " + k6 + " bytes to update LFH");
    }

    private void l(p pVar, ByteArrayOutputStream byteArrayOutputStream, h0 h0Var, Charset charset) {
        if (pVar.a() == null || pVar.a().a() == null || pVar.a().a().size() <= 0) {
            return;
        }
        for (i iVar : pVar.a().a()) {
            o(pVar, iVar, byteArrayOutputStream, h0Var, charset);
        }
    }

    private void m(p pVar, int i6, long j6, ByteArrayOutputStream byteArrayOutputStream, h0 h0Var, Charset charset) {
        byte[] bArr = new byte[8];
        h0Var.j(byteArrayOutputStream, (int) c.END_OF_CENTRAL_DIRECTORY.getValue());
        h0Var.n(byteArrayOutputStream, pVar.b().d());
        h0Var.n(byteArrayOutputStream, pVar.b().e());
        long size = pVar.a().a().size();
        long c6 = pVar.h() ? c(pVar.a().a(), pVar.b().d()) : size;
        if (c6 > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            c6 = 65535;
        }
        h0Var.n(byteArrayOutputStream, (int) c6);
        if (size > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            size = 65535;
        }
        h0Var.n(byteArrayOutputStream, (int) size);
        h0Var.j(byteArrayOutputStream, i6);
        if (j6 > 4294967295L) {
            h0Var.m(bArr, 0, 4294967295L);
        } else {
            h0Var.m(bArr, 0, j6);
        }
        byteArrayOutputStream.write(bArr, 0, 4);
        String c7 = pVar.b().c();
        if (!i0.d(c7)) {
            h0Var.n(byteArrayOutputStream, 0);
            return;
        }
        byte[] b6 = d.b(c7, charset);
        h0Var.n(byteArrayOutputStream, b6.length);
        byteArrayOutputStream.write(b6);
    }

    private void o(p pVar, i iVar, ByteArrayOutputStream byteArrayOutputStream, h0 h0Var, Charset charset) {
        byte[] bArr;
        if (iVar == null) {
            throw new a5.a("input parameters is null, cannot write local file header");
        }
        try {
            byte[] bArr2 = {0, 0};
            boolean h6 = h(iVar);
            h0Var.j(byteArrayOutputStream, (int) iVar.a().getValue());
            h0Var.n(byteArrayOutputStream, iVar.Q());
            h0Var.n(byteArrayOutputStream, iVar.o());
            byteArrayOutputStream.write(iVar.l());
            h0Var.n(byteArrayOutputStream, iVar.e().getCode());
            h0Var.m(this.f3041b, 0, iVar.m());
            byteArrayOutputStream.write(this.f3041b, 0, 4);
            h0Var.m(this.f3041b, 0, iVar.f());
            byteArrayOutputStream.write(this.f3041b, 0, 4);
            if (h6) {
                h0Var.m(this.f3041b, 0, 4294967295L);
                byteArrayOutputStream.write(this.f3041b, 0, 4);
                byteArrayOutputStream.write(this.f3041b, 0, 4);
                pVar.p(true);
                bArr = bArr2;
            } else {
                bArr = bArr2;
                h0Var.m(this.f3041b, 0, iVar.d());
                byteArrayOutputStream.write(this.f3041b, 0, 4);
                h0Var.m(this.f3041b, 0, iVar.n());
                byteArrayOutputStream.write(this.f3041b, 0, 4);
            }
            byte[] bArr3 = new byte[0];
            if (i0.d(iVar.j())) {
                bArr3 = d.b(iVar.j(), charset);
            }
            h0Var.n(byteArrayOutputStream, bArr3.length);
            byte[] bArr4 = new byte[4];
            if (h6) {
                h0Var.m(this.f3041b, 0, 4294967295L);
                System.arraycopy(this.f3041b, 0, bArr4, 0, 4);
            } else {
                h0Var.m(this.f3041b, 0, iVar.P());
                System.arraycopy(this.f3041b, 0, bArr4, 0, 4);
            }
            h0Var.n(byteArrayOutputStream, b(iVar, h6));
            String O = iVar.O();
            byte[] bArr5 = new byte[0];
            if (i0.d(O)) {
                bArr5 = d.b(O, charset);
            }
            h0Var.n(byteArrayOutputStream, bArr5.length);
            if (h6) {
                h0Var.k(this.f3042c, 0, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                byteArrayOutputStream.write(this.f3042c, 0, 2);
            } else {
                h0Var.n(byteArrayOutputStream, iVar.M());
            }
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(iVar.N());
            byteArrayOutputStream.write(bArr4);
            if (bArr3.length > 0) {
                byteArrayOutputStream.write(bArr3);
            }
            if (h6) {
                pVar.p(true);
                h0Var.n(byteArrayOutputStream, (int) c.ZIP64_EXTRA_FIELD_SIGNATURE.getValue());
                h0Var.n(byteArrayOutputStream, 28);
                h0Var.l(byteArrayOutputStream, iVar.n());
                h0Var.l(byteArrayOutputStream, iVar.d());
                h0Var.l(byteArrayOutputStream, iVar.P());
                h0Var.j(byteArrayOutputStream, iVar.M());
            }
            if (iVar.c() != null) {
                e5.a c6 = iVar.c();
                h0Var.n(byteArrayOutputStream, (int) c6.a().getValue());
                h0Var.n(byteArrayOutputStream, c6.f());
                h0Var.n(byteArrayOutputStream, c6.d().getVersionNumber());
                byteArrayOutputStream.write(c6.g().getBytes());
                byteArrayOutputStream.write(new byte[]{(byte) c6.c().getRawCode()});
                h0Var.n(byteArrayOutputStream, c6.e().getCode());
            }
            q(iVar, byteArrayOutputStream);
            if (bArr5.length > 0) {
                byteArrayOutputStream.write(bArr5);
            }
        } catch (Exception e6) {
            throw new a5.a(e6);
        }
    }

    private void q(i iVar, OutputStream outputStream) {
        if (iVar.h() == null || iVar.h().size() == 0) {
            return;
        }
        for (h hVar : iVar.h()) {
            if (hVar.d() != c.AES_EXTRA_DATA_RECORD.getValue() && hVar.d() != c.ZIP64_EXTRA_FIELD_SIGNATURE.getValue()) {
                this.f3040a.n(outputStream, (int) hVar.d());
                this.f3040a.n(outputStream, hVar.e());
                if (hVar.e() > 0 && hVar.c() != null) {
                    outputStream.write(hVar.c());
                }
            }
        }
    }

    private void r(l lVar, ByteArrayOutputStream byteArrayOutputStream, h0 h0Var) {
        h0Var.j(byteArrayOutputStream, (int) c.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR.getValue());
        h0Var.j(byteArrayOutputStream, lVar.c());
        h0Var.l(byteArrayOutputStream, lVar.d());
        h0Var.j(byteArrayOutputStream, lVar.e());
    }

    private void s(m mVar, ByteArrayOutputStream byteArrayOutputStream, h0 h0Var) {
        h0Var.j(byteArrayOutputStream, (int) mVar.a().getValue());
        h0Var.l(byteArrayOutputStream, mVar.g());
        h0Var.n(byteArrayOutputStream, mVar.j());
        h0Var.n(byteArrayOutputStream, mVar.k());
        h0Var.j(byteArrayOutputStream, mVar.c());
        h0Var.j(byteArrayOutputStream, mVar.d());
        h0Var.l(byteArrayOutputStream, mVar.i());
        h0Var.l(byteArrayOutputStream, mVar.h());
        h0Var.l(byteArrayOutputStream, mVar.f());
        h0Var.l(byteArrayOutputStream, mVar.e());
    }

    private void t(p pVar, OutputStream outputStream, byte[] bArr, Charset charset) {
        if (bArr == null) {
            throw new a5.a("invalid buff to write as zip headers");
        }
        if ((outputStream instanceof d5.d) && ((d5.d) outputStream).c(bArr.length)) {
            d(pVar, outputStream, charset);
        } else {
            outputStream.write(bArr);
        }
    }

    public void d(p pVar, OutputStream outputStream, Charset charset) {
        if (pVar == null || outputStream == null) {
            throw new a5.a("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            i(pVar, outputStream);
            long f6 = f(pVar);
            l(pVar, byteArrayOutputStream, this.f3040a, charset);
            int size = byteArrayOutputStream.size();
            if (pVar.i() || f6 >= 4294967295L || pVar.a().a().size() >= 65535) {
                if (pVar.f() == null) {
                    pVar.o(new m());
                }
                if (pVar.e() == null) {
                    pVar.n(new l());
                }
                pVar.e().g(size + f6);
                if (g(outputStream)) {
                    int e6 = e(outputStream);
                    pVar.e().f(e6);
                    pVar.e().h(e6 + 1);
                } else {
                    pVar.e().f(0);
                    pVar.e().h(1);
                }
                m a6 = a(pVar, size, f6);
                pVar.o(a6);
                s(a6, byteArrayOutputStream, this.f3040a);
                r(pVar.e(), byteArrayOutputStream, this.f3040a);
            }
            m(pVar, size, f6, byteArrayOutputStream, this.f3040a, charset);
            t(pVar, outputStream, byteArrayOutputStream.toByteArray(), charset);
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void k(i iVar, p pVar, d5.h hVar) {
        d5.h hVar2;
        boolean z5;
        String str;
        StringBuilder sb;
        String str2;
        if (iVar == null || pVar == null) {
            throw new a5.a("invalid input parameters, cannot update local file header");
        }
        if (iVar.M() != hVar.a()) {
            String parent = pVar.g().getParent();
            String n5 = f0.n(pVar.g().getName());
            if (parent != null) {
                str = parent + System.getProperty("file.separator");
            } else {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            z5 = true;
            if (iVar.M() < 9) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(n5);
                str2 = ".z0";
            } else {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(n5);
                str2 = ".z";
            }
            sb.append(str2);
            sb.append(iVar.M() + 1);
            hVar2 = new d5.h(new File(sb.toString()));
        } else {
            hVar2 = hVar;
            z5 = false;
        }
        long b6 = hVar2.b();
        hVar2.h(iVar.P() + 14);
        this.f3040a.m(this.f3041b, 0, iVar.f());
        hVar2.write(this.f3041b, 0, 4);
        j(hVar2, iVar);
        if (z5) {
            hVar2.close();
        } else {
            hVar.h(b6);
        }
    }

    public void n(j jVar, OutputStream outputStream) {
        if (jVar == null || outputStream == null) {
            throw new a5.a("input parameters is null, cannot write extended local header");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.f3040a.j(byteArrayOutputStream, (int) c.EXTRA_DATA_RECORD.getValue());
            this.f3040a.m(this.f3041b, 0, jVar.f());
            byteArrayOutputStream.write(this.f3041b, 0, 4);
            if (jVar.L()) {
                this.f3040a.l(byteArrayOutputStream, jVar.d());
                this.f3040a.l(byteArrayOutputStream, jVar.n());
            } else {
                this.f3040a.m(this.f3041b, 0, jVar.d());
                byteArrayOutputStream.write(this.f3041b, 0, 4);
                this.f3040a.m(this.f3041b, 0, jVar.n());
                byteArrayOutputStream.write(this.f3041b, 0, 4);
            }
            outputStream.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006e A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:3:0x0005, B:5:0x0060, B:11:0x006e, B:13:0x00a9, B:15:0x00b5, B:16:0x00bd, B:20:0x00c9, B:22:0x00cf, B:23:0x00d1, B:25:0x00d9, B:27:0x00de, B:28:0x0103, B:30:0x0109, B:31:0x0159, B:12:0x0086), top: B:40:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0086 A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:3:0x0005, B:5:0x0060, B:11:0x006e, B:13:0x00a9, B:15:0x00b5, B:16:0x00bd, B:20:0x00c9, B:22:0x00cf, B:23:0x00d1, B:25:0x00d9, B:27:0x00de, B:28:0x0103, B:30:0x0109, B:31:0x0159, B:12:0x0086), top: B:40:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b5 A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:3:0x0005, B:5:0x0060, B:11:0x006e, B:13:0x00a9, B:15:0x00b5, B:16:0x00bd, B:20:0x00c9, B:22:0x00cf, B:23:0x00d1, B:25:0x00d9, B:27:0x00de, B:28:0x0103, B:30:0x0109, B:31:0x0159, B:12:0x0086), top: B:40:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:3:0x0005, B:5:0x0060, B:11:0x006e, B:13:0x00a9, B:15:0x00b5, B:16:0x00bd, B:20:0x00c9, B:22:0x00cf, B:23:0x00d1, B:25:0x00d9, B:27:0x00de, B:28:0x0103, B:30:0x0109, B:31:0x0159, B:12:0x0086), top: B:40:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d9 A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:3:0x0005, B:5:0x0060, B:11:0x006e, B:13:0x00a9, B:15:0x00b5, B:16:0x00bd, B:20:0x00c9, B:22:0x00cf, B:23:0x00d1, B:25:0x00d9, B:27:0x00de, B:28:0x0103, B:30:0x0109, B:31:0x0159, B:12:0x0086), top: B:40:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00de A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:3:0x0005, B:5:0x0060, B:11:0x006e, B:13:0x00a9, B:15:0x00b5, B:16:0x00bd, B:20:0x00c9, B:22:0x00cf, B:23:0x00d1, B:25:0x00d9, B:27:0x00de, B:28:0x0103, B:30:0x0109, B:31:0x0159, B:12:0x0086), top: B:40:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0109 A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:3:0x0005, B:5:0x0060, B:11:0x006e, B:13:0x00a9, B:15:0x00b5, B:16:0x00bd, B:20:0x00c9, B:22:0x00cf, B:23:0x00d1, B:25:0x00d9, B:27:0x00de, B:28:0x0103, B:30:0x0109, B:31:0x0159, B:12:0x0086), top: B:40:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p(p pVar, j jVar, OutputStream outputStream, Charset charset) {
        boolean z5;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.f3040a.j(byteArrayOutputStream, (int) jVar.a().getValue());
            this.f3040a.n(byteArrayOutputStream, jVar.o());
            byteArrayOutputStream.write(jVar.l());
            this.f3040a.n(byteArrayOutputStream, jVar.e().getCode());
            this.f3040a.m(this.f3041b, 0, jVar.m());
            byteArrayOutputStream.write(this.f3041b, 0, 4);
            this.f3040a.m(this.f3041b, 0, jVar.f());
            byteArrayOutputStream.write(this.f3041b, 0, 4);
            if (jVar.d() < 4294967295L && jVar.n() < 4294967295L) {
                z5 = false;
                if (z5) {
                    this.f3040a.m(this.f3041b, 0, jVar.d());
                    byteArrayOutputStream.write(this.f3041b, 0, 4);
                    this.f3040a.m(this.f3041b, 0, jVar.n());
                    byteArrayOutputStream.write(this.f3041b, 0, 4);
                    jVar.M(false);
                } else {
                    this.f3040a.m(this.f3041b, 0, 4294967295L);
                    byteArrayOutputStream.write(this.f3041b, 0, 4);
                    byteArrayOutputStream.write(this.f3041b, 0, 4);
                    pVar.p(true);
                    jVar.M(true);
                }
                bArr = new byte[0];
                if (i0.d(jVar.j())) {
                    bArr = d.b(jVar.j(), charset);
                }
                this.f3040a.n(byteArrayOutputStream, bArr.length);
                int i6 = !z5 ? 20 : 0;
                if (jVar.c() != null) {
                    i6 += 11;
                }
                this.f3040a.n(byteArrayOutputStream, i6);
                if (bArr.length > 0) {
                    byteArrayOutputStream.write(bArr);
                }
                if (z5) {
                    this.f3040a.n(byteArrayOutputStream, (int) c.ZIP64_EXTRA_FIELD_SIGNATURE.getValue());
                    this.f3040a.n(byteArrayOutputStream, 16);
                    this.f3040a.l(byteArrayOutputStream, jVar.n());
                    this.f3040a.l(byteArrayOutputStream, jVar.d());
                }
                if (jVar.c() != null) {
                    e5.a c6 = jVar.c();
                    this.f3040a.n(byteArrayOutputStream, (int) c6.a().getValue());
                    this.f3040a.n(byteArrayOutputStream, c6.f());
                    this.f3040a.n(byteArrayOutputStream, c6.d().getVersionNumber());
                    byteArrayOutputStream.write(c6.g().getBytes());
                    byteArrayOutputStream.write(new byte[]{(byte) c6.c().getRawCode()});
                    this.f3040a.n(byteArrayOutputStream, c6.e().getCode());
                }
                outputStream.write(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.close();
            }
            z5 = true;
            if (z5) {
            }
            bArr = new byte[0];
            if (i0.d(jVar.j())) {
            }
            this.f3040a.n(byteArrayOutputStream, bArr.length);
            if (!z5) {
            }
            if (jVar.c() != null) {
            }
            this.f3040a.n(byteArrayOutputStream, i6);
            if (bArr.length > 0) {
            }
            if (z5) {
            }
            if (jVar.c() != null) {
            }
            outputStream.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
