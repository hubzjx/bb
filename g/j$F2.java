package g;

import f.InterfaceC0257j$e;
import f.InterfaceC0272j$t;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes2.dex */
class j$F2 extends j$J2 implements InterfaceC0272j$t {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j$F2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$F2(int i6) {
        super(i6);
    }

    @Override // g.j$J2
    protected final Object[] A() {
        return new int[8];
    }

    @Override // g.j$J2, java.lang.Iterable
    /* renamed from: C */
    public e.j$D spliterator() {
        return new j$E2(this, 0, this.f10143c, 0, this.f10142b);
    }

    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof InterfaceC0272j$t) {
            l((InterfaceC0272j$t) interfaceC0257j$e);
        } else if (j$A3.f9953a) {
            j$A3.a(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
            throw null;
        } else {
            spliterator().b(interfaceC0257j$e);
        }
    }

    @Override // f.InterfaceC0272j$t
    public void e(int i6) {
        B();
        int i7 = this.f10142b;
        this.f10142b = i7 + 1;
        ((int[]) this.f10013e)[i7] = i6;
    }

    @Override // g.j$J2
    public final Object g(int i6) {
        return new int[i6];
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return e.j$X.g(spliterator());
    }

    public final String toString() {
        int[] iArr = (int[]) k();
        return iArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f10143c), Arrays.toString(iArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f10143c), Arrays.toString(Arrays.copyOf(iArr, 200)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.j$J2
    public final void w(Object obj, int i6, int i7, Object obj2) {
        int[] iArr = (int[]) obj;
        InterfaceC0272j$t interfaceC0272j$t = (InterfaceC0272j$t) obj2;
        while (i6 < i7) {
            interfaceC0272j$t.e(iArr[i6]);
            i6++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.j$J2
    public final int x(Object obj) {
        return ((int[]) obj).length;
    }
}
