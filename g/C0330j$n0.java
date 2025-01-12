package g;

import f.C0264j$l;
/* renamed from: g.j$n0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0330j$n0 extends AbstractC0334j$o0 implements j$Y1 {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ EnumC0338j$p0 f10219c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0264j$l f10220d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0330j$n0(C0264j$l c0264j$l, EnumC0338j$p0 enumC0338j$p0) {
        super(enumC0338j$p0);
        this.f10219c = enumC0338j$p0;
        this.f10220d = c0264j$l;
    }

    @Override // g.AbstractC0334j$o0, g.InterfaceC0284j$b2
    public final void d(double d6) {
        boolean z5;
        boolean z6;
        if (this.f10227a) {
            return;
        }
        boolean test = this.f10220d.f9719a.test(d6);
        EnumC0338j$p0 enumC0338j$p0 = this.f10219c;
        z5 = enumC0338j$p0.f10238a;
        if (test == z5) {
            this.f10227a = true;
            z6 = enumC0338j$p0.f10239b;
            this.f10228b = z6;
        }
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        s((Double) obj);
    }

    @Override // g.j$Y1
    public final /* synthetic */ void s(Double d6) {
        AbstractC0350j$s0.m(this, d6);
    }
}
