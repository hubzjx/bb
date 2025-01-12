package c1;
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f3160a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3161b;

    /* renamed from: c  reason: collision with root package name */
    private int f3162c;

    /* renamed from: d  reason: collision with root package name */
    private int f3163d;

    public b0(byte[] bArr) {
        this.f3160a = bArr;
        this.f3161b = bArr.length;
    }

    private void a() {
        int i6;
        int i7 = this.f3162c;
        com.google.android.exoplayer2.util.a.g(i7 >= 0 && (i7 < (i6 = this.f3161b) || (i7 == i6 && this.f3163d == 0)));
    }

    public int b() {
        return (this.f3162c * 8) + this.f3163d;
    }

    public boolean c() {
        boolean z5 = (((this.f3160a[this.f3162c] & 255) >> this.f3163d) & 1) == 1;
        e(1);
        return z5;
    }

    public int d(int i6) {
        int i7 = this.f3162c;
        int min = Math.min(i6, 8 - this.f3163d);
        int i8 = i7 + 1;
        int i9 = ((this.f3160a[i7] & 255) >> this.f3163d) & (255 >> (8 - min));
        while (min < i6) {
            i9 |= (this.f3160a[i8] & 255) << min;
            min += 8;
            i8++;
        }
        int i10 = i9 & ((-1) >>> (32 - i6));
        e(i6);
        return i10;
    }

    public void e(int i6) {
        int i7 = i6 / 8;
        int i8 = this.f3162c + i7;
        this.f3162c = i8;
        int i9 = this.f3163d + (i6 - (i7 * 8));
        this.f3163d = i9;
        if (i9 > 7) {
            this.f3162c = i8 + 1;
            this.f3163d = i9 - 8;
        }
        a();
    }
}
