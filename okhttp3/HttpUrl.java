package okhttp3;

import b.j;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k4.c;
import k5.d;
import kotlin.collections.i0;
import kotlin.collections.n;
import kotlin.collections.o;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.text.k;
import kotlin.text.w;
import kotlin.text.x;
import kotlin.text.z;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import r4.f;
/* loaded from: classes.dex */
public final class HttpUrl {
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;
    public static final Companion Companion = new Companion(null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* loaded from: classes.dex */
    public static final class Builder {
        public static final Companion Companion = new Companion(null);
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = HttpUrl.FRAGMENT_ENCODE_SET;
        private String encodedPassword = HttpUrl.FRAGMENT_ENCODE_SET;
        private int port = -1;

        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int parsePort(String str, int i6, int i7) {
                try {
                    int parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i6, i7, HttpUrl.FRAGMENT_ENCODE_SET, false, false, false, false, null, 248, null));
                    boolean z5 = false;
                    if (1 <= parseInt && parseInt < 65536) {
                        z5 = true;
                    }
                    if (z5) {
                        return parseInt;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int portColonOffset(String str, int i6, int i7) {
                while (i6 < i7) {
                    char charAt = str.charAt(i6);
                    if (charAt == '[') {
                        do {
                            i6++;
                            if (i6 < i7) {
                            }
                        } while (str.charAt(i6) != ']');
                    } else if (charAt == ':') {
                        return i6;
                    }
                    i6++;
                }
                return i7;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i6, int i7) {
                if (i7 - i6 < 2) {
                    return -1;
                }
                char charAt = str.charAt(i6);
                if ((l.e(charAt, 97) < 0 || l.e(charAt, j.L0) > 0) && (l.e(charAt, 65) < 0 || l.e(charAt, 90) > 0)) {
                    return -1;
                }
                int i8 = i6 + 1;
                while (i8 < i7) {
                    int i9 = i8 + 1;
                    char charAt2 = str.charAt(i8);
                    if (!(((((('a' <= charAt2 && charAt2 < '{') || ('A' <= charAt2 && charAt2 < '[')) || ('0' <= charAt2 && charAt2 < ':')) || charAt2 == '+') || charAt2 == '-') || charAt2 == '.')) {
                        if (charAt2 == ':') {
                            return i8;
                        }
                        return -1;
                    }
                    i8 = i9;
                }
                return -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int slashCount(String str, int i6, int i7) {
                int i8 = 0;
                while (i6 < i7) {
                    int i9 = i6 + 1;
                    char charAt = str.charAt(i6);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i8++;
                    i6 = i9;
                }
                return i8;
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add(HttpUrl.FRAGMENT_ENCODE_SET);
        }

        private final int effectivePort() {
            int i6 = this.port;
            if (i6 != -1) {
                return i6;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            l.b(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            boolean l6;
            if (l.a(str, ".")) {
                return true;
            }
            l6 = w.l(str, "%2e", true);
            return l6;
        }

        private final boolean isDotDot(String str) {
            boolean l6;
            boolean l7;
            boolean l8;
            if (l.a(str, "..")) {
                return true;
            }
            l6 = w.l(str, "%2e.", true);
            if (l6) {
                return true;
            }
            l7 = w.l(str, ".%2e", true);
            if (l7) {
                return true;
            }
            l8 = w.l(str, "%2e%2e", true);
            return l8;
        }

        private final void pop() {
            List<String> list = this.encodedPathSegments;
            if (!(list.remove(list.size() - 1).length() == 0) || !(!this.encodedPathSegments.isEmpty())) {
                this.encodedPathSegments.add(HttpUrl.FRAGMENT_ENCODE_SET);
                return;
            }
            List<String> list2 = this.encodedPathSegments;
            list2.set(list2.size() - 1, HttpUrl.FRAGMENT_ENCODE_SET);
        }

        private final void push(String str, int i6, int i7, boolean z5, boolean z6) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i6, i7, HttpUrl.PATH_SEGMENT_ENCODE_SET, z6, false, false, false, null, 240, null);
            if (isDot(canonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(canonicalize$okhttp$default)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, canonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(canonicalize$okhttp$default);
            }
            if (z5) {
                this.encodedPathSegments.add(HttpUrl.FRAGMENT_ENCODE_SET);
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            l.b(list);
            int size = list.size() - 2;
            int b6 = c.b(size, 0, -2);
            if (b6 > size) {
                return;
            }
            while (true) {
                int i6 = size - 2;
                List<String> list2 = this.encodedQueryNamesAndValues;
                l.b(list2);
                if (l.a(str, list2.get(size))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    l.b(list3);
                    list3.remove(size + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    l.b(list4);
                    list4.remove(size);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    l.b(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (size == b6) {
                    return;
                }
                size = i6;
            }
        }

        private final void resolvePath(String str, int i6, int i7) {
            if (i6 == i7) {
                return;
            }
            char charAt = str.charAt(i6);
            if (charAt == '/' || charAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add(HttpUrl.FRAGMENT_ENCODE_SET);
                i6++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, HttpUrl.FRAGMENT_ENCODE_SET);
            }
            while (true) {
                int i8 = i6;
                while (i8 < i7) {
                    i6 = Util.delimiterOffset(str, "/\\", i8, i7);
                    boolean z5 = i6 < i7;
                    push(str, i8, i6, z5, true);
                    if (z5) {
                        i8 = i6 + 1;
                    }
                }
                return;
            }
        }

        public final Builder addEncodedPathSegment(String str) {
            l.d(str, "encodedPathSegment");
            push(str, 0, str.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String str) {
            l.d(str, "encodedPathSegments");
            return addPathSegments(str, true);
        }

        public final Builder addEncodedQueryParameter(String str, String str2) {
            l.d(str, "encodedName");
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                setEncodedQueryNamesAndValues$okhttp(new ArrayList());
            }
            List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
            l.b(encodedQueryNamesAndValues$okhttp);
            Companion companion = HttpUrl.Companion;
            encodedQueryNamesAndValues$okhttp.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> encodedQueryNamesAndValues$okhttp2 = getEncodedQueryNamesAndValues$okhttp();
            l.b(encodedQueryNamesAndValues$okhttp2);
            encodedQueryNamesAndValues$okhttp2.add(str2 == null ? null : Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        public final Builder addPathSegment(String str) {
            l.d(str, "pathSegment");
            push(str, 0, str.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String str) {
            l.d(str, "pathSegments");
            return addPathSegments(str, false);
        }

        public final Builder addQueryParameter(String str, String str2) {
            l.d(str, "name");
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                setEncodedQueryNamesAndValues$okhttp(new ArrayList());
            }
            List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
            l.b(encodedQueryNamesAndValues$okhttp);
            Companion companion = HttpUrl.Companion;
            encodedQueryNamesAndValues$okhttp.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> encodedQueryNamesAndValues$okhttp2 = getEncodedQueryNamesAndValues$okhttp();
            l.b(encodedQueryNamesAndValues$okhttp2);
            encodedQueryNamesAndValues$okhttp2.add(str2 == null ? null : Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        public final HttpUrl build() {
            int p5;
            ArrayList arrayList;
            int p6;
            String str = this.scheme;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
                String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
                String str2 = this.host;
                if (str2 != null) {
                    int effectivePort = effectivePort();
                    List<String> list = this.encodedPathSegments;
                    p5 = o.p(list, 10);
                    ArrayList arrayList2 = new ArrayList(p5);
                    for (String str3 : list) {
                        arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, false, 7, null));
                    }
                    List<String> list2 = this.encodedQueryNamesAndValues;
                    if (list2 == null) {
                        arrayList = null;
                    } else {
                        p6 = o.p(list2, 10);
                        arrayList = new ArrayList(p6);
                        for (String str4 : list2) {
                            arrayList.add(str4 == null ? null : Companion.percentDecode$okhttp$default(HttpUrl.Companion, str4, 0, 0, true, 3, null));
                        }
                    }
                    String str5 = this.encodedFragment;
                    return new HttpUrl(str, percentDecode$okhttp$default, percentDecode$okhttp$default2, str2, effectivePort, arrayList2, arrayList, str5 == null ? null : Companion.percentDecode$okhttp$default(HttpUrl.Companion, str5, 0, 0, false, 7, null), toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public final Builder encodedFragment(String str) {
            setEncodedFragment$okhttp(str == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET, true, false, false, true, null, 179, null));
            return this;
        }

        public final Builder encodedPassword(String str) {
            l.d(str, "encodedPassword");
            setEncodedPassword$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null));
            return this;
        }

        public final Builder encodedPath(String str) {
            boolean y5;
            l.d(str, "encodedPath");
            y5 = w.y(str, "/", false, 2, null);
            if (y5) {
                resolvePath(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException(l.i("unexpected encodedPath: ", str).toString());
        }

        public final Builder encodedQuery(String str) {
            List<String> list = null;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                }
            }
            setEncodedQueryNamesAndValues$okhttp(list);
            return this;
        }

        public final Builder encodedUsername(String str) {
            l.d(str, "encodedUsername");
            setEncodedUsername$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null));
            return this;
        }

        public final Builder fragment(String str) {
            setEncodedFragment$okhttp(str == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET, false, false, false, true, null, 187, null));
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String str) {
            l.d(str, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, 0, 0, false, 7, null));
            if (canonicalHost != null) {
                setHost$okhttp(canonicalHost);
                return this;
            }
            throw new IllegalArgumentException(l.i("unexpected host: ", str));
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            String w02;
            int delimiterOffset;
            int i6;
            int i7;
            String str2;
            int i8;
            String str3;
            int i9;
            boolean z5;
            boolean v5;
            boolean v6;
            String str4 = str;
            l.d(str4, "input");
            int indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(str4, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(str4, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = Companion;
            int schemeDelimiterOffset = companion.schemeDelimiterOffset(str4, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            String str5 = "this as java.lang.String…ing(startIndex, endIndex)";
            char c6 = 65535;
            if (schemeDelimiterOffset != -1) {
                v5 = w.v(str4, "https:", indexOfFirstNonAsciiWhitespace$default, true);
                if (v5) {
                    this.scheme = "https";
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    v6 = w.v(str4, "http:", indexOfFirstNonAsciiWhitespace$default, true);
                    if (!v6) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String substring = str4.substring(0, schemeDelimiterOffset);
                        l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb.append(substring);
                        sb.append('\'');
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.scheme = "http";
                    indexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else if (httpUrl == null) {
                if (str.length() > 6) {
                    w02 = z.w0(str4, 6);
                    str4 = l.i(w02, "...");
                }
                throw new IllegalArgumentException(l.i("Expected URL scheme 'http' or 'https' but no scheme was found for ", str4));
            } else {
                this.scheme = httpUrl.scheme();
            }
            int slashCount = companion.slashCount(str4, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c7 = '?';
            char c8 = '#';
            if (slashCount >= 2 || httpUrl == null || !l.a(httpUrl.scheme(), this.scheme)) {
                int i10 = indexOfFirstNonAsciiWhitespace$default + slashCount;
                boolean z6 = false;
                boolean z7 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(str4, "@/\\?#", i10, indexOfLastNonAsciiWhitespace$default);
                    char charAt = delimiterOffset != indexOfLastNonAsciiWhitespace$default ? str4.charAt(delimiterOffset) : (char) 65535;
                    if (charAt == c6 || charAt == c8 || charAt == '/' || charAt == '\\' || charAt == c7) {
                        break;
                    } else if (charAt == '@') {
                        if (z6) {
                            i8 = indexOfLastNonAsciiWhitespace$default;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            str3 = str5;
                            i9 = delimiterOffset;
                            sb2.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i10, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb2.toString();
                        } else {
                            int delimiterOffset2 = Util.delimiterOffset(str4, ':', i10, delimiterOffset);
                            Companion companion2 = HttpUrl.Companion;
                            i8 = indexOfLastNonAsciiWhitespace$default;
                            String str6 = str5;
                            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, str, i10, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z7) {
                                canonicalize$okhttp$default = this.encodedUsername + "%40" + canonicalize$okhttp$default;
                            }
                            this.encodedUsername = canonicalize$okhttp$default;
                            if (delimiterOffset2 != delimiterOffset) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, str, delimiterOffset2 + 1, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z5 = true;
                            } else {
                                z5 = z6;
                            }
                            z6 = z5;
                            str3 = str6;
                            z7 = true;
                            i9 = delimiterOffset;
                        }
                        i10 = i9 + 1;
                        str5 = str3;
                        indexOfLastNonAsciiWhitespace$default = i8;
                        c8 = '#';
                        c7 = '?';
                        c6 = 65535;
                    }
                }
                String str7 = str5;
                i6 = indexOfLastNonAsciiWhitespace$default;
                Companion companion3 = Companion;
                int portColonOffset = companion3.portColonOffset(str4, i10, delimiterOffset);
                int i11 = portColonOffset + 1;
                if (i11 < delimiterOffset) {
                    i7 = i10;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, i10, portColonOffset, false, 4, null));
                    int parsePort = companion3.parsePort(str4, i11, delimiterOffset);
                    this.port = parsePort;
                    if (!(parsePort != -1)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String substring2 = str4.substring(i11, delimiterOffset);
                        l.c(substring2, str7);
                        sb3.append(substring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                    str2 = str7;
                } else {
                    i7 = i10;
                    str2 = str7;
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, str, i7, portColonOffset, false, 4, null));
                    String str8 = this.scheme;
                    l.b(str8);
                    this.port = companion4.defaultPort(str8);
                }
                if (!(this.host != null)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String substring3 = str4.substring(i7, portColonOffset);
                    l.c(substring3, str2);
                    sb4.append(substring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || str4.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i6 = indexOfLastNonAsciiWhitespace$default;
            }
            int i12 = i6;
            int delimiterOffset3 = Util.delimiterOffset(str4, "?#", indexOfFirstNonAsciiWhitespace$default, i12);
            resolvePath(str4, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 < i12 && str4.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(str4, '#', delimiterOffset3, i12);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, str, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i12 && str4.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, delimiterOffset3 + 1, i12, HttpUrl.FRAGMENT_ENCODE_SET, true, false, false, true, null, 176, null);
            }
            return this;
        }

        public final Builder password(String str) {
            l.d(str, "password");
            setEncodedPassword$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }

        public final Builder port(int i6) {
            boolean z5 = false;
            if (1 <= i6 && i6 < 65536) {
                z5 = true;
            }
            if (z5) {
                setPort$okhttp(i6);
                return this;
            }
            throw new IllegalArgumentException(l.i("unexpected port: ", Integer.valueOf(i6)).toString());
        }

        public final Builder query(String str) {
            List<String> list = null;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                }
            }
            setEncodedQueryNamesAndValues$okhttp(list);
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String host$okhttp = getHost$okhttp();
            setHost$okhttp(host$okhttp == null ? null : new k("[\"<>^`{|}]").replace(host$okhttp, HttpUrl.FRAGMENT_ENCODE_SET));
            int size = getEncodedPathSegments$okhttp().size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                getEncodedPathSegments$okhttp().set(i7, Companion.canonicalize$okhttp$default(HttpUrl.Companion, getEncodedPathSegments$okhttp().get(i7), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
            if (encodedQueryNamesAndValues$okhttp != null) {
                int size2 = encodedQueryNamesAndValues$okhttp.size();
                while (i6 < size2) {
                    int i8 = i6 + 1;
                    String str = encodedQueryNamesAndValues$okhttp.get(i6);
                    encodedQueryNamesAndValues$okhttp.set(i6, str == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null));
                    i6 = i8;
                }
            }
            String encodedFragment$okhttp = getEncodedFragment$okhttp();
            setEncodedFragment$okhttp(encodedFragment$okhttp != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedFragment$okhttp, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null) : null);
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String str) {
            l.d(str, "encodedName");
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        public final Builder removeAllQueryParameters(String str) {
            l.d(str, "name");
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        public final Builder removePathSegment(int i6) {
            getEncodedPathSegments$okhttp().remove(i6);
            if (getEncodedPathSegments$okhttp().isEmpty()) {
                getEncodedPathSegments$okhttp().add(HttpUrl.FRAGMENT_ENCODE_SET);
            }
            return this;
        }

        public final Builder scheme(String str) {
            boolean l6;
            boolean l7;
            l.d(str, "scheme");
            String str2 = "http";
            l6 = w.l(str, "http", true);
            if (!l6) {
                str2 = "https";
                l7 = w.l(str, "https", true);
                if (!l7) {
                    throw new IllegalArgumentException(l.i("unexpected scheme: ", str));
                }
            }
            setScheme$okhttp(str2);
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            l.d(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i6, String str) {
            l.d(str, "encodedPathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            getEncodedPathSegments$okhttp().set(i6, canonicalize$okhttp$default);
            if ((isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) ? false : true) {
                return this;
            }
            throw new IllegalArgumentException(l.i("unexpected path segment: ", str).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String str, String str2) {
            l.d(str, "encodedName");
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            l.d(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i6, String str) {
            l.d(str, "pathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if ((isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) ? false : true) {
                getEncodedPathSegments$okhttp().set(i6, canonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(l.i("unexpected path segment: ", str).toString());
        }

        public final void setPort$okhttp(int i6) {
            this.port = i6;
        }

        public final Builder setQueryParameter(String str, String str2) {
            l.d(str, "name");
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
            if ((getEncodedPassword$okhttp().length() > 0) != false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00b2, code lost:
            if (r1 != r2.defaultPort(r3)) goto L36;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            String str;
            boolean C;
            StringBuilder sb = new StringBuilder();
            if (getScheme$okhttp() != null) {
                sb.append(getScheme$okhttp());
                str = "://";
            } else {
                str = "//";
            }
            sb.append(str);
            if (!(getEncodedUsername$okhttp().length() > 0)) {
            }
            sb.append(getEncodedUsername$okhttp());
            if (getEncodedPassword$okhttp().length() > 0) {
                sb.append(':');
                sb.append(getEncodedPassword$okhttp());
            }
            sb.append('@');
            if (getHost$okhttp() != null) {
                String host$okhttp = getHost$okhttp();
                l.b(host$okhttp);
                C = x.C(host$okhttp, ':', false, 2, null);
                if (C) {
                    sb.append('[');
                    sb.append(getHost$okhttp());
                    sb.append(']');
                } else {
                    sb.append(getHost$okhttp());
                }
            }
            if (getPort$okhttp() != -1 || getScheme$okhttp() != null) {
                int effectivePort = effectivePort();
                if (getScheme$okhttp() != null) {
                    Companion companion = HttpUrl.Companion;
                    String scheme$okhttp = getScheme$okhttp();
                    l.b(scheme$okhttp);
                }
                sb.append(':');
                sb.append(effectivePort);
            }
            Companion companion2 = HttpUrl.Companion;
            companion2.toPathString$okhttp(getEncodedPathSegments$okhttp(), sb);
            if (getEncodedQueryNamesAndValues$okhttp() != null) {
                sb.append('?');
                List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
                l.b(encodedQueryNamesAndValues$okhttp);
                companion2.toQueryString$okhttp(encodedQueryNamesAndValues$okhttp, sb);
            }
            if (getEncodedFragment$okhttp() != null) {
                sb.append('#');
                sb.append(getEncodedFragment$okhttp());
            }
            String sb2 = sb.toString();
            l.c(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }

        public final Builder username(String str) {
            l.d(str, "username");
            setEncodedUsername$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }

        private final Builder addPathSegments(String str, boolean z5) {
            int i6 = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, "/\\", i6, str.length());
                push(str, i6, delimiterOffset, delimiterOffset < str.length(), z5);
                i6 = delimiterOffset + 1;
            } while (i6 <= str.length());
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i6, int i7, String str2, boolean z5, boolean z6, boolean z7, boolean z8, Charset charset, int i8, Object obj) {
            return companion.canonicalize$okhttp(str, (i8 & 1) != 0 ? 0 : i6, (i8 & 2) != 0 ? str.length() : i7, str2, (i8 & 8) != 0 ? false : z5, (i8 & 16) != 0 ? false : z6, (i8 & 32) != 0 ? false : z7, (i8 & 64) != 0 ? false : z8, (i8 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i6, int i7) {
            int i8 = i6 + 2;
            return i8 < i7 && str.charAt(i6) == '%' && Util.parseHexDigit(str.charAt(i6 + 1)) != -1 && Util.parseHexDigit(str.charAt(i8)) != -1;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i6, int i7, boolean z5, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i6 = 0;
            }
            if ((i8 & 2) != 0) {
                i7 = str.length();
            }
            if ((i8 & 4) != 0) {
                z5 = false;
            }
            return companion.percentDecode$okhttp(str, i6, i7, z5);
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x005f, code lost:
            if (isPercentEncoded(r16, r5, r18) == false) goto L39;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void writeCanonicalized(Buffer buffer, String str, int i6, int i7, String str2, boolean z5, boolean z6, boolean z7, boolean z8, Charset charset) {
            boolean C;
            int i8 = i6;
            Buffer buffer2 = null;
            while (i8 < i7) {
                int codePointAt = str.codePointAt(i8);
                if (!z5 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                    if (codePointAt == 43 && z7) {
                        buffer.writeUtf8(z5 ? d.ANY_NON_NULL_MARKER : "%2B");
                    } else {
                        if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z8)) {
                            C = x.C(str2, (char) codePointAt, false, 2, null);
                            if (!C) {
                                if (codePointAt == 37) {
                                    if (z5) {
                                        if (z6) {
                                        }
                                    }
                                }
                                buffer.writeUtf8CodePoint(codePointAt);
                                i8 += Character.charCount(codePointAt);
                            }
                        }
                        if (buffer2 == null) {
                            buffer2 = new Buffer();
                        }
                        if (charset == null || l.a(charset, StandardCharsets.UTF_8)) {
                            buffer2.writeUtf8CodePoint(codePointAt);
                        } else {
                            buffer2.writeString(str, i8, Character.charCount(codePointAt) + i8, charset);
                        }
                        while (!buffer2.exhausted()) {
                            int readByte = buffer2.readByte() & 255;
                            buffer.writeByte(37);
                            buffer.writeByte((int) HttpUrl.HEX_DIGITS[(readByte >> 4) & 15]);
                            buffer.writeByte((int) HttpUrl.HEX_DIGITS[readByte & 15]);
                        }
                        i8 += Character.charCount(codePointAt);
                    }
                }
                i8 += Character.charCount(codePointAt);
            }
        }

        private final void writePercentDecoded(Buffer buffer, String str, int i6, int i7, boolean z5) {
            int i8;
            while (i6 < i7) {
                int codePointAt = str.codePointAt(i6);
                if (codePointAt != 37 || (i8 = i6 + 2) >= i7) {
                    if (codePointAt == 43 && z5) {
                        buffer.writeByte(32);
                        i6++;
                    }
                    buffer.writeUtf8CodePoint(codePointAt);
                    i6 += Character.charCount(codePointAt);
                } else {
                    int parseHexDigit = Util.parseHexDigit(str.charAt(i6 + 1));
                    int parseHexDigit2 = Util.parseHexDigit(str.charAt(i8));
                    if (parseHexDigit != -1 && parseHexDigit2 != -1) {
                        buffer.writeByte((parseHexDigit << 4) + parseHexDigit2);
                        i6 = Character.charCount(codePointAt) + i8;
                    }
                    buffer.writeUtf8CodePoint(codePointAt);
                    i6 += Character.charCount(codePointAt);
                }
            }
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m95deprecated_get(String str) {
            l.d(str, "url");
            return get(str);
        }

        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final HttpUrl m98deprecated_parse(String str) {
            l.d(str, "url");
            return parse(str);
        }

        public final String canonicalize$okhttp(String str, int i6, int i7, String str2, boolean z5, boolean z6, boolean z7, boolean z8, Charset charset) {
            boolean C;
            l.d(str, "<this>");
            l.d(str2, "encodeSet");
            int i8 = i6;
            while (i8 < i7) {
                int codePointAt = str.codePointAt(i8);
                if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z8)) {
                    C = x.C(str2, (char) codePointAt, false, 2, null);
                    if (!C) {
                        if (codePointAt == 37) {
                            if (z5) {
                                if (z6) {
                                    if (!isPercentEncoded(str, i8, i7)) {
                                        Buffer buffer = new Buffer();
                                        buffer.writeUtf8(str, i6, i8);
                                        writeCanonicalized(buffer, str, i8, i7, str2, z5, z6, z7, z8, charset);
                                        return buffer.readUtf8();
                                    }
                                    if (codePointAt != 43 && z7) {
                                        Buffer buffer2 = new Buffer();
                                        buffer2.writeUtf8(str, i6, i8);
                                        writeCanonicalized(buffer2, str, i8, i7, str2, z5, z6, z7, z8, charset);
                                        return buffer2.readUtf8();
                                    }
                                    i8 += Character.charCount(codePointAt);
                                }
                            }
                        }
                        if (codePointAt != 43) {
                        }
                        i8 += Character.charCount(codePointAt);
                    }
                }
                Buffer buffer22 = new Buffer();
                buffer22.writeUtf8(str, i6, i8);
                writeCanonicalized(buffer22, str, i8, i7, str2, z5, z6, z7, z8, charset);
                return buffer22.readUtf8();
            }
            String substring = str.substring(i6, i7);
            l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final int defaultPort(String str) {
            l.d(str, "scheme");
            if (l.a(str, "http")) {
                return 80;
            }
            return l.a(str, "https") ? 443 : -1;
        }

        public final HttpUrl get(String str) {
            l.d(str, "<this>");
            return new Builder().parse$okhttp(null, str).build();
        }

        public final HttpUrl parse(String str) {
            l.d(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String str, int i6, int i7, boolean z5) {
            l.d(str, "<this>");
            int i8 = i6;
            while (i8 < i7) {
                int i9 = i8 + 1;
                char charAt = str.charAt(i8);
                if (charAt == '%' || (charAt == '+' && z5)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i6, i8);
                    writePercentDecoded(buffer, str, i8, i7, z5);
                    return buffer.readUtf8();
                }
                i8 = i9;
            }
            String substring = str.substring(i6, i7);
            l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final void toPathString$okhttp(List<String> list, StringBuilder sb) {
            l.d(list, "<this>");
            l.d(sb, "out");
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                sb.append('/');
                sb.append(list.get(i6));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String str) {
            int N;
            int N2;
            String str2;
            l.d(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            while (i6 <= str.length()) {
                N = x.N(str, '&', i6, false, 4, null);
                if (N == -1) {
                    N = str.length();
                }
                int i7 = N;
                N2 = x.N(str, '=', i6, false, 4, null);
                if (N2 == -1 || N2 > i7) {
                    String substring = str.substring(i6, i7);
                    l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    str2 = null;
                } else {
                    String substring2 = str.substring(i6, N2);
                    l.c(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                    str2 = str.substring(N2 + 1, i7);
                    l.c(str2, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                arrayList.add(str2);
                i6 = i7 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> list, StringBuilder sb) {
            r4.c g6;
            r4.a f6;
            l.d(list, "<this>");
            l.d(sb, "out");
            g6 = f.g(0, list.size());
            f6 = f.f(g6, 2);
            int a6 = f6.a();
            int b6 = f6.b();
            int c6 = f6.c();
            if ((c6 <= 0 || a6 > b6) && (c6 >= 0 || b6 > a6)) {
                return;
            }
            while (true) {
                int i6 = a6 + c6;
                String str = list.get(a6);
                String str2 = list.get(a6 + 1);
                if (a6 > 0) {
                    sb.append('&');
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
                if (a6 == b6) {
                    return;
                }
                a6 = i6;
            }
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m96deprecated_get(URI uri) {
            l.d(uri, "uri");
            return get(uri);
        }

        public final HttpUrl get(URI uri) {
            l.d(uri, "<this>");
            String uri2 = uri.toString();
            l.c(uri2, "toString()");
            return parse(uri2);
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m97deprecated_get(URL url) {
            l.d(url, "url");
            return get(url);
        }

        public final HttpUrl get(URL url) {
            l.d(url, "<this>");
            String url2 = url.toString();
            l.c(url2, "toString()");
            return parse(url2);
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int i6, List<String> list, List<String> list2, String str5, String str6) {
        l.d(str, "scheme");
        l.d(str2, "username");
        l.d(str3, "password");
        l.d(str4, "host");
        l.d(list, "pathSegments");
        l.d(str6, "url");
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i6;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
        this.isHttps = l.a(str, "https");
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_encodedFragment  reason: not valid java name */
    public final String m76deprecated_encodedFragment() {
        return encodedFragment();
    }

    /* renamed from: -deprecated_encodedPassword  reason: not valid java name */
    public final String m77deprecated_encodedPassword() {
        return encodedPassword();
    }

    /* renamed from: -deprecated_encodedPath  reason: not valid java name */
    public final String m78deprecated_encodedPath() {
        return encodedPath();
    }

    /* renamed from: -deprecated_encodedPathSegments  reason: not valid java name */
    public final List<String> m79deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    /* renamed from: -deprecated_encodedQuery  reason: not valid java name */
    public final String m80deprecated_encodedQuery() {
        return encodedQuery();
    }

    /* renamed from: -deprecated_encodedUsername  reason: not valid java name */
    public final String m81deprecated_encodedUsername() {
        return encodedUsername();
    }

    /* renamed from: -deprecated_fragment  reason: not valid java name */
    public final String m82deprecated_fragment() {
        return this.fragment;
    }

    /* renamed from: -deprecated_host  reason: not valid java name */
    public final String m83deprecated_host() {
        return this.host;
    }

    /* renamed from: -deprecated_password  reason: not valid java name */
    public final String m84deprecated_password() {
        return this.password;
    }

    /* renamed from: -deprecated_pathSegments  reason: not valid java name */
    public final List<String> m85deprecated_pathSegments() {
        return this.pathSegments;
    }

    /* renamed from: -deprecated_pathSize  reason: not valid java name */
    public final int m86deprecated_pathSize() {
        return pathSize();
    }

    /* renamed from: -deprecated_port  reason: not valid java name */
    public final int m87deprecated_port() {
        return this.port;
    }

    /* renamed from: -deprecated_query  reason: not valid java name */
    public final String m88deprecated_query() {
        return query();
    }

    /* renamed from: -deprecated_queryParameterNames  reason: not valid java name */
    public final Set<String> m89deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    /* renamed from: -deprecated_querySize  reason: not valid java name */
    public final int m90deprecated_querySize() {
        return querySize();
    }

    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m91deprecated_scheme() {
        return this.scheme;
    }

    /* renamed from: -deprecated_uri  reason: not valid java name */
    public final URI m92deprecated_uri() {
        return uri();
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final URL m93deprecated_url() {
        return url();
    }

    /* renamed from: -deprecated_username  reason: not valid java name */
    public final String m94deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        int N;
        if (this.fragment == null) {
            return null;
        }
        N = x.N(this.url, '#', 0, false, 6, null);
        String substring = this.url.substring(N + 1);
        l.c(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String encodedPassword() {
        int N;
        int N2;
        if (this.password.length() == 0) {
            return FRAGMENT_ENCODE_SET;
        }
        N = x.N(this.url, ':', this.scheme.length() + 3, false, 4, null);
        N2 = x.N(this.url, '@', 0, false, 6, null);
        String substring = this.url.substring(N + 1, N2);
        l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedPath() {
        int N;
        N = x.N(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        String substring = this.url.substring(N, Util.delimiterOffset(str, "?#", N, str.length()));
        l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final List<String> encodedPathSegments() {
        int N;
        N = x.N(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", N, str.length());
        ArrayList arrayList = new ArrayList();
        while (N < delimiterOffset) {
            int i6 = N + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, '/', i6, delimiterOffset);
            String substring = this.url.substring(i6, delimiterOffset2);
            l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(substring);
            N = delimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        int N;
        if (this.queryNamesAndValues == null) {
            return null;
        }
        N = x.N(this.url, '?', 0, false, 6, null);
        int i6 = N + 1;
        String str = this.url;
        String substring = this.url.substring(i6, Util.delimiterOffset(str, '#', i6, str.length()));
        l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return FRAGMENT_ENCODE_SET;
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String substring = this.url.substring(length, Util.delimiterOffset(str, ":@", length, str.length()));
        l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && l.a(((HttpUrl) obj).url, this.url);
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public final String queryParameter(String str) {
        r4.c g6;
        r4.a f6;
        l.d(str, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        g6 = f.g(0, list.size());
        f6 = f.f(g6, 2);
        int a6 = f6.a();
        int b6 = f6.b();
        int c6 = f6.c();
        if ((c6 > 0 && a6 <= b6) || (c6 < 0 && b6 <= a6)) {
            while (true) {
                int i6 = a6 + c6;
                if (l.a(str, this.queryNamesAndValues.get(a6))) {
                    return this.queryNamesAndValues.get(a6 + 1);
                }
                if (a6 == b6) {
                    break;
                }
                a6 = i6;
            }
        }
        return null;
    }

    public final String queryParameterName(int i6) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            String str = list.get(i6 * 2);
            l.b(str);
            return str;
        }
        throw new IndexOutOfBoundsException();
    }

    public final Set<String> queryParameterNames() {
        r4.c g6;
        r4.a f6;
        Set<String> b6;
        if (this.queryNamesAndValues == null) {
            b6 = i0.b();
            return b6;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        g6 = f.g(0, this.queryNamesAndValues.size());
        f6 = f.f(g6, 2);
        int a6 = f6.a();
        int b7 = f6.b();
        int c6 = f6.c();
        if ((c6 > 0 && a6 <= b7) || (c6 < 0 && b7 <= a6)) {
            while (true) {
                int i6 = a6 + c6;
                String str = this.queryNamesAndValues.get(a6);
                l.b(str);
                linkedHashSet.add(str);
                if (a6 == b7) {
                    break;
                }
                a6 = i6;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        l.c(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final String queryParameterValue(int i6) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i6 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String str) {
        r4.c g6;
        r4.a f6;
        List<String> f7;
        l.d(str, "name");
        if (this.queryNamesAndValues == null) {
            f7 = n.f();
            return f7;
        }
        ArrayList arrayList = new ArrayList();
        g6 = f.g(0, this.queryNamesAndValues.size());
        f6 = f.f(g6, 2);
        int a6 = f6.a();
        int b6 = f6.b();
        int c6 = f6.c();
        if ((c6 > 0 && a6 <= b6) || (c6 < 0 && b6 <= a6)) {
            while (true) {
                int i6 = a6 + c6;
                if (l.a(str, this.queryNamesAndValues.get(a6))) {
                    arrayList.add(this.queryNamesAndValues.get(a6 + 1));
                }
                if (a6 == b6) {
                    break;
                }
                a6 = i6;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        l.c(unmodifiableList, "unmodifiableList(result)");
        return unmodifiableList;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        l.b(newBuilder);
        return newBuilder.username(FRAGMENT_ENCODE_SET).password(FRAGMENT_ENCODE_SET).build().toString();
    }

    public final HttpUrl resolve(String str) {
        l.d(str, "link");
        Builder newBuilder = newBuilder(str);
        if (newBuilder == null) {
            return null;
        }
        return newBuilder.build();
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e6) {
            try {
                URI create = URI.create(new k("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(builder, FRAGMENT_ENCODE_SET));
                l.c(create, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e6);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e6) {
            throw new RuntimeException(e6);
        }
    }

    public final String username() {
        return this.username;
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public final Builder newBuilder(String str) {
        l.d(str, "link");
        try {
            return new Builder().parse$okhttp(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }
}
