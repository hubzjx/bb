package g;

import e.AbstractC0227j$a;
import f.InterfaceC0257j$e;
import java.util.Comparator;
/* loaded from: classes2.dex */
final class j$s3 extends j$t3 implements e.j$J, InterfaceC0257j$e {

    /* renamed from: e  reason: collision with root package name */
    Object f10272e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$s3(e.j$J j_j, long j6, long j7) {
        super(j_j, j6, j7);
    }

    j$s3(e.j$J j_j, j$s3 j_s3) {
        super(j_j, j_s3);
    }

    @Override // e.j$J
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        interfaceC0257j$e.getClass();
        j$W2 j_w2 = null;
        while (true) {
            int w5 = w();
            if (w5 == 1) {
                return;
            }
            e.j$J j_j = this.f10277a;
            if (w5 != 2) {
                j_j.b(interfaceC0257j$e);
                return;
            }
            if (j_w2 == null) {
                j_w2 = new j$W2();
            } else {
                j_w2.f10103a = 0;
            }
            long j6 = 0;
            while (j_j.r(j_w2)) {
                j6++;
                if (j6 >= 128) {
                    break;
                }
            }
            if (j6 == 0) {
                return;
            }
            long t5 = t(j6);
            for (int i6 = 0; i6 < t5; i6++) {
                interfaceC0257j$e.j(j_w2.f10101b[i6]);
            }
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

    @Override // f.InterfaceC0257j$e
    public final void j(Object obj) {
        this.f10272e = obj;
    }

    @Override // e.j$J
    public final boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        interfaceC0257j$e.getClass();
        while (w() != 1 && this.f10277a.r(this)) {
            if (t(1L) == 1) {
                interfaceC0257j$e.j(this.f10272e);
                this.f10272e = null;
                return true;
            }
        }
        return false;
    }

    @Override // g.j$t3
    protected final e.j$J u(e.j$J j_j) {
        return new j$s3(j_j, this);
    }
}
