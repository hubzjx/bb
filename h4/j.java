package h4;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class j implements Serializable {
    private final Object first;
    private final Object second;

    public j(Object obj, Object obj2) {
        this.first = obj;
        this.second = obj2;
    }

    public static /* synthetic */ j copy$default(j jVar, Object obj, Object obj2, int i6, Object obj3) {
        if ((i6 & 1) != 0) {
            obj = jVar.first;
        }
        if ((i6 & 2) != 0) {
            obj2 = jVar.second;
        }
        return jVar.copy(obj, obj2);
    }

    public final Object component1() {
        return this.first;
    }

    public final Object component2() {
        return this.second;
    }

    public final j copy(Object obj, Object obj2) {
        return new j(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return kotlin.jvm.internal.l.a(this.first, jVar.first) && kotlin.jvm.internal.l.a(this.second, jVar.second);
        }
        return false;
    }

    public final Object getFirst() {
        return this.first;
    }

    public final Object getSecond() {
        return this.second;
    }

    public int hashCode() {
        Object obj = this.first;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.second;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
