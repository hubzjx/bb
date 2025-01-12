package kotlin.jvm.internal;

import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class m implements h, Serializable {
    private final int arity;

    public m(int i6) {
        this.arity = i6;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String e6 = s.e(this);
        l.c(e6, "renderLambdaToString(this)");
        return e6;
    }
}
