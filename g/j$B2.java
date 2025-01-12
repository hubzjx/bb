package g;

import e.AbstractC0227j$a;
import f.InterfaceC0257j$e;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$B2 implements e.j$J {

    /* renamed from: a  reason: collision with root package name */
    int f9958a;

    /* renamed from: b  reason: collision with root package name */
    final int f9959b;

    /* renamed from: c  reason: collision with root package name */
    int f9960c;

    /* renamed from: d  reason: collision with root package name */
    final int f9961d;

    /* renamed from: e  reason: collision with root package name */
    Object[] f9962e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ j$K2 f9963f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$B2(j$K2 j_k2, int i6, int i7, int i8, int i9) {
        this.f9963f = j_k2;
        this.f9958a = i6;
        this.f9959b = i7;
        this.f9960c = i8;
        this.f9961d = i9;
        Object[][] objArr = j_k2.f10017f;
        this.f9962e = objArr == null ? j_k2.f10016e : objArr[i6];
    }

    @Override // e.j$J
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        j$K2 j_k2;
        interfaceC0257j$e.getClass();
        int i6 = this.f9958a;
        int i7 = this.f9961d;
        int i8 = this.f9959b;
        if (i6 < i8 || (i6 == i8 && this.f9960c < i7)) {
            int i9 = this.f9960c;
            while (true) {
                j_k2 = this.f9963f;
                if (i6 >= i8) {
                    break;
                }
                Object[] objArr = j_k2.f10017f[i6];
                while (i9 < objArr.length) {
                    interfaceC0257j$e.j(objArr[i9]);
                    i9++;
                }
                i6++;
                i9 = 0;
            }
            Object[] objArr2 = this.f9958a == i8 ? this.f9962e : j_k2.f10017f[i8];
            while (i9 < i7) {
                interfaceC0257j$e.j(objArr2[i9]);
                i9++;
            }
            this.f9958a = i8;
            this.f9960c = i7;
        }
    }

    @Override // e.j$J
    public final int characteristics() {
        return 16464;
    }

    @Override // e.j$J
    public final long estimateSize() {
        int i6 = this.f9958a;
        int i7 = this.f9961d;
        int i8 = this.f9959b;
        if (i6 == i8) {
            return i7 - this.f9960c;
        }
        long[] jArr = this.f9963f.f10144d;
        return ((jArr[i8] + i7) - jArr[i6]) - this.f9960c;
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

    @Override // e.j$J
    public final boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        interfaceC0257j$e.getClass();
        int i6 = this.f9958a;
        int i7 = this.f9959b;
        if (i6 < i7 || (i6 == i7 && this.f9960c < this.f9961d)) {
            Object[] objArr = this.f9962e;
            int i8 = this.f9960c;
            this.f9960c = i8 + 1;
            interfaceC0257j$e.j(objArr[i8]);
            if (this.f9960c == this.f9962e.length) {
                this.f9960c = 0;
                int i9 = this.f9958a + 1;
                this.f9958a = i9;
                Object[][] objArr2 = this.f9963f.f10017f;
                if (objArr2 != null && i9 <= i7) {
                    this.f9962e = objArr2[i9];
                }
            }
            return true;
        }
        return false;
    }

    @Override // e.j$J
    public final e.j$J trySplit() {
        int i6 = this.f9958a;
        int i7 = this.f9959b;
        if (i6 < i7) {
            int i8 = i7 - 1;
            int i9 = this.f9960c;
            j$K2 j_k2 = this.f9963f;
            j$B2 j_b2 = new j$B2(j_k2, i6, i8, i9, j_k2.f10017f[i8].length);
            this.f9958a = i7;
            this.f9960c = 0;
            this.f9962e = j_k2.f10017f[i7];
            return j_b2;
        } else if (i6 == i7) {
            int i10 = this.f9960c;
            int i11 = (this.f9961d - i10) / 2;
            if (i11 == 0) {
                return null;
            }
            e.j$J m5 = e.j$X.m(this.f9962e, i10, i10 + i11);
            this.f9960c += i11;
            return m5;
        } else {
            return null;
        }
    }
}
