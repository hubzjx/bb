package l2;

import android.text.Layout;
/* loaded from: classes.dex */
final class f {

    /* renamed from: a  reason: collision with root package name */
    private String f11819a;

    /* renamed from: b  reason: collision with root package name */
    private int f11820b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11821c;

    /* renamed from: d  reason: collision with root package name */
    private int f11822d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11823e;

    /* renamed from: k  reason: collision with root package name */
    private float f11829k;

    /* renamed from: l  reason: collision with root package name */
    private String f11830l;

    /* renamed from: o  reason: collision with root package name */
    private Layout.Alignment f11833o;

    /* renamed from: f  reason: collision with root package name */
    private int f11824f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f11825g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f11826h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f11827i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f11828j = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f11831m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f11832n = -1;

    /* renamed from: p  reason: collision with root package name */
    private int f11834p = -1;

    private f o(f fVar, boolean z5) {
        int i6;
        Layout.Alignment alignment;
        String str;
        if (fVar != null) {
            if (!this.f11821c && fVar.f11821c) {
                t(fVar.f11820b);
            }
            if (this.f11826h == -1) {
                this.f11826h = fVar.f11826h;
            }
            if (this.f11827i == -1) {
                this.f11827i = fVar.f11827i;
            }
            if (this.f11819a == null && (str = fVar.f11819a) != null) {
                this.f11819a = str;
            }
            if (this.f11824f == -1) {
                this.f11824f = fVar.f11824f;
            }
            if (this.f11825g == -1) {
                this.f11825g = fVar.f11825g;
            }
            if (this.f11832n == -1) {
                this.f11832n = fVar.f11832n;
            }
            if (this.f11833o == null && (alignment = fVar.f11833o) != null) {
                this.f11833o = alignment;
            }
            if (this.f11834p == -1) {
                this.f11834p = fVar.f11834p;
            }
            if (this.f11828j == -1) {
                this.f11828j = fVar.f11828j;
                this.f11829k = fVar.f11829k;
            }
            if (z5 && !this.f11823e && fVar.f11823e) {
                r(fVar.f11822d);
            }
            if (z5 && this.f11831m == -1 && (i6 = fVar.f11831m) != -1) {
                this.f11831m = i6;
            }
        }
        return this;
    }

    public f A(int i6) {
        this.f11832n = i6;
        return this;
    }

    public f B(int i6) {
        this.f11831m = i6;
        return this;
    }

    public f C(Layout.Alignment alignment) {
        this.f11833o = alignment;
        return this;
    }

    public f D(boolean z5) {
        this.f11834p = z5 ? 1 : 0;
        return this;
    }

    public f E(boolean z5) {
        this.f11825g = z5 ? 1 : 0;
        return this;
    }

    public f a(f fVar) {
        return o(fVar, true);
    }

    public int b() {
        if (this.f11823e) {
            return this.f11822d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f11821c) {
            return this.f11820b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String d() {
        return this.f11819a;
    }

    public float e() {
        return this.f11829k;
    }

    public int f() {
        return this.f11828j;
    }

    public String g() {
        return this.f11830l;
    }

    public int h() {
        return this.f11832n;
    }

    public int i() {
        return this.f11831m;
    }

    public int j() {
        int i6 = this.f11826h;
        if (i6 == -1 && this.f11827i == -1) {
            return -1;
        }
        return (i6 == 1 ? 1 : 0) | (this.f11827i == 1 ? 2 : 0);
    }

    public Layout.Alignment k() {
        return this.f11833o;
    }

    public boolean l() {
        return this.f11834p == 1;
    }

    public boolean m() {
        return this.f11823e;
    }

    public boolean n() {
        return this.f11821c;
    }

    public boolean p() {
        return this.f11824f == 1;
    }

    public boolean q() {
        return this.f11825g == 1;
    }

    public f r(int i6) {
        this.f11822d = i6;
        this.f11823e = true;
        return this;
    }

    public f s(boolean z5) {
        this.f11826h = z5 ? 1 : 0;
        return this;
    }

    public f t(int i6) {
        this.f11820b = i6;
        this.f11821c = true;
        return this;
    }

    public f u(String str) {
        this.f11819a = str;
        return this;
    }

    public f v(float f6) {
        this.f11829k = f6;
        return this;
    }

    public f w(int i6) {
        this.f11828j = i6;
        return this;
    }

    public f x(String str) {
        this.f11830l = str;
        return this;
    }

    public f y(boolean z5) {
        this.f11827i = z5 ? 1 : 0;
        return this;
    }

    public f z(boolean z5) {
        this.f11824f = z5 ? 1 : 0;
        return this;
    }
}
