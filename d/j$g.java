package d;

import b.j;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
abstract class j$g implements j$l {

    /* renamed from: a  reason: collision with root package name */
    public static final j$d f9086a;

    /* renamed from: b  reason: collision with root package name */
    public static final j$e f9087b;

    /* renamed from: c  reason: collision with root package name */
    public static final j$f f9088c;

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f9089d;

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ j$g[] f9090e;
    /* JADX INFO: Fake field, exist only in values array */
    j$g EF0;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [d.j$d] */
    /* JADX WARN: Type inference failed for: r2v0, types: [d.j$e] */
    /* JADX WARN: Type inference failed for: r3v0, types: [d.j$f] */
    static {
        j$g j_g = new j$g() { // from class: d.j$c
            @Override // d.j$l
            public final long a(j$k j_k) {
                int[] iArr;
                if (c(j_k)) {
                    int e6 = j_k.e(j$a.DAY_OF_YEAR);
                    int e7 = j_k.e(j$a.MONTH_OF_YEAR);
                    long a6 = j_k.a(j$a.YEAR);
                    iArr = j$g.f9089d;
                    int i6 = (e7 - 1) / 3;
                    j.e.f2842a.getClass();
                    return e6 - iArr[i6 + (j.e.a(a6) ? 4 : 0)];
                }
                throw new j$p("Unsupported field: DayOfQuarter");
            }

            @Override // d.j$l
            public final j$q b() {
                return j$q.j(90L, 92L);
            }

            @Override // d.j$l
            public final boolean c(j$k j_k) {
                return j_k.d(j$a.DAY_OF_YEAR) && j_k.d(j$a.MONTH_OF_YEAR) && j_k.d(j$a.YEAR) && j$g.g(j_k);
            }

            @Override // d.j$g, d.j$l
            public final j$q f(j$k j_k) {
                if (c(j_k)) {
                    long a6 = j_k.a(j$g.f9086a);
                    if (a6 != 1) {
                        return a6 == 2 ? j$q.i(1L, 91L) : (a6 == 3 || a6 == 4) ? j$q.i(1L, 92L) : b();
                    }
                    long a7 = j_k.a(j$a.YEAR);
                    j.e.f2842a.getClass();
                    return j.e.a(a7) ? j$q.i(1L, 91L) : j$q.i(1L, 90L);
                }
                throw new j$p("Unsupported field: DayOfQuarter");
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        ?? r12 = new j$g() { // from class: d.j$d
            @Override // d.j$l
            public final long a(j$k j_k) {
                if (c(j_k)) {
                    return (j_k.a(j$a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new j$p("Unsupported field: QuarterOfYear");
            }

            @Override // d.j$l
            public final j$q b() {
                return j$q.i(1L, 4L);
            }

            @Override // d.j$l
            public final boolean c(j$k j_k) {
                return j_k.d(j$a.MONTH_OF_YEAR) && j$g.g(j_k);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        f9086a = r12;
        ?? r22 = new j$g() { // from class: d.j$e
            @Override // d.j$l
            public final long a(j$k j_k) {
                if (c(j_k)) {
                    return j$g.j(a.j$d.h(j_k));
                }
                throw new j$p("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // d.j$l
            public final j$q b() {
                return j$q.j(52L, 53L);
            }

            @Override // d.j$l
            public final boolean c(j$k j_k) {
                return j_k.d(j$a.EPOCH_DAY) && j$g.g(j_k);
            }

            @Override // d.j$g, d.j$l
            public final j$q f(j$k j_k) {
                j$q m5;
                if (c(j_k)) {
                    m5 = j$g.m(a.j$d.h(j_k));
                    return m5;
                }
                throw new j$p("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        f9087b = r22;
        ?? r32 = new j$g() { // from class: d.j$f
            @Override // d.j$l
            public final long a(j$k j_k) {
                int l6;
                if (c(j_k)) {
                    l6 = j$g.l(a.j$d.h(j_k));
                    return l6;
                }
                throw new j$p("Unsupported field: WeekBasedYear");
            }

            @Override // d.j$l
            public final j$q b() {
                return j$a.YEAR.b();
            }

            @Override // d.j$l
            public final boolean c(j$k j_k) {
                return j_k.d(j$a.EPOCH_DAY) && j$g.g(j_k);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        f9088c = r32;
        f9090e = new j$g[]{j_g, r12, r22, r32};
        f9089d = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$g(String str, int i6) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(j$k j_k) {
        if (j_k != null) {
            Object obj = (j.d) j_k.c(j$j.f9098b);
            if (obj == null) {
                obj = j.e.f2842a;
            }
            return ((j.a) obj).equals(j.e.f2842a);
        }
        throw new NullPointerException("temporal");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        if ((r0 == -3 || (r0 == -2 && r5.m())) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int j(a.j$d j_d) {
        int ordinal = j_d.j().ordinal();
        int i6 = 1;
        int k6 = j_d.k() - 1;
        int i7 = (3 - ordinal) + k6;
        int i8 = (i7 - ((i7 / 7) * 7)) - 3;
        if (i8 < -3) {
            i8 += 7;
        }
        if (k6 < i8) {
            return (int) m(j_d.r().p(-1L)).d();
        }
        int i9 = ((k6 - i8) / 7) + 1;
        if (i9 == 53) {
        }
        i6 = i9;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(a.j$d j_d) {
        int l6 = j_d.l();
        int k6 = j_d.k();
        if (k6 <= 3) {
            return k6 - j_d.j().ordinal() < -2 ? l6 - 1 : l6;
        } else if (k6 >= 363) {
            return ((k6 - 363) - (j_d.m() ? 1 : 0)) - j_d.j().ordinal() >= 0 ? l6 + 1 : l6;
        } else {
            return l6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static j$q m(a.j$d j_d) {
        a.j$d n5 = a.j$d.n(l(j_d), 1, 1);
        return j$q.i(1L, (n5.j() == a.j$c.THURSDAY || (n5.j() == a.j$c.WEDNESDAY && n5.m())) ? 53 : 52);
    }

    public static j$g valueOf(String str) {
        return (j$g) Enum.valueOf(j$g.class, str);
    }

    public static j$g[] values() {
        return (j$g[]) f9090e.clone();
    }

    @Override // d.j$l
    public final boolean d() {
        return false;
    }

    @Override // d.j$l
    public final boolean e() {
        return true;
    }

    public j$q f(j$k j_k) {
        return b();
    }
}
