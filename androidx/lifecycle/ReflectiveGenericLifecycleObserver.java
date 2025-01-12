package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1976a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0017a f1977b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1976a = obj;
        this.f1977b = a.f1978c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.d
    public void a(f fVar, c.a aVar) {
        this.f1977b.a(fVar, aVar, this.f1976a);
    }
}
