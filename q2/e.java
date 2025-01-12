package q2;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import q2.e;
/* loaded from: classes.dex */
public interface e {

    /* loaded from: classes.dex */
    public interface a {

        /* renamed from: q2.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0208a {

            /* renamed from: a  reason: collision with root package name */
            private final CopyOnWriteArrayList f12746a = new CopyOnWriteArrayList();

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: q2.e$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0209a {

                /* renamed from: a  reason: collision with root package name */
                private final Handler f12747a;

                /* renamed from: b  reason: collision with root package name */
                private final a f12748b;

                /* renamed from: c  reason: collision with root package name */
                private boolean f12749c;

                public C0209a(Handler handler, a aVar) {
                    this.f12747a = handler;
                    this.f12748b = aVar;
                }

                public void d() {
                    this.f12749c = true;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void d(C0209a c0209a, int i6, long j6, long j7) {
                c0209a.f12748b.H(i6, j6, j7);
            }

            public void b(Handler handler, a aVar) {
                com.google.android.exoplayer2.util.a.e(handler);
                com.google.android.exoplayer2.util.a.e(aVar);
                e(aVar);
                this.f12746a.add(new C0209a(handler, aVar));
            }

            public void c(final int i6, final long j6, final long j7) {
                Iterator it = this.f12746a.iterator();
                while (it.hasNext()) {
                    final C0209a c0209a = (C0209a) it.next();
                    if (!c0209a.f12749c) {
                        c0209a.f12747a.post(new Runnable() { // from class: q2.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.a.C0208a.d(e.a.C0208a.C0209a.this, i6, j6, j7);
                            }
                        });
                    }
                }
            }

            public void e(a aVar) {
                Iterator it = this.f12746a.iterator();
                while (it.hasNext()) {
                    C0209a c0209a = (C0209a) it.next();
                    if (c0209a.f12748b == aVar) {
                        c0209a.d();
                        this.f12746a.remove(c0209a);
                    }
                }
            }
        }

        void H(int i6, long j6, long j7);
    }

    void b(a aVar);

    i0 c();

    long e();

    void h(Handler handler, a aVar);
}
