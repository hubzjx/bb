package okio;

import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public final class JvmFileHandle extends FileHandle {
    private final RandomAccessFile randomAccessFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmFileHandle(boolean z5, RandomAccessFile randomAccessFile) {
        super(z5);
        kotlin.jvm.internal.l.d(randomAccessFile, "randomAccessFile");
        this.randomAccessFile = randomAccessFile;
    }

    @Override // okio.FileHandle
    protected synchronized void protectedClose() {
        this.randomAccessFile.close();
    }

    @Override // okio.FileHandle
    protected synchronized void protectedFlush() {
        this.randomAccessFile.getFD().sync();
    }

    @Override // okio.FileHandle
    protected synchronized int protectedRead(long j6, byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.l.d(bArr, "array");
        this.randomAccessFile.seek(j6);
        int i8 = 0;
        while (true) {
            if (i8 >= i7) {
                break;
            }
            int read = this.randomAccessFile.read(bArr, i6, i7 - i8);
            if (read != -1) {
                i8 += read;
            } else if (i8 == 0) {
                return -1;
            }
        }
        return i8;
    }

    @Override // okio.FileHandle
    protected synchronized void protectedResize(long j6) {
        long size = size();
        long j7 = j6 - size;
        if (j7 > 0) {
            int i6 = (int) j7;
            protectedWrite(size, new byte[i6], 0, i6);
        } else {
            this.randomAccessFile.setLength(j6);
        }
    }

    @Override // okio.FileHandle
    protected synchronized long protectedSize() {
        return this.randomAccessFile.length();
    }

    @Override // okio.FileHandle
    protected synchronized void protectedWrite(long j6, byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.l.d(bArr, "array");
        this.randomAccessFile.seek(j6);
        this.randomAccessFile.write(bArr, i6, i7);
    }
}
