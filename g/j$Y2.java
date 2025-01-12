package g;

import e.AbstractC0227j$a;
import f.InterfaceC0257j$e;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Comparator;
/* loaded from: classes2.dex */
final class j$Y2 implements e.j$J, InterfaceC0257j$e {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f10104d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final e.j$J f10105a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap f10106b;

    /* renamed from: c  reason: collision with root package name */
    private Object f10107c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$Y2(e.j$J j_j) {
        this(j_j, new ConcurrentHashMap());
    }

    private j$Y2(e.j$J j_j, ConcurrentHashMap concurrentHashMap) {
        this.f10105a = j_j;
        this.f10106b = concurrentHashMap;
    }

    @Override // e.j$J
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        this.f10105a.b(new C0321j$l(6, this, interfaceC0257j$e));
    }

    @Override // e.j$J
    public final int characteristics() {
        return (this.f10105a.characteristics() & (-16469)) | 1;
    }

    @Override // e.j$J
    public final long estimateSize() {
        return this.f10105a.estimateSize();
    }

    @Override // e.j$J
    public final Comparator getComparator() {
        return this.f10105a.getComparator();
    }

    @Override // e.j$J
    public final /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0227j$a.h(this);
    }

    @Override // e.j$J
    public final /* synthetic */ boolean hasCharacteristics(int i6) {
        return AbstractC0227j$a.i(this, i6);
    }

    @Override // f.InterfaceC0257j$e
    public final void j(Object obj) {
        this.f10107c = obj;
    }

    @Override // e.j$J
    public final boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        while (this.f10105a.r(this)) {
            Object obj = this.f10107c;
            if (obj == null) {
                obj = f10104d;
            }
            if (this.f10106b.putIfAbsent(obj, Boolean.TRUE) == null) {
                interfaceC0257j$e.j(this.f10107c);
                this.f10107c = null;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t(InterfaceC0257j$e interfaceC0257j$e, Object obj) {
        if (this.f10106b.putIfAbsent(obj != null ? obj : f10104d, Boolean.TRUE) == null) {
            interfaceC0257j$e.j(obj);
        }
    }

    @Override // e.j$J
    public final e.j$J trySplit() {
        e.j$J trySplit = this.f10105a.trySplit();
        if (trySplit != null) {
            return new j$Y2(trySplit, this.f10106b);
        }
        return null;
    }
}
