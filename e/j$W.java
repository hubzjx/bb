package e;

import f.InterfaceC0257j$e;
import java.util.Comparator;
import okhttp3.internal.http2.Http2;
/* loaded from: classes2.dex */
final class j$W implements j$F {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f9272a;

    /* renamed from: b  reason: collision with root package name */
    private int f9273b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9274c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9275d;

    public j$W(long[] jArr, int i6, int i7, int i8) {
        this.f9272a = jArr;
        this.f9273b = i6;
        this.f9274c = i7;
        this.f9275d = i8 | 64 | Http2.INITIAL_MAX_FRAME_SIZE;
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.f(this, interfaceC0257j$e);
    }

    @Override // e.j$H
    /* renamed from: c */
    public final void forEachRemaining(f.j$E j_e) {
        int i6;
        j_e.getClass();
        long[] jArr = this.f9272a;
        int length = jArr.length;
        int i7 = this.f9274c;
        if (length < i7 || (i6 = this.f9273b) < 0) {
            return;
        }
        this.f9273b = i7;
        if (i6 < i7) {
            do {
                j_e.f(jArr[i6]);
                i6++;
            } while (i6 < i7);
        }
    }

    @Override // e.j$J
    public final int characteristics() {
        return this.f9275d;
    }

    @Override // e.j$J
    public final long estimateSize() {
        return this.f9274c - this.f9273b;
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

    @Override // e.j$H
    /* renamed from: p */
    public final boolean tryAdvance(f.j$E j_e) {
        j_e.getClass();
        int i6 = this.f9273b;
        if (i6 < 0 || i6 >= this.f9274c) {
            return false;
        }
        this.f9273b = i6 + 1;
        j_e.f(this.f9272a[i6]);
        return true;
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.s(this, interfaceC0257j$e);
    }

    @Override // e.j$F, e.j$H, e.j$J
    public final j$F trySplit() {
        int i6 = this.f9273b;
        int i7 = (this.f9274c + i6) >>> 1;
        if (i6 >= i7) {
            return null;
        }
        this.f9273b = i7;
        return new j$W(this.f9272a, i6, i7, this.f9275d);
    }
}
