package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.n;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends androidx.lifecycle.m {

    /* renamed from: i  reason: collision with root package name */
    private static final n.a f1843i = new a();

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1847f;

    /* renamed from: c  reason: collision with root package name */
    private final HashSet f1844c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    private final HashMap f1845d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final HashMap f1846e = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private boolean f1848g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1849h = false;

    /* loaded from: classes.dex */
    static class a implements n.a {
        a() {
        }

        @Override // androidx.lifecycle.n.a
        public androidx.lifecycle.m a(Class cls) {
            return new j(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(boolean z5) {
        this.f1847f = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j g(androidx.lifecycle.o oVar) {
        return (j) new androidx.lifecycle.n(oVar, f1843i).a(j.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.m
    public void c() {
        if (h.I) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1848g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Fragment fragment) {
        return this.f1844c.add(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment) {
        if (h.I) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        j jVar = (j) this.f1845d.get(fragment.f1694f);
        if (jVar != null) {
            jVar.c();
            this.f1845d.remove(fragment.f1694f);
        }
        androidx.lifecycle.o oVar = (androidx.lifecycle.o) this.f1846e.get(fragment.f1694f);
        if (oVar != null) {
            oVar.a();
            this.f1846e.remove(fragment.f1694f);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f1844c.equals(jVar.f1844c) && this.f1845d.equals(jVar.f1845d) && this.f1846e.equals(jVar.f1846e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j f(Fragment fragment) {
        j jVar = (j) this.f1845d.get(fragment.f1694f);
        if (jVar == null) {
            j jVar2 = new j(this.f1847f);
            this.f1845d.put(fragment.f1694f, jVar2);
            return jVar2;
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection h() {
        return this.f1844c;
    }

    public int hashCode() {
        return (((this.f1844c.hashCode() * 31) + this.f1845d.hashCode()) * 31) + this.f1846e.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.o i(Fragment fragment) {
        androidx.lifecycle.o oVar = (androidx.lifecycle.o) this.f1846e.get(fragment.f1694f);
        if (oVar == null) {
            androidx.lifecycle.o oVar2 = new androidx.lifecycle.o();
            this.f1846e.put(fragment.f1694f, oVar2);
            return oVar2;
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.f1848g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k(Fragment fragment) {
        return this.f1844c.remove(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(Fragment fragment) {
        if (this.f1844c.contains(fragment)) {
            return this.f1847f ? this.f1848g : !this.f1849h;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f1844c.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f1845d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f1846e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
