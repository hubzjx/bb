package p1;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayOutputStream f12617a;

    /* renamed from: b  reason: collision with root package name */
    private final DataOutputStream f12618b;

    public c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f12617a = byteArrayOutputStream;
        this.f12618b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    private static void c(DataOutputStream dataOutputStream, long j6) {
        dataOutputStream.writeByte(((int) (j6 >>> 24)) & 255);
        dataOutputStream.writeByte(((int) (j6 >>> 16)) & 255);
        dataOutputStream.writeByte(((int) (j6 >>> 8)) & 255);
        dataOutputStream.writeByte(((int) j6) & 255);
    }

    public byte[] a(a aVar) {
        this.f12617a.reset();
        try {
            b(this.f12618b, aVar.f12611a);
            String str = aVar.f12612b;
            if (str == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            b(this.f12618b, str);
            c(this.f12618b, aVar.f12613c);
            c(this.f12618b, aVar.f12614d);
            this.f12618b.write(aVar.f12615e);
            this.f12618b.flush();
            return this.f12617a.toByteArray();
        } catch (IOException e6) {
            throw new RuntimeException(e6);
        }
    }
}
