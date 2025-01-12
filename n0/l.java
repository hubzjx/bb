package n0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class l implements Cloneable {
    private static final int[] I = {2, 1, 3, 4};
    private static final g J = new a();
    private static ThreadLocal K = new ThreadLocal();
    private e F;
    private l.a G;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList f12126v;

    /* renamed from: w  reason: collision with root package name */
    private ArrayList f12127w;

    /* renamed from: a  reason: collision with root package name */
    private String f12107a = getClass().getName();

    /* renamed from: b  reason: collision with root package name */
    private long f12108b = -1;

    /* renamed from: c  reason: collision with root package name */
    long f12109c = -1;

    /* renamed from: d  reason: collision with root package name */
    private TimeInterpolator f12110d = null;

    /* renamed from: e  reason: collision with root package name */
    ArrayList f12111e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    ArrayList f12112f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList f12113g = null;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList f12114h = null;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList f12115k = null;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList f12116l = null;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList f12117m = null;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList f12118n = null;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList f12119o = null;

    /* renamed from: p  reason: collision with root package name */
    private ArrayList f12120p = null;

    /* renamed from: q  reason: collision with root package name */
    private ArrayList f12121q = null;

    /* renamed from: r  reason: collision with root package name */
    private t f12122r = new t();

    /* renamed from: s  reason: collision with root package name */
    private t f12123s = new t();

    /* renamed from: t  reason: collision with root package name */
    p f12124t = null;

    /* renamed from: u  reason: collision with root package name */
    private int[] f12125u = I;

    /* renamed from: x  reason: collision with root package name */
    private ViewGroup f12128x = null;

    /* renamed from: y  reason: collision with root package name */
    boolean f12129y = false;

    /* renamed from: z  reason: collision with root package name */
    ArrayList f12130z = new ArrayList();
    private int A = 0;
    private boolean B = false;
    private boolean C = false;
    private ArrayList D = null;
    private ArrayList E = new ArrayList();
    private g H = J;

    /* loaded from: classes.dex */
    static class a extends g {
        a() {
        }

        @Override // n0.g
        public Path a(float f6, float f7, float f8, float f9) {
            Path path = new Path();
            path.moveTo(f6, f7);
            path.lineTo(f8, f9);
            return path;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l.a f12131a;

        b(l.a aVar) {
            this.f12131a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f12131a.remove(animator);
            l.this.f12130z.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            l.this.f12130z.add(animator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.o();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        View f12134a;

        /* renamed from: b  reason: collision with root package name */
        String f12135b;

        /* renamed from: c  reason: collision with root package name */
        s f12136c;

        /* renamed from: d  reason: collision with root package name */
        p0 f12137d;

        /* renamed from: e  reason: collision with root package name */
        l f12138e;

        d(View view, String str, l lVar, p0 p0Var, s sVar) {
            this.f12134a = view;
            this.f12135b = str;
            this.f12136c = sVar;
            this.f12137d = p0Var;
            this.f12138e = lVar;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(l lVar);

        void b(l lVar);

        void c(l lVar);

        void d(l lVar);

        void e(l lVar);
    }

    private static boolean G(s sVar, s sVar2, String str) {
        Object obj = sVar.f12173a.get(str);
        Object obj2 = sVar2.f12173a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void H(l.a aVar, l.a aVar2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = (View) sparseArray.valueAt(i6);
            if (view2 != null && F(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i6))) != null && F(view)) {
                s sVar = (s) aVar.get(view2);
                s sVar2 = (s) aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f12126v.add(sVar);
                    this.f12127w.add(sVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void I(l.a aVar, l.a aVar2) {
        s sVar;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.i(size);
            if (view != null && F(view) && (sVar = (s) aVar2.remove(view)) != null && F(sVar.f12174b)) {
                this.f12126v.add((s) aVar.k(size));
                this.f12127w.add(sVar);
            }
        }
    }

    private void J(l.a aVar, l.a aVar2, l.d dVar, l.d dVar2) {
        View view;
        int l6 = dVar.l();
        for (int i6 = 0; i6 < l6; i6++) {
            View view2 = (View) dVar.m(i6);
            if (view2 != null && F(view2) && (view = (View) dVar2.e(dVar.h(i6))) != null && F(view)) {
                s sVar = (s) aVar.get(view2);
                s sVar2 = (s) aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f12126v.add(sVar);
                    this.f12127w.add(sVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void K(l.a aVar, l.a aVar2, l.a aVar3, l.a aVar4) {
        View view;
        int size = aVar3.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = (View) aVar3.m(i6);
            if (view2 != null && F(view2) && (view = (View) aVar4.get(aVar3.i(i6))) != null && F(view)) {
                s sVar = (s) aVar.get(view2);
                s sVar2 = (s) aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f12126v.add(sVar);
                    this.f12127w.add(sVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void L(t tVar, t tVar2) {
        l.a aVar = new l.a(tVar.f12176a);
        l.a aVar2 = new l.a(tVar2.f12176a);
        int i6 = 0;
        while (true) {
            int[] iArr = this.f12125u;
            if (i6 >= iArr.length) {
                c(aVar, aVar2);
                return;
            }
            int i7 = iArr[i6];
            if (i7 == 1) {
                I(aVar, aVar2);
            } else if (i7 == 2) {
                K(aVar, aVar2, tVar.f12179d, tVar2.f12179d);
            } else if (i7 == 3) {
                H(aVar, aVar2, tVar.f12177b, tVar2.f12177b);
            } else if (i7 == 4) {
                J(aVar, aVar2, tVar.f12178c, tVar2.f12178c);
            }
            i6++;
        }
    }

    private void R(Animator animator, l.a aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            e(animator);
        }
    }

    private void c(l.a aVar, l.a aVar2) {
        for (int i6 = 0; i6 < aVar.size(); i6++) {
            s sVar = (s) aVar.m(i6);
            if (F(sVar.f12174b)) {
                this.f12126v.add(sVar);
                this.f12127w.add(null);
            }
        }
        for (int i7 = 0; i7 < aVar2.size(); i7++) {
            s sVar2 = (s) aVar2.m(i7);
            if (F(sVar2.f12174b)) {
                this.f12127w.add(sVar2);
                this.f12126v.add(null);
            }
        }
    }

    private static void d(t tVar, View view, s sVar) {
        tVar.f12176a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f12177b.indexOfKey(id) >= 0) {
                tVar.f12177b.put(id, null);
            } else {
                tVar.f12177b.put(id, view);
            }
        }
        String J2 = e0.b0.J(view);
        if (J2 != null) {
            if (tVar.f12179d.containsKey(J2)) {
                tVar.f12179d.put(J2, null);
            } else {
                tVar.f12179d.put(J2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f12178c.g(itemIdAtPosition) < 0) {
                    e0.b0.t0(view, true);
                    tVar.f12178c.i(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) tVar.f12178c.e(itemIdAtPosition);
                if (view2 != null) {
                    e0.b0.t0(view2, false);
                    tVar.f12178c.i(itemIdAtPosition, null);
                }
            }
        }
    }

    private void g(View view, boolean z5) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.f12115k;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList arrayList2 = this.f12116l;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.f12117m;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        if (((Class) this.f12117m.get(i6)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s(view);
                    if (z5) {
                        i(sVar);
                    } else {
                        f(sVar);
                    }
                    sVar.f12175c.add(this);
                    h(sVar);
                    d(z5 ? this.f12122r : this.f12123s, view, sVar);
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.f12119o;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList arrayList5 = this.f12120p;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.f12121q;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i7 = 0; i7 < size2; i7++) {
                                    if (((Class) this.f12121q.get(i7)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
                                g(viewGroup.getChildAt(i8), z5);
                            }
                        }
                    }
                }
            }
        }
    }

    private static l.a w() {
        l.a aVar = (l.a) K.get();
        if (aVar == null) {
            l.a aVar2 = new l.a();
            K.set(aVar2);
            return aVar2;
        }
        return aVar;
    }

    public List A() {
        return this.f12114h;
    }

    public List B() {
        return this.f12112f;
    }

    public String[] C() {
        return null;
    }

    public s D(View view, boolean z5) {
        p pVar = this.f12124t;
        if (pVar != null) {
            return pVar.D(view, z5);
        }
        return (s) (z5 ? this.f12122r : this.f12123s).f12176a.get(view);
    }

    public boolean E(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] C = C();
        if (C == null) {
            for (String str : sVar.f12173a.keySet()) {
                if (G(sVar, sVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : C) {
            if (!G(sVar, sVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.f12115k;
        if (arrayList3 == null || !arrayList3.contains(Integer.valueOf(id))) {
            ArrayList arrayList4 = this.f12116l;
            if (arrayList4 == null || !arrayList4.contains(view)) {
                ArrayList arrayList5 = this.f12117m;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        if (((Class) this.f12117m.get(i6)).isInstance(view)) {
                            return false;
                        }
                    }
                }
                if (this.f12118n == null || e0.b0.J(view) == null || !this.f12118n.contains(e0.b0.J(view))) {
                    if ((this.f12111e.size() == 0 && this.f12112f.size() == 0 && (((arrayList = this.f12114h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f12113g) == null || arrayList2.isEmpty()))) || this.f12111e.contains(Integer.valueOf(id)) || this.f12112f.contains(view)) {
                        return true;
                    }
                    ArrayList arrayList6 = this.f12113g;
                    if (arrayList6 == null || !arrayList6.contains(e0.b0.J(view))) {
                        if (this.f12114h != null) {
                            for (int i7 = 0; i7 < this.f12114h.size(); i7++) {
                                if (((Class) this.f12114h.get(i7)).isInstance(view)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void M(View view) {
        if (this.C) {
            return;
        }
        l.a w5 = w();
        int size = w5.size();
        p0 d6 = a0.d(view);
        for (int i6 = size - 1; i6 >= 0; i6--) {
            d dVar = (d) w5.m(i6);
            if (dVar.f12134a != null && d6.equals(dVar.f12137d)) {
                n0.a.b((Animator) w5.i(i6));
            }
        }
        ArrayList arrayList = this.D;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.D.clone();
            int size2 = arrayList2.size();
            for (int i7 = 0; i7 < size2; i7++) {
                ((f) arrayList2.get(i7)).c(this);
            }
        }
        this.B = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(ViewGroup viewGroup) {
        d dVar;
        this.f12126v = new ArrayList();
        this.f12127w = new ArrayList();
        L(this.f12122r, this.f12123s);
        l.a w5 = w();
        int size = w5.size();
        p0 d6 = a0.d(viewGroup);
        for (int i6 = size - 1; i6 >= 0; i6--) {
            Animator animator = (Animator) w5.i(i6);
            if (animator != null && (dVar = (d) w5.get(animator)) != null && dVar.f12134a != null && d6.equals(dVar.f12137d)) {
                s sVar = dVar.f12136c;
                View view = dVar.f12134a;
                s D = D(view, true);
                s s5 = s(view, true);
                if (D == null && s5 == null) {
                    s5 = (s) this.f12123s.f12176a.get(view);
                }
                if (!(D == null && s5 == null) && dVar.f12138e.E(sVar, s5)) {
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        w5.remove(animator);
                    }
                }
            }
        }
        n(viewGroup, this.f12122r, this.f12123s, this.f12126v, this.f12127w);
        S();
    }

    public l O(f fVar) {
        ArrayList arrayList = this.D;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.D.size() == 0) {
            this.D = null;
        }
        return this;
    }

    public l P(View view) {
        this.f12112f.remove(view);
        return this;
    }

    public void Q(View view) {
        if (this.B) {
            if (!this.C) {
                l.a w5 = w();
                int size = w5.size();
                p0 d6 = a0.d(view);
                for (int i6 = size - 1; i6 >= 0; i6--) {
                    d dVar = (d) w5.m(i6);
                    if (dVar.f12134a != null && d6.equals(dVar.f12137d)) {
                        n0.a.c((Animator) w5.i(i6));
                    }
                }
                ArrayList arrayList = this.D;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.D.clone();
                    int size2 = arrayList2.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        ((f) arrayList2.get(i7)).a(this);
                    }
                }
            }
            this.B = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S() {
        Z();
        l.a w5 = w();
        Iterator it = this.E.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (w5.containsKey(animator)) {
                Z();
                R(animator, w5);
            }
        }
        this.E.clear();
        o();
    }

    public l T(long j6) {
        this.f12109c = j6;
        return this;
    }

    public void U(e eVar) {
        this.F = eVar;
    }

    public l V(TimeInterpolator timeInterpolator) {
        this.f12110d = timeInterpolator;
        return this;
    }

    public void W(g gVar) {
        if (gVar == null) {
            gVar = J;
        }
        this.H = gVar;
    }

    public void X(o oVar) {
    }

    public l Y(long j6) {
        this.f12108b = j6;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z() {
        if (this.A == 0) {
            ArrayList arrayList = this.D;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.D.clone();
                int size = arrayList2.size();
                for (int i6 = 0; i6 < size; i6++) {
                    ((f) arrayList2.get(i6)).d(this);
                }
            }
            this.C = false;
        }
        this.A++;
    }

    public l a(f fVar) {
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.add(fVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f12109c != -1) {
            str2 = str2 + "dur(" + this.f12109c + ") ";
        }
        if (this.f12108b != -1) {
            str2 = str2 + "dly(" + this.f12108b + ") ";
        }
        if (this.f12110d != null) {
            str2 = str2 + "interp(" + this.f12110d + ") ";
        }
        if (this.f12111e.size() > 0 || this.f12112f.size() > 0) {
            String str3 = str2 + "tgts(";
            if (this.f12111e.size() > 0) {
                for (int i6 = 0; i6 < this.f12111e.size(); i6++) {
                    if (i6 > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.f12111e.get(i6);
                }
            }
            if (this.f12112f.size() > 0) {
                for (int i7 = 0; i7 < this.f12112f.size(); i7++) {
                    if (i7 > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.f12112f.get(i7);
                }
            }
            return str3 + ")";
        }
        return str2;
    }

    public l b(View view) {
        this.f12112f.add(view);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancel() {
        for (int size = this.f12130z.size() - 1; size >= 0; size--) {
            ((Animator) this.f12130z.get(size)).cancel();
        }
        ArrayList arrayList = this.D;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.D.clone();
        int size2 = arrayList2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            ((f) arrayList2.get(i6)).e(this);
        }
    }

    protected void e(Animator animator) {
        if (animator == null) {
            o();
            return;
        }
        if (p() >= 0) {
            animator.setDuration(p());
        }
        if (x() >= 0) {
            animator.setStartDelay(x() + animator.getStartDelay());
        }
        if (r() != null) {
            animator.setInterpolator(r());
        }
        animator.addListener(new c());
        animator.start();
    }

    public abstract void f(s sVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(s sVar) {
    }

    public abstract void i(s sVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ViewGroup viewGroup, boolean z5) {
        ArrayList arrayList;
        ArrayList arrayList2;
        l.a aVar;
        k(z5);
        if ((this.f12111e.size() > 0 || this.f12112f.size() > 0) && (((arrayList = this.f12113g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f12114h) == null || arrayList2.isEmpty()))) {
            for (int i6 = 0; i6 < this.f12111e.size(); i6++) {
                View findViewById = viewGroup.findViewById(((Integer) this.f12111e.get(i6)).intValue());
                if (findViewById != null) {
                    s sVar = new s(findViewById);
                    if (z5) {
                        i(sVar);
                    } else {
                        f(sVar);
                    }
                    sVar.f12175c.add(this);
                    h(sVar);
                    d(z5 ? this.f12122r : this.f12123s, findViewById, sVar);
                }
            }
            for (int i7 = 0; i7 < this.f12112f.size(); i7++) {
                View view = (View) this.f12112f.get(i7);
                s sVar2 = new s(view);
                if (z5) {
                    i(sVar2);
                } else {
                    f(sVar2);
                }
                sVar2.f12175c.add(this);
                h(sVar2);
                d(z5 ? this.f12122r : this.f12123s, view, sVar2);
            }
        } else {
            g(viewGroup, z5);
        }
        if (z5 || (aVar = this.G) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i8 = 0; i8 < size; i8++) {
            arrayList3.add(this.f12122r.f12179d.remove((String) this.G.i(i8)));
        }
        for (int i9 = 0; i9 < size; i9++) {
            View view2 = (View) arrayList3.get(i9);
            if (view2 != null) {
                this.f12122r.f12179d.put((String) this.G.m(i9), view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(boolean z5) {
        t tVar;
        if (z5) {
            this.f12122r.f12176a.clear();
            this.f12122r.f12177b.clear();
            tVar = this.f12122r;
        } else {
            this.f12123s.f12176a.clear();
            this.f12123s.f12177b.clear();
            tVar = this.f12123s;
        }
        tVar.f12178c.b();
    }

    @Override // 
    /* renamed from: l */
    public l clone() {
        try {
            l lVar = (l) super.clone();
            lVar.E = new ArrayList();
            lVar.f12122r = new t();
            lVar.f12123s = new t();
            lVar.f12126v = null;
            lVar.f12127w = null;
            return lVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator m(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        View view;
        Animator animator;
        s sVar;
        int i6;
        Animator animator2;
        s sVar2;
        l.a w5 = w();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            s sVar3 = (s) arrayList.get(i7);
            s sVar4 = (s) arrayList2.get(i7);
            if (sVar3 != null && !sVar3.f12175c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f12175c.contains(this)) {
                sVar4 = null;
            }
            if (sVar3 != null || sVar4 != null) {
                if (sVar3 == null || sVar4 == null || E(sVar3, sVar4)) {
                    Animator m5 = m(viewGroup, sVar3, sVar4);
                    if (m5 != null) {
                        if (sVar4 != null) {
                            View view2 = sVar4.f12174b;
                            String[] C = C();
                            if (C != null && C.length > 0) {
                                sVar2 = new s(view2);
                                s sVar5 = (s) tVar2.f12176a.get(view2);
                                if (sVar5 != null) {
                                    int i8 = 0;
                                    while (i8 < C.length) {
                                        Map map = sVar2.f12173a;
                                        Animator animator3 = m5;
                                        String str = C[i8];
                                        map.put(str, sVar5.f12173a.get(str));
                                        i8++;
                                        m5 = animator3;
                                        C = C;
                                    }
                                }
                                Animator animator4 = m5;
                                int size2 = w5.size();
                                int i9 = 0;
                                while (true) {
                                    if (i9 >= size2) {
                                        animator2 = animator4;
                                        break;
                                    }
                                    d dVar = (d) w5.get((Animator) w5.i(i9));
                                    if (dVar.f12136c != null && dVar.f12134a == view2 && dVar.f12135b.equals(t()) && dVar.f12136c.equals(sVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i9++;
                                }
                            } else {
                                animator2 = m5;
                                sVar2 = null;
                            }
                            view = view2;
                            animator = animator2;
                            sVar = sVar2;
                        } else {
                            view = sVar3.f12174b;
                            animator = m5;
                            sVar = null;
                        }
                        if (animator != null) {
                            i6 = size;
                            w5.put(animator, new d(view, t(), this, a0.d(viewGroup), sVar));
                            this.E.add(animator);
                            i7++;
                            size = i6;
                        }
                        i6 = size;
                        i7++;
                        size = i6;
                    }
                    i6 = size;
                    i7++;
                    size = i6;
                }
            }
            i6 = size;
            i7++;
            size = i6;
        }
        if (sparseIntArray.size() != 0) {
            for (int i10 = 0; i10 < sparseIntArray.size(); i10++) {
                Animator animator5 = (Animator) this.E.get(sparseIntArray.keyAt(i10));
                animator5.setStartDelay((sparseIntArray.valueAt(i10) - Long.MAX_VALUE) + animator5.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        int i6 = this.A - 1;
        this.A = i6;
        if (i6 == 0) {
            ArrayList arrayList = this.D;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.D.clone();
                int size = arrayList2.size();
                for (int i7 = 0; i7 < size; i7++) {
                    ((f) arrayList2.get(i7)).b(this);
                }
            }
            for (int i8 = 0; i8 < this.f12122r.f12178c.l(); i8++) {
                View view = (View) this.f12122r.f12178c.m(i8);
                if (view != null) {
                    e0.b0.t0(view, false);
                }
            }
            for (int i9 = 0; i9 < this.f12123s.f12178c.l(); i9++) {
                View view2 = (View) this.f12123s.f12178c.m(i9);
                if (view2 != null) {
                    e0.b0.t0(view2, false);
                }
            }
            this.C = true;
        }
    }

    public long p() {
        return this.f12109c;
    }

    public e q() {
        return this.F;
    }

    public TimeInterpolator r() {
        return this.f12110d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s s(View view, boolean z5) {
        p pVar = this.f12124t;
        if (pVar != null) {
            return pVar.s(view, z5);
        }
        ArrayList arrayList = z5 ? this.f12126v : this.f12127w;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            }
            s sVar = (s) arrayList.get(i6);
            if (sVar == null) {
                return null;
            }
            if (sVar.f12174b == view) {
                break;
            }
            i6++;
        }
        if (i6 >= 0) {
            return (s) (z5 ? this.f12127w : this.f12126v).get(i6);
        }
        return null;
    }

    public String t() {
        return this.f12107a;
    }

    public String toString() {
        return a0(HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public g u() {
        return this.H;
    }

    public o v() {
        return null;
    }

    public long x() {
        return this.f12108b;
    }

    public List y() {
        return this.f12111e;
    }

    public List z() {
        return this.f12113g;
    }
}
