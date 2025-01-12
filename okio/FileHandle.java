package okio;

import java.io.Closeable;
/* loaded from: classes.dex */
public abstract class FileHandle implements Closeable {
    private boolean closed;
    private int openStreamCount;
    private final boolean readWrite;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class FileHandleSink implements Sink {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSink(FileHandle fileHandle, long j6) {
            kotlin.jvm.internal.l.d(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j6;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            synchronized (this.fileHandle) {
                FileHandle fileHandle = this.fileHandle;
                fileHandle.openStreamCount--;
                if (this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    h4.q qVar = h4.q.f10774a;
                    this.fileHandle.protectedClose();
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.fileHandle.protectedFlush();
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setClosed(boolean z5) {
            this.closed = z5;
        }

        public final void setPosition(long j6) {
            this.position = j6;
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j6) {
            kotlin.jvm.internal.l.d(buffer, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.fileHandle.writeNoCloseCheck(this.position, buffer, j6);
            this.position += j6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class FileHandleSource implements Source {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSource(FileHandle fileHandle, long j6) {
            kotlin.jvm.internal.l.d(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j6;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            synchronized (this.fileHandle) {
                FileHandle fileHandle = this.fileHandle;
                fileHandle.openStreamCount--;
                if (this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    h4.q qVar = h4.q.f10774a;
                    this.fileHandle.protectedClose();
                }
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j6) {
            kotlin.jvm.internal.l.d(buffer, "sink");
            if (!this.closed) {
                long readNoCloseCheck = this.fileHandle.readNoCloseCheck(this.position, buffer, j6);
                if (readNoCloseCheck != -1) {
                    this.position += readNoCloseCheck;
                }
                return readNoCloseCheck;
            }
            throw new IllegalStateException("closed".toString());
        }

        public final void setClosed(boolean z5) {
            this.closed = z5;
        }

        public final void setPosition(long j6) {
            this.position = j6;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return Timeout.NONE;
        }
    }

    public FileHandle(boolean z5) {
        this.readWrite = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long readNoCloseCheck(long j6, Buffer buffer, long j7) {
        int i6;
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        long j8 = j6 + j7;
        long j9 = j6;
        while (true) {
            if (j9 >= j8) {
                break;
            }
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int protectedRead = protectedRead(j9, writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j8 - j9, 8192 - i6));
            if (protectedRead == -1) {
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                if (j6 == j9) {
                    return -1L;
                }
            } else {
                writableSegment$okio.limit += protectedRead;
                long j10 = protectedRead;
                j9 += j10;
                buffer.setSize$okio(buffer.size() + j10);
            }
        }
        return j9 - j6;
    }

    public static /* synthetic */ Sink sink$default(FileHandle fileHandle, long j6, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 1) != 0) {
                j6 = 0;
            }
            return fileHandle.sink(j6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    public static /* synthetic */ Source source$default(FileHandle fileHandle, long j6, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 1) != 0) {
                j6 = 0;
            }
            return fileHandle.source(j6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeNoCloseCheck(long j6, Buffer buffer, long j7) {
        _UtilKt.checkOffsetAndCount(buffer.size(), 0L, j7);
        long j8 = j7 + j6;
        while (j6 < j8) {
            Segment segment = buffer.head;
            kotlin.jvm.internal.l.b(segment);
            int min = (int) Math.min(j8 - j6, segment.limit - segment.pos);
            protectedWrite(j6, segment.data, segment.pos, min);
            segment.pos += min;
            long j9 = min;
            j6 += j9;
            buffer.setSize$okio(buffer.size() - j9);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public final Sink appendingSink() {
        return sink(size());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.openStreamCount != 0) {
                return;
            }
            h4.q qVar = h4.q.f10774a;
            protectedClose();
        }
    }

    public final void flush() {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            h4.q qVar = h4.q.f10774a;
        }
        protectedFlush();
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final long position(Sink sink) {
        long j6;
        kotlin.jvm.internal.l.d(sink, "sink");
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            j6 = realBufferedSink.bufferField.size();
            sink = realBufferedSink.sink;
        } else {
            j6 = 0;
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
            FileHandleSink fileHandleSink = (FileHandleSink) sink;
            if (!fileHandleSink.getClosed()) {
                return fileHandleSink.getPosition() + j6;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    }

    protected abstract void protectedClose();

    protected abstract void protectedFlush();

    protected abstract int protectedRead(long j6, byte[] bArr, int i6, int i7);

    protected abstract void protectedResize(long j6);

    protected abstract long protectedSize();

    protected abstract void protectedWrite(long j6, byte[] bArr, int i6, int i7);

    public final int read(long j6, byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.l.d(bArr, "array");
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            h4.q qVar = h4.q.f10774a;
        }
        return protectedRead(j6, bArr, i6, i7);
    }

    public final void reposition(Sink sink, long j6) {
        kotlin.jvm.internal.l.d(sink, "sink");
        boolean z5 = false;
        if (!(sink instanceof RealBufferedSink)) {
            if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
                z5 = true;
            }
            if (!z5) {
                throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
            }
            FileHandleSink fileHandleSink = (FileHandleSink) sink;
            if (!(!fileHandleSink.getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            fileHandleSink.setPosition(j6);
            return;
        }
        RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
        Sink sink2 = realBufferedSink.sink;
        if ((sink2 instanceof FileHandleSink) && ((FileHandleSink) sink2).getFileHandle() == this) {
            z5 = true;
        }
        if (!z5) {
            throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
        }
        FileHandleSink fileHandleSink2 = (FileHandleSink) sink2;
        if (!(!fileHandleSink2.getClosed())) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.emit();
        fileHandleSink2.setPosition(j6);
    }

    public final void resize(long j6) {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            h4.q qVar = h4.q.f10774a;
        }
        protectedResize(j6);
    }

    public final Sink sink(long j6) {
        if (this.readWrite) {
            synchronized (this) {
                if (!(!this.closed)) {
                    throw new IllegalStateException("closed".toString());
                }
                this.openStreamCount++;
            }
            return new FileHandleSink(this, j6);
        }
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final long size() {
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            h4.q qVar = h4.q.f10774a;
        }
        return protectedSize();
    }

    public final Source source(long j6) {
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.openStreamCount++;
        }
        return new FileHandleSource(this, j6);
    }

    public final void write(long j6, Buffer buffer, long j7) {
        kotlin.jvm.internal.l.d(buffer, "source");
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            h4.q qVar = h4.q.f10774a;
        }
        writeNoCloseCheck(j6, buffer, j7);
    }

    public final long position(Source source) {
        long j6;
        kotlin.jvm.internal.l.d(source, "source");
        if (source instanceof RealBufferedSource) {
            RealBufferedSource realBufferedSource = (RealBufferedSource) source;
            j6 = realBufferedSource.bufferField.size();
            source = realBufferedSource.source;
        } else {
            j6 = 0;
        }
        if ((source instanceof FileHandleSource) && ((FileHandleSource) source).getFileHandle() == this) {
            FileHandleSource fileHandleSource = (FileHandleSource) source;
            if (!fileHandleSource.getClosed()) {
                return fileHandleSource.getPosition() - j6;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException("source was not created by this FileHandle".toString());
    }

    public final long read(long j6, Buffer buffer, long j7) {
        kotlin.jvm.internal.l.d(buffer, "sink");
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            h4.q qVar = h4.q.f10774a;
        }
        return readNoCloseCheck(j6, buffer, j7);
    }

    public final void reposition(Source source, long j6) {
        kotlin.jvm.internal.l.d(source, "source");
        boolean z5 = false;
        if (!(source instanceof RealBufferedSource)) {
            if ((source instanceof FileHandleSource) && ((FileHandleSource) source).getFileHandle() == this) {
                z5 = true;
            }
            if (!z5) {
                throw new IllegalArgumentException("source was not created by this FileHandle".toString());
            }
            FileHandleSource fileHandleSource = (FileHandleSource) source;
            if (!(!fileHandleSource.getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            fileHandleSource.setPosition(j6);
            return;
        }
        RealBufferedSource realBufferedSource = (RealBufferedSource) source;
        Source source2 = realBufferedSource.source;
        if (!((source2 instanceof FileHandleSource) && ((FileHandleSource) source2).getFileHandle() == this)) {
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        FileHandleSource fileHandleSource2 = (FileHandleSource) source2;
        if (!(!fileHandleSource2.getClosed())) {
            throw new IllegalStateException("closed".toString());
        }
        long size = realBufferedSource.bufferField.size();
        long position = j6 - (fileHandleSource2.getPosition() - size);
        if (0 <= position && position < size) {
            z5 = true;
        }
        if (z5) {
            realBufferedSource.skip(position);
            return;
        }
        realBufferedSource.bufferField.clear();
        fileHandleSource2.setPosition(j6);
    }

    public final void write(long j6, byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.l.d(bArr, "array");
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            h4.q qVar = h4.q.f10774a;
        }
        protectedWrite(j6, bArr, i6, i7);
    }
}
