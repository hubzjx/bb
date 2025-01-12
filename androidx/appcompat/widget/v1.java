package androidx.appcompat.widget;
/* loaded from: classes.dex */
class v1 {

    /* renamed from: a  reason: collision with root package name */
    private int f1085a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1086b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1087c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f1088d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f1089e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1090f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1091g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1092h = false;

    public int a() {
        return this.f1091g ? this.f1085a : this.f1086b;
    }

    public int b() {
        return this.f1085a;
    }

    public int c() {
        return this.f1086b;
    }

    public int d() {
        return this.f1091g ? this.f1086b : this.f1085a;
    }

    public void e(int i6, int i7) {
        this.f1092h = false;
        if (i6 != Integer.MIN_VALUE) {
            this.f1089e = i6;
            this.f1085a = i6;
        }
        if (i7 != Integer.MIN_VALUE) {
            this.f1090f = i7;
            this.f1086b = i7;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:
        if (r2 != Integer.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0028, code lost:
        if (r2 != Integer.MIN_VALUE) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(boolean z5) {
        int i6;
        if (z5 == this.f1091g) {
            return;
        }
        this.f1091g = z5;
        if (!this.f1092h) {
            this.f1085a = this.f1089e;
        } else if (z5) {
            int i7 = this.f1088d;
            if (i7 == Integer.MIN_VALUE) {
                i7 = this.f1089e;
            }
            this.f1085a = i7;
            i6 = this.f1087c;
        } else {
            int i8 = this.f1087c;
            if (i8 == Integer.MIN_VALUE) {
                i8 = this.f1089e;
            }
            this.f1085a = i8;
            i6 = this.f1088d;
        }
        i6 = this.f1090f;
        this.f1086b = i6;
    }

    public void g(int i6, int i7) {
        this.f1087c = i6;
        this.f1088d = i7;
        this.f1092h = true;
        if (this.f1091g) {
            if (i7 != Integer.MIN_VALUE) {
                this.f1085a = i7;
            }
            if (i6 != Integer.MIN_VALUE) {
                this.f1086b = i6;
                return;
            }
            return;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f1085a = i6;
        }
        if (i7 != Integer.MIN_VALUE) {
            this.f1086b = i7;
        }
    }
}
