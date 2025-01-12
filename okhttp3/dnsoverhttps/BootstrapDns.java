package okhttp3.dnsoverhttps;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.jvm.internal.l;
import okhttp3.Dns;
/* loaded from: classes.dex */
public final class BootstrapDns implements Dns {
    private final String dnsHostname;
    private final List<InetAddress> dnsServers;

    /* JADX WARN: Multi-variable type inference failed */
    public BootstrapDns(String str, List<? extends InetAddress> list) {
        l.d(str, "dnsHostname");
        l.d(list, "dnsServers");
        this.dnsHostname = str;
        this.dnsServers = list;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) {
        l.d(str, "hostname");
        if (l.a(this.dnsHostname, str)) {
            return this.dnsServers;
        }
        throw new UnknownHostException("BootstrapDns called for " + str + " instead of " + this.dnsHostname);
    }
}
