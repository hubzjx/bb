package g;

import e.C0239j$m;
import f.InterfaceC0255j$c;
import f.InterfaceC0259j$g;
import f.InterfaceC0270j$r;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$v1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0363j$v1 extends AbstractC0350j$s0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10290h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Object f10291i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0363j$v1(int i6, Object obj, int i7) {
        super(i6);
        this.f10290h = i7;
        this.f10291i = obj;
    }

    @Override // g.AbstractC0350j$s0
    public final j$K1 q0() {
        int i6 = this.f10290h;
        Object obj = this.f10291i;
        switch (i6) {
            case 0:
                return new C0367j$w1((InterfaceC0259j$g) obj);
            case 1:
                final InterfaceC0255j$c interfaceC0255j$c = (InterfaceC0255j$c) obj;
                return new j$K1() { // from class: g.j$z1

                    /* renamed from: a  reason: collision with root package name */
                    private boolean f10311a;

                    /* renamed from: b  reason: collision with root package name */
                    private Object f10312b;

                    @Override // g.InterfaceC0284j$b2
                    public final /* synthetic */ void d(double d6) {
                        AbstractC0350j$s0.j();
                        throw null;
                    }

                    @Override // g.InterfaceC0284j$b2
                    public final /* synthetic */ void e(int i7) {
                        AbstractC0350j$s0.s();
                        throw null;
                    }

                    @Override // g.InterfaceC0284j$b2
                    public final /* synthetic */ void f(long j6) {
                        AbstractC0350j$s0.t();
                        throw null;
                    }

                    @Override // f.j$V
                    public final Object get() {
                        return this.f10311a ? C0239j$m.a() : C0239j$m.d(this.f10312b);
                    }

                    @Override // g.InterfaceC0284j$b2
                    public final /* synthetic */ void h() {
                    }

                    @Override // g.InterfaceC0284j$b2
                    public final void i(long j6) {
                        this.f10311a = true;
                        this.f10312b = null;
                    }

                    @Override // f.InterfaceC0257j$e
                    public final void j(Object obj2) {
                        if (this.f10311a) {
                            this.f10311a = false;
                        } else {
                            obj2 = InterfaceC0255j$c.this.p(this.f10312b, obj2);
                        }
                        this.f10312b = obj2;
                    }

                    @Override // g.InterfaceC0284j$b2
                    public final /* synthetic */ boolean o() {
                        return false;
                    }

                    @Override // g.j$K1
                    public final void v(j$K1 j_k1) {
                        C0379j$z1 c0379j$z1 = (C0379j$z1) j_k1;
                        if (c0379j$z1.f10311a) {
                            return;
                        }
                        j(c0379j$z1.f10312b);
                    }
                };
            case 2:
                return new j$F1((InterfaceC0270j$r) obj);
            default:
                return new j$J1((f.j$C) obj);
        }
    }
}
