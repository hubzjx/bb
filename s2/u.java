package s2;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.util.s0;
import s2.u;
/* loaded from: classes.dex */
public interface u {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f13263a;

        /* renamed from: b  reason: collision with root package name */
        private final u f13264b;

        public a(Handler handler, u uVar) {
            this.f13263a = uVar != null ? (Handler) com.google.android.exoplayer2.util.a.e(handler) : null;
            this.f13264b = uVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(String str, long j6, long j7) {
            ((u) s0.j(this.f13264b)).o(str, j6, j7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(com.google.android.exoplayer2.decoder.h hVar) {
            hVar.c();
            ((u) s0.j(this.f13264b)).J(hVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(int i6, long j6) {
            ((u) s0.j(this.f13264b)).T(i6, j6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(com.google.android.exoplayer2.decoder.h hVar) {
            ((u) s0.j(this.f13264b)).A(hVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(com.google.android.exoplayer2.s0 s0Var) {
            ((u) s0.j(this.f13264b)).y(s0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(Surface surface) {
            ((u) s0.j(this.f13264b)).G(surface);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(long j6, int i6) {
            ((u) s0.j(this.f13264b)).U(j6, i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(int i6, int i7, int i8, float f6) {
            ((u) s0.j(this.f13264b)).c(i6, i7, i8, f6);
        }

        public void i(final String str, final long j6, final long j7) {
            Handler handler = this.f13263a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: s2.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.a.this.n(str, j6, j7);
                    }
                });
            }
        }

        public void j(final com.google.android.exoplayer2.decoder.h hVar) {
            hVar.c();
            Handler handler = this.f13263a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: s2.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.a.this.o(hVar);
                    }
                });
            }
        }

        public void k(final int i6, final long j6) {
            Handler handler = this.f13263a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: s2.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.a.this.p(i6, j6);
                    }
                });
            }
        }

        public void l(final com.google.android.exoplayer2.decoder.h hVar) {
            Handler handler = this.f13263a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: s2.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.a.this.q(hVar);
                    }
                });
            }
        }

        public void m(final com.google.android.exoplayer2.s0 s0Var) {
            Handler handler = this.f13263a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: s2.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.a.this.r(s0Var);
                    }
                });
            }
        }

        public void v(final Surface surface) {
            Handler handler = this.f13263a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: s2.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.a.this.s(surface);
                    }
                });
            }
        }

        public void w(final long j6, final int i6) {
            Handler handler = this.f13263a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: s2.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.a.this.t(j6, i6);
                    }
                });
            }
        }

        public void x(final int i6, final int i7, final int i8, final float f6) {
            Handler handler = this.f13263a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: s2.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.a.this.u(i6, i7, i8, f6);
                    }
                });
            }
        }
    }

    void A(com.google.android.exoplayer2.decoder.h hVar);

    void G(Surface surface);

    void J(com.google.android.exoplayer2.decoder.h hVar);

    void T(int i6, long j6);

    void U(long j6, int i6);

    void c(int i6, int i7, int i8, float f6);

    void o(String str, long j6, long j7);

    void y(com.google.android.exoplayer2.s0 s0Var);
}
