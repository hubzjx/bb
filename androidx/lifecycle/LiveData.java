package androidx.lifecycle;

import androidx.lifecycle.c;
import java.util.Map;
import k.b;
/* loaded from: classes.dex */
public abstract class LiveData {

    /* renamed from: j  reason: collision with root package name */
    static final Object f1960j = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Object f1961a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private k.b f1962b = new k.b();

    /* renamed from: c  reason: collision with root package name */
    int f1963c = 0;

    /* renamed from: d  reason: collision with root package name */
    private volatile Object f1964d;

    /* renamed from: e  reason: collision with root package name */
    volatile Object f1965e;

    /* renamed from: f  reason: collision with root package name */
    private int f1966f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1967g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1968h;

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f1969i;

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends androidx.lifecycle.LiveData.b implements d {

        /* renamed from: d  reason: collision with root package name */
        final f f1970d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ LiveData f1971e;

        @Override // androidx.lifecycle.d
        public void a(f fVar, c.a aVar) {
            if (this.f1970d.h().b() == c.b.DESTROYED) {
                this.f1971e.f(null);
            } else {
                b(d());
            }
        }

        void c() {
            this.f1970d.h().c(this);
        }

        boolean d() {
            return this.f1970d.h().b().isAtLeast(c.b.STARTED);
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f1961a) {
                obj = LiveData.this.f1965e;
                LiveData.this.f1965e = LiveData.f1960j;
            }
            LiveData.this.g(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f1973a;

        /* renamed from: b  reason: collision with root package name */
        int f1974b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LiveData f1975c;

        void b(boolean z5) {
            if (z5 == this.f1973a) {
                return;
            }
            this.f1973a = z5;
            LiveData liveData = this.f1975c;
            int i6 = liveData.f1963c;
            boolean z6 = i6 == 0;
            liveData.f1963c = i6 + (z5 ? 1 : -1);
            if (z6 && z5) {
                liveData.d();
            }
            LiveData liveData2 = this.f1975c;
            if (liveData2.f1963c == 0 && !this.f1973a) {
                liveData2.e();
            }
            if (this.f1973a) {
                this.f1975c.c(this);
            }
        }

        abstract void c();

        abstract boolean d();
    }

    public LiveData() {
        Object obj = f1960j;
        this.f1964d = obj;
        this.f1965e = obj;
        this.f1966f = -1;
        this.f1969i = new a();
    }

    private static void a(String str) {
        if (j.a.d().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void b(b bVar) {
        if (bVar.f1973a) {
            if (!bVar.d()) {
                bVar.b(false);
                return;
            }
            int i6 = bVar.f1974b;
            int i7 = this.f1966f;
            if (i6 >= i7) {
                return;
            }
            bVar.f1974b = i7;
            throw null;
        }
    }

    void c(b bVar) {
        if (this.f1967g) {
            this.f1968h = true;
            return;
        }
        this.f1967g = true;
        do {
            this.f1968h = false;
            if (bVar == null) {
                b.d c6 = this.f1962b.c();
                while (c6.hasNext()) {
                    b((b) ((Map.Entry) c6.next()).getValue());
                    if (this.f1968h) {
                        break;
                    }
                }
            } else {
                b(bVar);
                bVar = null;
            }
        } while (this.f1968h);
        this.f1967g = false;
    }

    protected void d() {
    }

    protected void e() {
    }

    public void f(k kVar) {
        a("removeObserver");
        b bVar = (b) this.f1962b.f(kVar);
        if (bVar == null) {
            return;
        }
        bVar.c();
        bVar.b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Object obj) {
        a("setValue");
        this.f1966f++;
        this.f1964d = obj;
        c(null);
    }
}
