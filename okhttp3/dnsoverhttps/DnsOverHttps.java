package okhttp3.dnsoverhttps;

import h4.b;
import h4.q;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.collections.j;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.text.w;
import n4.a;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.ByteString;
/* loaded from: classes.dex */
public final class DnsOverHttps implements Dns {
    public static final Companion Companion = new Companion(null);
    private static final MediaType DNS_MESSAGE = MediaType.Companion.get("application/dns-message");
    public static final int MAX_RESPONSE_SIZE = 65536;
    private final OkHttpClient client;
    private final boolean includeIPv6;
    private final boolean post;
    private final boolean resolvePrivateAddresses;
    private final boolean resolvePublicAddresses;
    private final HttpUrl url;

    /* loaded from: classes.dex */
    public static final class Builder {
        private List<? extends InetAddress> bootstrapDnsHosts;
        private OkHttpClient client;
        private boolean post;
        private boolean resolvePrivateAddresses;
        private HttpUrl url;
        private boolean includeIPv6 = true;
        private Dns systemDns = Dns.SYSTEM;
        private boolean resolvePublicAddresses = true;

        public final Builder bootstrapDnsHosts(List<? extends InetAddress> list) {
            setBootstrapDnsHosts$okhttp_dnsoverhttps(list);
            return this;
        }

        public final DnsOverHttps build() {
            OkHttpClient okHttpClient = this.client;
            if (okHttpClient != null) {
                OkHttpClient build = okHttpClient.newBuilder().dns(DnsOverHttps.Companion.buildBootstrapClient(this)).build();
                HttpUrl httpUrl = this.url;
                if (httpUrl != null) {
                    return new DnsOverHttps(build, httpUrl, this.includeIPv6, this.post, this.resolvePrivateAddresses, this.resolvePublicAddresses);
                }
                throw new IllegalStateException("url not set".toString());
            }
            throw new NullPointerException("client not set");
        }

        public final Builder client(OkHttpClient okHttpClient) {
            l.d(okHttpClient, "client");
            setClient$okhttp_dnsoverhttps(okHttpClient);
            return this;
        }

        public final List<InetAddress> getBootstrapDnsHosts$okhttp_dnsoverhttps() {
            return this.bootstrapDnsHosts;
        }

        public final OkHttpClient getClient$okhttp_dnsoverhttps() {
            return this.client;
        }

        public final boolean getIncludeIPv6$okhttp_dnsoverhttps() {
            return this.includeIPv6;
        }

        public final boolean getPost$okhttp_dnsoverhttps() {
            return this.post;
        }

        public final boolean getResolvePrivateAddresses$okhttp_dnsoverhttps() {
            return this.resolvePrivateAddresses;
        }

        public final boolean getResolvePublicAddresses$okhttp_dnsoverhttps() {
            return this.resolvePublicAddresses;
        }

        public final Dns getSystemDns$okhttp_dnsoverhttps() {
            return this.systemDns;
        }

        public final HttpUrl getUrl$okhttp_dnsoverhttps() {
            return this.url;
        }

        public final Builder includeIPv6(boolean z5) {
            setIncludeIPv6$okhttp_dnsoverhttps(z5);
            return this;
        }

        public final Builder post(boolean z5) {
            setPost$okhttp_dnsoverhttps(z5);
            return this;
        }

        public final Builder resolvePrivateAddresses(boolean z5) {
            setResolvePrivateAddresses$okhttp_dnsoverhttps(z5);
            return this;
        }

        public final Builder resolvePublicAddresses(boolean z5) {
            setResolvePublicAddresses$okhttp_dnsoverhttps(z5);
            return this;
        }

        public final void setBootstrapDnsHosts$okhttp_dnsoverhttps(List<? extends InetAddress> list) {
            this.bootstrapDnsHosts = list;
        }

        public final void setClient$okhttp_dnsoverhttps(OkHttpClient okHttpClient) {
            this.client = okHttpClient;
        }

        public final void setIncludeIPv6$okhttp_dnsoverhttps(boolean z5) {
            this.includeIPv6 = z5;
        }

        public final void setPost$okhttp_dnsoverhttps(boolean z5) {
            this.post = z5;
        }

        public final void setResolvePrivateAddresses$okhttp_dnsoverhttps(boolean z5) {
            this.resolvePrivateAddresses = z5;
        }

        public final void setResolvePublicAddresses$okhttp_dnsoverhttps(boolean z5) {
            this.resolvePublicAddresses = z5;
        }

        public final void setSystemDns$okhttp_dnsoverhttps(Dns dns) {
            l.d(dns, "<set-?>");
            this.systemDns = dns;
        }

        public final void setUrl$okhttp_dnsoverhttps(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public final Builder systemDns(Dns dns) {
            l.d(dns, "systemDns");
            setSystemDns$okhttp_dnsoverhttps(dns);
            return this;
        }

        public final Builder url(HttpUrl httpUrl) {
            l.d(httpUrl, "url");
            setUrl$okhttp_dnsoverhttps(httpUrl);
            return this;
        }

        public final Builder bootstrapDnsHosts(InetAddress... inetAddressArr) {
            List<? extends InetAddress> v5;
            l.d(inetAddressArr, "bootstrapDnsHosts");
            v5 = j.v(inetAddressArr);
            return bootstrapDnsHosts(v5);
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Dns buildBootstrapClient(Builder builder) {
            List<InetAddress> bootstrapDnsHosts$okhttp_dnsoverhttps = builder.getBootstrapDnsHosts$okhttp_dnsoverhttps();
            if (bootstrapDnsHosts$okhttp_dnsoverhttps != null) {
                HttpUrl url$okhttp_dnsoverhttps = builder.getUrl$okhttp_dnsoverhttps();
                l.b(url$okhttp_dnsoverhttps);
                return new BootstrapDns(url$okhttp_dnsoverhttps.host(), bootstrapDnsHosts$okhttp_dnsoverhttps);
            }
            return builder.getSystemDns$okhttp_dnsoverhttps();
        }

        public final MediaType getDNS_MESSAGE() {
            return DnsOverHttps.DNS_MESSAGE;
        }

        public final boolean isPrivateHost$okhttp_dnsoverhttps(String str) {
            l.d(str, "host");
            return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(str) == null;
        }
    }

    public DnsOverHttps(OkHttpClient okHttpClient, HttpUrl httpUrl, boolean z5, boolean z6, boolean z7, boolean z8) {
        l.d(okHttpClient, "client");
        l.d(httpUrl, "url");
        this.client = okHttpClient;
        this.url = httpUrl;
        this.includeIPv6 = z5;
        this.post = z6;
        this.resolvePrivateAddresses = z7;
        this.resolvePublicAddresses = z8;
    }

    private final Request buildRequest(String str, int i6) {
        String u5;
        Request.Builder builder = new Request.Builder();
        MediaType mediaType = DNS_MESSAGE;
        Request.Builder header = builder.header("Accept", mediaType.toString());
        ByteString encodeQuery = DnsRecordCodec.INSTANCE.encodeQuery(str, i6);
        if (post()) {
            header.url(url()).post(RequestBody.Companion.create(encodeQuery, mediaType));
        } else {
            u5 = w.u(encodeQuery.base64Url(), "=", HttpUrl.FRAGMENT_ENCODE_SET, false, 4, null);
            header.url(url().newBuilder().addQueryParameter("dns", u5).build());
        }
        return header.build();
    }

    private final void executeRequests(final String str, List<? extends Call> list, final List<InetAddress> list2, final List<Exception> list3) {
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        for (Call call : list) {
            call.enqueue(new Callback() { // from class: okhttp3.dnsoverhttps.DnsOverHttps$executeRequests$1
                @Override // okhttp3.Callback
                public void onFailure(Call call2, IOException iOException) {
                    l.d(call2, "call");
                    l.d(iOException, "e");
                    List<Exception> list4 = list3;
                    synchronized (list4) {
                        list4.add(iOException);
                    }
                    countDownLatch.countDown();
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call2, Response response) {
                    l.d(call2, "call");
                    l.d(response, "response");
                    this.processResponse(response, str, list2, list3);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e6) {
            list3.add(e6);
        }
    }

    private final Response getCacheOnlyResponse(Request request) {
        if (this.post || this.client.cache() == null) {
            return null;
        }
        try {
            Response execute = this.client.newCall(request.newBuilder().cacheControl(new CacheControl.Builder().onlyIfCached().build()).build()).execute();
            if (execute.code() != 504) {
                return execute;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    private final List<InetAddress> lookupHttps(String str) {
        ArrayList arrayList = new ArrayList(2);
        ArrayList arrayList2 = new ArrayList(2);
        ArrayList arrayList3 = new ArrayList(5);
        buildRequest(str, arrayList, arrayList3, arrayList2, 1);
        if (this.includeIPv6) {
            buildRequest(str, arrayList, arrayList3, arrayList2, 28);
        }
        executeRequests(str, arrayList, arrayList3, arrayList2);
        return arrayList3.isEmpty() ^ true ? arrayList3 : throwBestFailure(str, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processResponse(Response response, String str, List<InetAddress> list, List<Exception> list2) {
        try {
            List<InetAddress> readResponse = readResponse(str, response);
            synchronized (list) {
                list.addAll(readResponse);
            }
        } catch (Exception e6) {
            synchronized (list2) {
                list2.add(e6);
            }
        }
    }

    private final List<InetAddress> readResponse(String str, Response response) {
        if (response.cacheResponse() == null && response.protocol() != Protocol.HTTP_2) {
            Platform.log$default(Platform.Companion.get(), l.i("Incorrect protocol: ", response.protocol()), 5, null, 4, null);
        }
        try {
            if (!response.isSuccessful()) {
                throw new IOException("response: " + response.code() + ' ' + response.message());
            }
            ResponseBody body = response.body();
            l.b(body);
            if (body.contentLength() <= 65536) {
                List<InetAddress> decodeAnswers = DnsRecordCodec.INSTANCE.decodeAnswers(str, body.source().readByteString());
                a.a(response, null);
                return decodeAnswers;
            }
            throw new IOException("response size exceeds limit (65536 bytes): " + body.contentLength() + " bytes");
        } finally {
        }
    }

    private final List<InetAddress> throwBestFailure(String str, List<? extends Exception> list) {
        if (list.isEmpty()) {
            throw new UnknownHostException(str);
        }
        Exception exc = list.get(0);
        if (exc instanceof UnknownHostException) {
            throw exc;
        }
        UnknownHostException unknownHostException = new UnknownHostException(str);
        unknownHostException.initCause(exc);
        int size = list.size();
        for (int i6 = 1; i6 < size; i6++) {
            b.a(unknownHostException, list.get(i6));
        }
        throw unknownHostException;
    }

    public final OkHttpClient client() {
        return this.client;
    }

    public final boolean includeIPv6() {
        return this.includeIPv6;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) {
        l.d(str, "hostname");
        if (!this.resolvePrivateAddresses || !this.resolvePublicAddresses) {
            boolean isPrivateHost$okhttp_dnsoverhttps = Companion.isPrivateHost$okhttp_dnsoverhttps(str);
            if (isPrivateHost$okhttp_dnsoverhttps && !this.resolvePrivateAddresses) {
                throw new UnknownHostException("private hosts not resolved");
            }
            if (!isPrivateHost$okhttp_dnsoverhttps && !this.resolvePublicAddresses) {
                throw new UnknownHostException("public hosts not resolved");
            }
        }
        return lookupHttps(str);
    }

    public final boolean post() {
        return this.post;
    }

    public final boolean resolvePrivateAddresses() {
        return this.resolvePrivateAddresses;
    }

    public final boolean resolvePublicAddresses() {
        return this.resolvePublicAddresses;
    }

    public final HttpUrl url() {
        return this.url;
    }

    private final void buildRequest(String str, List<Call> list, List<InetAddress> list2, List<Exception> list3, int i6) {
        q qVar;
        Request buildRequest = buildRequest(str, i6);
        Response cacheOnlyResponse = getCacheOnlyResponse(buildRequest);
        if (cacheOnlyResponse == null) {
            qVar = null;
        } else {
            processResponse(cacheOnlyResponse, str, list2, list3);
            qVar = q.f10774a;
        }
        if (qVar == null) {
            list.add(this.client.newCall(buildRequest));
        }
    }
}
