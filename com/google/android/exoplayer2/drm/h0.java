package com.google.android.exoplayer2.drm;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class h0 extends IOException {
    public final long bytesLoaded;
    public final q2.o dataSpec;
    public final Map<String, List<String>> responseHeaders;
    public final Uri uriAfterRedirects;

    public h0(q2.o oVar, Uri uri, Map<String, List<String>> map, long j6, Throwable th) {
        super(th);
        this.dataSpec = oVar;
        this.uriAfterRedirects = uri;
        this.responseHeaders = map;
        this.bytesLoaded = j6;
    }
}
