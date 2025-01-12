package g;

import f.InterfaceC0257j$e;
import f.InterfaceC0274j$v;
import java.util.List;
/* renamed from: g.j$a  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0276j$a implements f.j$V, f.j$G, InterfaceC0257j$e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10111a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f10112b;

    public /* synthetic */ C0276j$a(int i6, Object obj) {
        this.f10111a = i6;
        this.f10112b = obj;
    }

    @Override // f.j$V
    public final Object get() {
        int i6 = this.f10111a;
        Object obj = this.f10112b;
        switch (i6) {
            case 0:
                return (e.j$J) obj;
            default:
                return ((AbstractC0285j$c) obj).C0();
        }
    }

    @Override // f.InterfaceC0257j$e
    public final void j(Object obj) {
        int i6 = this.f10111a;
        Object obj2 = this.f10112b;
        switch (i6) {
            case 3:
                ((InterfaceC0284j$b2) obj2).j(obj);
                return;
            default:
                ((List) obj2).add(obj);
                return;
        }
    }

    @Override // f.j$G
    public final Object t(long j6) {
        int i6 = j$G0.f9988k;
        return AbstractC0350j$s0.L(j6, (InterfaceC0274j$v) this.f10112b);
    }
}
