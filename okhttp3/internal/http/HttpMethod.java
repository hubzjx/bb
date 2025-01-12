package okhttp3.internal.http;

import kotlin.jvm.internal.l;
/* loaded from: classes.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean permitsRequestBody(String str) {
        l.d(str, "method");
        return (l.a(str, "GET") || l.a(str, "HEAD")) ? false : true;
    }

    public static final boolean requiresRequestBody(String str) {
        l.d(str, "method");
        return l.a(str, "POST") || l.a(str, "PUT") || l.a(str, "PATCH") || l.a(str, "PROPPATCH") || l.a(str, "REPORT");
    }

    public final boolean invalidatesCache(String str) {
        l.d(str, "method");
        return l.a(str, "POST") || l.a(str, "PATCH") || l.a(str, "PUT") || l.a(str, "DELETE") || l.a(str, "MOVE");
    }

    public final boolean redirectsToGet(String str) {
        l.d(str, "method");
        return !l.a(str, "PROPFIND");
    }

    public final boolean redirectsWithBody(String str) {
        l.d(str, "method");
        return l.a(str, "PROPFIND");
    }
}
