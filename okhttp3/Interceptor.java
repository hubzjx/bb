package okhttp3;

import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import p4.l;
/* loaded from: classes.dex */
public interface Interceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* loaded from: classes.dex */
    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        Connection connection();

        Response proceed(Request request);

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int i6, TimeUnit timeUnit);

        Chain withReadTimeout(int i6, TimeUnit timeUnit);

        Chain withWriteTimeout(int i6, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final Interceptor invoke(final l lVar) {
            kotlin.jvm.internal.l.d(lVar, "block");
            return new Interceptor() { // from class: okhttp3.Interceptor$Companion$invoke$1
                @Override // okhttp3.Interceptor
                public final Response intercept(Interceptor.Chain chain) {
                    kotlin.jvm.internal.l.d(chain, "it");
                    return (Response) l.this.invoke(chain);
                }
            };
        }
    }

    Response intercept(Chain chain);
}
