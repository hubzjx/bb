package h4;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class d implements f, Serializable {
    private final Object value;

    public d(Object obj) {
        this.value = obj;
    }

    @Override // h4.f
    public Object getValue() {
        return this.value;
    }

    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
