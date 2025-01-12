package b5;

import e5.i;
import e5.p;
import i5.g0;
import i5.i0;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public abstract class d {
    public static String a(byte[] bArr, boolean z5, Charset charset) {
        if (charset != null) {
            return new String(bArr, charset);
        }
        if (z5) {
            return new String(bArr, g0.f11039b);
        }
        try {
            return new String(bArr, "Cp437");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static byte[] b(String str, Charset charset) {
        return charset == null ? str.getBytes(g0.f11040c) : str.getBytes(charset);
    }

    public static i c(p pVar, String str) {
        i d6 = d(pVar, str);
        if (d6 == null) {
            String replaceAll = str.replaceAll("\\\\", "/");
            i d7 = d(pVar, replaceAll);
            return d7 == null ? d(pVar, replaceAll.replaceAll("/", "\\\\")) : d7;
        }
        return d6;
    }

    private static i d(p pVar, String str) {
        if (pVar == null) {
            throw new a5.a("zip model is null, cannot determine file header with exact match for fileName: " + str);
        } else if (!i0.d(str)) {
            throw new a5.a("file name is null, cannot determine file header with exact match for fileName: " + str);
        } else if (pVar.a() == null) {
            throw new a5.a("central directory is null, cannot determine file header with exact match for fileName: " + str);
        } else if (pVar.a().a() == null) {
            throw new a5.a("file Headers are null, cannot determine file header with exact match for fileName: " + str);
        } else if (pVar.a().a().size() == 0) {
            return null;
        } else {
            for (i iVar : pVar.a().a()) {
                String j6 = iVar.j();
                if (i0.d(j6) && str.equalsIgnoreCase(j6)) {
                    return iVar;
                }
            }
            return null;
        }
    }

    public static long e(p pVar) {
        return pVar.i() ? pVar.f().e() : pVar.b().g();
    }
}
