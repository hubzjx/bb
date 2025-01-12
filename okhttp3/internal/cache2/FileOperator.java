package okhttp3.internal.cache2;

import java.nio.channels.FileChannel;
import kotlin.jvm.internal.l;
import okio.Buffer;
/* loaded from: classes.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        l.d(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j6, Buffer buffer, long j7) {
        l.d(buffer, "sink");
        if (j7 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j7 > 0) {
            long transferTo = this.fileChannel.transferTo(j6, j7, buffer);
            j6 += transferTo;
            j7 -= transferTo;
        }
    }

    public final void write(long j6, Buffer buffer, long j7) {
        l.d(buffer, "source");
        if (j7 < 0 || j7 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j8 = j6;
        long j9 = j7;
        while (j9 > 0) {
            long transferFrom = this.fileChannel.transferFrom(buffer, j8, j9);
            j8 += transferFrom;
            j9 -= transferFrom;
        }
    }
}
