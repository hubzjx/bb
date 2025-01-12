package androidx.fragment.app;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.l;
import e0.b0;
import e0.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1890a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    private static final o f1891b = new n();

    /* renamed from: c  reason: collision with root package name */
    private static final o f1892c = w();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f1893a;

        a(ArrayList arrayList) {
            this.f1893a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.A(this.f1893a, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f1894a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f1895b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f1896c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Fragment f1897d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f1898e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f1899f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ArrayList f1900g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Object f1901h;

        b(Object obj, o oVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f1894a = obj;
            this.f1895b = oVar;
            this.f1896c = view;
            this.f1897d = fragment;
            this.f1898e = arrayList;
            this.f1899f = arrayList2;
            this.f1900g = arrayList3;
            this.f1901h = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f1894a;
            if (obj != null) {
                this.f1895b.p(obj, this.f1896c);
                this.f1899f.addAll(m.k(this.f1895b, this.f1894a, this.f1897d, this.f1898e, this.f1896c));
            }
            if (this.f1900g != null) {
                if (this.f1901h != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f1896c);
                    this.f1895b.q(this.f1901h, this.f1900g, arrayList);
                }
                this.f1900g.clear();
                this.f1900g.add(this.f1896c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f1902a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f1903b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f1904c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ l.a f1905d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f1906e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ o f1907f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Rect f1908g;

        c(Fragment fragment, Fragment fragment2, boolean z5, l.a aVar, View view, o oVar, Rect rect) {
            this.f1902a = fragment;
            this.f1903b = fragment2;
            this.f1904c = z5;
            this.f1905d = aVar;
            this.f1906e = view;
            this.f1907f = oVar;
            this.f1908g = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.f(this.f1902a, this.f1903b, this.f1904c, this.f1905d, false);
            View view = this.f1906e;
            if (view != null) {
                this.f1907f.k(view, this.f1908g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f1909a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l.a f1910b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f1911c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f1912d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f1913e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f1914f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Fragment f1915g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Fragment f1916h;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ boolean f1917k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ ArrayList f1918l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ Object f1919m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ Rect f1920n;

        d(o oVar, l.a aVar, Object obj, e eVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z5, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f1909a = oVar;
            this.f1910b = aVar;
            this.f1911c = obj;
            this.f1912d = eVar;
            this.f1913e = arrayList;
            this.f1914f = view;
            this.f1915g = fragment;
            this.f1916h = fragment2;
            this.f1917k = z5;
            this.f1918l = arrayList2;
            this.f1919m = obj2;
            this.f1920n = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.a h6 = m.h(this.f1909a, this.f1910b, this.f1911c, this.f1912d);
            if (h6 != null) {
                this.f1913e.addAll(h6.values());
                this.f1913e.add(this.f1914f);
            }
            m.f(this.f1915g, this.f1916h, this.f1917k, h6, false);
            Object obj = this.f1911c;
            if (obj != null) {
                this.f1909a.z(obj, this.f1918l, this.f1913e);
                View s5 = m.s(h6, this.f1912d, this.f1919m, this.f1917k);
                if (s5 != null) {
                    this.f1909a.k(s5, this.f1920n);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f1921a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1922b;

        /* renamed from: c  reason: collision with root package name */
        public androidx.fragment.app.a f1923c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f1924d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1925e;

        /* renamed from: f  reason: collision with root package name */
        public androidx.fragment.app.a f1926f;

        e() {
        }
    }

    static void A(ArrayList arrayList, int i6) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void B(h hVar, ArrayList arrayList, ArrayList arrayList2, int i6, int i7, boolean z5) {
        if (hVar.f1798q < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i8 = i6; i8 < i7; i8++) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i8);
            if (((Boolean) arrayList2.get(i8)).booleanValue()) {
                e(aVar, sparseArray, z5);
            } else {
                c(aVar, sparseArray, z5);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(hVar.f1799r.i());
            int size = sparseArray.size();
            for (int i9 = 0; i9 < size; i9++) {
                int keyAt = sparseArray.keyAt(i9);
                l.a d6 = d(keyAt, arrayList, arrayList2, i6, i7);
                e eVar = (e) sparseArray.valueAt(i9);
                if (z5) {
                    o(hVar, keyAt, eVar, view, d6);
                } else {
                    n(hVar, keyAt, eVar, view, d6);
                }
            }
        }
    }

    private static void a(ArrayList arrayList, l.a aVar, Collection collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.m(size);
            if (collection.contains(b0.J(view))) {
                arrayList.add(view);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0041, code lost:
        if (r10.f1700l != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0076, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0090, code lost:
        if (r10.f1714z == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0092, code lost:
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ae A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00e5 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(androidx.fragment.app.a aVar, l.a aVar2, SparseArray sparseArray, boolean z5, boolean z6) {
        int i6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        e eVar;
        h hVar;
        Fragment fragment = aVar2.f1883b;
        if (fragment == null || (i6 = fragment.f1712x) == 0) {
            return;
        }
        int i7 = z5 ? f1890a[aVar2.f1882a] : aVar2.f1882a;
        boolean z11 = false;
        if (i7 != 1) {
            if (i7 != 3) {
                if (i7 == 4) {
                    boolean z12 = !z6 ? false : false;
                    z9 = z12;
                    z8 = false;
                    z10 = true;
                    e eVar2 = (e) sparseArray.get(i6);
                    if (z11) {
                    }
                    eVar = eVar2;
                    if (!z6) {
                    }
                    if (z9) {
                    }
                    if (z6) {
                    }
                } else if (i7 != 5) {
                    if (i7 != 6) {
                        if (i7 != 7) {
                            z8 = false;
                            z10 = false;
                            z9 = false;
                            e eVar22 = (e) sparseArray.get(i6);
                            if (z11) {
                                eVar22 = p(eVar22, sparseArray, i6);
                                eVar22.f1921a = fragment;
                                eVar22.f1922b = z5;
                                eVar22.f1923c = aVar;
                            }
                            eVar = eVar22;
                            if (!z6 && z8) {
                                if (eVar != null && eVar.f1924d == fragment) {
                                    eVar.f1924d = null;
                                }
                                hVar = aVar.f1758s;
                                if (fragment.f1690b < 1 && hVar.f1798q >= 1 && !aVar.f1880q) {
                                    hVar.J0(fragment);
                                    hVar.R0(fragment, 1, 0, 0, false);
                                }
                            }
                            if (z9 && (eVar == null || eVar.f1924d == null)) {
                                eVar = p(eVar, sparseArray, i6);
                                eVar.f1924d = fragment;
                                eVar.f1925e = z5;
                                eVar.f1926f = aVar;
                            }
                            if (z6 || !z10 || eVar == null || eVar.f1921a != fragment) {
                                return;
                            }
                            eVar.f1921a = null;
                            return;
                        }
                    }
                } else if (z6) {
                    if (fragment.O) {
                        if (!fragment.f1714z) {
                        }
                    }
                    z7 = false;
                    z11 = z7;
                    z8 = true;
                    z10 = false;
                    z9 = false;
                    e eVar222 = (e) sparseArray.get(i6);
                    if (z11) {
                    }
                    eVar = eVar222;
                    if (!z6) {
                        if (eVar != null) {
                            eVar.f1924d = null;
                        }
                        hVar = aVar.f1758s;
                        if (fragment.f1690b < 1) {
                            hVar.J0(fragment);
                            hVar.R0(fragment, 1, 0, 0, false);
                        }
                    }
                    if (z9) {
                        eVar = p(eVar, sparseArray, i6);
                        eVar.f1924d = fragment;
                        eVar.f1925e = z5;
                        eVar.f1926f = aVar;
                    }
                    if (z6) {
                        return;
                    }
                    return;
                } else {
                    z7 = fragment.f1714z;
                    z11 = z7;
                    z8 = true;
                    z10 = false;
                    z9 = false;
                    e eVar2222 = (e) sparseArray.get(i6);
                    if (z11) {
                    }
                    eVar = eVar2222;
                    if (!z6) {
                    }
                    if (z9) {
                    }
                    if (z6) {
                    }
                }
            }
            boolean z13 = fragment.f1700l;
            if (!z6) {
            }
            z9 = z12;
            z8 = false;
            z10 = true;
            e eVar22222 = (e) sparseArray.get(i6);
            if (z11) {
            }
            eVar = eVar22222;
            if (!z6) {
            }
            if (z9) {
            }
            if (z6) {
            }
        }
        if (z6) {
            z7 = fragment.N;
            z11 = z7;
            z8 = true;
            z10 = false;
            z9 = false;
            e eVar222222 = (e) sparseArray.get(i6);
            if (z11) {
            }
            eVar = eVar222222;
            if (!z6) {
            }
            if (z9) {
            }
            if (z6) {
            }
        } else {
            if (!fragment.f1700l) {
            }
            z7 = false;
            z11 = z7;
            z8 = true;
            z10 = false;
            z9 = false;
            e eVar2222222 = (e) sparseArray.get(i6);
            if (z11) {
            }
            eVar = eVar2222222;
            if (!z6) {
            }
            if (z9) {
            }
            if (z6) {
            }
        }
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray sparseArray, boolean z5) {
        int size = aVar.f1864a.size();
        for (int i6 = 0; i6 < size; i6++) {
            b(aVar, (l.a) aVar.f1864a.get(i6), sparseArray, false, z5);
        }
    }

    private static l.a d(int i6, ArrayList arrayList, ArrayList arrayList2, int i7, int i8) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        l.a aVar = new l.a();
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) arrayList.get(i9);
            if (aVar2.s(i6)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i9)).booleanValue();
                ArrayList arrayList5 = aVar2.f1878o;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.f1878o;
                        arrayList4 = aVar2.f1879p;
                    } else {
                        ArrayList arrayList6 = aVar2.f1878o;
                        arrayList3 = aVar2.f1879p;
                        arrayList4 = arrayList6;
                    }
                    for (int i10 = 0; i10 < size; i10++) {
                        String str = (String) arrayList4.get(i10);
                        String str2 = (String) arrayList3.get(i10);
                        String str3 = (String) aVar.remove(str2);
                        if (str3 != null) {
                            aVar.put(str, str3);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray sparseArray, boolean z5) {
        if (aVar.f1758s.f1800s.e()) {
            for (int size = aVar.f1864a.size() - 1; size >= 0; size--) {
                b(aVar, (l.a) aVar.f1864a.get(size), sparseArray, true, z5);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z5, l.a aVar, boolean z6) {
        if (z5) {
            fragment2.r();
        } else {
            fragment.r();
        }
    }

    private static boolean g(o oVar, List list) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (!oVar.e(list.get(i6))) {
                return false;
            }
        }
        return true;
    }

    static l.a h(o oVar, l.a aVar, Object obj, e eVar) {
        ArrayList arrayList;
        Fragment fragment = eVar.f1921a;
        View K = fragment.K();
        if (aVar.isEmpty() || obj == null || K == null) {
            aVar.clear();
            return null;
        }
        l.a aVar2 = new l.a();
        oVar.j(aVar2, K);
        androidx.fragment.app.a aVar3 = eVar.f1923c;
        if (eVar.f1922b) {
            fragment.t();
            arrayList = aVar3.f1878o;
        } else {
            fragment.r();
            arrayList = aVar3.f1879p;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
            aVar2.o(aVar.values());
        }
        x(aVar, aVar2);
        return aVar2;
    }

    private static l.a i(o oVar, l.a aVar, Object obj, e eVar) {
        ArrayList arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = eVar.f1924d;
        l.a aVar2 = new l.a();
        oVar.j(aVar2, fragment.a1());
        androidx.fragment.app.a aVar3 = eVar.f1926f;
        if (eVar.f1925e) {
            fragment.r();
            arrayList = aVar3.f1879p;
        } else {
            fragment.t();
            arrayList = aVar3.f1878o;
        }
        aVar2.o(arrayList);
        aVar.o(aVar2.keySet());
        return aVar2;
    }

    private static o j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object s5 = fragment.s();
            if (s5 != null) {
                arrayList.add(s5);
            }
            Object E = fragment.E();
            if (E != null) {
                arrayList.add(E);
            }
            Object G = fragment.G();
            if (G != null) {
                arrayList.add(G);
            }
        }
        if (fragment2 != null) {
            Object q5 = fragment2.q();
            if (q5 != null) {
                arrayList.add(q5);
            }
            Object B = fragment2.B();
            if (B != null) {
                arrayList.add(B);
            }
            Object F = fragment2.F();
            if (F != null) {
                arrayList.add(F);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        o oVar = f1891b;
        if (oVar == null || !g(oVar, arrayList)) {
            o oVar2 = f1892c;
            if (oVar2 == null || !g(oVar2, arrayList)) {
                if (oVar == null && oVar2 == null) {
                    return null;
                }
                throw new IllegalArgumentException("Invalid Transition types");
            }
            return oVar2;
        }
        return oVar;
    }

    static ArrayList k(o oVar, Object obj, Fragment fragment, ArrayList arrayList, View view) {
        if (obj != null) {
            ArrayList arrayList2 = new ArrayList();
            View K = fragment.K();
            if (K != null) {
                oVar.f(arrayList2, K);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (arrayList2.isEmpty()) {
                return arrayList2;
            }
            arrayList2.add(view);
            oVar.b(obj, arrayList2);
            return arrayList2;
        }
        return null;
    }

    private static Object l(o oVar, ViewGroup viewGroup, View view, l.a aVar, e eVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        Object t5;
        l.a aVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = eVar.f1921a;
        Fragment fragment2 = eVar.f1924d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z5 = eVar.f1922b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            t5 = null;
        } else {
            t5 = t(oVar, fragment, fragment2, z5);
            aVar2 = aVar;
        }
        l.a i6 = i(oVar, aVar2, t5, eVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(i6.values());
            obj3 = t5;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z5, i6, true);
        if (obj3 != null) {
            rect = new Rect();
            oVar.y(obj3, view, arrayList);
            z(oVar, obj3, obj2, i6, eVar.f1925e, eVar.f1926f);
            if (obj != null) {
                oVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        w.a(viewGroup, new d(oVar, aVar, obj3, eVar, arrayList2, view, fragment, fragment2, z5, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(o oVar, ViewGroup viewGroup, View view, l.a aVar, e eVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = eVar.f1921a;
        Fragment fragment2 = eVar.f1924d;
        if (fragment != null) {
            fragment.a1().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z5 = eVar.f1922b;
        Object t5 = aVar.isEmpty() ? null : t(oVar, fragment, fragment2, z5);
        l.a i6 = i(oVar, aVar, t5, eVar);
        l.a h6 = h(oVar, aVar, t5, eVar);
        if (aVar.isEmpty()) {
            if (i6 != null) {
                i6.clear();
            }
            if (h6 != null) {
                h6.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, i6, aVar.keySet());
            a(arrayList2, h6, aVar.values());
            obj3 = t5;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z5, i6, true);
        if (obj3 != null) {
            arrayList2.add(view);
            oVar.y(obj3, view, arrayList);
            z(oVar, obj3, obj2, i6, eVar.f1925e, eVar.f1926f);
            Rect rect2 = new Rect();
            View s5 = s(h6, eVar, obj, z5);
            if (s5 != null) {
                oVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = s5;
        } else {
            view2 = null;
            rect = null;
        }
        w.a(viewGroup, new c(fragment, fragment2, z5, h6, view2, oVar, rect));
        return obj3;
    }

    private static void n(h hVar, int i6, e eVar, View view, l.a aVar) {
        Fragment fragment;
        Fragment fragment2;
        o j6;
        Object obj;
        ViewGroup viewGroup = hVar.f1800s.e() ? (ViewGroup) hVar.f1800s.d(i6) : null;
        if (viewGroup == null || (j6 = j((fragment2 = eVar.f1924d), (fragment = eVar.f1921a))) == null) {
            return;
        }
        boolean z5 = eVar.f1922b;
        boolean z6 = eVar.f1925e;
        Object q5 = q(j6, fragment, z5);
        Object r5 = r(j6, fragment2, z6);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Object l6 = l(j6, viewGroup, view, aVar, eVar, arrayList, arrayList2, q5, r5);
        if (q5 == null && l6 == null) {
            obj = r5;
            if (obj == null) {
                return;
            }
        } else {
            obj = r5;
        }
        ArrayList k6 = k(j6, obj, fragment2, arrayList, view);
        Object obj2 = (k6 == null || k6.isEmpty()) ? null : obj;
        j6.a(q5, view);
        Object u5 = u(j6, q5, obj2, l6, fragment, eVar.f1922b);
        if (u5 != null) {
            ArrayList arrayList3 = new ArrayList();
            j6.t(u5, q5, arrayList3, obj2, k6, l6, arrayList2);
            y(j6, viewGroup, fragment, view, arrayList2, q5, arrayList3, obj2, k6);
            j6.w(viewGroup, arrayList2, aVar);
            j6.c(viewGroup, u5);
            j6.s(viewGroup, arrayList2, aVar);
        }
    }

    private static void o(h hVar, int i6, e eVar, View view, l.a aVar) {
        Fragment fragment;
        Fragment fragment2;
        o j6;
        Object obj;
        ViewGroup viewGroup = hVar.f1800s.e() ? (ViewGroup) hVar.f1800s.d(i6) : null;
        if (viewGroup == null || (j6 = j((fragment2 = eVar.f1924d), (fragment = eVar.f1921a))) == null) {
            return;
        }
        boolean z5 = eVar.f1922b;
        boolean z6 = eVar.f1925e;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Object q5 = q(j6, fragment, z5);
        Object r5 = r(j6, fragment2, z6);
        Object m5 = m(j6, viewGroup, view, aVar, eVar, arrayList2, arrayList, q5, r5);
        if (q5 == null && m5 == null) {
            obj = r5;
            if (obj == null) {
                return;
            }
        } else {
            obj = r5;
        }
        ArrayList k6 = k(j6, obj, fragment2, arrayList2, view);
        ArrayList k7 = k(j6, q5, fragment, arrayList, view);
        A(k7, 4);
        Object u5 = u(j6, q5, obj, m5, fragment, z5);
        if (u5 != null) {
            v(j6, obj, fragment2, k6);
            ArrayList o5 = j6.o(arrayList);
            j6.t(u5, q5, k7, obj, k6, m5, arrayList);
            j6.c(viewGroup, u5);
            j6.x(viewGroup, arrayList2, arrayList, o5, aVar);
            A(k7, 0);
            j6.z(m5, arrayList2, arrayList);
        }
    }

    private static e p(e eVar, SparseArray sparseArray, int i6) {
        if (eVar == null) {
            e eVar2 = new e();
            sparseArray.put(i6, eVar2);
            return eVar2;
        }
        return eVar;
    }

    private static Object q(o oVar, Fragment fragment, boolean z5) {
        if (fragment == null) {
            return null;
        }
        return oVar.g(z5 ? fragment.B() : fragment.q());
    }

    private static Object r(o oVar, Fragment fragment, boolean z5) {
        if (fragment == null) {
            return null;
        }
        return oVar.g(z5 ? fragment.E() : fragment.s());
    }

    static View s(l.a aVar, e eVar, Object obj, boolean z5) {
        ArrayList arrayList;
        androidx.fragment.app.a aVar2 = eVar.f1923c;
        if (obj == null || aVar == null || (arrayList = aVar2.f1878o) == null || arrayList.isEmpty()) {
            return null;
        }
        return (View) aVar.get((String) (z5 ? aVar2.f1878o : aVar2.f1879p).get(0));
    }

    private static Object t(o oVar, Fragment fragment, Fragment fragment2, boolean z5) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return oVar.A(oVar.g(z5 ? fragment2.G() : fragment.F()));
    }

    private static Object u(o oVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z5) {
        return (obj == null || obj2 == null || fragment == null) ? true : z5 ? fragment.k() : fragment.j() ? oVar.n(obj2, obj, obj3) : oVar.m(obj2, obj, obj3);
    }

    private static void v(o oVar, Object obj, Fragment fragment, ArrayList arrayList) {
        if (fragment != null && obj != null && fragment.f1700l && fragment.f1714z && fragment.O) {
            fragment.g1(true);
            oVar.r(obj, fragment.K(), arrayList);
            w.a(fragment.G, new a(arrayList));
        }
    }

    private static o w() {
        try {
            return (o) n0.e.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void x(l.a aVar, l.a aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey((String) aVar.m(size))) {
                aVar.k(size);
            }
        }
    }

    private static void y(o oVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList arrayList, Object obj, ArrayList arrayList2, Object obj2, ArrayList arrayList3) {
        w.a(viewGroup, new b(obj, oVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void z(o oVar, Object obj, Object obj2, l.a aVar, boolean z5, androidx.fragment.app.a aVar2) {
        ArrayList arrayList = aVar2.f1878o;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = (View) aVar.get((String) (z5 ? aVar2.f1879p : aVar2.f1878o).get(0));
        oVar.v(obj, view);
        if (obj2 != null) {
            oVar.v(obj2, view);
        }
    }
}
