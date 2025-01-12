package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.l;
import kotlin.jvm.internal.s;
/* loaded from: classes.dex */
public abstract class j extends i implements kotlin.jvm.internal.h {
    private final int arity;

    public j(int i6) {
        this(i6, null);
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public String toString() {
        if (getCompletion() == null) {
            String d6 = s.d(this);
            l.c(d6, "renderLambdaToString(this)");
            return d6;
        }
        return super.toString();
    }

    public j(int i6, j4.a aVar) {
        super(aVar);
        this.arity = i6;
    }
}
