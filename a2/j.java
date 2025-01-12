package a2;

import com.google.android.exoplayer2.util.s0;
import java.util.List;
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    final h f109a;

    /* renamed from: b  reason: collision with root package name */
    final long f110b;

    /* renamed from: c  reason: collision with root package name */
    final long f111c;

    /* loaded from: classes.dex */
    public static abstract class a extends j {

        /* renamed from: d  reason: collision with root package name */
        final long f112d;

        /* renamed from: e  reason: collision with root package name */
        final long f113e;

        /* renamed from: f  reason: collision with root package name */
        final List f114f;

        public a(h hVar, long j6, long j7, long j8, long j9, List list) {
            super(hVar, j6, j7);
            this.f112d = j8;
            this.f113e = j9;
            this.f114f = list;
        }

        public long c() {
            return this.f112d;
        }

        public abstract int d(long j6);

        public final long e(long j6, long j7) {
            List list = this.f114f;
            if (list != null) {
                return (((d) list.get((int) (j6 - this.f112d))).f120b * 1000000) / this.f110b;
            }
            int d6 = d(j7);
            return (d6 == -1 || j6 != (c() + ((long) d6)) - 1) ? (this.f113e * 1000000) / this.f110b : j7 - g(j6);
        }

        public long f(long j6, long j7) {
            long c6 = c();
            long d6 = d(j7);
            if (d6 == 0) {
                return c6;
            }
            if (this.f114f == null) {
                long j8 = this.f112d + (j6 / ((this.f113e * 1000000) / this.f110b));
                return j8 < c6 ? c6 : d6 == -1 ? j8 : Math.min(j8, (c6 + d6) - 1);
            }
            long j9 = (d6 + c6) - 1;
            long j10 = c6;
            while (j10 <= j9) {
                long j11 = ((j9 - j10) / 2) + j10;
                int i6 = (g(j11) > j6 ? 1 : (g(j11) == j6 ? 0 : -1));
                if (i6 < 0) {
                    j10 = j11 + 1;
                } else if (i6 <= 0) {
                    return j11;
                } else {
                    j9 = j11 - 1;
                }
            }
            return j10 == c6 ? j10 : j9;
        }

        public final long g(long j6) {
            List list = this.f114f;
            return s0.F0(list != null ? ((d) list.get((int) (j6 - this.f112d))).f119a - this.f111c : (j6 - this.f112d) * this.f113e, 1000000L, this.f110b);
        }

        public abstract h h(i iVar, long j6);

        public boolean i() {
            return this.f114f != null;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends a {

        /* renamed from: g  reason: collision with root package name */
        final List f115g;

        public b(h hVar, long j6, long j7, long j8, long j9, List list, List list2) {
            super(hVar, j6, j7, j8, j9, list);
            this.f115g = list2;
        }

        @Override // a2.j.a
        public int d(long j6) {
            return this.f115g.size();
        }

        @Override // a2.j.a
        public h h(i iVar, long j6) {
            return (h) this.f115g.get((int) (j6 - this.f112d));
        }

        @Override // a2.j.a
        public boolean i() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends a {

        /* renamed from: g  reason: collision with root package name */
        final l f116g;

        /* renamed from: h  reason: collision with root package name */
        final l f117h;

        /* renamed from: i  reason: collision with root package name */
        final long f118i;

        public c(h hVar, long j6, long j7, long j8, long j9, long j10, List list, l lVar, l lVar2) {
            super(hVar, j6, j7, j8, j10, list);
            this.f116g = lVar;
            this.f117h = lVar2;
            this.f118i = j9;
        }

        @Override // a2.j
        public h a(i iVar) {
            l lVar = this.f116g;
            if (lVar != null) {
                com.google.android.exoplayer2.s0 s0Var = iVar.f98b;
                return new h(lVar.a(s0Var.f4045a, 0L, s0Var.f4052h, 0L), 0L, -1L);
            }
            return super.a(iVar);
        }

        @Override // a2.j.a
        public int d(long j6) {
            List list = this.f114f;
            if (list != null) {
                return list.size();
            }
            long j7 = this.f118i;
            if (j7 != -1) {
                return (int) ((j7 - this.f112d) + 1);
            }
            if (j6 != -9223372036854775807L) {
                return (int) s0.m(j6, (this.f113e * 1000000) / this.f110b);
            }
            return -1;
        }

        @Override // a2.j.a
        public h h(i iVar, long j6) {
            List list = this.f114f;
            long j7 = list != null ? ((d) list.get((int) (j6 - this.f112d))).f119a : (j6 - this.f112d) * this.f113e;
            l lVar = this.f117h;
            com.google.android.exoplayer2.s0 s0Var = iVar.f98b;
            return new h(lVar.a(s0Var.f4045a, j6, s0Var.f4052h, j7), 0L, -1L);
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        final long f119a;

        /* renamed from: b  reason: collision with root package name */
        final long f120b;

        public d(long j6, long j7) {
            this.f119a = j6;
            this.f120b = j7;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f119a == dVar.f119a && this.f120b == dVar.f120b;
        }

        public int hashCode() {
            return (((int) this.f119a) * 31) + ((int) this.f120b);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends j {

        /* renamed from: d  reason: collision with root package name */
        final long f121d;

        /* renamed from: e  reason: collision with root package name */
        final long f122e;

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public h c() {
            long j6 = this.f122e;
            if (j6 <= 0) {
                return null;
            }
            return new h(null, this.f121d, j6);
        }

        public e(h hVar, long j6, long j7, long j8, long j9) {
            super(hVar, j6, j7);
            this.f121d = j8;
            this.f122e = j9;
        }
    }

    public j(h hVar, long j6, long j7) {
        this.f109a = hVar;
        this.f110b = j6;
        this.f111c = j7;
    }

    public h a(i iVar) {
        return this.f109a;
    }

    public long b() {
        return s0.F0(this.f111c, 1000000L, this.f110b);
    }
}
