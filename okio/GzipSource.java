package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* loaded from: classes.dex */
public final class GzipSource implements Source {
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final RealBufferedSource source;

    public GzipSource(Source source) {
        kotlin.jvm.internal.l.d(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.source = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new InflaterSource((BufferedSource) realBufferedSource, inflater);
        this.crc = new CRC32();
    }

    private final void checkEqual(String str, int i6, int i7) {
        if (i7 == i6) {
            return;
        }
        String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i7), Integer.valueOf(i6)}, 3));
        kotlin.jvm.internal.l.c(format, "format(this, *args)");
        throw new IOException(format);
    }

    private final void consumeHeader() {
        this.source.require(10L);
        byte b6 = this.source.bufferField.getByte(3L);
        boolean z5 = ((b6 >> 1) & 1) == 1;
        if (z5) {
            updateCrc(this.source.bufferField, 0L, 10L);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((b6 >> 2) & 1) == 1) {
            this.source.require(2L);
            if (z5) {
                updateCrc(this.source.bufferField, 0L, 2L);
            }
            long readShortLe = this.source.bufferField.readShortLe();
            this.source.require(readShortLe);
            if (z5) {
                updateCrc(this.source.bufferField, 0L, readShortLe);
            }
            this.source.skip(readShortLe);
        }
        if (((b6 >> 3) & 1) == 1) {
            long indexOf = this.source.indexOf((byte) 0);
            if (indexOf == -1) {
                throw new EOFException();
            }
            if (z5) {
                updateCrc(this.source.bufferField, 0L, indexOf + 1);
            }
            this.source.skip(indexOf + 1);
        }
        if (((b6 >> 4) & 1) == 1) {
            long indexOf2 = this.source.indexOf((byte) 0);
            if (indexOf2 == -1) {
                throw new EOFException();
            }
            if (z5) {
                updateCrc(this.source.bufferField, 0L, indexOf2 + 1);
            }
            this.source.skip(indexOf2 + 1);
        }
        if (z5) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    private final void consumeTrailer() {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private final void updateCrc(Buffer buffer, long j6, long j7) {
        int i6;
        Segment segment = buffer.head;
        while (true) {
            kotlin.jvm.internal.l.b(segment);
            int i7 = segment.limit;
            int i8 = segment.pos;
            if (j6 < i7 - i8) {
                break;
            }
            j6 -= i7 - i8;
            segment = segment.next;
        }
        while (j7 > 0) {
            int min = (int) Math.min(segment.limit - i6, j7);
            this.crc.update(segment.data, (int) (segment.pos + j6), min);
            j7 -= min;
            segment = segment.next;
            kotlin.jvm.internal.l.b(segment);
            j6 = 0;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflaterSource.close();
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "sink");
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        } else if (i6 == 0) {
            return 0L;
        } else {
            if (this.section == 0) {
                consumeHeader();
                this.section = (byte) 1;
            }
            if (this.section == 1) {
                long size = buffer.size();
                long read = this.inflaterSource.read(buffer, j6);
                if (read != -1) {
                    updateCrc(buffer, size, read);
                    return read;
                }
                this.section = (byte) 2;
            }
            if (this.section == 2) {
                consumeTrailer();
                this.section = (byte) 3;
                if (!this.source.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }
}
