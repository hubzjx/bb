package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    private final Map f2000a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f2001b = false;

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e6) {
                throw new RuntimeException(e6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f2001b = true;
        Map map = this.f2000a;
        if (map != null) {
            synchronized (map) {
                for (Object obj : this.f2000a.values()) {
                    b(obj);
                }
            }
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
    }
}
