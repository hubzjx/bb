package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import e0.b0;
import e0.p0;
import e0.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class o {

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1941a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f1942b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f1943c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f1944d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f1945e;

        a(int i6, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f1941a = i6;
            this.f1942b = arrayList;
            this.f1943c = arrayList2;
            this.f1944d = arrayList3;
            this.f1945e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i6 = 0; i6 < this.f1941a; i6++) {
                b0.z0((View) this.f1942b.get(i6), (String) this.f1943c.get(i6));
                b0.z0((View) this.f1944d.get(i6), (String) this.f1945e.get(i6));
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f1947a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f1948b;

        b(ArrayList arrayList, Map map) {
            this.f1947a = arrayList;
            this.f1948b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f1947a.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = (View) this.f1947a.get(i6);
                String J = b0.J(view);
                if (J != null) {
                    b0.z0(view, o.i(this.f1948b, J));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f1950a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f1951b;

        c(ArrayList arrayList, Map map) {
            this.f1950a = arrayList;
            this.f1951b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f1950a.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = (View) this.f1950a.get(i6);
                b0.z0(view, (String) this.f1951b.get(b0.J(view)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d(List list, View view) {
        int size = list.size();
        if (h(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i6 = size; i6 < list.size(); i6++) {
            View view2 = (View) list.get(i6);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = viewGroup.getChildAt(i7);
                    if (!h(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean h(List list, View view, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            if (list.get(i7) == view) {
                return true;
            }
        }
        return false;
    }

    static String i(Map map, String str) {
        for (Map.Entry entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract Object A(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ArrayList arrayList, View view) {
        if (view.getVisibility() == 0) {
            boolean z5 = view instanceof ViewGroup;
            ViewGroup viewGroup = view;
            if (z5) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                boolean a6 = p0.a(viewGroup2);
                viewGroup = viewGroup2;
                if (!a6) {
                    int childCount = viewGroup2.getChildCount();
                    for (int i6 = 0; i6 < childCount; i6++) {
                        f(arrayList, viewGroup2.getChildAt(i6));
                    }
                    return;
                }
            }
            arrayList.add(viewGroup);
        }
    }

    public abstract Object g(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Map map, View view) {
        if (view.getVisibility() == 0) {
            String J = b0.J(view);
            if (J != null) {
                map.put(J, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    j(map, viewGroup.getChildAt(i6));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i6 = iArr[0];
        rect.set(i6, iArr[1], view.getWidth() + i6, iArr[1] + view.getHeight());
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList o(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = (View) arrayList.get(i6);
            arrayList2.add(b0.J(view));
            b0.z0(view, null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract void r(Object obj, View view, ArrayList arrayList);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(ViewGroup viewGroup, ArrayList arrayList, Map map) {
        w.a(viewGroup, new c(arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(View view, ArrayList arrayList, Map map) {
        w.a(view, new b(arrayList, map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(View view, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Map map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = (View) arrayList.get(i6);
            String J = b0.J(view2);
            arrayList4.add(J);
            if (J != null) {
                b0.z0(view2, null);
                String str = (String) map.get(J);
                int i7 = 0;
                while (true) {
                    if (i7 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i7))) {
                        b0.z0((View) arrayList2.get(i7), J);
                        break;
                    } else {
                        i7++;
                    }
                }
            }
        }
        w.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void y(Object obj, View view, ArrayList arrayList);

    public abstract void z(Object obj, ArrayList arrayList, ArrayList arrayList2);
}
