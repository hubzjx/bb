package g;

import f.InterfaceC0257j$e;
/* loaded from: classes2.dex */
final class j$v3 extends j$R2 {
    j$v3(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, boolean z5) {
        super(abstractC0350j$s0, j_j, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$v3(AbstractC0350j$s0 abstractC0350j$s0, C0276j$a c0276j$a, boolean z5) {
        super(abstractC0350j$s0, c0276j$a, z5);
    }

    @Override // e.j$J
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        if (this.f10085h != null || this.f10086i) {
            do {
            } while (r(interfaceC0257j$e));
            return;
        }
        interfaceC0257j$e.getClass();
        e();
        j$u3 j_u3 = new j$u3(interfaceC0257j$e, 1);
        this.f10079b.s0(this.f10081d, j_u3);
        this.f10086i = true;
    }

    @Override // g.j$R2
    final void f() {
        j$K2 j_k2 = new j$K2();
        this.f10085h = j_k2;
        this.f10082e = this.f10079b.t0(new j$u3(j_k2, 0));
        this.f10083f = new C0276j$a(7, this);
    }

    @Override // g.j$R2
    final j$R2 h(e.j$J j_j) {
        return new j$v3(this.f10079b, j_j, this.f10078a);
    }

    @Override // e.j$J
    public final boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        Object obj;
        interfaceC0257j$e.getClass();
        boolean a6 = a();
        if (a6) {
            j$K2 j_k2 = (j$K2) this.f10085h;
            long j6 = this.f10084g;
            if (j_k2.f10143c != 0) {
                if (j6 < j_k2.count()) {
                    for (int i6 = 0; i6 <= j_k2.f10143c; i6++) {
                        long j7 = j_k2.f10144d[i6];
                        Object[] objArr = j_k2.f10017f[i6];
                        if (j6 < objArr.length + j7) {
                            obj = objArr[(int) (j6 - j7)];
                        }
                    }
                    throw new IndexOutOfBoundsException(Long.toString(j6));
                }
                throw new IndexOutOfBoundsException(Long.toString(j6));
            } else if (j6 >= j_k2.f10142b) {
                throw new IndexOutOfBoundsException(Long.toString(j6));
            } else {
                obj = j_k2.f10016e[(int) j6];
            }
            interfaceC0257j$e.j(obj);
        }
        return a6;
    }
}
