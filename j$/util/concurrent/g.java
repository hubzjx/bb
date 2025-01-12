package j$.util.concurrent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g extends l {

    /* renamed from: e  reason: collision with root package name */
    final l[] f11081e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(l[] lVarArr) {
        super(-1, null, null, null);
        this.f11081e = lVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
        if ((r0 instanceof j$.util.concurrent.g) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002b, code lost:
        r0 = ((j$.util.concurrent.g) r0).f11081e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
        return r0.a(r5, r6);
     */
    @Override // j$.util.concurrent.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final l a(int i6, Object obj) {
        int length;
        l m5;
        Object obj2;
        l[] lVarArr = this.f11081e;
        loop0: while (obj != null && lVarArr != null && (length = lVarArr.length) != 0 && (m5 = ConcurrentHashMap.m(lVarArr, (length - 1) & i6)) != null) {
            while (true) {
                int i7 = m5.f11088a;
                if (i7 != i6 || ((obj2 = m5.f11089b) != obj && (obj2 == null || !obj.equals(obj2)))) {
                    if (i7 >= 0) {
                        m5 = m5.f11091d;
                        if (m5 == null) {
                            break loop0;
                        }
                    } else {
                        break;
                    }
                }
            }
            return m5;
        }
        return null;
    }
}
