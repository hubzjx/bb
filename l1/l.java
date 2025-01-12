package l1;

import com.google.android.exoplayer2.s0;
import java.util.Collections;
import java.util.List;
import l1.i0;
/* loaded from: classes.dex */
public final class l implements m {

    /* renamed from: a  reason: collision with root package name */
    private final List f11581a;

    /* renamed from: b  reason: collision with root package name */
    private final c1.a0[] f11582b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11583c;

    /* renamed from: d  reason: collision with root package name */
    private int f11584d;

    /* renamed from: e  reason: collision with root package name */
    private int f11585e;

    /* renamed from: f  reason: collision with root package name */
    private long f11586f;

    public l(List list) {
        this.f11581a = list;
        this.f11582b = new c1.a0[list.size()];
    }

    private boolean b(com.google.android.exoplayer2.util.y yVar, int i6) {
        if (yVar.a() == 0) {
            return false;
        }
        if (yVar.A() != i6) {
            this.f11583c = false;
        }
        this.f11584d--;
        return this.f11583c;
    }

    @Override // l1.m
    public void a() {
        this.f11583c = false;
    }

    @Override // l1.m
    public void c(com.google.android.exoplayer2.util.y yVar) {
        c1.a0[] a0VarArr;
        if (this.f11583c) {
            if (this.f11584d != 2 || b(yVar, 32)) {
                if (this.f11584d != 1 || b(yVar, 0)) {
                    int d6 = yVar.d();
                    int a6 = yVar.a();
                    for (c1.a0 a0Var : this.f11582b) {
                        yVar.M(d6);
                        a0Var.a(yVar, a6);
                    }
                    this.f11585e += a6;
                }
            }
        }
    }

    @Override // l1.m
    public void d() {
        if (this.f11583c) {
            for (c1.a0 a0Var : this.f11582b) {
                a0Var.d(this.f11586f, 1, this.f11585e, 0, null);
            }
            this.f11583c = false;
        }
    }

    @Override // l1.m
    public void e(long j6, int i6) {
        if ((i6 & 4) == 0) {
            return;
        }
        this.f11583c = true;
        this.f11586f = j6;
        this.f11585e = 0;
        this.f11584d = 2;
    }

    @Override // l1.m
    public void f(c1.k kVar, i0.d dVar) {
        for (int i6 = 0; i6 < this.f11582b.length; i6++) {
            i0.a aVar = (i0.a) this.f11581a.get(i6);
            dVar.a();
            c1.a0 e6 = kVar.e(dVar.c(), 3);
            e6.e(new s0.b().S(dVar.b()).e0("application/dvbsubs").T(Collections.singletonList(aVar.f11556c)).V(aVar.f11554a).E());
            this.f11582b[i6] = e6;
        }
    }
}
