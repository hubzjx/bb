package e1;

import c1.a;
import c1.j;
import c1.p;
import c1.s;
import java.util.Objects;
/* loaded from: classes.dex */
final class b extends c1.a {

    /* renamed from: e1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0158b implements a.f {

        /* renamed from: a  reason: collision with root package name */
        private final s f9410a;

        /* renamed from: b  reason: collision with root package name */
        private final int f9411b;

        /* renamed from: c  reason: collision with root package name */
        private final p.a f9412c;

        private C0158b(s sVar, int i6) {
            this.f9410a = sVar;
            this.f9411b = i6;
            this.f9412c = new p.a();
        }

        private long c(j jVar) {
            while (jVar.m() < jVar.a() - 6 && !p.h(jVar, this.f9410a, this.f9411b, this.f9412c)) {
                jVar.o(1);
            }
            if (jVar.m() >= jVar.a() - 6) {
                jVar.o((int) (jVar.a() - jVar.m()));
                return this.f9410a.f3234j;
            }
            return this.f9412c.f3221a;
        }

        @Override // c1.a.f
        public /* synthetic */ void a() {
            c1.b.a(this);
        }

        @Override // c1.a.f
        public a.e b(j jVar, long j6) {
            long p5 = jVar.p();
            long c6 = c(jVar);
            long m5 = jVar.m();
            jVar.o(Math.max(6, this.f9410a.f3227c));
            long c7 = c(jVar);
            return (c6 > j6 || c7 <= j6) ? c7 <= j6 ? a.e.f(c7, jVar.m()) : a.e.d(c6, p5) : a.e.e(m5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(final s sVar, int i6, long j6, long j7) {
        super(new a.d() { // from class: e1.a
            @Override // c1.a.d
            public final long a(long j8) {
                return s.this.j(j8);
            }
        }, new C0158b(sVar, i6), sVar.g(), 0L, sVar.f3234j, j6, j7, sVar.e(), Math.max(6, sVar.f3227c));
        Objects.requireNonNull(sVar);
    }
}
