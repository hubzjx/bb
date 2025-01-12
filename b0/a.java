package b0;

import android.graphics.Typeface;
import android.os.Handler;
import b0.e;
import b0.f;
/* loaded from: classes.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private final f.c f2843a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f2844b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0028a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.c f2845a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Typeface f2846b;

        RunnableC0028a(f.c cVar, Typeface typeface) {
            this.f2845a = cVar;
            this.f2846b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2845a.b(this.f2846b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.c f2848a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2849b;

        b(f.c cVar, int i6) {
            this.f2848a = cVar;
            this.f2849b = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2848a.a(this.f2849b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(f.c cVar, Handler handler) {
        this.f2843a = cVar;
        this.f2844b = handler;
    }

    private void a(int i6) {
        this.f2844b.post(new b(this.f2843a, i6));
    }

    private void c(Typeface typeface) {
        this.f2844b.post(new RunnableC0028a(this.f2843a, typeface));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e.C0029e c0029e) {
        if (c0029e.a()) {
            c(c0029e.f2872a);
        } else {
            a(c0029e.f2873b);
        }
    }
}
