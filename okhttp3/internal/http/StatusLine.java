package okhttp3.internal.http;

import java.net.ProtocolException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.text.w;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Response;
/* loaded from: classes.dex */
public final class StatusLine {
    public static final Companion Companion = new Companion(null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final StatusLine get(Response response) {
            l.d(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String str) {
            boolean y5;
            boolean y6;
            Protocol protocol;
            int i6;
            String str2;
            l.d(str, "statusLine");
            y5 = w.y(str, "HTTP/1.", false, 2, null);
            if (y5) {
                i6 = 9;
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException(l.i("Unexpected status line: ", str));
                }
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else if (charAt != 1) {
                    throw new ProtocolException(l.i("Unexpected status line: ", str));
                } else {
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                y6 = w.y(str, "ICY ", false, 2, null);
                if (!y6) {
                    throw new ProtocolException(l.i("Unexpected status line: ", str));
                }
                protocol = Protocol.HTTP_1_0;
                i6 = 4;
            }
            int i7 = i6 + 3;
            if (str.length() >= i7) {
                try {
                    String substring = str.substring(i6, i7);
                    l.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    int parseInt = Integer.parseInt(substring);
                    if (str.length() <= i7) {
                        str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                    } else if (str.charAt(i7) != ' ') {
                        throw new ProtocolException(l.i("Unexpected status line: ", str));
                    } else {
                        str2 = str.substring(i6 + 4);
                        l.c(str2, "this as java.lang.String).substring(startIndex)");
                    }
                    return new StatusLine(protocol, parseInt, str2);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException(l.i("Unexpected status line: ", str));
                }
            }
            throw new ProtocolException(l.i("Unexpected status line: ", str));
        }
    }

    public StatusLine(Protocol protocol, int i6, String str) {
        l.d(protocol, "protocol");
        l.d(str, "message");
        this.protocol = protocol;
        this.code = i6;
        this.message = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.protocol == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.message);
        String sb2 = sb.toString();
        l.c(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
