package j$.util.concurrent;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    final Object f11085a;

    /* renamed from: b  reason: collision with root package name */
    Object f11086b;

    /* renamed from: c  reason: collision with root package name */
    final ConcurrentHashMap f11087c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
        this.f11085a = obj;
        this.f11086b = obj2;
        this.f11087c = concurrentHashMap;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        Object obj2;
        Object obj3;
        return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.f11085a) || key.equals(obj2)) && (value == (obj3 = this.f11086b) || value.equals(obj3));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f11085a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f11086b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f11085a.hashCode() ^ this.f11086b.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        obj.getClass();
        Object obj2 = this.f11086b;
        this.f11086b = obj;
        this.f11087c.put(this.f11085a, obj);
        return obj2;
    }

    public final String toString() {
        return this.f11085a + "=" + this.f11086b;
    }
}
