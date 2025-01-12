package n2;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
final class a {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f12197c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: a  reason: collision with root package name */
    private final y f12198a = new y();

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f12199b = new StringBuilder();

    private void a(d dVar, String str) {
        if (HttpUrl.FRAGMENT_ENCODE_SET.equals(str)) {
            return;
        }
        int indexOf = str.indexOf(91);
        if (indexOf != -1) {
            Matcher matcher = f12197c.matcher(str.substring(indexOf));
            if (matcher.matches()) {
                dVar.x((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            }
            str = str.substring(0, indexOf);
        }
        String[] K0 = s0.K0(str, "\\.");
        String str2 = K0[0];
        int indexOf2 = str2.indexOf(35);
        if (indexOf2 != -1) {
            dVar.w(str2.substring(0, indexOf2));
            dVar.v(str2.substring(indexOf2 + 1));
        } else {
            dVar.w(str2);
        }
        if (K0.length > 1) {
            dVar.u((String[]) s0.z0(K0, 1, K0.length));
        }
    }

    private static boolean b(y yVar) {
        int d6 = yVar.d();
        int e6 = yVar.e();
        byte[] c6 = yVar.c();
        if (d6 + 2 > e6) {
            return false;
        }
        int i6 = d6 + 1;
        if (c6[d6] != 47) {
            return false;
        }
        int i7 = i6 + 1;
        if (c6[i6] != 42) {
            return false;
        }
        while (true) {
            int i8 = i7 + 1;
            if (i8 >= e6) {
                yVar.N(e6 - yVar.d());
                return true;
            } else if (((char) c6[i7]) == '*' && ((char) c6[i8]) == '/') {
                i7 = i8 + 1;
                e6 = i7;
            } else {
                i7 = i8;
            }
        }
    }

    private static boolean c(y yVar) {
        char j6 = j(yVar, yVar.d());
        if (j6 == '\t' || j6 == '\n' || j6 == '\f' || j6 == '\r' || j6 == ' ') {
            yVar.N(1);
            return true;
        }
        return false;
    }

    private static String e(y yVar, StringBuilder sb) {
        boolean z5 = false;
        sb.setLength(0);
        int d6 = yVar.d();
        int e6 = yVar.e();
        while (d6 < e6 && !z5) {
            char c6 = (char) yVar.c()[d6];
            if ((c6 < 'A' || c6 > 'Z') && ((c6 < 'a' || c6 > 'z') && !((c6 >= '0' && c6 <= '9') || c6 == '#' || c6 == '-' || c6 == '.' || c6 == '_'))) {
                z5 = true;
            } else {
                d6++;
                sb.append(c6);
            }
        }
        yVar.N(d6 - yVar.d());
        return sb.toString();
    }

    static String f(y yVar, StringBuilder sb) {
        m(yVar);
        if (yVar.a() == 0) {
            return null;
        }
        String e6 = e(yVar, sb);
        if (HttpUrl.FRAGMENT_ENCODE_SET.equals(e6)) {
            StringBuilder sb2 = new StringBuilder(1);
            sb2.append((char) yVar.A());
            return sb2.toString();
        }
        return e6;
    }

    private static String g(y yVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z5 = false;
        while (!z5) {
            int d6 = yVar.d();
            String f6 = f(yVar, sb);
            if (f6 == null) {
                return null;
            }
            if ("}".equals(f6) || ";".equals(f6)) {
                yVar.M(d6);
                z5 = true;
            } else {
                sb2.append(f6);
            }
        }
        return sb2.toString();
    }

    private static String h(y yVar, StringBuilder sb) {
        m(yVar);
        if (yVar.a() >= 5 && "::cue".equals(yVar.x(5))) {
            int d6 = yVar.d();
            String f6 = f(yVar, sb);
            if (f6 == null) {
                return null;
            }
            if ("{".equals(f6)) {
                yVar.M(d6);
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            String k6 = "(".equals(f6) ? k(yVar) : null;
            if (")".equals(f(yVar, sb))) {
                return k6;
            }
            return null;
        }
        return null;
    }

    private static void i(y yVar, d dVar, StringBuilder sb) {
        m(yVar);
        String e6 = e(yVar, sb);
        if (!HttpUrl.FRAGMENT_ENCODE_SET.equals(e6) && ":".equals(f(yVar, sb))) {
            m(yVar);
            String g6 = g(yVar, sb);
            if (g6 == null || HttpUrl.FRAGMENT_ENCODE_SET.equals(g6)) {
                return;
            }
            int d6 = yVar.d();
            String f6 = f(yVar, sb);
            if (!";".equals(f6)) {
                if (!"}".equals(f6)) {
                    return;
                }
                yVar.M(d6);
            }
            if ("color".equals(e6)) {
                dVar.q(com.google.android.exoplayer2.util.e.b(g6));
            } else if ("background-color".equals(e6)) {
                dVar.n(com.google.android.exoplayer2.util.e.b(g6));
            } else {
                boolean z5 = true;
                if ("ruby-position".equals(e6)) {
                    if ("over".equals(g6)) {
                        dVar.t(1);
                    } else if ("under".equals(g6)) {
                        dVar.t(2);
                    }
                } else if ("text-combine-upright".equals(e6)) {
                    if (!"all".equals(g6) && !g6.startsWith("digits")) {
                        z5 = false;
                    }
                    dVar.p(z5);
                } else if ("text-decoration".equals(e6)) {
                    if ("underline".equals(g6)) {
                        dVar.y(true);
                    }
                } else if ("font-family".equals(e6)) {
                    dVar.r(g6);
                } else if ("font-weight".equals(e6)) {
                    if ("bold".equals(g6)) {
                        dVar.o(true);
                    }
                } else if ("font-style".equals(e6) && "italic".equals(g6)) {
                    dVar.s(true);
                }
            }
        }
    }

    private static char j(y yVar, int i6) {
        return (char) yVar.c()[i6];
    }

    private static String k(y yVar) {
        int d6 = yVar.d();
        int e6 = yVar.e();
        boolean z5 = false;
        while (d6 < e6 && !z5) {
            int i6 = d6 + 1;
            z5 = ((char) yVar.c()[d6]) == ')';
            d6 = i6;
        }
        return yVar.x((d6 - 1) - yVar.d()).trim();
    }

    static void l(y yVar) {
        do {
        } while (!TextUtils.isEmpty(yVar.m()));
    }

    static void m(y yVar) {
        while (true) {
            for (boolean z5 = true; yVar.a() > 0 && z5; z5 = false) {
                if (!c(yVar) && !b(yVar)) {
                }
            }
            return;
        }
    }

    public List d(y yVar) {
        this.f12199b.setLength(0);
        int d6 = yVar.d();
        l(yVar);
        this.f12198a.K(yVar.c(), yVar.d());
        this.f12198a.M(d6);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String h6 = h(this.f12198a, this.f12199b);
            if (h6 == null || !"{".equals(f(this.f12198a, this.f12199b))) {
                return arrayList;
            }
            d dVar = new d();
            a(dVar, h6);
            String str = null;
            boolean z5 = false;
            while (!z5) {
                int d7 = this.f12198a.d();
                String f6 = f(this.f12198a, this.f12199b);
                boolean z6 = f6 == null || "}".equals(f6);
                if (!z6) {
                    this.f12198a.M(d7);
                    i(this.f12198a, dVar, this.f12199b);
                }
                str = f6;
                z5 = z6;
            }
            if ("}".equals(str)) {
                arrayList.add(dVar);
            }
        }
    }
}
