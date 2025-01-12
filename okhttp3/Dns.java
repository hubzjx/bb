package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.j;
import kotlin.jvm.internal.l;
/* loaded from: classes.dex */
public interface Dns {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final Dns SYSTEM = new Companion.DnsSystem();

    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* loaded from: classes.dex */
        private static final class DnsSystem implements Dns {
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(String str) {
                List<InetAddress> v5;
                l.d(str, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    l.c(allByName, "getAllByName(hostname)");
                    v5 = j.v(allByName);
                    return v5;
                } catch (NullPointerException e6) {
                    UnknownHostException unknownHostException = new UnknownHostException(l.i("Broken system behaviour for dns lookup of ", str));
                    unknownHostException.initCause(e6);
                    throw unknownHostException;
                }
            }
        }

        private Companion() {
        }
    }

    List<InetAddress> lookup(String str);
}
