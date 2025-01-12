package g;

import f.InterfaceC0255j$c;
import java.util.concurrent.CountedCompleter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j$H0 extends AbstractC0297j$f {

    /* renamed from: h  reason: collision with root package name */
    protected final AbstractC0350j$s0 f9993h;

    /* renamed from: i  reason: collision with root package name */
    protected final f.j$G f9994i;

    /* renamed from: j  reason: collision with root package name */
    protected final InterfaceC0255j$c f9995j;

    j$H0(j$H0 j_h0, e.j$J j_j) {
        super(j_h0, j_j);
        this.f9993h = j_h0.f9993h;
        this.f9994i = j_h0.f9994i;
        this.f9995j = j_h0.f9995j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$H0(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, f.j$G j_g, j$F0 j_f0) {
        super(abstractC0350j$s0, j_j);
        this.f9993h = abstractC0350j$s0;
        this.f9994i = j_g;
        this.f9995j = j_f0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.AbstractC0297j$f
    public final Object a() {
        InterfaceC0366j$w0 interfaceC0366j$w0 = (InterfaceC0366j$w0) this.f9994i.t(this.f9993h.W(this.f10155b));
        this.f9993h.s0(this.f10155b, interfaceC0366j$w0);
        return interfaceC0366j$w0.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.AbstractC0297j$f
    public final AbstractC0297j$f d(e.j$J j_j) {
        return new j$H0(this, j_j);
    }

    @Override // g.AbstractC0297j$f, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        AbstractC0297j$f abstractC0297j$f = this.f10157d;
        if (!(abstractC0297j$f == null)) {
            e((j$B0) this.f9995j.p((j$B0) ((j$H0) abstractC0297j$f).b(), (j$B0) ((j$H0) this.f10158e).b()));
        }
        super.onCompletion(countedCompleter);
    }
}
