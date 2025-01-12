package g;

import j$.util.Map;
import java.util.EnumMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum f uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class j$P2 {
    private static final /* synthetic */ j$P2[] A;

    /* renamed from: f  reason: collision with root package name */
    public static final j$P2 f10046f;

    /* renamed from: g  reason: collision with root package name */
    public static final j$P2 f10047g;

    /* renamed from: h  reason: collision with root package name */
    public static final j$P2 f10048h;

    /* renamed from: i  reason: collision with root package name */
    public static final j$P2 f10049i;

    /* renamed from: j  reason: collision with root package name */
    public static final j$P2 f10050j;

    /* renamed from: k  reason: collision with root package name */
    static final int f10051k;

    /* renamed from: l  reason: collision with root package name */
    static final int f10052l;

    /* renamed from: m  reason: collision with root package name */
    static final int f10053m;

    /* renamed from: n  reason: collision with root package name */
    private static final int f10054n;

    /* renamed from: o  reason: collision with root package name */
    private static final int f10055o;

    /* renamed from: p  reason: collision with root package name */
    private static final int f10056p;

    /* renamed from: q  reason: collision with root package name */
    static final int f10057q;

    /* renamed from: r  reason: collision with root package name */
    static final int f10058r;

    /* renamed from: s  reason: collision with root package name */
    static final int f10059s;

    /* renamed from: t  reason: collision with root package name */
    static final int f10060t;

    /* renamed from: u  reason: collision with root package name */
    static final int f10061u;

    /* renamed from: v  reason: collision with root package name */
    static final int f10062v;

    /* renamed from: w  reason: collision with root package name */
    static final int f10063w;

    /* renamed from: x  reason: collision with root package name */
    static final int f10064x;

    /* renamed from: y  reason: collision with root package name */
    static final int f10065y;

    /* renamed from: z  reason: collision with root package name */
    static final int f10066z;

    /* renamed from: a  reason: collision with root package name */
    private final Map f10067a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10068b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10069c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10070d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10071e;

    static {
        j$O2 j_o2 = j$O2.SPLITERATOR;
        j$N2 f6 = f(j_o2);
        j$O2 j_o22 = j$O2.STREAM;
        f6.a(j_o22);
        j$O2 j_o23 = j$O2.OP;
        f6.f10028a.put(j_o23, 3);
        j$P2 j_p2 = new j$P2("DISTINCT", 0, 0, f6);
        f10046f = j_p2;
        j$N2 f7 = f(j_o2);
        f7.a(j_o22);
        f7.f10028a.put(j_o23, 3);
        j$P2 j_p22 = new j$P2("SORTED", 1, 1, f7);
        f10047g = j_p22;
        j$N2 f8 = f(j_o2);
        f8.a(j_o22);
        Map map = f8.f10028a;
        map.put(j_o23, 3);
        j$O2 j_o24 = j$O2.TERMINAL_OP;
        map.put(j_o24, 2);
        j$O2 j_o25 = j$O2.UPSTREAM_TERMINAL_OP;
        map.put(j_o25, 2);
        j$P2 j_p23 = new j$P2("ORDERED", 2, 2, f8);
        f10048h = j_p23;
        j$N2 f9 = f(j_o2);
        f9.a(j_o22);
        f9.f10028a.put(j_o23, 2);
        j$P2 j_p24 = new j$P2("SIZED", 3, 3, f9);
        f10049i = j_p24;
        j$N2 f10 = f(j_o23);
        f10.a(j_o24);
        j$P2 j_p25 = new j$P2("SHORT_CIRCUIT", 4, 12, f10);
        f10050j = j_p25;
        A = new j$P2[]{j_p2, j_p22, j_p23, j_p24, j_p25};
        f10051k = b(j_o2);
        f10052l = b(j_o22);
        f10053m = b(j_o23);
        b(j_o24);
        b(j_o25);
        int i6 = 0;
        for (j$P2 j_p26 : values()) {
            i6 |= j_p26.f10071e;
        }
        f10054n = i6;
        int i7 = f10052l;
        f10055o = i7;
        int i8 = i7 << 1;
        f10056p = i8;
        f10057q = i7 | i8;
        j$P2 j_p27 = f10046f;
        f10058r = j_p27.f10069c;
        f10059s = j_p27.f10070d;
        j$P2 j_p28 = f10047g;
        f10060t = j_p28.f10069c;
        f10061u = j_p28.f10070d;
        j$P2 j_p29 = f10048h;
        f10062v = j_p29.f10069c;
        f10063w = j_p29.f10070d;
        j$P2 j_p210 = f10049i;
        f10064x = j_p210.f10069c;
        f10065y = j_p210.f10070d;
        f10066z = f10050j.f10069c;
    }

    private j$P2(String str, int i6, int i7, j$N2 j_n2) {
        j$O2[] values = j$O2.values();
        int length = values.length;
        int i8 = 0;
        while (true) {
            Map map = j_n2.f10028a;
            if (i8 >= length) {
                this.f10067a = map;
                int i9 = i7 * 2;
                this.f10068b = i9;
                this.f10069c = 1 << i9;
                this.f10070d = 2 << i9;
                this.f10071e = 3 << i9;
                return;
            }
            j$O2 j_o2 = values[i8];
            if (map instanceof j$.util.Map) {
                ((j$.util.Map) map).putIfAbsent(j_o2, 0);
            } else {
                Map.CC.$default$putIfAbsent(map, j_o2, 0);
            }
            i8++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i6, int i7) {
        return i6 | (i7 & (i6 == 0 ? f10054n : ~(((f10055o & i6) << 1) | i6 | ((f10056p & i6) >> 1))));
    }

    private static int b(j$O2 j_o2) {
        j$P2[] values;
        int i6 = 0;
        for (j$P2 j_p2 : values()) {
            i6 |= ((Integer) j_p2.f10067a.get(j_o2)).intValue() << j_p2.f10068b;
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(e.j$J j_j) {
        int characteristics = j_j.characteristics();
        int i6 = characteristics & 4;
        int i7 = f10051k;
        return (i6 == 0 || j_j.getComparator() == null) ? characteristics & i7 : characteristics & i7 & (-5);
    }

    private static j$N2 f(j$O2 j_o2) {
        j$N2 j_n2 = new j$N2(new EnumMap(j$O2.class));
        j_n2.a(j_o2);
        return j_n2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i6) {
        return i6 & ((~i6) >> 1) & f10055o;
    }

    public static j$P2 valueOf(String str) {
        return (j$P2) Enum.valueOf(j$P2.class, str);
    }

    public static j$P2[] values() {
        return (j$P2[]) A.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d(int i6) {
        return (i6 & this.f10071e) == this.f10069c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e(int i6) {
        int i7 = this.f10071e;
        return (i6 & i7) == i7;
    }
}
