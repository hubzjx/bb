package androidx.activity;

import androidx.lifecycle.c;
import androidx.lifecycle.d;
import androidx.lifecycle.f;
import java.util.ArrayDeque;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f228a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayDeque f229b = new ArrayDeque();

    /* loaded from: classes.dex */
    private class LifecycleOnBackPressedCancellable implements d, androidx.activity.a {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.lifecycle.c f230a;

        /* renamed from: b  reason: collision with root package name */
        private final b f231b;

        /* renamed from: c  reason: collision with root package name */
        private androidx.activity.a f232c;

        LifecycleOnBackPressedCancellable(androidx.lifecycle.c cVar, b bVar) {
            this.f230a = cVar;
            this.f231b = bVar;
            cVar.a(this);
        }

        @Override // androidx.lifecycle.d
        public void a(f fVar, c.a aVar) {
            if (aVar == c.a.ON_START) {
                this.f232c = OnBackPressedDispatcher.this.b(this.f231b);
            } else if (aVar != c.a.ON_STOP) {
                if (aVar == c.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.a aVar2 = this.f232c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            }
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f230a.c(this);
            this.f231b.e(this);
            androidx.activity.a aVar = this.f232c;
            if (aVar != null) {
                aVar.cancel();
                this.f232c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements androidx.activity.a {

        /* renamed from: a  reason: collision with root package name */
        private final b f234a;

        a(b bVar) {
            this.f234a = bVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f229b.remove(this.f234a);
            this.f234a.e(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f228a = runnable;
    }

    public void a(f fVar, b bVar) {
        androidx.lifecycle.c h6 = fVar.h();
        if (h6.b() == c.b.DESTROYED) {
            return;
        }
        bVar.a(new LifecycleOnBackPressedCancellable(h6, bVar));
    }

    androidx.activity.a b(b bVar) {
        this.f229b.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    public void c() {
        Iterator descendingIterator = this.f229b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b bVar = (b) descendingIterator.next();
            if (bVar.c()) {
                bVar.b();
                return;
            }
        }
        Runnable runnable = this.f228a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
