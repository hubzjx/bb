package q2;

import com.google.android.exoplayer2.util.s0;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class f implements l {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f12750a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f12751b = new ArrayList(1);

    /* renamed from: c  reason: collision with root package name */
    private int f12752c;

    /* renamed from: d  reason: collision with root package name */
    private o f12753d;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(boolean z5) {
        this.f12750a = z5;
    }

    @Override // q2.l
    public /* synthetic */ Map f() {
        return k.a(this);
    }

    @Override // q2.l
    public final void i(i0 i0Var) {
        com.google.android.exoplayer2.util.a.e(i0Var);
        if (this.f12751b.contains(i0Var)) {
            return;
        }
        this.f12751b.add(i0Var);
        this.f12752c++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(int i6) {
        o oVar = (o) s0.j(this.f12753d);
        for (int i7 = 0; i7 < this.f12752c; i7++) {
            ((i0) this.f12751b.get(i7)).g(this, oVar, this.f12750a, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r() {
        o oVar = (o) s0.j(this.f12753d);
        for (int i6 = 0; i6 < this.f12752c; i6++) {
            ((i0) this.f12751b.get(i6)).d(this, oVar, this.f12750a);
        }
        this.f12753d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(o oVar) {
        for (int i6 = 0; i6 < this.f12752c; i6++) {
            ((i0) this.f12751b.get(i6)).f(this, oVar, this.f12750a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t(o oVar) {
        this.f12753d = oVar;
        for (int i6 = 0; i6 < this.f12752c; i6++) {
            ((i0) this.f12751b.get(i6)).a(this, oVar, this.f12750a);
        }
    }
}
