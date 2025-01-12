package j4;

import j4.c;
import java.io.Serializable;
import kotlin.jvm.internal.l;
import p4.p;
/* loaded from: classes.dex */
public final class d implements c, Serializable {
    public static final d INSTANCE = new d();
    private static final long serialVersionUID = 0;

    private d() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    public <R> R fold(R r5, p pVar) {
        l.d(pVar, "operation");
        return r5;
    }

    @Override // j4.c
    public <E extends c.a> E get(c.b bVar) {
        l.d(bVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public c minusKey(c.b bVar) {
        l.d(bVar, "key");
        return this;
    }

    public c plus(c cVar) {
        l.d(cVar, "context");
        return cVar;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
