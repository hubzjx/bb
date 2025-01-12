package s3;
/* loaded from: classes.dex */
public final class f extends i {
    @Override // s3.i
    public b c(b bVar, int i6, int i7, k kVar) {
        if (i6 <= 0 || i7 <= 0) {
            throw com.google.zxing.k.getNotFoundInstance();
        }
        b bVar2 = new b(i6, i7);
        int i8 = i6 * 2;
        float[] fArr = new float[i8];
        for (int i9 = 0; i9 < i7; i9++) {
            float f6 = i9 + 0.5f;
            for (int i10 = 0; i10 < i8; i10 += 2) {
                fArr[i10] = (i10 / 2) + 0.5f;
                fArr[i10 + 1] = f6;
            }
            kVar.f(fArr);
            i.a(bVar, fArr);
            for (int i11 = 0; i11 < i8; i11 += 2) {
                try {
                    if (bVar.e((int) fArr[i11], (int) fArr[i11 + 1])) {
                        bVar2.j(i11 / 2, i9);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw com.google.zxing.k.getNotFoundInstance();
                }
            }
        }
        return bVar2;
    }
}
