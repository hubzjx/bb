package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    AtomicReference f1985a = new AtomicReference();

    /* loaded from: classes.dex */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* loaded from: classes.dex */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(b bVar) {
            return compareTo(bVar) >= 0;
        }
    }

    public abstract void a(e eVar);

    public abstract b b();

    public abstract void c(e eVar);
}
