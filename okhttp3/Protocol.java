package okhttp3;

import java.io.IOException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
/* loaded from: classes.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    
    public static final Companion Companion = new Companion(null);
    private final String protocol;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Protocol get(String str) {
            l.d(str, "protocol");
            Protocol protocol = Protocol.HTTP_1_0;
            if (!l.a(str, protocol.protocol)) {
                protocol = Protocol.HTTP_1_1;
                if (!l.a(str, protocol.protocol)) {
                    protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!l.a(str, protocol.protocol)) {
                        protocol = Protocol.HTTP_2;
                        if (!l.a(str, protocol.protocol)) {
                            protocol = Protocol.SPDY_3;
                            if (!l.a(str, protocol.protocol)) {
                                protocol = Protocol.QUIC;
                                if (!l.a(str, protocol.protocol)) {
                                    throw new IOException(l.i("Unexpected protocol: ", str));
                                }
                            }
                        }
                    }
                }
            }
            return protocol;
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    public static final Protocol get(String str) {
        return Companion.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
