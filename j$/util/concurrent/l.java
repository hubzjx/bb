package j$.util.concurrent;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class l implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    final int f11088a;

    /* renamed from: b  reason: collision with root package name */
    final Object f11089b;

    /* renamed from: c  reason: collision with root package name */
    volatile Object f11090c;

    /* renamed from: d  reason: collision with root package name */
    volatile l f11091d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(int i6, Object obj, Object obj2, l lVar) {
        this.f11088a = i6;
        this.f11089b = obj;
        this.f11090c = obj2;
        this.f11091d = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l a(int i6, Object obj) {
        Object obj2;
        if (obj != null) {
            l lVar = this;
            do {
                if (lVar.f11088a == i6 && ((obj2 = lVar.f11089b) == obj || (obj2 != null && obj.equals(obj2)))) {
                    return lVar;
                }
                lVar = lVar.f11091d;
            } while (lVar != null);
            return null;
        }
        return null;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        Object obj2;
        Object obj3;
        return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.f11089b) || key.equals(obj2)) && (value == (obj3 = this.f11090c) || value.equals(obj3));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f11089b;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f11090c;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f11089b.hashCode() ^ this.f11090c.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return this.f11089b + "=" + this.f11090c;
    }
}
