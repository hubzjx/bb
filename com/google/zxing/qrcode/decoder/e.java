package com.google.zxing.qrcode.decoder;

import java.util.Map;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final u3.c f5858a = new u3.c(u3.a.f13609l);

    private void a(byte[] bArr, int i6) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = bArr[i7] & 255;
        }
        try {
            this.f5858a.a(iArr, bArr.length - i6);
            for (int i8 = 0; i8 < i6; i8++) {
                bArr[i8] = (byte) iArr[i8];
            }
        } catch (u3.e unused) {
            throw com.google.zxing.d.getChecksumInstance();
        }
    }

    private s3.e b(a aVar, Map map) {
        j e6 = aVar.e();
        f d6 = aVar.d().d();
        b[] b6 = b.b(aVar.c(), e6, d6);
        int i6 = 0;
        for (b bVar : b6) {
            i6 += bVar.c();
        }
        byte[] bArr = new byte[i6];
        int i7 = 0;
        for (b bVar2 : b6) {
            byte[] a6 = bVar2.a();
            int c6 = bVar2.c();
            a(a6, c6);
            int i8 = 0;
            while (i8 < c6) {
                bArr[i7] = a6[i8];
                i8++;
                i7++;
            }
        }
        return d.a(bArr, e6, d6, map);
    }

    public s3.e c(s3.b bVar, Map map) {
        com.google.zxing.d e6;
        a aVar = new a(bVar);
        com.google.zxing.h hVar = null;
        try {
            return b(aVar, map);
        } catch (com.google.zxing.d e7) {
            e6 = e7;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                s3.e b6 = b(aVar, map);
                b6.i(new i(true));
                return b6;
            } catch (com.google.zxing.d | com.google.zxing.h e8) {
                if (hVar == null) {
                    if (e6 != null) {
                        throw e6;
                    }
                    throw e8;
                }
                throw hVar;
            }
        } catch (com.google.zxing.h e9) {
            e6 = null;
            hVar = e9;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            s3.e b62 = b(aVar, map);
            b62.i(new i(true));
            return b62;
        }
    }
}
