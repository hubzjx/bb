package z3;
/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f14359a;

    /* renamed from: b  reason: collision with root package name */
    private int f14360b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i6) {
        this.f14359a = new byte[i6];
    }

    private void c(int i6, boolean z5) {
        this.f14359a[i6] = z5 ? (byte) 1 : (byte) 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = this.f14360b;
            this.f14360b = i8 + 1;
            c(i8, z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b(int i6) {
        int length = this.f14359a.length * i6;
        byte[] bArr = new byte[length];
        for (int i7 = 0; i7 < length; i7++) {
            bArr[i7] = this.f14359a[i7 / i6];
        }
        return bArr;
    }
}
