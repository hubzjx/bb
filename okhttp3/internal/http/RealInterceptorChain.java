package okhttp3.internal.http;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
/* loaded from: classes.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;
    private final Request request;
    private final int writeTimeoutMillis;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(RealCall realCall, List<? extends Interceptor> list, int i6, Exchange exchange, Request request, int i7, int i8, int i9) {
        l.d(realCall, "call");
        l.d(list, "interceptors");
        l.d(request, "request");
        this.call = realCall;
        this.interceptors = list;
        this.index = i6;
        this.exchange = exchange;
        this.request = request;
        this.connectTimeoutMillis = i7;
        this.readTimeoutMillis = i8;
        this.writeTimeoutMillis = i9;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i6, Exchange exchange, Request request, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i6 = realInterceptorChain.index;
        }
        if ((i10 & 2) != 0) {
            exchange = realInterceptorChain.exchange;
        }
        Exchange exchange2 = exchange;
        if ((i10 & 4) != 0) {
            request = realInterceptorChain.request;
        }
        Request request2 = request;
        if ((i10 & 8) != 0) {
            i7 = realInterceptorChain.connectTimeoutMillis;
        }
        int i11 = i7;
        if ((i10 & 16) != 0) {
            i8 = realInterceptorChain.readTimeoutMillis;
        }
        int i12 = i8;
        if ((i10 & 32) != 0) {
            i9 = realInterceptorChain.writeTimeoutMillis;
        }
        return realInterceptorChain.copy$okhttp(i6, exchange2, request2, i11, i12, i9);
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        Exchange exchange = this.exchange;
        if (exchange == null) {
            return null;
        }
        return exchange.getConnection$okhttp();
    }

    public final RealInterceptorChain copy$okhttp(int i6, Exchange exchange, Request request, int i7, int i8, int i9) {
        l.d(request, "request");
        return new RealInterceptorChain(this.call, this.interceptors, i6, exchange, request, i7, i8, i9);
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request request) {
        l.d(request, "request");
        if (this.index < this.interceptors.size()) {
            this.calls++;
            Exchange exchange = this.exchange;
            if (exchange != null) {
                if (!exchange.getFinder$okhttp().sameHostAndPort(request.url())) {
                    throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
                }
                if (!(this.calls == 1)) {
                    throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
                }
            }
            RealInterceptorChain copy$okhttp$default = copy$okhttp$default(this, this.index + 1, null, request, 0, 0, 0, 58, null);
            Interceptor interceptor = this.interceptors.get(this.index);
            Response intercept = interceptor.intercept(copy$okhttp$default);
            if (intercept == null) {
                throw new NullPointerException("interceptor " + interceptor + " returned null");
            }
            if (this.exchange != null) {
                if (!(this.index + 1 >= this.interceptors.size() || copy$okhttp$default.calls == 1)) {
                    throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
                }
            }
            if (intercept.body() != null) {
                return intercept;
            }
            throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i6, TimeUnit timeUnit) {
        l.d(timeUnit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, Util.checkDuration("connectTimeout", i6, timeUnit), 0, 0, 55, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i6, TimeUnit timeUnit) {
        l.d(timeUnit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, Util.checkDuration("readTimeout", i6, timeUnit), 0, 47, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i6, TimeUnit timeUnit) {
        l.d(timeUnit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, 0, Util.checkDuration("writeTimeout", i6, timeUnit), 31, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
