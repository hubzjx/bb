package okio.internal;

import java.io.IOException;
import kotlin.jvm.internal.l;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;
/* loaded from: classes.dex */
public final class FixedLengthSource extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedLengthSource(Source source, long j6, boolean z5) {
        super(source);
        l.d(source, "delegate");
        this.size = j6;
        this.truncate = z5;
    }

    private final void truncateToSize(Buffer buffer, long j6) {
        Buffer buffer2 = new Buffer();
        buffer2.writeAll(buffer);
        buffer.write(buffer2, j6);
        buffer2.clear();
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer buffer, long j6) {
        l.d(buffer, "sink");
        long j7 = this.bytesReceived;
        long j8 = this.size;
        if (j7 > j8) {
            j6 = 0;
        } else if (this.truncate) {
            long j9 = j8 - j7;
            if (j9 == 0) {
                return -1L;
            }
            j6 = Math.min(j6, j9);
        }
        long read = super.read(buffer, j6);
        int i6 = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
        if (i6 != 0) {
            this.bytesReceived += read;
        }
        long j10 = this.bytesReceived;
        long j11 = this.size;
        if ((j10 >= j11 || i6 != 0) && j10 <= j11) {
            return read;
        }
        if (read > 0 && j10 > j11) {
            truncateToSize(buffer, buffer.size() - (this.bytesReceived - this.size));
        }
        throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
    }
}
