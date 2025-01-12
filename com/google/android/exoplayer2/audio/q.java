package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.audio.q;
/* loaded from: classes.dex */
public interface q {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f3499a;

        /* renamed from: b  reason: collision with root package name */
        private final q f3500b;

        public a(Handler handler, q qVar) {
            this.f3499a = qVar != null ? (Handler) com.google.android.exoplayer2.util.a.e(handler) : null;
            this.f3500b = qVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(int i6) {
            ((q) com.google.android.exoplayer2.util.s0.j(this.f3500b)).b(i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(String str, long j6, long j7) {
            ((q) com.google.android.exoplayer2.util.s0.j(this.f3500b)).K(str, j6, j7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(com.google.android.exoplayer2.decoder.h hVar) {
            hVar.c();
            ((q) com.google.android.exoplayer2.util.s0.j(this.f3500b)).k(hVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(com.google.android.exoplayer2.decoder.h hVar) {
            ((q) com.google.android.exoplayer2.util.s0.j(this.f3500b)).m(hVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(com.google.android.exoplayer2.s0 s0Var) {
            ((q) com.google.android.exoplayer2.util.s0.j(this.f3500b)).D(s0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(long j6) {
            ((q) com.google.android.exoplayer2.util.s0.j(this.f3500b)).B(j6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(boolean z5) {
            ((q) com.google.android.exoplayer2.util.s0.j(this.f3500b)).a(z5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(int i6, long j6, long j7) {
            ((q) com.google.android.exoplayer2.util.s0.j(this.f3500b)).S(i6, j6, j7);
        }

        public void i(final int i6) {
            Handler handler = this.f3499a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.a.this.n(i6);
                    }
                });
            }
        }

        public void j(final String str, final long j6, final long j7) {
            Handler handler = this.f3499a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.a.this.o(str, j6, j7);
                    }
                });
            }
        }

        public void k(final com.google.android.exoplayer2.decoder.h hVar) {
            hVar.c();
            Handler handler = this.f3499a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.a.this.p(hVar);
                    }
                });
            }
        }

        public void l(final com.google.android.exoplayer2.decoder.h hVar) {
            Handler handler = this.f3499a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.a.this.q(hVar);
                    }
                });
            }
        }

        public void m(final com.google.android.exoplayer2.s0 s0Var) {
            Handler handler = this.f3499a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.a.this.r(s0Var);
                    }
                });
            }
        }

        public void v(final long j6) {
            Handler handler = this.f3499a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.a.this.s(j6);
                    }
                });
            }
        }

        public void w(final boolean z5) {
            Handler handler = this.f3499a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.a.this.t(z5);
                    }
                });
            }
        }

        public void x(final int i6, final long j6, final long j7) {
            Handler handler = this.f3499a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.a.this.u(i6, j6, j7);
                    }
                });
            }
        }
    }

    void B(long j6);

    void D(com.google.android.exoplayer2.s0 s0Var);

    void K(String str, long j6, long j7);

    void S(int i6, long j6, long j7);

    void a(boolean z5);

    void b(int i6);

    void k(com.google.android.exoplayer2.decoder.h hVar);

    void m(com.google.android.exoplayer2.decoder.h hVar);
}
