package okhttp3.internal.http;

import java.net.Proxy;
import kotlin.jvm.internal.l;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes.dex */
public final class RequestLine {
    public static final RequestLine INSTANCE = new RequestLine();

    private RequestLine() {
    }

    private final boolean includeAuthorityInRequestLine(Request request, Proxy.Type type) {
        return !request.isHttps() && type == Proxy.Type.HTTP;
    }

    public final String get(Request request, Proxy.Type type) {
        l.d(request, "request");
        l.d(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.method());
        sb.append(' ');
        RequestLine requestLine = INSTANCE;
        boolean includeAuthorityInRequestLine = requestLine.includeAuthorityInRequestLine(request, type);
        HttpUrl url = request.url();
        if (includeAuthorityInRequestLine) {
            sb.append(url);
        } else {
            sb.append(requestLine.requestPath(url));
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        l.c(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String requestPath(HttpUrl httpUrl) {
        l.d(httpUrl, "url");
        String encodedPath = httpUrl.encodedPath();
        String encodedQuery = httpUrl.encodedQuery();
        if (encodedQuery != null) {
            return encodedPath + '?' + ((Object) encodedQuery);
        }
        return encodedPath;
    }
}
