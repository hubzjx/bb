package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.fragment.app.l;
import java.io.PrintWriter;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends l implements h.j {

    /* renamed from: s  reason: collision with root package name */
    final h f1758s;

    /* renamed from: t  reason: collision with root package name */
    boolean f1759t;

    /* renamed from: u  reason: collision with root package name */
    int f1760u = -1;

    public a(h hVar) {
        this.f1758s = hVar;
    }

    private static boolean u(l.a aVar) {
        Fragment fragment = aVar.f1883b;
        return (fragment == null || !fragment.f1700l || fragment.H == null || fragment.A || fragment.f1714z || !fragment.Q()) ? false : true;
    }

    @Override // androidx.fragment.app.h.j
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (h.I) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f1871h) {
            this.f1758s.i(this);
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.l
    public int c() {
        return l(false);
    }

    @Override // androidx.fragment.app.l
    public int d() {
        return l(true);
    }

    @Override // androidx.fragment.app.l
    public void e() {
        f();
        this.f1758s.k0(this, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.l
    public void g(int i6, Fragment fragment, String str, int i7) {
        super.g(i6, fragment, str, i7);
        fragment.f1707s = this.f1758s;
    }

    @Override // androidx.fragment.app.l
    public l h(Fragment fragment) {
        h hVar = fragment.f1707s;
        if (hVar == null || hVar == this.f1758s) {
            return super.h(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i6) {
        l.a aVar;
        if (this.f1871h) {
            if (h.I) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i6);
            }
            int size = this.f1864a.size();
            for (int i7 = 0; i7 < size; i7++) {
                Fragment fragment = ((l.a) this.f1864a.get(i7)).f1883b;
                if (fragment != null) {
                    fragment.f1706r += i6;
                    if (h.I) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f1883b + " to " + aVar.f1883b.f1706r);
                    }
                }
            }
        }
    }

    int l(boolean z5) {
        if (this.f1759t) {
            throw new IllegalStateException("commit already called");
        }
        if (h.I) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new d0.c("FragmentManager"));
            m("  ", printWriter);
            printWriter.close();
        }
        this.f1759t = true;
        this.f1760u = this.f1871h ? this.f1758s.l(this) : -1;
        this.f1758s.g0(this, z5);
        return this.f1760u;
    }

    public void m(String str, PrintWriter printWriter) {
        n(str, printWriter, true);
    }

    public void n(String str, PrintWriter printWriter, boolean z5) {
        String str2;
        if (z5) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1873j);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1760u);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1759t);
            if (this.f1869f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1869f));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f1870g));
            }
            if (this.f1865b != 0 || this.f1866c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1865b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1866c));
            }
            if (this.f1867d != 0 || this.f1868e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1867d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1868e));
            }
            if (this.f1874k != 0 || this.f1875l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1874k));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1875l);
            }
            if (this.f1876m != 0 || this.f1877n != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1876m));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1877n);
            }
        }
        if (this.f1864a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1864a.size();
        for (int i6 = 0; i6 < size; i6++) {
            l.a aVar = (l.a) this.f1864a.get(i6);
            switch (aVar.f1882a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f1882a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i6);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f1883b);
            if (z5) {
                if (aVar.f1884c != 0 || aVar.f1885d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1884c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1885d));
                }
                if (aVar.f1886e != 0 || aVar.f1887f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1886e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1887f));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        int size = this.f1864a.size();
        for (int i6 = 0; i6 < size; i6++) {
            l.a aVar = (l.a) this.f1864a.get(i6);
            Fragment fragment = aVar.f1883b;
            if (fragment != null) {
                fragment.i1(this.f1869f, this.f1870g);
            }
            switch (aVar.f1882a) {
                case 1:
                    fragment.h1(aVar.f1884c);
                    this.f1758s.j(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1882a);
                case 3:
                    fragment.h1(aVar.f1885d);
                    this.f1758s.Y0(fragment);
                    break;
                case 4:
                    fragment.h1(aVar.f1885d);
                    this.f1758s.C0(fragment);
                    break;
                case 5:
                    fragment.h1(aVar.f1884c);
                    this.f1758s.l1(fragment);
                    break;
                case 6:
                    fragment.h1(aVar.f1885d);
                    this.f1758s.v(fragment);
                    break;
                case 7:
                    fragment.h1(aVar.f1884c);
                    this.f1758s.o(fragment);
                    break;
                case 8:
                    this.f1758s.k1(fragment);
                    break;
                case 9:
                    this.f1758s.k1(null);
                    break;
                case 10:
                    this.f1758s.j1(fragment, aVar.f1889h);
                    break;
            }
            if (!this.f1880q && aVar.f1882a != 1 && fragment != null) {
                this.f1758s.O0(fragment);
            }
        }
        if (this.f1880q) {
            return;
        }
        h hVar = this.f1758s;
        hVar.P0(hVar.f1798q, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(boolean z5) {
        for (int size = this.f1864a.size() - 1; size >= 0; size--) {
            l.a aVar = (l.a) this.f1864a.get(size);
            Fragment fragment = aVar.f1883b;
            if (fragment != null) {
                fragment.i1(h.d1(this.f1869f), this.f1870g);
            }
            switch (aVar.f1882a) {
                case 1:
                    fragment.h1(aVar.f1887f);
                    this.f1758s.Y0(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1882a);
                case 3:
                    fragment.h1(aVar.f1886e);
                    this.f1758s.j(fragment, false);
                    break;
                case 4:
                    fragment.h1(aVar.f1886e);
                    this.f1758s.l1(fragment);
                    break;
                case 5:
                    fragment.h1(aVar.f1887f);
                    this.f1758s.C0(fragment);
                    break;
                case 6:
                    fragment.h1(aVar.f1886e);
                    this.f1758s.o(fragment);
                    break;
                case 7:
                    fragment.h1(aVar.f1887f);
                    this.f1758s.v(fragment);
                    break;
                case 8:
                    this.f1758s.k1(null);
                    break;
                case 9:
                    this.f1758s.k1(fragment);
                    break;
                case 10:
                    this.f1758s.j1(fragment, aVar.f1888g);
                    break;
            }
            if (!this.f1880q && aVar.f1882a != 3 && fragment != null) {
                this.f1758s.O0(fragment);
            }
        }
        if (this.f1880q || !z5) {
            return;
        }
        h hVar = this.f1758s;
        hVar.P0(hVar.f1798q, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment q(ArrayList arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i6 = 0;
        while (i6 < this.f1864a.size()) {
            l.a aVar = (l.a) this.f1864a.get(i6);
            int i7 = aVar.f1882a;
            if (i7 != 1) {
                if (i7 == 2) {
                    Fragment fragment3 = aVar.f1883b;
                    int i8 = fragment3.f1712x;
                    boolean z5 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = (Fragment) arrayList.get(size);
                        if (fragment4.f1712x == i8) {
                            if (fragment4 == fragment3) {
                                z5 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f1864a.add(i6, new l.a(9, fragment4));
                                    i6++;
                                    fragment2 = null;
                                }
                                l.a aVar2 = new l.a(3, fragment4);
                                aVar2.f1884c = aVar.f1884c;
                                aVar2.f1886e = aVar.f1886e;
                                aVar2.f1885d = aVar.f1885d;
                                aVar2.f1887f = aVar.f1887f;
                                this.f1864a.add(i6, aVar2);
                                arrayList.remove(fragment4);
                                i6++;
                            }
                        }
                    }
                    if (z5) {
                        this.f1864a.remove(i6);
                        i6--;
                    } else {
                        aVar.f1882a = 1;
                        arrayList.add(fragment3);
                    }
                } else if (i7 == 3 || i7 == 6) {
                    arrayList.remove(aVar.f1883b);
                    Fragment fragment5 = aVar.f1883b;
                    if (fragment5 == fragment2) {
                        this.f1864a.add(i6, new l.a(9, fragment5));
                        i6++;
                        fragment2 = null;
                    }
                } else if (i7 != 7) {
                    if (i7 == 8) {
                        this.f1864a.add(i6, new l.a(9, fragment2));
                        i6++;
                        fragment2 = aVar.f1883b;
                    }
                }
                i6++;
            }
            arrayList.add(aVar.f1883b);
            i6++;
        }
        return fragment2;
    }

    public String r() {
        return this.f1873j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s(int i6) {
        int size = this.f1864a.size();
        for (int i7 = 0; i7 < size; i7++) {
            Fragment fragment = ((l.a) this.f1864a.get(i7)).f1883b;
            int i8 = fragment != null ? fragment.f1712x : 0;
            if (i8 != 0 && i8 == i6) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(ArrayList arrayList, int i6, int i7) {
        if (i7 == i6) {
            return false;
        }
        int size = this.f1864a.size();
        int i8 = -1;
        for (int i9 = 0; i9 < size; i9++) {
            Fragment fragment = ((l.a) this.f1864a.get(i9)).f1883b;
            int i10 = fragment != null ? fragment.f1712x : 0;
            if (i10 != 0 && i10 != i8) {
                for (int i11 = i6; i11 < i7; i11++) {
                    a aVar = (a) arrayList.get(i11);
                    int size2 = aVar.f1864a.size();
                    for (int i12 = 0; i12 < size2; i12++) {
                        Fragment fragment2 = ((l.a) aVar.f1864a.get(i12)).f1883b;
                        if ((fragment2 != null ? fragment2.f1712x : 0) == i10) {
                            return true;
                        }
                    }
                }
                i8 = i10;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1760u >= 0) {
            sb.append(" #");
            sb.append(this.f1760u);
        }
        if (this.f1873j != null) {
            sb.append(" ");
            sb.append(this.f1873j);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v() {
        for (int i6 = 0; i6 < this.f1864a.size(); i6++) {
            if (u((l.a) this.f1864a.get(i6))) {
                return true;
            }
        }
        return false;
    }

    public void w() {
        if (this.f1881r != null) {
            for (int i6 = 0; i6 < this.f1881r.size(); i6++) {
                ((Runnable) this.f1881r.get(i6)).run();
            }
            this.f1881r = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(Fragment.f fVar) {
        for (int i6 = 0; i6 < this.f1864a.size(); i6++) {
            l.a aVar = (l.a) this.f1864a.get(i6);
            if (u(aVar)) {
                aVar.f1883b.j1(fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment y(ArrayList arrayList, Fragment fragment) {
        for (int size = this.f1864a.size() - 1; size >= 0; size--) {
            l.a aVar = (l.a) this.f1864a.get(size);
            int i6 = aVar.f1882a;
            if (i6 != 1) {
                if (i6 != 3) {
                    switch (i6) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f1883b;
                            break;
                        case 10:
                            aVar.f1889h = aVar.f1888g;
                            break;
                    }
                }
                arrayList.add(aVar.f1883b);
            }
            arrayList.remove(aVar.f1883b);
        }
        return fragment;
    }
}
