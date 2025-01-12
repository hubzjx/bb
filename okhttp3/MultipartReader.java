package okhttp3;

import java.io.Closeable;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.http1.HeadersReader;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.Source;
import okio.Timeout;
/* loaded from: classes.dex */
public final class MultipartReader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Options afterBoundaryOptions;
    private final String boundary;
    private boolean closed;
    private final ByteString crlfDashDashBoundary;
    private PartSource currentPart;
    private final ByteString dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final BufferedSource source;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Options getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }
    }

    /* loaded from: classes.dex */
    public static final class Part implements Closeable {
        private final BufferedSource body;
        private final Headers headers;

        public Part(Headers headers, BufferedSource bufferedSource) {
            l.d(headers, "headers");
            l.d(bufferedSource, "body");
            this.headers = headers;
            this.body = bufferedSource;
        }

        public final BufferedSource body() {
            return this.body;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.body.close();
        }

        public final Headers headers() {
            return this.headers;
        }
    }

    /* loaded from: classes.dex */
    private final class PartSource implements Source {
        final /* synthetic */ MultipartReader this$0;
        private final Timeout timeout;

        public PartSource(MultipartReader multipartReader) {
            l.d(multipartReader, "this$0");
            this.this$0 = multipartReader;
            this.timeout = new Timeout();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (l.a(this.this$0.currentPart, this)) {
                this.this$0.currentPart = null;
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j6) {
            l.d(buffer, "sink");
            if (j6 >= 0) {
                if (l.a(this.this$0.currentPart, this)) {
                    Timeout timeout = this.this$0.source.timeout();
                    Timeout timeout2 = this.timeout;
                    MultipartReader multipartReader = this.this$0;
                    long timeoutNanos = timeout.timeoutNanos();
                    long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    timeout.timeout(minTimeout, timeUnit);
                    if (!timeout.hasDeadline()) {
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                        }
                        try {
                            long currentPartBytesRemaining = multipartReader.currentPartBytesRemaining(j6);
                            long read = currentPartBytesRemaining == 0 ? -1L : multipartReader.source.read(buffer, currentPartBytesRemaining);
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.hasDeadline()) {
                                timeout.clearDeadline();
                            }
                            return read;
                        } catch (Throwable th) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.clearDeadline();
                            }
                            throw th;
                        }
                    }
                    long deadlineNanoTime = timeout.deadlineNanoTime();
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                    }
                    try {
                        long currentPartBytesRemaining2 = multipartReader.currentPartBytesRemaining(j6);
                        long read2 = currentPartBytesRemaining2 == 0 ? -1L : multipartReader.source.read(buffer, currentPartBytesRemaining2);
                        timeout.timeout(timeoutNanos, timeUnit);
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(deadlineNanoTime);
                        }
                        return read2;
                    } catch (Throwable th2) {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(deadlineNanoTime);
                        }
                        throw th2;
                    }
                }
                throw new IllegalStateException("closed".toString());
            }
            throw new IllegalArgumentException(l.i("byteCount < 0: ", Long.valueOf(j6)).toString());
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    static {
        Options.Companion companion = Options.Companion;
        ByteString.Companion companion2 = ByteString.Companion;
        afterBoundaryOptions = companion.of(companion2.encodeUtf8("\r\n"), companion2.encodeUtf8("--"), companion2.encodeUtf8(" "), companion2.encodeUtf8("\t"));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MultipartReader(ResponseBody responseBody) {
        this(r0, r3);
        l.d(responseBody, "response");
        BufferedSource source = responseBody.source();
        MediaType contentType = responseBody.contentType();
        String parameter = contentType == null ? null : contentType.parameter("boundary");
        if (parameter == null) {
            throw new ProtocolException("expected the Content-Type to have a boundary parameter");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentPartBytesRemaining(long j6) {
        this.source.require(this.crlfDashDashBoundary.size());
        long indexOf = this.source.getBuffer().indexOf(this.crlfDashDashBoundary);
        if (indexOf == -1) {
            indexOf = (this.source.getBuffer().size() - this.crlfDashDashBoundary.size()) + 1;
        }
        return Math.min(j6, indexOf);
    }

    public final String boundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    public final Part nextPart() {
        BufferedSource bufferedSource;
        ByteString byteString;
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.noMoreParts) {
            return null;
        }
        if (this.partCount == 0 && this.source.rangeEquals(0L, this.dashDashBoundary)) {
            bufferedSource = this.source;
            byteString = this.dashDashBoundary;
        } else {
            while (true) {
                long currentPartBytesRemaining = currentPartBytesRemaining(8192L);
                if (currentPartBytesRemaining == 0) {
                    break;
                }
                this.source.skip(currentPartBytesRemaining);
            }
            bufferedSource = this.source;
            byteString = this.crlfDashDashBoundary;
        }
        bufferedSource.skip(byteString.size());
        boolean z5 = false;
        while (true) {
            int select = this.source.select(afterBoundaryOptions);
            if (select == -1) {
                throw new ProtocolException("unexpected characters after boundary");
            }
            if (select == 0) {
                this.partCount++;
                Headers readHeaders = new HeadersReader(this.source).readHeaders();
                PartSource partSource = new PartSource(this);
                this.currentPart = partSource;
                return new Part(readHeaders, Okio.buffer(partSource));
            } else if (select == 1) {
                if (z5) {
                    throw new ProtocolException("unexpected characters after boundary");
                }
                if (this.partCount != 0) {
                    this.noMoreParts = true;
                    return null;
                }
                throw new ProtocolException("expected at least 1 part");
            } else if (select == 2 || select == 3) {
                z5 = true;
            }
        }
    }

    public MultipartReader(BufferedSource bufferedSource, String str) {
        l.d(bufferedSource, "source");
        l.d(str, "boundary");
        this.source = bufferedSource;
        this.boundary = str;
        this.dashDashBoundary = new Buffer().writeUtf8("--").writeUtf8(str).readByteString();
        this.crlfDashDashBoundary = new Buffer().writeUtf8("\r\n--").writeUtf8(str).readByteString();
    }
}
