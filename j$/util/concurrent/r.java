package j$.util.concurrent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r extends l {

    /* renamed from: e  reason: collision with root package name */
    r f11109e;

    /* renamed from: f  reason: collision with root package name */
    r f11110f;

    /* renamed from: g  reason: collision with root package name */
    r f11111g;

    /* renamed from: h  reason: collision with root package name */
    r f11112h;

    /* renamed from: i  reason: collision with root package name */
    boolean f11113i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(int i6, Object obj, Object obj2, r rVar, r rVar2) {
        super(i6, obj, obj2, rVar);
        this.f11109e = rVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.concurrent.l
    public final l a(int i6, Object obj) {
        return b(i6, obj, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final r b(int i6, Object obj, Class cls) {
        int d6;
        if (obj != null) {
            r rVar = this;
            do {
                r rVar2 = rVar.f11110f;
                r rVar3 = rVar.f11111g;
                int i7 = rVar.f11088a;
                if (i7 <= i6) {
                    if (i7 >= i6) {
                        Object obj2 = rVar.f11089b;
                        if (obj2 == obj || (obj2 != null && obj.equals(obj2))) {
                            return rVar;
                        }
                        if (rVar2 != null) {
                            if (rVar3 != null) {
                                if ((cls == null && (cls = ConcurrentHashMap.c(obj)) == null) || (d6 = ConcurrentHashMap.d(cls, obj, obj2)) == 0) {
                                    r b6 = rVar3.b(i6, obj, cls);
                                    if (b6 != null) {
                                        return b6;
                                    }
                                } else if (d6 >= 0) {
                                    rVar2 = rVar3;
                                }
                            }
                        }
                    }
                    rVar = rVar3;
                    continue;
                }
                rVar = rVar2;
                continue;
            } while (rVar != null);
            return null;
        }
        return null;
    }
}
