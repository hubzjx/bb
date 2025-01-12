package okhttp3.internal.connection;

import h4.q;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.jvm.internal.l;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
/* loaded from: classes.dex */
public final class ExchangeFinder {
    private final Address address;
    private final RealCall call;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address, RealCall realCall, EventListener eventListener) {
        l.d(realConnectionPool, "connectionPool");
        l.d(address, "address");
        l.d(realCall, "call");
        l.d(eventListener, "eventListener");
        this.connectionPool = realConnectionPool;
        this.address = address;
        this.call = realCall;
        this.eventListener = eventListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final RealConnection findConnection(int i6, int i7, int i8, int i9, boolean z5) {
        List<Route> routes;
        RealConnection connection;
        Socket releaseConnectionNoEvents$okhttp;
        if (this.call.isCanceled()) {
            throw new IOException("Canceled");
        }
        RealConnection connection2 = this.call.getConnection();
        if (connection2 != null) {
            synchronized (connection2) {
                if (!connection2.getNoNewExchanges() && sameHostAndPort(connection2.route().address().url())) {
                    releaseConnectionNoEvents$okhttp = null;
                    q qVar = q.f10774a;
                }
                releaseConnectionNoEvents$okhttp = this.call.releaseConnectionNoEvents$okhttp();
                q qVar2 = q.f10774a;
            }
            if (this.call.getConnection() != null) {
                if (releaseConnectionNoEvents$okhttp == null) {
                    return connection2;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            if (releaseConnectionNoEvents$okhttp != null) {
                Util.closeQuietly(releaseConnectionNoEvents$okhttp);
            }
            this.eventListener.connectionReleased(this.call, connection2);
        }
        this.refusedStreamCount = 0;
        this.connectionShutdownCount = 0;
        this.otherFailureCount = 0;
        if (!this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
            Route route = this.nextRouteToTry;
            try {
                if (route != null) {
                    l.b(route);
                    this.nextRouteToTry = null;
                } else {
                    RouteSelector.Selection selection = this.routeSelection;
                    if (selection != null) {
                        l.b(selection);
                        if (selection.hasNext()) {
                            RouteSelector.Selection selection2 = this.routeSelection;
                            l.b(selection2);
                            route = selection2.next();
                        }
                    }
                    RouteSelector routeSelector = this.routeSelector;
                    if (routeSelector == null) {
                        routeSelector = new RouteSelector(this.address, this.call.getClient().getRouteDatabase(), this.call, this.eventListener);
                        this.routeSelector = routeSelector;
                    }
                    RouteSelector.Selection next = routeSelector.next();
                    this.routeSelection = next;
                    routes = next.getRoutes();
                    if (this.call.isCanceled()) {
                        throw new IOException("Canceled");
                    }
                    if (!this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, false)) {
                        route = next.next();
                        RealConnection realConnection = new RealConnection(this.connectionPool, route);
                        this.call.setConnectionToCancel(realConnection);
                        realConnection.connect(i6, i7, i8, i9, z5, this.call, this.eventListener);
                        this.call.setConnectionToCancel(null);
                        this.call.getClient().getRouteDatabase().connected(realConnection.route());
                        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, true)) {
                            synchronized (realConnection) {
                                this.connectionPool.put(realConnection);
                                this.call.acquireConnectionNoEvents(realConnection);
                                q qVar3 = q.f10774a;
                            }
                            this.eventListener.connectionAcquired(this.call, realConnection);
                            return realConnection;
                        }
                        connection = this.call.getConnection();
                        l.b(connection);
                        this.nextRouteToTry = route;
                        Util.closeQuietly(realConnection.socket());
                        this.eventListener.connectionAcquired(this.call, connection);
                        return connection;
                    }
                }
                realConnection.connect(i6, i7, i8, i9, z5, this.call, this.eventListener);
                this.call.setConnectionToCancel(null);
                this.call.getClient().getRouteDatabase().connected(realConnection.route());
                if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, true)) {
                }
            } catch (Throwable th) {
                this.call.setConnectionToCancel(null);
                throw th;
            }
            routes = null;
            RealConnection realConnection2 = new RealConnection(this.connectionPool, route);
            this.call.setConnectionToCancel(realConnection2);
        }
        connection = this.call.getConnection();
        l.b(connection);
        this.eventListener.connectionAcquired(this.call, connection);
        return connection;
    }

    private final RealConnection findHealthyConnection(int i6, int i7, int i8, int i9, boolean z5, boolean z6) {
        while (true) {
            RealConnection findConnection = findConnection(i6, i7, i8, i9, z5);
            if (findConnection.isHealthy(z6)) {
                return findConnection;
            }
            findConnection.noNewExchanges$okhttp();
            if (this.nextRouteToTry == null) {
                RouteSelector.Selection selection = this.routeSelection;
                if (selection == null ? true : selection.hasNext()) {
                    continue;
                } else {
                    RouteSelector routeSelector = this.routeSelector;
                    if (!(routeSelector != null ? routeSelector.hasNext() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    private final Route retryRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null) {
            return null;
        }
        synchronized (connection) {
            if (connection.getRouteFailureCount$okhttp() != 0) {
                return null;
            }
            if (Util.canReuseConnectionFor(connection.route().address().url(), getAddress$okhttp().url())) {
                return connection.route();
            }
            return null;
        }
    }

    public final ExchangeCodec find(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) {
        l.d(okHttpClient, "client");
        l.d(realInterceptorChain, "chain");
        try {
            return findHealthyConnection(realInterceptorChain.getConnectTimeoutMillis$okhttp(), realInterceptorChain.getReadTimeoutMillis$okhttp(), realInterceptorChain.getWriteTimeoutMillis$okhttp(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), !l.a(realInterceptorChain.getRequest$okhttp().method(), "GET")).newCodec$okhttp(okHttpClient, realInterceptorChain);
        } catch (IOException e6) {
            trackFailure(e6);
            throw new RouteException(e6);
        } catch (RouteException e7) {
            trackFailure(e7.getLastConnectException());
            throw e7;
        }
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final boolean retryAfterFailure() {
        RouteSelector routeSelector;
        boolean z5 = false;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        Route retryRoute = retryRoute();
        if (retryRoute != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        if (selection != null && selection.hasNext()) {
            z5 = true;
        }
        if (z5 || (routeSelector = this.routeSelector) == null) {
            return true;
        }
        return routeSelector.hasNext();
    }

    public final boolean sameHostAndPort(HttpUrl httpUrl) {
        l.d(httpUrl, "url");
        HttpUrl url = this.address.url();
        return httpUrl.port() == url.port() && l.a(httpUrl.host(), url.host());
    }

    public final void trackFailure(IOException iOException) {
        l.d(iOException, "e");
        this.nextRouteToTry = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
            this.refusedStreamCount++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }
}
