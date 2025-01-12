package f1;

import c1.h;
import com.google.android.exoplayer2.util.y;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
final class d extends e {

    /* renamed from: b  reason: collision with root package name */
    private long f9787b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f9788c;

    /* renamed from: d  reason: collision with root package name */
    private long[] f9789d;

    public d() {
        super(new h());
        this.f9787b = -9223372036854775807L;
        this.f9788c = new long[0];
        this.f9789d = new long[0];
    }

    private static Boolean g(y yVar) {
        return Boolean.valueOf(yVar.A() == 1);
    }

    private static Object h(y yVar, int i6) {
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 != 8) {
                            if (i6 != 10) {
                                if (i6 != 11) {
                                    return null;
                                }
                                return i(yVar);
                            }
                            return m(yVar);
                        }
                        return k(yVar);
                    }
                    return l(yVar);
                }
                return n(yVar);
            }
            return g(yVar);
        }
        return j(yVar);
    }

    private static Date i(y yVar) {
        Date date = new Date((long) j(yVar).doubleValue());
        yVar.N(2);
        return date;
    }

    private static Double j(y yVar) {
        return Double.valueOf(Double.longBitsToDouble(yVar.t()));
    }

    private static HashMap k(y yVar) {
        int E = yVar.E();
        HashMap hashMap = new HashMap(E);
        for (int i6 = 0; i6 < E; i6++) {
            String n5 = n(yVar);
            Object h6 = h(yVar, o(yVar));
            if (h6 != null) {
                hashMap.put(n5, h6);
            }
        }
        return hashMap;
    }

    private static HashMap l(y yVar) {
        HashMap hashMap = new HashMap();
        while (true) {
            String n5 = n(yVar);
            int o5 = o(yVar);
            if (o5 == 9) {
                return hashMap;
            }
            Object h6 = h(yVar, o5);
            if (h6 != null) {
                hashMap.put(n5, h6);
            }
        }
    }

    private static ArrayList m(y yVar) {
        int E = yVar.E();
        ArrayList arrayList = new ArrayList(E);
        for (int i6 = 0; i6 < E; i6++) {
            Object h6 = h(yVar, o(yVar));
            if (h6 != null) {
                arrayList.add(h6);
            }
        }
        return arrayList;
    }

    private static String n(y yVar) {
        int G = yVar.G();
        int d6 = yVar.d();
        yVar.N(G);
        return new String(yVar.c(), d6, G);
    }

    private static int o(y yVar) {
        return yVar.A();
    }

    @Override // f1.e
    protected boolean b(y yVar) {
        return true;
    }

    @Override // f1.e
    protected boolean c(y yVar, long j6) {
        if (o(yVar) == 2 && "onMetaData".equals(n(yVar)) && o(yVar) == 8) {
            HashMap k6 = k(yVar);
            Object obj = k6.get("duration");
            if (obj instanceof Double) {
                double doubleValue = ((Double) obj).doubleValue();
                if (doubleValue > 0.0d) {
                    this.f9787b = (long) (doubleValue * 1000000.0d);
                }
            }
            Object obj2 = k6.get("keyframes");
            if (obj2 instanceof Map) {
                Map map = (Map) obj2;
                Object obj3 = map.get("filepositions");
                Object obj4 = map.get("times");
                if ((obj3 instanceof List) && (obj4 instanceof List)) {
                    List list = (List) obj3;
                    List list2 = (List) obj4;
                    int size = list2.size();
                    this.f9788c = new long[size];
                    this.f9789d = new long[size];
                    for (int i6 = 0; i6 < size; i6++) {
                        Object obj5 = list.get(i6);
                        Object obj6 = list2.get(i6);
                        if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                            this.f9788c = new long[0];
                            this.f9789d = new long[0];
                            break;
                        }
                        this.f9788c[i6] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.f9789d[i6] = ((Double) obj5).longValue();
                    }
                }
            }
            return false;
        }
        return false;
    }

    public long d() {
        return this.f9787b;
    }

    public long[] e() {
        return this.f9789d;
    }

    public long[] f() {
        return this.f9788c;
    }
}
