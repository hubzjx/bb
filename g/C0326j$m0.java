package g;
/* renamed from: g.j$m0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0326j$m0 extends AbstractC0334j$o0 implements InterfaceC0279j$a2 {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ EnumC0338j$p0 f10206c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ f.j$H f10207d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0326j$m0(f.j$H j_h, EnumC0338j$p0 enumC0338j$p0) {
        super(enumC0338j$p0);
        this.f10206c = enumC0338j$p0;
        this.f10207d = j_h;
    }

    @Override // g.AbstractC0334j$o0, g.InterfaceC0284j$b2
    public final void f(long j6) {
        boolean z5;
        boolean z6;
        if (this.f10227a) {
            return;
        }
        boolean test = this.f10207d.f9702a.test(j6);
        EnumC0338j$p0 enumC0338j$p0 = this.f10206c;
        z5 = enumC0338j$p0.f10238a;
        if (test == z5) {
            this.f10227a = true;
            z6 = enumC0338j$p0.f10239b;
            this.f10228b = z6;
        }
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        q((Long) obj);
    }

    @Override // g.InterfaceC0279j$a2
    public final /* synthetic */ void q(Long l6) {
        AbstractC0350j$s0.q(this, l6);
    }
}
