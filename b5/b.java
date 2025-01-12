package b5;

import e5.h;
import e5.i;
import e5.k;
import e5.l;
import e5.m;
import e5.n;
import e5.p;
import i5.g0;
import i5.h0;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private p f3037a;

    /* renamed from: b  reason: collision with root package name */
    private final h0 f3038b = new h0();

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f3039c = new byte[4];

    private long a(p pVar) {
        return pVar.i() ? pVar.f().h() : pVar.b().h();
    }

    private long c(RandomAccessFile randomAccessFile) {
        long length = randomAccessFile.length();
        if (length >= 22) {
            long j6 = length - 22;
            r(randomAccessFile, j6);
            return ((long) this.f3038b.a(randomAccessFile)) == c.END_OF_CENTRAL_DIRECTORY.getValue() ? j6 : d(randomAccessFile);
        }
        throw new a5.a("Zip file size less than size of zip headers. Probably not a zip file.");
    }

    private long d(RandomAccessFile randomAccessFile) {
        long length = randomAccessFile.length() - 22;
        for (long length2 = randomAccessFile.length() < 65536 ? randomAccessFile.length() : 65536L; length2 > 0 && length > 0; length2--) {
            length--;
            r(randomAccessFile, length);
            if (this.f3038b.a(randomAccessFile) == c.END_OF_CENTRAL_DIRECTORY.getValue()) {
                return length;
            }
        }
        throw new a5.a("Zip headers not found. Probably not a zip file");
    }

    private List e(byte[] bArr, int i6) {
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        while (i7 < i6) {
            h hVar = new h();
            hVar.g(this.f3038b.h(bArr, i7));
            int i8 = i7 + 2;
            int h6 = this.f3038b.h(bArr, i8);
            hVar.h(h6);
            int i9 = i8 + 2;
            if (h6 > 0) {
                byte[] bArr2 = new byte[h6];
                System.arraycopy(bArr, i9, bArr2, 0, h6);
                hVar.f(bArr2);
            }
            i7 = i9 + h6;
            arrayList.add(hVar);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private e5.a f(List list, h0 h0Var) {
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (hVar != null) {
                long d6 = hVar.d();
                c cVar = c.AES_EXTRA_DATA_RECORD;
                if (d6 == cVar.getValue()) {
                    if (hVar.c() != null) {
                        e5.a aVar = new e5.a();
                        aVar.b(cVar);
                        aVar.k(hVar.e());
                        byte[] c6 = hVar.c();
                        aVar.i(f5.b.getFromVersionNumber(h0Var.h(c6, 0)));
                        byte[] bArr = new byte[2];
                        System.arraycopy(c6, 2, bArr, 0, 2);
                        aVar.l(new String(bArr));
                        aVar.h(f5.a.getAesKeyStrengthFromRawCode(c6[4] & 255));
                        aVar.j(f5.d.getCompressionMethodFromCode(h0Var.h(c6, 5)));
                        return aVar;
                    }
                    throw new a5.a("corrupt AES extra data records");
                }
            }
        }
        return null;
    }

    private void g(i iVar, h0 h0Var) {
        e5.a f6;
        if (iVar.h() == null || iVar.h().size() <= 0 || (f6 = f(iVar.h(), h0Var)) == null) {
            return;
        }
        iVar.t(f6);
        iVar.A(f5.e.AES);
    }

    private e5.d i(RandomAccessFile randomAccessFile, h0 h0Var, Charset charset) {
        String str;
        e5.d dVar = new e5.d();
        ArrayList arrayList = new ArrayList();
        long e6 = d.e(this.f3037a);
        long a6 = a(this.f3037a);
        randomAccessFile.seek(e6);
        int i6 = 2;
        byte[] bArr = new byte[2];
        byte[] bArr2 = new byte[4];
        int i7 = 0;
        int i8 = 0;
        while (i8 < a6) {
            i iVar = new i();
            byte[] bArr3 = bArr2;
            long a7 = h0Var.a(randomAccessFile);
            c cVar = c.CENTRAL_DIRECTORY;
            if (a7 != cVar.getValue()) {
                throw new a5.a("Expected central directory entry not found (#" + (i8 + 1) + ")");
            }
            iVar.b(cVar);
            iVar.X(h0Var.g(randomAccessFile));
            iVar.J(h0Var.g(randomAccessFile));
            byte[] bArr4 = new byte[i6];
            randomAccessFile.readFully(bArr4);
            iVar.z(i5.a.a(bArr4[i7], i7));
            iVar.x(i5.a.a(bArr4[i7], 3));
            iVar.F(i5.a.a(bArr4[1], 3));
            iVar.G((byte[]) bArr4.clone());
            iVar.v(f5.d.getCompressionMethodFromCode(h0Var.g(randomAccessFile)));
            iVar.H(h0Var.a(randomAccessFile));
            randomAccessFile.readFully(bArr3);
            byte[] bArr5 = bArr;
            iVar.w(h0Var.f(bArr3, i7));
            iVar.u(h0Var.e(randomAccessFile, 4));
            iVar.I(h0Var.e(randomAccessFile, 4));
            int g6 = h0Var.g(randomAccessFile);
            iVar.E(g6);
            iVar.C(h0Var.g(randomAccessFile));
            int g7 = h0Var.g(randomAccessFile);
            iVar.U(g7);
            iVar.R(h0Var.g(randomAccessFile));
            randomAccessFile.readFully(bArr5);
            iVar.V((byte[]) bArr5.clone());
            randomAccessFile.readFully(bArr3);
            iVar.S((byte[]) bArr3.clone());
            randomAccessFile.readFully(bArr3);
            long j6 = a6;
            iVar.W(h0Var.f(bArr3, 0));
            if (g6 > 0) {
                byte[] bArr6 = new byte[g6];
                randomAccessFile.readFully(bArr6);
                str = d.a(bArr6, iVar.s(), charset);
            } else {
                str = null;
            }
            iVar.D(str);
            iVar.y(b(iVar.N(), iVar.j()));
            l(randomAccessFile, iVar);
            p(iVar, h0Var);
            g(iVar, h0Var);
            if (g7 > 0) {
                byte[] bArr7 = new byte[g7];
                randomAccessFile.readFully(bArr7);
                iVar.T(d.a(bArr7, iVar.s(), charset));
            }
            if (iVar.r()) {
                iVar.A(iVar.c() != null ? f5.e.AES : f5.e.ZIP_STANDARD);
            }
            arrayList.add(iVar);
            i8++;
            bArr = bArr5;
            bArr2 = bArr3;
            a6 = j6;
            i6 = 2;
            i7 = 0;
        }
        dVar.b(arrayList);
        e5.e eVar = new e5.e();
        c cVar2 = c.DIGITAL_SIGNATURE;
        if (h0Var.a(randomAccessFile) == cVar2.getValue()) {
            eVar.b(cVar2);
            eVar.e(h0Var.g(randomAccessFile));
            if (eVar.c() > 0) {
                byte[] bArr8 = new byte[eVar.c()];
                randomAccessFile.readFully(bArr8);
                eVar.d(new String(bArr8));
            }
        }
        return dVar;
    }

    private e5.f j(RandomAccessFile randomAccessFile, h0 h0Var, k kVar) {
        long c6 = c(randomAccessFile);
        r(randomAccessFile, 4 + c6);
        e5.f fVar = new e5.f();
        fVar.b(c.END_OF_CENTRAL_DIRECTORY);
        fVar.k(h0Var.g(randomAccessFile));
        fVar.l(h0Var.g(randomAccessFile));
        fVar.q(h0Var.g(randomAccessFile));
        fVar.p(h0Var.g(randomAccessFile));
        fVar.o(h0Var.a(randomAccessFile));
        fVar.m(c6);
        randomAccessFile.readFully(this.f3039c);
        fVar.n(h0Var.f(this.f3039c, 0));
        fVar.j(q(randomAccessFile, h0Var.g(randomAccessFile), kVar.b()));
        this.f3037a.l(fVar.d() > 0);
        return fVar;
    }

    private List k(RandomAccessFile randomAccessFile, int i6) {
        if (i6 < 4) {
            if (i6 > 0) {
                randomAccessFile.skipBytes(i6);
                return null;
            }
            return null;
        }
        byte[] bArr = new byte[i6];
        randomAccessFile.read(bArr);
        try {
            return e(bArr, i6);
        } catch (Exception unused) {
            return Collections.emptyList();
        }
    }

    private void l(RandomAccessFile randomAccessFile, i iVar) {
        int i6 = iVar.i();
        if (i6 <= 0) {
            return;
        }
        iVar.B(k(randomAccessFile, i6));
    }

    private m m(RandomAccessFile randomAccessFile, h0 h0Var) {
        if (this.f3037a.e() != null) {
            long d6 = this.f3037a.e().d();
            if (d6 >= 0) {
                randomAccessFile.seek(d6);
                m mVar = new m();
                long a6 = h0Var.a(randomAccessFile);
                c cVar = c.ZIP64_END_CENTRAL_DIRECTORY_RECORD;
                if (a6 == cVar.getValue()) {
                    mVar.b(cVar);
                    mVar.q(h0Var.d(randomAccessFile));
                    mVar.t(h0Var.g(randomAccessFile));
                    mVar.u(h0Var.g(randomAccessFile));
                    mVar.m(h0Var.a(randomAccessFile));
                    mVar.n(h0Var.a(randomAccessFile));
                    mVar.s(h0Var.d(randomAccessFile));
                    mVar.r(h0Var.d(randomAccessFile));
                    mVar.p(h0Var.d(randomAccessFile));
                    mVar.o(h0Var.d(randomAccessFile));
                    long g6 = mVar.g() - 44;
                    if (g6 > 0) {
                        byte[] bArr = new byte[(int) g6];
                        randomAccessFile.readFully(bArr);
                        mVar.l(bArr);
                    }
                    return mVar;
                }
                throw new a5.a("invalid signature for zip64 end of central directory record");
            }
            throw new a5.a("invalid offset for start of end of central directory record");
        }
        throw new a5.a("invalid zip64 end of central directory locator");
    }

    private l n(RandomAccessFile randomAccessFile, h0 h0Var, long j6) {
        l lVar = new l();
        s(randomAccessFile, j6);
        c cVar = c.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR;
        if (h0Var.a(randomAccessFile) != cVar.getValue()) {
            this.f3037a.p(false);
            return null;
        }
        this.f3037a.p(true);
        lVar.b(cVar);
        lVar.f(h0Var.a(randomAccessFile));
        lVar.g(h0Var.d(randomAccessFile));
        lVar.h(h0Var.a(randomAccessFile));
        return lVar;
    }

    private n o(List list, h0 h0Var, long j6, long j7, long j8, int i6) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (hVar != null && c.ZIP64_EXTRA_FIELD_SIGNATURE.getValue() == hVar.d()) {
                n nVar = new n();
                byte[] c6 = hVar.c();
                if (hVar.e() <= 0) {
                    return null;
                }
                int i7 = 0;
                if (hVar.e() > 0 && j6 == 4294967295L) {
                    nVar.j(h0Var.f(c6, 0));
                    i7 = 8;
                }
                if (i7 < hVar.e() && j7 == 4294967295L) {
                    nVar.g(h0Var.f(c6, i7));
                    i7 += 8;
                }
                if (i7 < hVar.e() && j8 == 4294967295L) {
                    nVar.i(h0Var.f(c6, i7));
                    i7 += 8;
                }
                if (i7 < hVar.e() && i6 == 65535) {
                    nVar.h(h0Var.c(c6, i7));
                }
                return nVar;
            }
        }
        return null;
    }

    private void p(i iVar, h0 h0Var) {
        n o5;
        if (iVar.h() == null || iVar.h().size() <= 0 || (o5 = o(iVar.h(), h0Var, iVar.n(), iVar.d(), iVar.P(), iVar.M())) == null) {
            return;
        }
        iVar.K(o5);
        if (o5.f() != -1) {
            iVar.I(o5.f());
        }
        if (o5.c() != -1) {
            iVar.u(o5.c());
        }
        if (o5.e() != -1) {
            iVar.W(o5.e());
        }
        if (o5.d() != -1) {
            iVar.R(o5.d());
        }
    }

    private String q(RandomAccessFile randomAccessFile, int i6, Charset charset) {
        if (i6 <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i6];
            randomAccessFile.readFully(bArr);
            if (charset == null) {
                charset = g0.f11040c;
            }
            return d.a(bArr, false, charset);
        } catch (IOException unused) {
            return null;
        }
    }

    private void r(RandomAccessFile randomAccessFile, long j6) {
        if (randomAccessFile instanceof c5.a) {
            ((c5.a) randomAccessFile).d(j6);
        } else {
            randomAccessFile.seek(j6);
        }
    }

    private void s(RandomAccessFile randomAccessFile, long j6) {
        r(randomAccessFile, (((j6 - 4) - 8) - 4) - 4);
    }

    public boolean b(byte[] bArr, String str) {
        byte b6 = bArr[0];
        if (b6 == 0 || !i5.a.a(b6, 4)) {
            byte b7 = bArr[3];
            if (b7 == 0 || !i5.a.a(b7, 6)) {
                if (str != null) {
                    return str.endsWith("/") || str.endsWith("\\");
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public p h(RandomAccessFile randomAccessFile, k kVar) {
        p pVar;
        boolean z5;
        if (randomAccessFile.length() >= 22) {
            p pVar2 = new p();
            this.f3037a = pVar2;
            try {
                pVar2.k(j(randomAccessFile, this.f3038b, kVar));
                if (this.f3037a.b().h() == 0) {
                    return this.f3037a;
                }
                p pVar3 = this.f3037a;
                pVar3.n(n(randomAccessFile, this.f3038b, pVar3.b().f()));
                if (this.f3037a.i()) {
                    this.f3037a.o(m(randomAccessFile, this.f3038b));
                    if (this.f3037a.f() == null || this.f3037a.f().c() <= 0) {
                        pVar = this.f3037a;
                        z5 = false;
                    } else {
                        pVar = this.f3037a;
                        z5 = true;
                    }
                    pVar.l(z5);
                }
                this.f3037a.j(i(randomAccessFile, this.f3038b, kVar.b()));
                return this.f3037a;
            } catch (a5.a e6) {
                throw e6;
            } catch (IOException e7) {
                e7.printStackTrace();
                throw new a5.a("Zip headers not found. Probably not a zip file or a corrupted zip file", e7);
            }
        }
        throw new a5.a("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
    }
}
