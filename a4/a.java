package a4;

import com.google.zxing.c;
import com.google.zxing.k;
import com.google.zxing.n;
import com.google.zxing.o;
import com.google.zxing.p;
import com.google.zxing.qrcode.decoder.e;
import com.google.zxing.qrcode.decoder.i;
import java.util.List;
import java.util.Map;
import s3.g;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static final p[] f130b = new p[0];

    /* renamed from: a  reason: collision with root package name */
    private final e f131a = new e();

    private static s3.b c(s3.b bVar) {
        int[] h6 = bVar.h();
        int[] f6 = bVar.f();
        if (h6 == null || f6 == null) {
            throw k.getNotFoundInstance();
        }
        float d6 = d(h6, bVar);
        int i6 = h6[1];
        int i7 = f6[1];
        int i8 = h6[0];
        int i9 = f6[0];
        if (i8 >= i9 || i6 >= i7) {
            throw k.getNotFoundInstance();
        }
        int i10 = i7 - i6;
        if (i10 == i9 - i8 || (i9 = i8 + i10) < bVar.i()) {
            int round = Math.round(((i9 - i8) + 1) / d6);
            int round2 = Math.round((i10 + 1) / d6);
            if (round <= 0 || round2 <= 0) {
                throw k.getNotFoundInstance();
            }
            if (round2 == round) {
                int i11 = (int) (d6 / 2.0f);
                int i12 = i6 + i11;
                int i13 = i8 + i11;
                int i14 = (((int) ((round - 1) * d6)) + i13) - i9;
                if (i14 > 0) {
                    if (i14 > i11) {
                        throw k.getNotFoundInstance();
                    }
                    i13 -= i14;
                }
                int i15 = (((int) ((round2 - 1) * d6)) + i12) - i7;
                if (i15 > 0) {
                    if (i15 > i11) {
                        throw k.getNotFoundInstance();
                    }
                    i12 -= i15;
                }
                s3.b bVar2 = new s3.b(round, round2);
                for (int i16 = 0; i16 < round2; i16++) {
                    int i17 = ((int) (i16 * d6)) + i12;
                    for (int i18 = 0; i18 < round; i18++) {
                        if (bVar.e(((int) (i18 * d6)) + i13, i17)) {
                            bVar2.j(i18, i16);
                        }
                    }
                }
                return bVar2;
            }
            throw k.getNotFoundInstance();
        }
        throw k.getNotFoundInstance();
    }

    private static float d(int[] iArr, s3.b bVar) {
        int g6 = bVar.g();
        int i6 = bVar.i();
        int i7 = iArr[0];
        boolean z5 = true;
        int i8 = iArr[1];
        int i9 = 0;
        while (i7 < i6 && i8 < g6) {
            if (z5 != bVar.e(i7, i8)) {
                i9++;
                if (i9 == 5) {
                    break;
                }
                z5 = !z5;
            }
            i7++;
            i8++;
        }
        if (i7 == i6 || i8 == g6) {
            throw k.getNotFoundInstance();
        }
        return (i7 - iArr[0]) / 7.0f;
    }

    public n a(c cVar) {
        return b(cVar, null);
    }

    public final n b(c cVar, Map map) {
        p[] b6;
        s3.e eVar;
        if (map == null || !map.containsKey(com.google.zxing.e.PURE_BARCODE)) {
            g e6 = new com.google.zxing.qrcode.detector.c(cVar.a()).e(map);
            s3.e c6 = this.f131a.c(e6.a(), map);
            b6 = e6.b();
            eVar = c6;
        } else {
            eVar = this.f131a.c(c(cVar.a()), map);
            b6 = f130b;
        }
        if (eVar.c() instanceof i) {
            ((i) eVar.c()).a(b6);
        }
        n nVar = new n(eVar.g(), eVar.d(), b6, com.google.zxing.a.QR_CODE);
        List a6 = eVar.a();
        if (a6 != null) {
            nVar.b(o.BYTE_SEGMENTS, a6);
        }
        String b7 = eVar.b();
        if (b7 != null) {
            nVar.b(o.ERROR_CORRECTION_LEVEL, b7);
        }
        if (eVar.h()) {
            nVar.b(o.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVar.f()));
            nVar.b(o.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVar.e()));
        }
        return nVar;
    }
}
