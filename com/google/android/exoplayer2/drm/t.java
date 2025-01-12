package com.google.android.exoplayer2.drm;

import android.os.Handler;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.util.s0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import w1.v;
/* loaded from: classes.dex */
public interface t {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f3723a;

        /* renamed from: b  reason: collision with root package name */
        public final v.a f3724b;

        /* renamed from: c  reason: collision with root package name */
        private final CopyOnWriteArrayList f3725c;

        /* renamed from: com.google.android.exoplayer2.drm.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static final class C0039a {

            /* renamed from: a  reason: collision with root package name */
            public Handler f3726a;

            /* renamed from: b  reason: collision with root package name */
            public t f3727b;

            public C0039a(Handler handler, t tVar) {
                this.f3726a = handler;
                this.f3727b = tVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(t tVar) {
            tVar.N(this.f3723a, this.f3724b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(t tVar) {
            tVar.R(this.f3723a, this.f3724b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(t tVar) {
            tVar.q(this.f3723a, this.f3724b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(t tVar) {
            tVar.L(this.f3723a, this.f3724b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(t tVar, Exception exc) {
            tVar.x(this.f3723a, this.f3724b, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(t tVar) {
            tVar.z(this.f3723a, this.f3724b);
        }

        public void g(Handler handler, t tVar) {
            com.google.android.exoplayer2.util.a.e(handler);
            com.google.android.exoplayer2.util.a.e(tVar);
            this.f3725c.add(new C0039a(handler, tVar));
        }

        public void h() {
            Iterator it = this.f3725c.iterator();
            while (it.hasNext()) {
                C0039a c0039a = (C0039a) it.next();
                final t tVar = c0039a.f3727b;
                s0.C0(c0039a.f3726a, new Runnable() { // from class: com.google.android.exoplayer2.drm.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.n(tVar);
                    }
                });
            }
        }

        public void i() {
            Iterator it = this.f3725c.iterator();
            while (it.hasNext()) {
                C0039a c0039a = (C0039a) it.next();
                final t tVar = c0039a.f3727b;
                s0.C0(c0039a.f3726a, new Runnable() { // from class: com.google.android.exoplayer2.drm.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.o(tVar);
                    }
                });
            }
        }

        public void j() {
            Iterator it = this.f3725c.iterator();
            while (it.hasNext()) {
                C0039a c0039a = (C0039a) it.next();
                final t tVar = c0039a.f3727b;
                s0.C0(c0039a.f3726a, new Runnable() { // from class: com.google.android.exoplayer2.drm.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.p(tVar);
                    }
                });
            }
        }

        public void k() {
            Iterator it = this.f3725c.iterator();
            while (it.hasNext()) {
                C0039a c0039a = (C0039a) it.next();
                final t tVar = c0039a.f3727b;
                s0.C0(c0039a.f3726a, new Runnable() { // from class: com.google.android.exoplayer2.drm.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.q(tVar);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Iterator it = this.f3725c.iterator();
            while (it.hasNext()) {
                C0039a c0039a = (C0039a) it.next();
                final t tVar = c0039a.f3727b;
                s0.C0(c0039a.f3726a, new Runnable() { // from class: com.google.android.exoplayer2.drm.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.r(tVar, exc);
                    }
                });
            }
        }

        public void m() {
            Iterator it = this.f3725c.iterator();
            while (it.hasNext()) {
                C0039a c0039a = (C0039a) it.next();
                final t tVar = c0039a.f3727b;
                s0.C0(c0039a.f3726a, new Runnable() { // from class: com.google.android.exoplayer2.drm.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.s(tVar);
                    }
                });
            }
        }

        public a t(int i6, v.a aVar) {
            return new a(this.f3725c, i6, aVar);
        }

        private a(CopyOnWriteArrayList copyOnWriteArrayList, int i6, v.a aVar) {
            this.f3725c = copyOnWriteArrayList;
            this.f3723a = i6;
            this.f3724b = aVar;
        }
    }

    void L(int i6, v.a aVar);

    void N(int i6, v.a aVar);

    void R(int i6, v.a aVar);

    void q(int i6, v.a aVar);

    void x(int i6, v.a aVar, Exception exc);

    void z(int i6, v.a aVar);
}
