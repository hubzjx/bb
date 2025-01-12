package l0;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Stream;
/* loaded from: classes.dex */
abstract class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f11416a;

        /* renamed from: b  reason: collision with root package name */
        long f11417b;

        a() {
        }
    }

    static long a(RandomAccessFile randomAccessFile, a aVar) {
        CRC32 crc32 = new CRC32();
        long j6 = aVar.f11417b;
        randomAccessFile.seek(aVar.f11416a);
        int min = (int) Math.min((long) Http2Stream.EMIT_BUFFER_SIZE, j6);
        byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
        while (true) {
            int read = randomAccessFile.read(bArr, 0, min);
            if (read == -1) {
                break;
            }
            crc32.update(bArr, 0, read);
            j6 -= read;
            if (j6 == 0) {
                break;
            }
            min = (int) Math.min((long) Http2Stream.EMIT_BUFFER_SIZE, j6);
        }
        return crc32.getValue();
    }

    static a b(RandomAccessFile randomAccessFile) {
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j6 = length - 65536;
        long j7 = j6 >= 0 ? j6 : 0L;
        int reverseBytes = Integer.reverseBytes(101010256);
        do {
            randomAccessFile.seek(length);
            if (randomAccessFile.readInt() == reverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                a aVar = new a();
                aVar.f11417b = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                aVar.f11416a = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                return aVar;
            }
            length--;
        } while (length >= j7);
        throw new ZipException("End Of Central Directory signature not found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long c(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return a(randomAccessFile, b(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}
