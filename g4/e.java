package g4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public abstract class e {
    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() * 2);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes("UTF-8"));
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public static String b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 128);
        byte[] bArr2 = new byte[128];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read == -1) {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return byteArrayOutputStream.toString("UTF-8");
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }
}
