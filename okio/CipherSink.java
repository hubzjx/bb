package okio;

import javax.crypto.Cipher;
/* loaded from: classes.dex */
public final class CipherSink implements Sink {
    private final int blockSize;
    private final Cipher cipher;
    private boolean closed;
    private final BufferedSink sink;

    public CipherSink(BufferedSink bufferedSink, Cipher cipher) {
        kotlin.jvm.internal.l.d(bufferedSink, "sink");
        kotlin.jvm.internal.l.d(cipher, "cipher");
        this.sink = bufferedSink;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.blockSize = blockSize;
        if (blockSize > 0) {
            return;
        }
        throw new IllegalArgumentException(("Block cipher required " + cipher).toString());
    }

    private final Throwable doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        Throwable th = null;
        if (outputSize == 0) {
            return null;
        }
        if (outputSize > 8192) {
            try {
                BufferedSink bufferedSink = this.sink;
                byte[] doFinal = this.cipher.doFinal();
                kotlin.jvm.internal.l.c(doFinal, "cipher.doFinal()");
                bufferedSink.write(doFinal);
                return null;
            } catch (Throwable th2) {
                return th2;
            }
        }
        Buffer buffer = this.sink.getBuffer();
        Segment writableSegment$okio = buffer.writableSegment$okio(outputSize);
        try {
            int doFinal2 = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.limit);
            writableSegment$okio.limit += doFinal2;
            buffer.setSize$okio(buffer.size() + doFinal2);
        } catch (Throwable th3) {
            th = th3;
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
        return th;
    }

    private final int update(Buffer buffer, long j6) {
        Segment segment = buffer.head;
        kotlin.jvm.internal.l.b(segment);
        int min = (int) Math.min(j6, segment.limit - segment.pos);
        Buffer buffer2 = this.sink.getBuffer();
        while (true) {
            int outputSize = this.cipher.getOutputSize(min);
            if (outputSize <= 8192) {
                Segment writableSegment$okio = buffer2.writableSegment$okio(outputSize);
                int update = this.cipher.update(segment.data, segment.pos, min, writableSegment$okio.data, writableSegment$okio.limit);
                writableSegment$okio.limit += update;
                buffer2.setSize$okio(buffer2.size() + update);
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    buffer2.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                this.sink.emitCompleteSegments();
                buffer.setSize$okio(buffer.size() - min);
                int i6 = segment.pos + min;
                segment.pos = i6;
                if (i6 == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return min;
            }
            int i7 = this.blockSize;
            if (min <= i7) {
                BufferedSink bufferedSink = this.sink;
                byte[] update2 = this.cipher.update(buffer.readByteArray(j6));
                kotlin.jvm.internal.l.c(update2, "cipher.update(source.readByteArray(remaining))");
                bufferedSink.write(update2);
                return (int) j6;
            }
            min -= i7;
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        Throwable doFinal = doFinal();
        try {
            this.sink.close();
        } catch (Throwable th) {
            if (doFinal == null) {
                doFinal = th;
            }
        }
        if (doFinal != null) {
            throw doFinal;
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.sink.flush();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "source");
        _UtilKt.checkOffsetAndCount(buffer.size(), 0L, j6);
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j6 > 0) {
            j6 -= update(buffer, j6);
        }
    }
}
