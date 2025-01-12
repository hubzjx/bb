package k1;

import c1.a0;
import c1.i;
import c1.j;
import c1.k;
import c1.w;
import c1.x;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.y;
import java.io.IOException;
/* loaded from: classes.dex */
public final class a implements i {

    /* renamed from: a  reason: collision with root package name */
    private final s0 f11265a;

    /* renamed from: c  reason: collision with root package name */
    private a0 f11267c;

    /* renamed from: e  reason: collision with root package name */
    private int f11269e;

    /* renamed from: f  reason: collision with root package name */
    private long f11270f;

    /* renamed from: g  reason: collision with root package name */
    private int f11271g;

    /* renamed from: h  reason: collision with root package name */
    private int f11272h;

    /* renamed from: b  reason: collision with root package name */
    private final y f11266b = new y(9);

    /* renamed from: d  reason: collision with root package name */
    private int f11268d = 0;

    public a(s0 s0Var) {
        this.f11265a = s0Var;
    }

    private boolean b(j jVar) {
        this.f11266b.I(8);
        if (jVar.d(this.f11266b.c(), 0, 8, true)) {
            if (this.f11266b.k() == 1380139777) {
                this.f11269e = this.f11266b.A();
                return true;
            }
            throw new IOException("Input not RawCC");
        }
        return false;
    }

    private void e(j jVar) {
        while (this.f11271g > 0) {
            this.f11266b.I(3);
            jVar.readFully(this.f11266b.c(), 0, 3);
            this.f11267c.a(this.f11266b, 3);
            this.f11272h += 3;
            this.f11271g--;
        }
        int i6 = this.f11272h;
        if (i6 > 0) {
            this.f11267c.d(this.f11270f, 1, i6, 0, null);
        }
    }

    private boolean f(j jVar) {
        long t5;
        int i6 = this.f11269e;
        if (i6 == 0) {
            this.f11266b.I(5);
            if (!jVar.d(this.f11266b.c(), 0, 5, true)) {
                return false;
            }
            t5 = (this.f11266b.C() * 1000) / 45;
        } else if (i6 != 1) {
            int i7 = this.f11269e;
            StringBuilder sb = new StringBuilder(39);
            sb.append("Unsupported version number: ");
            sb.append(i7);
            throw new f1(sb.toString());
        } else {
            this.f11266b.I(9);
            if (!jVar.d(this.f11266b.c(), 0, 9, true)) {
                return false;
            }
            t5 = this.f11266b.t();
        }
        this.f11270f = t5;
        this.f11271g = this.f11266b.A();
        this.f11272h = 0;
        return true;
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(k kVar) {
        kVar.r(new x.b(-9223372036854775807L));
        a0 e6 = kVar.e(0, 3);
        this.f11267c = e6;
        e6.e(this.f11265a);
        kVar.g();
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        this.f11268d = 0;
    }

    @Override // c1.i
    public int g(j jVar, w wVar) {
        com.google.android.exoplayer2.util.a.i(this.f11267c);
        while (true) {
            int i6 = this.f11268d;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        e(jVar);
                        this.f11268d = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                } else if (!f(jVar)) {
                    this.f11268d = 0;
                    return -1;
                } else {
                    this.f11268d = 2;
                }
            } else if (!b(jVar)) {
                return -1;
            } else {
                this.f11268d = 1;
            }
        }
    }

    @Override // c1.i
    public boolean h(j jVar) {
        this.f11266b.I(8);
        jVar.n(this.f11266b.c(), 0, 8);
        return this.f11266b.k() == 1380139777;
    }
}
