package g;

import f.C0275j$w;
/* renamed from: g.j$l0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0322j$l0 extends AbstractC0334j$o0 implements j$Z1 {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ EnumC0338j$p0 f10200c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0275j$w f10201d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0322j$l0(C0275j$w c0275j$w, EnumC0338j$p0 enumC0338j$p0) {
        super(enumC0338j$p0);
        this.f10200c = enumC0338j$p0;
        this.f10201d = c0275j$w;
    }

    @Override // g.AbstractC0334j$o0, g.InterfaceC0284j$b2
    public final void e(int i6) {
        boolean z5;
        boolean z6;
        if (this.f10227a) {
            return;
        }
        boolean test = this.f10201d.f9726a.test(i6);
        EnumC0338j$p0 enumC0338j$p0 = this.f10200c;
        z5 = enumC0338j$p0.f10238a;
        if (test == z5) {
            this.f10227a = true;
            z6 = enumC0338j$p0.f10239b;
            this.f10228b = z6;
        }
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        m((Integer) obj);
    }

    @Override // g.j$Z1
    public final /* synthetic */ void m(Integer num) {
        AbstractC0350j$s0.o(this, num);
    }
}
