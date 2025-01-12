package g;

import e.AbstractC0227j$a;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class j$R2 implements e.j$J {

    /* renamed from: a  reason: collision with root package name */
    final boolean f10078a;

    /* renamed from: b  reason: collision with root package name */
    final AbstractC0350j$s0 f10079b;

    /* renamed from: c  reason: collision with root package name */
    private f.j$V f10080c;

    /* renamed from: d  reason: collision with root package name */
    e.j$J f10081d;

    /* renamed from: e  reason: collision with root package name */
    InterfaceC0284j$b2 f10082e;

    /* renamed from: f  reason: collision with root package name */
    C0276j$a f10083f;

    /* renamed from: g  reason: collision with root package name */
    long f10084g;

    /* renamed from: h  reason: collision with root package name */
    AbstractC0293j$e f10085h;

    /* renamed from: i  reason: collision with root package name */
    boolean f10086i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$R2(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, boolean z5) {
        this.f10079b = abstractC0350j$s0;
        this.f10080c = null;
        this.f10081d = j_j;
        this.f10078a = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$R2(AbstractC0350j$s0 abstractC0350j$s0, C0276j$a c0276j$a, boolean z5) {
        this.f10079b = abstractC0350j$s0;
        this.f10080c = c0276j$a;
        this.f10081d = null;
        this.f10078a = z5;
    }

    private boolean d() {
        boolean r5;
        while (this.f10085h.count() == 0) {
            if (!this.f10082e.o()) {
                C0276j$a c0276j$a = this.f10083f;
                int i6 = c0276j$a.f10111a;
                Object obj = c0276j$a.f10112b;
                switch (i6) {
                    case 4:
                        C0280j$a3 c0280j$a3 = (C0280j$a3) obj;
                        r5 = c0280j$a3.f10081d.r(c0280j$a3.f10082e);
                        break;
                    case 5:
                        j$c3 j_c3 = (j$c3) obj;
                        r5 = j_c3.f10081d.r(j_c3.f10082e);
                        break;
                    case 6:
                        j$e3 j_e3 = (j$e3) obj;
                        r5 = j_e3.f10081d.r(j_e3.f10082e);
                        break;
                    default:
                        j$v3 j_v3 = (j$v3) obj;
                        r5 = j_v3.f10081d.r(j_v3.f10082e);
                        break;
                }
                if (r5) {
                    continue;
                }
            }
            if (this.f10086i) {
                return false;
            }
            this.f10082e.h();
            this.f10086i = true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        AbstractC0293j$e abstractC0293j$e = this.f10085h;
        if (abstractC0293j$e == null) {
            if (this.f10086i) {
                return false;
            }
            e();
            f();
            this.f10084g = 0L;
            this.f10082e.i(this.f10081d.getExactSizeIfKnown());
            return d();
        }
        long j6 = this.f10084g + 1;
        this.f10084g = j6;
        boolean z5 = j6 < abstractC0293j$e.count();
        if (z5) {
            return z5;
        }
        this.f10084g = 0L;
        this.f10085h.clear();
        return d();
    }

    @Override // e.j$J
    public final int characteristics() {
        e();
        int g6 = j$P2.g(this.f10079b.c0()) & j$P2.f10051k;
        return (g6 & 64) != 0 ? (g6 & (-16449)) | (this.f10081d.characteristics() & 16448) : g6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        if (this.f10081d == null) {
            this.f10081d = (e.j$J) this.f10080c.get();
            this.f10080c = null;
        }
    }

    @Override // e.j$J
    public final long estimateSize() {
        e();
        return this.f10081d.estimateSize();
    }

    abstract void f();

    @Override // e.j$J
    public final Comparator getComparator() {
        if (AbstractC0227j$a.i(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    @Override // e.j$J
    public final long getExactSizeIfKnown() {
        e();
        if (j$P2.f10049i.d(this.f10079b.c0())) {
            return this.f10081d.getExactSizeIfKnown();
        }
        return -1L;
    }

    abstract j$R2 h(e.j$J j_j);

    @Override // e.j$J
    public final /* synthetic */ boolean hasCharacteristics(int i6) {
        return AbstractC0227j$a.i(this, i6);
    }

    public final String toString() {
        return String.format("%s[%s]", getClass().getName(), this.f10081d);
    }

    @Override // e.j$J
    public e.j$J trySplit() {
        if (!this.f10078a || this.f10086i) {
            return null;
        }
        e();
        e.j$J trySplit = this.f10081d.trySplit();
        if (trySplit == null) {
            return null;
        }
        return h(trySplit);
    }
}
