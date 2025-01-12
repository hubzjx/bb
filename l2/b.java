package l2;

import android.text.Layout;
import b.j;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.t0;
import e2.h;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes.dex */
public final class b extends e2.d {

    /* renamed from: p  reason: collision with root package name */
    private static final Pattern f11780p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: q  reason: collision with root package name */
    private static final Pattern f11781q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f11782r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: s  reason: collision with root package name */
    private static final Pattern f11783s = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: t  reason: collision with root package name */
    private static final Pattern f11784t = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: u  reason: collision with root package name */
    private static final Pattern f11785u = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: v  reason: collision with root package name */
    private static final C0191b f11786v = new C0191b(30.0f, 1, 1);

    /* renamed from: w  reason: collision with root package name */
    private static final a f11787w = new a(32, 15);

    /* renamed from: o  reason: collision with root package name */
    private final XmlPullParserFactory f11788o;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int f11789a;

        /* renamed from: b  reason: collision with root package name */
        final int f11790b;

        a(int i6, int i7) {
            this.f11789a = i6;
            this.f11790b = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l2.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0191b {

        /* renamed from: a  reason: collision with root package name */
        final float f11791a;

        /* renamed from: b  reason: collision with root package name */
        final int f11792b;

        /* renamed from: c  reason: collision with root package name */
        final int f11793c;

        C0191b(float f6, int i6, int i7) {
            this.f11791a = f6;
            this.f11792b = i6;
            this.f11793c = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final int f11794a;

        /* renamed from: b  reason: collision with root package name */
        final int f11795b;

        c(int i6, int i7) {
            this.f11794a = i6;
            this.f11795b = i7;
        }
    }

    public b() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f11788o = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e6) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e6);
        }
    }

    private static f C(f fVar) {
        return fVar == null ? new f() : fVar;
    }

    private static boolean D(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    private static a E(XmlPullParser xmlPullParser, a aVar) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f11785u.matcher(attributeValue);
        if (!matcher.matches()) {
            n.h("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring malformed cell resolution: ".concat(attributeValue) : new String("Ignoring malformed cell resolution: "));
            return aVar;
        }
        try {
            int parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(2)));
            if (parseInt == 0 || parseInt2 == 0) {
                StringBuilder sb = new StringBuilder(47);
                sb.append("Invalid cell resolution ");
                sb.append(parseInt);
                sb.append(" ");
                sb.append(parseInt2);
                throw new h(sb.toString());
            }
            return new a(parseInt, parseInt2);
        } catch (NumberFormatException unused) {
            n.h("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring malformed cell resolution: ".concat(attributeValue) : new String("Ignoring malformed cell resolution: "));
            return aVar;
        }
    }

    private static void F(String str, f fVar) {
        Matcher matcher;
        String[] K0 = s0.K0(str, "\\s+");
        if (K0.length == 1) {
            matcher = f11782r.matcher(str);
        } else if (K0.length != 2) {
            int length = K0.length;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Invalid number of entries for fontSize: ");
            sb.append(length);
            sb.append(".");
            throw new h(sb.toString());
        } else {
            matcher = f11782r.matcher(K0[1]);
            n.h("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 36);
            sb2.append("Invalid expression for fontSize: '");
            sb2.append(str);
            sb2.append("'.");
            throw new h(sb2.toString());
        }
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(3));
        str2.hashCode();
        char c6 = 65535;
        switch (str2.hashCode()) {
            case 37:
                if (str2.equals("%")) {
                    c6 = 0;
                    break;
                }
                break;
            case 3240:
                if (str2.equals("em")) {
                    c6 = 1;
                    break;
                }
                break;
            case 3592:
                if (str2.equals("px")) {
                    c6 = 2;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                fVar.w(3);
                break;
            case 1:
                fVar.w(2);
                break;
            case 2:
                fVar.w(1);
                break;
            default:
                StringBuilder sb3 = new StringBuilder(str2.length() + 30);
                sb3.append("Invalid unit for fontSize: '");
                sb3.append(str2);
                sb3.append("'.");
                throw new h(sb3.toString());
        }
        fVar.v(Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))));
    }

    private static C0191b G(XmlPullParser xmlPullParser) {
        float f6;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] K0 = s0.K0(attributeValue2, " ");
            if (K0.length != 2) {
                throw new h("frameRateMultiplier doesn't have 2 parts");
            }
            f6 = Integer.parseInt(K0[0]) / Integer.parseInt(K0[1]);
        } else {
            f6 = 1.0f;
        }
        C0191b c0191b = f11786v;
        int i6 = c0191b.f11792b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i6 = Integer.parseInt(attributeValue3);
        }
        int i7 = c0191b.f11793c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i7 = Integer.parseInt(attributeValue4);
        }
        return new C0191b(parseInt * f6, i6, i7);
    }

    private static Map H(XmlPullParser xmlPullParser, Map map, a aVar, c cVar, Map map2, Map map3) {
        do {
            xmlPullParser.next();
            if (t0.f(xmlPullParser, "style")) {
                String a6 = t0.a(xmlPullParser, "style");
                f L = L(xmlPullParser, new f());
                if (a6 != null) {
                    for (String str : M(a6)) {
                        L.a((f) map.get(str));
                    }
                }
                String g6 = L.g();
                if (g6 != null) {
                    map.put(g6, L);
                }
            } else if (t0.f(xmlPullParser, "region")) {
                d K = K(xmlPullParser, aVar, cVar);
                if (K != null) {
                    map2.put(K.f11809a, K);
                }
            } else if (t0.f(xmlPullParser, "metadata")) {
                I(xmlPullParser, map3);
            }
        } while (!t0.d(xmlPullParser, "head"));
        return map;
    }

    private static void I(XmlPullParser xmlPullParser, Map map) {
        String a6;
        do {
            xmlPullParser.next();
            if (t0.f(xmlPullParser, "image") && (a6 = t0.a(xmlPullParser, "id")) != null) {
                map.put(a6, xmlPullParser.nextText());
            }
        } while (!t0.d(xmlPullParser, "metadata"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static l2.c J(XmlPullParser xmlPullParser, l2.c cVar, Map map, C0191b c0191b) {
        long j6;
        long j7;
        char c6;
        int attributeCount = xmlPullParser.getAttributeCount();
        f L = L(xmlPullParser, null);
        String[] strArr = null;
        String str = null;
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        long j8 = -9223372036854775807L;
        long j9 = -9223372036854775807L;
        long j10 = -9223372036854775807L;
        for (int i6 = 0; i6 < attributeCount; i6++) {
            String attributeName = xmlPullParser.getAttributeName(i6);
            String attributeValue = xmlPullParser.getAttributeValue(i6);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c6 = 3;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c6 = 4;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c6 = 5;
                        break;
                    }
                    c6 = 65535;
                    break;
                default:
                    c6 = 65535;
                    break;
            }
            switch (c6) {
                case 0:
                    if (map.containsKey(attributeValue)) {
                        str2 = attributeValue;
                        continue;
                    }
                case 1:
                    j10 = N(attributeValue, c0191b);
                    break;
                case 2:
                    j9 = N(attributeValue, c0191b);
                    break;
                case 3:
                    j8 = N(attributeValue, c0191b);
                    break;
                case 4:
                    String[] M = M(attributeValue);
                    if (M.length > 0) {
                        strArr = M;
                        break;
                    }
                    break;
                case 5:
                    if (attributeValue.startsWith("#")) {
                        str = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (cVar != null) {
            long j11 = cVar.f11799d;
            j6 = -9223372036854775807L;
            if (j11 != -9223372036854775807L) {
                if (j8 != -9223372036854775807L) {
                    j8 += j11;
                }
                if (j9 != -9223372036854775807L) {
                    j9 += j11;
                }
            }
        } else {
            j6 = -9223372036854775807L;
        }
        long j12 = j8;
        if (j9 == j6) {
            if (j10 != j6) {
                j7 = j12 + j10;
            } else if (cVar != null) {
                long j13 = cVar.f11800e;
                if (j13 != j6) {
                    j7 = j13;
                }
            }
            return l2.c.c(xmlPullParser.getName(), j12, j7, L, strArr, str2, str, cVar);
        }
        j7 = j9;
        return l2.c.c(xmlPullParser.getName(), j12, j7, L, strArr, str2, str, cVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01af, code lost:
        if (r0.equals("tb") == false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0182  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static d K(XmlPullParser xmlPullParser, a aVar, c cVar) {
        String str;
        float parseFloat;
        float f6;
        float parseFloat2;
        float parseFloat3;
        a aVar2;
        float f7;
        int i6;
        String a6;
        int i7;
        String a7 = t0.a(xmlPullParser, "id");
        if (a7 == null) {
            return null;
        }
        String a8 = t0.a(xmlPullParser, "origin");
        if (a8 != null) {
            Pattern pattern = f11783s;
            Matcher matcher = pattern.matcher(a8);
            Pattern pattern2 = f11784t;
            Matcher matcher2 = pattern2.matcher(a8);
            if (matcher.matches()) {
                try {
                    float parseFloat4 = Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) / 100.0f;
                    parseFloat = Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))) / 100.0f;
                    f6 = parseFloat4;
                } catch (NumberFormatException unused) {
                    n.h("TtmlDecoder", a8.length() != 0 ? "Ignoring region with malformed origin: ".concat(a8) : new String("Ignoring region with malformed origin: "));
                    return null;
                }
            } else if (!matcher2.matches()) {
                n.h("TtmlDecoder", a8.length() != 0 ? "Ignoring region with unsupported origin: ".concat(a8) : new String("Ignoring region with unsupported origin: "));
                return null;
            } else if (cVar == null) {
                n.h("TtmlDecoder", a8.length() != 0 ? "Ignoring region with missing tts:extent: ".concat(a8) : new String("Ignoring region with missing tts:extent: "));
                return null;
            } else {
                try {
                    int parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher2.group(1)));
                    int parseInt2 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher2.group(2)));
                    f6 = parseInt / cVar.f11794a;
                    parseFloat = parseInt2 / cVar.f11795b;
                } catch (NumberFormatException unused2) {
                    n.h("TtmlDecoder", a8.length() != 0 ? "Ignoring region with malformed origin: ".concat(a8) : new String("Ignoring region with malformed origin: "));
                    return null;
                }
            }
            String a9 = t0.a(xmlPullParser, "extent");
            if (a9 != null) {
                Matcher matcher3 = pattern.matcher(a9);
                Matcher matcher4 = pattern2.matcher(a9);
                if (matcher3.matches()) {
                    try {
                        parseFloat2 = Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher3.group(1))) / 100.0f;
                        parseFloat3 = Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher3.group(2))) / 100.0f;
                    } catch (NumberFormatException unused3) {
                        n.h("TtmlDecoder", a8.length() != 0 ? "Ignoring region with malformed extent: ".concat(a8) : new String("Ignoring region with malformed extent: "));
                        return null;
                    }
                } else if (!matcher4.matches()) {
                    n.h("TtmlDecoder", a8.length() != 0 ? "Ignoring region with unsupported extent: ".concat(a8) : new String("Ignoring region with unsupported extent: "));
                    return null;
                } else if (cVar == null) {
                    n.h("TtmlDecoder", a8.length() != 0 ? "Ignoring region with missing tts:extent: ".concat(a8) : new String("Ignoring region with missing tts:extent: "));
                    return null;
                } else {
                    try {
                        int parseInt3 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher4.group(1)));
                        int parseInt4 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher4.group(2)));
                        parseFloat2 = parseInt3 / cVar.f11794a;
                        parseFloat3 = parseInt4 / cVar.f11795b;
                    } catch (NumberFormatException unused4) {
                        n.h("TtmlDecoder", a8.length() != 0 ? "Ignoring region with malformed extent: ".concat(a8) : new String("Ignoring region with malformed extent: "));
                        return null;
                    }
                }
                String a10 = t0.a(xmlPullParser, "displayAlign");
                char c6 = 0;
                if (a10 != null) {
                    String S0 = s0.S0(a10);
                    S0.hashCode();
                    if (S0.equals("center")) {
                        aVar2 = aVar;
                        f7 = parseFloat + (parseFloat3 / 2.0f);
                        i6 = 1;
                    } else if (S0.equals("after")) {
                        aVar2 = aVar;
                        f7 = parseFloat + parseFloat3;
                        i6 = 2;
                    }
                    float f8 = 1.0f / aVar2.f11790b;
                    a6 = t0.a(xmlPullParser, "writingMode");
                    if (a6 != null) {
                        String S02 = s0.S0(a6);
                        S02.hashCode();
                        switch (S02.hashCode()) {
                            case 3694:
                                break;
                            case 3553396:
                                if (S02.equals("tblr")) {
                                    c6 = 1;
                                    break;
                                }
                                c6 = 65535;
                                break;
                            case 3553576:
                                if (S02.equals("tbrl")) {
                                    c6 = 2;
                                    break;
                                }
                                c6 = 65535;
                                break;
                            default:
                                c6 = 65535;
                                break;
                        }
                        switch (c6) {
                            case 0:
                            case 1:
                                i7 = 2;
                                break;
                            case 2:
                                i7 = 1;
                                break;
                        }
                        return new d(a7, f6, f7, 0, i6, parseFloat2, parseFloat3, 1, f8, i7);
                    }
                    i7 = Integer.MIN_VALUE;
                    return new d(a7, f6, f7, 0, i6, parseFloat2, parseFloat3, 1, f8, i7);
                }
                aVar2 = aVar;
                f7 = parseFloat;
                i6 = 0;
                float f82 = 1.0f / aVar2.f11790b;
                a6 = t0.a(xmlPullParser, "writingMode");
                if (a6 != null) {
                }
                i7 = Integer.MIN_VALUE;
                return new d(a7, f6, f7, 0, i6, parseFloat2, parseFloat3, 1, f82, i7);
            }
            str = "Ignoring region without an extent";
        } else {
            str = "Ignoring region without an origin";
        }
        n.h("TtmlDecoder", str);
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0297, code lost:
        if (r3.equals("start") == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x018e, code lost:
        if (r3.equals("text") == false) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static f L(XmlPullParser xmlPullParser, f fVar) {
        char c6;
        String valueOf;
        String str;
        String str2;
        f C;
        Layout.Alignment alignment;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i6 = 0; i6 < attributeCount; i6++) {
            String attributeValue = xmlPullParser.getAttributeValue(i6);
            String attributeName = xmlPullParser.getAttributeName(i6);
            attributeName.hashCode();
            char c7 = 5;
            char c8 = 4;
            char c9 = 65535;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c6 = 3;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c6 = 4;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c6 = 5;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        c6 = 6;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        c6 = 7;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        c6 = '\b';
                        break;
                    }
                    c6 = 65535;
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c6 = '\t';
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        c6 = '\n';
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c6 = 11;
                        break;
                    }
                    c6 = 65535;
                    break;
                default:
                    c6 = 65535;
                    break;
            }
            switch (c6) {
                case 0:
                    fVar = C(fVar).y("italic".equalsIgnoreCase(attributeValue));
                    continue;
                case 1:
                    fVar = C(fVar).u(attributeValue);
                    continue;
                case 2:
                    String S0 = s0.S0(attributeValue);
                    S0.hashCode();
                    switch (S0.hashCode()) {
                        case -1364013995:
                            if (S0.equals("center")) {
                                c8 = 0;
                                break;
                            }
                            c8 = 65535;
                            break;
                        case 100571:
                            if (S0.equals("end")) {
                                c8 = 1;
                                break;
                            }
                            c8 = 65535;
                            break;
                        case 3317767:
                            if (S0.equals("left")) {
                                c8 = 2;
                                break;
                            }
                            c8 = 65535;
                            break;
                        case 108511772:
                            if (S0.equals("right")) {
                                c8 = 3;
                                break;
                            }
                            c8 = 65535;
                            break;
                        case 109757538:
                            break;
                        default:
                            c8 = 65535;
                            break;
                    }
                    switch (c8) {
                        case 0:
                            C = C(fVar);
                            alignment = Layout.Alignment.ALIGN_CENTER;
                            fVar = C.C(alignment);
                            continue;
                        case 1:
                        case 3:
                            C = C(fVar);
                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                            fVar = C.C(alignment);
                            continue;
                        case 2:
                        case 4:
                            C = C(fVar);
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                            fVar = C.C(alignment);
                            continue;
                    }
                    break;
                case 3:
                    String S02 = s0.S0(attributeValue);
                    S02.hashCode();
                    switch (S02.hashCode()) {
                        case -1461280213:
                            if (S02.equals("nounderline")) {
                                c9 = 0;
                                break;
                            }
                            break;
                        case -1026963764:
                            if (S02.equals("underline")) {
                                c9 = 1;
                                break;
                            }
                            break;
                        case 913457136:
                            if (S02.equals("nolinethrough")) {
                                c9 = 2;
                                break;
                            }
                            break;
                        case 1679736913:
                            if (S02.equals("linethrough")) {
                                c9 = 3;
                                break;
                            }
                            break;
                    }
                    switch (c9) {
                        case 0:
                            fVar = C(fVar).E(false);
                            continue;
                        case 1:
                            fVar = C(fVar).E(true);
                            continue;
                        case 2:
                            fVar = C(fVar).z(false);
                            continue;
                        case 3:
                            fVar = C(fVar).z(true);
                            continue;
                            continue;
                    }
                    break;
                case 4:
                    fVar = C(fVar).s("bold".equalsIgnoreCase(attributeValue));
                    continue;
                case 5:
                    if ("style".equals(xmlPullParser.getName())) {
                        fVar = C(fVar).x(attributeValue);
                    } else {
                        continue;
                    }
                case 6:
                    String S03 = s0.S0(attributeValue);
                    S03.hashCode();
                    switch (S03.hashCode()) {
                        case -618561360:
                            if (S03.equals("baseContainer")) {
                                c7 = 0;
                                break;
                            }
                            c7 = 65535;
                            break;
                        case -410956671:
                            if (S03.equals("container")) {
                                c7 = 1;
                                break;
                            }
                            c7 = 65535;
                            break;
                        case -250518009:
                            if (S03.equals("delimiter")) {
                                c7 = 2;
                                break;
                            }
                            c7 = 65535;
                            break;
                        case -136074796:
                            if (S03.equals("textContainer")) {
                                c7 = 3;
                                break;
                            }
                            c7 = 65535;
                            break;
                        case 3016401:
                            if (S03.equals("base")) {
                                c7 = 4;
                                break;
                            }
                            c7 = 65535;
                            break;
                        case 3556653:
                            break;
                        default:
                            c7 = 65535;
                            break;
                    }
                    switch (c7) {
                        case 0:
                        case 4:
                            fVar = C(fVar).B(2);
                            continue;
                        case 1:
                            fVar = C(fVar).B(1);
                            continue;
                        case 2:
                            fVar = C(fVar).B(4);
                            continue;
                        case 3:
                        case 5:
                            fVar = C(fVar).B(3);
                            continue;
                            continue;
                    }
                    break;
                case 7:
                    fVar = C(fVar);
                    try {
                        fVar.t(com.google.android.exoplayer2.util.e.c(attributeValue));
                        continue;
                    } catch (IllegalArgumentException unused) {
                        valueOf = String.valueOf(attributeValue);
                        str = "Failed parsing color value: ";
                        if (valueOf.length() == 0) {
                            str2 = new String("Failed parsing color value: ");
                            break;
                        }
                        str2 = str.concat(valueOf);
                        break;
                    }
                case '\b':
                    String S04 = s0.S0(attributeValue);
                    S04.hashCode();
                    if (S04.equals("all")) {
                        fVar = C(fVar).D(true);
                    } else if (S04.equals("none")) {
                        fVar = C(fVar).D(false);
                        continue;
                    }
                case '\t':
                    try {
                        fVar = C(fVar);
                        F(attributeValue, fVar);
                        continue;
                    } catch (h unused2) {
                        valueOf = String.valueOf(attributeValue);
                        str = "Failed parsing fontSize value: ";
                        if (valueOf.length() == 0) {
                            str2 = new String("Failed parsing fontSize value: ");
                            break;
                        }
                        str2 = str.concat(valueOf);
                        break;
                    }
                case '\n':
                    String S05 = s0.S0(attributeValue);
                    S05.hashCode();
                    if (S05.equals("before")) {
                        fVar = C(fVar).A(1);
                    } else if (S05.equals("after")) {
                        fVar = C(fVar).A(2);
                        continue;
                    }
                case 11:
                    fVar = C(fVar);
                    try {
                        fVar.r(com.google.android.exoplayer2.util.e.c(attributeValue));
                        continue;
                    } catch (IllegalArgumentException unused3) {
                        valueOf = String.valueOf(attributeValue);
                        str = "Failed parsing background value: ";
                        if (valueOf.length() == 0) {
                            str2 = new String("Failed parsing background value: ");
                            break;
                        }
                        str2 = str.concat(valueOf);
                        break;
                    }
                default:
            }
            n.h("TtmlDecoder", str2);
        }
        return fVar;
    }

    private static String[] M(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : s0.K0(trim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00bf, code lost:
        if (r13.equals("ms") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long N(String str, C0191b c0191b) {
        double d6;
        double d7;
        String group;
        String group2;
        Matcher matcher = f11780p.matcher(str);
        char c6 = 4;
        if (matcher.matches()) {
            double parseLong = (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) * 3600) + (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))) * 60) + Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(3)));
            String group3 = matcher.group(4);
            return (long) ((parseLong + (group3 != null ? Double.parseDouble(group3) : 0.0d) + (matcher.group(5) != null ? ((float) Long.parseLong(group)) / c0191b.f11791a : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(group2) / c0191b.f11792b) / c0191b.f11791a : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = f11781q.matcher(str);
        if (!matcher2.matches()) {
            String valueOf = String.valueOf(str);
            throw new h(valueOf.length() != 0 ? "Malformed time expression: ".concat(valueOf) : new String("Malformed time expression: "));
        }
        double parseDouble = Double.parseDouble((String) com.google.android.exoplayer2.util.a.e(matcher2.group(1)));
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher2.group(2));
        str2.hashCode();
        switch (str2.hashCode()) {
            case androidx.constraintlayout.widget.g.U0 /* 102 */:
                if (str2.equals("f")) {
                    c6 = 0;
                    break;
                }
                c6 = 65535;
                break;
            case androidx.constraintlayout.widget.g.W0 /* 104 */:
                if (str2.equals("h")) {
                    c6 = 1;
                    break;
                }
                c6 = 65535;
                break;
            case 109:
                if (str2.equals("m")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            case j.F0 /* 116 */:
                if (str2.equals("t")) {
                    c6 = 3;
                    break;
                }
                c6 = 65535;
                break;
            case 3494:
                break;
            default:
                c6 = 65535;
                break;
        }
        switch (c6) {
            case 0:
                d6 = c0191b.f11791a;
                parseDouble /= d6;
                return (long) (parseDouble * 1000000.0d);
            case 1:
                d7 = 3600.0d;
                parseDouble *= d7;
                return (long) (parseDouble * 1000000.0d);
            case 2:
                d7 = 60.0d;
                parseDouble *= d7;
                return (long) (parseDouble * 1000000.0d);
            case 3:
                d6 = c0191b.f11793c;
                parseDouble /= d6;
                return (long) (parseDouble * 1000000.0d);
            case 4:
                d6 = 1000.0d;
                parseDouble /= d6;
                return (long) (parseDouble * 1000000.0d);
            default:
                return (long) (parseDouble * 1000000.0d);
        }
    }

    private static c O(XmlPullParser xmlPullParser) {
        String a6 = t0.a(xmlPullParser, "extent");
        if (a6 == null) {
            return null;
        }
        Matcher matcher = f11784t.matcher(a6);
        if (!matcher.matches()) {
            n.h("TtmlDecoder", a6.length() != 0 ? "Ignoring non-pixel tts extent: ".concat(a6) : new String("Ignoring non-pixel tts extent: "));
            return null;
        }
        try {
            return new c(Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))), Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))));
        } catch (NumberFormatException unused) {
            n.h("TtmlDecoder", a6.length() != 0 ? "Ignoring malformed tts extent: ".concat(a6) : new String("Ignoring malformed tts extent: "));
            return null;
        }
    }

    @Override // e2.d
    protected e2.f A(byte[] bArr, int i6, boolean z5) {
        C0191b c0191b;
        try {
            XmlPullParser newPullParser = this.f11788o.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put(HttpUrl.FRAGMENT_ENCODE_SET, new d(HttpUrl.FRAGMENT_ENCODE_SET));
            c cVar = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i6), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            C0191b c0191b2 = f11786v;
            a aVar = f11787w;
            g gVar = null;
            int i7 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                l2.c cVar2 = (l2.c) arrayDeque.peek();
                if (i7 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            c0191b2 = G(newPullParser);
                            aVar = E(newPullParser, f11787w);
                            cVar = O(newPullParser);
                        }
                        c cVar3 = cVar;
                        C0191b c0191b3 = c0191b2;
                        a aVar2 = aVar;
                        if (D(name)) {
                            if ("head".equals(name)) {
                                c0191b = c0191b3;
                                H(newPullParser, hashMap, aVar2, cVar3, hashMap2, hashMap3);
                            } else {
                                c0191b = c0191b3;
                                try {
                                    l2.c J = J(newPullParser, cVar2, hashMap2, c0191b);
                                    arrayDeque.push(J);
                                    if (cVar2 != null) {
                                        cVar2.a(J);
                                    }
                                } catch (h e6) {
                                    n.i("TtmlDecoder", "Suppressing parser error", e6);
                                    i7++;
                                }
                            }
                            c0191b2 = c0191b;
                        } else {
                            String valueOf = String.valueOf(newPullParser.getName());
                            n.f("TtmlDecoder", valueOf.length() != 0 ? "Ignoring unsupported tag: ".concat(valueOf) : new String("Ignoring unsupported tag: "));
                            i7++;
                            c0191b2 = c0191b3;
                        }
                        cVar = cVar3;
                        aVar = aVar2;
                    } else if (eventType == 4) {
                        ((l2.c) com.google.android.exoplayer2.util.a.e(cVar2)).a(l2.c.d(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            gVar = new g((l2.c) com.google.android.exoplayer2.util.a.e((l2.c) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i7++;
                } else if (eventType == 3) {
                    i7--;
                }
                newPullParser.next();
            }
            if (gVar != null) {
                return gVar;
            }
            throw new h("No TTML subtitles found");
        } catch (IOException e7) {
            throw new IllegalStateException("Unexpected error when reading input.", e7);
        } catch (XmlPullParserException e8) {
            throw new h("Unable to decode source", e8);
        }
    }
}
