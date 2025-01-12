package n0;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import n0.l;
/* loaded from: classes.dex */
public class e extends androidx.fragment.app.o {

    /* loaded from: classes.dex */
    class a extends l.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f12088a;

        a(Rect rect) {
            this.f12088a = rect;
        }
    }

    /* loaded from: classes.dex */
    class b implements l.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f12090a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f12091b;

        b(View view, ArrayList arrayList) {
            this.f12090a = view;
            this.f12091b = arrayList;
        }

        @Override // n0.l.f
        public void a(l lVar) {
        }

        @Override // n0.l.f
        public void b(l lVar) {
            lVar.O(this);
            this.f12090a.setVisibility(8);
            int size = this.f12091b.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((View) this.f12091b.get(i6)).setVisibility(0);
            }
        }

        @Override // n0.l.f
        public void c(l lVar) {
        }

        @Override // n0.l.f
        public void d(l lVar) {
        }

        @Override // n0.l.f
        public void e(l lVar) {
        }
    }

    /* loaded from: classes.dex */
    class c extends m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f12093a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f12094b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f12095c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f12096d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f12097e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f12098f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f12093a = obj;
            this.f12094b = arrayList;
            this.f12095c = obj2;
            this.f12096d = arrayList2;
            this.f12097e = obj3;
            this.f12098f = arrayList3;
        }

        @Override // n0.l.f
        public void b(l lVar) {
            lVar.O(this);
        }

        @Override // n0.m, n0.l.f
        public void d(l lVar) {
            Object obj = this.f12093a;
            if (obj != null) {
                e.this.q(obj, this.f12094b, null);
            }
            Object obj2 = this.f12095c;
            if (obj2 != null) {
                e.this.q(obj2, this.f12096d, null);
            }
            Object obj3 = this.f12097e;
            if (obj3 != null) {
                e.this.q(obj3, this.f12098f, null);
            }
        }
    }

    /* loaded from: classes.dex */
    class d extends l.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f12100a;

        d(Rect rect) {
            this.f12100a = rect;
        }
    }

    private static boolean B(l lVar) {
        return (androidx.fragment.app.o.l(lVar.y()) && androidx.fragment.app.o.l(lVar.z()) && androidx.fragment.app.o.l(lVar.A())) ? false : true;
    }

    @Override // androidx.fragment.app.o
    public Object A(Object obj) {
        if (obj == null) {
            return null;
        }
        p pVar = new p();
        pVar.d0((l) obj);
        return pVar;
    }

    @Override // androidx.fragment.app.o
    public void a(Object obj, View view) {
        if (obj != null) {
            ((l) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.o
    public void b(Object obj, ArrayList arrayList) {
        l lVar = (l) obj;
        if (lVar == null) {
            return;
        }
        int i6 = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int g02 = pVar.g0();
            while (i6 < g02) {
                b(pVar.f0(i6), arrayList);
                i6++;
            }
        } else if (B(lVar) || !androidx.fragment.app.o.l(lVar.B())) {
        } else {
            int size = arrayList.size();
            while (i6 < size) {
                lVar.b((View) arrayList.get(i6));
                i6++;
            }
        }
    }

    @Override // androidx.fragment.app.o
    public void c(ViewGroup viewGroup, Object obj) {
        n.a(viewGroup, (l) obj);
    }

    @Override // androidx.fragment.app.o
    public boolean e(Object obj) {
        return obj instanceof l;
    }

    @Override // androidx.fragment.app.o
    public Object g(Object obj) {
        if (obj != null) {
            return ((l) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.o
    public Object m(Object obj, Object obj2, Object obj3) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        l lVar3 = (l) obj3;
        if (lVar != null && lVar2 != null) {
            lVar = new p().d0(lVar).d0(lVar2).l0(1);
        } else if (lVar == null) {
            lVar = lVar2 != null ? lVar2 : null;
        }
        if (lVar3 != null) {
            p pVar = new p();
            if (lVar != null) {
                pVar.d0(lVar);
            }
            pVar.d0(lVar3);
            return pVar;
        }
        return lVar;
    }

    @Override // androidx.fragment.app.o
    public Object n(Object obj, Object obj2, Object obj3) {
        p pVar = new p();
        if (obj != null) {
            pVar.d0((l) obj);
        }
        if (obj2 != null) {
            pVar.d0((l) obj2);
        }
        if (obj3 != null) {
            pVar.d0((l) obj3);
        }
        return pVar;
    }

    @Override // androidx.fragment.app.o
    public void p(Object obj, View view) {
        if (obj != null) {
            ((l) obj).P(view);
        }
    }

    @Override // androidx.fragment.app.o
    public void q(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        l lVar = (l) obj;
        int i6 = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int g02 = pVar.g0();
            while (i6 < g02) {
                q(pVar.f0(i6), arrayList, arrayList2);
                i6++;
            }
        } else if (!B(lVar)) {
            List B = lVar.B();
            if (B.size() == arrayList.size() && B.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i6 < size) {
                    lVar.b((View) arrayList2.get(i6));
                    i6++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    lVar.P((View) arrayList.get(size2));
                }
            }
        }
    }

    @Override // androidx.fragment.app.o
    public void r(Object obj, View view, ArrayList arrayList) {
        ((l) obj).a(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.o
    public void t(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((l) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.o
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((l) obj).U(new d(rect));
        }
    }

    @Override // androidx.fragment.app.o
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((l) obj).U(new a(rect));
        }
    }

    @Override // androidx.fragment.app.o
    public void y(Object obj, View view, ArrayList arrayList) {
        p pVar = (p) obj;
        List B = pVar.B();
        B.clear();
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            androidx.fragment.app.o.d(B, (View) arrayList.get(i6));
        }
        B.add(view);
        arrayList.add(view);
        b(pVar, arrayList);
    }

    @Override // androidx.fragment.app.o
    public void z(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        p pVar = (p) obj;
        if (pVar != null) {
            pVar.B().clear();
            pVar.B().addAll(arrayList2);
            q(pVar, arrayList, arrayList2);
        }
    }
}
