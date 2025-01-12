package j2;

import android.graphics.PointF;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f11227a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11228b;

    /* loaded from: classes.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f11229a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11230b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11231c;

        private a(int i6, int i7, int i8) {
            this.f11229a = i6;
            this.f11230b = i7;
            this.f11231c = i8;
        }

        public static a a(String str) {
            String[] split = TextUtils.split(str.substring(7), ",");
            int i6 = -1;
            int i7 = -1;
            for (int i8 = 0; i8 < split.length; i8++) {
                String S0 = s0.S0(split[i8].trim());
                S0.hashCode();
                if (S0.equals("name")) {
                    i6 = i8;
                } else if (S0.equals("alignment")) {
                    i7 = i8;
                }
            }
            if (i6 != -1) {
                return new a(i6, i7, split.length);
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    static final class b {

        /* renamed from: c  reason: collision with root package name */
        private static final Pattern f11232c = Pattern.compile("\\{([^}]*)\\}");

        /* renamed from: d  reason: collision with root package name */
        private static final Pattern f11233d = Pattern.compile(s0.D("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: e  reason: collision with root package name */
        private static final Pattern f11234e = Pattern.compile(s0.D("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: f  reason: collision with root package name */
        private static final Pattern f11235f = Pattern.compile("\\\\an(\\d+)");

        /* renamed from: a  reason: collision with root package name */
        public final int f11236a;

        /* renamed from: b  reason: collision with root package name */
        public final PointF f11237b;

        private b(int i6, PointF pointF) {
            this.f11236a = i6;
            this.f11237b = pointF;
        }

        private static int a(String str) {
            Matcher matcher = f11235f.matcher(str);
            if (matcher.find()) {
                return c.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            }
            return -1;
        }

        public static b b(String str) {
            Matcher matcher = f11232c.matcher(str);
            PointF pointF = null;
            int i6 = -1;
            while (matcher.find()) {
                String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
                try {
                    PointF c6 = c(str2);
                    if (c6 != null) {
                        pointF = c6;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int a6 = a(str2);
                    if (a6 != -1) {
                        i6 = a6;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new b(i6, pointF);
        }

        private static PointF c(String str) {
            String group;
            String group2;
            Matcher matcher = f11233d.matcher(str);
            Matcher matcher2 = f11234e.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 82);
                    sb.append("Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='");
                    sb.append(str);
                    sb.append("'");
                    n.f("SsaStyle.Overrides", sb.toString());
                }
                group = matcher.group(1);
                group2 = matcher.group(2);
            } else if (!find2) {
                return null;
            } else {
                group = matcher2.group(1);
                group2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) com.google.android.exoplayer2.util.a.e(group)).trim()), Float.parseFloat(((String) com.google.android.exoplayer2.util.a.e(group2)).trim()));
        }

        public static String d(String str) {
            return f11232c.matcher(str).replaceAll(HttpUrl.FRAGMENT_ENCODE_SET);
        }
    }

    private c(String str, int i6) {
        this.f11227a = str;
        this.f11228b = i6;
    }

    public static c b(String str, a aVar) {
        com.google.android.exoplayer2.util.a.a(str.startsWith("Style:"));
        String[] split = TextUtils.split(str.substring(6), ",");
        int length = split.length;
        int i6 = aVar.f11231c;
        if (length != i6) {
            n.h("SsaStyle", s0.D("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i6), Integer.valueOf(split.length), str));
            return null;
        }
        try {
            return new c(split[aVar.f11229a].trim(), d(split[aVar.f11230b]));
        } catch (RuntimeException e6) {
            StringBuilder sb = new StringBuilder(str.length() + 36);
            sb.append("Skipping malformed 'Style:' line: '");
            sb.append(str);
            sb.append("'");
            n.i("SsaStyle", sb.toString(), e6);
            return null;
        }
    }

    private static boolean c(int i6) {
        switch (i6) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (c(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        String valueOf = String.valueOf(str);
        n.h("SsaStyle", valueOf.length() != 0 ? "Ignoring unknown alignment: ".concat(valueOf) : new String("Ignoring unknown alignment: "));
        return -1;
    }
}
