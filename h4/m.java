package h4;

import java.io.Serializable;
/* loaded from: classes.dex */
final class m implements f, Serializable {
    private volatile Object _value;
    private p4.a initializer;
    private final Object lock;

    public m(p4.a aVar, Object obj) {
        kotlin.jvm.internal.l.d(aVar, "initializer");
        this.initializer = aVar;
        this._value = o.f10773a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new d(getValue());
    }

    @Override // h4.f
    public Object getValue() {
        Object obj;
        Object obj2 = this._value;
        o oVar = o.f10773a;
        if (obj2 != oVar) {
            return obj2;
        }
        synchronized (this.lock) {
            obj = this._value;
            if (obj == oVar) {
                p4.a aVar = this.initializer;
                kotlin.jvm.internal.l.b(aVar);
                obj = aVar.invoke();
                this._value = obj;
                this.initializer = null;
            }
        }
        return obj;
    }

    public boolean isInitialized() {
        return this._value != o.f10773a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ m(p4.a aVar, Object obj, int i6, kotlin.jvm.internal.g gVar) {
        this(aVar, (i6 & 2) != 0 ? null : obj);
    }
}
