package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.text.w;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
/* loaded from: classes.dex */
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private final Cache cache;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            int i6;
            boolean l6;
            boolean y5;
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            int i7 = 0;
            while (i6 < size) {
                int i8 = i6 + 1;
                String name = headers.name(i6);
                String value = headers.value(i6);
                l6 = w.l("Warning", name, true);
                if (l6) {
                    y5 = w.y(value, "1", false, 2, null);
                    i6 = y5 ? i8 : 0;
                }
                if (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            int size2 = headers2.size();
            while (i7 < size2) {
                int i9 = i7 + 1;
                String name2 = headers2.name(i7);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    builder.addLenient$okhttp(name2, headers2.value(i7));
                }
                i7 = i9;
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String str) {
            boolean l6;
            boolean l7;
            boolean l8;
            l6 = w.l("Content-Length", str, true);
            if (l6) {
                return true;
            }
            l7 = w.l("Content-Encoding", str, true);
            if (l7) {
                return true;
            }
            l8 = w.l("Content-Type", str, true);
            return l8;
        }

        private final boolean isEndToEnd(String str) {
            boolean l6;
            boolean l7;
            boolean l8;
            boolean l9;
            boolean l10;
            boolean l11;
            boolean l12;
            boolean l13;
            l6 = w.l("Connection", str, true);
            if (!l6) {
                l7 = w.l("Keep-Alive", str, true);
                if (!l7) {
                    l8 = w.l("Proxy-Authenticate", str, true);
                    if (!l8) {
                        l9 = w.l("Proxy-Authorization", str, true);
                        if (!l9) {
                            l10 = w.l("TE", str, true);
                            if (!l10) {
                                l11 = w.l("Trailers", str, true);
                                if (!l11) {
                                    l12 = w.l("Transfer-Encoding", str, true);
                                    if (!l12) {
                                        l13 = w.l("Upgrade", str, true);
                                        if (!l13) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Response stripBody(Response response) {
            return (response == null ? null : response.body()) != null ? response.newBuilder().body(null).build() : response;
        }
    }

    public CacheInterceptor(Cache cache) {
        this.cache = cache;
    }

    private final Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) {
        if (cacheRequest == null) {
            return response;
        }
        Sink body = cacheRequest.body();
        ResponseBody body2 = response.body();
        l.b(body2);
        final BufferedSource source = body2.source();
        final BufferedSink buffer = Okio.buffer(body);
        Source source2 = new Source() { // from class: okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1
            private boolean cacheRequestClosed;

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                BufferedSource.this.close();
            }

            @Override // okio.Source
            public long read(Buffer buffer2, long j6) {
                l.d(buffer2, "sink");
                try {
                    long read = BufferedSource.this.read(buffer2, j6);
                    if (read != -1) {
                        buffer2.copyTo(buffer.getBuffer(), buffer2.size() - read, read);
                        buffer.emitCompleteSegments();
                        return read;
                    }
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        buffer.close();
                    }
                    return -1L;
                } catch (IOException e6) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e6;
                }
            }

            @Override // okio.Source
            public Timeout timeout() {
                return BufferedSource.this.timeout();
            }
        };
        return response.newBuilder().body(new RealResponseBody(Response.header$default(response, "Content-Type", null, 2, null), response.body().contentLength(), Okio.buffer(source2))).build();
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        ResponseBody body;
        ResponseBody body2;
        l.d(chain, "chain");
        Call call = chain.call();
        Cache cache = this.cache;
        Response response = cache == null ? null : cache.get$okhttp(chain.request());
        CacheStrategy compute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse = compute.getCacheResponse();
        Cache cache2 = this.cache;
        if (cache2 != null) {
            cache2.trackResponse$okhttp(compute);
        }
        RealCall realCall = call instanceof RealCall ? (RealCall) call : null;
        EventListener eventListener$okhttp = realCall != null ? realCall.getEventListener$okhttp() : null;
        if (eventListener$okhttp == null) {
            eventListener$okhttp = EventListener.NONE;
        }
        if (response != null && cacheResponse == null && (body2 = response.body()) != null) {
            Util.closeQuietly(body2);
        }
        if (networkRequest == null && cacheResponse == null) {
            Response build = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener$okhttp.satisfactionFailure(call, build);
            return build;
        } else if (networkRequest == null) {
            l.b(cacheResponse);
            Response build2 = cacheResponse.newBuilder().cacheResponse(Companion.stripBody(cacheResponse)).build();
            eventListener$okhttp.cacheHit(call, build2);
            return build2;
        } else {
            if (cacheResponse != null) {
                eventListener$okhttp.cacheConditionalHit(call, cacheResponse);
            } else if (this.cache != null) {
                eventListener$okhttp.cacheMiss(call);
            }
            try {
                Response proceed = chain.proceed(networkRequest);
                if (proceed == null && response != null && body != null) {
                }
                if (cacheResponse != null) {
                    boolean z5 = false;
                    if (proceed != null && proceed.code() == 304) {
                        z5 = true;
                    }
                    if (z5) {
                        Response.Builder newBuilder = cacheResponse.newBuilder();
                        Companion companion = Companion;
                        Response build3 = newBuilder.headers(companion.combine(cacheResponse.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(companion.stripBody(cacheResponse)).networkResponse(companion.stripBody(proceed)).build();
                        ResponseBody body3 = proceed.body();
                        l.b(body3);
                        body3.close();
                        Cache cache3 = this.cache;
                        l.b(cache3);
                        cache3.trackConditionalCacheHit$okhttp();
                        this.cache.update$okhttp(cacheResponse, build3);
                        eventListener$okhttp.cacheHit(call, build3);
                        return build3;
                    }
                    ResponseBody body4 = cacheResponse.body();
                    if (body4 != null) {
                        Util.closeQuietly(body4);
                    }
                }
                l.b(proceed);
                Response.Builder newBuilder2 = proceed.newBuilder();
                Companion companion2 = Companion;
                Response build4 = newBuilder2.cacheResponse(companion2.stripBody(cacheResponse)).networkResponse(companion2.stripBody(proceed)).build();
                if (this.cache != null) {
                    if (HttpHeaders.promisesBody(build4) && CacheStrategy.Companion.isCacheable(build4, networkRequest)) {
                        Response cacheWritingResponse = cacheWritingResponse(this.cache.put$okhttp(build4), build4);
                        if (cacheResponse != null) {
                            eventListener$okhttp.cacheMiss(call);
                        }
                        return cacheWritingResponse;
                    } else if (HttpMethod.INSTANCE.invalidatesCache(networkRequest.method())) {
                        try {
                            this.cache.remove$okhttp(networkRequest);
                        } catch (IOException unused) {
                        }
                    }
                }
                return build4;
            } finally {
                if (response != null && (body = response.body()) != null) {
                    Util.closeQuietly(body);
                }
            }
        }
    }
}
