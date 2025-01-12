package q2;

import com.google.android.exoplayer2.util.s0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class p implements b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f12815a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12816b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f12817c;

    /* renamed from: d  reason: collision with root package name */
    private final a[] f12818d;

    /* renamed from: e  reason: collision with root package name */
    private int f12819e;

    /* renamed from: f  reason: collision with root package name */
    private int f12820f;

    /* renamed from: g  reason: collision with root package name */
    private int f12821g;

    /* renamed from: h  reason: collision with root package name */
    private a[] f12822h;

    public p(boolean z5, int i6) {
        this(z5, i6, 0);
    }

    @Override // q2.b
    public synchronized void a(a aVar) {
        a[] aVarArr = this.f12818d;
        aVarArr[0] = aVar;
        b(aVarArr);
    }

    @Override // q2.b
    public synchronized void b(a[] aVarArr) {
        int i6 = this.f12821g;
        int length = aVarArr.length + i6;
        a[] aVarArr2 = this.f12822h;
        if (length >= aVarArr2.length) {
            this.f12822h = (a[]) Arrays.copyOf(aVarArr2, Math.max(aVarArr2.length * 2, i6 + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            a[] aVarArr3 = this.f12822h;
            int i7 = this.f12821g;
            this.f12821g = i7 + 1;
            aVarArr3[i7] = aVar;
        }
        this.f12820f -= aVarArr.length;
        notifyAll();
    }

    @Override // q2.b
    public synchronized void c() {
        int i6 = 0;
        int max = Math.max(0, s0.l(this.f12819e, this.f12816b) - this.f12820f);
        int i7 = this.f12821g;
        if (max >= i7) {
            return;
        }
        if (this.f12817c != null) {
            int i8 = i7 - 1;
            while (i6 <= i8) {
                a aVar = (a) com.google.android.exoplayer2.util.a.e(this.f12822h[i6]);
                if (aVar.f12708a == this.f12817c) {
                    i6++;
                } else {
                    a aVar2 = (a) com.google.android.exoplayer2.util.a.e(this.f12822h[i8]);
                    if (aVar2.f12708a != this.f12817c) {
                        i8--;
                    } else {
                        a[] aVarArr = this.f12822h;
                        aVarArr[i6] = aVar2;
                        aVarArr[i8] = aVar;
                        i8--;
                        i6++;
                    }
                }
            }
            max = Math.max(max, i6);
            if (max >= this.f12821g) {
                return;
            }
        }
        Arrays.fill(this.f12822h, max, this.f12821g, (Object) null);
        this.f12821g = max;
    }

    @Override // q2.b
    public synchronized a d() {
        a aVar;
        this.f12820f++;
        int i6 = this.f12821g;
        if (i6 > 0) {
            a[] aVarArr = this.f12822h;
            int i7 = i6 - 1;
            this.f12821g = i7;
            aVar = (a) com.google.android.exoplayer2.util.a.e(aVarArr[i7]);
            this.f12822h[this.f12821g] = null;
        } else {
            aVar = new a(new byte[this.f12816b], 0);
        }
        return aVar;
    }

    @Override // q2.b
    public int e() {
        return this.f12816b;
    }

    public synchronized int f() {
        return this.f12820f * this.f12816b;
    }

    public synchronized void g() {
        if (this.f12815a) {
            h(0);
        }
    }

    public synchronized void h(int i6) {
        boolean z5 = i6 < this.f12819e;
        this.f12819e = i6;
        if (z5) {
            c();
        }
    }

    public p(boolean z5, int i6, int i7) {
        com.google.android.exoplayer2.util.a.a(i6 > 0);
        com.google.android.exoplayer2.util.a.a(i7 >= 0);
        this.f12815a = z5;
        this.f12816b = i6;
        this.f12821g = i7;
        this.f12822h = new a[i7 + 100];
        if (i7 > 0) {
            this.f12817c = new byte[i7 * i6];
            for (int i8 = 0; i8 < i7; i8++) {
                this.f12822h[i8] = new a(this.f12817c, i8 * i6);
            }
        } else {
            this.f12817c = null;
        }
        this.f12818d = new a[1];
    }
}
