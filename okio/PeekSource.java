package okio;
/* loaded from: classes.dex */
public final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource bufferedSource) {
        kotlin.jvm.internal.l.d(bufferedSource, "upstream");
        this.upstream = bufferedSource;
        Buffer buffer = bufferedSource.getBuffer();
        this.buffer = buffer;
        Segment segment = buffer.head;
        this.expectedSegment = segment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (r5 == r6.pos) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    @Override // okio.Source
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long read(Buffer buffer, long j6) {
        Segment segment;
        kotlin.jvm.internal.l.d(buffer, "sink");
        boolean z5 = false;
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        } else if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else {
            Segment segment2 = this.expectedSegment;
            if (segment2 != null) {
                Segment segment3 = this.buffer.head;
                if (segment2 == segment3) {
                    int i7 = this.expectedPos;
                    kotlin.jvm.internal.l.b(segment3);
                }
                if (z5) {
                    throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
                }
                if (i6 == 0) {
                    return 0L;
                }
                if (this.upstream.request(this.pos + 1)) {
                    if (this.expectedSegment == null && (segment = this.buffer.head) != null) {
                        this.expectedSegment = segment;
                        kotlin.jvm.internal.l.b(segment);
                        this.expectedPos = segment.pos;
                    }
                    long min = Math.min(j6, this.buffer.size() - this.pos);
                    this.buffer.copyTo(buffer, this.pos, min);
                    this.pos += min;
                    return min;
                }
                return -1L;
            }
            z5 = true;
            if (z5) {
            }
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.upstream.timeout();
    }
}
