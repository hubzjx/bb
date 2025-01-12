package t4;

import java.util.Iterator;
import p4.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class h {

    /* loaded from: classes.dex */
    public static final class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f13397a;

        public a(p pVar) {
            this.f13397a = pVar;
        }

        @Override // t4.d
        public Iterator iterator() {
            return h.a(this.f13397a);
        }
    }

    public static final Iterator a(p pVar) {
        j4.a a6;
        kotlin.jvm.internal.l.d(pVar, "block");
        e eVar = new e();
        a6 = kotlin.coroutines.intrinsics.c.a(pVar, eVar, eVar);
        eVar.d(a6);
        return eVar;
    }

    public static d b(p pVar) {
        kotlin.jvm.internal.l.d(pVar, "block");
        return new a(pVar);
    }
}
