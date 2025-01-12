package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.n;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.text.k;
import kotlin.text.w;
import kotlin.text.x;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
/* loaded from: classes.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* loaded from: classes.dex */
    public static final class Builder {
        private String domain;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private boolean persistent;
        private boolean secure;
        private String value;
        private long expiresAt = DatesKt.MAX_DATE;
        private String path = "/";

        public final Cookie build() {
            String str = this.name;
            if (str != null) {
                String str2 = this.value;
                if (str2 != null) {
                    long j6 = this.expiresAt;
                    String str3 = this.domain;
                    if (str3 != null) {
                        return new Cookie(str, str2, j6, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
                    }
                    throw new NullPointerException("builder.domain == null");
                }
                throw new NullPointerException("builder.value == null");
            }
            throw new NullPointerException("builder.name == null");
        }

        public final Builder domain(String str) {
            l.d(str, "domain");
            return domain(str, false);
        }

        public final Builder expiresAt(long j6) {
            if (j6 <= 0) {
                j6 = Long.MIN_VALUE;
            }
            if (j6 > DatesKt.MAX_DATE) {
                j6 = 253402300799999L;
            }
            this.expiresAt = j6;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String str) {
            l.d(str, "domain");
            return domain(str, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String str) {
            CharSequence v02;
            l.d(str, "name");
            v02 = x.v0(str);
            if (l.a(v02.toString(), str)) {
                this.name = str;
                return this;
            }
            throw new IllegalArgumentException("name is not trimmed".toString());
        }

        public final Builder path(String str) {
            boolean y5;
            l.d(str, "path");
            y5 = w.y(str, "/", false, 2, null);
            if (y5) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'".toString());
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String str) {
            CharSequence v02;
            l.d(str, "value");
            v02 = x.v0(str);
            if (l.a(v02.toString(), str)) {
                this.value = str;
                return this;
            }
            throw new IllegalArgumentException("value is not trimmed".toString());
        }

        private final Builder domain(String str, boolean z5) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost != null) {
                this.domain = canonicalHost;
                this.hostOnly = z5;
                return this;
            }
            throw new IllegalArgumentException(l.i("unexpected domain: ", str));
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x003f, code lost:
            if (r1 != ':') goto L7;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final int dateCharacterOffset(String str, int i6, int i7, boolean z5) {
            boolean z6;
            while (i6 < i7) {
                int i8 = i6 + 1;
                char charAt = str.charAt(i6);
                if ((charAt >= ' ' || charAt == '\t') && charAt < 127) {
                    z6 = false;
                    if (!(charAt <= '9' && '0' <= charAt)) {
                        if (!(charAt <= 'z' && 'a' <= charAt)) {
                            if (!(charAt <= 'Z' && 'A' <= charAt)) {
                            }
                        }
                    }
                }
                z6 = true;
                if (z6 == (!z5)) {
                    return i6;
                }
                i6 = i8;
            }
            return i7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            boolean k6;
            if (l.a(str, str2)) {
                return true;
            }
            k6 = w.k(str, str2, false, 2, null);
            return k6 && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.canParseAsIpAddress(str);
        }

        private final String parseDomain(String str) {
            boolean k6;
            String c02;
            k6 = w.k(str, ".", false, 2, null);
            if (!k6) {
                c02 = x.c0(str, ".");
                String canonicalHost = HostnamesKt.toCanonicalHost(c02);
                if (canonicalHost != null) {
                    return canonicalHost;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseExpires(String str, int i6, int i7) {
            int O;
            int dateCharacterOffset = dateCharacterOffset(str, i6, i7, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            while (dateCharacterOffset < i7) {
                int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i7, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i9 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    l.c(group, "matcher.group(1)");
                    i9 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    l.c(group2, "matcher.group(2)");
                    i12 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    l.c(group3, "matcher.group(3)");
                    i13 = Integer.parseInt(group3);
                } else if (i10 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    l.c(group4, "matcher.group(1)");
                    i10 = Integer.parseInt(group4);
                } else if (i11 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    l.c(group5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    l.c(locale, "US");
                    String lowerCase = group5.toLowerCase(locale);
                    l.c(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String pattern = Cookie.MONTH_PATTERN.pattern();
                    l.c(pattern, "MONTH_PATTERN.pattern()");
                    O = x.O(pattern, lowerCase, 0, false, 6, null);
                    i11 = O / 4;
                } else if (i8 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    l.c(group6, "matcher.group(1)");
                    i8 = Integer.parseInt(group6);
                }
                dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i7, false);
            }
            if (70 <= i8 && i8 < 100) {
                i8 += 1900;
            }
            if (i8 >= 0 && i8 < 70) {
                i8 += 2000;
            }
            if (i8 >= 1601) {
                if (i11 != -1) {
                    if (1 <= i10 && i10 < 32) {
                        if (i9 >= 0 && i9 < 24) {
                            if (i12 >= 0 && i12 < 60) {
                                if (i13 >= 0 && i13 < 60) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i8);
                                    gregorianCalendar.set(2, i11 - 1);
                                    gregorianCalendar.set(5, i10);
                                    gregorianCalendar.set(11, i9);
                                    gregorianCalendar.set(12, i12);
                                    gregorianCalendar.set(13, i13);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseMaxAge(String str) {
            boolean y5;
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e6) {
                if (new k("-?\\d+").matches(str)) {
                    y5 = w.y(str, "-", false, 2, null);
                    return y5 ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e6;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            boolean y5;
            boolean k6;
            String encodedPath = httpUrl.encodedPath();
            if (l.a(encodedPath, str)) {
                return true;
            }
            y5 = w.y(encodedPath, str, false, 2, null);
            if (y5) {
                k6 = w.k(str, "/", false, 2, null);
                if (k6 || encodedPath.charAt(str.length()) == '/') {
                    return true;
                }
            }
            return false;
        }

        public final Cookie parse(HttpUrl httpUrl, String str) {
            l.d(httpUrl, "url");
            l.d(str, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x0103, code lost:
            if (r1 > okhttp3.internal.http.DatesKt.MAX_DATE) goto L86;
         */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0115  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x015b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Cookie parse$okhttp(long j6, HttpUrl httpUrl, String str) {
            long j7;
            String host;
            Cookie cookie;
            String str2;
            String str3;
            int S;
            String str4;
            boolean y5;
            boolean l6;
            boolean l7;
            boolean l8;
            boolean l9;
            boolean l10;
            boolean l11;
            l.d(httpUrl, "url");
            l.d(str, "setCookie");
            int delimiterOffset$default = Util.delimiterOffset$default(str, ';', 0, 0, 6, (Object) null);
            int delimiterOffset$default2 = Util.delimiterOffset$default(str, '=', 0, delimiterOffset$default, 2, (Object) null);
            if (delimiterOffset$default2 == delimiterOffset$default) {
                return null;
            }
            String trimSubstring$default = Util.trimSubstring$default(str, 0, delimiterOffset$default2, 1, null);
            if ((trimSubstring$default.length() == 0) || Util.indexOfControlOrNonAscii(trimSubstring$default) != -1) {
                return null;
            }
            String trimSubstring = Util.trimSubstring(str, delimiterOffset$default2 + 1, delimiterOffset$default);
            if (Util.indexOfControlOrNonAscii(trimSubstring) != -1) {
                return null;
            }
            int i6 = delimiterOffset$default + 1;
            int length = str.length();
            String str5 = null;
            String str6 = null;
            long j8 = -1;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = true;
            long j9 = DatesKt.MAX_DATE;
            while (i6 < length) {
                int delimiterOffset = Util.delimiterOffset(str, ';', i6, length);
                int delimiterOffset2 = Util.delimiterOffset(str, '=', i6, delimiterOffset);
                String trimSubstring2 = Util.trimSubstring(str, i6, delimiterOffset2);
                String trimSubstring3 = delimiterOffset2 < delimiterOffset ? Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : HttpUrl.FRAGMENT_ENCODE_SET;
                l6 = w.l(trimSubstring2, "expires", true);
                if (l6) {
                    try {
                        j9 = parseExpires(trimSubstring3, 0, trimSubstring3.length());
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else {
                    l7 = w.l(trimSubstring2, "max-age", true);
                    if (l7) {
                        j8 = parseMaxAge(trimSubstring3);
                    } else {
                        l8 = w.l(trimSubstring2, "domain", true);
                        if (l8) {
                            str5 = parseDomain(trimSubstring3);
                            z8 = false;
                        } else {
                            l9 = w.l(trimSubstring2, "path", true);
                            if (l9) {
                                str6 = trimSubstring3;
                            } else {
                                l10 = w.l(trimSubstring2, "secure", true);
                                if (l10) {
                                    z5 = true;
                                } else {
                                    l11 = w.l(trimSubstring2, "httponly", true);
                                    if (l11) {
                                        z6 = true;
                                    }
                                }
                            }
                        }
                        i6 = delimiterOffset + 1;
                    }
                }
                z7 = true;
                i6 = delimiterOffset + 1;
            }
            long j10 = Long.MIN_VALUE;
            if (j8 != Long.MIN_VALUE) {
                if (j8 != -1) {
                    j10 = j6 + (j8 <= 9223372036854775L ? j8 * 1000 : Long.MAX_VALUE);
                    long j11 = j10 >= j6 ? DatesKt.MAX_DATE : DatesKt.MAX_DATE;
                    j7 = j11;
                } else {
                    j7 = j9;
                }
                host = httpUrl.host();
                if (str5 != null) {
                    str2 = host;
                    cookie = null;
                } else if (!domainMatch(host, str5)) {
                    return null;
                } else {
                    cookie = null;
                    str2 = str5;
                }
                if (host.length() == str2.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(str2) == null) {
                    return cookie;
                }
                String str7 = "/";
                str3 = str6;
                if (str3 != null) {
                    y5 = w.y(str3, "/", false, 2, cookie);
                    if (y5) {
                        str4 = str3;
                        return new Cookie(trimSubstring$default, trimSubstring, j7, str2, str4, z5, z6, z7, z8, null);
                    }
                }
                String encodedPath = httpUrl.encodedPath();
                S = x.S(encodedPath, '/', 0, false, 6, null);
                if (S != 0) {
                    str7 = encodedPath.substring(0, S);
                    l.c(str7, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                str4 = str7;
                return new Cookie(trimSubstring$default, trimSubstring, j7, str2, str4, z5, z6, z7, z8, null);
            }
            j7 = j10;
            host = httpUrl.host();
            if (str5 != null) {
            }
            if (host.length() == str2.length()) {
            }
            String str72 = "/";
            str3 = str6;
            if (str3 != null) {
            }
            String encodedPath2 = httpUrl.encodedPath();
            S = x.S(encodedPath2, '/', 0, false, 6, null);
            if (S != 0) {
            }
            str4 = str72;
            return new Cookie(trimSubstring$default, trimSubstring, j7, str2, str4, z5, z6, z7, z8, null);
        }

        public final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
            List<Cookie> f6;
            l.d(httpUrl, "url");
            l.d(headers, "headers");
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            ArrayList arrayList = null;
            int i6 = 0;
            while (i6 < size) {
                int i7 = i6 + 1;
                Cookie parse = parse(httpUrl, values.get(i6));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
                i6 = i7;
            }
            if (arrayList == null) {
                f6 = n.f();
                return f6;
            }
            List<Cookie> unmodifiableList = Collections.unmodifiableList(arrayList);
            l.c(unmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return unmodifiableList;
        }
    }

    private Cookie(String str, String str2, long j6, String str3, String str4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j6;
        this.domain = str3;
        this.path = str4;
        this.secure = z5;
        this.httpOnly = z6;
        this.persistent = z7;
        this.hostOnly = z8;
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    /* renamed from: -deprecated_domain  reason: not valid java name */
    public final String m55deprecated_domain() {
        return this.domain;
    }

    /* renamed from: -deprecated_expiresAt  reason: not valid java name */
    public final long m56deprecated_expiresAt() {
        return this.expiresAt;
    }

    /* renamed from: -deprecated_hostOnly  reason: not valid java name */
    public final boolean m57deprecated_hostOnly() {
        return this.hostOnly;
    }

    /* renamed from: -deprecated_httpOnly  reason: not valid java name */
    public final boolean m58deprecated_httpOnly() {
        return this.httpOnly;
    }

    /* renamed from: -deprecated_name  reason: not valid java name */
    public final String m59deprecated_name() {
        return this.name;
    }

    /* renamed from: -deprecated_path  reason: not valid java name */
    public final String m60deprecated_path() {
        return this.path;
    }

    /* renamed from: -deprecated_persistent  reason: not valid java name */
    public final boolean m61deprecated_persistent() {
        return this.persistent;
    }

    /* renamed from: -deprecated_secure  reason: not valid java name */
    public final boolean m62deprecated_secure() {
        return this.secure;
    }

    /* renamed from: -deprecated_value  reason: not valid java name */
    public final String m63deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (l.a(cookie.name, this.name) && l.a(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && l.a(cookie.domain, this.domain) && l.a(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + a.a(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + b.a(this.secure)) * 31) + b.a(this.httpOnly)) * 31) + b.a(this.persistent)) * 31) + b.a(this.hostOnly);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl httpUrl) {
        l.d(httpUrl, "url");
        if ((this.hostOnly ? l.a(httpUrl.host(), this.domain) : Companion.domainMatch(httpUrl.host(), this.domain)) && Companion.pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z5) {
        String httpDateString;
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append('=');
        sb.append(value());
        if (persistent()) {
            if (expiresAt() == Long.MIN_VALUE) {
                httpDateString = "; max-age=0";
            } else {
                sb.append("; expires=");
                httpDateString = DatesKt.toHttpDateString(new Date(expiresAt()));
            }
            sb.append(httpDateString);
        }
        if (!hostOnly()) {
            sb.append("; domain=");
            if (z5) {
                sb.append(".");
            }
            sb.append(domain());
        }
        sb.append("; path=");
        sb.append(path());
        if (secure()) {
            sb.append("; secure");
        }
        if (httpOnly()) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        l.c(sb2, "toString()");
        return sb2;
    }

    public final String value() {
        return this.value;
    }

    public /* synthetic */ Cookie(String str, String str2, long j6, String str3, String str4, boolean z5, boolean z6, boolean z7, boolean z8, g gVar) {
        this(str, str2, j6, str3, str4, z5, z6, z7, z8);
    }
}
