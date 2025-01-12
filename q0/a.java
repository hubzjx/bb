package q0;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import k5.b;
import k5.c;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final b f12697a = c.g("ProxyCacheUtils");

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i6])));
        }
        return stringBuffer.toString();
    }

    public static String b(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e6) {
            throw new IllegalStateException(e6);
        }
    }
}
