package e;

import f.InterfaceC0257j$e;
import f.InterfaceC0272j$t;
import java.util.Comparator;
import okhttp3.internal.http2.Http2;
/* loaded from: classes2.dex */
final class j$U implements j$D {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f9263a;

    /* renamed from: b  reason: collision with root package name */
    private int f9264b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9265c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9266d;

    public j$U(int[] iArr, int i6, int i7, int i8) {
        this.f9263a = iArr;
        this.f9264b = i6;
        this.f9265c = i7;
        this.f9266d = i8 | 64 | Http2.INITIAL_MAX_FRAME_SIZE;
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.e(this, interfaceC0257j$e);
    }

    @Override // e.j$J
    public final int characteristics() {
        return this.f9266d;
    }

    @Override // e.j$J
    public final long estimateSize() {
        return this.f9265c - this.f9264b;
    }

    @Override // e.j$H
    /* renamed from: g */
    public final boolean tryAdvance(InterfaceC0272j$t interfaceC0272j$t) {
        interfaceC0272j$t.getClass();
        int i6 = this.f9264b;
        if (i6 < 0 || i6 >= this.f9265c) {
            return false;
        }
        this.f9264b = i6 + 1;
        interfaceC0272j$t.e(this.f9263a[i6]);
        return true;
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
    /* renamed from: l */
    public final void forEachRemaining(InterfaceC0272j$t interfaceC0272j$t) {
        int i6;
        interfaceC0272j$t.getClass();
        int[] iArr = this.f9263a;
        int length = iArr.length;
        int i7 = this.f9265c;
        if (length < i7 || (i6 = this.f9264b) < 0) {
            return;
        }
        this.f9264b = i7;
        if (i6 < i7) {
            do {
                interfaceC0272j$t.e(iArr[i6]);
                i6++;
            } while (i6 < i7);
        }
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.q(this, interfaceC0257j$e);
    }

    @Override // e.j$D, e.j$H, e.j$J
    public final j$D trySplit() {
        int i6 = this.f9264b;
        int i7 = (this.f9265c + i6) >>> 1;
        if (i6 >= i7) {
            return null;
        }
        this.f9264b = i7;
        return new j$U(this.f9263a, i6, i7, this.f9266d);
    }
}
