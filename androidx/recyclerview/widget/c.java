package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import e0.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c extends m {

    /* renamed from: s  reason: collision with root package name */
    private static TimeInterpolator f2388s;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList f2389h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList f2390i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList f2391j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList f2392k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    ArrayList f2393l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    ArrayList f2394m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    ArrayList f2395n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    ArrayList f2396o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    ArrayList f2397p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    ArrayList f2398q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    ArrayList f2399r = new ArrayList();

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2400a;

        a(ArrayList arrayList) {
            this.f2400a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f2400a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                c.this.S(jVar.f2434a, jVar.f2435b, jVar.f2436c, jVar.f2437d, jVar.f2438e);
            }
            this.f2400a.clear();
            c.this.f2394m.remove(this.f2400a);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2402a;

        b(ArrayList arrayList) {
            this.f2402a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f2402a.iterator();
            while (it.hasNext()) {
                c.this.R((i) it.next());
            }
            this.f2402a.clear();
            c.this.f2395n.remove(this.f2402a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0023c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2404a;

        RunnableC0023c(ArrayList arrayList) {
            this.f2404a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f2404a.iterator();
            while (it.hasNext()) {
                c.this.Q((RecyclerView.c0) it.next());
            }
            this.f2404a.clear();
            c.this.f2393l.remove(this.f2404a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.c0 f2406a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2407b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2408c;

        d(RecyclerView.c0 c0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2406a = c0Var;
            this.f2407b = viewPropertyAnimator;
            this.f2408c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2407b.setListener(null);
            this.f2408c.setAlpha(1.0f);
            c.this.G(this.f2406a);
            c.this.f2398q.remove(this.f2406a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.H(this.f2406a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.c0 f2410a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2411b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2412c;

        e(RecyclerView.c0 c0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f2410a = c0Var;
            this.f2411b = view;
            this.f2412c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2411b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2412c.setListener(null);
            c.this.A(this.f2410a);
            c.this.f2396o.remove(this.f2410a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.B(this.f2410a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.c0 f2414a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2415b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2416c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2417d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2418e;

        f(RecyclerView.c0 c0Var, int i6, View view, int i7, ViewPropertyAnimator viewPropertyAnimator) {
            this.f2414a = c0Var;
            this.f2415b = i6;
            this.f2416c = view;
            this.f2417d = i7;
            this.f2418e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f2415b != 0) {
                this.f2416c.setTranslationX(0.0f);
            }
            if (this.f2417d != 0) {
                this.f2416c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2418e.setListener(null);
            c.this.E(this.f2414a);
            c.this.f2397p.remove(this.f2414a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.F(this.f2414a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f2420a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2421b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2422c;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2420a = iVar;
            this.f2421b = viewPropertyAnimator;
            this.f2422c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2421b.setListener(null);
            this.f2422c.setAlpha(1.0f);
            this.f2422c.setTranslationX(0.0f);
            this.f2422c.setTranslationY(0.0f);
            c.this.C(this.f2420a.f2428a, true);
            c.this.f2399r.remove(this.f2420a.f2428a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f2420a.f2428a, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f2424a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2425b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2426c;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2424a = iVar;
            this.f2425b = viewPropertyAnimator;
            this.f2426c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2425b.setListener(null);
            this.f2426c.setAlpha(1.0f);
            this.f2426c.setTranslationX(0.0f);
            this.f2426c.setTranslationY(0.0f);
            c.this.C(this.f2424a.f2429b, false);
            c.this.f2399r.remove(this.f2424a.f2429b);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f2424a.f2429b, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.c0 f2428a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.c0 f2429b;

        /* renamed from: c  reason: collision with root package name */
        public int f2430c;

        /* renamed from: d  reason: collision with root package name */
        public int f2431d;

        /* renamed from: e  reason: collision with root package name */
        public int f2432e;

        /* renamed from: f  reason: collision with root package name */
        public int f2433f;

        private i(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2) {
            this.f2428a = c0Var;
            this.f2429b = c0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f2428a + ", newHolder=" + this.f2429b + ", fromX=" + this.f2430c + ", fromY=" + this.f2431d + ", toX=" + this.f2432e + ", toY=" + this.f2433f + '}';
        }

        i(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i6, int i7, int i8, int i9) {
            this(c0Var, c0Var2);
            this.f2430c = i6;
            this.f2431d = i7;
            this.f2432e = i8;
            this.f2433f = i9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.c0 f2434a;

        /* renamed from: b  reason: collision with root package name */
        public int f2435b;

        /* renamed from: c  reason: collision with root package name */
        public int f2436c;

        /* renamed from: d  reason: collision with root package name */
        public int f2437d;

        /* renamed from: e  reason: collision with root package name */
        public int f2438e;

        j(RecyclerView.c0 c0Var, int i6, int i7, int i8, int i9) {
            this.f2434a = c0Var;
            this.f2435b = i6;
            this.f2436c = i7;
            this.f2437d = i8;
            this.f2438e = i9;
        }
    }

    private void T(RecyclerView.c0 c0Var) {
        View view = c0Var.f2221a;
        ViewPropertyAnimator animate = view.animate();
        this.f2398q.add(c0Var);
        animate.setDuration(o()).alpha(0.0f).setListener(new d(c0Var, animate, view)).start();
    }

    private void W(List list, RecyclerView.c0 c0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = (i) list.get(size);
            if (Y(iVar, c0Var) && iVar.f2428a == null && iVar.f2429b == null) {
                list.remove(iVar);
            }
        }
    }

    private void X(i iVar) {
        RecyclerView.c0 c0Var = iVar.f2428a;
        if (c0Var != null) {
            Y(iVar, c0Var);
        }
        RecyclerView.c0 c0Var2 = iVar.f2429b;
        if (c0Var2 != null) {
            Y(iVar, c0Var2);
        }
    }

    private boolean Y(i iVar, RecyclerView.c0 c0Var) {
        boolean z5 = false;
        if (iVar.f2429b == c0Var) {
            iVar.f2429b = null;
        } else if (iVar.f2428a != c0Var) {
            return false;
        } else {
            iVar.f2428a = null;
            z5 = true;
        }
        c0Var.f2221a.setAlpha(1.0f);
        c0Var.f2221a.setTranslationX(0.0f);
        c0Var.f2221a.setTranslationY(0.0f);
        C(c0Var, z5);
        return true;
    }

    private void Z(RecyclerView.c0 c0Var) {
        if (f2388s == null) {
            f2388s = new ValueAnimator().getInterpolator();
        }
        c0Var.f2221a.animate().setInterpolator(f2388s);
        j(c0Var);
    }

    void Q(RecyclerView.c0 c0Var) {
        View view = c0Var.f2221a;
        ViewPropertyAnimator animate = view.animate();
        this.f2396o.add(c0Var);
        animate.alpha(1.0f).setDuration(l()).setListener(new e(c0Var, view, animate)).start();
    }

    void R(i iVar) {
        RecyclerView.c0 c0Var = iVar.f2428a;
        View view = c0Var == null ? null : c0Var.f2221a;
        RecyclerView.c0 c0Var2 = iVar.f2429b;
        View view2 = c0Var2 != null ? c0Var2.f2221a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f2399r.add(iVar.f2428a);
            duration.translationX(iVar.f2432e - iVar.f2430c);
            duration.translationY(iVar.f2433f - iVar.f2431d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f2399r.add(iVar.f2429b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    void S(RecyclerView.c0 c0Var, int i6, int i7, int i8, int i9) {
        View view = c0Var.f2221a;
        int i10 = i8 - i6;
        int i11 = i9 - i7;
        if (i10 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i11 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f2397p.add(c0Var);
        animate.setDuration(n()).setListener(new f(c0Var, i10, view, i11, animate)).start();
    }

    void U(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.c0) list.get(size)).f2221a.animate().cancel();
        }
    }

    void V() {
        if (p()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.c0 c0Var, List list) {
        return !list.isEmpty() || super.g(c0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.c0 c0Var) {
        View view = c0Var.f2221a;
        view.animate().cancel();
        int size = this.f2391j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (((j) this.f2391j.get(size)).f2434a == c0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(c0Var);
                this.f2391j.remove(size);
            }
        }
        W(this.f2392k, c0Var);
        if (this.f2389h.remove(c0Var)) {
            view.setAlpha(1.0f);
            G(c0Var);
        }
        if (this.f2390i.remove(c0Var)) {
            view.setAlpha(1.0f);
            A(c0Var);
        }
        for (int size2 = this.f2395n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f2395n.get(size2);
            W(arrayList, c0Var);
            if (arrayList.isEmpty()) {
                this.f2395n.remove(size2);
            }
        }
        for (int size3 = this.f2394m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.f2394m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((j) arrayList2.get(size4)).f2434a == c0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    E(c0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f2394m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f2393l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.f2393l.get(size5);
            if (arrayList3.remove(c0Var)) {
                view.setAlpha(1.0f);
                A(c0Var);
                if (arrayList3.isEmpty()) {
                    this.f2393l.remove(size5);
                }
            }
        }
        this.f2398q.remove(c0Var);
        this.f2396o.remove(c0Var);
        this.f2399r.remove(c0Var);
        this.f2397p.remove(c0Var);
        V();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f2391j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) this.f2391j.get(size);
            View view = jVar.f2434a.f2221a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(jVar.f2434a);
            this.f2391j.remove(size);
        }
        for (int size2 = this.f2389h.size() - 1; size2 >= 0; size2--) {
            G((RecyclerView.c0) this.f2389h.get(size2));
            this.f2389h.remove(size2);
        }
        int size3 = this.f2390i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.c0 c0Var = (RecyclerView.c0) this.f2390i.get(size3);
            c0Var.f2221a.setAlpha(1.0f);
            A(c0Var);
            this.f2390i.remove(size3);
        }
        for (int size4 = this.f2392k.size() - 1; size4 >= 0; size4--) {
            X((i) this.f2392k.get(size4));
        }
        this.f2392k.clear();
        if (p()) {
            for (int size5 = this.f2394m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f2394m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.f2434a.f2221a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    E(jVar2.f2434a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f2394m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f2393l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f2393l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.c0 c0Var2 = (RecyclerView.c0) arrayList2.get(size8);
                    c0Var2.f2221a.setAlpha(1.0f);
                    A(c0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f2393l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f2395n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f2395n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    X((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f2395n.remove(arrayList3);
                    }
                }
            }
            U(this.f2398q);
            U(this.f2397p);
            U(this.f2396o);
            U(this.f2399r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.f2390i.isEmpty() && this.f2392k.isEmpty() && this.f2391j.isEmpty() && this.f2389h.isEmpty() && this.f2397p.isEmpty() && this.f2398q.isEmpty() && this.f2396o.isEmpty() && this.f2399r.isEmpty() && this.f2394m.isEmpty() && this.f2393l.isEmpty() && this.f2395n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void u() {
        boolean z5 = !this.f2389h.isEmpty();
        boolean z6 = !this.f2391j.isEmpty();
        boolean z7 = !this.f2392k.isEmpty();
        boolean z8 = !this.f2390i.isEmpty();
        if (z5 || z6 || z8 || z7) {
            Iterator it = this.f2389h.iterator();
            while (it.hasNext()) {
                T((RecyclerView.c0) it.next());
            }
            this.f2389h.clear();
            if (z6) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f2391j);
                this.f2394m.add(arrayList);
                this.f2391j.clear();
                a aVar = new a(arrayList);
                if (z5) {
                    b0.e0(((j) arrayList.get(0)).f2434a.f2221a, aVar, o());
                } else {
                    aVar.run();
                }
            }
            if (z7) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f2392k);
                this.f2395n.add(arrayList2);
                this.f2392k.clear();
                b bVar = new b(arrayList2);
                if (z5) {
                    b0.e0(((i) arrayList2.get(0)).f2428a.f2221a, bVar, o());
                } else {
                    bVar.run();
                }
            }
            if (z8) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f2390i);
                this.f2393l.add(arrayList3);
                this.f2390i.clear();
                RunnableC0023c runnableC0023c = new RunnableC0023c(arrayList3);
                if (z5 || z6 || z7) {
                    b0.e0(((RecyclerView.c0) arrayList3.get(0)).f2221a, runnableC0023c, (z5 ? o() : 0L) + Math.max(z6 ? n() : 0L, z7 ? m() : 0L));
                } else {
                    runnableC0023c.run();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.m
    public boolean w(RecyclerView.c0 c0Var) {
        Z(c0Var);
        c0Var.f2221a.setAlpha(0.0f);
        this.f2390i.add(c0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean x(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i6, int i7, int i8, int i9) {
        if (c0Var == c0Var2) {
            return y(c0Var, i6, i7, i8, i9);
        }
        float translationX = c0Var.f2221a.getTranslationX();
        float translationY = c0Var.f2221a.getTranslationY();
        float alpha = c0Var.f2221a.getAlpha();
        Z(c0Var);
        int i10 = (int) ((i8 - i6) - translationX);
        int i11 = (int) ((i9 - i7) - translationY);
        c0Var.f2221a.setTranslationX(translationX);
        c0Var.f2221a.setTranslationY(translationY);
        c0Var.f2221a.setAlpha(alpha);
        if (c0Var2 != null) {
            Z(c0Var2);
            c0Var2.f2221a.setTranslationX(-i10);
            c0Var2.f2221a.setTranslationY(-i11);
            c0Var2.f2221a.setAlpha(0.0f);
        }
        this.f2392k.add(new i(c0Var, c0Var2, i6, i7, i8, i9));
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean y(RecyclerView.c0 c0Var, int i6, int i7, int i8, int i9) {
        View view = c0Var.f2221a;
        int translationX = i6 + ((int) view.getTranslationX());
        int translationY = i7 + ((int) c0Var.f2221a.getTranslationY());
        Z(c0Var);
        int i10 = i8 - translationX;
        int i11 = i9 - translationY;
        if (i10 == 0 && i11 == 0) {
            E(c0Var);
            return false;
        }
        if (i10 != 0) {
            view.setTranslationX(-i10);
        }
        if (i11 != 0) {
            view.setTranslationY(-i11);
        }
        this.f2391j.add(new j(c0Var, translationX, translationY, i8, i9));
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean z(RecyclerView.c0 c0Var) {
        Z(c0Var);
        this.f2389h.add(c0Var);
        return true;
    }
}
