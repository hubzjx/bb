package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import e0.b0;
import f0.y;
import f0.z;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class k extends e0.a {

    /* renamed from: d  reason: collision with root package name */
    final RecyclerView f2509d;

    /* renamed from: e  reason: collision with root package name */
    private final a f2510e;

    /* loaded from: classes.dex */
    public static class a extends e0.a {

        /* renamed from: d  reason: collision with root package name */
        final k f2511d;

        /* renamed from: e  reason: collision with root package name */
        private Map f2512e = new WeakHashMap();

        public a(k kVar) {
            this.f2511d = kVar;
        }

        @Override // e0.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            e0.a aVar = (e0.a) this.f2512e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // e0.a
        public z b(View view) {
            e0.a aVar = (e0.a) this.f2512e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // e0.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            e0.a aVar = (e0.a) this.f2512e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // e0.a
        public void g(View view, y yVar) {
            if (!this.f2511d.o() && this.f2511d.f2509d.getLayoutManager() != null) {
                this.f2511d.f2509d.getLayoutManager().O0(view, yVar);
                e0.a aVar = (e0.a) this.f2512e.get(view);
                if (aVar != null) {
                    aVar.g(view, yVar);
                    return;
                }
            }
            super.g(view, yVar);
        }

        @Override // e0.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            e0.a aVar = (e0.a) this.f2512e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // e0.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            e0.a aVar = (e0.a) this.f2512e.get(viewGroup);
            return aVar != null ? aVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // e0.a
        public boolean j(View view, int i6, Bundle bundle) {
            if (this.f2511d.o() || this.f2511d.f2509d.getLayoutManager() == null) {
                return super.j(view, i6, bundle);
            }
            e0.a aVar = (e0.a) this.f2512e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i6, bundle)) {
                    return true;
                }
            } else if (super.j(view, i6, bundle)) {
                return true;
            }
            return this.f2511d.f2509d.getLayoutManager().i1(view, i6, bundle);
        }

        @Override // e0.a
        public void l(View view, int i6) {
            e0.a aVar = (e0.a) this.f2512e.get(view);
            if (aVar != null) {
                aVar.l(view, i6);
            } else {
                super.l(view, i6);
            }
        }

        @Override // e0.a
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            e0.a aVar = (e0.a) this.f2512e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public e0.a n(View view) {
            return (e0.a) this.f2512e.remove(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void o(View view) {
            e0.a l6 = b0.l(view);
            if (l6 == null || l6 == this) {
                return;
            }
            this.f2512e.put(view, l6);
        }
    }

    public k(RecyclerView recyclerView) {
        this.f2509d = recyclerView;
        e0.a n5 = n();
        this.f2510e = (n5 == null || !(n5 instanceof a)) ? new a(this) : (a) n5;
    }

    @Override // e0.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().K0(accessibilityEvent);
        }
    }

    @Override // e0.a
    public void g(View view, y yVar) {
        super.g(view, yVar);
        if (o() || this.f2509d.getLayoutManager() == null) {
            return;
        }
        this.f2509d.getLayoutManager().N0(yVar);
    }

    @Override // e0.a
    public boolean j(View view, int i6, Bundle bundle) {
        if (super.j(view, i6, bundle)) {
            return true;
        }
        if (o() || this.f2509d.getLayoutManager() == null) {
            return false;
        }
        return this.f2509d.getLayoutManager().g1(i6, bundle);
    }

    public e0.a n() {
        return this.f2510e;
    }

    boolean o() {
        return this.f2509d.l0();
    }
}
