package c1;
/* loaded from: classes.dex */
abstract class l {
    public static int a(j jVar, byte[] bArr, int i6, int i7) {
        int i8 = 0;
        while (i8 < i7) {
            int e6 = jVar.e(bArr, i6 + i8, i7 - i8);
            if (e6 == -1) {
                break;
            }
            i8 += e6;
        }
        return i8;
    }
}
