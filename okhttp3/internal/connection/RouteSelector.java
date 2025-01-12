package okhttp3.internal.connection;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.s;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;
/* loaded from: classes.dex */
public final class RouteSelector {
    public static final Companion Companion = new Companion(null);
    private final Address address;
    private final Call call;
    private final EventListener eventListener;
    private List<? extends InetSocketAddress> inetSocketAddresses;
    private int nextProxyIndex;
    private final List<Route> postponedRoutes;
    private List<? extends Proxy> proxies;
    private final RouteDatabase routeDatabase;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getSocketHost(InetSocketAddress inetSocketAddress) {
            String hostAddress;
            String str;
            l.d(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                hostAddress = inetSocketAddress.getHostName();
                str = "hostName";
            } else {
                hostAddress = address.getHostAddress();
                str = "address.hostAddress";
            }
            l.c(hostAddress, str);
            return hostAddress;
        }
    }

    /* loaded from: classes.dex */
    public static final class Selection {
        private int nextRouteIndex;
        private final List<Route> routes;

        public Selection(List<Route> list) {
            l.d(list, "routes");
            this.routes = list;
        }

        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        public final Route next() {
            if (hasNext()) {
                List<Route> list = this.routes;
                int i6 = this.nextRouteIndex;
                this.nextRouteIndex = i6 + 1;
                return list.get(i6);
            }
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        List<? extends Proxy> f6;
        List<? extends InetSocketAddress> f7;
        l.d(address, "address");
        l.d(routeDatabase, "routeDatabase");
        l.d(call, "call");
        l.d(eventListener, "eventListener");
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.eventListener = eventListener;
        f6 = n.f();
        this.proxies = f6;
        f7 = n.f();
        this.inetSocketAddresses = f7;
        this.postponedRoutes = new ArrayList();
        resetNextProxy(address.url(), address.proxy());
    }

    private final boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private final Proxy nextProxy() {
        if (hasNextProxy()) {
            List<? extends Proxy> list = this.proxies;
            int i6 = this.nextProxyIndex;
            this.nextProxyIndex = i6 + 1;
            Proxy proxy = list.get(i6);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
    }

    private final void resetNextInetSocketAddress(Proxy proxy) {
        String host;
        int port;
        List<InetAddress> lookup;
        ArrayList arrayList = new ArrayList();
        this.inetSocketAddresses = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            host = this.address.url().host();
            port = this.address.url().port();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(l.i("Proxy.address() is not an InetSocketAddress: ", address.getClass()).toString());
            }
            Companion companion = Companion;
            l.c(address, "proxyAddress");
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            host = companion.getSocketHost(inetSocketAddress);
            port = inetSocketAddress.getPort();
        }
        boolean z5 = false;
        if (1 <= port && port < 65536) {
            z5 = true;
        }
        if (!z5) {
            throw new SocketException("No route to " + host + ':' + port + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(host, port));
        } else {
            if (Util.canParseAsIpAddress(host)) {
                lookup = m.b(InetAddress.getByName(host));
            } else {
                this.eventListener.dnsStart(this.call, host);
                lookup = this.address.dns().lookup(host);
                if (lookup.isEmpty()) {
                    throw new UnknownHostException(this.address.dns() + " returned no addresses for " + host);
                }
                this.eventListener.dnsEnd(this.call, host, lookup);
            }
            for (InetAddress inetAddress : lookup) {
                arrayList.add(new InetSocketAddress(inetAddress, port));
            }
        }
    }

    private final void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        this.eventListener.proxySelectStart(this.call, httpUrl);
        List<Proxy> resetNextProxy$selectProxies = resetNextProxy$selectProxies(proxy, httpUrl, this);
        this.proxies = resetNextProxy$selectProxies;
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, httpUrl, resetNextProxy$selectProxies);
    }

    private static final List<Proxy> resetNextProxy$selectProxies(Proxy proxy, HttpUrl httpUrl, RouteSelector routeSelector) {
        List<Proxy> b6;
        if (proxy != null) {
            b6 = m.b(proxy);
            return b6;
        }
        URI uri = httpUrl.uri();
        if (uri.getHost() == null) {
            return Util.immutableListOf(Proxy.NO_PROXY);
        }
        List<Proxy> select = routeSelector.address.proxySelector().select(uri);
        if (select == null || select.isEmpty()) {
            return Util.immutableListOf(Proxy.NO_PROXY);
        }
        l.c(select, "proxiesOrNull");
        return Util.toImmutableList(select);
    }

    public final boolean hasNext() {
        return hasNextProxy() || (this.postponedRoutes.isEmpty() ^ true);
    }

    public final Selection next() {
        if (hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (hasNextProxy()) {
                Proxy nextProxy = nextProxy();
                for (InetSocketAddress inetSocketAddress : this.inetSocketAddresses) {
                    Route route = new Route(this.address, nextProxy, inetSocketAddress);
                    if (this.routeDatabase.shouldPostpone(route)) {
                        this.postponedRoutes.add(route);
                    } else {
                        arrayList.add(route);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                s.s(arrayList, this.postponedRoutes);
                this.postponedRoutes.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }
}
