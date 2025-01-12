package b5;

import e5.i;
import e5.j;
import e5.q;
import i5.f0;
import i5.g0;
import i5.h0;
import i5.i0;
import i5.j0;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class a {
    private int a(String str, Charset charset) {
        return d.b(str, charset).length;
    }

    private byte[] b(boolean z5, q qVar, Charset charset) {
        byte[] bArr = new byte[2];
        bArr[0] = e(z5, qVar);
        if (charset == null || g0.f11039b.equals(charset)) {
            bArr[1] = i5.a.b(bArr[1], 3);
        }
        return bArr;
    }

    private e5.a c(q qVar) {
        e5.a aVar = new e5.a();
        if (qVar.b() != null) {
            aVar.i(qVar.b());
        }
        f5.a a6 = qVar.a();
        f5.a aVar2 = f5.a.KEY_STRENGTH_128;
        if (a6 != aVar2) {
            f5.a a7 = qVar.a();
            aVar2 = f5.a.KEY_STRENGTH_192;
            if (a7 != aVar2) {
                f5.a a8 = qVar.a();
                aVar2 = f5.a.KEY_STRENGTH_256;
                if (a8 != aVar2) {
                    throw new a5.a("invalid AES key strength");
                }
            }
        }
        aVar.h(aVar2);
        aVar.j(qVar.d());
        return aVar;
    }

    private byte e(boolean z5, q qVar) {
        byte b6;
        byte b7;
        byte b8 = z5 ? i5.a.b((byte) 0, 0) : (byte) 0;
        if (f5.d.DEFLATE.equals(qVar.d())) {
            if (f5.c.NORMAL.equals(qVar.c())) {
                b7 = i5.a.c(b8, 1);
            } else if (f5.c.MAXIMUM.equals(qVar.c())) {
                b7 = i5.a.b(b8, 1);
            } else {
                if (f5.c.FAST.equals(qVar.c())) {
                    b6 = i5.a.c(b8, 1);
                } else if (f5.c.FASTEST.equals(qVar.c()) || f5.c.ULTRA.equals(qVar.c())) {
                    b6 = i5.a.b(b8, 1);
                }
                b8 = i5.a.b(b6, 2);
            }
            b8 = i5.a.c(b7, 2);
        }
        return qVar.u() ? i5.a.b(b8, 3) : b8;
    }

    private String g(String str) {
        if (i0.d(str)) {
            return str;
        }
        throw new a5.a("fileNameInZip is null or empty");
    }

    public i d(q qVar, boolean z5, int i6, Charset charset, h0 h0Var) {
        i iVar = new i();
        iVar.b(c.CENTRAL_DIRECTORY);
        iVar.X(j0.a(qVar, h0Var));
        iVar.J(j0.b(qVar).getCode());
        if (qVar.o() && qVar.f() == f5.e.AES) {
            iVar.v(f5.d.AES_INTERNAL_ONLY);
            iVar.t(c(qVar));
            iVar.C(iVar.i() + 11);
        } else {
            iVar.v(qVar.d());
        }
        if (qVar.o()) {
            if (qVar.f() == null || qVar.f() == f5.e.NONE) {
                throw new a5.a("Encryption method has to be set when encryptFiles flag is set in zip parameters");
            }
            iVar.z(true);
            iVar.A(qVar.f());
        }
        String g6 = g(qVar.k());
        iVar.D(g6);
        iVar.E(a(g6, charset));
        if (!z5) {
            i6 = 0;
        }
        iVar.R(i6);
        iVar.H(i0.c(qVar.l() > 0 ? qVar.l() : System.currentTimeMillis()));
        boolean t5 = f0.t(g6);
        iVar.y(t5);
        iVar.S(f0.f(t5));
        if (qVar.u() && qVar.h() == -1) {
            iVar.I(0L);
        } else {
            iVar.I(qVar.h());
        }
        if (qVar.o() && qVar.f() == f5.e.ZIP_STANDARD) {
            iVar.w(qVar.g());
        }
        iVar.G(b(iVar.r(), qVar, charset));
        iVar.x(qVar.u());
        iVar.T(qVar.j());
        return iVar;
    }

    public j f(i iVar) {
        j jVar = new j();
        jVar.b(c.LOCAL_FILE_HEADER);
        jVar.J(iVar.o());
        jVar.v(iVar.e());
        jVar.H(iVar.m());
        jVar.I(iVar.n());
        jVar.E(iVar.k());
        jVar.D(iVar.j());
        jVar.z(iVar.r());
        jVar.A(iVar.g());
        jVar.t(iVar.c());
        jVar.w(iVar.f());
        jVar.u(iVar.d());
        jVar.G((byte[]) iVar.l().clone());
        jVar.x(iVar.q());
        jVar.C(iVar.i());
        return jVar;
    }
}
