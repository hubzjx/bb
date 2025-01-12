package g4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import okio.Segment;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    ZipOutputStream f10515a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10516b;

    public j(String str) {
        this.f10516b = true;
        try {
            this.f10515a = new ZipOutputStream(new FileOutputStream(str));
        } catch (Exception unused) {
            this.f10515a = null;
            this.f10516b = false;
        }
    }

    private static void c(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[Segment.SHARE_MINIMUM];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public void a(String str, String str2) {
        if (this.f10516b) {
            try {
                FileInputStream fileInputStream = new FileInputStream(str2);
                this.f10515a.putNextEntry(new ZipEntry(str));
                c(fileInputStream, this.f10515a);
                fileInputStream.close();
            } catch (Exception unused) {
                this.f10516b = false;
            }
        }
    }

    public void b() {
        ZipOutputStream zipOutputStream = this.f10515a;
        if (zipOutputStream != null) {
            try {
                zipOutputStream.close();
            } catch (Exception unused) {
                this.f10516b = false;
            }
            this.f10515a = null;
        }
    }
}
