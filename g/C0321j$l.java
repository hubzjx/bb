package g;

import f.C0264j$l;
import f.C0275j$w;
import f.InterfaceC0257j$e;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.BiConsumer;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: g.j$l  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0321j$l implements InterfaceC0257j$e, f.j$V {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10197a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f10198b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f10199c;

    public /* synthetic */ C0321j$l(int i6, Object obj, Object obj2) {
        this.f10197a = i6;
        this.f10198b = obj;
        this.f10199c = obj2;
    }

    @Override // f.j$V
    public final Object get() {
        int i6 = this.f10197a;
        Object obj = this.f10199c;
        Object obj2 = this.f10198b;
        switch (i6) {
            case 1:
                return new C0322j$l0((C0275j$w) obj, (EnumC0338j$p0) obj2);
            case 2:
                final EnumC0338j$p0 enumC0338j$p0 = (EnumC0338j$p0) obj2;
                final f.j$T j_t = (f.j$T) obj;
                return new AbstractC0334j$o0(j_t, enumC0338j$p0) { // from class: g.j$k0

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ EnumC0338j$p0 f10188c;

                    /* renamed from: d  reason: collision with root package name */
                    final /* synthetic */ f.j$T f10189d;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(enumC0338j$p0);
                        this.f10188c = enumC0338j$p0;
                    }

                    @Override // f.InterfaceC0257j$e
                    public final void j(Object obj3) {
                        boolean z5;
                        boolean z6;
                        if (this.f10227a) {
                            return;
                        }
                        boolean l6 = this.f10189d.l(obj3);
                        EnumC0338j$p0 enumC0338j$p02 = this.f10188c;
                        z5 = enumC0338j$p02.f10238a;
                        if (l6 == z5) {
                            this.f10227a = true;
                            z6 = enumC0338j$p02.f10239b;
                            this.f10228b = z6;
                        }
                    }
                };
            case 3:
                return new C0330j$n0((C0264j$l) obj, (EnumC0338j$p0) obj2);
            default:
                return new C0326j$m0((f.j$H) obj, (EnumC0338j$p0) obj2);
        }
    }

    @Override // f.InterfaceC0257j$e
    public final void j(Object obj) {
        int i6 = this.f10197a;
        Object obj2 = this.f10199c;
        Object obj3 = this.f10198b;
        switch (i6) {
            case 0:
                AtomicBoolean atomicBoolean = (AtomicBoolean) obj3;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) obj2;
                if (obj == null) {
                    atomicBoolean.set(true);
                    return;
                } else {
                    concurrentHashMap.putIfAbsent(obj, Boolean.TRUE);
                    return;
                }
            case 5:
                ((BiConsumer) obj3).n(obj2, obj);
                return;
            default:
                ((j$Y2) obj3).t((InterfaceC0257j$e) obj2, obj);
                return;
        }
    }
}
