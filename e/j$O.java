package e;

import f.InterfaceC0257j$e;
import java.util.Comparator;
import okhttp3.internal.http2.Http2;
/* loaded from: classes2.dex */
final class j$O implements j$J {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f9255a;

    /* renamed from: b  reason: collision with root package name */
    private int f9256b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9257c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9258d;

    public j$O(Object[] objArr, int i6, int i7, int i8) {
        this.f9255a = objArr;
        this.f9256b = i6;
        this.f9257c = i7;
        this.f9258d = i8 | 64 | Http2.INITIAL_MAX_FRAME_SIZE;
    }

    @Override // e.j$J
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        int i6;
        interfaceC0257j$e.getClass();
        Object[] objArr = this.f9255a;
        int length = objArr.length;
        int i7 = this.f9257c;
        if (length < i7 || (i6 = this.f9256b) < 0) {
            return;
        }
        this.f9256b = i7;
        if (i6 < i7) {
            do {
                interfaceC0257j$e.j(objArr[i6]);
                i6++;
            } while (i6 < i7);
        }
    }

    @Override // e.j$J
    public final int characteristics() {
        return this.f9258d;
    }

    @Override // e.j$J
    public final long estimateSize() {
        return this.f9257c - this.f9256b;
    }

    @Override // e.j$J
    public final Comparator getComparator() {
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
        int i6 = this.f9256b;
        if (i6 < 0 || i6 >= this.f9257c) {
            return false;
        }
        this.f9256b = i6 + 1;
        interfaceC0257j$e.j(this.f9255a[i6]);
        return true;
    }

    @Override // e.j$J
    public final j$J trySplit() {
        int i6 = this.f9256b;
        int i7 = (this.f9257c + i6) >>> 1;
        if (i6 >= i7) {
            return null;
        }
        this.f9256b = i7;
        return new j$O(this.f9255a, i6, i7, this.f9258d);
    }
}
