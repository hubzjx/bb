package h5;

import d5.h;
import d5.k;
import e5.i;
import e5.p;
import e5.q;
import g5.a;
import h5.e;
import h5.f;
import i5.f0;
import i5.i0;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends e {

    /* renamed from: d  reason: collision with root package name */
    private final p f10775d;

    /* renamed from: e  reason: collision with root package name */
    private final char[] f10776e;

    /* renamed from: f  reason: collision with root package name */
    private final b5.e f10777f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(p pVar, char[] cArr, b5.e eVar, e.b bVar) {
        super(bVar);
        this.f10775d = pVar;
        this.f10776e = cArr;
        this.f10777f = eVar;
    }

    private void k(File file, k kVar, q qVar, h hVar, g5.a aVar, byte[] bArr) {
        kVar.h(qVar);
        if (file.exists() && !file.isDirectory()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    kVar.write(bArr, 0, read);
                    aVar.l(read);
                    j();
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            fileInputStream.close();
        }
        q(kVar, hVar, file, false);
    }

    private boolean m(q qVar) {
        return q.a.INCLUDE_LINK_ONLY.equals(qVar.n()) || q.a.INCLUDE_LINK_AND_LINKED_FILE.equals(qVar.n());
    }

    private void n(File file, k kVar, q qVar, h hVar) {
        q qVar2 = new q(qVar);
        qVar2.B(v(qVar.k(), file.getName()));
        qVar2.x(false);
        qVar2.w(f5.d.STORE);
        kVar.h(qVar2);
        kVar.write(f0.u(file).getBytes());
        q(kVar, hVar, file, true);
    }

    private q p(q qVar, File file, g5.a aVar) {
        q qVar2 = new q(qVar);
        qVar2.C(i0.c(file.lastModified()));
        if (file.isDirectory()) {
            qVar2.A(0L);
        } else {
            qVar2.A(file.length());
        }
        qVar2.D(false);
        qVar2.C(file.lastModified());
        if (!i0.d(qVar.k())) {
            qVar2.B(f0.l(file, qVar));
        }
        if (file.isDirectory()) {
            qVar2.w(f5.d.STORE);
            qVar2.y(f5.e.NONE);
            qVar2.x(false);
        } else {
            if (qVar2.o() && qVar2.f() == f5.e.ZIP_STANDARD) {
                aVar.g(a.c.CALCULATE_CRC);
                qVar2.z(i5.b.a(file, aVar));
                aVar.g(a.c.ADD_ENTRY);
            }
            if (file.length() == 0) {
                qVar2.w(f5.d.STORE);
            }
        }
        return qVar2;
    }

    private void q(k kVar, h hVar, File file, boolean z5) {
        i a6 = kVar.a();
        byte[] g6 = f0.g(file);
        if (!z5) {
            g6[3] = i5.a.c(g6[3], 5);
        }
        a6.S(g6);
        w(a6, hVar);
    }

    private List u(List list, q qVar, g5.a aVar, e5.k kVar) {
        ArrayList arrayList = new ArrayList(list);
        if (this.f10775d.g().exists()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (!i0.d(file.getName())) {
                    arrayList.remove(file);
                }
                i c6 = b5.d.c(this.f10775d, f0.l(file, qVar));
                if (c6 != null) {
                    if (qVar.q()) {
                        aVar.g(a.c.REMOVE_ENTRY);
                        t(c6, aVar, kVar);
                        j();
                        aVar.g(a.c.ADD_ENTRY);
                    } else {
                        arrayList.remove(file);
                    }
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    private String v(String str, String str2) {
        if (str.contains("/")) {
            return str.substring(0, str.lastIndexOf("/") + 1) + str2;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h5.e
    public a.c g() {
        return a.c.ADD_ENTRY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(List list, g5.a aVar, q qVar, e5.k kVar) {
        f0.b(list, qVar.n());
        byte[] bArr = new byte[kVar.a()];
        List<File> u5 = u(list, qVar, aVar, kVar);
        h hVar = new h(this.f10775d.g(), this.f10775d.d());
        try {
            k s5 = s(hVar, kVar);
            for (File file : u5) {
                j();
                q p5 = p(qVar, file, aVar);
                aVar.h(file.getAbsolutePath());
                if (f0.q(file) && m(p5)) {
                    n(file, s5, p5, hVar);
                    if (q.a.INCLUDE_LINK_ONLY.equals(p5.n())) {
                    }
                }
                k(file, s5, p5, hVar, aVar, bArr);
            }
            if (s5 != null) {
                s5.close();
            }
            hVar.close();
        } catch (Throwable th) {
            try {
                hVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long o(List list, q qVar) {
        Iterator it = list.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            File file = (File) it.next();
            if (file.exists()) {
                j6 += (qVar.o() && qVar.f() == f5.e.ZIP_STANDARD) ? file.length() * 2 : file.length();
                i c6 = b5.d.c(r(), f0.l(file, qVar));
                if (c6 != null) {
                    j6 += r().g().length() - c6.d();
                }
            }
        }
        return j6;
    }

    protected p r() {
        return this.f10775d;
    }

    k s(h hVar, e5.k kVar) {
        if (this.f10775d.g().exists()) {
            hVar.h(b5.d.e(this.f10775d));
        }
        return new k(hVar, this.f10776e, kVar, this.f10775d);
    }

    void t(i iVar, g5.a aVar, e5.k kVar) {
        new f(this.f10775d, this.f10777f, new e.b(null, false, aVar)).e(new f.a(Collections.singletonList(iVar.j()), kVar));
    }

    void w(i iVar, h hVar) {
        this.f10777f.k(iVar, r(), hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(q qVar) {
        if (qVar == null) {
            throw new a5.a("cannot validate zip parameters");
        }
        if (qVar.d() != f5.d.STORE && qVar.d() != f5.d.DEFLATE) {
            throw new a5.a("unsupported compression type");
        }
        if (!qVar.o()) {
            qVar.y(f5.e.NONE);
        } else if (qVar.f() == f5.e.NONE) {
            throw new a5.a("Encryption method has to be set, when encrypt files flag is set");
        } else {
            char[] cArr = this.f10776e;
            if (cArr == null || cArr.length <= 0) {
                throw new a5.a("input password is empty or null");
            }
        }
    }
}
