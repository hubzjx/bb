package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public abstract class m extends RecyclerView.l {

    /* renamed from: g  reason: collision with root package name */
    boolean f2513g = true;

    public final void A(RecyclerView.c0 c0Var) {
        I(c0Var);
        h(c0Var);
    }

    public final void B(RecyclerView.c0 c0Var) {
        J(c0Var);
    }

    public final void C(RecyclerView.c0 c0Var, boolean z5) {
        K(c0Var, z5);
        h(c0Var);
    }

    public final void D(RecyclerView.c0 c0Var, boolean z5) {
        L(c0Var, z5);
    }

    public final void E(RecyclerView.c0 c0Var) {
        M(c0Var);
        h(c0Var);
    }

    public final void F(RecyclerView.c0 c0Var) {
        N(c0Var);
    }

    public final void G(RecyclerView.c0 c0Var) {
        O(c0Var);
        h(c0Var);
    }

    public final void H(RecyclerView.c0 c0Var) {
        P(c0Var);
    }

    public void I(RecyclerView.c0 c0Var) {
    }

    public void J(RecyclerView.c0 c0Var) {
    }

    public void K(RecyclerView.c0 c0Var, boolean z5) {
    }

    public void L(RecyclerView.c0 c0Var, boolean z5) {
    }

    public void M(RecyclerView.c0 c0Var) {
    }

    public void N(RecyclerView.c0 c0Var) {
    }

    public void O(RecyclerView.c0 c0Var) {
    }

    public void P(RecyclerView.c0 c0Var) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.c0 c0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i6;
        int i7;
        return (bVar == null || ((i6 = bVar.f2250a) == (i7 = bVar2.f2250a) && bVar.f2251b == bVar2.f2251b)) ? w(c0Var) : y(c0Var, i6, bVar.f2251b, i7, bVar2.f2251b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i6;
        int i7;
        int i8 = bVar.f2250a;
        int i9 = bVar.f2251b;
        if (c0Var2.J()) {
            int i10 = bVar.f2250a;
            i7 = bVar.f2251b;
            i6 = i10;
        } else {
            i6 = bVar2.f2250a;
            i7 = bVar2.f2251b;
        }
        return x(c0Var, c0Var2, i8, i9, i6, i7);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.c0 c0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i6 = bVar.f2250a;
        int i7 = bVar.f2251b;
        View view = c0Var.f2221a;
        int left = bVar2 == null ? view.getLeft() : bVar2.f2250a;
        int top = bVar2 == null ? view.getTop() : bVar2.f2251b;
        if (c0Var.v() || (i6 == left && i7 == top)) {
            return z(c0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return y(c0Var, i6, i7, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.c0 c0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i6 = bVar.f2250a;
        int i7 = bVar2.f2250a;
        if (i6 == i7 && bVar.f2251b == bVar2.f2251b) {
            E(c0Var);
            return false;
        }
        return y(c0Var, i6, bVar.f2251b, i7, bVar2.f2251b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.c0 c0Var) {
        return !this.f2513g || c0Var.t();
    }

    public abstract boolean w(RecyclerView.c0 c0Var);

    public abstract boolean x(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i6, int i7, int i8, int i9);

    public abstract boolean y(RecyclerView.c0 c0Var, int i6, int i7, int i8, int i9);

    public abstract boolean z(RecyclerView.c0 c0Var);
}
