package c;

import b.j;
import e.AbstractC0227j$a;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$r {

    /* renamed from: a  reason: collision with root package name */
    private d.j$k f3087a;

    /* renamed from: b  reason: collision with root package name */
    private j$b f3088b;

    /* renamed from: c  reason: collision with root package name */
    private int f3089c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$r(final d.j$k j_k, j$b j_b) {
        d.j$a[] values;
        j.d b6 = j_b.b();
        if (b6 != null) {
            j.d dVar = (j.d) j_k.c(d.j$j.d());
            final a.j$h j_h = (a.j$h) j_k.c(d.j$j.j());
            final a.j$d j_d = null;
            b6 = AbstractC0227j$a.x(b6, dVar) ? null : b6;
            AbstractC0227j$a.x(null, j_h);
            if (b6 != null) {
                final j.d dVar2 = b6 != null ? b6 : dVar;
                if (b6 != null) {
                    if (j_k.d(d.j$a.EPOCH_DAY)) {
                        ((j.e) dVar2).getClass();
                        j_d = a.j$d.h(j_k);
                    } else if (b6 != j.e.f2842a || dVar != null) {
                        for (d.j$a j_a : d.j$a.values()) {
                            if (j_a.e() && j_k.d(j_a)) {
                                throw new a.j$b("Unable to apply override chronology '" + b6 + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + j_k);
                            }
                        }
                    }
                }
                j_k = new d.j$k() { // from class: c.j$q
                    @Override // d.j$k
                    public final long a(d.j$l j_l) {
                        j.b bVar = j_d;
                        return (bVar == null || !j_l.e()) ? j_k.a(j_l) : ((a.j$d) bVar).a(j_l);
                    }

                    @Override // d.j$k
                    public final d.j$q b(d.j$l j_l) {
                        j.b bVar = j_d;
                        return (bVar == null || !j_l.e()) ? j_k.b(j_l) : ((a.j$d) bVar).b(j_l);
                    }

                    @Override // d.j$k
                    public final Object c(d.j$n j_n) {
                        return j_n == d.j$j.d() ? dVar2 : j_n == d.j$j.j() ? j_h : j_n == d.j$j.h() ? j_k.c(j_n) : j_n.a(this);
                    }

                    @Override // d.j$k
                    public final boolean d(d.j$l j_l) {
                        j.b bVar = j_d;
                        return (bVar == null || !j_l.e()) ? j_k.d(j_l) : ((a.j$d) bVar).d(j_l);
                    }

                    @Override // d.j$k
                    public final /* synthetic */ int e(d.j$a j_a2) {
                        return d.j$j.a(this, j_a2);
                    }
                };
            }
        }
        this.f3087a = j_k;
        this.f3088b = j_b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f3089c--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j$t b() {
        return this.f3088b.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Locale c() {
        return this.f3088b.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d.j$k d() {
        return this.f3087a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long e(d.j$l j_l) {
        try {
            return Long.valueOf(this.f3087a.a(j_l));
        } catch (a.j$b e6) {
            if (this.f3089c > 0) {
                return null;
            }
            throw e6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object f(d.j$n j_n) {
        Object c6 = this.f3087a.c(j_n);
        if (c6 == null && this.f3089c == 0) {
            throw new a.j$b("Unable to extract value: " + this.f3087a.getClass());
        }
        return c6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g() {
        this.f3089c++;
    }

    public final String toString() {
        return this.f3087a.toString();
    }
}
