package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.text.w;
import kotlin.text.x;
import okhttp3.internal.Util;
/* loaded from: classes.dex */
public final class CacheControl {
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final Companion Companion = new Companion(null);
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j6) {
            if (j6 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j6;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        public final Builder maxAge(int i6, TimeUnit timeUnit) {
            l.d(timeUnit, "timeUnit");
            if (i6 >= 0) {
                this.maxAgeSeconds = clampToInt(timeUnit.toSeconds(i6));
                return this;
            }
            throw new IllegalArgumentException(l.i("maxAge < 0: ", Integer.valueOf(i6)).toString());
        }

        public final Builder maxStale(int i6, TimeUnit timeUnit) {
            l.d(timeUnit, "timeUnit");
            if (i6 >= 0) {
                this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(i6));
                return this;
            }
            throw new IllegalArgumentException(l.i("maxStale < 0: ", Integer.valueOf(i6)).toString());
        }

        public final Builder minFresh(int i6, TimeUnit timeUnit) {
            l.d(timeUnit, "timeUnit");
            if (i6 >= 0) {
                this.minFreshSeconds = clampToInt(timeUnit.toSeconds(i6));
                return this;
            }
            throw new IllegalArgumentException(l.i("minFresh < 0: ", Integer.valueOf(i6)).toString());
        }

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
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

        private final int indexOfElement(String str, String str2, int i6) {
            boolean C;
            int length = str.length();
            while (i6 < length) {
                int i7 = i6 + 1;
                C = x.C(str2, str.charAt(i6), false, 2, null);
                if (C) {
                    return i6;
                }
                i6 = i7;
            }
            return str.length();
        }

        static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i6, int i7, Object obj) {
            if ((i7 & 2) != 0) {
                i6 = 0;
            }
            return companion.indexOfElement(str, str2, i6);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final CacheControl parse(Headers headers) {
            boolean l6;
            boolean l7;
            int i6;
            CharSequence v02;
            int i7;
            String str;
            boolean l8;
            boolean l9;
            boolean l10;
            boolean l11;
            boolean l12;
            boolean l13;
            boolean l14;
            boolean l15;
            boolean l16;
            boolean l17;
            boolean l18;
            boolean l19;
            CharSequence v03;
            int N;
            Headers headers2 = headers;
            l.d(headers2, "headers");
            int size = headers.size();
            boolean z5 = true;
            int i8 = 0;
            boolean z6 = true;
            String str2 = null;
            boolean z7 = false;
            boolean z8 = false;
            int i9 = -1;
            int i10 = -1;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            int i11 = -1;
            int i12 = -1;
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = false;
            while (i8 < size) {
                int i13 = i8 + 1;
                String name = headers2.name(i8);
                String value = headers2.value(i8);
                l6 = w.l(name, "Cache-Control", z5);
                if (!l6) {
                    l7 = w.l(name, "Pragma", z5);
                    if (!l7) {
                        headers2 = headers;
                        i8 = i13;
                    }
                } else if (str2 == null) {
                    str2 = value;
                    i6 = 0;
                    while (i6 < value.length()) {
                        int indexOfElement = indexOfElement(value, "=,;", i6);
                        String substring = value.substring(i6, indexOfElement);
                        l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        v02 = x.v0(substring);
                        String obj = v02.toString();
                        if (indexOfElement == value.length() || value.charAt(indexOfElement) == ',' || value.charAt(indexOfElement) == ';') {
                            i7 = indexOfElement + 1;
                            str = null;
                        } else {
                            int indexOfNonWhitespace = Util.indexOfNonWhitespace(value, indexOfElement + 1);
                            if (indexOfNonWhitespace >= value.length() || value.charAt(indexOfNonWhitespace) != '\"') {
                                i7 = indexOfElement(value, ",;", indexOfNonWhitespace);
                                String substring2 = value.substring(indexOfNonWhitespace, i7);
                                l.c(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                v03 = x.v0(substring2);
                                str = v03.toString();
                            } else {
                                int i14 = indexOfNonWhitespace + 1;
                                N = x.N(value, '\"', i14, false, 4, null);
                                str = value.substring(i14, N);
                                l.c(str, "this as java.lang.String…ing(startIndex, endIndex)");
                                i7 = N + 1;
                            }
                        }
                        l8 = w.l("no-cache", obj, true);
                        if (l8) {
                            i6 = i7;
                            z5 = true;
                            z7 = true;
                        } else {
                            l9 = w.l("no-store", obj, true);
                            if (l9) {
                                i6 = i7;
                                z5 = true;
                                z8 = true;
                            } else {
                                l10 = w.l("max-age", obj, true);
                                if (l10) {
                                    i9 = Util.toNonNegativeInt(str, -1);
                                } else {
                                    l11 = w.l("s-maxage", obj, true);
                                    if (l11) {
                                        i10 = Util.toNonNegativeInt(str, -1);
                                    } else {
                                        l12 = w.l("private", obj, true);
                                        if (l12) {
                                            i6 = i7;
                                            z5 = true;
                                            z9 = true;
                                        } else {
                                            l13 = w.l("public", obj, true);
                                            if (l13) {
                                                i6 = i7;
                                                z5 = true;
                                                z10 = true;
                                            } else {
                                                l14 = w.l("must-revalidate", obj, true);
                                                if (l14) {
                                                    i6 = i7;
                                                    z5 = true;
                                                    z11 = true;
                                                } else {
                                                    l15 = w.l("max-stale", obj, true);
                                                    if (l15) {
                                                        i11 = Util.toNonNegativeInt(str, Integer.MAX_VALUE);
                                                    } else {
                                                        l16 = w.l("min-fresh", obj, true);
                                                        if (l16) {
                                                            i12 = Util.toNonNegativeInt(str, -1);
                                                        } else {
                                                            l17 = w.l("only-if-cached", obj, true);
                                                            if (l17) {
                                                                i6 = i7;
                                                                z5 = true;
                                                                z12 = true;
                                                            } else {
                                                                l18 = w.l("no-transform", obj, true);
                                                                if (l18) {
                                                                    i6 = i7;
                                                                    z5 = true;
                                                                    z13 = true;
                                                                } else {
                                                                    l19 = w.l("immutable", obj, true);
                                                                    if (l19) {
                                                                        i6 = i7;
                                                                        z5 = true;
                                                                        z14 = true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                i6 = i7;
                                z5 = true;
                            }
                        }
                    }
                    headers2 = headers;
                    i8 = i13;
                }
                z6 = false;
                i6 = 0;
                while (i6 < value.length()) {
                }
                headers2 = headers;
                i8 = i13;
            }
            return new CacheControl(z7, z8, i9, i10, z9, z10, z11, i11, i12, z12, z13, z14, !z6 ? null : str2, null);
        }
    }

    private CacheControl(boolean z5, boolean z6, int i6, int i7, boolean z7, boolean z8, boolean z9, int i8, int i9, boolean z10, boolean z11, boolean z12, String str) {
        this.noCache = z5;
        this.noStore = z6;
        this.maxAgeSeconds = i6;
        this.sMaxAgeSeconds = i7;
        this.isPrivate = z7;
        this.isPublic = z8;
        this.mustRevalidate = z9;
        this.maxStaleSeconds = i8;
        this.minFreshSeconds = i9;
        this.onlyIfCached = z10;
        this.noTransform = z11;
        this.immutable = z12;
        this.headerValue = str;
    }

    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    /* renamed from: -deprecated_immutable  reason: not valid java name */
    public final boolean m37deprecated_immutable() {
        return this.immutable;
    }

    /* renamed from: -deprecated_maxAgeSeconds  reason: not valid java name */
    public final int m38deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* renamed from: -deprecated_maxStaleSeconds  reason: not valid java name */
    public final int m39deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    /* renamed from: -deprecated_minFreshSeconds  reason: not valid java name */
    public final int m40deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    /* renamed from: -deprecated_mustRevalidate  reason: not valid java name */
    public final boolean m41deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    /* renamed from: -deprecated_noCache  reason: not valid java name */
    public final boolean m42deprecated_noCache() {
        return this.noCache;
    }

    /* renamed from: -deprecated_noStore  reason: not valid java name */
    public final boolean m43deprecated_noStore() {
        return this.noStore;
    }

    /* renamed from: -deprecated_noTransform  reason: not valid java name */
    public final boolean m44deprecated_noTransform() {
        return this.noTransform;
    }

    /* renamed from: -deprecated_onlyIfCached  reason: not valid java name */
    public final boolean m45deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    /* renamed from: -deprecated_sMaxAgeSeconds  reason: not valid java name */
    public final int m46deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String str = this.headerValue;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            if (noCache()) {
                sb.append("no-cache, ");
            }
            if (noStore()) {
                sb.append("no-store, ");
            }
            if (maxAgeSeconds() != -1) {
                sb.append("max-age=");
                sb.append(maxAgeSeconds());
                sb.append(", ");
            }
            if (sMaxAgeSeconds() != -1) {
                sb.append("s-maxage=");
                sb.append(sMaxAgeSeconds());
                sb.append(", ");
            }
            if (isPrivate()) {
                sb.append("private, ");
            }
            if (isPublic()) {
                sb.append("public, ");
            }
            if (mustRevalidate()) {
                sb.append("must-revalidate, ");
            }
            if (maxStaleSeconds() != -1) {
                sb.append("max-stale=");
                sb.append(maxStaleSeconds());
                sb.append(", ");
            }
            if (minFreshSeconds() != -1) {
                sb.append("min-fresh=");
                sb.append(minFreshSeconds());
                sb.append(", ");
            }
            if (onlyIfCached()) {
                sb.append("only-if-cached, ");
            }
            if (noTransform()) {
                sb.append("no-transform, ");
            }
            if (immutable()) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            sb.delete(sb.length() - 2, sb.length());
            String sb2 = sb.toString();
            l.c(sb2, "StringBuilder().apply(builderAction).toString()");
            this.headerValue = sb2;
            return sb2;
        }
        return str;
    }

    public /* synthetic */ CacheControl(boolean z5, boolean z6, int i6, int i7, boolean z7, boolean z8, boolean z9, int i8, int i9, boolean z10, boolean z11, boolean z12, String str, g gVar) {
        this(z5, z6, i6, i7, z7, z8, z9, i8, i9, z10, z11, z12, str);
    }
}
