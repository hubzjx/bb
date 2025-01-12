package w1;

import android.os.Handler;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import w1.e0;
import w1.v;
/* loaded from: classes.dex */
public interface e0 {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f13824a;

        /* renamed from: b  reason: collision with root package name */
        public final v.a f13825b;

        /* renamed from: c  reason: collision with root package name */
        private final CopyOnWriteArrayList f13826c;

        /* renamed from: d  reason: collision with root package name */
        private final long f13827d;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: w1.e0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0222a {

            /* renamed from: a  reason: collision with root package name */
            public Handler f13828a;

            /* renamed from: b  reason: collision with root package name */
            public e0 f13829b;

            public C0222a(Handler handler, e0 e0Var) {
                this.f13828a = handler;
                this.f13829b = e0Var;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        private long h(long j6) {
            long b6 = com.google.android.exoplayer2.p.b(j6);
            if (b6 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f13827d + b6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(e0 e0Var, s sVar) {
            e0Var.l(this.f13824a, this.f13825b, sVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(e0 e0Var, p pVar, s sVar) {
            e0Var.v(this.f13824a, this.f13825b, pVar, sVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(e0 e0Var, p pVar, s sVar) {
            e0Var.n(this.f13824a, this.f13825b, pVar, sVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(e0 e0Var, p pVar, s sVar, IOException iOException, boolean z5) {
            e0Var.I(this.f13824a, this.f13825b, pVar, sVar, iOException, z5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(e0 e0Var, p pVar, s sVar) {
            e0Var.Q(this.f13824a, this.f13825b, pVar, sVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(e0 e0Var, v.a aVar, s sVar) {
            e0Var.j(this.f13824a, aVar, sVar);
        }

        public void A(p pVar, int i6, int i7, com.google.android.exoplayer2.s0 s0Var, int i8, Object obj, long j6, long j7) {
            B(pVar, new s(i6, i7, s0Var, i8, obj, h(j6), h(j7)));
        }

        public void B(final p pVar, final s sVar) {
            Iterator it = this.f13826c.iterator();
            while (it.hasNext()) {
                C0222a c0222a = (C0222a) it.next();
                final e0 e0Var = c0222a.f13829b;
                com.google.android.exoplayer2.util.s0.C0(c0222a.f13828a, new Runnable() { // from class: w1.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        e0.a.this.o(e0Var, pVar, sVar);
                    }
                });
            }
        }

        public void C(e0 e0Var) {
            Iterator it = this.f13826c.iterator();
            while (it.hasNext()) {
                C0222a c0222a = (C0222a) it.next();
                if (c0222a.f13829b == e0Var) {
                    this.f13826c.remove(c0222a);
                }
            }
        }

        public void D(int i6, long j6, long j7) {
            E(new s(1, i6, null, 3, null, h(j6), h(j7)));
        }

        public void E(final s sVar) {
            final v.a aVar = (v.a) com.google.android.exoplayer2.util.a.e(this.f13825b);
            Iterator it = this.f13826c.iterator();
            while (it.hasNext()) {
                C0222a c0222a = (C0222a) it.next();
                final e0 e0Var = c0222a.f13829b;
                com.google.android.exoplayer2.util.s0.C0(c0222a.f13828a, new Runnable() { // from class: w1.d0
                    @Override // java.lang.Runnable
                    public final void run() {
                        e0.a.this.p(e0Var, aVar, sVar);
                    }
                });
            }
        }

        public a F(int i6, v.a aVar, long j6) {
            return new a(this.f13826c, i6, aVar, j6);
        }

        public void g(Handler handler, e0 e0Var) {
            com.google.android.exoplayer2.util.a.e(handler);
            com.google.android.exoplayer2.util.a.e(e0Var);
            this.f13826c.add(new C0222a(handler, e0Var));
        }

        public void i(int i6, com.google.android.exoplayer2.s0 s0Var, int i7, Object obj, long j6) {
            j(new s(1, i6, s0Var, i7, obj, h(j6), -9223372036854775807L));
        }

        public void j(final s sVar) {
            Iterator it = this.f13826c.iterator();
            while (it.hasNext()) {
                C0222a c0222a = (C0222a) it.next();
                final e0 e0Var = c0222a.f13829b;
                com.google.android.exoplayer2.util.s0.C0(c0222a.f13828a, new Runnable() { // from class: w1.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        e0.a.this.k(e0Var, sVar);
                    }
                });
            }
        }

        public void q(p pVar, int i6) {
            r(pVar, i6, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void r(p pVar, int i6, int i7, com.google.android.exoplayer2.s0 s0Var, int i8, Object obj, long j6, long j7) {
            s(pVar, new s(i6, i7, s0Var, i8, obj, h(j6), h(j7)));
        }

        public void s(final p pVar, final s sVar) {
            Iterator it = this.f13826c.iterator();
            while (it.hasNext()) {
                C0222a c0222a = (C0222a) it.next();
                final e0 e0Var = c0222a.f13829b;
                com.google.android.exoplayer2.util.s0.C0(c0222a.f13828a, new Runnable() { // from class: w1.c0
                    @Override // java.lang.Runnable
                    public final void run() {
                        e0.a.this.l(e0Var, pVar, sVar);
                    }
                });
            }
        }

        public void t(p pVar, int i6) {
            u(pVar, i6, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void u(p pVar, int i6, int i7, com.google.android.exoplayer2.s0 s0Var, int i8, Object obj, long j6, long j7) {
            v(pVar, new s(i6, i7, s0Var, i8, obj, h(j6), h(j7)));
        }

        public void v(final p pVar, final s sVar) {
            Iterator it = this.f13826c.iterator();
            while (it.hasNext()) {
                C0222a c0222a = (C0222a) it.next();
                final e0 e0Var = c0222a.f13829b;
                com.google.android.exoplayer2.util.s0.C0(c0222a.f13828a, new Runnable() { // from class: w1.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        e0.a.this.m(e0Var, pVar, sVar);
                    }
                });
            }
        }

        public void w(p pVar, int i6, int i7, com.google.android.exoplayer2.s0 s0Var, int i8, Object obj, long j6, long j7, IOException iOException, boolean z5) {
            y(pVar, new s(i6, i7, s0Var, i8, obj, h(j6), h(j7)), iOException, z5);
        }

        public void x(p pVar, int i6, IOException iOException, boolean z5) {
            w(pVar, i6, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z5);
        }

        public void y(final p pVar, final s sVar, final IOException iOException, final boolean z5) {
            Iterator it = this.f13826c.iterator();
            while (it.hasNext()) {
                C0222a c0222a = (C0222a) it.next();
                final e0 e0Var = c0222a.f13829b;
                com.google.android.exoplayer2.util.s0.C0(c0222a.f13828a, new Runnable() { // from class: w1.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        e0.a.this.n(e0Var, pVar, sVar, iOException, z5);
                    }
                });
            }
        }

        public void z(p pVar, int i6) {
            A(pVar, i6, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        private a(CopyOnWriteArrayList copyOnWriteArrayList, int i6, v.a aVar, long j6) {
            this.f13826c = copyOnWriteArrayList;
            this.f13824a = i6;
            this.f13825b = aVar;
            this.f13827d = j6;
        }
    }

    void I(int i6, v.a aVar, p pVar, s sVar, IOException iOException, boolean z5);

    void Q(int i6, v.a aVar, p pVar, s sVar);

    void j(int i6, v.a aVar, s sVar);

    void l(int i6, v.a aVar, s sVar);

    void n(int i6, v.a aVar, p pVar, s sVar);

    void v(int i6, v.a aVar, p pVar, s sVar);
}
