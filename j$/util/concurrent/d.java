package j$.util.concurrent;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class d extends AbstractC0381a implements Iterator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(l[] lVarArr, int i6, int i7, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i6, i7, concurrentHashMap);
    }

    @Override // java.util.Iterator
    public final Object next() {
        l lVar = this.f11097b;
        if (lVar != null) {
            Object obj = lVar.f11089b;
            Object obj2 = lVar.f11090c;
            this.f11077j = lVar;
            a();
            return new k(obj, obj2, this.f11076i);
        }
        throw new NoSuchElementException();
    }
}
