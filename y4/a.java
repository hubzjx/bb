package y4;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private Mac f14337a;

    /* renamed from: b  reason: collision with root package name */
    private int f14338b;

    /* renamed from: c  reason: collision with root package name */
    private String f14339c;

    public a(String str) {
        this.f14339c = str;
        try {
            Mac mac = Mac.getInstance(str);
            this.f14337a = mac;
            this.f14338b = mac.getMacLength();
        } catch (NoSuchAlgorithmException e6) {
            throw new RuntimeException(e6);
        }
    }

    @Override // y4.d
    public byte[] a(byte[] bArr) {
        return this.f14337a.doFinal(bArr);
    }

    @Override // y4.d
    public int b() {
        return this.f14338b;
    }

    @Override // y4.d
    public void c(byte[] bArr) {
        try {
            this.f14337a.init(new SecretKeySpec(bArr, this.f14339c));
        } catch (InvalidKeyException e6) {
            throw new RuntimeException(e6);
        }
    }

    public byte[] d() {
        return this.f14337a.doFinal();
    }

    public void e(byte[] bArr, int i6, int i7) {
        try {
            this.f14337a.update(bArr, i6, i7);
        } catch (IllegalStateException e6) {
            throw new RuntimeException(e6);
        }
    }
}
