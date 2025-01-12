package okhttp3.internal.http;

import h4.b;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.l;
import kotlin.text.w;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.BufferedSink;
import okio.Okio;
/* loaded from: classes.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z5) {
        this.forWebSocket = z5;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int i6) {
        if (i6 == 100) {
            return true;
        }
        return 102 <= i6 && i6 < 200;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x014d, code lost:
        if (r0 != false) goto L62;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00df A[Catch: IOException -> 0x019c, TryCatch #3 {IOException -> 0x019c, blocks: (B:40:0x00a8, B:42:0x00b1, B:43:0x00b5, B:45:0x00df, B:47:0x00e8, B:48:0x00eb, B:49:0x010f, B:53:0x011a, B:54:0x0124, B:56:0x0136, B:58:0x0144, B:65:0x015a, B:71:0x016d, B:75:0x0190, B:76:0x019a, B:74:0x0188, B:68:0x0163, B:60:0x014f, B:55:0x0129), top: B:90:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0144 A[Catch: IOException -> 0x019c, TryCatch #3 {IOException -> 0x019c, blocks: (B:40:0x00a8, B:42:0x00b1, B:43:0x00b5, B:45:0x00df, B:47:0x00e8, B:48:0x00eb, B:49:0x010f, B:53:0x011a, B:54:0x0124, B:56:0x0136, B:58:0x0144, B:65:0x015a, B:71:0x016d, B:75:0x0190, B:76:0x019a, B:74:0x0188, B:68:0x0163, B:60:0x014f, B:55:0x0129), top: B:90:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0163 A[Catch: IOException -> 0x019c, TryCatch #3 {IOException -> 0x019c, blocks: (B:40:0x00a8, B:42:0x00b1, B:43:0x00b5, B:45:0x00df, B:47:0x00e8, B:48:0x00eb, B:49:0x010f, B:53:0x011a, B:54:0x0124, B:56:0x0136, B:58:0x0144, B:65:0x015a, B:71:0x016d, B:75:0x0190, B:76:0x019a, B:74:0x0188, B:68:0x0163, B:60:0x014f, B:55:0x0129), top: B:90:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016d A[Catch: IOException -> 0x019c, TryCatch #3 {IOException -> 0x019c, blocks: (B:40:0x00a8, B:42:0x00b1, B:43:0x00b5, B:45:0x00df, B:47:0x00e8, B:48:0x00eb, B:49:0x010f, B:53:0x011a, B:54:0x0124, B:56:0x0136, B:58:0x0144, B:65:0x015a, B:71:0x016d, B:75:0x0190, B:76:0x019a, B:74:0x0188, B:68:0x0163, B:60:0x014f, B:55:0x0129), top: B:90:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) {
        Response.Builder builder;
        boolean z5;
        Response.Builder builder2;
        int code;
        Response build;
        boolean l6;
        ResponseBody body;
        boolean l7;
        boolean l8;
        Response.Builder builder3;
        l.d(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange$okhttp = realInterceptorChain.getExchange$okhttp();
        l.b(exchange$okhttp);
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RequestBody body2 = request$okhttp.body();
        long currentTimeMillis = System.currentTimeMillis();
        Long l9 = null;
        try {
            exchange$okhttp.writeRequestHeaders(request$okhttp);
            builder = HttpMethod.permitsRequestBody(request$okhttp.method());
        } catch (IOException e6) {
            e = e6;
            builder = null;
        }
        try {
            if (builder == 0 || body2 == null) {
                exchange$okhttp.noRequestBody();
                builder = 0;
                z5 = true;
            } else {
                l8 = w.l("100-continue", request$okhttp.header("Expect"), true);
                if (l8) {
                    exchange$okhttp.flushRequest();
                    builder = exchange$okhttp.readResponseHeaders(true);
                    try {
                        exchange$okhttp.responseHeadersStart();
                        z5 = false;
                        builder3 = builder;
                    } catch (IOException e7) {
                        e = e7;
                        z5 = true;
                        if (e instanceof ConnectionShutdownException) {
                            builder2 = builder;
                            if (!exchange$okhttp.getHasFailure$okhttp()) {
                                throw e;
                            }
                            if (builder2 == null) {
                            }
                            Response build2 = builder2.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
                            code = build2.code();
                            if (shouldIgnoreAndWaitForRealResponse(code)) {
                            }
                            exchange$okhttp.responseHeadersEnd(build2);
                            build = ((this.forWebSocket || code != 101) ? build2.newBuilder().body(exchange$okhttp.openResponseBody(build2)) : build2.newBuilder().body(Util.EMPTY_RESPONSE)).build();
                            l6 = w.l("close", build.request().header("Connection"), true);
                            if (!l6) {
                            }
                            exchange$okhttp.noNewExchangesOnConnection();
                            if (code != 204) {
                            }
                            body = build.body();
                            if ((body != null ? -1L : body.contentLength()) > 0) {
                            }
                            return build;
                        }
                        throw e;
                    }
                } else {
                    builder3 = null;
                    z5 = true;
                }
                if (builder3 != null) {
                    exchange$okhttp.noRequestBody();
                    builder = builder3;
                    if (!exchange$okhttp.getConnection$okhttp().isMultiplexed$okhttp()) {
                        exchange$okhttp.noNewExchangesOnConnection();
                        builder = builder3;
                    }
                } else if (body2.isDuplex()) {
                    exchange$okhttp.flushRequest();
                    body2.writeTo(Okio.buffer(exchange$okhttp.createRequestBody(request$okhttp, true)));
                    builder = builder3;
                } else {
                    BufferedSink buffer = Okio.buffer(exchange$okhttp.createRequestBody(request$okhttp, false));
                    body2.writeTo(buffer);
                    buffer.close();
                    builder = builder3;
                }
            }
            if (body2 == null || !body2.isDuplex()) {
                exchange$okhttp.finishRequest();
            }
            e = null;
            builder2 = builder;
        } catch (IOException e8) {
            e = e8;
            if (e instanceof ConnectionShutdownException) {
            }
        }
        if (builder2 == null) {
            try {
                builder2 = exchange$okhttp.readResponseHeaders(false);
                l.b(builder2);
                if (z5) {
                    exchange$okhttp.responseHeadersStart();
                    z5 = false;
                }
            } catch (IOException e9) {
                if (e != null) {
                    b.a(e, e9);
                    throw e;
                }
                throw e9;
            }
        }
        Response build22 = builder2.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        code = build22.code();
        if (shouldIgnoreAndWaitForRealResponse(code)) {
            Response.Builder readResponseHeaders = exchange$okhttp.readResponseHeaders(false);
            l.b(readResponseHeaders);
            if (z5) {
                exchange$okhttp.responseHeadersStart();
            }
            build22 = readResponseHeaders.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build22.code();
        }
        exchange$okhttp.responseHeadersEnd(build22);
        build = ((this.forWebSocket || code != 101) ? build22.newBuilder().body(exchange$okhttp.openResponseBody(build22)) : build22.newBuilder().body(Util.EMPTY_RESPONSE)).build();
        l6 = w.l("close", build.request().header("Connection"), true);
        if (!l6) {
            l7 = w.l("close", Response.header$default(build, "Connection", null, 2, null), true);
        }
        exchange$okhttp.noNewExchangesOnConnection();
        if (code != 204 || code == 205) {
            body = build.body();
            if ((body != null ? -1L : body.contentLength()) > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP ");
                sb.append(code);
                sb.append(" had non-zero Content-Length: ");
                ResponseBody body3 = build.body();
                if (body3 != null) {
                    l9 = Long.valueOf(body3.contentLength());
                }
                sb.append(l9);
                throw new ProtocolException(sb.toString());
            }
        }
        return build;
    }
}
