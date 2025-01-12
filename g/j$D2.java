package g;

import f.InterfaceC0257j$e;
import f.InterfaceC0261j$i;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes2.dex */
class j$D2 extends j$J2 implements InterfaceC0261j$i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j$D2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$D2(int i6) {
        super(i6);
    }

    @Override // g.j$J2
    protected final Object[] A() {
        return new double[8];
    }

    @Override // g.j$J2, java.lang.Iterable
    /* renamed from: C */
    public e.j$B spliterator() {
        return new j$C2(this, 0, this.f10143c, 0, this.f10142b);
    }

    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof InterfaceC0261j$i) {
            l((InterfaceC0261j$i) interfaceC0257j$e);
        } else if (j$A3.f9953a) {
            j$A3.a(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
            throw null;
        } else {
            spliterator().b(interfaceC0257j$e);
        }
    }

    @Override // f.InterfaceC0261j$i
    public void d(double d6) {
        B();
        int i6 = this.f10142b;
        this.f10142b = i6 + 1;
        ((double[]) this.f10013e)[i6] = d6;
    }

    @Override // g.j$J2
    public final Object g(int i6) {
        return new double[i6];
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return e.j$X.f(spliterator());
    }

    public final String toString() {
        double[] dArr = (double[]) k();
        return dArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f10143c), Arrays.toString(dArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f10143c), Arrays.toString(Arrays.copyOf(dArr, 200)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.j$J2
    public final void w(Object obj, int i6, int i7, Object obj2) {
        double[] dArr = (double[]) obj;
        InterfaceC0261j$i interfaceC0261j$i = (InterfaceC0261j$i) obj2;
        while (i6 < i7) {
            interfaceC0261j$i.d(dArr[i6]);
            i6++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.j$J2
    public final int x(Object obj) {
        return ((double[]) obj).length;
    }
}
