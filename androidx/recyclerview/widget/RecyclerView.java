package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.p;
import e0.o0;
import f0.y;
import io.jsonwebtoken.JwtParser;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;
import okio.Segment;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements e0.p {
    static final boolean A0;
    static final boolean B0;
    private static final boolean C0;
    private static final boolean D0;
    private static final Class[] E0;
    static final Interpolator F0;

    /* renamed from: x0  reason: collision with root package name */
    private static final int[] f2160x0 = {16843830};

    /* renamed from: y0  reason: collision with root package name */
    static final boolean f2161y0;

    /* renamed from: z0  reason: collision with root package name */
    static final boolean f2162z0;
    boolean A;
    private final AccessibilityManager B;
    private List C;
    boolean D;
    boolean E;
    private int F;
    private int G;
    private k H;
    private EdgeEffect I;
    private EdgeEffect J;
    private EdgeEffect K;
    private EdgeEffect L;
    l M;
    private int N;
    private int O;
    private VelocityTracker P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private q V;
    private final int W;

    /* renamed from: a0  reason: collision with root package name */
    private final int f2163a0;

    /* renamed from: b  reason: collision with root package name */
    private final w f2164b;

    /* renamed from: b0  reason: collision with root package name */
    private float f2165b0;

    /* renamed from: c  reason: collision with root package name */
    final u f2166c;

    /* renamed from: c0  reason: collision with root package name */
    private float f2167c0;

    /* renamed from: d  reason: collision with root package name */
    private x f2168d;

    /* renamed from: d0  reason: collision with root package name */
    private boolean f2169d0;

    /* renamed from: e  reason: collision with root package name */
    androidx.recyclerview.widget.a f2170e;

    /* renamed from: e0  reason: collision with root package name */
    final b0 f2171e0;

    /* renamed from: f  reason: collision with root package name */
    androidx.recyclerview.widget.b f2172f;

    /* renamed from: f0  reason: collision with root package name */
    androidx.recyclerview.widget.e f2173f0;

    /* renamed from: g  reason: collision with root package name */
    final androidx.recyclerview.widget.p f2174g;

    /* renamed from: g0  reason: collision with root package name */
    e.b f2175g0;

    /* renamed from: h  reason: collision with root package name */
    boolean f2176h;

    /* renamed from: h0  reason: collision with root package name */
    final z f2177h0;

    /* renamed from: i  reason: collision with root package name */
    final Runnable f2178i;

    /* renamed from: i0  reason: collision with root package name */
    private s f2179i0;

    /* renamed from: j  reason: collision with root package name */
    final Rect f2180j;

    /* renamed from: j0  reason: collision with root package name */
    private List f2181j0;

    /* renamed from: k  reason: collision with root package name */
    private final Rect f2182k;

    /* renamed from: k0  reason: collision with root package name */
    boolean f2183k0;

    /* renamed from: l  reason: collision with root package name */
    final RectF f2184l;

    /* renamed from: l0  reason: collision with root package name */
    boolean f2185l0;

    /* renamed from: m  reason: collision with root package name */
    g f2186m;

    /* renamed from: m0  reason: collision with root package name */
    private l.a f2187m0;

    /* renamed from: n  reason: collision with root package name */
    o f2188n;

    /* renamed from: n0  reason: collision with root package name */
    boolean f2189n0;

    /* renamed from: o  reason: collision with root package name */
    final ArrayList f2190o;

    /* renamed from: o0  reason: collision with root package name */
    androidx.recyclerview.widget.k f2191o0;

    /* renamed from: p  reason: collision with root package name */
    private final ArrayList f2192p;

    /* renamed from: p0  reason: collision with root package name */
    private final int[] f2193p0;

    /* renamed from: q  reason: collision with root package name */
    private r f2194q;

    /* renamed from: q0  reason: collision with root package name */
    private e0.q f2195q0;

    /* renamed from: r  reason: collision with root package name */
    boolean f2196r;

    /* renamed from: r0  reason: collision with root package name */
    private final int[] f2197r0;

    /* renamed from: s  reason: collision with root package name */
    boolean f2198s;

    /* renamed from: s0  reason: collision with root package name */
    private final int[] f2199s0;

    /* renamed from: t  reason: collision with root package name */
    boolean f2200t;

    /* renamed from: t0  reason: collision with root package name */
    final int[] f2201t0;

    /* renamed from: u  reason: collision with root package name */
    boolean f2202u;

    /* renamed from: u0  reason: collision with root package name */
    final List f2203u0;

    /* renamed from: v  reason: collision with root package name */
    private int f2204v;

    /* renamed from: v0  reason: collision with root package name */
    private Runnable f2205v0;

    /* renamed from: w  reason: collision with root package name */
    boolean f2206w;

    /* renamed from: w0  reason: collision with root package name */
    private final p.b f2207w0;

    /* renamed from: x  reason: collision with root package name */
    boolean f2208x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f2209y;

    /* renamed from: z  reason: collision with root package name */
    private int f2210z;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f2202u || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f2196r) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f2208x) {
                recyclerView2.f2206w = true;
            } else {
                recyclerView2.u();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a0 {
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.M;
            if (lVar != null) {
                lVar.u();
            }
            RecyclerView.this.f2189n0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f2213a;

        /* renamed from: b  reason: collision with root package name */
        private int f2214b;

        /* renamed from: c  reason: collision with root package name */
        OverScroller f2215c;

        /* renamed from: d  reason: collision with root package name */
        Interpolator f2216d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2217e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2218f;

        b0() {
            Interpolator interpolator = RecyclerView.F0;
            this.f2216d = interpolator;
            this.f2217e = false;
            this.f2218f = false;
            this.f2215c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i6, int i7, int i8, int i9) {
            int i10;
            int abs = Math.abs(i6);
            int abs2 = Math.abs(i7);
            boolean z5 = abs > abs2;
            int sqrt = (int) Math.sqrt((i8 * i8) + (i9 * i9));
            int sqrt2 = (int) Math.sqrt((i6 * i6) + (i7 * i7));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z5 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i11 = width / 2;
            float f6 = width;
            float f7 = i11;
            float b6 = f7 + (b(Math.min(1.0f, (sqrt2 * 1.0f) / f6)) * f7);
            if (sqrt > 0) {
                i10 = Math.round(Math.abs(b6 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z5) {
                    abs = abs2;
                }
                i10 = (int) (((abs / f6) + 1.0f) * 300.0f);
            }
            return Math.min(i10, 2000);
        }

        private float b(float f6) {
            return (float) Math.sin((f6 - 0.5f) * 0.47123894f);
        }

        private void d() {
            RecyclerView.this.removeCallbacks(this);
            e0.b0.d0(RecyclerView.this, this);
        }

        public void c(int i6, int i7) {
            RecyclerView.this.setScrollState(2);
            this.f2214b = 0;
            this.f2213a = 0;
            Interpolator interpolator = this.f2216d;
            Interpolator interpolator2 = RecyclerView.F0;
            if (interpolator != interpolator2) {
                this.f2216d = interpolator2;
                this.f2215c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f2215c.fling(0, 0, i6, i7, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        void e() {
            if (this.f2217e) {
                this.f2218f = true;
            } else {
                d();
            }
        }

        public void f(int i6, int i7, int i8, Interpolator interpolator) {
            if (i8 == Integer.MIN_VALUE) {
                i8 = a(i6, i7, 0, 0);
            }
            int i9 = i8;
            if (interpolator == null) {
                interpolator = RecyclerView.F0;
            }
            if (this.f2216d != interpolator) {
                this.f2216d = interpolator;
                this.f2215c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f2214b = 0;
            this.f2213a = 0;
            RecyclerView.this.setScrollState(2);
            this.f2215c.startScroll(0, 0, i6, i7, i9);
            if (Build.VERSION.SDK_INT < 23) {
                this.f2215c.computeScrollOffset();
            }
            e();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.f2215c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i6;
            int i7;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f2188n == null) {
                g();
                return;
            }
            this.f2218f = false;
            this.f2217e = true;
            recyclerView.u();
            OverScroller overScroller = this.f2215c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i8 = currX - this.f2213a;
                int i9 = currY - this.f2214b;
                this.f2213a = currX;
                this.f2214b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.f2201t0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.F(i8, i9, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.f2201t0;
                    i8 -= iArr2[0];
                    i9 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.t(i8, i9);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f2186m != null) {
                    int[] iArr3 = recyclerView3.f2201t0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.f1(i8, i9, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.f2201t0;
                    i7 = iArr4[0];
                    i6 = iArr4[1];
                    i8 -= i7;
                    i9 -= i6;
                    y yVar = recyclerView4.f2188n.f2261g;
                    if (yVar != null && !yVar.g() && yVar.h()) {
                        int b6 = RecyclerView.this.f2177h0.b();
                        if (b6 == 0) {
                            yVar.r();
                        } else {
                            if (yVar.f() >= b6) {
                                yVar.p(b6 - 1);
                            }
                            yVar.j(i7, i6);
                        }
                    }
                } else {
                    i6 = 0;
                    i7 = 0;
                }
                if (!RecyclerView.this.f2190o.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.f2201t0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.G(i7, i6, i8, i9, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.f2201t0;
                int i10 = i8 - iArr6[0];
                int i11 = i9 - iArr6[1];
                if (i7 != 0 || i6 != 0) {
                    recyclerView6.I(i7, i6);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z5 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i10 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i11 != 0));
                y yVar2 = RecyclerView.this.f2188n.f2261g;
                if ((yVar2 != null && yVar2.g()) || !z5) {
                    e();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.e eVar = recyclerView7.f2173f0;
                    if (eVar != null) {
                        eVar.f(recyclerView7, i7, i6);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i12 = i10 < 0 ? -currVelocity : i10 > 0 ? currVelocity : 0;
                        if (i11 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i11 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i12, currVelocity);
                    }
                    if (RecyclerView.B0) {
                        RecyclerView.this.f2175g0.b();
                    }
                }
            }
            y yVar3 = RecyclerView.this.f2188n.f2261g;
            if (yVar3 != null && yVar3.g()) {
                yVar3.j(0, 0);
            }
            this.f2217e = false;
            if (this.f2218f) {
                d();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.s1(1);
        }
    }

    /* loaded from: classes.dex */
    static class c implements Interpolator {
        c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 - 1.0f;
            return (f7 * f7 * f7 * f7 * f7) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c0 {

        /* renamed from: s  reason: collision with root package name */
        private static final List f2220s = Collections.emptyList();

        /* renamed from: a  reason: collision with root package name */
        public final View f2221a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference f2222b;

        /* renamed from: j  reason: collision with root package name */
        int f2230j;

        /* renamed from: r  reason: collision with root package name */
        RecyclerView f2238r;

        /* renamed from: c  reason: collision with root package name */
        int f2223c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f2224d = -1;

        /* renamed from: e  reason: collision with root package name */
        long f2225e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f2226f = -1;

        /* renamed from: g  reason: collision with root package name */
        int f2227g = -1;

        /* renamed from: h  reason: collision with root package name */
        c0 f2228h = null;

        /* renamed from: i  reason: collision with root package name */
        c0 f2229i = null;

        /* renamed from: k  reason: collision with root package name */
        List f2231k = null;

        /* renamed from: l  reason: collision with root package name */
        List f2232l = null;

        /* renamed from: m  reason: collision with root package name */
        private int f2233m = 0;

        /* renamed from: n  reason: collision with root package name */
        u f2234n = null;

        /* renamed from: o  reason: collision with root package name */
        boolean f2235o = false;

        /* renamed from: p  reason: collision with root package name */
        private int f2236p = 0;

        /* renamed from: q  reason: collision with root package name */
        int f2237q = -1;

        public c0(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f2221a = view;
        }

        private void g() {
            if (this.f2231k == null) {
                ArrayList arrayList = new ArrayList();
                this.f2231k = arrayList;
                this.f2232l = Collections.unmodifiableList(arrayList);
            }
        }

        void A(int i6, boolean z5) {
            if (this.f2224d == -1) {
                this.f2224d = this.f2223c;
            }
            if (this.f2227g == -1) {
                this.f2227g = this.f2223c;
            }
            if (z5) {
                this.f2227g += i6;
            }
            this.f2223c += i6;
            if (this.f2221a.getLayoutParams() != null) {
                ((p) this.f2221a.getLayoutParams()).f2281c = true;
            }
        }

        void B(RecyclerView recyclerView) {
            int i6 = this.f2237q;
            if (i6 == -1) {
                i6 = e0.b0.z(this.f2221a);
            }
            this.f2236p = i6;
            recyclerView.i1(this, 4);
        }

        void C(RecyclerView recyclerView) {
            recyclerView.i1(this, this.f2236p);
            this.f2236p = 0;
        }

        void D() {
            this.f2230j = 0;
            this.f2223c = -1;
            this.f2224d = -1;
            this.f2225e = -1L;
            this.f2227g = -1;
            this.f2233m = 0;
            this.f2228h = null;
            this.f2229i = null;
            d();
            this.f2236p = 0;
            this.f2237q = -1;
            RecyclerView.r(this);
        }

        void E() {
            if (this.f2224d == -1) {
                this.f2224d = this.f2223c;
            }
        }

        void F(int i6, int i7) {
            this.f2230j = (i6 & i7) | (this.f2230j & (~i7));
        }

        public final void G(boolean z5) {
            int i6;
            int i7 = this.f2233m;
            int i8 = z5 ? i7 - 1 : i7 + 1;
            this.f2233m = i8;
            if (i8 < 0) {
                this.f2233m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z5 && i8 == 1) {
                i6 = this.f2230j | 16;
            } else if (!z5 || i8 != 0) {
                return;
            } else {
                i6 = this.f2230j & (-17);
            }
            this.f2230j = i6;
        }

        void H(u uVar, boolean z5) {
            this.f2234n = uVar;
            this.f2235o = z5;
        }

        boolean I() {
            return (this.f2230j & 16) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean J() {
            return (this.f2230j & 128) != 0;
        }

        void K() {
            this.f2234n.J(this);
        }

        boolean L() {
            return (this.f2230j & 32) != 0;
        }

        void a(Object obj) {
            if (obj == null) {
                b(Segment.SHARE_MINIMUM);
            } else if ((1024 & this.f2230j) == 0) {
                g();
                this.f2231k.add(obj);
            }
        }

        void b(int i6) {
            this.f2230j = i6 | this.f2230j;
        }

        void c() {
            this.f2224d = -1;
            this.f2227g = -1;
        }

        void d() {
            List list = this.f2231k;
            if (list != null) {
                list.clear();
            }
            this.f2230j &= -1025;
        }

        void e() {
            this.f2230j &= -33;
        }

        void f() {
            this.f2230j &= -257;
        }

        boolean h() {
            return (this.f2230j & 16) == 0 && e0.b0.O(this.f2221a);
        }

        void i(int i6, int i7, boolean z5) {
            b(8);
            A(i7, z5);
            this.f2223c = i6;
        }

        public final int j() {
            RecyclerView recyclerView = this.f2238r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.b0(this);
        }

        public final long k() {
            return this.f2225e;
        }

        public final int l() {
            return this.f2226f;
        }

        public final int m() {
            int i6 = this.f2227g;
            return i6 == -1 ? this.f2223c : i6;
        }

        public final int n() {
            return this.f2224d;
        }

        List o() {
            if ((this.f2230j & Segment.SHARE_MINIMUM) == 0) {
                List list = this.f2231k;
                return (list == null || list.size() == 0) ? f2220s : this.f2232l;
            }
            return f2220s;
        }

        boolean p(int i6) {
            return (i6 & this.f2230j) != 0;
        }

        boolean q() {
            return (this.f2230j & 512) != 0 || t();
        }

        boolean r() {
            return (this.f2221a.getParent() == null || this.f2221a.getParent() == this.f2238r) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean s() {
            return (this.f2230j & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean t() {
            return (this.f2230j & 4) != 0;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.f2223c + " id=" + this.f2225e + ", oldPos=" + this.f2224d + ", pLpos:" + this.f2227g);
            if (w()) {
                sb.append(" scrap ");
                sb.append(this.f2235o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (t()) {
                sb.append(" invalid");
            }
            if (!s()) {
                sb.append(" unbound");
            }
            if (z()) {
                sb.append(" update");
            }
            if (v()) {
                sb.append(" removed");
            }
            if (J()) {
                sb.append(" ignored");
            }
            if (x()) {
                sb.append(" tmpDetached");
            }
            if (!u()) {
                sb.append(" not recyclable(" + this.f2233m + ")");
            }
            if (q()) {
                sb.append(" undefined adapter position");
            }
            if (this.f2221a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final boolean u() {
            return (this.f2230j & 16) == 0 && !e0.b0.O(this.f2221a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean v() {
            return (this.f2230j & 8) != 0;
        }

        boolean w() {
            return this.f2234n != null;
        }

        boolean x() {
            return (this.f2230j & 256) != 0;
        }

        boolean y() {
            return (this.f2230j & 2) != 0;
        }

        boolean z() {
            return (this.f2230j & 2) != 0;
        }
    }

    /* loaded from: classes.dex */
    class d implements p.b {
        d() {
        }

        @Override // androidx.recyclerview.widget.p.b
        public void a(c0 c0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f2188n.m1(c0Var.f2221a, recyclerView.f2166c);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void b(c0 c0Var, l.b bVar, l.b bVar2) {
            RecyclerView.this.l(c0Var, bVar, bVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void c(c0 c0Var, l.b bVar, l.b bVar2) {
            RecyclerView.this.f2166c.J(c0Var);
            RecyclerView.this.n(c0Var, bVar, bVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void d(c0 c0Var, l.b bVar, l.b bVar2) {
            c0Var.G(false);
            RecyclerView recyclerView = RecyclerView.this;
            boolean z5 = recyclerView.D;
            l lVar = recyclerView.M;
            if (z5) {
                if (!lVar.b(c0Var, c0Var, bVar, bVar2)) {
                    return;
                }
            } else if (!lVar.d(c0Var, bVar, bVar2)) {
                return;
            }
            RecyclerView.this.L0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements b.InterfaceC0022b {
        e() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0022b
        public View a(int i6) {
            return RecyclerView.this.getChildAt(i6);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0022b
        public void b(View view) {
            c0 f02 = RecyclerView.f0(view);
            if (f02 != null) {
                f02.B(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0022b
        public c0 c(View view) {
            return RecyclerView.f0(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0022b
        public void d(int i6) {
            c0 f02;
            View a6 = a(i6);
            if (a6 != null && (f02 = RecyclerView.f0(a6)) != null) {
                if (f02.x() && !f02.J()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + f02 + RecyclerView.this.P());
                }
                f02.b(256);
            }
            RecyclerView.this.detachViewFromParent(i6);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0022b
        public void e(View view) {
            c0 f02 = RecyclerView.f0(view);
            if (f02 != null) {
                f02.C(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0022b
        public void f(View view, int i6) {
            RecyclerView.this.addView(view, i6);
            RecyclerView.this.y(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0022b
        public int g() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0022b
        public void h(int i6) {
            View childAt = RecyclerView.this.getChildAt(i6);
            if (childAt != null) {
                RecyclerView.this.z(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i6);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0022b
        public void i() {
            int g6 = g();
            for (int i6 = 0; i6 < g6; i6++) {
                View a6 = a(i6);
                RecyclerView.this.z(a6);
                a6.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0022b
        public void j(View view, int i6, ViewGroup.LayoutParams layoutParams) {
            c0 f02 = RecyclerView.f0(view);
            if (f02 != null) {
                if (!f02.x() && !f02.J()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + f02 + RecyclerView.this.P());
                }
                f02.f();
            }
            RecyclerView.this.attachViewToParent(view, i6, layoutParams);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0022b
        public int k(View view) {
            return RecyclerView.this.indexOfChild(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements a.InterfaceC0021a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0021a
        public void a(int i6, int i7) {
            RecyclerView.this.B0(i6, i7);
            RecyclerView.this.f2183k0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0021a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0021a
        public c0 c(int i6) {
            c0 Z = RecyclerView.this.Z(i6, true);
            if (Z == null || RecyclerView.this.f2172f.n(Z.f2221a)) {
                return null;
            }
            return Z;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0021a
        public void d(int i6, int i7) {
            RecyclerView.this.C0(i6, i7, false);
            RecyclerView.this.f2183k0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0021a
        public void e(int i6, int i7) {
            RecyclerView.this.A0(i6, i7);
            RecyclerView.this.f2183k0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0021a
        public void f(int i6, int i7) {
            RecyclerView.this.C0(i6, i7, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f2183k0 = true;
            recyclerView.f2177h0.f2317d += i7;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0021a
        public void g(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0021a
        public void h(int i6, int i7, Object obj) {
            RecyclerView.this.v1(i6, i7, obj);
            RecyclerView.this.f2185l0 = true;
        }

        void i(a.b bVar) {
            int i6 = bVar.f2379a;
            if (i6 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f2188n.R0(recyclerView, bVar.f2380b, bVar.f2382d);
            } else if (i6 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f2188n.U0(recyclerView2, bVar.f2380b, bVar.f2382d);
            } else if (i6 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f2188n.W0(recyclerView3, bVar.f2380b, bVar.f2382d, bVar.f2381c);
            } else if (i6 != 8) {
            } else {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f2188n.T0(recyclerView4, bVar.f2380b, bVar.f2382d, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g {

        /* renamed from: a  reason: collision with root package name */
        private final h f2242a = new h();

        /* renamed from: b  reason: collision with root package name */
        private boolean f2243b = false;

        public final void a(c0 c0Var, int i6) {
            c0Var.f2223c = i6;
            if (g()) {
                c0Var.f2225e = d(i6);
            }
            c0Var.F(1, 519);
            a0.b.a("RV OnBindView");
            j(c0Var, i6, c0Var.o());
            c0Var.d();
            ViewGroup.LayoutParams layoutParams = c0Var.f2221a.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f2281c = true;
            }
            a0.b.b();
        }

        public final c0 b(ViewGroup viewGroup, int i6) {
            try {
                a0.b.a("RV CreateView");
                c0 k6 = k(viewGroup, i6);
                if (k6.f2221a.getParent() == null) {
                    k6.f2226f = i6;
                    return k6;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                a0.b.b();
            }
        }

        public abstract int c();

        public long d(int i6) {
            return -1L;
        }

        public int e(int i6) {
            return 0;
        }

        public final boolean f() {
            return this.f2242a.a();
        }

        public final boolean g() {
            return this.f2243b;
        }

        public void h(RecyclerView recyclerView) {
        }

        public abstract void i(c0 c0Var, int i6);

        public void j(c0 c0Var, int i6, List list) {
            i(c0Var, i6);
        }

        public abstract c0 k(ViewGroup viewGroup, int i6);

        public void l(RecyclerView recyclerView) {
        }

        public boolean m(c0 c0Var) {
            return false;
        }

        public void n(c0 c0Var) {
        }

        public void o(c0 c0Var) {
        }

        public void p(c0 c0Var) {
        }

        public void q(i iVar) {
            this.f2242a.registerObserver(iVar);
        }

        public void r(boolean z5) {
            if (f()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f2243b = z5;
        }

        public void s(i iVar) {
            this.f2242a.unregisterObserver(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h extends Observable {
        h() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
    }

    /* loaded from: classes.dex */
    public interface j {
    }

    /* loaded from: classes.dex */
    public static class k {
        protected EdgeEffect a(RecyclerView recyclerView, int i6) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class l {

        /* renamed from: a  reason: collision with root package name */
        private a f2244a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList f2245b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private long f2246c = 120;

        /* renamed from: d  reason: collision with root package name */
        private long f2247d = 120;

        /* renamed from: e  reason: collision with root package name */
        private long f2248e = 250;

        /* renamed from: f  reason: collision with root package name */
        private long f2249f = 250;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface a {
            void a(c0 c0Var);
        }

        /* loaded from: classes.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f2250a;

            /* renamed from: b  reason: collision with root package name */
            public int f2251b;

            /* renamed from: c  reason: collision with root package name */
            public int f2252c;

            /* renamed from: d  reason: collision with root package name */
            public int f2253d;

            public b a(c0 c0Var) {
                return b(c0Var, 0);
            }

            public b b(c0 c0Var, int i6) {
                View view = c0Var.f2221a;
                this.f2250a = view.getLeft();
                this.f2251b = view.getTop();
                this.f2252c = view.getRight();
                this.f2253d = view.getBottom();
                return this;
            }
        }

        static int e(c0 c0Var) {
            int i6 = c0Var.f2230j & 14;
            if (c0Var.t()) {
                return 4;
            }
            if ((i6 & 4) == 0) {
                int n5 = c0Var.n();
                int j6 = c0Var.j();
                return (n5 == -1 || j6 == -1 || n5 == j6) ? i6 : i6 | 2048;
            }
            return i6;
        }

        public abstract boolean a(c0 c0Var, b bVar, b bVar2);

        public abstract boolean b(c0 c0Var, c0 c0Var2, b bVar, b bVar2);

        public abstract boolean c(c0 c0Var, b bVar, b bVar2);

        public abstract boolean d(c0 c0Var, b bVar, b bVar2);

        public abstract boolean f(c0 c0Var);

        public boolean g(c0 c0Var, List list) {
            return f(c0Var);
        }

        public final void h(c0 c0Var) {
            r(c0Var);
            a aVar = this.f2244a;
            if (aVar != null) {
                aVar.a(c0Var);
            }
        }

        public final void i() {
            if (this.f2245b.size() <= 0) {
                this.f2245b.clear();
            } else {
                android.support.v4.media.a.a(this.f2245b.get(0));
                throw null;
            }
        }

        public abstract void j(c0 c0Var);

        public abstract void k();

        public long l() {
            return this.f2246c;
        }

        public long m() {
            return this.f2249f;
        }

        public long n() {
            return this.f2248e;
        }

        public long o() {
            return this.f2247d;
        }

        public abstract boolean p();

        public b q() {
            return new b();
        }

        public void r(c0 c0Var) {
        }

        public b s(z zVar, c0 c0Var) {
            return q().a(c0Var);
        }

        public b t(z zVar, c0 c0Var, int i6, List list) {
            return q().a(c0Var);
        }

        public abstract void u();

        void v(a aVar) {
            this.f2244a = aVar;
        }
    }

    /* loaded from: classes.dex */
    private class m implements l.a {
        m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.a
        public void a(c0 c0Var) {
            c0Var.G(true);
            if (c0Var.f2228h != null && c0Var.f2229i == null) {
                c0Var.f2228h = null;
            }
            c0Var.f2229i = null;
            if (c0Var.I() || RecyclerView.this.U0(c0Var.f2221a) || !c0Var.x()) {
                return;
            }
            RecyclerView.this.removeDetachedView(c0Var.f2221a, false);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n {
        public void d(Rect rect, int i6, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void e(Rect rect, View view, RecyclerView recyclerView, z zVar) {
            d(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        public void f(Canvas canvas, RecyclerView recyclerView) {
        }

        public void g(Canvas canvas, RecyclerView recyclerView, z zVar) {
            f(canvas, recyclerView);
        }

        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, z zVar) {
            h(canvas, recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class o {

        /* renamed from: a  reason: collision with root package name */
        androidx.recyclerview.widget.b f2255a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f2256b;

        /* renamed from: c  reason: collision with root package name */
        private final o.b f2257c;

        /* renamed from: d  reason: collision with root package name */
        private final o.b f2258d;

        /* renamed from: e  reason: collision with root package name */
        androidx.recyclerview.widget.o f2259e;

        /* renamed from: f  reason: collision with root package name */
        androidx.recyclerview.widget.o f2260f;

        /* renamed from: g  reason: collision with root package name */
        y f2261g;

        /* renamed from: h  reason: collision with root package name */
        boolean f2262h;

        /* renamed from: i  reason: collision with root package name */
        boolean f2263i;

        /* renamed from: j  reason: collision with root package name */
        boolean f2264j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f2265k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f2266l;

        /* renamed from: m  reason: collision with root package name */
        int f2267m;

        /* renamed from: n  reason: collision with root package name */
        boolean f2268n;

        /* renamed from: o  reason: collision with root package name */
        private int f2269o;

        /* renamed from: p  reason: collision with root package name */
        private int f2270p;

        /* renamed from: q  reason: collision with root package name */
        private int f2271q;

        /* renamed from: r  reason: collision with root package name */
        private int f2272r;

        /* loaded from: classes.dex */
        class a implements o.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i6) {
                return o.this.I(i6);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return o.this.o0() - o.this.f0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c(View view) {
                return o.this.Q(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d() {
                return o.this.e0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.T(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }
        }

        /* loaded from: classes.dex */
        class b implements o.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i6) {
                return o.this.I(i6);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return o.this.W() - o.this.d0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c(View view) {
                return o.this.U(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d() {
                return o.this.g0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.O(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }
        }

        /* loaded from: classes.dex */
        public interface c {
            void a(int i6, int i7);
        }

        /* loaded from: classes.dex */
        public static class d {

            /* renamed from: a  reason: collision with root package name */
            public int f2275a;

            /* renamed from: b  reason: collision with root package name */
            public int f2276b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f2277c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f2278d;
        }

        public o() {
            a aVar = new a();
            this.f2257c = aVar;
            b bVar = new b();
            this.f2258d = bVar;
            this.f2259e = new androidx.recyclerview.widget.o(aVar);
            this.f2260f = new androidx.recyclerview.widget.o(bVar);
            this.f2262h = false;
            this.f2263i = false;
            this.f2264j = false;
            this.f2265k = true;
            this.f2266l = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r5 == 1073741824) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int K(int i6, int i7, int i8, int i9, boolean z5) {
            int max = Math.max(0, i6 - i8);
            if (z5) {
                if (i9 < 0) {
                    if (i9 == -1) {
                        if (i7 != Integer.MIN_VALUE) {
                            if (i7 != 0) {
                            }
                        }
                        i9 = max;
                    }
                    i7 = 0;
                    i9 = 0;
                }
                i7 = 1073741824;
            } else {
                if (i9 < 0) {
                    if (i9 != -1) {
                        if (i9 == -2) {
                            i7 = (i7 == Integer.MIN_VALUE || i7 == 1073741824) ? Integer.MIN_VALUE : 0;
                        }
                        i7 = 0;
                        i9 = 0;
                    }
                    i9 = max;
                }
                i7 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i9, i7);
        }

        private int[] L(View view, Rect rect) {
            int[] iArr = new int[2];
            int e02 = e0();
            int g02 = g0();
            int o02 = o0() - f0();
            int W = W() - d0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i6 = left - e02;
            int min = Math.min(0, i6);
            int i7 = top - g02;
            int min2 = Math.min(0, i7);
            int i8 = width - o02;
            int max = Math.max(0, i8);
            int max2 = Math.max(0, height - W);
            if (Z() != 1) {
                if (min == 0) {
                    min = Math.min(i6, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i8);
            }
            if (min2 == 0) {
                min2 = Math.min(i7, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        private void f(View view, int i6, boolean z5) {
            c0 f02 = RecyclerView.f0(view);
            if (z5 || f02.v()) {
                this.f2256b.f2174g.b(f02);
            } else {
                this.f2256b.f2174g.p(f02);
            }
            p pVar = (p) view.getLayoutParams();
            if (f02.L() || f02.w()) {
                if (f02.w()) {
                    f02.K();
                } else {
                    f02.e();
                }
                this.f2255a.c(view, i6, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f2256b) {
                int m5 = this.f2255a.m(view);
                if (i6 == -1) {
                    i6 = this.f2255a.g();
                }
                if (m5 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f2256b.indexOfChild(view) + this.f2256b.P());
                } else if (m5 != i6) {
                    this.f2256b.f2188n.B0(m5, i6);
                }
            } else {
                this.f2255a.a(view, i6, false);
                pVar.f2281c = true;
                y yVar = this.f2261g;
                if (yVar != null && yVar.h()) {
                    this.f2261g.k(view);
                }
            }
            if (pVar.f2282d) {
                f02.f2221a.invalidate();
                pVar.f2282d = false;
            }
        }

        public static d i0(Context context, AttributeSet attributeSet, int i6, int i7) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m0.c.f11944f, i6, i7);
            dVar.f2275a = obtainStyledAttributes.getInt(m0.c.f11945g, 1);
            dVar.f2276b = obtainStyledAttributes.getInt(m0.c.f11955q, 1);
            dVar.f2277c = obtainStyledAttributes.getBoolean(m0.c.f11954p, false);
            dVar.f2278d = obtainStyledAttributes.getBoolean(m0.c.f11956r, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static int n(int i6, int i7, int i8) {
            int mode = View.MeasureSpec.getMode(i6);
            int size = View.MeasureSpec.getSize(i6);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i7, i8) : size : Math.min(size, Math.max(i7, i8));
        }

        private boolean t0(RecyclerView recyclerView, int i6, int i7) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int e02 = e0();
            int g02 = g0();
            int o02 = o0() - f0();
            int W = W() - d0();
            Rect rect = this.f2256b.f2180j;
            P(focusedChild, rect);
            return rect.left - i6 < o02 && rect.right - i6 > e02 && rect.top - i7 < W && rect.bottom - i7 > g02;
        }

        private void v1(u uVar, int i6, View view) {
            c0 f02 = RecyclerView.f0(view);
            if (f02.J()) {
                return;
            }
            if (f02.t() && !f02.v() && !this.f2256b.f2186m.g()) {
                q1(i6);
                uVar.C(f02);
                return;
            }
            x(i6);
            uVar.D(view);
            this.f2256b.f2174g.k(f02);
        }

        private static boolean w0(int i6, int i7, int i8) {
            int mode = View.MeasureSpec.getMode(i7);
            int size = View.MeasureSpec.getSize(i7);
            if (i8 <= 0 || i6 == i8) {
                if (mode == Integer.MIN_VALUE) {
                    return size >= i6;
                } else if (mode != 0) {
                    return mode == 1073741824 && size == i6;
                } else {
                    return true;
                }
            }
            return false;
        }

        private void y(int i6, View view) {
            this.f2255a.d(i6);
        }

        void A(RecyclerView recyclerView, u uVar) {
            this.f2263i = false;
            I0(recyclerView, uVar);
        }

        public void A0(View view, int i6, int i7) {
            p pVar = (p) view.getLayoutParams();
            Rect j02 = this.f2256b.j0(view);
            int i8 = i6 + j02.left + j02.right;
            int i9 = i7 + j02.top + j02.bottom;
            int K = K(o0(), p0(), e0() + f0() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i8, ((ViewGroup.MarginLayoutParams) pVar).width, k());
            int K2 = K(W(), X(), g0() + d0() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i9, ((ViewGroup.MarginLayoutParams) pVar).height, l());
            if (F1(view, K, K2, pVar)) {
                view.measure(K, K2);
            }
        }

        void A1(int i6, int i7) {
            this.f2271q = View.MeasureSpec.getSize(i6);
            int mode = View.MeasureSpec.getMode(i6);
            this.f2269o = mode;
            if (mode == 0 && !RecyclerView.f2162z0) {
                this.f2271q = 0;
            }
            this.f2272r = View.MeasureSpec.getSize(i7);
            int mode2 = View.MeasureSpec.getMode(i7);
            this.f2270p = mode2;
            if (mode2 != 0 || RecyclerView.f2162z0) {
                return;
            }
            this.f2272r = 0;
        }

        public View B(View view) {
            View R;
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView == null || (R = recyclerView.R(view)) == null || this.f2255a.n(R)) {
                return null;
            }
            return R;
        }

        public void B0(int i6, int i7) {
            View I = I(i6);
            if (I != null) {
                x(i6);
                h(I, i7);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i6 + this.f2256b.toString());
        }

        public void B1(int i6, int i7) {
            this.f2256b.setMeasuredDimension(i6, i7);
        }

        public View C(int i6) {
            int J = J();
            for (int i7 = 0; i7 < J; i7++) {
                View I = I(i7);
                c0 f02 = RecyclerView.f0(I);
                if (f02 != null && f02.m() == i6 && !f02.J() && (this.f2256b.f2177h0.e() || !f02.v())) {
                    return I;
                }
            }
            return null;
        }

        public void C0(int i6) {
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView != null) {
                recyclerView.y0(i6);
            }
        }

        public void C1(Rect rect, int i6, int i7) {
            B1(n(i6, rect.width() + e0() + f0(), c0()), n(i7, rect.height() + g0() + d0(), b0()));
        }

        public abstract p D();

        public void D0(int i6) {
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView != null) {
                recyclerView.z0(i6);
            }
        }

        void D1(int i6, int i7) {
            int J = J();
            if (J == 0) {
                this.f2256b.w(i6, i7);
                return;
            }
            int i8 = Integer.MIN_VALUE;
            int i9 = Integer.MIN_VALUE;
            int i10 = Integer.MAX_VALUE;
            int i11 = Integer.MAX_VALUE;
            for (int i12 = 0; i12 < J; i12++) {
                View I = I(i12);
                Rect rect = this.f2256b.f2180j;
                P(I, rect);
                int i13 = rect.left;
                if (i13 < i10) {
                    i10 = i13;
                }
                int i14 = rect.right;
                if (i14 > i8) {
                    i8 = i14;
                }
                int i15 = rect.top;
                if (i15 < i11) {
                    i11 = i15;
                }
                int i16 = rect.bottom;
                if (i16 > i9) {
                    i9 = i16;
                }
            }
            this.f2256b.f2180j.set(i10, i11, i8, i9);
            C1(this.f2256b.f2180j, i6, i7);
        }

        public p E(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void E0(g gVar, g gVar2) {
        }

        void E1(RecyclerView recyclerView) {
            int height;
            if (recyclerView == null) {
                this.f2256b = null;
                this.f2255a = null;
                height = 0;
                this.f2271q = 0;
            } else {
                this.f2256b = recyclerView;
                this.f2255a = recyclerView.f2172f;
                this.f2271q = recyclerView.getWidth();
                height = recyclerView.getHeight();
            }
            this.f2272r = height;
            this.f2269o = 1073741824;
            this.f2270p = 1073741824;
        }

        public p F(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public boolean F0(RecyclerView recyclerView, ArrayList arrayList, int i6, int i7) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean F1(View view, int i6, int i7, p pVar) {
            return (!view.isLayoutRequested() && this.f2265k && w0(view.getWidth(), i6, ((ViewGroup.MarginLayoutParams) pVar).width) && w0(view.getHeight(), i7, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int G() {
            return -1;
        }

        public void G0(RecyclerView recyclerView) {
        }

        boolean G1() {
            return false;
        }

        public int H(View view) {
            return ((p) view.getLayoutParams()).f2280b.bottom;
        }

        public void H0(RecyclerView recyclerView) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean H1(View view, int i6, int i7, p pVar) {
            return (this.f2265k && w0(view.getMeasuredWidth(), i6, ((ViewGroup.MarginLayoutParams) pVar).width) && w0(view.getMeasuredHeight(), i7, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public View I(int i6) {
            androidx.recyclerview.widget.b bVar = this.f2255a;
            if (bVar != null) {
                return bVar.f(i6);
            }
            return null;
        }

        public void I0(RecyclerView recyclerView, u uVar) {
            H0(recyclerView);
        }

        public abstract void I1(RecyclerView recyclerView, z zVar, int i6);

        public int J() {
            androidx.recyclerview.widget.b bVar = this.f2255a;
            if (bVar != null) {
                return bVar.g();
            }
            return 0;
        }

        public abstract View J0(View view, int i6, u uVar, z zVar);

        public void J1(y yVar) {
            y yVar2 = this.f2261g;
            if (yVar2 != null && yVar != yVar2 && yVar2.h()) {
                this.f2261g.r();
            }
            this.f2261g = yVar;
            yVar.q(this.f2256b, this);
        }

        public void K0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f2256b;
            L0(recyclerView.f2166c, recyclerView.f2177h0, accessibilityEvent);
        }

        void K1() {
            y yVar = this.f2261g;
            if (yVar != null) {
                yVar.r();
            }
        }

        public void L0(u uVar, z zVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z5 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f2256b.canScrollVertically(-1) && !this.f2256b.canScrollHorizontally(-1) && !this.f2256b.canScrollHorizontally(1)) {
                z5 = false;
            }
            accessibilityEvent.setScrollable(z5);
            g gVar = this.f2256b.f2186m;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.c());
            }
        }

        public abstract boolean L1();

        public boolean M() {
            RecyclerView recyclerView = this.f2256b;
            return recyclerView != null && recyclerView.f2176h;
        }

        public void M0(u uVar, z zVar, f0.y yVar) {
            if (this.f2256b.canScrollVertically(-1) || this.f2256b.canScrollHorizontally(-1)) {
                yVar.a(Segment.SIZE);
                yVar.o0(true);
            }
            if (this.f2256b.canScrollVertically(1) || this.f2256b.canScrollHorizontally(1)) {
                yVar.a(_BufferKt.SEGMENTING_THRESHOLD);
                yVar.o0(true);
            }
            yVar.Y(y.b.a(k0(uVar, zVar), N(uVar, zVar), v0(uVar, zVar), l0(uVar, zVar)));
        }

        public int N(u uVar, z zVar) {
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView == null || recyclerView.f2186m == null || !k()) {
                return 1;
            }
            return this.f2256b.f2186m.c();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void N0(f0.y yVar) {
            RecyclerView recyclerView = this.f2256b;
            M0(recyclerView.f2166c, recyclerView.f2177h0, yVar);
        }

        public int O(View view) {
            return view.getBottom() + H(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void O0(View view, f0.y yVar) {
            c0 f02 = RecyclerView.f0(view);
            if (f02 == null || f02.v() || this.f2255a.n(f02.f2221a)) {
                return;
            }
            RecyclerView recyclerView = this.f2256b;
            P0(recyclerView.f2166c, recyclerView.f2177h0, view, yVar);
        }

        public void P(View view, Rect rect) {
            RecyclerView.g0(view, rect);
        }

        public void P0(u uVar, z zVar, View view, f0.y yVar) {
            yVar.Z(y.c.a(l() ? h0(view) : 0, 1, k() ? h0(view) : 0, 1, false, false));
        }

        public int Q(View view) {
            return view.getLeft() - a0(view);
        }

        public View Q0(View view, int i6) {
            return null;
        }

        public int R(View view) {
            Rect rect = ((p) view.getLayoutParams()).f2280b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void R0(RecyclerView recyclerView, int i6, int i7) {
        }

        public int S(View view) {
            Rect rect = ((p) view.getLayoutParams()).f2280b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void S0(RecyclerView recyclerView) {
        }

        public int T(View view) {
            return view.getRight() + j0(view);
        }

        public void T0(RecyclerView recyclerView, int i6, int i7, int i8) {
        }

        public int U(View view) {
            return view.getTop() - m0(view);
        }

        public void U0(RecyclerView recyclerView, int i6, int i7) {
        }

        public View V() {
            View focusedChild;
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f2255a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void V0(RecyclerView recyclerView, int i6, int i7) {
        }

        public int W() {
            return this.f2272r;
        }

        public void W0(RecyclerView recyclerView, int i6, int i7, Object obj) {
            V0(recyclerView, i6, i7);
        }

        public int X() {
            return this.f2270p;
        }

        public abstract void X0(u uVar, z zVar);

        public int Y() {
            RecyclerView recyclerView = this.f2256b;
            g adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.c();
            }
            return 0;
        }

        public void Y0(z zVar) {
        }

        public int Z() {
            return e0.b0.B(this.f2256b);
        }

        public void Z0(u uVar, z zVar, int i6, int i7) {
            this.f2256b.w(i6, i7);
        }

        public int a0(View view) {
            return ((p) view.getLayoutParams()).f2280b.left;
        }

        public boolean a1(RecyclerView recyclerView, View view, View view2) {
            return x0() || recyclerView.t0();
        }

        public void b(View view) {
            c(view, -1);
        }

        public int b0() {
            return e0.b0.C(this.f2256b);
        }

        public boolean b1(RecyclerView recyclerView, z zVar, View view, View view2) {
            return a1(recyclerView, view, view2);
        }

        public void c(View view, int i6) {
            f(view, i6, true);
        }

        public int c0() {
            return e0.b0.D(this.f2256b);
        }

        public abstract void c1(Parcelable parcelable);

        public void d(View view) {
            e(view, -1);
        }

        public int d0() {
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public abstract Parcelable d1();

        public void e(View view, int i6) {
            f(view, i6, false);
        }

        public int e0() {
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void e1(int i6) {
        }

        public int f0() {
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        void f1(y yVar) {
            if (this.f2261g == yVar) {
                this.f2261g = null;
            }
        }

        public void g(String str) {
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView != null) {
                recyclerView.o(str);
            }
        }

        public int g0() {
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean g1(int i6, Bundle bundle) {
            RecyclerView recyclerView = this.f2256b;
            return h1(recyclerView.f2166c, recyclerView.f2177h0, i6, bundle);
        }

        public void h(View view, int i6) {
            i(view, i6, (p) view.getLayoutParams());
        }

        public int h0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        public boolean h1(u uVar, z zVar, int i6, Bundle bundle) {
            int W;
            int o02;
            int i7;
            int i8;
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView == null) {
                return false;
            }
            if (i6 == 4096) {
                W = recyclerView.canScrollVertically(1) ? (W() - g0()) - d0() : 0;
                if (this.f2256b.canScrollHorizontally(1)) {
                    o02 = (o0() - e0()) - f0();
                    i7 = W;
                    i8 = o02;
                }
                i7 = W;
                i8 = 0;
            } else if (i6 != 8192) {
                i8 = 0;
                i7 = 0;
            } else {
                W = recyclerView.canScrollVertically(-1) ? -((W() - g0()) - d0()) : 0;
                if (this.f2256b.canScrollHorizontally(-1)) {
                    o02 = -((o0() - e0()) - f0());
                    i7 = W;
                    i8 = o02;
                }
                i7 = W;
                i8 = 0;
            }
            if (i7 == 0 && i8 == 0) {
                return false;
            }
            this.f2256b.n1(i8, i7, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void i(View view, int i6, p pVar) {
            c0 f02 = RecyclerView.f0(view);
            if (f02.v()) {
                this.f2256b.f2174g.b(f02);
            } else {
                this.f2256b.f2174g.p(f02);
            }
            this.f2255a.c(view, i6, pVar, f02.v());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean i1(View view, int i6, Bundle bundle) {
            RecyclerView recyclerView = this.f2256b;
            return j1(recyclerView.f2166c, recyclerView.f2177h0, view, i6, bundle);
        }

        public void j(View view, Rect rect) {
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.j0(view));
            }
        }

        public int j0(View view) {
            return ((p) view.getLayoutParams()).f2280b.right;
        }

        public boolean j1(u uVar, z zVar, View view, int i6, Bundle bundle) {
            return false;
        }

        public abstract boolean k();

        public int k0(u uVar, z zVar) {
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView == null || recyclerView.f2186m == null || !l()) {
                return 1;
            }
            return this.f2256b.f2186m.c();
        }

        public void k1(u uVar) {
            for (int J = J() - 1; J >= 0; J--) {
                if (!RecyclerView.f0(I(J)).J()) {
                    n1(J, uVar);
                }
            }
        }

        public abstract boolean l();

        public int l0(u uVar, z zVar) {
            return 0;
        }

        void l1(u uVar) {
            int j6 = uVar.j();
            for (int i6 = j6 - 1; i6 >= 0; i6--) {
                View n5 = uVar.n(i6);
                c0 f02 = RecyclerView.f0(n5);
                if (!f02.J()) {
                    f02.G(false);
                    if (f02.x()) {
                        this.f2256b.removeDetachedView(n5, false);
                    }
                    l lVar = this.f2256b.M;
                    if (lVar != null) {
                        lVar.j(f02);
                    }
                    f02.G(true);
                    uVar.y(n5);
                }
            }
            uVar.e();
            if (j6 > 0) {
                this.f2256b.invalidate();
            }
        }

        public boolean m(p pVar) {
            return pVar != null;
        }

        public int m0(View view) {
            return ((p) view.getLayoutParams()).f2280b.top;
        }

        public void m1(View view, u uVar) {
            p1(view);
            uVar.B(view);
        }

        public void n0(View view, boolean z5, Rect rect) {
            Matrix matrix;
            if (z5) {
                Rect rect2 = ((p) view.getLayoutParams()).f2280b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f2256b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f2256b.f2184l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void n1(int i6, u uVar) {
            View I = I(i6);
            q1(i6);
            uVar.B(I);
        }

        public abstract void o(int i6, int i7, z zVar, c cVar);

        public int o0() {
            return this.f2271q;
        }

        public boolean o1(Runnable runnable) {
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void p(int i6, c cVar) {
        }

        public int p0() {
            return this.f2269o;
        }

        public void p1(View view) {
            this.f2255a.p(view);
        }

        public abstract int q(z zVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean q0() {
            int J = J();
            for (int i6 = 0; i6 < J; i6++) {
                ViewGroup.LayoutParams layoutParams = I(i6).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void q1(int i6) {
            if (I(i6) != null) {
                this.f2255a.q(i6);
            }
        }

        public abstract int r(z zVar);

        public boolean r0() {
            return this.f2263i;
        }

        public boolean r1(RecyclerView recyclerView, View view, Rect rect, boolean z5) {
            return s1(recyclerView, view, rect, z5, false);
        }

        public abstract int s(z zVar);

        public abstract boolean s0();

        public boolean s1(RecyclerView recyclerView, View view, Rect rect, boolean z5, boolean z6) {
            int[] L = L(view, rect);
            int i6 = L[0];
            int i7 = L[1];
            if ((!z6 || t0(recyclerView, i6, i7)) && !(i6 == 0 && i7 == 0)) {
                if (z5) {
                    recyclerView.scrollBy(i6, i7);
                } else {
                    recyclerView.k1(i6, i7);
                }
                return true;
            }
            return false;
        }

        public abstract int t(z zVar);

        public void t1() {
            RecyclerView recyclerView = this.f2256b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public abstract int u(z zVar);

        public final boolean u0() {
            return this.f2266l;
        }

        public void u1() {
            this.f2262h = true;
        }

        public abstract int v(z zVar);

        public boolean v0(u uVar, z zVar) {
            return false;
        }

        public void w(u uVar) {
            for (int J = J() - 1; J >= 0; J--) {
                v1(uVar, J, I(J));
            }
        }

        public abstract int w1(int i6, u uVar, z zVar);

        public void x(int i6) {
            y(i6, I(i6));
        }

        public boolean x0() {
            y yVar = this.f2261g;
            return yVar != null && yVar.h();
        }

        public abstract void x1(int i6);

        public boolean y0(View view, boolean z5, boolean z6) {
            boolean z7 = this.f2259e.b(view, 24579) && this.f2260f.b(view, 24579);
            return z5 ? z7 : !z7;
        }

        public abstract int y1(int i6, u uVar, z zVar);

        void z(RecyclerView recyclerView) {
            this.f2263i = true;
            G0(recyclerView);
        }

        public void z0(View view, int i6, int i7, int i8, int i9) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f2280b;
            view.layout(i6 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i7 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i8 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i9 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        void z1(RecyclerView recyclerView) {
            A1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }
    }

    /* loaded from: classes.dex */
    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        c0 f2279a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f2280b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2281c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2282d;

        public p(int i6, int i7) {
            super(i6, i7);
            this.f2280b = new Rect();
            this.f2281c = true;
            this.f2282d = false;
        }

        public int a() {
            return this.f2279a.m();
        }

        public boolean b() {
            return this.f2279a.y();
        }

        public boolean c() {
            return this.f2279a.v();
        }

        public boolean d() {
            return this.f2279a.t();
        }

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2280b = new Rect();
            this.f2281c = true;
            this.f2282d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2280b = new Rect();
            this.f2281c = true;
            this.f2282d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2280b = new Rect();
            this.f2281c = true;
            this.f2282d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f2280b = new Rect();
            this.f2281c = true;
            this.f2282d = false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class q {
        public abstract boolean a(int i6, int i7);
    }

    /* loaded from: classes.dex */
    public interface r {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z5);
    }

    /* loaded from: classes.dex */
    public static abstract class s {
        public void a(RecyclerView recyclerView, int i6) {
        }

        public abstract void b(RecyclerView recyclerView, int i6, int i7);
    }

    /* loaded from: classes.dex */
    public static class t {

        /* renamed from: a  reason: collision with root package name */
        SparseArray f2283a = new SparseArray();

        /* renamed from: b  reason: collision with root package name */
        private int f2284b = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList f2285a = new ArrayList();

            /* renamed from: b  reason: collision with root package name */
            int f2286b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f2287c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f2288d = 0;

            a() {
            }
        }

        private a g(int i6) {
            a aVar = (a) this.f2283a.get(i6);
            if (aVar == null) {
                a aVar2 = new a();
                this.f2283a.put(i6, aVar2);
                return aVar2;
            }
            return aVar;
        }

        void a() {
            this.f2284b++;
        }

        public void b() {
            for (int i6 = 0; i6 < this.f2283a.size(); i6++) {
                ((a) this.f2283a.valueAt(i6)).f2285a.clear();
            }
        }

        void c() {
            this.f2284b--;
        }

        void d(int i6, long j6) {
            a g6 = g(i6);
            g6.f2288d = j(g6.f2288d, j6);
        }

        void e(int i6, long j6) {
            a g6 = g(i6);
            g6.f2287c = j(g6.f2287c, j6);
        }

        public c0 f(int i6) {
            a aVar = (a) this.f2283a.get(i6);
            if (aVar == null || aVar.f2285a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.f2285a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((c0) arrayList.get(size)).r()) {
                    return (c0) arrayList.remove(size);
                }
            }
            return null;
        }

        void h(g gVar, g gVar2, boolean z5) {
            if (gVar != null) {
                c();
            }
            if (!z5 && this.f2284b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void i(c0 c0Var) {
            int l6 = c0Var.l();
            ArrayList arrayList = g(l6).f2285a;
            if (((a) this.f2283a.get(l6)).f2286b <= arrayList.size()) {
                return;
            }
            c0Var.D();
            arrayList.add(c0Var);
        }

        long j(long j6, long j7) {
            return j6 == 0 ? j7 : ((j6 / 4) * 3) + (j7 / 4);
        }

        boolean k(int i6, long j6, long j7) {
            long j8 = g(i6).f2288d;
            return j8 == 0 || j6 + j8 < j7;
        }

        boolean l(int i6, long j6, long j7) {
            long j8 = g(i6).f2287c;
            return j8 == 0 || j6 + j8 < j7;
        }
    }

    /* loaded from: classes.dex */
    public final class u {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList f2289a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList f2290b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList f2291c;

        /* renamed from: d  reason: collision with root package name */
        private final List f2292d;

        /* renamed from: e  reason: collision with root package name */
        private int f2293e;

        /* renamed from: f  reason: collision with root package name */
        int f2294f;

        /* renamed from: g  reason: collision with root package name */
        t f2295g;

        public u() {
            ArrayList arrayList = new ArrayList();
            this.f2289a = arrayList;
            this.f2290b = null;
            this.f2291c = new ArrayList();
            this.f2292d = Collections.unmodifiableList(arrayList);
            this.f2293e = 2;
            this.f2294f = 2;
        }

        private boolean H(c0 c0Var, int i6, int i7, long j6) {
            c0Var.f2238r = RecyclerView.this;
            int l6 = c0Var.l();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j6 == Long.MAX_VALUE || this.f2295g.k(l6, nanoTime, j6)) {
                RecyclerView.this.f2186m.a(c0Var, i6);
                this.f2295g.d(c0Var.l(), RecyclerView.this.getNanoTime() - nanoTime);
                b(c0Var);
                if (RecyclerView.this.f2177h0.e()) {
                    c0Var.f2227g = i7;
                    return true;
                }
                return true;
            }
            return false;
        }

        private void b(c0 c0Var) {
            if (RecyclerView.this.s0()) {
                View view = c0Var.f2221a;
                if (e0.b0.z(view) == 0) {
                    e0.b0.u0(view, 1);
                }
                androidx.recyclerview.widget.k kVar = RecyclerView.this.f2191o0;
                if (kVar == null) {
                    return;
                }
                e0.a n5 = kVar.n();
                if (n5 instanceof k.a) {
                    ((k.a) n5).o(view);
                }
                e0.b0.l0(view, n5);
            }
        }

        private void q(ViewGroup viewGroup, boolean z5) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z5) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        private void r(c0 c0Var) {
            View view = c0Var.f2221a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        void A(int i6) {
            a((c0) this.f2291c.get(i6), true);
            this.f2291c.remove(i6);
        }

        public void B(View view) {
            c0 f02 = RecyclerView.f0(view);
            if (f02.x()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (f02.w()) {
                f02.K();
            } else if (f02.L()) {
                f02.e();
            }
            C(f02);
            if (RecyclerView.this.M == null || f02.u()) {
                return;
            }
            RecyclerView.this.M.j(f02);
        }

        void C(c0 c0Var) {
            boolean z5;
            boolean z6 = true;
            if (c0Var.w() || c0Var.f2221a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(c0Var.w());
                sb.append(" isAttached:");
                sb.append(c0Var.f2221a.getParent() != null);
                sb.append(RecyclerView.this.P());
                throw new IllegalArgumentException(sb.toString());
            } else if (c0Var.x()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c0Var + RecyclerView.this.P());
            } else if (c0Var.J()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.P());
            } else {
                boolean h6 = c0Var.h();
                g gVar = RecyclerView.this.f2186m;
                if ((gVar != null && h6 && gVar.m(c0Var)) || c0Var.u()) {
                    if (this.f2294f <= 0 || c0Var.p(526)) {
                        z5 = false;
                    } else {
                        int size = this.f2291c.size();
                        if (size >= this.f2294f && size > 0) {
                            A(0);
                            size--;
                        }
                        if (RecyclerView.B0 && size > 0 && !RecyclerView.this.f2175g0.d(c0Var.f2223c)) {
                            int i6 = size - 1;
                            while (i6 >= 0) {
                                if (!RecyclerView.this.f2175g0.d(((c0) this.f2291c.get(i6)).f2223c)) {
                                    break;
                                }
                                i6--;
                            }
                            size = i6 + 1;
                        }
                        this.f2291c.add(size, c0Var);
                        z5 = true;
                    }
                    if (!z5) {
                        a(c0Var, true);
                        r1 = z5;
                        RecyclerView.this.f2174g.q(c0Var);
                        if (r1 && !z6 && h6) {
                            c0Var.f2238r = null;
                            return;
                        }
                        return;
                    }
                    r1 = z5;
                }
                z6 = false;
                RecyclerView.this.f2174g.q(c0Var);
                if (r1) {
                }
            }
        }

        void D(View view) {
            ArrayList arrayList;
            c0 f02 = RecyclerView.f0(view);
            if (!f02.p(12) && f02.y() && !RecyclerView.this.p(f02)) {
                if (this.f2290b == null) {
                    this.f2290b = new ArrayList();
                }
                f02.H(this, true);
                arrayList = this.f2290b;
            } else if (f02.t() && !f02.v() && !RecyclerView.this.f2186m.g()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.P());
            } else {
                f02.H(this, false);
                arrayList = this.f2289a;
            }
            arrayList.add(f02);
        }

        void E(t tVar) {
            t tVar2 = this.f2295g;
            if (tVar2 != null) {
                tVar2.c();
            }
            this.f2295g = tVar;
            if (tVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f2295g.a();
        }

        void F(a0 a0Var) {
        }

        public void G(int i6) {
            this.f2293e = i6;
            K();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0170  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x017f  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01a9  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01b7  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x01cc A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c0 I(int i6, boolean z5, long j6) {
            c0 c0Var;
            boolean z6;
            c0 c0Var2;
            boolean z7;
            boolean H;
            ViewGroup.LayoutParams layoutParams;
            p pVar;
            ViewGroup.LayoutParams generateLayoutParams;
            RecyclerView V;
            if (i6 < 0 || i6 >= RecyclerView.this.f2177h0.b()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i6 + "(" + i6 + "). Item count:" + RecyclerView.this.f2177h0.b() + RecyclerView.this.P());
            }
            boolean z8 = true;
            if (RecyclerView.this.f2177h0.e()) {
                c0Var = h(i6);
                if (c0Var != null) {
                    z6 = true;
                    if (c0Var == null && (c0Var = m(i6, z5)) != null) {
                        if (L(c0Var)) {
                            if (!z5) {
                                c0Var.b(4);
                                if (c0Var.w()) {
                                    RecyclerView.this.removeDetachedView(c0Var.f2221a, false);
                                    c0Var.K();
                                } else if (c0Var.L()) {
                                    c0Var.e();
                                }
                                C(c0Var);
                            }
                            c0Var = null;
                        } else {
                            z6 = true;
                        }
                    }
                    if (c0Var == null) {
                        int m5 = RecyclerView.this.f2170e.m(i6);
                        if (m5 < 0 || m5 >= RecyclerView.this.f2186m.c()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i6 + "(offset:" + m5 + ").state:" + RecyclerView.this.f2177h0.b() + RecyclerView.this.P());
                        }
                        int e6 = RecyclerView.this.f2186m.e(m5);
                        if (RecyclerView.this.f2186m.g() && (c0Var = l(RecyclerView.this.f2186m.d(m5), e6, z5)) != null) {
                            c0Var.f2223c = m5;
                            z6 = true;
                        }
                        if (c0Var == null) {
                            c0 f6 = i().f(e6);
                            if (f6 != null) {
                                f6.D();
                                if (RecyclerView.f2161y0) {
                                    r(f6);
                                }
                            }
                            c0Var = f6;
                        }
                        if (c0Var == null) {
                            long nanoTime = RecyclerView.this.getNanoTime();
                            if (j6 == Long.MAX_VALUE || this.f2295g.l(e6, nanoTime, j6)) {
                                RecyclerView recyclerView = RecyclerView.this;
                                c0 b6 = recyclerView.f2186m.b(recyclerView, e6);
                                if (RecyclerView.B0 && (V = RecyclerView.V(b6.f2221a)) != null) {
                                    b6.f2222b = new WeakReference(V);
                                }
                                this.f2295g.e(e6, RecyclerView.this.getNanoTime() - nanoTime);
                                c0Var2 = b6;
                                z7 = z6;
                                if (z7 && !RecyclerView.this.f2177h0.e() && c0Var2.p(Segment.SIZE)) {
                                    c0Var2.F(0, Segment.SIZE);
                                    if (RecyclerView.this.f2177h0.f2324k) {
                                        int e7 = l.e(c0Var2) | _BufferKt.SEGMENTING_THRESHOLD;
                                        RecyclerView recyclerView2 = RecyclerView.this;
                                        RecyclerView.this.Q0(c0Var2, recyclerView2.M.t(recyclerView2.f2177h0, c0Var2, e7, c0Var2.o()));
                                    }
                                }
                                if (!RecyclerView.this.f2177h0.e() && c0Var2.s()) {
                                    c0Var2.f2227g = i6;
                                } else if (c0Var2.s() || c0Var2.z() || c0Var2.t()) {
                                    H = H(c0Var2, RecyclerView.this.f2170e.m(i6), i6, j6);
                                    layoutParams = c0Var2.f2221a.getLayoutParams();
                                    if (layoutParams != null) {
                                        generateLayoutParams = RecyclerView.this.generateDefaultLayoutParams();
                                    } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                                        pVar = (p) layoutParams;
                                        pVar.f2279a = c0Var2;
                                        pVar.f2282d = (z7 || !H) ? false : false;
                                        return c0Var2;
                                    } else {
                                        generateLayoutParams = RecyclerView.this.generateLayoutParams(layoutParams);
                                    }
                                    pVar = (p) generateLayoutParams;
                                    c0Var2.f2221a.setLayoutParams(pVar);
                                    pVar.f2279a = c0Var2;
                                    pVar.f2282d = (z7 || !H) ? false : false;
                                    return c0Var2;
                                }
                                H = false;
                                layoutParams = c0Var2.f2221a.getLayoutParams();
                                if (layoutParams != null) {
                                }
                                pVar = (p) generateLayoutParams;
                                c0Var2.f2221a.setLayoutParams(pVar);
                                pVar.f2279a = c0Var2;
                                pVar.f2282d = (z7 || !H) ? false : false;
                                return c0Var2;
                            }
                            return null;
                        }
                    }
                    c0Var2 = c0Var;
                    z7 = z6;
                    if (z7) {
                        c0Var2.F(0, Segment.SIZE);
                        if (RecyclerView.this.f2177h0.f2324k) {
                        }
                    }
                    if (!RecyclerView.this.f2177h0.e()) {
                    }
                    if (c0Var2.s()) {
                    }
                    H = H(c0Var2, RecyclerView.this.f2170e.m(i6), i6, j6);
                    layoutParams = c0Var2.f2221a.getLayoutParams();
                    if (layoutParams != null) {
                    }
                    pVar = (p) generateLayoutParams;
                    c0Var2.f2221a.setLayoutParams(pVar);
                    pVar.f2279a = c0Var2;
                    pVar.f2282d = (z7 || !H) ? false : false;
                    return c0Var2;
                }
            } else {
                c0Var = null;
            }
            z6 = false;
            if (c0Var == null) {
                if (L(c0Var)) {
                }
            }
            if (c0Var == null) {
            }
            c0Var2 = c0Var;
            z7 = z6;
            if (z7) {
            }
            if (!RecyclerView.this.f2177h0.e()) {
            }
            if (c0Var2.s()) {
            }
            H = H(c0Var2, RecyclerView.this.f2170e.m(i6), i6, j6);
            layoutParams = c0Var2.f2221a.getLayoutParams();
            if (layoutParams != null) {
            }
            pVar = (p) generateLayoutParams;
            c0Var2.f2221a.setLayoutParams(pVar);
            pVar.f2279a = c0Var2;
            pVar.f2282d = (z7 || !H) ? false : false;
            return c0Var2;
        }

        void J(c0 c0Var) {
            (c0Var.f2235o ? this.f2290b : this.f2289a).remove(c0Var);
            c0Var.f2234n = null;
            c0Var.f2235o = false;
            c0Var.e();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void K() {
            o oVar = RecyclerView.this.f2188n;
            this.f2294f = this.f2293e + (oVar != null ? oVar.f2267m : 0);
            for (int size = this.f2291c.size() - 1; size >= 0 && this.f2291c.size() > this.f2294f; size--) {
                A(size);
            }
        }

        boolean L(c0 c0Var) {
            if (c0Var.v()) {
                return RecyclerView.this.f2177h0.e();
            }
            int i6 = c0Var.f2223c;
            if (i6 >= 0 && i6 < RecyclerView.this.f2186m.c()) {
                if (RecyclerView.this.f2177h0.e() || RecyclerView.this.f2186m.e(c0Var.f2223c) == c0Var.l()) {
                    return !RecyclerView.this.f2186m.g() || c0Var.k() == RecyclerView.this.f2186m.d(c0Var.f2223c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c0Var + RecyclerView.this.P());
        }

        void M(int i6, int i7) {
            int i8;
            int i9 = i7 + i6;
            for (int size = this.f2291c.size() - 1; size >= 0; size--) {
                c0 c0Var = (c0) this.f2291c.get(size);
                if (c0Var != null && (i8 = c0Var.f2223c) >= i6 && i8 < i9) {
                    c0Var.b(2);
                    A(size);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(c0 c0Var, boolean z5) {
            RecyclerView.r(c0Var);
            View view = c0Var.f2221a;
            androidx.recyclerview.widget.k kVar = RecyclerView.this.f2191o0;
            if (kVar != null) {
                e0.a n5 = kVar.n();
                e0.b0.l0(view, n5 instanceof k.a ? ((k.a) n5).n(view) : null);
            }
            if (z5) {
                g(c0Var);
            }
            c0Var.f2238r = null;
            i().i(c0Var);
        }

        public void c() {
            this.f2289a.clear();
            z();
        }

        void d() {
            int size = this.f2291c.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((c0) this.f2291c.get(i6)).c();
            }
            int size2 = this.f2289a.size();
            for (int i7 = 0; i7 < size2; i7++) {
                ((c0) this.f2289a.get(i7)).c();
            }
            ArrayList arrayList = this.f2290b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i8 = 0; i8 < size3; i8++) {
                    ((c0) this.f2290b.get(i8)).c();
                }
            }
        }

        void e() {
            this.f2289a.clear();
            ArrayList arrayList = this.f2290b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i6) {
            if (i6 >= 0 && i6 < RecyclerView.this.f2177h0.b()) {
                return !RecyclerView.this.f2177h0.e() ? i6 : RecyclerView.this.f2170e.m(i6);
            }
            throw new IndexOutOfBoundsException("invalid position " + i6 + ". State item count is " + RecyclerView.this.f2177h0.b() + RecyclerView.this.P());
        }

        void g(c0 c0Var) {
            RecyclerView.this.getClass();
            g gVar = RecyclerView.this.f2186m;
            if (gVar != null) {
                gVar.p(c0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f2177h0 != null) {
                recyclerView.f2174g.q(c0Var);
            }
        }

        c0 h(int i6) {
            int size;
            int m5;
            ArrayList arrayList = this.f2290b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i7 = 0; i7 < size; i7++) {
                    c0 c0Var = (c0) this.f2290b.get(i7);
                    if (!c0Var.L() && c0Var.m() == i6) {
                        c0Var.b(32);
                        return c0Var;
                    }
                }
                if (RecyclerView.this.f2186m.g() && (m5 = RecyclerView.this.f2170e.m(i6)) > 0 && m5 < RecyclerView.this.f2186m.c()) {
                    long d6 = RecyclerView.this.f2186m.d(m5);
                    for (int i8 = 0; i8 < size; i8++) {
                        c0 c0Var2 = (c0) this.f2290b.get(i8);
                        if (!c0Var2.L() && c0Var2.k() == d6) {
                            c0Var2.b(32);
                            return c0Var2;
                        }
                    }
                }
            }
            return null;
        }

        t i() {
            if (this.f2295g == null) {
                this.f2295g = new t();
            }
            return this.f2295g;
        }

        int j() {
            return this.f2289a.size();
        }

        public List k() {
            return this.f2292d;
        }

        c0 l(long j6, int i6, boolean z5) {
            for (int size = this.f2289a.size() - 1; size >= 0; size--) {
                c0 c0Var = (c0) this.f2289a.get(size);
                if (c0Var.k() == j6 && !c0Var.L()) {
                    if (i6 == c0Var.l()) {
                        c0Var.b(32);
                        if (c0Var.v() && !RecyclerView.this.f2177h0.e()) {
                            c0Var.F(2, 14);
                        }
                        return c0Var;
                    } else if (!z5) {
                        this.f2289a.remove(size);
                        RecyclerView.this.removeDetachedView(c0Var.f2221a, false);
                        y(c0Var.f2221a);
                    }
                }
            }
            int size2 = this.f2291c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                c0 c0Var2 = (c0) this.f2291c.get(size2);
                if (c0Var2.k() == j6 && !c0Var2.r()) {
                    if (i6 == c0Var2.l()) {
                        if (!z5) {
                            this.f2291c.remove(size2);
                        }
                        return c0Var2;
                    } else if (!z5) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        c0 m(int i6, boolean z5) {
            View e6;
            int size = this.f2289a.size();
            for (int i7 = 0; i7 < size; i7++) {
                c0 c0Var = (c0) this.f2289a.get(i7);
                if (!c0Var.L() && c0Var.m() == i6 && !c0Var.t() && (RecyclerView.this.f2177h0.f2321h || !c0Var.v())) {
                    c0Var.b(32);
                    return c0Var;
                }
            }
            if (z5 || (e6 = RecyclerView.this.f2172f.e(i6)) == null) {
                int size2 = this.f2291c.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    c0 c0Var2 = (c0) this.f2291c.get(i8);
                    if (!c0Var2.t() && c0Var2.m() == i6 && !c0Var2.r()) {
                        if (!z5) {
                            this.f2291c.remove(i8);
                        }
                        return c0Var2;
                    }
                }
                return null;
            }
            c0 f02 = RecyclerView.f0(e6);
            RecyclerView.this.f2172f.s(e6);
            int m5 = RecyclerView.this.f2172f.m(e6);
            if (m5 != -1) {
                RecyclerView.this.f2172f.d(m5);
                D(e6);
                f02.b(8224);
                return f02;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + f02 + RecyclerView.this.P());
        }

        View n(int i6) {
            return ((c0) this.f2289a.get(i6)).f2221a;
        }

        public View o(int i6) {
            return p(i6, false);
        }

        View p(int i6, boolean z5) {
            return I(i6, z5, Long.MAX_VALUE).f2221a;
        }

        void s() {
            int size = this.f2291c.size();
            for (int i6 = 0; i6 < size; i6++) {
                p pVar = (p) ((c0) this.f2291c.get(i6)).f2221a.getLayoutParams();
                if (pVar != null) {
                    pVar.f2281c = true;
                }
            }
        }

        void t() {
            int size = this.f2291c.size();
            for (int i6 = 0; i6 < size; i6++) {
                c0 c0Var = (c0) this.f2291c.get(i6);
                if (c0Var != null) {
                    c0Var.b(6);
                    c0Var.a(null);
                }
            }
            g gVar = RecyclerView.this.f2186m;
            if (gVar == null || !gVar.g()) {
                z();
            }
        }

        void u(int i6, int i7) {
            int size = this.f2291c.size();
            for (int i8 = 0; i8 < size; i8++) {
                c0 c0Var = (c0) this.f2291c.get(i8);
                if (c0Var != null && c0Var.f2223c >= i6) {
                    c0Var.A(i7, true);
                }
            }
        }

        void v(int i6, int i7) {
            int i8;
            int i9;
            int i10;
            int i11;
            if (i6 < i7) {
                i8 = -1;
                i10 = i6;
                i9 = i7;
            } else {
                i8 = 1;
                i9 = i6;
                i10 = i7;
            }
            int size = this.f2291c.size();
            for (int i12 = 0; i12 < size; i12++) {
                c0 c0Var = (c0) this.f2291c.get(i12);
                if (c0Var != null && (i11 = c0Var.f2223c) >= i10 && i11 <= i9) {
                    if (i11 == i6) {
                        c0Var.A(i7 - i6, false);
                    } else {
                        c0Var.A(i8, false);
                    }
                }
            }
        }

        void w(int i6, int i7, boolean z5) {
            int i8 = i6 + i7;
            for (int size = this.f2291c.size() - 1; size >= 0; size--) {
                c0 c0Var = (c0) this.f2291c.get(size);
                if (c0Var != null) {
                    int i9 = c0Var.f2223c;
                    if (i9 >= i8) {
                        c0Var.A(-i7, z5);
                    } else if (i9 >= i6) {
                        c0Var.b(8);
                        A(size);
                    }
                }
            }
        }

        void x(g gVar, g gVar2, boolean z5) {
            c();
            i().h(gVar, gVar2, z5);
        }

        void y(View view) {
            c0 f02 = RecyclerView.f0(view);
            f02.f2234n = null;
            f02.f2235o = false;
            f02.e();
            C(f02);
        }

        void z() {
            for (int size = this.f2291c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f2291c.clear();
            if (RecyclerView.B0) {
                RecyclerView.this.f2175g0.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface v {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class w extends i {
        w() {
        }
    }

    /* loaded from: classes.dex */
    public static class x extends h0.a {
        public static final Parcelable.Creator<x> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        Parcelable f2298c;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public x createFromParcel(Parcel parcel) {
                return new x(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public x createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new x(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public x[] newArray(int i6) {
                return new x[i6];
            }
        }

        x(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2298c = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        void f(x xVar) {
            this.f2298c = xVar.f2298c;
        }

        @Override // h0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeParcelable(this.f2298c, 0);
        }

        x(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class y {

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView f2300b;

        /* renamed from: c  reason: collision with root package name */
        private o f2301c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2302d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2303e;

        /* renamed from: f  reason: collision with root package name */
        private View f2304f;

        /* renamed from: h  reason: collision with root package name */
        private boolean f2306h;

        /* renamed from: a  reason: collision with root package name */
        private int f2299a = -1;

        /* renamed from: g  reason: collision with root package name */
        private final a f2305g = new a(0, 0);

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f2307a;

            /* renamed from: b  reason: collision with root package name */
            private int f2308b;

            /* renamed from: c  reason: collision with root package name */
            private int f2309c;

            /* renamed from: d  reason: collision with root package name */
            private int f2310d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f2311e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f2312f;

            /* renamed from: g  reason: collision with root package name */
            private int f2313g;

            public a(int i6, int i7) {
                this(i6, i7, Integer.MIN_VALUE, null);
            }

            private void e() {
                if (this.f2311e != null && this.f2309c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f2309c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.f2310d >= 0;
            }

            public void b(int i6) {
                this.f2310d = i6;
            }

            void c(RecyclerView recyclerView) {
                int i6 = this.f2310d;
                if (i6 >= 0) {
                    this.f2310d = -1;
                    recyclerView.v0(i6);
                    this.f2312f = false;
                } else if (!this.f2312f) {
                    this.f2313g = 0;
                } else {
                    e();
                    recyclerView.f2171e0.f(this.f2307a, this.f2308b, this.f2309c, this.f2311e);
                    int i7 = this.f2313g + 1;
                    this.f2313g = i7;
                    if (i7 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f2312f = false;
                }
            }

            public void d(int i6, int i7, int i8, Interpolator interpolator) {
                this.f2307a = i6;
                this.f2308b = i7;
                this.f2309c = i8;
                this.f2311e = interpolator;
                this.f2312f = true;
            }

            public a(int i6, int i7, int i8, Interpolator interpolator) {
                this.f2310d = -1;
                this.f2312f = false;
                this.f2313g = 0;
                this.f2307a = i6;
                this.f2308b = i7;
                this.f2309c = i8;
                this.f2311e = interpolator;
            }
        }

        /* loaded from: classes.dex */
        public interface b {
            PointF a(int i6);
        }

        public PointF a(int i6) {
            o e6 = e();
            if (e6 instanceof b) {
                return ((b) e6).a(i6);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i6) {
            return this.f2300b.f2188n.C(i6);
        }

        public int c() {
            return this.f2300b.f2188n.J();
        }

        public int d(View view) {
            return this.f2300b.d0(view);
        }

        public o e() {
            return this.f2301c;
        }

        public int f() {
            return this.f2299a;
        }

        public boolean g() {
            return this.f2302d;
        }

        public boolean h() {
            return this.f2303e;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void i(PointF pointF) {
            float f6 = pointF.x;
            float f7 = pointF.y;
            float sqrt = (float) Math.sqrt((f6 * f6) + (f7 * f7));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        void j(int i6, int i7) {
            PointF a6;
            RecyclerView recyclerView = this.f2300b;
            if (this.f2299a == -1 || recyclerView == null) {
                r();
            }
            if (this.f2302d && this.f2304f == null && this.f2301c != null && (a6 = a(this.f2299a)) != null) {
                float f6 = a6.x;
                if (f6 != 0.0f || a6.y != 0.0f) {
                    recyclerView.f1((int) Math.signum(f6), (int) Math.signum(a6.y), null);
                }
            }
            this.f2302d = false;
            View view = this.f2304f;
            if (view != null) {
                if (d(view) == this.f2299a) {
                    o(this.f2304f, recyclerView.f2177h0, this.f2305g);
                    this.f2305g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f2304f = null;
                }
            }
            if (this.f2303e) {
                l(i6, i7, recyclerView.f2177h0, this.f2305g);
                boolean a7 = this.f2305g.a();
                this.f2305g.c(recyclerView);
                if (a7 && this.f2303e) {
                    this.f2302d = true;
                    recyclerView.f2171e0.e();
                }
            }
        }

        protected void k(View view) {
            if (d(view) == f()) {
                this.f2304f = view;
            }
        }

        protected abstract void l(int i6, int i7, z zVar, a aVar);

        protected abstract void m();

        protected abstract void n();

        protected abstract void o(View view, z zVar, a aVar);

        public void p(int i6) {
            this.f2299a = i6;
        }

        void q(RecyclerView recyclerView, o oVar) {
            recyclerView.f2171e0.g();
            if (this.f2306h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f2300b = recyclerView;
            this.f2301c = oVar;
            int i6 = this.f2299a;
            if (i6 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f2177h0.f2314a = i6;
            this.f2303e = true;
            this.f2302d = true;
            this.f2304f = b(f());
            m();
            this.f2300b.f2171e0.e();
            this.f2306h = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void r() {
            if (this.f2303e) {
                this.f2303e = false;
                n();
                this.f2300b.f2177h0.f2314a = -1;
                this.f2304f = null;
                this.f2299a = -1;
                this.f2302d = false;
                this.f2301c.f1(this);
                this.f2301c = null;
                this.f2300b = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class z {

        /* renamed from: b  reason: collision with root package name */
        private SparseArray f2315b;

        /* renamed from: m  reason: collision with root package name */
        int f2326m;

        /* renamed from: n  reason: collision with root package name */
        long f2327n;

        /* renamed from: o  reason: collision with root package name */
        int f2328o;

        /* renamed from: p  reason: collision with root package name */
        int f2329p;

        /* renamed from: q  reason: collision with root package name */
        int f2330q;

        /* renamed from: a  reason: collision with root package name */
        int f2314a = -1;

        /* renamed from: c  reason: collision with root package name */
        int f2316c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f2317d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f2318e = 1;

        /* renamed from: f  reason: collision with root package name */
        int f2319f = 0;

        /* renamed from: g  reason: collision with root package name */
        boolean f2320g = false;

        /* renamed from: h  reason: collision with root package name */
        boolean f2321h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f2322i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f2323j = false;

        /* renamed from: k  reason: collision with root package name */
        boolean f2324k = false;

        /* renamed from: l  reason: collision with root package name */
        boolean f2325l = false;

        void a(int i6) {
            if ((this.f2318e & i6) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i6) + " but it is " + Integer.toBinaryString(this.f2318e));
        }

        public int b() {
            return this.f2321h ? this.f2316c - this.f2317d : this.f2319f;
        }

        public int c() {
            return this.f2314a;
        }

        public boolean d() {
            return this.f2314a != -1;
        }

        public boolean e() {
            return this.f2321h;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f(g gVar) {
            this.f2318e = 1;
            this.f2319f = gVar.c();
            this.f2321h = false;
            this.f2322i = false;
            this.f2323j = false;
        }

        public boolean g() {
            return this.f2325l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f2314a + ", mData=" + this.f2315b + ", mItemCount=" + this.f2319f + ", mIsMeasuring=" + this.f2323j + ", mPreviousLayoutItemCount=" + this.f2316c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2317d + ", mStructureChanged=" + this.f2320g + ", mInPreLayout=" + this.f2321h + ", mRunSimpleAnimations=" + this.f2324k + ", mRunPredictiveAnimations=" + this.f2325l + '}';
        }
    }

    static {
        int i6 = Build.VERSION.SDK_INT;
        f2161y0 = false;
        f2162z0 = i6 >= 23;
        A0 = true;
        B0 = true;
        C0 = false;
        D0 = false;
        Class cls = Integer.TYPE;
        E0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        F0 = new c();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m0.a.recyclerViewStyle);
    }

    private void A() {
        int i6 = this.f2210z;
        this.f2210z = 0;
        if (i6 == 0 || !s0()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        f0.b.b(obtain, i6);
        sendAccessibilityEventUnchecked(obtain);
    }

    private void C() {
        boolean z5 = true;
        this.f2177h0.a(1);
        Q(this.f2177h0);
        this.f2177h0.f2323j = false;
        p1();
        this.f2174g.f();
        F0();
        N0();
        c1();
        z zVar = this.f2177h0;
        zVar.f2322i = (zVar.f2324k && this.f2185l0) ? false : false;
        this.f2185l0 = false;
        this.f2183k0 = false;
        zVar.f2321h = zVar.f2325l;
        zVar.f2319f = this.f2186m.c();
        U(this.f2193p0);
        if (this.f2177h0.f2324k) {
            int g6 = this.f2172f.g();
            for (int i6 = 0; i6 < g6; i6++) {
                c0 f02 = f0(this.f2172f.f(i6));
                if (!f02.J() && (!f02.t() || this.f2186m.g())) {
                    this.f2174g.e(f02, this.M.t(this.f2177h0, f02, l.e(f02), f02.o()));
                    if (this.f2177h0.f2322i && f02.y() && !f02.v() && !f02.J() && !f02.t()) {
                        this.f2174g.c(c0(f02), f02);
                    }
                }
            }
        }
        if (this.f2177h0.f2325l) {
            d1();
            z zVar2 = this.f2177h0;
            boolean z6 = zVar2.f2320g;
            zVar2.f2320g = false;
            this.f2188n.X0(this.f2166c, zVar2);
            this.f2177h0.f2320g = z6;
            for (int i7 = 0; i7 < this.f2172f.g(); i7++) {
                c0 f03 = f0(this.f2172f.f(i7));
                if (!f03.J() && !this.f2174g.i(f03)) {
                    int e6 = l.e(f03);
                    boolean p5 = f03.p(Segment.SIZE);
                    if (!p5) {
                        e6 |= _BufferKt.SEGMENTING_THRESHOLD;
                    }
                    l.b t5 = this.M.t(this.f2177h0, f03, e6, f03.o());
                    if (p5) {
                        Q0(f03, t5);
                    } else {
                        this.f2174g.a(f03, t5);
                    }
                }
            }
        }
        s();
        G0();
        r1(false);
        this.f2177h0.f2318e = 2;
    }

    private void D() {
        p1();
        F0();
        this.f2177h0.a(6);
        this.f2170e.j();
        this.f2177h0.f2319f = this.f2186m.c();
        z zVar = this.f2177h0;
        zVar.f2317d = 0;
        zVar.f2321h = false;
        this.f2188n.X0(this.f2166c, zVar);
        z zVar2 = this.f2177h0;
        zVar2.f2320g = false;
        this.f2168d = null;
        zVar2.f2324k = zVar2.f2324k && this.M != null;
        zVar2.f2318e = 4;
        G0();
        r1(false);
    }

    private void E() {
        this.f2177h0.a(4);
        p1();
        F0();
        z zVar = this.f2177h0;
        zVar.f2318e = 1;
        if (zVar.f2324k) {
            for (int g6 = this.f2172f.g() - 1; g6 >= 0; g6--) {
                c0 f02 = f0(this.f2172f.f(g6));
                if (!f02.J()) {
                    long c02 = c0(f02);
                    l.b s5 = this.M.s(this.f2177h0, f02);
                    c0 g7 = this.f2174g.g(c02);
                    if (g7 != null && !g7.J()) {
                        boolean h6 = this.f2174g.h(g7);
                        boolean h7 = this.f2174g.h(f02);
                        if (!h6 || g7 != f02) {
                            l.b n5 = this.f2174g.n(g7);
                            this.f2174g.d(f02, s5);
                            l.b m5 = this.f2174g.m(f02);
                            if (n5 == null) {
                                k0(c02, f02, g7);
                            } else {
                                m(g7, f02, n5, m5, h6, h7);
                            }
                        }
                    }
                    this.f2174g.d(f02, s5);
                }
            }
            this.f2174g.o(this.f2207w0);
        }
        this.f2188n.l1(this.f2166c);
        z zVar2 = this.f2177h0;
        zVar2.f2316c = zVar2.f2319f;
        this.D = false;
        this.E = false;
        zVar2.f2324k = false;
        zVar2.f2325l = false;
        this.f2188n.f2262h = false;
        ArrayList arrayList = this.f2166c.f2290b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.f2188n;
        if (oVar.f2268n) {
            oVar.f2267m = 0;
            oVar.f2268n = false;
            this.f2166c.K();
        }
        this.f2188n.Y0(this.f2177h0);
        G0();
        r1(false);
        this.f2174g.f();
        int[] iArr = this.f2193p0;
        if (x(iArr[0], iArr[1])) {
            I(0, 0);
        }
        R0();
        a1();
    }

    private void I0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.O) {
            int i6 = actionIndex == 0 ? 1 : 0;
            this.O = motionEvent.getPointerId(i6);
            int x5 = (int) (motionEvent.getX(i6) + 0.5f);
            this.S = x5;
            this.Q = x5;
            int y5 = (int) (motionEvent.getY(i6) + 0.5f);
            this.T = y5;
            this.R = y5;
        }
    }

    private boolean K(MotionEvent motionEvent) {
        r rVar = this.f2194q;
        if (rVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return T(motionEvent);
        }
        rVar.b(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f2194q = null;
        }
        return true;
    }

    private boolean M0() {
        return this.M != null && this.f2188n.L1();
    }

    private void N0() {
        boolean z5;
        if (this.D) {
            this.f2170e.u();
            if (this.E) {
                this.f2188n.S0(this);
            }
        }
        if (M0()) {
            this.f2170e.s();
        } else {
            this.f2170e.j();
        }
        boolean z6 = false;
        boolean z7 = this.f2183k0 || this.f2185l0;
        this.f2177h0.f2324k = this.f2202u && this.M != null && ((z5 = this.D) || z7 || this.f2188n.f2262h) && (!z5 || this.f2186m.g());
        z zVar = this.f2177h0;
        if (zVar.f2324k && z7 && !this.D && M0()) {
            z6 = true;
        }
        zVar.f2325l = z6;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void P0(float f6, float f7, float f8, float f9) {
        boolean z5;
        EdgeEffect edgeEffect;
        float width;
        float height;
        boolean z6 = true;
        if (f7 < 0.0f) {
            M();
            edgeEffect = this.I;
            width = (-f7) / getWidth();
            height = 1.0f - (f8 / getHeight());
        } else if (f7 <= 0.0f) {
            z5 = false;
            if (f9 >= 0.0f) {
                O();
                androidx.core.widget.e.a(this.J, (-f9) / getHeight(), f6 / getWidth());
            } else if (f9 > 0.0f) {
                L();
                androidx.core.widget.e.a(this.L, f9 / getHeight(), 1.0f - (f6 / getWidth()));
            } else {
                z6 = z5;
            }
            if (z6 && f7 == 0.0f && f9 == 0.0f) {
                return;
            }
            e0.b0.c0(this);
        } else {
            N();
            edgeEffect = this.K;
            width = f7 / getWidth();
            height = f8 / getHeight();
        }
        androidx.core.widget.e.a(edgeEffect, width, height);
        z5 = true;
        if (f9 >= 0.0f) {
        }
        if (z6) {
        }
        e0.b0.c0(this);
    }

    private void R0() {
        View findViewById;
        if (!this.f2169d0 || this.f2186m == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!D0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f2172f.n(focusedChild)) {
                    return;
                }
            } else if (this.f2172f.g() == 0) {
                requestFocus();
                return;
            }
        }
        View view = null;
        c0 Y = (this.f2177h0.f2327n == -1 || !this.f2186m.g()) ? null : Y(this.f2177h0.f2327n);
        if (Y != null && !this.f2172f.n(Y.f2221a) && Y.f2221a.hasFocusable()) {
            view = Y.f2221a;
        } else if (this.f2172f.g() > 0) {
            view = W();
        }
        if (view != null) {
            int i6 = this.f2177h0.f2328o;
            if (i6 != -1 && (findViewById = view.findViewById(i6)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    private void S0() {
        boolean z5;
        EdgeEffect edgeEffect = this.I;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z5 = this.I.isFinished();
        } else {
            z5 = false;
        }
        EdgeEffect edgeEffect2 = this.J;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z5 |= this.J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z5 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.L;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z5 |= this.L.isFinished();
        }
        if (z5) {
            e0.b0.c0(this);
        }
    }

    private boolean T(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f2192p.size();
        for (int i6 = 0; i6 < size; i6++) {
            r rVar = (r) this.f2192p.get(i6);
            if (rVar.a(this, motionEvent) && action != 3) {
                this.f2194q = rVar;
                return true;
            }
        }
        return false;
    }

    private void U(int[] iArr) {
        int g6 = this.f2172f.g();
        if (g6 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i6 = Integer.MAX_VALUE;
        int i7 = Integer.MIN_VALUE;
        for (int i8 = 0; i8 < g6; i8++) {
            c0 f02 = f0(this.f2172f.f(i8));
            if (!f02.J()) {
                int m5 = f02.m();
                if (m5 < i6) {
                    i6 = m5;
                }
                if (m5 > i7) {
                    i7 = m5;
                }
            }
        }
        iArr[0] = i6;
        iArr[1] = i7;
    }

    static RecyclerView V(View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof RecyclerView) {
                return (RecyclerView) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                RecyclerView V = V(viewGroup.getChildAt(i6));
                if (V != null) {
                    return V;
                }
            }
            return null;
        }
        return null;
    }

    private View W() {
        c0 X;
        z zVar = this.f2177h0;
        int i6 = zVar.f2326m;
        if (i6 == -1) {
            i6 = 0;
        }
        int b6 = zVar.b();
        for (int i7 = i6; i7 < b6; i7++) {
            c0 X2 = X(i7);
            if (X2 == null) {
                break;
            } else if (X2.f2221a.hasFocusable()) {
                return X2.f2221a;
            }
        }
        int min = Math.min(b6, i6);
        while (true) {
            min--;
            if (min < 0 || (X = X(min)) == null) {
                return null;
            }
            if (X.f2221a.hasFocusable()) {
                return X.f2221a;
            }
        }
    }

    private void Z0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f2180j.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f2281c) {
                Rect rect = pVar.f2280b;
                Rect rect2 = this.f2180j;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f2180j);
            offsetRectIntoDescendantCoords(view, this.f2180j);
        }
        this.f2188n.s1(this, view, this.f2180j, !this.f2202u, view2 == null);
    }

    private void a1() {
        z zVar = this.f2177h0;
        zVar.f2327n = -1L;
        zVar.f2326m = -1;
        zVar.f2328o = -1;
    }

    private void b1() {
        VelocityTracker velocityTracker = this.P;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        s1(0);
        S0();
    }

    private void c1() {
        View focusedChild = (this.f2169d0 && hasFocus() && this.f2186m != null) ? getFocusedChild() : null;
        c0 S = focusedChild != null ? S(focusedChild) : null;
        if (S == null) {
            a1();
            return;
        }
        this.f2177h0.f2327n = this.f2186m.g() ? S.k() : -1L;
        this.f2177h0.f2326m = this.D ? -1 : S.v() ? S.f2224d : S.j();
        this.f2177h0.f2328o = h0(S.f2221a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c0 f0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f2279a;
    }

    private void g(c0 c0Var) {
        View view = c0Var.f2221a;
        boolean z5 = view.getParent() == this;
        this.f2166c.J(e0(view));
        if (c0Var.x()) {
            this.f2172f.c(view, -1, view.getLayoutParams(), true);
            return;
        }
        androidx.recyclerview.widget.b bVar = this.f2172f;
        if (z5) {
            bVar.k(view);
        } else {
            bVar.b(view, true);
        }
    }

    static void g0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f2280b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private e0.q getScrollingChildHelper() {
        if (this.f2195q0 == null) {
            this.f2195q0 = new e0.q(this);
        }
        return this.f2195q0;
    }

    private int h0(View view) {
        int id;
        loop0: while (true) {
            id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    break;
                }
            }
        }
        return id;
    }

    private void h1(g gVar, boolean z5, boolean z6) {
        g gVar2 = this.f2186m;
        if (gVar2 != null) {
            gVar2.s(this.f2164b);
            this.f2186m.l(this);
        }
        if (!z5 || z6) {
            T0();
        }
        this.f2170e.u();
        g gVar3 = this.f2186m;
        this.f2186m = gVar;
        if (gVar != null) {
            gVar.q(this.f2164b);
            gVar.h(this);
        }
        o oVar = this.f2188n;
        if (oVar != null) {
            oVar.E0(gVar3, this.f2186m);
        }
        this.f2166c.x(gVar3, this.f2186m, z5);
        this.f2177h0.f2320g = true;
    }

    private String i0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + JwtParser.SEPARATOR_CHAR + str;
        }
    }

    private void k0(long j6, c0 c0Var, c0 c0Var2) {
        int g6 = this.f2172f.g();
        for (int i6 = 0; i6 < g6; i6++) {
            c0 f02 = f0(this.f2172f.f(i6));
            if (f02 != c0Var && c0(f02) == j6) {
                g gVar = this.f2186m;
                if (gVar == null || !gVar.g()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + f02 + " \n View Holder 2:" + c0Var + P());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + f02 + " \n View Holder 2:" + c0Var + P());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c0Var2 + " cannot be found but it is necessary for " + c0Var + P());
    }

    private void m(c0 c0Var, c0 c0Var2, l.b bVar, l.b bVar2, boolean z5, boolean z6) {
        c0Var.G(false);
        if (z5) {
            g(c0Var);
        }
        if (c0Var != c0Var2) {
            if (z6) {
                g(c0Var2);
            }
            c0Var.f2228h = c0Var2;
            g(c0Var);
            this.f2166c.J(c0Var);
            c0Var2.G(false);
            c0Var2.f2229i = c0Var;
        }
        if (this.M.b(c0Var, c0Var2, bVar, bVar2)) {
            L0();
        }
    }

    private boolean m0() {
        int g6 = this.f2172f.g();
        for (int i6 = 0; i6 < g6; i6++) {
            c0 f02 = f0(this.f2172f.f(i6));
            if (f02 != null && !f02.J() && f02.y()) {
                return true;
            }
        }
        return false;
    }

    private void o0() {
        if (e0.b0.A(this) == 0) {
            e0.b0.v0(this, 8);
        }
    }

    private void p0() {
        this.f2172f = new androidx.recyclerview.widget.b(new e());
    }

    private void q() {
        b1();
        setScrollState(0);
    }

    static void r(c0 c0Var) {
        WeakReference weakReference = c0Var.f2222b;
        if (weakReference != null) {
            Object obj = weakReference.get();
            while (true) {
                for (View view = (View) obj; view != null; view = null) {
                    if (view == c0Var.f2221a) {
                        return;
                    }
                    obj = view.getParent();
                    if (obj instanceof View) {
                        break;
                    }
                }
                c0Var.f2222b = null;
                return;
            }
        }
    }

    private boolean u0(View view, View view2, int i6) {
        int i7;
        if (view2 == null || view2 == this || R(view2) == null) {
            return false;
        }
        if (view == null || R(view) == null) {
            return true;
        }
        this.f2180j.set(0, 0, view.getWidth(), view.getHeight());
        this.f2182k.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f2180j);
        offsetDescendantRectToMyCoords(view2, this.f2182k);
        char c6 = 65535;
        int i8 = this.f2188n.Z() == 1 ? -1 : 1;
        Rect rect = this.f2180j;
        int i9 = rect.left;
        Rect rect2 = this.f2182k;
        int i10 = rect2.left;
        if ((i9 < i10 || rect.right <= i10) && rect.right < rect2.right) {
            i7 = 1;
        } else {
            int i11 = rect.right;
            int i12 = rect2.right;
            i7 = ((i11 > i12 || i9 >= i12) && i9 > i10) ? -1 : 0;
        }
        int i13 = rect.top;
        int i14 = rect2.top;
        if ((i13 < i14 || rect.bottom <= i14) && rect.bottom < rect2.bottom) {
            c6 = 1;
        } else {
            int i15 = rect.bottom;
            int i16 = rect2.bottom;
            if ((i15 <= i16 && i13 < i16) || i13 <= i14) {
                c6 = 0;
            }
        }
        if (i6 == 1) {
            return c6 < 0 || (c6 == 0 && i7 * i8 <= 0);
        } else if (i6 == 2) {
            return c6 > 0 || (c6 == 0 && i7 * i8 >= 0);
        } else if (i6 == 17) {
            return i7 < 0;
        } else if (i6 == 33) {
            return c6 < 0;
        } else if (i6 == 66) {
            return i7 > 0;
        } else if (i6 == 130) {
            return c6 > 0;
        } else {
            throw new IllegalArgumentException("Invalid direction: " + i6 + P());
        }
    }

    private void u1() {
        this.f2171e0.g();
        o oVar = this.f2188n;
        if (oVar != null) {
            oVar.K1();
        }
    }

    private void v(Context context, String str, AttributeSet attributeSet, int i6, int i7) {
        Constructor constructor;
        Object[] objArr;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String i02 = i0(context, trim);
            try {
                Class<? extends U> asSubclass = Class.forName(i02, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                try {
                    constructor = asSubclass.getConstructor(E0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i6), Integer.valueOf(i7)};
                } catch (NoSuchMethodException e6) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    } catch (NoSuchMethodException e7) {
                        e7.initCause(e6);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + i02, e7);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + i02, e8);
            } catch (ClassNotFoundException e9) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + i02, e9);
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + i02, e10);
            } catch (InstantiationException e11) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + i02, e11);
            } catch (InvocationTargetException e12) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + i02, e12);
            }
        }
    }

    private boolean x(int i6, int i7) {
        U(this.f2193p0);
        int[] iArr = this.f2193p0;
        return (iArr[0] == i6 && iArr[1] == i7) ? false : true;
    }

    void A0(int i6, int i7) {
        int j6 = this.f2172f.j();
        for (int i8 = 0; i8 < j6; i8++) {
            c0 f02 = f0(this.f2172f.i(i8));
            if (f02 != null && !f02.J() && f02.f2223c >= i6) {
                f02.A(i7, false);
                this.f2177h0.f2320g = true;
            }
        }
        this.f2166c.u(i6, i7);
        requestLayout();
    }

    void B() {
        String str;
        if (this.f2186m == null) {
            str = "No adapter attached; skipping layout";
        } else if (this.f2188n != null) {
            z zVar = this.f2177h0;
            zVar.f2323j = false;
            if (zVar.f2318e == 1) {
                C();
            } else if (!this.f2170e.q() && this.f2188n.o0() == getWidth() && this.f2188n.W() == getHeight()) {
                this.f2188n.z1(this);
                E();
                return;
            }
            this.f2188n.z1(this);
            D();
            E();
            return;
        } else {
            str = "No layout manager attached; skipping layout";
        }
        Log.e("RecyclerView", str);
    }

    void B0(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int j6 = this.f2172f.j();
        if (i6 < i7) {
            i10 = -1;
            i9 = i6;
            i8 = i7;
        } else {
            i8 = i6;
            i9 = i7;
            i10 = 1;
        }
        for (int i12 = 0; i12 < j6; i12++) {
            c0 f02 = f0(this.f2172f.i(i12));
            if (f02 != null && (i11 = f02.f2223c) >= i9 && i11 <= i8) {
                if (i11 == i6) {
                    f02.A(i7 - i6, false);
                } else {
                    f02.A(i10, false);
                }
                this.f2177h0.f2320g = true;
            }
        }
        this.f2166c.v(i6, i7);
        requestLayout();
    }

    void C0(int i6, int i7, boolean z5) {
        int i8 = i6 + i7;
        int j6 = this.f2172f.j();
        for (int i9 = 0; i9 < j6; i9++) {
            c0 f02 = f0(this.f2172f.i(i9));
            if (f02 != null && !f02.J()) {
                int i10 = f02.f2223c;
                if (i10 >= i8) {
                    f02.A(-i7, z5);
                } else if (i10 >= i6) {
                    f02.i(i6 - 1, -i7, z5);
                }
                this.f2177h0.f2320g = true;
            }
        }
        this.f2166c.w(i6, i7, z5);
        requestLayout();
    }

    public void D0(View view) {
    }

    public void E0(View view) {
    }

    public boolean F(int i6, int i7, int[] iArr, int[] iArr2, int i8) {
        return getScrollingChildHelper().d(i6, i7, iArr, iArr2, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F0() {
        this.F++;
    }

    public final void G(int i6, int i7, int i8, int i9, int[] iArr, int i10, int[] iArr2) {
        getScrollingChildHelper().e(i6, i7, i8, i9, iArr, i10, iArr2);
    }

    void G0() {
        H0(true);
    }

    void H(int i6) {
        o oVar = this.f2188n;
        if (oVar != null) {
            oVar.e1(i6);
        }
        J0(i6);
        s sVar = this.f2179i0;
        if (sVar != null) {
            sVar.a(this, i6);
        }
        List list = this.f2181j0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((s) this.f2181j0.get(size)).a(this, i6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H0(boolean z5) {
        int i6 = this.F - 1;
        this.F = i6;
        if (i6 < 1) {
            this.F = 0;
            if (z5) {
                A();
                J();
            }
        }
    }

    void I(int i6, int i7) {
        this.G++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i6, scrollY - i7);
        K0(i6, i7);
        s sVar = this.f2179i0;
        if (sVar != null) {
            sVar.b(this, i6, i7);
        }
        List list = this.f2181j0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((s) this.f2181j0.get(size)).b(this, i6, i7);
            }
        }
        this.G--;
    }

    void J() {
        int i6;
        for (int size = this.f2203u0.size() - 1; size >= 0; size--) {
            c0 c0Var = (c0) this.f2203u0.get(size);
            if (c0Var.f2221a.getParent() == this && !c0Var.J() && (i6 = c0Var.f2237q) != -1) {
                e0.b0.u0(c0Var.f2221a, i6);
                c0Var.f2237q = -1;
            }
        }
        this.f2203u0.clear();
    }

    public void J0(int i6) {
    }

    public void K0(int i6, int i7) {
    }

    void L() {
        int measuredWidth;
        int measuredHeight;
        if (this.L != null) {
            return;
        }
        EdgeEffect a6 = this.H.a(this, 3);
        this.L = a6;
        if (this.f2176h) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a6.setSize(measuredWidth, measuredHeight);
    }

    void L0() {
        if (this.f2189n0 || !this.f2196r) {
            return;
        }
        e0.b0.d0(this, this.f2205v0);
        this.f2189n0 = true;
    }

    void M() {
        int measuredHeight;
        int measuredWidth;
        if (this.I != null) {
            return;
        }
        EdgeEffect a6 = this.H.a(this, 0);
        this.I = a6;
        if (this.f2176h) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a6.setSize(measuredHeight, measuredWidth);
    }

    void N() {
        int measuredHeight;
        int measuredWidth;
        if (this.K != null) {
            return;
        }
        EdgeEffect a6 = this.H.a(this, 2);
        this.K = a6;
        if (this.f2176h) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a6.setSize(measuredHeight, measuredWidth);
    }

    void O() {
        int measuredWidth;
        int measuredHeight;
        if (this.J != null) {
            return;
        }
        EdgeEffect a6 = this.H.a(this, 1);
        this.J = a6;
        if (this.f2176h) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a6.setSize(measuredWidth, measuredHeight);
    }

    void O0(boolean z5) {
        this.E = z5 | this.E;
        this.D = true;
        x0();
    }

    String P() {
        return " " + super.toString() + ", adapter:" + this.f2186m + ", layout:" + this.f2188n + ", context:" + getContext();
    }

    final void Q(z zVar) {
        if (getScrollState() != 2) {
            zVar.f2329p = 0;
            zVar.f2330q = 0;
            return;
        }
        OverScroller overScroller = this.f2171e0.f2215c;
        zVar.f2329p = overScroller.getFinalX() - overScroller.getCurrX();
        zVar.f2330q = overScroller.getFinalY() - overScroller.getCurrY();
    }

    void Q0(c0 c0Var, l.b bVar) {
        c0Var.F(0, Segment.SIZE);
        if (this.f2177h0.f2322i && c0Var.y() && !c0Var.v() && !c0Var.J()) {
            this.f2174g.c(c0(c0Var), c0Var);
        }
        this.f2174g.e(c0Var, bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View R(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == null || parent == this || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return null;
    }

    public c0 S(View view) {
        View R = R(view);
        if (R == null) {
            return null;
        }
        return e0(R);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T0() {
        l lVar = this.M;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.f2188n;
        if (oVar != null) {
            oVar.k1(this.f2166c);
            this.f2188n.l1(this.f2166c);
        }
        this.f2166c.c();
    }

    boolean U0(View view) {
        p1();
        boolean r5 = this.f2172f.r(view);
        if (r5) {
            c0 f02 = f0(view);
            this.f2166c.J(f02);
            this.f2166c.C(f02);
        }
        r1(!r5);
        return r5;
    }

    public void V0(n nVar) {
        o oVar = this.f2188n;
        if (oVar != null) {
            oVar.g("Cannot remove item decoration during a scroll  or layout");
        }
        this.f2190o.remove(nVar);
        if (this.f2190o.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        w0();
        requestLayout();
    }

    public void W0(r rVar) {
        this.f2192p.remove(rVar);
        if (this.f2194q == rVar) {
            this.f2194q = null;
        }
    }

    public c0 X(int i6) {
        c0 c0Var = null;
        if (this.D) {
            return null;
        }
        int j6 = this.f2172f.j();
        for (int i7 = 0; i7 < j6; i7++) {
            c0 f02 = f0(this.f2172f.i(i7));
            if (f02 != null && !f02.v() && b0(f02) == i6) {
                if (!this.f2172f.n(f02.f2221a)) {
                    return f02;
                }
                c0Var = f02;
            }
        }
        return c0Var;
    }

    public void X0(s sVar) {
        List list = this.f2181j0;
        if (list != null) {
            list.remove(sVar);
        }
    }

    public c0 Y(long j6) {
        g gVar = this.f2186m;
        c0 c0Var = null;
        if (gVar != null && gVar.g()) {
            int j7 = this.f2172f.j();
            for (int i6 = 0; i6 < j7; i6++) {
                c0 f02 = f0(this.f2172f.i(i6));
                if (f02 != null && !f02.v() && f02.k() == j6) {
                    if (!this.f2172f.n(f02.f2221a)) {
                        return f02;
                    }
                    c0Var = f02;
                }
            }
        }
        return c0Var;
    }

    void Y0() {
        c0 c0Var;
        int g6 = this.f2172f.g();
        for (int i6 = 0; i6 < g6; i6++) {
            View f6 = this.f2172f.f(i6);
            c0 e02 = e0(f6);
            if (e02 != null && (c0Var = e02.f2229i) != null) {
                View view = c0Var.f2221a;
                int left = f6.getLeft();
                int top = f6.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    c0 Z(int i6, boolean z5) {
        int j6 = this.f2172f.j();
        c0 c0Var = null;
        for (int i7 = 0; i7 < j6; i7++) {
            c0 f02 = f0(this.f2172f.i(i7));
            if (f02 != null && !f02.v()) {
                if (z5) {
                    if (f02.f2223c != i6) {
                        continue;
                    }
                    if (this.f2172f.n(f02.f2221a)) {
                        return f02;
                    }
                    c0Var = f02;
                } else {
                    if (f02.m() != i6) {
                        continue;
                    }
                    if (this.f2172f.n(f02.f2221a)) {
                    }
                }
            }
        }
        return c0Var;
    }

    void a(int i6, int i7) {
        if (i6 < 0) {
            M();
            if (this.I.isFinished()) {
                this.I.onAbsorb(-i6);
            }
        } else if (i6 > 0) {
            N();
            if (this.K.isFinished()) {
                this.K.onAbsorb(i6);
            }
        }
        if (i7 < 0) {
            O();
            if (this.J.isFinished()) {
                this.J.onAbsorb(-i7);
            }
        } else if (i7 > 0) {
            L();
            if (this.L.isFinished()) {
                this.L.onAbsorb(i7);
            }
        }
        if (i6 == 0 && i7 == 0) {
            return;
        }
        e0.b0.c0(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean a0(int i6, int i7) {
        o oVar = this.f2188n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f2208x) {
            return false;
        } else {
            int k6 = oVar.k();
            boolean l6 = this.f2188n.l();
            i6 = (k6 == 0 || Math.abs(i6) < this.W) ? 0 : 0;
            i7 = (!l6 || Math.abs(i7) < this.W) ? 0 : 0;
            if (i6 == 0 && i7 == 0) {
                return false;
            }
            float f6 = i6;
            float f7 = i7;
            if (!dispatchNestedPreFling(f6, f7)) {
                boolean z5 = k6 != 0 || l6;
                dispatchNestedFling(f6, f7, z5);
                q qVar = this.V;
                if (qVar != null && qVar.a(i6, i7)) {
                    return true;
                }
                if (z5) {
                    if (l6) {
                        k6 = (k6 == true ? 1 : 0) | 2;
                    }
                    q1(k6, 1);
                    int i8 = this.f2163a0;
                    int max = Math.max(-i8, Math.min(i6, i8));
                    int i9 = this.f2163a0;
                    this.f2171e0.c(max, Math.max(-i9, Math.min(i7, i9)));
                    return true;
                }
            }
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i6, int i7) {
        o oVar = this.f2188n;
        if (oVar == null || !oVar.F0(this, arrayList, i6, i7)) {
            super.addFocusables(arrayList, i6, i7);
        }
    }

    int b0(c0 c0Var) {
        if (c0Var.p(524) || !c0Var.s()) {
            return -1;
        }
        return this.f2170e.e(c0Var.f2223c);
    }

    long c0(c0 c0Var) {
        return this.f2186m.g() ? c0Var.k() : c0Var.f2223c;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.f2188n.m((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.f2188n;
        if (oVar != null && oVar.k()) {
            return this.f2188n.q(this.f2177h0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.f2188n;
        if (oVar != null && oVar.k()) {
            return this.f2188n.r(this.f2177h0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.f2188n;
        if (oVar != null && oVar.k()) {
            return this.f2188n.s(this.f2177h0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.f2188n;
        if (oVar != null && oVar.l()) {
            return this.f2188n.t(this.f2177h0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.f2188n;
        if (oVar != null && oVar.l()) {
            return this.f2188n.u(this.f2177h0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.f2188n;
        if (oVar != null && oVar.l()) {
            return this.f2188n.v(this.f2177h0);
        }
        return 0;
    }

    public int d0(View view) {
        c0 f02 = f0(view);
        if (f02 != null) {
            return f02.m();
        }
        return -1;
    }

    void d1() {
        int j6 = this.f2172f.j();
        for (int i6 = 0; i6 < j6; i6++) {
            c0 f02 = f0(this.f2172f.i(i6));
            if (!f02.J()) {
                f02.E();
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f6, float f7, boolean z5) {
        return getScrollingChildHelper().a(f6, f7, z5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f6, float f7) {
        return getScrollingChildHelper().b(f6, f7);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i6, int i7, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i6, i7, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, int[] iArr) {
        return getScrollingChildHelper().f(i6, i7, i8, i9, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z5;
        float f6;
        int i6;
        super.draw(canvas);
        int size = this.f2190o.size();
        boolean z6 = false;
        for (int i7 = 0; i7 < size; i7++) {
            ((n) this.f2190o.get(i7)).i(canvas, this, this.f2177h0);
        }
        EdgeEffect edgeEffect = this.I;
        boolean z7 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z5 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f2176h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.I;
            z5 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f2176h) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.J;
            z5 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.K;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f2176h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.K;
            z5 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.L;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f2176h) {
                f6 = (-getWidth()) + getPaddingRight();
                i6 = (-getHeight()) + getPaddingBottom();
            } else {
                f6 = -getWidth();
                i6 = -getHeight();
            }
            canvas.translate(f6, i6);
            EdgeEffect edgeEffect8 = this.L;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z6 = true;
            }
            z5 |= z6;
            canvas.restoreToCount(save4);
        }
        if (z5 || this.M == null || this.f2190o.size() <= 0 || !this.M.p()) {
            z7 = z5;
        }
        if (z7) {
            e0.b0.c0(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j6) {
        return super.drawChild(canvas, view, j6);
    }

    public c0 e0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return f0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    boolean e1(int i6, int i7, MotionEvent motionEvent) {
        int i8;
        int i9;
        int i10;
        int i11;
        u();
        if (this.f2186m != null) {
            int[] iArr = this.f2201t0;
            iArr[0] = 0;
            iArr[1] = 0;
            f1(i6, i7, iArr);
            int[] iArr2 = this.f2201t0;
            int i12 = iArr2[0];
            int i13 = iArr2[1];
            i8 = i13;
            i9 = i12;
            i10 = i6 - i12;
            i11 = i7 - i13;
        } else {
            i8 = 0;
            i9 = 0;
            i10 = 0;
            i11 = 0;
        }
        if (!this.f2190o.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.f2201t0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        G(i9, i8, i10, i11, this.f2197r0, 0, iArr3);
        int[] iArr4 = this.f2201t0;
        int i14 = iArr4[0];
        int i15 = i10 - i14;
        int i16 = iArr4[1];
        int i17 = i11 - i16;
        boolean z5 = (i14 == 0 && i16 == 0) ? false : true;
        int i18 = this.S;
        int[] iArr5 = this.f2197r0;
        int i19 = iArr5[0];
        this.S = i18 - i19;
        int i20 = this.T;
        int i21 = iArr5[1];
        this.T = i20 - i21;
        int[] iArr6 = this.f2199s0;
        iArr6[0] = iArr6[0] + i19;
        iArr6[1] = iArr6[1] + i21;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !e0.o.a(motionEvent, 8194)) {
                P0(motionEvent.getX(), i15, motionEvent.getY(), i17);
            }
            t(i6, i7);
        }
        if (i9 != 0 || i8 != 0) {
            I(i9, i8);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z5 && i9 == 0 && i8 == 0) ? false : true;
    }

    void f1(int i6, int i7, int[] iArr) {
        p1();
        F0();
        a0.b.a("RV Scroll");
        Q(this.f2177h0);
        int w12 = i6 != 0 ? this.f2188n.w1(i6, this.f2166c, this.f2177h0) : 0;
        int y12 = i7 != 0 ? this.f2188n.y1(i7, this.f2166c, this.f2177h0) : 0;
        a0.b.b();
        Y0();
        G0();
        r1(false);
        if (iArr != null) {
            iArr[0] = w12;
            iArr[1] = y12;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i6) {
        View view2;
        boolean z5;
        View Q0 = this.f2188n.Q0(view, i6);
        if (Q0 != null) {
            return Q0;
        }
        boolean z6 = (this.f2186m == null || this.f2188n == null || t0() || this.f2208x) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z6 && (i6 == 2 || i6 == 1)) {
            if (this.f2188n.l()) {
                int i7 = i6 == 2 ? 130 : 33;
                z5 = focusFinder.findNextFocus(this, view, i7) == null;
                if (C0) {
                    i6 = i7;
                }
            } else {
                z5 = false;
            }
            if (!z5 && this.f2188n.k()) {
                int i8 = (this.f2188n.Z() == 1) ^ (i6 == 2) ? 66 : 17;
                boolean z7 = focusFinder.findNextFocus(this, view, i8) == null;
                if (C0) {
                    i6 = i8;
                }
                z5 = z7;
            }
            if (z5) {
                u();
                if (R(view) == null) {
                    return null;
                }
                p1();
                this.f2188n.J0(view, i6, this.f2166c, this.f2177h0);
                r1(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i6);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i6);
            if (findNextFocus == null && z6) {
                u();
                if (R(view) == null) {
                    return null;
                }
                p1();
                view2 = this.f2188n.J0(view, i6, this.f2166c, this.f2177h0);
                r1(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return u0(view, view2, i6) ? view2 : super.focusSearch(view, i6);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i6);
        } else {
            Z0(view2, null);
            return view;
        }
    }

    public void g1(int i6) {
        if (this.f2208x) {
            return;
        }
        t1();
        o oVar = this.f2188n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        oVar.x1(i6);
        awakenScrollBars();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.f2188n;
        if (oVar != null) {
            return oVar.D();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.f2188n;
        if (oVar != null) {
            return oVar.E(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.f2186m;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.f2188n;
        return oVar != null ? oVar.G() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i6, int i7) {
        return super.getChildDrawingOrder(i6, i7);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f2176h;
    }

    public androidx.recyclerview.widget.k getCompatAccessibilityDelegate() {
        return this.f2191o0;
    }

    public k getEdgeEffectFactory() {
        return this.H;
    }

    public l getItemAnimator() {
        return this.M;
    }

    public int getItemDecorationCount() {
        return this.f2190o.size();
    }

    public o getLayoutManager() {
        return this.f2188n;
    }

    public int getMaxFlingVelocity() {
        return this.f2163a0;
    }

    public int getMinFlingVelocity() {
        return this.W;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (B0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public q getOnFlingListener() {
        return this.V;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f2169d0;
    }

    public t getRecycledViewPool() {
        return this.f2166c.i();
    }

    public int getScrollState() {
        return this.N;
    }

    public void h(n nVar) {
        i(nVar, -1);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(n nVar, int i6) {
        o oVar = this.f2188n;
        if (oVar != null) {
            oVar.g("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f2190o.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i6 < 0) {
            this.f2190o.add(nVar);
        } else {
            this.f2190o.add(i6, nVar);
        }
        w0();
        requestLayout();
    }

    boolean i1(c0 c0Var, int i6) {
        if (!t0()) {
            e0.b0.u0(c0Var.f2221a, i6);
            return true;
        }
        c0Var.f2237q = i6;
        this.f2203u0.add(c0Var);
        return false;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f2196r;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f2208x;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(r rVar) {
        this.f2192p.add(rVar);
    }

    Rect j0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (pVar.f2281c) {
            if (this.f2177h0.e() && (pVar.b() || pVar.d())) {
                return pVar.f2280b;
            }
            Rect rect = pVar.f2280b;
            rect.set(0, 0, 0, 0);
            int size = this.f2190o.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.f2180j.set(0, 0, 0, 0);
                ((n) this.f2190o.get(i6)).e(this.f2180j, view, this, this.f2177h0);
                int i7 = rect.left;
                Rect rect2 = this.f2180j;
                rect.left = i7 + rect2.left;
                rect.top += rect2.top;
                rect.right += rect2.right;
                rect.bottom += rect2.bottom;
            }
            pVar.f2281c = false;
            return rect;
        }
        return pVar.f2280b;
    }

    boolean j1(AccessibilityEvent accessibilityEvent) {
        if (t0()) {
            int a6 = accessibilityEvent != null ? f0.b.a(accessibilityEvent) : 0;
            this.f2210z |= a6 != 0 ? a6 : 0;
            return true;
        }
        return false;
    }

    public void k(s sVar) {
        if (this.f2181j0 == null) {
            this.f2181j0 = new ArrayList();
        }
        this.f2181j0.add(sVar);
    }

    public void k1(int i6, int i7) {
        l1(i6, i7, null);
    }

    void l(c0 c0Var, l.b bVar, l.b bVar2) {
        c0Var.G(false);
        if (this.M.a(c0Var, bVar, bVar2)) {
            L0();
        }
    }

    public boolean l0() {
        return !this.f2202u || this.D || this.f2170e.p();
    }

    public void l1(int i6, int i7, Interpolator interpolator) {
        m1(i6, i7, interpolator, Integer.MIN_VALUE);
    }

    public void m1(int i6, int i7, Interpolator interpolator, int i8) {
        n1(i6, i7, interpolator, i8, false);
    }

    void n(c0 c0Var, l.b bVar, l.b bVar2) {
        g(c0Var);
        c0Var.G(false);
        if (this.M.c(c0Var, bVar, bVar2)) {
            L0();
        }
    }

    void n0() {
        this.f2170e = new androidx.recyclerview.widget.a(new f());
    }

    void n1(int i6, int i7, Interpolator interpolator, int i8, boolean z5) {
        o oVar = this.f2188n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.f2208x) {
        } else {
            if (!oVar.k()) {
                i6 = 0;
            }
            if (!this.f2188n.l()) {
                i7 = 0;
            }
            if (i6 == 0 && i7 == 0) {
                return;
            }
            if (!(i8 == Integer.MIN_VALUE || i8 > 0)) {
                scrollBy(i6, i7);
                return;
            }
            if (z5) {
                int i9 = i6 != 0 ? 1 : 0;
                if (i7 != 0) {
                    i9 |= 2;
                }
                q1(i9, 1);
            }
            this.f2171e0.f(i6, i7, i8, interpolator);
        }
    }

    void o(String str) {
        if (t0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + P());
        } else if (this.G > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(HttpUrl.FRAGMENT_ENCODE_SET + P()));
        }
    }

    public void o1(int i6) {
        if (this.f2208x) {
            return;
        }
        o oVar = this.f2188n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.I1(this, this.f2177h0, i6);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r1 >= 30.0f) goto L17;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onAttachedToWindow() {
        float f6;
        super.onAttachedToWindow();
        this.F = 0;
        boolean z5 = true;
        this.f2196r = true;
        this.f2202u = (!this.f2202u || isLayoutRequested()) ? false : false;
        o oVar = this.f2188n;
        if (oVar != null) {
            oVar.z(this);
        }
        this.f2189n0 = false;
        if (B0) {
            ThreadLocal threadLocal = androidx.recyclerview.widget.e.f2470e;
            androidx.recyclerview.widget.e eVar = (androidx.recyclerview.widget.e) threadLocal.get();
            this.f2173f0 = eVar;
            if (eVar == null) {
                this.f2173f0 = new androidx.recyclerview.widget.e();
                Display v5 = e0.b0.v(this);
                if (!isInEditMode() && v5 != null) {
                    f6 = v5.getRefreshRate();
                }
                f6 = 60.0f;
                androidx.recyclerview.widget.e eVar2 = this.f2173f0;
                eVar2.f2474c = 1.0E9f / f6;
                threadLocal.set(eVar2);
            }
            this.f2173f0.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.e eVar;
        super.onDetachedFromWindow();
        l lVar = this.M;
        if (lVar != null) {
            lVar.k();
        }
        t1();
        this.f2196r = false;
        o oVar = this.f2188n;
        if (oVar != null) {
            oVar.A(this, this.f2166c);
        }
        this.f2203u0.clear();
        removeCallbacks(this.f2205v0);
        this.f2174g.j();
        if (!B0 || (eVar = this.f2173f0) == null) {
            return;
        }
        eVar.j(this);
        this.f2173f0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f2190o.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((n) this.f2190o.get(i6)).g(canvas, this, this.f2177h0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f6;
        float f7;
        if (this.f2188n != null && !this.f2208x && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f6 = this.f2188n.l() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.f2188n.k()) {
                    f7 = motionEvent.getAxisValue(10);
                    if (f6 == 0.0f || f7 != 0.0f) {
                        e1((int) (f7 * this.f2165b0), (int) (f6 * this.f2167c0), motionEvent);
                    }
                }
                f7 = 0.0f;
                if (f6 == 0.0f) {
                }
                e1((int) (f7 * this.f2165b0), (int) (f6 * this.f2167c0), motionEvent);
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.f2188n.l()) {
                        f6 = -axisValue;
                        f7 = 0.0f;
                        if (f6 == 0.0f) {
                        }
                        e1((int) (f7 * this.f2165b0), (int) (f6 * this.f2167c0), motionEvent);
                    } else if (this.f2188n.k()) {
                        f7 = axisValue;
                        f6 = 0.0f;
                        if (f6 == 0.0f) {
                        }
                        e1((int) (f7 * this.f2165b0), (int) (f6 * this.f2167c0), motionEvent);
                    }
                }
                f6 = 0.0f;
                f7 = 0.0f;
                if (f6 == 0.0f) {
                }
                e1((int) (f7 * this.f2165b0), (int) (f6 * this.f2167c0), motionEvent);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        if (this.f2208x) {
            return false;
        }
        this.f2194q = null;
        if (T(motionEvent)) {
            q();
            return true;
        }
        o oVar = this.f2188n;
        if (oVar == null) {
            return false;
        }
        boolean k6 = oVar.k();
        boolean l6 = this.f2188n.l();
        if (this.P == null) {
            this.P = VelocityTracker.obtain();
        }
        this.P.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f2209y) {
                this.f2209y = false;
            }
            this.O = motionEvent.getPointerId(0);
            int x5 = (int) (motionEvent.getX() + 0.5f);
            this.S = x5;
            this.Q = x5;
            int y5 = (int) (motionEvent.getY() + 0.5f);
            this.T = y5;
            this.R = y5;
            if (this.N == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                s1(1);
            }
            int[] iArr = this.f2199s0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i6 = k6;
            if (l6) {
                i6 = (k6 ? 1 : 0) | 2;
            }
            q1(i6, 0);
        } else if (actionMasked == 1) {
            this.P.clear();
            s1(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.O);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.O + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x6 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y6 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.N != 1) {
                int i7 = x6 - this.Q;
                int i8 = y6 - this.R;
                if (!k6 || Math.abs(i7) <= this.U) {
                    z5 = false;
                } else {
                    this.S = x6;
                    z5 = true;
                }
                if (l6 && Math.abs(i8) > this.U) {
                    this.T = y6;
                    z5 = true;
                }
                if (z5) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            q();
        } else if (actionMasked == 5) {
            this.O = motionEvent.getPointerId(actionIndex);
            int x7 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.S = x7;
            this.Q = x7;
            int y7 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.T = y7;
            this.R = y7;
        } else if (actionMasked == 6) {
            I0(motionEvent);
        }
        return this.N == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        a0.b.a("RV OnLayout");
        B();
        a0.b.b();
        this.f2202u = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        o oVar = this.f2188n;
        if (oVar == null) {
            w(i6, i7);
            return;
        }
        boolean z5 = false;
        if (oVar.s0()) {
            int mode = View.MeasureSpec.getMode(i6);
            int mode2 = View.MeasureSpec.getMode(i7);
            this.f2188n.Z0(this.f2166c, this.f2177h0, i6, i7);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z5 = true;
            }
            if (z5 || this.f2186m == null) {
                return;
            }
            if (this.f2177h0.f2318e == 1) {
                C();
            }
            this.f2188n.A1(i6, i7);
            this.f2177h0.f2323j = true;
            D();
            this.f2188n.D1(i6, i7);
            if (this.f2188n.G1()) {
                this.f2188n.A1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f2177h0.f2323j = true;
                D();
                this.f2188n.D1(i6, i7);
            }
        } else if (this.f2198s) {
            this.f2188n.Z0(this.f2166c, this.f2177h0, i6, i7);
        } else {
            if (this.A) {
                p1();
                F0();
                N0();
                G0();
                z zVar = this.f2177h0;
                if (zVar.f2325l) {
                    zVar.f2321h = true;
                } else {
                    this.f2170e.j();
                    this.f2177h0.f2321h = false;
                }
                this.A = false;
                r1(false);
            } else if (this.f2177h0.f2325l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            g gVar = this.f2186m;
            if (gVar != null) {
                this.f2177h0.f2319f = gVar.c();
            } else {
                this.f2177h0.f2319f = 0;
            }
            p1();
            this.f2188n.Z0(this.f2166c, this.f2177h0, i6, i7);
            r1(false);
            this.f2177h0.f2321h = false;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i6, Rect rect) {
        if (t0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i6, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof x)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        x xVar = (x) parcelable;
        this.f2168d = xVar;
        super.onRestoreInstanceState(xVar.e());
        o oVar = this.f2188n;
        if (oVar == null || (parcelable2 = this.f2168d.f2298c) == null) {
            return;
        }
        oVar.c1(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        x xVar = new x(super.onSaveInstanceState());
        x xVar2 = this.f2168d;
        if (xVar2 != null) {
            xVar.f(xVar2);
        } else {
            o oVar = this.f2188n;
            xVar.f2298c = oVar != null ? oVar.d1() : null;
        }
        return xVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        if (i6 == i8 && i7 == i9) {
            return;
        }
        r0();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        boolean z6 = false;
        if (this.f2208x || this.f2209y) {
            return false;
        }
        if (K(motionEvent)) {
            q();
            return true;
        }
        o oVar = this.f2188n;
        if (oVar == null) {
            return false;
        }
        boolean k6 = oVar.k();
        boolean l6 = this.f2188n.l();
        if (this.P == null) {
            this.P = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.f2199s0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.f2199s0;
        obtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.O = motionEvent.getPointerId(0);
            int x5 = (int) (motionEvent.getX() + 0.5f);
            this.S = x5;
            this.Q = x5;
            int y5 = (int) (motionEvent.getY() + 0.5f);
            this.T = y5;
            this.R = y5;
            int i6 = k6;
            if (l6) {
                i6 = (k6 ? 1 : 0) | 2;
            }
            q1(i6, 0);
        } else if (actionMasked == 1) {
            this.P.addMovement(obtain);
            this.P.computeCurrentVelocity(1000, this.f2163a0);
            float f6 = k6 ? -this.P.getXVelocity(this.O) : 0.0f;
            float f7 = l6 ? -this.P.getYVelocity(this.O) : 0.0f;
            if ((f6 == 0.0f && f7 == 0.0f) || !a0((int) f6, (int) f7)) {
                setScrollState(0);
            }
            b1();
            z6 = true;
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.O);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.O + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x6 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y6 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            int i7 = this.S - x6;
            int i8 = this.T - y6;
            if (this.N != 1) {
                if (k6) {
                    int i9 = this.U;
                    i7 = i7 > 0 ? Math.max(0, i7 - i9) : Math.min(0, i7 + i9);
                    if (i7 != 0) {
                        z5 = true;
                        if (l6) {
                            int i10 = this.U;
                            i8 = i8 > 0 ? Math.max(0, i8 - i10) : Math.min(0, i8 + i10);
                            if (i8 != 0) {
                                z5 = true;
                            }
                        }
                        if (z5) {
                            setScrollState(1);
                        }
                    }
                }
                z5 = false;
                if (l6) {
                }
                if (z5) {
                }
            }
            int i11 = i7;
            int i12 = i8;
            if (this.N == 1) {
                int[] iArr3 = this.f2201t0;
                iArr3[0] = 0;
                iArr3[1] = 0;
                if (F(k6 ? i11 : 0, l6 ? i12 : 0, iArr3, this.f2197r0, 0)) {
                    int[] iArr4 = this.f2201t0;
                    i11 -= iArr4[0];
                    i12 -= iArr4[1];
                    int[] iArr5 = this.f2199s0;
                    int i13 = iArr5[0];
                    int[] iArr6 = this.f2197r0;
                    iArr5[0] = i13 + iArr6[0];
                    iArr5[1] = iArr5[1] + iArr6[1];
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int i14 = i12;
                int[] iArr7 = this.f2197r0;
                this.S = x6 - iArr7[0];
                this.T = y6 - iArr7[1];
                if (e1(k6 ? i11 : 0, l6 ? i14 : 0, motionEvent)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                androidx.recyclerview.widget.e eVar = this.f2173f0;
                if (eVar != null && (i11 != 0 || i14 != 0)) {
                    eVar.f(this, i11, i14);
                }
            }
        } else if (actionMasked == 3) {
            q();
        } else if (actionMasked == 5) {
            this.O = motionEvent.getPointerId(actionIndex);
            int x7 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.S = x7;
            this.Q = x7;
            int y7 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.T = y7;
            this.R = y7;
        } else if (actionMasked == 6) {
            I0(motionEvent);
        }
        if (!z6) {
            this.P.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    boolean p(c0 c0Var) {
        l lVar = this.M;
        return lVar == null || lVar.g(c0Var, c0Var.o());
    }

    void p1() {
        int i6 = this.f2204v + 1;
        this.f2204v = i6;
        if (i6 != 1 || this.f2208x) {
            return;
        }
        this.f2206w = false;
    }

    void q0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(m0.b.fastscroll_default_thickness), resources.getDimensionPixelSize(m0.b.fastscroll_minimum_range), resources.getDimensionPixelOffset(m0.b.fastscroll_margin));
            return;
        }
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + P());
    }

    public boolean q1(int i6, int i7) {
        return getScrollingChildHelper().p(i6, i7);
    }

    void r0() {
        this.L = null;
        this.J = null;
        this.K = null;
        this.I = null;
    }

    void r1(boolean z5) {
        if (this.f2204v < 1) {
            this.f2204v = 1;
        }
        if (!z5 && !this.f2208x) {
            this.f2206w = false;
        }
        if (this.f2204v == 1) {
            if (z5 && this.f2206w && !this.f2208x && this.f2188n != null && this.f2186m != null) {
                B();
            }
            if (!this.f2208x) {
                this.f2206w = false;
            }
        }
        this.f2204v--;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z5) {
        c0 f02 = f0(view);
        if (f02 != null) {
            if (f02.x()) {
                f02.f();
            } else if (!f02.J()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + f02 + P());
            }
        }
        view.clearAnimation();
        z(view);
        super.removeDetachedView(view, z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f2188n.b1(this, this.f2177h0, view, view2) && view2 != null) {
            Z0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z5) {
        return this.f2188n.r1(this, view, rect, z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z5) {
        int size = this.f2192p.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((r) this.f2192p.get(i6)).c(z5);
        }
        super.requestDisallowInterceptTouchEvent(z5);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f2204v != 0 || this.f2208x) {
            this.f2206w = true;
        } else {
            super.requestLayout();
        }
    }

    void s() {
        int j6 = this.f2172f.j();
        for (int i6 = 0; i6 < j6; i6++) {
            c0 f02 = f0(this.f2172f.i(i6));
            if (!f02.J()) {
                f02.c();
            }
        }
        this.f2166c.d();
    }

    boolean s0() {
        AccessibilityManager accessibilityManager = this.B;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public void s1(int i6) {
        getScrollingChildHelper().r(i6);
    }

    @Override // android.view.View
    public void scrollBy(int i6, int i7) {
        o oVar = this.f2188n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.f2208x) {
        } else {
            boolean k6 = oVar.k();
            boolean l6 = this.f2188n.l();
            if (k6 || l6) {
                if (!k6) {
                    i6 = 0;
                }
                if (!l6) {
                    i7 = 0;
                }
                e1(i6, i7, null);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i6, int i7) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (j1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.k kVar) {
        this.f2191o0 = kVar;
        e0.b0.l0(this, kVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        h1(gVar, false, true);
        O0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z5) {
        if (z5 != this.f2176h) {
            r0();
        }
        this.f2176h = z5;
        super.setClipToPadding(z5);
        if (this.f2202u) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        d0.i.c(kVar);
        this.H = kVar;
        r0();
    }

    public void setHasFixedSize(boolean z5) {
        this.f2198s = z5;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.M;
        if (lVar2 != null) {
            lVar2.k();
            this.M.v(null);
        }
        this.M = lVar;
        if (lVar != null) {
            lVar.v(this.f2187m0);
        }
    }

    public void setItemViewCacheSize(int i6) {
        this.f2166c.G(i6);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z5) {
        suppressLayout(z5);
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.f2188n) {
            return;
        }
        t1();
        if (this.f2188n != null) {
            l lVar = this.M;
            if (lVar != null) {
                lVar.k();
            }
            this.f2188n.k1(this.f2166c);
            this.f2188n.l1(this.f2166c);
            this.f2166c.c();
            if (this.f2196r) {
                this.f2188n.A(this, this.f2166c);
            }
            this.f2188n.E1(null);
            this.f2188n = null;
        } else {
            this.f2166c.c();
        }
        this.f2172f.o();
        this.f2188n = oVar;
        if (oVar != null) {
            if (oVar.f2256b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f2256b.P());
            }
            oVar.E1(this);
            if (this.f2196r) {
                this.f2188n.z(this);
            }
        }
        this.f2166c.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z5) {
        getScrollingChildHelper().m(z5);
    }

    public void setOnFlingListener(q qVar) {
        this.V = qVar;
    }

    @Deprecated
    public void setOnScrollListener(s sVar) {
        this.f2179i0 = sVar;
    }

    public void setPreserveFocusAfterLayout(boolean z5) {
        this.f2169d0 = z5;
    }

    public void setRecycledViewPool(t tVar) {
        this.f2166c.E(tVar);
    }

    public void setRecyclerListener(v vVar) {
    }

    void setScrollState(int i6) {
        if (i6 == this.N) {
            return;
        }
        this.N = i6;
        if (i6 != 2) {
            u1();
        }
        H(i6);
    }

    public void setScrollingTouchSlop(int i6) {
        int scaledTouchSlop;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i6 != 0) {
            if (i6 == 1) {
                scaledTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                this.U = scaledTouchSlop;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i6 + "; using default value");
        }
        scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.U = scaledTouchSlop;
    }

    public void setViewCacheExtension(a0 a0Var) {
        this.f2166c.F(a0Var);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i6) {
        return getScrollingChildHelper().o(i6);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z5) {
        if (z5 != this.f2208x) {
            o("Do not suppressLayout in layout or scroll");
            if (z5) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f2208x = true;
                this.f2209y = true;
                t1();
                return;
            }
            this.f2208x = false;
            if (this.f2206w && this.f2188n != null && this.f2186m != null) {
                requestLayout();
            }
            this.f2206w = false;
        }
    }

    void t(int i6, int i7) {
        boolean z5;
        EdgeEffect edgeEffect = this.I;
        if (edgeEffect == null || edgeEffect.isFinished() || i6 <= 0) {
            z5 = false;
        } else {
            this.I.onRelease();
            z5 = this.I.isFinished();
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i6 < 0) {
            this.K.onRelease();
            z5 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i7 > 0) {
            this.J.onRelease();
            z5 |= this.J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.L;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i7 < 0) {
            this.L.onRelease();
            z5 |= this.L.isFinished();
        }
        if (z5) {
            e0.b0.c0(this);
        }
    }

    public boolean t0() {
        return this.F > 0;
    }

    public void t1() {
        setScrollState(0);
        u1();
    }

    void u() {
        if (!this.f2202u || this.D) {
            a0.b.a("RV FullInvalidate");
            B();
            a0.b.b();
        } else if (this.f2170e.p()) {
            if (this.f2170e.o(4) && !this.f2170e.o(11)) {
                a0.b.a("RV PartialInvalidate");
                p1();
                F0();
                this.f2170e.s();
                if (!this.f2206w) {
                    if (m0()) {
                        B();
                    } else {
                        this.f2170e.i();
                    }
                }
                r1(true);
                G0();
            } else if (!this.f2170e.p()) {
                return;
            } else {
                a0.b.a("RV FullInvalidate");
                B();
            }
            a0.b.b();
        }
    }

    void v0(int i6) {
        if (this.f2188n == null) {
            return;
        }
        setScrollState(2);
        this.f2188n.x1(i6);
        awakenScrollBars();
    }

    void v1(int i6, int i7, Object obj) {
        int i8;
        int j6 = this.f2172f.j();
        int i9 = i6 + i7;
        for (int i10 = 0; i10 < j6; i10++) {
            View i11 = this.f2172f.i(i10);
            c0 f02 = f0(i11);
            if (f02 != null && !f02.J() && (i8 = f02.f2223c) >= i6 && i8 < i9) {
                f02.b(2);
                f02.a(obj);
                ((p) i11.getLayoutParams()).f2281c = true;
            }
        }
        this.f2166c.M(i6, i7);
    }

    void w(int i6, int i7) {
        setMeasuredDimension(o.n(i6, getPaddingLeft() + getPaddingRight(), e0.b0.D(this)), o.n(i7, getPaddingTop() + getPaddingBottom(), e0.b0.C(this)));
    }

    void w0() {
        int j6 = this.f2172f.j();
        for (int i6 = 0; i6 < j6; i6++) {
            ((p) this.f2172f.i(i6).getLayoutParams()).f2281c = true;
        }
        this.f2166c.s();
    }

    void x0() {
        int j6 = this.f2172f.j();
        for (int i6 = 0; i6 < j6; i6++) {
            c0 f02 = f0(this.f2172f.i(i6));
            if (f02 != null && !f02.J()) {
                f02.b(6);
            }
        }
        w0();
        this.f2166c.t();
    }

    void y(View view) {
        int size;
        c0 f02 = f0(view);
        D0(view);
        g gVar = this.f2186m;
        if (gVar != null && f02 != null) {
            gVar.n(f02);
        }
        List list = this.C;
        if (list == null || list.size() - 1 < 0) {
            return;
        }
        android.support.v4.media.a.a(this.C.get(size));
        throw null;
    }

    public void y0(int i6) {
        int g6 = this.f2172f.g();
        for (int i7 = 0; i7 < g6; i7++) {
            this.f2172f.f(i7).offsetLeftAndRight(i6);
        }
    }

    void z(View view) {
        int size;
        c0 f02 = f0(view);
        E0(view);
        g gVar = this.f2186m;
        if (gVar != null && f02 != null) {
            gVar.o(f02);
        }
        List list = this.C;
        if (list == null || list.size() - 1 < 0) {
            return;
        }
        android.support.v4.media.a.a(this.C.get(size));
        throw null;
    }

    public void z0(int i6) {
        int g6 = this.f2172f.g();
        for (int i7 = 0; i7 < g6; i7++) {
            this.f2172f.f(i7).offsetTopAndBottom(i6);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2164b = new w();
        this.f2166c = new u();
        this.f2174g = new androidx.recyclerview.widget.p();
        this.f2178i = new a();
        this.f2180j = new Rect();
        this.f2182k = new Rect();
        this.f2184l = new RectF();
        this.f2190o = new ArrayList();
        this.f2192p = new ArrayList();
        this.f2204v = 0;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = new k();
        this.M = new androidx.recyclerview.widget.c();
        this.N = 0;
        this.O = -1;
        this.f2165b0 = Float.MIN_VALUE;
        this.f2167c0 = Float.MIN_VALUE;
        this.f2169d0 = true;
        this.f2171e0 = new b0();
        this.f2175g0 = B0 ? new e.b() : null;
        this.f2177h0 = new z();
        this.f2183k0 = false;
        this.f2185l0 = false;
        this.f2187m0 = new m();
        this.f2189n0 = false;
        this.f2193p0 = new int[2];
        this.f2197r0 = new int[2];
        this.f2199s0 = new int[2];
        this.f2201t0 = new int[2];
        this.f2203u0 = new ArrayList();
        this.f2205v0 = new b();
        this.f2207w0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.U = viewConfiguration.getScaledTouchSlop();
        this.f2165b0 = o0.b(viewConfiguration, context);
        this.f2167c0 = o0.d(viewConfiguration, context);
        this.W = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2163a0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.M.v(this.f2187m0);
        n0();
        p0();
        o0();
        if (e0.b0.z(this) == 0) {
            e0.b0.u0(this, 1);
        }
        this.B = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.k(this));
        int[] iArr = m0.c.f11944f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, i6, 0);
        }
        String string = obtainStyledAttributes.getString(m0.c.f11953o);
        if (obtainStyledAttributes.getInt(m0.c.f11947i, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f2176h = obtainStyledAttributes.getBoolean(m0.c.f11946h, true);
        boolean z5 = obtainStyledAttributes.getBoolean(m0.c.f11948j, false);
        this.f2200t = z5;
        if (z5) {
            q0((StateListDrawable) obtainStyledAttributes.getDrawable(m0.c.f11951m), obtainStyledAttributes.getDrawable(m0.c.f11952n), (StateListDrawable) obtainStyledAttributes.getDrawable(m0.c.f11949k), obtainStyledAttributes.getDrawable(m0.c.f11950l));
        }
        obtainStyledAttributes.recycle();
        v(context, string, attributeSet, i6, 0);
        int[] iArr2 = f2160x0;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i6, 0);
        if (i7 >= 29) {
            saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes2, i6, 0);
        }
        boolean z6 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z6);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.f2188n;
        if (oVar != null) {
            return oVar.F(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }
}
