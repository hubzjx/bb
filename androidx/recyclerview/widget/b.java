package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    final InterfaceC0022b f2383a;

    /* renamed from: b  reason: collision with root package name */
    final a f2384b = new a();

    /* renamed from: c  reason: collision with root package name */
    final List f2385c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f2386a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f2387b;

        a() {
        }

        private void c() {
            if (this.f2387b == null) {
                this.f2387b = new a();
            }
        }

        void a(int i6) {
            if (i6 < 64) {
                this.f2386a &= ~(1 << i6);
                return;
            }
            a aVar = this.f2387b;
            if (aVar != null) {
                aVar.a(i6 - 64);
            }
        }

        int b(int i6) {
            a aVar = this.f2387b;
            return aVar == null ? i6 >= 64 ? Long.bitCount(this.f2386a) : Long.bitCount(this.f2386a & ((1 << i6) - 1)) : i6 < 64 ? Long.bitCount(this.f2386a & ((1 << i6) - 1)) : aVar.b(i6 - 64) + Long.bitCount(this.f2386a);
        }

        boolean d(int i6) {
            if (i6 < 64) {
                return (this.f2386a & (1 << i6)) != 0;
            }
            c();
            return this.f2387b.d(i6 - 64);
        }

        void e(int i6, boolean z5) {
            if (i6 >= 64) {
                c();
                this.f2387b.e(i6 - 64, z5);
                return;
            }
            long j6 = this.f2386a;
            boolean z6 = (Long.MIN_VALUE & j6) != 0;
            long j7 = (1 << i6) - 1;
            this.f2386a = ((j6 & (~j7)) << 1) | (j6 & j7);
            if (z5) {
                h(i6);
            } else {
                a(i6);
            }
            if (z6 || this.f2387b != null) {
                c();
                this.f2387b.e(0, z6);
            }
        }

        boolean f(int i6) {
            if (i6 >= 64) {
                c();
                return this.f2387b.f(i6 - 64);
            }
            long j6 = 1 << i6;
            long j7 = this.f2386a;
            boolean z5 = (j7 & j6) != 0;
            long j8 = j7 & (~j6);
            this.f2386a = j8;
            long j9 = j6 - 1;
            this.f2386a = (j8 & j9) | Long.rotateRight((~j9) & j8, 1);
            a aVar = this.f2387b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f2387b.f(0);
            }
            return z5;
        }

        void g() {
            this.f2386a = 0L;
            a aVar = this.f2387b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i6) {
            if (i6 < 64) {
                this.f2386a |= 1 << i6;
                return;
            }
            c();
            this.f2387b.h(i6 - 64);
        }

        public String toString() {
            if (this.f2387b == null) {
                return Long.toBinaryString(this.f2386a);
            }
            return this.f2387b.toString() + "xx" + Long.toBinaryString(this.f2386a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0022b {
        View a(int i6);

        void b(View view);

        RecyclerView.c0 c(View view);

        void d(int i6);

        void e(View view);

        void f(View view, int i6);

        int g();

        void h(int i6);

        void i();

        void j(View view, int i6, ViewGroup.LayoutParams layoutParams);

        int k(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InterfaceC0022b interfaceC0022b) {
        this.f2383a = interfaceC0022b;
    }

    private int h(int i6) {
        if (i6 < 0) {
            return -1;
        }
        int g6 = this.f2383a.g();
        int i7 = i6;
        while (i7 < g6) {
            int b6 = i6 - (i7 - this.f2384b.b(i7));
            if (b6 == 0) {
                while (this.f2384b.d(i7)) {
                    i7++;
                }
                return i7;
            }
            i7 += b6;
        }
        return -1;
    }

    private void l(View view) {
        this.f2385c.add(view);
        this.f2383a.b(view);
    }

    private boolean t(View view) {
        if (this.f2385c.remove(view)) {
            this.f2383a.e(view);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i6, boolean z5) {
        int g6 = i6 < 0 ? this.f2383a.g() : h(i6);
        this.f2384b.e(g6, z5);
        if (z5) {
            l(view);
        }
        this.f2383a.f(view, g6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view, boolean z5) {
        a(view, -1, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view, int i6, ViewGroup.LayoutParams layoutParams, boolean z5) {
        int g6 = i6 < 0 ? this.f2383a.g() : h(i6);
        this.f2384b.e(g6, z5);
        if (z5) {
            l(view);
        }
        this.f2383a.j(view, g6, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i6) {
        int h6 = h(i6);
        this.f2384b.f(h6);
        this.f2383a.d(h6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View e(int i6) {
        int size = this.f2385c.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = (View) this.f2385c.get(i7);
            RecyclerView.c0 c6 = this.f2383a.c(view);
            if (c6.m() == i6 && !c6.t() && !c6.v()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View f(int i6) {
        return this.f2383a.a(h(i6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f2383a.g() - this.f2385c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View i(int i6) {
        return this.f2383a.a(i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f2383a.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(View view) {
        int k6 = this.f2383a.k(view);
        if (k6 >= 0) {
            this.f2384b.h(k6);
            l(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(View view) {
        int k6 = this.f2383a.k(view);
        if (k6 == -1 || this.f2384b.d(k6)) {
            return -1;
        }
        return k6 - this.f2384b.b(k6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f2385c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f2384b.g();
        for (int size = this.f2385c.size() - 1; size >= 0; size--) {
            this.f2383a.e((View) this.f2385c.get(size));
            this.f2385c.remove(size);
        }
        this.f2383a.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view) {
        int k6 = this.f2383a.k(view);
        if (k6 < 0) {
            return;
        }
        if (this.f2384b.f(k6)) {
            t(view);
        }
        this.f2383a.h(k6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i6) {
        int h6 = h(i6);
        View a6 = this.f2383a.a(h6);
        if (a6 == null) {
            return;
        }
        if (this.f2384b.f(h6)) {
            t(a6);
        }
        this.f2383a.h(h6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(View view) {
        int k6 = this.f2383a.k(view);
        if (k6 == -1) {
            t(view);
            return true;
        } else if (this.f2384b.d(k6)) {
            this.f2384b.f(k6);
            t(view);
            this.f2383a.h(k6);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(View view) {
        int k6 = this.f2383a.k(view);
        if (k6 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f2384b.d(k6)) {
            this.f2384b.a(k6);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f2384b.toString() + ", hidden list:" + this.f2385c.size();
    }
}
