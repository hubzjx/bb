package i5;
/* loaded from: classes.dex */
public abstract class j0 {
    public static int a(e5.q qVar, h0 h0Var) {
        byte[] bArr = {b5.f.SPECIFICATION_VERSION.getCode(), b5.f.UNIX.getCode()};
        if (f0.s() && !qVar.t()) {
            bArr[1] = b5.f.WINDOWS.getCode();
        }
        return h0Var.h(bArr, 0);
    }

    public static b5.g b(e5.q qVar) {
        b5.g gVar = b5.g.DEFAULT;
        if (qVar.d() == f5.d.DEFLATE) {
            gVar = b5.g.DEFLATE_COMPRESSED;
        }
        if (qVar.h() > 4294967295L) {
            gVar = b5.g.ZIP_64_FORMAT;
        }
        return (qVar.o() && qVar.f().equals(f5.e.AES)) ? b5.g.AES_ENCRYPTED : gVar;
    }
}
