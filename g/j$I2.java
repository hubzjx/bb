package g;

import e.AbstractC0227j$a;
import java.util.Comparator;
/* loaded from: classes2.dex */
abstract class j$I2 implements e.j$H {

    /* renamed from: a  reason: collision with root package name */
    int f10003a;

    /* renamed from: b  reason: collision with root package name */
    final int f10004b;

    /* renamed from: c  reason: collision with root package name */
    int f10005c;

    /* renamed from: d  reason: collision with root package name */
    final int f10006d;

    /* renamed from: e  reason: collision with root package name */
    Object f10007e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ j$J2 f10008f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$I2(j$J2 j_j2, int i6, int i7, int i8, int i9) {
        this.f10008f = j_j2;
        this.f10003a = i6;
        this.f10004b = i7;
        this.f10005c = i8;
        this.f10006d = i9;
        Object[] objArr = j_j2.f10014f;
        this.f10007e = objArr == null ? j_j2.f10013e : objArr[i6];
    }

    abstract void a(int i6, Object obj, Object obj2);

    @Override // e.j$J
    public final int characteristics() {
        return 16464;
    }

    abstract e.j$H d(Object obj, int i6, int i7);

    abstract e.j$H e(int i6, int i7, int i8, int i9);

    @Override // e.j$J
    public final long estimateSize() {
        int i6 = this.f10003a;
        int i7 = this.f10006d;
        int i8 = this.f10004b;
        if (i6 == i8) {
            return i7 - this.f10005c;
        }
        long[] jArr = this.f10008f.f10144d;
        return ((jArr[i8] + i7) - jArr[i6]) - this.f10005c;
    }

    @Override // e.j$H
    /* renamed from: forEachRemaining */
    public final void l(Object obj) {
        j$J2 j_j2;
        obj.getClass();
        int i6 = this.f10003a;
        int i7 = this.f10006d;
        int i8 = this.f10004b;
        if (i6 < i8 || (i6 == i8 && this.f10005c < i7)) {
            int i9 = this.f10005c;
            while (true) {
                j_j2 = this.f10008f;
                if (i6 >= i8) {
                    break;
                }
                Object obj2 = j_j2.f10014f[i6];
                j_j2.w(obj2, i9, j_j2.x(obj2), obj);
                i6++;
                i9 = 0;
            }
            j_j2.w(this.f10003a == i8 ? this.f10007e : j_j2.f10014f[i8], i9, i7, obj);
            this.f10003a = i8;
            this.f10005c = i7;
        }
    }

    @Override // e.j$J
    public final Comparator getComparator() {
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
    /* renamed from: tryAdvance */
    public final boolean p(Object obj) {
        obj.getClass();
        int i6 = this.f10003a;
        int i7 = this.f10004b;
        if (i6 < i7 || (i6 == i7 && this.f10005c < this.f10006d)) {
            Object obj2 = this.f10007e;
            int i8 = this.f10005c;
            this.f10005c = i8 + 1;
            a(i8, obj2, obj);
            int i9 = this.f10005c;
            Object obj3 = this.f10007e;
            j$J2 j_j2 = this.f10008f;
            if (i9 == j_j2.x(obj3)) {
                this.f10005c = 0;
                int i10 = this.f10003a + 1;
                this.f10003a = i10;
                Object[] objArr = j_j2.f10014f;
                if (objArr != null && i10 <= i7) {
                    this.f10007e = objArr[i10];
                }
            }
            return true;
        }
        return false;
    }

    @Override // e.j$H, e.j$J
    public /* bridge */ /* synthetic */ e.j$B trySplit() {
        return (e.j$B) trySplit();
    }

    @Override // e.j$H, e.j$J
    public /* bridge */ /* synthetic */ e.j$D trySplit() {
        return (e.j$D) trySplit();
    }

    @Override // e.j$H, e.j$J
    public /* bridge */ /* synthetic */ e.j$F trySplit() {
        return (e.j$F) trySplit();
    }

    @Override // e.j$H, e.j$J
    public final e.j$H trySplit() {
        int i6 = this.f10003a;
        int i7 = this.f10004b;
        if (i6 < i7) {
            int i8 = this.f10005c;
            j$J2 j_j2 = this.f10008f;
            e.j$H e6 = e(i6, i7 - 1, i8, j_j2.x(j_j2.f10014f[i7 - 1]));
            this.f10003a = i7;
            this.f10005c = 0;
            this.f10007e = j_j2.f10014f[i7];
            return e6;
        } else if (i6 == i7) {
            int i9 = this.f10005c;
            int i10 = (this.f10006d - i9) / 2;
            if (i10 == 0) {
                return null;
            }
            e.j$H d6 = d(this.f10007e, i9, i10);
            this.f10005c += i10;
            return d6;
        } else {
            return null;
        }
    }
}
