package e;

import f.InterfaceC0257j$e;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import okhttp3.internal.http2.Http2;
import okio.Segment;
import okio.internal._BufferKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j$V implements j$J {

    /* renamed from: a  reason: collision with root package name */
    private final Collection f9267a;

    /* renamed from: b  reason: collision with root package name */
    private Iterator f9268b = null;

    /* renamed from: c  reason: collision with root package name */
    private final int f9269c;

    /* renamed from: d  reason: collision with root package name */
    private long f9270d;

    /* renamed from: e  reason: collision with root package name */
    private int f9271e;

    public j$V(Collection collection, int i6) {
        this.f9267a = collection;
        this.f9269c = (i6 & _BufferKt.SEGMENTING_THRESHOLD) == 0 ? i6 | 64 | Http2.INITIAL_MAX_FRAME_SIZE : i6;
    }

    @Override // e.j$J
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        interfaceC0257j$e.getClass();
        Iterator it = this.f9268b;
        if (it == null) {
            Collection collection = this.f9267a;
            Iterator it2 = collection.iterator();
            this.f9268b = it2;
            this.f9270d = collection.size();
            it = it2;
        }
        if (it instanceof InterfaceC0236j$j) {
            ((InterfaceC0236j$j) it).b(interfaceC0257j$e);
            return;
        }
        while (it.hasNext()) {
            interfaceC0257j$e.j(it.next());
        }
    }

    @Override // e.j$J
    public final int characteristics() {
        return this.f9269c;
    }

    @Override // e.j$J
    public final long estimateSize() {
        if (this.f9268b == null) {
            Collection collection = this.f9267a;
            this.f9268b = collection.iterator();
            long size = collection.size();
            this.f9270d = size;
            return size;
        }
        return this.f9270d;
    }

    @Override // e.j$J
    public Comparator getComparator() {
        if (AbstractC0227j$a.i(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    @Override // e.j$J
    public final /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0227j$a.h(this);
    }

    @Override // e.j$J
    public final /* synthetic */ boolean hasCharacteristics(int i6) {
        return AbstractC0227j$a.i(this, i6);
    }

    @Override // e.j$J
    public final boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        interfaceC0257j$e.getClass();
        if (this.f9268b == null) {
            Collection collection = this.f9267a;
            this.f9268b = collection.iterator();
            this.f9270d = collection.size();
        }
        if (this.f9268b.hasNext()) {
            interfaceC0257j$e.j(this.f9268b.next());
            return true;
        }
        return false;
    }

    @Override // e.j$J
    public final j$J trySplit() {
        long j6;
        Iterator it = this.f9268b;
        if (it == null) {
            Collection collection = this.f9267a;
            Iterator it2 = collection.iterator();
            this.f9268b = it2;
            j6 = collection.size();
            this.f9270d = j6;
            it = it2;
        } else {
            j6 = this.f9270d;
        }
        if (j6 <= 1 || !it.hasNext()) {
            return null;
        }
        int i6 = this.f9271e + Segment.SHARE_MINIMUM;
        if (i6 > j6) {
            i6 = (int) j6;
        }
        if (i6 > 33554432) {
            i6 = 33554432;
        }
        Object[] objArr = new Object[i6];
        int i7 = 0;
        do {
            objArr[i7] = it.next();
            i7++;
            if (i7 >= i6) {
                break;
            }
        } while (it.hasNext());
        this.f9271e = i7;
        long j7 = this.f9270d;
        if (j7 != Long.MAX_VALUE) {
            this.f9270d = j7 - i7;
        }
        return new j$O(objArr, 0, i7, this.f9269c);
    }
}
