package w1;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class p {

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicLong f13956h = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public final long f13957a;

    /* renamed from: b  reason: collision with root package name */
    public final q2.o f13958b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f13959c;

    /* renamed from: d  reason: collision with root package name */
    public final Map f13960d;

    /* renamed from: e  reason: collision with root package name */
    public final long f13961e;

    /* renamed from: f  reason: collision with root package name */
    public final long f13962f;

    /* renamed from: g  reason: collision with root package name */
    public final long f13963g;

    public p(long j6, q2.o oVar, long j7) {
        this(j6, oVar, oVar.f12794a, Collections.emptyMap(), j7, 0L, 0L);
    }

    public static long a() {
        return f13956h.getAndIncrement();
    }

    public p(long j6, q2.o oVar, Uri uri, Map map, long j7, long j8, long j9) {
        this.f13957a = j6;
        this.f13958b = oVar;
        this.f13959c = uri;
        this.f13960d = map;
        this.f13961e = j7;
        this.f13962f = j8;
        this.f13963g = j9;
    }
}
