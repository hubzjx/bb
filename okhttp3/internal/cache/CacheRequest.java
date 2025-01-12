package okhttp3.internal.cache;

import okio.Sink;
/* loaded from: classes.dex */
public interface CacheRequest {
    void abort();

    Sink body();
}
