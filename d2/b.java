package d2;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.drm.k;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.s0;
import d2.a;
import i1.m;
import i1.p;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import okio.Segment;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import q2.f0;
/* loaded from: classes.dex */
public class b implements f0.a {

    /* renamed from: a  reason: collision with root package name */
    private final XmlPullParserFactory f9164a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f9165a;

        /* renamed from: b  reason: collision with root package name */
        private final String f9166b;

        /* renamed from: c  reason: collision with root package name */
        private final a f9167c;

        /* renamed from: d  reason: collision with root package name */
        private final List f9168d = new LinkedList();

        public a(a aVar, String str, String str2) {
            this.f9167c = aVar;
            this.f9165a = str;
            this.f9166b = str2;
        }

        private a e(a aVar, String str, String str2) {
            if ("QualityLevel".equals(str)) {
                return new d(aVar, str2);
            }
            if ("Protection".equals(str)) {
                return new c(aVar, str2);
            }
            if ("StreamIndex".equals(str)) {
                return new f(aVar, str2);
            }
            return null;
        }

        protected void a(Object obj) {
        }

        protected abstract Object b();

        protected final Object c(String str) {
            for (int i6 = 0; i6 < this.f9168d.size(); i6++) {
                Pair pair = (Pair) this.f9168d.get(i6);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            a aVar = this.f9167c;
            if (aVar == null) {
                return null;
            }
            return aVar.c(str);
        }

        protected boolean d(String str) {
            return false;
        }

        public final Object f(XmlPullParser xmlPullParser) {
            boolean z5 = false;
            int i6 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f9166b.equals(name)) {
                        n(xmlPullParser);
                        z5 = true;
                    } else if (z5) {
                        if (i6 > 0) {
                            i6++;
                        } else if (d(name)) {
                            n(xmlPullParser);
                        } else {
                            a e6 = e(this, name, this.f9165a);
                            if (e6 == null) {
                                i6 = 1;
                            } else {
                                a(e6.f(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z5 && i6 == 0) {
                        o(xmlPullParser);
                    }
                } else if (!z5) {
                    continue;
                } else if (i6 > 0) {
                    i6--;
                } else {
                    String name2 = xmlPullParser.getName();
                    h(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        protected final boolean g(XmlPullParser xmlPullParser, String str, boolean z5) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z5;
        }

        protected void h(XmlPullParser xmlPullParser) {
        }

        protected final int i(XmlPullParser xmlPullParser, String str, int i6) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e6) {
                    throw new f1(e6);
                }
            }
            return i6;
        }

        protected final long j(XmlPullParser xmlPullParser, String str, long j6) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e6) {
                    throw new f1(e6);
                }
            }
            return j6;
        }

        protected final int k(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e6) {
                    throw new f1(e6);
                }
            }
            throw new C0155b(str);
        }

        protected final long l(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e6) {
                    throw new f1(e6);
                }
            }
            throw new C0155b(str);
        }

        protected final String m(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new C0155b(str);
        }

        protected abstract void n(XmlPullParser xmlPullParser);

        protected void o(XmlPullParser xmlPullParser) {
        }

        protected final void p(String str, Object obj) {
            this.f9168d.add(Pair.create(str, obj));
        }
    }

    /* renamed from: d2.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0155b extends f1 {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public C0155b(String str) {
            super(r3.length() != 0 ? "Missing required field: ".concat(r3) : new String("Missing required field: "));
            String valueOf = String.valueOf(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends a {

        /* renamed from: e  reason: collision with root package name */
        private boolean f9169e;

        /* renamed from: f  reason: collision with root package name */
        private UUID f9170f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f9171g;

        public c(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        private static p[] q(byte[] bArr) {
            return new p[]{new p(true, null, 8, r(bArr), 0, 0, null)};
        }

        private static byte[] r(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < bArr.length; i6 += 2) {
                sb.append((char) bArr[i6]);
            }
            String sb2 = sb.toString();
            byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
            t(decode, 0, 3);
            t(decode, 1, 2);
            t(decode, 4, 5);
            t(decode, 6, 7);
            return decode;
        }

        private static String s(String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }

        private static void t(byte[] bArr, int i6, int i7) {
            byte b6 = bArr[i6];
            bArr[i6] = bArr[i7];
            bArr[i7] = b6;
        }

        @Override // d2.b.a
        public Object b() {
            UUID uuid = this.f9170f;
            return new a.C0154a(uuid, m.a(uuid, this.f9171g), q(this.f9171g));
        }

        @Override // d2.b.a
        public boolean d(String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // d2.b.a
        public void h(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f9169e = false;
            }
        }

        @Override // d2.b.a
        public void n(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f9169e = true;
                this.f9170f = UUID.fromString(s(xmlPullParser.getAttributeValue(null, "SystemID")));
            }
        }

        @Override // d2.b.a
        public void o(XmlPullParser xmlPullParser) {
            if (this.f9169e) {
                this.f9171g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends a {

        /* renamed from: e  reason: collision with root package name */
        private s0 f9172e;

        public d(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        private static List q(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] I = com.google.android.exoplayer2.util.s0.I(str);
                byte[][] h6 = com.google.android.exoplayer2.util.d.h(I);
                if (h6 == null) {
                    arrayList.add(I);
                } else {
                    Collections.addAll(arrayList, h6);
                }
            }
            return arrayList;
        }

        private static String r(String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return "video/avc";
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return "audio/mp4a-latm";
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return "application/ttml+xml";
            }
            if (str.equalsIgnoreCase("ac-3") || str.equalsIgnoreCase("dac3")) {
                return "audio/ac3";
            }
            if (str.equalsIgnoreCase("ec-3") || str.equalsIgnoreCase("dec3")) {
                return "audio/eac3";
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return "audio/vnd.dts";
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (str.equalsIgnoreCase("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (str.equalsIgnoreCase("opus")) {
                return "audio/opus";
            }
            return null;
        }

        @Override // d2.b.a
        public Object b() {
            return this.f9172e;
        }

        @Override // d2.b.a
        public void n(XmlPullParser xmlPullParser) {
            int i6;
            s0.b bVar = new s0.b();
            String r5 = r(m(xmlPullParser, "FourCC"));
            int intValue = ((Integer) c("Type")).intValue();
            if (intValue == 2) {
                bVar.K("video/mp4").j0(k(xmlPullParser, "MaxWidth")).Q(k(xmlPullParser, "MaxHeight")).T(q(xmlPullParser.getAttributeValue(null, "CodecPrivateData")));
            } else if (intValue == 1) {
                if (r5 == null) {
                    r5 = "audio/mp4a-latm";
                }
                int k6 = k(xmlPullParser, "Channels");
                int k7 = k(xmlPullParser, "SamplingRate");
                List q5 = q(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                if (q5.isEmpty() && "audio/mp4a-latm".equals(r5)) {
                    q5 = Collections.singletonList(com.google.android.exoplayer2.audio.a.a(k7, k6));
                }
                bVar.K("audio/mp4").H(k6).f0(k7).T(q5);
            } else if (intValue == 3) {
                String str = (String) c("Subtype");
                if (str != null) {
                    if (str.equals("CAPT")) {
                        i6 = 64;
                    } else if (str.equals("DESC")) {
                        i6 = Segment.SHARE_MINIMUM;
                    }
                    bVar.K("application/mp4").c0(i6);
                }
                i6 = 0;
                bVar.K("application/mp4").c0(i6);
            } else {
                bVar.K("application/mp4");
            }
            this.f9172e = bVar.S(xmlPullParser.getAttributeValue(null, "Index")).U((String) c("Name")).e0(r5).G(k(xmlPullParser, "Bitrate")).V((String) c("Language")).E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends a {

        /* renamed from: e  reason: collision with root package name */
        private final List f9173e;

        /* renamed from: f  reason: collision with root package name */
        private int f9174f;

        /* renamed from: g  reason: collision with root package name */
        private int f9175g;

        /* renamed from: h  reason: collision with root package name */
        private long f9176h;

        /* renamed from: i  reason: collision with root package name */
        private long f9177i;

        /* renamed from: j  reason: collision with root package name */
        private long f9178j;

        /* renamed from: k  reason: collision with root package name */
        private int f9179k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f9180l;

        /* renamed from: m  reason: collision with root package name */
        private a.C0154a f9181m;

        public e(a aVar, String str) {
            super(aVar, str, "SmoothStreamingMedia");
            this.f9179k = -1;
            this.f9181m = null;
            this.f9173e = new LinkedList();
        }

        @Override // d2.b.a
        public void a(Object obj) {
            if (obj instanceof a.b) {
                this.f9173e.add((a.b) obj);
            } else if (obj instanceof a.C0154a) {
                com.google.android.exoplayer2.util.a.g(this.f9181m == null);
                this.f9181m = (a.C0154a) obj;
            }
        }

        @Override // d2.b.a
        public Object b() {
            int size = this.f9173e.size();
            a.b[] bVarArr = new a.b[size];
            this.f9173e.toArray(bVarArr);
            if (this.f9181m != null) {
                a.C0154a c0154a = this.f9181m;
                k kVar = new k(new k.b(c0154a.f9145a, "video/mp4", c0154a.f9146b));
                for (int i6 = 0; i6 < size; i6++) {
                    a.b bVar = bVarArr[i6];
                    int i7 = bVar.f9148a;
                    if (i7 == 2 || i7 == 1) {
                        s0[] s0VarArr = bVar.f9157j;
                        for (int i8 = 0; i8 < s0VarArr.length; i8++) {
                            s0VarArr[i8] = s0VarArr[i8].e().L(kVar).E();
                        }
                    }
                }
            }
            return new d2.a(this.f9174f, this.f9175g, this.f9176h, this.f9177i, this.f9178j, this.f9179k, this.f9180l, this.f9181m, bVarArr);
        }

        @Override // d2.b.a
        public void n(XmlPullParser xmlPullParser) {
            this.f9174f = k(xmlPullParser, "MajorVersion");
            this.f9175g = k(xmlPullParser, "MinorVersion");
            this.f9176h = j(xmlPullParser, "TimeScale", 10000000L);
            this.f9177i = l(xmlPullParser, "Duration");
            this.f9178j = j(xmlPullParser, "DVRWindowLength", 0L);
            this.f9179k = i(xmlPullParser, "LookaheadCount", -1);
            this.f9180l = g(xmlPullParser, "IsLive", false);
            p("TimeScale", Long.valueOf(this.f9176h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f extends a {

        /* renamed from: e  reason: collision with root package name */
        private final String f9182e;

        /* renamed from: f  reason: collision with root package name */
        private final List f9183f;

        /* renamed from: g  reason: collision with root package name */
        private int f9184g;

        /* renamed from: h  reason: collision with root package name */
        private String f9185h;

        /* renamed from: i  reason: collision with root package name */
        private long f9186i;

        /* renamed from: j  reason: collision with root package name */
        private String f9187j;

        /* renamed from: k  reason: collision with root package name */
        private String f9188k;

        /* renamed from: l  reason: collision with root package name */
        private int f9189l;

        /* renamed from: m  reason: collision with root package name */
        private int f9190m;

        /* renamed from: n  reason: collision with root package name */
        private int f9191n;

        /* renamed from: o  reason: collision with root package name */
        private int f9192o;

        /* renamed from: p  reason: collision with root package name */
        private String f9193p;

        /* renamed from: q  reason: collision with root package name */
        private ArrayList f9194q;

        /* renamed from: r  reason: collision with root package name */
        private long f9195r;

        public f(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.f9182e = str;
            this.f9183f = new LinkedList();
        }

        private void q(XmlPullParser xmlPullParser) {
            int s5 = s(xmlPullParser);
            this.f9184g = s5;
            p("Type", Integer.valueOf(s5));
            this.f9185h = this.f9184g == 3 ? m(xmlPullParser, "Subtype") : xmlPullParser.getAttributeValue(null, "Subtype");
            p("Subtype", this.f9185h);
            this.f9187j = xmlPullParser.getAttributeValue(null, "Name");
            this.f9188k = m(xmlPullParser, "Url");
            this.f9189l = i(xmlPullParser, "MaxWidth", -1);
            this.f9190m = i(xmlPullParser, "MaxHeight", -1);
            this.f9191n = i(xmlPullParser, "DisplayWidth", -1);
            this.f9192o = i(xmlPullParser, "DisplayHeight", -1);
            String attributeValue = xmlPullParser.getAttributeValue(null, "Language");
            this.f9193p = attributeValue;
            p("Language", attributeValue);
            long i6 = i(xmlPullParser, "TimeScale", -1);
            this.f9186i = i6;
            if (i6 == -1) {
                this.f9186i = ((Long) c("TimeScale")).longValue();
            }
            this.f9194q = new ArrayList();
        }

        private void r(XmlPullParser xmlPullParser) {
            int size = this.f9194q.size();
            long j6 = j(xmlPullParser, "t", -9223372036854775807L);
            int i6 = 1;
            if (j6 == -9223372036854775807L) {
                if (size == 0) {
                    j6 = 0;
                } else if (this.f9195r == -1) {
                    throw new f1("Unable to infer start time");
                } else {
                    j6 = ((Long) this.f9194q.get(size - 1)).longValue() + this.f9195r;
                }
            }
            this.f9194q.add(Long.valueOf(j6));
            this.f9195r = j(xmlPullParser, "d", -9223372036854775807L);
            long j7 = j(xmlPullParser, "r", 1L);
            if (j7 > 1 && this.f9195r == -9223372036854775807L) {
                throw new f1("Repeated chunk with unspecified duration");
            }
            while (true) {
                long j8 = i6;
                if (j8 >= j7) {
                    return;
                }
                this.f9194q.add(Long.valueOf((this.f9195r * j8) + j6));
                i6++;
            }
        }

        private int s(XmlPullParser xmlPullParser) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue != null) {
                if ("audio".equalsIgnoreCase(attributeValue)) {
                    return 1;
                }
                if ("video".equalsIgnoreCase(attributeValue)) {
                    return 2;
                }
                if ("text".equalsIgnoreCase(attributeValue)) {
                    return 3;
                }
                StringBuilder sb = new StringBuilder(attributeValue.length() + 19);
                sb.append("Invalid key value[");
                sb.append(attributeValue);
                sb.append("]");
                throw new f1(sb.toString());
            }
            throw new C0155b("Type");
        }

        @Override // d2.b.a
        public void a(Object obj) {
            if (obj instanceof s0) {
                this.f9183f.add((s0) obj);
            }
        }

        @Override // d2.b.a
        public Object b() {
            s0[] s0VarArr = new s0[this.f9183f.size()];
            this.f9183f.toArray(s0VarArr);
            return new a.b(this.f9182e, this.f9188k, this.f9184g, this.f9185h, this.f9186i, this.f9187j, this.f9189l, this.f9190m, this.f9191n, this.f9192o, this.f9193p, s0VarArr, this.f9194q, this.f9195r);
        }

        @Override // d2.b.a
        public boolean d(String str) {
            return "c".equals(str);
        }

        @Override // d2.b.a
        public void n(XmlPullParser xmlPullParser) {
            if ("c".equals(xmlPullParser.getName())) {
                r(xmlPullParser);
            } else {
                q(xmlPullParser);
            }
        }
    }

    public b() {
        try {
            this.f9164a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e6) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e6);
        }
    }

    @Override // q2.f0.a
    /* renamed from: b */
    public d2.a a(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.f9164a.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (d2.a) new e(null, uri.toString()).f(newPullParser);
        } catch (XmlPullParserException e6) {
            throw new f1(e6);
        }
    }
}
