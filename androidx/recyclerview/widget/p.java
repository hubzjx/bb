package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    final l.g f2526a = new l.g();

    /* renamed from: b  reason: collision with root package name */
    final l.d f2527b = new l.d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        static d0.f f2528d = new d0.g(20);

        /* renamed from: a  reason: collision with root package name */
        int f2529a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.l.b f2530b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.l.b f2531c;

        private a() {
        }

        static void a() {
            do {
            } while (f2528d.b() != null);
        }

        static a b() {
            a aVar = (a) f2528d.b();
            return aVar == null ? new a() : aVar;
        }

        static void c(a aVar) {
            aVar.f2529a = 0;
            aVar.f2530b = null;
            aVar.f2531c = null;
            f2528d.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.c0 c0Var);

        void b(RecyclerView.c0 c0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void c(RecyclerView.c0 c0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void d(RecyclerView.c0 c0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);
    }

    private RecyclerView.l.b l(RecyclerView.c0 c0Var, int i6) {
        a aVar;
        RecyclerView.l.b bVar;
        int f6 = this.f2526a.f(c0Var);
        if (f6 >= 0 && (aVar = (a) this.f2526a.m(f6)) != null) {
            int i7 = aVar.f2529a;
            if ((i7 & i6) != 0) {
                int i8 = (~i6) & i7;
                aVar.f2529a = i8;
                if (i6 == 4) {
                    bVar = aVar.f2530b;
                } else if (i6 != 8) {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                } else {
                    bVar = aVar.f2531c;
                }
                if ((i8 & 12) == 0) {
                    this.f2526a.k(f6);
                    a.c(aVar);
                }
                return bVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.c0 c0Var, RecyclerView.l.b bVar) {
        a aVar = (a) this.f2526a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f2526a.put(c0Var, aVar);
        }
        aVar.f2529a |= 2;
        aVar.f2530b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.c0 c0Var) {
        a aVar = (a) this.f2526a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f2526a.put(c0Var, aVar);
        }
        aVar.f2529a |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j6, RecyclerView.c0 c0Var) {
        this.f2527b.i(j6, c0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.c0 c0Var, RecyclerView.l.b bVar) {
        a aVar = (a) this.f2526a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f2526a.put(c0Var, aVar);
        }
        aVar.f2531c = bVar;
        aVar.f2529a |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(RecyclerView.c0 c0Var, RecyclerView.l.b bVar) {
        a aVar = (a) this.f2526a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f2526a.put(c0Var, aVar);
        }
        aVar.f2530b = bVar;
        aVar.f2529a |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f2526a.clear();
        this.f2527b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.c0 g(long j6) {
        return (RecyclerView.c0) this.f2527b.e(j6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(RecyclerView.c0 c0Var) {
        a aVar = (a) this.f2526a.get(c0Var);
        return (aVar == null || (aVar.f2529a & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(RecyclerView.c0 c0Var) {
        a aVar = (a) this.f2526a.get(c0Var);
        return (aVar == null || (aVar.f2529a & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        a.a();
    }

    public void k(RecyclerView.c0 c0Var) {
        p(c0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.b m(RecyclerView.c0 c0Var) {
        return l(c0Var, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.b n(RecyclerView.c0 c0Var) {
        return l(c0Var, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(b bVar) {
        RecyclerView.l.b bVar2;
        RecyclerView.l.b bVar3;
        for (int size = this.f2526a.size() - 1; size >= 0; size--) {
            RecyclerView.c0 c0Var = (RecyclerView.c0) this.f2526a.i(size);
            a aVar = (a) this.f2526a.k(size);
            int i6 = aVar.f2529a;
            if ((i6 & 3) != 3) {
                if ((i6 & 1) != 0) {
                    bVar2 = aVar.f2530b;
                    bVar3 = bVar2 != null ? aVar.f2531c : null;
                } else {
                    if ((i6 & 14) != 14) {
                        if ((i6 & 12) == 12) {
                            bVar.d(c0Var, aVar.f2530b, aVar.f2531c);
                        } else if ((i6 & 4) != 0) {
                            bVar2 = aVar.f2530b;
                        } else if ((i6 & 8) == 0) {
                        }
                        a.c(aVar);
                    }
                    bVar.b(c0Var, aVar.f2530b, aVar.f2531c);
                    a.c(aVar);
                }
                bVar.c(c0Var, bVar2, bVar3);
                a.c(aVar);
            }
            bVar.a(c0Var);
            a.c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(RecyclerView.c0 c0Var) {
        a aVar = (a) this.f2526a.get(c0Var);
        if (aVar == null) {
            return;
        }
        aVar.f2529a &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(RecyclerView.c0 c0Var) {
        int l6 = this.f2527b.l() - 1;
        while (true) {
            if (l6 < 0) {
                break;
            } else if (c0Var == this.f2527b.m(l6)) {
                this.f2527b.k(l6);
                break;
            } else {
                l6--;
            }
        }
        a aVar = (a) this.f2526a.remove(c0Var);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
