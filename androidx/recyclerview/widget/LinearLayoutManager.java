package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.y.b {
    int A;
    int B;
    private boolean C;
    d D;
    final a E;
    private final b F;
    private int G;
    private int[] H;

    /* renamed from: s  reason: collision with root package name */
    int f2127s;

    /* renamed from: t  reason: collision with root package name */
    private c f2128t;

    /* renamed from: u  reason: collision with root package name */
    i f2129u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f2130v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f2131w;

    /* renamed from: x  reason: collision with root package name */
    boolean f2132x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f2133y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f2134z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        i f2135a;

        /* renamed from: b  reason: collision with root package name */
        int f2136b;

        /* renamed from: c  reason: collision with root package name */
        int f2137c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2138d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2139e;

        a() {
            e();
        }

        void a() {
            this.f2137c = this.f2138d ? this.f2135a.i() : this.f2135a.m();
        }

        public void b(View view, int i6) {
            this.f2137c = this.f2138d ? this.f2135a.d(view) + this.f2135a.o() : this.f2135a.g(view);
            this.f2136b = i6;
        }

        public void c(View view, int i6) {
            int o5 = this.f2135a.o();
            if (o5 >= 0) {
                b(view, i6);
                return;
            }
            this.f2136b = i6;
            if (this.f2138d) {
                int i7 = (this.f2135a.i() - o5) - this.f2135a.d(view);
                this.f2137c = this.f2135a.i() - i7;
                if (i7 > 0) {
                    int e6 = this.f2137c - this.f2135a.e(view);
                    int m5 = this.f2135a.m();
                    int min = e6 - (m5 + Math.min(this.f2135a.g(view) - m5, 0));
                    if (min < 0) {
                        this.f2137c += Math.min(i7, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g6 = this.f2135a.g(view);
            int m6 = g6 - this.f2135a.m();
            this.f2137c = g6;
            if (m6 > 0) {
                int i8 = (this.f2135a.i() - Math.min(0, (this.f2135a.i() - o5) - this.f2135a.d(view))) - (g6 + this.f2135a.e(view));
                if (i8 < 0) {
                    this.f2137c -= Math.min(m6, -i8);
                }
            }
        }

        boolean d(View view, RecyclerView.z zVar) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < zVar.b();
        }

        void e() {
            this.f2136b = -1;
            this.f2137c = Integer.MIN_VALUE;
            this.f2138d = false;
            this.f2139e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2136b + ", mCoordinate=" + this.f2137c + ", mLayoutFromEnd=" + this.f2138d + ", mValid=" + this.f2139e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2140a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2141b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2142c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2143d;

        protected b() {
        }

        void a() {
            this.f2140a = 0;
            this.f2141b = false;
            this.f2142c = false;
            this.f2143d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b  reason: collision with root package name */
        int f2145b;

        /* renamed from: c  reason: collision with root package name */
        int f2146c;

        /* renamed from: d  reason: collision with root package name */
        int f2147d;

        /* renamed from: e  reason: collision with root package name */
        int f2148e;

        /* renamed from: f  reason: collision with root package name */
        int f2149f;

        /* renamed from: g  reason: collision with root package name */
        int f2150g;

        /* renamed from: k  reason: collision with root package name */
        int f2154k;

        /* renamed from: m  reason: collision with root package name */
        boolean f2156m;

        /* renamed from: a  reason: collision with root package name */
        boolean f2144a = true;

        /* renamed from: h  reason: collision with root package name */
        int f2151h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f2152i = 0;

        /* renamed from: j  reason: collision with root package name */
        boolean f2153j = false;

        /* renamed from: l  reason: collision with root package name */
        List f2155l = null;

        c() {
        }

        private View e() {
            int size = this.f2155l.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = ((RecyclerView.c0) this.f2155l.get(i6)).f2221a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f2147d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f6 = f(view);
            this.f2147d = f6 == null ? -1 : ((RecyclerView.p) f6.getLayoutParams()).a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(RecyclerView.z zVar) {
            int i6 = this.f2147d;
            return i6 >= 0 && i6 < zVar.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View d(RecyclerView.u uVar) {
            if (this.f2155l != null) {
                return e();
            }
            View o5 = uVar.o(this.f2147d);
            this.f2147d += this.f2148e;
            return o5;
        }

        public View f(View view) {
            int a6;
            int size = this.f2155l.size();
            View view2 = null;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < size; i7++) {
                View view3 = ((RecyclerView.c0) this.f2155l.get(i7)).f2221a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (a6 = (pVar.a() - this.f2147d) * this.f2148e) >= 0 && a6 < i6) {
                    view2 = view3;
                    if (a6 == 0) {
                        break;
                    }
                    i6 = a6;
                }
            }
            return view2;
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f2157a;

        /* renamed from: b  reason: collision with root package name */
        int f2158b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2159c;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public d[] newArray(int i6) {
                return new d[i6];
            }
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f2157a = parcel.readInt();
            this.f2158b = parcel.readInt();
            this.f2159c = parcel.readInt() == 1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        boolean e() {
            return this.f2157a >= 0;
        }

        void f() {
            this.f2157a = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f2157a);
            parcel.writeInt(this.f2158b);
            parcel.writeInt(this.f2159c ? 1 : 0);
        }

        public d(d dVar) {
            this.f2157a = dVar.f2157a;
            this.f2158b = dVar.f2158b;
            this.f2159c = dVar.f2159c;
        }
    }

    public LinearLayoutManager(Context context, int i6, boolean z5) {
        this.f2127s = 1;
        this.f2131w = false;
        this.f2132x = false;
        this.f2133y = false;
        this.f2134z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        C2(i6);
        D2(z5);
    }

    private void A2() {
        this.f2132x = (this.f2127s == 1 || !q2()) ? this.f2131w : !this.f2131w;
    }

    private boolean F2(RecyclerView.u uVar, RecyclerView.z zVar, a aVar) {
        boolean z5 = false;
        if (J() == 0) {
            return false;
        }
        View V = V();
        if (V != null && aVar.d(V, zVar)) {
            aVar.c(V, h0(V));
            return true;
        } else if (this.f2130v != this.f2133y) {
            return false;
        } else {
            View i22 = aVar.f2138d ? i2(uVar, zVar) : j2(uVar, zVar);
            if (i22 != null) {
                aVar.b(i22, h0(i22));
                if (!zVar.e() && L1()) {
                    if ((this.f2129u.g(i22) >= this.f2129u.i() || this.f2129u.d(i22) < this.f2129u.m()) ? true : true) {
                        aVar.f2137c = aVar.f2138d ? this.f2129u.i() : this.f2129u.m();
                    }
                }
                return true;
            }
            return false;
        }
    }

    private boolean G2(RecyclerView.z zVar, a aVar) {
        int i6;
        if (!zVar.e() && (i6 = this.A) != -1) {
            if (i6 >= 0 && i6 < zVar.b()) {
                aVar.f2136b = this.A;
                d dVar = this.D;
                if (dVar != null && dVar.e()) {
                    boolean z5 = this.D.f2159c;
                    aVar.f2138d = z5;
                    aVar.f2137c = z5 ? this.f2129u.i() - this.D.f2158b : this.f2129u.m() + this.D.f2158b;
                    return true;
                } else if (this.B != Integer.MIN_VALUE) {
                    boolean z6 = this.f2132x;
                    aVar.f2138d = z6;
                    aVar.f2137c = z6 ? this.f2129u.i() - this.B : this.f2129u.m() + this.B;
                    return true;
                } else {
                    View C = C(this.A);
                    if (C == null) {
                        if (J() > 0) {
                            aVar.f2138d = (this.A < h0(I(0))) == this.f2132x;
                        }
                        aVar.a();
                    } else if (this.f2129u.e(C) > this.f2129u.n()) {
                        aVar.a();
                        return true;
                    } else if (this.f2129u.g(C) - this.f2129u.m() < 0) {
                        aVar.f2137c = this.f2129u.m();
                        aVar.f2138d = false;
                        return true;
                    } else if (this.f2129u.i() - this.f2129u.d(C) < 0) {
                        aVar.f2137c = this.f2129u.i();
                        aVar.f2138d = true;
                        return true;
                    } else {
                        aVar.f2137c = aVar.f2138d ? this.f2129u.d(C) + this.f2129u.o() : this.f2129u.g(C);
                    }
                    return true;
                }
            }
            this.A = -1;
            this.B = Integer.MIN_VALUE;
        }
        return false;
    }

    private void H2(RecyclerView.u uVar, RecyclerView.z zVar, a aVar) {
        if (G2(zVar, aVar) || F2(uVar, zVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f2136b = this.f2133y ? zVar.b() - 1 : 0;
    }

    private void I2(int i6, int i7, boolean z5, RecyclerView.z zVar) {
        int m5;
        this.f2128t.f2156m = z2();
        this.f2128t.f2149f = i6;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(zVar, iArr);
        int max = Math.max(0, this.H[0]);
        int max2 = Math.max(0, this.H[1]);
        boolean z6 = i6 == 1;
        c cVar = this.f2128t;
        int i8 = z6 ? max2 : max;
        cVar.f2151h = i8;
        if (!z6) {
            max = max2;
        }
        cVar.f2152i = max;
        if (z6) {
            cVar.f2151h = i8 + this.f2129u.j();
            View m22 = m2();
            c cVar2 = this.f2128t;
            cVar2.f2148e = this.f2132x ? -1 : 1;
            int h02 = h0(m22);
            c cVar3 = this.f2128t;
            cVar2.f2147d = h02 + cVar3.f2148e;
            cVar3.f2145b = this.f2129u.d(m22);
            m5 = this.f2129u.d(m22) - this.f2129u.i();
        } else {
            View n22 = n2();
            this.f2128t.f2151h += this.f2129u.m();
            c cVar4 = this.f2128t;
            cVar4.f2148e = this.f2132x ? 1 : -1;
            int h03 = h0(n22);
            c cVar5 = this.f2128t;
            cVar4.f2147d = h03 + cVar5.f2148e;
            cVar5.f2145b = this.f2129u.g(n22);
            m5 = (-this.f2129u.g(n22)) + this.f2129u.m();
        }
        c cVar6 = this.f2128t;
        cVar6.f2146c = i7;
        if (z5) {
            cVar6.f2146c = i7 - m5;
        }
        cVar6.f2150g = m5;
    }

    private void J2(int i6, int i7) {
        this.f2128t.f2146c = this.f2129u.i() - i7;
        c cVar = this.f2128t;
        cVar.f2148e = this.f2132x ? -1 : 1;
        cVar.f2147d = i6;
        cVar.f2149f = 1;
        cVar.f2145b = i7;
        cVar.f2150g = Integer.MIN_VALUE;
    }

    private void K2(a aVar) {
        J2(aVar.f2136b, aVar.f2137c);
    }

    private void L2(int i6, int i7) {
        this.f2128t.f2146c = i7 - this.f2129u.m();
        c cVar = this.f2128t;
        cVar.f2147d = i6;
        cVar.f2148e = this.f2132x ? 1 : -1;
        cVar.f2149f = -1;
        cVar.f2145b = i7;
        cVar.f2150g = Integer.MIN_VALUE;
    }

    private void M2(a aVar) {
        L2(aVar.f2136b, aVar.f2137c);
    }

    private int O1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.a(zVar, this.f2129u, Y1(!this.f2134z, true), X1(!this.f2134z, true), this, this.f2134z);
    }

    private int P1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.b(zVar, this.f2129u, Y1(!this.f2134z, true), X1(!this.f2134z, true), this, this.f2134z, this.f2132x);
    }

    private int Q1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.c(zVar, this.f2129u, Y1(!this.f2134z, true), X1(!this.f2134z, true), this, this.f2134z);
    }

    private View V1() {
        return d2(0, J());
    }

    private View W1(RecyclerView.u uVar, RecyclerView.z zVar) {
        return h2(uVar, zVar, 0, J(), zVar.b());
    }

    private View a2() {
        return d2(J() - 1, -1);
    }

    private View b2(RecyclerView.u uVar, RecyclerView.z zVar) {
        return h2(uVar, zVar, J() - 1, -1, zVar.b());
    }

    private View f2() {
        return this.f2132x ? V1() : a2();
    }

    private View g2() {
        return this.f2132x ? a2() : V1();
    }

    private View i2(RecyclerView.u uVar, RecyclerView.z zVar) {
        return this.f2132x ? W1(uVar, zVar) : b2(uVar, zVar);
    }

    private View j2(RecyclerView.u uVar, RecyclerView.z zVar) {
        return this.f2132x ? b2(uVar, zVar) : W1(uVar, zVar);
    }

    private int k2(int i6, RecyclerView.u uVar, RecyclerView.z zVar, boolean z5) {
        int i7;
        int i8 = this.f2129u.i() - i6;
        if (i8 > 0) {
            int i9 = -B2(-i8, uVar, zVar);
            int i10 = i6 + i9;
            if (!z5 || (i7 = this.f2129u.i() - i10) <= 0) {
                return i9;
            }
            this.f2129u.r(i7);
            return i7 + i9;
        }
        return 0;
    }

    private int l2(int i6, RecyclerView.u uVar, RecyclerView.z zVar, boolean z5) {
        int m5;
        int m6 = i6 - this.f2129u.m();
        if (m6 > 0) {
            int i7 = -B2(m6, uVar, zVar);
            int i8 = i6 + i7;
            if (!z5 || (m5 = i8 - this.f2129u.m()) <= 0) {
                return i7;
            }
            this.f2129u.r(-m5);
            return i7 - m5;
        }
        return 0;
    }

    private View m2() {
        return I(this.f2132x ? 0 : J() - 1);
    }

    private View n2() {
        return I(this.f2132x ? J() - 1 : 0);
    }

    private void t2(RecyclerView.u uVar, RecyclerView.z zVar, int i6, int i7) {
        if (!zVar.g() || J() == 0 || zVar.e() || !L1()) {
            return;
        }
        List k6 = uVar.k();
        int size = k6.size();
        int h02 = h0(I(0));
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            RecyclerView.c0 c0Var = (RecyclerView.c0) k6.get(i10);
            if (!c0Var.v()) {
                char c6 = (c0Var.m() < h02) != this.f2132x ? (char) 65535 : (char) 1;
                int e6 = this.f2129u.e(c0Var.f2221a);
                if (c6 == 65535) {
                    i8 += e6;
                } else {
                    i9 += e6;
                }
            }
        }
        this.f2128t.f2155l = k6;
        if (i8 > 0) {
            L2(h0(n2()), i6);
            c cVar = this.f2128t;
            cVar.f2151h = i8;
            cVar.f2146c = 0;
            cVar.a();
            U1(uVar, this.f2128t, zVar, false);
        }
        if (i9 > 0) {
            J2(h0(m2()), i7);
            c cVar2 = this.f2128t;
            cVar2.f2151h = i9;
            cVar2.f2146c = 0;
            cVar2.a();
            U1(uVar, this.f2128t, zVar, false);
        }
        this.f2128t.f2155l = null;
    }

    private void v2(RecyclerView.u uVar, c cVar) {
        if (!cVar.f2144a || cVar.f2156m) {
            return;
        }
        int i6 = cVar.f2150g;
        int i7 = cVar.f2152i;
        if (cVar.f2149f == -1) {
            x2(uVar, i6, i7);
        } else {
            y2(uVar, i6, i7);
        }
    }

    private void w2(RecyclerView.u uVar, int i6, int i7) {
        if (i6 == i7) {
            return;
        }
        if (i7 <= i6) {
            while (i6 > i7) {
                n1(i6, uVar);
                i6--;
            }
            return;
        }
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            n1(i8, uVar);
        }
    }

    private void x2(RecyclerView.u uVar, int i6, int i7) {
        int J = J();
        if (i6 < 0) {
            return;
        }
        int h6 = (this.f2129u.h() - i6) + i7;
        if (this.f2132x) {
            for (int i8 = 0; i8 < J; i8++) {
                View I = I(i8);
                if (this.f2129u.g(I) < h6 || this.f2129u.q(I) < h6) {
                    w2(uVar, 0, i8);
                    return;
                }
            }
            return;
        }
        int i9 = J - 1;
        for (int i10 = i9; i10 >= 0; i10--) {
            View I2 = I(i10);
            if (this.f2129u.g(I2) < h6 || this.f2129u.q(I2) < h6) {
                w2(uVar, i9, i10);
                return;
            }
        }
    }

    private void y2(RecyclerView.u uVar, int i6, int i7) {
        if (i6 < 0) {
            return;
        }
        int i8 = i6 - i7;
        int J = J();
        if (!this.f2132x) {
            for (int i9 = 0; i9 < J; i9++) {
                View I = I(i9);
                if (this.f2129u.d(I) > i8 || this.f2129u.p(I) > i8) {
                    w2(uVar, 0, i9);
                    return;
                }
            }
            return;
        }
        int i10 = J - 1;
        for (int i11 = i10; i11 >= 0; i11--) {
            View I2 = I(i11);
            if (this.f2129u.d(I2) > i8 || this.f2129u.p(I2) > i8) {
                w2(uVar, i10, i11);
                return;
            }
        }
    }

    int B2(int i6, RecyclerView.u uVar, RecyclerView.z zVar) {
        if (J() == 0 || i6 == 0) {
            return 0;
        }
        T1();
        this.f2128t.f2144a = true;
        int i7 = i6 > 0 ? 1 : -1;
        int abs = Math.abs(i6);
        I2(i7, abs, true, zVar);
        c cVar = this.f2128t;
        int U1 = cVar.f2150g + U1(uVar, cVar, zVar, false);
        if (U1 < 0) {
            return 0;
        }
        if (abs > U1) {
            i6 = i7 * U1;
        }
        this.f2129u.r(-i6);
        this.f2128t.f2154k = i6;
        return i6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View C(int i6) {
        int J = J();
        if (J == 0) {
            return null;
        }
        int h02 = i6 - h0(I(0));
        if (h02 >= 0 && h02 < J) {
            View I = I(h02);
            if (h0(I) == i6) {
                return I;
            }
        }
        return super.C(i6);
    }

    public void C2(int i6) {
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i6);
        }
        g(null);
        if (i6 != this.f2127s || this.f2129u == null) {
            i b6 = i.b(this, i6);
            this.f2129u = b6;
            this.E.f2135a = b6;
            this.f2127s = i6;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return new RecyclerView.p(-2, -2);
    }

    public void D2(boolean z5) {
        g(null);
        if (z5 == this.f2131w) {
            return;
        }
        this.f2131w = z5;
        t1();
    }

    public void E2(boolean z5) {
        g(null);
        if (this.f2133y == z5) {
            return;
        }
        this.f2133y = z5;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean G1() {
        return (X() == 1073741824 || p0() == 1073741824 || !q0()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.u uVar) {
        super.I0(recyclerView, uVar);
        if (this.C) {
            k1(uVar);
            uVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.z zVar, int i6) {
        g gVar = new g(recyclerView.getContext());
        gVar.p(i6);
        J1(gVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i6, RecyclerView.u uVar, RecyclerView.z zVar) {
        int R1;
        A2();
        if (J() == 0 || (R1 = R1(i6)) == Integer.MIN_VALUE) {
            return null;
        }
        T1();
        I2(R1, (int) (this.f2129u.n() * 0.33333334f), false, zVar);
        c cVar = this.f2128t;
        cVar.f2150g = Integer.MIN_VALUE;
        cVar.f2144a = false;
        U1(uVar, cVar, zVar, true);
        View g22 = R1 == -1 ? g2() : f2();
        View n22 = R1 == -1 ? n2() : m2();
        if (n22.hasFocusable()) {
            if (g22 == null) {
                return null;
            }
            return n22;
        }
        return g22;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            accessibilityEvent.setFromIndex(Z1());
            accessibilityEvent.setToIndex(c2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.D == null && this.f2130v == this.f2133y;
    }

    protected void M1(RecyclerView.z zVar, int[] iArr) {
        int i6;
        int o22 = o2(zVar);
        if (this.f2128t.f2149f == -1) {
            i6 = 0;
        } else {
            i6 = o22;
            o22 = 0;
        }
        iArr[0] = o22;
        iArr[1] = i6;
    }

    void N1(RecyclerView.z zVar, c cVar, RecyclerView.o.c cVar2) {
        int i6 = cVar.f2147d;
        if (i6 < 0 || i6 >= zVar.b()) {
            return;
        }
        cVar2.a(i6, Math.max(0, cVar.f2150g));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int R1(int i6) {
        return i6 != 1 ? i6 != 2 ? i6 != 17 ? i6 != 33 ? i6 != 66 ? (i6 == 130 && this.f2127s == 1) ? 1 : Integer.MIN_VALUE : this.f2127s == 0 ? 1 : Integer.MIN_VALUE : this.f2127s == 1 ? -1 : Integer.MIN_VALUE : this.f2127s == 0 ? -1 : Integer.MIN_VALUE : (this.f2127s != 1 && q2()) ? -1 : 1 : (this.f2127s != 1 && q2()) ? 1 : -1;
    }

    c S1() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T1() {
        if (this.f2128t == null) {
            this.f2128t = S1();
        }
    }

    int U1(RecyclerView.u uVar, c cVar, RecyclerView.z zVar, boolean z5) {
        int i6 = cVar.f2146c;
        int i7 = cVar.f2150g;
        if (i7 != Integer.MIN_VALUE) {
            if (i6 < 0) {
                cVar.f2150g = i7 + i6;
            }
            v2(uVar, cVar);
        }
        int i8 = cVar.f2146c + cVar.f2151h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.f2156m && i8 <= 0) || !cVar.c(zVar)) {
                break;
            }
            bVar.a();
            s2(uVar, zVar, cVar, bVar);
            if (!bVar.f2141b) {
                cVar.f2145b += bVar.f2140a * cVar.f2149f;
                if (!bVar.f2142c || cVar.f2155l != null || !zVar.e()) {
                    int i9 = cVar.f2146c;
                    int i10 = bVar.f2140a;
                    cVar.f2146c = i9 - i10;
                    i8 -= i10;
                }
                int i11 = cVar.f2150g;
                if (i11 != Integer.MIN_VALUE) {
                    int i12 = i11 + bVar.f2140a;
                    cVar.f2150g = i12;
                    int i13 = cVar.f2146c;
                    if (i13 < 0) {
                        cVar.f2150g = i12 + i13;
                    }
                    v2(uVar, cVar);
                }
                if (z5 && bVar.f2143d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i6 - cVar.f2146c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.u uVar, RecyclerView.z zVar) {
        int i6;
        int i7;
        int i8;
        int i9;
        int k22;
        int i10;
        View C;
        int g6;
        int i11;
        int i12 = -1;
        if (!(this.D == null && this.A == -1) && zVar.b() == 0) {
            k1(uVar);
            return;
        }
        d dVar = this.D;
        if (dVar != null && dVar.e()) {
            this.A = this.D.f2157a;
        }
        T1();
        this.f2128t.f2144a = false;
        A2();
        View V = V();
        a aVar = this.E;
        if (!aVar.f2139e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.E;
            aVar2.f2138d = this.f2132x ^ this.f2133y;
            H2(uVar, zVar, aVar2);
            this.E.f2139e = true;
        } else if (V != null && (this.f2129u.g(V) >= this.f2129u.i() || this.f2129u.d(V) <= this.f2129u.m())) {
            this.E.c(V, h0(V));
        }
        c cVar = this.f2128t;
        cVar.f2149f = cVar.f2154k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(zVar, iArr);
        int max = Math.max(0, this.H[0]) + this.f2129u.m();
        int max2 = Math.max(0, this.H[1]) + this.f2129u.j();
        if (zVar.e() && (i10 = this.A) != -1 && this.B != Integer.MIN_VALUE && (C = C(i10)) != null) {
            if (this.f2132x) {
                i11 = this.f2129u.i() - this.f2129u.d(C);
                g6 = this.B;
            } else {
                g6 = this.f2129u.g(C) - this.f2129u.m();
                i11 = this.B;
            }
            int i13 = i11 - g6;
            if (i13 > 0) {
                max += i13;
            } else {
                max2 -= i13;
            }
        }
        a aVar3 = this.E;
        if (!aVar3.f2138d ? !this.f2132x : this.f2132x) {
            i12 = 1;
        }
        u2(uVar, zVar, aVar3, i12);
        w(uVar);
        this.f2128t.f2156m = z2();
        this.f2128t.f2153j = zVar.e();
        this.f2128t.f2152i = 0;
        a aVar4 = this.E;
        if (aVar4.f2138d) {
            M2(aVar4);
            c cVar2 = this.f2128t;
            cVar2.f2151h = max;
            U1(uVar, cVar2, zVar, false);
            c cVar3 = this.f2128t;
            i7 = cVar3.f2145b;
            int i14 = cVar3.f2147d;
            int i15 = cVar3.f2146c;
            if (i15 > 0) {
                max2 += i15;
            }
            K2(this.E);
            c cVar4 = this.f2128t;
            cVar4.f2151h = max2;
            cVar4.f2147d += cVar4.f2148e;
            U1(uVar, cVar4, zVar, false);
            c cVar5 = this.f2128t;
            i6 = cVar5.f2145b;
            int i16 = cVar5.f2146c;
            if (i16 > 0) {
                L2(i14, i7);
                c cVar6 = this.f2128t;
                cVar6.f2151h = i16;
                U1(uVar, cVar6, zVar, false);
                i7 = this.f2128t.f2145b;
            }
        } else {
            K2(aVar4);
            c cVar7 = this.f2128t;
            cVar7.f2151h = max2;
            U1(uVar, cVar7, zVar, false);
            c cVar8 = this.f2128t;
            i6 = cVar8.f2145b;
            int i17 = cVar8.f2147d;
            int i18 = cVar8.f2146c;
            if (i18 > 0) {
                max += i18;
            }
            M2(this.E);
            c cVar9 = this.f2128t;
            cVar9.f2151h = max;
            cVar9.f2147d += cVar9.f2148e;
            U1(uVar, cVar9, zVar, false);
            c cVar10 = this.f2128t;
            i7 = cVar10.f2145b;
            int i19 = cVar10.f2146c;
            if (i19 > 0) {
                J2(i17, i6);
                c cVar11 = this.f2128t;
                cVar11.f2151h = i19;
                U1(uVar, cVar11, zVar, false);
                i6 = this.f2128t.f2145b;
            }
        }
        if (J() > 0) {
            if (this.f2132x ^ this.f2133y) {
                int k23 = k2(i6, uVar, zVar, true);
                i8 = i7 + k23;
                i9 = i6 + k23;
                k22 = l2(i8, uVar, zVar, false);
            } else {
                int l22 = l2(i7, uVar, zVar, true);
                i8 = i7 + l22;
                i9 = i6 + l22;
                k22 = k2(i9, uVar, zVar, false);
            }
            i7 = i8 + k22;
            i6 = i9 + k22;
        }
        t2(uVar, zVar, i7, i6);
        if (zVar.e()) {
            this.E.e();
        } else {
            this.f2129u.s();
        }
        this.f2130v = this.f2133y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View X1(boolean z5, boolean z6) {
        int J;
        int i6;
        if (this.f2132x) {
            J = 0;
            i6 = J();
        } else {
            J = J() - 1;
            i6 = -1;
        }
        return e2(J, i6, z5, z6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.z zVar) {
        super.Y0(zVar);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Y1(boolean z5, boolean z6) {
        int i6;
        int J;
        if (this.f2132x) {
            i6 = J() - 1;
            J = -1;
        } else {
            i6 = 0;
            J = J();
        }
        return e2(i6, J, z5, z6);
    }

    public int Z1() {
        View e22 = e2(0, J(), false, true);
        if (e22 == null) {
            return -1;
        }
        return h0(e22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF a(int i6) {
        if (J() == 0) {
            return null;
        }
        int i7 = (i6 < h0(I(0))) != this.f2132x ? -1 : 1;
        return this.f2127s == 0 ? new PointF(i7, 0.0f) : new PointF(0.0f, i7);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.D = (d) parcelable;
            t1();
        }
    }

    public int c2() {
        View e22 = e2(J() - 1, -1, false, true);
        if (e22 == null) {
            return -1;
        }
        return h0(e22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        if (this.D != null) {
            return new d(this.D);
        }
        d dVar = new d();
        if (J() > 0) {
            T1();
            boolean z5 = this.f2130v ^ this.f2132x;
            dVar.f2159c = z5;
            if (z5) {
                View m22 = m2();
                dVar.f2158b = this.f2129u.i() - this.f2129u.d(m22);
                dVar.f2157a = h0(m22);
            } else {
                View n22 = n2();
                dVar.f2157a = h0(n22);
                dVar.f2158b = this.f2129u.g(n22) - this.f2129u.m();
            }
        } else {
            dVar.f();
        }
        return dVar;
    }

    View d2(int i6, int i7) {
        int i8;
        int i9;
        T1();
        if ((i7 > i6 ? (char) 1 : i7 < i6 ? (char) 65535 : (char) 0) == 0) {
            return I(i6);
        }
        if (this.f2129u.g(I(i6)) < this.f2129u.m()) {
            i8 = 16644;
            i9 = 16388;
        } else {
            i8 = 4161;
            i9 = 4097;
        }
        return (this.f2127s == 0 ? this.f2259e : this.f2260f).a(i6, i7, i8, i9);
    }

    View e2(int i6, int i7, boolean z5, boolean z6) {
        T1();
        return (this.f2127s == 0 ? this.f2259e : this.f2260f).a(i6, i7, z5 ? 24579 : 320, z6 ? 320 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.D == null) {
            super.g(str);
        }
    }

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
            if (h02 >= 0 && h02 < i8) {
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
    public boolean k() {
        return this.f2127s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f2127s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i6, int i7, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        if (this.f2127s != 0) {
            i6 = i7;
        }
        if (J() == 0 || i6 == 0) {
            return;
        }
        T1();
        I2(i6 > 0 ? 1 : -1, Math.abs(i6), true, zVar);
        N1(zVar, this.f2128t, cVar);
    }

    protected int o2(RecyclerView.z zVar) {
        if (zVar.d()) {
            return this.f2129u.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i6, RecyclerView.o.c cVar) {
        boolean z5;
        int i7;
        d dVar = this.D;
        if (dVar == null || !dVar.e()) {
            A2();
            z5 = this.f2132x;
            i7 = this.A;
            if (i7 == -1) {
                i7 = z5 ? i6 - 1 : 0;
            }
        } else {
            d dVar2 = this.D;
            z5 = dVar2.f2159c;
            i7 = dVar2.f2157a;
        }
        int i8 = z5 ? -1 : 1;
        for (int i9 = 0; i9 < this.G && i7 >= 0 && i7 < i6; i9++) {
            cVar.a(i7, 0);
            i7 += i8;
        }
    }

    public int p2() {
        return this.f2127s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.z zVar) {
        return O1(zVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.z zVar) {
        return P1(zVar);
    }

    public boolean r2() {
        return this.f2134z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return true;
    }

    void s2(RecyclerView.u uVar, RecyclerView.z zVar, c cVar, b bVar) {
        int i6;
        int i7;
        int i8;
        int i9;
        int f6;
        View d6 = cVar.d(uVar);
        if (d6 == null) {
            bVar.f2141b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) d6.getLayoutParams();
        if (cVar.f2155l == null) {
            if (this.f2132x == (cVar.f2149f == -1)) {
                d(d6);
            } else {
                e(d6, 0);
            }
        } else {
            if (this.f2132x == (cVar.f2149f == -1)) {
                b(d6);
            } else {
                c(d6, 0);
            }
        }
        A0(d6, 0, 0);
        bVar.f2140a = this.f2129u.e(d6);
        if (this.f2127s == 1) {
            if (q2()) {
                f6 = o0() - f0();
                i9 = f6 - this.f2129u.f(d6);
            } else {
                i9 = e0();
                f6 = this.f2129u.f(d6) + i9;
            }
            int i10 = cVar.f2149f;
            int i11 = cVar.f2145b;
            if (i10 == -1) {
                i8 = i11;
                i7 = f6;
                i6 = i11 - bVar.f2140a;
            } else {
                i6 = i11;
                i7 = f6;
                i8 = bVar.f2140a + i11;
            }
        } else {
            int g02 = g0();
            int f7 = this.f2129u.f(d6) + g02;
            int i12 = cVar.f2149f;
            int i13 = cVar.f2145b;
            if (i12 == -1) {
                i7 = i13;
                i6 = g02;
                i8 = f7;
                i9 = i13 - bVar.f2140a;
            } else {
                i6 = g02;
                i7 = bVar.f2140a + i13;
                i8 = f7;
                i9 = i13;
            }
        }
        z0(d6, i9, i6, i7, i8);
        if (pVar.c() || pVar.b()) {
            bVar.f2142c = true;
        }
        bVar.f2143d = d6.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.z zVar) {
        return O1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.z zVar) {
        return P1(zVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u2(RecyclerView.u uVar, RecyclerView.z zVar, a aVar, int i6) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i6, RecyclerView.u uVar, RecyclerView.z zVar) {
        if (this.f2127s == 1) {
            return 0;
        }
        return B2(i6, uVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i6) {
        this.A = i6;
        this.B = Integer.MIN_VALUE;
        d dVar = this.D;
        if (dVar != null) {
            dVar.f();
        }
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i6, RecyclerView.u uVar, RecyclerView.z zVar) {
        if (this.f2127s == 0) {
            return 0;
        }
        return B2(i6, uVar, zVar);
    }

    boolean z2() {
        return this.f2129u.k() == 0 && this.f2129u.h() == 0;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i6, int i7) {
        this.f2127s = 1;
        this.f2131w = false;
        this.f2132x = false;
        this.f2133y = false;
        this.f2134z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.o.d i02 = RecyclerView.o.i0(context, attributeSet, i6, i7);
        C2(i02.f2275a);
        D2(i02.f2277c);
        E2(i02.f2278d);
    }
}
