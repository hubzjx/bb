package kotlin.coroutines.jvm.internal;

import h4.k;
import java.io.Serializable;
import kotlin.jvm.internal.l;
/* loaded from: classes.dex */
public abstract class a implements j4.a, d, Serializable {
    private final j4.a completion;

    public a(j4.a aVar) {
        this.completion = aVar;
    }

    public j4.a create(j4.a aVar) {
        l.d(aVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public d getCallerFrame() {
        j4.a aVar = this.completion;
        if (aVar instanceof d) {
            return (d) aVar;
        }
        return null;
    }

    public final j4.a getCompletion() {
        return this.completion;
    }

    @Override // j4.a
    public abstract /* synthetic */ j4.c getContext();

    public StackTraceElement getStackTraceElement() {
        return f.d(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    @Override // j4.a
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        Object b6;
        j4.a aVar = this;
        while (true) {
            g.b(aVar);
            a aVar2 = (a) aVar;
            j4.a aVar3 = aVar2.completion;
            l.b(aVar3);
            try {
                invokeSuspend = aVar2.invokeSuspend(obj);
                b6 = kotlin.coroutines.intrinsics.d.b();
            } catch (Throwable th) {
                k.a aVar4 = k.Companion;
                obj = k.m15constructorimpl(h4.l.a(th));
            }
            if (invokeSuspend == b6) {
                return;
            }
            obj = k.m15constructorimpl(invokeSuspend);
            aVar2.releaseIntercepted();
            if (!(aVar3 instanceof a)) {
                aVar3.resumeWith(obj);
                return;
            }
            aVar = aVar3;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public j4.a create(Object obj, j4.a aVar) {
        l.d(aVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
