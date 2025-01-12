package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.l;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
/* loaded from: classes.dex */
public final class Exchange {
    private final RealCall call;
    private final ExchangeCodec codec;
    private final RealConnection connection;
    private final EventListener eventListener;
    private final ExchangeFinder finder;
    private boolean hasFailure;
    private boolean isDuplex;

    /* loaded from: classes.dex */
    private final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(Exchange exchange, Sink sink, long j6) {
            super(sink);
            l.d(exchange, "this$0");
            l.d(sink, "delegate");
            this.this$0 = exchange;
            this.contentLength = j6;
        }

        private final <E extends IOException> E complete(E e6) {
            if (this.completed) {
                return e6;
            }
            this.completed = true;
            return (E) this.this$0.bodyComplete(this.bytesReceived, false, true, e6);
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j6 = this.contentLength;
            if (j6 != -1 && this.bytesReceived != j6) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete(null);
            } catch (IOException e6) {
                throw complete(e6);
            }
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public void flush() {
            try {
                super.flush();
            } catch (IOException e6) {
                throw complete(e6);
            }
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j6) {
            l.d(buffer, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            long j7 = this.contentLength;
            if (j7 == -1 || this.bytesReceived + j6 <= j7) {
                try {
                    super.write(buffer, j6);
                    this.bytesReceived += j6;
                    return;
                } catch (IOException e6) {
                    throw complete(e6);
                }
            }
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j6));
        }
    }

    /* loaded from: classes.dex */
    public final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(Exchange exchange, Source source, long j6) {
            super(source);
            l.d(exchange, "this$0");
            l.d(source, "delegate");
            this.this$0 = exchange;
            this.contentLength = j6;
            this.invokeStartEvent = true;
            if (j6 == 0) {
                complete(null);
            }
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e6) {
                throw complete(e6);
            }
        }

        public final <E extends IOException> E complete(E e6) {
            if (this.completed) {
                return e6;
            }
            this.completed = true;
            if (e6 == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
            }
            return (E) this.this$0.bodyComplete(this.bytesReceived, true, false, e6);
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j6) {
            l.d(buffer, "sink");
            if (!this.closed) {
                try {
                    long read = delegate().read(buffer, j6);
                    if (this.invokeStartEvent) {
                        this.invokeStartEvent = false;
                        this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
                    }
                    if (read == -1) {
                        complete(null);
                        return -1L;
                    }
                    long j7 = this.bytesReceived + read;
                    long j8 = this.contentLength;
                    if (j8 != -1 && j7 > j8) {
                        throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j7);
                    }
                    this.bytesReceived = j7;
                    if (j7 == j8) {
                        complete(null);
                    }
                    return read;
                } catch (IOException e6) {
                    throw complete(e6);
                }
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    public Exchange(RealCall realCall, EventListener eventListener, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        l.d(realCall, "call");
        l.d(eventListener, "eventListener");
        l.d(exchangeFinder, "finder");
        l.d(exchangeCodec, "codec");
        this.call = realCall;
        this.eventListener = eventListener;
        this.finder = exchangeFinder;
        this.codec = exchangeCodec;
        this.connection = exchangeCodec.getConnection();
    }

    private final void trackFailure(IOException iOException) {
        this.hasFailure = true;
        this.finder.trackFailure(iOException);
        this.codec.getConnection().trackFailure$okhttp(this.call, iOException);
    }

    public final <E extends IOException> E bodyComplete(long j6, boolean z5, boolean z6, E e6) {
        if (e6 != null) {
            trackFailure(e6);
        }
        if (z6) {
            EventListener eventListener = this.eventListener;
            RealCall realCall = this.call;
            if (e6 != null) {
                eventListener.requestFailed(realCall, e6);
            } else {
                eventListener.requestBodyEnd(realCall, j6);
            }
        }
        if (z5) {
            if (e6 != null) {
                this.eventListener.responseFailed(this.call, e6);
            } else {
                this.eventListener.responseBodyEnd(this.call, j6);
            }
        }
        return (E) this.call.messageDone$okhttp(this, z6, z5, e6);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final Sink createRequestBody(Request request, boolean z5) {
        l.d(request, "request");
        this.isDuplex = z5;
        RequestBody body = request.body();
        l.b(body);
        long contentLength = body.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(request, contentLength), contentLength);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() {
        try {
            this.codec.finishRequest();
        } catch (IOException e6) {
            this.eventListener.requestFailed(this.call, e6);
            trackFailure(e6);
            throw e6;
        }
    }

    public final void flushRequest() {
        try {
            this.codec.flushRequest();
        } catch (IOException e6) {
            this.eventListener.requestFailed(this.call, e6);
            trackFailure(e6);
            throw e6;
        }
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final RealConnection getConnection$okhttp() {
        return this.connection;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean getHasFailure$okhttp() {
        return this.hasFailure;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !l.a(this.finder.getAddress$okhttp().url().host(), this.connection.route().address().url().host());
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final RealWebSocket.Streams newWebSocketStreams() {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    public final ResponseBody openResponseBody(Response response) {
        l.d(response, "response");
        try {
            String header$default = Response.header$default(response, "Content-Type", null, 2, null);
            long reportedContentLength = this.codec.reportedContentLength(response);
            return new RealResponseBody(header$default, reportedContentLength, Okio.buffer(new ResponseBodySource(this, this.codec.openResponseBodySource(response), reportedContentLength)));
        } catch (IOException e6) {
            this.eventListener.responseFailed(this.call, e6);
            trackFailure(e6);
            throw e6;
        }
    }

    public final Response.Builder readResponseHeaders(boolean z5) {
        try {
            Response.Builder readResponseHeaders = this.codec.readResponseHeaders(z5);
            if (readResponseHeaders != null) {
                readResponseHeaders.initExchange$okhttp(this);
            }
            return readResponseHeaders;
        } catch (IOException e6) {
            this.eventListener.responseFailed(this.call, e6);
            trackFailure(e6);
            throw e6;
        }
    }

    public final void responseHeadersEnd(Response response) {
        l.d(response, "response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final Headers trailers() {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1L, true, true, null);
    }

    public final void writeRequestHeaders(Request request) {
        l.d(request, "request");
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e6) {
            this.eventListener.requestFailed(this.call, e6);
            trackFailure(e6);
            throw e6;
        }
    }
}
