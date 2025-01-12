package w1;

import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.y1;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import w1.v;
/* loaded from: classes.dex */
public final class i0 extends g {

    /* renamed from: t  reason: collision with root package name */
    private static final com.google.android.exoplayer2.w0 f13856t = new w0.b().c("MergingMediaSource").a();

    /* renamed from: l  reason: collision with root package name */
    private final boolean f13857l;

    /* renamed from: m  reason: collision with root package name */
    private final v[] f13858m;

    /* renamed from: n  reason: collision with root package name */
    private final y1[] f13859n;

    /* renamed from: o  reason: collision with root package name */
    private final ArrayList f13860o;

    /* renamed from: p  reason: collision with root package name */
    private final i f13861p;

    /* renamed from: q  reason: collision with root package name */
    private int f13862q;

    /* renamed from: r  reason: collision with root package name */
    private long[][] f13863r;

    /* renamed from: s  reason: collision with root package name */
    private a f13864s;

    /* loaded from: classes.dex */
    public static final class a extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        public a(int i6) {
            this.reason = i6;
        }
    }

    public i0(boolean z5, i iVar, v... vVarArr) {
        this.f13857l = z5;
        this.f13858m = vVarArr;
        this.f13861p = iVar;
        this.f13860o = new ArrayList(Arrays.asList(vVarArr));
        this.f13862q = -1;
        this.f13859n = new y1[vVarArr.length];
        this.f13863r = new long[0];
    }

    private void K() {
        y1.b bVar = new y1.b();
        for (int i6 = 0; i6 < this.f13862q; i6++) {
            long j6 = -this.f13859n[0].f(i6, bVar).k();
            int i7 = 1;
            while (true) {
                y1[] y1VarArr = this.f13859n;
                if (i7 < y1VarArr.length) {
                    this.f13863r[i6][i7] = j6 - (-y1VarArr[i7].f(i6, bVar).k());
                    i7++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.g, w1.a
    public void A(q2.i0 i0Var) {
        super.A(i0Var);
        for (int i6 = 0; i6 < this.f13858m.length; i6++) {
            J(Integer.valueOf(i6), this.f13858m[i6]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.g, w1.a
    public void C() {
        super.C();
        Arrays.fill(this.f13859n, (Object) null);
        this.f13862q = -1;
        this.f13864s = null;
        this.f13860o.clear();
        Collections.addAll(this.f13860o, this.f13858m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.g
    /* renamed from: L */
    public v.a E(Integer num, v.a aVar) {
        if (num.intValue() == 0) {
            return aVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.g
    /* renamed from: M */
    public void I(Integer num, v vVar, y1 y1Var) {
        if (this.f13864s != null) {
            return;
        }
        if (this.f13862q == -1) {
            this.f13862q = y1Var.i();
        } else if (y1Var.i() != this.f13862q) {
            this.f13864s = new a(0);
            return;
        }
        if (this.f13863r.length == 0) {
            this.f13863r = (long[][]) Array.newInstance(Long.TYPE, this.f13862q, this.f13859n.length);
        }
        this.f13860o.remove(vVar);
        this.f13859n[num.intValue()] = y1Var;
        if (this.f13860o.isEmpty()) {
            if (this.f13857l) {
                K();
            }
            B(this.f13859n[0]);
        }
    }

    @Override // w1.v
    public com.google.android.exoplayer2.w0 a() {
        v[] vVarArr = this.f13858m;
        return vVarArr.length > 0 ? vVarArr[0].a() : f13856t;
    }

    @Override // w1.g, w1.v
    public void e() {
        a aVar = this.f13864s;
        if (aVar != null) {
            throw aVar;
        }
        super.e();
    }

    @Override // w1.v
    public void i(t tVar) {
        h0 h0Var = (h0) tVar;
        int i6 = 0;
        while (true) {
            v[] vVarArr = this.f13858m;
            if (i6 >= vVarArr.length) {
                return;
            }
            vVarArr[i6].i(h0Var.e(i6));
            i6++;
        }
    }

    @Override // w1.v
    public t o(v.a aVar, q2.b bVar, long j6) {
        int length = this.f13858m.length;
        t[] tVarArr = new t[length];
        int b6 = this.f13859n[0].b(aVar.f14051a);
        for (int i6 = 0; i6 < length; i6++) {
            tVarArr[i6] = this.f13858m[i6].o(aVar.a(this.f13859n[i6].l(b6)), bVar, j6 - this.f13863r[b6][i6]);
        }
        return new h0(this.f13861p, this.f13863r[b6], tVarArr);
    }

    public i0(boolean z5, v... vVarArr) {
        this(z5, new j(), vVarArr);
    }

    public i0(v... vVarArr) {
        this(false, vVarArr);
    }
}
