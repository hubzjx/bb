package o;
/* loaded from: classes.dex */
class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f12299a;

    /* renamed from: b  reason: collision with root package name */
    private int f12300b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i6) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f12299a = new Object[i6];
    }

    @Override // o.f
    public boolean a(Object obj) {
        int i6 = this.f12300b;
        Object[] objArr = this.f12299a;
        if (i6 < objArr.length) {
            objArr[i6] = obj;
            this.f12300b = i6 + 1;
            return true;
        }
        return false;
    }

    @Override // o.f
    public Object b() {
        int i6 = this.f12300b;
        if (i6 > 0) {
            int i7 = i6 - 1;
            Object[] objArr = this.f12299a;
            Object obj = objArr[i7];
            objArr[i7] = null;
            this.f12300b = i6 - 1;
            return obj;
        }
        return null;
    }

    @Override // o.f
    public void c(Object[] objArr, int i6) {
        if (i6 > objArr.length) {
            i6 = objArr.length;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            Object obj = objArr[i7];
            int i8 = this.f12300b;
            Object[] objArr2 = this.f12299a;
            if (i8 < objArr2.length) {
                objArr2[i8] = obj;
                this.f12300b = i8 + 1;
            }
        }
    }
}
