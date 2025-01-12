package g;

import f.InterfaceC0257j$e;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes2.dex */
class j$H2 extends j$J2 implements f.j$E {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j$H2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$H2(int i6) {
        super(i6);
    }

    @Override // g.j$J2
    protected final Object[] A() {
        return new long[8];
    }

    @Override // g.j$J2, java.lang.Iterable
    /* renamed from: C */
    public e.j$F spliterator() {
        return new j$G2(this, 0, this.f10143c, 0, this.f10142b);
    }

    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof f.j$E) {
            l((f.j$E) interfaceC0257j$e);
        } else if (j$A3.f9953a) {
            j$A3.a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
            throw null;
        } else {
            spliterator().b(interfaceC0257j$e);
        }
    }

    @Override // f.j$E
    public void f(long j6) {
        B();
        int i6 = this.f10142b;
        this.f10142b = i6 + 1;
        ((long[]) this.f10013e)[i6] = j6;
    }

    @Override // g.j$J2
    public final Object g(int i6) {
        return new long[i6];
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return e.j$X.h(spliterator());
    }

    public final String toString() {
        long[] jArr = (long[]) k();
        return jArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f10143c), Arrays.toString(jArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f10143c), Arrays.toString(Arrays.copyOf(jArr, 200)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.j$J2
    public final void w(Object obj, int i6, int i7, Object obj2) {
        long[] jArr = (long[]) obj;
        f.j$E j_e = (f.j$E) obj2;
        while (i6 < i7) {
            j_e.f(jArr[i6]);
            i6++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.j$J2
    public final int x(Object obj) {
        return ((long[]) obj).length;
    }
}
