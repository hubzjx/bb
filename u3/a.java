package u3;

import okio.Segment;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: h  reason: collision with root package name */
    public static final a f13605h = new a(4201, _BufferKt.SEGMENTING_THRESHOLD, 1);

    /* renamed from: i  reason: collision with root package name */
    public static final a f13606i = new a(1033, Segment.SHARE_MINIMUM, 1);

    /* renamed from: j  reason: collision with root package name */
    public static final a f13607j;

    /* renamed from: k  reason: collision with root package name */
    public static final a f13608k;

    /* renamed from: l  reason: collision with root package name */
    public static final a f13609l;

    /* renamed from: m  reason: collision with root package name */
    public static final a f13610m;

    /* renamed from: n  reason: collision with root package name */
    public static final a f13611n;

    /* renamed from: o  reason: collision with root package name */
    public static final a f13612o;

    /* renamed from: a  reason: collision with root package name */
    private final int[] f13613a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f13614b;

    /* renamed from: c  reason: collision with root package name */
    private final b f13615c;

    /* renamed from: d  reason: collision with root package name */
    private final b f13616d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13617e;

    /* renamed from: f  reason: collision with root package name */
    private final int f13618f;

    /* renamed from: g  reason: collision with root package name */
    private final int f13619g;

    static {
        a aVar = new a(67, 64, 1);
        f13607j = aVar;
        f13608k = new a(19, 16, 1);
        f13609l = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f13610m = aVar2;
        f13611n = aVar2;
        f13612o = aVar;
    }

    public a(int i6, int i7, int i8) {
        this.f13618f = i6;
        this.f13617e = i7;
        this.f13619g = i8;
        this.f13613a = new int[i7];
        this.f13614b = new int[i7];
        int i9 = 1;
        for (int i10 = 0; i10 < i7; i10++) {
            this.f13613a[i10] = i9;
            i9 <<= 1;
            if (i9 >= i7) {
                i9 = (i9 ^ i6) & (i7 - 1);
            }
        }
        for (int i11 = 0; i11 < i7 - 1; i11++) {
            this.f13614b[this.f13613a[i11]] = i11;
        }
        this.f13615c = new b(this, new int[]{0});
        this.f13616d = new b(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i6, int i7) {
        return i6 ^ i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b(int i6, int i7) {
        if (i6 >= 0) {
            if (i7 == 0) {
                return this.f13615c;
            }
            int[] iArr = new int[i6 + 1];
            iArr[0] = i7;
            return new b(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i6) {
        return this.f13613a[i6];
    }

    public int d() {
        return this.f13619g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e() {
        return this.f13616d;
    }

    public int f() {
        return this.f13617e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b g() {
        return this.f13615c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(int i6) {
        if (i6 != 0) {
            return this.f13613a[(this.f13617e - this.f13614b[i6]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i6) {
        if (i6 != 0) {
            return this.f13614b[i6];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(int i6, int i7) {
        if (i6 == 0 || i7 == 0) {
            return 0;
        }
        int[] iArr = this.f13613a;
        int[] iArr2 = this.f13614b;
        return iArr[(iArr2[i6] + iArr2[i7]) % (this.f13617e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f13618f) + ',' + this.f13617e + ')';
    }
}
