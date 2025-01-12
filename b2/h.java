package b2;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import b2.e;
import b2.f;
import com.google.android.exoplayer2.drm.k;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.hls.r;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.util.s0;
import i1.m;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2;
import okio.Segment;
import okio.internal._BufferKt;
import q2.f0;
import w1.z0;
/* loaded from: classes.dex */
public final class h implements f0.a {

    /* renamed from: a  reason: collision with root package name */
    private final e f3013a;

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f2988b = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f2989c = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f2990d = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f2991e = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f2992f = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f2993g = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f2994h = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f2995i = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f2996j = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f2997k = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f2998l = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f2999m = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: n  reason: collision with root package name */
    private static final Pattern f3000n = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: o  reason: collision with root package name */
    private static final Pattern f3001o = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* renamed from: p  reason: collision with root package name */
    private static final Pattern f3002p = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");

    /* renamed from: q  reason: collision with root package name */
    private static final Pattern f3003q = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f3004r = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");

    /* renamed from: s  reason: collision with root package name */
    private static final Pattern f3005s = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");

    /* renamed from: t  reason: collision with root package name */
    private static final Pattern f3006t = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");

    /* renamed from: u  reason: collision with root package name */
    private static final Pattern f3007u = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");

    /* renamed from: v  reason: collision with root package name */
    private static final Pattern f3008v = Pattern.compile("KEYFORMAT=\"(.+?)\"");

    /* renamed from: w  reason: collision with root package name */
    private static final Pattern f3009w = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");

    /* renamed from: x  reason: collision with root package name */
    private static final Pattern f3010x = Pattern.compile("URI=\"(.+?)\"");

    /* renamed from: y  reason: collision with root package name */
    private static final Pattern f3011y = Pattern.compile("IV=([^,.*]+)");

    /* renamed from: z  reason: collision with root package name */
    private static final Pattern f3012z = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern A = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern B = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern C = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern D = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern E = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern F = c("AUTOSELECT");
    private static final Pattern G = c("DEFAULT");
    private static final Pattern H = c("FORCED");
    private static final Pattern I = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern J = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern K = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedReader f3014a;

        /* renamed from: b  reason: collision with root package name */
        private final Queue f3015b;

        /* renamed from: c  reason: collision with root package name */
        private String f3016c;

        public a(Queue queue, BufferedReader bufferedReader) {
            this.f3015b = queue;
            this.f3014a = bufferedReader;
        }

        public boolean a() {
            String trim;
            if (this.f3016c != null) {
                return true;
            }
            if (!this.f3015b.isEmpty()) {
                this.f3016c = (String) com.google.android.exoplayer2.util.a.e((String) this.f3015b.poll());
                return true;
            }
            do {
                String readLine = this.f3014a.readLine();
                this.f3016c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.f3016c = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String b() {
            if (a()) {
                String str = this.f3016c;
                this.f3016c = null;
                return str;
            }
            throw new NoSuchElementException();
        }
    }

    public h() {
        this(e.f2939n);
    }

    private static boolean b(BufferedReader bufferedReader) {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int w5 = w(bufferedReader, true, read);
        for (int i6 = 0; i6 < 7; i6++) {
            if (w5 != "#EXTM3U".charAt(i6)) {
                return false;
            }
            w5 = bufferedReader.read();
        }
        return s0.o0(w(bufferedReader, false, w5));
    }

    private static Pattern c(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 9);
        sb.append(str);
        sb.append("=(");
        sb.append("NO");
        sb.append("|");
        sb.append("YES");
        sb.append(")");
        return Pattern.compile(sb.toString());
    }

    private static e.b d(ArrayList arrayList, String str) {
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            e.b bVar = (e.b) arrayList.get(i6);
            if (str.equals(bVar.f2957d)) {
                return bVar;
            }
        }
        return null;
    }

    private static e.b e(ArrayList arrayList, String str) {
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            e.b bVar = (e.b) arrayList.get(i6);
            if (str.equals(bVar.f2958e)) {
                return bVar;
            }
        }
        return null;
    }

    private static e.b f(ArrayList arrayList, String str) {
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            e.b bVar = (e.b) arrayList.get(i6);
            if (str.equals(bVar.f2956c)) {
                return bVar;
            }
        }
        return null;
    }

    private static double h(String str, Pattern pattern) {
        return Double.parseDouble(u(str, pattern, Collections.emptyMap()));
    }

    private static k.b i(String str, String str2, Map map) {
        String q5 = q(str, f3009w, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String u5 = u(str, f3010x, map);
            return new k.b(p.f3951d, "video/mp4", Base64.decode(u5.substring(u5.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            return new k.b(p.f3951d, "hls", s0.h0(str));
        } else {
            if ("com.microsoft.playready".equals(str2) && "1".equals(q5)) {
                String u6 = u(str, f3010x, map);
                byte[] decode = Base64.decode(u6.substring(u6.indexOf(44)), 0);
                UUID uuid = p.f3952e;
                return new k.b(uuid, "video/mp4", m.a(uuid, decode));
            }
            return null;
        }
    }

    private static String j(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    private static int k(String str, Pattern pattern) {
        return Integer.parseInt(u(str, pattern, Collections.emptyMap()));
    }

    private static long l(String str, Pattern pattern) {
        return Long.parseLong(u(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    private static e m(a aVar, String str) {
        Uri uri;
        char c6;
        com.google.android.exoplayer2.s0 s0Var;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        ArrayList arrayList3;
        int parseInt;
        String str3;
        String str4;
        boolean z5;
        int i6;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        int i7;
        int i8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        String v5;
        HashMap hashMap;
        int i9;
        String str5 = str;
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            String str6 = "application/x-mpegURL";
            if (!aVar.a()) {
                HashMap hashMap4 = hashMap2;
                ArrayList arrayList19 = arrayList16;
                ArrayList arrayList20 = arrayList12;
                ArrayList arrayList21 = arrayList13;
                ArrayList arrayList22 = arrayList14;
                ArrayList arrayList23 = arrayList15;
                ArrayList arrayList24 = arrayList18;
                boolean z8 = z6;
                ArrayList arrayList25 = arrayList17;
                ArrayList arrayList26 = new ArrayList();
                HashSet hashSet = new HashSet();
                int i10 = 0;
                while (true) {
                    uri = null;
                    if (i10 >= arrayList11.size()) {
                        break;
                    }
                    e.b bVar = (e.b) arrayList11.get(i10);
                    if (hashSet.add(bVar.f2954a)) {
                        com.google.android.exoplayer2.util.a.g(bVar.f2955b.f4054l == null);
                        arrayList26.add(bVar.a(bVar.f2955b.e().X(new n1.a(new r(null, null, (List) com.google.android.exoplayer2.util.a.e((ArrayList) hashMap4.get(bVar.f2954a))))).E()));
                    }
                    i10++;
                }
                ArrayList arrayList27 = null;
                com.google.android.exoplayer2.s0 s0Var2 = null;
                int i11 = 0;
                while (i11 < arrayList19.size()) {
                    ArrayList arrayList28 = arrayList19;
                    String str7 = (String) arrayList28.get(i11);
                    String u5 = u(str7, C, hashMap3);
                    String u6 = u(str7, B, hashMap3);
                    s0.b bVar2 = new s0.b();
                    StringBuilder sb = new StringBuilder(String.valueOf(u5).length() + 1 + String.valueOf(u6).length());
                    sb.append(u5);
                    sb.append(":");
                    sb.append(u6);
                    s0.b V = bVar2.S(sb.toString()).U(u6).K(str6).g0(t(str7)).c0(s(str7, hashMap3)).V(r(str7, A, hashMap3));
                    String r5 = r(str7, f3010x, hashMap3);
                    Uri d6 = r5 == null ? uri : m0.d(str, r5);
                    arrayList19 = arrayList28;
                    String str8 = str6;
                    n1.a aVar2 = new n1.a(new r(u5, u6, Collections.emptyList()));
                    String u7 = u(str7, f3012z, hashMap3);
                    u7.hashCode();
                    switch (u7.hashCode()) {
                        case -959297733:
                            if (u7.equals("SUBTITLES")) {
                                c6 = 0;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case -333210994:
                            if (u7.equals("CLOSED-CAPTIONS")) {
                                c6 = 1;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 62628790:
                            if (u7.equals("AUDIO")) {
                                c6 = 2;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 81665115:
                            if (u7.equals("VIDEO")) {
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
                            s0Var = s0Var2;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            e.b e6 = e(arrayList11, u5);
                            if (e6 != null) {
                                String J2 = com.google.android.exoplayer2.util.s0.J(e6.f2955b.f4053k, 3);
                                V.I(J2);
                                str2 = q.e(J2);
                            } else {
                                str2 = null;
                            }
                            if (str2 == null) {
                                str2 = "text/vtt";
                            }
                            V.e0(str2).X(aVar2);
                            arrayList3 = arrayList22;
                            arrayList3.add(new e.a(d6, V.E(), u5, u6));
                            break;
                        case 1:
                            s0Var = s0Var2;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            String u8 = u(str7, E, hashMap3);
                            if (u8.startsWith("CC")) {
                                parseInt = Integer.parseInt(u8.substring(2));
                                str3 = "application/cea-608";
                            } else {
                                parseInt = Integer.parseInt(u8.substring(7));
                                str3 = "application/cea-708";
                            }
                            if (arrayList27 == null) {
                                arrayList27 = new ArrayList();
                            }
                            V.e0(str3).F(parseInt);
                            arrayList27.add(V.E());
                            arrayList3 = arrayList22;
                            break;
                        case 2:
                            arrayList2 = arrayList20;
                            e.b d7 = d(arrayList11, u5);
                            if (d7 != null) {
                                s0Var = s0Var2;
                                String J3 = com.google.android.exoplayer2.util.s0.J(d7.f2955b.f4053k, 1);
                                V.I(J3);
                                str4 = q.e(J3);
                            } else {
                                s0Var = s0Var2;
                                str4 = null;
                            }
                            String r6 = r(str7, f2994h, hashMap3);
                            if (r6 != null) {
                                V.H(Integer.parseInt(com.google.android.exoplayer2.util.s0.L0(r6, "/")[0]));
                                if ("audio/eac3".equals(str4) && r6.endsWith("/JOC")) {
                                    str4 = "audio/eac3-joc";
                                }
                            }
                            V.e0(str4);
                            if (d6 != null) {
                                V.X(aVar2);
                                arrayList = arrayList21;
                                arrayList.add(new e.a(d6, V.E(), u5, u6));
                            } else {
                                arrayList = arrayList21;
                                if (d7 != null) {
                                    s0Var = V.E();
                                }
                            }
                            arrayList3 = arrayList22;
                            break;
                        case 3:
                            e.b f6 = f(arrayList11, u5);
                            if (f6 != null) {
                                com.google.android.exoplayer2.s0 s0Var3 = f6.f2955b;
                                String J4 = com.google.android.exoplayer2.util.s0.J(s0Var3.f4053k, 2);
                                V.I(J4).e0(q.e(J4)).j0(s0Var3.f4061s).Q(s0Var3.f4062t).P(s0Var3.f4063u);
                            }
                            if (d6 != null) {
                                V.X(aVar2);
                                arrayList2 = arrayList20;
                                arrayList2.add(new e.a(d6, V.E(), u5, u6));
                                s0Var = s0Var2;
                                arrayList3 = arrayList22;
                                arrayList = arrayList21;
                                break;
                            }
                        default:
                            s0Var = s0Var2;
                            arrayList3 = arrayList22;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            break;
                    }
                    i11++;
                    arrayList22 = arrayList3;
                    arrayList21 = arrayList;
                    arrayList20 = arrayList2;
                    str6 = str8;
                    s0Var2 = s0Var;
                    uri = null;
                }
                return new e(str, arrayList24, arrayList26, arrayList20, arrayList21, arrayList22, arrayList23, s0Var2, z7 ? Collections.emptyList() : arrayList27, z8, hashMap3, arrayList25);
            }
            String b6 = aVar.b();
            if (b6.startsWith("#EXT")) {
                arrayList18.add(b6);
            }
            boolean startsWith = b6.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            boolean z9 = z6;
            if (b6.startsWith("#EXT-X-DEFINE")) {
                hashMap3.put(u(b6, B, hashMap3), u(b6, I, hashMap3));
            } else {
                if (b6.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    hashMap = hashMap2;
                    arrayList10 = arrayList16;
                    arrayList9 = arrayList12;
                    arrayList8 = arrayList13;
                    arrayList7 = arrayList14;
                    arrayList5 = arrayList15;
                    arrayList6 = arrayList18;
                    arrayList4 = arrayList17;
                    z6 = true;
                } else if (b6.startsWith("#EXT-X-MEDIA")) {
                    arrayList16.add(b6);
                } else if (b6.startsWith("#EXT-X-SESSION-KEY")) {
                    k.b i12 = i(b6, q(b6, f3008v, "identity", hashMap3), hashMap3);
                    if (i12 != null) {
                        arrayList17.add(new k(j(u(b6, f3007u, hashMap3)), i12));
                    }
                } else if (b6.startsWith("#EXT-X-STREAM-INF") || startsWith) {
                    boolean contains = z7 | b6.contains("CLOSED-CAPTIONS=NONE");
                    if (startsWith) {
                        i6 = Http2.INITIAL_MAX_FRAME_SIZE;
                        z5 = contains;
                    } else {
                        z5 = contains;
                        i6 = 0;
                    }
                    int k6 = k(b6, f2993g);
                    arrayList4 = arrayList17;
                    arrayList5 = arrayList15;
                    int p5 = p(b6, f2988b, -1);
                    String r7 = r(b6, f2995i, hashMap3);
                    arrayList6 = arrayList18;
                    String r8 = r(b6, f2996j, hashMap3);
                    arrayList7 = arrayList14;
                    if (r8 != null) {
                        String[] split = r8.split("x");
                        int parseInt2 = Integer.parseInt(split[0]);
                        int parseInt3 = Integer.parseInt(split[1]);
                        if (parseInt2 <= 0 || parseInt3 <= 0) {
                            parseInt3 = -1;
                            i9 = -1;
                        } else {
                            i9 = parseInt2;
                        }
                        arrayList8 = arrayList13;
                        i8 = parseInt3;
                        i7 = i9;
                    } else {
                        arrayList8 = arrayList13;
                        i7 = -1;
                        i8 = -1;
                    }
                    String r9 = r(b6, f2997k, hashMap3);
                    float parseFloat = r9 != null ? Float.parseFloat(r9) : -1.0f;
                    arrayList9 = arrayList12;
                    String r10 = r(b6, f2989c, hashMap3);
                    arrayList10 = arrayList16;
                    String r11 = r(b6, f2990d, hashMap3);
                    HashMap hashMap5 = hashMap2;
                    String r12 = r(b6, f2991e, hashMap3);
                    String r13 = r(b6, f2992f, hashMap3);
                    if (startsWith) {
                        v5 = u(b6, f3010x, hashMap3);
                    } else if (!aVar.a()) {
                        throw new f1("#EXT-X-STREAM-INF must be followed by another line");
                    } else {
                        v5 = v(aVar.b(), hashMap3);
                    }
                    Uri d8 = m0.d(str5, v5);
                    arrayList11.add(new e.b(d8, new s0.b().R(arrayList11.size()).K("application/x-mpegURL").I(r7).G(p5).Z(k6).j0(i7).Q(i8).P(parseFloat).c0(i6).E(), r10, r11, r12, r13));
                    hashMap = hashMap5;
                    ArrayList arrayList29 = (ArrayList) hashMap.get(d8);
                    if (arrayList29 == null) {
                        arrayList29 = new ArrayList();
                        hashMap.put(d8, arrayList29);
                    }
                    arrayList29.add(new r.b(p5, k6, r10, r11, r12, r13));
                    z6 = z9;
                    z7 = z5;
                }
                hashMap2 = hashMap;
                arrayList17 = arrayList4;
                arrayList15 = arrayList5;
                arrayList18 = arrayList6;
                arrayList14 = arrayList7;
                arrayList13 = arrayList8;
                arrayList12 = arrayList9;
                arrayList16 = arrayList10;
                str5 = str;
            }
            hashMap = hashMap2;
            arrayList10 = arrayList16;
            arrayList9 = arrayList12;
            arrayList8 = arrayList13;
            arrayList7 = arrayList14;
            arrayList5 = arrayList15;
            arrayList6 = arrayList18;
            arrayList4 = arrayList17;
            z6 = z9;
            hashMap2 = hashMap;
            arrayList17 = arrayList4;
            arrayList15 = arrayList5;
            arrayList18 = arrayList6;
            arrayList14 = arrayList7;
            arrayList13 = arrayList8;
            arrayList12 = arrayList9;
            arrayList16 = arrayList10;
            str5 = str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0154, code lost:
        if (r11 != null) goto L147;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static f n(e eVar, a aVar, String str) {
        long j6;
        long j7;
        String u5;
        long j8;
        HashMap hashMap;
        HashMap hashMap2;
        TreeMap treeMap;
        k kVar;
        e eVar2 = eVar;
        boolean z5 = eVar2.f2987c;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        TreeMap treeMap2 = new TreeMap();
        char c6 = 0;
        long j9 = -9223372036854775807L;
        int i6 = 1;
        boolean z6 = z5;
        long j10 = -9223372036854775807L;
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        int i7 = 0;
        String str3 = null;
        long j11 = 0;
        boolean z7 = false;
        int i8 = 0;
        long j12 = 0;
        int i9 = 1;
        boolean z8 = false;
        k kVar2 = null;
        long j13 = 0;
        long j14 = 0;
        k kVar3 = null;
        boolean z9 = false;
        String str4 = null;
        String str5 = null;
        long j15 = -1;
        int i10 = 0;
        long j16 = 0;
        boolean z10 = false;
        f.a aVar2 = null;
        while (true) {
            long j17 = 0;
            while (aVar.a()) {
                String b6 = aVar.b();
                if (b6.startsWith("#EXT")) {
                    arrayList2.add(b6);
                }
                if (b6.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    String u6 = u(b6, f3000n, hashMap3);
                    if ("VOD".equals(u6)) {
                        i7 = 1;
                    } else if ("EVENT".equals(u6)) {
                        i7 = 2;
                    }
                } else if (b6.equals("#EXT-X-I-FRAMES-ONLY")) {
                    z10 = true;
                } else if (b6.startsWith("#EXT-X-START")) {
                    j9 = (long) (h(b6, f3004r) * 1000000.0d);
                } else if (b6.startsWith("#EXT-X-MAP")) {
                    String u7 = u(b6, f3010x, hashMap3);
                    String r5 = r(b6, f3006t, hashMap3);
                    if (r5 != null) {
                        String[] split = r5.split("@");
                        long parseLong = Long.parseLong(split[c6]);
                        if (split.length > i6) {
                            j6 = Long.parseLong(split[i6]);
                            j7 = parseLong;
                        } else {
                            j7 = parseLong;
                            j6 = j13;
                        }
                    } else {
                        j6 = j13;
                        j7 = j15;
                    }
                    if (str4 != null && str5 == null) {
                        throw new f1("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.");
                    }
                    aVar2 = new f.a(u7, j6, j7, str4, str5);
                    j13 = 0;
                    j15 = -1;
                } else if (b6.startsWith("#EXT-X-TARGETDURATION")) {
                    j10 = k(b6, f2998l) * 1000000;
                } else if (b6.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                    j14 = l(b6, f3001o);
                    j12 = j14;
                } else if (b6.startsWith("#EXT-X-VERSION")) {
                    i9 = k(b6, f2999m);
                } else {
                    if (b6.startsWith("#EXT-X-DEFINE")) {
                        String r6 = r(b6, J, hashMap3);
                        if (r6 != null) {
                            u5 = (String) eVar2.f2948l.get(r6);
                        } else {
                            r6 = u(b6, B, hashMap3);
                            u5 = u(b6, I, hashMap3);
                        }
                        hashMap3.put(r6, u5);
                    } else if (b6.startsWith("#EXTINF")) {
                        str2 = q(b6, f3003q, HttpUrl.FRAGMENT_ENCODE_SET, hashMap3);
                        j17 = (long) (h(b6, f3002p) * 1000000.0d);
                        i6 = 1;
                    } else {
                        if (b6.startsWith("#EXT-X-KEY")) {
                            String u8 = u(b6, f3007u, hashMap3);
                            String q5 = q(b6, f3008v, "identity", hashMap3);
                            if ("NONE".equals(u8)) {
                                treeMap2.clear();
                                kVar3 = null;
                                str4 = null;
                                str5 = null;
                            } else {
                                String r7 = r(b6, f3011y, hashMap3);
                                if (!"identity".equals(q5)) {
                                    if (str3 == null) {
                                        str3 = j(u8);
                                    }
                                    k.b i11 = i(b6, q5, hashMap3);
                                    if (i11 != null) {
                                        treeMap2.put(q5, i11);
                                        str5 = r7;
                                        kVar3 = null;
                                        str4 = null;
                                    }
                                } else if ("AES-128".equals(u8)) {
                                    str5 = r7;
                                    str4 = u(b6, f3010x, hashMap3);
                                }
                                str5 = r7;
                                str4 = null;
                            }
                        } else if (b6.startsWith("#EXT-X-BYTERANGE")) {
                            String[] split2 = u(b6, f3005s, hashMap3).split("@");
                            j15 = Long.parseLong(split2[0]);
                            if (split2.length > 1) {
                                j13 = Long.parseLong(split2[1]);
                            }
                        } else if (b6.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                            i8 = Integer.parseInt(b6.substring(b6.indexOf(58) + 1));
                            c6 = 0;
                            i6 = 1;
                            z7 = true;
                        } else if (b6.equals("#EXT-X-DISCONTINUITY")) {
                            i10++;
                        } else if (!b6.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                            i6 = 1;
                            if (b6.equals("#EXT-X-GAP")) {
                                c6 = 0;
                                z9 = true;
                            } else if (b6.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                c6 = 0;
                                z6 = true;
                            } else if (b6.equals("#EXT-X-ENDLIST")) {
                                c6 = 0;
                                z8 = true;
                            } else if (!b6.startsWith("#")) {
                                String hexString = str4 == null ? null : str5 != null ? str5 : Long.toHexString(j14);
                                long j18 = j14 + 1;
                                String v5 = v(b6, hashMap3);
                                f.a aVar3 = (f.a) hashMap4.get(v5);
                                int i12 = (j15 > (-1L) ? 1 : (j15 == (-1L) ? 0 : -1));
                                if (i12 == 0) {
                                    j8 = 0;
                                } else {
                                    if (z10 && aVar2 == null && aVar3 == null) {
                                        f.a aVar4 = new f.a(v5, 0L, j13, null, null);
                                        hashMap4.put(v5, aVar4);
                                        aVar3 = aVar4;
                                    }
                                    j8 = j13;
                                }
                                if (kVar3 != null || treeMap2.isEmpty()) {
                                    hashMap = hashMap3;
                                    hashMap2 = hashMap4;
                                    treeMap = treeMap2;
                                    kVar = kVar3;
                                } else {
                                    hashMap = hashMap3;
                                    k.b[] bVarArr = (k.b[]) treeMap2.values().toArray(new k.b[0]);
                                    kVar = new k(str3, bVarArr);
                                    if (kVar2 == null) {
                                        k.b[] bVarArr2 = new k.b[bVarArr.length];
                                        hashMap2 = hashMap4;
                                        treeMap = treeMap2;
                                        int i13 = 0;
                                        while (i13 < bVarArr.length) {
                                            bVarArr2[i13] = bVarArr[i13].f(null);
                                            i13++;
                                            bVarArr = bVarArr;
                                        }
                                        kVar2 = new k(str3, bVarArr2);
                                    } else {
                                        hashMap2 = hashMap4;
                                        treeMap = treeMap2;
                                    }
                                }
                                arrayList.add(new f.a(v5, aVar2 != null ? aVar2 : aVar3, str2, j17, i10, j16, kVar, str4, hexString, j8, j15, z9));
                                j16 += j17;
                                if (i12 != 0) {
                                    j8 += j15;
                                }
                                j13 = j8;
                                eVar2 = eVar;
                                kVar3 = kVar;
                                j14 = j18;
                                str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                                j15 = -1;
                                hashMap3 = hashMap;
                                hashMap4 = hashMap2;
                                treeMap2 = treeMap;
                                c6 = 0;
                                i6 = 1;
                                z9 = false;
                            }
                        } else if (j11 == 0) {
                            i6 = 1;
                            j11 = p.a(com.google.android.exoplayer2.util.s0.A0(b6.substring(b6.indexOf(58) + 1))) - j16;
                            c6 = 0;
                        }
                        c6 = 0;
                        i6 = 1;
                    }
                    eVar2 = eVar;
                    hashMap3 = hashMap3;
                    hashMap4 = hashMap4;
                    treeMap2 = treeMap2;
                    c6 = 0;
                    i6 = 1;
                }
            }
            return new f(i7, str, arrayList2, j9, j11, z7, i8, j12, i9, j10, z6, z8, j11 != 0, kVar2, arrayList);
        }
    }

    private static boolean o(String str, Pattern pattern, boolean z5) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z5;
    }

    private static int p(String str, Pattern pattern, int i6) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) : i6;
    }

    private static String q(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : v(str2, map);
    }

    private static String r(String str, Pattern pattern, Map map) {
        return q(str, pattern, null, map);
    }

    private static int s(String str, Map map) {
        String r5 = r(str, D, map);
        if (TextUtils.isEmpty(r5)) {
            return 0;
        }
        String[] K0 = com.google.android.exoplayer2.util.s0.K0(r5, ",");
        int i6 = com.google.android.exoplayer2.util.s0.t(K0, "public.accessibility.describes-video") ? 512 : 0;
        if (com.google.android.exoplayer2.util.s0.t(K0, "public.accessibility.transcribes-spoken-dialog")) {
            i6 |= _BufferKt.SEGMENTING_THRESHOLD;
        }
        if (com.google.android.exoplayer2.util.s0.t(K0, "public.accessibility.describes-music-and-sound")) {
            i6 |= Segment.SHARE_MINIMUM;
        }
        return com.google.android.exoplayer2.util.s0.t(K0, "public.easy-to-read") ? i6 | Segment.SIZE : i6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static int t(String str) {
        boolean o5 = o(str, G, false);
        ?? r02 = o5;
        if (o(str, H, false)) {
            r02 = (o5 ? 1 : 0) | true;
        }
        return o(str, F, false) ? r02 | 4 : r02;
    }

    private static String u(String str, Pattern pattern, Map map) {
        String r5 = r(str, pattern, map);
        if (r5 != null) {
            return r5;
        }
        String pattern2 = pattern.pattern();
        StringBuilder sb = new StringBuilder(String.valueOf(pattern2).length() + 19 + String.valueOf(str).length());
        sb.append("Couldn't match ");
        sb.append(pattern2);
        sb.append(" in ");
        sb.append(str);
        throw new f1(sb.toString());
    }

    private static String v(String str, Map map) {
        Matcher matcher = K.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement((String) map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static int w(BufferedReader bufferedReader, boolean z5, int i6) {
        while (i6 != -1 && Character.isWhitespace(i6) && (z5 || !com.google.android.exoplayer2.util.s0.o0(i6))) {
            i6 = bufferedReader.read();
        }
        return i6;
    }

    @Override // q2.f0.a
    /* renamed from: g */
    public g a(Uri uri, InputStream inputStream) {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (b(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        com.google.android.exoplayer2.util.s0.n(bufferedReader);
                        throw new f1("Failed to parse the playlist, could not identify any tags.");
                    }
                    trim = readLine.trim();
                    if (!trim.isEmpty()) {
                        if (!trim.startsWith("#EXT-X-STREAM-INF")) {
                            if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                                break;
                            }
                            arrayDeque.add(trim);
                        } else {
                            arrayDeque.add(trim);
                            return m(new a(arrayDeque, bufferedReader), uri.toString());
                        }
                    }
                }
                arrayDeque.add(trim);
                return n(this.f3013a, new a(arrayDeque, bufferedReader), uri.toString());
            }
            throw new z0("Input does not start with the #EXTM3U header.", uri);
        } finally {
            com.google.android.exoplayer2.util.s0.n(bufferedReader);
        }
    }

    public h(e eVar) {
        this.f3013a = eVar;
    }
}
