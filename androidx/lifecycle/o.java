package androidx.lifecycle;

import java.util.HashMap;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f2004a = new HashMap();

    public final void a() {
        for (m mVar : this.f2004a.values()) {
            mVar.a();
        }
        this.f2004a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m b(String str) {
        return (m) this.f2004a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(String str, m mVar) {
        m mVar2 = (m) this.f2004a.put(str, mVar);
        if (mVar2 != null) {
            mVar2.c();
        }
    }
}
