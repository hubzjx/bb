package h5;

import a5.a;
import g5.a;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private final g5.a f10782a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10783b;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f10784c;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f10785a;

        a(Object obj) {
            this.f10785a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e eVar = e.this;
                eVar.i(this.f10785a, eVar.f10782a);
            } catch (a5.a unused) {
            } catch (Throwable th) {
                e.this.f10784c.shutdown();
                throw th;
            }
            e.this.f10784c.shutdown();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final g5.a f10787a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f10788b;

        /* renamed from: c  reason: collision with root package name */
        private final ExecutorService f10789c;

        public b(ExecutorService executorService, boolean z5, g5.a aVar) {
            this.f10789c = executorService;
            this.f10788b = z5;
            this.f10787a = aVar;
        }
    }

    public e(b bVar) {
        this.f10782a = bVar.f10787a;
        this.f10783b = bVar.f10788b;
        this.f10784c = bVar.f10789c;
    }

    private void h() {
        this.f10782a.c();
        this.f10782a.j(a.b.BUSY);
        this.f10782a.g(g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Object obj, g5.a aVar) {
        try {
            f(obj, aVar);
            aVar.a();
        } catch (a5.a e6) {
            aVar.b(e6);
            throw e6;
        } catch (Exception e7) {
            aVar.b(e7);
            throw new a5.a(e7);
        }
    }

    protected abstract long d(Object obj);

    public void e(Object obj) {
        if (this.f10783b && a.b.BUSY.equals(this.f10782a.d())) {
            throw new a5.a("invalid operation - Zip4j is in busy state");
        }
        h();
        if (!this.f10783b) {
            i(obj, this.f10782a);
            return;
        }
        this.f10782a.k(d(obj));
        this.f10784c.execute(new a(obj));
    }

    protected abstract void f(Object obj, g5.a aVar);

    protected abstract a.c g();

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        if (this.f10782a.e()) {
            this.f10782a.i(a.EnumC0171a.CANCELLED);
            this.f10782a.j(a.b.READY);
            throw new a5.a("Task cancelled", a.EnumC0003a.TASK_CANCELLED_EXCEPTION);
        }
    }
}
