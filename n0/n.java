package n0;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    private static l f12143a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadLocal f12144b = new ThreadLocal();

    /* renamed from: c  reason: collision with root package name */
    static ArrayList f12145c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        l f12146b;

        /* renamed from: c  reason: collision with root package name */
        ViewGroup f12147c;

        /* renamed from: n0.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0198a extends m {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l.a f12148a;

            C0198a(l.a aVar) {
                this.f12148a = aVar;
            }

            @Override // n0.l.f
            public void b(l lVar) {
                ((ArrayList) this.f12148a.get(a.this.f12147c)).remove(lVar);
                lVar.O(this);
            }
        }

        a(l lVar, ViewGroup viewGroup) {
            this.f12146b = lVar;
            this.f12147c = viewGroup;
        }

        private void a() {
            this.f12147c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f12147c.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (n.f12145c.remove(this.f12147c)) {
                l.a b6 = n.b();
                ArrayList arrayList = (ArrayList) b6.get(this.f12147c);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    b6.put(this.f12147c, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.f12146b);
                this.f12146b.a(new C0198a(b6));
                this.f12146b.j(this.f12147c, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((l) it.next()).Q(this.f12147c);
                    }
                }
                this.f12146b.N(this.f12147c);
                return true;
            }
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            n.f12145c.remove(this.f12147c);
            ArrayList arrayList = (ArrayList) n.b().get(this.f12147c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).Q(this.f12147c);
                }
            }
            this.f12146b.k(true);
        }
    }

    public static void a(ViewGroup viewGroup, l lVar) {
        if (f12145c.contains(viewGroup) || !e0.b0.R(viewGroup)) {
            return;
        }
        f12145c.add(viewGroup);
        if (lVar == null) {
            lVar = f12143a;
        }
        l clone = lVar.clone();
        d(viewGroup, clone);
        k.b(viewGroup, null);
        c(viewGroup, clone);
    }

    static l.a b() {
        l.a aVar;
        WeakReference weakReference = (WeakReference) f12144b.get();
        if (weakReference == null || (aVar = (l.a) weakReference.get()) == null) {
            l.a aVar2 = new l.a();
            f12144b.set(new WeakReference(aVar2));
            return aVar2;
        }
        return aVar;
    }

    private static void c(ViewGroup viewGroup, l lVar) {
        if (lVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(lVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, l lVar) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((l) it.next()).M(viewGroup);
            }
        }
        if (lVar != null) {
            lVar.j(viewGroup, true);
        }
        k.a(viewGroup);
    }
}
