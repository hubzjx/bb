package o;

import java.util.ArrayList;
import java.util.Iterator;
import o.d;
import o.i;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class b implements d.a {

    /* renamed from: e  reason: collision with root package name */
    public a f12272e;

    /* renamed from: a  reason: collision with root package name */
    i f12268a = null;

    /* renamed from: b  reason: collision with root package name */
    float f12269b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    boolean f12270c = false;

    /* renamed from: d  reason: collision with root package name */
    ArrayList f12271d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    boolean f12273f = false;

    /* loaded from: classes.dex */
    public interface a {
        float a(int i6);

        void b(i iVar, float f6, boolean z5);

        void c(i iVar, float f6);

        void clear();

        int d();

        boolean e(i iVar);

        float f(b bVar, boolean z5);

        float g(i iVar);

        i h(int i6);

        void i(float f6);

        float j(i iVar, boolean z5);

        void k();
    }

    public b() {
    }

    private boolean v(i iVar, d dVar) {
        return iVar.f12324m <= 1;
    }

    private i x(boolean[] zArr, i iVar) {
        i.a aVar;
        int d6 = this.f12272e.d();
        i iVar2 = null;
        float f6 = 0.0f;
        for (int i6 = 0; i6 < d6; i6++) {
            float a6 = this.f12272e.a(i6);
            if (a6 < 0.0f) {
                i h6 = this.f12272e.h(i6);
                if ((zArr == null || !zArr[h6.f12314c]) && h6 != iVar && (((aVar = h6.f12321j) == i.a.SLACK || aVar == i.a.ERROR) && a6 < f6)) {
                    f6 = a6;
                    iVar2 = h6;
                }
            }
        }
        return iVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String A() {
        StringBuilder sb;
        boolean z5;
        float a6;
        int i6;
        StringBuilder sb2;
        String str;
        StringBuilder sb3;
        if (this.f12268a == null) {
            sb = new StringBuilder();
            sb.append(HttpUrl.FRAGMENT_ENCODE_SET);
            sb.append("0");
        } else {
            sb = new StringBuilder();
            sb.append(HttpUrl.FRAGMENT_ENCODE_SET);
            sb.append(this.f12268a);
        }
        String str2 = sb.toString() + " = ";
        if (this.f12269b != 0.0f) {
            str2 = str2 + this.f12269b;
            z5 = true;
        } else {
            z5 = false;
        }
        int d6 = this.f12272e.d();
        for (int i7 = 0; i7 < d6; i7++) {
            i h6 = this.f12272e.h(i7);
            if (h6 != null && (this.f12272e.a(i7)) != 0.0f) {
                String iVar = h6.toString();
                if (!z5) {
                    if (a6 < 0.0f) {
                        sb2 = new StringBuilder();
                        sb2.append(str2);
                        str = "- ";
                        sb2.append(str);
                        str2 = sb2.toString();
                        a6 *= -1.0f;
                    }
                    if (a6 == 1.0f) {
                        sb3 = new StringBuilder();
                    } else {
                        sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append(a6);
                        str2 = " ";
                    }
                    sb3.append(str2);
                    sb3.append(iVar);
                    str2 = sb3.toString();
                    z5 = true;
                } else if (i6 > 0) {
                    str2 = str2 + " + ";
                    if (a6 == 1.0f) {
                    }
                    sb3.append(str2);
                    sb3.append(iVar);
                    str2 = sb3.toString();
                    z5 = true;
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(str2);
                    str = " - ";
                    sb2.append(str);
                    str2 = sb2.toString();
                    a6 *= -1.0f;
                    if (a6 == 1.0f) {
                    }
                    sb3.append(str2);
                    sb3.append(iVar);
                    str2 = sb3.toString();
                    z5 = true;
                }
            }
        }
        if (z5) {
            return str2;
        }
        return str2 + "0.0";
    }

    public void B(d dVar, i iVar, boolean z5) {
        if (iVar.f12318g) {
            this.f12269b += iVar.f12317f * this.f12272e.g(iVar);
            this.f12272e.j(iVar, z5);
            if (z5) {
                iVar.c(this);
            }
        }
    }

    public void C(b bVar, boolean z5) {
        this.f12269b += bVar.f12269b * this.f12272e.f(bVar, z5);
        if (z5) {
            bVar.f12268a.c(this);
        }
    }

    public void D(d dVar) {
        if (dVar.f12287f.length == 0) {
            return;
        }
        boolean z5 = false;
        while (!z5) {
            int d6 = this.f12272e.d();
            for (int i6 = 0; i6 < d6; i6++) {
                i h6 = this.f12272e.h(i6);
                if (h6.f12315d != -1 || h6.f12318g) {
                    this.f12271d.add(h6);
                }
            }
            if (this.f12271d.size() > 0) {
                Iterator it = this.f12271d.iterator();
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    if (iVar.f12318g) {
                        B(dVar, iVar, true);
                    } else {
                        C(dVar.f12287f[iVar.f12315d], true);
                    }
                }
                this.f12271d.clear();
            } else {
                z5 = true;
            }
        }
    }

    @Override // o.d.a
    public void a(i iVar) {
        int i6 = iVar.f12316e;
        float f6 = 1.0f;
        if (i6 != 1) {
            if (i6 == 2) {
                f6 = 1000.0f;
            } else if (i6 == 3) {
                f6 = 1000000.0f;
            } else if (i6 == 4) {
                f6 = 1.0E9f;
            } else if (i6 == 5) {
                f6 = 1.0E12f;
            }
        }
        this.f12272e.c(iVar, f6);
    }

    @Override // o.d.a
    public i b(d dVar, boolean[] zArr) {
        return x(zArr, null);
    }

    @Override // o.d.a
    public void c(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f12268a = null;
            this.f12272e.clear();
            for (int i6 = 0; i6 < bVar.f12272e.d(); i6++) {
                this.f12272e.b(bVar.f12272e.h(i6), bVar.f12272e.a(i6), true);
            }
        }
    }

    @Override // o.d.a
    public void clear() {
        this.f12272e.clear();
        this.f12268a = null;
        this.f12269b = 0.0f;
    }

    public b d(d dVar, int i6) {
        this.f12272e.c(dVar.o(i6, "ep"), 1.0f);
        this.f12272e.c(dVar.o(i6, "em"), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e(i iVar, int i6) {
        this.f12272e.c(iVar, i6);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(d dVar) {
        boolean z5;
        i g6 = g(dVar);
        if (g6 == null) {
            z5 = true;
        } else {
            y(g6);
            z5 = false;
        }
        if (this.f12272e.d() == 0) {
            this.f12273f = true;
        }
        return z5;
    }

    i g(d dVar) {
        int d6 = this.f12272e.d();
        i iVar = null;
        i iVar2 = null;
        boolean z5 = false;
        boolean z6 = false;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i6 = 0; i6 < d6; i6++) {
            float a6 = this.f12272e.a(i6);
            i h6 = this.f12272e.h(i6);
            if (h6.f12321j == i.a.UNRESTRICTED) {
                if (iVar == null || f6 > a6) {
                    z5 = v(h6, dVar);
                    f6 = a6;
                    iVar = h6;
                } else if (!z5 && v(h6, dVar)) {
                    f6 = a6;
                    iVar = h6;
                    z5 = true;
                }
            } else if (iVar == null && a6 < 0.0f) {
                if (iVar2 == null || f7 > a6) {
                    z6 = v(h6, dVar);
                    f7 = a6;
                    iVar2 = h6;
                } else if (!z6 && v(h6, dVar)) {
                    f7 = a6;
                    iVar2 = h6;
                    z6 = true;
                }
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    @Override // o.d.a
    public i getKey() {
        return this.f12268a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b h(i iVar, i iVar2, int i6, float f6, i iVar3, i iVar4, int i7) {
        float f7;
        int i8;
        if (iVar2 == iVar3) {
            this.f12272e.c(iVar, 1.0f);
            this.f12272e.c(iVar4, 1.0f);
            this.f12272e.c(iVar2, -2.0f);
            return this;
        }
        if (f6 == 0.5f) {
            this.f12272e.c(iVar, 1.0f);
            this.f12272e.c(iVar2, -1.0f);
            this.f12272e.c(iVar3, -1.0f);
            this.f12272e.c(iVar4, 1.0f);
            if (i6 > 0 || i7 > 0) {
                i8 = (-i6) + i7;
                f7 = i8;
            }
            return this;
        } else if (f6 <= 0.0f) {
            this.f12272e.c(iVar, -1.0f);
            this.f12272e.c(iVar2, 1.0f);
            f7 = i6;
        } else if (f6 < 1.0f) {
            float f8 = 1.0f - f6;
            this.f12272e.c(iVar, f8 * 1.0f);
            this.f12272e.c(iVar2, f8 * (-1.0f));
            this.f12272e.c(iVar3, (-1.0f) * f6);
            this.f12272e.c(iVar4, 1.0f * f6);
            if (i6 > 0 || i7 > 0) {
                f7 = ((-i6) * f8) + (i7 * f6);
            }
            return this;
        } else {
            this.f12272e.c(iVar4, -1.0f);
            this.f12272e.c(iVar3, 1.0f);
            i8 = -i7;
            f7 = i8;
        }
        this.f12269b = f7;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b i(i iVar, int i6) {
        this.f12268a = iVar;
        float f6 = i6;
        iVar.f12317f = f6;
        this.f12269b = f6;
        this.f12273f = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b j(i iVar, i iVar2, float f6) {
        this.f12272e.c(iVar, -1.0f);
        this.f12272e.c(iVar2, f6);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f6) {
        this.f12272e.c(iVar, -1.0f);
        this.f12272e.c(iVar2, 1.0f);
        this.f12272e.c(iVar3, f6);
        this.f12272e.c(iVar4, -f6);
        return this;
    }

    public b l(float f6, float f7, float f8, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f12269b = 0.0f;
        if (f7 == 0.0f || f6 == f8) {
            this.f12272e.c(iVar, 1.0f);
            this.f12272e.c(iVar2, -1.0f);
            this.f12272e.c(iVar4, 1.0f);
            this.f12272e.c(iVar3, -1.0f);
        } else if (f6 == 0.0f) {
            this.f12272e.c(iVar, 1.0f);
            this.f12272e.c(iVar2, -1.0f);
        } else if (f8 == 0.0f) {
            this.f12272e.c(iVar3, 1.0f);
            this.f12272e.c(iVar4, -1.0f);
        } else {
            float f9 = (f6 / f7) / (f8 / f7);
            this.f12272e.c(iVar, 1.0f);
            this.f12272e.c(iVar2, -1.0f);
            this.f12272e.c(iVar4, f9);
            this.f12272e.c(iVar3, -f9);
        }
        return this;
    }

    public b m(i iVar, int i6) {
        a aVar;
        float f6;
        if (i6 < 0) {
            this.f12269b = i6 * (-1);
            aVar = this.f12272e;
            f6 = 1.0f;
        } else {
            this.f12269b = i6;
            aVar = this.f12272e;
            f6 = -1.0f;
        }
        aVar.c(iVar, f6);
        return this;
    }

    public b n(i iVar, i iVar2, int i6) {
        boolean z5 = false;
        if (i6 != 0) {
            if (i6 < 0) {
                i6 *= -1;
                z5 = true;
            }
            this.f12269b = i6;
        }
        if (z5) {
            this.f12272e.c(iVar, 1.0f);
            this.f12272e.c(iVar2, -1.0f);
        } else {
            this.f12272e.c(iVar, -1.0f);
            this.f12272e.c(iVar2, 1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i6) {
        boolean z5 = false;
        if (i6 != 0) {
            if (i6 < 0) {
                i6 *= -1;
                z5 = true;
            }
            this.f12269b = i6;
        }
        if (z5) {
            this.f12272e.c(iVar, 1.0f);
            this.f12272e.c(iVar2, -1.0f);
            this.f12272e.c(iVar3, -1.0f);
        } else {
            this.f12272e.c(iVar, -1.0f);
            this.f12272e.c(iVar2, 1.0f);
            this.f12272e.c(iVar3, 1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i6) {
        boolean z5 = false;
        if (i6 != 0) {
            if (i6 < 0) {
                i6 *= -1;
                z5 = true;
            }
            this.f12269b = i6;
        }
        if (z5) {
            this.f12272e.c(iVar, 1.0f);
            this.f12272e.c(iVar2, -1.0f);
            this.f12272e.c(iVar3, 1.0f);
        } else {
            this.f12272e.c(iVar, -1.0f);
            this.f12272e.c(iVar2, 1.0f);
            this.f12272e.c(iVar3, -1.0f);
        }
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f6) {
        this.f12272e.c(iVar3, 0.5f);
        this.f12272e.c(iVar4, 0.5f);
        this.f12272e.c(iVar, -0.5f);
        this.f12272e.c(iVar2, -0.5f);
        this.f12269b = -f6;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        float f6 = this.f12269b;
        if (f6 < 0.0f) {
            this.f12269b = f6 * (-1.0f);
            this.f12272e.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        i iVar = this.f12268a;
        return iVar != null && (iVar.f12321j == i.a.UNRESTRICTED || this.f12269b >= 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(i iVar) {
        return this.f12272e.e(iVar);
    }

    public String toString() {
        return A();
    }

    public boolean u() {
        return this.f12268a == null && this.f12269b == 0.0f && this.f12272e.d() == 0;
    }

    public i w(i iVar) {
        return x(null, iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(i iVar) {
        i iVar2 = this.f12268a;
        if (iVar2 != null) {
            this.f12272e.c(iVar2, -1.0f);
            this.f12268a = null;
        }
        float j6 = this.f12272e.j(iVar, true) * (-1.0f);
        this.f12268a = iVar;
        if (j6 == 1.0f) {
            return;
        }
        this.f12269b /= j6;
        this.f12272e.i(j6);
    }

    public void z() {
        this.f12268a = null;
        this.f12272e.clear();
        this.f12269b = 0.0f;
        this.f12273f = false;
    }

    public b(c cVar) {
        this.f12272e = new o.a(this, cVar);
    }
}
