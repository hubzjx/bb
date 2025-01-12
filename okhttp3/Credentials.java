package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.l;
import okio.ByteString;
/* loaded from: classes.dex */
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    public static final String basic(String str, String str2) {
        l.d(str, "username");
        l.d(str2, "password");
        return basic$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            charset = StandardCharsets.ISO_8859_1;
            l.c(charset, "ISO_8859_1");
        }
        return basic(str, str2, charset);
    }

    public static final String basic(String str, String str2, Charset charset) {
        l.d(str, "username");
        l.d(str2, "password");
        l.d(charset, "charset");
        return l.i("Basic ", ByteString.Companion.encodeString(str + ':' + str2, charset).base64());
    }
}
