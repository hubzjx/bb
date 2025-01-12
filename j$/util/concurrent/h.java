package j$.util.concurrent;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h extends AbstractC0381a implements Iterator, Enumeration {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f11082k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(l[] lVarArr, int i6, int i7, ConcurrentHashMap concurrentHashMap, int i8) {
        super(lVarArr, i6, i7, concurrentHashMap);
        this.f11082k = i8;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f11082k) {
            case 0:
                l lVar = this.f11097b;
                if (lVar != null) {
                    Object obj = lVar.f11089b;
                    this.f11077j = lVar;
                    a();
                    return obj;
                }
                throw new NoSuchElementException();
            default:
                l lVar2 = this.f11097b;
                if (lVar2 != null) {
                    Object obj2 = lVar2.f11090c;
                    this.f11077j = lVar2;
                    a();
                    return obj2;
                }
                throw new NoSuchElementException();
        }
    }

    @Override // java.util.Enumeration
    public final Object nextElement() {
        switch (this.f11082k) {
            case 0:
                return next();
            default:
                return next();
        }
    }
}
