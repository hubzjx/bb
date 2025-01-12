package okhttp3.internal;

import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.l;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes.dex */
public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str) {
        l.d(builder, "builder");
        l.d(str, "line");
        return builder.addLenient$okhttp(str);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z5) {
        l.d(connectionSpec, "connectionSpec");
        l.d(sSLSocket, "sslSocket");
        connectionSpec.apply$okhttp(sSLSocket, z5);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        l.d(cache, "cache");
        l.d(request, "request");
        return cache.get$okhttp(request);
    }

    public static final String cookieToString(Cookie cookie, boolean z5) {
        l.d(cookie, "cookie");
        return cookie.toString$okhttp(z5);
    }

    public static final Cookie parseCookie(long j6, HttpUrl httpUrl, String str) {
        l.d(httpUrl, "url");
        l.d(str, "setCookie");
        return Cookie.Companion.parse$okhttp(j6, httpUrl, str);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str, String str2) {
        l.d(builder, "builder");
        l.d(str, "name");
        l.d(str2, "value");
        return builder.addLenient$okhttp(str, str2);
    }
}
