package j2;

import android.graphics.PointF;
import android.text.Layout;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import e2.b;
import e2.f;
import j2.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class a extends e2.d {

    /* renamed from: t  reason: collision with root package name */
    private static final Pattern f11216t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: o  reason: collision with root package name */
    private final boolean f11217o;

    /* renamed from: p  reason: collision with root package name */
    private final b f11218p;

    /* renamed from: q  reason: collision with root package name */
    private Map f11219q;

    /* renamed from: r  reason: collision with root package name */
    private float f11220r;

    /* renamed from: s  reason: collision with root package name */
    private float f11221s;

    public a(List list) {
        super("SsaDecoder");
        this.f11220r = -3.4028235E38f;
        this.f11221s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f11217o = false;
            this.f11218p = null;
            return;
        }
        this.f11217o = true;
        String E = s0.E((byte[]) list.get(0));
        com.google.android.exoplayer2.util.a.a(E.startsWith("Format:"));
        this.f11218p = (b) com.google.android.exoplayer2.util.a.e(b.a(E));
        H(new y((byte[]) list.get(1)));
    }

    private static int C(long j6, List list, List list2) {
        int i6;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i6 = 0;
                break;
            } else if (((Long) list.get(size)).longValue() == j6) {
                return size;
            } else {
                if (((Long) list.get(size)).longValue() < j6) {
                    i6 = size + 1;
                    break;
                }
                size--;
            }
        }
        list.add(i6, Long.valueOf(j6));
        list2.add(i6, i6 == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i6 - 1)));
        return i6;
    }

    private static float D(int i6) {
        if (i6 != 0) {
            if (i6 != 1) {
                return i6 != 2 ? -3.4028235E38f : 0.95f;
            }
            return 0.5f;
        }
        return 0.05f;
    }

    private static e2.b E(String str, c cVar, c.b bVar, float f6, float f7) {
        float D;
        b.C0159b m5 = new b.C0159b().m(str);
        int i6 = bVar.f11236a;
        if (i6 == -1) {
            i6 = cVar != null ? cVar.f11228b : -1;
        }
        m5.n(N(i6)).k(M(i6)).i(L(i6));
        PointF pointF = bVar.f11237b;
        if (pointF == null || f7 == -3.4028235E38f || f6 == -3.4028235E38f) {
            m5.j(D(m5.d()));
            D = D(m5.c());
        } else {
            m5.j(pointF.x / f6);
            D = bVar.f11237b.y / f7;
        }
        m5.h(D, 0);
        return m5.a();
    }

    private void F(String str, b bVar, List list, List list2) {
        int i6;
        com.google.android.exoplayer2.util.a.a(str.startsWith("Dialogue:"));
        String[] split = str.substring(9).split(",", bVar.f11226e);
        if (split.length != bVar.f11226e) {
            n.h("SsaDecoder", str.length() != 0 ? "Skipping dialogue line with fewer columns than format: ".concat(str) : new String("Skipping dialogue line with fewer columns than format: "));
            return;
        }
        long K = K(split[bVar.f11222a]);
        if (K == -9223372036854775807L) {
            n.h("SsaDecoder", str.length() != 0 ? "Skipping invalid timing: ".concat(str) : new String("Skipping invalid timing: "));
            return;
        }
        long K2 = K(split[bVar.f11223b]);
        if (K2 == -9223372036854775807L) {
            n.h("SsaDecoder", str.length() != 0 ? "Skipping invalid timing: ".concat(str) : new String("Skipping invalid timing: "));
            return;
        }
        Map map = this.f11219q;
        c cVar = (map == null || (i6 = bVar.f11224c) == -1) ? null : (c) map.get(split[i6].trim());
        String str2 = split[bVar.f11225d];
        e2.b E = E(c.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), cVar, c.b.b(str2), this.f11220r, this.f11221s);
        int C = C(K2, list2, list);
        for (int C2 = C(K, list2, list); C2 < C; C2++) {
            ((List) list.get(C2)).add(E);
        }
    }

    private void G(y yVar, List list, List list2) {
        b bVar = this.f11217o ? this.f11218p : null;
        while (true) {
            String m5 = yVar.m();
            if (m5 == null) {
                return;
            }
            if (m5.startsWith("Format:")) {
                bVar = b.a(m5);
            } else if (m5.startsWith("Dialogue:")) {
                if (bVar == null) {
                    n.h("SsaDecoder", m5.length() != 0 ? "Skipping dialogue line before complete format: ".concat(m5) : new String("Skipping dialogue line before complete format: "));
                } else {
                    F(m5, bVar, list, list2);
                }
            }
        }
    }

    private void H(y yVar) {
        while (true) {
            String m5 = yVar.m();
            if (m5 == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(m5)) {
                I(yVar);
            } else if ("[V4+ Styles]".equalsIgnoreCase(m5)) {
                this.f11219q = J(yVar);
            } else if ("[V4 Styles]".equalsIgnoreCase(m5)) {
                n.f("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(m5)) {
                return;
            }
        }
    }

    private void I(y yVar) {
        while (true) {
            String m5 = yVar.m();
            if (m5 == null) {
                return;
            }
            if (yVar.a() != 0 && yVar.g() == 91) {
                return;
            }
            String[] split = m5.split(":");
            if (split.length == 2) {
                String S0 = s0.S0(split[0].trim());
                S0.hashCode();
                if (S0.equals("playresx")) {
                    this.f11220r = Float.parseFloat(split[1].trim());
                } else if (S0.equals("playresy")) {
                    try {
                        this.f11221s = Float.parseFloat(split[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    private static Map J(y yVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c.a aVar = null;
        while (true) {
            String m5 = yVar.m();
            if (m5 == null || (yVar.a() != 0 && yVar.g() == 91)) {
                break;
            } else if (m5.startsWith("Format:")) {
                aVar = c.a.a(m5);
            } else if (m5.startsWith("Style:")) {
                if (aVar == null) {
                    n.h("SsaDecoder", m5.length() != 0 ? "Skipping 'Style:' line before 'Format:' line: ".concat(m5) : new String("Skipping 'Style:' line before 'Format:' line: "));
                } else {
                    c b6 = c.b(m5, aVar);
                    if (b6 != null) {
                        linkedHashMap.put(b6.f11227a, b6);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static long K(String str) {
        Matcher matcher = f11216t.matcher(str.trim());
        if (matcher.matches()) {
            return (Long.parseLong((String) s0.j(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) s0.j(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) s0.j(matcher.group(3))) * 1000000) + (Long.parseLong((String) s0.j(matcher.group(4))) * 10000);
        }
        return -9223372036854775807L;
    }

    private static int L(int i6) {
        switch (i6) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                StringBuilder sb = new StringBuilder(30);
                sb.append("Unknown alignment: ");
                sb.append(i6);
                n.h("SsaDecoder", sb.toString());
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
        }
    }

    private static int M(int i6) {
        switch (i6) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                StringBuilder sb = new StringBuilder(30);
                sb.append("Unknown alignment: ");
                sb.append(i6);
                n.h("SsaDecoder", sb.toString());
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
        }
    }

    private static Layout.Alignment N(int i6) {
        switch (i6) {
            case -1:
                return null;
            case 0:
            default:
                StringBuilder sb = new StringBuilder(30);
                sb.append("Unknown alignment: ");
                sb.append(i6);
                n.h("SsaDecoder", sb.toString());
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    @Override // e2.d
    protected f A(byte[] bArr, int i6, boolean z5) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        y yVar = new y(bArr, i6);
        if (!this.f11217o) {
            H(yVar);
        }
        G(yVar, arrayList, arrayList2);
        return new d(arrayList, arrayList2);
    }
}
