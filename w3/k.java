package w3;
/* loaded from: classes.dex */
public class k {

    /* renamed from: i  reason: collision with root package name */
    static final k[] f14122i;

    /* renamed from: j  reason: collision with root package name */
    private static k[] f14123j;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f14124a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14125b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14126c;

    /* renamed from: d  reason: collision with root package name */
    public final int f14127d;

    /* renamed from: e  reason: collision with root package name */
    public final int f14128e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14129f;

    /* renamed from: g  reason: collision with root package name */
    private final int f14130g;

    /* renamed from: h  reason: collision with root package name */
    private final int f14131h;

    static {
        k[] kVarArr = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, b.j.D0, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, 174, 68, 22, 22, 4), new k(false, 204, 84, 24, 24, 4, androidx.constraintlayout.widget.g.U0, 42), new k(false, 280, 112, 14, 14, 16, 140, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, 192, 18, 18, 16, b.j.D0, 48), new k(false, 576, 224, 20, 20, 16, 144, 56), new k(false, 696, 272, 22, 22, 16, 174, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, 1050, 408, 18, 18, 36, 175, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        f14122i = kVarArr;
        f14123j = kVarArr;
    }

    public k(boolean z5, int i6, int i7, int i8, int i9, int i10) {
        this(z5, i6, i7, i8, i9, i10, i6, i7);
    }

    private int e() {
        int i6 = this.f14129f;
        int i7 = 1;
        if (i6 != 1) {
            i7 = 2;
            if (i6 != 2 && i6 != 4) {
                if (i6 != 16) {
                    if (i6 == 36) {
                        return 6;
                    }
                    throw new IllegalStateException("Cannot handle this number of data regions");
                }
                return 4;
            }
        }
        return i7;
    }

    private int k() {
        int i6 = this.f14129f;
        if (i6 == 1 || i6 == 2) {
            return 1;
        }
        if (i6 != 4) {
            if (i6 != 16) {
                if (i6 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
            return 4;
        }
        return 2;
    }

    public static k l(int i6, l lVar, com.google.zxing.f fVar, com.google.zxing.f fVar2, boolean z5) {
        k[] kVarArr;
        for (k kVar : f14123j) {
            if (!(lVar == l.FORCE_SQUARE && kVar.f14124a) && ((lVar != l.FORCE_RECTANGLE || kVar.f14124a) && i6 <= kVar.f14125b)) {
                return kVar;
            }
        }
        if (z5) {
            throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i6);
        }
        return null;
    }

    public final int a() {
        return this.f14125b;
    }

    public int b(int i6) {
        return this.f14130g;
    }

    public final int c() {
        return this.f14126c;
    }

    public final int d(int i6) {
        return this.f14131h;
    }

    public int f() {
        return this.f14125b / this.f14130g;
    }

    public final int g() {
        return k() * this.f14128e;
    }

    public final int h() {
        return e() * this.f14127d;
    }

    public final int i() {
        return g() + (k() << 1);
    }

    public final int j() {
        return h() + (e() << 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14124a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f14127d);
        sb.append('x');
        sb.append(this.f14128e);
        sb.append(", symbol size ");
        sb.append(j());
        sb.append('x');
        sb.append(i());
        sb.append(", symbol data size ");
        sb.append(h());
        sb.append('x');
        sb.append(g());
        sb.append(", codewords ");
        sb.append(this.f14125b);
        sb.append('+');
        sb.append(this.f14126c);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(boolean z5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.f14124a = z5;
        this.f14125b = i6;
        this.f14126c = i7;
        this.f14127d = i8;
        this.f14128e = i9;
        this.f14129f = i10;
        this.f14130g = i11;
        this.f14131h = i12;
    }
}
