package o;

import java.util.Arrays;
import o.b;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class a implements b.a {

    /* renamed from: l  reason: collision with root package name */
    private static float f12256l = 0.001f;

    /* renamed from: b  reason: collision with root package name */
    private final b f12258b;

    /* renamed from: c  reason: collision with root package name */
    protected final c f12259c;

    /* renamed from: a  reason: collision with root package name */
    int f12257a = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f12260d = 8;

    /* renamed from: e  reason: collision with root package name */
    private i f12261e = null;

    /* renamed from: f  reason: collision with root package name */
    private int[] f12262f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    private int[] f12263g = new int[8];

    /* renamed from: h  reason: collision with root package name */
    private float[] f12264h = new float[8];

    /* renamed from: i  reason: collision with root package name */
    private int f12265i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f12266j = -1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12267k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, c cVar) {
        this.f12258b = bVar;
        this.f12259c = cVar;
    }

    @Override // o.b.a
    public float a(int i6) {
        int i7 = this.f12265i;
        for (int i8 = 0; i7 != -1 && i8 < this.f12257a; i8++) {
            if (i8 == i6) {
                return this.f12264h[i7];
            }
            i7 = this.f12263g[i7];
        }
        return 0.0f;
    }

    @Override // o.b.a
    public void b(i iVar, float f6, boolean z5) {
        float f7 = f12256l;
        if (f6 <= (-f7) || f6 >= f7) {
            int i6 = this.f12265i;
            if (i6 == -1) {
                this.f12265i = 0;
                this.f12264h[0] = f6;
                this.f12262f[0] = iVar.f12314c;
                this.f12263g[0] = -1;
                iVar.f12324m++;
                iVar.a(this.f12258b);
                this.f12257a++;
                if (this.f12267k) {
                    return;
                }
                int i7 = this.f12266j + 1;
                this.f12266j = i7;
                int[] iArr = this.f12262f;
                if (i7 >= iArr.length) {
                    this.f12267k = true;
                    this.f12266j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i8 = -1;
            for (int i9 = 0; i6 != -1 && i9 < this.f12257a; i9++) {
                int i10 = this.f12262f[i6];
                int i11 = iVar.f12314c;
                if (i10 == i11) {
                    float[] fArr = this.f12264h;
                    float f8 = fArr[i6] + f6;
                    float f9 = f12256l;
                    if (f8 > (-f9) && f8 < f9) {
                        f8 = 0.0f;
                    }
                    fArr[i6] = f8;
                    if (f8 == 0.0f) {
                        if (i6 == this.f12265i) {
                            this.f12265i = this.f12263g[i6];
                        } else {
                            int[] iArr2 = this.f12263g;
                            iArr2[i8] = iArr2[i6];
                        }
                        if (z5) {
                            iVar.c(this.f12258b);
                        }
                        if (this.f12267k) {
                            this.f12266j = i6;
                        }
                        iVar.f12324m--;
                        this.f12257a--;
                        return;
                    }
                    return;
                }
                if (i10 < i11) {
                    i8 = i6;
                }
                i6 = this.f12263g[i6];
            }
            int i12 = this.f12266j;
            int i13 = i12 + 1;
            if (this.f12267k) {
                int[] iArr3 = this.f12262f;
                if (iArr3[i12] != -1) {
                    i12 = iArr3.length;
                }
            } else {
                i12 = i13;
            }
            int[] iArr4 = this.f12262f;
            if (i12 >= iArr4.length && this.f12257a < iArr4.length) {
                int i14 = 0;
                while (true) {
                    int[] iArr5 = this.f12262f;
                    if (i14 >= iArr5.length) {
                        break;
                    } else if (iArr5[i14] == -1) {
                        i12 = i14;
                        break;
                    } else {
                        i14++;
                    }
                }
            }
            int[] iArr6 = this.f12262f;
            if (i12 >= iArr6.length) {
                i12 = iArr6.length;
                int i15 = this.f12260d * 2;
                this.f12260d = i15;
                this.f12267k = false;
                this.f12266j = i12 - 1;
                this.f12264h = Arrays.copyOf(this.f12264h, i15);
                this.f12262f = Arrays.copyOf(this.f12262f, this.f12260d);
                this.f12263g = Arrays.copyOf(this.f12263g, this.f12260d);
            }
            this.f12262f[i12] = iVar.f12314c;
            this.f12264h[i12] = f6;
            int[] iArr7 = this.f12263g;
            if (i8 != -1) {
                iArr7[i12] = iArr7[i8];
                iArr7[i8] = i12;
            } else {
                iArr7[i12] = this.f12265i;
                this.f12265i = i12;
            }
            iVar.f12324m++;
            iVar.a(this.f12258b);
            this.f12257a++;
            if (!this.f12267k) {
                this.f12266j++;
            }
            int i16 = this.f12266j;
            int[] iArr8 = this.f12262f;
            if (i16 >= iArr8.length) {
                this.f12267k = true;
                this.f12266j = iArr8.length - 1;
            }
        }
    }

    @Override // o.b.a
    public final void c(i iVar, float f6) {
        if (f6 == 0.0f) {
            j(iVar, true);
            return;
        }
        int i6 = this.f12265i;
        if (i6 == -1) {
            this.f12265i = 0;
            this.f12264h[0] = f6;
            this.f12262f[0] = iVar.f12314c;
            this.f12263g[0] = -1;
            iVar.f12324m++;
            iVar.a(this.f12258b);
            this.f12257a++;
            if (this.f12267k) {
                return;
            }
            int i7 = this.f12266j + 1;
            this.f12266j = i7;
            int[] iArr = this.f12262f;
            if (i7 >= iArr.length) {
                this.f12267k = true;
                this.f12266j = iArr.length - 1;
                return;
            }
            return;
        }
        int i8 = -1;
        for (int i9 = 0; i6 != -1 && i9 < this.f12257a; i9++) {
            int i10 = this.f12262f[i6];
            int i11 = iVar.f12314c;
            if (i10 == i11) {
                this.f12264h[i6] = f6;
                return;
            }
            if (i10 < i11) {
                i8 = i6;
            }
            i6 = this.f12263g[i6];
        }
        int i12 = this.f12266j;
        int i13 = i12 + 1;
        if (this.f12267k) {
            int[] iArr2 = this.f12262f;
            if (iArr2[i12] != -1) {
                i12 = iArr2.length;
            }
        } else {
            i12 = i13;
        }
        int[] iArr3 = this.f12262f;
        if (i12 >= iArr3.length && this.f12257a < iArr3.length) {
            int i14 = 0;
            while (true) {
                int[] iArr4 = this.f12262f;
                if (i14 >= iArr4.length) {
                    break;
                } else if (iArr4[i14] == -1) {
                    i12 = i14;
                    break;
                } else {
                    i14++;
                }
            }
        }
        int[] iArr5 = this.f12262f;
        if (i12 >= iArr5.length) {
            i12 = iArr5.length;
            int i15 = this.f12260d * 2;
            this.f12260d = i15;
            this.f12267k = false;
            this.f12266j = i12 - 1;
            this.f12264h = Arrays.copyOf(this.f12264h, i15);
            this.f12262f = Arrays.copyOf(this.f12262f, this.f12260d);
            this.f12263g = Arrays.copyOf(this.f12263g, this.f12260d);
        }
        this.f12262f[i12] = iVar.f12314c;
        this.f12264h[i12] = f6;
        int[] iArr6 = this.f12263g;
        if (i8 != -1) {
            iArr6[i12] = iArr6[i8];
            iArr6[i8] = i12;
        } else {
            iArr6[i12] = this.f12265i;
            this.f12265i = i12;
        }
        iVar.f12324m++;
        iVar.a(this.f12258b);
        int i16 = this.f12257a + 1;
        this.f12257a = i16;
        if (!this.f12267k) {
            this.f12266j++;
        }
        int[] iArr7 = this.f12262f;
        if (i16 >= iArr7.length) {
            this.f12267k = true;
        }
        if (this.f12266j >= iArr7.length) {
            this.f12267k = true;
            this.f12266j = iArr7.length - 1;
        }
    }

    @Override // o.b.a
    public final void clear() {
        int i6 = this.f12265i;
        for (int i7 = 0; i6 != -1 && i7 < this.f12257a; i7++) {
            i iVar = this.f12259c.f12277d[this.f12262f[i6]];
            if (iVar != null) {
                iVar.c(this.f12258b);
            }
            i6 = this.f12263g[i6];
        }
        this.f12265i = -1;
        this.f12266j = -1;
        this.f12267k = false;
        this.f12257a = 0;
    }

    @Override // o.b.a
    public int d() {
        return this.f12257a;
    }

    @Override // o.b.a
    public boolean e(i iVar) {
        int i6 = this.f12265i;
        if (i6 == -1) {
            return false;
        }
        for (int i7 = 0; i6 != -1 && i7 < this.f12257a; i7++) {
            if (this.f12262f[i6] == iVar.f12314c) {
                return true;
            }
            i6 = this.f12263g[i6];
        }
        return false;
    }

    @Override // o.b.a
    public float f(b bVar, boolean z5) {
        float g6 = g(bVar.f12268a);
        j(bVar.f12268a, z5);
        b.a aVar = bVar.f12272e;
        int d6 = aVar.d();
        for (int i6 = 0; i6 < d6; i6++) {
            i h6 = aVar.h(i6);
            b(h6, aVar.g(h6) * g6, z5);
        }
        return g6;
    }

    @Override // o.b.a
    public final float g(i iVar) {
        int i6 = this.f12265i;
        for (int i7 = 0; i6 != -1 && i7 < this.f12257a; i7++) {
            if (this.f12262f[i6] == iVar.f12314c) {
                return this.f12264h[i6];
            }
            i6 = this.f12263g[i6];
        }
        return 0.0f;
    }

    @Override // o.b.a
    public i h(int i6) {
        int i7 = this.f12265i;
        for (int i8 = 0; i7 != -1 && i8 < this.f12257a; i8++) {
            if (i8 == i6) {
                return this.f12259c.f12277d[this.f12262f[i7]];
            }
            i7 = this.f12263g[i7];
        }
        return null;
    }

    @Override // o.b.a
    public void i(float f6) {
        int i6 = this.f12265i;
        for (int i7 = 0; i6 != -1 && i7 < this.f12257a; i7++) {
            float[] fArr = this.f12264h;
            fArr[i6] = fArr[i6] / f6;
            i6 = this.f12263g[i6];
        }
    }

    @Override // o.b.a
    public final float j(i iVar, boolean z5) {
        if (this.f12261e == iVar) {
            this.f12261e = null;
        }
        int i6 = this.f12265i;
        if (i6 == -1) {
            return 0.0f;
        }
        int i7 = 0;
        int i8 = -1;
        while (i6 != -1 && i7 < this.f12257a) {
            if (this.f12262f[i6] == iVar.f12314c) {
                if (i6 == this.f12265i) {
                    this.f12265i = this.f12263g[i6];
                } else {
                    int[] iArr = this.f12263g;
                    iArr[i8] = iArr[i6];
                }
                if (z5) {
                    iVar.c(this.f12258b);
                }
                iVar.f12324m--;
                this.f12257a--;
                this.f12262f[i6] = -1;
                if (this.f12267k) {
                    this.f12266j = i6;
                }
                return this.f12264h[i6];
            }
            i7++;
            i8 = i6;
            i6 = this.f12263g[i6];
        }
        return 0.0f;
    }

    @Override // o.b.a
    public void k() {
        int i6 = this.f12265i;
        for (int i7 = 0; i6 != -1 && i7 < this.f12257a; i7++) {
            float[] fArr = this.f12264h;
            fArr[i6] = fArr[i6] * (-1.0f);
            i6 = this.f12263g[i6];
        }
    }

    public String toString() {
        int i6 = this.f12265i;
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        for (int i7 = 0; i6 != -1 && i7 < this.f12257a; i7++) {
            str = ((str + " -> ") + this.f12264h[i6] + " : ") + this.f12259c.f12277d[this.f12262f[i6]];
            i6 = this.f12263g[i6];
        }
        return str;
    }
}
