package h5;

import e5.k;
import e5.p;
import e5.q;
import g5.a;
import h5.e;
import java.util.List;
/* loaded from: classes.dex */
public class d extends h5.a {

    /* loaded from: classes.dex */
    public static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        private final List f10780b;

        /* renamed from: c  reason: collision with root package name */
        private final q f10781c;

        public a(List list, q qVar, k kVar) {
            super(kVar);
            this.f10780b = list;
            this.f10781c = qVar;
        }
    }

    public d(p pVar, char[] cArr, b5.e eVar, e.b bVar) {
        super(pVar, cArr, eVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h5.a, h5.e
    public a.c g() {
        return super.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h5.e
    /* renamed from: y */
    public long d(a aVar) {
        return o(aVar.f10780b, aVar.f10781c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h5.e
    /* renamed from: z */
    public void f(a aVar, g5.a aVar2) {
        x(aVar.f10781c);
        l(aVar.f10780b, aVar2, aVar.f10781c, aVar.f10779a);
    }
}
