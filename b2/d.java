package b2;

import java.util.List;
import q2.f0;
/* loaded from: classes.dex */
public final class d implements i {

    /* renamed from: a  reason: collision with root package name */
    private final i f2937a;

    /* renamed from: b  reason: collision with root package name */
    private final List f2938b;

    public d(i iVar, List list) {
        this.f2937a = iVar;
        this.f2938b = list;
    }

    @Override // b2.i
    public f0.a a(e eVar) {
        return new u1.d(this.f2937a.a(eVar), this.f2938b);
    }

    @Override // b2.i
    public f0.a b() {
        return new u1.d(this.f2937a.b(), this.f2938b);
    }
}
