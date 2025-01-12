package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f236a;

    /* renamed from: b  reason: collision with root package name */
    private CopyOnWriteArrayList f237b = new CopyOnWriteArrayList();

    public b(boolean z5) {
        this.f236a = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f237b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f236a;
    }

    public final void d() {
        Iterator it = this.f237b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(a aVar) {
        this.f237b.remove(aVar);
    }

    public final void f(boolean z5) {
        this.f236a = z5;
    }
}
