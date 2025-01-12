package o;

import java.util.Arrays;
import o.b;
/* loaded from: classes.dex */
public class j implements b.a {

    /* renamed from: n  reason: collision with root package name */
    private static float f12326n = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    private final int f12327a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f12328b = 16;

    /* renamed from: c  reason: collision with root package name */
    private int f12329c = 16;

    /* renamed from: d  reason: collision with root package name */
    int[] f12330d = new int[16];

    /* renamed from: e  reason: collision with root package name */
    int[] f12331e = new int[16];

    /* renamed from: f  reason: collision with root package name */
    int[] f12332f = new int[16];

    /* renamed from: g  reason: collision with root package name */
    float[] f12333g = new float[16];

    /* renamed from: h  reason: collision with root package name */
    int[] f12334h = new int[16];

    /* renamed from: i  reason: collision with root package name */
    int[] f12335i = new int[16];

    /* renamed from: j  reason: collision with root package name */
    int f12336j = 0;

    /* renamed from: k  reason: collision with root package name */
    int f12337k = -1;

    /* renamed from: l  reason: collision with root package name */
    private final b f12338l;

    /* renamed from: m  reason: collision with root package name */
    protected final c f12339m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar, c cVar) {
        this.f12338l = bVar;
        this.f12339m = cVar;
        clear();
    }

    private void l(i iVar, int i6) {
        int[] iArr;
        int i7 = iVar.f12314c % this.f12329c;
        int[] iArr2 = this.f12330d;
        int i8 = iArr2[i7];
        if (i8 == -1) {
            iArr2[i7] = i6;
        } else {
            while (true) {
                iArr = this.f12331e;
                int i9 = iArr[i8];
                if (i9 == -1) {
                    break;
                }
                i8 = i9;
            }
            iArr[i8] = i6;
        }
        this.f12331e[i6] = -1;
    }

    private void m(int i6, i iVar, float f6) {
        this.f12332f[i6] = iVar.f12314c;
        this.f12333g[i6] = f6;
        this.f12334h[i6] = -1;
        this.f12335i[i6] = -1;
        iVar.a(this.f12338l);
        iVar.f12324m++;
        this.f12336j++;
    }

    private int n() {
        for (int i6 = 0; i6 < this.f12328b; i6++) {
            if (this.f12332f[i6] == -1) {
                return i6;
            }
        }
        return -1;
    }

    private void o() {
        int i6 = this.f12328b * 2;
        this.f12332f = Arrays.copyOf(this.f12332f, i6);
        this.f12333g = Arrays.copyOf(this.f12333g, i6);
        this.f12334h = Arrays.copyOf(this.f12334h, i6);
        this.f12335i = Arrays.copyOf(this.f12335i, i6);
        this.f12331e = Arrays.copyOf(this.f12331e, i6);
        for (int i7 = this.f12328b; i7 < i6; i7++) {
            this.f12332f[i7] = -1;
            this.f12331e[i7] = -1;
        }
        this.f12328b = i6;
    }

    private void q(int i6, i iVar, float f6) {
        int n5 = n();
        m(n5, iVar, f6);
        if (i6 != -1) {
            this.f12334h[n5] = i6;
            int[] iArr = this.f12335i;
            iArr[n5] = iArr[i6];
            iArr[i6] = n5;
        } else {
            this.f12334h[n5] = -1;
            if (this.f12336j > 0) {
                this.f12335i[n5] = this.f12337k;
                this.f12337k = n5;
            } else {
                this.f12335i[n5] = -1;
            }
        }
        int i7 = this.f12335i[n5];
        if (i7 != -1) {
            this.f12334h[i7] = n5;
        }
        l(iVar, n5);
    }

    private void r(i iVar) {
        int[] iArr;
        int i6;
        int i7 = iVar.f12314c;
        int i8 = i7 % this.f12329c;
        int[] iArr2 = this.f12330d;
        int i9 = iArr2[i8];
        if (i9 == -1) {
            return;
        }
        if (this.f12332f[i9] == i7) {
            int[] iArr3 = this.f12331e;
            iArr2[i8] = iArr3[i9];
            iArr3[i9] = -1;
            return;
        }
        while (true) {
            iArr = this.f12331e;
            i6 = iArr[i9];
            if (i6 == -1 || this.f12332f[i6] == i7) {
                break;
            }
            i9 = i6;
        }
        if (i6 == -1 || this.f12332f[i6] != i7) {
            return;
        }
        iArr[i9] = iArr[i6];
        iArr[i6] = -1;
    }

    @Override // o.b.a
    public float a(int i6) {
        int i7 = this.f12336j;
        int i8 = this.f12337k;
        for (int i9 = 0; i9 < i7; i9++) {
            if (i9 == i6) {
                return this.f12333g[i8];
            }
            i8 = this.f12335i[i8];
            if (i8 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // o.b.a
    public void b(i iVar, float f6, boolean z5) {
        float f7 = f12326n;
        if (f6 <= (-f7) || f6 >= f7) {
            int p5 = p(iVar);
            if (p5 == -1) {
                c(iVar, f6);
                return;
            }
            float[] fArr = this.f12333g;
            float f8 = fArr[p5] + f6;
            fArr[p5] = f8;
            float f9 = f12326n;
            if (f8 <= (-f9) || f8 >= f9) {
                return;
            }
            fArr[p5] = 0.0f;
            j(iVar, z5);
        }
    }

    @Override // o.b.a
    public void c(i iVar, float f6) {
        float f7 = f12326n;
        if (f6 > (-f7) && f6 < f7) {
            j(iVar, true);
            return;
        }
        if (this.f12336j == 0) {
            m(0, iVar, f6);
            l(iVar, 0);
            this.f12337k = 0;
            return;
        }
        int p5 = p(iVar);
        if (p5 != -1) {
            this.f12333g[p5] = f6;
            return;
        }
        if (this.f12336j + 1 >= this.f12328b) {
            o();
        }
        int i6 = this.f12336j;
        int i7 = this.f12337k;
        int i8 = -1;
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = this.f12332f[i7];
            int i11 = iVar.f12314c;
            if (i10 == i11) {
                this.f12333g[i7] = f6;
                return;
            }
            if (i10 < i11) {
                i8 = i7;
            }
            i7 = this.f12335i[i7];
            if (i7 == -1) {
                break;
            }
        }
        q(i8, iVar, f6);
    }

    @Override // o.b.a
    public void clear() {
        int i6 = this.f12336j;
        for (int i7 = 0; i7 < i6; i7++) {
            i h6 = h(i7);
            if (h6 != null) {
                h6.c(this.f12338l);
            }
        }
        for (int i8 = 0; i8 < this.f12328b; i8++) {
            this.f12332f[i8] = -1;
            this.f12331e[i8] = -1;
        }
        for (int i9 = 0; i9 < this.f12329c; i9++) {
            this.f12330d[i9] = -1;
        }
        this.f12336j = 0;
        this.f12337k = -1;
    }

    @Override // o.b.a
    public int d() {
        return this.f12336j;
    }

    @Override // o.b.a
    public boolean e(i iVar) {
        return p(iVar) != -1;
    }

    @Override // o.b.a
    public float f(b bVar, boolean z5) {
        float g6 = g(bVar.f12268a);
        j(bVar.f12268a, z5);
        j jVar = (j) bVar.f12272e;
        int d6 = jVar.d();
        int i6 = 0;
        int i7 = 0;
        while (i6 < d6) {
            int i8 = jVar.f12332f[i7];
            if (i8 != -1) {
                b(this.f12339m.f12277d[i8], jVar.f12333g[i7] * g6, z5);
                i6++;
            }
            i7++;
        }
        return g6;
    }

    @Override // o.b.a
    public float g(i iVar) {
        int p5 = p(iVar);
        if (p5 != -1) {
            return this.f12333g[p5];
        }
        return 0.0f;
    }

    @Override // o.b.a
    public i h(int i6) {
        int i7 = this.f12336j;
        if (i7 == 0) {
            return null;
        }
        int i8 = this.f12337k;
        for (int i9 = 0; i9 < i7; i9++) {
            if (i9 == i6 && i8 != -1) {
                return this.f12339m.f12277d[this.f12332f[i8]];
            }
            i8 = this.f12335i[i8];
            if (i8 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // o.b.a
    public void i(float f6) {
        int i6 = this.f12336j;
        int i7 = this.f12337k;
        for (int i8 = 0; i8 < i6; i8++) {
            float[] fArr = this.f12333g;
            fArr[i7] = fArr[i7] / f6;
            i7 = this.f12335i[i7];
            if (i7 == -1) {
                return;
            }
        }
    }

    @Override // o.b.a
    public float j(i iVar, boolean z5) {
        int p5 = p(iVar);
        if (p5 == -1) {
            return 0.0f;
        }
        r(iVar);
        float f6 = this.f12333g[p5];
        if (this.f12337k == p5) {
            this.f12337k = this.f12335i[p5];
        }
        this.f12332f[p5] = -1;
        int[] iArr = this.f12334h;
        int i6 = iArr[p5];
        if (i6 != -1) {
            int[] iArr2 = this.f12335i;
            iArr2[i6] = iArr2[p5];
        }
        int i7 = this.f12335i[p5];
        if (i7 != -1) {
            iArr[i7] = iArr[p5];
        }
        this.f12336j--;
        iVar.f12324m--;
        if (z5) {
            iVar.c(this.f12338l);
        }
        return f6;
    }

    @Override // o.b.a
    public void k() {
        int i6 = this.f12336j;
        int i7 = this.f12337k;
        for (int i8 = 0; i8 < i6; i8++) {
            float[] fArr = this.f12333g;
            fArr[i7] = fArr[i7] * (-1.0f);
            i7 = this.f12335i[i7];
            if (i7 == -1) {
                return;
            }
        }
    }

    public int p(i iVar) {
        if (this.f12336j == 0) {
            return -1;
        }
        int i6 = iVar.f12314c;
        int i7 = this.f12330d[i6 % this.f12329c];
        if (i7 == -1) {
            return -1;
        }
        if (this.f12332f[i7] == i6) {
            return i7;
        }
        do {
            i7 = this.f12331e[i7];
            if (i7 == -1) {
                break;
            }
        } while (this.f12332f[i7] != i6);
        if (i7 != -1 && this.f12332f[i7] == i6) {
            return i7;
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb;
        String str = hashCode() + " { ";
        int i6 = this.f12336j;
        for (int i7 = 0; i7 < i6; i7++) {
            i h6 = h(i7);
            if (h6 != null) {
                String str2 = str + h6 + " = " + a(i7) + " ";
                int p5 = p(h6);
                String str3 = str2 + "[p: ";
                if (this.f12334h[p5] != -1) {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(this.f12339m.f12277d[this.f12332f[this.f12334h[p5]]]);
                } else {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append("none");
                }
                String str4 = sb.toString() + ", n: ";
                str = (this.f12335i[p5] != -1 ? str4 + this.f12339m.f12277d[this.f12332f[this.f12335i[p5]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
