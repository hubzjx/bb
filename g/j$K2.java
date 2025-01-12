package g;

import f.C0256j$d;
import f.InterfaceC0257j$e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j$K2 extends AbstractC0293j$e implements InterfaceC0257j$e, Iterable {

    /* renamed from: e  reason: collision with root package name */
    protected Object[] f10016e = new Object[1 << 4];

    /* renamed from: f  reason: collision with root package name */
    protected Object[][] f10017f;

    public void b(InterfaceC0257j$e interfaceC0257j$e) {
        for (int i6 = 0; i6 < this.f10143c; i6++) {
            for (Object obj : this.f10017f[i6]) {
                interfaceC0257j$e.j(obj);
            }
        }
        for (int i7 = 0; i7 < this.f10142b; i7++) {
            interfaceC0257j$e.j(this.f10016e[i7]);
        }
    }

    @Override // g.AbstractC0293j$e
    public final void clear() {
        Object[][] objArr = this.f10017f;
        if (objArr != null) {
            this.f10016e = objArr[0];
            int i6 = 0;
            while (true) {
                Object[] objArr2 = this.f10016e;
                if (i6 >= objArr2.length) {
                    break;
                }
                objArr2[i6] = null;
                i6++;
            }
            this.f10017f = null;
            this.f10144d = null;
        } else {
            for (int i7 = 0; i7 < this.f10142b; i7++) {
                this.f10016e[i7] = null;
            }
        }
        this.f10142b = 0;
        this.f10143c = 0;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ void forEach(Consumer consumer) {
        b(C0256j$d.b(consumer));
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return e.j$X.i(spliterator());
    }

    @Override // f.InterfaceC0257j$e
    public void j(Object obj) {
        long length;
        int i6 = this.f10142b;
        Object[] objArr = this.f10016e;
        if (i6 == objArr.length) {
            if (this.f10017f == null) {
                Object[][] objArr2 = new Object[8];
                this.f10017f = objArr2;
                this.f10144d = new long[8];
                objArr2[0] = objArr;
            }
            int i7 = this.f10143c;
            int i8 = i7 + 1;
            Object[][] objArr3 = this.f10017f;
            if (i8 >= objArr3.length || objArr3[i8] == null) {
                if (i7 == 0) {
                    length = objArr.length;
                } else {
                    length = objArr3[i7].length + this.f10144d[i7];
                }
                w(length + 1);
            }
            this.f10142b = 0;
            int i9 = this.f10143c + 1;
            this.f10143c = i9;
            this.f10016e = this.f10017f[i9];
        }
        Object[] objArr4 = this.f10016e;
        int i10 = this.f10142b;
        this.f10142b = i10 + 1;
        objArr4[i10] = obj;
    }

    @Override // java.lang.Iterable
    public e.j$J spliterator() {
        return new j$B2(this, 0, this.f10143c, 0, this.f10142b);
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return e.j$I.a(spliterator());
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        b(new C0276j$a(8, arrayList));
        return "SpinedBuffer:" + arrayList.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w(long j6) {
        long length;
        Object[][] objArr;
        int i6;
        int i7 = this.f10143c;
        if (i7 == 0) {
            length = this.f10016e.length;
        } else {
            length = this.f10017f[i7].length + this.f10144d[i7];
        }
        if (j6 <= length) {
            return;
        }
        if (this.f10017f == null) {
            Object[][] objArr2 = new Object[8];
            this.f10017f = objArr2;
            this.f10144d = new long[8];
            objArr2[0] = this.f10016e;
        }
        while (true) {
            i7++;
            if (j6 <= length) {
                return;
            }
            Object[][] objArr3 = this.f10017f;
            if (i7 >= objArr3.length) {
                int length2 = objArr3.length * 2;
                this.f10017f = (Object[][]) Arrays.copyOf(objArr3, length2);
                this.f10144d = Arrays.copyOf(this.f10144d, length2);
            }
            int i8 = this.f10141a;
            if (i7 != 0 && i7 != 1) {
                i8 = Math.min((i8 + i7) - 1, 30);
            }
            int i9 = 1 << i8;
            this.f10017f[i7] = new Object[i9];
            long[] jArr = this.f10144d;
            jArr[i7] = jArr[i7 - 1] + objArr[i6].length;
            length += i9;
        }
    }
}
