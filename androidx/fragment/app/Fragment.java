package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.c;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
/* loaded from: classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.f, androidx.lifecycle.p, androidx.savedstate.b {
    static final Object Y = new Object();
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    private boolean F;
    ViewGroup G;
    View H;
    View I;
    boolean J;
    d L;
    boolean N;
    boolean O;
    float P;
    LayoutInflater Q;
    boolean R;
    androidx.lifecycle.g T;
    p U;
    androidx.savedstate.a W;
    private int X;

    /* renamed from: c  reason: collision with root package name */
    Bundle f1691c;

    /* renamed from: d  reason: collision with root package name */
    SparseArray f1692d;

    /* renamed from: e  reason: collision with root package name */
    Boolean f1693e;

    /* renamed from: g  reason: collision with root package name */
    Bundle f1695g;

    /* renamed from: h  reason: collision with root package name */
    Fragment f1696h;

    /* renamed from: j  reason: collision with root package name */
    int f1698j;

    /* renamed from: l  reason: collision with root package name */
    boolean f1700l;

    /* renamed from: m  reason: collision with root package name */
    boolean f1701m;

    /* renamed from: n  reason: collision with root package name */
    boolean f1702n;

    /* renamed from: o  reason: collision with root package name */
    boolean f1703o;

    /* renamed from: p  reason: collision with root package name */
    boolean f1704p;

    /* renamed from: q  reason: collision with root package name */
    boolean f1705q;

    /* renamed from: r  reason: collision with root package name */
    int f1706r;

    /* renamed from: s  reason: collision with root package name */
    h f1707s;

    /* renamed from: t  reason: collision with root package name */
    androidx.fragment.app.f f1708t;

    /* renamed from: v  reason: collision with root package name */
    Fragment f1710v;

    /* renamed from: w  reason: collision with root package name */
    int f1711w;

    /* renamed from: x  reason: collision with root package name */
    int f1712x;

    /* renamed from: y  reason: collision with root package name */
    String f1713y;

    /* renamed from: z  reason: collision with root package name */
    boolean f1714z;

    /* renamed from: b  reason: collision with root package name */
    int f1690b = 0;

    /* renamed from: f  reason: collision with root package name */
    String f1694f = UUID.randomUUID().toString();

    /* renamed from: i  reason: collision with root package name */
    String f1697i = null;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f1699k = null;

    /* renamed from: u  reason: collision with root package name */
    h f1709u = new h();
    boolean E = true;
    boolean K = true;
    Runnable M = new a();
    c.b S = c.b.RESUMED;
    androidx.lifecycle.j V = new androidx.lifecycle.j();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.c();
        }
    }

    /* loaded from: classes.dex */
    class c extends androidx.fragment.app.c {
        c() {
        }

        @Override // androidx.fragment.app.c
        public View d(int i6) {
            View view = Fragment.this.H;
            if (view != null) {
                return view.findViewById(i6);
            }
            throw new IllegalStateException("Fragment " + this + " does not have a view");
        }

        @Override // androidx.fragment.app.c
        public boolean e() {
            return Fragment.this.H != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        View f1719a;

        /* renamed from: b  reason: collision with root package name */
        Animator f1720b;

        /* renamed from: c  reason: collision with root package name */
        int f1721c;

        /* renamed from: d  reason: collision with root package name */
        int f1722d;

        /* renamed from: e  reason: collision with root package name */
        int f1723e;

        /* renamed from: f  reason: collision with root package name */
        int f1724f;

        /* renamed from: g  reason: collision with root package name */
        Object f1725g = null;

        /* renamed from: h  reason: collision with root package name */
        Object f1726h;

        /* renamed from: i  reason: collision with root package name */
        Object f1727i;

        /* renamed from: j  reason: collision with root package name */
        Object f1728j;

        /* renamed from: k  reason: collision with root package name */
        Object f1729k;

        /* renamed from: l  reason: collision with root package name */
        Object f1730l;

        /* renamed from: m  reason: collision with root package name */
        Boolean f1731m;

        /* renamed from: n  reason: collision with root package name */
        Boolean f1732n;

        /* renamed from: o  reason: collision with root package name */
        boolean f1733o;

        /* renamed from: p  reason: collision with root package name */
        f f1734p;

        /* renamed from: q  reason: collision with root package name */
        boolean f1735q;

        d() {
            Object obj = Fragment.Y;
            this.f1726h = obj;
            this.f1727i = null;
            this.f1728j = obj;
            this.f1729k = null;
            this.f1730l = obj;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends RuntimeException {
        public e(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void a();

        void b();
    }

    public Fragment() {
        L();
    }

    private void L() {
        this.T = new androidx.lifecycle.g(this);
        this.W = androidx.savedstate.a.a(this);
        this.T.a(new androidx.lifecycle.d() { // from class: androidx.fragment.app.Fragment.2
            @Override // androidx.lifecycle.d
            public void a(androidx.lifecycle.f fVar, c.a aVar) {
                View view;
                if (aVar != c.a.ON_STOP || (view = Fragment.this.H) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
    }

    public static Fragment N(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) androidx.fragment.app.e.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.f1(bundle);
            }
            return fragment;
        } catch (IllegalAccessException e6) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e6);
        } catch (InstantiationException e7) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e7);
        } catch (NoSuchMethodException e8) {
            throw new e("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e8);
        } catch (InvocationTargetException e9) {
            throw new e("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e9);
        }
    }

    private d e() {
        if (this.L == null) {
            this.L = new d();
        }
        return this.L;
    }

    public final Fragment A() {
        return this.f1710v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A0(Bundle bundle) {
        this.f1709u.S0();
        this.f1690b = 2;
        this.F = false;
        T(bundle);
        if (this.F) {
            this.f1709u.w();
            return;
        }
        throw new q("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public Object B() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1728j;
        return obj == Y ? s() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B0() {
        this.f1709u.n(this.f1708t, new c(), this);
        this.F = false;
        W(this.f1708t.i());
        if (this.F) {
            return;
        }
        throw new q("Fragment " + this + " did not call through to super.onAttach()");
    }

    public final Resources C() {
        return Y0().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C0(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.f1709u.x(configuration);
    }

    public final boolean D() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D0(MenuItem menuItem) {
        if (this.f1714z) {
            return false;
        }
        return Y(menuItem) || this.f1709u.y(menuItem);
    }

    public Object E() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1726h;
        return obj == Y ? q() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E0(Bundle bundle) {
        this.f1709u.S0();
        this.f1690b = 1;
        this.F = false;
        this.W.c(bundle);
        Z(bundle);
        this.R = true;
        if (this.F) {
            this.T.i(c.a.ON_CREATE);
            return;
        }
        throw new q("Fragment " + this + " did not call through to super.onCreate()");
    }

    public Object F() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        return dVar.f1729k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F0(Menu menu, MenuInflater menuInflater) {
        boolean z5 = false;
        if (this.f1714z) {
            return false;
        }
        if (this.D && this.E) {
            c0(menu, menuInflater);
            z5 = true;
        }
        return z5 | this.f1709u.A(menu, menuInflater);
    }

    public Object G() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1730l;
        return obj == Y ? F() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1709u.S0();
        this.f1705q = true;
        this.U = new p();
        View d02 = d0(layoutInflater, viewGroup, bundle);
        this.H = d02;
        if (d02 != null) {
            this.U.d();
            this.V.g(this.U);
        } else if (this.U.e()) {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        } else {
            this.U = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int H() {
        d dVar = this.L;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1721c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H0() {
        this.f1709u.B();
        this.T.i(c.a.ON_DESTROY);
        this.f1690b = 0;
        this.F = false;
        this.R = false;
        e0();
        if (this.F) {
            return;
        }
        throw new q("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public final String I(int i6) {
        return C().getString(i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I0() {
        this.f1709u.C();
        if (this.H != null) {
            this.U.c(c.a.ON_DESTROY);
        }
        this.f1690b = 1;
        this.F = false;
        g0();
        if (this.F) {
            androidx.loader.app.a.b(this).c();
            this.f1705q = false;
            return;
        }
        throw new q("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    public final Fragment J() {
        String str;
        Fragment fragment = this.f1696h;
        if (fragment != null) {
            return fragment;
        }
        h hVar = this.f1707s;
        if (hVar == null || (str = this.f1697i) == null) {
            return null;
        }
        return (Fragment) hVar.f1789h.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J0() {
        this.F = false;
        h0();
        this.Q = null;
        if (this.F) {
            if (this.f1709u.D0()) {
                return;
            }
            this.f1709u.B();
            this.f1709u = new h();
            return;
        }
        throw new q("Fragment " + this + " did not call through to super.onDetach()");
    }

    public View K() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater K0(Bundle bundle) {
        LayoutInflater i02 = i0(bundle);
        this.Q = i02;
        return i02;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L0() {
        onLowMemory();
        this.f1709u.D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M() {
        L();
        this.f1694f = UUID.randomUUID().toString();
        this.f1700l = false;
        this.f1701m = false;
        this.f1702n = false;
        this.f1703o = false;
        this.f1704p = false;
        this.f1706r = 0;
        this.f1707s = null;
        this.f1709u = new h();
        this.f1708t = null;
        this.f1711w = 0;
        this.f1712x = 0;
        this.f1713y = null;
        this.f1714z = false;
        this.A = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M0(boolean z5) {
        m0(z5);
        this.f1709u.E(z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean N0(MenuItem menuItem) {
        if (this.f1714z) {
            return false;
        }
        return (this.D && this.E && n0(menuItem)) || this.f1709u.T(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O() {
        d dVar = this.L;
        if (dVar == null) {
            return false;
        }
        return dVar.f1735q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(Menu menu) {
        if (this.f1714z) {
            return;
        }
        if (this.D && this.E) {
            o0(menu);
        }
        this.f1709u.U(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean P() {
        return this.f1706r > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P0() {
        this.f1709u.W();
        if (this.H != null) {
            this.U.c(c.a.ON_PAUSE);
        }
        this.T.i(c.a.ON_PAUSE);
        this.f1690b = 3;
        this.F = false;
        p0();
        if (this.F) {
            return;
        }
        throw new q("Fragment " + this + " did not call through to super.onPause()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Q() {
        d dVar = this.L;
        if (dVar == null) {
            return false;
        }
        return dVar.f1733o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q0(boolean z5) {
        q0(z5);
        this.f1709u.X(z5);
    }

    public final boolean R() {
        h hVar = this.f1707s;
        if (hVar == null) {
            return false;
        }
        return hVar.H0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean R0(Menu menu) {
        boolean z5 = false;
        if (this.f1714z) {
            return false;
        }
        if (this.D && this.E) {
            r0(menu);
            z5 = true;
        }
        return z5 | this.f1709u.Y(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        this.f1709u.S0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S0() {
        boolean F0 = this.f1707s.F0(this);
        Boolean bool = this.f1699k;
        if (bool == null || bool.booleanValue() != F0) {
            this.f1699k = Boolean.valueOf(F0);
            s0(F0);
            this.f1709u.Z();
        }
    }

    public void T(Bundle bundle) {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T0() {
        this.f1709u.S0();
        this.f1709u.j0();
        this.f1690b = 4;
        this.F = false;
        u0();
        if (!this.F) {
            throw new q("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.g gVar = this.T;
        c.a aVar = c.a.ON_RESUME;
        gVar.i(aVar);
        if (this.H != null) {
            this.U.c(aVar);
        }
        this.f1709u.a0();
        this.f1709u.j0();
    }

    public void U(int i6, int i7, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U0(Bundle bundle) {
        v0(bundle);
        this.W.d(bundle);
        Parcelable e12 = this.f1709u.e1();
        if (e12 != null) {
            bundle.putParcelable("android:support:fragments", e12);
        }
    }

    public void V(Activity activity) {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V0() {
        this.f1709u.S0();
        this.f1709u.j0();
        this.f1690b = 3;
        this.F = false;
        w0();
        if (!this.F) {
            throw new q("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.g gVar = this.T;
        c.a aVar = c.a.ON_START;
        gVar.i(aVar);
        if (this.H != null) {
            this.U.c(aVar);
        }
        this.f1709u.b0();
    }

    public void W(Context context) {
        this.F = true;
        androidx.fragment.app.f fVar = this.f1708t;
        Activity f6 = fVar == null ? null : fVar.f();
        if (f6 != null) {
            this.F = false;
            V(f6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W0() {
        this.f1709u.d0();
        if (this.H != null) {
            this.U.c(c.a.ON_STOP);
        }
        this.T.i(c.a.ON_STOP);
        this.f1690b = 2;
        this.F = false;
        x0();
        if (this.F) {
            return;
        }
        throw new q("Fragment " + this + " did not call through to super.onStop()");
    }

    public void X(Fragment fragment) {
    }

    public final FragmentActivity X0() {
        FragmentActivity i6 = i();
        if (i6 != null) {
            return i6;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public boolean Y(MenuItem menuItem) {
        return false;
    }

    public final Context Y0() {
        Context p5 = p();
        if (p5 != null) {
            return p5;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public void Z(Bundle bundle) {
        this.F = true;
        b1(bundle);
        if (this.f1709u.G0(1)) {
            return;
        }
        this.f1709u.z();
    }

    public final g Z0() {
        g u5 = u();
        if (u5 != null) {
            return u5;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public Animation a0(int i6, boolean z5, int i7) {
        return null;
    }

    public final View a1() {
        View K = K();
        if (K != null) {
            return K;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry b() {
        return this.W.b();
    }

    public Animator b0(int i6, boolean z5, int i7) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.f1709u.c1(parcelable);
        this.f1709u.z();
    }

    void c() {
        d dVar = this.L;
        f fVar = null;
        if (dVar != null) {
            dVar.f1733o = false;
            f fVar2 = dVar.f1734p;
            dVar.f1734p = null;
            fVar = fVar2;
        }
        if (fVar != null) {
            fVar.a();
        }
    }

    public void c0(Menu menu, MenuInflater menuInflater) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f1692d;
        if (sparseArray != null) {
            this.I.restoreHierarchyState(sparseArray);
            this.f1692d = null;
        }
        this.F = false;
        z0(bundle);
        if (this.F) {
            if (this.H != null) {
                this.U.c(c.a.ON_CREATE);
                return;
            }
            return;
        }
        throw new q("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f1711w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f1712x));
        printWriter.print(" mTag=");
        printWriter.println(this.f1713y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f1690b);
        printWriter.print(" mWho=");
        printWriter.print(this.f1694f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f1706r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f1700l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f1701m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f1702n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f1703o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f1714z);
        printWriter.print(" mDetached=");
        printWriter.print(this.A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.B);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.K);
        if (this.f1707s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f1707s);
        }
        if (this.f1708t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f1708t);
        }
        if (this.f1710v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f1710v);
        }
        if (this.f1695g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f1695g);
        }
        if (this.f1691c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f1691c);
        }
        if (this.f1692d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f1692d);
        }
        Fragment J = J();
        if (J != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(J);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f1698j);
        }
        if (x() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(x());
        }
        if (this.G != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.G);
        }
        if (this.H != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.H);
        }
        if (this.I != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.H);
        }
        if (l() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(l());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(H());
        }
        if (p() != null) {
            androidx.loader.app.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f1709u + ":");
        h hVar = this.f1709u;
        hVar.b(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public View d0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i6 = this.X;
        if (i6 != 0) {
            return layoutInflater.inflate(i6, viewGroup, false);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d1(View view) {
        e().f1719a = view;
    }

    public void e0() {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e1(Animator animator) {
        e().f1720b = animator;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment f(String str) {
        return str.equals(this.f1694f) ? this : this.f1709u.q0(str);
    }

    public void f0() {
    }

    public void f1(Bundle bundle) {
        if (this.f1707s != null && R()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f1695g = bundle;
    }

    @Override // androidx.lifecycle.p
    public androidx.lifecycle.o g() {
        h hVar = this.f1707s;
        if (hVar != null) {
            return hVar.A0(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void g0() {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g1(boolean z5) {
        e().f1735q = z5;
    }

    @Override // androidx.lifecycle.f
    public androidx.lifecycle.c h() {
        return this.T;
    }

    public void h0() {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h1(int i6) {
        if (this.L == null && i6 == 0) {
            return;
        }
        e().f1722d = i6;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final FragmentActivity i() {
        androidx.fragment.app.f fVar = this.f1708t;
        if (fVar == null) {
            return null;
        }
        return (FragmentActivity) fVar.f();
    }

    public LayoutInflater i0(Bundle bundle) {
        return w(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i1(int i6, int i7) {
        if (this.L == null && i6 == 0 && i7 == 0) {
            return;
        }
        e();
        d dVar = this.L;
        dVar.f1723e = i6;
        dVar.f1724f = i7;
    }

    public boolean j() {
        Boolean bool;
        d dVar = this.L;
        if (dVar == null || (bool = dVar.f1732n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void j0(boolean z5) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j1(f fVar) {
        e();
        d dVar = this.L;
        f fVar2 = dVar.f1734p;
        if (fVar == fVar2) {
            return;
        }
        if (fVar != null && fVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (dVar.f1733o) {
            dVar.f1734p = fVar;
        }
        if (fVar != null) {
            fVar.b();
        }
    }

    public boolean k() {
        Boolean bool;
        d dVar = this.L;
        if (dVar == null || (bool = dVar.f1731m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void k0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k1(int i6) {
        e().f1721c = i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View l() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        return dVar.f1719a;
    }

    public void l0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
        androidx.fragment.app.f fVar = this.f1708t;
        Activity f6 = fVar == null ? null : fVar.f();
        if (f6 != null) {
            this.F = false;
            k0(f6, attributeSet, bundle);
        }
    }

    public void l1() {
        h hVar = this.f1707s;
        if (hVar == null || hVar.f1799r == null) {
            e().f1733o = false;
        } else if (Looper.myLooper() != this.f1707s.f1799r.j().getLooper()) {
            this.f1707s.f1799r.j().postAtFrontOfQueue(new b());
        } else {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animator m() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        return dVar.f1720b;
    }

    public void m0(boolean z5) {
    }

    public final Bundle n() {
        return this.f1695g;
    }

    public boolean n0(MenuItem menuItem) {
        return false;
    }

    public final g o() {
        if (this.f1708t != null) {
            return this.f1709u;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public void o0(Menu menu) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.F = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        X0().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.F = true;
    }

    public Context p() {
        androidx.fragment.app.f fVar = this.f1708t;
        if (fVar == null) {
            return null;
        }
        return fVar.i();
    }

    public void p0() {
        this.F = true;
    }

    public Object q() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        return dVar.f1725g;
    }

    public void q0(boolean z5) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t.k r() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        dVar.getClass();
        return null;
    }

    public void r0(Menu menu) {
    }

    public Object s() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        return dVar.f1727i;
    }

    public void s0(boolean z5) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t.k t() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        dVar.getClass();
        return null;
    }

    public void t0(int i6, String[] strArr, int[] iArr) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        d0.b.a(this, sb);
        sb.append(" (");
        sb.append(this.f1694f);
        sb.append(")");
        if (this.f1711w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1711w));
        }
        if (this.f1713y != null) {
            sb.append(" ");
            sb.append(this.f1713y);
        }
        sb.append('}');
        return sb.toString();
    }

    public final g u() {
        return this.f1707s;
    }

    public void u0() {
        this.F = true;
    }

    public final Object v() {
        androidx.fragment.app.f fVar = this.f1708t;
        if (fVar == null) {
            return null;
        }
        return fVar.m();
    }

    public void v0(Bundle bundle) {
    }

    public LayoutInflater w(Bundle bundle) {
        androidx.fragment.app.f fVar = this.f1708t;
        if (fVar != null) {
            LayoutInflater n5 = fVar.n();
            e0.f.a(n5, this.f1709u.y0());
            return n5;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void w0() {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x() {
        d dVar = this.L;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1722d;
    }

    public void x0() {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int y() {
        d dVar = this.L;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1723e;
    }

    public void y0(View view, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int z() {
        d dVar = this.L;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1724f;
    }

    public void z0(Bundle bundle) {
        this.F = true;
    }
}
