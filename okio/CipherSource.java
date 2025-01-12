package okio;

import javax.crypto.Cipher;
/* loaded from: classes.dex */
public final class CipherSource implements Source {
    private final int blockSize;
    private final Buffer buffer;
    private final Cipher cipher;
    private boolean closed;

    /* renamed from: final  reason: not valid java name */
    private boolean f0final;
    private final BufferedSource source;

    public CipherSource(BufferedSource bufferedSource, Cipher cipher) {
        kotlin.jvm.internal.l.d(bufferedSource, "source");
        kotlin.jvm.internal.l.d(cipher, "cipher");
        this.source = bufferedSource;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.blockSize = blockSize;
        this.buffer = new Buffer();
        if (blockSize > 0) {
            return;
        }
        throw new IllegalArgumentException(("Block cipher required " + cipher).toString());
    }

    private final void doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize == 0) {
            return;
        }
        Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int doFinal = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.pos);
        writableSegment$okio.limit += doFinal;
        Buffer buffer = this.buffer;
        buffer.setSize$okio(buffer.size() + doFinal);
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            this.buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    private final void refill() {
        while (this.buffer.size() == 0 && !this.f0final) {
            if (this.source.exhausted()) {
                this.f0final = true;
                doFinal();
                return;
            }
            update();
        }
    }

    private final void update() {
        Segment segment = this.source.getBuffer().head;
        kotlin.jvm.internal.l.b(segment);
        int i6 = segment.limit;
        int i7 = segment.pos;
        do {
            i6 -= i7;
            int outputSize = this.cipher.getOutputSize(i6);
            if (outputSize <= 8192) {
                Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
                int update = this.cipher.update(segment.data, segment.pos, i6, writableSegment$okio.data, writableSegment$okio.pos);
                this.source.skip(i6);
                writableSegment$okio.limit += update;
                Buffer buffer = this.buffer;
                buffer.setSize$okio(buffer.size() + update);
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    this.buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                    return;
                }
                return;
            }
            i7 = this.blockSize;
        } while (i6 > i7);
        this.f0final = true;
        Buffer buffer2 = this.buffer;
        byte[] doFinal = this.cipher.doFinal(this.source.readByteArray());
        kotlin.jvm.internal.l.c(doFinal, "cipher.doFinal(source.readByteArray())");
        buffer2.write(doFinal);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        this.source.close();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "sink");
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        } else if (true ^ this.closed) {
            if (i6 == 0) {
                return 0L;
            }
            refill();
            return this.buffer.read(buffer, j6);
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }
}
