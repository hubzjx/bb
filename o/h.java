package o;

import java.util.Arrays;
import java.util.Comparator;
import o.b;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class h extends o.b {

    /* renamed from: g  reason: collision with root package name */
    private int f12301g;

    /* renamed from: h  reason: collision with root package name */
    private i[] f12302h;

    /* renamed from: i  reason: collision with root package name */
    private i[] f12303i;

    /* renamed from: j  reason: collision with root package name */
    private int f12304j;

    /* renamed from: k  reason: collision with root package name */
    b f12305k;

    /* renamed from: l  reason: collision with root package name */
    c f12306l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(i iVar, i iVar2) {
            return iVar.f12314c - iVar2.f12314c;
        }
    }

    /* loaded from: classes.dex */
    class b implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        i f12308a;

        /* renamed from: b  reason: collision with root package name */
        h f12309b;

        public b(h hVar) {
            this.f12309b = hVar;
        }

        public boolean a(i iVar, float f6) {
            boolean z5 = true;
            if (!this.f12308a.f12312a) {
                for (int i6 = 0; i6 < 9; i6++) {
                    float f7 = iVar.f12320i[i6];
                    if (f7 != 0.0f) {
                        float f8 = f7 * f6;
                        if (Math.abs(f8) < 1.0E-4f) {
                            f8 = 0.0f;
                        }
                        this.f12308a.f12320i[i6] = f8;
                    } else {
                        this.f12308a.f12320i[i6] = 0.0f;
                    }
                }
                return true;
            }
            for (int i7 = 0; i7 < 9; i7++) {
                float[] fArr = this.f12308a.f12320i;
                float f9 = fArr[i7] + (iVar.f12320i[i7] * f6);
                fArr[i7] = f9;
                if (Math.abs(f9) < 1.0E-4f) {
                    this.f12308a.f12320i[i7] = 0.0f;
                } else {
                    z5 = false;
                }
            }
            if (z5) {
                h.this.G(this.f12308a);
            }
            return false;
        }

        public void b(i iVar) {
            this.f12308a = iVar;
        }

        public final boolean c() {
            for (int i6 = 8; i6 >= 0; i6--) {
                float f6 = this.f12308a.f12320i[i6];
                if (f6 > 0.0f) {
                    return false;
                }
                if (f6 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f12308a.f12314c - ((i) obj).f12314c;
        }

        public final boolean d(i iVar) {
            int i6 = 8;
            while (true) {
                if (i6 < 0) {
                    break;
                }
                float f6 = iVar.f12320i[i6];
                float f7 = this.f12308a.f12320i[i6];
                if (f7 == f6) {
                    i6--;
                } else if (f7 < f6) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f12308a.f12320i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f12308a != null) {
                for (int i6 = 0; i6 < 9; i6++) {
                    str = str + this.f12308a.f12320i[i6] + " ";
                }
            }
            return str + "] " + this.f12308a;
        }
    }

    public h(c cVar) {
        super(cVar);
        this.f12301g = 128;
        this.f12302h = new i[128];
        this.f12303i = new i[128];
        this.f12304j = 0;
        this.f12305k = new b(this);
        this.f12306l = cVar;
    }

    private final void F(i iVar) {
        int i6;
        int i7 = this.f12304j + 1;
        i[] iVarArr = this.f12302h;
        if (i7 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f12302h = iVarArr2;
            this.f12303i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f12302h;
        int i8 = this.f12304j;
        iVarArr3[i8] = iVar;
        int i9 = i8 + 1;
        this.f12304j = i9;
        if (i9 > 1 && iVarArr3[i9 - 1].f12314c > iVar.f12314c) {
            int i10 = 0;
            while (true) {
                i6 = this.f12304j;
                if (i10 >= i6) {
                    break;
                }
                this.f12303i[i10] = this.f12302h[i10];
                i10++;
            }
            Arrays.sort(this.f12303i, 0, i6, new a());
            for (int i11 = 0; i11 < this.f12304j; i11++) {
                this.f12302h[i11] = this.f12303i[i11];
            }
        }
        iVar.f12312a = true;
        iVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(i iVar) {
        int i6 = 0;
        while (i6 < this.f12304j) {
            if (this.f12302h[i6] == iVar) {
                while (true) {
                    int i7 = this.f12304j;
                    if (i6 >= i7 - 1) {
                        this.f12304j = i7 - 1;
                        iVar.f12312a = false;
                        return;
                    }
                    i[] iVarArr = this.f12302h;
                    int i8 = i6 + 1;
                    iVarArr[i6] = iVarArr[i8];
                    i6 = i8;
                }
            } else {
                i6++;
            }
        }
    }

    @Override // o.b
    public void C(o.b bVar, boolean z5) {
        i iVar = bVar.f12268a;
        if (iVar == null) {
            return;
        }
        b.a aVar = bVar.f12272e;
        int d6 = aVar.d();
        for (int i6 = 0; i6 < d6; i6++) {
            i h6 = aVar.h(i6);
            float a6 = aVar.a(i6);
            this.f12305k.b(h6);
            if (this.f12305k.a(iVar, a6)) {
                F(h6);
            }
            this.f12269b += bVar.f12269b * a6;
        }
        G(iVar);
    }

    @Override // o.b, o.d.a
    public void a(i iVar) {
        this.f12305k.b(iVar);
        this.f12305k.e();
        iVar.f12320i[iVar.f12316e] = 1.0f;
        F(iVar);
    }

    @Override // o.b, o.d.a
    public i b(d dVar, boolean[] zArr) {
        int i6 = -1;
        for (int i7 = 0; i7 < this.f12304j; i7++) {
            i iVar = this.f12302h[i7];
            if (!zArr[iVar.f12314c]) {
                this.f12305k.b(iVar);
                b bVar = this.f12305k;
                if (i6 == -1) {
                    if (!bVar.c()) {
                    }
                    i6 = i7;
                } else {
                    if (!bVar.d(this.f12302h[i6])) {
                    }
                    i6 = i7;
                }
            }
        }
        if (i6 == -1) {
            return null;
        }
        return this.f12302h[i6];
    }

    @Override // o.b, o.d.a
    public void clear() {
        this.f12304j = 0;
        this.f12269b = 0.0f;
    }

    @Override // o.b
    public String toString() {
        String str = HttpUrl.FRAGMENT_ENCODE_SET + " goal -> (" + this.f12269b + ") : ";
        for (int i6 = 0; i6 < this.f12304j; i6++) {
            this.f12305k.b(this.f12302h[i6]);
            str = str + this.f12305k + " ";
        }
        return str;
    }
}
