package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    static final ThreadLocal f2470e = new ThreadLocal();

    /* renamed from: f  reason: collision with root package name */
    static Comparator f2471f = new a();

    /* renamed from: b  reason: collision with root package name */
    long f2473b;

    /* renamed from: c  reason: collision with root package name */
    long f2474c;

    /* renamed from: a  reason: collision with root package name */
    ArrayList f2472a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f2475d = new ArrayList();

    /* loaded from: classes.dex */
    static class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f2483d;
            if ((recyclerView == null) != (cVar2.f2483d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z5 = cVar.f2480a;
            if (z5 != cVar2.f2480a) {
                return z5 ? -1 : 1;
            }
            int i6 = cVar2.f2481b - cVar.f2481b;
            if (i6 != 0) {
                return i6;
            }
            int i7 = cVar.f2482c - cVar2.f2482c;
            if (i7 != 0) {
                return i7;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements RecyclerView.o.c {

        /* renamed from: a  reason: collision with root package name */
        int f2476a;

        /* renamed from: b  reason: collision with root package name */
        int f2477b;

        /* renamed from: c  reason: collision with root package name */
        int[] f2478c;

        /* renamed from: d  reason: collision with root package name */
        int f2479d;

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i6, int i7) {
            if (i6 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i7 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i8 = this.f2479d * 2;
            int[] iArr = this.f2478c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f2478c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i8 >= iArr.length) {
                int[] iArr3 = new int[i8 * 2];
                this.f2478c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f2478c;
            iArr4[i8] = i6;
            iArr4[i8 + 1] = i7;
            this.f2479d++;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f2478c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2479d = 0;
        }

        void c(RecyclerView recyclerView, boolean z5) {
            this.f2479d = 0;
            int[] iArr = this.f2478c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.f2188n;
            if (recyclerView.f2186m == null || oVar == null || !oVar.u0()) {
                return;
            }
            if (z5) {
                if (!recyclerView.f2170e.p()) {
                    oVar.p(recyclerView.f2186m.c(), this);
                }
            } else if (!recyclerView.l0()) {
                oVar.o(this.f2476a, this.f2477b, recyclerView.f2177h0, this);
            }
            int i6 = this.f2479d;
            if (i6 > oVar.f2267m) {
                oVar.f2267m = i6;
                oVar.f2268n = z5;
                recyclerView.f2166c.K();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d(int i6) {
            if (this.f2478c != null) {
                int i7 = this.f2479d * 2;
                for (int i8 = 0; i8 < i7; i8 += 2) {
                    if (this.f2478c[i8] == i6) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i6, int i7) {
            this.f2476a = i6;
            this.f2477b = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2480a;

        /* renamed from: b  reason: collision with root package name */
        public int f2481b;

        /* renamed from: c  reason: collision with root package name */
        public int f2482c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f2483d;

        /* renamed from: e  reason: collision with root package name */
        public int f2484e;

        c() {
        }

        public void a() {
            this.f2480a = false;
            this.f2481b = 0;
            this.f2482c = 0;
            this.f2483d = null;
            this.f2484e = 0;
        }
    }

    private void b() {
        c cVar;
        int size = this.f2472a.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            RecyclerView recyclerView = (RecyclerView) this.f2472a.get(i7);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f2175g0.c(recyclerView, false);
                i6 += recyclerView.f2175g0.f2479d;
            }
        }
        this.f2475d.ensureCapacity(i6);
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f2472a.get(i9);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f2175g0;
                int abs = Math.abs(bVar.f2476a) + Math.abs(bVar.f2477b);
                for (int i10 = 0; i10 < bVar.f2479d * 2; i10 += 2) {
                    if (i8 >= this.f2475d.size()) {
                        cVar = new c();
                        this.f2475d.add(cVar);
                    } else {
                        cVar = (c) this.f2475d.get(i8);
                    }
                    int[] iArr = bVar.f2478c;
                    int i11 = iArr[i10 + 1];
                    cVar.f2480a = i11 <= abs;
                    cVar.f2481b = abs;
                    cVar.f2482c = i11;
                    cVar.f2483d = recyclerView2;
                    cVar.f2484e = iArr[i10];
                    i8++;
                }
            }
        }
        Collections.sort(this.f2475d, f2471f);
    }

    private void c(c cVar, long j6) {
        RecyclerView.c0 i6 = i(cVar.f2483d, cVar.f2484e, cVar.f2480a ? Long.MAX_VALUE : j6);
        if (i6 == null || i6.f2222b == null || !i6.s() || i6.t()) {
            return;
        }
        h((RecyclerView) i6.f2222b.get(), j6);
    }

    private void d(long j6) {
        for (int i6 = 0; i6 < this.f2475d.size(); i6++) {
            c cVar = (c) this.f2475d.get(i6);
            if (cVar.f2483d == null) {
                return;
            }
            c(cVar, j6);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i6) {
        int j6 = recyclerView.f2172f.j();
        for (int i7 = 0; i7 < j6; i7++) {
            RecyclerView.c0 f02 = RecyclerView.f0(recyclerView.f2172f.i(i7));
            if (f02.f2223c == i6 && !f02.t()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j6) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.D && recyclerView.f2172f.j() != 0) {
            recyclerView.T0();
        }
        b bVar = recyclerView.f2175g0;
        bVar.c(recyclerView, true);
        if (bVar.f2479d != 0) {
            try {
                a0.b.a("RV Nested Prefetch");
                recyclerView.f2177h0.f(recyclerView.f2186m);
                for (int i6 = 0; i6 < bVar.f2479d * 2; i6 += 2) {
                    i(recyclerView, bVar.f2478c[i6], j6);
                }
            } finally {
                a0.b.b();
            }
        }
    }

    private RecyclerView.c0 i(RecyclerView recyclerView, int i6, long j6) {
        if (e(recyclerView, i6)) {
            return null;
        }
        RecyclerView.u uVar = recyclerView.f2166c;
        try {
            recyclerView.F0();
            RecyclerView.c0 I = uVar.I(i6, false, j6);
            if (I != null) {
                if (!I.s() || I.t()) {
                    uVar.a(I, false);
                } else {
                    uVar.B(I.f2221a);
                }
            }
            return I;
        } finally {
            recyclerView.H0(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f2472a.add(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i6, int i7) {
        if (recyclerView.isAttachedToWindow() && this.f2473b == 0) {
            this.f2473b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f2175g0.e(i6, i7);
    }

    void g(long j6) {
        b();
        d(j6);
    }

    public void j(RecyclerView recyclerView) {
        this.f2472a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a0.b.a("RV Prefetch");
            if (!this.f2472a.isEmpty()) {
                int size = this.f2472a.size();
                long j6 = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    RecyclerView recyclerView = (RecyclerView) this.f2472a.get(i6);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j6 = Math.max(recyclerView.getDrawingTime(), j6);
                    }
                }
                if (j6 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j6) + this.f2474c);
                }
            }
        } finally {
            this.f2473b = 0L;
            a0.b.b();
        }
    }
}
