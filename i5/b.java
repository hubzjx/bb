package i5;

import g5.a;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.CRC32;
import okhttp3.internal.http2.Http2;
/* loaded from: classes.dex */
public abstract class b {
    public static long a(File file, g5.a aVar) {
        if (file == null || !file.exists() || !file.canRead()) {
            throw new a5.a("input file is null or does not exist or cannot read. Cannot calculate CRC for the file");
        }
        byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
        CRC32 crc32 = new CRC32();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    long value = crc32.getValue();
                    fileInputStream.close();
                    return value;
                }
                crc32.update(bArr, 0, read);
                if (aVar != null) {
                    aVar.l(read);
                    if (aVar.e()) {
                        aVar.i(a.EnumC0171a.CANCELLED);
                        aVar.j(a.b.READY);
                        fileInputStream.close();
                        return 0L;
                    }
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }
}
