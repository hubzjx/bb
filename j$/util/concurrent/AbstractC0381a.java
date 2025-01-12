package j$.util.concurrent;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.concurrent.a  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0381a extends p {

    /* renamed from: i  reason: collision with root package name */
    final ConcurrentHashMap f11076i;

    /* renamed from: j  reason: collision with root package name */
    l f11077j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0381a(l[] lVarArr, int i6, int i7, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i6, 0, i7);
        this.f11076i = concurrentHashMap;
        a();
    }

    public final boolean hasMoreElements() {
        return this.f11097b != null;
    }

    public final boolean hasNext() {
        return this.f11097b != null;
    }

    public final void remove() {
        l lVar = this.f11077j;
        if (lVar == null) {
            throw new IllegalStateException();
        }
        this.f11077j = null;
        this.f11076i.i(lVar.f11089b, null, null);
    }
}
