package n4;

import h4.b;
import java.io.Closeable;
/* loaded from: classes.dex */
public abstract class a {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                b.a(th, th2);
            }
        }
    }
}
