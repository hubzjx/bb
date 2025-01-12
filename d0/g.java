package d0;
/* loaded from: classes.dex */
public class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f9113a;

    /* renamed from: b  reason: collision with root package name */
    private int f9114b;

    public g(int i6) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f9113a = new Object[i6];
    }

    private boolean c(Object obj) {
        for (int i6 = 0; i6 < this.f9114b; i6++) {
            if (this.f9113a[i6] == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // d0.f
    public boolean a(Object obj) {
        if (c(obj)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i6 = this.f9114b;
        Object[] objArr = this.f9113a;
        if (i6 < objArr.length) {
            objArr[i6] = obj;
            this.f9114b = i6 + 1;
            return true;
        }
        return false;
    }

    @Override // d0.f
    public Object b() {
        int i6 = this.f9114b;
        if (i6 > 0) {
            int i7 = i6 - 1;
            Object[] objArr = this.f9113a;
            Object obj = objArr[i7];
            objArr[i7] = null;
            this.f9114b = i6 - 1;
            return obj;
        }
        return null;
    }
}
