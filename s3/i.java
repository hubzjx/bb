package s3;
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static i f13287a = new f();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(b bVar, float[] fArr) {
        int i6 = bVar.i();
        int g6 = bVar.g();
        boolean z5 = true;
        for (int i7 = 0; i7 < fArr.length && z5; i7 += 2) {
            int i8 = (int) fArr[i7];
            int i9 = i7 + 1;
            int i10 = (int) fArr[i9];
            if (i8 < -1 || i8 > i6 || i10 < -1 || i10 > g6) {
                throw com.google.zxing.k.getNotFoundInstance();
            }
            if (i8 == -1) {
                fArr[i7] = 0.0f;
            } else if (i8 == i6) {
                fArr[i7] = i6 - 1;
            } else {
                z5 = false;
                if (i10 != -1) {
                    fArr[i9] = 0.0f;
                } else if (i10 == g6) {
                    fArr[i9] = g6 - 1;
                }
                z5 = true;
            }
            z5 = true;
            if (i10 != -1) {
            }
            z5 = true;
        }
        boolean z6 = true;
        for (int length = fArr.length - 2; length >= 0 && z6; length -= 2) {
            int i11 = (int) fArr[length];
            int i12 = length + 1;
            int i13 = (int) fArr[i12];
            if (i11 < -1 || i11 > i6 || i13 < -1 || i13 > g6) {
                throw com.google.zxing.k.getNotFoundInstance();
            }
            if (i11 == -1) {
                fArr[length] = 0.0f;
            } else if (i11 == i6) {
                fArr[length] = i6 - 1;
            } else {
                z6 = false;
                if (i13 != -1) {
                    fArr[i12] = 0.0f;
                } else if (i13 == g6) {
                    fArr[i12] = g6 - 1;
                }
                z6 = true;
            }
            z6 = true;
            if (i13 != -1) {
            }
            z6 = true;
        }
    }

    public static i b() {
        return f13287a;
    }

    public abstract b c(b bVar, int i6, int i7, k kVar);
}
