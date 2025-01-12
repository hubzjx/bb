package okhttp3.internal.http2;

import java.util.List;
import kotlin.jvm.internal.l;
import okio.BufferedSource;
/* loaded from: classes.dex */
public interface PushObserver {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();

    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* loaded from: classes.dex */
        private static final class PushObserverCancel implements PushObserver {
            @Override // okhttp3.internal.http2.PushObserver
            public boolean onData(int i6, BufferedSource bufferedSource, int i7, boolean z5) {
                l.d(bufferedSource, "source");
                bufferedSource.skip(i7);
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onHeaders(int i6, List<Header> list, boolean z5) {
                l.d(list, "responseHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onRequest(int i6, List<Header> list) {
                l.d(list, "requestHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public void onReset(int i6, ErrorCode errorCode) {
                l.d(errorCode, "errorCode");
            }
        }

        private Companion() {
        }
    }

    boolean onData(int i6, BufferedSource bufferedSource, int i7, boolean z5);

    boolean onHeaders(int i6, List<Header> list, boolean z5);

    boolean onRequest(int i6, List<Header> list);

    void onReset(int i6, ErrorCode errorCode);
}
