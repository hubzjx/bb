package w1;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.y1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import w1.e0;
import w1.v;
/* loaded from: classes.dex */
public abstract class a implements v {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f13772a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    private final HashSet f13773b = new HashSet(1);

    /* renamed from: c  reason: collision with root package name */
    private final e0.a f13774c = new e0.a();

    /* renamed from: d  reason: collision with root package name */
    private final t.a f13775d = new t.a();

    /* renamed from: e  reason: collision with root package name */
    private Looper f13776e;

    /* renamed from: f  reason: collision with root package name */
    private y1 f13777f;

    protected abstract void A(q2.i0 i0Var);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B(y1 y1Var) {
        this.f13777f = y1Var;
        Iterator it = this.f13772a.iterator();
        while (it.hasNext()) {
            ((v.b) it.next()).a(this, y1Var);
        }
    }

    protected abstract void C();

    @Override // w1.v
    public final void b(v.b bVar) {
        com.google.android.exoplayer2.util.a.e(this.f13776e);
        boolean isEmpty = this.f13773b.isEmpty();
        this.f13773b.add(bVar);
        if (isEmpty) {
            y();
        }
    }

    @Override // w1.v
    public final void c(v.b bVar) {
        this.f13772a.remove(bVar);
        if (!this.f13772a.isEmpty()) {
            j(bVar);
            return;
        }
        this.f13776e = null;
        this.f13777f = null;
        this.f13773b.clear();
        C();
    }

    @Override // w1.v
    public final void d(Handler handler, com.google.android.exoplayer2.drm.t tVar) {
        com.google.android.exoplayer2.util.a.e(handler);
        com.google.android.exoplayer2.util.a.e(tVar);
        this.f13775d.g(handler, tVar);
    }

    @Override // w1.v
    public /* synthetic */ boolean f() {
        return u.b(this);
    }

    @Override // w1.v
    public /* synthetic */ y1 g() {
        return u.a(this);
    }

    @Override // w1.v
    public final void j(v.b bVar) {
        boolean z5 = !this.f13773b.isEmpty();
        this.f13773b.remove(bVar);
        if (z5 && this.f13773b.isEmpty()) {
            x();
        }
    }

    @Override // w1.v
    public final void l(v.b bVar, q2.i0 i0Var) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f13776e;
        com.google.android.exoplayer2.util.a.a(looper == null || looper == myLooper);
        y1 y1Var = this.f13777f;
        this.f13772a.add(bVar);
        if (this.f13776e == null) {
            this.f13776e = myLooper;
            this.f13773b.add(bVar);
            A(i0Var);
        } else if (y1Var != null) {
            b(bVar);
            bVar.a(this, y1Var);
        }
    }

    @Override // w1.v
    public final void n(Handler handler, e0 e0Var) {
        com.google.android.exoplayer2.util.a.e(handler);
        com.google.android.exoplayer2.util.a.e(e0Var);
        this.f13774c.g(handler, e0Var);
    }

    @Override // w1.v
    public final void r(e0 e0Var) {
        this.f13774c.C(e0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final t.a s(int i6, v.a aVar) {
        return this.f13775d.t(i6, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final t.a t(v.a aVar) {
        return this.f13775d.t(0, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final e0.a u(int i6, v.a aVar, long j6) {
        return this.f13774c.F(i6, aVar, j6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final e0.a v(v.a aVar) {
        return this.f13774c.F(0, aVar, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final e0.a w(v.a aVar, long j6) {
        com.google.android.exoplayer2.util.a.e(aVar);
        return this.f13774c.F(0, aVar, j6);
    }

    protected void x() {
    }

    protected void y() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean z() {
        return !this.f13773b.isEmpty();
    }
}
