package a2;

import a2.j;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.Xml;
import com.google.android.exoplayer2.drm.k;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.util.t0;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import q2.f0;
/* loaded from: classes.dex */
public class c extends DefaultHandler implements f0.a {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f63b = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f64c = Pattern.compile("CC([1-4])=.*");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f65d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f66e = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* renamed from: a  reason: collision with root package name */
    private final XmlPullParserFactory f67a;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final s0 f68a;

        /* renamed from: b  reason: collision with root package name */
        public final String f69b;

        /* renamed from: c  reason: collision with root package name */
        public final j f70c;

        /* renamed from: d  reason: collision with root package name */
        public final String f71d;

        /* renamed from: e  reason: collision with root package name */
        public final ArrayList f72e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayList f73f;

        /* renamed from: g  reason: collision with root package name */
        public final long f74g;

        public a(s0 s0Var, String str, j jVar, String str2, ArrayList arrayList, ArrayList arrayList2, long j6) {
            this.f68a = s0Var;
            this.f69b = str;
            this.f70c = jVar;
            this.f71d = str2;
            this.f72e = arrayList;
            this.f73f = arrayList2;
            this.f74g = j6;
        }
    }

    public c() {
        try {
            this.f67a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e6) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e6);
        }
    }

    protected static int A(List list) {
        String str;
        for (int i6 = 0; i6 < list.size(); i6++) {
            d dVar = (d) list.get(i6);
            if ("urn:scte:dash:cc:cea-708:2015".equals(dVar.f75a) && (str = dVar.f76b) != null) {
                Matcher matcher = f65d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                String valueOf = String.valueOf(dVar.f76b);
                n.h("MpdParser", valueOf.length() != 0 ? "Unable to parse CEA-708 service block number from: ".concat(valueOf) : new String("Unable to parse CEA-708 service block number from: "));
            }
        }
        return -1;
    }

    protected static long E(XmlPullParser xmlPullParser, String str, long j6) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j6 : com.google.android.exoplayer2.util.s0.A0(attributeValue);
    }

    protected static d F(XmlPullParser xmlPullParser, String str) {
        String h02 = h0(xmlPullParser, "schemeIdUri", HttpUrl.FRAGMENT_ENCODE_SET);
        String h03 = h0(xmlPullParser, "value", null);
        String h04 = h0(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!t0.d(xmlPullParser, str));
        return new d(h02, h03, h04);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected static int G(XmlPullParser xmlPullParser) {
        char c6;
        String S0 = com.google.android.exoplayer2.util.s0.S0(xmlPullParser.getAttributeValue(null, "value"));
        if (S0 == null) {
            return -1;
        }
        switch (S0.hashCode()) {
            case 1596796:
                if (S0.equals("4000")) {
                    c6 = 0;
                    break;
                }
                c6 = 65535;
                break;
            case 2937391:
                if (S0.equals("a000")) {
                    c6 = 1;
                    break;
                }
                c6 = 65535;
                break;
            case 3094035:
                if (S0.equals("f801")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            case 3133436:
                if (S0.equals("fa01")) {
                    c6 = 3;
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
                return 1;
            case 1:
                return 2;
            case 2:
                return 6;
            case 3:
                return 8;
            default:
                return -1;
        }
    }

    protected static long H(XmlPullParser xmlPullParser, String str, long j6) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j6 : com.google.android.exoplayer2.util.s0.B0(attributeValue);
    }

    protected static String I(List list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            d dVar = (d) list.get(i6);
            String str = dVar.f75a;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(dVar.f76b)) {
                return "audio/eac3-joc";
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(dVar.f76b)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    protected static float M(XmlPullParser xmlPullParser, float f6) {
        String group;
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue != null) {
            Matcher matcher = f63b.matcher(attributeValue);
            if (matcher.matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                float f7 = parseInt;
                return !TextUtils.isEmpty(matcher.group(2)) ? f7 / Integer.parseInt(group) : f7;
            }
            return f6;
        }
        return f6;
    }

    protected static int O(XmlPullParser xmlPullParser, String str, int i6) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i6 : Integer.parseInt(attributeValue);
    }

    protected static long Q(List list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            d dVar = (d) list.get(i6);
            if ("http://dashif.org/guidelines/last-segment-number".equalsIgnoreCase(dVar.f75a)) {
                return Long.parseLong(dVar.f76b);
            }
        }
        return -1L;
    }

    protected static long R(XmlPullParser xmlPullParser, String str, long j6) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j6 : Long.parseLong(attributeValue);
    }

    protected static int T(XmlPullParser xmlPullParser) {
        int O = O(xmlPullParser, "value", -1);
        if (O >= 0) {
            int[] iArr = f66e;
            if (O < iArr.length) {
                return iArr[O];
            }
            return -1;
        }
        return -1;
    }

    private long b(List list, long j6, long j7, int i6, long j8) {
        int m5 = i6 >= 0 ? i6 + 1 : (int) com.google.android.exoplayer2.util.s0.m(j8 - j6, j7);
        for (int i7 = 0; i7 < m5; i7++) {
            list.add(m(j6, j7));
            j6 += j7;
        }
        return j6;
    }

    protected static String h0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    protected static String i0(XmlPullParser xmlPullParser, String str) {
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                t(xmlPullParser);
            }
        } while (!t0.d(xmlPullParser, str));
        return str2;
    }

    private static int p(int i6, int i7) {
        if (i6 == -1) {
            return i7;
        }
        if (i7 == -1) {
            return i6;
        }
        com.google.android.exoplayer2.util.a.g(i6 == i7);
        return i6;
    }

    private static String q(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        com.google.android.exoplayer2.util.a.g(str.equals(str2));
        return str;
    }

    private static void r(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            k.b bVar = (k.b) arrayList.get(size);
            if (!bVar.g()) {
                int i6 = 0;
                while (true) {
                    if (i6 >= arrayList.size()) {
                        break;
                    } else if (((k.b) arrayList.get(i6)).e(bVar)) {
                        arrayList.remove(size);
                        break;
                    } else {
                        i6++;
                    }
                }
            }
        }
    }

    private static String s(String str, String str2) {
        if (q.n(str)) {
            return q.b(str2);
        }
        if (q.q(str)) {
            return q.m(str2);
        }
        if (q.p(str)) {
            return "application/x-rawcc".equals(str) ? q.h(str2) : str;
        } else if ("application/mp4".equals(str)) {
            String e6 = q.e(str2);
            return "text/vtt".equals(e6) ? "application/x-mp4-vtt" : e6;
        } else {
            return null;
        }
    }

    public static void t(XmlPullParser xmlPullParser) {
        if (t0.e(xmlPullParser)) {
            int i6 = 1;
            while (i6 != 0) {
                xmlPullParser.next();
                if (t0.e(xmlPullParser)) {
                    i6++;
                } else if (t0.c(xmlPullParser)) {
                    i6--;
                }
            }
        }
    }

    protected static int z(List list) {
        String str;
        for (int i6 = 0; i6 < list.size(); i6++) {
            d dVar = (d) list.get(i6);
            if ("urn:scte:dash:cc:cea-608:2015".equals(dVar.f75a) && (str = dVar.f76b) != null) {
                Matcher matcher = f64c.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                String valueOf = String.valueOf(dVar.f76b);
                n.h("MpdParser", valueOf.length() != 0 ? "Unable to parse CEA-608 channel number from: ".concat(valueOf) : new String("Unable to parse CEA-608 channel number from: "));
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Pair B(XmlPullParser xmlPullParser) {
        String str;
        UUID uuid;
        UUID uuid2;
        byte[] bArr;
        byte[] bArr2;
        String attributeValue = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue != null) {
            String S0 = com.google.android.exoplayer2.util.s0.S0(attributeValue);
            S0.hashCode();
            char c6 = 65535;
            switch (S0.hashCode()) {
                case 489446379:
                    if (S0.equals("urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95")) {
                        c6 = 0;
                        break;
                    }
                    break;
                case 755418770:
                    if (S0.equals("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed")) {
                        c6 = 1;
                        break;
                    }
                    break;
                case 1812765994:
                    if (S0.equals("urn:mpeg:dash:mp4protection:2011")) {
                        c6 = 2;
                        break;
                    }
                    break;
            }
            switch (c6) {
                case 0:
                    uuid = p.f3952e;
                    str = null;
                    uuid2 = null;
                    bArr = uuid2;
                    bArr2 = uuid2;
                    break;
                case 1:
                    uuid = p.f3951d;
                    str = null;
                    uuid2 = null;
                    bArr = uuid2;
                    bArr2 = uuid2;
                    break;
                case 2:
                    str = xmlPullParser.getAttributeValue(null, "value");
                    String b6 = t0.b(xmlPullParser, "default_KID");
                    if (!TextUtils.isEmpty(b6) && !"00000000-0000-0000-0000-000000000000".equals(b6)) {
                        String[] split = b6.split("\\s+");
                        UUID[] uuidArr = new UUID[split.length];
                        for (int i6 = 0; i6 < split.length; i6++) {
                            uuidArr[i6] = UUID.fromString(split[i6]);
                        }
                        uuid = p.f3949b;
                        bArr = null;
                        bArr2 = i1.m.b(uuid, uuidArr, null);
                        break;
                    } else {
                        uuid = null;
                        uuid2 = uuid;
                        bArr = uuid2;
                        bArr2 = uuid2;
                        break;
                    }
            }
            do {
                xmlPullParser.next();
                if (!t0.f(xmlPullParser, "ms:laurl")) {
                    bArr = xmlPullParser.getAttributeValue(null, "licenseUrl");
                    bArr2 = bArr2;
                } else if (bArr2 == null && t0.g(xmlPullParser, "pssh") && xmlPullParser.next() == 4) {
                    byte[] decode = Base64.decode(xmlPullParser.getText(), 0);
                    UUID f6 = i1.m.f(decode);
                    if (f6 == null) {
                        n.h("MpdParser", "Skipping malformed cenc:pssh data");
                        uuid = f6;
                        bArr2 = null;
                    } else {
                        bArr2 = decode;
                        uuid = f6;
                    }
                } else {
                    if (bArr2 == null) {
                        UUID uuid3 = p.f3952e;
                        if (uuid3.equals(uuid) && t0.f(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                            bArr2 = i1.m.a(uuid3, Base64.decode(xmlPullParser.getText(), 0));
                        }
                    }
                    t(xmlPullParser);
                    bArr2 = bArr2;
                }
            } while (!t0.d(xmlPullParser, "ContentProtection"));
            return Pair.create(str, uuid != null ? new k.b(uuid, bArr, "video/mp4", bArr2) : null);
        }
        str = null;
        uuid = null;
        uuid2 = uuid;
        bArr = uuid2;
        bArr2 = uuid2;
        do {
            xmlPullParser.next();
            if (!t0.f(xmlPullParser, "ms:laurl")) {
            }
        } while (!t0.d(xmlPullParser, "ContentProtection"));
        return Pair.create(str, uuid != null ? new k.b(uuid, bArr, "video/mp4", bArr2) : null);
    }

    protected int C(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    protected int D(String str) {
        if (str == null) {
            return 0;
        }
        char c6 = 65535;
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals("subtitle")) {
                    c6 = 0;
                    break;
                }
                break;
            case -1724546052:
                if (str.equals("description")) {
                    c6 = 1;
                    break;
                }
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    c6 = 2;
                    break;
                }
                break;
            case -1408024454:
                if (str.equals("alternate")) {
                    c6 = 3;
                    break;
                }
                break;
            case 99825:
                if (str.equals("dub")) {
                    c6 = 4;
                    break;
                }
                break;
            case 3343801:
                if (str.equals("main")) {
                    c6 = 5;
                    break;
                }
                break;
            case 3530173:
                if (str.equals("sign")) {
                    c6 = 6;
                    break;
                }
                break;
            case 552573414:
                if (str.equals("caption")) {
                    c6 = 7;
                    break;
                }
                break;
            case 899152809:
                if (str.equals("commentary")) {
                    c6 = '\b';
                    break;
                }
                break;
            case 1629013393:
                if (str.equals("emergency")) {
                    c6 = '\t';
                    break;
                }
                break;
            case 1855372047:
                if (str.equals("supplementary")) {
                    c6 = '\n';
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                return 128;
            case 1:
                return 512;
            case 2:
                return 2048;
            case 3:
                return 2;
            case 4:
                return 16;
            case 5:
                return 1;
            case 6:
                return 256;
            case 7:
                return 64;
            case '\b':
                return 8;
            case '\t':
                return 32;
            case '\n':
                return 4;
            default:
                return 0;
        }
    }

    protected Pair J(XmlPullParser xmlPullParser, String str, String str2, long j6, ByteArrayOutputStream byteArrayOutputStream) {
        long R = R(xmlPullParser, "id", 0L);
        long R2 = R(xmlPullParser, "duration", -9223372036854775807L);
        long R3 = R(xmlPullParser, "presentationTime", 0L);
        long F0 = com.google.android.exoplayer2.util.s0.F0(R2, 1000L, j6);
        long F02 = com.google.android.exoplayer2.util.s0.F0(R3, 1000000L, j6);
        String h02 = h0(xmlPullParser, "messageData", null);
        byte[] K = K(xmlPullParser, byteArrayOutputStream);
        Long valueOf = Long.valueOf(F02);
        if (h02 != null) {
            K = com.google.android.exoplayer2.util.s0.h0(h02);
        }
        return Pair.create(valueOf, d(str, str2, R, F0, K));
    }

    protected byte[] K(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, com.google.common.base.b.f5585c.name());
        while (true) {
            xmlPullParser.nextToken();
            if (t0.d(xmlPullParser, "Event")) {
                newSerializer.flush();
                return byteArrayOutputStream.toByteArray();
            }
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i6 = 0; i6 < xmlPullParser.getAttributeCount(); i6++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i6), xmlPullParser.getAttributeName(i6), xmlPullParser.getAttributeValue(i6));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
        }
    }

    protected e L(XmlPullParser xmlPullParser) {
        String h02 = h0(xmlPullParser, "schemeIdUri", HttpUrl.FRAGMENT_ENCODE_SET);
        String h03 = h0(xmlPullParser, "value", HttpUrl.FRAGMENT_ENCODE_SET);
        long R = R(xmlPullParser, "timescale", 1L);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (t0.f(xmlPullParser, "Event")) {
                arrayList.add(J(xmlPullParser, h02, h03, R, byteArrayOutputStream));
            } else {
                t(xmlPullParser);
            }
        } while (!t0.d(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        p1.a[] aVarArr = new p1.a[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            Pair pair = (Pair) arrayList.get(i6);
            jArr[i6] = ((Long) pair.first).longValue();
            aVarArr[i6] = (p1.a) pair.second;
        }
        return e(h02, h03, R, jArr, aVarArr);
    }

    protected h N(XmlPullParser xmlPullParser) {
        return W(xmlPullParser, "sourceURL", "range");
    }

    protected String P(XmlPullParser xmlPullParser) {
        return i0(xmlPullParser, "Label");
    }

    protected b S(XmlPullParser xmlPullParser, String str) {
        long j6;
        long j7;
        c cVar = this;
        long E = E(xmlPullParser, "availabilityStartTime", -9223372036854775807L);
        long H = H(xmlPullParser, "mediaPresentationDuration", -9223372036854775807L);
        long H2 = H(xmlPullParser, "minBufferTime", -9223372036854775807L);
        boolean equals = "dynamic".equals(xmlPullParser.getAttributeValue(null, "type"));
        long H3 = equals ? H(xmlPullParser, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long H4 = equals ? H(xmlPullParser, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long H5 = equals ? H(xmlPullParser, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        long E2 = E(xmlPullParser, "publishTime", -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        Uri uri = null;
        long j8 = equals ? -9223372036854775807L : 0L;
        boolean z5 = false;
        boolean z6 = false;
        String str2 = str;
        g gVar = null;
        m mVar = null;
        while (true) {
            xmlPullParser.next();
            long j9 = H4;
            if (t0.f(xmlPullParser, "BaseURL")) {
                if (z5) {
                    j6 = j8;
                    j7 = H3;
                    j8 = j6;
                } else {
                    str2 = cVar.y(xmlPullParser, str2);
                    j7 = H3;
                    z5 = true;
                }
            } else if (t0.f(xmlPullParser, "ProgramInformation")) {
                j7 = H3;
                gVar = V(xmlPullParser);
            } else if (t0.f(xmlPullParser, "UTCTiming")) {
                j7 = H3;
                mVar = l0(xmlPullParser);
            } else if (t0.f(xmlPullParser, "Location")) {
                j7 = H3;
                uri = Uri.parse(xmlPullParser.nextText());
            } else if (!t0.f(xmlPullParser, "Period") || z6) {
                j6 = j8;
                j7 = H3;
                t(xmlPullParser);
                j8 = j6;
            } else {
                Pair U = cVar.U(xmlPullParser, str2, j8);
                long j10 = j8;
                f fVar = (f) U.first;
                j7 = H3;
                if (fVar.f84b != -9223372036854775807L) {
                    long longValue = ((Long) U.second).longValue();
                    long j11 = longValue == -9223372036854775807L ? -9223372036854775807L : fVar.f84b + longValue;
                    arrayList.add(fVar);
                    j8 = j11;
                } else if (!equals) {
                    int size = arrayList.size();
                    StringBuilder sb = new StringBuilder(47);
                    sb.append("Unable to determine start of period ");
                    sb.append(size);
                    throw new f1(sb.toString());
                } else {
                    j8 = j10;
                    z6 = true;
                }
            }
            if (t0.d(xmlPullParser, "MPD")) {
                if (H == -9223372036854775807L) {
                    if (j8 != -9223372036854775807L) {
                        H = j8;
                    } else if (!equals) {
                        throw new f1("Unable to determine duration of static manifest.");
                    }
                }
                if (arrayList.isEmpty()) {
                    throw new f1("No periods found.");
                }
                return g(E, H, H2, equals, j7, j9, H5, E2, gVar, mVar, uri, arrayList);
            }
            cVar = this;
            H4 = j9;
            H3 = j7;
        }
    }

    protected Pair U(XmlPullParser xmlPullParser, String str, long j6) {
        String str2;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        long H = H(xmlPullParser, "start", j6);
        long H2 = H(xmlPullParser, "duration", -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String str3 = str;
        j jVar = null;
        d dVar = null;
        boolean z5 = false;
        do {
            xmlPullParser.next();
            if (t0.f(xmlPullParser, "BaseURL")) {
                if (z5) {
                    str2 = str3;
                } else {
                    str3 = y(xmlPullParser, str3);
                    z5 = true;
                }
            } else if (t0.f(xmlPullParser, "AdaptationSet")) {
                str2 = str3;
                arrayList.add(v(xmlPullParser, str3, jVar, H2));
            } else {
                str2 = str3;
                if (t0.f(xmlPullParser, "EventStream")) {
                    arrayList2.add(L(xmlPullParser));
                } else if (t0.f(xmlPullParser, "SegmentBase")) {
                    jVar = b0(xmlPullParser, null);
                } else if (t0.f(xmlPullParser, "SegmentList")) {
                    jVar = c0(xmlPullParser, null, H2);
                } else if (t0.f(xmlPullParser, "SegmentTemplate")) {
                    jVar = d0(xmlPullParser, null, Collections.emptyList(), H2);
                } else if (t0.f(xmlPullParser, "AssetIdentifier")) {
                    dVar = F(xmlPullParser, "AssetIdentifier");
                } else {
                    t(xmlPullParser);
                }
            }
            str3 = str2;
        } while (!t0.d(xmlPullParser, "Period"));
        return Pair.create(h(attributeValue, H, arrayList, arrayList2, dVar), Long.valueOf(H2));
    }

    protected g V(XmlPullParser xmlPullParser) {
        String str = null;
        String h02 = h0(xmlPullParser, "moreInformationURL", null);
        String h03 = h0(xmlPullParser, "lang", null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (t0.f(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (t0.f(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (t0.f(xmlPullParser, "Copyright")) {
                str3 = xmlPullParser.nextText();
            } else {
                t(xmlPullParser);
            }
            String str4 = str3;
            if (t0.d(xmlPullParser, "ProgramInformation")) {
                return new g(str, str2, str4, h02, h03);
            }
            str3 = str4;
        }
    }

    protected h W(XmlPullParser xmlPullParser, String str, String str2) {
        long j6;
        long j7;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j6 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j7 = (Long.parseLong(split[1]) - j6) + 1;
                return i(attributeValue, j6, j7);
            }
        } else {
            j6 = 0;
        }
        j7 = -1;
        return i(attributeValue, j6, j7);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x019d A[LOOP:0: B:3:0x0064->B:50:0x019d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015a A[EDGE_INSN: B:51:0x015a->B:44:0x015a ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected a X(XmlPullParser xmlPullParser, String str, String str2, String str3, int i6, int i7, float f6, int i8, int i9, String str4, List list, List list2, List list3, List list4, j jVar, long j6) {
        int i10;
        int i11;
        String str5;
        j d02;
        int i12;
        String str6;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        int O = O(xmlPullParser, "bandwidth", -1);
        String h02 = h0(xmlPullParser, "mimeType", str2);
        String h03 = h0(xmlPullParser, "codecs", str3);
        int O2 = O(xmlPullParser, "width", i6);
        int O3 = O(xmlPullParser, "height", i7);
        float M = M(xmlPullParser, f6);
        int O4 = O(xmlPullParser, "audioSamplingRate", i9);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list3);
        ArrayList arrayList4 = new ArrayList(list4);
        int i13 = i8;
        j.e eVar = jVar;
        String str7 = null;
        boolean z5 = false;
        String str8 = str;
        while (true) {
            xmlPullParser.next();
            if (t0.f(xmlPullParser, "BaseURL")) {
                if (z5) {
                    str5 = str8;
                    i10 = O4;
                    i11 = O;
                    i12 = i13;
                    str6 = str5;
                    if (!t0.d(xmlPullParser, "Representation")) {
                    }
                } else {
                    str8 = y(xmlPullParser, str8);
                    i10 = O4;
                    i11 = O;
                    i12 = i13;
                    z5 = true;
                    eVar = eVar;
                    str6 = str8;
                    if (!t0.d(xmlPullParser, "Representation")) {
                        break;
                    }
                    O4 = i10;
                    str8 = str6;
                    O = i11;
                    i13 = i12;
                }
            } else if (t0.f(xmlPullParser, "AudioChannelConfiguration")) {
                i12 = x(xmlPullParser);
                str6 = str8;
                i10 = O4;
                i11 = O;
                if (!t0.d(xmlPullParser, "Representation")) {
                }
            } else if (t0.f(xmlPullParser, "SegmentBase")) {
                i10 = O4;
                i11 = O;
                eVar = b0(xmlPullParser, (j.e) eVar);
                i12 = i13;
                str6 = str8;
                if (!t0.d(xmlPullParser, "Representation")) {
                }
            } else {
                if (t0.f(xmlPullParser, "SegmentList")) {
                    i10 = O4;
                    i11 = O;
                    d02 = c0(xmlPullParser, (j.b) eVar, j6);
                } else {
                    i10 = O4;
                    i11 = O;
                    if (t0.f(xmlPullParser, "SegmentTemplate")) {
                        d02 = d0(xmlPullParser, (j.c) eVar, list4, j6);
                    } else {
                        if (t0.f(xmlPullParser, "ContentProtection")) {
                            Pair B = B(xmlPullParser);
                            str5 = str8;
                            Object obj = B.first;
                            if (obj != null) {
                                str7 = (String) obj;
                            }
                            Object obj2 = B.second;
                            if (obj2 != null) {
                                arrayList.add((k.b) obj2);
                            }
                        } else {
                            str5 = str8;
                            if (t0.f(xmlPullParser, "InbandEventStream")) {
                                arrayList2.add(F(xmlPullParser, "InbandEventStream"));
                            } else if (t0.f(xmlPullParser, "EssentialProperty")) {
                                arrayList3.add(F(xmlPullParser, "EssentialProperty"));
                            } else if (t0.f(xmlPullParser, "SupplementalProperty")) {
                                arrayList4.add(F(xmlPullParser, "SupplementalProperty"));
                            } else {
                                t(xmlPullParser);
                            }
                        }
                        i12 = i13;
                        str6 = str5;
                        if (!t0.d(xmlPullParser, "Representation")) {
                        }
                    }
                }
                eVar = d02;
                i12 = i13;
                str6 = str8;
                if (!t0.d(xmlPullParser, "Representation")) {
                }
            }
        }
        return new a(f(attributeValue, h02, O2, O3, M, i12, i10, i11, str4, list, list2, h03, arrayList3, arrayList4), str6, eVar != null ? eVar : new j.e(), str7, arrayList, arrayList2, -1L);
    }

    protected int Y(List list) {
        int j02;
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            d dVar = (d) list.get(i7);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(dVar.f75a)) {
                j02 = D(dVar.f76b);
            } else if ("urn:tva:metadata:cs:AudioPurposeCS:2007".equalsIgnoreCase(dVar.f75a)) {
                j02 = j0(dVar.f76b);
            }
            i6 |= j02;
        }
        return i6;
    }

    protected int Z(List list) {
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            if ("http://dashif.org/guidelines/trickmode".equalsIgnoreCase(((d) list.get(i7)).f75a)) {
                i6 |= Http2.INITIAL_MAX_FRAME_SIZE;
            }
        }
        return i6;
    }

    protected int a0(List list) {
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            d dVar = (d) list.get(i7);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(dVar.f75a)) {
                i6 |= D(dVar.f76b);
            }
        }
        return i6;
    }

    protected j.e b0(XmlPullParser xmlPullParser, j.e eVar) {
        long j6;
        long j7;
        long R = R(xmlPullParser, "timescale", eVar != null ? eVar.f110b : 1L);
        long R2 = R(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.f111c : 0L);
        long j8 = eVar != null ? eVar.f121d : 0L;
        long j9 = eVar != null ? eVar.f122e : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j7 = Long.parseLong(split[0]);
            j6 = (Long.parseLong(split[1]) - j7) + 1;
        } else {
            j6 = j9;
            j7 = j8;
        }
        h hVar = eVar != null ? eVar.f109a : null;
        do {
            xmlPullParser.next();
            if (t0.f(xmlPullParser, "Initialization")) {
                hVar = N(xmlPullParser);
            } else {
                t(xmlPullParser);
            }
        } while (!t0.d(xmlPullParser, "SegmentBase"));
        return n(hVar, R, R2, j7, j6);
    }

    protected a2.a c(int i6, int i7, List list, List list2, List list3, List list4) {
        return new a2.a(i6, i7, list, list2, list3, list4);
    }

    protected j.b c0(XmlPullParser xmlPullParser, j.b bVar, long j6) {
        long R = R(xmlPullParser, "timescale", bVar != null ? bVar.f110b : 1L);
        long R2 = R(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.f111c : 0L);
        long R3 = R(xmlPullParser, "duration", bVar != null ? bVar.f113e : -9223372036854775807L);
        long R4 = R(xmlPullParser, "startNumber", bVar != null ? bVar.f112d : 1L);
        List list = null;
        List list2 = null;
        h hVar = null;
        do {
            xmlPullParser.next();
            if (t0.f(xmlPullParser, "Initialization")) {
                hVar = N(xmlPullParser);
            } else if (t0.f(xmlPullParser, "SegmentTimeline")) {
                list = e0(xmlPullParser, R, j6);
            } else if (t0.f(xmlPullParser, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(f0(xmlPullParser));
            } else {
                t(xmlPullParser);
            }
        } while (!t0.d(xmlPullParser, "SegmentList"));
        if (bVar != null) {
            if (hVar == null) {
                hVar = bVar.f109a;
            }
            if (list == null) {
                list = bVar.f114f;
            }
            if (list2 == null) {
                list2 = bVar.f115g;
            }
        }
        return k(hVar, R, R2, R4, R3, list, list2);
    }

    protected p1.a d(String str, String str2, long j6, long j7, byte[] bArr) {
        return new p1.a(str, str2, j7, j6, bArr);
    }

    protected j.c d0(XmlPullParser xmlPullParser, j.c cVar, List list, long j6) {
        long R = R(xmlPullParser, "timescale", cVar != null ? cVar.f110b : 1L);
        long R2 = R(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.f111c : 0L);
        long R3 = R(xmlPullParser, "duration", cVar != null ? cVar.f113e : -9223372036854775807L);
        long R4 = R(xmlPullParser, "startNumber", cVar != null ? cVar.f112d : 1L);
        long Q = Q(list);
        List list2 = null;
        l k02 = k0(xmlPullParser, "media", cVar != null ? cVar.f117h : null);
        l k03 = k0(xmlPullParser, "initialization", cVar != null ? cVar.f116g : null);
        h hVar = null;
        do {
            xmlPullParser.next();
            if (t0.f(xmlPullParser, "Initialization")) {
                hVar = N(xmlPullParser);
            } else if (t0.f(xmlPullParser, "SegmentTimeline")) {
                list2 = e0(xmlPullParser, R, j6);
            } else {
                t(xmlPullParser);
            }
        } while (!t0.d(xmlPullParser, "SegmentTemplate"));
        if (cVar != null) {
            if (hVar == null) {
                hVar = cVar.f109a;
            }
            if (list2 == null) {
                list2 = cVar.f114f;
            }
        }
        return l(hVar, R, R2, R4, Q, R3, list2, k03, k02);
    }

    protected e e(String str, String str2, long j6, long[] jArr, p1.a[] aVarArr) {
        return new e(str, str2, j6, jArr, aVarArr);
    }

    protected List e0(XmlPullParser xmlPullParser, long j6, long j7) {
        ArrayList arrayList = new ArrayList();
        long j8 = 0;
        long j9 = -9223372036854775807L;
        boolean z5 = false;
        int i6 = 0;
        do {
            xmlPullParser.next();
            if (t0.f(xmlPullParser, "S")) {
                long R = R(xmlPullParser, "t", -9223372036854775807L);
                if (z5) {
                    j8 = b(arrayList, j8, j9, i6, R);
                }
                if (R == -9223372036854775807L) {
                    R = j8;
                }
                j9 = R(xmlPullParser, "d", -9223372036854775807L);
                i6 = O(xmlPullParser, "r", 0);
                j8 = R;
                z5 = true;
            } else {
                t(xmlPullParser);
            }
        } while (!t0.d(xmlPullParser, "SegmentTimeline"));
        if (z5) {
            b(arrayList, j8, j9, i6, com.google.android.exoplayer2.util.s0.F0(j7, j6, 1000L));
        }
        return arrayList;
    }

    protected s0 f(String str, String str2, int i6, int i7, float f6, int i8, int i9, int i10, String str3, List list, List list2, String str4, List list3, List list4) {
        String s5 = s(str2, str4);
        if ("audio/eac3".equals(s5)) {
            s5 = I(list4);
        }
        s0.b V = new s0.b().S(str).K(str2).e0(s5).I(str4).Z(i10).g0(g0(list)).c0(a0(list) | Y(list2) | Z(list3) | Z(list4)).V(str3);
        if (q.q(s5)) {
            V.j0(i6).Q(i7).P(f6);
        } else if (q.n(s5)) {
            V.H(i8).f0(i9);
        } else if (q.p(s5)) {
            V.F("application/cea-608".equals(s5) ? z(list2) : "application/cea-708".equals(s5) ? A(list2) : -1);
        }
        return V.E();
    }

    protected h f0(XmlPullParser xmlPullParser) {
        return W(xmlPullParser, "media", "mediaRange");
    }

    protected b g(long j6, long j7, long j8, boolean z5, long j9, long j10, long j11, long j12, g gVar, m mVar, Uri uri, List list) {
        return new b(j6, j7, j8, z5, j9, j10, j11, j12, gVar, mVar, uri, list);
    }

    protected int g0(List list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            d dVar = (d) list.get(i6);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(dVar.f75a) && "main".equals(dVar.f76b)) {
                return 1;
            }
        }
        return 0;
    }

    protected f h(String str, long j6, List list, List list2, d dVar) {
        return new f(str, j6, list, list2, dVar);
    }

    protected h i(String str, long j6, long j7) {
        return new h(str, j6, j7);
    }

    protected i j(a aVar, String str, String str2, ArrayList arrayList, ArrayList arrayList2) {
        s0.b e6 = aVar.f68a.e();
        if (str != null) {
            e6.U(str);
        }
        String str3 = aVar.f71d;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList arrayList3 = aVar.f72e;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            r(arrayList3);
            e6.L(new com.google.android.exoplayer2.drm.k(str2, arrayList3));
        }
        ArrayList arrayList4 = aVar.f73f;
        arrayList4.addAll(arrayList2);
        return i.l(aVar.f74g, e6.E(), aVar.f69b, aVar.f70c, arrayList4);
    }

    protected int j0(String str) {
        if (str == null) {
            return 0;
        }
        char c6 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c6 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c6 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c6 = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c6 = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c6 = 4;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                return 512;
            case 1:
                return 2048;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    protected j.b k(h hVar, long j6, long j7, long j8, long j9, List list, List list2) {
        return new j.b(hVar, j6, j7, j8, j9, list, list2);
    }

    protected l k0(XmlPullParser xmlPullParser, String str, l lVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? l.b(attributeValue) : lVar;
    }

    protected j.c l(h hVar, long j6, long j7, long j8, long j9, long j10, List list, l lVar, l lVar2) {
        return new j.c(hVar, j6, j7, j8, j9, j10, list, lVar, lVar2);
    }

    protected m l0(XmlPullParser xmlPullParser) {
        return o(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    protected j.d m(long j6, long j7) {
        return new j.d(j6, j7);
    }

    protected j.e n(h hVar, long j6, long j7, long j8, long j9) {
        return new j.e(hVar, j6, j7, j8, j9);
    }

    protected m o(String str, String str2) {
        return new m(str, str2);
    }

    @Override // q2.f0.a
    /* renamed from: u */
    public b a(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.f67a.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return S(newPullParser, uri.toString());
            }
            throw new f1("inputStream does not contain a valid media presentation description");
        } catch (XmlPullParserException e6) {
            throw new f1(e6);
        }
    }

    protected a2.a v(XmlPullParser xmlPullParser, String str, j jVar, long j6) {
        String str2;
        String str3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        String str4;
        String str5;
        int i6;
        ArrayList arrayList7;
        XmlPullParser xmlPullParser2;
        c cVar;
        ArrayList arrayList8;
        j d02;
        c cVar2 = this;
        XmlPullParser xmlPullParser3 = xmlPullParser;
        int O = O(xmlPullParser3, "id", -1);
        int C = C(xmlPullParser);
        String str6 = null;
        String attributeValue = xmlPullParser3.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser3.getAttributeValue(null, "codecs");
        int O2 = O(xmlPullParser3, "width", -1);
        int O3 = O(xmlPullParser3, "height", -1);
        float M = M(xmlPullParser3, -1.0f);
        int O4 = O(xmlPullParser3, "audioSamplingRate", -1);
        String str7 = "lang";
        String attributeValue3 = xmlPullParser3.getAttributeValue(null, "lang");
        String attributeValue4 = xmlPullParser3.getAttributeValue(null, "label");
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        String str8 = str;
        j jVar2 = jVar;
        String str9 = attributeValue4;
        String str10 = null;
        int i7 = -1;
        boolean z5 = false;
        int i8 = C;
        while (true) {
            xmlPullParser.next();
            if (t0.f(xmlPullParser3, "BaseURL")) {
                if (!z5) {
                    z5 = true;
                    str8 = cVar2.y(xmlPullParser3, str8);
                    arrayList = arrayList14;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList12;
                    arrayList4 = arrayList11;
                    arrayList6 = arrayList9;
                    str4 = str7;
                    str5 = str6;
                    xmlPullParser2 = xmlPullParser3;
                    cVar = cVar2;
                    i6 = i8;
                    arrayList7 = arrayList15;
                    arrayList8 = arrayList10;
                }
                str2 = attributeValue3;
                str3 = str8;
                arrayList = arrayList14;
                arrayList2 = arrayList13;
                arrayList3 = arrayList12;
                arrayList4 = arrayList11;
                arrayList6 = arrayList9;
                str4 = str7;
                str5 = str6;
                xmlPullParser2 = xmlPullParser3;
                cVar = cVar2;
                i6 = i8;
                arrayList7 = arrayList15;
                arrayList8 = arrayList10;
                attributeValue3 = str2;
                str8 = str3;
            } else {
                if (t0.f(xmlPullParser3, "ContentProtection")) {
                    Pair B = B(xmlPullParser);
                    Object obj = B.first;
                    if (obj != null) {
                        str10 = (String) obj;
                    }
                    Object obj2 = B.second;
                    if (obj2 != null) {
                        arrayList9.add((k.b) obj2);
                    }
                } else if (t0.f(xmlPullParser3, "ContentComponent")) {
                    attributeValue3 = q(attributeValue3, xmlPullParser3.getAttributeValue(str6, str7));
                    arrayList = arrayList14;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList12;
                    arrayList4 = arrayList11;
                    arrayList6 = arrayList9;
                    str4 = str7;
                    str5 = str6;
                    xmlPullParser2 = xmlPullParser3;
                    cVar = cVar2;
                    i6 = p(i8, C(xmlPullParser));
                    arrayList7 = arrayList15;
                    arrayList8 = arrayList10;
                } else {
                    if (t0.f(xmlPullParser3, "Role")) {
                        arrayList12.add(F(xmlPullParser3, "Role"));
                    } else if (t0.f(xmlPullParser3, "AudioChannelConfiguration")) {
                        i7 = x(xmlPullParser);
                    } else if (t0.f(xmlPullParser3, "Accessibility")) {
                        arrayList11.add(F(xmlPullParser3, "Accessibility"));
                    } else if (t0.f(xmlPullParser3, "EssentialProperty")) {
                        arrayList13.add(F(xmlPullParser3, "EssentialProperty"));
                    } else if (t0.f(xmlPullParser3, "SupplementalProperty")) {
                        arrayList14.add(F(xmlPullParser3, "SupplementalProperty"));
                    } else {
                        if (t0.f(xmlPullParser3, "Representation")) {
                            str2 = attributeValue3;
                            str3 = str8;
                            arrayList = arrayList14;
                            arrayList2 = arrayList13;
                            arrayList3 = arrayList12;
                            arrayList4 = arrayList11;
                            arrayList5 = arrayList10;
                            arrayList6 = arrayList9;
                            str4 = str7;
                            str5 = str6;
                            a X = X(xmlPullParser, str8, attributeValue, attributeValue2, O2, O3, M, i7, O4, str2, arrayList3, arrayList4, arrayList2, arrayList, jVar2, j6);
                            int p5 = p(i8, q.j(X.f68a.f4056n));
                            arrayList7 = arrayList15;
                            arrayList7.add(X);
                            cVar = this;
                            xmlPullParser2 = xmlPullParser;
                            i6 = p5;
                        } else {
                            str2 = attributeValue3;
                            str3 = str8;
                            arrayList = arrayList14;
                            arrayList2 = arrayList13;
                            arrayList3 = arrayList12;
                            arrayList4 = arrayList11;
                            arrayList5 = arrayList10;
                            arrayList6 = arrayList9;
                            str4 = str7;
                            str5 = str6;
                            i6 = i8;
                            arrayList7 = arrayList15;
                            xmlPullParser2 = xmlPullParser;
                            if (t0.f(xmlPullParser2, "SegmentBase")) {
                                cVar = this;
                                d02 = cVar.b0(xmlPullParser2, (j.e) jVar2);
                            } else {
                                cVar = this;
                                if (t0.f(xmlPullParser2, "SegmentList")) {
                                    d02 = cVar.c0(xmlPullParser2, (j.b) jVar2, j6);
                                } else if (t0.f(xmlPullParser2, "SegmentTemplate")) {
                                    d02 = d0(xmlPullParser, (j.c) jVar2, arrayList, j6);
                                } else {
                                    if (t0.f(xmlPullParser2, "InbandEventStream")) {
                                        arrayList8 = arrayList5;
                                        arrayList8.add(F(xmlPullParser2, "InbandEventStream"));
                                    } else {
                                        arrayList8 = arrayList5;
                                        if (t0.f(xmlPullParser2, "Label")) {
                                            str9 = P(xmlPullParser);
                                        } else if (t0.e(xmlPullParser)) {
                                            w(xmlPullParser);
                                        }
                                    }
                                    attributeValue3 = str2;
                                    str8 = str3;
                                }
                            }
                            jVar2 = d02;
                        }
                        attributeValue3 = str2;
                        str8 = str3;
                        arrayList8 = arrayList5;
                    }
                    str2 = attributeValue3;
                    str3 = str8;
                    arrayList = arrayList14;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList12;
                    arrayList4 = arrayList11;
                    arrayList6 = arrayList9;
                    str4 = str7;
                    str5 = str6;
                    xmlPullParser2 = xmlPullParser3;
                    cVar = cVar2;
                    i6 = i8;
                    arrayList7 = arrayList15;
                    arrayList8 = arrayList10;
                    attributeValue3 = str2;
                    str8 = str3;
                }
                arrayList = arrayList14;
                arrayList2 = arrayList13;
                arrayList3 = arrayList12;
                arrayList4 = arrayList11;
                arrayList6 = arrayList9;
                str4 = str7;
                str5 = str6;
                xmlPullParser2 = xmlPullParser3;
                cVar = cVar2;
                i6 = i8;
                arrayList7 = arrayList15;
                arrayList8 = arrayList10;
            }
            if (t0.d(xmlPullParser2, "AdaptationSet")) {
                break;
            }
            i8 = i6;
            arrayList15 = arrayList7;
            xmlPullParser3 = xmlPullParser2;
            cVar2 = cVar;
            arrayList10 = arrayList8;
            arrayList14 = arrayList;
            arrayList13 = arrayList2;
            arrayList12 = arrayList3;
            arrayList11 = arrayList4;
            arrayList9 = arrayList6;
            str7 = str4;
            str6 = str5;
        }
        ArrayList arrayList16 = new ArrayList(arrayList7.size());
        for (int i9 = 0; i9 < arrayList7.size(); i9++) {
            arrayList16.add(j((a) arrayList7.get(i9), str9, str10, arrayList6, arrayList8));
        }
        return c(O, i6, arrayList16, arrayList4, arrayList2, arrayList);
    }

    protected void w(XmlPullParser xmlPullParser) {
        t(xmlPullParser);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected int x(XmlPullParser xmlPullParser) {
        char c6;
        String h02 = h0(xmlPullParser, "schemeIdUri", null);
        h02.hashCode();
        int i6 = -1;
        switch (h02.hashCode()) {
            case -1352850286:
                if (h02.equals("urn:mpeg:dash:23003:3:audio_channel_configuration:2011")) {
                    c6 = 0;
                    break;
                }
                c6 = 65535;
                break;
            case -1138141449:
                if (h02.equals("tag:dolby.com,2014:dash:audio_channel_configuration:2011")) {
                    c6 = 1;
                    break;
                }
                c6 = 65535;
                break;
            case -986633423:
                if (h02.equals("urn:mpeg:mpegB:cicp:ChannelConfiguration")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            case 2036691300:
                if (h02.equals("urn:dolby:dash:audio_channel_configuration:2011")) {
                    c6 = 3;
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
                i6 = O(xmlPullParser, "value", -1);
                break;
            case 1:
            case 3:
                i6 = G(xmlPullParser);
                break;
            case 2:
                i6 = T(xmlPullParser);
                break;
        }
        do {
            xmlPullParser.next();
        } while (!t0.d(xmlPullParser, "AudioChannelConfiguration"));
        return i6;
    }

    protected String y(XmlPullParser xmlPullParser, String str) {
        return m0.c(str, i0(xmlPullParser, "BaseURL"));
    }
}
