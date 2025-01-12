package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.s1;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import d2.a;
import java.util.ArrayList;
import o2.j;
import q2.c0;
import q2.e0;
import q2.i0;
import w1.e0;
import w1.i;
import w1.r0;
import w1.s0;
import w1.t;
import w1.x0;
import w1.y0;
import y1.h;
/* loaded from: classes.dex */
final class c implements t, s0.a {

    /* renamed from: a  reason: collision with root package name */
    private final b.a f4426a;

    /* renamed from: b  reason: collision with root package name */
    private final i0 f4427b;

    /* renamed from: c  reason: collision with root package name */
    private final e0 f4428c;

    /* renamed from: d  reason: collision with root package name */
    private final v f4429d;

    /* renamed from: e  reason: collision with root package name */
    private final t.a f4430e;

    /* renamed from: f  reason: collision with root package name */
    private final c0 f4431f;

    /* renamed from: g  reason: collision with root package name */
    private final e0.a f4432g;

    /* renamed from: h  reason: collision with root package name */
    private final q2.b f4433h;

    /* renamed from: k  reason: collision with root package name */
    private final y0 f4434k;

    /* renamed from: l  reason: collision with root package name */
    private final i f4435l;

    /* renamed from: m  reason: collision with root package name */
    private t.a f4436m;

    /* renamed from: n  reason: collision with root package name */
    private d2.a f4437n;

    /* renamed from: o  reason: collision with root package name */
    private h[] f4438o;

    /* renamed from: p  reason: collision with root package name */
    private s0 f4439p;

    public c(d2.a aVar, b.a aVar2, i0 i0Var, i iVar, v vVar, t.a aVar3, c0 c0Var, e0.a aVar4, q2.e0 e0Var, q2.b bVar) {
        this.f4437n = aVar;
        this.f4426a = aVar2;
        this.f4427b = i0Var;
        this.f4428c = e0Var;
        this.f4429d = vVar;
        this.f4430e = aVar3;
        this.f4431f = c0Var;
        this.f4432g = aVar4;
        this.f4433h = bVar;
        this.f4435l = iVar;
        this.f4434k = k(aVar, vVar);
        h[] p5 = p(0);
        this.f4438o = p5;
        this.f4439p = iVar.a(p5);
    }

    private h e(j jVar, long j6) {
        int f6 = this.f4434k.f(jVar.k());
        return new h(this.f4437n.f9142f[f6].f9148a, null, null, this.f4426a.a(this.f4428c, this.f4437n, f6, jVar, this.f4427b), this, this.f4433h, j6, this.f4429d, this.f4430e, this.f4431f, this.f4432g);
    }

    private static y0 k(d2.a aVar, v vVar) {
        x0[] x0VarArr = new x0[aVar.f9142f.length];
        int i6 = 0;
        while (true) {
            a.b[] bVarArr = aVar.f9142f;
            if (i6 >= bVarArr.length) {
                return new y0(x0VarArr);
            }
            com.google.android.exoplayer2.s0[] s0VarArr = bVarArr[i6].f9157j;
            com.google.android.exoplayer2.s0[] s0VarArr2 = new com.google.android.exoplayer2.s0[s0VarArr.length];
            for (int i7 = 0; i7 < s0VarArr.length; i7++) {
                com.google.android.exoplayer2.s0 s0Var = s0VarArr[i7];
                s0VarArr2[i7] = s0Var.f(vVar.d(s0Var));
            }
            x0VarArr[i6] = new x0(s0VarArr2);
            i6++;
        }
    }

    private static h[] p(int i6) {
        return new h[i6];
    }

    @Override // w1.t, w1.s0
    public boolean a() {
        return this.f4439p.a();
    }

    @Override // w1.t
    public long c(long j6, s1 s1Var) {
        h[] hVarArr;
        for (h hVar : this.f4438o) {
            if (hVar.f14291a == 2) {
                return hVar.c(j6, s1Var);
            }
        }
        return j6;
    }

    @Override // w1.t, w1.s0
    public long d() {
        return this.f4439p.d();
    }

    @Override // w1.t, w1.s0
    public long f() {
        return this.f4439p.f();
    }

    @Override // w1.t, w1.s0
    public boolean h(long j6) {
        return this.f4439p.h(j6);
    }

    @Override // w1.t, w1.s0
    public void i(long j6) {
        this.f4439p.i(j6);
    }

    @Override // w1.t
    public long l() {
        return -9223372036854775807L;
    }

    @Override // w1.t
    public y0 n() {
        return this.f4434k;
    }

    @Override // w1.t
    public void o(t.a aVar, long j6) {
        this.f4436m = aVar;
        aVar.g(this);
    }

    @Override // w1.t
    public long q(j[] jVarArr, boolean[] zArr, r0[] r0VarArr, boolean[] zArr2, long j6) {
        j jVar;
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < jVarArr.length; i6++) {
            r0 r0Var = r0VarArr[i6];
            if (r0Var != null) {
                h hVar = (h) r0Var;
                if (jVarArr[i6] == null || !zArr[i6]) {
                    hVar.P();
                    r0VarArr[i6] = null;
                } else {
                    ((b) hVar.E()).d(jVarArr[i6]);
                    arrayList.add(hVar);
                }
            }
            if (r0VarArr[i6] == null && (jVar = jVarArr[i6]) != null) {
                h e6 = e(jVar, j6);
                arrayList.add(e6);
                r0VarArr[i6] = e6;
                zArr2[i6] = true;
            }
        }
        h[] p5 = p(arrayList.size());
        this.f4438o = p5;
        arrayList.toArray(p5);
        this.f4439p = this.f4435l.a(this.f4438o);
        return j6;
    }

    @Override // w1.s0.a
    /* renamed from: r */
    public void j(h hVar) {
        this.f4436m.j(this);
    }

    @Override // w1.t
    public void s() {
        this.f4428c.b();
    }

    @Override // w1.t
    public void t(long j6, boolean z5) {
        for (h hVar : this.f4438o) {
            hVar.t(j6, z5);
        }
    }

    @Override // w1.t
    public long u(long j6) {
        for (h hVar : this.f4438o) {
            hVar.S(j6);
        }
        return j6;
    }

    public void v() {
        for (h hVar : this.f4438o) {
            hVar.P();
        }
        this.f4436m = null;
    }

    public void w(d2.a aVar) {
        this.f4437n = aVar;
        for (h hVar : this.f4438o) {
            ((b) hVar.E()).j(aVar);
        }
        this.f4436m.j(this);
    }
}
