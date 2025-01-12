package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import f0.y;
import java.util.Arrays;
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean I;
    int J;
    int[] K;
    View[] L;
    final SparseIntArray M;
    final SparseIntArray N;
    c O;
    final Rect P;
    private boolean Q;

    /* loaded from: classes.dex */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i6, int i7) {
            return i6 % i7;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i6) {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        int f2121e;

        /* renamed from: f  reason: collision with root package name */
        int f2122f;

        public b(int i6, int i7) {
            super(i6, i7);
            this.f2121e = -1;
            this.f2122f = 0;
        }

        public int e() {
            return this.f2121e;
        }

        public int f() {
            return this.f2122f;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2121e = -1;
            this.f2122f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2121e = -1;
            this.f2122f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2121e = -1;
            this.f2122f = 0;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f2123a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        final SparseIntArray f2124b = new SparseIntArray();

        /* renamed from: c  reason: collision with root package name */
        private boolean f2125c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2126d = false;

        static int a(SparseIntArray sparseIntArray, int i6) {
            int size = sparseIntArray.size() - 1;
            int i7 = 0;
            while (i7 <= size) {
                int i8 = (i7 + size) >>> 1;
                if (sparseIntArray.keyAt(i8) < i6) {
                    i7 = i8 + 1;
                } else {
                    size = i8 - 1;
                }
            }
            int i9 = i7 - 1;
            if (i9 < 0 || i9 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i9);
        }

        int b(int i6, int i7) {
            if (this.f2126d) {
                int i8 = this.f2124b.get(i6, -1);
                if (i8 != -1) {
                    return i8;
                }
                int d6 = d(i6, i7);
                this.f2124b.put(i6, d6);
                return d6;
            }
            return d(i6, i7);
        }

        int c(int i6, int i7) {
            if (this.f2125c) {
                int i8 = this.f2123a.get(i6, -1);
                if (i8 != -1) {
                    return i8;
                }
                int e6 = e(i6, i7);
                this.f2123a.put(i6, e6);
                return e6;
            }
            return e(i6, i7);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int d(int i6, int i7) {
            int i8;
            int i9;
            int a6;
            if (this.f2126d && (a6 = a(this.f2124b, i6)) != -1) {
                int i10 = this.f2124b.get(a6);
                i8 = a6 + 1;
                i9 = c(a6, i7) + f(a6);
                i10 = i9 == i7 ? i10 + 1 : 0;
                int f6 = f(i6);
                while (i8 < i6) {
                    int f7 = f(i8);
                    i9 += f7;
                    if (i9 == i7) {
                        i10++;
                        i9 = 0;
                    } else if (i9 > i7) {
                        i10++;
                        i9 = f7;
                    }
                    i8++;
                }
                return i9 + f6 <= i7 ? i10 + 1 : i10;
            }
            i8 = 0;
            i9 = 0;
            int f62 = f(i6);
            while (i8 < i6) {
            }
            if (i9 + f62 <= i7) {
            }
        }

        public abstract int e(int i6, int i7);

        public abstract int f(int i6);

        public void g() {
            this.f2124b.clear();
        }

        public void h() {
            this.f2123a.clear();
        }
    }

    public GridLayoutManager(Context context, int i6, int i7, boolean z5) {
        super(context, i7, z5);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        d3(i6);
    }

    private void N2(RecyclerView.u uVar, RecyclerView.z zVar, int i6, boolean z5) {
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        if (z5) {
            i8 = i6;
            i7 = 0;
            i9 = 1;
        } else {
            i7 = i6 - 1;
            i8 = -1;
            i9 = -1;
        }
        while (i7 != i8) {
            View view = this.L[i7];
            b bVar = (b) view.getLayoutParams();
            int Z2 = Z2(uVar, zVar, h0(view));
            bVar.f2122f = Z2;
            bVar.f2121e = i10;
            i10 += Z2;
            i7 += i9;
        }
    }

    private void O2() {
        int J = J();
        for (int i6 = 0; i6 < J; i6++) {
            b bVar = (b) I(i6).getLayoutParams();
            int a6 = bVar.a();
            this.M.put(a6, bVar.f());
            this.N.put(a6, bVar.e());
        }
    }

    private void P2(int i6) {
        this.K = Q2(this.K, this.J, i6);
    }

    static int[] Q2(int[] iArr, int i6, int i7) {
        int i8;
        if (iArr == null || iArr.length != i6 + 1 || iArr[iArr.length - 1] != i7) {
            iArr = new int[i6 + 1];
        }
        int i9 = 0;
        iArr[0] = 0;
        int i10 = i7 / i6;
        int i11 = i7 % i6;
        int i12 = 0;
        for (int i13 = 1; i13 <= i6; i13++) {
            i9 += i11;
            if (i9 <= 0 || i6 - i9 >= i11) {
                i8 = i10;
            } else {
                i8 = i10 + 1;
                i9 -= i6;
            }
            i12 += i8;
            iArr[i13] = i12;
        }
        return iArr;
    }

    private void R2() {
        this.M.clear();
        this.N.clear();
    }

    private int S2(RecyclerView.z zVar) {
        if (J() != 0 && zVar.b() != 0) {
            T1();
            boolean r22 = r2();
            View Y1 = Y1(!r22, true);
            View X1 = X1(!r22, true);
            if (Y1 != null && X1 != null) {
                int b6 = this.O.b(h0(Y1), this.J);
                int b7 = this.O.b(h0(X1), this.J);
                int min = Math.min(b6, b7);
                int max = this.f2132x ? Math.max(0, ((this.O.b(zVar.b() - 1, this.J) + 1) - Math.max(b6, b7)) - 1) : Math.max(0, min);
                if (r22) {
                    return Math.round((max * (Math.abs(this.f2129u.d(X1) - this.f2129u.g(Y1)) / ((this.O.b(h0(X1), this.J) - this.O.b(h0(Y1), this.J)) + 1))) + (this.f2129u.m() - this.f2129u.g(Y1)));
                }
                return max;
            }
        }
        return 0;
    }

    private int T2(RecyclerView.z zVar) {
        if (J() != 0 && zVar.b() != 0) {
            T1();
            View Y1 = Y1(!r2(), true);
            View X1 = X1(!r2(), true);
            if (Y1 != null && X1 != null) {
                if (r2()) {
                    int d6 = this.f2129u.d(X1) - this.f2129u.g(Y1);
                    int b6 = this.O.b(h0(Y1), this.J);
                    return (int) ((d6 / ((this.O.b(h0(X1), this.J) - b6) + 1)) * (this.O.b(zVar.b() - 1, this.J) + 1));
                }
                return this.O.b(zVar.b() - 1, this.J) + 1;
            }
        }
        return 0;
    }

    private void U2(RecyclerView.u uVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i6) {
        boolean z5 = i6 == 1;
        int Y2 = Y2(uVar, zVar, aVar.f2136b);
        if (z5) {
            while (Y2 > 0) {
                int i7 = aVar.f2136b;
                if (i7 <= 0) {
                    return;
                }
                int i8 = i7 - 1;
                aVar.f2136b = i8;
                Y2 = Y2(uVar, zVar, i8);
            }
            return;
        }
        int b6 = zVar.b() - 1;
        int i9 = aVar.f2136b;
        while (i9 < b6) {
            int i10 = i9 + 1;
            int Y22 = Y2(uVar, zVar, i10);
            if (Y22 <= Y2) {
                break;
            }
            i9 = i10;
            Y2 = Y22;
        }
        aVar.f2136b = i9;
    }

    private void V2() {
        View[] viewArr = this.L;
        if (viewArr == null || viewArr.length != this.J) {
            this.L = new View[this.J];
        }
    }

    private int X2(RecyclerView.u uVar, RecyclerView.z zVar, int i6) {
        if (zVar.e()) {
            int f6 = uVar.f(i6);
            if (f6 == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i6);
                return 0;
            }
            return this.O.b(f6, this.J);
        }
        return this.O.b(i6, this.J);
    }

    private int Y2(RecyclerView.u uVar, RecyclerView.z zVar, int i6) {
        if (zVar.e()) {
            int i7 = this.N.get(i6, -1);
            if (i7 != -1) {
                return i7;
            }
            int f6 = uVar.f(i6);
            if (f6 == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i6);
                return 0;
            }
            return this.O.c(f6, this.J);
        }
        return this.O.c(i6, this.J);
    }

    private int Z2(RecyclerView.u uVar, RecyclerView.z zVar, int i6) {
        if (zVar.e()) {
            int i7 = this.M.get(i6, -1);
            if (i7 != -1) {
                return i7;
            }
            int f6 = uVar.f(i6);
            if (f6 == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i6);
                return 1;
            }
            return this.O.f(f6);
        }
        return this.O.f(i6);
    }

    private void a3(float f6, int i6) {
        P2(Math.max(Math.round(f6 * this.J), i6));
    }

    private void b3(View view, int i6, boolean z5) {
        int i7;
        int i8;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f2280b;
        int i9 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i10 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int W2 = W2(bVar.f2121e, bVar.f2122f);
        if (this.f2127s == 1) {
            i8 = RecyclerView.o.K(W2, i6, i10, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i7 = RecyclerView.o.K(this.f2129u.n(), X(), i9, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int K = RecyclerView.o.K(W2, i6, i9, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int K2 = RecyclerView.o.K(this.f2129u.n(), p0(), i10, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i7 = K;
            i8 = K2;
        }
        c3(view, i8, i7, z5);
    }

    private void c3(View view, int i6, int i7, boolean z5) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z5 ? H1(view, i6, i7, pVar) : F1(view, i6, i7, pVar)) {
            view.measure(i6, i7);
        }
    }

    private void e3() {
        int W;
        int g02;
        if (p2() == 1) {
            W = o0() - f0();
            g02 = e0();
        } else {
            W = W() - d0();
            g02 = g0();
        }
        P2(W - g02);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(Rect rect, int i6, int i7) {
        int n5;
        int n6;
        if (this.K == null) {
            super.C1(rect, i6, i7);
        }
        int e02 = e0() + f0();
        int g02 = g0() + d0();
        if (this.f2127s == 1) {
            n6 = RecyclerView.o.n(i7, rect.height() + g02, b0());
            int[] iArr = this.K;
            n5 = RecyclerView.o.n(i6, iArr[iArr.length - 1] + e02, c0());
        } else {
            n5 = RecyclerView.o.n(i6, rect.width() + e02, c0());
            int[] iArr2 = this.K;
            n6 = RecyclerView.o.n(i7, iArr2[iArr2.length - 1] + g02, b0());
        }
        B1(n5, n6);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.f2127s == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void E2(boolean z5) {
        if (z5) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.E2(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
        if (r13 == (r2 > r15)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f6, code lost:
        if (r13 == (r2 > r7)) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View J0(View view, int i6, RecyclerView.u uVar, RecyclerView.z zVar) {
        int J;
        int i7;
        int i8;
        View view2;
        View view3;
        int i9;
        int i10;
        boolean z5;
        int i11;
        int i12;
        RecyclerView.u uVar2 = uVar;
        RecyclerView.z zVar2 = zVar;
        View B = B(view);
        View view4 = null;
        if (B == null) {
            return null;
        }
        b bVar = (b) B.getLayoutParams();
        int i13 = bVar.f2121e;
        int i14 = bVar.f2122f + i13;
        if (super.J0(view, i6, uVar, zVar) == null) {
            return null;
        }
        if ((R1(i6) == 1) != this.f2132x) {
            i7 = J() - 1;
            J = -1;
            i8 = -1;
        } else {
            J = J();
            i7 = 0;
            i8 = 1;
        }
        boolean z6 = this.f2127s == 1 && q2();
        int X2 = X2(uVar2, zVar2, i7);
        int i15 = i7;
        int i16 = 0;
        int i17 = -1;
        int i18 = -1;
        int i19 = 0;
        View view5 = null;
        while (i15 != J) {
            int X22 = X2(uVar2, zVar2, i15);
            View I = I(i15);
            if (I == B) {
                break;
            }
            if (!I.hasFocusable() || X22 == X2) {
                b bVar2 = (b) I.getLayoutParams();
                int i20 = bVar2.f2121e;
                view2 = B;
                int i21 = bVar2.f2122f + i20;
                if (I.hasFocusable() && i20 == i13 && i21 == i14) {
                    return I;
                }
                if (!(I.hasFocusable() && view4 == null) && (I.hasFocusable() || view5 != null)) {
                    view3 = view5;
                    int min = Math.min(i21, i14) - Math.max(i20, i13);
                    if (I.hasFocusable()) {
                        if (min <= i16) {
                            if (min == i16) {
                            }
                        }
                    } else if (view4 == null) {
                        i9 = i16;
                        i10 = J;
                        if (y0(I, false, true)) {
                            i11 = i19;
                            if (min > i11) {
                                i12 = i18;
                                if (z5) {
                                    if (I.hasFocusable()) {
                                        i17 = bVar2.f2121e;
                                        i18 = i12;
                                        i19 = i11;
                                        view5 = view3;
                                        view4 = I;
                                        i16 = Math.min(i21, i14) - Math.max(i20, i13);
                                    } else {
                                        int i22 = bVar2.f2121e;
                                        i19 = Math.min(i21, i14) - Math.max(i20, i13);
                                        i18 = i22;
                                        i16 = i9;
                                        view5 = I;
                                    }
                                    i15 += i8;
                                    uVar2 = uVar;
                                    zVar2 = zVar;
                                    B = view2;
                                    J = i10;
                                }
                            } else {
                                if (min == i11) {
                                    i12 = i18;
                                } else {
                                    i12 = i18;
                                }
                                z5 = false;
                                if (z5) {
                                }
                            }
                        }
                        i12 = i18;
                        i11 = i19;
                        z5 = false;
                        if (z5) {
                        }
                    }
                    i9 = i16;
                    i10 = J;
                    i12 = i18;
                    i11 = i19;
                    z5 = false;
                    if (z5) {
                    }
                } else {
                    view3 = view5;
                }
                i9 = i16;
                i10 = J;
                i12 = i18;
                i11 = i19;
                z5 = true;
                if (z5) {
                }
            } else if (view4 != null) {
                break;
            } else {
                view2 = B;
                view3 = view5;
                i9 = i16;
                i10 = J;
                i12 = i18;
                i11 = i19;
            }
            i18 = i12;
            i19 = i11;
            i16 = i9;
            view5 = view3;
            i15 += i8;
            uVar2 = uVar;
            zVar2 = zVar;
            B = view2;
            J = i10;
        }
        return view4 != null ? view4 : view5;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.D == null && !this.I;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.u uVar, RecyclerView.z zVar) {
        if (this.f2127s == 1) {
            return this.J;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return X2(uVar, zVar, zVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void N1(RecyclerView.z zVar, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i6 = this.J;
        for (int i7 = 0; i7 < this.J && cVar.c(zVar) && i6 > 0; i7++) {
            int i8 = cVar.f2147d;
            cVar2.a(i8, Math.max(0, cVar.f2150g));
            i6 -= this.O.f(i8);
            cVar.f2147d += cVar.f2148e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P0(RecyclerView.u uVar, RecyclerView.z zVar, View view, y yVar) {
        int i6;
        int e6;
        int f6;
        boolean z5;
        boolean z6;
        int i7;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.O0(view, yVar);
            return;
        }
        b bVar = (b) layoutParams;
        int X2 = X2(uVar, zVar, bVar.a());
        if (this.f2127s == 0) {
            i7 = bVar.e();
            i6 = bVar.f();
            f6 = 1;
            z5 = false;
            z6 = false;
            e6 = X2;
        } else {
            i6 = 1;
            e6 = bVar.e();
            f6 = bVar.f();
            z5 = false;
            z6 = false;
            i7 = X2;
        }
        yVar.Z(y.c.a(i7, i6, e6, f6, z5, z6));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView, int i6, int i7) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i6, int i7, int i8) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i6, int i7) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView, int i6, int i7, Object obj) {
        this.O.h();
        this.O.g();
    }

    int W2(int i6, int i7) {
        if (this.f2127s != 1 || !q2()) {
            int[] iArr = this.K;
            return iArr[i7 + i6] - iArr[i6];
        }
        int[] iArr2 = this.K;
        int i8 = this.J;
        return iArr2[i8 - i6] - iArr2[(i8 - i6) - i7];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.u uVar, RecyclerView.z zVar) {
        if (zVar.e()) {
            O2();
        }
        super.X0(uVar, zVar);
        R2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.z zVar) {
        super.Y0(zVar);
        this.I = false;
    }

    public void d3(int i6) {
        if (i6 == this.J) {
            return;
        }
        this.I = true;
        if (i6 >= 1) {
            this.J = i6;
            this.O.h();
            t1();
            return;
        }
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + i6);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View h2(RecyclerView.u uVar, RecyclerView.z zVar, int i6, int i7, int i8) {
        T1();
        int m5 = this.f2129u.m();
        int i9 = this.f2129u.i();
        int i10 = i7 > i6 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i6 != i7) {
            View I = I(i6);
            int h02 = h0(I);
            if (h02 >= 0 && h02 < i8 && Y2(uVar, zVar, h02) == 0) {
                if (((RecyclerView.p) I.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = I;
                    }
                } else if (this.f2129u.g(I) < i9 && this.f2129u.d(I) >= m5) {
                    return I;
                } else {
                    if (view == null) {
                        view = I;
                    }
                }
            }
            i6 += i10;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k0(RecyclerView.u uVar, RecyclerView.z zVar) {
        if (this.f2127s == 0) {
            return this.J;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return X2(uVar, zVar, zVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.z zVar) {
        return this.Q ? S2(zVar) : super.r(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.z zVar) {
        return this.Q ? T2(zVar) : super.s(zVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
        r21.f2141b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a1, code lost:
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void s2(RecyclerView.u uVar, RecyclerView.z zVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int f6;
        int i14;
        int i15;
        int K;
        int i16;
        View d6;
        int l6 = this.f2129u.l();
        boolean z5 = l6 != 1073741824;
        int i17 = J() > 0 ? this.K[this.J] : 0;
        if (z5) {
            e3();
        }
        boolean z6 = cVar.f2148e == 1;
        int i18 = this.J;
        if (!z6) {
            i18 = Y2(uVar, zVar, cVar.f2147d) + Z2(uVar, zVar, cVar.f2147d);
        }
        int i19 = 0;
        while (i19 < this.J && cVar.c(zVar) && i18 > 0) {
            int i20 = cVar.f2147d;
            int Z2 = Z2(uVar, zVar, i20);
            if (Z2 > this.J) {
                throw new IllegalArgumentException("Item at position " + i20 + " requires " + Z2 + " spans but GridLayoutManager has only " + this.J + " spans.");
            }
            i18 -= Z2;
            if (i18 < 0 || (d6 = cVar.d(uVar)) == null) {
                break;
            }
            this.L[i19] = d6;
            i19++;
        }
        N2(uVar, zVar, i19, z6);
        float f7 = 0.0f;
        int i21 = 0;
        for (int i22 = 0; i22 < i19; i22++) {
            View view = this.L[i22];
            if (cVar.f2155l == null) {
                if (z6) {
                    d(view);
                } else {
                    e(view, 0);
                }
            } else if (z6) {
                b(view);
            } else {
                c(view, 0);
            }
            j(view, this.P);
            b3(view, l6, false);
            int e6 = this.f2129u.e(view);
            if (e6 > i21) {
                i21 = e6;
            }
            float f8 = (this.f2129u.f(view) * 1.0f) / ((b) view.getLayoutParams()).f2122f;
            if (f8 > f7) {
                f7 = f8;
            }
        }
        if (z5) {
            a3(f7, i17);
            i21 = 0;
            for (int i23 = 0; i23 < i19; i23++) {
                View view2 = this.L[i23];
                b3(view2, 1073741824, true);
                int e7 = this.f2129u.e(view2);
                if (e7 > i21) {
                    i21 = e7;
                }
            }
        }
        for (int i24 = 0; i24 < i19; i24++) {
            View view3 = this.L[i24];
            if (this.f2129u.e(view3) != i21) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.f2280b;
                int i25 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar2).topMargin + ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin;
                int i26 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar2).leftMargin + ((ViewGroup.MarginLayoutParams) bVar2).rightMargin;
                int W2 = W2(bVar2.f2121e, bVar2.f2122f);
                if (this.f2127s == 1) {
                    i16 = RecyclerView.o.K(W2, 1073741824, i26, ((ViewGroup.MarginLayoutParams) bVar2).width, false);
                    K = View.MeasureSpec.makeMeasureSpec(i21 - i25, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i21 - i26, 1073741824);
                    K = RecyclerView.o.K(W2, 1073741824, i25, ((ViewGroup.MarginLayoutParams) bVar2).height, false);
                    i16 = makeMeasureSpec;
                }
                c3(view3, i16, K, true);
            }
        }
        bVar.f2140a = i21;
        if (this.f2127s == 1) {
            if (cVar.f2149f == -1) {
                i11 = cVar.f2145b;
                i15 = i11 - i21;
            } else {
                i15 = cVar.f2145b;
                i11 = i15 + i21;
            }
            i9 = i15;
            i10 = 0;
            i8 = 0;
        } else {
            if (cVar.f2149f == -1) {
                i7 = cVar.f2145b;
                i6 = i7 - i21;
            } else {
                i6 = cVar.f2145b;
                i7 = i6 + i21;
            }
            i8 = i6;
            i9 = 0;
            i10 = i7;
            i11 = 0;
        }
        int i27 = 0;
        while (i27 < i19) {
            View view4 = this.L[i27];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.f2127s != 1) {
                int g02 = g0() + this.K[bVar3.f2121e];
                i12 = g02;
                i13 = i10;
                f6 = this.f2129u.f(view4) + g02;
            } else if (q2()) {
                int e02 = e0() + this.K[this.J - bVar3.f2121e];
                i8 = e02 - this.f2129u.f(view4);
                f6 = i11;
                i13 = e02;
                i12 = i9;
            } else {
                int e03 = e0() + this.K[bVar3.f2121e];
                f6 = i11;
                i14 = e03;
                i12 = i9;
                i13 = this.f2129u.f(view4) + e03;
                z0(view4, i14, i12, i13, f6);
                if (!bVar3.c() || bVar3.b()) {
                    bVar.f2142c = true;
                }
                bVar.f2143d |= view4.hasFocusable();
                i27++;
                i11 = f6;
                i10 = i13;
                i9 = i12;
                i8 = i14;
            }
            i14 = i8;
            z0(view4, i14, i12, i13, f6);
            if (!bVar3.c()) {
            }
            bVar.f2142c = true;
            bVar.f2143d |= view4.hasFocusable();
            i27++;
            i11 = f6;
            i10 = i13;
            i9 = i12;
            i8 = i14;
        }
        Arrays.fill(this.L, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.z zVar) {
        return this.Q ? S2(zVar) : super.u(zVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void u2(RecyclerView.u uVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i6) {
        super.u2(uVar, zVar, aVar, i6);
        e3();
        if (zVar.b() > 0 && !zVar.e()) {
            U2(uVar, zVar, aVar, i6);
        }
        V2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.z zVar) {
        return this.Q ? T2(zVar) : super.v(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i6, RecyclerView.u uVar, RecyclerView.z zVar) {
        e3();
        V2();
        return super.w1(i6, uVar, zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i6, RecyclerView.u uVar, RecyclerView.z zVar) {
        e3();
        V2();
        return super.y1(i6, uVar, zVar);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        d3(RecyclerView.o.i0(context, attributeSet, i6, i7).f2276b);
    }
}
