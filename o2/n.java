package o2;

import com.google.android.exoplayer2.q1;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final int f12477a;

    /* renamed from: b  reason: collision with root package name */
    public final q1[] f12478b;

    /* renamed from: c  reason: collision with root package name */
    public final k f12479c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f12480d;

    public n(q1[] q1VarArr, j[] jVarArr, Object obj) {
        this.f12478b = q1VarArr;
        this.f12479c = new k(jVarArr);
        this.f12480d = obj;
        this.f12477a = q1VarArr.length;
    }

    public boolean a(n nVar) {
        if (nVar == null || nVar.f12479c.f12460a != this.f12479c.f12460a) {
            return false;
        }
        for (int i6 = 0; i6 < this.f12479c.f12460a; i6++) {
            if (!b(nVar, i6)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(n nVar, int i6) {
        return nVar != null && s0.c(this.f12478b[i6], nVar.f12478b[i6]) && s0.c(this.f12479c.a(i6), nVar.f12479c.a(i6));
    }

    public boolean c(int i6) {
        return this.f12478b[i6] != null;
    }
}
