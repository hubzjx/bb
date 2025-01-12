package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class a implements j {

    /* renamed from: b  reason: collision with root package name */
    protected Context f491b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f492c;

    /* renamed from: d  reason: collision with root package name */
    protected e f493d;

    /* renamed from: e  reason: collision with root package name */
    protected LayoutInflater f494e;

    /* renamed from: f  reason: collision with root package name */
    protected LayoutInflater f495f;

    /* renamed from: g  reason: collision with root package name */
    private j.a f496g;

    /* renamed from: h  reason: collision with root package name */
    private int f497h;

    /* renamed from: i  reason: collision with root package name */
    private int f498i;

    /* renamed from: j  reason: collision with root package name */
    protected k f499j;

    /* renamed from: k  reason: collision with root package name */
    private int f500k;

    public a(Context context, int i6, int i7) {
        this.f491b = context;
        this.f494e = LayoutInflater.from(context);
        this.f497h = i6;
        this.f498i = i7;
    }

    protected void a(View view, int i6) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f499j).addView(view, i6);
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(e eVar, boolean z5) {
        j.a aVar = this.f496g;
        if (aVar != null) {
            aVar.b(eVar, z5);
        }
    }

    public abstract void c(g gVar, k.a aVar);

    @Override // androidx.appcompat.view.menu.j
    public void d(Context context, e eVar) {
        this.f492c = context;
        this.f495f = LayoutInflater.from(context);
        this.f493d = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.e] */
    @Override // androidx.appcompat.view.menu.j
    public boolean e(m mVar) {
        j.a aVar = this.f496g;
        m mVar2 = mVar;
        if (aVar != null) {
            if (mVar == null) {
                mVar2 = this.f493d;
            }
            return aVar.c(mVar2);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void f(boolean z5) {
        ViewGroup viewGroup = (ViewGroup) this.f499j;
        if (viewGroup == null) {
            return;
        }
        e eVar = this.f493d;
        int i6 = 0;
        if (eVar != null) {
            eVar.r();
            ArrayList E = this.f493d.E();
            int size = E.size();
            int i7 = 0;
            for (int i8 = 0; i8 < size; i8++) {
                g gVar = (g) E.get(i8);
                if (q(i7, gVar)) {
                    View childAt = viewGroup.getChildAt(i7);
                    g itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                    View n5 = n(gVar, childAt, viewGroup);
                    if (gVar != itemData) {
                        n5.setPressed(false);
                        n5.jumpDrawablesToCurrentState();
                    }
                    if (n5 != childAt) {
                        a(n5, i7);
                    }
                    i7++;
                }
            }
            i6 = i7;
        }
        while (i6 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i6)) {
                i6++;
            }
        }
    }

    public k.a g(ViewGroup viewGroup) {
        return (k.a) this.f494e.inflate(this.f498i, viewGroup, false);
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean i(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean j(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void k(j.a aVar) {
        this.f496g = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l(ViewGroup viewGroup, int i6) {
        viewGroup.removeViewAt(i6);
        return true;
    }

    public j.a m() {
        return this.f496g;
    }

    public View n(g gVar, View view, ViewGroup viewGroup) {
        k.a g6 = view instanceof k.a ? (k.a) view : g(viewGroup);
        c(gVar, g6);
        return (View) g6;
    }

    public k o(ViewGroup viewGroup) {
        if (this.f499j == null) {
            k kVar = (k) this.f494e.inflate(this.f497h, viewGroup, false);
            this.f499j = kVar;
            kVar.b(this.f493d);
            f(true);
        }
        return this.f499j;
    }

    public void p(int i6) {
        this.f500k = i6;
    }

    public abstract boolean q(int i6, g gVar);
}
