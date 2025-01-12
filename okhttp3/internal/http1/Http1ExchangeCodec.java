package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.text.w;
import kotlin.text.x;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;
/* loaded from: classes.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {
    public static final Companion Companion = new Companion(null);
    private static final long NO_CHUNK_YET = -1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final OkHttpClient client;
    private final RealConnection connection;
    private final HeadersReader headersReader;
    private final BufferedSink sink;
    private final BufferedSource source;
    private int state;
    private Headers trailers;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class AbstractSource implements Source {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final ForwardingTimeout timeout;

        public AbstractSource(Http1ExchangeCodec http1ExchangeCodec) {
            l.d(http1ExchangeCodec, "this$0");
            this.this$0 = http1ExchangeCodec;
            this.timeout = new ForwardingTimeout(http1ExchangeCodec.source.timeout());
        }

        protected final boolean getClosed() {
            return this.closed;
        }

        protected final ForwardingTimeout getTimeout() {
            return this.timeout;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j6) {
            l.d(buffer, "sink");
            try {
                return this.this$0.source.read(buffer, j6);
            } catch (IOException e6) {
                this.this$0.getConnection().noNewExchanges$okhttp();
                responseBodyComplete();
                throw e6;
            }
        }

        public final void responseBodyComplete() {
            if (this.this$0.state == 6) {
                return;
            }
            if (this.this$0.state != 5) {
                throw new IllegalStateException(l.i("state: ", Integer.valueOf(this.this$0.state)));
            }
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 6;
        }

        protected final void setClosed(boolean z5) {
            this.closed = z5;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class ChunkedSink implements Sink {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final ForwardingTimeout timeout;

        public ChunkedSink(Http1ExchangeCodec http1ExchangeCodec) {
            l.d(http1ExchangeCodec, "this$0");
            this.this$0 = http1ExchangeCodec;
            this.timeout = new ForwardingTimeout(http1ExchangeCodec.sink.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.this$0.sink.writeUtf8("0\r\n\r\n");
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            this.this$0.sink.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j6) {
            l.d(buffer, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j6 == 0) {
                return;
            }
            this.this$0.sink.writeHexadecimalUnsignedLong(j6);
            this.this$0.sink.writeUtf8("\r\n");
            this.this$0.sink.write(buffer, j6);
            this.this$0.sink.writeUtf8("\r\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final HttpUrl url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl) {
            super(http1ExchangeCodec);
            l.d(http1ExchangeCodec, "this$0");
            l.d(httpUrl, "url");
            this.this$0 = http1ExchangeCodec;
            this.url = httpUrl;
            this.bytesRemainingInChunk = Http1ExchangeCodec.NO_CHUNK_YET;
            this.hasMoreChunks = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
            if (r1 != false) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void readChunkSize() {
            CharSequence v02;
            boolean y5;
            if (this.bytesRemainingInChunk != Http1ExchangeCodec.NO_CHUNK_YET) {
                this.this$0.source.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = this.this$0.source.readHexadecimalUnsignedLong();
                v02 = x.v0(this.this$0.source.readUtf8LineStrict());
                String obj = v02.toString();
                if (this.bytesRemainingInChunk >= 0) {
                    if (obj.length() > 0) {
                        y5 = w.y(obj, ";", false, 2, null);
                    }
                    if (this.bytesRemainingInChunk == 0) {
                        this.hasMoreChunks = false;
                        Http1ExchangeCodec http1ExchangeCodec = this.this$0;
                        http1ExchangeCodec.trailers = http1ExchangeCodec.headersReader.readHeaders();
                        OkHttpClient okHttpClient = this.this$0.client;
                        l.b(okHttpClient);
                        CookieJar cookieJar = okHttpClient.cookieJar();
                        HttpUrl httpUrl = this.url;
                        Headers headers = this.this$0.trailers;
                        l.b(headers);
                        HttpHeaders.receiveHeaders(cookieJar, httpUrl, headers);
                        responseBodyComplete();
                        return;
                    }
                    return;
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + obj + '\"');
            } catch (NumberFormatException e6) {
                throw new ProtocolException(e6.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getConnection().noNewExchanges$okhttp();
                responseBodyComplete();
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(Buffer buffer, long j6) {
            l.d(buffer, "sink");
            if (j6 >= 0) {
                if (true ^ getClosed()) {
                    if (this.hasMoreChunks) {
                        long j7 = this.bytesRemainingInChunk;
                        if (j7 == 0 || j7 == Http1ExchangeCodec.NO_CHUNK_YET) {
                            readChunkSize();
                            if (!this.hasMoreChunks) {
                                return Http1ExchangeCodec.NO_CHUNK_YET;
                            }
                        }
                        long read = super.read(buffer, Math.min(j6, this.bytesRemainingInChunk));
                        if (read != Http1ExchangeCodec.NO_CHUNK_YET) {
                            this.bytesRemainingInChunk -= read;
                            return read;
                        }
                        this.this$0.getConnection().noNewExchanges$okhttp();
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        responseBodyComplete();
                        throw protocolException;
                    }
                    return Http1ExchangeCodec.NO_CHUNK_YET;
                }
                throw new IllegalStateException("closed".toString());
            }
            throw new IllegalArgumentException(l.i("byteCount < 0: ", Long.valueOf(j6)).toString());
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FixedLengthSource(Http1ExchangeCodec http1ExchangeCodec, long j6) {
            super(http1ExchangeCodec);
            l.d(http1ExchangeCodec, "this$0");
            this.this$0 = http1ExchangeCodec;
            this.bytesRemaining = j6;
            if (j6 == 0) {
                responseBodyComplete();
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getConnection().noNewExchanges$okhttp();
                responseBodyComplete();
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(Buffer buffer, long j6) {
            l.d(buffer, "sink");
            if (j6 >= 0) {
                if (true ^ getClosed()) {
                    long j7 = this.bytesRemaining;
                    if (j7 == 0) {
                        return Http1ExchangeCodec.NO_CHUNK_YET;
                    }
                    long read = super.read(buffer, Math.min(j7, j6));
                    if (read == Http1ExchangeCodec.NO_CHUNK_YET) {
                        this.this$0.getConnection().noNewExchanges$okhttp();
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        responseBodyComplete();
                        throw protocolException;
                    }
                    long j8 = this.bytesRemaining - read;
                    this.bytesRemaining = j8;
                    if (j8 == 0) {
                        responseBodyComplete();
                    }
                    return read;
                }
                throw new IllegalStateException("closed".toString());
            }
            throw new IllegalArgumentException(l.i("byteCount < 0: ", Long.valueOf(j6)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class KnownLengthSink implements Sink {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final ForwardingTimeout timeout;

        public KnownLengthSink(Http1ExchangeCodec http1ExchangeCodec) {
            l.d(http1ExchangeCodec, "this$0");
            this.this$0 = http1ExchangeCodec;
            this.timeout = new ForwardingTimeout(http1ExchangeCodec.sink.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.closed) {
                return;
            }
            this.this$0.sink.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j6) {
            l.d(buffer, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Util.checkOffsetAndCount(buffer.size(), 0L, j6);
            this.this$0.sink.write(buffer, j6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownLengthSource(Http1ExchangeCodec http1ExchangeCodec) {
            super(http1ExchangeCodec);
            l.d(http1ExchangeCodec, "this$0");
            this.this$0 = http1ExchangeCodec;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                responseBodyComplete();
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(Buffer buffer, long j6) {
            l.d(buffer, "sink");
            if (j6 >= 0) {
                if (!getClosed()) {
                    if (this.inputExhausted) {
                        return Http1ExchangeCodec.NO_CHUNK_YET;
                    }
                    long read = super.read(buffer, j6);
                    if (read == Http1ExchangeCodec.NO_CHUNK_YET) {
                        this.inputExhausted = true;
                        responseBodyComplete();
                        return Http1ExchangeCodec.NO_CHUNK_YET;
                    }
                    return read;
                }
                throw new IllegalStateException("closed".toString());
            }
            throw new IllegalArgumentException(l.i("byteCount < 0: ", Long.valueOf(j6)).toString());
        }
    }

    public Http1ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        l.d(realConnection, "connection");
        l.d(bufferedSource, "source");
        l.d(bufferedSink, "sink");
        this.client = okHttpClient;
        this.connection = realConnection;
        this.source = bufferedSource;
        this.sink = bufferedSink;
        this.headersReader = new HeadersReader(bufferedSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    private final boolean isChunked(Request request) {
        boolean l6;
        l6 = w.l("chunked", request.header("Transfer-Encoding"), true);
        return l6;
    }

    private final Sink newChunkedSink() {
        int i6 = this.state;
        if (i6 == 1) {
            this.state = 2;
            return new ChunkedSink(this);
        }
        throw new IllegalStateException(l.i("state: ", Integer.valueOf(i6)).toString());
    }

    private final Source newChunkedSource(HttpUrl httpUrl) {
        int i6 = this.state;
        if (i6 == 4) {
            this.state = 5;
            return new ChunkedSource(this, httpUrl);
        }
        throw new IllegalStateException(l.i("state: ", Integer.valueOf(i6)).toString());
    }

    private final Source newFixedLengthSource(long j6) {
        int i6 = this.state;
        if (i6 == 4) {
            this.state = 5;
            return new FixedLengthSource(this, j6);
        }
        throw new IllegalStateException(l.i("state: ", Integer.valueOf(i6)).toString());
    }

    private final Sink newKnownLengthSink() {
        int i6 = this.state;
        if (i6 == 1) {
            this.state = 2;
            return new KnownLengthSink(this);
        }
        throw new IllegalStateException(l.i("state: ", Integer.valueOf(i6)).toString());
    }

    private final Source newUnknownLengthSource() {
        int i6 = this.state;
        if (i6 == 4) {
            this.state = 5;
            getConnection().noNewExchanges$okhttp();
            return new UnknownLengthSource(this);
        }
        throw new IllegalStateException(l.i("state: ", Integer.valueOf(i6)).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        getConnection().cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink createRequestBody(Request request, long j6) {
        l.d(request, "request");
        if (request.body() == null || !request.body().isDuplex()) {
            if (isChunked(request)) {
                return newChunkedSink();
            }
            if (j6 != NO_CHUNK_YET) {
                return newKnownLengthSink();
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        throw new ProtocolException("Duplex connections are not supported for HTTP/1");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection getConnection() {
        return this.connection;
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source openResponseBodySource(Response response) {
        long headersContentLength;
        l.d(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            headersContentLength = 0;
        } else if (isChunked(response)) {
            return newChunkedSource(response.request().url());
        } else {
            headersContentLength = Util.headersContentLength(response);
            if (headersContentLength == NO_CHUNK_YET) {
                return newUnknownLengthSource();
            }
        }
        return newFixedLengthSource(headersContentLength);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean z5) {
        int i6 = this.state;
        boolean z6 = false;
        if (i6 == 1 || i6 == 2 || i6 == 3) {
            try {
                StatusLine parse = StatusLine.Companion.parse(this.headersReader.readLine());
                Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(this.headersReader.readHeaders());
                if (z5 && parse.code == 100) {
                    return null;
                }
                int i7 = parse.code;
                if (i7 != 100) {
                    if (102 <= i7 && i7 < 200) {
                        z6 = true;
                    }
                    if (!z6) {
                        this.state = 4;
                        return headers;
                    }
                }
                this.state = 3;
                return headers;
            } catch (EOFException e6) {
                throw new IOException(l.i("unexpected end of stream on ", getConnection().route().address().url().redact()), e6);
            }
        }
        throw new IllegalStateException(l.i("state: ", Integer.valueOf(i6)).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response response) {
        l.d(response, "response");
        if (HttpHeaders.promisesBody(response)) {
            return isChunked(response) ? NO_CHUNK_YET : Util.headersContentLength(response);
        }
        return 0L;
    }

    public final void skipConnectBody(Response response) {
        l.d(response, "response");
        long headersContentLength = Util.headersContentLength(response);
        if (headersContentLength == NO_CHUNK_YET) {
            return;
        }
        Source newFixedLengthSource = newFixedLengthSource(headersContentLength);
        Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        newFixedLengthSource.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Headers trailers() {
        if (this.state == 6) {
            Headers headers = this.trailers;
            return headers == null ? Util.EMPTY_HEADERS : headers;
        }
        throw new IllegalStateException("too early; can't read the trailers yet".toString());
    }

    public final void writeRequest(Headers headers, String str) {
        l.d(headers, "headers");
        l.d(str, "requestLine");
        int i6 = this.state;
        if (!(i6 == 0)) {
            throw new IllegalStateException(l.i("state: ", Integer.valueOf(i6)).toString());
        }
        this.sink.writeUtf8(str).writeUtf8("\r\n");
        int size = headers.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.sink.writeUtf8(headers.name(i7)).writeUtf8(": ").writeUtf8(headers.value(i7)).writeUtf8("\r\n");
        }
        this.sink.writeUtf8("\r\n");
        this.state = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request request) {
        l.d(request, "request");
        RequestLine requestLine = RequestLine.INSTANCE;
        Proxy.Type type = getConnection().route().proxy().type();
        l.c(type, "connection.route().proxy.type()");
        writeRequest(request.headers(), requestLine.get(request, type));
    }

    private final boolean isChunked(Response response) {
        boolean l6;
        l6 = w.l("chunked", Response.header$default(response, "Transfer-Encoding", null, 2, null), true);
        return l6;
    }
}
