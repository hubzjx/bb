package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
/* loaded from: classes.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response response) {
        l.d(call, "call");
        l.d(response, "cachedResponse");
    }

    public void cacheHit(Call call, Response response) {
        l.d(call, "call");
        l.d(response, "response");
    }

    public void cacheMiss(Call call) {
        l.d(call, "call");
    }

    public void callEnd(Call call) {
        l.d(call, "call");
    }

    public void callFailed(Call call, IOException iOException) {
        l.d(call, "call");
        l.d(iOException, "ioe");
    }

    public void callStart(Call call) {
        l.d(call, "call");
    }

    public void canceled(Call call) {
        l.d(call, "call");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        l.d(call, "call");
        l.d(inetSocketAddress, "inetSocketAddress");
        l.d(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        l.d(call, "call");
        l.d(inetSocketAddress, "inetSocketAddress");
        l.d(proxy, "proxy");
        l.d(iOException, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        l.d(call, "call");
        l.d(inetSocketAddress, "inetSocketAddress");
        l.d(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        l.d(call, "call");
        l.d(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        l.d(call, "call");
        l.d(connection, "connection");
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        l.d(call, "call");
        l.d(str, "domainName");
        l.d(list, "inetAddressList");
    }

    public void dnsStart(Call call, String str) {
        l.d(call, "call");
        l.d(str, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        l.d(call, "call");
        l.d(httpUrl, "url");
        l.d(list, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        l.d(call, "call");
        l.d(httpUrl, "url");
    }

    public void requestBodyEnd(Call call, long j6) {
        l.d(call, "call");
    }

    public void requestBodyStart(Call call) {
        l.d(call, "call");
    }

    public void requestFailed(Call call, IOException iOException) {
        l.d(call, "call");
        l.d(iOException, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        l.d(call, "call");
        l.d(request, "request");
    }

    public void requestHeadersStart(Call call) {
        l.d(call, "call");
    }

    public void responseBodyEnd(Call call, long j6) {
        l.d(call, "call");
    }

    public void responseBodyStart(Call call) {
        l.d(call, "call");
    }

    public void responseFailed(Call call, IOException iOException) {
        l.d(call, "call");
        l.d(iOException, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        l.d(call, "call");
        l.d(response, "response");
    }

    public void responseHeadersStart(Call call) {
        l.d(call, "call");
    }

    public void satisfactionFailure(Call call, Response response) {
        l.d(call, "call");
        l.d(response, "response");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        l.d(call, "call");
    }

    public void secureConnectStart(Call call) {
        l.d(call, "call");
    }
}
