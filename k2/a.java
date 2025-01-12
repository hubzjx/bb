package k2;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.y;
import e2.b;
import e2.d;
import e2.f;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: q  reason: collision with root package name */
    private static final Pattern f11273q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f11274r = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: o  reason: collision with root package name */
    private final StringBuilder f11275o;

    /* renamed from: p  reason: collision with root package name */
    private final ArrayList f11276p;

    public a() {
        super("SubripDecoder");
        this.f11275o = new StringBuilder();
        this.f11276p = new ArrayList();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private e2.b C(Spanned spanned, String str) {
        char c6;
        char c7;
        b.C0159b m5 = new b.C0159b().m(spanned);
        if (str == null) {
            return m5.a();
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c6 = 0;
                    break;
                }
                c6 = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c6 = 6;
                    break;
                }
                c6 = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c6 = 3;
                    break;
                }
                c6 = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c6 = 1;
                    break;
                }
                c6 = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c6 = 7;
                    break;
                }
                c6 = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c6 = 4;
                    break;
                }
                c6 = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c6 = '\b';
                    break;
                }
                c6 = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c6 = 5;
                    break;
                }
                c6 = 65535;
                break;
            default:
                c6 = 65535;
                break;
        }
        if (c6 == 0 || c6 == 1 || c6 == 2) {
            m5.k(0);
        } else if (c6 == 3 || c6 == 4 || c6 == 5) {
            m5.k(2);
        } else {
            m5.k(1);
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c7 = 0;
                    break;
                }
                c7 = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c7 = 1;
                    break;
                }
                c7 = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c7 = 2;
                    break;
                }
                c7 = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c7 = 6;
                    break;
                }
                c7 = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c7 = 7;
                    break;
                }
                c7 = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c7 = '\b';
                    break;
                }
                c7 = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c7 = 3;
                    break;
                }
                c7 = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c7 = 4;
                    break;
                }
                c7 = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c7 = 5;
                    break;
                }
                c7 = 65535;
                break;
            default:
                c7 = 65535;
                break;
        }
        if (c7 == 0 || c7 == 1 || c7 == 2) {
            m5.i(2);
        } else if (c7 == 3 || c7 == 4 || c7 == 5) {
            m5.i(0);
        } else {
            m5.i(1);
        }
        return m5.j(D(m5.d())).h(D(m5.c()), 0).a();
    }

    static float D(int i6) {
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 2) {
                    return 0.92f;
                }
                throw new IllegalArgumentException();
            }
            return 0.5f;
        }
        return 0.08f;
    }

    private static long E(Matcher matcher, int i6) {
        String group = matcher.group(i6 + 1);
        long parseLong = (group != null ? Long.parseLong(group) * 60 * 60 * 1000 : 0L) + (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(i6 + 2))) * 60 * 1000) + (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(i6 + 3))) * 1000);
        String group2 = matcher.group(i6 + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    private String F(String str, ArrayList arrayList) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder(trim);
        Matcher matcher = f11274r.matcher(trim);
        int i6 = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i6;
            int length = group.length();
            sb.replace(start, start + length, HttpUrl.FRAGMENT_ENCODE_SET);
            i6 += length;
        }
        return sb.toString();
    }

    @Override // e2.d
    protected f A(byte[] bArr, int i6, boolean z5) {
        String str;
        String str2;
        String str3;
        ArrayList arrayList = new ArrayList();
        o oVar = new o();
        y yVar = new y(bArr, i6);
        while (true) {
            String m5 = yVar.m();
            int i7 = 0;
            if (m5 == null) {
                break;
            } else if (m5.length() != 0) {
                try {
                    Integer.parseInt(m5);
                    m5 = yVar.m();
                } catch (NumberFormatException unused) {
                    str = "Skipping invalid index: ";
                    if (m5.length() == 0) {
                        str2 = new String("Skipping invalid index: ");
                    }
                }
                if (m5 == null) {
                    n.h("SubripDecoder", "Unexpected end");
                    break;
                }
                Matcher matcher = f11273q.matcher(m5);
                if (matcher.matches()) {
                    oVar.a(E(matcher, 1));
                    oVar.a(E(matcher, 6));
                    this.f11275o.setLength(0);
                    this.f11276p.clear();
                    while (true) {
                        String m6 = yVar.m();
                        if (TextUtils.isEmpty(m6)) {
                            break;
                        }
                        if (this.f11275o.length() > 0) {
                            this.f11275o.append("<br>");
                        }
                        this.f11275o.append(F(m6, this.f11276p));
                    }
                    Spanned fromHtml = Html.fromHtml(this.f11275o.toString());
                    while (true) {
                        if (i7 >= this.f11276p.size()) {
                            str3 = null;
                            break;
                        }
                        str3 = (String) this.f11276p.get(i7);
                        if (str3.matches("\\{\\\\an[1-9]\\}")) {
                            break;
                        }
                        i7++;
                    }
                    arrayList.add(C(fromHtml, str3));
                    arrayList.add(e2.b.f9435p);
                } else {
                    str = "Skipping invalid timing: ";
                    if (m5.length() == 0) {
                        str2 = new String("Skipping invalid timing: ");
                        n.h("SubripDecoder", str2);
                    }
                    str2 = str.concat(m5);
                    n.h("SubripDecoder", str2);
                }
            }
        }
        return new b((e2.b[]) arrayList.toArray(new e2.b[0]), oVar.d());
    }
}
