package n2;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import e2.b;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n2.f;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f12222a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f12223b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c  reason: collision with root package name */
    private static final Map f12224c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map f12225d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: c  reason: collision with root package name */
        private static final Comparator f12226c = new Comparator() { // from class: n2.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e6;
                e6 = f.b.e((f.b) obj, (f.b) obj2);
                return e6;
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final c f12227a;

        /* renamed from: b  reason: collision with root package name */
        private final int f12228b;

        private b(c cVar, int i6) {
            this.f12227a = cVar;
            this.f12228b = i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int e(b bVar, b bVar2) {
            return Integer.compare(bVar.f12227a.f12230b, bVar2.f12227a.f12230b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f12229a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12230b;

        /* renamed from: c  reason: collision with root package name */
        public final String f12231c;

        /* renamed from: d  reason: collision with root package name */
        public final Set f12232d;

        private c(String str, int i6, String str2, Set set) {
            this.f12230b = i6;
            this.f12229a = str;
            this.f12231c = str2;
            this.f12232d = set;
        }

        public static c a(String str, int i6) {
            String str2;
            String trim = str.trim();
            com.google.android.exoplayer2.util.a.a(!trim.isEmpty());
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] K0 = s0.K0(trim, "\\.");
            String str3 = K0[0];
            HashSet hashSet = new HashSet();
            for (int i7 = 1; i7 < K0.length; i7++) {
                hashSet.add(K0[i7]);
            }
            return new c(str3, i6, str2, hashSet);
        }

        public static c b() {
            return new c(HttpUrl.FRAGMENT_ENCODE_SET, 0, HttpUrl.FRAGMENT_ENCODE_SET, Collections.emptySet());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        public final int f12233a;

        /* renamed from: b  reason: collision with root package name */
        public final n2.d f12234b;

        public d(int i6, n2.d dVar) {
            this.f12233a = i6;
            this.f12234b = dVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(d dVar) {
            return Integer.compare(this.f12233a, dVar.f12233a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f12237c;

        /* renamed from: a  reason: collision with root package name */
        public long f12235a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f12236b = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f12238d = 2;

        /* renamed from: e  reason: collision with root package name */
        public float f12239e = -3.4028235E38f;

        /* renamed from: f  reason: collision with root package name */
        public int f12240f = 1;

        /* renamed from: g  reason: collision with root package name */
        public int f12241g = 0;

        /* renamed from: h  reason: collision with root package name */
        public float f12242h = -3.4028235E38f;

        /* renamed from: i  reason: collision with root package name */
        public int f12243i = Integer.MIN_VALUE;

        /* renamed from: j  reason: collision with root package name */
        public float f12244j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public int f12245k = Integer.MIN_VALUE;

        private static float b(float f6, int i6) {
            int i7 = (f6 > (-3.4028235E38f) ? 1 : (f6 == (-3.4028235E38f) ? 0 : -1));
            if (i7 == 0 || i6 != 0 || (f6 >= 0.0f && f6 <= 1.0f)) {
                return i7 != 0 ? f6 : i6 == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        private static Layout.Alignment c(int i6) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 != 4) {
                            if (i6 != 5) {
                                StringBuilder sb = new StringBuilder(34);
                                sb.append("Unknown textAlignment: ");
                                sb.append(i6);
                                n.h("WebvttCueParser", sb.toString());
                                return null;
                            }
                        }
                    }
                    return Layout.Alignment.ALIGN_OPPOSITE;
                }
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        private static float d(int i6, float f6) {
            if (i6 != 0) {
                if (i6 == 1) {
                    return f6 <= 0.5f ? f6 * 2.0f : (1.0f - f6) * 2.0f;
                } else if (i6 == 2) {
                    return f6;
                } else {
                    throw new IllegalStateException(String.valueOf(i6));
                }
            }
            return 1.0f - f6;
        }

        private static float e(int i6) {
            if (i6 != 4) {
                return i6 != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        private static int f(int i6) {
            if (i6 != 1) {
                if (i6 != 3) {
                    if (i6 != 4) {
                        return i6 != 5 ? 1 : 2;
                    }
                    return 0;
                }
                return 2;
            }
            return 0;
        }

        public n2.e a() {
            return new n2.e(g().a(), this.f12235a, this.f12236b);
        }

        public b.C0159b g() {
            float f6 = this.f12242h;
            if (f6 == -3.4028235E38f) {
                f6 = e(this.f12238d);
            }
            int i6 = this.f12243i;
            if (i6 == Integer.MIN_VALUE) {
                i6 = f(this.f12238d);
            }
            b.C0159b p5 = new b.C0159b().n(c(this.f12238d)).h(b(this.f12239e, this.f12240f), this.f12240f).i(this.f12241g).j(f6).k(i6).l(Math.min(this.f12244j, d(i6, f6))).p(this.f12245k);
            CharSequence charSequence = this.f12237c;
            if (charSequence != null) {
                p5.m(charSequence);
            }
            return p5;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f12224c = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f12225d = Collections.unmodifiableMap(hashMap2);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, Set set, int i6, int i7) {
        Object foregroundColorSpan;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Map map = f12224c;
            if (map.containsKey(str)) {
                foregroundColorSpan = new ForegroundColorSpan(((Integer) map.get(str)).intValue());
            } else {
                Map map2 = f12225d;
                if (map2.containsKey(str)) {
                    foregroundColorSpan = new BackgroundColorSpan(((Integer) map2.get(str)).intValue());
                }
            }
            spannableStringBuilder.setSpan(foregroundColorSpan, i6, i7, 33);
        }
    }

    private static void b(String str, SpannableStringBuilder spannableStringBuilder) {
        char c6;
        str.hashCode();
        char c7 = 65535;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals("gt")) {
                    c7 = 0;
                    break;
                }
                break;
            case 3464:
                if (str.equals("lt")) {
                    c7 = 1;
                    break;
                }
                break;
            case 96708:
                if (str.equals("amp")) {
                    c7 = 2;
                    break;
                }
                break;
            case 3374865:
                if (str.equals("nbsp")) {
                    c7 = 3;
                    break;
                }
                break;
        }
        switch (c7) {
            case 0:
                c6 = '>';
                break;
            case 1:
                c6 = '<';
                break;
            case 2:
                c6 = '&';
                break;
            case 3:
                c6 = ' ';
                break;
            default:
                StringBuilder sb = new StringBuilder(str.length() + 33);
                sb.append("ignoring unsupported entity: '&");
                sb.append(str);
                sb.append(";'");
                n.h("WebvttCueParser", sb.toString());
                return;
        }
        spannableStringBuilder.append(c6);
    }

    private static void c(SpannableStringBuilder spannableStringBuilder, String str, c cVar, List list, List list2) {
        int i6 = i(list2, str, cVar);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, b.f12226c);
        int i7 = cVar.f12230b;
        int i8 = 0;
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            if ("rt".equals(((b) arrayList.get(i9)).f12227a.f12229a)) {
                b bVar = (b) arrayList.get(i9);
                int g6 = g(i(list2, str, bVar.f12227a), i6, 1);
                int i10 = bVar.f12227a.f12230b - i8;
                int i11 = bVar.f12228b - i8;
                CharSequence subSequence = spannableStringBuilder.subSequence(i10, i11);
                spannableStringBuilder.delete(i10, i11);
                spannableStringBuilder.setSpan(new i2.b(subSequence.toString(), g6), i7, i10, 33);
                i8 += subSequence.length();
                i7 = i10;
            }
        }
    }

    private static void d(String str, c cVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        Object styleSpan;
        int i6 = cVar.f12230b;
        int length = spannableStringBuilder.length();
        String str2 = cVar.f12229a;
        str2.hashCode();
        char c6 = 65535;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals(HttpUrl.FRAGMENT_ENCODE_SET)) {
                    c6 = 0;
                    break;
                }
                break;
            case androidx.constraintlayout.widget.g.Q0 /* 98 */:
                if (str2.equals("b")) {
                    c6 = 1;
                    break;
                }
                break;
            case androidx.constraintlayout.widget.g.R0 /* 99 */:
                if (str2.equals("c")) {
                    c6 = 2;
                    break;
                }
                break;
            case 105:
                if (str2.equals("i")) {
                    c6 = 3;
                    break;
                }
                break;
            case b.j.G0 /* 117 */:
                if (str2.equals("u")) {
                    c6 = 4;
                    break;
                }
                break;
            case b.j.H0 /* 118 */:
                if (str2.equals("v")) {
                    c6 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    c6 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str2.equals("ruby")) {
                    c6 = 7;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
            case 5:
            case 6:
                break;
            case 1:
                styleSpan = new StyleSpan(1);
                spannableStringBuilder.setSpan(styleSpan, i6, length, 33);
                break;
            case 2:
                a(spannableStringBuilder, cVar.f12232d, i6, length);
                break;
            case 3:
                styleSpan = new StyleSpan(2);
                spannableStringBuilder.setSpan(styleSpan, i6, length, 33);
                break;
            case 4:
                styleSpan = new UnderlineSpan();
                spannableStringBuilder.setSpan(styleSpan, i6, length, 33);
                break;
            case 7:
                c(spannableStringBuilder, str, cVar, list, list2);
                break;
            default:
                return;
        }
        List h6 = h(list2, str, cVar);
        for (int i7 = 0; i7 < h6.size(); i7++) {
            e(spannableStringBuilder, ((d) h6.get(i7)).f12234b, i6, length);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void e(SpannableStringBuilder spannableStringBuilder, n2.d dVar, int i6, int i7) {
        Object absoluteSizeSpan;
        if (dVar == null) {
            return;
        }
        if (dVar.i() != -1) {
            i2.c.a(spannableStringBuilder, new StyleSpan(dVar.i()), i6, i7, 33);
        }
        if (dVar.l()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i6, i7, 33);
        }
        if (dVar.m()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i6, i7, 33);
        }
        if (dVar.k()) {
            i2.c.a(spannableStringBuilder, new ForegroundColorSpan(dVar.c()), i6, i7, 33);
        }
        if (dVar.j()) {
            i2.c.a(spannableStringBuilder, new BackgroundColorSpan(dVar.a()), i6, i7, 33);
        }
        if (dVar.d() != null) {
            i2.c.a(spannableStringBuilder, new TypefaceSpan(dVar.d()), i6, i7, 33);
        }
        int f6 = dVar.f();
        if (f6 == 1) {
            absoluteSizeSpan = new AbsoluteSizeSpan((int) dVar.e(), true);
        } else if (f6 != 2) {
            if (f6 == 3) {
                absoluteSizeSpan = new RelativeSizeSpan(dVar.e() / 100.0f);
            }
            if (dVar.b()) {
                return;
            }
            spannableStringBuilder.setSpan(new i2.a(), i6, i7, 33);
            return;
        } else {
            absoluteSizeSpan = new RelativeSizeSpan(dVar.e());
        }
        i2.c.a(spannableStringBuilder, absoluteSizeSpan, i6, i7, 33);
        if (dVar.b()) {
        }
    }

    private static int f(String str, int i6) {
        int indexOf = str.indexOf(62, i6);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static int g(int i6, int i7, int i8) {
        if (i6 != -1) {
            return i6;
        }
        if (i7 != -1) {
            return i7;
        }
        if (i8 != -1) {
            return i8;
        }
        throw new IllegalArgumentException();
    }

    private static List h(List list, String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            n2.d dVar = (n2.d) list.get(i6);
            int h6 = dVar.h(str, cVar.f12229a, cVar.f12232d, cVar.f12231c);
            if (h6 > 0) {
                arrayList.add(new d(h6, dVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static int i(List list, String str, c cVar) {
        List h6 = h(list, str, cVar);
        for (int i6 = 0; i6 < h6.size(); i6++) {
            n2.d dVar = ((d) h6.get(i6)).f12234b;
            if (dVar.g() != -1) {
                return dVar.g();
            }
        }
        return -1;
    }

    private static String j(String str) {
        String trim = str.trim();
        com.google.android.exoplayer2.util.a.a(!trim.isEmpty());
        return s0.L0(trim, "[ \\.]")[0];
    }

    private static boolean k(String str) {
        str.hashCode();
        char c6 = 65535;
        switch (str.hashCode()) {
            case androidx.constraintlayout.widget.g.Q0 /* 98 */:
                if (str.equals("b")) {
                    c6 = 0;
                    break;
                }
                break;
            case androidx.constraintlayout.widget.g.R0 /* 99 */:
                if (str.equals("c")) {
                    c6 = 1;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    c6 = 2;
                    break;
                }
                break;
            case b.j.G0 /* 117 */:
                if (str.equals("u")) {
                    c6 = 3;
                    break;
                }
                break;
            case b.j.H0 /* 118 */:
                if (str.equals("v")) {
                    c6 = 4;
                    break;
                }
                break;
            case 3650:
                if (str.equals("rt")) {
                    c6 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str.equals("lang")) {
                    c6 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str.equals("ruby")) {
                    c6 = 7;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e2.b l(CharSequence charSequence) {
        e eVar = new e();
        eVar.f12237c = charSequence;
        return eVar.g().a();
    }

    public static n2.e m(y yVar, List list) {
        String m5 = yVar.m();
        if (m5 == null) {
            return null;
        }
        Pattern pattern = f12222a;
        Matcher matcher = pattern.matcher(m5);
        if (matcher.matches()) {
            return n(null, matcher, yVar, list);
        }
        String m6 = yVar.m();
        if (m6 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(m6);
        if (matcher2.matches()) {
            return n(m5.trim(), matcher2, yVar, list);
        }
        return null;
    }

    private static n2.e n(String str, Matcher matcher, y yVar, List list) {
        e eVar = new e();
        try {
            eVar.f12235a = i.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            eVar.f12236b = i.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(2)));
            p((String) com.google.android.exoplayer2.util.a.e(matcher.group(3)), eVar);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String m5 = yVar.m();
                if (TextUtils.isEmpty(m5)) {
                    eVar.f12237c = q(str, sb.toString(), list);
                    return eVar.a();
                }
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(m5.trim());
            }
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(matcher.group());
            n.h("WebvttCueParser", valueOf.length() != 0 ? "Skipping cue with bad header: ".concat(valueOf) : new String("Skipping cue with bad header: "));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b.C0159b o(String str) {
        e eVar = new e();
        p(str, eVar);
        return eVar.g();
    }

    private static void p(String str, e eVar) {
        Matcher matcher = f12223b.matcher(str);
        while (matcher.find()) {
            String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
            String str3 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    s(str3, eVar);
                } else if ("align".equals(str2)) {
                    eVar.f12238d = v(str3);
                } else if ("position".equals(str2)) {
                    u(str3, eVar);
                } else if ("size".equals(str2)) {
                    eVar.f12244j = i.c(str3);
                } else if ("vertical".equals(str2)) {
                    eVar.f12245k = w(str3);
                } else {
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 21 + String.valueOf(str3).length());
                    sb.append("Unknown cue setting ");
                    sb.append(str2);
                    sb.append(":");
                    sb.append(str3);
                    n.h("WebvttCueParser", sb.toString());
                }
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(matcher.group());
                n.h("WebvttCueParser", valueOf.length() != 0 ? "Skipping bad cue setting: ".concat(valueOf) : new String("Skipping bad cue setting: "));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpannedString q(String str, String str2, List list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (i6 < str2.length()) {
            char charAt = str2.charAt(i6);
            if (charAt == '&') {
                i6++;
                int indexOf = str2.indexOf(59, i6);
                int indexOf2 = str2.indexOf(32, i6);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    b(str2.substring(i6, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i6 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i6++;
            } else {
                int i7 = i6 + 1;
                if (i7 < str2.length()) {
                    boolean z5 = str2.charAt(i7) == '/';
                    i7 = f(str2, i7);
                    int i8 = i7 - 2;
                    boolean z6 = str2.charAt(i8) == '/';
                    int i9 = i6 + (z5 ? 2 : 1);
                    if (!z6) {
                        i8 = i7 - 1;
                    }
                    String substring = str2.substring(i9, i8);
                    if (!substring.trim().isEmpty()) {
                        String j6 = j(substring);
                        if (k(j6)) {
                            if (z5) {
                                while (!arrayDeque.isEmpty()) {
                                    c cVar = (c) arrayDeque.pop();
                                    d(str, cVar, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new b(cVar, spannableStringBuilder.length()));
                                    }
                                    if (cVar.f12229a.equals(j6)) {
                                        break;
                                    }
                                }
                            } else if (!z6) {
                                arrayDeque.push(c.a(substring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i6 = i7;
            }
        }
        while (!arrayDeque.isEmpty()) {
            d(str, (c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        d(str, c.b(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    private static int r(String str) {
        str.hashCode();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c6 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c6 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c6 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c6 = 3;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 0;
            default:
                n.h("WebvttCueParser", str.length() != 0 ? "Invalid anchor value: ".concat(str) : new String("Invalid anchor value: "));
                return Integer.MIN_VALUE;
        }
    }

    private static void s(String str, e eVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            eVar.f12241g = r(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            eVar.f12239e = i.c(str);
            eVar.f12240f = 0;
            return;
        }
        eVar.f12239e = Integer.parseInt(str);
        eVar.f12240f = 1;
    }

    private static int t(String str) {
        str.hashCode();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -1842484672:
                if (str.equals("line-left")) {
                    c6 = 0;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c6 = 1;
                    break;
                }
                break;
            case -1276788989:
                if (str.equals("line-right")) {
                    c6 = 2;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c6 = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c6 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c6 = 5;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
            case 5:
                return 0;
            case 1:
            case 3:
                return 1;
            case 2:
            case 4:
                return 2;
            default:
                n.h("WebvttCueParser", str.length() != 0 ? "Invalid anchor value: ".concat(str) : new String("Invalid anchor value: "));
                return Integer.MIN_VALUE;
        }
    }

    private static void u(String str, e eVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            eVar.f12243i = t(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        eVar.f12242h = i.c(str);
    }

    private static int v(String str) {
        str.hashCode();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c6 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c6 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c6 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c6 = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c6 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c6 = 5;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 1;
            default:
                n.h("WebvttCueParser", str.length() != 0 ? "Invalid alignment value: ".concat(str) : new String("Invalid alignment value: "));
                return 2;
        }
    }

    private static int w(String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        n.h("WebvttCueParser", str.length() != 0 ? "Invalid 'vertical' value: ".concat(str) : new String("Invalid 'vertical' value: "));
        return Integer.MIN_VALUE;
    }
}
