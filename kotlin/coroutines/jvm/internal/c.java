package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.l;
/* loaded from: classes.dex */
public abstract class c extends a {
    private final j4.c _context;
    private transient j4.a intercepted;

    public c(j4.a aVar) {
        this(aVar, aVar != null ? aVar.getContext() : null);
    }

    @Override // kotlin.coroutines.jvm.internal.a, j4.a
    public j4.c getContext() {
        j4.c cVar = this._context;
        l.b(cVar);
        return cVar;
    }

    public final j4.a intercepted() {
        j4.a aVar = this.intercepted;
        if (aVar == null) {
            getContext().get(j4.b.f11246j);
            this.intercepted = this;
            return this;
        }
        return aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    protected void releaseIntercepted() {
        j4.a aVar = this.intercepted;
        if (aVar == null || aVar == this) {
            this.intercepted = b.f11304a;
            return;
        }
        getContext().get(j4.b.f11246j);
        l.b(null);
        throw null;
    }

    public c(j4.a aVar, j4.c cVar) {
        super(aVar);
        this._context = cVar;
    }
}
