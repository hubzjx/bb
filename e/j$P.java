package e;

import f.InterfaceC0257j$e;
import f.InterfaceC0261j$i;
import java.util.Comparator;
import okhttp3.internal.http2.Http2;
/* loaded from: classes2.dex */
final class j$P implements j$B {

    /* renamed from: a  reason: collision with root package name */
    private final double[] f9259a;

    /* renamed from: b  reason: collision with root package name */
    private int f9260b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9261c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9262d;

    public j$P(double[] dArr, int i6, int i7, int i8) {
        this.f9259a = dArr;
        this.f9260b = i6;
        this.f9261c = i7;
        this.f9262d = i8 | 64 | Http2.INITIAL_MAX_FRAME_SIZE;
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.d(this, interfaceC0257j$e);
    }

    @Override // e.j$J
    public final int characteristics() {
        return this.f9262d;
    }

    @Override // e.j$J
    public final long estimateSize() {
        return this.f9261c - this.f9260b;
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
    /* renamed from: k */
    public final void forEachRemaining(InterfaceC0261j$i interfaceC0261j$i) {
        int i6;
        interfaceC0261j$i.getClass();
        double[] dArr = this.f9259a;
        int length = dArr.length;
        int i7 = this.f9261c;
        if (length < i7 || (i6 = this.f9260b) < 0) {
            return;
        }
        this.f9260b = i7;
        if (i6 < i7) {
            do {
                interfaceC0261j$i.d(dArr[i6]);
                i6++;
            } while (i6 < i7);
        }
    }

    @Override // e.j$H
    /* renamed from: n */
    public final boolean tryAdvance(InterfaceC0261j$i interfaceC0261j$i) {
        interfaceC0261j$i.getClass();
        int i6 = this.f9260b;
        if (i6 < 0 || i6 >= this.f9261c) {
            return false;
        }
        this.f9260b = i6 + 1;
        interfaceC0261j$i.d(this.f9259a[i6]);
        return true;
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.o(this, interfaceC0257j$e);
    }

    @Override // e.j$B, e.j$H, e.j$J
    public final j$B trySplit() {
        int i6 = this.f9260b;
        int i7 = (this.f9261c + i6) >>> 1;
        if (i6 >= i7) {
            return null;
        }
        this.f9260b = i7;
        return new j$P(this.f9259a, i6, i7, this.f9262d);
    }
}
