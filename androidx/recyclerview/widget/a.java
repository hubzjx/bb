package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements h.a {

    /* renamed from: a  reason: collision with root package name */
    private d0.f f2371a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList f2372b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList f2373c;

    /* renamed from: d  reason: collision with root package name */
    final InterfaceC0021a f2374d;

    /* renamed from: e  reason: collision with root package name */
    Runnable f2375e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f2376f;

    /* renamed from: g  reason: collision with root package name */
    final h f2377g;

    /* renamed from: h  reason: collision with root package name */
    private int f2378h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0021a {
        void a(int i6, int i7);

        void b(b bVar);

        RecyclerView.c0 c(int i6);

        void d(int i6, int i7);

        void e(int i6, int i7);

        void f(int i6, int i7);

        void g(b bVar);

        void h(int i6, int i7, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f2379a;

        /* renamed from: b  reason: collision with root package name */
        int f2380b;

        /* renamed from: c  reason: collision with root package name */
        Object f2381c;

        /* renamed from: d  reason: collision with root package name */
        int f2382d;

        b(int i6, int i7, int i8, Object obj) {
            this.f2379a = i6;
            this.f2380b = i7;
            this.f2382d = i8;
            this.f2381c = obj;
        }

        String a() {
            int i6 = this.f2379a;
            return i6 != 1 ? i6 != 2 ? i6 != 4 ? i6 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i6 = this.f2379a;
            if (i6 != bVar.f2379a) {
                return false;
            }
            if (i6 == 8 && Math.abs(this.f2382d - this.f2380b) == 1 && this.f2382d == bVar.f2380b && this.f2380b == bVar.f2382d) {
                return true;
            }
            if (this.f2382d == bVar.f2382d && this.f2380b == bVar.f2380b) {
                Object obj2 = this.f2381c;
                Object obj3 = bVar.f2381c;
                if (obj2 != null) {
                    if (!obj2.equals(obj3)) {
                        return false;
                    }
                } else if (obj3 != null) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f2379a * 31) + this.f2380b) * 31) + this.f2382d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f2380b + "c:" + this.f2382d + ",p:" + this.f2381c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InterfaceC0021a interfaceC0021a) {
        this(interfaceC0021a, false);
    }

    private void c(b bVar) {
        r(bVar);
    }

    private void d(b bVar) {
        r(bVar);
    }

    private void f(b bVar) {
        boolean z5;
        char c6;
        int i6 = bVar.f2380b;
        int i7 = bVar.f2382d + i6;
        char c7 = 65535;
        int i8 = i6;
        int i9 = 0;
        while (i8 < i7) {
            if (this.f2374d.c(i8) != null || h(i8)) {
                if (c7 == 0) {
                    k(b(2, i6, i9, null));
                    z5 = true;
                } else {
                    z5 = false;
                }
                c6 = 1;
            } else {
                if (c7 == 1) {
                    r(b(2, i6, i9, null));
                    z5 = true;
                } else {
                    z5 = false;
                }
                c6 = 0;
            }
            if (z5) {
                i8 -= i9;
                i7 -= i9;
                i9 = 1;
            } else {
                i9++;
            }
            i8++;
            c7 = c6;
        }
        if (i9 != bVar.f2382d) {
            a(bVar);
            bVar = b(2, i6, i9, null);
        }
        if (c7 == 0) {
            k(bVar);
        } else {
            r(bVar);
        }
    }

    private void g(b bVar) {
        int i6 = bVar.f2380b;
        int i7 = bVar.f2382d + i6;
        int i8 = i6;
        char c6 = 65535;
        int i9 = 0;
        while (i6 < i7) {
            if (this.f2374d.c(i6) != null || h(i6)) {
                if (c6 == 0) {
                    k(b(4, i8, i9, bVar.f2381c));
                    i8 = i6;
                    i9 = 0;
                }
                c6 = 1;
            } else {
                if (c6 == 1) {
                    r(b(4, i8, i9, bVar.f2381c));
                    i8 = i6;
                    i9 = 0;
                }
                c6 = 0;
            }
            i9++;
            i6++;
        }
        if (i9 != bVar.f2382d) {
            Object obj = bVar.f2381c;
            a(bVar);
            bVar = b(4, i8, i9, obj);
        }
        if (c6 == 0) {
            k(bVar);
        } else {
            r(bVar);
        }
    }

    private boolean h(int i6) {
        int size = this.f2373c.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = (b) this.f2373c.get(i7);
            int i8 = bVar.f2379a;
            if (i8 == 8) {
                if (n(bVar.f2382d, i7 + 1) == i6) {
                    return true;
                }
            } else if (i8 == 1) {
                int i9 = bVar.f2380b;
                int i10 = bVar.f2382d + i9;
                while (i9 < i10) {
                    if (n(i9, i7 + 1) == i6) {
                        return true;
                    }
                    i9++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i6;
        int i7 = bVar.f2379a;
        if (i7 == 1 || i7 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int v5 = v(bVar.f2380b, i7);
        int i8 = bVar.f2380b;
        int i9 = bVar.f2379a;
        if (i9 == 2) {
            i6 = 0;
        } else if (i9 != 4) {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        } else {
            i6 = 1;
        }
        int i10 = 1;
        for (int i11 = 1; i11 < bVar.f2382d; i11++) {
            int v6 = v(bVar.f2380b + (i6 * i11), bVar.f2379a);
            int i12 = bVar.f2379a;
            if (i12 == 2 ? v6 == v5 : i12 == 4 && v6 == v5 + 1) {
                i10++;
            } else {
                b b6 = b(i12, v5, i10, bVar.f2381c);
                l(b6, i8);
                a(b6);
                if (bVar.f2379a == 4) {
                    i8 += i10;
                }
                v5 = v6;
                i10 = 1;
            }
        }
        Object obj = bVar.f2381c;
        a(bVar);
        if (i10 > 0) {
            b b7 = b(bVar.f2379a, v5, i10, obj);
            l(b7, i8);
            a(b7);
        }
    }

    private void r(b bVar) {
        this.f2373c.add(bVar);
        int i6 = bVar.f2379a;
        if (i6 == 1) {
            this.f2374d.e(bVar.f2380b, bVar.f2382d);
        } else if (i6 == 2) {
            this.f2374d.d(bVar.f2380b, bVar.f2382d);
        } else if (i6 == 4) {
            this.f2374d.h(bVar.f2380b, bVar.f2382d, bVar.f2381c);
        } else if (i6 == 8) {
            this.f2374d.a(bVar.f2380b, bVar.f2382d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int v(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        for (int size = this.f2373c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f2373c.get(size);
            int i14 = bVar.f2379a;
            if (i14 == 8) {
                int i15 = bVar.f2380b;
                int i16 = bVar.f2382d;
                if (i15 < i16) {
                    i10 = i15;
                    i9 = i16;
                } else {
                    i9 = i15;
                    i10 = i16;
                }
                if (i6 < i10 || i6 > i9) {
                    if (i6 < i15) {
                        if (i7 == 1) {
                            bVar.f2380b = i15 + 1;
                            i11 = i16 + 1;
                        } else if (i7 == 2) {
                            bVar.f2380b = i15 - 1;
                            i11 = i16 - 1;
                        }
                        bVar.f2382d = i11;
                    }
                } else if (i10 == i15) {
                    if (i7 == 1) {
                        i13 = i16 + 1;
                    } else {
                        if (i7 == 2) {
                            i13 = i16 - 1;
                        }
                        i6++;
                    }
                    bVar.f2382d = i13;
                    i6++;
                } else {
                    if (i7 == 1) {
                        i12 = i15 + 1;
                    } else {
                        if (i7 == 2) {
                            i12 = i15 - 1;
                        }
                        i6--;
                    }
                    bVar.f2380b = i12;
                    i6--;
                }
            } else {
                int i17 = bVar.f2380b;
                if (i17 > i6) {
                    if (i7 == 1) {
                        i8 = i17 + 1;
                    } else if (i7 == 2) {
                        i8 = i17 - 1;
                    }
                    bVar.f2380b = i8;
                } else if (i14 == 1) {
                    i6 -= bVar.f2382d;
                } else if (i14 == 2) {
                    i6 += bVar.f2382d;
                }
            }
        }
        for (int size2 = this.f2373c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f2373c.get(size2);
            if (bVar2.f2379a == 8) {
                int i18 = bVar2.f2382d;
                if (i18 != bVar2.f2380b && i18 >= 0) {
                }
                this.f2373c.remove(size2);
                a(bVar2);
            } else {
                if (bVar2.f2382d > 0) {
                }
                this.f2373c.remove(size2);
                a(bVar2);
            }
        }
        return i6;
    }

    @Override // androidx.recyclerview.widget.h.a
    public void a(b bVar) {
        if (this.f2376f) {
            return;
        }
        bVar.f2381c = null;
        this.f2371a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.h.a
    public b b(int i6, int i7, int i8, Object obj) {
        b bVar = (b) this.f2371a.b();
        if (bVar == null) {
            return new b(i6, i7, i8, obj);
        }
        bVar.f2379a = i6;
        bVar.f2380b = i7;
        bVar.f2382d = i8;
        bVar.f2381c = obj;
        return bVar;
    }

    public int e(int i6) {
        int size = this.f2372b.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = (b) this.f2372b.get(i7);
            int i8 = bVar.f2379a;
            if (i8 != 1) {
                if (i8 == 2) {
                    int i9 = bVar.f2380b;
                    if (i9 <= i6) {
                        int i10 = bVar.f2382d;
                        if (i9 + i10 > i6) {
                            return -1;
                        }
                        i6 -= i10;
                    } else {
                        continue;
                    }
                } else if (i8 == 8) {
                    int i11 = bVar.f2380b;
                    if (i11 == i6) {
                        i6 = bVar.f2382d;
                    } else {
                        if (i11 < i6) {
                            i6--;
                        }
                        if (bVar.f2382d <= i6) {
                            i6++;
                        }
                    }
                }
            } else if (bVar.f2380b <= i6) {
                i6 += bVar.f2382d;
            }
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        int size = this.f2373c.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f2374d.b((b) this.f2373c.get(i6));
        }
        t(this.f2373c);
        this.f2378h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f2372b.size();
        for (int i6 = 0; i6 < size; i6++) {
            b bVar = (b) this.f2372b.get(i6);
            int i7 = bVar.f2379a;
            if (i7 == 1) {
                this.f2374d.b(bVar);
                this.f2374d.e(bVar.f2380b, bVar.f2382d);
            } else if (i7 == 2) {
                this.f2374d.b(bVar);
                this.f2374d.f(bVar.f2380b, bVar.f2382d);
            } else if (i7 == 4) {
                this.f2374d.b(bVar);
                this.f2374d.h(bVar.f2380b, bVar.f2382d, bVar.f2381c);
            } else if (i7 == 8) {
                this.f2374d.b(bVar);
                this.f2374d.a(bVar.f2380b, bVar.f2382d);
            }
            Runnable runnable = this.f2375e;
            if (runnable != null) {
                runnable.run();
            }
        }
        t(this.f2372b);
        this.f2378h = 0;
    }

    void l(b bVar, int i6) {
        this.f2374d.g(bVar);
        int i7 = bVar.f2379a;
        if (i7 == 2) {
            this.f2374d.f(i6, bVar.f2382d);
        } else if (i7 != 4) {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        } else {
            this.f2374d.h(i6, bVar.f2382d, bVar.f2381c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(int i6) {
        return n(i6, 0);
    }

    int n(int i6, int i7) {
        int size = this.f2373c.size();
        while (i7 < size) {
            b bVar = (b) this.f2373c.get(i7);
            int i8 = bVar.f2379a;
            if (i8 == 8) {
                int i9 = bVar.f2380b;
                if (i9 == i6) {
                    i6 = bVar.f2382d;
                } else {
                    if (i9 < i6) {
                        i6--;
                    }
                    if (bVar.f2382d <= i6) {
                        i6++;
                    }
                }
            } else {
                int i10 = bVar.f2380b;
                if (i10 > i6) {
                    continue;
                } else if (i8 == 2) {
                    int i11 = bVar.f2382d;
                    if (i6 < i10 + i11) {
                        return -1;
                    }
                    i6 -= i11;
                } else if (i8 == 1) {
                    i6 += bVar.f2382d;
                }
            }
            i7++;
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(int i6) {
        return (i6 & this.f2378h) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f2372b.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return (this.f2373c.isEmpty() || this.f2372b.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.f2377g.b(this.f2372b);
        int size = this.f2372b.size();
        for (int i6 = 0; i6 < size; i6++) {
            b bVar = (b) this.f2372b.get(i6);
            int i7 = bVar.f2379a;
            if (i7 == 1) {
                c(bVar);
            } else if (i7 == 2) {
                f(bVar);
            } else if (i7 == 4) {
                g(bVar);
            } else if (i7 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f2375e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f2372b.clear();
    }

    void t(List list) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            a((b) list.get(i6));
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        t(this.f2372b);
        t(this.f2373c);
        this.f2378h = 0;
    }

    a(InterfaceC0021a interfaceC0021a, boolean z5) {
        this.f2371a = new d0.g(30);
        this.f2372b = new ArrayList();
        this.f2373c = new ArrayList();
        this.f2378h = 0;
        this.f2374d = interfaceC0021a;
        this.f2376f = z5;
        this.f2377g = new h(this);
    }
}
